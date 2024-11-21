package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.thucydides.core.annotations.Steps;
import starter.pages.DashboardPage;
import starter.pages.LoginPage;
import starter.utlis.Constants;

public class DashboardStep {

    @Steps
    DashboardPage dashboardPage;
    @Steps
    LoginPage loginPage;

    @Given("get register of the email")
    public void getRegisterOfTheEmail() {
        dashboardPage.fetchAccessToken();
        dashboardPage.getRegisterEmail(Constants.EMAIL_AUTHORIZED_USER);
    }

    @When("create document shipment with valid awb")
    public void createDocumentShipmentWithValidAwb() {
        dashboardPage.createDocumentShipping();
    }

    @Then("success create document")
    public void successCreateDocument() {
        dashboardPage.successStatusCode();
    }

    @And("new document appears in the list of AWB")
    public void newDocumentAppearsInTheListOfAWB() throws InterruptedException {
        loginPage.login(Constants.EMAIL_AUTHORIZED_USER, Constants.PASSWORD);
        dashboardPage.verifyAwbListAppears();
    }

    @When("search awb with valid and registered awb number")
    public void searchAwbWithValidAndRegisteredAwbNumber() {
        dashboardPage.searchValidRegisteredAwbDashboard();
    }


    @Then("awb that matched with awb keyword appears")
    public void awbThatMatchedWithAwbKeywordAppears() {
       dashboardPage.assertMatchedAwbAppears();
    }

    @Then("success add awb number to watchlist")
    public void successAddToWatchlist() throws InterruptedException {
        dashboardPage.checkedAwbTrack();
    }

    @When("adding awb number to be tracked")
    public void addingAwbNumberToBeTracked() {
        dashboardPage.clickUntrackedAwb();
    }
}
