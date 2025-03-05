package starter.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaymentPopupPage extends PageObject {

    private By subscribeButton = By.xpath("//button[text() = 'Subscribe']");
    private By totalAmount = By.xpath("//p[text() = 'Total Amount:']");
    private By savedCardRadio = By.xpath("//button[text() = 'Subscribe']");
    private By inputtedCardRadio = By.xpath("//button[text() = 'Subscribe']");
    private By saveCardCheckbox = By.xpath("//button[text() = 'Subscribe']");
    private By paynowRadio = By.xpath("//button[text() = 'Subscribe']");
    private By giroRadio = By.xpath("//button[text() = 'Subscribe']");
    private By cardNumberField = By.xpath("//button[text() = 'Subscribe']");
    private By expiredField = By.xpath("//button[text() = 'Subscribe']");
    private By cvcField = By.xpath("//button[text() = 'Subscribe']");
    private By payButton = By.xpath("//button[text() = 'Subscribe']");
    private By pleaseContactAdmin = By.xpath("//button[text() = 'Subscribe']");
    private By expiredWarning = By.xpath("//button[text() = 'Subscribe']");
    private By sgExceptionWarning = By.xpath("//button[text() = 'Subscribe']");
    private By errorWarning = By.xpath("//button[text() = 'Subscribe']");

    public void goToUrl(){
        openAt("/payment-popup-test/");
    }
    public boolean detailPaymentAppears(){
        return $$(totalAmount).size() == 1;
    }
    public boolean savedCardAppears(){ return $$(savedCardRadio).size() == 1; }
    //TODO
    public boolean verifySavedCardEnabled(){ return $$(savedCardRadio).size() == 1; }
    public boolean verifySavedCardDisabled(){ return $$(savedCardRadio).size() == 1; }
    public boolean inputtedCardAppears(){ return $$(inputtedCardRadio).size() == 1; }
    public void chooseInputtedCard(){ $(inputtedCardRadio).click(); }
    public boolean saveCardCheckboxAppears(){ return $$(saveCardCheckbox).size() == 1; }
    public boolean paynowAppears(){ return $$(paynowRadio).size() == 1; }
    public void choosePaynow(){ $(paynowRadio).click(); }
    public boolean giroAppears(){ return $$(giroRadio).size() == 1; }
    public void chooseGiro(){ $(giroRadio).click(); }
    public boolean payButtonAppears(){ return $$(payButton).size() == 1; }
    public void clickSubscribeButton(){ $(subscribeButton).click();}
    public void inputCardInformation(String cardNumber, String expired, String cvc){
        $(cardNumberField).type(cardNumber);
        $(expiredField).type(expired);
        $(cvcField).type(cvc);
    }
    public void clickPayButton(){ $(payButton).click(); }
    public boolean pleaseContactAppears(){ return $$(pleaseContactAdmin).size() == 1; }
    public boolean expiredWarnAppears(){ return $$(expiredWarning).size() == 1; }
    public boolean sgExceptionWarnAppears(){ return $$(sgExceptionWarning).size() == 1; }
    public boolean errorWarning(){ return $$(errorWarning).size() == 1; }
}
