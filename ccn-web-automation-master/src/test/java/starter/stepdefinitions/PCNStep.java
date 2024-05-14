package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.*;
import starter.utlis.Constants;

public class PCNStep {

    @Steps
    LoginPage loginPage;

    @Steps
    SubscriptionPage subscriptionPage;

    @Steps
    GoToUrl goToUrl;

    @Steps
    CompanyPage companyPage;
    @Steps
    RegistrationPage registrationPage;

    @Steps
    MailServiceYopmailPage mailServiceYopmailPage;

    private int waitResponse = 2000;
    private String originalWindow = "";

    @Given("go to main web")
    public void goToMainWeb() {
        loginPage.goToMainWeb();
    }

    @And("open subscriber payment form")
    public void openSubscriberPaymentForm() throws Exception {
        subscriptionPage.openCompleteFillSubscriberPayment();
    }

    @And("go to AWB IATA TEST PCN")
    public void goToAWBIATATESTPCN() throws InterruptedException {
        subscriptionPage.switchWindowTab();
        Thread.sleep(waitResponse);
        goToUrl.goToUrl(Constants.URL_IATA);
        Thread.sleep(waitResponse);
    }

    @When("press second sign in button with email {string} and password {string} plan C for AWB BC with {string}")
    public void pressSecondSignInButtonWithEmailAndPasswordPlanCForAWBBCWith(String email, String password, String plan) {
        loginPage.goToLoginPage();
        loginPage.changeSigninWindow();
        loginPage.loginCubeforall(email, password);
        subscriptionPage.switchWindowTab();
        loginPage.goToMainWeb();
        loginPage.pressBtnLoginInit();
        goToUrl.goToUrl(Constants.URL_AWB_BC);
        subscriptionPage.clickCheckComplimentarySubscribee();
        subscriptionPage.inputComplimentarySubscribee(plan);
        subscriptionPage.clickBtnComplimentarySubscribee();
        subscriptionPage.printCurrentUrl();
    }

    @And("go to AWB Concierge Premium PCN Test")
    public void goToAWBConciergePremiumPCNTest() {
        subscriptionPage.switchWindowTab();
        goToUrl.goToUrl(Constants.URL_AWB_CONCIERGE_PREMIUM);
    }

    @And("click subscriber payment form")
    public void clickSubscriberPaymentForm() throws Exception {
        subscriptionPage.clickbtncompleteformpaymentStripe();
    }

    @And("go to my icon account to Sign Out")
    public void goToMyIconAccountToSignOut() throws Exception {
        companyPage.clickMenuAccountFront();
    }

    @Given("press sign in button")
    public void pressSignInButton() {
        loginPage.pressBtnLoginInit();
        loginPage.changeSigninWindow();
    }

    @And("wait for response")
    public void waitForResponse() throws InterruptedException {
        Thread.sleep(7000);
    }

    @When("registration with new account from malaysia {string} and {string} login")
    public void registrationWithNewAccountFromMalaysiaAndLogin(String city, String country) throws Exception {
        String email = Constants.FULL_EMAIL_MY;
        registrationPage.pressSignUpNow();
        registrationPage.inputEmailRegister(email);
        registrationPage.pressSendVerificationCodeRegister();
        registrationPage.inputNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputConfirmNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputDisplayNameRegister(Constants.DISPLAY_NAME);
        registrationPage.inputContactNumberRegister(Constants.GENERATED_NUM);
        registrationPage.selectCityRegister(city);
        registrationPage.selectCountryRegister(country);
        String registerWindow = subscriptionPage.getWindow();
        subscriptionPage.switchWindowTab();
        Thread.sleep(2000);
        goToUrl.goToAbsUrl(Constants.YOPMAIL_SERVICE_URL);
        Thread.sleep(7000);
        mailServiceYopmailPage.getVerificationCodemy();
        Thread.sleep(7000);
        subscriptionPage.closeWindow();
        subscriptionPage.switchToWindow(registerWindow);
        registrationPage.inputVerificationCodeRegister(Constants.VERIFICATION_CODE);
        registrationPage.pressVerificationCodeRegister();
        Thread.sleep(7000);
        registrationPage.pressAgreetheTerm();
        Thread.sleep(7000);
        registrationPage.pressCreateAccountRegister();
        Thread.sleep(15000);
        subscriptionPage.switchToWindow(originalWindow);
        Constants.NEW_EMAIL_MY = email;
    }

    @Then("will redirected to suggested company list which match with domain name of the users")
    public void willRedirectedToSuggestedCompanyListWhichMatchWithDomainNameOfTheUsers() throws InterruptedException {
        companyPage.validateMatchWithDomainNameOfTheUsers();
    }

    @When("registration with new account from INDO {string} and {string} login")
    public void registrationWithNewAccountFromINDOAndLogin(String city, String country) throws Exception {
        registrationPage.pressSignUpNow();
        registrationPage.inputEmailRegister(Constants.FULL_EMAIL_INDO);
        registrationPage.pressSendVerificationCodeRegister();
        registrationPage.inputNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputConfirmNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputDisplayNameRegister(Constants.DISPLAY_NAME);
        registrationPage.inputContactNumberRegister(Constants.GENERATED_NUM);
        registrationPage.selectCityRegister(city);
        registrationPage.selectCountryRegister(country);
        String registerWindow = subscriptionPage.getWindow();
        subscriptionPage.switchWindowTab();
        Thread.sleep(2000);
        goToUrl.goToAbsUrl(Constants.YOPMAIL_SERVICE_URL);
        Thread.sleep(7000);
        mailServiceYopmailPage.getVerificationCodeina();
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

    @When("registration with new account from UAE {string} and {string} login")
    public void registrationWithNewAccountFromUAEAndLogin(String city, String country) throws Exception {
        registrationPage.pressSignUpNow();
        registrationPage.inputEmailRegister(Constants.FULL_EMAIL_UAE);
        registrationPage.pressSendVerificationCodeRegister();
        registrationPage.inputNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputConfirmNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputDisplayNameRegister(Constants.DISPLAY_NAME);
        registrationPage.inputContactNumberRegister(Constants.GENERATED_NUM);
        registrationPage.selectCityRegister(city);
        registrationPage.selectCountryRegister(country);
        String registerWindow = subscriptionPage.getWindow();
        subscriptionPage.switchWindowTab();
        Thread.sleep(2000);
        goToUrl.goToAbsUrl(Constants.YOPMAIL_SERVICE_URL);
        Thread.sleep(7000);
        mailServiceYopmailPage.getVerificationCodeUAE();
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

    @When("system didn't found the suggested company matched")
    public void systemDidnTFoundTheSuggestedCompanyMatched() throws InterruptedException {
        //		driver.get("https://sandbox.cubeforall.com/portal/manage-company/");
        //		driver.get("https://dev.cubeforall.com/portal/manage-company/");
        Thread.sleep(waitResponse);
        System.out.println(companyPage.companyListsTable());
    }

    @And("input company name {string} from {string} dynamics")
    public void inputCompanyNameFromDynamics(String companyName, String country) throws InterruptedException {
        Thread.sleep(waitResponse);
        String companyNameInput = country+" "+companyName+Constants.FOUR_DIGIT;
        registrationPage.inputCompanyNameRegister(companyNameInput);
    }

    @And("input company registration {string}")
    public void inputCompanyRegistration(String compRegNo) throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.inputCompanyRegNoOnMyCompany(compRegNo);
    }

    @And("input company type {string}")
    public void inputCompanyType(String compType) throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.selectCompanyType(compType);
    }

    @And("input country {string}")
    public void inputCountry(String country) throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.selectCountry(country);
    }

    @And("input city {string}")
    public void inputCity(String city) throws Exception {
        Thread.sleep(waitResponse);
        companyPage.selectCity(city);
    }

    @And("theres button to create company with the status was enabled to create company")
    public void theresButtonToCreateCompanyWithTheStatusWasEnabledToCreateCompany() throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.createNewCompany().isEnabled();
    }

    @Then("the user was able to create a new company")
    public void theUserWasAbleToCreateANewCompany() {
        companyPage.createNewCompany().isDisplayed();
    }

    @When("press create company button")
    public void pressCreateCompanyButton() throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.pressCreateNewCompany();
    }

    @And("input contact details IATA membership number {string}")
    public void inputContactDetailsIATAMembershipNumber(String iata) throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.inputIataMembershipNoSetupCompany(iata);
    }

    @And("input contact details CASS number {string}")
    public void inputContactDetailsCASSNumber(String cass) throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.inputCassNoSetupCompany(cass);
    }

    @And("input registered office address {string} for company detail")
    public void inputRegisteredOfficeAddressForCompanyDetail(String address) throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.inputAddress(address);
    }

    @And("input post code {string} for company detail")
    public void inputPostCodeForCompanyDetail(String postCode) throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.inputPostCode(postCode);
    }

    @And("input company email {string} for company detail")
    public void inputCompanyEmailForCompanyDetail(String companyemail) throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.inputCompanyEmailSetupCompanyDetails(companyemail);
    }
    
    @And("input mobile number detail company {string} for company detail")
    public void inputMobileNumberDetailCompanyForCompanyDetail(String mobile) throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.inputCompanyMobileNumberCompanyDetails(mobile);
    }

    @And("input mailing address complete from same as registered company address")
    public void inputMailingAddressCompleteFromSameAsRegisteredCompanyAddress() throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.clickCheckBoxRegisterSameMailing();
    }

    @And("input contact details name {string}")
    public void inputContactDetailsName(String name) throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.inputContactNameSetupCompany(name);
    }

    @And("input contact details designation {string}")
    public void inputContactDetailsDesignation(String designation) throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.inputDesignationSetupCompany(designation);
    }

    @And("input contact details mobile no {string}")
    public void inputContactDetailsMobileNo(String mobileNo) throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.inputMobileNoSetupCompany(mobileNo);
    }
    
    @And("input contact details email {string}")
    public void inputContactDetailsEmail(String email) throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.inputEmailSetupCompany(email);
    }

    @And("press submit create company")
    public void pressSubmitCreateCompany() throws Exception {
        Thread.sleep(waitResponse);
        companyPage.clickButtonSubmitCompany();
    }

    @When("registration with new account yopmail and login")
    public void registrationWithNewAccountYopmailAndLogin() throws Exception {
        registrationPage.pressSignUpNow();
        registrationPage.inputEmailRegister(Constants.FULL_MAIL);
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
        goToUrl.goToAbsUrl(Constants.YOPMAIL_SERVICE_URL);
        Thread.sleep(7000);
        mailServiceYopmailPage.getVerificationCodeGLB();
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

    @Then("will displayed pop up for post payment setup")
    public void willDisplayedPopUpForPostPaymentSetup() throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.setupNowModalDisplayed();
    }

    @And("click proceed pop up button for creating company to the post payment")
    public void clickProceedPopUpButtonForCreatingCompanyToThePostPayment() throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.clickbtnProceedConfirmationCreateCompany();
    }

    @And("click ok button from pop up confirmation that tells GIRO setup instructions has been sent to email")
    public void clickOkButtonFromPopUpConfirmationThatTellsGIROSetupInstructionsHasBeenSentToEmail() throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.clickbtnProceedConfirmationCreateCompany();
    }

    @Then("finally successfully to the setup post payment")
    public void finallySuccessfullyToTheSetupPostPayment() throws InterruptedException {
        Thread.sleep(waitResponse);
    }

    @And("receive email notification giro setup")
    public void receiveEmailNotificationGiroSetup() throws InterruptedException {
        Thread.sleep(waitResponse);
    }

    @When("registration with new account from NZ {string} and {string} login")
    public void registrationWithNewAccountFromNZAndLogin(String city, String country) throws Exception {
        registrationPage.pressSignUpNow();
        registrationPage.inputEmailRegister(Constants.FULL_EMAIL_NZ);
        registrationPage.pressSendVerificationCodeRegister();
        registrationPage.inputNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputConfirmNewPasswordRegister(Constants.PASSWORD);
        registrationPage.inputDisplayNameRegister(Constants.DISPLAY_NAME);
        registrationPage.inputContactNumberRegister(Constants.GENERATED_NUM);
        registrationPage.selectCityRegister(city);
        registrationPage.selectCountryRegister(country);
        String registerWindow = subscriptionPage.getWindow();
        subscriptionPage.switchWindowTab();
        Thread.sleep(2000);
        goToUrl.goToAbsUrl(Constants.YOPMAIL_SERVICE_URL);
        Thread.sleep(7000);
        mailServiceYopmailPage.getVerificationCodenz();
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

    @Then("press remove to reject the request")
    public void pressRemoveToRejectTheRequest() throws Exception {
        Thread.sleep(waitResponse);
        companyPage.pressRemovePerUserOnMemberByAdmin();
    }
}
