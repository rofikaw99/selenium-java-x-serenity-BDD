package starter.pages;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.rest.SerenityRest.given;

public class PopUpAdvertisementBannerPage extends PageObject {

    private int waitResponse = 3000;
    WebDriver driver;

    private By advertisementBanner = By.xpath("//img[@alt='Iklan']");
    private By buttonCloseBanner = By.xpath("//div[contains(@class, 'items-center') and contains(text(), '×')]");
    private By doNotShowThisAgain = By.xpath("//div[normalize-space(text())='Do not show this again']");
    private By findOutMore = By.xpath("//a[normalize-space(text())='Click here to find out more']");


    public boolean advertisementBannerDisplay(){
        return $(advertisementBanner).isDisplayed();
    }
    public boolean doNotShowThisAgain(){
        return $(doNotShowThisAgain).isClickable();
    }
    public void verifyAdvertisementBannerIsNotVisible() {
        Assert.assertFalse($(advertisementBanner).isVisible());
    }

    public void closeBanner() throws InterruptedException{
        $(buttonCloseBanner).isDisplayed();
        $(buttonCloseBanner).click();
        Thread.sleep(1000);
    }
    public void clickFindOutMore() throws InterruptedException{
        $(findOutMore).isDisplayed();
        $(findOutMore).click();
        Thread.sleep(3000);
    }
}
