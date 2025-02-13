package starter.stepdefinitions.api;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.SkipStepException;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;
import org.json.XML;
import starter.api.TransformXfzbApi;
import starter.utlis.onerecord.XFZBXml;

import java.io.IOException;

public class TransformXFZB {
    @Steps
    TransformXfzbApi transformXfzbApi;

    String response;
    JSONObject jsonRequest, jsonResponse;

    @Given("user transform xfzb")
    public void userTransformXfzb() throws IOException {
        String xmlPayload = XFZBXml.xmlPayload;
        jsonRequest = XML.toJSONObject(xmlPayload);
        response = transformXfzbApi.transformXfzb(xmlPayload, "internal");
        jsonResponse = new JSONObject(response);
    }

    @Given("user transform xfzb using {string} url")
    public void userTransformXfwbUsingUrl(String url) throws IOException {
        String xmlPayload = XFZBXml.xmlPayload;
        jsonRequest = XML.toJSONObject(xmlPayload);
        response = transformXfzbApi.transformXfzb(xmlPayload, url);
        jsonResponse = new JSONObject(response);
    }

    @Then("verify mapping data {string} {string} {string}of BusinessHeaderDocument to data in response of HouseWaybill {string}")
    public void verifyMappingDataOfBusinessHeaderDocumentToDataInResponseOfHouseWaybill(String key, String subkey1, String subkey2, String keyResponse) {
        switch (keyResponse){
            case "waybillNumber":
                transformXfzbApi.verifyWaybillNumber(jsonRequest, jsonResponse);
                break;
            case "waybillType":
                transformXfzbApi.verifyWaybillType(jsonRequest, jsonResponse);
                break;
            case "consignorDeclarationSignature":
                transformXfzbApi.verifyConsignorDeclarationSignature(jsonRequest, jsonResponse);
                break;
            case "carrierDeclarationDate":
                transformXfzbApi.verifyCarrierDeclarationDate(jsonRequest, jsonResponse);
                break;
            case "carrierDeclarationSignature":
                transformXfzbApi.verifyCarrierDeclarationSignature(jsonRequest, jsonResponse);
                break;
            case "carrierDeclarationPlace":
                transformXfzbApi.verifyCarrierDeclarationPlace(jsonRequest, jsonResponse);
                break;
            default:
                throw new SkipStepException("there is no ket response");
        }
    }

    @Then("verify mapping data {string} {string} {string}of MasterConsignment to data in response of HouseWaybill {string}")
    public void verifyMappingDataOfMasterConsignmentToDataInResponseOfHouseWaybill(String key, String subkey, String arg2, String keyResponse) {
        switch (keyResponse){
            case "declaredValueForCarriage":
                if (subkey.equals("NilCarriageValueIndicator")) transformXfzbApi.verifyNilCarriageValueIndicator(jsonRequest, jsonResponse);
                else if (subkey.equals("DeclaredValueForCarriageAmount")) transformXfzbApi.verifyDeclaredValueForCarriage(jsonRequest, jsonResponse);
                break;
            case "declaredValueForCustoms":
                if (subkey.equals("NilCustomsValueIndicator")) transformXfzbApi.verifyNilCustomsValueIndicator(jsonRequest, jsonResponse);
                else if (subkey.equals("DeclaredValueForCustomsAmount")) transformXfzbApi.verifyDeclaredValueForCustoms(jsonRequest, jsonResponse);
                break;
            case "insuredAmount":
                if (subkey.equals("NilInsuranceValueIndicator")) transformXfzbApi.verifyNilInsuranceValueIndicator(jsonRequest, jsonResponse);
                else if (subkey.equals("InsuranceValueAmount")) transformXfzbApi.verifyInsuranceValueAmount(jsonRequest, jsonResponse);
                break;
            case "weightValuationIndicator":
                transformXfzbApi.verifyWeightValuationIndicator(jsonRequest, jsonResponse);
                break;
            case "otherChargesIndicator":
                transformXfzbApi.verifyOtherChargesIndicator(jsonRequest, jsonResponse);
                break;
            case "totalGrossWeight":
                transformXfzbApi.verifyTotalGrossWeight(jsonRequest, jsonResponse);
                break;
            case "slacForRate":
                transformXfzbApi.verifySlacForRate(jsonRequest, jsonResponse);
                break;
            case "Goodsdescriptionforrate":
                transformXfzbApi.verifyGoodsDescriptionForRate(jsonRequest, jsonResponse);
                break;
            case "departureLocation":
                transformXfzbApi.verifyDepartureLocation(jsonRequest, jsonResponse);
                break;
            case "arrivalLocation":
                transformXfzbApi.verifyArrivalLocation(jsonRequest, jsonResponse);
                break;
            case "pieceCountForRate":
                transformXfzbApi.verifyPieceCountForRate(jsonRequest, jsonResponse);
                break;
            case "waybillNumber":
                transformXfzbApi.verifyMasterWaybillNumber(jsonRequest, jsonResponse);
                break;
            default:
                throw new SkipStepException("there is no key response");
        }
    }

    @Then("verify mapping data {string} {string} of MessageHeaderDocument to data in response of HouseWaybill {string}")
    public void verifyMappingDataOfMessageHeaderDocumentToDataInResponseOfHouseWaybill(String arg0, String arg1, String keyResponse) {
        switch (keyResponse){
            default:
                throw new SkipStepException("there is no key response");
        }
    }

    @Then("verify mapping data {string} {string} {string} of ConsignorParty in MasterConsignment to data in response of HouseWaybill {string}")
    public void verifyMappingDataOfConsignorPartyInMasterConsignmentToDataInResponseOfHouseWaybill(String arg0, String arg1, String arg2, String keyResponse) {
        String party = "Consignor";
        switch (keyResponse) {
            case "name":
                transformXfzbApi.verifyNameConsignorParty(jsonRequest, jsonResponse, party);
                break;
            case "postalCode":
                transformXfzbApi.verifyConsignorPostalCode(jsonRequest, jsonResponse, party);
                break;
            case "streetAddressLines":
                transformXfzbApi.verifyConsignorStreetAddressLines(jsonRequest, jsonResponse, party);
                break;
            case "cityName":
                transformXfzbApi.verifyConsignorCityName(jsonRequest, jsonResponse, party);
                break;
            case "countryCode":
                transformXfzbApi.verifyConsignorCountryCode(jsonRequest, jsonResponse, party);
                break;
            case "countryDescription":
                transformXfzbApi.verifyConsignorCountry(jsonRequest, jsonResponse, party);
                break;
            case "regionName":
                transformXfzbApi.verifyConsignorRegionName(jsonRequest, jsonResponse, party);
                break;
            case "postOfficeBox":
                transformXfzbApi.verifyConsignorPostOfficeBox(jsonRequest, jsonResponse, party);
                break;
            case "cityCode":
                transformXfzbApi.verifyConsignorCityID(jsonRequest, jsonResponse, party);
                break;
            case "regionCode":
                transformXfzbApi.verifyConsignorCountrySubDivisionID(jsonRequest, jsonResponse, party);
                break;
            default:
                throw new SkipStepException("there is no key response");
        }
    }

    @Then("verify mapping data {string} {string} {string} of ConsigneeParty in MasterConsignment to data in response of HouseWaybill {string}")
    public void verifyMappingDataOfConsigneePartyInMasterConsignmentToDataInResponseOfHouseWaybill(String arg0, String arg1, String arg2, String keyResponse) {
        String party = "Consignee";
        switch (keyResponse) {
            case "name":
                transformXfzbApi.verifyNameConsigneeParty(jsonRequest, jsonResponse, party);
                break;
            case "postalCode":
                transformXfzbApi.verifyConsigneePostalCode(jsonRequest, jsonResponse, party);
                break;
            case "streetAddressLines":
                transformXfzbApi.verifyConsigneeStreetAddressLines(jsonRequest, jsonResponse, party);
                break;
            case "cityName":
                transformXfzbApi.verifyConsigneeCityName(jsonRequest, jsonResponse, party);
                break;
            case "countryCode":
                transformXfzbApi.verifyConsigneeCountryCode(jsonRequest, jsonResponse, party);
                break;
            case "countryDescription":
                transformXfzbApi.verifyConsigneeCountry(jsonRequest, jsonResponse, party);
                break;
            case "regionName":
                transformXfzbApi.verifyConsigneeRegionName(jsonRequest, jsonResponse, party);
                break;
            case "postOfficeBox":
                transformXfzbApi.verifyConsigneePostOfficeBox(jsonRequest, jsonResponse, party);
                break;
            case "cityCode":
                transformXfzbApi.verifyConsigneeCityID(jsonRequest, jsonResponse, party);
                break;
            case "regionCode":
                transformXfzbApi.verifyConsigneeCountrySubDivisionID(jsonRequest, jsonResponse, party);
                break;
            default:
                throw new SkipStepException("there is no key response");
        }
    }

    @Then("verify mapping data {string} {string} {string} of FreightForwarderParty in MasterConsignment to data in response of HouseWaybill {string}")
    public void verifyMappingDataOfFreightForwarderPartyInMasterConsignmentToDataInResponseOfHouseWaybill(String arg0, String arg1, String arg2, String keyResponse) {
        String party = "Agent";
        switch (keyResponse) {
            case "name":
                transformXfzbApi.verifyNameFreightForwarderParty(jsonRequest, jsonResponse, party);
                break;
            case "postalCode":
                transformXfzbApi.verifyFreightForwarderPostalCode(jsonRequest, jsonResponse, party);
                break;
            case "streetAddressLines":
                transformXfzbApi.verifyFreightForwarderStreetAddressLines(jsonRequest, jsonResponse, party);
                break;
            case "cityName":
                transformXfzbApi.verifyFreightForwarderCityName(jsonRequest, jsonResponse, party);
                break;
            case "countryCode":
                transformXfzbApi.verifyFreightForwarderCountryCode(jsonRequest, jsonResponse, party);
                break;
            case "countryDescription":
                transformXfzbApi.verifyFreightForwarderCountry(jsonRequest, jsonResponse, party);
                break;
            case "regionName":
                transformXfzbApi.verifyFreightForwarderRegionName(jsonRequest, jsonResponse, party);
                break;
            case "postOfficeBox":
                transformXfzbApi.verifyFreightForwarderPostOfficeBox(jsonRequest, jsonResponse, party);
                break;
            case "cityCode":
                transformXfzbApi.verifyFreightForwarderCityID(jsonRequest, jsonResponse, party);
                break;
            case "regionCode":
                transformXfzbApi.verifyFreightForwarderCountrySubDivisionID(jsonRequest, jsonResponse, party);
                break;
            default:
                throw new SkipStepException("there is no key response");
        }
    }

    @Then("verify mapping data {string} {string} {string} of AssociatedParty in MasterConsignment to data in response of HouseWaybill {string}")
    public void verifyMappingDataOfAssociatedPartyInMasterConsignmentToDataInResponseOfHouseWaybill(String arg0, String arg1, String arg2, String keyResponse) {
        String party = "Associated Party";
        switch (keyResponse) {
            case "name":
                transformXfzbApi.verifyNameNotifyParty(jsonRequest, jsonResponse, party);
                break;
            case "postalCode":
                transformXfzbApi.verifyNotifyPartyPostalCode(jsonRequest, jsonResponse, party);
                break;
            case "streetAddressLines":
                transformXfzbApi.verifyNotifyPartyStreetAddressLines(jsonRequest, jsonResponse, party);
                break;
            case "cityName":
                transformXfzbApi.verifyNotifyPartyCityName(jsonRequest, jsonResponse, party);
                break;
            case "countryCode":
                transformXfzbApi.verifyNotifyPartyCountryCode(jsonRequest, jsonResponse, party);
                break;
            case "countryDescription":
                transformXfzbApi.verifyNotifyPartyCountry(jsonRequest, jsonResponse, party);
                break;
            case "regionName":
                transformXfzbApi.verifyNotifyPartyRegionName(jsonRequest, jsonResponse, party);
                break;
            case "postOfficeBox":
                transformXfzbApi.verifyNotifyPartyPostOfficeBox(jsonRequest, jsonResponse, party);
                break;
            case "cityCode":
                transformXfzbApi.verifyNotifyPartyCityID(jsonRequest, jsonResponse, party);
                break;
            case "regionCode":
                transformXfzbApi.verifyNotifyPartyCountrySubDivisionID(jsonRequest, jsonResponse, party);
                break;
            default:
                throw new SkipStepException("there is no key response");
        }
    }

    @Then("verify mapping data {string} {string} {string} of OriginLocation in MasterConsignment to data in response of HouseWaybill {string}")
    public void verifyMappingDataOfOriginLocationInMasterConsignmentToDataInResponseOfHouseWaybill(String arg0, String arg1, String arg2, String keyResponse) {
        switch (keyResponse) {
            case "locationCode":
                transformXfzbApi.verifyOriginLocationID(jsonRequest, jsonResponse);
                break;
            case "locationName":
                transformXfzbApi.verifyOriginLocationName(jsonRequest, jsonResponse);
                break;
            default:
                throw new SkipStepException("there is no key response");
        }
    }

    @Then("verify mapping data {string} {string} {string} of FinalDestinationLocation in MasterConsignment to data in response of HouseWaybill {string}")
    public void verifyMappingDataOfFinalDestinationLocationInMasterConsignmentToDataInResponseOfHouseWaybill(String arg0, String arg1, String arg2, String keyResponse) {
        switch (keyResponse) {
            case "locationCode":
                transformXfzbApi.verifyDestinationLocationID(jsonRequest, jsonResponse);
                break;
            case "locationName":
                transformXfzbApi.verifyDestinationLocationName(jsonRequest, jsonResponse);
                break;
            default:
                throw new SkipStepException("there is no key response");
        }
    }
}
