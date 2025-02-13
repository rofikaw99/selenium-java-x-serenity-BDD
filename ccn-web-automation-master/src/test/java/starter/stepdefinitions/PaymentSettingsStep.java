package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.api.PaymentSettings;

public class PaymentSettingsStep {
    @Steps
    PaymentSettings paymentSettings;

    @Given("{string} access card detail with value {string} cardDetail and {string} userList in payload")
    public void accessCardDetailWithValueCardDetailAndUserListInPayload(String user, String cardDetail, String userList) {
        paymentSettings.setToken(user);
        paymentSettings.retrieveCardDetail(cardDetail, userList);
    }

    @Then("result will be given based on payload: {int} status code and {string} cardDetail and {string} userList")
    public void resultWillBeGivenBasedOnPayloadStatusCodeAndCardDetailAndUserList(int statusCode, String cardDetail, String userList) {
        paymentSettings.verifyStatusCode(statusCode);
        paymentSettings.verifyCardDetail(cardDetail);
        paymentSettings.verifyUserList(userList);
    }

    @Then("result will be given based on payload: {int} status code and there's message {string}")
    public void resultWillBeGivenBasedOnPayloadStatusCodeAndThereSMessage(int statusCode, String message) {
        paymentSettings.verifyStatusCode(statusCode);
        paymentSettings.verifyStatusCodeInBody(statusCode);
        paymentSettings.verifyMessage(message);
    }
}
