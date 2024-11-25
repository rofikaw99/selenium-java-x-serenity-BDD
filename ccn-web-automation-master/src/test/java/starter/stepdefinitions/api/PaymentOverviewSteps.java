package starter.stepdefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;
import starter.api.PaymentDelegation;
import starter.api.PaymentOverview;
import starter.api.StandingInstruction;
import starter.utlis.ApiProperties;
import starter.utlis.Common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

public class PaymentOverviewSteps {

    @Steps
    PaymentOverview paymentOverview;

    @Steps
    StandingInstruction standingInstruction;

    @Steps
    PaymentDelegation paymentDelegation;

    private List<String> payIds = null;
    private String suppId, suppName, productId, productName, cardToken, companyEmail, delegationId, payId, statuses;
    private int companyNumber;

    @When("user view detail of {string} with status: {string}")
    public void userViewDetailOfMyPaymentWithStatus(String type, String status) {
        paymentOverview.retrievePaymentOverview(type, status);
        if (paymentOverview.payIdNumber() > 0)
            payIds = paymentOverview.payIds(0, 1);
        else payIds = null;
        statuses = status;
    }

    @Then("payment detail page with selected id appears")
    public void paymentDetailPageWithSelectedIdAppears() {
        if (payIds != null){
            paymentOverview.retrievePaymentRequest(payIds);
            paymentOverview.verifyPaymentStatusInPaymentRequest(statuses);
        }
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
        standingInstruction.retrieveStandingInstruction("MY_PAYMENT");
        if (!standingInstruction.thereIsSI()){
            paymentDelegation.setToken(1);
            paymentDelegation.getAllSupplier();
            String product = ApiProperties.productName("svs");
            int index = paymentDelegation.indexOfProduct(List.of(product));
            suppId = paymentDelegation.supplierId(index);
            productId = paymentDelegation.productId(index);
            suppName = paymentDelegation.supplierName(index);
            productName = paymentDelegation.productName(index);

            standingInstruction.retrieveCompanyIdentities();
            companyEmail = standingInstruction.companyEmail(index);

            standingInstruction.retrieveCardToken();
            cardToken = standingInstruction.cardToken();

            standingInstruction.createStandingInstruction(productId, productName, suppId, suppName, cardToken, "MY_PAYMENT", companyEmail, 200);
        }
    }

    @When("there is payment for service A")
    public void thereIsPaymentForServiceA() {
        paymentOverview.createPaymentRequest(400, Common.chargeDateTimePayment("DAYS", 0), "", "", "", 201);
        payId = paymentOverview.payId();
    }

    @Then("payment for service A of company will be auto-deducted")
    public void paymentForServiceAOfCompanyWillBeAutoDeducted() {
        paymentOverview.retrievePaymentOverview("MY_PAYMENT", 100);
        paymentOverview.verifyPaymentIdAppears(payId);
        paymentOverview.retrievePaymentRequest(List.of(payId));
        paymentOverview.verifySuccessAutoDeduct();
    }

    @And("payment status changes to Paid")
    public void paymentStatusChangesToPaid() {
        paymentOverview.verifyPaymentStatus("PAID");
    }

    @And("there is Outstanding or Upcoming payment request of service A")
    public void thereIsOutstandingOrUpcomingPaymentRequestOfServiceA() {
        paymentOverview.createPaymentRequest("svs", 201);
        payId = paymentOverview.payId();
    }

    @And("there is no Active payment delegation for service A")
    public void thereIsNoActivePaymentDelegationForServiceA() throws IOException {
        paymentDelegation.setToken(1);
        paymentDelegation.retrievePaymentDelegationSetting();
        if (!paymentDelegation.thereIsNoDelegationSetting()){
            delegationId = paymentDelegation.paymentDelegationId(0);
            paymentDelegation.deletePaymentDelegation(delegationId, 200);
        }
    }

    @When("user delegate the specific payment request to company X")
    public void userDelegateTheSpecificPaymentRequestToCompanyX() {
        companyEmail = ApiProperties.emailCompany2();
        paymentOverview.delegatePaymentRequest(payId, companyEmail, ApiProperties.companyName2());
    }

    @Then("the payment will be delegated to company X \\(will appears in the Received Payment menu)")
    public void thePaymentWillBeDelegatedToCompanyXWillAppearsInTheReceivedPaymentMenu() {
        paymentOverview.retrievePaymentRequest(List.of(payId));
        paymentOverview.verifyDelegateToCompany(companyEmail);
    }

    @And("company X able to pay the payment")
    public void companyXAbleToPayThePayment() throws IOException {
        paymentOverview.setToken(2);
        paymentOverview.retrievePaymentOverview("DELEGATED_PAYMENT", 100);
        paymentOverview.verifyPaymentIdAppears(payId);
    }

    @Given("supplier create payment request to a user")
    public void supplierCreatePaymentRequestToAUser() throws IOException {
        paymentOverview.setToken(1);
        paymentOverview.createPaymentRequest(400, Common.chargeDateTimePayment("DAYS", 0), "", "","", 201);
        payId = paymentOverview.payId();
    }

    @When("payment has been Paid")
    public void paymentHasBeenPaid() throws InterruptedException {
        paymentOverview.retrievePaymentOverview("MY_PAYMENT");
        payIds = List.of(payId);
        int number = 0;
        do {
            sleep(2000);
            paymentOverview.retrievePaymentRequest(payIds);
            number++;
        } while (!paymentOverview.paymentStatus().equals(List.of("PAID").toString()) && (number < 5));
        paymentOverview.verifyPaymentStatusInRetrievePayReq(List.of("PAID").toString());
    }

    @And("supplier add payment record to the payment")
    public void supplierAddPaymentRecordToThePayment() throws IOException {
        paymentOverview.createPaymentRecord(payIds.get(0), -2, 200);
    }

    @Then("success add payment record")
    public void successAddPaymentRecord() {
        paymentOverview.verifyMessageBody("Success create Payment Request Record");
        paymentOverview.verifyPaymentReqIdInCreatePayRecord(payId);
    }

    @And("verify the record appears in report excel merchant")
    public void verifyTheRecordAppearsInReportExcelMerchant() {
        paymentOverview.retrievePaymentRequest(payIds);
    }

    @And("supplier add payment record to the payment with string value")
    public void supplierAddPaymentRecordToThePaymentWithStringValue() {
        paymentOverview.createPaymentRecord(payIds.get(0), "-2", 422);
    }

    @Then("failed add payment record")
    public void failedAddPaymentRecord() {
        paymentOverview.verifyMessageBody("amount must be number");
    }

    @Given("user has SI for service A")
    public void userHasSIForServiceA() throws IOException {
        standingInstruction.setToken(1);
        standingInstruction.retrieveStandingInstruction("MY_PAYMENT");
        if (!standingInstruction.thereIsSI()){
            paymentDelegation.setToken(1);
            paymentDelegation.getAllSupplier();
            suppId = paymentDelegation.supplierId(1);
            suppName = paymentDelegation.supplierName(1);
            productId = paymentDelegation.productId(1);
            productName = paymentDelegation.productName(1);

            standingInstruction.retrieveCardToken();
            cardToken = standingInstruction.cardToken();
            standingInstruction.createStandingInstruction(productId, productName, suppId, suppName, cardToken,
                    "MY_PAYMENT", 1, 200);
        }
    }

    @When("supplier create payment request with deductionDate in {int} minutes")
    public void supplierCreatePaymentRequestWithDeductionDate(int minutes) throws IOException {
        paymentOverview.setToken(1);
        paymentOverview.createPaymentRequest(400, Common.chargeDateTimePayment("MINUTES", 0), Common.chargeDateTimePayment("MINUTES", minutes), "", "", 201);
        payId = paymentOverview.payId();
    }

    @Then("payment will automatically deducted based on the time")
    public void paymentWillAutomaticallyDeductedBasedOnTheTime() {
        paymentOverview.retrievePaymentOverview("MY_PAYMENT");
//        paymentOverview.verifyPaymentIdAppears(payId);
        paymentOverview.retrievePaymentRequest(List.of(payId));
        paymentOverview.verifyPaymentStatus("OUTSTANDING");
    }

    @When("supplier create payment request without deductionDate")
    public void supplierCreatePaymentRequestWithoutDeductionDate() throws IOException {
        paymentOverview.setToken(1);
        paymentOverview.createPaymentRequest(400, Common.chargeDateTimePayment("DAYS", 0), "", "", "", 201);
        payId = paymentOverview.payId();
    }

    @Then("payment will immediately changes to PAID")
    public void paymentWillImmediatelyChangesToPAID() throws InterruptedException {
        int count = 0;
        payIds = List.of(payId);
        do {
            sleep(10000);
            paymentOverview.retrievePaymentRequest(payIds);
            count ++;
        } while ((!paymentOverview.paymentStatus().equals(List.of("PAID").toString())) && (count < 5));
        paymentOverview.verifyPaymentStatusInPaymentRequest("PAID");
    }

    @When("supplier create payment request with amount greater than SI")
    public void supplierCreatePaymentRequestWithAmountGreaterThanSI() throws IOException {
        paymentOverview.setToken(1);
        paymentOverview.createPaymentRequest(1000, Common.chargeDateTimePayment("MINUTES", 0), Common.chargeDateTimePayment("MINUTES", 0), "", "", 201);
        payId = paymentOverview.payId();
    }

    @Then("payment will remain in Outstanding status")
    public void paymentWillRemainInOutstandingStatus() throws InterruptedException {
        int count = 0;
        payIds = List.of(payId);
        do {
            sleep(10000);
            paymentOverview.retrievePaymentRequest(payIds);
            count ++;
        } while ((!paymentOverview.paymentStatus().equals(List.of("OUTSTANDING").toString())) && (count < 5));
        paymentOverview.verifyPaymentStatusInPaymentRequest("OUTSTANDING");
    }

    @Then("payment will automatically changes to Expired")
    public void paymentWillAutomaticallyChangesToExpired() {
        //        paymentOverview.retrievePaymentOverview("MY_PAYMENT");
//        paymentOverview.verifyPaymentIdAppears(payId);
        paymentOverview.retrievePaymentRequest(List.of(payId));
        paymentOverview.verifyPaymentStatus("EXPIRED");
    }

    @When("supplier create payment request with expired date today")
    public void supplierCreatePaymentRequestWithExpiredDateToday() throws IOException {
        paymentOverview.setToken(1);
        paymentOverview.createPaymentRequest(1000, Common.chargeDateTimePayment("MINUTES", -1), "", Common.chargeDateTimePayment("MINUTES", 0), "", 201);
        payId = paymentOverview.payId();
    }

    @When("supplier create payment request with expired date in {int} minutes")
    public void supplierCreatePaymentRequestWithExpiredDate(int minutes) throws IOException {
        paymentOverview.setToken(1);
        paymentOverview.createPaymentRequest(1000, Common.chargeDateTimePayment("MINUTES", 0), "", Common.chargeDateTimePayment("MINUTES", minutes), "", 201);
        payId = paymentOverview.payId();
    }

    @When("supplier create payment request without expired date")
    public void supplierCreatePaymentRequestWithoutExpiredDate() throws IOException {
        paymentOverview.setToken(1);
        paymentOverview.createPaymentRequest(1000, Common.chargeDateTimePayment("MINUTES", 0), "", "", "", 201);
        payId = paymentOverview.payId();
    }

    @Then("payment will changes to Expired in {int} days")
    public void paymentWillChangesToExpiredInDays(int days) throws InterruptedException {
//        paymentOverview.retrievePaymentOverview("MY_PAYMENT");
//        paymentOverview.verifyPaymentIdAppears(payId);
        int count = 0;
        payIds = List.of(payId);
        do {
            sleep(10000);
            paymentOverview.retrievePaymentRequest(payIds);
            count ++;
        } while ((!paymentOverview.paymentStatus().equals(List.of("OUTSTANDING").toString())) && (count < 5));
        paymentOverview.verifyPaymentStatusInPaymentRequest("OUTSTANDING");
        paymentOverview.verifyExpiredDate(Common.addedDatePayment(days));
    }

    @Given("supplier create payment request for {string} status")
    public void supplierCreatePaymentRequestForStatus(String status) throws IOException {
        paymentOverview.setToken(1);
        if (status.equals("Upcoming")) paymentOverview.createPaymentRequest(1000, Common.chargeDateTimePayment("MINUTES", 1), "", "", "", 201);
        else if (status.equals("Outstanding")) paymentOverview.createPaymentRequest(1000, "", "", "", "", 201);
        payId = paymentOverview.payId();
        paymentOverview.retrievePaymentRequest(List.of(payId));
    }

    @When("supplier update payment request to {string} status")
    public void supplierUpdatePaymentRequestToStatus(String status) {
        paymentOverview.updatePaymentRequest(payId, status, 200);
    }

    @Then("payment will automatically changes to {string}")
    public void paymentWillAutomaticallyChangesTo(String status) throws InterruptedException {
        int count = 0;
        payIds = List.of(payId);
        do {
            sleep(20000);
            paymentOverview.retrievePaymentRequest(payIds);
            count ++;
        } while ((!paymentOverview.paymentStatus().equals(List.of(status).toString())) && (count < 5));
        paymentOverview.verifyPaymentStatusInPaymentRequest(status);
    }

    @Given("supplier create payment request for {string} status and achieved amount SI")
    public void supplierCreatePaymentRequestForStatusAndAchievedAmountSI(String status) throws IOException {
        paymentOverview.setToken(1);
        if (status.equals("Upcoming")) paymentOverview.createPaymentRequest(400, Common.chargeDateTimePayment("MINUTES", 1), "", "", "", 201);
        else if (status.equals("Outstanding")) paymentOverview.createPaymentRequest(400, Common.chargeDateTimePayment("MINUTES", 0), "", "", "", 201);
        payId = paymentOverview.payId();
    }

    @And("the payment by will be {string} and autoDeduct is {string}")
    public void thePaymentByWillBeAndAutoDeductIs(String paymentBy, String autoDeduct) {
        paymentOverview.verifyPaymentByInPaymentRequest(paymentBy);
        paymentOverview.verifyIsAutoDeductInPaymentRequest(autoDeduct);
    }

    @Then("error message can't update {string} payment appears")
    public void errorMessageCanTUpdatePaymentAppears(String status) {
        if (status.equals("PAID")){
            paymentOverview.verifyErrorMessageContains("Payment Request with ID "+ payId +" Status Already Updated to ");
        } else {
            paymentOverview.verifyErrorMessageBody("Payment Request with ID "+ payId +" Status Already Updated to " + status);
        }
    }

    @When("supplier failed update payment request to {string} status")
    public void supplierFailedUpdatePaymentRequestToStatus(String status) {
        paymentOverview.updatePaymentRequest(payId, status, 400);
    }

    @And("expiredDate will be {string}")
    public void expireddateWillBe(String date) {
        if (date.equals("today")) paymentOverview.verifyExpiredDate(Common.addedDatePayment(0));
        else if (date.equals("tomorrow")) paymentOverview.verifyExpiredDate(Common.addedDatePayment(1));
        else if (date.equals("yesterday")) paymentOverview.verifyExpiredDate(Common.addedDatePayment(-1));
    }

    @Given("user login as card admin or card user from company {int}")
    public void userLoginAsCardAdminOrCardUserFromCompany(int company) throws IOException {
        companyNumber = company;
        paymentOverview.setToken(company);
    }

    @And("there is Active future payment delegation for service A to company X")
    public void thereIsActiveFuturePaymentDelegationForServiceAToCompanyX() throws IOException {
        paymentDelegation.setToken(companyNumber);
        paymentDelegation.retrievePaymentDelegationSetting();
        if (paymentDelegation.thereIsNoDelegationSetting()){
            paymentDelegation.getAllSupplier();
            int index = 1;
            suppId = paymentDelegation.supplierId(index);
            productId = paymentDelegation.productId(index);
            paymentDelegation.createPaymentDelegation(productId, suppId, 200);
        }
    }

    @And("there is payment Z for service A with Outstanding and Upcoming status")
    public void thereIsPaymentZForServiceAWithOutstandingAndUpcomingStatus() {
        paymentOverview.createPaymentRequest("svs", 201);
        payId = paymentOverview.payId();
    }

    @Then("value of Delegated To is company X")
    public void valueOfDelegatedToIsCompanyX() {
        paymentOverview.retrievePaymentRequest(List.of(payId));
        paymentOverview.verifyDelegateToCompany(ApiProperties.emailCompany1());
    }

    @When("user delegate payment Z of service A to company Y")
    public void userDelegatePaymentZOfServiceAToCompanyY() throws IOException {
        paymentOverview.setToken(companyNumber);
        paymentOverview.delegatePaymentRequest(payId, ApiProperties.emailCompany3(), ApiProperties.companyName3());
    }

    @And("payment request Z sent to company {int} with Outstanding or Upcoming status")
    public void paymentRequestZSentToCompanyWithOutstandingOrUpcomingStatus(int company) throws IOException, InterruptedException {
        paymentOverview.setToken(company);
        int count = 0;
        payIds = List.of(payId);
        do {
            sleep(20000);
            paymentOverview.retrievePaymentRequest(payIds);
            count ++;
        } while ((!paymentOverview.paymentStatus().equals(List.of("OUTSTANDING").toString())) && (count < 5));
        paymentOverview.verifyPaymentStatusInPaymentRequest("OUTSTANDING");
    }

    @And("payment request Z status in company {int} changes to Withdrawn")
    public void paymentRequestZStatusInCompanyChangesToWithdrawn(int company) throws IOException {
        paymentOverview.setToken(company);
        paymentOverview.retrievePaymentOverview("DELEGATED_PAYMENT", "WITHDRAW");
        paymentOverview.verifyPaymentIdAppears(payId);
        paymentOverview.retrievePaymentRequest(List.of(payId));
        paymentOverview.verifyPaymentRequestNull();
    }

    @And("value of Delegated To changes to company Y")
    public void valueOfDelegatedToChangesToCompanyY() {
        paymentOverview.retrievePaymentRequest(List.of(payId));
        paymentOverview.verifyDelegateToCompany();
    }

    @And("payment delegation request for service A from company X to company Y has Active status")
    public void paymentDelegationRequestForServiceAFromCompanyXToCompanyYHasActiveStatus() throws IOException {
        paymentDelegation.setToken(companyNumber);
        paymentDelegation.retrievePaymentDelegationSetting();
        if (paymentDelegation.thereIsNoDelegationSetting()){
            int index = 1;
            paymentDelegation.getAllSupplier();
            suppId = paymentDelegation.supplierId(index);
            suppName = paymentDelegation.supplierName(index);
            productId = paymentDelegation.productId(index);
            productName = paymentDelegation.productName(index);
            paymentDelegation.createPaymentDelegation(productId, suppId, 200);
        }
    }

    @And("there is SI for service A in company Y")
    public void thereIsSIForServiceAInCompanyY() throws IOException {
        standingInstruction.setToken(1);
        standingInstruction.retrieveStandingInstruction("RECEIVED_PAYMENT");
        companyEmail = ApiProperties.emailCompany2();
        if (!standingInstruction.thereIsSIForCompany(companyEmail)){
            standingInstruction.retrieveCardToken();
            cardToken = standingInstruction.cardToken();

            paymentDelegation.setToken(1);
            paymentDelegation.getAllSupplier();
            int index = paymentDelegation.indexOfProduct(List.of(ApiProperties.productName("svs")));
            productId = paymentDelegation.productId(index);
            productName = paymentDelegation.productName(index);
            suppName = paymentDelegation.supplierName(index);
            suppId = paymentDelegation.supplierId(index);
            standingInstruction.createStandingInstruction(productId, productName, suppId, suppName, cardToken,
                    "RECEIVED_PAYMENT", companyEmail, 200);
        }
    }

    @Then("payment for service A of company X will be auto-deducted in company Y")
    public void paymentForServiceAOfCompanyXWillBeAutoDeductedInCompanyY() throws IOException {
        paymentOverview.setToken(1);
        paymentOverview.retrievePaymentOverview("DELEGATED_PAYMENT", 100);
        paymentOverview.verifyPaymentIdAppears(payId);
    }

    @When("there is payment for service A from company {int}")
    public void thereIsPaymentForServiceAFromCompany(int company) throws IOException {
        paymentOverview.setToken(company);
        paymentOverview.createPaymentRequest(400, Common.chargeDateTimePayment("MINUTES", 0), "", "", "", 201);
        payId = paymentOverview.payId();
    }

    @When("supplier update payment request with notes")
    public void supplierUpdatePaymentRequestWithNotes() {
        paymentOverview.updatePaymentRequest(payId, "AWB Number: 909090");
    }

    @Then("payment will have notes")
    public void paymentWillHaveNotes() {
        paymentOverview.retrievePaymentRequest(List.of(payId));
        paymentOverview.verifyNotesAppears();
    }

    @Given("supplier create payment request for {string} status with notes")
    public void supplierCreatePaymentRequestForStatusWithNotes(String status) throws IOException {
        paymentOverview.setToken(1);
        if (status.equals("Upcoming")) paymentOverview.createPaymentRequest(1000, Common.chargeDateTimePayment("MINUTES", 1), "", "", "first notes", 201);
        else if (status.equals("Outstanding")) paymentOverview.createPaymentRequest(1000, "", "", "", "first notes", 201);
        payId = paymentOverview.payId();
        paymentOverview.retrievePaymentRequest(List.of(payId));
    }

    @And("company {int} remove payment delegation of that payment")
    public void companyRemovePaymentDelegationOfThatPayment(int company) throws IOException {
        payIds = List.of(payId);
        paymentOverview.setToken(company);
        paymentOverview.removePaymentDelegationRequest(payIds);
        paymentOverview.verifyMessageBody("Success delete delegated payment request");
    }

    @And("in {int} minutes later")
    public void inMinutesLater(int minutes) throws InterruptedException {
        Thread.sleep(minutes * 1000);
    }

    @When("there is payment for service A from company {int} with deductionTime in {int} minutes")
    public void thereIsPaymentForServiceAFromCompanyWithDeductionTimeInMinutes(int company, int minutes) throws IOException {
        paymentOverview.setToken(company);
        paymentOverview.createPaymentRequest(400, Common.chargeDateTimePayment("MINUTES", 0), Common.chargeDateTimePayment("MINUTES", minutes), "", "", 201);
        payId = paymentOverview.payId();
    }

    @Then("payment will be deleted from company {int}")
    public void paymentWillBeDeletedFromCompany(int arg0) {
        paymentOverview.retrievePaymentRequest(payIds);
        paymentOverview.verifyPaymentRequestNull();
    }

    @And("value of Delegated To changes to null in company {int}")
    public void valueOfDelegatedToChangesToNull(int company) throws IOException {
        paymentOverview.setToken(company);
        paymentOverview.retrievePaymentRequest(payIds);
        paymentOverview.verifyDelegateToCompany("");
    }

    @When("user pay {int} of Outstanding my payments")
    public void userPayOfOutstandingMyPayments(int number) throws InterruptedException {
        List<JSONObject> paymentRequests = new ArrayList<>(){};
        payIds = new ArrayList<>();
        int amount = 40;
        for (int i = 0; i < number; i++){
            paymentOverview.createPaymentRequest(amount, Common.chargeDateTimePayment("MINUTES", 0), "", "", "", 201);
            Thread.sleep(1000);
            payId = paymentOverview.payId();
            payIds.add(payId);
            JSONObject paymentRequest = new JSONObject();
            paymentRequest.put("amount", amount);
            paymentRequest.put("id", payId);
            paymentRequest.put("suppId", ApiProperties.supplierId("svs"));
            paymentRequests.add(paymentRequest);
        }
        paymentOverview.createCheckoutSession(paymentRequests);
    }

    @Then("payment status changes to {string} in My Payment tab menu")
    public void paymentStatusChangesToInMyPaymentTabMenu(String status) {
        paymentOverview.retrievePaymentRequest(payIds);
        for (int i = 0; i < payIds.size(); i++)
            paymentOverview.verifyPaymentStatusInPaymentRequest(status, i);
    }
}
