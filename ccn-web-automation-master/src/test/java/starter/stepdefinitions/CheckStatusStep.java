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
        else checkStatusPage.getCheckStatus("4e59bb35-fc37-48d7-9852-a25a6e0b9190");
    }

    @And("user get service id pair service type service with service with reference ID")
    public void userGetpair_service_type_service_with_serviceID(String type) {
        if (type.equals("App")) checkStatusPage.getCheckStatus("e29da7aa-92cf-450e-87a1-ee914a94da5f");
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

    @Then("failed get detail of service id")
    public void failedGetDetailOfServiceId() {
        checkStatusPage.assertSuccessCheckStatus();
    }
}
