package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import starter.pages.CompanyPage;
import starter.pages.LoginPage;
import starter.pages.PaymentOverviewPage;

public class PaymentOverviewStepdefs {

    @Steps
    LoginPage loginPage;

    @Steps
    CompanyPage companyPage;

    @Steps
    PaymentOverviewPage paymentOverviewPage;
    private int waitResponse = 5000;
    private int waitLongResponse = 10000;

    @When("User go to {string}")
    public void gotoPaymentOverview(String menu) throws Exception {
        //type of user is not affect this step, so being ignored
        companyPage.myMenuAccount(menu);
    }

    @When("verify field to be display on my payment")
    public void verify_field_to_be_display_on_my_payment() throws Exception {
        Thread.sleep(3000);
        Assert.assertTrue(paymentOverviewPage.referenceIsDisplayed());
        Assert.assertTrue(paymentOverviewPage.requestDateIsDisplayed());
        Assert.assertTrue(paymentOverviewPage.supplierIsDisplayed());
        Assert.assertTrue(paymentOverviewPage.referenceIsDisplayed());
        Assert.assertTrue(paymentOverviewPage.lastUpdatedIsDisplayed());
        Assert.assertTrue(paymentOverviewPage.paymentMethodIsDisplayed());
        Assert.assertTrue(paymentOverviewPage.paymentByIsDisplayed());
        Assert.assertTrue(paymentOverviewPage.totalIsDisplayed());
        Assert.assertTrue(paymentOverviewPage.statusIsDisplayed());
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
        paymentOverviewPage.createPaymentRequest();
    }
    @Given("user create credit term payment request")
    public void user_create_credit_term_payment_request() throws Exception {
        paymentOverviewPage.createCreditTermPaymentRequest();
    }

    @Given("user create {string} payment request with {string}")
    public void user_create_string_payment_request_with(String status, String paymentRequestId) throws Exception {
        paymentOverviewPage.updatePaymentRequest(status, paymentRequestId);
    }

}
