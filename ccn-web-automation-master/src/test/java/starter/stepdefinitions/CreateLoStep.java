package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.api.CreateLoAPI;

import java.io.IOException;

public class CreateLoStep {
    @Steps
    CreateLoAPI createLoAPI;

    @Then("Success create")
    public void successCreate() {
        createLoAPI.verifySuccessCreateLO();
    }

    @And("Verify there is id of LO in body response")
    public void verifyThereIsIdOfLOInBodyResponse() {
        createLoAPI.verifyThereIsLOId();
    }
}
