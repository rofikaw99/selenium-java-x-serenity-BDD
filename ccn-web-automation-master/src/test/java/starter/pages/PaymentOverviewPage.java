package starter.pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import starter.utlis.Constants;

import static net.serenitybdd.rest.SerenityRest.*;

public class PaymentOverviewPage extends PageObject {

    private int waitResponse = 3000;
    WebDriver driver;

    //Payment Overview Page

    private By reference = By.id("cube-sort-reference");
    private By requestDate = By.id("cube-sort-request_date");
    private By supplier = By.id("cube-sort-supplier");
    private By lastUpdated = By.id("cube-sort-last_updated");
    private By paymentMethod = By.id("cube-sort-payment_method");
    private By paymentBy = By.id("cube-sort-payment_by");
    private By total = By.id("cube-sort-total");
    private By status = By.id("cube-sort-status");
    private By inputKeywordField = By.xpath("//*[@class='cube-search']//input[@placeholder='Search by...']");
    private By checkoutButton = By.xpath("(//div[contains(@class, 'cube-btn-flex')]//button[contains(@class, 'cube-button') and contains(@class, 'cube-default') and contains(@class, 'undefined')])[1]");
    private By bulkOutstanding = By.xpath("(//span[contains(@class, 'cube-checkmark-checkbox') and contains(@class, 'check')])[23]");
    private By bulkChcekout = By.xpath("//button[contains(@class, 'cube-button') and contains(@class, 'cube-default') and contains(@class, 'ml-[80px]')]");
    private By payCheckout = By.xpath("//button[contains(@class, 'cube-button') and contains(@class, 'cube-primary') and contains(@class, '!w-[212px]') and contains(@class, 'ml-[30px]') and contains(@style, 'height: 48px;') and text()='Pay']");
    private By cookie1 = By.xpath("(//button[@class='cky-btn cky-btn-accept' and @aria-label='Accept All'])[1]");
    private By payNow = By.xpath("//button[@class='cube-button cube-secondary   ']");
    private By payCC = By.xpath("//div[@class='SubmitButton-IconContainer']");
    private By outstandingTextColor = By.xpath("(//td[@class='row-label']/div[contains(text(), 'OUTSTANDING')])[1]");
    private By upcomingTextColor = By.xpath("(//td[@class='row-label']/div[contains(text(), 'UPCOMING')])[1]");
    private By paidTextColor = By.xpath("(//td[@class='row-label']/div[contains(text(), 'PAID')])[1]");
    private By expiredTextColor = By.xpath("(//td[@class='row-label']/div[contains(text(), 'EXPIRED')])[1]");
    private By gotoDetailPayments = By.xpath("(//div[contains(@class, 'text-') and contains(@class, 'font-') and contains(@class, 'cursor-pointer')])[1]");
    private By requestDateInfo = By.xpath("(//p)[12]");
    private By supplierInfo = By.xpath("(//p)[13]");
    private By statusInfo = By.xpath("(//p)[16]");

    private By notFoundOverview = By.xpath("//div[@class=\"w-full top-0 flex items-center justify-center my-14\"]");

    public boolean referenceIsDisplayed(){
        return $(reference).isDisplayed();
    }
    public boolean noDataFound(){
        return $(notFoundOverview).isDisplayed();
    }
    public boolean requestDateIsDisplayed(){
        return $(requestDate).isDisplayed();
    }
    public boolean supplierIsDisplayed(){
        return $(supplier).isDisplayed();
    }
    public boolean lastUpdatedIsDisplayed(){
        return $(lastUpdated).isDisplayed();
    }
    public boolean paymentMethodIsDisplayed(){
        return $(paymentMethod).isDisplayed();
    }
    public boolean paymentByIsDisplayed(){
        return $(paymentBy).isDisplayed();
    }
    public boolean totalIsDisplayed(){
        return $(total).isDisplayed();
    }
    public boolean statusIsDisplayed(){
        return $(status).isDisplayed();
    }

    public boolean checkoutUnable(){
        return $(checkoutButton).isDisabled();
    }
    public void inputKeyword(String keyword){
        $(inputKeywordField).waitUntilVisible();
        $(inputKeywordField).clear();
        $(inputKeywordField).sendKeys(keyword);
    }

    public void findPayment(String keyword){
        $(inputKeywordField).waitUntilVisible();
        $(inputKeywordField).clear();
        $(inputKeywordField).sendKeys(keyword + Constants.FOUR_DIGIT);
    }

    public void verifyOutstandingColorCode(){
        $(outstandingTextColor).isDisplayed();
        String style = $(outstandingTextColor).getAttribute("style");
        System.out.println("Style attribute of oustandingTextColor: " + style);
    }

    public void verifyPaidColorCode(){
        $(paidTextColor).isDisplayed();
        String style = $(paidTextColor).getAttribute("style");
        System.out.println("Style attribute of oustandingTextColor: " + style);
    }

    public void verifyExpiredColorCode(){
        $(expiredTextColor).isDisplayed();
        String style = $(expiredTextColor).getAttribute("style");
        System.out.println("Style attribute of oustandingTextColor: " + style);
    }

    public void verifyUpcomingColorCode(){
        $(upcomingTextColor).isDisplayed();
        String style = $(upcomingTextColor).getAttribute("style");
        System.out.println("Style attribute of oustandingTextColor: " + style);
    }

    public void verifyAndClickCheckoutButton() throws Exception{
        Thread.sleep(waitResponse);
        System.out.println("checkout button is display-enable : "+$(checkoutButton).isDisplayed()+" - "+$(checkoutButton).isEnabled());
        evaluateJavascript("arguments[0].click();", $(checkoutButton));
    }

    public void bulkOutstanding()throws Exception{
        Thread.sleep(waitResponse);
        System.out.println("bulk outstanding button is display-enable : "+$(bulkOutstanding).isDisplayed()+" - "+$(bulkOutstanding).isEnabled());
        evaluateJavascript("arguments[0].click();", $(bulkOutstanding));
    }

    public void bulkCheckout()throws Exception{
        Thread.sleep(waitResponse);
        System.out.println("checkout button is display-enable : "+$(bulkChcekout).isDisplayed()+" - "+$(bulkChcekout).isEnabled());
        evaluateJavascript("arguments[0].click();", $(bulkChcekout));
    }

    public void scrollUntilElementVisible(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void payCheckoutButton()throws Exception{
        Thread.sleep(waitResponse);
        System.out.println("pay button is display-enable : "+$(payCheckout).isDisplayed()+" - "+$(payCheckout).isEnabled());
        evaluateJavascript("arguments[0].click();", $(payCheckout));
    }

    public void payForCCCheckoutButton()throws Exception{
        Thread.sleep(waitResponse);
        System.out.println("pay button is display-enable : "+$(payCheckout).isDisplayed()+" - "+$(payCheckout).isEnabled());
    }
    public void scrollToElement(By element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", find(element));
    }

    public void payNow()throws Exception{
        Thread.sleep(waitResponse);
        System.out.println("cookie button is display-enable : "+$(payNow).isDisplayed()+" - "+$(payNow).isEnabled());
        evaluateJavascript("arguments[0].click();", $(payNow));
    }

    public void payCC(){
        $(payCC).isDisplayed();
        $(payCC).click();
    }

    public void goToPaymentDetail()throws Exception{
        Thread.sleep(waitResponse);
        System.out.println("cookie button is display-enable : "+$(gotoDetailPayments).isDisplayed()+" - "+$(gotoDetailPayments).isEnabled());
        evaluateJavascript("arguments[0].click();", $(gotoDetailPayments));
    }

    public void paymentDetailInfo(){
        $(requestDateInfo).isDisplayed();
        $(supplierInfo).isDisplayed();
        $(statusInfo).isDisplayed();
        System.out.println(requestDate);
        System.out.println(supplierInfo);
        System.out.println(statusInfo);
    }

    public void cek2(){
        String url = "https://reqres.in/api/users?page=2";
        given().when().get(url);
        System.out.println("response of api " + lastResponse().path("data"));
    }

    public void cek(){
        // then() -> method untuk melakukan verifikasi atau pengecekan terhadap
        // response yang dihasilkan
        // method then digunakan untuk memverifikasi response yg dikembalikan
        then().statusCode(200);
    }

    private static String accessToken;

    private String paymentRequestId;

    public static void main(String[] args) {
        fetchAccessToken();
        System.out.println("Access Token: " + accessToken);
    }

    public static void fetchAccessToken() {
        Response response = RestAssured.given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Cookie", "fpc=AvtAb5bVFpRMgmodPHJEYoWc2pdeAgAAAO0Tzd0OAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd")
                .formParam("grant_type", "client_credentials")
                .formParam("scope", "https://ccnssoppd.onmicrosoft.com/CUBE_CORE_SITE_1/.default")
                .formParam("client_id", "2f35dd55-9ee1-4a07-a8af-78e213e1d63b")
                .formParam("client_secret", "ShT8Q~Oyu5kcsGA2p~_vTR6ZIhWTg3S4hhxrea0_")
                .when().post("https://login.microsoftonline.com/ccnssoppd.onmicrosoft.com/oauth2/v2.0/token");

        accessToken = response.jsonPath().getString("access_token");
    }

    public void createCreditTermPaymentRequest() {
        String payload = "{\n" +
                "    \"externalReferenceId\": \"EXT-" + Constants.FOUR_DIGIT + "\",\n" +
                "    \"reference\": \"REF-" + Constants.FOUR_DIGIT + "\",\n" +
                "    \"totalChargeAmount\": 470,\n" +
                "    \"currency\": \"SGD\",\n" +
                "    \"meta\": {\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"description\": \"Arm, Ammunition, & Explosives (Strong Room Storage)\",\n" +
                "                \"amount\": 100\n" +
                "            },\n" +
                "            {\n" +
                "                \"description\": \"Valuable Cargo (Strong Room Storage)\",\n" +
                "                \"amount\": 80\n" +
                "            },\n" +
                "            {\n" +
                "                \"description\": \"Export Perishables Storage\",\n" +
                "                \"amount\": 90\n" +
                "            },\n" +
                "            {\n" +
                "                \"description\": \"Administrative Charge for Return Cargo\",\n" +
                "                \"amount\": 200\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"paymentMethod\": \"credit_terms\" \n" +
                "}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + accessToken)
                .body(payload)
                .post("http://cube.sandbox.ccn/9af033381cea4417af7b0821c82101e5/service/34e0813e-2c7d-4531-9c8b-14e4bdd1ad70/Payment/1/CreatePaymentRequest");

        paymentRequestId = response.jsonPath().getString("paymentRequestId");

        System.out.println("REF-" + Constants.FOUR_DIGIT);
        System.out.println("Payment Request ID: " + paymentRequestId);
    }


    public void createCreditTermPaymentRequestToGetNotification() {
        String payload = "{\n" +
                "    \"externalReferenceId\": \"EXT-" + Constants.FOUR_DIGIT + "\",\n" +
                "    \"reference\": \"REF-" + Constants.FOUR_DIGIT + "\",\n" +
                "    \"totalChargeAmount\": 470,\n" +
                "    \"currency\": \"SGD\",\n" +
                "    \"status\": \"READY\",\n" +
                "    \"meta\": {\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"description\": \"Arm, Ammunition, & Explosives (Strong Room Storage)\",\n" +
                "                \"amount\": 100\n" +
                "            },\n" +
                "            {\n" +
                "                \"description\": \"Valuable Cargo (Strong Room Storage)\",\n" +
                "                \"amount\": 80\n" +
                "            },\n" +
                "            {\n" +
                "                \"description\": \"Export Perishables Storage\",\n" +
                "                \"amount\": 90\n" +
                "            },\n" +
                "            {\n" +
                "                \"description\": \"Administrative Charge for Return Cargo\",\n" +
                "                \"amount\": 200\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"paymentMethod\": \"credit_terms\" \n" +
                "}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + accessToken)
                .body(payload)
                .post("http://cube.sandbox.ccn/9af033381cea4417af7b0821c82101e5/service/34e0813e-2c7d-4531-9c8b-14e4bdd1ad70/Payment/1/CreatePaymentRequest");

        paymentRequestId = response.jsonPath().getString("paymentRequestId");

        System.out.println("REF-" + Constants.FOUR_DIGIT);
        System.out.println("Payment Request ID: " + paymentRequestId);
    }

    public void createPaymentRequest() {
        String payload = "{\n" +
                "    \"externalReferenceId\": \"EXT-" + Constants.FOUR_DIGIT + "\",\n" +
                "    \"reference\": \"TEST-PAYMENT, REF-1234, 1146, 1234, Headquarter SQ Company\",\n" +
                "    \"totalChargeAmount\": 470,\n" +
                "    \"currency\": \"SGD\",\n" +
                "    \"status\": \"UPCOMING\",\n" +
                "    \"meta\": {\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"description\": \"Arm, Ammunition, & Explosives (Strong Room Storage)\",\n" +
                "                \"amount\": 100\n" +
                "            },\n" +
                "            {\n" +
                "                \"description\": \"Valuable Cargo (Strong Room Storage)\",\n" +
                "                \"amount\": 80\n" +
                "            },\n" +
                "            {\n" +
                "                \"description\": \"Export Perishables Storage\",\n" +
                "                \"amount\": 90\n" +
                "            },\n" +
                "            {\n" +
                "                \"description\": \"Administrative Charge for Return Cargo\",\n" +
                "                \"amount\": 200\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + accessToken)
                .body(payload)
                .post("http://cube.sandbox.ccn/9af033381cea4417af7b0821c82101e5/service/34e0813e-2c7d-4531-9c8b-14e4bdd1ad70/Payment/1/CreatePaymentRequest");

        paymentRequestId = response.jsonPath().getString("paymentRequestId");
        System.out.println("REF-" + Constants.FOUR_DIGIT);
        System.out.println("Payment Request ID: " + paymentRequestId);
    }

    public void updatePaymentRequest(String status, String paymentRequestId){
        String payload = "{\n" +
                "    \"paymentRequestId\": \"" + paymentRequestId + "\",\n" +
                "    \"status\": \"" + status + "\"\n" +
                "}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + accessToken)
                .body(payload)
                .post("http://cube.sandbox.ccn/9af033381cea4417af7b0821c82101e5/service/34e0813e-2c7d-4531-9c8b-14e4bdd1ad70/Payment/1/UpdatePaymentRequest");

        System.out.println("Status code: " + response.getStatusCode());
//        Assert.assertEquals("Status code not as acpected", 200, response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
    }

    public void updatePaymentRequestToNotify(String status){
        String payload = "{\n" +
                "    \"paymentRequestId\": \"" + paymentRequestId + "\",\n" +
                "    \"status\": \"" + status + "\"\n" +
                "}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + accessToken)
                .body(payload)
                .post("http://cube.sandbox.ccn/9af033381cea4417af7b0821c82101e5/service/34e0813e-2c7d-4531-9c8b-14e4bdd1ad70/Payment/1/UpdatePaymentRequest");

        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
    }




}
