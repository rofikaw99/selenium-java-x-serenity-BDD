package starter.stepdefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.api.PaymentDelegation;
import starter.api.StandingInstruction;

import java.io.IOException;

public class PaymentDelegationSteps {
    @Steps
    PaymentDelegation paymentDelegation;

    @Steps
    StandingInstruction standingInstruction;

    private String productId, suppId, delegationId;

    @Given("{string} login to the api")
    public void loginToTheApi(String arg0) throws IOException {
        paymentDelegation.setToken(1);
    }

    @When("go to Payment Delegation menu tab {string}")
    public void goToPaymentDelegationMenuTab(String arg0) {
        paymentDelegation.retrievePaymentDelegationSetting();
    }

    @Then("{string} can view all payment delegation request")
    public void canViewAllPaymentDelegationRequest(String arg0) {
        paymentDelegation.verifyMessageResponse("Success retrieve payment delegation settings");

    }

    @When("create new payment delegation request with valid data")
    public void createNewPaymentDelegationRequestWithValidData() {
        paymentDelegation.getAllSupplier();

        productId = paymentDelegation.productId(0);
        suppId = paymentDelegation.supplierId(0);

        paymentDelegation.createPaymentDelegation(productId, suppId, 201);
    }

    @Then("new payment request appears in list of data")
    public void newPaymentRequestAppearsInListOfData() {
        paymentDelegation.retrievePaymentDelegationSetting();
        paymentDelegation.verifyNewPaymentAppears("");
    }

    @And("the value of status is {string}")
    public void theValueOfStatusIs(String status) {
        paymentDelegation.verifyPaymentStatus(0, status);
    }

    @And("the value of Payment Authorization is {string}")
    public void theValueOfPaymentAuthorizationIs(String type) {
        paymentDelegation.verifyPaymentType(0, type);
    }

    @And("the value of Active Date is null")
    public void theValueOfActiveDateIsNull() {
        paymentDelegation.verifyDelegationActiveDate(0, null);
    }

    @When("input fill blank in all of fields in add payment delegation form")
    public void inputFillBlankInAllOfFieldsInAddPaymentDelegationForm() {
        paymentDelegation.createPaymentDelegation("", "", 400);
    }

    @Then("the Request button will be disabled")
    public void theRequestButtonWillBeDisabled() {
        paymentDelegation.verifyMessageResponse("input blank");
    }

    @And("there is payment delegation request of product or service A with Active status")
    public void thereIsPaymentDelegationRequestOfProductOrServiceAWithActiveStatus() {
        paymentDelegation.retrievePaymentDelegationSetting();
        if (paymentDelegation.thereIsNoDelegationSetting()) {
            createNewPaymentDelegationRequestWithValidData();
        }
    }

    @When("create new payment delegation request with product or service A")
    public void createNewPaymentDelegationRequestWithProductOrServiceA() {
        paymentDelegation.createPaymentDelegation(productId, suppId, 400);
    }

    @Then("unable create same product or service in payment delegation request")
    public void unableCreateSameProductOrServiceInPaymentDelegationRequest() {
        paymentDelegation.verifyMessageResponse("unable");
    }

    @And("there is standing instruction with product or service A")
    public void thereIsStandingInstructionWithProductOrServiceA() throws IOException {
        standingInstruction.setToken(1);
        standingInstruction.retrieveStandingInstruction("MY_PAYMENT");
        if (!standingInstruction.thereIsSI()){
            standingInstruction.retrieveCardToken();
            String cardToken = standingInstruction.cardToken();

            paymentDelegation.setToken(1);
            paymentDelegation.getAllSupplier();
            suppId = paymentDelegation.supplierId(1);
            productId = paymentDelegation.productId(1);
            String suppName = paymentDelegation.supplierName(1);
            String productName = paymentDelegation.productName(1);

            standingInstruction.setToken(1);
            standingInstruction.createStandingInstruction(productId, productName, suppId, suppName, cardToken,"MY_PAYMENT", 1);
        }
    }

    @When("create new payment delegation request with product or service A for error message")
    public void createNewPaymentDelegationRequestWithProductOrServiceAForErrorMessage() {
        paymentDelegation.getAllSupplier();
        suppId = paymentDelegation.supplierId(1);
        productId = paymentDelegation.productId(1);
        paymentDelegation.createPaymentDelegation(productId, suppId, 400);
    }

    @Then("error message can't create payment delegation appears")
    public void errorMessageCanTCreatePaymentDelegationAppears() {
        paymentDelegation.verifyMessageResponse("");
    }

    @When("user delete Active payment delegation request with future payment type \\(note: user only can delete the product that they subscribe)")
    public void userDeleteActivePaymentDelegationRequestWithFuturePaymentTypeNoteUserOnlyCanDeleteTheProductThatTheySubscribe() {
        paymentDelegation.retrievePaymentDelegationSetting();
        if (paymentDelegation.thereIsNoDelegationSetting()){
            paymentDelegation.getAllSupplier();
            suppId = paymentDelegation.supplierId(0);
            productId = paymentDelegation.productId(0);
            paymentDelegation.createPaymentDelegation(productId, suppId, 200);
            paymentDelegation.retrievePaymentDelegationSetting();
        }
        delegationId = paymentDelegation.paymentDelegationId(0);
        paymentDelegation.deletePaymentDelegation(delegationId, 200);
    }


    @Then("the selected payment delegation request status will be deleted from the row data")
    public void theSelectedPaymentDelegationRequestStatusWillBeDeletedFromTheRowData() {
        paymentDelegation.retrievePaymentDelegationSetting();
        paymentDelegation.thereIsNoDelegationId(delegationId);
    }
}