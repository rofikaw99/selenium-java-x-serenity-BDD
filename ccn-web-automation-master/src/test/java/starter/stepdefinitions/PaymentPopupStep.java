package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import starter.pages.PaymentPopupPage;
import starter.utlis.Constants;

public class PaymentPopupStep {
    @Steps
    PaymentPopupPage paymentPopupPage;

    @When("user pay from the popup")
    public void userPayFromThePopup() {
        paymentPopupPage.goToUrl();
        paymentPopupPage.clickSubscribeButton();
    }

    @And("saved card with enabled icon will appears if {string} login")
    public void savedCardWithEnabledIconWillAppearsIfLogin(String user_type) {
        Assert.assertTrue(paymentPopupPage.savedCardAppears());
        paymentPopupPage.verifySavedCardEnabled();
    }

    @And("saved card with disabled icon will appears if user with saved card company login")
    public void savedCardWithDisabledIconWillAppearsIfUserWithSavedCardCompanyLogin() {
        Assert.assertTrue(paymentPopupPage.savedCardAppears());
        paymentPopupPage.verifySavedCardDisabled();
    }

    @And("option to input new card will appears for all of users")
    public void optionToInputNewCardWillAppearsForAllOfUsers() {
        Assert.assertTrue(paymentPopupPage.inputtedCardAppears());
    }

    @And("paynow option will appears for all users type")
    public void paynowOptionWillAppearsForAllUsersType() {
        Assert.assertTrue(paymentPopupPage.paynowAppears());
    }

    @And("giro option will appears for user with giro saved in company")
    public void giroOptionWillAppearsForUserWithGiroSavedInCompany() {
        Assert.assertTrue(paymentPopupPage.giroAppears());
    }

    @And("there is Pay button")
    public void thereIsPayButton() {
        Assert.assertTrue(paymentPopupPage.payButtonAppears());
    }

    @Then("detail of payment items will appears")
    public void detailOfPaymentItemsWillAppears() {
        Assert.assertTrue(paymentPopupPage.detailPaymentAppears());
    }

    @When("pay payment with {string}")
    public void payPaymentWith(String method) {
        switch (method){
            case "saved card selected":
                //doesn't do anything here
                break;
            case "the valid setup card":
                paymentPopupPage.inputCardInformation(Constants.CARD_DUPLICATE, Constants.CARD_EXP_DATE, Constants.CARD_CVC);
                break;
            case "paynow":
                paymentPopupPage.choosePaynow();
                break;
            case "giro":
                paymentPopupPage.chooseGiro();
                break;
            case "non-visa card":
                paymentPopupPage.inputCardInformation(Constants.CARD_NON_VISA, Constants.CARD_EXP_DATE, Constants.CARD_CVC);
                break;
            case "non-singapore card":
                paymentPopupPage.inputCardInformation(Constants.CARD_NON_VISA_SINGAPORE, Constants.CARD_EXP_DATE, Constants.CARD_CVC);
                break;
        }
        paymentPopupPage.clickPayButton();
    }

    @And("select non-saved card option")
    public void selectNonSavedCardOption() {
        paymentPopupPage.chooseInputtedCard();
    }

    @And("setup card form appears without save payment method checkbox")
    public void setupCardFormAppearsWithoutSavePaymentMethodCheckbox() {
        Assert.assertTrue(paymentPopupPage.inputtedCardAppears());
        Assert.assertFalse(paymentPopupPage.saveCardCheckboxAppears());
    }

    @And("non-saved card option is auto-selected")
    public void nonSavedCardOptionIsAutoSelected() {
        Assert.assertTrue(paymentPopupPage.pleaseContactAppears());
        //TODO
    }
}
