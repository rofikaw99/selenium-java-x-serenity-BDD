package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.pages.GoToUrl;
import starter.pages.LoginPage;
import starter.pages.SupportAppPage;
import starter.utlis.Constants;

public class SupportAppStep {

    @Steps
    GoToUrl goToUrl;

    @Steps
    LoginPage loginPage;

    @Steps
    SupportAppPage supportAppPage;

    private int waitResponse = 3000;
    private String input = "";
    @Given("go to support app web")
    public void goToSupportAppWeb() throws InterruptedException {
        goToUrl.goToAbsUrl(Constants.URL_SUPPORT_APP_WEB);
        Thread.sleep(3000);
    }

    @When("input user ID {string} and password {string} and submit button to continue login")
    public void inputUserIDAndPasswordAndSubmitButtonToContinueLogin(String userID, String password) throws Exception {
        Thread.sleep(waitResponse);
        loginPage.inputSigninSupportApp(userID,password);
    }
    @When("user input {string} and click search")
    public void userInputAWBPrefixAndClickSearch(String AirlineSearchBy) throws Exception {
        Thread.sleep(400);
        loginPage.inputAwbPrefixToGetAirlinesCompanyIdentity(AirlineSearchBy);
    }
    @When("try to edit {string} in airline company identity")
    public void tryToEditInAirlineCompanyIdentity(String address3) throws Exception {
        Thread.sleep(400);
        loginPage.editAirlinesCompanyIdentity(address3);
    }
    @When("user input all data required to create company like {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void user_input_all_data_required_to_create_airline_company_like(String airlineName,String email, String compRegNo, String pimaAddress, String country, String city, String address, String address2, String address3, String carrierCode, String awbPrefix ) throws Exception {
        Thread.sleep(400);
        loginPage.editAirlinesCompanyIdentity(address3);
    }
    @Then("update new plan manager in support app")
    public void updateNewPlanManageriInSupportApp() throws Exception {
        Thread.sleep(waitResponse);
        loginPage.inputPlanManagerSupportApp();
    }
    @When("user go to create discount menu")
    public void userGoToCreateDiscountMenu() {
        supportAppPage.pressDiscountMenu();
        supportAppPage.createDiscountSubMenu();
    }

    @When("user go to subscription menu")
    public void userGoToSubscriptionMenu() {
        supportAppPage.pressSubscriptionMenu();
    }
    @And("user go to upload file onboard submenu")
    public void userGoToUploadFileOnboardSubMenu() throws InterruptedException {
        supportAppPage.pressOnboardFileSubMenu();
    }
    @And("user select an excel file to upload file onboard in the support app then populate and submit")
    public void userSelectAnExcelFileToUploadFileOnboardInTheSupportApp() throws InterruptedException {
        supportAppPage.uploadOnboardFileSubMenu();
    }
    @And("user select an excel file to upload file onboard in the support app")
    public void userSelectAnExcelFileToUploadFileOnboardInTheSupportAppOnlySelect() throws InterruptedException {
        supportAppPage.uploadOnboardFileOnly();
    }
    @When("user go to group menu")
    public void userGoToGroupMenu() throws InterruptedException {
        supportAppPage.pressGroupMenu();
    }
    @When("user go to airlines submenu")
    public void userGoToAirlineSubMenu() throws InterruptedException {
        supportAppPage.pressAirlinesSubMenu();
    }
    @When("user go to create new airlines function")
    public void userGoToCreateNewAirlineFunction() throws InterruptedException {
        supportAppPage.pressCreateNewAirlines();
    }
    @When("user press submit to create new airlines")
    public void userPressSubmitToCreateNewAirline() throws InterruptedException {
        supportAppPage.pressSubmitToCreateNewAirlines();
    }
    @And("user go to edit airlines company identity function")
    public void userGoToEditAirline() throws InterruptedException {
        supportAppPage.pressEditAirlines();
    }
    @When("user want to view change log by input filter date {string} and {string}")
    public void userWantViewChangeLog(String startDate, String endDate) throws InterruptedException {
        supportAppPage.viewAirlineChangeLog(startDate, endDate);
    }
    @When("user select airline company identity by carrier code")
    public void userSelectAirlineCompanyIdentityByCarrierCode() throws InterruptedException {
        supportAppPage.selectSearchAirlineCompanyIdentityType();
    }
    @When("user go to notification menu")
    public void userGoToNotificationMenu() throws InterruptedException {
        supportAppPage.pressNotificationMonitoringMenu();
    }

    @When("user go to update plan manager menu")
    public void userGoToUpdatePlanManagerMenu() throws InterruptedException {
        supportAppPage.pressUpdatePlanManager();
    }
    @When("user go to action log")
    public void userGoToActionLog() throws InterruptedException {
        supportAppPage.actionLog();
    }
    @When("user click Access Control")
    public void userClickAccessControl() throws InterruptedException {
        supportAppPage.accessControl();
    }
    @When("verify that the tittle change from “Access Control” to “Portal Access Management.”  on Access Control Sub Menu")
    public void verifyTitleChangeToPortalAccessManagement() throws InterruptedException {
        supportAppPage.verifyTitleChangeToPortalAccessManagement();
    }
    @When("verify that the tittle change from “Group Access” to “Access Group.”  on Access Control Sub Menu")
    public void verifyTitleChangeToAccessGroup() throws InterruptedException {
        supportAppPage.verifyTitleChangeToAccessGroup();
    }
    @When("verify that the tittle change from “User” to “User Management.”  on Access Control Sub Menu")
    public void verifyTitleChangeToUserManagement() throws InterruptedException {
        supportAppPage.verifyTitleChangeToUserManagement();
    }
    @When("Add a new feature titled “Admin Change Log.”")
    public void newFeatureTitledAminChangeLog() throws InterruptedException {
        supportAppPage.newAdminChangeLog();
    }
    @When("user go to a new feature titled “Admin Change Log.”")
    public void userGoToFeatureTitledAminChangeLog() throws InterruptedException {
        supportAppPage.goTonewAdminChangeLog();
    }
    @When("user go to subscription support app")
    public void userGoToSubscriptionSupportApp() throws InterruptedException {
        supportAppPage.subscription();
    }
    @When("user click action log dropDown")
    public void userClickActionLogDropDown() throws InterruptedException {
        supportAppPage.clickActionLogDropDown();
    }
    @And("select user to export action log")
    public void selectUserToExportActionLog() throws InterruptedException {
        supportAppPage.selectUserToExportActionLog();
    }
    @And("input start date {string} and end date {string} to export action log")
    public void selectStartEndActionLog(String startDate, String endDate) throws InterruptedException {
        supportAppPage.selectStartEndDateActionLog(startDate, endDate);
    }

    @Then("verify notification monitoring information")
    public void verifyNotificationMonitoringInformation() throws InterruptedException {
        supportAppPage.verifyNotificationMonitoringMenuInfo();
    }
    @Then("verify airline search validation text display")
    public void verifyAirlineSearchValidationTextDisplay() throws InterruptedException {
        supportAppPage.verifyAirlineSearchValidationTextDisplayInformation();
    }
    @Then("verify that Airlines Company Identity already cover Airlines Name, Carrier Code, Awb Prefix, Airlines Address, and System Cube Mail Address")
    public void verifyAirlinesCompanyIdentityCover5Attribute() throws InterruptedException {
        Thread.sleep(600);
        Assert.assertTrue(supportAppPage.fiveAttributeIsDisplayed());
    }
    @Then("verify that new Airlines Company created successfully")
    public void verifyNewAirlinesCompanyIdentityCreated() throws InterruptedException {
        Thread.sleep(600);
        Assert.assertTrue(supportAppPage.fiveAttributeIsDisplayed());
    }

    @When("user go to company info sub menu")
    public void userGoToCompanyInfoSubMenu() throws InterruptedException {
        supportAppPage.companyInfoSubMenu();
    }

    @And("input create discount support web app with {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void inputCreateDiscountSupportWebAppWithAndAndAndAndAndAndAnd(String couponNameFill, String amount,
                                                                          String promoCodeFill, String companyPromoFill, String customer, String priceID,
                                                                          String country, String city) {
        supportAppPage.createDiscount(couponNameFill, amount, promoCodeFill,
                companyPromoFill, customer, priceID, country, city);
    }

    @And("Input {string} the display more info")
    public void InputCompanyInfo(String condition) throws Exception {
        Thread.sleep(3000);
        supportAppPage.pressTypeofSearch(condition);
        switch (condition) {
            case "Company System Address":
                input = Constants.SYSTEM_COMPANY_ADDRESS;
                break;
            case "Company Pima Address":
                input = Constants.COMPANY_PIMA;
                break;
            case "Member Email":
                input = Constants.EMAIL_AUTHORIZED_HAVE_PAYMENT_REQUEST;
                break;
            case "Company Cube ID":
                input = Constants.CUBE_ID;
                break;
            case "Company Name":
            case "Company UEN":
                input = Constants.COMPANY_NAME_SEARCH;
                break;
            case "Company Domain":
                input = Constants.COMPANY_NAME_DOMAIN;
                break;
            default:
                input = Constants.EMAIL_WITHOUT_COMPANY;
        }
        Thread.sleep(2500);
        supportAppPage.inputCompany(input);
        supportAppPage.pressSCheckButton();
        Thread.sleep(7000);
        Assert.assertTrue(supportAppPage.CompanyName());
        Assert.assertTrue(supportAppPage.CompanyCubeID());
        Assert.assertTrue(supportAppPage.CompanySystemCube());
        Assert.assertTrue(supportAppPage.CompanyPIMA());
        Assert.assertTrue(supportAppPage.GHA());
        Assert.assertTrue(supportAppPage.GHACode());
        Assert.assertTrue(supportAppPage.UEN());
        Assert.assertTrue(supportAppPage.CompanyCountry());
        Assert.assertTrue(supportAppPage.CompanyMembers());
    }

    @And("input {string} to display update plan manager function")
    public void InputPlanManagerMail(String planManagerMail) throws Exception {
        Thread.sleep(2000);
        switch (planManagerMail) {
            case "HQ":
                input = Constants.HQ;
                break;
            default:
                input = Constants.EMAIL_WITHOUT_COMPANY;
        }
        supportAppPage.inputCompany(input);
        supportAppPage.pressSCheckButton();
        Thread.sleep(3000);
        Assert.assertTrue(supportAppPage.currentPlanManager());
    }

    @When("user go to create plan support web app menu")
    public void userGoToCreatePlanSupportWebAppMenu() {
        supportAppPage.pressSubscribtionMenu();
        supportAppPage.pressProductSubMenu();
        supportAppPage.pressCreatePlan();
    }

    @And("input create plan in support web app with {string} and {string} and {string}")
    public void inputCreatePlanInSupportWebAppWithAndAnd(String name, String productPlanName, String description) {
        supportAppPage.createPlanInput(name, productPlanName, description);
    }

    @When("add new price on new plan")
    public void addNewPriceOnNewPlan() {
        supportAppPage.pressSubscribtionMenu();
        supportAppPage.pressProductSubMenu();
        supportAppPage.addNewPrice();
    }

    @And("add new price in support web app with {string} and {string} and {string}")
    public void addNewPriceInSupportWebAppWithAndAnd(String nickName, String unitAmount, String memberLimit) {
        supportAppPage.addNewPriceInput(nickName, unitAmount, memberLimit);
    }
}
