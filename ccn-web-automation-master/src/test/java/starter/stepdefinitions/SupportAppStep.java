package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.pages.GoToUrl;
import starter.pages.LoginPage;
import starter.pages.SupportAppPage;
import starter.utlis.Constants;

public class SupportAppStep {

    @Steps
    GoToUrl goToUrl;

    @Steps
    LoginPage loginPage;

    @Steps
    SupportAppPage supportAppPage;

    private int waitResponse = 3000;
    private String input = "";
    @Given("go to support app web")
    public void goToSupportAppWeb() throws InterruptedException {
        goToUrl.goToAbsUrl(Constants.URL_SUPPORT_APP_WEB);
        Thread.sleep(3000);
    }

    @When("input user ID {string} and password {string} and submit button to continue login")
    public void inputUserIDAndPasswordAndSubmitButtonToContinueLogin(String userID, String password) throws Exception {
        Thread.sleep(waitResponse);
        loginPage.inputSigninSupportApp(userID,password);
    }
    @When("user input {string} and click search")
    public void userInputAWBPrefixAndClickSearch(String AirlineSearchBy) throws Exception {
        Thread.sleep(400);
        loginPage.inputAwbPrefixToGetAirlinesCompanyIdentity(AirlineSearchBy);
    }
    @When("try to edit {string} in airline company identity")
    public void tryToEditInAirlineCompanyIdentity(String address3) throws Exception {
        Thread.sleep(400);
        loginPage.editAirlinesCompanyIdentity(address3);
    }
    @When("user input all data required to create company like {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void user_input_all_data_required_to_create_airline_company_like(String airlineName,String email, String compRegNo, String pimaAddress, String country, String city, String address, String address2, String address3, String carrierCode, String awbPrefix ) throws Exception {
        Thread.sleep(400);
        loginPage.editAirlinesCompanyIdentity(address3);
    }
    @Then("update new plan manager in support app")
    public void updateNewPlanManageriInSupportApp() throws Exception {
        Thread.sleep(waitResponse);
        loginPage.inputPlanManagerSupportApp();
    }
    @When("user go to create discount menu")
    public void userGoToCreateDiscountMenu() {
        supportAppPage.pressDiscountMenu();
        supportAppPage.createDiscountSubMenu();
    }

    @When("user go to subscription menu")
    public void userGoToSubscriptionMenu() {
        supportAppPage.pressSubscriptionMenu();
    }
    @And("user go to upload file onboard submenu")
    public void userGoToUploadFileOnboardSubMenu() throws InterruptedException {
        supportAppPage.pressOnboardFileSubMenu();
    }
    @And("user go to User Bundle Termination submenu")
    public void user_go_to_User_Bundle_Termination_submenu() throws InterruptedException {
        supportAppPage.pressTerminationFileSubMenu();
    }
    @And("user go to User Bundle Amendment submenu")
    public void user_go_to_User_Bundle_Amendment_submenu() throws InterruptedException {
        supportAppPage.pressUserAmendmentFileSubMenu();
    }
    @And("click populate")
    public void click_populate() throws InterruptedException {
        supportAppPage.pressPopulate();
    }
    @Then("error validation cannot pick the date will display")
    public void error_validation_cannot_pick_the_date_will_display() throws InterruptedException {
        Thread.sleep(3000);
    }
    @And("not select the country")
    public void not_select_the_country() throws InterruptedException {
        Thread.sleep(1000);
    }
    @And("not input pima")
    public void not_select_pima() throws InterruptedException {
        Thread.sleep(1000);
    }
    @And("not select effective date")
    public void not_select_effective_date() throws InterruptedException {
        Thread.sleep(1000);
    }
    @Then("error validation display")
    public void error_validation_l_display() throws InterruptedException {
        Thread.sleep(3000);
    }
    @And("click submit to onboard")
    public void click_submit_to_onboard() throws InterruptedException {
        supportAppPage.pressSubmitToOnboard();
    }
    @And("click submit to amendment")
    public void click_submit_to_amendment() throws InterruptedException {
        supportAppPage.pressSubmitAmendment();
    }
    @And("select future effective date {string} in this case just select the month option")
    public void select_future_effective_date_in_this_case_just_select_the_month_option(String effectiveDate) throws InterruptedException {
        supportAppPage.selectMonth(effectiveDate);
    }
    @And("select past future effective date {string}")
    public void select_past_future_effective_date(String effectiveDate) throws InterruptedException {
        supportAppPage.selectMonth(effectiveDate);
    }
    @And("input OCR number {string}")
    public void input_OCR_number(String ocr) throws InterruptedException {
        supportAppPage.inputOCR(ocr);
    }


    @And("user select an excel file to upload file onboard in the support app then populate and submit")
    public void userSelectAnExcelFileToUploadFileOnboardInTheSupportApp() throws InterruptedException {
        supportAppPage.uploadOnboardFileSubMenu();
    }
    @And("user select an excel file to upload file onboard in the support app")
    public void userSelectAnExcelFileToUploadFileOnboardInTheSupportAppOnlySelect() throws InterruptedException {
        supportAppPage.uploadOnboardFileOnly();
    }
    @When("user go to group menu")
    public void userGoToGroupMenu() throws InterruptedException {
        supportAppPage.pressGroupMenu();
    }
    @When("user go to airlines submenu")
    public void userGoToAirlineSubMenu() throws InterruptedException {
        supportAppPage.pressAirlinesSubMenu();
    }
    @When("user go to create new airlines function")
    public void userGoToCreateNewAirlineFunction() throws InterruptedException {
        supportAppPage.pressCreateNewAirlines();
    }
    @When("user press submit to create new airlines")
    public void userPressSubmitToCreateNewAirline() throws InterruptedException {
        supportAppPage.pressSubmitToCreateNewAirlines();
    }
    @And("user go to edit airlines company identity function")
    public void userGoToEditAirline() throws InterruptedException {
        supportAppPage.pressEditAirlines();
    }
    @When("user want to view change log by input filter date {string} and {string}")
    public void userWantViewChangeLog(String startDate, String endDate) throws InterruptedException {
        supportAppPage.viewAirlineChangeLog(startDate, endDate);
    }
    @When("user select airline company identity by carrier code")
    public void userSelectAirlineCompanyIdentityByCarrierCode() throws InterruptedException {
        supportAppPage.selectSearchAirlineCompanyIdentityType();
    }
    @When("user go to notification menu")
    public void userGoToNotificationMenu() throws InterruptedException {
        supportAppPage.pressNotificationMonitoringMenu();
    }

    @When("user go to update plan manager menu")
    public void userGoToUpdatePlanManagerMenu() throws InterruptedException {
        supportAppPage.pressUpdatePlanManager();
    }
    @When("user go to action log")
    public void userGoToActionLog() throws InterruptedException {
        supportAppPage.actionLog();
    }
    @When("user click Action Log Report")
    public void userGoToActionLog2() throws InterruptedException {
        supportAppPage.actionLog();
    }
    @When("check function field on action report")
    public void check_function_field_on_action_report() throws InterruptedException {
        supportAppPage.functionActionLog();
    }
    @Then("all portal admin functions are available except for Portal Access Management")
    public void all_portal_admin_functions_are_available_except_for_Portal_Access_Management() throws InterruptedException {
        supportAppPage.displayVerify();
    }
    @When("user click Access Control")
    public void userClickAccessControl() throws InterruptedException {
        supportAppPage.accessControl();
    }
    @When("verify that the tittle change from “Access Control” to “Portal Access Management.”  on Access Control Sub Menu")
    public void verifyTitleChangeToPortalAccessManagement() throws InterruptedException {
        supportAppPage.verifyTitleChangeToPortalAccessManagement();
    }
    @When("verify that the tittle change from “Group Access” to “Access Group.”  on Access Control Sub Menu")
    public void verifyTitleChangeToAccessGroup() throws InterruptedException {
        supportAppPage.verifyTitleChangeToAccessGroup();
    }
    @When("verify that the tittle change from “User” to “User Management.”  on Access Control Sub Menu")
    public void verifyTitleChangeToUserManagement() throws InterruptedException {
        supportAppPage.verifyTitleChangeToUserManagement();
    }
    @When("Add a new feature titled “Admin Change Log.”")
    public void newFeatureTitledAminChangeLog() throws InterruptedException {
        supportAppPage.newAdminChangeLog();
    }
    @When("user go to a new feature titled “Admin Change Log.”")
    public void userGoToFeatureTitledAminChangeLog() throws InterruptedException {
        supportAppPage.goTonewAdminChangeLog();
    }
    @When("only select a specific Function User Management and no value is selected for User")
    public void userOnlySelectSpecificFunction() throws InterruptedException {
        supportAppPage.selectAdminChangeLogFunction();
        supportAppPage.select_option_user_management();
        supportAppPage.searchAdminChangeLogButton();
    }
    @And("only select a specific Function User Management and User")
    public void only_select_a_specific_Function_User_Management_and_User() throws InterruptedException {
        supportAppPage.selectAdminChangeLogFunction();
        supportAppPage.select_option_user_management();
        supportAppPage.searchAdminChangeLogButton();
        supportAppPage.selectOneOfUserOfAdminChangeLogButton();
    }

    @And("only select a specific Function Access Group and User")
    public void only_select_a_specific_Function_Access_Group_and_User() throws InterruptedException {
        supportAppPage.selectAdminChangeLogFunction();
        supportAppPage.select_option_user_management();
        supportAppPage.searchAdminChangeLogButton();
        supportAppPage.selectOneOfUserOfAdminChangeLogButton();
    }
    @When("only select a specific Function Access Group and no value is selected for User")
    public void only_select_a_specific_Function_Access_Group_and_no_value_is_selected_for_User() throws InterruptedException {
        supportAppPage.selectAdminChangeLogFunction();
        supportAppPage.select_option_access_group();
        supportAppPage.searchAdminChangeLogButton();
    }
    @When("input start date {string} and {string} on support app admin change log")
    public void input_start_date_startDate_and_endDate_on_support_app_admin_change_log(String startDate, String endDate) throws Exception {
        Thread.sleep(waitResponse);
        supportAppPage.inputStartDateACL(startDate);
        supportAppPage.inputEndDateACL(endDate);
    }
    @When("the search will include only specific function User Management and all users")
    public void the_search_will_include_only_specific_function_User_Management_and_all_users() throws InterruptedException {
        supportAppPage.adminChangeLogTableHover();
    }
    @And("the search will include only specific function Access Group and all users")
    public void the_search_will_include_only_specific_function_Access_Group_and_all_users() throws InterruptedException {
        supportAppPage.adminChangeLogTableHover();
    }
    @And("the actions tracked should include creating a new access group, detailing the functions included in that group or recording changes made to existing access group")
    public void the_actions_tracked_should_include_creating_a_new_access_group() throws InterruptedException {
        supportAppPage.adminChangeLogTableHover();
    }
    @When("user verify completeness of the perimeter search")
    public void user_verify_completeness_of_the_perimeter_search() throws InterruptedException{
        supportAppPage.completeness_of_the_perimeter_search();
    }
    @When("verify the data range filter is mandatory.")
    public void verify_the_data_range_filter_is_mandatory() throws InterruptedException{
        supportAppPage.searchAdminChangeLogButton();
        Thread.sleep(waitResponse);
    }
    @When("verify the functions available are “ User Management” & “ Access Group”")
    public void verify_the_functions_available_are_User_Management_Access_Group() throws InterruptedException{
        supportAppPage.selectOptionFunctionInAdminChangeLog();

    }
    @When("the actions tracked should include any changes made by the admin")
    public void the_search_will_include_only_specific_function_User_Management_and_all_users_2() throws InterruptedException {
        supportAppPage.adminChangeLogTableHover();
    }
    @And("the search will include only specific function User Management and specific user")
    public void the_search_will_include_only_specific_function_User_Management_and_all_users_3() throws InterruptedException {
        supportAppPage.adminChangeLogTableHover();
    }
    @And("the search will include only specific function Access Group and specific user")
    public void the_search_will_include_only_specific_function_User_Management_and_all_users_4() throws InterruptedException {
        supportAppPage.adminChangeLogTableHover();
    }
    @And("the search result will include all users and all function actions")
    public void the_search_result_will_include_all_users_and_all_function_actions() throws InterruptedException {
        supportAppPage.adminChangeLogTableHover();
    }
    @And("the onboard data display in support app with correct information")
    public void the_onboard_data_display_in_support_app_with_correct_information() throws InterruptedException {
        supportAppPage.afterPopulateTableHover();
    }
    @And("success submit onboard data")
    public void success_submit_onboard_data() throws InterruptedException {
        supportAppPage.successUploadOnboardMSG();
    }
    @And("success upload terminate user bundle")
    public void success_upload_terminate_user_bundle() throws InterruptedException {
        supportAppPage.successUploadTerminateOnboardMSG();
    }
    @And("The date range filter is compulsory")
    public void The_data_range_filter_is_compulsory() throws InterruptedException {
        supportAppPage.The_data_range_filter_is_compulsory_sign();
    }
    @And("no value is selected whether User or Function")
    public void no_value_is_selected_whether_User_or_Function() throws InterruptedException {
        supportAppPage.The_data_range_filter_is_compulsory_sign();
    }
    @When("user go to subscription support app")
    public void userGoToSubscriptionSupportApp() throws InterruptedException {
        supportAppPage.subscription();
    }
    @When("user click action log dropDown")
    public void userClickActionLogDropDown() throws InterruptedException {
        supportAppPage.clickActionLogDropDown();
    }
    @And("select user to export action log")
    public void selectUserToExportActionLog() throws InterruptedException {
        supportAppPage.selectUserToExportActionLog();
    }
    @And("input start date {string} and end date {string} to export action log")
    public void selectStartEndActionLog(String startDate, String endDate) throws InterruptedException {
        supportAppPage.selectStartEndDateActionLog(startDate, endDate);
    }

    @Then("verify notification monitoring information")
    public void verifyNotificationMonitoringInformation() throws InterruptedException {
        supportAppPage.verifyNotificationMonitoringMenuInfo();
    }
    @Then("verify airline search validation text display")
    public void verifyAirlineSearchValidationTextDisplay() throws InterruptedException {
        supportAppPage.verifyAirlineSearchValidationTextDisplayInformation();
    }
    @Then("verify that Airlines Company Identity already cover Airlines Name, Carrier Code, Awb Prefix, Airlines Address, and System Cube Mail Address")
    public void verifyAirlinesCompanyIdentityCover5Attribute() throws InterruptedException {
        Thread.sleep(600);
        Assert.assertTrue(supportAppPage.fiveAttributeIsDisplayed());
    }
    @Then("verify that new Airlines Company created successfully")
    public void verifyNewAirlinesCompanyIdentityCreated() throws InterruptedException {
        Thread.sleep(600);
        Assert.assertTrue(supportAppPage.fiveAttributeIsDisplayed());
    }

    @When("user go to company info sub menu")
    public void userGoToCompanyInfoSubMenu() throws InterruptedException {
        supportAppPage.companyInfoSubMenu();
    }

    @And("input create discount support web app with {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void inputCreateDiscountSupportWebAppWithAndAndAndAndAndAndAnd(String couponNameFill, String amount,
                                                                          String promoCodeFill, String companyPromoFill, String customer, String priceID,
                                                                          String country, String city) {
        supportAppPage.createDiscount(couponNameFill, amount, promoCodeFill,
                companyPromoFill, customer, priceID, country, city);
    }

    @And("Input {string} the display more info")
    public void InputCompanyInfo(String condition) throws Exception {
        Thread.sleep(3000);
        supportAppPage.pressTypeofSearch(condition);
        switch (condition) {
            case "Company System Address":
                input = Constants.SYSTEM_COMPANY_ADDRESS;
                break;
            case "Company Pima Address":
                input = Constants.COMPANY_PIMA;
                break;
            case "Member Email":
                input = Constants.EMAIL_AUTHORIZED_HAVE_PAYMENT_REQUEST;
                break;
            case "Company Cube ID":
                input = Constants.CUBE_ID;
                break;
            case "Company Name":
            case "Company UEN":
                input = Constants.COMPANY_NAME_SEARCH;
                break;
            case "Company Domain":
                input = Constants.COMPANY_NAME_DOMAIN;
                break;
            default:
                input = Constants.EMAIL_WITHOUT_COMPANY;
        }
        Thread.sleep(2500);
        supportAppPage.inputCompany(input);
        supportAppPage.pressSCheckButton();
        Thread.sleep(3000);
        Assert.assertTrue(supportAppPage.CompanyName());
        Assert.assertTrue(supportAppPage.CompanyCubeID());
        Assert.assertTrue(supportAppPage.CompanySystemCube());
        Assert.assertTrue(supportAppPage.CompanyPIMA());
        Assert.assertTrue(supportAppPage.GHA());
        Assert.assertTrue(supportAppPage.GHACode());
        Assert.assertTrue(supportAppPage.UEN());
        Assert.assertTrue(supportAppPage.CompanyCountry());
        Assert.assertTrue(supportAppPage.CompanyMembers());
        Thread.sleep(4000);
    }
    @And("select the country {string}")
    public void select_the_country(String country) throws Exception {
        Thread.sleep(2000);
        supportAppPage.pressSelectCountry(country);
        switch (country) {
            case "Singapore":
                input = Constants.SG;
                break;
            case "Philippines":
                input = Constants.PH;
                break;
            case "Vietnam":
                input = Constants.VN;
                break;
            case "Indonesia":
                input = Constants.ID;
                break;
            default:
                input = Constants.EMAIL_WITHOUT_COMPANY;
        }
        Thread.sleep(1500);
    }



    @And("input {string} to display update plan manager function")
    public void InputPlanManagerMail(String planManagerMail) throws Exception {
        Thread.sleep(2000);
        switch (planManagerMail) {
            case "HQ":
                input = Constants.HQ;
                break;
            default:
                input = Constants.EMAIL_WITHOUT_COMPANY;
        }
        supportAppPage.inputCompany(input);
        supportAppPage.pressSCheckButton();
        Thread.sleep(3000);
        Assert.assertTrue(supportAppPage.currentPlanManager());
    }

    @When("user go to create plan support web app menu")
    public void userGoToCreatePlanSupportWebAppMenu() {
        supportAppPage.pressSubscribtionMenu();
        supportAppPage.pressProductSubMenu();
        supportAppPage.pressCreatePlan();
    }

    @And("input create plan in support web app with {string} and {string} and {string}")
    public void inputCreatePlanInSupportWebAppWithAndAnd(String name, String productPlanName, String description) {
        supportAppPage.createPlanInput(name, productPlanName, description);
    }

    @When("add new price on new plan")
    public void addNewPriceOnNewPlan() {
        supportAppPage.pressSubscribtionMenu();
        supportAppPage.pressProductSubMenu();
        supportAppPage.addNewPrice();
    }

    @And("add new price in support web app with {string} and {string} and {string}")
    public void addNewPriceInSupportWebAppWithAndAnd(String nickName, String unitAmount, String memberLimit) {
        supportAppPage.addNewPriceInput(nickName, unitAmount, memberLimit);
    }

    @When("user go to manage banner support app")
    public void userGoToManageBannerSupportApp() throws InterruptedException {
        supportAppPage.manageBanner();
    }

    @When("upload an advertisement image")
    public void uploadAnAdvertisementImage() throws InterruptedException {
        supportAppPage.uploadBannerAdvertisement();
    }

    @When("set a {string} and {string} for the advertisement")
    public void setAAndForTheAdvertisement(String startDate, String endDate) throws InterruptedException {
        supportAppPage.bannerDate(startDate, endDate);
    }

    @And("input the advertisement URL {string} to learn more")
    public void inputTheAdvertisementURLToLearnMore(String adsUrl) throws InterruptedException {
        supportAppPage.AdvertisementURL(adsUrl);
    }

    @Then("the image should be displayed in a preview section")
    public void theImageShouldBeDisplayedInAPreviewSection() throws InterruptedException {
        supportAppPage.adsPreviewImage();
        
    }

    @And("click the manage banner save button")
    public void clickTheManageBannerSaveButton() {
        supportAppPage.manageBannerSave();
    }

    @And("input targeted advertisement {string}")
    public void inputTargetedAdvertisement(String country) throws InterruptedException {
        supportAppPage.adsTargetedCountry(country);
    }

    @And("select frequency on {string} value")
    public void selectFrequencyOnValue(String frequencyValue) {
        supportAppPage.selectFrequency(frequencyValue);
    }

    @And("input targeted advertisement with multiple country {string} {string}")
    public void inputTargetedAdvertisementWithMultipleCountry(String country, String country2) throws InterruptedException {
        supportAppPage.adsTargetedMultipleCountry(country, country2);
    }

    @And("click the manage banner save button then return error because any overlapping data")
    public void clickTheManageBannerSaveButtonThenReturnErrorBecauseAnyOverlappingData() throws InterruptedException {
        supportAppPage.manageBannerSaveReallyClick();
    }

    @Then("view image in job list advertisement configuration log")
    public void viewImageInJobListAdvertisementConfigurationLog() throws InterruptedException {
        supportAppPage.viewImageInTheJobList();
    }

    @Then("edit job list advertisement configuration log")
    public void editJobListAdvertisementConfigurationLog() throws InterruptedException {
        supportAppPage.editTheAdsJobList();
    }

    @Then("delete job list advertisement configuration log")
    public void deleteJobListAdvertisementConfigurationLog() throws InterruptedException {
        supportAppPage.deleteTheAdsJobList();
    }

    @And("verify the onboard transaction record on the log on certain {string} {string}")
    public void verifyTheTransactionRecordOnTheLog(String startDate, String endDate) throws InterruptedException {
        supportAppPage.actionLog();
        supportAppPage.functionActionLog();
        supportAppPage.functionActionLogOptionUploadFileOnboard();
        supportAppPage.actionLogReportDate(startDate, endDate);
    }

    @And("verify output onboard file")
    public void verifyOutputOnboardFile() {
        supportAppPage.printFilesInSandboxDirectory();
    }
    @And("verify output amendment file")
    public void verifyOutputAmendmentFile() {
        supportAppPage.printFilesInSandboxDirectory();
    }
    @And("verify output termination file")
    public void verifyOutputTerminationFile() {
        supportAppPage.printFilesInSandboxDirectory();
    }
    @Then("validation please select future date when onboard appear")
    public void validationPleaseSelectFutureDateWhenOnboardAppear() {
        try {
            Thread.sleep(3000); // 3 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("input pima {string}")
    public void inputPima(String pima) throws InterruptedException {
        supportAppPage.inputPima(pima);
    }

    @And("press edit amendment")
    public void pressEditAmendment() throws InterruptedException {
        supportAppPage.pressEditAmendment();
    }

    @When("user want to edit total number of account to {string}")
    public void userWantToEditTotalNumberOfAccountTo(String totalNumberAccount) throws InterruptedException {
        supportAppPage.editTotalNumberOfAccount(totalNumberAccount);
    }

    @And("save the amendment change")
    public void saveTheAmendmentChange() throws InterruptedException {
        supportAppPage.pressSaveAmendmentChanges();
    }

    @Then("success amendment user bundle")
    public void successAmendmentUserBundle() throws InterruptedException {
        supportAppPage.successUploadAmendmentMSG();
    }

    @And("verify the amendment record on the log on the certain {string} {string}")
    public void verifyTheAmendmentRecordOnTheLogOnTheCertain(String startDate, String endDate) throws InterruptedException {
        supportAppPage.actionLog();
        supportAppPage.functionActionLog();
        supportAppPage.functionActionLogOptionAmend();
        supportAppPage.actionLogReportDate(startDate, endDate);
    }

    @And("click submit to termination")
    public void clickSubmitToTermination() throws InterruptedException {
        supportAppPage.pressSubmitAmendment();
    }

    @And("verify the termination record on the log on the certain {string} {string}")
    public void verifyTheTerminationRecordOnTheLogOnTheCertain(String startDate, String endDate) throws InterruptedException {
        supportAppPage.actionLog();
        supportAppPage.functionActionLog();
        supportAppPage.functionActionLogOptionTerminate();
        supportAppPage.actionLogReportDate(startDate, endDate);
    }
}
