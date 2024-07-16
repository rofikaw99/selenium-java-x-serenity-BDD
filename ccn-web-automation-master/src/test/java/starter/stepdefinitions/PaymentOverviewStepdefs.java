package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import starter.pages.*;
import starter.utlis.Constants;

public class PaymentOverviewStepdefs {

    @Steps
    LoginPage loginPage;

    @Steps
    GoToUrl goToUrl;

    @Steps
    MailServiceYopmailPage mailServiceYopmailPage;

    @Steps
    CompanyPage companyPage;

    @Steps
    PaymentOverviewPage paymentOverviewPage;

    @Steps
    SubscriptionPage subscriptionPage;

    private int waitResponse = 5000;
    private int waitLongResponse = 10000;

    @When("User go to {string}")
    public void gotoPaymentOverview(String menu) throws Exception {
        //type of user is not affect this step, so being ignored
        companyPage.myMenuAccount(menu);
    }

    @Then("User go to {string} to verify that the non SG can't access payment module")
    public void gotoPayment(String menu) throws Exception {
        //type of user is not affect this step, so being ignored
        companyPage.myMenuAccountNotAvailable(menu);
    }

    @When("verify field to be display on my payment")
    public void verify_field_to_be_display_on_my_payment() throws Exception {
        Thread.sleep(4000);
        Assert.assertTrue(paymentOverviewPage.referenceIsDisplayed());
        Assert.assertTrue(paymentOverviewPage.supplierIsDisplayed());
        Assert.assertTrue(paymentOverviewPage.paymentMethodIsDisplayed());
        Assert.assertTrue(paymentOverviewPage.totalIsDisplayed());
        Assert.assertTrue(paymentOverviewPage.statusIsDisplayed());
    }

    @When("verify field to be display that payment request not display")
    public void verify_field_to_be_display_on_the_another_company() throws Exception {
        Thread.sleep(4000);
        Assert.assertTrue(paymentOverviewPage.noDataFound());
    }

    @When("input filter keyword {string}")
    public void input_filter_keyword(String keyword) throws Exception {
        paymentOverviewPage.inputKeyword(keyword);
        Thread.sleep(5000);
    }

    @When("user find the payment that already created with {string}")
    public void user_find_the_payment_that_already_created_with(String keyword) throws Exception {
        paymentOverviewPage.findPayment(keyword);
        Thread.sleep(waitResponse);
    }

    @When("verify outstanding status color code is correct")
    public void verify_outstanding_status_color_code_is_correct() throws Exception {
        paymentOverviewPage.verifyOutstandingColorCode();
    }

    @When("verify paid status color code is correct")
    public void verify_paid_status_color_code_is_correct() throws Exception {
        paymentOverviewPage.verifyPaidColorCode();
    }

    @When("verify expired status color code is correct")
    public void verify_expired_status_color_code_is_correct() throws Exception {
        paymentOverviewPage.verifyExpiredColorCode();
    }

    @Then("verify cancelled status color code is correct")
    public void verify_cancelled_status_color_code_is_correct() throws Exception {
        paymentOverviewPage.verifyCancelledColorCode();
    }

    @When("verify upcoming status color code is correct")
    public void verify_upcoming_status_color_code_is_correct() throws Exception {
        paymentOverviewPage.verifyUpcomingColorCode();
    }

    @When("verify button checkout enable to click")
    public void verify_button_checkout_enable_to_click() throws Exception {
        paymentOverviewPage.verifyAndClickCheckoutButton();
        Thread.sleep(13000);
    }

    @When("user click checkbox bulk outstanding")
    public void user_click_checkbox_bulk_outstanding() throws Exception {
        paymentOverviewPage.bulkOutstanding();
    }

    @When("user click checkbox bulk checkout")
    public void user_click_checkbox_bulk_checkout() throws Exception {
        paymentOverviewPage.bulkCheckout();
        Thread.sleep(waitResponse);
    }

    @When("user click pay after checkout")
    public void user_click_pay_after_checkout() throws Exception {
        Thread.sleep(waitResponse);
        paymentOverviewPage.payCheckoutButton();
        Thread.sleep(waitResponse);
    }

    @When("download the report")
    public void download_report() throws Exception {
        paymentOverviewPage.downloadReportButton();
        Thread.sleep(waitResponse);
    }

    @When("user click pay for CC after checkout")
    public void user_click_pay_for_CC_after_checkout() throws Exception {
        Thread.sleep(waitResponse);
        paymentOverviewPage.payForCCCheckoutButton();
        Thread.sleep(waitResponse);
    }

    @When("user pay with payNow")
    public void user_pay_with_payNow() throws Exception {
        paymentOverviewPage.payNow();
        Thread.sleep(waitResponse);
    }

    @When("user pay with CC")
    public void user_pay_with_CC() throws Exception {
        paymentOverviewPage.payCC();
        Thread.sleep(waitResponse);
    }

    @When("verify button checkout unable to click")
    public void verify_button_checkout_unable_to_click() throws Exception {
        paymentOverviewPage.checkoutUnable();
        Thread.sleep(waitResponse);
    }

    @When("go to the payment detail")
    public void go_to_the_payment_detail() throws Exception {
        paymentOverviewPage.goToPaymentDetail();
        Thread.sleep(waitResponse);
    }

    @When("verify payment detail information")
    public void verify_payment_detail_information() throws Exception {
        paymentOverviewPage.paymentDetailInfo();
        Thread.sleep(waitResponse);
    }

    @When("select filter page {string}")
    public void select_filter_page(String page) throws Exception {
        companyPage.page(page);
    }


    @Given("user get SSO token")
    public void user_get_SSO_token() throws Exception {
        PaymentOverviewPage.fetchAccessToken();
    }

    @Given("user create upcoming payment request")
    public void user_create_upcoming_payment_request() throws Exception {
        paymentOverviewPage.createPaymentRequestAPI();
    }

    @And("update to outstanding to trigger notification")
    public void update_to_outstanding_to_trigger_notification() throws Exception {
        paymentOverviewPage.createCreditTermPaymentRequestToGetNotification();
    }

    @And("create payment but fail")
    public void create_payment_but_fail() throws Exception {
        paymentOverviewPage.createCreditTermPaymentRequestToGetNotification();
    }

    @Then("get triggered {string} notification")
    public void get_triggered_email_notification(String email) throws Exception {
        goToUrl.goToAbsUrl(Constants.YOPMAIL_SERVICE_URL);
        Thread.sleep(1000);
        mailServiceYopmailPage.getPaymentNotification(email);
        Thread.sleep(5000);
    }
    @Given("user create credit term payment request")
    public void user_create_credit_term_payment_request() throws Exception {
        paymentOverviewPage.createCreditTermPaymentRequest();
    }

    @Given("user create {string} payment request with {string}")
    public void user_create_string_payment_request_with(String status, String paymentRequestId) throws Exception {
        paymentOverviewPage.updatePaymentRequest(status, paymentRequestId);
    }

    @And("update payment request to {string}")
    public void update_payment_request_to(String status) throws Exception {
        paymentOverviewPage.updatePaymentRequestToNotify(status);
    }

}
