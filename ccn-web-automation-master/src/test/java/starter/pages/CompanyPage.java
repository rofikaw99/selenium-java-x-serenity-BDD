package starter.pages;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import starter.utlis.Constants;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;

public class CompanyPage extends PageObject {
    public static String name = "";
    public static int index;
    private int waitResponse =13000;

    //Information section
    private By btnInformationOnMyCompany = By.id("cube-information");
    private By btnLeaveCompany = By.id("cube-leave-company"); //admin & user
    private By btnSureWantToLeaveCompany = By.id("cube-confirm-leave-confirmation");
    private By verifyRemovePM = By.id("cube-confirm-remove-confirmation");
    private By changeRoleToUser = By.xpath("//div[@class='cube-action-list']/p[@class='active' and text()='User']");
    private By btnYes = By.id("cube-confirm-leave-confirmation"); //admin & user
    private By btnSetupPayment = By.id("cube-setup-payment"); //admin from SG country & not setup payment yet, can see this
    private By updatePlanManagerPopUp = By.xpath("//p[contains(@class, 'cube-tracking') and contains(@class, 'cube-title') and contains(@class, 'undefined') and text()='Update Plan Manager']");
    //Members section
    private By btnMembersOnMyCompany = By.id("cube-members");
    private By btnInviteUserToCompany = By.id("cube-invite-users"); //admin
    private By btnRemoveUsersFromAdmin = By.xpath("//*[@id=\"cube-members\"]/tbody/tr[1]/td[5]/div/div/div[2]/div[3]/p"); //admin
    private By btnApproveUsersFromAdmin = By.id("cube-approve"); //admin
    private By txtInviteEmailUsers = By.xpath("//*[@id=\"toppage\"]/main/div[3]/wc-company/div/div[2]/div[3]/div/div/div[1]/div[2]/div/input"); //admin
    private By btn3dot = By.id("cube-open-action-["+index+"]"); //Conditionally
    private By btnAcceptPendingApprovalPerUsers = By.id("cube-accept-request-["+index+"]"); //Conditionally
    private By btnRemovePerUsers = By.id("cube-remove-user-["+index+"]"); //Conditionally
    private By checkboxUsersOnMembers = By.id("checkbox-["+index+"]"); //Conditionally
    private By txtSearchUser = By.xpath("//input[@placeholder='Search by Members, Roles or Status.']");
    private	By dropdownFilterUsersOnMembers = By.id("cube-filter-users");

    private By tblMember = By.xpath("//*[@id=\"cube-members\"]/tbody/tr/td[4]");

    private By lscheckboxMember = By.xpath("//*[@id=\"cube-members\"]/tbody/tr/td[1]/label/span");
    private By lsFilterUsersOnMember = By.xpath("//*[@id=\"cube-sort-checkbox\"]/div/div[2]/div/div[2]/div");

    private By txtValidateAlreadyinCompany = By.xpath("//*[@id=\"toppage\"]/main/div[3]/wc-company/div/div[2]/div/div/div[1]/div[2]/p");

    private By btnValidateAlreadyinCompany = By.id("cube-confirm-error");
    private By txtemailValidateAlreadyinCompany = By.xpath("//*[@id=\"toppage\"]/main/div[3]/wc-company/div/div[3]/div/div/div[1]/div[2]/p");

    private By btnValidateNotYetInCompany = By.xpath("//button[@id=\"cube-confirm-add-users\"]");
    private By txtValidateNotYetInCompanyAndSuccesAddMember = By.xpath("//*[@id=\"toppage\"]/main/div[3]/wc-company/div/div[1]/div[2]/div/div/div[1]/p");
    private By lsthreedoteoptionmembermostleftside = By.xpath("//*[@id=\"cube-members\"]/tbody/tr/td[5]");
    private By ThreeDotLeftSidePortal = By.xpath("(//td[contains(@class, ' !pl-0') and contains(@class, 'bg-white')])");
    private By GeneratePouchAndOther = By.xpath("(//div[@class='flex py-2 w-full left-0 items-center px-3 ccn-font-size-normal transition-all hover:!bg-ccn-blue-light'])");
    private By removePM =By.xpath("(//div[@class='cube-action-list cube-d-flex'])[2]");
    private By btnRemoveUserConfirmMember = By.id("cube-confirm-remove");
    private By lsThreeDotsOptionAdminOnMember = By.xpath("//*[@id=\\\"cube-members\\\"]/tbody/tr[1]/td[5]/div/div/div[2]/div");
//    private By customChangeRoleOption = By.xpath("(//*[@id=\"cube-members\"]/tbody/tr/td[5])[18]");
    private By customChangeRoleOption = By.xpath("(//div[@class='cube-action-list cube-d-flex'])[1]");
    private By btnConfirmRemoveMember = By.id("cube-confirm-remove-confirmation");
    private By btnConfirmCancelRemoveMember = By.id("cube-later");
    private By lsOptionChangeRole = By.xpath("//*[@id=\\\"cube-members\\\"]/tbody/tr[1]/td[5]/div/div/div[2]/div[1]/div[2]/div");
    private By btnErrorChangeRole = By.id("cube-confirm-error");
    private By txtErrorChangeRole = By.xpath("//*[@id=\"toppage\"]/main/div[3]/wc-company/div/div[2]/div/div/div[1]/p");
    private By btnConfirmChangeRoleSucces = By.id("cube-confirm-change-status");
    private By txtConfirmChangeRoleSucces = By.xpath("//*[@id=\"toppage\"]/main/div[3]/wc-company/div/div[1]/div[2]/div/div/div[1]/p");
    private	By btnChangeRolePerUsers = By.id("cube-change-role-["+index+"]"); //Conditionally
    //*[@id="cube-confirm-remove"]
//	The user�s role has been changed successfully. User will be notified via email of this change.

    //Application status
    private By txtCompanyName = By.id("cube-company-name");
    private By txtCompanyRegNo = By.id("cube-company-registration-no");
    private By btnSearchCompany = By.id("cube-search-companies"); // appears when application status rejected
    private By btnCreateCompany = By.id("create-company"); // new or old users without company
    private By btnWithdrawApplication = By.id("cube-withdraw-application"); // user who already request join to the company can withdraw
    private By btnRejectApplicationFromUser = By.id("cube-reject"); // user who already invited by admin to company can reject the application
    private By btnAcceptApplicationFromUser = By.id("cube-accept"); // user who already invited by admin to company can accept the application
    private By lblApplicationStatus = By.xpath("//div[@id='cube-status']"); // application status for validation data
    private By btnPaginationLeftArrow = By.id("cube-prev");
    private By btnPaginationRightArrow = By.id("cube-next");
    private By tblCompany = By.id("cube-company-setup-table");
    private By btnJoinCompanies = By.id("cube-join"); // probably need some index to get the element
    private By dropdownCompanyTypes = By.id("company-type-item");
    private By dropdownMenuCompanytype = By.xpath("//*[@id=\"company-type\"]/div[1]/input");
    private By dropdownMenuCountry = By.xpath("//*[@id=\"country\"]/div[1]/input");
    private By dropdownCountries = By.id("country-item");
    private By dropdownMenuCity = By.xpath("//*[@id=\"city\"]/div[1]/input");
    private By dropdownCities = By.id("city-item");

//    private By pageOption = By.xpath("//div[@class='cube-dropdown-selected']");
    private By pageOption = By.xpath("//div[@id='selected-' and text()='10']");
    private By accountCircleIcon = By.xpath("//div[contains(@class, 'circle-initial letter-avatar')]");
    private By menuAccount = By.xpath("//*[@service-id='2ccbe74c-493b-47a4-8dee-80bdb147e895' and @client-id='268e587b-a947-421b-a737-b5573c6ea075' and @target-service-id='52bf0c2e-6ea1-459f-b863-f4dccc28a296' and @login-redirect-url='/portal' and @logout-redirect-url='/' and @env='ppd' and @login-type='popup' and @contract-version='1' and @authority-url='https://ccnssoppd.b2clogin.com/ccnssoppd.onmicrosoft.com' and @sign-up-sign-in-authority='b2c_1a_signup_signinnewusersyn' and @forgot-password-policy-name='b2c_1a_passwordreset' and @label-button='Sign In' and @contract_name='Profile' and @polling-interval='10000' and @redirect-interval='100' and @china-site='https://cndev.cubeforall.com/' and @general-site='https://sandbox.cubeforall.com/']");
//    private By lsMenuAccounts = By.xpath("//*[@id=\"toppage\"]/header/div[2]/div[2]/div[2]/div[2]/wc-login/div/div/div[2]/div[2]/div");
    private By lsMenuAccounts = By.xpath("//*[@class = 'styled-option']");
    private By ClickMenuAccount = By.xpath("//div[@id=\"toppage\"]/header/div[2]/div[2]/div[2]/div[2]/wc-login/div/div/div[2]/div[2]/div");
    private By ClickSubscribe = By.xpath("//a[@href='/portal/manage-subscription/']/span");
    private By ClickSignOut = By.xpath("//span[text()='Sign Out']");
    private By ClickUnSubscribe = By.xpath("//*[@id=\"cube-plan-list\"]/tbody/tr[1]/td[8]");

    //Modals
    private By btnCancelOnModal = By.id("cube-cancel");
    private By btnInviteOnModal = By.xpath("//button[@id=\"cube-confirm-add-user\"]");
    private By btnLaterOnModal = By.id("cube-later");
    private By btnSetupNowOnModal = By.id("cube-setup-now");

    private By btnConfirmOnModal = By.id("cube-confirm");
    private By btnConfirmOnConfirmWithdraw = By.id("cube-confirm-application-status");
    private By btnCancelConfirmOnConfirmWithdraw = By.id("cube-later");
    private By btnConfirmOnJoinRquest = By.id("cube-confirm-join");

    // Setup company (Company Details)
    private By txtAddress = By.id("cube-address");
    private By txtPostCode = By.id("cube-postcode");
    private By txtIataMembershipNo = By.id("cube-iata-code");
    private By txtCassNo = By.id("cube-cass-code");
    private By txtCompanyemail = By.id("cube-cube-company-email");
    private By txtMobileNumberMobileDetails = By.id("cube-cube-company-mobile-no");

    // Setup company (Admin Contact Details)
    private By txtContactName = By.id("cube-username");
    private By txtDesignation = By.id("cube-designation");
    private By txtMobileNo = By.id("cube-cube-mobile-no");
    private By txtEmail = By.id("cube-email");
    private By domainNumbers = By.id("cube-undefined");
    private By selectDomainNumberCounties = By.xpath("//*[@id=\"cube-form-create-company\"]/div[8]/div[2]/div[3]/ul/li");

    // Mailing Address
    private By checkBoxSameAsRegisterAddress = By.xpath("//*[@id=\"cube-form-create-company\"]/div[5]/div[2]/label/span");

    //Button Cancel And Submit
    private By btnSubmit = By.id("cube-submit");
    private By btnCancel = By.id("cube-cancel");

    // pop up after submit create company
    private By btnProceedConfirmationCreateCompany = By.xpath("//button[@id=\"cube-confirm\"]");
    private By btnLaterConfirmationCreateCompany = By.id("cube-later");

    // post payment
    private By btnPostpaymentCreateCompany = By.xpath("//button[@id=\"cube-confirm\"]");

    //sort
    private By sorting = By.id("cube-sort-"+name+"");

    public WebElement applicationStatusLabel(){
        return $(lblApplicationStatus);
    }

    public void pressInformationOnMyCompany(){
        $(btnInformationOnMyCompany).isDisplayed();
        $(btnInformationOnMyCompany).click();
    }
    public void pressLeaveCompany(){
        $(btnLeaveCompany).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(btnLeaveCompany));
    }

    public void pressSureWantToLeaveCompany(){
        $(btnSureWantToLeaveCompany).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(btnSureWantToLeaveCompany));
    }
    public void pressRemovePMVerification(){
        $(verifyRemovePM).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(verifyRemovePM));
    }

    public void pressChangeRoleToUser() throws InterruptedException {
        Actions act = new Actions(getDriver());
        $(customChangeRoleOption).waitUntilVisible();
        List<WebElement> customChangeRoleOptionWE = getDriver().findElements(customChangeRoleOption);
        act.moveToElement(customChangeRoleOptionWE.get(0)).perform();
//        evaluateJavascript("arguments[0].click();", $(customChangeRoleOption));
        $(changeRoleToUser).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(changeRoleToUser));
        Thread.sleep(4000);
    }

    public void verifyUpdatePMPopUpAvailable(){
        $(updatePlanManagerPopUp).waitUntilVisible();
        $(updatePlanManagerPopUp).isDisplayed();
    }

    public void pressYesBtn(){
        $(btnLeaveCompany).waitUntilVisible();
        evaluateJavascript("arguments[0].click();", $(btnYes));
    }
    public void pressSetupPaymentCompany(){
        $(btnSetupPayment).isDisplayed();
        $(btnSetupPayment).click();
    }

    public void btnValidateNotYetInCompany() {
        $(btnValidateNotYetInCompany).click();
    }

    public void pressMembersOnMyCompany() throws Exception{
        $(btnMembersOnMyCompany).isDisplayed();
        Thread.sleep(waitResponse);
        $(btnMembersOnMyCompany).waitUntilClickable();
        $(btnMembersOnMyCompany).click();
    }

    public void pressInviteUserToCompany() throws Exception{
        evaluateJavascript("window.scrollBy(0,-150)", "");
        Thread.sleep(waitResponse);
        $(btnInviteUserToCompany).isDisplayed();
        $(btnInviteUserToCompany).click();
    }

    public void pressRemoveUserFromCompanyByAdmin() throws Exception{
        List<WebElement> lsthreedoteoptionmembermostleftsides = getDriver().findElements(lsthreedoteoptionmembermostleftside);
        lsthreedoteoptionmembermostleftsides.get(0).isDisplayed();
        lsthreedoteoptionmembermostleftsides.get(0).isEnabled();
        lsthreedoteoptionmembermostleftsides.get(0).click();
        $(btnRemoveUsersFromAdmin).isDisplayed();
        $(btnRemoveUsersFromAdmin).click();
        confirmpressRemoveUserFromCompanyByAdmin();
    }

    public void pressbtnRemoveUsersFromAdmin() throws Exception{
        $(btnRemoveUsersFromAdmin).isDisplayed();
        $(btnRemoveUsersFromAdmin).click();
        confirmpressRemoveUserFromCompanyByAdmin();
    }

    public void pressthreedotsRemoveUserFromCompanyByAdminPendingAccept() {
        List<WebElement> lsthreedoteoptionmembermostleftsides = getDriver().findElements(lsthreedoteoptionmembermostleftside);
        lsthreedoteoptionmembermostleftsides.get(0).isDisplayed();
        lsthreedoteoptionmembermostleftsides.get(0).isEnabled();
        lsthreedoteoptionmembermostleftsides.get(0).click();
    }
    public void confirmpressRemoveUserFromCompanyByAdmin() throws Exception {
        Thread.sleep(waitResponse);
        $(btnConfirmRemoveMember).isDisplayed();
        $(btnConfirmRemoveMember).isEnabled();
        $(btnConfirmRemoveMember).click();
    }
    public void pressApproveUserByAdmin(){
        $(btnApproveUsersFromAdmin).isDisplayed();
        $(btnApproveUsersFromAdmin).click();
    }
    public void inputSearchUsersOnMembers(String search){
        $(txtSearchUser).clear();
        $(txtSearchUser).sendKeys(search);
    }
    public void inputInviteUsersOnMembersByAdmin(String email){
        $(txtInviteEmailUsers).clear();
        $(txtInviteEmailUsers).sendKeys(email);
    }
    public void press3DotOnMembers(int indexing){
        index = indexing;
        $(btn3dot).isDisplayed();
        $(btn3dot).click();
    }

    public WebElement acceptRequestPerUserOnMemberByAdmin(int indexing){
        index = indexing;
        return $(btnAcceptPendingApprovalPerUsers);
    }

    public void pressthreedotsFromCompanyByAdmin() {
        List<WebElement> lsthreedoteoptionmembermostleftsides = getDriver().findElements(lsthreedoteoptionmembermostleftside);
        System.out.println("lsthreedoteoptionmembermostleftside display: "+lsthreedoteoptionmembermostleftsides.get(0).isDisplayed());
        System.out.println("lsthreedoteoptionmembermostleftside enabled: "+lsthreedoteoptionmembermostleftsides.get(0).isEnabled());
        lsthreedoteoptionmembermostleftsides.get(0).click();
    }

    public void pressthreedotsInThePortalDashboard() {
        List<WebElement> lsthreedoteoptionmembermostleftsides = getDriver().findElements(ThreeDotLeftSidePortal);
        System.out.println("lsthreedoteoptionmembermostleftside display: "+lsthreedoteoptionmembermostleftsides.get(0).isDisplayed());
        System.out.println("lsthreedoteoptionmembermostleftside enabled: "+lsthreedoteoptionmembermostleftsides.get(0).isEnabled());
        lsthreedoteoptionmembermostleftsides.get(0).click();
    }

    public void pressGeneratePouch() {
        List<WebElement> lsthreedoteoptionmembermostleftsides = getDriver().findElements(GeneratePouchAndOther);
        System.out.println("lsthreedoteoptionmembermostleftside display: "+lsthreedoteoptionmembermostleftsides.get(2).isDisplayed());
        System.out.println("lsthreedoteoptionmembermostleftside enabled: "+lsthreedoteoptionmembermostleftsides.get(2).isEnabled());
        lsthreedoteoptionmembermostleftsides.get(2).click();
    }

    public void pressOpenwithElectronicAirwaybillPrint() {
        List<WebElement> lsthreedoteoptionmembermostleftsides = getDriver().findElements(GeneratePouchAndOther);
        System.out.println("lsthreedoteoptionmembermostleftside display: "+lsthreedoteoptionmembermostleftsides.get(0).isDisplayed());
        System.out.println("lsthreedoteoptionmembermostleftside enabled: "+lsthreedoteoptionmembermostleftsides.get(0).isEnabled());
        lsthreedoteoptionmembermostleftsides.get(0).click();
    }

    public void pressRemovePM() {
        List<WebElement> lsthreedoteoptionmembermostleftsides = getDriver().findElements(removePM);
        System.out.println("remove field display: "+lsthreedoteoptionmembermostleftsides.get(0).isDisplayed());
        System.out.println("remove field enabled: "+lsthreedoteoptionmembermostleftsides.get(0).isEnabled());
        lsthreedoteoptionmembermostleftsides.get(0).click();
    }

    //TODO fixing
    public void changeRolePerUserOnMemberByAdmin(String role) throws Exception{
        Actions act = new Actions(getDriver());
        Thread.sleep(waitResponse);
        //		act.moveToElement(lsthreedoteoptionmembermostleftside.get(0)).click().perform();

        List<WebElement> lsThreeDotsOptionAdminOnMembers = getDriver().findElements(lsThreeDotsOptionAdminOnMember);
        System.out.println("lsThreeDotsOptionAdminOnMember display: "+lsThreeDotsOptionAdminOnMembers.get(1).isDisplayed());
        System.out.println("lsThreeDotsOptionAdminOnMember enabled: "+lsThreeDotsOptionAdminOnMembers.get(1).isEnabled());
        //		js.executeScript("arguments[0].scrollIntoView();", lsThreeDotsOptionAdminOnMember.get(0).click());
        //		lsThreeDotsOptionAdminOnMember.get(0).click();
        //		act.moveToElement(lsthreedoteoptionmembermostleftside.get(0)).moveToElement(lsThreeDotsOptionAdminOnMember.get(0)).perform();

        //		act.moveToElement(lsThreeDotsOptionAdminOnMember.get(0)).moveToElement(lsOptionChangeRole.get(0)).perform();
        act.moveToElement(lsThreeDotsOptionAdminOnMembers.get(1)).perform();
        Thread.sleep(waitResponse);
        //		act.moveToElement(lsThreeDotsOptionAdminOnMember.get(0));

        List<WebElement> lsOptionChangeRoles = getDriver().findElements(lsOptionChangeRole);
        //list option change role
        switch (role) {
            case "admin":
                act.moveToElement(lsOptionChangeRoles.get(0)).click().perform();
                //			lsOptionChangeRole.get(0).click();
                break;
            case "user":
                act.moveToElement(lsOptionChangeRoles.get(1)).click().perform();
                //			lsOptionChangeRole.get(1).click();
                break;
            default:
                break;
        }

        //change role success gettext
        //*[@id="toppage"]/main/div[3]/wc-company/div/div[1]/div[2]/div/div/div[1]/p
        //				The user�s role has been changed successfully. User will be notified via email of this change.
        //				The user�s role has been changed successfully. User will be notified via email of this change.
        // button confirm change status
        //*[@id="cube-confirm-change-status"]


        //		index = indexing;
        //		return driver.findElement(btnChangeRolePerUsers);
    }

    public void customChangeRolePerUserOnMemberByAdmin(String role) throws Exception{
        Actions act = new Actions(getDriver());
        List<WebElement> lsOptionChangeRoles = getDriver().findElements(lsOptionChangeRole);
        //list option change role
        switch (role) {
            case "admin":
                act.moveToElement(lsOptionChangeRoles.get(0)).click().perform();
                break;
            case "user":
                act.moveToElement(lsOptionChangeRoles.get(1)).click().perform();
                break;
            default:
                break;
        }
    }

    public void pressAcceptRequestPerUserOnMemberByAdmin() throws Exception{
        Thread.sleep(waitResponse);
        List<WebElement> lsThreeDotsOptionAdminOnMembers = getDriver().findElements(lsThreeDotsOptionAdminOnMember);
        lsThreeDotsOptionAdminOnMembers.get(1).isEnabled();
        lsThreeDotsOptionAdminOnMembers.get(1).isDisplayed();
        lsThreeDotsOptionAdminOnMembers.get(1).click();
        //		Thread.sleep(waitResponse);
        //		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
        //		btnConfirmAcceptMember.isEnabled();
        //		btnConfirmAcceptMember.isDisplayed();
        //		btnConfirmAcceptMember.click();
    }

    public void pressRemovePerUserOnMemberByAdmin() throws Exception{
        Thread.sleep(waitResponse);
        List<WebElement> lsThreeDotsOptionAdminOnMembers = getDriver().findElements(lsThreeDotsOptionAdminOnMember);
        lsThreeDotsOptionAdminOnMembers.get(2).isEnabled();
        lsThreeDotsOptionAdminOnMembers.get(2).isDisplayed();
        lsThreeDotsOptionAdminOnMembers.get(2).click();
        Thread.sleep(waitResponse);
        $(btnConfirmRemoveMember).isEnabled();
        $(btnConfirmRemoveMember).isDisplayed();
        $(btnConfirmRemoveMember).click();
        //list option admin to request member join company
    }

    public void pressCancelRemovePerUserOnMemberByAdmin() throws Exception{
        Thread.sleep(waitResponse);
        List<WebElement> lsThreeDotsOptionAdminOnMembers = getDriver().findElements(lsThreeDotsOptionAdminOnMember);
        lsThreeDotsOptionAdminOnMembers.get(1).isEnabled();
        lsThreeDotsOptionAdminOnMembers.get(1).isDisplayed();
        lsThreeDotsOptionAdminOnMembers.get(1).click();
        Thread.sleep(waitResponse);
        $(btnConfirmCancelRemoveMember).isEnabled();
        $(btnConfirmCancelRemoveMember).isDisplayed();
        $(btnConfirmCancelRemoveMember).click();
        //list option admin to request member join company

        //list option change role
        //*[@id="cube-members"]/tbody/tr[2]/td[5]/div/div/div[2]/div[1]/div[2]/div
        //change role success gettext
        //*[@id="toppage"]/main/div[3]/wc-company/div/div[1]/div[2]/div/div/div[1]/p
        //		The user�s role has been changed successfully. User will be notified via email of this change.
        //		The user�s role has been changed successfully. User will be notified via email of this change.
        // button confirm change status
        //*[@id="cube-confirm-change-status"]

        // pop up remove member
    }

    public WebElement removePerUserOnMemberByAdmin(int indexing){
        index = indexing;
        return $(btnRemovePerUsers);
    }

    public List<String> memberListTable(){
        List<WebElement> tblMemberLists = getDriver().findElements(tblMember);
        List<String> data = new ArrayList<>();
        for(WebElement w:tblMemberLists) {
            data.add(w.getText());
        }
        return data;
    }

    public void inputCompanyNameOnMyCompany(String companyName) throws Exception{
        Thread.sleep(waitResponse);
        evaluateJavascript("window.scrollBy(0,150)", "");
        Thread.sleep(waitResponse);
        $(txtCompanyName).waitUntilClickable();
        $(txtCompanyName).clear();
        String company = RandomStringUtils.randomNumeric(4)+"-"+companyName;
        System.out.println(company);
        $(txtCompanyName).sendKeys(company);
    }
    public void searchinputCompanyNameOnMyCompany(String companyName) throws Exception{
        Thread.sleep(waitResponse);
        evaluateJavascript("window.scrollBy(0,150)", "");
        Thread.sleep(waitResponse);
        $(txtCompanyName).waitUntilClickable();
        $(txtCompanyName).clear();
        System.out.println(companyName);
        $(txtCompanyName).sendKeys(companyName);
    }
    public void inputCompanyRegNoOnMyCompany(String companyName){
        $(txtCompanyRegNo).clear();
        $(txtCompanyRegNo).sendKeys(companyName);
    }

    public void selectCompanyType(String companyType) throws InterruptedException {
        System.out.println("company type selected is enabled : "+$(dropdownMenuCompanytype).isEnabled()+" company type selected is displaying : "+$(dropdownMenuCompanytype).isDisplayed());
//        WebElement inputCompanyType = $(dropdownMenuCompanytype);
//        evaluateJavascript(
//                "arguments[0].removeAttribute('readonly','readonly')", inputCompanyType);
//        inputCompanyType.sendKeys(companyType);
//        Thread.sleep(1000);
//        inputCompanyType.sendKeys(Keys.TAB);
////        inputCompanyType.sendKeys(Keys.TAB);
//        Thread.sleep(1000);
//        inputCompanyType.sendKeys(Keys.ENTER);
//        System.out.println("company type selected is enabled : "+dropdownCompanyType.get(1).isEnabled()+" company type selected is displaying : "+dropdownCompanyType.get(1).isDisplayed());
//        $(dropdownMenuCompanytype).click();
        evaluateJavascript("arguments[0].click();", $(dropdownMenuCompanytype));
//        $(Dropdown.withNameOrId("company-type")).click();
//        $(By.id("company-type")).selectByVisibleText(companyType);
//        selectByVisibleText()
        Thread.sleep(1000);
        List<WebElement> dropdownCompanyType = getDriver().findElements(dropdownCompanyTypes);
        evaluateJavascript("arguments[0].click();", $(dropdownCompanyType.get(1)));
//        dropdownCompanyType.get(1).click();
    }

    public void selectCountry(String country) throws InterruptedException {
        List<WebElement> dropdownCountry = getDriver().findElements(dropdownCountries);
        $(dropdownMenuCountry).click();
//        WebElement inputCountry = $(dropdownMenuCountry);
//        evaluateJavascript(
//                "arguments[0].removeAttribute('readonly','readonly')", inputCountry);
//        $(dropdownMenuCountry).click();
//        inputCountry.sendKeys(country);
//        inputCountry.sendKeys(Keys.TAB);
//        inputCountry.sendKeys(Keys.TAB);
//        Thread.sleep(1000);
//        inputCountry.sendKeys(Keys.ENTER);
        for(WebElement i:dropdownCountry) {
            if(i.getText().contains(country)) {
                i.click();
                break;
            }
        }
    }

    public void selectCity(String city) throws Exception{
        WebElement inputCity = $(dropdownMenuCity);
        evaluateJavascript(
                "arguments[0].removeAttribute('readonly','readonly')", inputCity);
//        $(dropdownMenuCompanytype).click();
        inputCity.sendKeys(city);
        inputCity.sendKeys(Keys.TAB);
        inputCity.sendKeys(Keys.TAB);
        Thread.sleep(1000);
        inputCity.sendKeys(Keys.ENTER);
//        evaluateJavascript("window.scrollBy(0,50)", "");
//        $(dropdownMenuCity).click();
//        $(dropdownMenuCity).sendKeys(city);
//        List<WebElement> dropdownCity = getDriver().findElements(dropdownCities);
//        System.out.println(dropdownCity.get(0).getText()+" same as city selected: "+city);
//        dropdownCity.get(0).click();;
        //		for(WebElement i:dropdownCity) {
        //			if(i.getText().contains(city)) {
        //				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
        //				i.click();
        //				break;
        //			}
        //		}
    }

    public void pressSearchCompany(){
        $(btnSearchCompany).isDisplayed();
        $(btnSearchCompany).click();
    }

    private void clickAccountCircleIcon() throws Exception {
        Thread.sleep(9000);
        System.out.println("accountCircleIcon is display-enable : "+$(accountCircleIcon).isDisplayed()+" - "+$(accountCircleIcon).isEnabled());
        evaluateJavascript("arguments[0].click();", $(accountCircleIcon));
    }

    private void clickMenuIcon() throws Exception {
        Thread.sleep(waitResponse);
        $(menuAccount).click();
    }

    public void myMenuAccount(String menu) throws Exception {
        clickAccountCircleIcon();
        Thread.sleep(waitResponse);
        evaluateJavascript("arguments[0].click();", $(By.xpath("//*[contains(text(), '" + menu +  "')]")));
        Thread.sleep(waitResponse);
    }

    public void myMenuAccountNotAvailable(String menu) throws Exception {
        clickAccountCircleIcon();
        try {
            evaluateJavascript("arguments[0].click();", $(By.xpath("//*[contains(text(), '" + menu +  "')]")));
        } catch (NoSuchElementException e) {
            System.out.println("Menu item '" + menu + "' not found.");
        }
    }

    public void page(String page) throws Exception{
        Thread.sleep(waitResponse);
        evaluateJavascript("window.scrollBy(0,700)", "");
        System.out.println("cookie button is display-enable : "+$(pageOption).isDisplayed()+" - "+$(pageOption).isEnabled());
        evaluateJavascript("arguments[0].click();", $(pageOption));
        evaluateJavascript("arguments[0].click();", $(By.xpath("//div[contains(text(), '"+ page +"') and @tabindex='0']")));
        Thread.sleep(waitResponse);
    }

    public void clickCircleMenuAccount() throws Exception {
        Thread.sleep(waitResponse);
//		driver.get("https://sandbox.cubeforall.com/portal/manage-subscription/");
        clickAccountCircleIcon();
        Thread.sleep(waitResponse);
        $(menuAccount).click();
        $(ClickSubscribe).isDisplayed();
        $(ClickSubscribe).click();
        Thread.sleep(waitResponse);
    }

    public void clickMenuAccountFront() throws Exception {
        Thread.sleep(waitResponse);
        clickMenuIcon();
        Thread.sleep(waitResponse);
        $(ClickSignOut).click();
        Thread.sleep(waitResponse);
    }

    public void pressJoinCompany(int position) throws Exception{
        Thread.sleep(waitResponse);
        List<WebElement> lsBtnJoinCompany = getDriver().findElements(btnJoinCompanies);
        lsBtnJoinCompany.get(position).isDisplayed();
        lsBtnJoinCompany.get(position).click();
    }

    public void pressCreateNewCompany(){
        $(btnCreateCompany).isDisplayed();
        evaluateJavascript("arguments[0].click();", $(btnCreateCompany));
    }

    public WebElement createNewCompany(){
        evaluateJavascript("window.scrollBy(0,150)", "");
        return $(btnCreateCompany);
    }

    public void pressWithdrawApplication() throws Exception{
        Thread.sleep(waitResponse);
        $(btnWithdrawApplication).isDisplayed();
        $(btnWithdrawApplication).click();
    }
    public void pressRejectApplicationFromCompanyByUser(){
        $(btnRejectApplicationFromUser).isDisplayed();
        $(btnRejectApplicationFromUser).click();
    }
    public void pressAcceptApplicationFromCompanyByUser(){
        $(btnAcceptApplicationFromUser).isDisplayed();
        $(btnAcceptApplicationFromUser).click();
    }
    public void pressPreviousPageOnCompanyLists(){
        $(btnPaginationLeftArrow).isDisplayed();
        $(btnPaginationLeftArrow).click();
    }
    public void pressNextPageOnCompanyLists(){
        $(btnPaginationRightArrow).isDisplayed();
        $(btnPaginationRightArrow).click();
    }
    public void selectFilterUsersOnMembers(String filter) throws Exception{
        Thread.sleep(waitResponse);
        $(dropdownFilterUsersOnMembers).click();
        Thread.sleep(waitResponse);
        List<WebElement> lsFilterUsersOnMembers = getDriver().findElements(lsFilterUsersOnMember);
        switch (filter) {
            case "All":
                lsFilterUsersOnMembers.get(0).click();
                break;
            case "Pending Accept":
                lsFilterUsersOnMembers.get(1).click();
                break;
            case "Pending Approve":
                lsFilterUsersOnMembers.get(2).click();
                break;
            case "Active":
                lsFilterUsersOnMembers.get(3).click();
                break;
            default:
                break;
        }
    }

    public String companyListsTable(){
        List<WebElement> tblCompanyList = getDriver().findElements(tblCompany);
        String result="";
        if(tblCompanyList==null) {
            result="system didnt found the suggested company matched";
        }else {
            result="system found the suggested company matched";
        }
        return result;
    }

    public void pressCancelOnModalMyCompany(){
        $(btnCancelOnModal).isDisplayed();
        $(btnCancelOnModal).click();
    }

    public void pressConfirmWithdrwawRquestCompany() throws Exception{
        Thread.sleep(waitResponse);
        $(btnConfirmOnConfirmWithdraw).isDisplayed();
        $(btnConfirmOnConfirmWithdraw).click();
    }
    public void pressConfirmRequestCompany() throws Exception{
        Thread.sleep(waitResponse);
        $(btnConfirmOnJoinRquest).isDisplayed();
        $(btnConfirmOnJoinRquest).click();
    }
    public void pressInviteOnModalMyCompany(){
        $(btnInviteOnModal).isDisplayed();
        $(btnInviteOnModal).click();
    }
    public void pressLaterOnModalMyCompany(){
        $(btnLaterOnModal).isDisplayed();
        $(btnLaterOnModal).click();
    }
    public void pressSetupNowOnModalMyCompany(){
        $(btnSetupNowOnModal).isDisplayed();
        $(btnSetupNowOnModal).click();
    }

    public void setupNowModalDisplayed(){
        $(btnSetupNowOnModal).isDisplayed();
    }

    public void clickbtnProceedConfirmationCreateCompany() {
        $(btnProceedConfirmationCreateCompany).waitUntilClickable();
        $(btnProceedConfirmationCreateCompany).click();
    }

    public void clickbtnLaterConfirmationCreateCompany() {
        $(btnLaterConfirmationCreateCompany).click();
    }

    public void clickCheckBoxRegisterSameMailing() {
        evaluateJavascript("window.scrollBy(0,250)", "");
        $(checkBoxSameAsRegisterAddress).isDisplayed();
        $(checkBoxSameAsRegisterAddress).click();
    }
    public void clickButtonSubmitCompany() throws Exception {
        Thread.sleep(waitResponse);
        evaluateJavascript("window.scrollBy(0,100)", "");
        System.out.println("btnSubmit company is displaying: "+$(btnSubmit).isDisplayed()+" also enabled: "+$(btnSubmit).isEnabled());
        $(btnSubmit).click();
    }
    public void inputCompanyMobileNumberCompanyDetails(String contactNo){
        $(txtMobileNumberMobileDetails).clear();
        $(txtMobileNumberMobileDetails).sendKeys(contactNo);
    }

    public void inputContactNameSetupCompany(String contactName){
        $(txtContactName).clear();
        $(txtContactName).sendKeys(contactName);
    }

    public void inputDesignationSetupCompany(String designation){
        $(txtDesignation).clear();
        $(txtDesignation).sendKeys(designation);
    }
    public void inputCompanyEmailSetupCompanyDetails(String companyemail){
        $(txtCompanyemail).clear();
        $(txtCompanyemail).sendKeys(companyemail);
    }
    public void inputMobileNoSetupCompany(String mobileNo){
        List<WebElement> domainNumber = getDriver().findElements(domainNumbers);
        List<WebElement> selectDomainNumberCounty = getDriver().findElements(selectDomainNumberCounties);
        domainNumber.get(1).click();
        selectDomainNumberCounty.get(0).click();
        $(txtMobileNo).clear();
        $(txtMobileNo).sendKeys(mobileNo);
    }

    public void inputEmailSetupCompany(String email){
        $(txtEmail).clear();
        $(txtEmail).sendKeys(email);
    }

    public void inputIataMembershipNoSetupCompany(String iataMemberNo){
        $(txtIataMembershipNo).clear();
        $(txtIataMembershipNo).sendKeys(iataMemberNo);
    }

    public void inputCassNoSetupCompany(String cassNo){
        $(txtCassNo).clear();
        $(txtCassNo).sendKeys(cassNo);
    }

    public void inputAddress(String address){
        $(txtAddress).clear();
        $(txtAddress).sendKeys(address);
    }

    public void inputPostCode(String postCode){
        $(txtPostCode).clear();
        $(txtPostCode).sendKeys(postCode);
    }

    public void pressSubmitCreateCompany(){
        $(btnSubmit).isDisplayed();
        $(btnSubmit).click();
    }

    public void selectSorting(String nameSort){
        name = nameSort;
        $(sorting).isDisplayed();
        $(sorting).click();
    }

    public void validateMatchWithDomainNameOfTheUsers() throws InterruptedException {
        //verified the url + path
        Thread.sleep(25000);
        String getUrl = getDriver().getCurrentUrl();
        System.out.println(getUrl);
        System.out.println(Constants.URL_PATH_COMPANY);
        Assert.assertTrue(getUrl.contains(Constants.URL_PATH_COMPANY));
        //		Thread.sleep(waitResponse);
        //		Assert.assertEquals(Constants.COMPANY_PATH_URL,getUrl);
        //		myCompanyPOM.clickAccountCircleIcon();
        //		Assert.assertEquals("https://sandbox.cubeforall.com/portal/manage-company/",getUrl);
        //		Thread.sleep(waitResponse);
        //		Assert.assertEquals("https://dev.cubeforall.com/portal/manage-company/",getUrl);


        //		try{
        //			//verified the table was displayed or not
        //			myCompanyPOM.companyListsTable().isDisplayed();
        //			//assert the company list contents
        //			String compListTable = myCompanyPOM.companyListsTable().getText();
        //			Assert.assertEquals(Constants.FULL_EMAIL, compListTable);
        //			System.out.println(compListTable);
        //		}catch (Exception e){
        //			System.out.println("The table was not exist "+e);
        //		}
        //		myCompanyPOM.inputCompanyNameOnMyCompany(getUrl)
        Thread.sleep(5000);
    }

    //TODO apakah masih dipakai

    //	public void pressAcceptRequestPerUserOnMemberByAdmin(int indexing){
    //		index = indexing;
    //		driver.findElement(btnAcceptPendingApprovalPerUsers).isDisplayed();
    //		driver.findElement(btnAcceptPendingApprovalPerUsers).click();
    //	}

    //	public void pressRemovePerUserOnMemberByAdmin(int indexing){
    //		index = indexing;
    //		driver.findElement(btnRemovePerUsers).isDisplayed();
    //		driver.findElement(btnRemovePerUsers).click();
    //	}

    //	public WebElement changeRolePerUserOnMemberByAdmin(int indexing){
    //		index = indexing;
    //		return driver.findElement(btnChangeRolePerUsers);
    //	}

    //	public void selectCompanyType(String companyType){
    //		Select selectCompanyType = new Select(driver.findElement(dropdownCompanyType));
    //		selectCompanyType.selectByVisibleText(companyType);
    //	}

//    public void selectStatusMember() {
//        //*[@id="cube-members"]/tbody/tr/td[1]/label/span
//        //		lschckboxMember
//    }

//    public void clickUnsubscribeAWBConcierge() throws Exception {
//
//    }

    //	public void pressConfirmOnModalMyCompany() throws Exception{
    //		Thread.sleep(waitResponse);
    //		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
    //		//		driver.findElement(btnConfirmOnModal).isDisplayed();
    //		//		driver.findElement(btnConfirmOnModal).click();
    //		btnConfirmOnModal.isDisplayed();
    //		btnConfirmOnModal.click();
    //	}
}
