package starter.pages;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.*;
import starter.utlis.Constants;

import java.util.List;

public class SecurityServiceGatewayPageOrdinary extends PageObject {

    private int waitResponse = 3000;
    private int longwaitResponse = 15000;
    private String newWindow="";

    String freshToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6IlFqZmFlS1pwOXhiZ1dwSDVqM3pYTGxaUW5Qa2szMHFCelZ2Rzl2cmdKLXMiLCJ0eXAiOiJKV1QifQ";
    private By JWTstringInput = By.xpath("(//div[@class='CodeMirror-code']//pre/span[@role='presentation'])[1]");
    private By cmJWTheader = By.xpath("//span[@class='cm-jwt-header']");

    public void inputTokenPayload(){
        $(cmJWTheader).waitUntilVisible();
//        $(cmJWTheader).clear();
        $(cmJWTheader).sendKeys(freshToken);
    }
}
