package starter.stepdefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.api.PaymentDelegation;
import starter.api.PaymentOverview;
import starter.api.StandingInstruction;
import starter.utlis.ApiProperties;

import java.io.IOException;
import java.util.List;

public class PaymentOverviewSteps {

    @Steps
    PaymentOverview paymentOverview;

    @Steps
    StandingInstruction standingInstruction;

    @Steps
    PaymentDelegation paymentDelegation;

    private List<String> payIds = null;
    private String suppId, suppName, productId, productName, cardToken, companyEmail, delegationId, payId;

    @When("user view detail of my payment with status: {string}")
    public void userViewDetailOfMyPaymentWithStatus(String status) {
        paymentOverview.retrievePaymentOverview("MY_PAYMENT", status);
        payIds = paymentOverview.payIds(0, 1);
    }

    @Then("payment detail page with selected id appears")
    public void paymentDetailPageWithSelectedIdAppears() {
        paymentOverview.retrievePaymentRequest(payIds);
        paymentOverview.verifySelectedPaymentAppears(payIds);
    }

    @Given("user login as card admin or card user or user")
    public void userLoginAsCardAdminOrCardUserOrUser() throws IOException {
        paymentOverview.setToken(1);
    }

    @Given("user login as card admin or card user")
    public void userLoginAsCardAdminOrCardUser() throws IOException {
        paymentOverview.setToken(1);
    }

    @And("there is SI for service A in the company")
    public void thereIsSIForServiceAInTheCompany() throws IOException {
        standingInstruction.setToken(1);
        if (!standingInstruction.thereIsSI()){
            paymentDelegation.setToken(1);
            paymentDelegation.getAllSupplier();
            suppId = paymentDelegation.supplierId(0);
            productId = paymentDelegation.productId(0);
            suppName = paymentDelegation.supplierName(0);
            productName = paymentDelegation.productName(0);

            standingInstruction.retrieveCompanyIdentities();
            companyEmail = standingInstruction.companyEmail(0);

            standingInstruction.retrieveCardToken();
            cardToken = standingInstruction.cardToken();

            standingInstruction.createStandingInstruction(productId, productName, suppId, suppName, cardToken, "MY_PAYMENT", companyEmail, 200);
        }
    }

    @When("there is payment for service A")
    public void thereIsPaymentForServiceA() {
        paymentOverview.createPaymentRequest(200);
    }

    @Then("payment for service A of company will be auto-deducted")
    public void paymentForServiceAOfCompanyWillBeAutoDeducted() {
        paymentOverview.retrievePaymentOverview("MY_PAYMENT");
        paymentOverview.verifySuccessAutoDeduct();
    }

    @And("payment status changes to Paid")
    public void paymentStatusChangesToPaid() {
        paymentOverview.verifyPaymentStatus("PAID");
    }

    @And("there is Outstanding or Upcoming payment request of service A")
    public void thereIsOutstandingOrUpcomingPaymentRequestOfServiceA() {
        paymentOverview.createPaymentRequest(200);
    }

    @And("there is no Active payment delegation for service A")
    public void thereIsNoActivePaymentDelegationForServiceA() throws IOException {
        paymentDelegation.setToken(1);
        paymentDelegation.retrievePaymentDelegationSetting();
        delegationId = paymentDelegation.paymentDelegationId(0);
        if (!paymentDelegation.thereIsNoDelegationSetting()){
            paymentDelegation.deletePaymentDelegation(delegationId, 200);
        }
    }

    @When("user delegate the specific payment request to company X")
    public void userDelegateTheSpecificPaymentRequestToCompanyX() {
        paymentOverview.createPaymentRequest(200);
        payId = paymentOverview.payIds(0, 1).get(0);
        paymentOverview.delegatePaymentRequest(payId, ApiProperties.emailCompany2());
    }

    @Then("the payment will be delegated to company X \\(will appears in the Received Payment menu)")
    public void thePaymentWillBeDelegatedToCompanyXWillAppearsInTheReceivedPaymentMenu() {
        paymentOverview.verifyDelegateToCompany();
    }

    @And("company X able to pay the payment")
    public void companyXAbleToPayThePayment() throws IOException {
        paymentOverview.setToken(2);
        paymentOverview.retrievePaymentOverview("RECEIVED_PAYMENT");
        paymentOverview.verifyPaymentIdAppears(payId);
    }
}
