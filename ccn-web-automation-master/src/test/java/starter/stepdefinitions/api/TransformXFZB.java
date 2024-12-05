package starter.stepdefinitions.api;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;
import org.json.XML;
import starter.api.TransformXfzbApi;
import starter.utlis.XFWBXml;
import starter.utlis.XFZBXml;

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

//    @Then("verify mapping data {string} {string} {string}of BusinessHeaderDocument to data in response of HouseWaybill {string}")
//    public void verifyMappingDataOfBusinessHeaderDocumentToDataInResponseOfHouseWaybill(String key, String subkey1, String subkey2, String keyResponse) {
//        switch (keyResponse){
//            case "waybillNumber":
//                transformXfzbApi.verifyWaybillNumber(jsonRequest, jsonResponse);
//                break;
//            case "consignorDeclarationSignature":
//                transformXfzbApi.verifyConsignorDeclarationSignature(jsonRequest, jsonResponse);
//                break;
//            case "carrierDeclarationDate":
//                transformXfzbApi.verifyCarrierDeclarationDate(jsonRequest, jsonResponse);
//                break;
//            case "carrierDeclarationSignature":
//                transformXfzbApi.verifyCarrierDeclarationSignature(jsonRequest, jsonResponse);
//                break;
//            case "carrierDeclarationPlace":
//                transformXfzbApi.verifyCarrierDeclarationPlace(jsonRequest, jsonResponse);
//                break;
//        }
//    }

//    @Then("verify mapping data {string} {string} {string}of MasterConsignment to data in response of HouseWaybill {string}")
//    public void verifyMappingDataOfMasterConsignmentToDataInResponseOfHouseWaybill(String arg0, String arg1, String arg2, String keyResponse) {
//        switch (keyResponse){
//            case "declaredValueForCarriage":
//                transformXfzbApi.verifyDeclaredValueForCarriage(jsonRequest, jsonResponse);
//                break;
//            case "declaredValueForCustoms":
//                transformXfzbApi.verifyDeclaredValueForCustoms(jsonRequest, jsonResponse);
//                break;
//            case "insuredAmount":
//                transformXfzbApi.verifyInsuredAmount(jsonRequest, jsonResponse);
//                break;
//            case "weightValuationIndicator":
//                transformXfzbApi.verifyWeightValuationIndicator(jsonRequest, jsonResponse);
//                break;
//            case "otherChargesIndicator":
//                transformXfzbApi.verifyOtherChargesIndicator(jsonRequest, jsonResponse);
//                break;
//            case "totalGrossWeight":
//                transformXfzbApi.verifyTotalGrossWeight(jsonRequest, jsonResponse);
//                break;
//            case "slacForRate":
//                transformXfzbApi.verifySlacForRate(jsonRequest, jsonResponse);
//                break;
//            case "Goodsdescriptionforrate":
//                transformXfzbApi.verifyGoodsDescriptionForRate(jsonRequest, jsonResponse);
//                break;
//            case "departureLocation":
//                transformXfzbApi.verifyDepartureLocation(jsonRequest, jsonResponse);
//                break;
//            case "arrivalLocation":
//                transformXfzbApi.verifyArrivalLocation(jsonRequest, jsonResponse);
//                break;
//            default:
//                throw new PendingException("there is no key response");
//        }
//    }
}
