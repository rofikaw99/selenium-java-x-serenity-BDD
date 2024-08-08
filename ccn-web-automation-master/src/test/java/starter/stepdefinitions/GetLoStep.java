package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;
import starter.api.CreateLoAPI;
import starter.api.GetLoAPI;
import starter.api.TransformXfwbPage;

import java.io.IOException;

public class GetLoStep {
    @Steps
    CreateLoAPI createLoAPI;

    @Steps
    GetLoAPI getLoAPI;
    @Steps
    TransformXfwbPage transformXfwbPage;

    String id;
    JSONObject responseJson;
    @Given("Create logistic objects using predefined json")
    public void createLogisticObjectsUsingPredefinedJson() throws IOException {
        id = createLoAPI.createLORequest();
    }

    @When("get logistic objects using ID of response")
    public void getLogisticObjectsUsingIDOfResponse() {
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
                transformXfwbPage.verifyAccountingInformation(responseJson);
                break;
            case "carrierDeclarationDate":
                transformXfwbPage.verifyCarrierDeclarationPlace(responseJson);
                break;
            case "carrierDeclarationSignature":
                transformXfwbPage.verifyCarrierDeclarationSignature(responseJson);
                break;
            case "consignorDeclarationSignature":
                transformXfwbPage.verifyConsignorDeclarationSignature(responseJson);
                break;
            case "waybillPrefix":
                transformXfwbPage.verifyWaybillPrefix(responseJson);
                break;
            case "waybillNumber":
                transformXfwbPage.verifyWaybillNumber(responseJson);
                break;
        }
    }
}
