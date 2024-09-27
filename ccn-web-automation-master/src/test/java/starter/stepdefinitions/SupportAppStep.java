package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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

    @When("user go to create discount menu")
    public void userGoToCreateDiscountMenu() {
        supportAppPage.pressDiscountMenu();
        supportAppPage.createDiscountSubMenu();
    }

    @When("user go to group menu")
    public void userGoToGroupMenu() throws InterruptedException {
        supportAppPage.pressGroupMenu();
    }

    @When("user go to notification menu")
    public void userGoToNotificationMenu() throws InterruptedException {
        supportAppPage.pressNotificationMonitoringMenu();
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
