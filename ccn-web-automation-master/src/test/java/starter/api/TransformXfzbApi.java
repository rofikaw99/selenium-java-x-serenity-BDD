package starter.api;

import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.junit.Assert;
import starter.utlis.ApiProperties;
import starter.utlis.onerecord.XFWBRequest;
import starter.utlis.onerecord.XFWBResponse;
import starter.utlis.onerecord.XFZBRequest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class TransformXfzbApi {

    private String url, response;
    private RequestSpecification requestSpecification;

    public void setupApi(String typeUrl) throws IOException {
        requestSpecification = given()
                .headers("Content-Type", "application/xml");

        if (typeUrl.equals("internal")){
            url = ApiProperties.internalUrl() +"/service/" + ApiProperties.serviceId() + "/OneRecord/1/transformXFZB3";
            requestSpecification.headers("x-api-key", ApiProperties.apiKey());
        } else if (typeUrl.equals("external")){
            url = ApiProperties.baseUrl() + "/transformXFZB3";
        }
    }

    public String transformXfzb(String payload, String typeUrl) throws IOException {
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

    public void verifyWaybillNumber(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.BHD_ID(request), XFWBResponse.waybillNumber(response));
    }

    public void verifyWaybillType(JSONObject request, JSONObject response){
        Assert.assertEquals("HOUSE", XFWBResponse.waybillType(response));
    }

    public void verifyConsignorDeclarationSignature(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.BHD_SCoA_Signatory(request), XFWBResponse.consignorDeclarationSignature(response));
    }

    public void verifyCarrierDeclarationDate(JSONObject request, JSONObject response){
        Assert.assertTrue(XFWBResponse.carrierDeclarationDate(response).contains(XFZBRequest.BHD_SCaA_ActualDateTime(request)));
    }

    public void verifyCarrierDeclarationSignature(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.BHD_SCaA_Signatory(request), XFWBResponse.carrierDeclarationSignature(response));
    }

    public void verifyCarrierDeclarationPlace(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.BHD_SCaA_IAL_Name(request), XFWBResponse.carrierDeclarationPlace(response));
    }

    public void verifyNilCarriageValueIndicator(JSONObject request, JSONObject response){
        if (XFZBRequest.MC_IHC_NilCarriageValueIndicator(request)) Assert.assertEquals(0, XFWBResponse.declaredValueForCarriage(response).get("content"));
    }

    public void verifyNilCustomsValueIndicator(JSONObject request, JSONObject response){
        if (XFZBRequest.MC_IHC_NilCustomsValueIndicator(request)) Assert.assertEquals(0, XFWBResponse.declaredValueForCustoms(response).get("content"));
    }

    public void verifyDeclaredValueForCarriage(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_DeclaredValueForCarriageAmount(request).get("content"), XFWBResponse.declaredValueForCarriage(response).get("content"));
        Assert.assertEquals(XFZBRequest.MC_IHC_DeclaredValueForCarriageAmount(request).get("currencyID"), XFWBResponse.declaredValueForCarriage(response).get("content"));
    }

    public void verifyDeclaredValueForCustoms(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_DeclaredValueForCustoms(request).get("content"), XFWBResponse.declaredValueForCustoms(response).get("content"));
        Assert.assertEquals(XFZBRequest.MC_IHC_DeclaredValueForCustoms(request).get("currencyID"), XFWBResponse.declaredValueForCustoms(response).get("currencyID"));
    }

    public void verifyNilInsuranceValueIndicator(JSONObject request, JSONObject response){
        if (XFZBRequest.MC_IHC_NilInsuranceValueIndicator(request)) Assert.assertEquals(0, XFWBResponse.insuredAmount(response).get("content"));
    }

    public void verifyInsuranceValueAmount(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_InsuranceValueAmount(request).get("content"), XFWBResponse.insuredAmount(response).get("content"));
        Assert.assertEquals(XFZBRequest.MC_IHC_InsuranceValueAmount(request).get("currencyID"), XFWBResponse.insuredAmount(response).get("currencyID"));
    }

    public void verifyWeightValuationIndicator(JSONObject request, JSONObject response){
        if (XFZBRequest.MC_IHC_TotalChargePrepaidIndicator(request)) Assert.assertEquals("P", XFWBResponse.weightValuationIndicator(response));
    }

    public void verifyOtherChargesIndicator(JSONObject request, JSONObject response){
        if (XFZBRequest.MC_IHC_TotalDisbursementPrepaidIndicator(request)) Assert.assertEquals("P", XFWBResponse.otherChargesIndicator(response));
    }

    public void verifyTotalGrossWeight(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_IncludedTareGrossWeightMeasure(request).get("content"), XFWBResponse.Master_TotalGrossWeight(response).get("content"));
        Assert.assertEquals(XFZBRequest.MC_IHC_IncludedTareGrossWeightMeasure(request).get("unitCode"), XFWBResponse.Master_TotalGrossWeight(response).get("unitCode"));
    }

    public void verifySlacForRate(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_PackageQuantity(request), XFWBResponse.slacForRate(response));
    }

    public void verifyGoodsDescriptionForRate(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_SummaryDescription(request), XFWBResponse.WaybillLineItems_GoodsDescriptionForRate(response));
    }

    public void verifyDepartureLocation(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_OL_ID(request), XFWBResponse.Master_DepartureLocation_Code(response));
    }

    public void verifyArrivalLocation(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_FDL_ID(request), XFWBResponse.Master_ArrivalLocation_Codes(response));
    }

    public void verifyPieceCountForRate(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_TotalPieceQuantity(request), XFWBResponse.Master_WLI_PieceCountForRate(response));
    }

    public void verifyMasterWaybillNumber(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_TCD_ID(request), XFWBResponse.Master_WaybillPrefix(response) + "-" + XFWBResponse.Master_WaybillNumber(response));
    }

    public void verifyNameConsignorParty(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFZBRequest.MC_IHC_CoP_Name(jsonXml), XFWBResponse.PD_Name(jsonObject, party));
    }
    public void verifyConsignorPostalCode(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(String.valueOf(XFZBRequest.MC_IHC_CoP_PSA_PostcodeCode(jsonXml)), XFWBResponse.PD_BAL_A_postalCode(jsonObject, party));
    }
    public void verifyConsignorStreetAddressLines(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFZBRequest.MC_IHC_CoP_PSA_StreetName(jsonXml), XFWBResponse.PD_BAL_streetAddressLines(jsonObject, party));
    }
    public void verifyConsignorCityName(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFZBRequest.MC_IHC_CoP_PSA_CityName(jsonXml), XFWBResponse.PD_BAL_A_cityName(jsonObject, party));
    }
    public void verifyConsignorCountryCode(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_CoP_PSA_CountryID(jsonXml), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyConsignorCountry(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_CoP_PSA_CountryID(jsonXml), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyConsignorRegionName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_CoP_PSA_CountrySubDivisionName(jsonXml), XFWBResponse.PD_BAL_regionName(jsonObject, party));
    }
    public void verifyConsignorPostOfficeBox(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFZBRequest.MC_IHC_CoP_PSA_PostOfficeBox(jsonXml)), XFWBResponse.PD_BAL_A_postOfficeBox(jsonObject, party));
    }
    public void verifyConsignorCityID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_CoP_PSA_CityID(jsonXml), XFWBResponse.PD_BAL_A_cityCode(jsonObject, party));
    }
    public void verifyConsignorCountrySubDivisionID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_CoP_PSA_CountrySubDivisionID(jsonXml), XFWBResponse.PD_BAL_regionCode(jsonObject, party));
    }

    public void verifyNameConsigneeParty(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFZBRequest.MC_IHC_CeP_Name(jsonXml), XFWBResponse.PD_Name(jsonObject, party));
    }
    public void verifyConsigneePostalCode(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(String.valueOf(XFZBRequest.MC_IHC_CeP_PSA_PostcodeCode(jsonXml)), XFWBResponse.PD_BAL_A_postalCode(jsonObject, party));
    }
    public void verifyConsigneeStreetAddressLines(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFZBRequest.MC_IHC_CeP_PSA_StreetName(jsonXml), XFWBResponse.PD_BAL_streetAddressLines(jsonObject, party));
    }
    public void verifyConsigneeCityName(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFZBRequest.MC_IHC_CeP_PSA_CityName(jsonXml), XFWBResponse.PD_BAL_A_cityName(jsonObject, party));
    }
    public void verifyConsigneeCountryCode(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_CeP_PSA_CountryID(jsonXml), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyConsigneeCountry(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_CeP_PSA_CountryID(jsonXml), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyConsigneeRegionName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_CeP_PSA_CountrySubDivisionName(jsonXml), XFWBResponse.PD_BAL_regionName(jsonObject, party));
    }
    public void verifyConsigneePostOfficeBox(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFZBRequest.MC_IHC_CeP_PSA_PostOfficeBox(jsonXml)), XFWBResponse.PD_BAL_A_postOfficeBox(jsonObject, party));
    }
    public void verifyConsigneeCityID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_CeP_PSA_CityID(jsonXml), XFWBResponse.PD_BAL_A_cityCode(jsonObject, party));
    }
    public void verifyConsigneeCountrySubDivisionID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_CeP_PSA_CountrySubDivisionID(jsonXml), XFWBResponse.PD_BAL_regionCode(jsonObject, party));
    }

    public void verifyNameFreightForwarderParty(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFZBRequest.MC_IHC_FFP_Name(jsonXml), XFWBResponse.PD_Name(jsonObject, party));
    }
    public void verifyFreightForwarderPostalCode(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(String.valueOf(XFZBRequest.MC_IHC_FFP_PSA_PostcodeCode(jsonXml)), XFWBResponse.PD_BAL_A_postalCode(jsonObject, party));
    }
    public void verifyFreightForwarderStreetAddressLines(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFZBRequest.MC_IHC_FFP_PSA_StreetName(jsonXml), XFWBResponse.PD_BAL_streetAddressLines(jsonObject, party));
    }
    public void verifyFreightForwarderCityName(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFZBRequest.MC_IHC_FFP_PSA_CityName(jsonXml), XFWBResponse.PD_BAL_A_cityName(jsonObject, party));
    }
    public void verifyFreightForwarderCountryCode(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_FFP_PSA_CountryID(jsonXml), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyFreightForwarderCountry(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_FFP_PSA_CountryID(jsonXml), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyFreightForwarderRegionName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_FFP_PSA_CountrySubDivisionName(jsonXml), XFWBResponse.PD_BAL_regionName(jsonObject, party));
    }
    public void verifyFreightForwarderPostOfficeBox(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFZBRequest.MC_IHC_FFP_PSA_PostOfficeBox(jsonXml)), XFWBResponse.PD_BAL_A_postOfficeBox(jsonObject, party));
    }
    public void verifyFreightForwarderCityID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_FFP_PSA_CityID(jsonXml), XFWBResponse.PD_BAL_A_cityCode(jsonObject, party));
    }
    public void verifyFreightForwarderCountrySubDivisionID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_FFP_PSA_CountrySubDivisionID(jsonXml), XFWBResponse.PD_BAL_regionCode(jsonObject, party));
    }

    public void verifyNameNotifyParty(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFZBRequest.MC_IHC_NP_Name(jsonXml), XFWBResponse.PD_Name(jsonObject, party));
    }
    public void verifyNotifyPartyPostalCode(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(String.valueOf(XFZBRequest.MC_IHC_NP_PSA_PostcodeCode(jsonXml)), XFWBResponse.PD_BAL_A_postalCode(jsonObject, party));
    }
    public void verifyNotifyPartyStreetAddressLines(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFZBRequest.MC_IHC_NP_PSA_StreetName(jsonXml), XFWBResponse.PD_BAL_streetAddressLines(jsonObject, party));
    }
    public void verifyNotifyPartyCityName(JSONObject jsonXml, JSONObject jsonObject, String party){
        Assert.assertEquals(XFZBRequest.MC_IHC_NP_PSA_CityName(jsonXml), XFWBResponse.PD_BAL_A_cityName(jsonObject, party));
    }
    public void verifyNotifyPartyCountryCode(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_NP_PSA_CountryID(jsonXml), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyNotifyPartyCountry(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_NP_PSA_CountryID(jsonXml), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyNotifyPartyRegionName(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_NP_PSA_CountrySubDivisionName(jsonXml), XFWBResponse.PD_BAL_regionName(jsonObject, party));
    }
    public void verifyNotifyPartyPostOfficeBox(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(String.valueOf(XFZBRequest.MC_IHC_NP_PSA_PostOfficeBox(jsonXml)), XFWBResponse.PD_BAL_A_postOfficeBox(jsonObject, party));
    }
    public void verifyNotifyPartyCityID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_NP_PSA_CityID(jsonXml), XFWBResponse.PD_BAL_A_cityCode(jsonObject, party));
    }
    public void verifyNotifyPartyCountrySubDivisionID(JSONObject jsonXml, JSONObject jsonObject, String party) {
        Assert.assertEquals(XFZBRequest.MC_IHC_NP_PSA_CountrySubDivisionID(jsonXml), XFWBResponse.PD_BAL_regionCode(jsonObject, party));
    }

    public void verifyOriginLocationID(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_OL_ID(request), XFWBResponse.DL_LocationCodes_Code(response));
    }
    public void verifyOriginLocationName(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_OL_Name(request), XFWBResponse.DL_LocationName(response));
    }

    public void verifyDestinationLocationID(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_FDL_ID(request), XFWBResponse.AL_LocationCodes_Code(response));
    }
    public void verifyDestinationLocationName(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_FDL_Name(request), XFWBResponse.AL_LocationName(response));
    }
}
