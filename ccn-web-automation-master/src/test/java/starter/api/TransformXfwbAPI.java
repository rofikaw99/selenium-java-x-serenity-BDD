package starter.api;

import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.junit.Assert;
import starter.utlis.ApiProperties;
import starter.utlis.onerecord.XFWBRequest;
import starter.utlis.onerecord.XFWBResponse;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.*;

public class TransformXfwbAPI {
    String response, url, accessToken;
    RequestSpecification requestSpecification;

    public void setupApi(String typeUrl) throws IOException {
//        accessToken = FileUtils.readFileToString(new File("src/test/java/starter/utlis/tokenOneRecord.json"), StandardCharsets.UTF_8);
        requestSpecification = given()
                .headers("Content-Type", "application/xml");

        if (typeUrl.equals("internal")){
            url = ApiProperties.internalUrl() +"/service/" + ApiProperties.serviceId() + "/OneRecord/1/transformXFWB3";
            requestSpecification.headers("x-api-key", ApiProperties.apiKey());
        } else if (typeUrl.equals("external")){
            url = ApiProperties.baseUrl() + "/transformXFWB3";
        }
    }
    public String transformXfwb(String payload, String typeUrl) throws IOException {
        setupApi(typeUrl);
        response = requestSpecification
                .body(payload)
                .post(url)
                .then()
                .extract()
                .body()
                .asString();

        FileWriter file = new FileWriter("src/test/java/starter/utlis/onerecord/outputJson.json");
        file.write(response);
        file.close();
        if (typeUrl.equals("internal")) then().statusCode(200);
        else if (typeUrl.equals("external")) then().statusCode(201);
        return response;
    }

    public void verifyShippingRefNo(JSONObject jsonXml, JSONObject jsonObject) {
        Assert.assertEquals(XFWBRequest.BHD_SenderAssignedID(jsonXml), XFWBResponse.shippingRefNo(jsonObject));
    }
    public void verifyWaybillPrefix(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(List.of(XFWBRequest.BHD_ID(jsonXml).split("-")).get(0), XFWBResponse.waybillPrefix(jsonObject));
    }
    public void verifyWaybillNumber(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(List.of(XFWBRequest.BHD_ID(jsonXml).split("-")).get(1), XFWBResponse.waybillNumber(jsonObject));
    }
    public void verifyNilCarriageValueIndicator(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.NilCarriageValueIndicator(jsonXml), XFWBResponse.declaredValueForCarriage(jsonObject));
    }
    public void verifyNilCustomsValueIndicator(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.NilCustomsValueIndicator(jsonXml), XFWBResponse.declaredValueForCustoms(jsonObject));
    }
    public void verifyDeclaredValueForCarriageAmount(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.DeclaredValueForCarriageAmount(jsonXml), XFWBResponse.declaredValueForCarriage(jsonObject));
    }
    public void verifyDeclaredValueForCustomsAmount(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.DeclaredValueForCustomsAmount(jsonXml), XFWBResponse.declaredValueForCustoms(jsonObject));
    }
    public void verifyNilInsuranceValueIndicator(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.NilInsuranceValueIndicator(jsonXml), XFWBResponse.insuredAmount(jsonObject));
    }
    public void verifyInsuranceValueAmount(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.InsuranceValueAmount(jsonXml), XFWBResponse.insuredAmount(jsonObject));
    }
    public void verifyWaybillType(JSONObject jsonXml, JSONObject jsonObject){
        String expected = XFWBRequest.IHN_ContentCode(jsonXml);
        if (expected.equals("D")) expected = "DIRECT";
        else if (expected.equals("C")) expected = "MASTER";
        Assert.assertEquals(expected, XFWBResponse.waybillType(jsonObject));
    }
    public void verifyConsignorDeclarationSignature(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SCoA_Signatory(jsonXml), XFWBResponse.consignorDeclarationSignature(jsonObject));
    }
    public void verifyCarrierDeclarationDate(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.BHD_SCaA_ActualDateTime(jsonXml), XFWBResponse.carrierDeclarationDate(jsonObject));
    }
    public void verifyCarrierDeclarationSignature(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.BHD_SCaA_Signatory(jsonXml), XFWBResponse.carrierDeclarationSignature(jsonObject));
    }
    public void verifyCarrierDeclarationPlace(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.IAL_Name(jsonXml), XFWBResponse.carrierDeclarationPlace(jsonObject));
    }
    public void verifyWeightValuationIndicator(JSONObject jsonXml, JSONObject jsonObject){
        Boolean expected = XFWBRequest.TotalChargePrepaidIndicator(jsonXml);
        String convertExpected;
        if (expected) convertExpected = "P";
        else convertExpected = "C";
        Assert.assertEquals(convertExpected, XFWBResponse.weightValuationIndicator(jsonObject));
    }
    public void verifyOtherChargesIndicator(JSONObject jsonXml, JSONObject jsonObject){
        Boolean expected = XFWBRequest.TotalDisbursementPrepaidIndicator(jsonXml);
        String convertExpected;
        if (expected) convertExpected = "P";
        else convertExpected = "C";
        Assert.assertEquals(convertExpected, XFWBResponse.otherChargesIndicator(jsonObject));
    }
    public void verifyTotalGrossWeight(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.IncludedTareGrossWeightMeasure(jsonXml).get("content"), XFWBResponse.numericalValueOfGrossWeight(jsonObject));
    }
    public void verifyUnitTotalGrossWeight(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.IncludedTareGrossWeightMeasure(jsonXml).get("unitCode"), XFWBResponse.unitTotalGrossWeight(jsonObject));
    }
    public void verifyDimensionsForRate(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.GrossVolumeMeasure(jsonXml).get("content"), XFWBResponse.numericalValueDimensionsForRate(jsonObject));
    }
    public void verifyUnitDimensionsForRate(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.GrossVolumeMeasure(jsonXml).get("unitCode"), XFWBResponse.unitDimensionsForRate(jsonObject));
    }
    public void verifyPieceCountForRate(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.TotalPieceQuantity(jsonXml), XFWBResponse.pieceCountForRate(jsonObject));
    }
    public void verifyPackageQuantity(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.PackageQuantity(jsonXml), XFWBResponse.slacForRate(jsonObject));
    }
    public void verifyProductID(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ProductID(jsonXml), XFWBResponse.productCode(jsonObject));
    }
    public void verifyNameConsignorParty(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFWBRequest.CoP_Name(jsonXml), XFWBResponse.PD_Name(jsonObject, party));
    }
    public void verifyConsignorPartyAccID(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(String.valueOf(XFWBRequest.CoP_AccountID(jsonXml)), XFWBResponse.PD_OtherIdentifiers(jsonObject, party));
    }
    public void verifyConsignorPostalCode(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(String.valueOf(XFWBRequest.CoP_PSA_PostcodeCode(jsonXml)), XFWBResponse.PD_BAL_A_postalCode(jsonObject, party));
    }
    public void verifyConsignorStreetAddressLines(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFWBRequest.CoP_PSA_StreetName(jsonXml), XFWBResponse.PD_BAL_streetAddressLines(jsonObject, party));
    }
    public void verifyConsignorCityName(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFWBRequest.CoP_PSA_CityName(jsonXml), XFWBResponse.PD_BAL_A_cityName(jsonObject, party));
    }
    public void verifyConsignorCountryCode(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CoP_PSA_CountryID(jsonXml), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyConsignorCountry(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CoP_PSA_CountryName(jsonXml), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyConsignorRegionName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CoP_PSA_CountrySubDivisionName(jsonXml), XFWBResponse.PD_BAL_regionName(jsonObject, party));
    }
    public void verifyConsignorPostOfficeBox(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFWBRequest.CoP_PSA_PostOfficeBox(jsonXml)), XFWBResponse.PD_BAL_A_postOfficeBox(jsonObject, party));
    }
    public void verifyConsignorCityID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CoP_PSA_CityID(jsonXml), XFWBResponse.PD_BAL_A_cityCode(jsonObject, party));
    }
    public void verifyConsignorCountrySubDivisionID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CoP_PSA_CountrySubDivisionID(jsonXml), XFWBResponse.PD_BAL_regionCode(jsonObject, party));
    }
    public void verifyConsignorPersonName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CoP_DTC_PersonName(jsonXml), XFWBResponse.PD_BAL_firstName(jsonObject, party));
    }
    public void verifyConsigneePersonName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CeP_DTC_PersonName(jsonXml), XFWBResponse.PD_BAL_firstName(jsonObject, party));
    }
    public void verifyFFPPersonName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_DTC_PersonName(jsonXml), XFWBResponse.PD_BAL_firstName(jsonObject, party));
    }
    public void verifyAssociatedPartyPersonName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.AP_DTC_PersonName(jsonXml), XFWBResponse.PD_BAL_firstName(jsonObject, party));
    }
    public void verifyConsignorDepartmentName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CoP_DTC_DepartmentName(jsonXml), XFWBResponse.PD_BAL_department(jsonObject, party));
    }
    public void verifyConsigneeDepartmentName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CeP_DTC_DepartmentName(jsonXml), XFWBResponse.PD_BAL_department(jsonObject, party));
    }
    public void verifyFFPDepartmentName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_DTC_DepartmentName(jsonXml), XFWBResponse.PD_BAL_department(jsonObject, party));
    }
    public void verifyAssociatedPartyDepartmentName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.AP_DTC_DepartmentName(jsonXml), XFWBResponse.PD_BAL_department(jsonObject, party));
    }
    public void verifyConsignorDirectTelephoneCommunication(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CoP_DTC_DirectTelephoneCommunication(jsonXml), XFWBResponse.PD_BAL_textualValue(jsonObject, party));
    }
    public void verifyConsigneeDirectTelephoneCommunication(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CeP_DTC_DirectTelephoneCommunication(jsonXml), XFWBResponse.PD_BAL_textualValue(jsonObject, party));
    }
    public void verifyFFPDirectTelephoneCommunication(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_DTC_DirectTelephoneCommunication(jsonXml), XFWBResponse.PD_BAL_textualValue(jsonObject, party));
    }
    public void verifyAssociatedPartyDirectTelephoneCommunication(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.AP_DTC_DirectTelephoneCommunication(jsonXml), XFWBResponse.PD_BAL_textualValue(jsonObject, party));
    }
    public void verifyConsignorFaxCommunication(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CoP_DTC_FaxCommunication(jsonXml), XFWBResponse.PD_BAL_textualValue(jsonObject, party));
    }
    public void verifyConsigneeFaxCommunication(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CeP_DTC_FaxCommunication(jsonXml), XFWBResponse.PD_BAL_textualValue(jsonObject, party));
    }
    public void verifyFFPFaxCommunication(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_DTC_FaxCommunication(jsonXml), XFWBResponse.PD_BAL_textualValue(jsonObject, party));
    }
    public void verifyAssociatedPartyFaxCommunication(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.AP_DTC_FaxCommunication(jsonXml), XFWBResponse.PD_BAL_textualValue(jsonObject, party));
    }
    public void verifyConsignorURIEmailCommunication(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CoP_DTC_URIEmailCommunication(jsonXml), XFWBResponse.PD_BAL_textualValue(jsonObject, party));
    }
    public void verifyConsigneeURIEmailCommunication(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CeP_DTC_URIEmailCommunication(jsonXml), XFWBResponse.PD_BAL_textualValue(jsonObject, party));
    }
    public void verifyFFPURIEmailCommunication(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_DTC_URIEmailCommunication(jsonXml), XFWBResponse.PD_BAL_textualValue(jsonObject, party));
    }
    public void verifyAssociatedPartyURIEmailCommunication(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.AP_DTC_URIEmailCommunication(jsonXml), XFWBResponse.PD_BAL_textualValue(jsonObject, party));
    }
    public void verifyConsignorTelexCommunication(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CoP_DTC_TelexCommunication(jsonXml), XFWBResponse.PD_BAL_textualValue(jsonObject, party));
    }
    public void verifyConsigneeTelexCommunication(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CeP_DTC_TelexCommunication(jsonXml), XFWBResponse.PD_BAL_textualValue(jsonObject, party));
    }
    public void verifyFFPTelexCommunication(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_DTC_TelexCommunication(jsonXml), XFWBResponse.PD_BAL_textualValue(jsonObject, party));
    }
    public void verifyAssociatedPartyTelexCommunication(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.AP_DTC_TelexCommunication(jsonXml), XFWBResponse.PD_BAL_textualValue(jsonObject, party));
    }
    public void verifyNameConsigneeParty(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFWBRequest.CeP_Name(jsonXml), XFWBResponse.PD_Name(jsonObject, party));
    }
    public void verifyConsigneePostalCode(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(String.valueOf(XFWBRequest.CeP_PSA_PostcodeCode(jsonXml)), XFWBResponse.PD_BAL_A_postalCode(jsonObject, party));
    }
    public void verifyConsigneeStreetAddressLines(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFWBRequest.CeP_PSA_StreetName(jsonXml), XFWBResponse.PD_BAL_streetAddressLines(jsonObject, party));
    }
    public void verifyConsigneeAccountID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFWBRequest.CeP_AccountID(jsonXml)), XFWBResponse.PD_OtherIdentifiers(jsonObject, party));
    }
    public void verifyConsigneeCityName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFWBRequest.CeP_PSA_CityName(jsonXml)), XFWBResponse.PD_BAL_A_cityName(jsonObject, party));
    }
    public void verifyConsigneeCountryID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFWBRequest.CeP_PSA_CountryID(jsonXml)), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyConsigneeCountryName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFWBRequest.CeP_PSA_CountryName(jsonXml)), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyConsigneeCountrySubDivisionName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFWBRequest.CeP_PSA_CountrySubDivisionName(jsonXml)), XFWBResponse.PD_BAL_regionName(jsonObject, party));
    }
    public void verifyConsigneePostOfficeBox(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFWBRequest.CeP_PSA_PostOfficeBox(jsonXml)), XFWBResponse.PD_BAL_A_postOfficeBox(jsonObject, party));
    }
    public void verifyConsigneeCityID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFWBRequest.CeP_PSA_CityID(jsonXml)), XFWBResponse.PD_BAL_A_cityCode(jsonObject, party));
    }
    public void verifyConsigneeCountrySubDivisionID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFWBRequest.CeP_PSA_CountrySubDivisionID(jsonXml)), XFWBResponse.PD_BAL_regionCode(jsonObject, party));
    }
    public void verifyNameFreightForwarderParty(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFWBRequest.FFP_Name(jsonXml), XFWBResponse.PD_Name(jsonObject, party));
    }
    public void verifyFreightForwarderCargoAgentId(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_CargoAgentID(jsonXml), XFWBResponse.PD_IataCargoAgentCode(jsonObject, party));
    }
    public void verifyFreightForwarderAccountID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFWBRequest.FFP_AccountID(jsonXml)), XFWBResponse.PD_OtherIdentifiers(jsonObject, party));
    }
    public void verifyFreightForwarderPostcodeCode(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFWBRequest.FFP_FFA_PostcodeCode(jsonXml)), XFWBResponse.PD_BAL_A_postalCode(jsonObject, party));
    }
    public void verifyFreightForwarderStreetName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_FFA_StreetName(jsonXml), XFWBResponse.PD_BAL_streetAddressLines(jsonObject, party));
    }
    public void verifyFreightForwarderCityName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_FFA_CityName(jsonXml), XFWBResponse.PD_BAL_A_cityName(jsonObject, party));
    }
    public void verifyFreightForwarderCountryID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_FFA_CountryID(jsonXml), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyFreightForwarderCountryName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_FFA_CountryName(jsonXml), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyFreightForwarderCountrySubDivisionName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_FFA_CountrySubDivisionName(jsonXml), XFWBResponse.PD_BAL_regionName(jsonObject, party));
    }
    public void verifyFreightForwarderPostOfficeBox(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFWBRequest.FFP_FFA_PostOfficeBox(jsonXml)), XFWBResponse.PD_BAL_A_postOfficeBox(jsonObject, party));
    }
    public void verifyFreightForwarderCityID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_FFA_CityID(jsonXml), XFWBResponse.PD_BAL_A_cityCode(jsonObject, party));
    }
    public void verifyFreightForwarderCountrySubDivisionID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_FFA_CountrySubDivisionID(jsonXml), XFWBResponse.PD_BAL_regionCode(jsonObject, party));
    }
    public void verifyFreightForwarderSpecifiedCargoAgentLocationId(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_SpecifiedCargoAgentLocation_ID(jsonXml), XFWBResponse.PD_IataCargoAgentLocationIdentifier(jsonObject, party));
    }
    public void verifyAssociatedPartyName(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFWBRequest.AP_Name(jsonXml), XFWBResponse.PD_Name(jsonObject, party));
    }
    public void verifyAssociatedPartyPostcodeCode(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFWBRequest.AP_PSA_PostcodeCode(jsonXml)), XFWBResponse.PD_BAL_A_postalCode(jsonObject, party));
    }
    public void verifyAssociatedPartyStreetName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.AP_PSA_StreetName(jsonXml), XFWBResponse.PD_BAL_streetAddressLines(jsonObject, party));
    }
    public void verifyAssociatedPartyCityName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.AP_PSA_CityName(jsonXml), XFWBResponse.PD_BAL_A_cityName(jsonObject, party));
    }
    public void verifyAssociatedPartyCountryID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.AP_PSA_CountryID(jsonXml), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyAssociatedPartyCountryName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.AP_PSA_CountryName(jsonXml), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyAssociatedPartyCountrySubDivisionName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.AP_PSA_CountrySubDivisionName(jsonXml), XFWBResponse.PD_BAL_regionName(jsonObject, party));
    }
    public void verifyAssociatedPartyPostOfficeBox(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFWBRequest.AP_PSA_PostOfficeBox(jsonXml)), XFWBResponse.PD_BAL_A_postOfficeBox(jsonObject, party));
    }
    public void verifyAssociatedPartyCityID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.AP_PSA_CityID(jsonXml), XFWBResponse.PD_BAL_A_cityCode(jsonObject, party));
    }
    public void verifyAssociatedPartyCountrySubDivisionID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.AP_PSA_CountrySubDivisionID(jsonXml), XFWBResponse.PD_BAL_regionCode(jsonObject, party));
    }
    public void verifyOriginLocationId(JSONObject jsonXml, JSONObject jsonObject) {
        Assert.assertEquals(XFWBRequest.OL_ID(jsonXml), XFWBResponse.DL_LocationCodes_Code(jsonObject));
    }
    public void verifyOriginLocationName(JSONObject jsonXml, JSONObject jsonObject) {
        Assert.assertEquals(XFWBRequest.OL_Name(jsonXml), XFWBResponse.DL_LocationName(jsonObject));
    }
    public void verifyFinalDestinationLocationId(JSONObject jsonXml, JSONObject jsonObject) {
        Assert.assertEquals(XFWBRequest.FDL_ID(jsonXml), XFWBResponse.AL_LocationCodes_Code(jsonObject));
    }
    public void verifyFinalDestinationLocationName(JSONObject jsonXml, JSONObject jsonObject) {
        Assert.assertEquals(XFWBRequest.FDL_Name(jsonXml), XFWBResponse.AL_LocationName(jsonObject));
    }
    public void verifySpecifiedLogisticsTransportMovementID(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_ID(jsonXml), XFWBResponse.SA_TransportIdentifier(jsonObject));
    }
    public void verifySpecifiedLogisticsTransportMovementStageCode(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_StageCode(jsonXml), XFWBResponse.SA_ModeQualifier(jsonObject));
    }
    public void verifySpecifiedLogisticsTransportMovementModeCode(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_ModeCode(jsonXml), XFWBResponse.SA_ModeCode(jsonObject));
    }
    public void verifyUsedLogisticsTransportMeans(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_UsedLogisticsTransportMeans_Name(jsonXml), XFWBResponse.SA_OperatingTransportMeans_TransportOrganization_AirlineCode(jsonObject));
    }
    public void verifyScheduledOccurrenceDateTime(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_AE_ScheduledOccurrenceDateTime(jsonXml), XFWBResponse.SA_MovementTimes_MovementTimestamp(jsonObject));
    }
    public void verifyDepartureScheduledOccurrenceDateTime(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_DE_ScheduledOccurrenceDateTime(jsonXml), XFWBResponse.SA_MovementTimes_MovementTimestamp(jsonObject));
    }
    public void verifyOccurrenceArrivalLocationID(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_AE_OAL_ID(jsonXml), XFWBResponse.SA_AL_LocationCodes_Code(jsonObject));
    }
    public void verifyOccurrenceDepartureLocationName(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_DE_ODL_Name(jsonXml), XFWBResponse.SA_DL_LocationName(jsonObject));
    }
    public void verifyOccurrenceDepartureTypeCode(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_DE_ODL_TypeCode(jsonXml), XFWBResponse.SA_DL_LocationType(jsonObject));
    }
    public void verifyOccurrenceDepartureLocationID(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_DE_ODL_ID(jsonXml), XFWBResponse.SA_DL_LocationCodes_Code(jsonObject));
    }
    public void verifyOccurrenceArrivalLocationName(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_AE_OAL_Name(jsonXml), XFWBResponse.SA_AL_LocationName(jsonObject));
    }
    public void verifyOccurrenceArrivalTypeCode(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_AE_OAL_TypeCode(jsonXml), XFWBResponse.SA_AL_LocationType(jsonObject));
    }
    public void verifyUtilizedLogisticsTransportEquipmentID(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(String.valueOf(XFWBRequest.ULTE_ID(jsonXml)), XFWBResponse.SA_OTM_VehicleRegistration(jsonObject));
    }
    public void verifyUtilizedLogisticsTransportEquipmentCharacteristicCode(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ULTE_CharacteristicCode(jsonXml), XFWBResponse.SA_OTM_VehicleType(jsonObject));
    }
    public void verifyUtilizedLogisticsTransportEquipmentCharacteristic(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(String.valueOf(XFWBRequest.ULTE_Characteristic(jsonXml)), XFWBResponse.SA_OTM_VehicleSize(jsonObject));
    }
    public void verifyUtilizedLogisticsTransportEquipmentAffixedLogisticsSeal(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(String.valueOf(XFWBRequest.ULTE_AffixedLogisticsSeal_ID(jsonXml)), XFWBResponse.SA_Seal(jsonObject));
    }
    public void verifySpecialHandlingCodes(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.HandlingSPHInstructions(jsonXml), XFWBResponse.SpecialHandlingCodes(jsonObject));
    }
    public void verifyTextualHandlingInstructionsDescription(JSONObject jsonXml, String type, JSONObject jsonObject){
        Assert.assertTrue(XFWBResponse.TextualHandlingInstructions(jsonObject).containsAll(XFWBRequest.HSSRI_Description(type, jsonXml)));
    }
    public void verifyOSITextualHandlingInstructionsDescription(JSONObject jsonXml, String type, JSONObject jsonObject){
        Assert.assertTrue(XFWBResponse.TextualHandlingInstructions(jsonObject).containsAll(XFWBRequest.OSI_Description(type, jsonXml)));
    }
    public void verifyAccountingInformation(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.IncludedAccountingNote(jsonXml), XFWBResponse.AccountingInformation(jsonObject));
    }
    public void verifyCustomsInformationContentCode(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ICN_ContentCode(jsonXml), XFWBResponse.CI_ContentCode(jsonObject));
    }
    public void verifyCustomsInformationContent(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ICN_Content(jsonXml), XFWBResponse.CI_Note(jsonObject));
    }
    public void verifyCustomsInformationSubjectCode(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ICN_SubjectCode(jsonXml), XFWBResponse.CI_SubjectCode(jsonObject));
    }
    public void verifyCustomsInformationCountryID(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ICN_CountryID(jsonXml), XFWBResponse.CI_Country(jsonObject));
    }
    public void verifyAssociatedReferenceDocumentID(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(String.valueOf(XFWBRequest.ARD_ID(jsonXml)), XFWBResponse.ER_DocumentIdentifier(jsonObject));
    }
    public void verifyAssociatedReferenceDocumentIssueDateTime(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ARD_IssueDateTime(jsonXml), XFWBResponse.ER_ValidFrom(jsonObject));
        Assert.assertEquals(XFWBRequest.ARD_IssueDateTime(jsonXml), XFWBResponse.ER_ValidUntil(jsonObject));
    }
    public void verifyAssociatedReferenceDocumentTypeCode(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(String.valueOf(XFWBRequest.ARD_TypeCode(jsonXml)), XFWBResponse.ER_DocumentType(jsonObject));
    }
    public void verifyAssociatedReferenceDocumentName(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ARD_Name(jsonXml), XFWBResponse.ER_DocumentName(jsonObject));
    }
    public void verifyApplicableOriginCurrencyExchangeSourceCurrencyCode(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(String.valueOf(XFWBRequest.ApplicableOriginCurrencyExchange_SourceCurrencyCode(jsonXml)), XFWBResponse.OriginCurrency(jsonObject));
    }
    public void verifyOtherChargesOtherChargeAmount(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ALLC_ActualAmount(jsonXml), XFWBResponse.OC_OtherChargeAmount(jsonObject));
    }
    public void verifyOtherChargesOtherChargeCode(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ALLC_ID(jsonXml), XFWBResponse.OC_OtherChargeCode(jsonObject));
    }
    public void verifyOtherChargesChargePaymentType(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ALLC_PrepaidIndicator(jsonXml), XFWBResponse.OC_ChargePaymentType(jsonObject));
    }
    public void verifyOtherChargesEntitlement(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ALLC_PartyTypeCode(jsonXml), XFWBResponse.OC_Entitlement(jsonObject));
    }
    public void verifyIncludedMasterConsignmentItemGrossWeightForRate(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_GrossWeightMeasure(jsonXml), XFWBResponse.WaybillLineItems_GrossWeightForRate(jsonObject));
    }
    public void verifyIncludedMasterConsignmentItemGrossVolumeMeasure(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_GrossVolumeMeasure(jsonXml), XFWBResponse.WLI_DimensionsForRate_Volume(jsonObject));
    }
    public void verifyIncludedMasterConsignmentItemPieceQuantity(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_PieceQuantity(jsonXml), XFWBResponse.WaybillLineItems_PieceCountForRate(jsonObject));
    }
    public void verifyNatureIdentificationTransportCargoIdentification(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_NatureIdentificationTransportCargo_Identification(jsonXml), XFWBResponse.WaybillLineItems_GoodsDescriptionForRate(jsonObject));
    }
    public void verifyTransportLogisticsPackageItemQuantity(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_TLP_ItemQuantity(jsonXml), XFWBResponse.WaybillLineItems_PieceCountForRate(jsonObject));
    }
    public void verifyLinearSpatialDimensionWidthMeasure(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_TLP_LSD_WidthMeasure(jsonXml), XFWBResponse.WLI_DimensionsForRate_Width(jsonObject));
    }
    public void verifyLinearSpatialDimensionLengthMeasure(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_TLP_LSD_LengthMeasure(jsonXml), XFWBResponse.WLI_DimensionsForRate_Length(jsonObject));
    }
    public void verifyLinearSpatialDimensionHeightMeasure(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_TLP_LSD_HeightMeasure(jsonXml), XFWBResponse.WLI_DimensionsForRate_Height(jsonObject));
    }
    public void verifyApplicableFreightRateServiceChargeCategoryCode(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_AFRSC_CategoryCode(jsonXml), XFWBResponse.WLI_RateClassCode(jsonObject));
    }
    public void verifyApplicableFreightRateServiceChargeChargeableWeightMeasure(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_AFRSC_ChargeableWeightMeasure(jsonXml), XFWBResponse.WLI_ChargeableWeightForRate(jsonObject));
    }
    public void verifyApplicableFreightRateServiceChargeAppliedRate(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_AFRSC_AppliedRate(jsonXml), XFWBResponse.WLI_RateCharge(jsonObject));
    }
    public void verifyApplicableFreightRateServiceChargeAppliedAmount(JSONObject jsonXml, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_AFRSC_AppliedAmount(jsonXml), XFWBResponse.WLI_RateCharge(jsonObject));
    }

}
