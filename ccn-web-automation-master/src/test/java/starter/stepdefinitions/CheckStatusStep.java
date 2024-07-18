package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.pages.CheckStatusPage;

public class CheckStatusStep {

    @Steps
    CheckStatusPage checkStatusPage;

    @And("user get service id {string} with reference ID")
    public void userGetServiceIdWithReferenceID(String type) {
        if (type.equals("Service")) checkStatusPage.getCheckStatus("5c3d42c5-d14a-4ba4-a3d7-77cf68e0bd99");
        else checkStatusPage.getCheckStatus("e29da7aa-92cf-450e-87a1-ee914a94da5f");
    }

    @Given("user get SSO token for check status")
    public void userGetSSOTokenForCheckStatus() {
        CheckStatusPage.fetchAccessToken();
    }

    @Then("success get detail of service id")
    public void successGetDetailOfServiceId() {
        checkStatusPage.assertSuccessCheckStatus();
    }

    @Then("failed with {int} get detail of service id")
    public void failedWithGetDetailOfServiceId(int statusCode) {
        checkStatusPage.assertFailedCheckStatus(statusCode);
    }
}
