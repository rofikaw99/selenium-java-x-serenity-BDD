package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import starter.pages.GoToUrl;
import starter.pages.LoginPage;
import starter.pages.SubscriptionPage;
import starter.utlis.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import static net.serenitybdd.core.Serenity.getDriver;

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
        Thread.sleep(19000);
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

    @And("Select plan TDSB")
    public void selectPlanTDSB() throws Exception {
        loginPage.selectTDSB();
        Thread.sleep(8000);
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

    @Given("I have authenticated to sandbox using Playwright {string}")
    public void iHaveAuthenticatedToSandboxUsingPlaywright(String email) throws IOException, InterruptedException {
        // Execute the Playwright login script
        try {
            Process process = Runtime.getRuntime().exec("node scripts/login.js");
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("login.js failed with exit code: " + exitCode);
                new BufferedReader(new InputStreamReader(process.getErrorStream()))
                        .lines()
                        .forEach(System.err::println);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // Read cookies generated by Playwright
        String json = Files.readString(Paths.get("auth-cookies.json"));
        JSONArray cookies = new JSONArray(json);

        // Open the target domain so Selenium can associate cookies
        getDriver().get(Constants.URL_MAIN_WEB);

        // Inject cookies that match the current domain
        String currentDomain = URI.create(getDriver().getCurrentUrl()).getHost();
        for (int i = 0; i < cookies.length(); i++) {
            JSONObject ck = cookies.getJSONObject(i);
            String cookieDomain = ck.getString("domain").replaceFirst("^\\.", "");

            if (currentDomain.equals(cookieDomain)) {
                Cookie seleniumCookie = new Cookie.Builder(ck.getString("name"), ck.getString("value"))
                        .domain(cookieDomain)
                        .path(ck.getString("path"))
                        .isSecure(ck.optBoolean("secure", false))
                        .build();
                getDriver().manage().addCookie(seleniumCookie);
            } else {
                System.out.println("Skipping cookie due to domain mismatch: " + cookieDomain);
            }
        }

        // Navigate to a protected page to validate authentication
        getDriver().navigate().to(Constants.URL_MAIN_WEB);

        // Optional: Print current URL for debugging
        System.out.println("Current URL after authentication: " + getDriver().getCurrentUrl());
        loginPage.pressBtnLoginInit();
        Thread.sleep(2500);
        loginPage.inputEmailLogin(email);
        loginPage.inputPasswordLogin(Constants.PASSWORD);
        Thread.sleep(3000);
        loginPage.pressSignIn();
        Thread.sleep(7000);
    }
}
