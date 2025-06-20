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

    @Given("create {string} doc with {string} from system")
    public void create_doc_from_system(String contentType, String contentName) throws Exception {
        fwbResharingPage.createDocFromSystem(contentType, contentName);
    }

    @Given("create {string} doc with {string} for share via")
    public void create_doc_for_share_via(String contentType, String contentName) throws Exception {
        fwbResharingPage.createDocForShareVia(contentType, contentName);
    }

    @Given("create {string} doc with {string} and {string}")
    public void create_doc_for_verify_filter_doc(String contentType, String contentName, String awbNo) throws Exception {
        fwbResharingPage.createDocForVerifyAWBNo(contentType, contentName, awbNo);
    }
    @Given("verify that {string} and {string} document filtering is running well")
    public void verifyDocumentFiltering(String contentType, String awbNo) {
        fwbResharingPage.verifyAWBNumber(contentType, awbNo);
    }
    @And("verify that {string} and {string} the document should appear in the company system")
    public void verifyThe_document_should_appear_in_the_company_system(String contentType, String awbNo) {
        fwbResharingPage.verify_the_document_should_appear_in_the_company_system(contentType, awbNo);
    }
    @And("verify that {string} and {string} another user in the same company should also be able to view the document created")
    public void verifyUser_B_should_also_be_able_to_view_the_document_created(String contentType, String awbNo) {
        fwbResharingPage.verify_another_user_in_the_same_company_should_also_be_able_to_view_the_document_created(contentType, awbNo);
    }
    @Given("validate the pima {string} to sync with chexs")
    public void validateThePimaSyncwithChexs(String pima) throws Exception {
        fwbResharingPage.validatePima(pima);
    }

    @Given("verify company group {string} information")
    public void verifyCompanyGroupInformation(String cubeID) throws Exception {
        fwbResharingPage.companyGroupInformation(cubeID);
    }
    @Given("convert the email body and attachments to JSON format, save the document in the sender's company CUBE {string}")
    public void convert_the_email_body_and_attachments_to_JSON_format(String senderCompanyCubeID) throws Exception {
        fwbResharingPage.emailExchangeDocumentChecking(senderCompanyCubeID);
    }
    @Given("explicit share it with the recipient’s {string} company CUBE")
    public void explicit_share_it_with_the_recipient(String recipientCompanyCubeID) throws Exception {
        fwbResharingPage.emailExchangeDocumentChecking(recipientCompanyCubeID);
    }
    @Given("verify encode all attachments {string} into a single ZIP file for CUBE document creation {string}")
    public void verify_encode_all_attachments_into_a_single_ZIP_file_for_CUBE_document_creation(String recipientCompanyCubeID, String egDocumentID) throws Exception {
        fwbResharingPage.verifyEncodedContent(recipientCompanyCubeID, egDocumentID);
    }
    @Given("create awbNo 1000 times")
    public void create_awb_1000() throws Exception {
        fwbResharingPage.awb1000times();
    }

    @Given("create {string} SS doc with {string} for share via")
    public void create_SSdoc_for_share_via(String contentType, String contentName) throws Exception {
        fwbResharingPage.createDocShipmentStatusForShareVia(contentType, contentName);
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
//        fwbResharingPage.testShareDocument(contact);
    }

    @When("share {string} {string} to airline")
    public void share_via(String via, String contact) throws Exception {
        fwbResharingPage.testShareVia(via, contact);
//        fwbResharingPage.testShareDocument(contact);
    }

    @Then("make sure that the notification share to the right user")
    public void make_sure_that_the_notification_share_to_the_right_user() throws Exception {
        fwbResharingPage.testGetDocumentShareForm();
    }
    @Then("make sure that the notification share to SATS")
    public void make_sure_that_the_notification_share_to_SATS() throws Exception {
        fwbResharingPage.testGetExplicitDocument();
    }

    @Then("verify document succeed share to airline {string} {string} {string}")
    public void verify_document_succeed_share(String via, String contentType, String contentName) throws Exception {
        fwbResharingPage.testGetDocumentShareViaColoader(via, contentType, contentName);
    }

    @Then("verify document failed share to airline")
    public void verify_document_failed_share() throws Exception {
        fwbResharingPage.testGetDocumentShareViaNonColoader();
    }

    @Then("verify no encoded content missing")
    public void verifyNoEncodedContentMissing() {
        fwbResharingPage.testGetDocumentContent();
    }

    @And("update the data after retrieve")
    public void updateTheDataAfterRetrieve() {
        fwbResharingPage.patchDocumentWithLatestData();
    }

    @Given("register {string} sandbox after register in UI")
    public void registerSandboxAfterRegisterInUI(String email) {
        fwbResharingPage.retrieveDBPlatform(email);
    }
}
