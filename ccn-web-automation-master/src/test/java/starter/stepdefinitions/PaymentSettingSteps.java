package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import starter.pages.CompanyPage;
import starter.pages.PaymentSettingsPage;
import starter.utlis.Constants;

import java.util.Map;

public class PaymentSettingSteps {

    @Steps
    PaymentSettingsPage paymentSettingsPage;

    @Steps
    CompanyPage companyPage;

    public int index;
    public String product, supplier, company;
    public Map<String, String> detailDelegation;

    @When("go to Payment Delegation menu tab {string}")
    public void goToPaymentDelegationMenuTab(String menu) throws Exception {
        companyPage.myMenuAccount("Payment Settings");
        paymentSettingsPage.goToPayment();
        paymentSettingsPage.clickPaymentDelegationMenu();
        switch (menu){
            case "Delegated To":
                paymentSettingsPage.clickDelegatedToTab();
                break;
            case "Delegated From":
                paymentSettingsPage.clickDelegatedFromTab();
                break;
        }
        Thread.sleep(3000);
    }

    @Then("{string} can view all payment delegation request")
    public void canViewAllPaymentDelegationRequest(String arg0) {
        paymentSettingsPage.verifyAllProductServiceAppears(true);
    }

    @And("user that subscribe into the product or service can view their own payment delegation request of the product or service")
    public void userThatSubscribeIntoTheProductOrServiceCanViewTheirOwnPaymentDelegationRequestOfTheProductOrService() {
        paymentSettingsPage.verifyAllProductServiceAppears(false);
    }

    @Then("user view all the required data: delegated to, product, supplier, request date, active date, payment authorization, status")
    public void userViewAllTheRequiredDataDelegatedToProductSupplierRequestDateActiveDatePaymentAuthorizationStatus() {
        paymentSettingsPage.verifyDelegatedToAppears();
        paymentSettingsPage.verifyProductServiceAppears();
        paymentSettingsPage.verifySupplierAppears();
        paymentSettingsPage.verifyRequestDateAppears();
        paymentSettingsPage.verifyActiveDateAppears();
        paymentSettingsPage.verifyPaymentAuthAppears();
        paymentSettingsPage.verifyStatusAppears();
    }

    @When("sort payment delegation data based on {string} column in {string} tab")
    public void sortPaymentDelegationDataBasedOnColumnInDelegatedToTab(String column, String menu) {
        switch (column){
            case "Delegated To":
                paymentSettingsPage.clickDelegatedToColName();
                break;
            case "Delegated From":
                paymentSettingsPage.clickDelegatedFromColName();
                break;
            case "Product / Service":
                paymentSettingsPage.clickProductServiceColName();
                break;
            case "Supplier":
                paymentSettingsPage.clickSupplierColName();
                break;
            case "Request Date":
                paymentSettingsPage.clickRequestDateColName();
                break;
            case "Active Date":
                paymentSettingsPage.clickActiveDateColName();
                break;
            case "Payment Authorization":
                paymentSettingsPage.clickPaymentAuthColName();
                break;
            case "Status":
                paymentSettingsPage.clickStatusColName();
                break;
        }
    }

    @Then("the data will be sorted asc or desc based on the {string}")
    public void theDataWillBeSortedAscOrDescBasedOnThe(String column) {
        paymentSettingsPage.verifySortedData(column);
    }

    @When("change the results per page value")
    public void changeTheResultsPerPageValue() {
        paymentSettingsPage.clickResultPerPage();
    }

    @When("go to previous page")
    public void goToPreviousPage() {
        paymentSettingsPage.clickPreviousPage();
    }

    @When("go to next page")
    public void goToNextPage() {
        paymentSettingsPage.clickNextPage();
    }

    @Then("number of data appears based on the selected value")
    public void numberOfDataAppearsBasedOnTheSelectedValue() {
        paymentSettingsPage.verifyNumberOfDataAppears(5); //change value of number
    }

    @When("user delete Active, Rejected or Cancelled payment delegation request with future payment type")
    public void userDeleteActiveRejectedOrCancelledPaymentDelegationRequestWithFuturePaymentType() {
        //there is no action here
    }

    @Then("there is no delete button for these statuses")
    public void thereIsNoDeleteButtonForTheseStatuses() {
        paymentSettingsPage.deleteButtonFutureInStatusAppears("Active", false);
        paymentSettingsPage.deleteButtonFutureInStatusAppears("Rejected", false);
        paymentSettingsPage.deleteButtonFutureInStatusAppears("Cancelled", false);
    }

    @When("user delete Pending payment delegation request for future payment type")
    public void userDeletePendingPaymentDelegationRequestForFuturePaymentType() {
        index = paymentSettingsPage.deleteButtonFutureInStatus("Pending");
        detailDelegation = paymentSettingsPage.detailDelegationRequest(index);
    }

    @When("create new payment delegation request with valid data")
    public void createNewPaymentDelegationRequestWithValidData() throws InterruptedException {
        paymentSettingsPage.clickAddNewDelegationBtn();
        product = paymentSettingsPage.chooseProductDelegation();
        supplier = paymentSettingsPage.chooseSupplierDelegation();
        company = paymentSettingsPage.chooseCompanyDelegation(Constants.DELEGATED_COMPANY);
        System.out.println("company: " + company);
        paymentSettingsPage.clickRequestBtn();
        Thread.sleep(1000);
        paymentSettingsPage.verifySuccessAddDelegation();
    }


    @Then("new payment request appears in list of data")
    public void newPaymentRequestAppearsInListOfData() throws InterruptedException {
        Thread.sleep(3000);
        paymentSettingsPage.verifySuccessCreateFutureDelegation(company, product, supplier);
    }

    @And("the value of status is {string}")
    public void theValueOfStatusIs(String status) {
        paymentSettingsPage.verifyStatusDelegationRequestAppears(0, status);
    }

    @And("the value of Payment Authorization is {string}")
    public void theValueOfPaymentAuthorizationIs(String paymentAuth) {
        paymentSettingsPage.verifyPaymentAuthDelegationAppears(0, paymentAuth);
    }

    @And("the value of Request Date is today")
    public void theValueOfRequestDateIsToday() {
        paymentSettingsPage.verifyRequestDateToday(0);
    }

    @And("the value of Active Date is null")
    public void theValueOfActiveDateIsNull() {
        paymentSettingsPage.verifyActiveDateNull(0);
    }

    @When("input fill blank in all of fields in add payment delegation form")
    public void inputFillBlankInAllOfFieldsInAddPaymentDelegationForm() {
        // user doesn't do anything
    }

    @Then("the Request button will be disabled")
    public void theRequestButtonWillBeDisabled() {
        paymentSettingsPage.verifyRequestBtnDisabled();
    }

    @And("there is payment delegation request of product or service A with Active or Pending status")
    public void thereIsPaymentDelegationRequestOfProductOrServiceAWithActiveOrPendingStatus() throws InterruptedException {
        product = paymentSettingsPage.activePendingProduct();
        if (product.isEmpty()) createNewPaymentDelegationRequestWithValidData();
    }

    @When("create new payment delegation request with product or service A")
    public void createNewPaymentDelegationRequestWithProductOrServiceA() {
        paymentSettingsPage.clickAddNewDelegationBtn();
    }

    @Then("product or service A disappear from the field of create form")
    public void productOrServiceADisappearFromTheFieldOfCreateForm() {
        paymentSettingsPage.verifyProductDisappearFromField(product);
    }

    @And("there is standing instruction with product or service A")
    public void thereIsStandingInstructionWithProductOrServiceA() throws InterruptedException {
        paymentSettingsPage.clickSIMenu();
        product = paymentSettingsPage.productWithSI();
    }

    @When("create new payment delegation request with product or service A for error message")
    public void createNewPaymentDelegationRequestWithProductOrServiceAForErrorMessage() throws InterruptedException {
        paymentSettingsPage.clickPaymentDelegationMenu();
        paymentSettingsPage.clickDelegatedToTab();
        paymentSettingsPage.clickAddNewDelegationBtn();
        paymentSettingsPage.chooseProductDelegation(product);
        paymentSettingsPage.chooseSupplierDelegation();
        paymentSettingsPage.chooseCompanyDelegation(Constants.DELEGATED_COMPANY);
        paymentSettingsPage.clickRequestBtn();

    }

    @Then("error message can't create payment delegation appears")
    public void errorMessageCanTCreatePaymentDelegationAppears() {
        paymentSettingsPage.verifyErrorCantCreateRequest();
    }

    @Then("the selected payment delegation request status will be Deleted")
    public void theSelectedPaymentDelegationRequestStatusWillBeDeleted() {
        paymentSettingsPage.verifySuccessDeleteDelegation();
        Assert.assertNotEquals(paymentSettingsPage.detailDelegationRequest(index), detailDelegation);
    }

    @Then("page will change to the selected page")
    public void pageWillChangeToTheSelectedPage() {
    }

    @When("change the page to page {int}")
    public void changeThePageToPage(int page) {
        paymentSettingsPage.clickSpecificPage(page);
    }

    @Then("page will change to page {int}")
    public void pageWillChangeToPage(int page) {
        paymentSettingsPage.verifyGoToSpecificPage(page);
    }

    @When("user cancel Active payment delegation request with future payment type \\(note: user only can delete the product that they subscribe)")
    public void userCancelActivePaymentDelegationRequestWithFuturePaymentTypeNoteUserOnlyCanDeleteTheProductThatTheySubscribe() {
        index = paymentSettingsPage.cancelButtonFutureInStatus("Active");
        detailDelegation = paymentSettingsPage.detailDelegationRequest(index);
    }

    @Then("user view all the required data: delegated from, product, supplier, request date, active date, payment authorization, status")
    public void userViewAllTheRequiredDataDelegatedFromProductSupplierRequestDateActiveDatePaymentAuthorizationStatus() {
        paymentSettingsPage.verifyDelegatedFromAppears();
        paymentSettingsPage.verifyProductServiceAppears();
        paymentSettingsPage.verifySupplierAppears();
        paymentSettingsPage.verifyRequestDateAppears();
        paymentSettingsPage.verifyActiveDateAppears();
        paymentSettingsPage.verifyPaymentAuthAppears();
        paymentSettingsPage.verifyStatusAppears();
    }

    @When("approve payment delegation request which have Pending status and {string} payments")
    public void approvePaymentDelegationRequestWhichHavePendingStatusAndPayments(String type) {
        index = paymentSettingsPage.approveButtonInTypePayment(type);
    }

    @When("reject payment delegation request which have Pending status and {string} payments")
    public void rejectPaymentDelegationRequestWhichHavePendingStatusAndPayments(String type) {
        index = paymentSettingsPage.rejectButtonInTypePayment(type);
    }

    @Then("payment delegation request status changes to {string}")
    public void paymentDelegationRequestStatusChangesTo(String status) {
        paymentSettingsPage.verifyStatusDelegationRequestAppears(index, status);
    }

    @And("value of Active Date is today")
    public void valueOfActiveDateIsToday() {
        paymentSettingsPage.verifyActiveDateToday(index);
    }

    @And("id of delegated payment is clickable")
    public void idOfDelegatedPaymentIsClickable() {
        paymentSettingsPage.verifyRefPaymentClickable();
    }

    @When("user cancel Active payment delegation request with future payment type")
    public void userCancelActivePaymentDelegationRequestWithFuturePaymentType() {
        index = paymentSettingsPage.cancelButtonInTypePayment("Future");
    }

    @When("user cancel Active payment delegation request with one-time payment type")
    public void userCancelActivePaymentDelegationRequestWithOneTimePaymentType() {
        index = paymentSettingsPage.cancelButtonInTypePayment("One time");
    }

    @And("the id of payment will be disabled and can't be clicked in Delegated From tab")
    public void theIdOfPaymentWillBeDisabledAndCanTBeClickedInDelegatedFromTab() {
        paymentSettingsPage.verifyRefPaymentDisabled();
    }
}
