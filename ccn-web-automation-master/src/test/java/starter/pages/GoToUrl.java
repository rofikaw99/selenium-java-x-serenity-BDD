package starter.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import starter.utlis.Constants;

public class GoToUrl extends PageObject {

    private int longWait = 15000;

    public void goToProductTab() throws InterruptedException {
        Thread.sleep(longWait);
        openAt(Constants.URL_PRODUCTS);
    }

    public void goToUrl(String url){
        openAt(url);
    }

    public void goToAbsUrl(String url){
        openUrl(url);
    }
}
