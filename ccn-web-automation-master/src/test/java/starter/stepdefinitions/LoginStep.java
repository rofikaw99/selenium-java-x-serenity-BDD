package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.api.LoginAPI;

import java.io.IOException;

public class LoginStep {
    @Steps
    LoginAPI loginAPI;

    @Given("user login SSO for one record")
    public void userLoginSSOForOneRecord() throws IOException {
        loginAPI.loginRequest();
    }
}
