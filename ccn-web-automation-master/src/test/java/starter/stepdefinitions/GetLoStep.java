package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;
import org.json.XML;
import starter.api.CreateLoAPI;
import starter.api.GetLoAPI;
import starter.api.TransformXfwbAPI;
import starter.utlis.XFWBXml;

import java.io.IOException;
import java.util.List;

public class GetLoStep {
    @Steps
    CreateLoAPI createLoAPI;

    @Steps
    GetLoAPI getLoAPI;
    @Steps
    TransformXfwbAPI transformXfwbPage;

    String id, waybillNumber, waybillPrefix;
    JSONObject responseJson;
    JSONObject jsonXml;

    @Given("Create logistic objects using predefined json")
    public void createLogisticObjectsUsingPredefinedJson() throws IOException {
        id = createLoAPI.createLoRequestUrl("internal");
        waybillNumber = createLoAPI.getWaybillNumber();
        waybillPrefix = createLoAPI.getWaybillPrefix();
    }

    @When("get logistic objects using ID of response")
    public void getLogisticObjectsUsingIDOfResponse() throws IOException {
        jsonXml = XML.toJSONObject(XFWBXml.xmlPayload);
        responseJson = getLoAPI.getLORequest(id);
    }

    @Then("success get detail of logistic object")
    public void successGetDetailOfLogisticObject() {
        getLoAPI.verifySuccessGetLO();
    }

    @Then("verify mapping data of {string} to API response")
    public void verifyMappingDataOfToAPIResponse(String key) {
        switch (key){
            case "accountingInformation":
                transformXfwbPage.verifyAccountingInformation(jsonXml, responseJson);
                break;
            case "carrierDeclarationDate":
                transformXfwbPage.verifyCarrierDeclarationDate(jsonXml, responseJson);
                break;
            case "carrierDeclarationSignature":
                transformXfwbPage.verifyCarrierDeclarationSignature(jsonXml, responseJson);
                break;
            case "consignorDeclarationSignature":
                transformXfwbPage.verifyConsignorDeclarationSignature(jsonXml, responseJson);
                break;
            case "waybillPrefix":
                transformXfwbPage.verifyWaybillPrefix(jsonXml, responseJson);
                break;
            case "waybillNumber":
                transformXfwbPage.verifyWaybillNumber(jsonXml, responseJson);
                break;
        }
    }

    @And("verify the id of body is equals with the request data")
    public void verifyTheIdOfBodyIsEqualsWithTheRequestData() {
        getLoAPI.verifyIdEqualRequest(id);
    }

    @When("get logistic objects using LO_ID")
    public void getLogisticObjectsUsingLO_ID() throws IOException {
        List<String> ids = List.of(id.split("/"));
        String idBody = ids.get(ids.size() - 1);
        getLoAPI.getLORequestLoId(idBody);
    }

    @When("get logistic objects using waybillNumber")
    public void getLogisticObjectsUsingWaybillNumber() throws IOException {
        getLoAPI.getLORequestLoWaybillNumber(waybillNumber);
    }

    @And("verify the waybillNumber is equals with the request data")
    public void verifyTheWaybillNumberIsEqualsWithTheRequestData() {
        getLoAPI.verifyWaybillNumberEqualRequest(waybillNumber);
    }

    @When("get logistic objects using waybillPrefix")
    public void getLogisticObjectsUsingWaybillPrefix() throws IOException {
        getLoAPI.getLORequestLoWaybillPrefix(waybillPrefix, waybillNumber);
    }

    @And("verify the waybillPrefix is equals with the request data")
    public void verifyTheWaybillPrefixIsEqualsWithTheRequestData() {
        getLoAPI.verifyWaybillPrefixEqualRequest(waybillPrefix);
        getLoAPI.verifyWaybillNumberEqualRequest(waybillNumber);
    }

    @And("Create logistic objects using predefined json and {string} url")
    public void createLogisticObjectsUsingPredefinedJsonAndUrl(String url) throws IOException {
        switch (url){
            case "internal":
                id = createLoAPI.createLoRequestUrl("internal");
                break;
            case "external":
                id = createLoAPI.createLoRequestUrl("external");
        }
        waybillNumber = createLoAPI.getWaybillNumber();
        waybillPrefix = createLoAPI.getWaybillPrefix();
    }
}
