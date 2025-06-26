package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.GoToUrl;
import starter.pages.MailServiceYopmailPage;
import starter.pages.SQPPPage;
import starter.pages.SubscriptionPage;
import starter.utlis.Constants;

public class SQPPStep {

    @Steps
    SQPPPage sqppPage;

    @Steps
    SubscriptionPage subscriptionPage;

    @Steps
    GoToUrl goToUrl;

    @Steps
    MailServiceYopmailPage mailServiceYopmailPage;

    private int waitResponse = 3000;
    private String sqppwindows = "";
    private String originsqppwindows = "";
    private String emailSQPP = "";

    @Given("go to sqpp website")
    public void goToSqppWebsite() {
        sqppPage.goToSqppUrl();
    }

    @Given("click member login sqpp")
    public void clickMemberLoginSqpp() throws Exception {
        Thread.sleep(waitResponse);
        sqppPage.loginsqpp();
        Thread.sleep(waitResponse);
        sqppPage.changeSigninWindowsqpp();
    }

    @Given("input login sqpp email {string} and password {string}")
    public void inputLoginSqppEmailAndPassword(String email, String password) throws Exception {
        Thread.sleep(waitResponse);
        sqppPage.inputloginsqpp(email,password);
    }

    @Given("go to yopmail")
    public void goToYopmail() {
        subscriptionPage.switchWindowTab();
        goToUrl.goToAbsUrl(Constants.YOPMAIL_SERVICE_URL);
    }

    @When("enter yopmail email to login {string}")
    public void enterYopmailEmailToLogin(String email) throws Exception {
        mailServiceYopmailPage.loginYopmail(email);
        mailServiceYopmailPage.btnloginyopmail();
    }

    @When("open yopmail email {string}")
    public void openYopmailEmail(String content) throws Exception {
        //		mailServiceYopmailPage.selectemailtoopen();
        mailServiceYopmailPage.selectemailtoopendetail(content);
    }

    @When("get verification code sqpp")
    public void getVerificationCodeSqpp() throws InterruptedException {
        Thread.sleep(waitResponse);
        sqppPage.getVerificationCodesqpp();
        Thread.sleep(waitResponse);
        System.out.println(Constants.VERIFICATION_CODE_SQPP);
//		sqpp.changeSigninWindowsqpp();
    }

    @When("back to login page after get verification code sqpp")
    public void backToLoginPageAfterGetVerificationCodeSqpp() throws Exception {
        sqppwindows = sqppPage.sqppwindows;
        sqppPage.driverClose();
        System.out.println(sqppwindows);
        subscriptionPage.switchToWindow(sqppwindows);
        sqppPage.inputverifcodeaftergetfromemail();
    }

    @Then("continue sign in sqpp")
    public void continueSignInSqpp() throws Exception {
        sqppPage.continuesigninsqpp();
    }

    @When("click agent managament sqpp")
    public void clickAgentManagamentSqpp() throws InterruptedException {
        originsqppwindows = sqppPage.originsqppwindows;
        subscriptionPage.switchToWindow(originsqppwindows);
//		sqpp.iconmenusqpp();
        Thread.sleep(waitResponse);
        goToUrl.goToAbsUrl("https://ppd-siacargo.ccnexchange.com/portal_management/agent-management");
        Thread.sleep(waitResponse);
    }

    @Given("click sign up sqpp")
    public void clickSignUpSqpp() throws Exception {
        Thread.sleep(waitResponse);
        emailSQPP = Constants.FULL_EMAIL_SQPP;
        sqppPage.signupsqpp(emailSQPP);
    }

    @When("enter yopmail email to register")
    public void enterYopmailEmailToRegister() throws Exception {
        String email = emailSQPP;
        mailServiceYopmailPage.loginYopmail(email);
        mailServiceYopmailPage.btnloginyopmail();
    }

    @When("back to login page after get verification code sqpp registration {string} {string} {string}")
    public void backToLoginPageAfterGetVerificationCodeSqppRegistration(String arg0, String arg1, String arg2) {
        //TODO fill
    }

    @Then("continue sign up sqpp with agent code {string} and country from {string} and city from {string}")
    public void continueSignUpSqppWithAgentCodeAndCountryFromAndCityFrom(String arg0, String arg1, String arg2) {
        //TODO fill
    }

}
