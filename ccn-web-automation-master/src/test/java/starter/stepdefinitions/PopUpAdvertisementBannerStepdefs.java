package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import starter.pages.PopUpAdvertisementBannerPage;

public class PopUpAdvertisementBannerStepdefs {

    @Steps
    PopUpAdvertisementBannerPage popUpAdvertisementBannerPage;

    @Then("the advertisement popup banner should appear and should be responsive")
    public void theAdvertisementPopupBannerShouldAppearAndShouldBeResponsive() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(popUpAdvertisementBannerPage.advertisementBannerDisplay());
    }
    @When("the advertisement popup banner is visible")
    public void the_advertisement_popup_banner_is_visible() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(popUpAdvertisementBannerPage.advertisementBannerDisplay());
    }

    @And("the user clicks the close button")
    public void theUserClicksTheCloseButton() throws InterruptedException {
        popUpAdvertisementBannerPage.closeBanner();
    }

    @Then("the banner should disappear")
    public void theBannerShouldDisappear() throws InterruptedException {
        Thread.sleep(1000);
        popUpAdvertisementBannerPage.verifyAdvertisementBannerIsNotVisible();
    }

    @When("the user clicks outside of the popup area")
    public void theUserClicksOutsideOfThePopupArea() throws InterruptedException {
        popUpAdvertisementBannerPage.closeBanner();
    }

    @When("the user checks the Do not show this again checkbox")
    public void theUserChecksTheCheckbox() {
        popUpAdvertisementBannerPage.doNotShowThisAgain();
    }

    @And("the user closes the banner")
    public void theUserClosesTheBanner() {
        
    }

    @Then("the pop-up should not appear in future logins")
    public void thePopupShouldNotAppearInFutureLogins() {
    }

    @When("the user checks the Click here to find out more checkbox")
    public void theUserChecksTheClickHereToFindOutMoreCheckbox() throws InterruptedException {
        popUpAdvertisementBannerPage.clickFindOutMore();
    }

    @Then("the user will be direct to new link to see more detail")
    public void theUserWillBeDirectToNewLinkToSeeMoreDetail() {
        
    }

    @Given("login with account with condition the current date is outside the advertisement schedule")
    public void loginWithAccountWithConditionTheCurrentDateIsOutsideTheAdvertisementSchedule() {
    }

    @Then("the pop-up should not appear")
    public void thePopUpShouldNotAppear() throws InterruptedException {
        Thread.sleep(1000);
        popUpAdvertisementBannerPage.verifyAdvertisementBannerIsNotVisible();
    }

    @Given("login with account with condition the user's company country is not in the targeted list")
    public void loginWithAccountWithConditionTheUserSCompanyCountryIsNotInTheTargetedList() {
        
    }

    @Given("the user saw the popup less than a week ago or a month ago depend on frequency condition")
    public void theUserSawThePopupLessThanAWeekAgoAMonthAgoDependOnFrequencyCondition() {
        
    }

    @And("the frequency is set to once a week or once a month depend on frequency condition")
    public void theFrequencyIsSetTo() {
    }

    @Given("login with account if frequency condition once a week or once a month or schedule or specific country is not met")
    public void loginWithAccountIfFrequencyConditionOnceAWeekOrOnceAMonthOrScheduleOrSpecificCountryIsNotMet() {
    }
}
