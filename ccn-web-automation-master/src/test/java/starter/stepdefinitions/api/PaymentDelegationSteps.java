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
import starter.utlis.Common;

import java.io.IOException;
import java.util.List;

public class PaymentDelegationSteps {
    @Steps
    PaymentDelegation paymentDelegation;

    @Steps
    StandingInstruction standingInstruction;

    @Steps
    PaymentOverview paymentOverview;

    private String productId, suppId, delegationId, order, keySort, payId;
    private int page, pagination, index;

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
        if (paymentDelegation.thereIsNoDelegationSetting()){
            String product = ApiProperties.productName("tdsb");
            paymentDelegation.getAllSupplier();
            int index = paymentDelegation.indexOfProduct(List.of(product));
            suppId = paymentDelegation.supplierId(index);
            productId = paymentDelegation.productId(index);
            paymentDelegation.createPaymentDelegation(productId, suppId, 200);
            paymentDelegation.retrievePaymentDelegationSetting();
        }
        paymentDelegation.verifyMessageResponse("Success retrieve payment delegation settings");
    }

    @When("create new payment delegation request with valid data")
    public void createNewPaymentDelegationRequestWithValidData() {
        paymentDelegation.getAllSupplier();
        index = paymentDelegation.indexOfProduct(List.of(ApiProperties.productName("tdsb")));

        productId = paymentDelegation.productId(index);
        suppId = paymentDelegation.supplierId(index);

        paymentDelegation.createPaymentDelegation(productId, suppId, 200);
        delegationId = paymentDelegation.paymentDelegationIdCreate();
    }

    @Then("new payment request appears in list of data")
    public void newPaymentRequestAppearsInListOfData() {
        paymentDelegation.retrievePaymentDelegationSetting();
        paymentDelegation.verifyNewPaymentAppears(delegationId);
    }

    @And("the value of status is {string}")
    public void theValueOfStatusIs(String status) {
        paymentDelegation.verifyPaymentStatus(0, status);
    }

    @And("the value of Payment Authorization is {string}")
    public void theValueOfPaymentAuthorizationIs(String type) {
        paymentDelegation.verifyPaymentType(0, type);
    }

    @And("the value of Active Date is today")
    public void theValueOfActiveDateIsToday() {
        paymentDelegation.verifyDelegationActiveDate(0, Common.activeDate());
    }

    @When("input fill blank in all of fields in add payment delegation form")
    public void inputFillBlankInAllOfFieldsInAddPaymentDelegationForm() {
        paymentDelegation.createPaymentDelegation("", "", 422);
    }

    @Then("the Request button will be disabled")
    public void theRequestButtonWillBeDisabled() {
        paymentDelegation.verifyMessageResponse("productServiceId must be a valid UUID");
    }

    @And("there is payment delegation request of product or service A with Active status")
    public void thereIsPaymentDelegationRequestOfProductOrServiceAWithActiveStatus() {
        if (paymentDelegation.thereIsNoDelegationSetting()) {
            createNewPaymentDelegationRequestWithValidData();
        } else {
            suppId = paymentDelegation.supplierIdListDelegation(0);
            productId = paymentDelegation.productIdListDelegation(0);
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
            String product = ApiProperties.productName("svs");
            int index = paymentDelegation.indexOfProduct(List.of(product));
            suppId = paymentDelegation.supplierId(index);
            productId = paymentDelegation.productId(index);
            String suppName = paymentDelegation.supplierName(index);
            String productName = paymentDelegation.productName(index);

            standingInstruction.setToken(1);
            standingInstruction.createStandingInstruction(productId, productName, suppId, suppName, cardToken,"MY_PAYMENT", 1, 200);
        } else {
            suppId = paymentDelegation.supplierIdFromSi(0);
            productId = paymentDelegation.productIdFromSi(0);
        }
    }

    @When("create new payment delegation request with product or service A for error message")
    public void createNewPaymentDelegationRequestWithProductOrServiceAForErrorMessage() {
        paymentDelegation.createPaymentDelegation(productId, suppId, 400);
    }

    @Then("error message can't create payment delegation appears")
    public void errorMessageCanTCreatePaymentDelegationAppears() {
        paymentDelegation.verifyMessageResponse("There is active MY_PAYMENT Standing Instruction for supplierId "+ suppId + " and productServiceId " + productId);
    }

    @When("user delete Active payment delegation request with future payment type \\(note: user only can delete the product that they subscribe)")
    public void userDeleteActivePaymentDelegationRequestWithFuturePaymentTypeNoteUserOnlyCanDeleteTheProductThatTheySubscribe() throws IOException {
        if (paymentDelegation.thereIsNoDelegationSetting()){
            String product = ApiProperties.productName("tdsb");
            paymentDelegation.getAllSupplier();
            int index = paymentDelegation.indexOfProduct(List.of(product));
            suppId = paymentDelegation.supplierId(index);
            productId = paymentDelegation.productId(index);
            paymentDelegation.createPaymentDelegation(productId, suppId, 200);
            paymentDelegation.retrievePaymentDelegationSetting();
        }
        //create payment request
        paymentOverview.setToken(1);
        paymentOverview.createPaymentRequest("tdsb", 200);
        payId = paymentOverview.payId();
        paymentOverview.retrievePaymentRequest(List.of(payId));
        paymentOverview.verifyDelegateToCompany(ApiProperties.emailCompany(2));

        delegationId = paymentDelegation.paymentDelegationId(0);
        paymentDelegation.deletePaymentDelegation(delegationId, 200);
    }


    @Then("the selected payment delegation request status will be deleted from the row data")
    public void theSelectedPaymentDelegationRequestStatusWillBeDeletedFromTheRowData() {
        paymentDelegation.retrievePaymentDelegationSetting();
        paymentDelegation.thereIsNoDelegationId(delegationId);
    }

    @When("change the page to page {int}")
    public void changeThePageToPage(int pages) {
        page = pages;
        paymentDelegation.retrievePaymentDelegationSetting(10, page);
    }

    @Then("page will change to page {int}")
    public void pageWillChangeToPage(int pages) {
        paymentDelegation.verifyPageValueInRetrieve(pages);
    }

    @When("change the results per page value to {int}")
    public void changeTheResultsPerPageValueTo(int paginations) {
        pagination = paginations;
        paymentDelegation.retrievePaymentDelegationSetting(pagination, 1);
    }

    @Then("number of data appears to {int} on the selected value")
    public void numberOfDataAppearsToOnTheSelectedValue(int paginations) {
        paymentDelegation.verifyPaginationValueInRetrieve(paginations);
    }

    @When("go to previous page")
    public void goToPreviousPage() {
        paymentDelegation.retrievePaymentDelegationSetting(pagination, page - 1);
    }

    @When("sort payment delegation data based on {string} column in {string} tab")
    public void sortPaymentDelegationDataBasedOnColumnInTab(String column, String arg1) {
        order = "asc";
        switch (column){
            case "Delegated To": keySort = "delegateTo.companyName";
            break;
            case "Product / Service": keySort = "productData.name";
            break;
            case "Supplier": keySort = "supplierData.name";
            break;
            case "Active Date": keySort = "activeDate";
            break;
            case "Payment Authorization": keySort = "paymentAuth";
            break;
            case "Status": keySort = "status";
            break;
        }
        paymentDelegation.retrievePaymentDelegationSetting(keySort, order);
    }

    @Then("the data will be sorted asc or desc based on the {string}")
    public void theDataWillBeSortedAscOrDescBasedOnThe(String column) {
        paymentDelegation.verifyDataSortedInRetrieve(keySort);
    }

    @Then("user view all the required data: delegated to, product, supplier, active date, payment authorization, status")
    public void userViewAllTheRequiredDataDelegatedToProductSupplierActiveDatePaymentAuthorizationStatus() {
        paymentDelegation.verifyThereIsRequiredData();
    }

    @And("user that subscribe into the product or service can view their own payment delegation request of the product or service")
    public void userThatSubscribeIntoTheProductOrServiceCanViewTheirOwnPaymentDelegationRequestOfTheProductOrService() {
        paymentDelegation.verifyMessageResponse("Success retrieve payment delegation settings");
    }

    @And("the payment will not being delegated to the delegated company in the future")
    public void thePaymentWillNotBeingDelegatedToTheDelegatedCompanyInTheFuture() throws IOException {
        paymentOverview.setToken(1);
        paymentOverview.createPaymentRequest("tdsb", 200);
        paymentOverview.retrievePaymentRequest(List.of(paymentOverview.payId()));
        paymentOverview.verifyDelegateToCompany("");
    }

    @And("the previous payment that has been delegated to company X still can be accessed in company X")
    public void thePreviousPaymentThatHasBeenDelegatedToCompanyXStillCanBeAccessedInCompanyX() {
        paymentOverview.retrievePaymentRequest(List.of(payId));
        paymentOverview.verifyDelegateToCompany(ApiProperties.emailCompany(2));
    }
}