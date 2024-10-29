package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import starter.pages.*;
import starter.utlis.Constants;

public class SubscribeStep {

    @Steps
    SubscriptionPage subscriptionPage;

    @Steps
    CompanyPage companyPage;

    @Steps
    GoToUrl goToUrl;

    @Steps
    LoginPage loginPage;

    @Steps
    MailServiceMailinatorPage mailServiceMailinatorPage;

    private long medwaitResponse = 5000;
    private String registerWindow = "";

    @And("Subscribe plan {string}")
    public void subscribePlan(String product) throws Exception {
        subscriptionPage.subscribeplan(product);
    }

    @Then("verify the pop up GHA validation message")
    public void verify_the_pop_up_message_GHA_validation(){
        companyPage.verifyGHAValidationMessage();
    }

    @And("Subscribe plan {string} and input coupon {string}")
    public void subscribePlan(String product, String coupon) throws Exception {
        subscriptionPage.subscribeCoupon(product, coupon);
    }

    @And("go to my icon account menu {string}")
    public void goToMyIconAccountMenu(String menu) throws Exception {
        companyPage.myMenuAccount(menu);
    }

    @And("Press Subscribe checkbox for the Bundle LFS BC Company Level plan complimentary subscription agreement")
    public void pressSubscribeCheckboxForTheBundleLFSBCCompanyLevelPlanComplimentarySubscriptionAgreement() throws Exception {
        subscriptionPage.clickchckBoxComplimentarySubscribebcnoncompany();
    }

    @And("input number of member for product Bundle AWB, BC Non Company")
    public void inputNumberOfMemberForProductBundleAWBBCNonCompany() throws Exception {
        subscriptionPage.inputComplimentarySubsribebcnoncompany();
    }

    @And("Press Subscribe button for the Bundle LFS BC Company Level plan complimentary subscription")
    public void pressSubscribeButtonForTheBundleLFSBCCompanyLevelPlanComplimentarySubscription() throws Exception {
        subscriptionPage.clickBtnComplimentarySubsribebcnoncompany();
    }

    @And("input checkout payment cardNumber form")
    public void inputCheckoutPaymentCardNumberForm() throws Exception {
        subscriptionPage.enterInputCardNumber();
    }

    @And("input checkout payment cardExpiry form")
    public void inputCheckoutPaymentCardExpiryForm() throws Exception {
        subscriptionPage.enterinputcardExpiryformpayment();
    }

    @And("input checkout payment cardCvc form")
    public void inputCheckoutPaymentCardCvcForm() throws Exception {
        subscriptionPage.enterinputVcaCardNumberformpayment();
    }

    @And("input checkout payment billingName form")
    public void inputCheckoutPaymentBillingNameForm() throws Exception {
        subscriptionPage.enterinputFullNameCardNumberformpayment();
    }

    @Then("submit checkout payment")
    public void submitCheckoutPayment() throws Exception {
        subscriptionPage.clickbtncompleteformpaymentStripe();
    }

    @And("select checkout payment country")
    public void selectCheckoutPaymentCountry() {
        //TODO fill
    }

    @And("click checkbox Securely save my information for {int}-click checkout")
    public void clickCheckboxSecurelySaveMyInformationForClickCheckout(int arg0) throws Exception {
        subscriptionPage.clickenableStripePass();
    }

    @Then("Validate subscription Successful for plan {string} {string} pop up massage")
    public void validateSubscriptionSuccessfulForPlanPopUpMassage(String arg0, String arg1) throws Exception {
        //		subscriptionPage.clickBtnConfirmComplimentarySubsribelfsfreetrial();
        subscriptionPage.clickBtnConfirmComplimentarySubsribebcnoncompany();
    }

    @And("Validate country {string} csm geolocation")
    public void validateCountryCsmGeolocation(String arg0) {
        //TODO fill
    }

    @And("open email mailinator after login")
    public void openEmailMailinatorAfterLogin() throws InterruptedException {
        Thread.sleep(medwaitResponse);
        registerWindow = subscriptionPage.getWindow();
        subscriptionPage.switchWindowTab();
        Thread.sleep(2000);
        goToUrl.goToAbsUrl(Constants.MAIL_SERVICE_URL);
        mailServiceMailinatorPage.getVerificationCodelogin();
        //		mailServiceMailinatorPage.getVerificationCode("qa-ccn-04346@mailinator.com");
    }

    @And("UnSubscribe plan {string}")
    public void unsubscribePlan(String plan) {
        subscriptionPage.unsubscribePlan(plan);
    }

    @And("input the complete subscriber payment form")
    public void inputTheCompleteSubscriberPaymentForm() throws Exception {
        subscriptionPage.inputCompleteFillSubscriberPayment();
    }

    @And("Subscribe first plan {string}")
    public void subscribeFirstPlan(String product) throws Exception {
        subscriptionPage.subscribeplan(product);
    }

    @And("back to Cubforall from payment page")
    public void backToCubforallFromPaymentPage() throws Exception {
        subscriptionPage.backtoCubeforallfrompayment();
    }

    @Given("{string} click product tab to subscribe a product")
    public void clickProductTabToSubscribeAProduct(String arg0) throws Exception {
        subscriptionPage.clickProductTabFromManageSubscribtion();
    }

    @And("Select second plan {string} {string}")
    public void selectSecondPlan(String arg0, String productB) throws Exception {
        subscriptionPage.selectPlanProduct(productB);
    }

    @When("click product tab to subscribe to product")
    public void clickProductTabToSubscribeToProduct() {
        subscriptionPage.clickProductTab();
    }

    @And("select bundle company level awb concierge lfs product")
    public void selectBundleCompanyLevelAwbConciergeLfsProduct() {
        subscriptionPage.clickProductbundlecompanylevelaWBConciergeLFS();
    }

    @And("validate product price for tier {int} and tier {int}")
    public void validateProductPriceForTierAndTier(int arg0, int arg1) throws Exception {
        subscriptionPage.clickchckBoxComplimentarySubscribebccompany();
        subscriptionPage.inputComplimentarySubsribebccompany();
        subscriptionPage.clickBtnComplimentarySubsribebccompany();
    }

    @And("Press Subscribe checkbox for the free trial plan complimentary subscription agreement")
    public void pressSubscribeCheckboxForTheFreeTrialPlanComplimentarySubscriptionAgreement() throws Exception {
        subscriptionPage.clickchckBoxComplimentarySubscribelfsfreetrial();
    }

    @And("Press Subscribe button for the free trial plan complimentary subscription")
    public void pressSubscribeButtonForTheFreeTrialPlanComplimentarySubscription() throws Exception {
        subscriptionPage.clickBtnComplimentarySubsribelfsfreetrial();
    }

    @And("go to my icon account menuu {string}")
    public void goToMyIconAccountMenuu(String menu) throws Exception {
        Thread.sleep(medwaitResponse);
        companyPage.myMenuAccount(menu);
    }

    @Then("{string} was already subscribe the free trial plan {string} {string}")
    public void wasAlreadySubscribeTheFreeTrialPlan(String arg0, String arg1, String product) throws Exception {
        Boolean result =subscriptionPage.verifytableProductSubscription(product);
        Assert.assertEquals(true, result);
    }

    @And("Remove {string} {string} subscription")
    public void removeSubscription(String arg0, String product) throws Exception {
        subscriptionPage.clickRemoveSubscription(product);
    }

    @And("the subscription will expired with {string} status for {string}")
    public void theSubscriptionWillExpiredWithStatusFor(String status, String product) throws Exception {
        Boolean result =subscriptionPage.verifytableStatusSubscription(product, status);
        Assert.assertEquals(true, result);
    }

    @And("validate {string} {string} has been remove from container application")
    public void validateHasBeenRemoveFromContainerApplication(String arg0, String arg1) {
        //TODO fill
    }

    @And("Validate active periode from {string} to {string} for {string}")
    public void validateActivePeriodeFromToFor(String string, String string2, String product) throws Exception {
        Boolean result = subscriptionPage.verifytableBcycleSubscription(product, string, string2);
        Assert.assertEquals(true, result);
    }

    @Given("User with {string} and password {string} login to the web")
    public void userWithAndPasswordLoginToTheWeb(String email, String password) throws InterruptedException {
        loginPage.login(email, password);
    }
}
