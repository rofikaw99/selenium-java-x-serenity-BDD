package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import starter.api.PaymentApi;

import java.io.IOException;

public class PaymentApiSteps {

    @Steps
    PaymentApi paymentApi;

    String siId, productId, suppId, cardToken, prodName, suppName, validFrom, paymentId;
    Integer amount;

    @When("request retrieve payment delegation")
    public void requestRetrievePaymentDelegation() throws IOException {
        paymentApi.setHeader();
        paymentApi.retrievePaymentDelegation();
    }

    @Then("success request api")
    public void successRequestApi() {
        paymentApi.verifyStatusCode(201);
    }

    @And("verify the data")
    public void verifyTheData() {
        paymentApi.verifySuccessRetrieveDelegation();
    }

    @Given("get all suppliers")
    public void getAllSuppliers() throws IOException {
        paymentApi.setHeader();
        paymentApi.getAllSupplier();
        productId = paymentApi.productId();
        suppId = paymentApi.supplierId();
        prodName = paymentApi.productName();
        suppName = paymentApi.supplierName();
    }

    @When("request create payment delegation")
    public void requestCreatePaymentDelegation() {
        productId = paymentApi.productId(0);
        suppId = paymentApi.supplierId(0);
        paymentApi.createPaymentDelegation(productId, suppId, "");
    }

    @When("delete payment delegation")
    public void deletePaymentDelegation() {
        paymentApi.deletePaymentDelegation(0);
    }

    @When("request retrieve {string} standing instruction")
    public void requestRetrieveStandingInstruction(String type) throws IOException {
        paymentApi.setHeader();
        paymentApi.retrieveStandingInstruction(type);
        siId = paymentApi.siIdFromList();
        suppId = paymentApi.suppIdList();
    }

    @And("verify success retrieve si")
    public void verifySuccessRetrieveSi() {
        paymentApi.verifySuccessRetrieveSI();
    }

    @And("retrieve card token")
    public void retrieveCardToken() throws IOException {
        paymentApi.setHeader();
        paymentApi.retrieveCardToken();
        cardToken = paymentApi.cardToken();
    }

    @When("create {string} standing instruction")
    public void createStandingInstruction(String type) {
        paymentApi.createStandingInstruction(productId, prodName, suppId, suppName, cardToken, type);
        siId = paymentApi.siId();
    }

    @When("update {string} standing instruction")
    public void updateStandingInstruction(String type) {
        amount = 900;
        validFrom = "2024-10-01";
        paymentApi.updateStandingInstruction(siId, productId, prodName, suppId, suppName, cardToken, type,
                amount, validFrom);
    }

    @And("verify success create {string} SI")
    public void verifySuccessCreateSI(String type) {
        paymentApi.retrieveStandingInstruction(type);
        paymentApi.verifyThereIsSiId(siId);
    }

    @When("delete {string} standing instruction")
    public void deleteStandingInstruction(String type) {
        paymentApi.deleteStandingInstruction(siId, suppId);
    }

    @And("verify success delete {string} si")
    public void verifySuccessDeleteSi(String type) {
        paymentApi.retrieveStandingInstruction(type);
        paymentApi.verifyThereIsNoSiId(siId);
    }

    @And("verify success update si")
    public void verifySuccessUpdateSi() {
        paymentApi.verifyAmountUpdated(amount);
        paymentApi.verifyValidFromUpdated(validFrom);
    }

    @When("request retrieve {string} payment overview")
    public void requestRetrievePaymentOverview(String type) throws IOException {
        paymentApi.setHeader();
        paymentApi.retrievePaymentOverview(type);
    }

    @When("create payment request")
    public void createPaymentRequest() throws IOException {
        paymentApi.setHeaderPayReq();
        paymentApi.createPaymentRequest();
        paymentId = paymentApi.paymentId();
    }

    @And("verify success create payment request")
    public void verifySuccessCreatePaymentRequest() throws IOException {
        paymentApi.setHeader();
        paymentApi.retrievePaymentOverview("MY_PAYMENT");
        paymentApi.verifyThereIsPaymentReqId(paymentId);
    }

    @And("verify success create")
    public void verifySuccessCreate() {
        System.out.println("suppId: " + suppId);
        System.out.println("productId: " + productId);
        paymentApi.verifySupplierId(suppId);
        paymentApi.verifyProductId(productId);
        paymentApi.verifyPaymentAuth();
        paymentApi.verifyStatus();
        paymentApi.verifyDelegateToCompany();
    }

    @And("verify success delete")
    public void verifySuccessDelete() {
        paymentApi.verifySuccessDeleteDelegation();
    }

    @And("verify success retrieve payment overview")
    public void verifySuccessRetrievePaymentOverview() throws IOException {

    }

    @When("delegate specific payment request to other company")
    public void delegateSpecificPaymentRequestToOtherCompany() throws IOException {
        paymentApi.setHeader();
        paymentApi.delegatePaymentRequest(paymentId);
    }

    @When("there is active SI for supplier")
    public void thereIsActiveSIForSupplier() throws IOException {
        paymentApi.setHeader();
        paymentApi.retrieveStandingInstruction("MY_PAYMENT");
    }

    @When("request retrieve {string} payment overview from Delegated Company")
    public void requestRetrievePaymentOverviewFromDelegatedCompany(String type) throws IOException {

    }

    @And("verify success retrieve payment overview with delegated payment")
    public void verifySuccessRetrievePaymentOverviewWithDelegatedPayment() {

    }

    @And("verify success retrieve payment overview in company owner")
    public void verifySuccessRetrievePaymentOverviewInCompanyOwner() throws IOException {
        paymentApi.setHeader();
        paymentApi.retrievePaymentOverview("MY_PAYMENT");
        paymentApi.verifyDelegateFromCompany();
        paymentApi.verifyDelegateToCompanyInList();
        paymentApi.verifyThereIsPaymentReqId(paymentId);
    }

    @And("verify success delegated payment to other company")
    public void verifySuccessDelegatedPaymentToOtherCompany() throws IOException {
        paymentApi.setHeader("secondary");
        paymentApi.baseUrl("secondary");
        paymentApi.retrievePaymentOverview("DELEGATED_PAYMENT");
        paymentApi.verifyDelegateFromCompany();
        paymentApi.verifyDelegateToCompanyInList();
        paymentApi.verifyThereIsPaymentReqId(paymentId);
    }

    @Then("payment success being auto-deduct")
    public void paymentSuccessBeingAutoDeduct() {
        paymentApi.verifyPaymentIsAutoDeducted();
    }

    @Given("there is active SI for supplier X in RECEIVED_PAYMENT of company A")
    public void thereIsActiveSIForSupplierXInRECEIVED_PAYMENTOfCompanyA() throws IOException {
        paymentApi.baseUrl("main");
        paymentApi.setHeader("main");
        paymentApi.retrieveStandingInstruction("RECEIVED_PAYMENT");
        if (!paymentApi.checkThereIsSupplier()) {
            paymentApi.retrieveCardToken();
            cardToken = paymentApi.cardToken();
            paymentApi.getAllSupplier();
            productId = paymentApi.productId();
            prodName = paymentApi.productName();
            suppId = paymentApi.supplierId();
            suppName = paymentApi.supplierName();

            paymentApi.createStandingInstruction(productId, prodName, suppId, suppName, cardToken, "RECEIVED_PAYMENT");
        }
    }

    @And("there is delegated payment setting of supplier X in company B to company A")
    public void thereIsDelegatedPaymentSettingOfSupplierXInCompanyBToCompanyA() throws IOException {
        paymentApi.baseUrl("secondary");
        paymentApi.setHeader("secondary");
        paymentApi.retrievePaymentDelegation();
        if (!paymentApi.checkThereIsPaymentDelegation())
            paymentApi.createPaymentDelegation(productId, suppId, "SG Auto QA");
    }

    @When("create payment request of supplier X in company B")
    public void createPaymentRequestOfSupplierXInCompanyB() throws IOException {
        paymentApi.setHeaderPayReq();
        paymentApi.baseUrl("secondary");
        paymentApi.createPaymentRequest();
        paymentId = paymentApi.paymentId();
    }

    @And("verify success create payment request in company B")
    public void verifySuccessCreatePaymentRequestInCompanyB() {
        paymentApi.retrievePaymentOverview("MY_PAYMENT");
        paymentApi.verifyThereIsPaymentReqId(paymentId);
    }

    @When("create payment request for auto-deduct")
    public void createPaymentRequestForAutoDeduct() throws IOException {
        paymentApi.setHeaderPayReq();
        paymentApi.createPaymentRequest(40);
        paymentId = paymentApi.paymentId();
    }

    @Given("there is payment delegation request of product X to company {string}")
    public void thereIsPaymentDelegationRequestOfProductXToCompany(String company) throws IOException {
        paymentApi.setHeader("secondary");
        paymentApi.baseUrl("secondary");
        paymentApi.getAllSupplier();
        productId = paymentApi.productId();
        suppId = paymentApi.supplierId();

        paymentApi.retrievePaymentDelegation();
        if (!paymentApi.checkThereIsPaymentDelegation()){
            paymentApi.createPaymentDelegation(productId, suppId, "Auto QA Company");
        }
    }

    @When("create payment request of product X in company {string}")
    public void createPaymentRequestOfProductXInCompanyA(String company) throws IOException {
        paymentApi.setHeaderPayReq();
        paymentApi.createPaymentRequest();
    }

    @And("verify success delegated payment to company {string}")
    public void verifySuccessDelegatedPaymentToCompany(String arg0) throws IOException {
        paymentApi.setHeader();
        paymentApi.baseUrl("main");
        paymentApi.retrievePaymentOverview("DELEGATED_PAYMENT");
    }

    @When("create payment request tdsb")
    public void createPaymentRequestTdsb() throws IOException {
        paymentApi.setHeaderPayReq("tdsb");
        paymentApi.createPaymentRequest("tdsb");
        paymentId = paymentApi.paymentId();
    }
}
