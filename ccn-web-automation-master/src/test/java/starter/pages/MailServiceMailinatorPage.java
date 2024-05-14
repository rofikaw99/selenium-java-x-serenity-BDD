package starter.pages;

import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import starter.utlis.Constants;

public class MailServiceMailinatorPage extends PageObject {
    private By txtSearch = By.id("search");
    private By emailOnLists = By.xpath("//td[contains(.,'CUBEforall by CCN account email verification code')]");
    private By emailVerification = By.xpath("//span[@id='BodyPlaceholder_UserVerificationEmailBodySentence2']");

    public void getVerificationCode(){
        // search mail on mailinator
        $(txtSearch).clear();
        $(txtSearch).sendKeys(Constants.FULL_EMAIL, Keys.ENTER);
        // press or expand the email
        $(emailOnLists).isDisplayed();
        $(emailOnLists).click();
        // get text email verification and extract the verification code
        getDriver().switchTo().frame("html_msg_body");
        String getEmailText = $(emailVerification).getText();
        Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
    }

    public void getVerificationCodelogin(){
        // search mail on mailinator
        $(txtSearch).clear();
        $(txtSearch).sendKeys(Constants.FULL_EMAIL_AFTER_LOGIN, Keys.ENTER);
        // press or expand the email
        $(emailOnLists).isDisplayed();
        $(emailOnLists).click();
        // get text email verification and extract the verification code
        getDriver().switchTo().frame("html_msg_body");
        String getEmailText = $(emailVerification).getText();
        Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
    }

    public void getVerificationCodesg(){
        // search mail on mailinator
        $(txtSearch).clear();
        $(txtSearch).sendKeys(Constants.FULL_EMAIL_SG, Keys.ENTER);
        // press or expand the email
        $(emailOnLists).isDisplayed();
        $(emailOnLists).click();
        // get text email verification and extract the verification code
        getDriver().switchTo().frame("html_msg_body");
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
        getDriver().switchTo().frame("html_msg_body");
        String getEmailText = $(emailVerification).getText();
        Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
    }

    public void getVerificationCodeuae(){
        // search mail on mailinat
        $(txtSearch).clear();
        $(txtSearch).sendKeys(Constants.FULL_EMAIL_UAE, Keys.ENTER);
        // press or expand the email
        $(emailOnLists).isDisplayed();
        $(emailOnLists).click();
        // get text email verification and extract the verification code
        getDriver().switchTo().frame("html_msg_body");
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
        getDriver().switchTo().frame("html_msg_body");
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
        getDriver().switchTo().frame("html_msg_body");
        String getEmailText = $(emailVerification).getText();
        Constants.VERIFICATION_CODE = StringUtils.getDigits(getEmailText);
    }
}
