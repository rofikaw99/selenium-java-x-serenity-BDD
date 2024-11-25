package starter.stepdefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.api.PaymentDelegation;
import starter.api.StandingInstruction;
import starter.utlis.ApiProperties;

import java.io.IOException;
import java.util.List;

public class StandingInstructionSteps {
    @Steps
    StandingInstruction standingInstruction;

    @Steps
    PaymentDelegation paymentDelegation;

    private String suppId, productId, suppName, productName, cardToken, companyEmail, siId, delegationId;
    private int companyNumber;

    @Given("User login as card admin or card user or user")
    public void userLoginAsCardAdminOrCardUserOrUser() throws IOException {
        companyNumber = 1;
        standingInstruction.setToken(companyNumber);
    }

    @And("company has Active future payment delegation for service A")
    public void companyHasActiveFuturePaymentDelegationForServiceA() throws IOException {
        paymentDelegation.setToken(companyNumber);
        paymentDelegation.retrievePaymentDelegationSetting();

        if (paymentDelegation.thereIsNoDelegationSetting()) {
            String product = ApiProperties.productName("svs");
            paymentDelegation.getAllSupplier();
            int index = paymentDelegation.indexOfProduct(List.of(product));
            suppId = paymentDelegation.supplierId(index);
            productId = paymentDelegation.productId(index);
            suppName = paymentDelegation.supplierName(index);
            productName = paymentDelegation.productName(index);
            paymentDelegation.createPaymentDelegation(productId, suppId, 200);
        } else {
            suppId = paymentDelegation.supplierIdListDelegation(0);
            productId = paymentDelegation.productIdListDelegation(0);
            suppName = paymentDelegation.supplierNameListDelegation(0);
            productName = paymentDelegation.productNameListDelegation(0);
        }
    }

    @When("user create SI for service A with status code {int}")
    public void userCreateSIForServiceAWithStatusCode(int statusCode) {
        standingInstruction.retrieveCardToken();
        cardToken = standingInstruction.cardToken();
        paymentDelegation.getAllSupplier();
        int index = paymentDelegation.indexOfProduct(List.of(ApiProperties.productName("svs")));
        productId = paymentDelegation.productId(index);
        productName = paymentDelegation.productName(index);
        suppId = paymentDelegation.supplierId(index);
        suppName = paymentDelegation.supplierName(index);
        standingInstruction.createStandingInstruction(productId, productName, suppId, suppName, cardToken, "MY_PAYMENT", 1, statusCode);
        siId = standingInstruction.siId();
    }

    @Then("error message can't create SI when has payment delegation appears")
    public void errorMessageCanTCreateSIWhenHasPaymentDelegationAppears() {
        standingInstruction.verifyMessageAppears("There is active Payment Delegation Setting for supplierId ["+suppId+"] and productServiceId ["+productId+"]");
    }

    @When("user create SI for service A of company X")
    public void userCreateSIForServiceAOfCompanyX() throws IOException {
        int index = 1;
        paymentDelegation.setToken(companyNumber);
        standingInstruction.setToken(companyNumber);
        standingInstruction.retrieveStandingInstruction("RECEIVED_PAYMENT");
        if (standingInstruction.thereIsSI()){
            List<String> siIds = standingInstruction.listOfSiId();
            List<String> productIds = standingInstruction.listOfProductIdSi();
            int numOfSi = siIds.size();
            for (int i = 0; i < numOfSi; i++) {
                siId = siIds.get(i);
                productId = productIds.get(i);
                standingInstruction.deleteStandingInstruction(siId, productId);
            }
        }
        paymentDelegation.getAllSupplier();
        suppId = paymentDelegation.supplierId(index);
        productId = paymentDelegation.productId(index);
        suppName = paymentDelegation.supplierName(index);
        productName = paymentDelegation.productName(index);

        standingInstruction.retrieveCompanyIdentities();
        companyEmail = standingInstruction.companyEmail(0);

        standingInstruction.retrieveCardToken();
        cardToken = standingInstruction.cardToken();

        standingInstruction.createStandingInstruction(productId, productName, suppId, suppName, cardToken, "RECEIVED_PAYMENT", companyEmail, 200);
        siId = standingInstruction.siId();

    }

    @Then("able to create SI of service A of company X")
    public void ableToCreateSIOfServiceAOfCompanyX() {
        standingInstruction.retrieveStandingInstruction("RECEIVED_PAYMENT");
        standingInstruction.verifySiCreatedInList(siId);
    }

    @When("user create SI for service A of company Y")
    public void userCreateSIForServiceAOfCompanyY() {
        standingInstruction.retrieveCompanyIdentities();
        companyEmail = standingInstruction.companyEmail(1);

        standingInstruction.createStandingInstruction(productId, productName, suppId, suppName, cardToken, "RECEIVED_PAYMENT", companyEmail, 200);
        siId = standingInstruction.siId();
    }

    @Then("able to create SI of service A of company Y")
    public void ableToCreateSIOfServiceAOfCompanyY() {
        standingInstruction.retrieveStandingInstruction("RECEIVED_PAYMENT");
        standingInstruction.verifySiCreatedInList(siId);
    }

    @And("user has SI of service A for company X")
    public void userHasSIOfServiceAForCompanyX() throws IOException {
        standingInstruction.retrieveStandingInstruction("RECEIVED_PAYMENT");
        if (standingInstruction.thereIsSI()){
            companyEmail = standingInstruction.companyEmailFromRetrieveSI(0);
            suppId = standingInstruction.supplierIdFromSi(0);
            suppName = standingInstruction.supplierNameFromSi(0);
            productId = standingInstruction.productIdFromSi(0);
            productName = standingInstruction.productNameFromSi(0);
        } else {
            paymentDelegation.setToken(companyNumber);
            paymentDelegation.getAllSupplier();
            suppId = paymentDelegation.supplierId(0);
            productId = paymentDelegation.productId(0);
            suppName = paymentDelegation.supplierName(0);
            productName = paymentDelegation.productName(0);

            standingInstruction.retrieveCompanyIdentities();
            companyEmail = standingInstruction.companyEmail(0);

            standingInstruction.retrieveCardToken();
            cardToken = standingInstruction.cardToken();

            standingInstruction.createStandingInstruction(productId, productName, suppId, suppName, cardToken, "RECEIVED_PAYMENT", companyEmail, 200);
        }
    }

    @When("user create SI of service A in company X")
    public void userCreateSIOfServiceAInCompanyX() {
        standingInstruction.retrieveCardToken();
        cardToken = standingInstruction.cardToken();
        standingInstruction.createStandingInstruction(productId, productName, suppId, suppName, cardToken, "RECEIVED_PAYMENT", companyEmail, 400);
    }

    @Then("unable to create SI of same service in company X")
    public void unableToCreateSIOfSameServiceInCompanyX() {
        standingInstruction.verifyMessageAppears("There is active RECEIVED_PAYMENT Standing Instruction for supplierId "+ suppId +" and productServiceId " + productId);
    }

    @When("user retrieve {string} of standing instruction")
    public void userRetrieveOfStandingInstruction(String type) {
        standingInstruction.retrieveStandingInstruction(type);
    }

    @Then("success retrieve standing instruction")
    public void successRetrieveStandingInstruction() {
        standingInstruction.verifyMessageAppears("Sucess retrieve Standing Instructions");
    }

    @When("user retrieve card token")
    public void userRetrieveCardToken() {
        standingInstruction.retrieveCardToken();
    }

    @Then("there is no {int} last card number")
    public void thereIsNoLastCardNumber(int arg0) {
        standingInstruction.thereIsNoDetailCard();
    }

    @Then("card number success retrieve")
    public void cardNumberSuccessRetrieve() {
        standingInstruction.thereIsDetailCard();
    }

    @When("user retrieve {int} last card number")
    public void userRetrieveLastCardNumber(int arg0) {
        standingInstruction.retrieveLastNumber();
    }

    @Given("User login as card admin or card user or user from company {int}")
    public void userLoginAsCardAdminOrCardUserOrUserFromCompany(int company) throws IOException {
        companyNumber = company;
        standingInstruction.setToken(company);
        paymentDelegation.setToken(company);
    }

    @And("company doesn't has Active future payment delegation for service A")
    public void companyDoesnTHasActiveFuturePaymentDelegationForServiceA() throws IOException {
        paymentDelegation.setToken(companyNumber);
        paymentDelegation.retrievePaymentDelegationSetting();
        List<String> delegationIds = paymentDelegation.paymentDelegationId();
        for (String id : delegationIds) {
            paymentDelegation.deletePaymentDelegation(id, 200);
        }
        standingInstruction.retrieveStandingInstruction("MY_PAYMENT");
        if (standingInstruction.thereIsSI()){
            siId = standingInstruction.listOfSiId().get(0);
            productId = standingInstruction.productIdFromSi(0);
            standingInstruction.deleteStandingInstruction(siId, productId);
        }
    }

    @When("user create SI for service A for company {int}")
    public void userCreateSIForServiceAForCompany(int company)  {
        int index = 1;
        paymentDelegation.getAllSupplier();
        suppId = paymentDelegation.supplierId(index);
        productId = paymentDelegation.productId(index);
        suppName = paymentDelegation.supplierName(index);
        productName = paymentDelegation.productName(index);

        standingInstruction.retrieveCardToken();
        cardToken = standingInstruction.cardToken();

        standingInstruction.createStandingInstruction(productId, productName, suppId, suppName, cardToken, "MY_PAYMENT", companyEmail, 200);
        siId = standingInstruction.siId();
    }

    @Then("SI for service A successfully created")
    public void siForServiceASuccessfullyCreated() {
        standingInstruction.retrieveStandingInstruction("MY_PAYMENT");
        standingInstruction.verifySiCreatedInList(siId);
    }
}
