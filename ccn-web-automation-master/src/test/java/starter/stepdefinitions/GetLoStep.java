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

public class GetLoStep {
    @Steps
    CreateLoAPI createLoAPI;

    @Steps
    GetLoAPI getLoAPI;
    @Steps
    TransformXfwbAPI transformXfwbPage;

    String id;
    JSONObject responseJson;
    JSONObject jsonXml;

    @Given("Create logistic objects using predefined json")
    public void createLogisticObjectsUsingPredefinedJson() throws IOException {
        id = createLoAPI.createLORequest();
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
}
