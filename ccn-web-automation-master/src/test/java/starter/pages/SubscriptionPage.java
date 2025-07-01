package starter.pages;

import net.serenitybdd.screenplay.targets.SearchableTarget;
import net.serenitybdd.screenplay.ui.Link;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionPage extends PageObject {

    private int waitResponse = 3000;
    private int longwaitResponse = 15000;
    private String newWindow="";

//    private SearchableTarget productTab = Link.containing("freight-forwarder");
//    private By productTab = By.xpath("//*[contains(@href, 'freight-forwarder')]");
    private By productTab = By.id("menu-item-629");
    private By productTabFromManageSubscribtion = By.xpath("//a[contains(@href, 'sandbox.cubeforall.com/freight-forwarder/freight-operations-management/')]");
    private By bundlecompanylevelaWBConciergeLFS = By.xpath("//*[@id=\"nav\"]/ul/li[11]/a");
    private By clickchckEnableStripePass = By.id("enableStripePass");
    private By inputCheckboxSubscribe = By.cssSelector("div > div > div.cube-subscribe-tnc-container > div.cube-subscribe-checkbox-container > #cube-subscribe-btn-checkbox-655da5ac0b5c91406fe80257");
    private By inputUser = By.xpath("//*[@id=\"freight\"]/div/div[2]/article/div[3]/div/div/cp-subscribe-button//div/div/div[3]/div/div/input");
    private By inputCardNumberformpayment = By.id("cardNumber");
    private By inputserachphonenumberformpayment = By.id("search-phoneNumber");
    private By SubmitButtoncompleteformpaymentStripe = By.xpath("//div[@class='SubmitButton-IconContainer']");
    private By inputphoneNumberformpayment = By.id("phoneNumber");
    private By inputcardExpiryformpayment = By.id("cardExpiry");
    private By inputVcaCardNumberformpayment = By.id("cardCvc");
    private By inputFullNameCardNumberformpayment = By.id("billingName");
    private By btnSubmitSubscribea = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/form/div[2]/div/div[2]/button/div[3]");
    private By accounticon = By.xpath("//*[@id=\"toppage\"]/header/div[2]/div[2]/div[2]/div[2]/wc-login/div/div/div");
    private By iconMenuMysubscription = By.xpath("//*[@id=\"toppage\"]/header/div[2]/div[2]/div[2]/div[2]/wc-login/div/div/div[2]/div[2]/div[3]/a");
    private By lsPlanProduct = By.xpath("//*[@id=\"nav\"]/ul/li");
    private By lfsProduct = By.xpath("//a[text()='Lead Freight Solutions']");
    private By contactUs = By.xpath("//a[@class='btn-1' and @data-bs-toggle='modal' and @href='#interest' and text()='Contact Us']");
    private By btnSuccesSubscribeLFSTrial = By.xpath("//*[@id=\"cube-subscribe-modal-btn-6566e1f8669e862c02256095\"]");
    private By inputCheckboxSubscribeMulti = By.xpath("//input[@id='cube-subscribe-btn-checkbox-6389c85e089c75ff462d9911']");
    private By backfrompayment = By.xpath("//a[@href='https://sandbox.cubeforall.com/portal/manage-subscription']");

    private By checkComplimentarySubscribee = ByShadow.cssSelector("input#cube-subscribe-btn-checkbox-657c08880cc0f27d570a3ac8");
    private By inputComplimentarySubscribee = ByShadow.cssSelector("input#cube-subscribe-btn-input-657c08880cc0f27d570a3ac8");
    private By btnComplimentarySubscribee = ByShadow.cssSelector("button#cube-subscribe-btn-657c08880cc0f27d570a3ac8");
    private By lsStatusSubs = By.xpath("//*[@id=\"cube-plan-list\"]/tbody/tr/td[7]");
    private By lsUserCountSubs = By.xpath("//*[@id=\"cube-plan-list\"]/tbody/tr/td[5]/p");
    private By lsDescNameSubs = By.xpath("//*[@id=\"cube-plan-list\"]/tbody/tr/td[4]/div/div");
    private By lsProductNameSubs = By.xpath("//*[@id=\"cube-plan-list\"]/tbody/tr/td[2]/p");
    private By lsPlanNameSubs = By.xpath("//*[@id=\"cube-plan-list\"]/tbody/tr/td[3]");
    private By startSubsDate = By.xpath("//*[@id=\"cube-plan-list\"]/tbody/tr[2]/td[6]/div/div/div/text()[1]");
    private By endSubsDate = By.xpath("//*[@id=\"cube-plan-list\"]/tbody/tr[2]/td[6]/div/div/div/text()[3]");
    private By removeProductSubs = By.xpath("//*[local-name()='svg' and @fill='#70757A']");
    private By lsComplieneDoc = By.xpath("//*[@id=\"nav\"]/ul/li/a");

    public void clickProductTab(){
        $(productTab).waitUntilVisible();
        $(productTab).click();
    }
    public void clickCheckComplimentarySubscribee(){
        $(checkComplimentarySubscribee).isDisplayed();
        $(checkComplimentarySubscribee).click();
    }

    public void clickBtnComplimentarySubscribee(){
        $(btnComplimentarySubscribee).isDisplayed();
        $(btnComplimentarySubscribee).click();
    }

    public void printCurrentUrl(){
        System.out.println(getDriver().getCurrentUrl());
    }

    public void inputComplimentarySubscribee(String inputSubs){
        $(inputComplimentarySubscribee).isDisplayed();
        $(inputComplimentarySubscribee).sendKeys(inputSubs);
    }
    private SearchContext shadowDomcpsubscribe() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        Thread.sleep(waitResponse);
        WebElement root = $(By.tagName("cp-subscribe-button"));
        SearchContext shadowDomcpsubscribe = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
        return shadowDomcpsubscribe;
    }
    private SearchContext shadowDomcpsubscribesecond() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        Thread.sleep(waitResponse);
        WebElement root = $(By.xpath("(//cp-subscribe-button[@cp_service_id='2ccbe74c-493b-47a4-8dee-80bdb147e895'])[2]"));
        SearchContext shadowDomcpsubscribe = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
        return shadowDomcpsubscribe;
    }

//	private SearchContext backfromsubscribelfsmulti() throws Exception {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		Thread.sleep(waitResponse);
//		WebElement root = driver.findElement(By.tagName("cp-subscribe-button"));
////		SearchContext shadowDomcpsubscribe = (SearchContext) js.executeScript("return arguments[1].shadowRoot", root);
//		SearchContext shadowDomcpsubscribe = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
//		return shadowDomcpsubscribe;
//	}

    private void subscribelfstrianonedayplan() throws Exception {
        clickchckBoxComplimentarySubscribelfsfreetrial();
        clickBtnComplimentarySubsribelfsfreetrial();
        clickBtnConfirmComplimentarySubsribelfsfreetrial();
    }


    // LFS FREE TRIAL
    public void clickchckBoxComplimentarySubscribelfsfreetrial() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-6566e1f8669e862c02256095"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickBtnComplimentarySubsribelfsfreetrial() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("button#cube-subscribe-btn-6566e1f8669e862c02256095"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
    }

    public void clickBtnConfirmComplimentarySubsribelfsfreetrial() throws Exception {
        Thread.sleep(waitResponse);
        WebElement element = shadowDomcpsubscribe()
                .findElement(By.cssSelector("div#cube-subscribe-modal-btn-6566e1f8669e862c02256095"));
        System.out.println("element is display: " + element.isDisplayed());
        element.isDisplayed();
        element.click();
    }

    // Bundle (LFS BC) Company Level

    private void subscribebundlelfsbc() throws Exception {
        clickchckBoxComplimentarySubscribebccompany();
        clickBtnComplimentarySubsribebccompany();
        inputComplimentarySubsribebccompany();
    }

    public void clickchckBoxComplimentarySubscribebccompany() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-657c09640cc0f27d570a3db8"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickBtnComplimentarySubsribebccompany() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("button#cube-subscribe-btn-657c09640cc0f27d570a3db8"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
    }

    public void inputComplimentarySubsribebccompany() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-input-657c09640cc0f27d570a3db8"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.sendKeys("3");
    }

    // bc non company level
    private void subscribebundleawbbcplan() throws Exception {
        clickchckBoxComplimentarySubscribebcnoncompany();
        clickBtnComplimentarySubsribebcnoncompany();
        inputComplimentarySubsribebcnoncompany();
    }

    public void clickchckBoxComplimentarySubscribebcnoncompany() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-657c08880cc0f27d570a3ac8"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickBtnComplimentarySubsribebcnoncompany() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("button#cube-subscribe-btn-657c08880cc0f27d570a3ac8"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
    }

    public void inputComplimentarySubsribebcnoncompany() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-input-657c08880cc0f27d570a3ac8"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.sendKeys("3");
    }

    public void clickBtnConfirmComplimentarySubsribebcnoncompany() throws Exception {
        Thread.sleep(waitResponse);
        WebElement element = shadowDomcpsubscribe()
                .findElement(By.cssSelector("div#cube-subscribe-modal-btn-657c08880cc0f27d570a3ac8"));
        System.out.println("element is display: " + element.isDisplayed());
        element.isDisplayed();
        element.click();
    }

    // moaah starter plan
//	moaahstarterplan
    private void subscribemoaahstarterplan() throws Exception {
        clickchckBoxmoaahstarterplan();
        clickBtnSubscribemoaahstarterplan();
        inputCompleteFillSubscriberPayment();
    }

    public void clickchckBoxmoaahstarterplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-652d04d9512779db0acdce08"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickBtnSubscribemoaahstarterplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("button#cube-subscribe-btn-652d04d9512779db0acdce08"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
    }


    //offline payment
    public void clickBtnConfirmmoaahstarterplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement element = shadowDomcpsubscribe()
                .findElement(By.cssSelector("div#cube-subscribe-modal-btn-657c08880cc0f27d570a3ac8"));
        System.out.println("element is display: " + element.isDisplayed());
        element.isDisplayed();
        element.click();
    }
    // moaah premium plan
//		moaahspremiumplan
    private void subscribemoaahspremiumplan() throws Exception {
        clickchckBoxmoaahspremiumplan();
        clickBtnSubscribemoaahspremiumplan();
        inputCompleteFillSubscriberPayment();
    }

    public void clickchckBoxmoaahspremiumplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-652d04d9512779db0acdce0c"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickBtnSubscribemoaahspremiumplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("button#cube-subscribe-btn-652d04d9512779db0acdce0c"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
    }


    //offline payment
    public void clickBtnConfirmmoaahspremiumplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement element = shadowDomcpsubscribe()
                .findElement(By.cssSelector("div#cube-subscribe-modal-btn-657c08880cc0f27d570a3ac8"));
        System.out.println("element is display: " + element.isDisplayed());
        element.isDisplayed();
        element.click();
    }

    //		quotationproposalplan
    private void subscribequotationproposalplanplan() throws Exception {
        clickchckBoxquotationproposalplan();
        clickBtnSubscribequotationproposalplan();
        clickBtnConfirmquotationproposalplan();// offline payment

    }

    public void clickchckBoxquotationproposalplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-6389b9e2089c75ff462d9843"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickchckBoxbundleAWBBCplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-657c08880cc0f27d570a3ac8"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickchckBoxTDSBplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-65a8bbea6da7bbb4522fdd20"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickchckBoxawbconciergepremiummulticurrencysandbox() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-65e00d89ba77a5a13700178c"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickchckBoxtestiatatactratepremiummulticurrencysandbox() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-65e6bb07f74faed02021600c"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickchckBoxsubscribetestbcpremiummulticurrencysandbox() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-65e6bb07f74faed02021600c"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickchckBoxsubscribeawbconciergepremiummulticurrencysandbox() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-65e00d89ba77a5a13700178c"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickcoupontextsubscribetestbcpremiummulticurrencysandbox() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("div.coupon-text"));
        System.out.println("clickComplimentaryCoupon is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickBtnSubscribequotationproposalplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("button#cube-subscribe-btn-6389b9e2089c75ff462d9843"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
    }

    public void clickBtnSubscribebundleAWBBCplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("button#cube-subscribe-btn-657c08880cc0f27d570a3ac8"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
        Thread.sleep(longwaitResponse);
        String currentUrl = getDriver().getCurrentUrl();
        System.out.println(currentUrl);
        Thread.sleep(2000);
    }

    public void clickBtnSubscribeTDSBplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("button#cube-subscribe-btn-65a8bbea6da7bbb4522fdd20"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
        Thread.sleep(2000);
    }

    public void clickBtnsubscribetestawbconciergepremiummulticurrencysandbox() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("button#cube-subscribe-btn-65e00d89ba77a5a13700178c"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
        Thread.sleep(longwaitResponse);
        String currentUrl = getDriver().getCurrentUrl();
        System.out.println(currentUrl);
        Thread.sleep(2000);
    }

    public void clickBtnsubscribetestbcpremiummulticurrencysandbox() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("button#cube-subscribe-btn-65e6bb07f74faed02021600c"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
        Thread.sleep(longwaitResponse);
        String currentUrl = getDriver().getCurrentUrl();
        System.out.println(currentUrl);
        Thread.sleep(2000);
    }

    public void clickBtnsubscribetestiatatactratepremiummulticurrencysandbox() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("button#cube-subscribe-btn-65e6bb07f74faed02021600c"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
        Thread.sleep(longwaitResponse);
        String currentUrl = getDriver().getCurrentUrl();
        System.out.println(currentUrl);
        Thread.sleep(2000);
    }


    //offline payment
    public void clickBtnConfirmquotationproposalplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement element = shadowDomcpsubscribe()
                .findElement(By.cssSelector("div#cube-subscribe-modal-btn-6389b9e2089c75ff462d9843"));
        System.out.println("element is display: " + element.isDisplayed());
        element.isDisplayed();
        element.click();
    }

//		bookingqueueplan();
    private void subscribebookingqueueplan() throws Exception {
        clickchckBoxquotationproposalplan();
        clickBtnSubscribequotationproposalplan();
        clickBtnConfirmquotationproposalplan();// offline payment
    }

    private void subscribebundleBCAWBplan() throws Exception {
        clickchckBoxbundleAWBBCplan();
        inputbundleawbbc();
        clickBtnSubscribebundleAWBBCplan();
    }

    private void subscribetestawbconciergepremiummulticurrencysandbox() throws Exception {
        clickchckBoxawbconciergepremiummulticurrencysandbox();
        clickBtnsubscribetestawbconciergepremiummulticurrencysandbox();
    }

    private void subscribetestiatatactratepremiummulticurrencysandbox() throws Exception {
        clickchckBoxtestiatatactratepremiummulticurrencysandbox();
        clickBtnsubscribetestiatatactratepremiummulticurrencysandbox();
    }

    private void subscribetestbcpremiummulticurrencysandbox() throws Exception {
        clickchckBoxsubscribetestbcpremiummulticurrencysandbox();
        clickBtnsubscribetestbcpremiummulticurrencysandbox();
    }

    private void subscribetestbcpremiummulticurrencysandboxdiscount(String coupon) throws Exception {
        clickchckBoxsubscribetestbcpremiummulticurrencysandbox();
        clickcoupontextsubscribetestbcpremiummulticurrencysandbox();
        inpupromobcpremium(coupon);
        pressConfirm();
    }

    private void subscribeawbconciergepremiummulticurrencysandboxdiscount(String coupon) throws Exception {
        clickchckBoxsubscribeawbconciergepremiummulticurrencysandbox();
        clickcoupontextsubscribetestbcpremiummulticurrencysandbox();
        inpupromobcpremium(coupon);
        pressConfirm();
    }

    public void clickchckBoxbookingqueueplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-6389b4af089c75ff462d9825"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickBtnSubscribebookingqueueplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("button#cube-subscribe-btn-6389b4af089c75ff462d9825"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
    }


    //offline payment
    public void clickBtnConfirmbookingqueueplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement element = shadowDomcpsubscribe()
                .findElement(By.cssSelector("div#cube-subscribe-modal-btn-6389b4af089c75ff462d9825"));
        System.out.println("element is display: " + element.isDisplayed());
        element.isDisplayed();
        element.click();
    }

//		subscribe quotation requestplan();
    private void subscribequotationrequestplan() throws Exception {
        clickchckBoxquotationrequestplan();
        clickBtnSubscribequotationrequestplan();
        clickBtnConfirmquotationrequestplan();// offline payment
    }

    public void clickchckBoxquotationrequestplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-65601eced5561491b24a8182"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickBtnSubscribequotationrequestplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("button#cube-subscribe-btn-65601eced5561491b24a8182"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
    }


    //offline payment
    public void clickBtnConfirmquotationrequestplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement element = shadowDomcpsubscribe()
                .findElement(By.cssSelector("div#cube-subscribe-modal-btn-65601eced5561491b24a8182"));
        System.out.println("element is display: " + element.isDisplayed());
        element.isDisplayed();
        element.click();
    }

//		Freight Management System - LFS Trial
    private void subscribelfstrialplan() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,500)", "");
        clickchckBoxlfstrialplan();
        inputlfstrialplan();
        clickBtnSubscribelfstrialplan();
        clickBtnConfirmlfstrialplan();// offline payment
    }

    public void clickchckBoxlfstrialplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-648965bf80066b3396b8c06f"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickBtnSubscribelfstrialplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("button#cube-subscribe-btn-648965bf80066b3396b8c06f"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
    }
    public void inputlfstrialplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-input-648965bf80066b3396b8c06f"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.sendKeys("3");
        ;
    }

    //offline payment
    public void clickBtnConfirmlfstrialplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement element = shadowDomcpsubscribe()
                .findElement(By.cssSelector("div#cube-subscribe-modal-btn-648965bf80066b3396b8c06f"));
        System.out.println("element is display: " + element.isDisplayed());
        element.isDisplayed();
        element.click();
    }

//		Freight Management System - LFS Multi
    private void subscribelfsmultiplan() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,900)", "");
        clickchckBoxlfsmultiplan();
        inputlfsmultiplan();
        clickBtnSubscribelfsmultiplan();
        inputCompleteFillSubscriberPayment();
    }

    private void subscribelfsmultiplanupgrade() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,900)", "");
        clickchckBoxlfsmultiplan();
        inputlfsmultiplan();
        clickBtnSubscribelfsmultiplan();
        Thread.sleep(3000);
    }

    private void subscribeFreightX(String UserCount) throws Exception {
        clickOptionalMyInvoisPEPPOL();
//        inputlfsmultiplan();
//        clickBtnSubscribelfsmultiplan();
//        Thread.sleep(3000);
    }

    private void subscribelfsmultiplandowngrade() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,900)", "");
        clickchckBoxlfsmultiplan();
        inputlfsmultiplandowngrade();
        clickBtnSubscribelfsmultiplan();
        Thread.sleep(3000);
//			clickBtnBackSubscribelfsmultiplan();
    }



    public void clickchckBoxlfsmultiplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribesecond()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-6389c85e089c75ff462d9911"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickOptionalMyInvoisPEPPOL() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribe = shadowDomcpsubscribesecond()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox3-685ea5ccdd0b1d1db492690e"));
        System.out.println("display: " + chckBoxComplimentarySubscribe.isDisplayed());
        chckBoxComplimentarySubscribe.isDisplayed();
        chckBoxComplimentarySubscribe.click();
    }

    public void clickBtnSubscribelfsmultiplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribesecond()
                .findElement(By.cssSelector("button#cube-subscribe-btn-6389c85e089c75ff462d9911"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
        Thread.sleep(longwaitResponse);
        String currentUrl = getDriver().getCurrentUrl();
        System.out.println(currentUrl);
        Thread.sleep(2000);
    }

//		public void clickBtnBackSubscribelfsmultiplan() throws Exception {
//			Thread.sleep(waitResponse);
//			WebElement btnComplimentarySubscribee = backfromsubscribelfsmulti()
//					.findElement(By.cssSelector("h1.Header-businessLink-name.Text.Text-color--gray800.Text-fontSize--14.Text-fontWeight--500.Text--truncate"));
//			System.out.println("clickBtnBackSubscribelfsmultiplan is display: " + btnComplimentarySubscribee.isDisplayed());
//			btnComplimentarySubscribee.isDisplayed();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitResponse));
//			btnComplimentarySubscribee.click();
//		}

    public void inputlfsmultiplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribesecond()
                .findElement(By.cssSelector("input#cube-subscribe-btn-input-6389c85e089c75ff462d9911"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.sendKeys("25");
        ;
    }

    public void inpupromobcpremium(String coupon) throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input.input-promo"));
        System.out.println("inputComplimentaryinputPromo is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.sendKeys(coupon);
    }

    public void pressConfirm() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("div#cube-subscribe-promo-btn-65e00cb4ba77a5a1370015b8"));
        System.out.println("clickComplimentaryBtnConfirm is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
        Thread.sleep(waitResponse);
    }

    public void inputlfsmultiplandowngrade() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribesecond()
                .findElement(By.cssSelector("input#cube-subscribe-btn-input-6389c85e089c75ff462d9911"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.sendKeys("13");
        ;
    }

    public void inputbundleawbbc() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-input-657c08880cc0f27d570a3ac8"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.sendKeys("5");

    }

    public void inputtdsb() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-input-65a8bbea6da7bbb4522fdd20"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.sendKeys("5");

    }

    //subscribe booking concierge
    private void subscribebookingconcierge() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,900)", "");
        clickchckBoxbookingconciergeplan();
        clickBtnSubscribebookingconciergeplan();
//			inputCompleteFillSubscriberPayment();
    }

    private void subscribetdsb() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,900)", "");
        clickchckBoxTDSBplan();
        inputtdsb();
        clickBtnSubscribeTDSBplan();
    }

    public void clickchckBoxbookingconciergeplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribesecond()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-6389af2c089c75ff462d97c7"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickBtnSubscribebookingconciergeplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribesecond()
                .findElement(By.cssSelector("button#cube-subscribe-btn-6389af2c089c75ff462d97c7"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
    }

    //subscribe awb concierge
    private void subscribeawbconcierge() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,900)", "");
        clickchckBoxawbconciergeplan();
        clickBtnSubscribeawbconciergeplan();
//					inputCompleteFillSubscriberPayment();
    }

    public void clickchckBoxawbconciergeplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribesecond()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-6389ae2e089c75ff462d97b7"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickBtnSubscribeawbconciergeplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribesecond()
                .findElement(By.cssSelector("button#cube-subscribe-btn-6389ae2e089c75ff462d97b7"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
    }
    //subscribe awb editor
    private void subscribeawbeditor() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,900)", "");
        clickchckBoxawbeditorplan();
        clickBtnSubscribeawbeditorplan();
        inputCompleteFillSubscriberPayment();
    }

    public void clickchckBoxawbeditorplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribesecond()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-656d4735a1c0c617986d3386"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickBtnSubscribeawbeditorplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribesecond()
                .findElement(By.cssSelector("button#cube-subscribe-btn-656d4735a1c0c617986d3386"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
    }

    //subscribe dgoffice
    private void subscribedgoffice() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,900)", "");
        clickchckBoxdgofficeplan();
        clickBtnSubscribedgofficeplan();
        inputCompleteFillSubscriberPayment();
    }

    public void clickchckBoxdgofficeplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribesecond()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-6509c7e3af6683e10dbbb6ca"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickBtnSubscribedgofficeplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribesecond()
                .findElement(By.cssSelector("button#cube-subscribe-btn-6509c7e3af6683e10dbbb6ca"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
    }

    //subscribe air line tariff query
    private void subscribeairlinetariffquery() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,900)", "");
        clickchckBoxairlinetariffqueryplan();
        clickBtnSubscribeairlinetariffqueryplan();
//					inputCompleteFillSubscriberPayment();
    }

    public void clickchckBoxairlinetariffqueryplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribesecond()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-64dc7ecd0b3820a326527906"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickBtnSubscribeairlinetariffqueryplan() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribesecond()
                .findElement(By.cssSelector("button#cube-subscribe-btn-64dc7ecd0b3820a326527906"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
    }


    // cargoai
    public void subscribecargomartai() throws Exception {
        clickchckBoxComplimentarySubscribecargoai();
        clickBtnComplimentarySubsribecargoai();
        clickBtnConfirmComplimentarySubsribecargoai();
    }

    public void clickchckBoxComplimentarySubscribecargoai() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-649172dede5affa0b247a4bb"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void clickBtnComplimentarySubsribecargoai() throws Exception {
        Thread.sleep(waitResponse);
        WebElement btnComplimentarySubscribee = shadowDomcpsubscribe()
                .findElement(By.cssSelector("button#cube-subscribe-btn-649172dede5affa0b247a4bb"));
        System.out.println("clickComplimentaryBtnSubsribe is display: " + btnComplimentarySubscribee.isDisplayed());
        btnComplimentarySubscribee.isDisplayed();
        btnComplimentarySubscribee.click();
    }

    public void clickBtnConfirmComplimentarySubsribecargoai() throws Exception {
        Thread.sleep(waitResponse);
        WebElement element = shadowDomcpsubscribe()
                .findElement(By.cssSelector("div#cube-subscribe-modal-btn-649172dede5affa0b247a4bb"));
        System.out.println("element is display: " + element.isDisplayed());
        element.isDisplayed();
        element.click();
    }

    // ==============

    public void subscribeComplimentarySubsriptionPlanProduct() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        // js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        js.executeScript("window.scrollBy(0,300)", "");
    }

    public void selectPlanPoduct(String product) throws Exception {
        Thread.sleep(waitResponse);
        List<WebElement> lsPlanProducts = getDriver().findElements(lsPlanProduct);
        List<WebElement> lsPlanProductsText = getDriver().findElements(By.xpath("//*[@id='nav']/ul/li/a"));
        evaluateJavascript("window.scrollBy(0,215)", "");
        for (int i = 0; i < lsPlanProductsText.size(); i++){
            if (lsPlanProductsText.get(i).getText().equals(product)) {
                evaluateJavascript("arguments[0].click();", lsPlanProducts.get(i));
                break;
            }
        }
//        switch (product) {
//            case "Booking Concierge":
//                lsPlanProducts.get(0).click();
//                break;
//            case "Test PnCLL ( paid non company level licensed )":
////			lsPlanProduct.get(1).click();
//                break;
//            case "Booking Queue":
//                lsPlanProducts.get(1).click();
//                break;
//
//            case "Booking Queue China Site":
//                getDriver().get("https://cndev.cubeforall.com/products/freight-operations-management/booking-queue/");
//                break;
//            case "Cargo Insurance":
//                lsPlanProducts.get(2).click();
//                break;
//            case "Cargo Insurance China Site":
////			driver.get("https://cndev.cubeforall.com/products/freight-operations-management/redkik-cargo-insurance/");
//                getDriver().get("https://sandbox.cubeforall.com/products/freight-operations-management/redkik-cargo-insurance/");
//                break;
//            case "CargoMart by CargoAi":
//                lsPlanProducts.get(3).click();
//                break;
//            case "CargoMart by CargoAi China Site":
////			driver.get("https://cndev.cubeforall.com/products/freight-operations-management/cargomart-by-cargoai/");
//                getDriver().get("https://sandbox.cubeforall.com/products/freight-operations-management/cargomart-by-cargoai/");
//                break;
//            case "Lead Freight Solutions":
////			driver.get("https://cndev.cubeforall.com/products/freight-operations-management/lead-freight-solutions/");
//                getDriver().get("https://sandbox.cubeforall.com/products/freight-operations-management/lead-freight-solutions/");
//                break;
//            case "Freight Management System - LFS Trial":
//                lsPlanProducts.get(4).click();
//                break;
//            case "Freight Management System - LFS Multi":
//                lsPlanProducts.get(4).click();
//                break;
//            case "Freight Management System - LFS Multi Upgrade":
//                lsPlanProducts.get(4).click();
//                break;
//            case "Quotation Request":
//                lsPlanProducts.get(5).click();
//                break;
//            case "Quotation Request China Site":
////			driver.get("https://cndev.cubeforall.com/products/freight-operations-management/quotation-request/");
//                getDriver().get("https://sandbox.cubeforall.com/products/freight-operations-management/quotation-request/");
//                break;
//            case "Quotation Proposal":
//                lsPlanProducts.get(6).click();
//                break;
//            case "Quotation Proposal China Site":
////			driver.get("https://cndev.cubeforall.com/products/freight-operations-management/quotation-proposal/");
//                getDriver().get("https://sandbox.cubeforall.com/products/freight-operations-management/quotation-proposal/");
//                break;
//            case "Moaah Starter":
////			lsPlanProduct.get(8).click();
//                break;
//            case "Moaah Premium":
////			lsPlanProduct.get(8).click();
//                break;
//            case "Welcome Product (Sample App)":
////			lsPlanProduct.get(9).click();
//                break;
//            case "Bundle (LFS BC) Company Level":
////			lsPlanProduct.get(10).click();
//                break;
//            case "Bundle (AWB, BC) Non Company":
////			lsPlanProduct.get(11).click();
//                break;
//            case "LFS Trial 1 day":
////			lsPlanProduct.get(12).click();
//                break;
//            case "AWB Concierge":
////			driver.get("https://cndev.cubeforall.com/products/compliance-and-documentation/awb-concierge/");
//                getDriver().get("https://sandbox.cubeforall.com/products/compliance-and-documentation/awb-concierge/");
////			driver.get("https://cubeforall.com/products/compliance-and-documentation/awb-concierge/");
//                break;
//            case "AWB Editor":
////			driver.get("https://cndev.cubeforall.com/products/compliance-and-documentation/awb-editor/");
//                getDriver().get("https://sandbox.cubeforall.com/products/compliance-and-documentation/awb-editor/");
////			driver.get("https://cubeforall.com/products/compliance-and-documentation/awb-editor/");
//                break;
//            case "DGOffice":
////			driver.get("https://cndev.cubeforall.com/products/compliance-and-documentation/dgoffice/");
//                getDriver().get("https://sandbox.cubeforall.com/products/compliance-and-documentation/dgoffice/");
////			driver.get("https://cubeforall.com/products/compliance-and-documentation/dgoffice/");
//                break;
//            case "Air Line Tariff Query":
////			driver.get("https://cndev.cubeforall.com/products/compliance-and-documentation/airline-tariff-query/");
//                getDriver().get("https://sandbox.cubeforall.com/products/compliance-and-documentation/airline-tariff-query/");
////			driver.get("https://cubeforall.com/products/compliance-and-documentation/airline-tariff-query/");
//                break;
//            case "Bundle BC AWB":
//                getDriver().get("https://sandbox.cubeforall.com/products/freight-operations-management/bundle-awb-bc/");
////			driver.get("https://cubeforall.com/products/compliance-and-documentation/airline-tariff-query/");
//                break;
//            case "test awbconcierge premium multicurrencysandbox":
//                getDriver().get("https://sandbox.cubeforall.com/products/freight-operations-management/test-awbconcierge-premium-multicurrencysandbox/");
//                break;
//            case "test iata tact rate premium multicurrencysandbox":
//                getDriver().get("https://sandbox.cubeforall.com/products/freight-operations-management/test-iata-tact-rate-premium-multicurrencysandbox/");
//                break;
//            case "test bc premium multicurrencysandbox":
//                getDriver().get("https://sandbox.cubeforall.com/products/forwarders-shippers/test-bc-premium-multicurrencysandbox/");
//                break;
//            case "test bc premium multicurrencysandbox discount":
//                getDriver().get("https://sandbox.cubeforall.com/products/freight-operations-management/test-bc-premium-multicurrencysandbox/");
//                break;
//            case "awbconcierge multicurrencysandbox discount":
//                getDriver().get("https://sandbox.cubeforall.com/products/freight-operations-management/test-awbconcierge-premium-multicurrencysandbox/");
//                break;
//            default:
//                break;
//        }

        evaluateJavascript("window.scrollBy(0,300)", "");
    }

    public void selectPlanProduct(String productB) throws Exception {
        Thread.sleep(waitResponse);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        List<WebElement> lsPlanProducts = getDriver().findElements(lsPlanProduct);
        // js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        js.executeScript("window.scrollBy(0,215)", "");
        // js.executeScript("arguments[0].scrollIntoView();",
        // bundlecompanylevelaWBConciergeLFS);
        switch (productB) {
            case "Freight Management System - LFS Multi Downgrade":
                $(lfsProduct).click();
                break;
            case "Bundle BC AWB":
                lsPlanProducts.get(9).click();
                break;
            default:
                break;
        }

        js.executeScript("window.scrollBy(0,300)", "");
    }
    public void verifyOnlyDisplayContactUs() {
        String contactUsText = $(contactUs).getText();
        System.out.println(contactUsText);
    }

    public void subscribeplan(String product) throws Exception {
        switch (product) {
            case "Booking Concierge":
                subscribebookingconcierge();
                break;
            case "TDSB":
                subscribetdsb();
                break;
            case "Cargo Insurance":

                break;
            case "CargoMart by CargoAi":
                subscribecargomartai();
                break;
            case "Freight Management System - LFS Trial":
                subscribelfstrialplan();
                break;
            case "Freight Management System - LFS Multi":
                subscribelfsmultiplan();
                break;
            case "Quotation Request":
                subscribequotationrequestplan();
                break;
            case "Booking Queue":
                subscribebookingqueueplan();
                break;
            case "Quotation Proposal":
                subscribequotationproposalplanplan();
                break;
            case "Moaah Starter":
                subscribemoaahstarterplan();
//			inputCompleteFillSubscriberPayment();
                break;
            case "Moaah Premium":
                subscribemoaahspremiumplan();
//			inputCompleteFillSubscriberPayment();
                break;
            case "Welcome Product (Sample App)":

                break;
            case "Bundle (LFS BC) Company Level":
                subscribebundlelfsbc();
                break;
            case "Bundle (AWB, BC) Non Company":
                subscribebundleawbbcplan();
                break;
            case "LFS Trial 1 day":
                subscribelfstrianonedayplan();
                break;
            case "AWB Concierge":
                subscribeawbconcierge();
                break;
            case "AWB Editor":
                subscribeawbeditor();
                break;
            case "DGOffice":
                subscribedgoffice();
                break;
            case "Air Line Tariff Query":
                subscribeairlinetariffquery();
                break;
            case "Freight Management System - LFS Multi Upgrade":
                subscribelfsmultiplanupgrade();
                break;
            case "Bundle BC AWB":
                subscribebundleBCAWBplan();
                break;
            case "test awbconcierge premium multicurrencysandbox":
                subscribetestawbconciergepremiummulticurrencysandbox();
                break;
            case "Test IATA TACT RATE-Premium Multicurrency#Sandbox":
                subscribetestiatatactratepremiummulticurrencysandbox();
                break;
            case "Test BC-Premium Multicurrency#Sandbox":
                subscribetestbcpremiummulticurrencysandbox();
                break;

            default:
                break;
        }
    }

    public void subscribePlanWithUserCount(String product, String UserCount) throws Exception {
        switch (product) {
            case "Freight Management System - LFS Multi Upgrade":
                subscribelfsmultiplanupgrade();
                break;
            case "FreightX":
                subscribeFreightX(UserCount);
                break;
            default:
                break;
        }
    }

    public void subscribeCoupon(String product, String coupon) throws Exception {
        switch (product) {
            case "awbconcierge premium multicurrencysandbox discount":
                subscribeawbconciergepremiummulticurrencysandboxdiscount(coupon);
                break;

            case "test bc premium multicurrencysandbox discount":
                subscribetestbcpremiummulticurrencysandboxdiscount(coupon);
                break;
            default:
                break;
        }
    }

    // remove button subscription
    public Boolean verifytableProductSubscription(String condition) throws Exception {
        List<WebElement> lsproductnamesubscription = getDriver().findElements(lsProductNameSubs);
        Thread.sleep(waitResponse);
        Boolean result = false;
        for (int i = 0; i < lsproductnamesubscription.size(); i++) {
            System.out.println(lsproductnamesubscription.get(i).getText());
            System.out.println(condition);
            if (lsproductnamesubscription.get(i).getText().contains(condition)) {
                result = true;
            }

            if (result == true) {
                break;
            }

        }
        return result;
    }

    public Boolean verifytablePlanSubscription(String conditionone, String conditiontwo) throws Exception {
        Thread.sleep(waitResponse);
        List<WebElement> lsproductnamesubscription = getDriver().findElements(lsProductNameSubs);
        List<WebElement> lsplannamesubscription = getDriver().findElements(lsPlanNameSubs);
        Boolean result = false;
        for (int i = 0; i < lsproductnamesubscription.size(); i++) {
            System.out.println(lsproductnamesubscription.get(i).getText());
            System.out.println(conditionone);
            System.out.println(conditiontwo);
            if (lsproductnamesubscription.get(i).getText().contains(conditionone)
                    && lsplannamesubscription.get(i).getText().contains(conditiontwo)) {
                result = true;
            }

            if (result == true) {
                break;
            }
        }
        return result;
    }

    public Boolean verifytableDescSubscription(String conditionone, String conditiontwo) throws Exception {
        Thread.sleep(waitResponse);
        List<WebElement> lsproductnamesubscription = getDriver().findElements(lsProductNameSubs);
        List<WebElement> lsdescnamesubscription = getDriver().findElements(lsDescNameSubs);
        Boolean result = false;
        for (int i = 0; i < lsproductnamesubscription.size(); i++) {
            System.out.println(lsproductnamesubscription.get(i).getText());
            System.out.println(conditionone);
            System.out.println(conditiontwo);
            if (lsproductnamesubscription.get(i).getText().contains(conditionone)
                    && lsdescnamesubscription.get(i).getText().contains(conditiontwo)) {
                result = true;
            }

            if (result == true) {
                break;
            }
        }
        return result;
    }

    public Boolean verifytableUserCountSubscription(String conditionone, String conditiontwo) throws Exception {
        Thread.sleep(waitResponse);
        List<WebElement> lsproductnamesubscription = getDriver().findElements(lsProductNameSubs);
        List<WebElement> lsusercountsubscription = getDriver().findElements(lsUserCountSubs);
        Boolean result = false;
        for (int i = 0; i < lsproductnamesubscription.size(); i++) {
            System.out.println(lsproductnamesubscription.get(i).getText());
            System.out.println(lsusercountsubscription.get(i).getText());
            System.out.println(conditionone);
            System.out.println(conditiontwo);
            if (lsproductnamesubscription.get(i).getText().toLowerCase().contains(conditionone.toLowerCase())
                    && lsusercountsubscription.get(i).getText().contains(conditiontwo)) {

                result = true;
            }

            if (result == true) {
                break;
            }
        }
        return result;
    }

    public Boolean verifytableStatusSubscription(String conditionone, String conditiontwo) throws Exception {
        Thread.sleep(waitResponse);
        List<WebElement> lsproductnamesubscription = getDriver().findElements(lsProductNameSubs);
        List<WebElement> lstatussubscription = getDriver().findElements(lsStatusSubs);
        Boolean result = false;
        for (int i = 0; i < lsproductnamesubscription.size(); i++) {
            System.out.println(lsproductnamesubscription.get(i).getText());
            System.out.println(conditionone);
            System.out.println(conditiontwo);
            if (lsproductnamesubscription.get(i).getText().contains(conditionone)
                    && lstatussubscription.get(i).getText().contains(conditiontwo)) {
                result = true;
            }

            if (result == true) {
                break;
            }

        }
        return result;
    }

    public Boolean verifytableBcycleSubscription(String conditionone, String startdate, String enddate)
            throws Exception {
        Thread.sleep(waitResponse);
        List<WebElement> lsproductnamesubscription = getDriver().findElements(lsProductNameSubs);
        WebElement startsubscriptiondate = $(startSubsDate);
        WebElement endsubscriptiondate = $(endSubsDate);
        Boolean result = false;
        for (int i = 0; i < lsproductnamesubscription.size(); i++) {
            System.out.println(lsproductnamesubscription.get(i).getText());
            System.out.println(conditionone);
            System.out.println(startsubscriptiondate.getText());
            System.out.println(endsubscriptiondate.getText());
            if (lsproductnamesubscription.get(i).getText().contains(conditionone)
                    && startsubscriptiondate.getText().contains(startdate)
                    && endsubscriptiondate.getText().contains(enddate)) {
                result = true;
            }
            if (result == true) {
                break;
            }
        }
        return result;
    }

    public void clickRemoveSubscription(String conditionone) throws Exception {
        Thread.sleep(waitResponse);
        List<WebElement> lsproductnamesubscription = getDriver().findElements(lsProductNameSubs);
        List<WebElement> btnsvglsremoveproductsubscription = getDriver().findElements(removeProductSubs);

        Boolean result = false;
        for (int i = 0; i < lsproductnamesubscription.size(); i++) {
            System.out.println(lsproductnamesubscription.get(i).getText());
            System.out.println(conditionone);
            if (lsproductnamesubscription.get(i).getText().contains(conditionone)) {
                btnsvglsremoveproductsubscription.get(i).click();
                result = true;
            }

            if (result == true) {
                break;
            }
        }
    }

    // s3 1874
    public void clickTabMenuMySubscription() {
        $(iconMenuMysubscription).click();
    }

    public void clickAcccountIcon() {
        $(accounticon).click();
    }

    public void clickProductTabFromManageSubscribtion() throws Exception {
        getDriver().switchTo().defaultContent();
        Thread.sleep(waitResponse);
        $(productTabFromManageSubscribtion).click();
    }

    public void inputCompleteFillSubscriberPayment() throws Exception {
        // Check if enterInputCardNumber() is performed
        boolean inputCardNumberPerformed = false;

        try {
            enterInputCardNumber();
            inputCardNumberPerformed = true;
        } catch (Exception e) {
            // Do nothing if enterInputCardNumber() is not performed
        }

        // Perform actions based on whether enterInputCardNumber() is performed or not
        if (inputCardNumberPerformed) {
            enterinputcardExpiryformpayment();
            enterinputVcaCardNumberformpayment();
            enterinputFullNameCardNumberformpayment();
        }

        // Click btncompleteformpaymentStripe() regardless
        clickbtncompleteformpaymentStripe();
    }

    public void openCompleteFillSubscriberPayment() throws Exception {
        Thread.sleep(longwaitResponse);
        String currentUrl = getDriver().getCurrentUrl();
        System.out.println(currentUrl);
        Thread.sleep(2000);
    }

    public void inputserachphonenumberformpayment() throws Exception {
        Thread.sleep(waitResponse);
        $(inputserachphonenumberformpayment).sendKeys("081234567891");
        Thread.sleep(1000);
    }

    public void clickenableStripePass() throws Exception {
        Thread.sleep(waitResponse);
        $(clickchckEnableStripePass).click();
    }

    public void enterInputCardNumber() throws Exception {
        Thread.sleep(waitResponse);
        $(inputCardNumberformpayment).sendKeys("4242424242424242");
    }

    public void enterinputcardExpiryformpayment() throws Exception {
        Thread.sleep(waitResponse);
        $(inputcardExpiryformpayment).sendKeys("0825");
    }

    public void enterinputVcaCardNumberformpayment() throws Exception {
        Thread.sleep(waitResponse);
        $(inputVcaCardNumberformpayment).sendKeys("424");
    }

    public void enterinputFullNameCardNumberformpayment() throws Exception {
        Thread.sleep(waitResponse);
        $(inputFullNameCardNumberformpayment).sendKeys("Testerccn");
    }

    public void clickbtncompleteformpaymentStripe() throws Exception {
        Thread.sleep(waitResponse);
        $(SubmitButtoncompleteformpaymentStripe).click();
    }

    public void clickProductbundlecompanylevelaWBConciergeLFS() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        // js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        js.executeScript("window.scrollBy(0,215)", "");
        // js.executeScript("arguments[0].scrollIntoView();",
        // bundlecompanylevelaWBConciergeLFS);
        $(bundlecompanylevelaWBConciergeLFS).isDisplayed();
        $(bundlecompanylevelaWBConciergeLFS).click();
    }

    public void validateprodcutprice() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        // js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        js.executeScript("window.scrollBy(0,300)", "");

    }

    public void clickInputCheckboxSubscribe() {
        System.out.println("clickInputCheckboxSubscribe is display: " + $(inputCheckboxSubscribe).isDisplayed());
        $(inputCheckboxSubscribe).isDisplayed();
        $(inputCheckboxSubscribe).click();

    }

    public void enterInputNumberOfUser() {
        System.out.println("enterInputNumberOfUser is display: " + $(inputUser).isDisplayed());
        $(inputUser).isDisplayed();
        $(inputUser).sendKeys("3");
    }

    // 2238 separate notification for manual & auto subscribe / unsubscribe.
    private By lsFreightForwardMenu = By.xpath("//*[@id=\"freight\"]/ul/li/a");
    public void clickCompianceAndDocumentationMenu() throws Exception {
        Thread.sleep(waitResponse);
        List<WebElement> lsFreightForwarderMenu = getDriver().findElements(lsFreightForwardMenu);
        lsFreightForwarderMenu.get(1).click();
    }

    public void clickAWBEditor() throws Exception {
        Thread.sleep(waitResponse);
        List<WebElement> lsCompliencenDoc = getDriver().findElements(lsComplieneDoc);
        lsCompliencenDoc.get(1).click();
    }

    public void clickchckboxSubscribeAwbeditor() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,300)", "");
    }

    public void backtoCubeforallfrompayment() throws Exception{
        Thread.sleep(waitResponse);
        $(backfrompayment).click();
    }

    public void unsubscribePlan(String plan){
        List<WebElement> rows = getDriver().findElements(By.xpath("//*[@id='cube-plan-list']/tbody/tr"));
        int rowCount = rows.size();
        System.out.println("Total number of rows in the table: " + rowCount);

        List<WebElement> column = getDriver().findElements(By.xpath("//*[@id='cube-plan-list']/tbody/tr"));
        int columnCount = column.size();
        System.out.println("Total number of column in the table: " + columnCount);

        for (int r = 1; r <= rowCount; r++) {
            for (int c = 1; c <= columnCount; c++) {
                String data = $(By.xpath("//*[@id='cube-plan-list']//tr[" + r + "]/td[" + c + "]")).getText();
                System.out.println(data);

                if (data.contains(plan)) {
                    // Assuming td8 is the 8th column in the current row
                    $(By.xpath("//*[@id='cube-plan-list']//tr[" + r + "]/td[8]")).click();
                }
            }
        }
    }

    // TODO FIX atas
    public void switchWindowTab(){
        getDriver().switchTo().newWindow(WindowType.TAB);
    }

    public void switchToWindow(String page){
        getDriver().switchTo().window(page);
    }

    public String getWindow(){
        return getDriver().getWindowHandle();
    }

    public void closeWindow(){
        getDriver().close();
    }
}
