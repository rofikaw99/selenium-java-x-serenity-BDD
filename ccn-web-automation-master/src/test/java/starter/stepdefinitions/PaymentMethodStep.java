package starter.stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import starter.pages.*;
import starter.utlis.Common;
import starter.utlis.Constants;

import java.util.*;

public class PaymentMethodStep {

    @Steps
    LoginPage loginPage;

    @Steps
    CompanyPage companyPage;

    @Steps
    PaymentMethodPage paymentMethodPage;

    @Steps
    GoToUrl goToUrl;

    @Steps
    MailServiceYopmailPage mailServiceYopmailPage;

    private int waitResponse = 5000;
    private int waitLongResponse = 20000;
    private String email = "";
    private List<String> emails = new LinkedList<>();
    private int index = 0;
    private List<Integer> indexes = new LinkedList<>();
    private int emailLength = 0;

    public void goToPayment() throws Exception {
        companyPage.myMenuAccount("My Payment Methods");
        paymentMethodPage.goToPayment();
    }
    public void createAuthorizedUser() throws Exception {
        if (!paymentMethodPage.btnEyesCardDisplayed()) {
            companyPage.myMenuAccount("Sign Out");

            Thread.sleep(3000);
            loginPage.login(Constants.EMAIL_CARD_OWNER_WITH_COMPANY);
            goToPayment();
            paymentMethodPage.setupCommercialCard(Constants.CARD_TO_BE_DELETED);
            paymentMethodPage.clickAddUserBtn();
            paymentMethodPage.chooseEmailUser(Constants.EMAIL_AUTHORIZED_USER);
            paymentMethodPage.clickConfirmAddUserBtn();
            Thread.sleep(3000);

            companyPage.myMenuAccount("Sign Out");
            Thread.sleep(3000);
            loginPage.login(email);
            goToPayment();
            Assert.assertTrue(paymentMethodPage.btnEyesCardDisplayed());
        }
    }

    public void createAuthorizedUser(String cardEmail, String authEmail) throws Exception {
        if (!paymentMethodPage.btnEyesCardDisplayed()) {
            companyPage.myMenuAccount("Sign Out");

            Thread.sleep(3000);
            loginPage.login(cardEmail);
            goToPayment();
            paymentMethodPage.setupCommercialCard(Constants.CARD_TO_BE_DELETED);
            paymentMethodPage.clickAddUserBtn();
            paymentMethodPage.chooseEmailUser(authEmail);
            paymentMethodPage.clickConfirmAddUserBtn();
            Thread.sleep(3000);

            companyPage.myMenuAccount("Sign Out");
            Thread.sleep(3000);
            loginPage.login(authEmail);
            goToPayment();
            Assert.assertTrue(paymentMethodPage.btnEyesCardDisplayed());
        }
    }

    @When("{string} setup commercial card")
    public void setupCommercialCard(String userType) throws Exception {
        //type of user is not affect this step, so being ignored
        goToPayment();
        switch (userType) {
            case "Card Owner":
                paymentMethodPage.setupCommercialCard(Constants.CARD_TO_BE_DELETED);
                break;
            case "Authorized User":
                createAuthorizedUser();
                break;
            case "User":
                paymentMethodPage.removeCommercialCard();
        }
    }

    @Then("user able to setup commercial card")
    public void userAbleToSetupCommercialCard() {
        Assert.assertTrue(paymentMethodPage.setupCardHeaderDisplayed());
    }

    @Given("{string} login to the web")
    public void loginToTheWeb(String condition) throws Exception {
        switch (condition) {
            case "User have company" :
            case "User" :
            case "User who company has card" :
                email = Constants.EMAIL_USER;
            break;
            case "Card Owner" : email = Constants.EMAIL_CARD_OWNER_WITH_COMPANY;
            break;
            case "Authorized User" : email = Constants.EMAIL_AUTHORIZED_USER;
            break;
            case "Have Payment Request" : email = Constants.EMAIL_HAVE_PAYMENT_REQUEST;
            break;
            case "Authorize User Overview" : email = Constants.EMAIL_AUTHORIZED_HAVE_PAYMENT_REQUEST;
            break;
            case "User Overview" : email = Constants.USER_OVERVIEW;
            break;
            case "User Backup" : email = Constants.EMAIL_USER_BACKUP;
                break;
            case "Card Owner that want to remove their card" :
            case "Card Owner that Leave Company" :
            case "User who company doesn't has card" :
                email = Constants.EMAIL_CARD_OWNER_DELETED;
                break;
            case "Authorized User that Leave Company" : email = Constants.EMAIL_AU_DELETED;
                break;
            default: email = Constants.EMAIL_WITHOUT_COMPANY;
        }

        loginPage.goToMainWeb();
        loginPage.pressBtnLoginInit();
        loginPage.changeSigninWindow();
        Thread.sleep(2500);
        loginPage.inputEmailLogin(email);
        loginPage.inputPasswordLogin(Constants.PASSWORD);
        Thread.sleep(3000);
        loginPage.pressSignIn();
        Thread.sleep(36000);
        loginPage.validateInMainWeb();
        loginPage.clickCookies();
    }

    @Then("can't setup commercial card")
    public void canTSetupCommercialCard() {
        Assert.assertTrue(paymentMethodPage.cardInfoHeaderDisplayed());
    }

    @And("user input {string} commercial card")
    public void userInputCommercialCard(String condition) {
        Assert.assertTrue(paymentMethodPage.setupCardHeaderDisplayed());
        String cardNo = "";
        if (condition.contains("non visa singapore")) cardNo = Constants.CARD_NON_VISA_SINGAPORE;
        else if (condition.contains("duplicate")) cardNo = Constants.CARD_DUPLICATE;
        else if (condition.contains("valid")) cardNo = Constants.CARD_VISA_SINGAPORE;

        paymentMethodPage.inputCardNumber(cardNo);
        paymentMethodPage.inputExpDate(Constants.CARD_EXP_DATE);
        paymentMethodPage.inputCvc(Constants.CARD_CVC);
    }

    @Then("validation note {string} appears")
    public void validationNoteAppears(String note) throws InterruptedException {
        if (!paymentMethodPage.getErrorMsgText(note)) {
            paymentMethodPage.removeCommercialCard();
        }
        Assert.assertTrue(paymentMethodPage.getErrorMsgText(note));
    }

    @And("press save commercial card")
    public void pressSaveCommercialCard() throws InterruptedException {
        paymentMethodPage.clickSaveBtn();
        Thread.sleep(15000);
    }

    @When("{string} want to remove commercial card")
    public void wantToRemoveCommercialCard(String userType) throws Exception {
        //type of user is not affect this step, so being ignored
        goToPayment();
        switch (userType) {
            case "Authorized User":
                createAuthorizedUser();
                break;
            case "Card Owner":
                paymentMethodPage.setupCommercialCard(Constants.CARD_TO_BE_DELETED);
                break;
        }
    }

    @Then("all standing instruction and authorized user will be removed")
    public void allStandingInstructionAndAuthorizedUserWillBeRemoved() throws InterruptedException {
        paymentMethodPage.clickDeleteCardBtn();
        paymentMethodPage.clickConfirmRemoveCardBtn();
        Thread.sleep(10000);
        Assert.assertTrue(paymentMethodPage.setupCardHeaderDisplayed());
    }

    @Then("{string} {string} to remove commercial card")
    public void toRemoveCommercialCard(String userType, String result) {
        //result is ignored
        switch (userType) {
            case "Authorized User":
            case "User":
            case "User Backup":
                Assert.assertFalse(paymentMethodPage.btnDeleteCardDisplayed());
                break;
            case "Card Owner":
                Assert.assertTrue(paymentMethodPage.btnDeleteCardEnabled());
                break;
        }
    }

    @When("{string} click view icon")
    public void clickViewIcon(String userType) throws Exception {
        //type of user is ignored
        goToPayment();
        if (userType.equals("Card Owner")) {
            if (!paymentMethodPage.btnEyesCardDisplayed())
                paymentMethodPage.setupCommercialCard(Constants.CARD_TO_BE_DELETED);
        } if (userType.equals("Authorized User"))
            if (!paymentMethodPage.btnEyesCardDisplayed())
                createAuthorizedUser();
        paymentMethodPage.clickEyesBtn();
    }

    @Then("{string} can view the last {int} digit visa card")
    public void canViewTheLastDigitVisaCard(String userType, int digit) {
        //userType and digit is ignored
        Assert.assertTrue(paymentMethodPage.txtCardNoDisplayed());
    }

    @Then("no view icon")
    public void noViewIcon() throws Exception {
        goToPayment();
        Assert.assertTrue(paymentMethodPage.btnEyesCardHidden());
    }

    @When("{string} want add authorized user")
    public void wantAddAuthorizedUser(String userType) throws Exception {
        //userType is ignored
        goToPayment();
        switch (userType) {
            case "Card Owner":
                paymentMethodPage.setupCommercialCard(Constants.CARD_TO_BE_DELETED);
                paymentMethodPage.clickAddUserBtn();
                break;
            case "Authorized User":
                createAuthorizedUser();
                break;
            case "User who company doesn't has card":
            case "User":
                paymentMethodPage.removeCommercialCard();
                break;
        }
    }

    @Then("the manage authored user function not available for {string}")
    public void theManageAuthoredUserFunctionNotAvailableFor(String userType) {
        //userType is ignored
        Assert.assertFalse(paymentMethodPage.txtListOfUserDisplayed());
        Assert.assertFalse(paymentMethodPage.btnRemoveDisplayed());
    }

    @Then("button setup company appears since {string} have to create company first")
    public void buttonSetupCompanyAppearsSinceHaveToCreateCompanyFirst(String userType) {
        Assert.assertTrue(paymentMethodPage.btnSetupCompanyDisplayed());
    }

    @When("click button setup company")
    public void clickButtonSetupCompany() {
        paymentMethodPage.clickSetupCompanyBtn();
    }

    @Then("Card Owner will be redirected to My Company page")
    public void cardOwnerWillBeRedirectedToMyCompanyPage() {
        Assert.assertTrue(paymentMethodPage.getCurrentUrl().contains("manage-company"));
    }

    @And("card owner added {string} authorized user that has not yet join company")
    public void cardOwnerAddedAuthorizedUserThatHasNotYetJoinCompany(String amount) throws InterruptedException {
        paymentMethodPage.clickAddUserBtn();
        for (int i = 0; i < Integer.parseInt(amount); i++)
            emails.add(Constants.FULL_MAIL);
        paymentMethodPage.inputEmailUser(emails);
        Thread.sleep(1000);
        paymentMethodPage.clickConfirmUserBtn();
        Thread.sleep(2000);
    }

    @When("invite {string} of the user")
    public void inviteOfTheUser(String amount) {
        int amountInt = Integer.parseInt(amount);
        if (amountInt == 1) paymentMethodPage.clickInviteUserBtn(paymentMethodPage.inviteEmailUser().size() - 1);
        else if (amountInt > 1) paymentMethodPage.clickInviteAllUserBtn();
        paymentMethodPage.clickConfirmInviteUserBtn();
        paymentMethodPage.waitUntilButtonConfirmDisappear();
    }

    @Then("information to invite the user to company appears")
    public void informationToInviteTheUserToCompanyAppears() {
        paymentMethodPage.txtInfoInviteUserDisplayed();
        paymentMethodPage.txtInvitedEmailDisplayed(emails.get(0));
    }

    @When("{string} want remove authorized user")
    public void wantRemoveAuthorizedUser(String userType) throws Exception {
        //userType is ignored
        goToPayment();
        if (userType.equals("Card Owner")) {
            if (paymentMethodPage.emailAuthorizedUser().size() < 1)
                paymentMethodPage.clickAddUserBtn();
                email = paymentMethodPage.chooseEmailUser();
                paymentMethodPage.clickConfirmAddUserBtn();
                Thread.sleep(2000);
                paymentMethodPage.clickRemoveBtn();
        }
    }

    @And("card owner has not yet invite the authorized user")
    public void cardOwnerHasNotYetInviteTheAuthorizedUser() {
        email = Constants.FULL_MAIL;
        emails.add(email);
        paymentMethodPage.clickAddUserBtn();
        paymentMethodPage.inputEmailUser(emails);
        paymentMethodPage.clickConfirmUserBtn();
    }

    @And("card owner invite the authorized user without company")
    public void cardOwnerInviteTheAuthorizedUserWithoutCompany() {
        email = Constants.FULL_MAIL;
        emails.add(email);
        paymentMethodPage.clickAddUserBtn();
        paymentMethodPage.inputEmailUser(emails);
        paymentMethodPage.clickConfirmUserBtn();
        paymentMethodPage.clickInviteUserBtn();
        paymentMethodPage.clickConfirmInviteUserBtn();
    }

    @When("remove that invited authorized user")
    public void removeThatInvitedAuthorizedUser() throws InterruptedException {
        Thread.sleep(1000);
        index = paymentMethodPage.indexOfEmail(email);
        paymentMethodPage.clickRemoveUserBtn(index - 1);
        paymentMethodPage.clickConfirmUserBtn();
    }

    @Then("succeed remove authorized user without company")
    public void succeedRemoveAuthorizedUserWithoutCompany() throws InterruptedException {
        Thread.sleep(4000); //wait for the loading in UI
        Assert.assertFalse(paymentMethodPage.checkingInvitedUser(emails.get(0)));
    }

    @Then("succeed remove authorized user who has standing instruction")
    public void succeedRemoveAuthorizedUserWhoHasStandingInstruction() throws InterruptedException {
        Assert.assertFalse(paymentMethodPage.txtSpecEmailDisplayed(email));
    }

    @And("standing instruction will be removed from the list of standing instruction")
    public void standingInstructionWillBeRemovedFromTheListOfStandingInstruction() throws InterruptedException {
        Assert.assertFalse(paymentMethodPage.manageEmailSI().contains(email));

        if (!paymentMethodPage.emailAuthorizedUser().contains(Constants.EMAIL_AUTHORIZED_USER)){
            paymentMethodPage.addAuthorizedUser(Constants.EMAIL_AUTHORIZED_USER);
            Thread.sleep(3000);
        }
    }

    @And("confirm remove {string} transferring the standing instruction")
    public void confirmRemoveTransferringTheStandingInstruction(String condition) throws InterruptedException {
        if (condition.equals("with")){
            paymentMethodPage.checkTransferSI();
            paymentMethodPage.inputEmailToTransferSI(Constants.EMAIL_CARD_OWNER_WITH_COMPANY);
        }
        paymentMethodPage.clickConfirmRemoveUserBtn();
        Thread.sleep(7000);
    }

    @When("{string} go the payment methods page")
    public void goThePaymentMethodsPage(String userType) throws Exception {
        //userType is ignored
        goToPayment();
    }

    @When("input data: {string} card information, {string} expired date, {string} cvc, {string} email")
    public void inputDataCardHolderCardInformationExpiredDateCvcEmail(String cardNo, String expDate, String cvc, String email) throws InterruptedException {
        if (cardNo.equals("invalid")) cardNo = "424242424242";
        paymentMethodPage.inputCardNumber(cardNo);
        if (expDate.equals("invalid")) expDate = "01/20";
        paymentMethodPage.inputExpDate(expDate);
        if (cvc.equals("invalid")) {
            cvc = "87";
            paymentMethodPage.inputCvc(cvc);
            paymentMethodPage.inputExpDate("");
        } else paymentMethodPage.inputCvc(cvc);
    }

    @Then("validation {string} appears")
    public void validationAppears(String message) {
        if (message.contains("disabled")) Assert.assertTrue(paymentMethodPage.btnSaveDisabled());
        else Assert.assertTrue(paymentMethodPage.getErrorMsgText(message));
    }

    @Then("commercial card will be saved \\(tokenization)")
    public void commercialCardWillBeSavedTokenization() throws InterruptedException {
        Assert.assertTrue(paymentMethodPage.cardInfoHeaderDisplayed());
        if (paymentMethodPage.cardInfoHeaderDisplayed()){
            paymentMethodPage.clickEyesBtn();
            Assert.assertTrue(paymentMethodPage.txtCardNoDisplayed());

            paymentMethodPage.removeCommercialCard();
        }
    }

    @And("Card Owner can only authorise user within their same company")
    public void cardOwnerCanOnlyAuthoriseUserWithinTheirSameCompany() throws InterruptedException {
        email = paymentMethodPage.chooseEmailUser();
        System.out.println("Selected email " + email);
        paymentMethodPage.clickConfirmAddUserBtn();
    }

    @Then("succeed add authorized user")
    public void succeedAddAuthorizedUser() {
        paymentMethodPage.txtSpecEmailDisplayed(email);
    }

    @Then("failed add authorized user with validation")
    public void failedAddAuthorizedUserWithValidation() {
        paymentMethodPage.getErrorMsgText("");//todo validation
    }

    @Given("There's a user that has standing instruction")
    public void thereSAUserThatHasStandingInstruction() throws Exception {
        //login
        loginPage.goToMainWeb();
        loginPage.pressBtnLoginInit();
        loginPage.changeSigninWindow();
        loginPage.inputEmailLogin(Constants.EMAIL_AUTHORIZED_USER);
        loginPage.inputPasswordLogin(Constants.PASSWORD);
        loginPage.pressSignIn();
        Thread.sleep(30000);
        loginPage.validateInMainWeb();

        //create si
        goToPayment();
        paymentMethodPage.clickAddNewSIBtn();
        paymentMethodPage.inputSupplier(index);
        paymentMethodPage.inputStartDate(4);
        paymentMethodPage.inputEndDate(10);//todo input end date
        paymentMethodPage.inputThreshold("900");//todo input threshold
        paymentMethodPage.clickSaveBtn();

        companyPage.myMenuAccount("Sign Out");
    }

    @When("remove authorized user that has standing instruction")
    public void removeAuthorizedUserThatHasStandingInstruction() throws Exception {
        emails = paymentMethodPage.manageEmailSI();
        if (emails.size() < 1) {
            paymentMethodPage.createNewSI(index);
            Assert.assertEquals(1, paymentMethodPage.manageEmailSI().size());

            paymentMethodPage.chooseSINo(index);
            //todo transfer

        } else {
            for (String e: emails){
                if (!e.equals(Constants.EMAIL_CARD_OWNER_WITH_COMPANY)) {
                    email = e;
                    break;
                }
            }
            index = paymentMethodPage.emailAuthorizedUser().indexOf(email);
        }
        paymentMethodPage.clickRemoveUserBtn(index);
    }

    @When("{string} want to setup standing instruction")
    public void wantToSetupStandingInstruction(String userType) throws Exception {
        //userType is ignored
        goToPayment();
        switch (userType) {
            case "Card Owner":
                paymentMethodPage.setupCommercialCard(Constants.CARD_TO_BE_DELETED);
                if (paymentMethodPage.manageEmailSI().size() == 1) {
                    paymentMethodPage.clickRemoveSIBtn(0);
                    paymentMethodPage.clickConfirmRemoveSIBtn();
                    paymentMethodPage.clickOkBtn();
                }
                break;
            case "Authorized User":
                createAuthorizedUser();
                break;
        }
    }

    @Then("not able to setup standing instruction")
    public void notAbleToSetupStandingInstruction() {
        Assert.assertFalse(paymentMethodPage.siNoDisplayed());
    }

    @Then("{string} can view all standing instruction including authorize user")
    public void canViewAllStandingInstructionIncludingAuthorizeUser(String userType) {
        //userType is ignored
        Set<String> uniqueEmail = Set.copyOf(paymentMethodPage.manageEmailSI());
        Set<Boolean> removeUniqueCondition = Set.copyOf(paymentMethodPage.enabledActionBtn());
        Set<Boolean> siNumberUniqueCondition = Set.copyOf(paymentMethodPage.enabledSINumberBtn());
        Assert.assertTrue(uniqueEmail.size() >= 1);
        Assert.assertEquals(1, removeUniqueCondition.size());
        Assert.assertEquals(1, siNumberUniqueCondition.size());

        if (userType.equals("Card Owner")){
            paymentMethodPage.clickRemoveSIBtn(0);
            paymentMethodPage.clickConfirmRemoveSIBtn();
        }
    }

    @And("able to setup standing instruction")
    public void ableToSetupStandingInstruction() throws InterruptedException {
        paymentMethodPage.inputSupplier(index);
        paymentMethodPage.inputStartDate(4);
        paymentMethodPage.inputEndDate(7);
        paymentMethodPage.inputThreshold("900");
        paymentMethodPage.clickSaveSIBtn();
        Assert.assertTrue(paymentMethodPage.getErrorMsgText("New Standing Instructions successfully added."));
    }

    @Then("{string} can see all the standing instruction created within the company. but they only able to manage their own standing instruction")
    public void canSeeAllTheStandingInstructionCreatedWithinTheCompanyButTheyOnlyAbleToManageTheirOwnStandingInstruction(String userType) {
        //userType is ignored
        Set<Boolean> removeUniqueCondition = Set.copyOf(paymentMethodPage.enabledActionBtn());
        Set<Boolean> siNumberUniqueCondition = Set.copyOf(paymentMethodPage.enabledSINumberBtn());
        if (!paymentMethodPage.manageEmailSI().contains(Constants.EMAIL_AUTHORIZED_USER)){
            Assert.assertTrue(removeUniqueCondition.contains(false));
            Assert.assertTrue(siNumberUniqueCondition.contains(false));
        }
        if (paymentMethodPage.manageEmailSI().contains(Constants.EMAIL_AUTHORIZED_USER)){
            Assert.assertTrue(removeUniqueCondition.contains(true));
            Assert.assertTrue(siNumberUniqueCondition.contains(true));
        }
    }

    @And("can select supplier to setup standing instruction")
    public void canSelectSupplierToSetupStandingInstruction() {
        paymentMethodPage.clickAddNewSIBtn();
        paymentMethodPage.fieldSupplierDisplayed();
    }

    @When("{string} want to update standing instruction")
    public void wantToUpdateStandingInstruction(String userType) throws Exception {
        //userType is ignored
        goToPayment();
        emails = paymentMethodPage.manageEmailSI();
        switch (userType) {
            case "Card Owner":
                if (emails.size() < 1) {
                    paymentMethodPage.createNewSI(index);
                    Assert.assertTrue(paymentMethodPage.manageEmailSI().size() > 0);
                }
                break;
            case "Authorized User":
                if (!emails.contains(Constants.EMAIL_AUTHORIZED_USER)) {
                    paymentMethodPage.createNewSI(index);
                    Assert.assertTrue(paymentMethodPage.manageEmailSI().contains(Constants.EMAIL_AUTHORIZED_USER));
                }
                break;
        }
    }

    @Then("only threshold limit, end date can be updated")
    public void onlyThresholdLimitEndDateCanBeUpdated() throws InterruptedException {
        Thread.sleep(2000);
        paymentMethodPage.updateEndDateUpdate(8);
        paymentMethodPage.updateThreshold("1234");
        paymentMethodPage.clickSaveSIUpdateBtn();
    }

    @And("authorized user only can update their own standing instruction")
    public void authorizedUserOnlyCanUpdateTheirOwnStandingInstruction() {
        Set<Boolean> siNumberUniqueCondition = Set.copyOf(paymentMethodPage.enabledSINumberBtn());
        if (!paymentMethodPage.manageEmailSI().contains(Constants.EMAIL_AUTHORIZED_USER)){
            Assert.assertTrue(siNumberUniqueCondition.contains(false));
        }
        if (paymentMethodPage.manageEmailSI().contains(Constants.EMAIL_AUTHORIZED_USER)){
            Assert.assertTrue(siNumberUniqueCondition.contains(true));
        }
    }

    @And("{string} choose one of the standing instruction")
    public void chooseOneOfTheStandingInstruction(String userType) {
        if (userType.equals("Card Owner")) paymentMethodPage.chooseSINo(0);
        else if (userType.equals("Authorized User")) {
            index = paymentMethodPage.manageEmailSI().indexOf(Constants.EMAIL_AUTHORIZED_USER);
            paymentMethodPage.chooseSINo(index);
        }
    }

    @Then("can't update standing instruction")
    public void canTUpdateStandingInstruction() {
        Assert.assertFalse(paymentMethodPage.siNoDisplayed());
    }

    @When("{string} want to transfer standing instruction ownership")
    public void wantToTransferStandingInstructionOwnership(String userType) throws Exception {
        //userType is ignored
        goToPayment();
        emails = paymentMethodPage.manageEmailSI();
        switch (userType) {
            case "Card Owner":
                if (emails.size() < 1) {
                    paymentMethodPage.createNewSI(index);
                    Assert.assertTrue(paymentMethodPage.manageEmailSI().size() > 0);
                }
                break;
            case "Authorized User":
                if (!emails.contains(Constants.EMAIL_AUTHORIZED_USER)) {
                    paymentMethodPage.createNewSI(index);
                    Assert.assertTrue(paymentMethodPage.manageEmailSI().contains(Constants.EMAIL_AUTHORIZED_USER));
                }
                break;
        }
    }

    @Then("Authorized User can't transfer standing instruction ownership")
    public void authorizedUserCanTTransferStandingInstructionOwnership() {
        Assert.assertTrue(paymentMethodPage.fieldManageByDisabled());
    }

    @Then("Card Owner able to transfer instruction ownership")
    public void cardOwnerAbleToTransferInstructionOwnership() {
        Assert.assertTrue(paymentMethodPage.fieldManageByEnabled());
    }

    @Then("the function not available")
    public void theFunctionNotAvailable() {
        Assert.assertFalse(paymentMethodPage.siNoDisplayed());
    }

    @Then("the user remove the commercial card")
    public void theUserRemoveTheCommercialCard() {

    }

    @And("add user {string}")
    public void addUser(String condition) {
        if (condition.contains("another company"))
            emails.add(Constants.EMAIL_DIFFERENT_COMPANY);
        else if (condition.contains("not yet joined")){
            emails.add(Constants.FULL_MAIL);
        }
        paymentMethodPage.inputEmailUser(emails);
        paymentMethodPage.clickConfirmUserBtn();
    }

    @When("{string} want to remove standing instruction")
    public void wantToRemoveStandingInstruction(String userType) throws Exception {
        //userType is ignored
        goToPayment();
    }

    @Then("card owner able to remove all the standing instruction within their card")
    public void cardOwnerAbleToRemoveAllTheStandingInstructionWithinTheirCard() {
        Assert.assertEquals(1, Set.copyOf(paymentMethodPage.enabledActionBtn()).size());
        Assert.assertTrue(paymentMethodPage.enabledActionBtn().contains(true));
    }

    @Then("authorized user only able to remove their standing instruction")
    public void authorizedUserOnlyAbleToRemoveTheirStandingInstruction() {
        List<String> emailSI = paymentMethodPage.manageEmailSI();
        List<Boolean> enabledRemove = paymentMethodPage.enabledActionBtn();
        for (int i = 0; i < emailSI.size(); i++){
            System.out.println("email - enabled : " + emailSI + " " + enabledRemove);
            if (emailSI.get(i).equals(Constants.EMAIL_AUTHORIZED_USER))
                Assert.assertTrue((boolean) enabledRemove.get(i));
            else Assert.assertFalse((boolean) enabledRemove.get(i));
        }
    }

    @Then("user has no option to remove standing instruction")
    public void userHasNoOptionToRemoveStandingInstruction() {
        Assert.assertFalse(paymentMethodPage.btnRemoveSIDisplayed());
    }

    @When("confirm remove one of the standing instruction")
    public void confirmRemoveOneOfTheStandingInstruction() throws InterruptedException {
        emails = paymentMethodPage.manageEmailSI();
        if (emails.size() == 0){
            paymentMethodPage.createNewSI(0);
        }
        paymentMethodPage.clickRemoveSIBtn(index);
        paymentMethodPage.clickConfirmRemoveSIBtn();
    }

    @Then("selected standing instruction disappear from the list")
    public void selectedStandingInstructionDisappearFromTheList() {
        Assert.assertTrue(paymentMethodPage.getErrorMsgText("Standing Instructions successfully deleted."));
        paymentMethodPage.clickOkBtn();
    }

    @When("{string} leave the company")
    public void leaveTheCompany(String userType) throws Exception {
        goToPayment();
        if (userType.equals("Card Owner")){
            paymentMethodPage.setupCommercialCard(Constants.CARD_TO_BE_DELETED);
        } else if (userType.equals("Authorized User")) createAuthorizedUser(Constants.EMAIL_CARD_OWNER_DELETED, Constants.EMAIL_AU_DELETED);
        paymentMethodPage.goToMyCompany();
        companyPage.pressLeaveCompany();
        companyPage.pressYesBtn();
        Thread.sleep(3000);
    }

    @Then("all card, authorized user & standing instruction will be removed")
    public void allCardAuthorizedUserStandingInstructionWillBeRemoved() throws Exception {
        goToPayment();
        Assert.assertTrue(paymentMethodPage.btnSetupCompanyDisplayed());
    }

    @Then("all standing instruction will be transferred to card owner")
    public void allStandingInstructionWillBeTransferredToCardOwner() throws Exception {
        companyPage.myMenuAccount("Sign Out");
        Thread.sleep(10000);

        loginPage.login(Constants.EMAIL_CARD_OWNER_DELETED);

        goToPayment();
        List<String> emailsManageBy = paymentMethodPage.manageEmailSI();
        Assert.assertFalse(emailsManageBy.contains(Constants.EMAIL_AUTHORIZED_USER));
    }

    @When("remove authorized user that doesn't has standing instruction")
    public void removeAuthorizedUserThatDoesnTHasStandingInstruction() throws Exception {
        goToPayment();
        List<String> emailAuthorizedUser = paymentMethodPage.emailAuthorizedUser();
        Set<String> emailSI = Set.copyOf(paymentMethodPage.manageEmailSI());
        for (int i = 0; i < emailAuthorizedUser.size(); i++){
            if (!emailSI.contains(emailAuthorizedUser.get(i))) {
                index = i;
                break;
            }
        }
        email = emailAuthorizedUser.get(index);
        paymentMethodPage.clickRemoveUserBtn(index);
    }

    @Then("there's no option to transfer the SI")
    public void thereSNoOptionToTransferTheSI() {
        Assert.assertFalse(paymentMethodPage.checkboxTransferDisplayed());
    }

    @Then("create account email sent to {string} the email user")
    public void createAccountEmailSentToTheEmailUser(String condition) throws Exception {
        //condition is ignored
        for (String email : emails){
            goToUrl.goToAbsUrl(Constants.YOPMAIL_SERVICE_URL);
            mailServiceYopmailPage.searchEmail(email);
            Assert.assertTrue(mailServiceYopmailPage.emailInvitationDisplayed());
        }
    }

    @And("standing instruction will be managed by the selected user")
    public void standingInstructionWillBeManagedByTheSelectedUser() throws InterruptedException {
        Thread.sleep(1500);
        emails = paymentMethodPage.manageEmailSI();
        for (Integer index : indexes){
            Assert.assertNotSame(emails.get(index), email);
        }

        if (!paymentMethodPage.emailAuthorizedUser().contains(Constants.EMAIL_AUTHORIZED_USER)){
            paymentMethodPage.addAuthorizedUser(Constants.EMAIL_AUTHORIZED_USER);
            Thread.sleep(3000);
        }
    }

    @And("{string} has commercial card")
    public void hasCommercialCard(String userType) throws Exception {
        goToPayment();
        //userType is ignored
        if (!paymentMethodPage.btnDeleteCardDisplayed()) {
            paymentMethodPage.inputCardNumber(Constants.CARD_TO_BE_DELETED);
            paymentMethodPage.inputExpDate(Constants.CARD_EXP_DATE);
            paymentMethodPage.inputCvc(Constants.CARD_CVC);
            paymentMethodPage.clickSaveBtn();
            Thread.sleep(1000);
        } else System.out.println("User has commercial card");
    }

    @And("success update standing instruction")
    public void successUpdateStandingInstruction() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(paymentMethodPage.getErrorMsgText("Standing Instructions successfully updated."));
    }

    @Given("{string} has standing instruction")
    public void hasStandingInstruction(String userType) throws Exception {
        if (userType.equals("Authorized User")) {
            //login
            loginPage.login(Constants.EMAIL_AUTHORIZED_USER);

            //create si
            goToPayment();
            Thread.sleep(3000);
            emails = paymentMethodPage.manageEmailSI();
            if (!emails.contains(Constants.EMAIL_AUTHORIZED_USER)) {
//                if (emails.size() == 1) {
//                    paymentMethodPage.clickRemoveSIBtn(0);
//                    paymentMethodPage.clickConfirmRemoveSIBtn();
//                    Thread.sleep(2000); //waiting for the UI to load
//                    paymentMethodPage.clickOkBtn();
//                }
                paymentMethodPage.clickAddNewSIBtn();
                paymentMethodPage.createNewSI(0);
                Thread.sleep(3000); //wait for UI loading
                Assert.assertTrue(paymentMethodPage.manageEmailSI().contains(Constants.EMAIL_AUTHORIZED_USER));
            }
            companyPage.myMenuAccount("Sign Out");
        }
    }

    @And("success delete user without standing instruction")
    public void successDeleteUserWithoutStandingInstruction() {
        paymentMethodPage.clickConfirmRemoveUserBtn();
        Assert.assertFalse(paymentMethodPage.txtSpecEmailDisplayed(email));
    }
}
