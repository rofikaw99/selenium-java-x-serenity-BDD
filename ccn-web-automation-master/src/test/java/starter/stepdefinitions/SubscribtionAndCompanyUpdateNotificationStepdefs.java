package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.api.FWBResharingPage;
import starter.api.SubscribtionAndCompanyUpdateNotificationPage;

public class SubscribtionAndCompanyUpdateNotificationStepdefs {

    @Steps
    SubscribtionAndCompanyUpdateNotificationPage subscribtionAndCompanyUpdateNotificationPage;

    private int waitResponse = 5000;
    private int waitLongResponse = 10000;

    @Then("notifying subscribers about Subscription update with input content type {string} param")
    public void notifying_subscribers_about_Subscription_update(String contentType) throws Exception {
        subscribtionAndCompanyUpdateNotificationPage.getNotification(contentType);
    }
    @And("check the response payload is correct with input {string} and {string}")
    public void check_the_response_payload_is_correct_with_input(String contentType, String eventAction) throws Exception {
        subscribtionAndCompanyUpdateNotificationPage.getEventNotification(contentType, eventAction);
    }
    @Given("user want to update the company")
    public void user_want_to_update_the_company(){

    }
    @Given("user want to update the subscription")
    public void user_want_to_update_the_subscription(){

    }
    @When("trigger new subscription with {string}")
    public void trigger_new_subscription(String priceId){
        subscribtionAndCompanyUpdateNotificationPage.subscribePlan(priceId);

    }
    @When("trigger subscriber info update on user profile {string}")
    public void trigger_subscriber_info_update_on_user_profile_display_name(String displayName){
        subscribtionAndCompanyUpdateNotificationPage.subscribeInfoUpdate(displayName);

    }
    @When("trigger canceled subscriber with {string}")
    public void trigger_canceled_subscribe(String userPlanID){
        subscribtionAndCompanyUpdateNotificationPage.triggerUnsubsExistingPlan(userPlanID);
    }
    @And("trigger company update")
    public void trigger_company_update(){

    }
    @When("check in current queue in support app for {string}")
    public void check_in_current_queue_in_support_app(String contentType){
        subscribtionAndCompanyUpdateNotificationPage.verifyCurrentQueues(contentType);
    }
    @When("trigger remove subscriber with {string} and {string} and {string}")
    public void trigger_remove_subscriber(String userPlanID, String member1, String member2){
        subscribtionAndCompanyUpdateNotificationPage.triggerRemoveSubscriber(userPlanID, member1, member2);

    }
    @When("trigger add new subscriber with {string} and {string}")
    public void trigger_add_new_subscriber(String userPlanID, String member1){
        subscribtionAndCompanyUpdateNotificationPage.triggerAddSubscriber(userPlanID, member1);

    }
    @And("a few moment later check on history queue in support app with {string} input param")
    public void a_few_minutes_later_check_on_history_queue_in_support_app_with_input_param(String documentID) throws Exception {
        subscribtionAndCompanyUpdateNotificationPage.findTheNotificationByDocumentID(documentID);
    }
}
