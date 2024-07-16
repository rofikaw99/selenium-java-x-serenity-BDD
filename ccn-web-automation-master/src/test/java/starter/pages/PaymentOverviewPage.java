package starter.pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import starter.utlis.Constants;

import java.util.HashMap;
import java.util.Map;

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
    private By bulkOutstanding = By.xpath("(//span[contains(@class, 'cube-checkmark-checkbox') and contains(@class, 'check')])[24]");
    private By bulkChcekout = By.xpath("//button[contains(@class, 'cube-button') and contains(@class, 'cube-default') and contains(@class, 'ml-[80px]')]");
    private By payCheckout = By.xpath("//button[contains(@class, 'cube-button') and contains(@class, 'cube-primary') and contains(@class, '!w-[212px]') and contains(@class, 'ml-[30px]') and contains(@style, 'height: 48px;') and text()='Pay']");
    private By downloadReport = By.xpath("(//div[text()='Download Report'])[1]");
    private By downloadReport2 = By.xpath("//button[text()='Download']");
    private By cookie1 = By.xpath("(//button[@class='cky-btn cky-btn-accept' and @aria-label='Accept All'])[1]");
    private By payNow = By.xpath("//button[@class='cube-button cube-secondary   ']");
    private By payCC = By.xpath("//div[@class='SubmitButton-IconContainer']");
    private By outstandingTextColor = By.xpath("(//td[@class='row-label']/div[contains(text(), 'OUTSTANDING')])[1]");
    private By upcomingTextColor = By.xpath("(//td[@class='row-label']/div[contains(text(), 'UPCOMING')])[1]");
    private By paidTextColor = By.xpath("(//td[@class='row-label']/div[contains(text(), 'PAID')])[1]");
    private By expiredTextColor = By.xpath("(//td[@class='row-label']/div[contains(text(), 'EXPIRED')])[1]");
    private By cancelledTextColor = By.xpath("(//td[@class='row-label']/div[contains(text(), 'CANCELED')])[1]");
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

    public void verifyCancelledColorCode(){
        $(cancelledTextColor).isDisplayed();
        String style = $(cancelledTextColor).getAttribute("style");
        System.out.println("Style attribute of cancelledTextColor: " + style);
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
        evaluateJavascript("arguments[0].click();", $(payCheckout));
    }

    public void downloadReportButton()throws Exception{
        evaluateJavascript("arguments[0].click();", $(downloadReport));
        Thread.sleep(waitResponse);
        evaluateJavascript("arguments[0].click();", $(downloadReport2));
        Thread.sleep(waitResponse);
    }

    public void payForCCCheckoutButton()throws Exception{
        Thread.sleep(waitResponse);
        boolean isDisplayed = $(payCheckout).isDisplayed();
        boolean isEnabled = $(payCheckout).isEnabled();
        System.out.println("pay button is display-enable : " + isDisplayed + " - " + isEnabled);

        if (isDisplayed && isEnabled) {
            System.out.println("pay button is display-enable : "+$(payCheckout).isDisplayed()+" - "+$(payCheckout).isEnabled());
        } else {
            System.out.println("Pay checkout button is not displayed or not enabled.");
        }
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
        String baseURL = "http://172.16.200.223:6969";

        // API endpoint
        String endpoint = "/5a3d543b1dcc447ca293ee63ef120a8f/service/34e0813e-2c7d-4531-9c8b-14e4bdd1ad70/Payment/1/CreatePaymentRequest";

        // Set request headers
        Map<String, String> headers = new HashMap<>();
        headers.put("source-service-id", "353ca99c-3965-4b4d-92f6-1128d407255e");
        headers.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IkwxS2ZLRklfam5YYndXYzIyeFp4dzFzVUhIMCJ9.eyJhdWQiOiJhYTkyMDA1YS02MzcwLTQ4MWItYWExNy1iYmNmNzhjMDgzYTciLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vZTI0YjI4OWEtMzIzYi00YWRkLTg3NjUtYzcxYmFiOGIxOGEzL3YyLjAiLCJpYXQiOjE3MTc0ODg1MzYsIm5iZiI6MTcxNzQ4ODUzNiwiZXhwIjoxNzE3NDkyNDM2LCJhaW8iOiJFMk5nWU1pVXZyNWltdmRUc1VmZkZxVnN2WDhsWjNKcTZGd2hoOFc3dW94NExLdkRVeXdBIiwiYXpwIjoiMmYzNWRkNTUtOWVlMS00YTA3LWE4YWYtNzhlMjEzZTFkNjNiIiwiYXpwYWNyIjoiMSIsIm9pZCI6Ijc3NDYwNzQyLTllYTAtNDNiNS1iMTNhLTY0NzJjNWQxYWMxNyIsInJoIjoiMC5BVDhBbWloTDRqc3kzVXFIWmNjYnE0c1lvMW9Ba3Fwd1l4dElxaGU3ejNqQWc2Y19BQUEuIiwic3ViIjoiNzc0NjA3NDItOWVhMC00M2I1LWIxM2EtNjQ3MmM1ZDFhYzE3IiwidGlkIjoiZTI0YjI4OWEtMzIzYi00YWRkLTg3NjUtYzcxYmFiOGIxOGEzIiwidXRpIjoiWTN6TkVMelBjVTJ1YWNzVnd0Z0VBQSIsInZlciI6IjIuMCJ9.NStfu25W7aePHT95zuNEFnHAmahqhSWtyjhE8vMBLXF-VkodAojk9xRjgesh18ionlemz94d-h0rG5Z-Xlb3cz5OSTabauOLQpIXkwPcBPdly0xxUQVBHhEyYT-ne1bszRWcLy-vRD3RIwQ6SRkIIr8AUqhNC0i6pffBtYseMLsP6QEQqAb1z0nE0zu-pWUiGKpvXJjKk8iu1MTscn9DQjH09KZVoaboeAITSn72TkrYUAhT-wu3HzJI7lqY6TFWoZ7XpmX_DzWdH55-TtvBUCykiA3NI32MmUYfz08gLthljqRUgrzY9NjdEMtrVB4kRP8u3ZSqAhDHEchvjwvoow");
        headers.put("Content-Type", "application/json");

        String payload = "{\n" +
                "    \"externalReferenceId\": \"EXT-" + Constants.FOUR_DIGIT + "\",\n" +
                "    \"reference\": \"TEST-PAYMENT, REF-1241, 1146, 1234, Supp\",\n" +
                "    \"totalChargeAmount\": 470,\n" +
                "    \"currency\": \"SGD\",\n" +
                "    \"status\": \"UPCOMING\",\n" +
                "    \"chargeDateTime\": \"2024-06-19\",\n" +
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
                "    \"paymentMethod\": \"credit_term\" \n" +
                "}";

        // Combine base URL and endpoint
        String url = baseURL + endpoint;

        // Send POST request using REST Assured
        Response response = RestAssured.given()
                .headers("source-service-id", "353ca99c-3965-4b4d-92f6-1128d407255e",
                        "Authorization", accessToken,
                        "Content-Type", ContentType.JSON.toString())
                .body(payload)
                .post(url);
        paymentRequestId = response.jsonPath().getString("paymentRequestId");

        // Print response body
        System.out.println("Response Body: " + paymentRequestId );
    }


    public void createCreditTermPaymentRequestToGetNotification() {
        String baseURL = "http://172.16.200.223:6969";

        // API endpoint
        String endpoint = "/5a3d543b1dcc447ca293ee63ef120a8f/service/34e0813e-2c7d-4531-9c8b-14e4bdd1ad70/Payment/1/CreatePaymentRequest";

        // Set request headers
        Map<String, String> headers = new HashMap<>();
        headers.put("source-service-id", "353ca99c-3965-4b4d-92f6-1128d407255e");
        headers.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IkwxS2ZLRklfam5YYndXYzIyeFp4dzFzVUhIMCJ9.eyJhdWQiOiJhYTkyMDA1YS02MzcwLTQ4MWItYWExNy1iYmNmNzhjMDgzYTciLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vZTI0YjI4OWEtMzIzYi00YWRkLTg3NjUtYzcxYmFiOGIxOGEzL3YyLjAiLCJpYXQiOjE3MTc0ODg1MzYsIm5iZiI6MTcxNzQ4ODUzNiwiZXhwIjoxNzE3NDkyNDM2LCJhaW8iOiJFMk5nWU1pVXZyNWltdmRUc1VmZkZxVnN2WDhsWjNKcTZGd2hoOFc3dW94NExLdkRVeXdBIiwiYXpwIjoiMmYzNWRkNTUtOWVlMS00YTA3LWE4YWYtNzhlMjEzZTFkNjNiIiwiYXpwYWNyIjoiMSIsIm9pZCI6Ijc3NDYwNzQyLTllYTAtNDNiNS1iMTNhLTY0NzJjNWQxYWMxNyIsInJoIjoiMC5BVDhBbWloTDRqc3kzVXFIWmNjYnE0c1lvMW9Ba3Fwd1l4dElxaGU3ejNqQWc2Y19BQUEuIiwic3ViIjoiNzc0NjA3NDItOWVhMC00M2I1LWIxM2EtNjQ3MmM1ZDFhYzE3IiwidGlkIjoiZTI0YjI4OWEtMzIzYi00YWRkLTg3NjUtYzcxYmFiOGIxOGEzIiwidXRpIjoiWTN6TkVMelBjVTJ1YWNzVnd0Z0VBQSIsInZlciI6IjIuMCJ9.NStfu25W7aePHT95zuNEFnHAmahqhSWtyjhE8vMBLXF-VkodAojk9xRjgesh18ionlemz94d-h0rG5Z-Xlb3cz5OSTabauOLQpIXkwPcBPdly0xxUQVBHhEyYT-ne1bszRWcLy-vRD3RIwQ6SRkIIr8AUqhNC0i6pffBtYseMLsP6QEQqAb1z0nE0zu-pWUiGKpvXJjKk8iu1MTscn9DQjH09KZVoaboeAITSn72TkrYUAhT-wu3HzJI7lqY6TFWoZ7XpmX_DzWdH55-TtvBUCykiA3NI32MmUYfz08gLthljqRUgrzY9NjdEMtrVB4kRP8u3ZSqAhDHEchvjwvoow");
        headers.put("Content-Type", "application/json");

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

        // Combine base URL and endpoint
        String url = baseURL + endpoint;

        // Send POST request using REST Assured
        Response response = RestAssured.given()
                .headers("source-service-id", "353ca99c-3965-4b4d-92f6-1128d407255e",
                        "Authorization", accessToken,
                        "Content-Type", ContentType.JSON.toString())
                .body(payload)
                .post(url);
        paymentRequestId = response.jsonPath().getString("paymentRequestId");

        // Print response body
        System.out.println("Response Body: " + paymentRequestId );
    }
        public void createPaymentRequestAPI() {

            String baseURL = "http://172.16.200.223:6969";

            // API endpoint
            String endpoint = "/5a3d543b1dcc447ca293ee63ef120a8f/service/34e0813e-2c7d-4531-9c8b-14e4bdd1ad70/Payment/1/CreatePaymentRequest";

            // Set request headers
            Map<String, String> headers = new HashMap<>();
            headers.put("source-service-id", "353ca99c-3965-4b4d-92f6-1128d407255e");
            headers.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IkwxS2ZLRklfam5YYndXYzIyeFp4dzFzVUhIMCJ9.eyJhdWQiOiJhYTkyMDA1YS02MzcwLTQ4MWItYWExNy1iYmNmNzhjMDgzYTciLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vZTI0YjI4OWEtMzIzYi00YWRkLTg3NjUtYzcxYmFiOGIxOGEzL3YyLjAiLCJpYXQiOjE3MTc0ODg1MzYsIm5iZiI6MTcxNzQ4ODUzNiwiZXhwIjoxNzE3NDkyNDM2LCJhaW8iOiJFMk5nWU1pVXZyNWltdmRUc1VmZkZxVnN2WDhsWjNKcTZGd2hoOFc3dW94NExLdkRVeXdBIiwiYXpwIjoiMmYzNWRkNTUtOWVlMS00YTA3LWE4YWYtNzhlMjEzZTFkNjNiIiwiYXpwYWNyIjoiMSIsIm9pZCI6Ijc3NDYwNzQyLTllYTAtNDNiNS1iMTNhLTY0NzJjNWQxYWMxNyIsInJoIjoiMC5BVDhBbWloTDRqc3kzVXFIWmNjYnE0c1lvMW9Ba3Fwd1l4dElxaGU3ejNqQWc2Y19BQUEuIiwic3ViIjoiNzc0NjA3NDItOWVhMC00M2I1LWIxM2EtNjQ3MmM1ZDFhYzE3IiwidGlkIjoiZTI0YjI4OWEtMzIzYi00YWRkLTg3NjUtYzcxYmFiOGIxOGEzIiwidXRpIjoiWTN6TkVMelBjVTJ1YWNzVnd0Z0VBQSIsInZlciI6IjIuMCJ9.NStfu25W7aePHT95zuNEFnHAmahqhSWtyjhE8vMBLXF-VkodAojk9xRjgesh18ionlemz94d-h0rG5Z-Xlb3cz5OSTabauOLQpIXkwPcBPdly0xxUQVBHhEyYT-ne1bszRWcLy-vRD3RIwQ6SRkIIr8AUqhNC0i6pffBtYseMLsP6QEQqAb1z0nE0zu-pWUiGKpvXJjKk8iu1MTscn9DQjH09KZVoaboeAITSn72TkrYUAhT-wu3HzJI7lqY6TFWoZ7XpmX_DzWdH55-TtvBUCykiA3NI32MmUYfz08gLthljqRUgrzY9NjdEMtrVB4kRP8u3ZSqAhDHEchvjwvoow");
            headers.put("Content-Type", "application/json");

            // Request body
            String requestBody = "{\n" +
                    "    \"externalReferenceId\": \"EXT-145\",\n" +
                    "    \"reference\": \"TEST-PAYMENT, REF-1367, 1146, 1234, Main Supplier\",\n" +
                    "    \"totalChargeAmount\": 40,\n" +
                    "    \"currency\": \"SGD\",\n" +
                    "    \"status\": \"UPCOMING\",\n" +
                    "    \"chargeDateTime\": \"2024-06-19\",\n" +
                    "    \"meta\": {\n" +
                    "        \"items\": [\n" +
                    "            {\n" +
                    "                \"description\": \"item 1 description\",\n" +
                    "                \"amount\": 10\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"description\": \"item 2 description\",\n" +
                    "                \"amount\": 10\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"description\": \"item 3 description\",\n" +
                    "                \"amount\": 10\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"description\": \"item 4 description\",\n" +
                    "                \"amount\": 10\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"notes\": [\n" +
                    "            \"Amount: SGD 40\",\n" +
                    "            \"note: Approved\",\n" +
                    "            \"Booking Date: 24 Feb 2024\",\n" +
                    "            \"AWB: 618-1234566\"\n" +
                    "        ]\n" +
                    "    }\n" +
                    "}";

            // Combine base URL and endpoint
            String url = baseURL + endpoint;

            // Send POST request using REST Assured
            Response response = RestAssured.given()
                    .headers("source-service-id", "353ca99c-3965-4b4d-92f6-1128d407255e",
                            "Authorization", accessToken,
                            "Content-Type", ContentType.JSON.toString())
                    .body(requestBody)
                    .post(url);
            paymentRequestId = response.jsonPath().getString("paymentRequestId");

            // Print response body
            System.out.println("Response Body: " + paymentRequestId );
        }

    public void updatePaymentRequest(String status, String paymentRequestId){
        String baseURL = "http://172.16.200.223:6969";

        // API endpoint
        String endpoint = "/5a3d543b1dcc447ca293ee63ef120a8f/service/34e0813e-2c7d-4531-9c8b-14e4bdd1ad70/Payment/1/CreatePaymentRequest";

        // Set request headers
        Map<String, String> headers = new HashMap<>();
        headers.put("source-service-id", "353ca99c-3965-4b4d-92f6-1128d407255e");
        headers.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IkwxS2ZLRklfam5YYndXYzIyeFp4dzFzVUhIMCJ9.eyJhdWQiOiJhYTkyMDA1YS02MzcwLTQ4MWItYWExNy1iYmNmNzhjMDgzYTciLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vZTI0YjI4OWEtMzIzYi00YWRkLTg3NjUtYzcxYmFiOGIxOGEzL3YyLjAiLCJpYXQiOjE3MTc0ODg1MzYsIm5iZiI6MTcxNzQ4ODUzNiwiZXhwIjoxNzE3NDkyNDM2LCJhaW8iOiJFMk5nWU1pVXZyNWltdmRUc1VmZkZxVnN2WDhsWjNKcTZGd2hoOFc3dW94NExLdkRVeXdBIiwiYXpwIjoiMmYzNWRkNTUtOWVlMS00YTA3LWE4YWYtNzhlMjEzZTFkNjNiIiwiYXpwYWNyIjoiMSIsIm9pZCI6Ijc3NDYwNzQyLTllYTAtNDNiNS1iMTNhLTY0NzJjNWQxYWMxNyIsInJoIjoiMC5BVDhBbWloTDRqc3kzVXFIWmNjYnE0c1lvMW9Ba3Fwd1l4dElxaGU3ejNqQWc2Y19BQUEuIiwic3ViIjoiNzc0NjA3NDItOWVhMC00M2I1LWIxM2EtNjQ3MmM1ZDFhYzE3IiwidGlkIjoiZTI0YjI4OWEtMzIzYi00YWRkLTg3NjUtYzcxYmFiOGIxOGEzIiwidXRpIjoiWTN6TkVMelBjVTJ1YWNzVnd0Z0VBQSIsInZlciI6IjIuMCJ9.NStfu25W7aePHT95zuNEFnHAmahqhSWtyjhE8vMBLXF-VkodAojk9xRjgesh18ionlemz94d-h0rG5Z-Xlb3cz5OSTabauOLQpIXkwPcBPdly0xxUQVBHhEyYT-ne1bszRWcLy-vRD3RIwQ6SRkIIr8AUqhNC0i6pffBtYseMLsP6QEQqAb1z0nE0zu-pWUiGKpvXJjKk8iu1MTscn9DQjH09KZVoaboeAITSn72TkrYUAhT-wu3HzJI7lqY6TFWoZ7XpmX_DzWdH55-TtvBUCykiA3NI32MmUYfz08gLthljqRUgrzY9NjdEMtrVB4kRP8u3ZSqAhDHEchvjwvoow");
        headers.put("Content-Type", "application/json");

        String payload = "{\n" +
                "    \"paymentRequestId\": \"" + paymentRequestId + "\",\n" +
                "    \"status\": \"" + status + "\"\n" +
                "}";

        // Combine base URL and endpoint
        String url = baseURL + endpoint;

        // Send POST request using REST Assured
        Response response = RestAssured.given()
                .headers("source-service-id", "353ca99c-3965-4b4d-92f6-1128d407255e",
                        "Authorization", accessToken,
                        "Content-Type", ContentType.JSON.toString())
                .body(payload)
                .post(url);
        paymentRequestId = response.jsonPath().getString("paymentRequestId");

        // Print response body
        System.out.println("Response Body: " + paymentRequestId );
    }

    public void updatePaymentRequestToNotify(String status){
        String baseURL = "http://172.16.200.223:6969";

        // API endpoint
        String endpoint = "/5a3d543b1dcc447ca293ee63ef120a8f/service/34e0813e-2c7d-4531-9c8b-14e4bdd1ad70/Payment/1/CreatePaymentRequest";

        // Set request headers
        Map<String, String> headers = new HashMap<>();
        headers.put("source-service-id", "353ca99c-3965-4b4d-92f6-1128d407255e");
        headers.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IkwxS2ZLRklfam5YYndXYzIyeFp4dzFzVUhIMCJ9.eyJhdWQiOiJhYTkyMDA1YS02MzcwLTQ4MWItYWExNy1iYmNmNzhjMDgzYTciLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vZTI0YjI4OWEtMzIzYi00YWRkLTg3NjUtYzcxYmFiOGIxOGEzL3YyLjAiLCJpYXQiOjE3MTc0ODg1MzYsIm5iZiI6MTcxNzQ4ODUzNiwiZXhwIjoxNzE3NDkyNDM2LCJhaW8iOiJFMk5nWU1pVXZyNWltdmRUc1VmZkZxVnN2WDhsWjNKcTZGd2hoOFc3dW94NExLdkRVeXdBIiwiYXpwIjoiMmYzNWRkNTUtOWVlMS00YTA3LWE4YWYtNzhlMjEzZTFkNjNiIiwiYXpwYWNyIjoiMSIsIm9pZCI6Ijc3NDYwNzQyLTllYTAtNDNiNS1iMTNhLTY0NzJjNWQxYWMxNyIsInJoIjoiMC5BVDhBbWloTDRqc3kzVXFIWmNjYnE0c1lvMW9Ba3Fwd1l4dElxaGU3ejNqQWc2Y19BQUEuIiwic3ViIjoiNzc0NjA3NDItOWVhMC00M2I1LWIxM2EtNjQ3MmM1ZDFhYzE3IiwidGlkIjoiZTI0YjI4OWEtMzIzYi00YWRkLTg3NjUtYzcxYmFiOGIxOGEzIiwidXRpIjoiWTN6TkVMelBjVTJ1YWNzVnd0Z0VBQSIsInZlciI6IjIuMCJ9.NStfu25W7aePHT95zuNEFnHAmahqhSWtyjhE8vMBLXF-VkodAojk9xRjgesh18ionlemz94d-h0rG5Z-Xlb3cz5OSTabauOLQpIXkwPcBPdly0xxUQVBHhEyYT-ne1bszRWcLy-vRD3RIwQ6SRkIIr8AUqhNC0i6pffBtYseMLsP6QEQqAb1z0nE0zu-pWUiGKpvXJjKk8iu1MTscn9DQjH09KZVoaboeAITSn72TkrYUAhT-wu3HzJI7lqY6TFWoZ7XpmX_DzWdH55-TtvBUCykiA3NI32MmUYfz08gLthljqRUgrzY9NjdEMtrVB4kRP8u3ZSqAhDHEchvjwvoow");
        headers.put("Content-Type", "application/json");

        String payload = "{\n" +
                "    \"paymentRequestId\": \"" + paymentRequestId + "\",\n" +
                "    \"status\": \"" + status + "\"\n" +
                "}";

        // Combine base URL and endpoint
        String url = baseURL + endpoint;

        // Send POST request using REST Assured
        Response response = RestAssured.given()
                .headers("source-service-id", "353ca99c-3965-4b4d-92f6-1128d407255e",
                        "Authorization", accessToken,
                        "Content-Type", ContentType.JSON.toString())
                .body(payload)
                .post(url);
        paymentRequestId = response.jsonPath().getString("paymentRequestId");

        // Print response body
        System.out.println("Response Body: " + paymentRequestId );
    }




}
