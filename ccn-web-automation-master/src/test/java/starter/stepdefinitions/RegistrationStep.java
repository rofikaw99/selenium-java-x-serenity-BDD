package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.Cookie;
import starter.pages.*;
import starter.registerv2.api.CreateRegisterV2;
import starter.registerv2.api.GetRegisteredAllUsersV2;
import starter.registerv2.api.GetRegisteredByMailV2;
import starter.registerv2.api.PUTIdentityLINC;
import starter.utlis.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import static net.serenitybdd.core.Serenity.getDriver;

public class RegistrationStep {

    @Steps
    RegistrationPage registrationPage;

    @Steps
    CreateRegisterV2 createRegisterV2;

    @Steps
    GetRegisteredByMailV2 getRegisteredByMailV2Page;

    @Steps
    PUTIdentityLINC pUTIdentityLINCPage;

    @Steps
    GetRegisteredAllUsersV2 getRegisteredAllUsersV2Steps;

    @Steps
    SubscriptionPage subscriptionPage;

    @Steps
    MailServiceMailinatorPage mailServiceMailinatorPage;

    @Steps
    MailServiceYopmailPage mailServiceYopmailPage;

    @Steps
    GoToUrl goToUrl;

    private String originalWindow = "";

    @When("registration with new account and login")
    public void registrationWithNewAccountAndLogin() throws Exception {
        registrationPage.pressSignUpNow();
        registrationPage.inputEmailRegister(Constants.FULL_EMAIL);
        System.out.println(Constants.FULL_EMAIL);
        registrationPage.pressSendVerificationCodeRegister();
        registrationPage.inputNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputConfirmNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputDisplayNameRegister(Constants.DISPLAY_NAME);
        registrationPage.inputContactNumberRegister("12345678"); 
        registrationPage.selectCityRegister("SINGAPORE"); 
        registrationPage.selectCountryRegister("Singapore"); 

        //		inputContactNumberOnRegisterPage("12345678"); 
        //		selectCityOnRegisterPage("KUALA LUMPUR"); 
        //		selectCountryOnRegisterPage("Malaysia"); 

        //		inputContactNumberOnRegisterPage("12345678"); 
        //		selectCityOnRegisterPage("ABU DHABI"); 
        //		selectCountryOnRegisterPage("United Arab Emirates"); 

        //		inputContactNumberOnRegisterPage("12345678"); 
        //		selectCityOnRegisterPage("COLOMBO"); 
        //		selectCountryOnRegisterPage("Sri Lanka"); 

        //		inputContactNumberOnRegisterPage("12345678"); 
        //		selectCityOnRegisterPage("MIAMI"); 
        //		selectCountryOnRegisterPage("United States"); 

        //		inputContactNumberOnRegisterPage("12345678"); 
        //		selectCityOnRegisterPage("JAKARTA"); 
        //		selectCountryOnRegisterPage("Indonesia"); 

        String registerWindow = subscriptionPage.getWindow();
        subscriptionPage.switchWindowTab();
        Thread.sleep(2000);
        goToUrl.goToAbsUrl(Constants.MAIL_SERVICE_URL);
        Thread.sleep(7000);
        mailServiceMailinatorPage.getVerificationCodeGlobalCustoms();
        Thread.sleep(3000);
        subscriptionPage.closeWindow();
        subscriptionPage.switchToWindow(registerWindow);
        registrationPage.inputVerificationCodeRegister(Constants.VERIFICATION_CODE);
        registrationPage.pressVerificationCodeRegister();
        Thread.sleep(7000);
        registrationPage.pressAgreetheTerm();
        Thread.sleep(7000);
        registrationPage.pressCreateAccountRegister();
        subscriptionPage.switchToWindow(originalWindow);

    }
    @Given("send email from {string} with keyword {string} along with attachment to another company CUBE {string} and cc to {string}")
    public void send_email_from_with_keyword_along_with_attachment_to_another_company_CUBE(String senderMail, String keyword, String recipientMail, String ccMail) throws Exception {
        goToUrl.goToAbsUrl(Constants.YOPMAIL_SERVICE_URL);
        Thread.sleep(1000);
        mailServiceYopmailPage.emailExchangeSender();
    }

    @Given("retrieve {string} emails from the mailbox")
    public void retrieve_emails_from_the_mailbox(String recipientMail) throws Exception {
        goToUrl.goToAbsUrl(Constants.YOPMAIL_SERVICE_URL);
        Thread.sleep(1000);
        mailServiceYopmailPage.emailExchangeRecipient(recipientMail);
    }
    @And("registration with new account and try login")
    public void registrationWithNewAccountAndTryLogin() throws Exception {
        registrationPage.pressSignUpNow();
        registrationPage.inputEmailRegister(Constants.FULL_EMAIL);
        registrationPage.pressSendVerificationCodeRegister();
        registrationPage.inputNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputConfirmNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputDisplayNameRegister(Constants.DISPLAY_NAME);
        registrationPage.inputContactNumberRegister("12345678"); 
        registrationPage.selectCityRegister("SINGAPORE"); 
        registrationPage.selectCountryRegister("Singapore"); 
        String registerWindow = subscriptionPage.getWindow();
        subscriptionPage.switchWindowTab();
        Thread.sleep(2000);
        goToUrl.goToAbsUrl(Constants.MAIL_SERVICE_URL);
        Thread.sleep(7000);
        mailServiceMailinatorPage.getVerificationCode();
        Thread.sleep(7000);
        subscriptionPage.closeWindow();
        subscriptionPage.switchToWindow(registerWindow);
        registrationPage.inputVerificationCodeRegister(Constants.VERIFICATION_CODE);
        registrationPage.pressVerificationCodeRegister();
        Thread.sleep(7000);
        registrationPage.pressAgreetheTerm();
        Thread.sleep(7000);
        registrationPage.pressCreateAccountRegister();
        subscriptionPage.switchToWindow(originalWindow);
    }

    @And("registration with new account and try login china")
    public void registrationWithNewAccountAndTryLoginChina() throws Exception {
        registrationPage.pressSignUpNow();
        registrationPage.inputEmailRegister(Constants.FULL_EMAIL_CH);
        registrationPage.pressSendVerificationCodeRegister();
        registrationPage.inputNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputConfirmNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputDisplayNameRegister(Constants.DISPLAY_NAME);
        registrationPage.inputContactNumberRegister("12345678"); 
        registrationPage.selectCityRegister("BEIJING"); 
        registrationPage.selectCountryRegister("China"); 
        String registerWindow = subscriptionPage.getWindow();
        subscriptionPage.switchWindowTab();
        Thread.sleep(2000);
        goToUrl.goToAbsUrl(Constants.MAIL_SERVICE_URL);
        Thread.sleep(7000);
        mailServiceMailinatorPage.getVerificationCodech();
        Thread.sleep(7000);
        subscriptionPage.closeWindow();
        subscriptionPage.switchToWindow(registerWindow);
        registrationPage.inputVerificationCodeRegister(Constants.VERIFICATION_CODE);
        registrationPage.pressVerificationCodeRegister();
        Thread.sleep(7000);
        registrationPage.pressAgreetheTerm();
        Thread.sleep(7000);
        registrationPage.pressCreateAccountRegister();
        subscriptionPage.switchToWindow(originalWindow);
    }

    @When("press sign up now button")
    public void pressSignUpNowButton() throws InterruptedException {
        registrationPage.pressSignUpNow();
    }

    @And("input email address on register page")
    public void inputEmailAddressOnRegisterPage() {
        registrationPage.inputEmailRegister(Constants.FULL_EMAIL);
    }

    @And("press send verification code")
    public void pressSendVerificationCode() {
        registrationPage.pressSendVerificationCodeRegister();
    }

    @And("input password & confirm password on register page")
    public void inputPasswordConfirmPasswordOnRegisterPage() {
        registrationPage.inputNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputConfirmNewPasswordRegister(Constants.PASSWORD);
    }

    @And("input display name {string} on register page")
    public void inputDisplayNameOnRegisterPage(String displayName) {
        registrationPage.inputDisplayNameRegister(displayName);
    }

    @And("input contact number {string} on register page")
    public void inputContactNumberOnRegisterPage(String contactNumber) {
        registrationPage.inputContactNumberRegister(contactNumber);
    }

    @And("select country {string} on register page")
    public void selectCountryOnRegisterPage(String country) {
        registrationPage.selectCountryRegister(country);
    }

    @And("Open new tab and open mailinator")
    public void openNewTabAndOpenMailinator() throws InterruptedException {
        originalWindow = subscriptionPage.getWindow();
        subscriptionPage.switchWindowTab();
        Thread.sleep(2000);
        goToUrl.goToAbsUrl(Constants.MAIL_SERVICE_URL);
        Thread.sleep(7000);
    }

    @And("get the email verification and extract the verification code")
    public void getTheEmailVerificationAndExtractTheVerificationCode() throws InterruptedException {
        mailServiceMailinatorPage.getVerificationCodech();
        Thread.sleep(7000);
    }

    @And("close tab and back to register page")
    public void closeTabAndBackToRegisterPage() {
        subscriptionPage.closeWindow();
        subscriptionPage.switchToWindow(originalWindow);
    }

    @And("input verification code on register page")
    public void inputVerificationCodeOnRegisterPage() {
        registrationPage.inputVerificationCodeRegister(Constants.VERIFICATION_CODE);
    }

    @And("press verification code button on register page")
    public void pressVerificationCodeButtonOnRegisterPage() {
        registrationPage.pressVerificationCodeRegister();
    }

    @And("press create account on register page")
    public void pressCreateAccountOnRegisterPage() throws Exception {
        registrationPage.pressCreateAccountRegister();
    }

    @And("select city {string} on register page")
    public void selectCityOnRegisterPage(String city) {
        registrationPage.selectCityRegister(city);
    }

    @And("get response {string}")
    public void getSuccessReturnStatusAPI(String responseCode) {
        registrationPage.getResponseCode(responseCode);
    }
    @And("get validation response that the email that email already registered")
    public void getValidationResponseMessageForAlreadyRegisteredEmail() {
        createRegisterV2.getValidationResponseMessageForAlreadyRegisteredEmail();
    }
    @And("user want to register multiple mail to cube with multiple mail {string} {string} input")
    public void ggivenUserWantsToRegisterMultipleEmails(String mail1, String mail2) {
        createRegisterV2.givenUserWantsToRegisterMultipleEmails(mail1, mail2);
    }
    @And("send the request for register multiple mail to cube with multiple mail input {string} {string}")
    public void whenSendRequestForMultipleEmails(String mail1, String mail2) {
        createRegisterV2.whenSendRequestForMultipleEmails(mail1, mail2);
    }
    @And("user want to register new mail to cube with {string} input")
    public void userWantRegisterNewMailCubeMailInput(String mail) {
        createRegisterV2.givenUserWantsToRegister(mail);
    }
    @And("user want to register existing mail to cube with {string} input")
    public void userWantRegisterNewMailCubeMailInput2(String mail) {
        createRegisterV2.givenUserWantsToRegister(mail);
    }
    @And("send the request with {string} input")
    public void sendReqUserWantRegisterNewMailCubeMailInput(String mail) {
        createRegisterV2.whenSendRequestWithEmail(mail);
    }
    @Given("user want to get register by {string}")
    public void userWantGetRegisterBy(String param) {
        getRegisteredByMailV2Page.user_want_to_get_register_by(param);
    }

    @When("send the request to get register by cube ID")
    public void sendTheRequestGetRegisterByCubeID() {
        getRegisteredByMailV2Page.send_the_request_by_cubeID();
    }
    @And("get response email and status")
    public void getResponseEmailAndStatus() {
        getRegisteredByMailV2Page.get_email_and_status_response();
    }
    @And("get box url and site response")
    public void getBoxUrlAndSiteResponse() {
        getRegisteredByMailV2Page.get_box_url_and_site_response();
    }
    @When("send the request to get register by mail")
    public void sendTheRequestGetRegisterByEmail() {
        getRegisteredByMailV2Page.send_the_request_by_email();
    }
    @Given("user want to get all registered user V2")
    public void userWantGetAllRegisteredUser() {
        getRegisteredAllUsersV2Steps.user_want_to_get_all_registered_user();
    }
    @Given("send the get all registered user V2 request")
    public void send_the_get_all_registered_user_V2_request() {
        getRegisteredAllUsersV2Steps.send_the_request();
    }
    @And("get response all register mail and cubeID")
    public void get_response_all_register_mail_and_cubeID() {
        getRegisteredAllUsersV2Steps.get_response_all_register_mail_and_cubeID();
    }
    @And("get response body cubeID, email, and status")
    public void get_response_body_cubeID_email_and_status() {
        getRegisteredAllUsersV2Steps.get_response_body_cubeID_email_and_status();
    }
    @Given("user want to put Identity LINC with input some required data")
    public void userWantPutIdentityLINCwithInputSomeRequiredData() {
        pUTIdentityLINCPage.user_wants_to_put_identity_linc_with_input_some_required_data();
    }
    @And("get response body value message and log id")
    public void getResponseBodyValueMessageLogId() {
        PUTIdentityLINC.get_response_body_value_message_and_log_id();
    }

    @Given("go to main web with PlayWright session token")
    public void goToMainWebWithPlayWrightSessionToken() throws IOException {
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
        getDriver().get("https://sandbox.cubeforall.com");

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
        getDriver().navigate().to("https://sandbox.cubeforall.com/");

        // Optional: Print current URL for debugging
        System.out.println("Current URL after authentication: " + getDriver().getCurrentUrl());
    }
}
