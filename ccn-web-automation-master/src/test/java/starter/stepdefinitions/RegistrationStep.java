package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.*;
import starter.utlis.Constants;

public class RegistrationStep {

    @Steps
    RegistrationPage registrationPage;

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
        registrationPage.pressSendVerificationCodeRegister();
        registrationPage.inputNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputConfirmNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputDisplayNameRegister(Constants.DISPLAY_NAME);
        registrationPage.inputContactNumberRegister("12345678"); //todo: fix the hardcoded
        registrationPage.selectCityRegister("SINGAPORE"); //todo: fix the hardcoded
        registrationPage.selectCountryRegister("Singapore"); //todo: fix the hardcoded

        //		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
        //		selectCityOnRegisterPage("KUALA LUMPUR"); //todo: fix the hardcoded
        //		selectCountryOnRegisterPage("Malaysia"); //todo: fix the hardcoded

        //		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
        //		selectCityOnRegisterPage("ABU DHABI"); //todo: fix the hardcoded
        //		selectCountryOnRegisterPage("United Arab Emirates"); //todo: fix the hardcoded

        //		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
        //		selectCityOnRegisterPage("COLOMBO"); //todo: fix the hardcoded
        //		selectCountryOnRegisterPage("Sri Lanka"); //todo: fix the hardcoded

        //		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
        //		selectCityOnRegisterPage("MIAMI"); //todo: fix the hardcoded
        //		selectCountryOnRegisterPage("United States"); //todo: fix the hardcoded

        //		inputContactNumberOnRegisterPage("12345678"); //todo: fix the hardcoded
        //		selectCityOnRegisterPage("JAKARTA"); //todo: fix the hardcoded
        //		selectCountryOnRegisterPage("Indonesia"); //todo: fix the hardcoded

        String registerWindow = subscriptionPage.getWindow();
        subscriptionPage.switchWindowTab();
        Thread.sleep(2000);
        goToUrl.goToAbsUrl(Constants.MAIL_SERVICE_URL);
        Thread.sleep(7000);
        mailServiceMailinatorPage.getVerificationCodesg();
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
        registrationPage.inputContactNumberRegister("12345678"); //todo: fix the hardcoded
        registrationPage.selectCityRegister("SINGAPORE"); //todo: fix the hardcoded
        registrationPage.selectCountryRegister("Singapore"); //todo: fix the hardcoded
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
        registrationPage.inputContactNumberRegister("12345678"); //todo: fix the hardcoded
        registrationPage.selectCityRegister("BEIJING"); //todo: fix the hardcoded
        registrationPage.selectCountryRegister("China"); //todo: fix the hardcoded
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
}
