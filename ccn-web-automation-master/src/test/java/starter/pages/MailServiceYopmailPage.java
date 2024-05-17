package starter.pages;

import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import starter.utlis.Constants;

import java.util.List;

public class MailServiceYopmailPage extends PageObject {

    private int waitResponse=1000;
    private int medResponse=5000;
    private By txtSearch = By.cssSelector("input#login.ycptinput");
    private By emailOnLists = By.xpath("//button[@id='refresh']");
    private By emailVerification = By.xpath("//span[contains(text(), 'Your code is:')]");
    private By refreshemail = By.id("refresh");
    private By loginyopmail = By.id("login");
    private By btnloginyopmail = By.xpath("//*[@id=\"refreshbut\"]/button");
    private By emailyopmail = By.xpath("//*[@class=\"m\"]/button/div[@class=\"lms\"]");
    private By emailHeader = By.xpath("//*[@id=\"webmail\"]/div[1]/div/header/div/nav/div[2]/a[1]");
    private By firstEmailHeader = By.xpath("//*[@class = 'lms'][1]");

    private SearchContext shadowDomcpsubscribe() throws Exception {
        Thread.sleep(waitResponse);
        WebElement root = $(By.tagName("cp-subscribe-button"));
        SearchContext shadowDomcpsubscribe = ( SearchContext) evaluateJavascript("return arguments[0].shadowRoot", root);
        return shadowDomcpsubscribe;
    }

    public void clickchckBoxComplimentarySubscribelfsfreetrial() throws Exception {
        Thread.sleep(waitResponse);
        WebElement chckBoxComplimentarySubscribee=shadowDomcpsubscribe().findElement(By.cssSelector("input#cube-subscribe-btn-checkbox-6566e1f8669e862c02256095"));
        System.out.println("clickComplimentaryBtnSubsribe is display: "+chckBoxComplimentarySubscribee.isDisplayed());
        chckBoxComplimentarySubscribee.isDisplayed();
        chckBoxComplimentarySubscribee.click();
    }

    public void getVerificationCode(){
        //*[@id="refresh"]
        getDriver().switchTo().frame("ifinbox");
        String getEmailText = $(emailVerification).getText();
        Constants.VERIFICATION_CODE_SQPP = StringUtils.getDigits(getEmailText);
    }

    public void getVerificationCodeGLB(){
        // search mail on mailinator
        $(txtSearch).clear();
        $(txtSearch).sendKeys(Constants.FULL_MAIL, Keys.ENTER);
        // press or expand the email
        $(emailOnLists).isDisplayed();
        $(emailOnLists).click();
        // get text email verification and extract the verification code
//	    try {
//	        // Adding sleep before switching to the frame
//	        Thread.sleep(4000);
//	    } catch (InterruptedException e) {
//	        // Handle the InterruptedException
//	        e.printStackTrace();
//	        // Optionally, you can decide to re-interrupt the thread or perform other actions
//	        Thread.currentThread().interrupt();
//	    }
        getDriver().switchTo().frame("ifmail");
        String getEmailText = $(emailVerification).getText();
        Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
    }


    public void getPaymentNotification(String email){
        // search mail on mailinator
        $(txtSearch).clear();
        $(txtSearch).sendKeys(email, Keys.ENTER);
        // press or expand the email
        $(emailOnLists).isDisplayed();
        $(emailOnLists).click();
    }

    public void getVerificationCodesg(){
        // search mail on mailinator
        $(txtSearch).clear();
        $(txtSearch).sendKeys(Constants.FULL_EMAIL_SG, Keys.ENTER);
        // press or expand the email
        $(emailOnLists).isDisplayed();
        $(emailOnLists).click();
        // get text email verification and extract the verification code
        getDriver().switchTo().frame("ifmail");
        String getEmailText = $(emailVerification).getText();
        Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
    }

    public void getVerificationCodemy(){
        // search mail on mailinator
        $(txtSearch).clear();
        $(txtSearch).sendKeys(Constants.FULL_EMAIL_MY, Keys.ENTER);
        // press or expand the email
        $(emailOnLists).isDisplayed();
        $(emailOnLists).click();
        // get text email verification and extract the verification code
        getDriver().switchTo().frame("ifmail");
        String getEmailText = $(emailVerification).getText();
        Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
    }

    public void getVerificationCodeUAE(){
        // search mail on mailinator
        $(txtSearch).clear();
        $(txtSearch).sendKeys(Constants.FULL_EMAIL_UAE, Keys.ENTER);
        // press or expand the email
        $(emailOnLists).isDisplayed();
        $(emailOnLists).click();
        // get text email verification and extract the verification code
        getDriver().switchTo().frame("ifmail");
        String getEmailText = $(emailVerification).getText();
        Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
    }

    public void getVerificationCodeina(){
        // search mail on mailinator
        $(txtSearch).clear();
        $(txtSearch).sendKeys(Constants.FULL_EMAIL_INDO, Keys.ENTER);
        // press or expand the email
        $(emailOnLists).isDisplayed();
        $(emailOnLists).click();
        // get text email verification and extract the verification code
        getDriver().switchTo().frame("ifmail");
        String getEmailText = $(emailVerification).getText();
        Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
    }

    public boolean emailInvitationDisplayed(){
        $(emailOnLists).isDisplayed();
        int times = 0;
        while (!$("//*[@id = 'nbmail']").getText().equals("1 mail") && (times < 10)) {
            $(emailOnLists).click();
            times++;
        }
        getDriver().switchTo().frame("ifinbox");
        $(firstEmailHeader).waitUntilVisible();
        return $(firstEmailHeader).getText().contains("been granted");

    }

    public void getVerificationCodenz(){
        // search mail on mailinator
        $(txtSearch).clear();
        $(txtSearch).sendKeys(Constants.FULL_EMAIL_NZ, Keys.ENTER);
        // press or expand the email
        $(emailOnLists).isDisplayed();
        $(emailOnLists).click();
        // get text email verification and extract the verification code
        getDriver().switchTo().frame("ifmail");
        String getEmailText = $(emailVerification).getText();
        Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
    }

    public void getVerificationCodech(){
        // search mail on mailinator
        $(txtSearch).clear();
        $(txtSearch).sendKeys(Constants.FULL_EMAIL_CH, Keys.ENTER);
        // press or expand the email
        $(emailOnLists).isDisplayed();
        $(emailOnLists).click();
        // get text email verification and extract the verification code
        getDriver().switchTo().frame("ifmail");
        String getEmailText = $(emailVerification).getText();
        Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
    }
    public void getVerificationCode(String email){
        // search mail on mailinator
        $(txtSearch).clear();
        $(txtSearch).sendKeys(email, Keys.ENTER);
        // press or expand the email
        $(emailOnLists).isDisplayed();
        $(emailOnLists).click();
        // get text email verification and extract the verification code
        getDriver().switchTo().frame("ifmail");
        String getEmailText = $(emailVerification).getText();
        Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
    }

    public void loginYopmail(String email) throws Exception{
        Thread.sleep(waitResponse);
        $(loginyopmail).sendKeys(email);
    }

    public void searchEmail(String email) throws Exception{
        $(txtSearch).clear();
        $(txtSearch).sendKeys(email, Keys.ENTER);
    }

    public void btnloginyopmail() throws Exception{
        Thread.sleep(waitResponse);
        $(btnloginyopmail).click();
    }
    public void selectemailtoopen() throws Exception{
        Thread.sleep(waitResponse);
        getDriver().switchTo().frame("ifinbox");
        Thread.sleep(waitResponse);
        List<WebElement> listemailyopmail = getDriver().findElements(emailyopmail);
        listemailyopmail.get(3).click();
        getDriver().switchTo().defaultContent();
        Thread.sleep(30000);
        $(emailHeader).click();
    }

    public void selectemailtoopendetail(String content) throws Exception{
        Thread.sleep(medResponse);
        $(refreshemail).click();
        Thread.sleep(waitResponse);
        getDriver().switchTo().frame("ifinbox");
        Thread.sleep(waitResponse);
        List<WebElement> listemailyopmail = getDriver().findElements(emailyopmail);
        for(WebElement i:listemailyopmail) {
            if(i.getText().contains(content)) {
                i.click();
                break;
            }
        }

//	    public static void main(String[] args) {
//	        String a = "code 44 verification was 123211";
//	        String getDigit = StringUtils.getDigits(a);
//	        System.out.println(getDigit);
//	    }

//		sdriver.switchTo().defaultContent();
//		Thread.sleep(30000);
//		driver.findElement(By.xpath("//*[@id=\"webmail\"]/div[1]/div/header/div/nav/div[2]/a[1]")).click();

    }
}
