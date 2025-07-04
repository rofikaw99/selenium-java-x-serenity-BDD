package starter.pages;

import io.cucumber.java.en.Given;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.utlis.Constants;

import java.io.File;
import java.util.List;

public class SupportAppPage extends PageObject {
    private int waitResponse =15000;

    //supportAppDiscount
    private By selectFrequencyDropdown = By.xpath("//select[@class='form-select']");
    private By discountMenu = By.xpath("(//a[@class='ps-menu-button' and @data-testid='ps-menu-button-test-id'])[30]");
    private By subscriptionMenu = By.xpath("(//a[@class='ps-menu-button' and @data-testid='ps-menu-button-test-id'])[32]");
    private By uploadOnboardFileSubMenu = By.xpath("(//a[@class='ps-menu-button' and @data-testid='ps-menu-button-test-id'])[40]");
    private By uploadAmendmentSubMenu = By.xpath("(//a[@class='ps-menu-button' and @data-testid='ps-menu-button-test-id'])[41]");
    private By uploadTerminationSubMenu = By.xpath("(//a[@class='ps-menu-button' and @data-testid='ps-menu-button-test-id'])[42]");
    private By airlines = By.xpath("(//a[@class='ps-menu-button' and @data-testid='ps-menu-button-test-id'])[20]");
    private By populate = By.xpath("//button[@type='button' and contains(text(), 'Populate') ]");
    private By submitToOnboard = By.xpath("//button[@type='button' and contains(text(), 'Submit to Onboard')]");
    private By submitAmendment = By.xpath("//button[text()='Submit']");
    private By editAmendmentBtn = By.xpath("//button[text()='Edit']");
    private By saveAmendmentChanges = By.xpath("//button[text()='Save']");
    private By ocrElement = By.id("ocrNumber");
    private By inputPima = By.id("pimaAddress");
    private By totalNumberAccountField = By.xpath("(//input[contains(@class, 'form-control')])[4]");
    private By selectMonth = By.id("startDate");
    private By actionLogStartDate = By.xpath("//input[@placeholder='Start Date']");
    private By actionLogEndDate = By.xpath("//input[@placeholder='End Date']");
    private By startDateBanner = By.xpath("(//input[@type='date' and @class='form-control'])[1]");
    private By endDateBanner = By.xpath("(//input[@type='date' and @class='form-control'])[2]");
    private By adsUrlAddress = By.xpath("(//input[@class='form-control' and @value=''])[1]");
    private By inputAdsTargetedCountry = By.xpath("//div[contains(@class, 'css-19bb58m')]//input[@type='text']");
    private By createNewAirline = By.xpath("//button[text()='Create New Airline']");
    private By airlineSubmitButton = By.xpath("//button[@type='submit' and contains(@class, 'btn btn-primary') and text()='Submit']");
    private By editAirline = By.xpath("(//button[@type='button' and contains(@class, 'btn btn-link')])[2]");
    private By airlineChangeLogFunction = By.xpath("//button[@type='button' and contains(@class, 'btn btn-link') and text()='logs']");
    private By airlineChangeLogStartDate = By.xpath("(//input[@type='text' and contains(@class, 'form-control') and @value=''])[1]");
    private By airlineChangeLogEndDate = By.xpath("(//input[@type='text' and contains(@class, 'form-control')])[3]");
    private By getAirlineChangeLogSubmitButton = By.xpath("//button[@type='button' and contains(@class, 'btn btn-primary') and text()='Submit']");
    private By airlineSearchBy = By.id("searchType");
    private By optionCarrierCode = By.xpath("//option[@value='carrierCode']");
    private By uploadExcelOnboardFile = By.id("formFile");
    private By uploadBannerAdvertisement = By.xpath("//input[@type='file' and @class='form-control']");
    private By populateOnboardFile = By.xpath("//button[@class='btn btn-primary']");
    private By groupMenu = By.xpath("(//a[@data-testid='ps-menu-button-test-id'])[17]");
    private By notificationMonitoringMenu = By.xpath("(//a[@class='ps-menu-button' and @data-testid='ps-menu-button-test-id'])[14]");
    private By updatePlanManager = By.xpath("(//a[@class='ps-menu-button' and @data-testid='ps-menu-button-test-id'])[34]");
    private By selectActionLogFunction = By.xpath("//button[text()='Select Function']");
    private By uploadFileOnboardLogOption = By.xpath("//a[text()='Upload File Onboarding']");
    private By amendmentLogOption = By.xpath("//a[text()='Cubeforall Bundle Amendment']");
    private By terminationLogOption = By.xpath("//a[text()='Cubeforall Bundle Termination']");
    private By actionLog = By.xpath("(//a[@class='ps-menu-button' and @data-testid='ps-menu-button-test-id'])[2]");
    private By accessControl = By.xpath("//a[@class='ps-menu-button' and @data-testid='ps-menu-button-test-id']//span[contains(text(), 'Portal Access Management')]");
    private By accessGroup = By.xpath("//a[@class='ps-menu-button' and @data-testid='ps-menu-button-test-id']//span[contains(text(), 'Access Group')]");
    private By adminChangeLog = By.xpath("//a[@class='ps-menu-button' and @data-testid='ps-menu-button-test-id']//span[contains(text(), 'Admin Change Log')]");
    private By searchAdminChangeLogButton = By.xpath("//button[contains(@class, 'btn-primary') and text()='Search']");
    private By select_option_dropdown_toggle_btn_btn_outline_secondary = By.xpath("//button[contains(@class, 'dropdown-toggle') and text()='Select Function']");
    private By option_userManagement = By.xpath("//a[contains(@class, 'dropdown-item') and text()='User Management']");
    private By option_access_group = By.xpath("//a[contains(@class, 'dropdown-item') and text()='Access Group']");
    private By startDateAdminChangeLog = By.xpath("//input[@id='startDate']");
    private By endDateAdminChangeLog = By.xpath("//input[@id='endDate']");
    private By selectAdminChangeLogFunction = By.xpath("//button[@type='button' and @id='dropdown-function' and contains(@class, 'dropdown-toggle')]");
    private By selectUserAdminChangeLog = By.xpath("(//button[contains(@class, 'dropdown-toggle') and contains(@class, 'btn-outline-secondary')])[1]");
    private By selectOneOfUserAdminChangeLog = By.xpath("//a[@href='#' and text()='RAwaludin']");
    private By adminChangeLogTableHover = By.xpath("//table[@class='table table-striped table-bordered table-hover']");
    private By tableHoverDisplayAfterPopulate = By.xpath("//table[contains(@class, 'table-striped') and contains(@class, 'table-bordered') and contains(@class, 'table-hover')]");
    private By successUploadOnboardMessage = By.xpath("//div[contains(@class, 'fade') and contains(@class, 'mt-3') and contains(@class, 'alert') and contains(@class, 'alert-success') and contains(@class, 'show')]");
    private By successSubmitAmendmentMsg = By.xpath("//div[@role='alert' and contains(@class, 'alert-success')]");
    private By successUploadTerminateOnboard = By.xpath("//div[contains(@class, \"alert-success\")]");
    private By the_date_range_filter_compulsory_in_action_log_menu = By.xpath("//span[@style='color: red;' and text()='*']");
    private By selectUserTitleAdminChangeLog = By.xpath("//label[@for='userSelect']");
    private By selectFunctionTitleAdminChangeLog = By.xpath("//label[@for='functionSelect']");
    private By selectDateRangeTitleAdminChangeLog = By.xpath("//label[text()[normalize-space()='Select Date Range']]");
    private By userManagement = By.xpath("//a[@class='ps-menu-button' and @data-testid='ps-menu-button-test-id']//span[contains(text(), 'User Management')]");
    private By subscription = By.xpath("(//a[@data-testid='ps-menu-button-test-id'])[35]");
    private By manageBanner = By.xpath("//span[text()='Manage Banners' and contains(@class, 'ps-menu-label')]");
    private By saveManageBannerConfigButton = By.xpath("//button[@type='button' and contains(@class, 'btn-success') and text()='Save Changes']");
    private By viewImageInJobList = By.xpath("(//button[text()='View'])[1]");
    private By editAdsJoblistBtn = By.xpath("(//button[text()='Edit'])[1]");
    private By deleteAdsList = By.xpath("(//button[text()='Delete'])[1]");
    private By adsPreviewImage = By.xpath("//button[text()='Preview Image']");
    private By actionLogDropDown = By.xpath("//button[@id='dropdown-basic-button']");
    private By selectUserToExportActionLog = By.xpath("(//a[@class='dropdown-item'])[1]");
    private By startDateActionLog = By.xpath("//input[@placeholder='Start Date']");
    private By endDateActionLog = By.xpath("//input[@placeholder='End Date']");
    private By actionLogSearchBtn = By.xpath("//button[text()='Search']");
    private By submitActionLog = By.xpath("//button[@type='submit']");
    private By currentTotalCount = By.xpath("(//p[text()])[2]");
    private By previousTotalCount = By.xpath("(//p[text()])[3]");
    private By currentTotalFailedProcess = By.xpath("(//p[text()])[4]");
    private By previousTotalFailedProcess = By.xpath("(//p[text()])[5]");
    private By currentCountAt = By.xpath("(//h6[text()])[1]");
    private By previousCountAt = By.xpath("(//h6[text()])[2]");
    private By airlineSearchValidationText = By.xpath("//span[contains(@class, 'text-danger')]");
    private By companyName = By.xpath("//th[text()='Company Name']");
    private By airlinesNameTitle = By.xpath("//th[text()='Airline Name']");
    private By emailTitle = By.xpath("//th[text()='Company System Cube']");
    private By stationTitle = By.xpath("//th[text()='Station']");
    private By countryTitle = By.xpath("//th[text()='Country']");
    private By carrierCodeTitle = By.xpath("//th[text()='Carrier Code']");
    private By awbPrefixTitle = By.xpath("//th[text()='AWB Prefix']");
    private By currentPlanManager = By.xpath("//th[text()='Current Plan Manager']");
    private By CompanyCubeID = By.xpath("//th[text()='Company Cube ID']");
    private By CompanySystemCube = By.xpath("//th[text()='Company System Cube']");
    private By CompanyPIMA = By.xpath("//th[text()='Company PIMA']");
    private By GHA = By.xpath("//th[text()='GHA']");
    private By GHACode = By.xpath("//th[text()='GHA Code']");
    private By UEN = By.xpath("//th[text()='UEN']");
    private By CompanyCountry = By.xpath("//th[text()='Company Country']");
    private By CompanyMembers = By.xpath("//th[text()='Company Members']");
    private By createDiscountSubMenu = By.xpath("//span[text()='Create Discount']");
    private By companyInfoInputField = By.xpath("//input[@type='text' and @class='form-control']");
    private By companyInfoSubMenu = By.xpath("//span[contains(text(), 'Company Info')]");
    private By couponName = By.xpath("//input[@placeholder='Coupon Name']");
    private By amountOfCoupon = By.xpath("//input[@placeholder='1000']");
    private By currencyCoupon = By.xpath("(//input[@placeholder='USD'])[1]");
    private By USDdropdownCoupon = By.xpath("//div[@id='Currency-dropdown-item' and text()='USD']");
    private By amountOfPCN = By.xpath("(//input[@placeholder='10000'])[1]");
    private By currencyPCN = By.xpath("(//input[@placeholder='USD'])[2]");
    private By USDdropdownPCN = By.xpath("//div[@id='pcn-currency-dropdown-item' and text()='USD']");
    private By promoCode = By.xpath("//input[@placeholder='UATSUBSPCN7']");
    private By companyPromo = By.xpath("//input[@placeholder='system.company@exchange.com']");
    private By customerPromo = By.xpath("//input[@placeholder='Customers']");
    private By productTypePromo = By.xpath("//div[@id='product-type-dropdown']//input[@placeholder='None']");
    private By CompanydropdownProductTypePromo = By.xpath("//div[@id='product-type-dropdown-item' and text()='Company']");
    private By priceIDfield = By.xpath("//input[@placeholder='Price Id']");
    private By countryPromo = By.xpath("//input[@placeholder='Country']");
    private By cityPromo = By.xpath("//input[@placeholder='City']");
    private By ADCountry = By.xpath("(//*[@id='country-dropdown-0-item'])[1]");
    private By dropdownCountry = By.id("country-dropdown-0-item");
    private By AAECity = By.xpath("//*[@id='city-dropdown-0-item']");
    private By dropdownCity = By.id("city-dropdown-0-item");
    private By checkBoxFirstTime = By.xpath("//span[contains(@class, 'cube-checkmark-checkbox') and contains(@class, 'check')]");
    private By minimumAmountRestriction = By.xpath("(//input[@placeholder='10000'])[2]");
    private By minimumAmountCurrencyRestriction = By.xpath("(//input[@placeholder='USD'])[3]");
    private By USDdropdownCurrencyRestriction = By.xpath("//div[@id='minimum-amount-currency-item' and text()='USD']");
    private By expiredAt = By.xpath("(//div[contains(@class, 'react-datepicker-wrapper')]//input[@type='text'])[1]");
    private By validityStartDate = By.xpath("(//div[contains(@class, 'react-datepicker-wrapper')]//input[@type='text'])[2]");
    private By validityEndDate = By.xpath("(//div[contains(@class, 'react-datepicker-wrapper')]//input[@type='text'])[3]");
    private By expiredAtPick = By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='28']");
    private By startDatePick = By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='8']");
    private By validityEndDatePick = By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='8']");
    private By submitDiscount = By.xpath("(//button[@type='submit'])[2]");
    private By companySystemAddressOption = By.xpath("//a[text()='Company System Address']\n");
    private By checkButton = By.xpath("//button[contains(@class, 'btn btn-primary') and text()='Check']");
    private By createDiscountSuccessMessage = By.xpath("//p[@class='cube-tracking cube-message']");
    private By typeOfSearch = By.xpath("//button[@id='dropdown-basic-button' and text()='Choose Type of Search']");
    private By selectCountry = By.id("selectCountry");
    private By subscribtionMenu = By.xpath("(//a[@class='ps-menu-button' and @data-testid='ps-menu-button-test-id']/span[@class='ps-menu-label css-12w9als'])[27]");
    private By productSubMenu = By.xpath("//span[text()='Product']");
    private By createPlan = By.xpath("//button[text()='Create Plan']");
    private By namePlan = By.xpath("//input[@placeholder='Name']");
    private By productPlanNameField = By.xpath("//input[@placeholder='Product Name']");
    private By serviceIDplan = By.xpath("//input[@placeholder='Service Id']");
    private By FWBdropdown = By.xpath("(//div[@id='-item' and @tabindex='0'])[5]");
    private By submitPlan = By.xpath("(//button[@type='button'])[3]");
    private By descriptionPlanNameField = By.xpath("//input[@placeholder='Description']");

    //addNewPrice
    private By newPlanCreated = By.xpath("(//td[@class='row-label']/div)[1]");
    private By addNewPrice = By.xpath("//button[text()='Add new Price']");
    private By typeOfPrice = By.xpath("//input[@placeholder='Type']");
    private By freeDropDownOptionPrice = By.xpath("(//div[@id='-item' and text()='Free'])[2]");
    private By nickNameInput = By.xpath("//input[@placeholder='Nickname']");
    private By unitAmountInput = By.xpath("//input[@placeholder='Unit Amount']");
    private By memberLimitInput = By.xpath("//input[@placeholder='Member Limit']");
    private By submitPrice = By.xpath("(//button[@type='button'])[4]");

    public void addNewPrice(){
        $(newPlanCreated).isDisplayed();
        $(newPlanCreated).click();
        $(addNewPrice).isDisplayed();
        $(addNewPrice).click();
    }

    public void pressSubscribtionMenu(){
        $(subscribtionMenu).isDisplayed();
        $(subscribtionMenu).click();
    }

    public void pressSCheckButton(){
        $(checkButton).isDisplayed();
        evaluateJavascript("arguments[0].click();", $(checkButton));
    }
    public void pressTypeofSearch(String condition){
        $(typeOfSearch).isDisplayed();
        evaluateJavascript("arguments[0].click();", $(typeOfSearch));
        evaluateJavascript("arguments[0].click();", $(By.xpath("//*[contains(text(), '" + condition +  "')]")));
    }
    public void pressSelectCountry(String country){
        $(selectCountry).isDisplayed();
        evaluateJavascript("arguments[0].click();", $(selectCountry));
        evaluateJavascript("arguments[0].click();", $(By.xpath("//option[@value='" + country + "')]")));
    }

    public void companySystemAddressOption(){
        $(checkButton).isDisplayed();
        evaluateJavascript("arguments[0].click();", $(checkButton));
    }

    public void inputCompany(String input){
        $(companyInfoInputField).waitUntilVisible();
        $(companyInfoInputField).clear();
        $(companyInfoInputField).sendKeys(input);
    }
    public void pressProductSubMenu(){
        $(productSubMenu).isDisplayed();
        $(productSubMenu).click();
    }

    public void pressCreatePlan(){
        $(createPlan).isDisplayed();
        $(createPlan).click();
    }

    public void addNewPriceInput(String nickName, String unitAmount, String memberLimit){
        $(typeOfPrice).isDisplayed();
        $(typeOfPrice).click();
        $(freeDropDownOptionPrice).isDisplayed();
        $(freeDropDownOptionPrice).click();
        $(nickNameInput).isDisplayed();
        $(nickNameInput).sendKeys(nickName+ Constants.FOUR_DIGIT);
        System.out.println(nickName+Constants.FOUR_DIGIT);
        $(unitAmountInput).isDisplayed();
        $(unitAmountInput).sendKeys(unitAmount);
        $(memberLimitInput).isDisplayed();
        $(memberLimitInput).sendKeys(memberLimit);
        $(submitPrice).isDisplayed();
        $(submitPrice).click();
        WebElement element = $(By.xpath("//p[@class='cube-tracking cube-message']"));
        String text = element.getText();
        System.out.println("test status: "+text);

    }

    public void createPlanInput(String name, String productPlanName, String description){
        $(namePlan).isDisplayed();
        $(namePlan).sendKeys(name+Constants.FOUR_DIGIT);
        System.out.println(name+Constants.FOUR_DIGIT);
        $(productPlanNameField).isDisplayed();
        $(productPlanNameField).sendKeys(productPlanName+Constants.FOUR_DIGIT);
        System.out.println(productPlanName+Constants.FOUR_DIGIT);
        $(serviceIDplan).isDisplayed();
        $(serviceIDplan).click();
        $(descriptionPlanNameField).isDisplayed();
        $(descriptionPlanNameField).sendKeys(description+Constants.FOUR_DIGIT);
        System.out.println(description+Constants.FOUR_DIGIT);
        $(FWBdropdown).isDisplayed();
        $(FWBdropdown).click();
        $(submitPlan).isDisplayed();
        $(submitPlan).click();
        $(createDiscountSuccessMessage).isDisplayed();
        WebElement element = $(createDiscountSuccessMessage);
        String text = element.getText();
        System.out.println("test status: "+text);

    }


    public void pressDiscountMenu(){
        $(discountMenu).isDisplayed();
        $(discountMenu).click();
    }

    public void pressSubscriptionMenu(){
        $(subscriptionMenu).isDisplayed();
        $(subscriptionMenu).click();
    }
    public void pressPopulate() throws InterruptedException{
        $(populate).isDisplayed();
        evaluateJavascript("arguments[0].click();", $(populate));
        Thread.sleep(7000);
    }
    public void pressSubmitToOnboard() throws InterruptedException{
        $(submitToOnboard).isDisplayed();
        evaluateJavascript("arguments[0].click();", $(submitToOnboard));
        Thread.sleep(5000);
    }
    public void pressSubmitAmendment() throws InterruptedException{
        $(submitAmendment).isDisplayed();
        evaluateJavascript("arguments[0].click();", $(submitAmendment));
        Thread.sleep(5000);
    }
    public void pressEditAmendment() throws InterruptedException{
        $(editAmendmentBtn).isDisplayed();
        evaluateJavascript("arguments[0].click();", $(editAmendmentBtn));
        Thread.sleep(5000);
    }
    public void pressSaveAmendmentChanges() throws InterruptedException{
        $(saveAmendmentChanges).isDisplayed();
        evaluateJavascript("arguments[0].click();", $(saveAmendmentChanges));
        Thread.sleep(5000);
    }
    public void printFilesInSandboxDirectory() {
        // UNC path ke direktori network
        String path = "\\\\172.21.120.111\\CubeForAll Config\\SANDBOX";
        File folder = new File(path);
        if (folder.exists() && folder.isDirectory()) {
            File[] listOfFiles = folder.listFiles();
            if (listOfFiles != null) {
                System.out.println("Daftar file di direktori SANDBOX:");
                for (File file : listOfFiles) {
                    System.out.println("- " + file.getName());
                }
            } else {
                System.out.println("Tidak ada file ditemukan di direktori tersebut.");
            }
        } else {
            System.out.println("Direktori tidak ditemukan atau tidak dapat diakses.");
        }
    }
    public void pressOnboardFileSubMenu() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", $(uploadOnboardFileSubMenu));
        $(uploadOnboardFileSubMenu).isDisplayed();
        $(uploadOnboardFileSubMenu).click();
        Thread.sleep(1000);
    }
    public void pressTerminationFileSubMenu() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", $(uploadTerminationSubMenu));
        $(uploadTerminationSubMenu).isDisplayed();
        $(uploadTerminationSubMenu).click();
        Thread.sleep(1500);
        // scroll ke atas setelah klik dan sleep
        js.executeScript("window.scrollTo(0, 0);");
    }
    public void pressUserAmendmentFileSubMenu() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", $(uploadAmendmentSubMenu));
        $(uploadAmendmentSubMenu).isDisplayed();
        $(uploadAmendmentSubMenu).click();
        Thread.sleep(1000);
    }
    public void selectMonth(String effectiveDate) throws InterruptedException {
        $(selectMonth).isDisplayed();
        WebDriver driver = getDriver(); // Dapatkan driver dari Serenity context
        WebElement input = driver.findElement(By.id("startDate"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = """
        let input = arguments[0];
        let nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, "value").set;
        nativeInputValueSetter.call(input, arguments[1]);

        input.dispatchEvent(new Event('input', { bubbles: true }));
        input.dispatchEvent(new Event('change', { bubbles: true }));
    """;

        js.executeScript(script, input, effectiveDate); // isi '2025-07' lewat argumen kedua

        WebElement populateBtn = driver.findElement(By.cssSelector("button.btn.btn-primary"));
        populateBtn.click();
    }
    public void AdvertisementURL(String adsUrl) throws InterruptedException {
        $(adsUrlAddress).isDisplayed();
        $(adsUrlAddress).click();
        $(adsUrlAddress).sendKeys(adsUrl);
        Thread.sleep(1000);
    }
    public void adsTargetedCountry(String country) throws InterruptedException {
        $(inputAdsTargetedCountry).isDisplayed();
        $(inputAdsTargetedCountry).click();
        $(inputAdsTargetedCountry).sendKeys(country + Keys.ENTER);
        Thread.sleep(1000);
    }
    public void adsTargetedMultipleCountry(String country, String country2) throws InterruptedException {
        $(inputAdsTargetedCountry).isDisplayed();
        $(inputAdsTargetedCountry).click();
        $(inputAdsTargetedCountry).sendKeys(country + Keys.ENTER);
        Thread.sleep(1000);
        $(inputAdsTargetedCountry).isDisplayed();
        $(inputAdsTargetedCountry).click();
        $(inputAdsTargetedCountry).sendKeys(country2 + Keys.ENTER);
        Thread.sleep(1000);
    }
    public void selectFrequency(String frequencyValue) {
        WebElement dropdownElement = getDriver().findElement(selectFrequencyDropdown);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(frequencyValue); // or selectByVisibleText("Weekly");
    }
    public void adsPreviewImage() throws InterruptedException {
        $(adsPreviewImage).isDisplayed();
        $(adsPreviewImage).click();
        Thread.sleep(3000);
    }
    public void manageBannerSave() {
        $(saveManageBannerConfigButton).isClickable();
    }
    public void manageBannerSaveReallyClick() throws InterruptedException {
        $(saveManageBannerConfigButton).isClickable();
        $(saveManageBannerConfigButton).click();
        Thread.sleep(3000);
    }
    public void bannerDate(String startDate, String endDate) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement start = $(startDateBanner);
        WebElement end = $(endDateBanner);
        js.executeScript("arguments[0].value = arguments[1]", start, startDate);
        Thread.sleep(500);
        start.sendKeys(Keys.ENTER);
        js.executeScript("arguments[0].value = arguments[1]", end, endDate);
        Thread.sleep(500);
        end.sendKeys(Keys.ENTER);
    }
    public void actionLogReportDate(String startDate, String endDate) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement start = $(startDateActionLog);
        WebElement end = $(endDateActionLog);
        js.executeScript("arguments[0].value = arguments[1]", start, startDate);
        Thread.sleep(500);
        start.sendKeys(Keys.ENTER);
        js.executeScript("arguments[0].value = arguments[1]", end, endDate);
        Thread.sleep(500);
        end.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        evaluateJavascript("arguments[0].click();", $(actionLogSearchBtn));
        Thread.sleep(3500);
    }
    public void inputOCR(String ocr) throws InterruptedException {
        $(ocrElement).isDisplayed();
        $(ocrElement).click();
        $(ocrElement).sendKeys(ocr + Constants.FOUR_DIGIT);
        Thread.sleep(1000);
    }
    public void inputPima(String pima) throws InterruptedException {
        $(inputPima).isDisplayed();
        $(inputPima).click();
        $(inputPima).sendKeys(pima);
        Thread.sleep(1000);
    }
    public void editTotalNumberOfAccount(String totalNumberAccount) throws InterruptedException {
        $(totalNumberAccountField).isDisplayed();
        $(totalNumberAccountField).click();
        $(totalNumberAccountField).clear();
        $(totalNumberAccountField).sendKeys(totalNumberAccount);
        Thread.sleep(1000);
    }
    public void uploadOnboardFileSubMenu() throws InterruptedException {
        String filePath = "C:/Users/rofik/IdeaProjects/CCNRepoTest/cubeforall.test/ccn-web-automation-master/src/test/java/starter/utlis/onboard-ppd-20112024_1.xlsx";
        $(uploadExcelOnboardFile).sendKeys(filePath);
        Thread.sleep(1000);
        $(populateOnboardFile).click();
        Thread.sleep(2000);
        $(submitToOnboard).click();
        Thread.sleep(1000);
    }
    public void uploadOnboardFileOnly() throws InterruptedException {
        String filePath = "src/test/java/starter/utlis/testing4.xlsx";
        File file = new File(filePath);
        String absolutePath = file.getAbsolutePath();

        $(uploadExcelOnboardFile).sendKeys(absolutePath);
        Thread.sleep(1000);
    }
    public void uploadBannerAdvertisement() throws InterruptedException {
        String filePath = "src/test/java/starter/utlis/bannerAdvertisement/201-[Converted].jpg";
        File file = new File(filePath);
        String absolutePath = file.getAbsolutePath();

        $(uploadBannerAdvertisement).sendKeys(absolutePath);
        Thread.sleep(1000);
    }
    public void pressGroupMenu() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("btnSubmit company is displaying: "+$(groupMenu).isDisplayed()+" also enabled: "+$(groupMenu).isEnabled());
        evaluateJavascript("arguments[0].click();", $(groupMenu));
//        Thread.sleep(3000);
    }
    public void pressAirlinesSubMenu() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("btnSubmit company is displaying: "+$(airlines).isDisplayed()+" also enabled: "+$(airlines).isEnabled());
        evaluateJavascript("arguments[0].click();", $(airlines));
        Thread.sleep(1000);
    }
    public void pressCreateNewAirlines() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("btnSubmit company is displaying: "+$(createNewAirline).isDisplayed()+" also enabled: "+$(createNewAirline).isEnabled());
        evaluateJavascript("arguments[0].click();", $(createNewAirline));
        Thread.sleep(1000);
    }
    public void pressSubmitToCreateNewAirlines() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("btnSubmit company is displaying: "+$(airlineSubmitButton).isDisplayed()+" also enabled: "+$(airlineSubmitButton).isEnabled());
        evaluateJavascript("arguments[0].click();", $(airlineSubmitButton));
        Thread.sleep(1000);
    }
    public void pressEditAirlines() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("btnSubmit company is displaying: "+$(editAirline).isDisplayed()+" also enabled: "+$(editAirline).isEnabled());
        evaluateJavascript("arguments[0].click();", $(editAirline));
        Thread.sleep(1000);
    }
    public void viewAirlineChangeLog(String startDate, String endDate) throws InterruptedException{
        Thread.sleep(500);
        System.out.println("btnSubmit company is displaying: "+$(airlineChangeLogFunction).isDisplayed()+" also enabled: "+$(airlineChangeLogFunction).isEnabled());
        evaluateJavascript("arguments[0].click();", $(airlineChangeLogFunction));
        Thread.sleep(500);
        $(airlineChangeLogStartDate).clear();
        $(airlineChangeLogStartDate).sendKeys(startDate);
        $(airlineChangeLogStartDate).sendKeys(Keys.ENTER);
        Thread.sleep(2500);
        $(airlineChangeLogEndDate).clear();
        $(airlineChangeLogEndDate).sendKeys(endDate);
        $(airlineChangeLogEndDate).sendKeys(Keys.ENTER);
        Thread.sleep(500);
        System.out.println("btnSubmit company is displaying: "+$(getAirlineChangeLogSubmitButton).isDisplayed()+" also enabled: "+$(getAirlineChangeLogSubmitButton).isEnabled());
        evaluateJavascript("arguments[0].click();", $(getAirlineChangeLogSubmitButton));
        Thread.sleep(2500);
    }

    public void selectSearchAirlineCompanyIdentityType() throws InterruptedException {
        Thread.sleep(500);
//        System.out.println("btnSubmit company is displaying: "+$(airlineSearchBy).isDisplayed()+" also enabled: "+$(airlineSearchBy).isEnabled());
//        evaluateJavascript("arguments[0].click();", $(airlineSearchBy));
//        Thread.sleep(2000);
//        System.out.println("btnSubmit company is displaying: "+$(optionCarrierCode).isDisplayed()+" also enabled: "+$(optionCarrierCode).isEnabled());
//        evaluateJavascript("arguments[0].click();", $(optionCarrierCode));
//        Thread.sleep(500);
        List<WebElement> lsthreedoteoptionmembermostleftsides = getDriver().findElements(airlineSearchBy);
        System.out.println("search by display: "+lsthreedoteoptionmembermostleftsides.get(0).isDisplayed());
        System.out.println("search by enabled: "+lsthreedoteoptionmembermostleftsides.get(0).isEnabled());
        lsthreedoteoptionmembermostleftsides.get(0).click();
        Thread.sleep(500);
        List<WebElement> carrierCode = getDriver().findElements(optionCarrierCode);
        System.out.println("option carrier code display: "+lsthreedoteoptionmembermostleftsides.get(0).isDisplayed());
        System.out.println("option carrier code enabled: "+lsthreedoteoptionmembermostleftsides.get(0).isEnabled());
        carrierCode.get(0).click();
        Thread.sleep(500);
    }

    public void pressNotificationMonitoringMenu() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("btnSubmit company is displaying: "+$(notificationMonitoringMenu).isDisplayed()+" also enabled: "+$(notificationMonitoringMenu).isEnabled());
        evaluateJavascript("arguments[0].click();", $(notificationMonitoringMenu));
        Thread.sleep(3000);
    }

    public void pressUpdatePlanManager() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("btnSubmit company is displaying: "+$(updatePlanManager).isDisplayed()+" also enabled: "+$(updatePlanManager).isEnabled());
        evaluateJavascript("arguments[0].click();", $(updatePlanManager));
        Thread.sleep(3000);
    }

    public void actionLog() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("btnSubmit company is displaying: "+$(actionLog).isDisplayed()+" also enabled: "+$(actionLog).isEnabled());
        evaluateJavascript("arguments[0].click();", $(actionLog));
    }
    public void functionActionLog() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("btn is displaying: "+$(selectActionLogFunction).isDisplayed()+" also enabled: "+$(actionLog).isEnabled());
        evaluateJavascript("arguments[0].click();", $(selectActionLogFunction));
    }
    public void functionActionLogOptionUploadFileOnboard() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("btn is displaying: "+$(uploadFileOnboardLogOption).isDisplayed()+" also enabled: "+$(uploadFileOnboardLogOption).isEnabled());
        evaluateJavascript("arguments[0].click();", $(uploadFileOnboardLogOption));
    }
    public void functionActionLogOptionAmend() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("btn is displaying: "+$(amendmentLogOption).isDisplayed()+" also enabled: "+$(amendmentLogOption).isEnabled());
        evaluateJavascript("arguments[0].click();", $(amendmentLogOption));
    }
    public void functionActionLogOptionTerminate() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("btn is displaying: "+$(terminationLogOption).isDisplayed()+" also enabled: "+$(terminationLogOption).isEnabled());
        evaluateJavascript("arguments[0].click();", $(terminationLogOption));
    }
    public void displayVerify() throws InterruptedException {
        Thread.sleep(3000);
    }
    public void accessControl() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("btnSubmit company is displaying: "+$(accessControl).isDisplayed()+" also enabled: "+$(accessControl).isEnabled());
        evaluateJavascript("arguments[0].click();", $(accessControl));
    }
    public void newAdminChangeLog() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("btnSubmit company is displaying: "+$(adminChangeLog).isDisplayed()+" also enabled: "+$(adminChangeLog).isEnabled());
    }
    public void goTonewAdminChangeLog() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("btnSubmit company is displaying: "+$(adminChangeLog).isDisplayed()+" also enabled: "+$(adminChangeLog).isEnabled());
        evaluateJavascript("arguments[0].click();", $(adminChangeLog));
    }
    public void searchAdminChangeLogButton() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("btnSubmit company is displaying: "+$(searchAdminChangeLogButton).isDisplayed()+" also enabled: "+$(searchAdminChangeLogButton).isEnabled());
        evaluateJavascript("arguments[0].click();", $(searchAdminChangeLogButton));
    }
    public void selectOneOfUserOfAdminChangeLogButton() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("btnSubmit company is displaying: "+$(selectUserAdminChangeLog).isDisplayed()+" also enabled: "+$(selectUserAdminChangeLog).isEnabled());
        evaluateJavascript("arguments[0].click();", $(selectUserAdminChangeLog));
        Thread.sleep(500);
        System.out.println("btnSubmit company is displaying: "+$(selectOneOfUserAdminChangeLog).isDisplayed()+" also enabled: "+$(selectOneOfUserAdminChangeLog).isEnabled());
        evaluateJavascript("arguments[0].click();", $(selectOneOfUserAdminChangeLog));
    }
    public void select_option_user_management() throws InterruptedException{
        Thread.sleep(1000);
        System.out.println("btnSubmit company is displaying: "+$(option_userManagement).isDisplayed()+" also enabled: "+$(option_userManagement).isEnabled());
        evaluateJavascript("arguments[0].click();", $(option_userManagement));
    }
    public void select_option_access_group() throws InterruptedException{
        Thread.sleep(1000);
        System.out.println("btnSubmit company is displaying: "+$(option_access_group).isDisplayed()+" also enabled: "+$(option_access_group).isEnabled());
        evaluateJavascript("arguments[0].click();", $(option_access_group));
    }
    public void inputStartDateACL(String startDate){
        $(startDateAdminChangeLog).sendKeys(startDate);
    }
    public void inputEndDateACL(String endDate) throws InterruptedException {
        Thread.sleep(2000);
        $(endDateAdminChangeLog).sendKeys(endDate);
    }
    public void selectAdminChangeLogFunction() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("btnSubmit company is displaying: "+$(selectAdminChangeLogFunction).isDisplayed()+" also enabled: "+$(selectAdminChangeLogFunction).isEnabled());
        evaluateJavascript("arguments[0].click();", $(selectAdminChangeLogFunction));
    }
    public void selectOptionFunctionInAdminChangeLog() throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("btnSubmit company is displaying: "+$(select_option_dropdown_toggle_btn_btn_outline_secondary).isDisplayed()+" also enabled: "+$(select_option_dropdown_toggle_btn_btn_outline_secondary).isEnabled());
        evaluateJavascript("arguments[0].click();", $(select_option_dropdown_toggle_btn_btn_outline_secondary));
        Thread.sleep(2500);
    }
    public void adminChangeLogTableHover() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("admin change log table is displaying: "+$(adminChangeLogTableHover).isDisplayed());
    }
    public void afterPopulateTableHover() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("admin change log table is displaying: "+$(tableHoverDisplayAfterPopulate).isDisplayed());
    }
    public void successUploadOnboardMSG() throws InterruptedException {
        Thread.sleep(500);
        String successOnboardText = $(successUploadOnboardMessage).getText();
        System.out.println(successOnboardText);
    }
    public void successUploadAmendmentMSG() throws InterruptedException {
        Thread.sleep(500);
        String successOnboardText = $(successSubmitAmendmentMsg).getText();
        System.out.println(successOnboardText);
    }
    public void successUploadTerminateOnboardMSG() throws InterruptedException {
        Thread.sleep(500);
        String successTerminateOnboardText = $(successUploadTerminateOnboard).getText();
        System.out.println(successTerminateOnboardText);
    }
    public void The_data_range_filter_is_compulsory_sign() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("The data range filter is compulsory sign is displaying: "+$(the_date_range_filter_compulsory_in_action_log_menu).isDisplayed());
    }
    public void no_value_is_selected_whether_User_or_Function() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("btnSubmit action log is displaying: "+$(submitActionLog).isDisplayed()+" also enabled: "+$(submitActionLog).isEnabled());
        evaluateJavascript("arguments[0].click();", $(submitActionLog));
    }
    public void completeness_of_the_perimeter_search() throws  InterruptedException{
        Thread.sleep(1000);
        System.out.println("btnSubmit company is displaying: "+$(selectUserTitleAdminChangeLog).isDisplayed());
        System.out.println("btnSubmit company is displaying: "+$(selectFunctionTitleAdminChangeLog).isDisplayed());
        System.out.println("btnSubmit company is displaying: "+$(selectDateRangeTitleAdminChangeLog).isDisplayed());
    }
    public void verifyTitleChangeToPortalAccessManagement() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("btnSubmit company is displaying: "+$(accessControl).isDisplayed()+" also enabled: "+$(accessControl).isEnabled());
    }
    public void verifyTitleChangeToAccessGroup() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("btnSubmit company is displaying: "+$(accessGroup).isDisplayed()+" also enabled: "+$(accessGroup).isEnabled());
    }
    public void verifyTitleChangeToUserManagement() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("btnSubmit company is displaying: "+$(userManagement).isDisplayed()+" also enabled: "+$(userManagement).isEnabled());
    }
    public void subscription() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", $(subscription));
        System.out.println("btnSubmit company is displaying: "+$(subscription).isDisplayed()+" also enabled: "+$(subscription).isEnabled());
        evaluateJavascript("arguments[0].click();", $(subscription));
    }
    public void manageBanner() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("btnSubmit company is displaying: "+$(manageBanner).isDisplayed()+" also enabled: "+$(manageBanner).isEnabled());
        evaluateJavascript("arguments[0].click();", $(manageBanner));
    }
    public void viewImageInTheJobList() throws InterruptedException {
        System.out.println("btn is displaying: "+$(viewImageInJobList).isDisplayed()+" also enabled: "+$(viewImageInJobList).isEnabled());
        evaluateJavascript("arguments[0].click();", $(viewImageInJobList));
        Thread.sleep(3000);
    }
    public void editTheAdsJobList() throws InterruptedException {
        System.out.println("btn is displaying: "+$(editAdsJoblistBtn).isDisplayed()+" also enabled: "+$(editAdsJoblistBtn).isEnabled());
        evaluateJavascript("arguments[0].click();", $(editAdsJoblistBtn));
        Thread.sleep(3000);
    }
    public void deleteTheAdsJobList() throws InterruptedException {
        System.out.println("btn is displaying: "+$(deleteAdsList).isDisplayed()+" also enabled: "+$(deleteAdsList).isEnabled());
        evaluateJavascript("arguments[0].click();", $(deleteAdsList));
        Thread.sleep(3000);
    }
    public void clickActionLogDropDown() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("btnSubmit company is displaying: "+$(actionLogDropDown).isDisplayed()+" also enabled: "+$(actionLogDropDown).isEnabled());
        evaluateJavascript("arguments[0].click();", $(actionLogDropDown));
    }
    public void selectUserToExportActionLog() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("btnSubmit company is displaying: "+$(selectUserToExportActionLog).isDisplayed()+" also enabled: "+$(selectUserToExportActionLog).isEnabled());
        evaluateJavascript("arguments[0].click();", $(selectUserToExportActionLog));
    }

    public void selectStartEndDateActionLog(String startDate, String endDate) throws InterruptedException {
        Thread.sleep(1000);
        $(startDateActionLog).sendKeys(startDate);
        Thread.sleep(1000);
        $(endDateActionLog).sendKeys(endDate);
        Thread.sleep(1000);
        System.out.println("btnSubmit action log is displaying: "+$(submitActionLog).isDisplayed()+" also enabled: "+$(submitActionLog).isEnabled());
        evaluateJavascript("arguments[0].click();", $(submitActionLog));
        Thread.sleep(7000);
    }

    public void verifyAirlineSearchValidationTextDisplayInformation() {
        String ValidationText = $(airlineSearchValidationText).getText();
        System.out.println(ValidationText);
    }
    public void verifyNotificationMonitoringMenuInfo() {
        String currentTotalCountValue = $(currentTotalCount).getText();
        String previousTotalCountValue = $(previousTotalCount).getText();
        String currentTotalFailedProcessValue = $(currentTotalFailedProcess).getText();
        String previousTotalFailedProcessValue = $(previousTotalFailedProcess).getText();
        String currentCountAtValue = $(currentCountAt).getText();
        String previousCountAtValue = $(previousCountAt).getText();
        System.out.println("the Current Total Notification Monitoring Count is: " + currentTotalCountValue);
        System.out.println("the Previous Total Notification Monitoring Count is: " + previousTotalCountValue);
        System.out.println("the Current Total Failed Notification Monitoring Count is: " + currentTotalFailedProcessValue);
        System.out.println("the Previous Total Failed Notification Monitoring Count is: " + previousTotalFailedProcessValue);
        System.out.println(currentCountAtValue);
        System.out.println(previousCountAtValue);
    }
    public boolean fiveAttributeIsDisplayed() {
        return $(airlinesNameTitle).isDisplayed() && $(emailTitle).isDisplayed() && $(stationTitle).isDisplayed() && $(countryTitle).isDisplayed() && $(carrierCodeTitle).isDisplayed() && $(awbPrefixTitle).isDisplayed();
    }

    public boolean CompanyName(){
        return $(companyName).isDisplayed();
    }
    public boolean currentPlanManager(){
        return $(currentPlanManager).isDisplayed();
    }
    public boolean CompanyCubeID(){
        return $(CompanyCubeID).isDisplayed();
    }
    public boolean CompanySystemCube(){
        return $(CompanyCubeID).isDisplayed();
    }
    public boolean CompanyPIMA(){
        return $(CompanyPIMA).isDisplayed();
    }
    public boolean GHA(){
        return $(GHA).isDisplayed();
    }
    public boolean GHACode(){
        return $(GHACode).isDisplayed();
    }
    public boolean UEN(){
        return $(UEN).isDisplayed();
    }
    public boolean CompanyCountry(){
        return $(CompanyCountry).isDisplayed();
    }
    public boolean CompanyMembers(){
        return $(CompanyMembers).isDisplayed();
    }
    public void createDiscountSubMenu(){
        System.out.println("btnSubmit company is displaying: "+$(createDiscountSubMenu).isDisplayed()+" also enabled: "+$(createDiscountSubMenu).isEnabled());
        evaluateJavascript("arguments[0].click();", $(createDiscountSubMenu));
    }
    public void companyInfoSubMenu() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("company info submenu is displaying: "+$(companyInfoSubMenu).isDisplayed()+" also enabled: "+$(companyInfoSubMenu).isEnabled());
        evaluateJavascript("arguments[0].click();", $(companyInfoSubMenu));
    }

    public void createDiscount(String couponNameFill, String amount,
                               String promoCodeFill, String companyPromoFill, String customer, String priceID,
                               String country, String city){
        $(couponName).isDisplayed();
        $(couponName).sendKeys(couponNameFill+Constants.FOUR_DIGIT);
        System.out.println(couponNameFill+Constants.FOUR_DIGIT);
        $(amountOfCoupon).isDisplayed();
        $(amountOfCoupon).sendKeys(amount+Constants.FOUR_DIGIT);
        System.out.println(amount+Constants.FOUR_DIGIT);
        $(currencyCoupon).isDisplayed();
        $(currencyCoupon).click();
        $(USDdropdownCoupon).isDisplayed();
        $(USDdropdownCoupon).click();
        $(amountOfPCN).isDisplayed();
        $(amountOfPCN).sendKeys(amount);
        $(currencyPCN).isDisplayed();
        $(currencyPCN).click();
        $(USDdropdownPCN).isDisplayed();
        $(USDdropdownPCN).click();
        $(promoCode).isDisplayed();
        $(promoCode).sendKeys(promoCodeFill+Constants.FOUR_DIGIT);
        System.out.println(promoCodeFill+Constants.FOUR_DIGIT);
        $(companyPromo).isDisplayed();
        $(companyPromo).sendKeys(companyPromoFill);
        $(companyPromo).sendKeys(Keys.ENTER);
        $(productTypePromo).isDisplayed();
        $(productTypePromo).click();
        $(CompanydropdownProductTypePromo).isDisplayed();
        $(CompanydropdownProductTypePromo).click();
        $(customerPromo).isDisplayed();
        $(customerPromo).sendKeys(customer+Constants.FOUR_DIGIT+"@yopmail.com");
        System.out.println(customer+Constants.FOUR_DIGIT+"@yopmail.com");
        $(priceIDfield).isDisplayed();
        $(priceIDfield).sendKeys(priceID);
        $(priceIDfield).sendKeys(Keys.ENTER);
        $(countryPromo).isDisplayed();
        $(countryPromo).click();
        $(ADCountry).isDisplayed();
        $(ADCountry).click();
//        Select selectCountry = new Select($(dropdownCountry));
//        selectCountry.selectByVisibleText(country);
        $(cityPromo).isDisplayed();
        $(cityPromo).click();
        $(AAECity).isDisplayed();
        $(AAECity).click();
//        Select selectCity = new Select($(dropdownCity));
//        selectCity.selectByVisibleText(city);
        $(checkBoxFirstTime).isDisplayed();
        $(checkBoxFirstTime).click();
        $(minimumAmountRestriction).isDisplayed();
        $(minimumAmountRestriction).sendKeys(amount);
        $(minimumAmountCurrencyRestriction).isDisplayed();
        $(minimumAmountCurrencyRestriction).click();
        $(USDdropdownCurrencyRestriction).isDisplayed();
        $(USDdropdownCurrencyRestriction).click();
        $(expiredAt).isDisplayed();
        $(expiredAt).click();
        $(expiredAtPick).isDisplayed();
        $(expiredAtPick).click();
        $(validityStartDate).isDisplayed();
        $(validityStartDate).click();
        $(startDatePick).isDisplayed();
        $(startDatePick).click();
        $(validityStartDate).isDisplayed();
        $(validityStartDate).click();
        $(validityEndDate).isDisplayed();
        $(validityEndDate).click();
        $(validityEndDatePick).isDisplayed();
        $(validityEndDatePick).click();
        $(submitDiscount).isDisplayed();
        $(submitDiscount).click();
        $(createDiscountSuccessMessage).isDisplayed();
        WebElement element = $(By.xpath("//p[@class='cube-tracking cube-message']"));
        String text = element.getText();
        System.out.println(text);
    }

}
