package starter.pages;

import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import starter.utlis.Constants;

import java.util.Set;

public class SQPPPage extends PageObject {

    private int waitResponse = 2000;
    public String sqppwindows = "";
    public String originsqppwindows = "";

    private By loginsqpp = By.xpath("//*[@id=\"pageHeader\"]/div/div/div[3]/div/div[2]/wc-login/div/button");
    private By acceptcookiesqpp = By.xpath("/html/body/div[3]/div/div/div/div[2]/button[3]");
    //login
    private By emailsignin = By.id("signInName");
    private By passwordsignin = By.id("password");
    private By nextsigninone = By.id("next");
    private By sendverifcode = By.id("readOnlyEmail_ver_but_send");
    private By inputverifcode = By.id("readOnlyEmail_ver_input");
    private By verifycode = By.id("readOnlyEmail_ver_but_verify");
    private By verifycoderegis = By.id("email_ver_but_verify");
    private By continuesignin = By.id("continue");
    private By emailVerification = By.xpath(
            "//*[@id=\"mail\"]/div/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td[3]/table/tbody/tr/td/table/tbody/tr/td/div[2]/span");
    private By signupsqpp = By.id("createAccount");
    private By inputemailsqpp = By.id("email");
    private By sendverifcoderegister = By.id("email_ver_but_send");
    private By inputverifcodesqppregister = By.id("email_ver_input");
    private By passwordregis = By.id("newPassword");
    private By confirmpasswordregis = By.id("reenterPassword");
    private By displayname = By.id("displayName");
    private By agentcode = By.id("extension_AgentCode");
    private By selectelementforcity = By.id("city");
    private By selectelementforcountry = By.id("extension_CountryCode");
    private By checkboxregissqpp = By.id("extension_TermsOfUseConsented_AgreeToTermsOfUseConsentYes");
    private By contiunueregis = By.id("continue");
    private By iconmenusqpp = By.xpath("//*[@id=\"pageHeader\"]/div/div/div[3]/div/div[2]/wc-login/div/div/div");

    // accces sqpp
    // *[@id="pageHeader"]/div/div/div[3]/div/div[2]/wc-login/div/div/div icon menu
    // *[@id="pageHeader"]/div/div/div[3]/div/div[2]/wc-login/div/div/div[2]/div[2]/div/a/span
    // list icon menu except sign out
    // *[@id="wrapper"]/div/section/div/div/agent-management//div/div/div/div[2]/div/div/div[2]/div/form/div/input
    // search agent code in agent management

    public void goToSqppUrl(){
        openUrl(Constants.SQPP_PATH_URL);
    }

    public void loginsqpp() throws Exception {
        Thread.sleep(waitResponse);
        $(acceptcookiesqpp).click();
        Thread.sleep(waitResponse);
        $(loginsqpp).click();
        Thread.sleep(waitResponse);
    }

    public void changeSigninWindowsqpp() {
        originsqppwindows = getDriver().getWindowHandle();
        sqppwindows = getDriver().getWindowHandle();
        Set<String> loginwindows = getDriver().getWindowHandles();
        for (String windowHandle : loginwindows) {
            if (!sqppwindows.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                sqppwindows = windowHandle;
                break;
            }
        }
    }

    public void inputloginsqpp(String email, String password) throws Exception {
        Thread.sleep(waitResponse);
        $(emailsignin).sendKeys(email);
        Thread.sleep(waitResponse);
        $(passwordsignin).sendKeys(password);
        Thread.sleep(waitResponse);
        $(nextsigninone).click();
        Thread.sleep(waitResponse);
        $(sendverifcode).click();
    }

    public void getVerificationCodesqpp() {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame("ifmail");
        String getEmailText = getDriver().findElement(emailVerification).getText();
        Constants.VERIFICATION_CODE_SQPP = StringUtils.getDigits(getEmailText);
    }

    public void inputverifcodeaftergetfromemail() throws Exception {
        Thread.sleep(waitResponse);
        $(inputverifcode).sendKeys(Constants.VERIFICATION_CODE_SQPP);
        Thread.sleep(waitResponse);
        $(verifycode).click();
    }

    public void continuesigninsqpp() throws Exception {
        Thread.sleep(waitResponse);
        $(continuesignin).click();
    }

    public void signupsqpp(String email) throws Exception {
        Thread.sleep(waitResponse);
        $(signupsqpp).click();
        $(inputemailsqpp).sendKeys(email);
        $(sendverifcoderegister).click();
    }

    public void inputverifcodeaftergetfromemailregis() throws Exception {
        Thread.sleep(waitResponse);
        $(inputverifcodesqppregister).sendKeys(Constants.VERIFICATION_CODE_SQPP);
        Thread.sleep(waitResponse);
        $(verifycoderegis).click();
        Thread.sleep(waitResponse);
        $(passwordregis).sendKeys(Constants.PASSWORD);

        Thread.sleep(waitResponse);
        $(confirmpasswordregis).sendKeys(Constants.PASSWORD);

        Thread.sleep(waitResponse);
        $(displayname).sendKeys(Constants.DISPLAY_NAME);

        Thread.sleep(waitResponse);
        $(agentcode).sendKeys("325364645");

        Thread.sleep(waitResponse);

        Select selectcity = new Select($(selectelementforcity));
        selectcity.selectByVisibleText("SINGAPORE");

        Thread.sleep(waitResponse);

        Select selectCountry = new Select($(selectelementforcountry));
        selectCountry.selectByVisibleText("Singapore");

        Thread.sleep(waitResponse);
        $(checkboxregissqpp).click();
        Thread.sleep(waitResponse);
        $(contiunueregis).click();
        Thread.sleep(waitResponse);
    }

    public void iconmenusqpp() throws Exception {
        Thread.sleep(waitResponse);
        $(iconmenusqpp).click();
    }

    public void driverClose(){
        getDriver().close();
    }
}
