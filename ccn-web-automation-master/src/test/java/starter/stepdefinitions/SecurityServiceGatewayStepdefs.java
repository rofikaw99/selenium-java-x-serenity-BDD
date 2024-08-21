package starter.stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import starter.api.FWBResharingPage;
import starter.api.SecurityServiceGatewayPage;
import starter.pages.*;
import starter.utlis.Constants;

public class SecurityServiceGatewayStepdefs {
    @Steps
    SecurityServiceGatewayPage securityServiceGatewayStepdefsPage;
    CheckStatusPage checkStatusPage;

    private int waitResponse = 5000;
    private int waitLongResponse = 10000;
    private String serviceGatewayType = "";

    @Given("Check status with {string} service gateway with no token and API key")
    public void Check_status_with_private_service_gateway_with_no_token_and_API_key(String condition) throws Exception {
        switch (condition) {
            case "public" : serviceGatewayType = Constants.PUBLIC_SERVICE_GATEWAY;
                break;
            case "private" : serviceGatewayType = Constants.PRIVATE_SERVICE_GATEWAY;
                break;
        }
        securityServiceGatewayStepdefsPage.Check_status_with_private_service_gateway_with_no_token_and_API_key(serviceGatewayType);
    }

    @Given("Check status with {string} service gateway with API key but no token")
    public void Check_status_with_private_service_gateway_with_no_token(String condition) throws Exception {
        switch (condition) {
            case "public" : serviceGatewayType = Constants.PUBLIC_SERVICE_GATEWAY;
                break;
            case "private" : serviceGatewayType = Constants.PRIVATE_SERVICE_GATEWAY;
                break;
        }
        securityServiceGatewayStepdefsPage.Check_status_with_private_service_gateway_with_no_token_and_API_key(serviceGatewayType);
    }

    @Given("Check status with {string} service gateway with modified host")
    public void Check_status_with_private_service_gateway_with_modified_host(String condition) throws Exception {
        switch (condition) {
            case "public" : serviceGatewayType = Constants.PUBLIC_SERVICE_GATEWAY;
                break;
            case "private" : serviceGatewayType = Constants.PRIVATE_SERVICE_GATEWAY;
                break;
        }
        securityServiceGatewayStepdefsPage.Check_status_with_private_service_gateway_with_modified_host(serviceGatewayType);
    }

    @Then("verify the response is unauthorized")
    public void verify_the_response_is_unauthorized() throws Exception {
        securityServiceGatewayStepdefsPage.assertFailed401();
    }

    @Then("verify the response is succeed")
    public void verify_the_response_is_succeed() throws Exception {
        checkStatusPage.assertSuccessCheckStatus();
    }
}
