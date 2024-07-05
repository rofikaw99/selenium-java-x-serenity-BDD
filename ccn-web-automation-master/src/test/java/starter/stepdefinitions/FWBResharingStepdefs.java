package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import starter.api.FWBResharingPage;
import starter.pages.*;
import starter.utlis.Constants;

public class FWBResharingStepdefs {

    @Steps
    FWBResharingPage fwbResharingPage;

    private int waitResponse = 5000;
    private int waitLongResponse = 10000;

    @Given("create {string} doc with {string}")
    public void create_doc(String contentType, String contentName) throws Exception {
        fwbResharingPage.createDoc(contentType, contentName);
    }

    @Given("Check that notification already share to the member within company")
    public void Check_that_notification_already_share_to_the_member_within_company() throws Exception {
        fwbResharingPage.testGetDocument();
    }

    @When("do extended sharing {string}")
    public void do_extended_sharing(String contact) throws Exception {
        fwbResharingPage.testShareDocument(contact);
    }

    @When("do explicit sharing {string}")
    public void do_explicit_sharing(String contact) throws Exception {
        fwbResharingPage.testShareExplicitDocument(contact);
    }

    @Then("make sure that the notification share to the right user")
    public void make_sure_that_the_notification_share_to_the_right_user() throws Exception {
        fwbResharingPage.testGetDocumentShareForm();
    }
    @Then("make sure that the notification share to SATS")
    public void make_sure_that_the_notification_share_to_SATS() throws Exception {
        fwbResharingPage.testGetExplicitDocument();
    }

}
