package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import starter.pages.GoToUrl;
import starter.pages.LoginPage;
import starter.pages.SubscriptionPage;

public class LoginSteps {

    private int waitResponse = 5000;
    @Steps
    LoginPage loginPage;

    @Steps
    SubscriptionPage subscriptionPage;

    @Steps
    GoToUrl headerComponent;

    @Given("accept cookie")
    public void acceptCookie() {
        loginPage.printAllCookies();
        loginPage.pressAcceptCookies();
    }

    @When("click initial sign in button")
    public void clickInitialSignInButton() throws InterruptedException {
        loginPage.pressBtnLoginInit();
        Thread.sleep(waitResponse);
        loginPage.changeSigninWindow();
    }

    @And("input initial email sign in")
    public void inputInitialEmailSignIn() throws InterruptedException {
        Thread.sleep(waitResponse);
        loginPage.inputEmailLogin("test_071123_a1@yopmail.com");
    }

    @And("input initial password sign in")
    public void inputInitialPasswordSignIn() {
        loginPage.inputPasswordLogin("p@55w0rd");
    }

    @And("click final sign in button")
    public void clickFinalSignInButton() throws Exception {
        loginPage.pressSignIn();
    }

    @Then("back to the main tab browser")
    public void backToTheMainTabBrowser() throws InterruptedException {
        Thread.sleep(36000);
        loginPage.validateInMainWeb();
    }

    @Given("{string} click product tab to subscribe to product")
    public void clickProductTabToSubscribeToProduct(String arg0) throws Exception {
        headerComponent.goToProductTab();
        Thread.sleep(2000);
    }

    @And("Select plan {string} {string}")
    public void selectPlan(String arg0, String product) throws Exception {
        subscriptionPage.selectPlanPoduct(product);
        Thread.sleep(10000);
    }

    @And("Select plan Test BC-Premium Multicurrency#Sandbox")
    public void selectPlanTestBCPremiumMulticurrencySandbox() throws Exception {
        loginPage.selectTestBCPremiumMulticurrencySandbox();
        Thread.sleep(9000);
    }

    @And("select plan bundle BC AWB")
    public void selectplanbundleBCAWB() throws Exception {
        loginPage.selectplanbundleBCAWB();
        Thread.sleep(9000);
    }

    @And("select plan test awbconcierge premium multicurrencysandbox")
    public void selectPlantestawbconciergepremiummulticurrencysandbox() throws Exception {
        loginPage.selecttestawbconciergepremiummulticurrencysandbox();
        Thread.sleep(9000);
    }

    @And("select plan Lead Freight Solutions")
    public void selectPlanLeadFreightSolutions() throws Exception {
        loginPage.selectPlanLeadFreightSolutions();
        Thread.sleep(9000);
    }

    @And("exit browser")
    public void exitBrowser() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }

    @And("select plan Test IATA TACT RATE-Premium Multicurrency#Sandbox")
    public void selectPlanTestIATATACTRATEPremiumMulticurrencySandbox() throws Exception {
        loginPage.selectTestIATATACTRATEPremiumMulticurrencySandbox();
        Thread.sleep(9000);
    }

    @And("select plan BC CN Market")
    public void selectselectplanBCCNMarket() throws Exception {
        loginPage.selectplanBCCNMarket();
        Thread.sleep(9000);
    }

    @And("contact us on plan BC CN Market")
    public void contactusonplanBCCNMarket() throws Exception {
        loginPage.contactusonplanBCCNMarket();
        Thread.sleep(9000);
    }

    @When("input email {string} and password {string} and press sign in to continue login")
    public void inputEmailAndPasswordAndPressSignInToContinueLogin(String email, String password) {
        loginPage.loginCubeforall(email, password);
    }
}
