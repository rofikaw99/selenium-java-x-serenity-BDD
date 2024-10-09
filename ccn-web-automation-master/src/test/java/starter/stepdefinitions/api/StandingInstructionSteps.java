package starter.stepdefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.api.PaymentDelegation;
import starter.api.StandingInstruction;

import java.io.IOException;

public class StandingInstructionSteps {
    @Steps
    StandingInstruction standingInstruction;

    @Steps
    PaymentDelegation paymentDelegation;

    private String suppId, productId, suppName, productName, cardToken, companyEmail, siId;

    @Given("User login as card admin or card user or user")
    public void userLoginAsCardAdminOrCardUserOrUser() throws IOException {
        standingInstruction.setToken(1);
    }

    @And("company has Active future payment delegation for service A")
    public void companyHasActiveFuturePaymentDelegationForServiceA() throws IOException {
        paymentDelegation.setToken(1);
        paymentDelegation.retrievePaymentDelegationSetting();

        paymentDelegation.getAllSupplier();
        suppId = paymentDelegation.supplierId(0);
        productId = paymentDelegation.productId(0);
        suppName = paymentDelegation.supplierName(0);
        productName = paymentDelegation.productName(0);

        if (paymentDelegation.thereIsNoDelegationSetting()) {
            paymentDelegation.createPaymentDelegation(productId, suppId, 200);
        }
    }

    @When("user create SI for service A")
    public void userCreateSIForServiceA() {
        standingInstruction.retrieveCardToken();
        cardToken = standingInstruction.cardToken();
        standingInstruction.createStandingInstruction(productId, productName, suppId, suppName, cardToken, "MY_PAYMENT", 1, 400);
    }

    @Then("error message can't create SI when has payment delegation appears")
    public void errorMessageCanTCreateSIWhenHasPaymentDelegationAppears() {
        standingInstruction.verifyMessageAppears("");
    }

    @When("user create SI for service A of company X")
    public void userCreateSIForServiceAOfCompanyX() throws IOException {
        int index = 1;
        paymentDelegation.setToken(1);
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
            suppId = standingInstruction.supplierId(0);
            suppName = standingInstruction.supplierName(0);
            productId = standingInstruction.productId(0);
            productName = standingInstruction.productName(0);
        } else {
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
        standingInstruction.verifyMessageAppears("");
    }
}
