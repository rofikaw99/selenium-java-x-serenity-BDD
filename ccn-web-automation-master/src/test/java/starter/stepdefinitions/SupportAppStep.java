package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
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
    @Given("go to support app web")
    public void goToSupportAppWeb() throws InterruptedException {
        goToUrl.goToAbsUrl(Constants.URL_SUPPORT_APP_WEB);
        Thread.sleep(waitResponse);
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

    @And("input create discount support web app with {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void inputCreateDiscountSupportWebAppWithAndAndAndAndAndAndAnd(String couponNameFill, String amount,
                                                                          String promoCodeFill, String companyPromoFill, String customer, String priceID,
                                                                          String country, String city) {
        supportAppPage.createDiscount(couponNameFill, amount, promoCodeFill,
                companyPromoFill, customer, priceID, country, city);
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
