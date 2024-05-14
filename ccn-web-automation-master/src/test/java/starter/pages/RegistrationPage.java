package starter.pages;

import net.serenitybdd.screenplay.targets.SearchableTarget;
import net.serenitybdd.screenplay.ui.Dropdown;
import net.serenitybdd.screenplay.ui.Select;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class RegistrationPage extends PageObject {

    private int waitResponse =15000;
    //register
    private By linkSignUpNow = By.id("createAccount");
    private By txtEmailRegister = By.id("email");
    private By btnSendVerificationCodeRegister = By.id("email_ver_but_send");
    private By txtVerificationCodeRegister = By.id("email_ver_input");
    private By btnVerificationCodeRegister = By.id("email_ver_but_verify");
    private By btnAgreeTerm = By.id("extension_TermsOfUseConsented_AgreeToTermsOfUseConsentYes");
    private By btnResendVerificationCodeRegister = By.id("email_ver_but_resend");
    private By txtNewPasswordRegister = By.id("newPassword");
    private By txtConfirmNewPasswordRegister = By.id("reenterPassword");
    private By txtDisplayNameRegister = By.id("displayName");
    private By txtCompanyNameRegister = By.id("cube-company-name");
    private By txtContactNumberRegister = By.id("extension_ContactNo");
//    private By dropdownCityRegister = By.id("city");
    private SearchableTarget dropdownCityRegister = Dropdown.withNameOrId("city");
//    private By dropdownCountryRegister = By.id("extension_CountryCode");
    private SearchableTarget dropdownCountryRegister = Dropdown.withNameOrId("extension_CountryCode");
    private By btnCreateRegister = By.id("continue");

    public void pressSignUpNow() throws InterruptedException {
        Thread.sleep(10000);
        $(linkSignUpNow).waitUntilVisible();
        $(linkSignUpNow).click();
    }

    public void inputEmailRegister(String email){
        $(txtEmailRegister).clear();
        $(txtEmailRegister).sendKeys(email);
    }
    public void pressSendVerificationCodeRegister(){
        $(btnSendVerificationCodeRegister).click();
    }
    public void inputVerificationCodeRegister(String verificationCode){
        $(txtVerificationCodeRegister).isDisplayed();
        $(txtVerificationCodeRegister).clear();
        $(txtVerificationCodeRegister).sendKeys(verificationCode);
    }
    public void pressVerificationCodeRegister(){
        $(btnVerificationCodeRegister).click();
    }

    public void pressAgreetheTerm(){
        $(btnAgreeTerm).click();
    }
    public void inputNewPasswordRegister(String password){
        $(txtNewPasswordRegister).clear();
        $(txtNewPasswordRegister).sendKeys(password);
    }
    public void inputConfirmNewPasswordRegister(String password){
        $(txtConfirmNewPasswordRegister).clear();
        $(txtConfirmNewPasswordRegister).sendKeys(password);
    }
    public void inputDisplayNameRegister(String displayName){
        $(txtDisplayNameRegister).clear();
        $(txtDisplayNameRegister).sendKeys(displayName);
    }
    public void inputCompanyNameRegister(String companyName){
        $(txtCompanyNameRegister).clear();
        $(txtCompanyNameRegister).sendKeys(companyName);
    }
    public void inputContactNumberRegister(String contactNumber){
        $(txtContactNumberRegister).clear();
        $(txtContactNumberRegister).sendKeys(contactNumber);
    }
    public void selectCityRegister(String city){
        $(dropdownCityRegister).click();
        $(dropdownCityRegister).sendKeys(city);
        $(dropdownCityRegister).sendKeys(Keys.ENTER);
    }
    public void selectCountryRegister(String country){
        $(dropdownCountryRegister).click();
        $(dropdownCountryRegister).sendKeys(country);
        $(dropdownCountryRegister).sendKeys(Keys.ENTER);
    }
    public void pressCreateAccountRegister() throws Exception{
        $(btnCreateRegister).isEnabled();
        Thread.sleep(waitResponse);
        $(btnCreateRegister).click();
    }
    public void registerCubeforall(String email,
                                   String password,
                                   String displayName,
                                   String contactNumber,
                                   String city,
                                   String country,
                                   String verificationCode) throws Exception{
        inputEmailRegister(email);
        pressSendVerificationCodeRegister();
        inputNewPasswordRegister(password);
        inputConfirmNewPasswordRegister(password);
        inputDisplayNameRegister(displayName);
        inputContactNumberRegister(contactNumber);
        selectCityRegister(city);
        selectCountryRegister(country);
        inputVerificationCodeRegister(verificationCode);
        pressVerificationCodeRegister();
        pressCreateAccountRegister();
    }
}
