package starter.pages;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import starter.utlis.Common;
import starter.utlis.Constants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static net.serenitybdd.rest.SerenityRest.*;

public class PaymentMethodPage extends PageObject {

    private int waitResponse = 3000;
    private By loadingPage = By.xpath("//*[@class = 'cube-spinner-container']");
    private By headerMyMethods = By.xpath("//*[text() = 'My Payment Methods']");

    //Payment Method Page
    private By setupCardHeader = By.xpath("//div[text() = 'Set up Commercial Card']");
    private By cardInformationHeader = By.xpath("//div[text() = 'Commercial Card Information']");
    private By btnsetupCompany = By.xpath("//*[div[contains(text(), 'company')]]//button[text() = 'Set Up']");
    private By btnAddNewSI = By.xpath("//p[text() = 'Add New']");

    //Card Section
    private By btnDeleteCard = By.xpath("//*[@class = 'btn-delete']");
    private By btnEyes = By.xpath("//*[@class = 'show-icon-container']");
    private By btnEyesHidden = By.xpath("//*[@class = 'hidden']//*[@class = 'show-icon-container']");
    private By txtCardNo = By.xpath("//*[@class = 'visa-number']");

    //Popup Confirmation Remove Commercial Card
    private By btnConfirm = By.id("cube-confirm-remove-commercial-card");
    private By btnCancel = By.id("cube-cancel-remove-commercial-card");

    //Setup Commercial Card Popup
    private By iframeCard = By.xpath("(//*[@id = 'payment-form']//iframe[contains(@name, '__privateStripeFrame')])");
    private By fieldCardHolderName = By.xpath("//*[contains(@class, 'cube-setup-form')]//*[@id = 'payment-form']//*[@id = 'cube-card-holder-name']");
    private By fieldCardNumber = By.xpath("//*[@placeholder = '1234 1234 1234 1234']");
    private By fieldExpDate = By.xpath("//*[@name = 'exp-date']");
    private By fieldCvc = By.xpath("//*[@name = 'cvc']");
    private By fieldEmail = By.xpath("//*[contains(@class, 'cube-setup-form')]//*[@id = 'payment-form']//*[@id = 'cube-email']");
    private By fieldFullName = By.id("Field-nameInput");
    private By fieldCountry = By.id("Field-countryInput");
    private By fieldAddressLine1 = By.id("Field-addressLine1Input");
    private By fieldPostalCode = By.id("Field-postalCodeInput");
    private By btnSave = By.xpath("//*[contains(@class, 'cube-setup-form')]//*[@id='submit']");
    private By btnSaveDisabled = By.xpath("(//*[contains(@id, 'payment-form')]//*[@id='submit'])[2]");

    //Authorized User Section
    private By txtListOfUser = By.xpath("//*[text() = 'List of Card User:']");
    private By btnAddUser = By.xpath("//*[text() = 'Add Users']");
    private By fieldEmailUser = By.xpath("//*[@class = 'cube-input-email-input']");
    private By dropdownEmailUser = By.xpath("//*[@class='cube-dropdown-option']");
    private By dropdownEmailUser(String email){
        return By.xpath("//*[@class='cube-dropdown-option' and text() = '"+ email +"']");
    }
    private By btnConfirmUser = By.xpath("//*[text() = 'Confirm']");
    private By btnConfirmAddUser = By.id("btn-confirm-add-user");
    private By btnInviteUser = By.xpath("//*[text() = 'Invite']");
    private By btnInviteAllUser = By.xpath("//*[text() = 'Invite All Users']");
    private By btnConfirmInvite = By.id("btn-confirm-invite");
    private By btnRemove = By.id("btn-remove-user");
    private By txtInfoInviteUser = By.xpath("//*[text() = 'User(s) is not a member of your company']");
    private By authorizedEmailTxt = By.xpath("//*[text() = 'User(s) is not a member of your company']"); //todo get the email
    private By listOfInvitedUser = By.xpath("//*[@class = 'warning-card-content']//li");
    private By listOfAuthorizedUser = By.xpath("//div[contains(@class, 'mt-[24px]')]//li");

    //Popup Remove Authorized User
    private By checkboxTransferSI = By.xpath("//*[@class = 'cube-modal' and @style = 'display: block;']//*[text()= 'Transfer Standing Instructions']");
    private By fieldEmailTransfer = By.xpath("(//div[//div[text() = 'Email']]//*[@class = 'cube-dropdown-selected']//input)[1]");
    private By btnConfirmRemoveInvitedUser = By.id("cube-confirm-remove-user-email");

    //SI Table
    private By txtSINo = By.xpath("//*[@id = 'si-number']/p");
    private By txtSIManageBy = By.xpath("//tr//*[@class = 'row-label'][6]//div");
    private By actionBtn = By.id("si-delete");
    private By confirmRemoveSIBtn = By.id("cube-columns-apply");

    //Create SI Popup
    private By fieldSupplier = By.xpath("//input[@placeholder = 'Supplier Name']");
    private By dropdownSupplier = By.id("si-supplier-name-item");
    private By fieldStartDate = By.xpath("(//input[@placeholder = 'Select Start Date'])[1]");
    private By fieldEndDate = By.xpath("//input[@placeholder = 'Select End Date']");
    private By fieldEndDateUpdate = By.xpath("(//input[@placeholder = 'Select End Date'])[2]");
    private By datePicker(int addedDate) {
        String date = Common.addDate(addedDate);
        return By.xpath("//*[@aria-disabled = 'false']//*[@class = 'cube-date-range-day-container']//*[text() = '"+ date +"']");
    }
    private By fieldThreshold = By.id("cube-threshold");
    private By fieldThresholdUpdate = By.xpath("(//*[@id = 'cube-threshold'])[2]");
    private By fieldManageByEnabled = By.xpath("(//input[@placeholder = 'Manage By' and contains(@style, 'auto') ])");
    private By fieldManageByDisabled = By.xpath("(//input[@placeholder = 'Manage By' and contains(@style, 'default') ])");
    private By fieldManageBy = By.xpath("");
    private By btnSaveSI = By.id("si-add-new");
    private By btnSaveSIUpdate = By.id("si-update");
    private By btnOk = By.xpath("//*[contains(@class, 'si-modal-confirm')]//button[text() = 'OK']");

    private By specEmail(String email){
        return By.xpath("//div[//*[text() = 'List of Authorized Users:']]//*[text()='"+ email+"']" );
    }

    private By invitedEmail(String email){
        return By.xpath("//div[//*[text() = 'User(s) is not a member of your company']]//*[text()='" + email +"']" );
    }

    public boolean getErrorMsgText(String message){
        By errorMsg = By.xpath("//*[text() = \""+ message +"\"]");
        return $$(errorMsg).size() == 1;
    }

    public void goToPayment() throws InterruptedException {
//        openAt(Constants.URL_PAYMENT_METHODS);
        Thread.sleep(20000);
        $(headerMyMethods).waitUntilPresent();
        Assert.assertTrue($(headerMyMethods).isPresent());
    }

    public void goToMyCompany(){
        openAt(Constants.URL_PATH_COMPANY);
    }
    public boolean setupCardHeaderDisplayed(){
        return $$(setupCardHeader).size() == 1;
    }

    public boolean fieldSupplierDisplayed(){
        return $$(fieldSupplier).size() == 1;
    }

    public boolean siNoDisplayed(){
        return $$(txtSINo).size() == 1;
    }

    public boolean cardInfoHeaderDisplayed(){
        return $$(cardInformationHeader).size() == 2;
    }
    public boolean btnSetupCompanyDisplayed(){
        return $$(btnsetupCompany).size() == 1;
    }
    public boolean btnEyesCardDisplayed(){
        return $$(btnEyes).size() == 1;
    }
    public boolean btnEyesCardHidden(){
        return $$(btnEyesHidden).size() == 1;
    }
    public boolean btnRemoveDisplayed(){
        return $$(btnRemove).size() == 1;
    }
    public boolean btnRemoveSIDisplayed(){
        return $$(actionBtn).size() == 1;
    }
    public boolean btnSaveDisabled(){
        return $(btnSave).isDisabled();
    }

    public boolean btnInviteDisplayed(){
        return $$(btnInviteUser).size() == 1;
    }
    public boolean txtInfoInviteUserDisplayed(){
        return $$(txtInfoInviteUser).size() == 1;
    }

    public boolean txtSpecEmailDisplayed(String email){
        evaluateJavascript("window.scrollBy(0,150)", "");
        return $$(specEmail(email)).size() == 1;
    }

    public boolean txtInvitedEmailDisplayed(String email){
        return $$(invitedEmail(email)).size() == 1;
    }

    public boolean txtCardNoDisplayed(){
        return $$(txtCardNo).size() == 1;
    }
    public boolean txtListOfUserDisplayed(){
        return $$(txtListOfUser).size() == 1;
    }
    public int numberOfSI(){
        return getDriver().findElements(txtSINo).size();
    }
    public boolean btnDeleteCardEnabled(){
        return $(btnDeleteCard).isEnabled();
    }
    public boolean btnDeleteCardDisplayed(){
        return $$(btnDeleteCard).size() == 1;
    }
    public boolean fieldManageByEnabled(){
        return $$(fieldManageByEnabled).size() == 1;
    }

    public boolean fieldManageByDisabled(){
        return $$(fieldManageByDisabled).size() == 1;
    }
    public boolean checkboxTransferDisplayed(){
        return $$(checkboxTransferSI).size() == 2;
    }

    public boolean btnAddSIDisplayed(){
        return $$(btnAddNewSI).size() == 1;
    }
    public String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }

    public void checkTransferSI(){
        $(checkboxTransferSI).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(checkboxTransferSI));
    }

    public void waitLoadingDisappears(){
        setWaitForTimeout(50000);
        $(loadingPage).waitUntilNotVisible();
        Assert.assertEquals(0, $$(loadingPage).size());
    }

    public void inputEmailToTransferSI(String email){
        $(fieldEmailTransfer).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(fieldEmailTransfer));
        By emailSi = By.xpath("//*[contains(@class, 'cube-dropdown-item') and text() = '" + email +"']");
        evaluateJavascript("arguments[0].click();", $(emailSi));
    }
    public void clickAddUserBtn(){
        evaluateJavascript("arguments[0].click();", $(btnAddUser));
    }

    public void clickAddNewSIBtn(){
        $(btnAddNewSI).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(btnAddNewSI));
    }

    public void clickConfirmRemoveSIBtn(){
        evaluateJavascript("arguments[0].click();", $(confirmRemoveSIBtn));
    }

    public void clickOkBtn(){
        $(btnOk).waitUntilPresent();
        evaluateJavascript("arguments[0].click();", $(btnOk));
    }

    public void clickRemoveBtn(){
        $(btnRemove).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(btnRemove));
    }

    public void clickSetupCompanyBtn(){
        $(btnsetupCompany).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(btnsetupCompany));
    }

    public void clickEyesBtn(){
        evaluateJavascript("arguments[0].click();", $(btnEyes));
    }

    public void clickConfirmRemoveCardBtn(){
        $(btnConfirm).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(btnConfirm));
    }

    public void clickConfirmRemoveUserBtn(){
        $(btnConfirmRemoveInvitedUser).waitUntilPresent();
        evaluateJavascript("arguments[0].click();", $(btnConfirmRemoveInvitedUser));
    }

    public void clickConfirmInviteUserBtn(){
        $(btnConfirmInvite).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(btnConfirmInvite));
    }

    public void waitUntilButtonConfirmDisappear(){
        $(btnConfirmInvite).waitUntilNotVisible();
    }

    public void clickDeleteCardBtn(){
        $(btnDeleteCard).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(btnDeleteCard));
    }

    public void clickRemoveSIBtn(int index){
        $(actionBtn).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $$(actionBtn).get(index));
    }

    public void clickRemoveUserBtn(int index){
        evaluateJavascript("arguments[0].click();", $$(btnRemove).get(index));
    }

    public void inputCardHolderName(String cardHolderName){
        $(fieldCardHolderName).waitUntilVisible();
        $(fieldCardHolderName).type(cardHolderName);
    }

    public void inputCardNumber(String cardNumber){
        getDriver().switchTo().frame(getDriver().findElements(iframeCard).get(3));
        $(fieldCardNumber).sendKeys(cardNumber);
        getDriver().switchTo().defaultContent();
    }

    public void inputExpDate(String expDate){
        getDriver().switchTo().frame(getDriver().findElements(iframeCard).get(4));
        $(fieldExpDate).sendKeys(expDate);
        getDriver().switchTo().defaultContent();
    }

    public void inputCvc(String cvc){
        getDriver().switchTo().frame(getDriver().findElements(iframeCard).get(5));
        $(fieldCvc).sendKeys(cvc);
        getDriver().switchTo().defaultContent();
    }

    public void clickSaveBtn(){
        evaluateJavascript("arguments[0].click();", $(btnSave));
    }

    public void clickSaveSIBtn(){
        $(btnSaveSI).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(btnSaveSI));
    }

    public void clickSaveSIUpdateBtn(){
        $(btnSaveSIUpdate).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(btnSaveSIUpdate));
    }

    public void clickConfirmUserBtn(){
        $(btnConfirmUser).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(btnConfirmUser));
    }

    public void clickConfirmAddUserBtn(){
        $(btnConfirmAddUser).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(btnConfirmAddUser));
    }

    public void clickInviteUserBtn(){
        $(btnInviteUser).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(btnInviteUser));
    }

    public void clickInviteUserBtn(int index){
        $(btnInviteUser).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $$(btnInviteUser).get(index));
    }

    public void clickInviteAllUserBtn(){
        $(btnInviteAllUser).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(btnInviteAllUser));
    }

    public void inputEmailUser(List<String> emails){
        $(fieldEmailUser).waitUntilVisible();
        for (String email : emails) {
            $(fieldEmailUser).sendKeys(email);
            $(fieldEmailUser).sendKeys(Keys.ENTER);
        }
    }

    public void inputSupplier(int index) throws InterruptedException {
        Thread.sleep(3000);
        $(fieldSupplier).waitUntilPresent();
        evaluateJavascript("arguments[0].click();", $(fieldSupplier));
        evaluateJavascript("arguments[0].click();", $$(dropdownSupplier).get(index));
    }

    public void inputStartDate(int startDate){
        $(fieldStartDate).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(fieldStartDate));
        evaluateJavascript("arguments[0].click();", $(datePicker(startDate)));
    }

    public void inputEndDate(int endDate){
        $(fieldEndDate).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(fieldEndDate));
        evaluateJavascript("arguments[0].click();", $(datePicker(endDate)));
    }

    public void updateEndDateUpdate(int endDate) {
        evaluateJavascript("arguments[0].click();", $(fieldEndDateUpdate));
        evaluateJavascript("arguments[0].click();", $(datePicker(endDate)));
    }

    public void inputThreshold(String threshold){
        evaluateJavascript("arguments[0].click();", $(fieldThreshold));
        $(fieldThreshold).type(threshold);
    }

    public void updateThreshold(String threshold){
        evaluateJavascript("arguments[0].click();", $(fieldThresholdUpdate));
        $(fieldThresholdUpdate).clear();
        $(fieldThresholdUpdate).type(threshold);
    }

    public void chooseSINo(){
        ListOfWebElementFacades siNumbers = $$(txtSINo);
        int index = siNumbers.size() - 1;
        evaluateJavascript("arguments[0].click();", siNumbers.get(index));
    }

    public void chooseSINo(int index){
        ListOfWebElementFacades siNumbers = $$(txtSINo);
        evaluateJavascript("arguments[0].click();", siNumbers.get(index));
    }

    public String chooseEmailUser() throws InterruptedException {
        $(fieldEmailUser).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(fieldEmailUser));
        Thread.sleep(1000);
        ListOfWebElementFacades dropdownEmailUsers = $$(dropdownEmailUser);

        WebElementFacade selectedEmail  = dropdownEmailUsers.get(0);
        evaluateJavascript("arguments[0].click();", selectedEmail);
        return selectedEmail.getText();
    }

    public void chooseEmailUser(String email){
        $(fieldEmailUser).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(fieldEmailUser));
        evaluateJavascript("arguments[0].click();", $(dropdownEmailUser(email)));
    }

    public Integer indexOfEmail(String email){
        int index = 0;
        List<WebElement> emails = getDriver().findElements(listOfInvitedUser);
        for (WebElement e: emails){
            if(e.getText().equals(email)){
                index = emails.indexOf(e);
                break;
            }
        }
        return index;
    }

    public Boolean checkingInvitedUser(String email){
        Boolean have = false;
        List<WebElement> emails = getDriver().findElements(listOfInvitedUser);
        for (WebElement e: emails){
            if(e.getText().equals(email)){
                have = true;
            }
        }
        return have;
    }

    public List<String> inviteEmailUser(){
        List<WebElement> emails = getDriver().findElements(listOfInvitedUser);
        List<String> emailsTxt = new ArrayList<>();
        for (WebElement e: emails){
            emailsTxt.add(e.getText().toLowerCase());
        }
        return emailsTxt;
    }

    public List<String> manageEmailSI(){
        List<WebElement> emails = getDriver().findElements(txtSIManageBy);
        List<String> emailsTxt = new ArrayList<>();
        for (WebElement e: emails){
            emailsTxt.add(e.getText().toLowerCase());
        }
        return emailsTxt;
    }

    public List<String> emailAuthorizedUser(){
        List<WebElement> emails = getDriver().findElements(listOfAuthorizedUser);
        List<String> emailsTxt = new ArrayList<>();
        for (WebElement e: emails){
            emailsTxt.add(e.getText());
            System.out.println(e.getText());
        }
        return emailsTxt;
    }

    public List<Boolean> enabledActionBtn(){
        List<WebElement> actionBtns = getDriver().findElements(actionBtn);
        List<Boolean> enableConditions = new ArrayList<>();
        for (WebElement e: actionBtns){
            if (e.getAttribute("class").contains("cursor-not-allowed")) enableConditions.add(false);
            else if (e.getAttribute("class").contains("cursor-pointer")) enableConditions.add(true);
        }
        return enableConditions;
    }

    public List<Boolean> enabledSINumberBtn(){
        List<WebElement> SINumbers = getDriver().findElements(txtSINo);
        List<Boolean> enableConditions = new ArrayList<>();
        for (WebElement e: SINumbers){
            if (e.getAttribute("class").contains("cursor-not-allowed")) enableConditions.add(false);
            else if (e.getAttribute("class").contains("cursor-pointer")) enableConditions.add(true);
        }
        return enableConditions;
    }

    public void setupCommercialCard(String cardNo) throws InterruptedException {
        if (!btnEyesCardDisplayed()) {
            inputCardNumber(cardNo);
            inputExpDate(Constants.CARD_EXP_DATE);
            inputCvc(Constants.CARD_CVC);
            clickSaveBtn();
            Thread.sleep(3000);
            Assert.assertTrue(btnEyesCardDisplayed());
        }
    }

    public void removeCommercialCard() throws InterruptedException {
        if (btnEyesCardDisplayed()) {
            clickDeleteCardBtn();
            clickConfirmRemoveCardBtn();
            Thread.sleep(10000);
            Assert.assertTrue(setupCardHeaderDisplayed());
        }
    }

    public void createNewSI(int index) throws InterruptedException {
        clickAddNewSIBtn();
        inputSupplier(index);
        inputStartDate(4);
        inputEndDate(10);
        inputThreshold("900");
        clickSaveSIBtn();
        Thread.sleep(3000); //wait for UI loading
    }

    public void selectTransferManageBy(String email){
        By emailTransfer = By.xpath("//*[contains(@class, 'cube-dropdown-item') and text() = '" + email + "']");
        evaluateJavascript("arguments[0].click();", $(emailTransfer));
    }

    public void addAuthorizedUser(String email){
        clickAddUserBtn();
        chooseEmailUser(email);
        clickConfirmAddUserBtn();
    }
}
