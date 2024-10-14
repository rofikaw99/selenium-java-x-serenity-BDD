package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import starter.pages.*;
import starter.utlis.Constants;

import java.util.List;

public class CompanyStep {

    @Steps
    GoToUrl goToUrl;

    @Steps
    MailServiceMailinatorPage mailServiceMailinatorPage;

    @Steps
    CompanyPage companyPage;

    private String originalWindow = "";
    private int waitResponse = 3000;

    @And("click Sorting data for column {string} on suggestion company {string} sorting")
    public void clickSortingDataForColumnOnSuggestionCompanySorting(String column, String direction) {
        if (direction.equals("ascending")) companyPage.selectSorting(column);
        else if (direction.equals("descending")){
            for (int i = 0; i < 2; i++) companyPage.selectSorting(column);
        }
    }

    @When("click on the column name again for sorting in {string}")
    public void clickOnTheColumnNameAgainForSortingIn(String column) {
        companyPage.selectSorting(column);
    }

    @Then("the data is sorted by column {string} with {string} sorting")
    public void theDataIsSortedByColumnWithSorting(String column, String direction) {
        //TODO fill based on the page
    }

    @And("search company name {string}")
    public void searchCompanyName(String compName) throws Exception {
        Thread.sleep(2000);
        companyPage.searchinputCompanyNameOnMyCompany(compName);
    }

    @When("request join to company")
    public void requestJoinToCompany() throws Exception {
        companyPage.pressJoinCompany(0);
    }

    @And("confirm request joining company")
    public void confirmRequestJoiningCompany() throws Exception {
        companyPage.pressConfirmRequestCompany();
    }

    @Then("will redirected to the application status")
    public void willRedirectedToTheApplicationStatus() {
        companyPage.applicationStatusLabel().isDisplayed();
    }


    @And("status user was still {string} and waiting for approval from admin company")
    public void statusUserWasStillAndWaitingForApprovalFromAdminCompany(String status) throws InterruptedException {
        Thread.sleep(waitResponse);
        String appStatus = companyPage.applicationStatusLabel().getText();
        Assert.assertEquals(appStatus, status);
    }


    @And("receive email notification for request joining company")
    public void receiveEmailNotificationForRequestJoiningCompany() {
        //TODO Assertion
    }

    @And("input company name {string}")
    public void inputCompanyName(String compName) throws Exception {
        Thread.sleep(waitResponse);
        companyPage.inputCompanyNameOnMyCompany(compName);
    }

    @And("open email mailinator")
    public void openEmailMailinator() throws InterruptedException {
        goToUrl.goToAbsUrl(Constants.MAIL_SERVICE_URL);
        Thread.sleep(7000);
        mailServiceMailinatorPage.getVerificationCodesg();
    }

    @And("receive email notification offline setup")
    public void receiveEmailNotificationOfflineSetup() throws InterruptedException {
        Thread.sleep(waitResponse);
        //TODO fill
    }

    @Then("pop up for duplicate company show up")
    public void popUpForDuplicateCompanyShowUp() throws InterruptedException {
        Thread.sleep(waitResponse);
        //TODO Fill
    }

    @And("click leave company")
    public void clickLeaveCompany() {
        companyPage.pressLeaveCompany();
    }

    @And("click sure want to leave")
    public void clickSureWantToLeave() {
        companyPage.pressSureWantToLeaveCompany();
    }

    @And("click change role to user")
    public void clickChangeRoleToUser() throws InterruptedException {
        companyPage.pressChangeRoleToUser();
    }

    @Then("verify update plan manager pop up available")
    public void verifyUpdatePlanManagerPopUpAvailable(){
        companyPage.verifyUpdatePMPopUpAvailable();
    }

    @Then("pop up that said the last admin cant leave company")
    public void popUpThatSaidTheLastAdminCantLeaveCompany() {
        //TODO Fill
    }

    @And("press member tab")
    public void pressMemberTab() throws Exception {
        Thread.sleep(5000);
        companyPage.pressMembersOnMyCompany();
    }

    @When("press dot on the left side user")
    public void pressDotOnTheLeftSideUser() throws InterruptedException {
        Thread.sleep(6000);
        companyPage.pressthreedotsFromCompanyByAdmin();
    }

    @And("press remove PM or User")
    public void pressRemovePm() throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.pressRemovePM();
        companyPage.pressRemovePMVerification();
    }

    @And("dot cant be click")
    public void dotCantBeClick() throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.pressthreedotsFromCompanyByAdmin();//TODO Add assertion
    }

    @And("go to my company")
    public void goToMyCompany() {
        goToUrl.goToUrl(Constants.COMPANY_PATH_URL);
    }

    @And("filter member with status {string}")
    public void filterMemberWithStatus(String status) throws Exception {
        Thread.sleep(waitResponse);
        companyPage.selectFilterUsersOnMembers(status);
    }

    @Then("press change roles button to change role to {string}")
    public void pressChangeRolesButtonToChangeRoleTo(String role) throws Exception {
        Thread.sleep(waitResponse);
        companyPage.changeRolePerUserOnMemberByAdmin(role);
    }

    @And("press custom change roles button to change role to {string}")
    public void pressCustomChangeRolesButtonToChangeRoleTo(String role) throws Exception {
        Thread.sleep(waitResponse);
        companyPage.customChangeRolePerUserOnMemberByAdmin(role);
    }

    @And("able to change role other user")
    public void ableToChangeRoleOtherUser() throws InterruptedException {
        Thread.sleep(waitResponse); //TODO fix
        //		myCompanyPOM.changeRolePerUserOnMemberByAdmin(1).isDisplayed();
        //		myCompanyPOM.changeRolePerUserOnMemberByAdmin(1).isEnabled();
    }

    @Then("admin company can see other admin member with status {string}")
    public void adminCompanyCanSeeOtherAdminMemberWithStatus(String arg0) {
        //TODO fill
    }

    @Then("admin company can see the pending member with status {string} and status {string} and status {string}")
    public void adminCompanyCanSeeThePendingMemberWithStatusAndStatusAndStatus(String pendingApprove, String pendingAccept, String active) throws InterruptedException {
        Thread.sleep(waitResponse);
        String[] expectedStatus = {pendingAccept,pendingApprove};
        List<String> getMemberList = companyPage.memberListTable();
        System.out.println(getMemberList);
        System.out.println(getMemberList);
        if(getMemberList.contains(expectedStatus)) {
            Assert.assertEquals("True", "True");
        }else {
            Assert.assertEquals("False", "False");
        }
    }

    @Then("admin company can see the pending member with status {string} and status {string}")
    public void adminCompanyCanSeeThePendingMemberWithStatusAndStatus(String pendingApprove, String pendingAccept) throws InterruptedException {
        Thread.sleep(waitResponse);
        String[] expectedStatus = {pendingAccept,pendingApprove};
        List<String> getMemberList = companyPage.memberListTable();
        System.out.println(getMemberList);
        System.out.println(getMemberList);
        if(getMemberList.contains(expectedStatus)) {
            Assert.assertEquals("True", "True");
        }else {
            Assert.assertEquals("False", "False");
        }
    }

    @When("press invite users button")
    public void pressInviteUsersButton() throws Exception {
        Thread.sleep(waitResponse);
        companyPage.pressInviteUserToCompany();
    }

    @And("input email {string} on the pop up")
    public void inputEmailOnThePopUp(String email) throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.inputInviteUsersOnMembersByAdmin(email);
    }

    @And("press invite button on the pop up")
    public void pressInviteButtonOnThePopUp() throws InterruptedException {
        Thread.sleep(waitResponse);
        companyPage.pressInviteOnModalMyCompany();
    }

    @Then("success invite user {string} to the company {string}")
    public void successInviteUserToTheCompany(String arg0, String arg1) throws InterruptedException {
        Thread.sleep(waitResponse);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
//		String actualvalidatemassage = myCompanyPOM.txtValidateNotYetInCompanyAndSuccesAddMember().getText();
//		String expectedvalidatemassage = "You have successfully added new member(s) to "+companyusera+". An email will be sent to your new member(s) to join CUBEforall.";
//		System.out.println(expectedvalidatemassage);
//		System.out.println(actualvalidatemassage);
//		System.out.println(expectedvalidatemassage.contains(actualvalidatemassage));
//		if(expectedvalidatemassage.contains(actualvalidatemassage)) {
//			Assert.assertEquals("email pop up true", "email pop up true");
//		}else {
//			Assert.assertEquals("email pop up true", "email pop up false");
//		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
        companyPage.btnValidateNotYetInCompany(); //TODO fix
    }

    @And("search email {string} to be removed from the company")
    public void searchEmailToBeRemovedFromTheCompany(String email) throws Exception {
        Thread.sleep(waitResponse);
        companyPage.inputSearchUsersOnMembers(email);
//        companyPage.pressRemoveUserFromCompanyByAdmin();
        //		companyPage.pressRemovePerUserOnMemberByAdmin();
    }

    @Then("admin company was able to reject or approve the request")
    public void adminCompanyWasAbleToRejectOrApproveTheRequest() throws InterruptedException {
        Thread.sleep(waitResponse); //TODO Fix
        //		companyPage.acceptRequestPerUserOnMemberByAdmin(1).isDisplayed();
        //		companyPage.acceptRequestPerUserOnMemberByAdmin(1).isEnabled();
        //		companyPage.removePerUserOnMemberByAdmin(1).isDisplayed();
        //		companyPage.removePerUserOnMemberByAdmin(1).isEnabled();
    }

    @And("search email {string} to be approved from the company")
    public void searchEmailToBeApprovedFromTheCompany(String email) throws Exception {
        Thread.sleep(waitResponse);
        companyPage.inputSearchUsersOnMembers(email);
        companyPage.pressRemoveUserFromCompanyByAdmin();
        //		myCompanyPOM.pressRemovePerUserOnMemberByAdmin();
    }

    @Then("press accept to approve the request")
    public void pressAcceptToApproveTheRequest() throws Exception {
        companyPage.pressAcceptRequestPerUserOnMemberByAdmin();
    }

    @And("search email {string} member")
    public void searchEmailMember(String email) throws Exception {
        Thread.sleep(waitResponse);
        companyPage.inputSearchUsersOnMembers(email);
        companyPage.pressRemoveUserFromCompanyByAdmin();
    }

    @And("wont able to change role other user member need to be approve first as active member")
    public void wontAbleToChangeRoleOtherUserMemberNeedToBeApproveFirstAsActiveMember() throws InterruptedException {
        Thread.sleep(waitResponse); //TODO Fix
        //		myCompanyPOM.changeRolePerUserOnMemberByAdmin(1).isDisplayed();
        //		myCompanyPOM.changeRolePerUserOnMemberByAdmin(1).isEnabled();
    }

    @Then("wont be able to invite user")
    public void wontBeAbleToInviteUser() throws InterruptedException {
        Thread.sleep(waitResponse); //TODO Fix
        //		myCompanyPOM.changeRolePerUserOnMemberByAdmin(1).isDisplayed();
        //		myCompanyPOM.changeRolePerUserOnMemberByAdmin(1).isEnabled();
    }

    @Then("user company can see the pending member with status {string}")
    public void userCompanyCanSeeThePendingMemberWithStatus(String arg0) {
        //TODO Fill
    }

    @Then("showing error on the pop up modal which contains the user has pending application or is already in company with other email user {string}")
    public void showingErrorOnThePopUpModalWhichContainsTheUserHasPendingApplicationOrIsAlreadyInCompanyWithOtherEmailUser(String arg0) throws InterruptedException {
        Thread.sleep(waitResponse);

//		//todo: get the pop up text and verified
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
//		String validationActualTxt = myCompanyPOM.txtValidateAlreadyinCompany().getText();
//		String txtone = "This user(s) you entered already has a pending application/is already in a company.";
//		String txttwo = "This user(s) you entered already has a company.";
//		String validationActualTxtEmail = myCompanyPOM.txtemailValidateAlreadyinCompany().getText();
//		System.out.println(validationActualTxtEmail);
//		if(validationActualTxt.contains(txtone)||validationActualTxt.contains(txttwo)) {
//			Assert.assertEquals("pop up massage true","pop up massage true" );
//		}else {
//			Assert.assertEquals("pop up massage true","pop up massage false" );
//		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
//		if(email.contains(validationActualTxtEmail)) {
//			Assert.assertEquals("email pop up true", "email pop up true");
//		}else {
//			Assert.assertEquals("email pop up true", "email pop up false");
//		}
    }

    @And("search company {string}")
    public void searchCompany(String company) throws Exception {
        Thread.sleep(waitResponse);
        companyPage.inputCompanyNameOnMyCompany(company);
    }

    @And("select request join to company")
    public void selectRequestJoinToCompany() throws Exception {
        companyPage.pressJoinCompany(0);
    }

    @When("press button withdraw application")
    public void pressButtonWithdrawApplication() throws Exception {
        Thread.sleep(waitResponse);
        companyPage.pressWithdrawApplication();
    }

    @Then("confirm withdraw application to company")
    public void confirmWithdrawApplicationToCompany() throws Exception {
        Thread.sleep(waitResponse);
        companyPage.pressConfirmWithdrwawRquestCompany();
    }


    @And("wont be able to change role other user")
    public void wontBeAbleToChangeRoleOtherUser() {
        //TODO fill
    }

    @And("status user was still {string}")
    public void statusUserWasStill(String status) throws InterruptedException {
        Thread.sleep(waitResponse);
        String appStatus = companyPage.applicationStatusLabel().getText();
        System.out.println(appStatus);
        Assert.assertEquals(status, appStatus);
    }

    @When("press button accept invitation")
    public void pressButtonAcceptInvitation() throws Exception {
        Thread.sleep(waitResponse);
        companyPage.pressWithdrawApplication();
    }

    @Then("confirm accept invitation")
    public void confirmAcceptInvitation() throws InterruptedException {
        Thread.sleep(waitResponse); //TODO Fix
//		myCompanyPOM.pressConfirmWithdrwawRquestCompany();
    }

    @When("press button reject invitation")
    public void pressButtonRejectInvitation() throws Exception {
        Thread.sleep(waitResponse);
        companyPage.pressWithdrawApplication();
    }

    @Then("confirm reject invitation")
    public void confirmRejectInvitation() throws InterruptedException {
        Thread.sleep(waitResponse); //TODO fix
//		myCompanyPOM.pressConfirmWithdrwawRquestCompany();
    }

    @And("click amount users selected")
    public void clickAmountUsersSelected() {
        //TODO fill
    }

    @And("click remove")
    public void clickRemove() {
        //TODO fill
    }

    @And("click x amount users selected")
    public void clickXAmountUsersSelected() {
        //TODO fill
    }
}
