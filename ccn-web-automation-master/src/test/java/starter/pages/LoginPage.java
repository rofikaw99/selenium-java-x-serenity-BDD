package starter.pages;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import starter.utlis.Constants;

import java.util.Set;


public class LoginPage extends PageObject {

    private int waitResponse=30000;
    private By formUserid = By.id("formUserId");
    private By formBasicPassword = By.id("formBasicPassword");
    private By btnSubmit = By.xpath( "//button[text()='Submit']");
    private By btnAcceptCookie = By.xpath("(//button[normalize-space()='Accept'])[1]");
    private By bcCNmarket = By.xpath("//a[@class='btn-1' and contains(@href, '#interest')]");
    private By btnSignInOnTheHomepage = By.xpath("//button[@class='login-btn']");
    private By txtEmailLogin = By.id("signInName");
    private By txtPasswordLogin = By.id("password");
    private By btnSignIn = By.id("next");
    private By TestBCPremiumMulticurrencySandbox = By.xpath("(//*[@id='nav']/ul/li/a)[14]");
    private By cookieElement = By.xpath("(//button[@class='cky-btn cky-btn-accept' and @aria-label='Accept All'])[1]");

    private By cookies = By.xpath("(//button[@class='cky-btn cky-btn-accept' and @aria-label='Accept All'])[1]");
    private By okErrorSession = By.id("cube-confirm-sign-in");
    private String initWindow = "";

    public void goToMainWeb(){
        open();
    }
    public void clickCookies(){
        if ($$(cookies).size() == 1) evaluateJavascript("arguments[0].click();", $(cookies));
    }

    public void clickOKSession(){
        if ($$(okErrorSession).size() == 1) evaluateJavascript("arguments[0].click();", $(okErrorSession));
    }

    public void goToLoginPage(){
        openUrl(Constants.URL_DIRECT_SIGNIN);
    }
    public void printAllCookies(){
        openAt("/");
        Set<Cookie> cookies = getDriver().manage().getCookies();
        System.out.println(cookies.size()+"======================================================================================");
        for(Cookie c:cookies) {
            System.out.println(c.getName()+" : "+c.getValue());
            System.out.println(getDriver().manage().getCookieNamed(c.getName()));
        }
    }

    public void inputEmailLogin(String email){
        $(txtEmailLogin).waitUntilVisible();
        $(txtEmailLogin).clear();
        $(txtEmailLogin).sendKeys(email);
    }
    public void inputPasswordLogin(String password){
        $(txtPasswordLogin).waitUntilVisible();
        $(txtPasswordLogin).clear();
        $(txtPasswordLogin).sendKeys(password);
    }

    public void inputUserId(String userId){
        $(formUserid).clear();
        $(formUserid).sendKeys(userId);
    }
    public void inputBasicPassword(String password){
        $(formBasicPassword).clear();
        $(formBasicPassword).sendKeys(password);
    }
    public void pressSignIn(){
        $(btnSignIn).isDisplayed();
        $(btnSignIn).click();
    }

    public void scrollToElement(By element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", find(element));
    }

    public void selectTestBCPremiumMulticurrencySandbox(){
        getDriver().get("https://sandbox.cubeforall.com/products/forwarders-shippers/test-iata-tact-rate-premium-multicurrencysandbox/");

    }

    public void selectplanbundleBCAWB(){
        getDriver().get("https://sandbox.cubeforall.com/products/forwarders-shippers/bundle-awb-bc/");

    }

    public void selecttestawbconciergepremiummulticurrencysandbox(){
        getDriver().get("https://sandbox.cubeforall.com/products/forwarders-shippers/test-awbconcierge-premium-multicurrencysandbox/");
    }

    public void selectPlanLeadFreightSolutions(){
        getDriver().get("https://sandbox.cubeforall.com/products/forwarders-shippers/lead-freight-solutions/");
    }

    public void selectTestIATATACTRATEPremiumMulticurrencySandbox(){
        getDriver().get("https://sandbox.cubeforall.com/products/forwarders-shippers/test-iata-tact-rate-premium-multicurrencysandbox/");

    }

    public void selectplanBCCNMarket(){
        getDriver().get("https://cndev.cubeforall.com/products/freight-operations-management/booking-concierge/");
    }

    public void contactusonplanBCCNMarket(){
        $(bcCNmarket).isDisplayed();
        $(bcCNmarket).click();
    }

    public void loginCubeforall(String email, String password){
        if (email == null) {
            email = Constants.FULL_EMAIL_AFTER_LOGIN;
            password = Constants.PASSWORD;
        }
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputEmailLogin(email);
        inputPasswordLogin(password);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pressSignIn();
    }

    public void pressAcceptCookies(){
        try{
            $(btnAcceptCookie).isDisplayed();
            $(btnAcceptCookie).click();
        }catch (Exception e){
            System.out.println("cookies not displayed "+e);
        }
    }
    public void pressBtnLoginInit() throws InterruptedException {
        Thread.sleep(2000);
        clickOKSession();
//        if (isCookieDisplayed()) {
//            $(cookieElement).isDisplayed();
//            $(cookieElement).click();
//        } else {
//            System.out.println("Cookie is not displayed. Skip click cookie.");
//        }
        $(btnSignInOnTheHomepage).isDisplayed();
        $(btnSignInOnTheHomepage).click();
    }

    public boolean isCookieDisplayed() {
        // Logic to check if cookie is displayed
        // Return true if displayed, false otherwise
        // Example:
         return $(cookieElement).isDisplayed();
    }
    public void changeSigninWindow() {
        initWindow = getDriver().getWindowHandle();
        Set<String> loginWindows = getDriver().getWindowHandles();
        for (String windowHandle : loginWindows) {
            if(!initWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    // another account
    // test_irsyad_0001@yopmail.com, Irsyad14129812
    // test_071123_a1@yopmail.com, p@55w0rd

    public void inputSignin(String email,String password) throws Exception {
        Constants.FULL_EMAIL_AFTER_LOGIN=email;
        inputEmailLogin(email);
        inputPasswordLogin(password);
        System.out.println("btninputsignin is displaying : "+$(btnSignIn).isDisplayed()+" and enabled : "+$(btnSignIn).isEnabled());
        Thread.sleep(waitResponse);
        pressSignIn();
    }

    public void inputSigninSupportApp(String userID,String password) throws Exception {
        Constants.FULL_EMAIL_AFTER_LOGIN=userID;
        inputUserId(userID);
        inputBasicPassword(password);
        System.out.println("button submit is displaying : "+$(btnSubmit).isDisplayed()+" and enabled : "+$(btnSubmit).isEnabled());
        Thread.sleep(waitResponse);
        $(btnSubmit).click();
    }

    public void validateInMainWeb(){
        getDriver().switchTo().window(initWindow);
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("portal"));
    }

    public void login(String email) throws InterruptedException {
        goToMainWeb();
        pressBtnLoginInit();
        changeSigninWindow();
        inputEmailLogin(email);
        inputPasswordLogin(Constants.PASSWORD);
        Thread.sleep(3000);
        pressSignIn();
        Thread.sleep(35000);
        validateInMainWeb();
    }

//	private SearchContext shadowDomcpsubscribe() throws Exception {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		Thread.sleep(waitResponse);
//		WebElement root = driver.findElement(By.xpath("//cp-subscribe-button[@price_id='657c08880cc0f27d570a3ac8']"));
//		SearchContext shadowDomcpsubscribe = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root);
//		return shadowDomcpsubscribe;
//	}

}
