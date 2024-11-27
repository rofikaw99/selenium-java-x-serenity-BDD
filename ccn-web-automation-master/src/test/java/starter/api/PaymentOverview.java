package starter.api;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import starter.payload.payment.PaymentOverviewPayload;
import starter.utlis.ApiProperties;
import starter.utlis.ReadFile;

import java.io.IOException;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.*;

public class PaymentOverview {

    String token, cubeId, baseUrl, baseUrlPayReq, emailCompany, emailCompany2;
    Response response;

    public void setToken(int company) throws IOException {
        if (company == 1) {
            cubeId = ApiProperties.cubeId1();
        } else if (company == 2) {
            cubeId = ApiProperties.cubeId2();
        } else if (company == 3){
            cubeId = ApiProperties.cubeId3();
        }
        emailCompany = ApiProperties.emailCompany1();
        emailCompany2 = ApiProperties.emailCompany2();
        baseUrl = ApiProperties.baseUrlExternal() + cubeId + "/service/" + ApiProperties.paymentServiceId();
        baseUrlPayReq = ApiProperties.baseUrlPayment() + cubeId + "/service/" + ApiProperties.paymentServiceId();
    }

    public void retrievePaymentOverview(String type, JSONObject filters) {
        String url = baseUrlPayReq + "/Payment/1/PaymentRequestOverview";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentOverviewPayload.retrievePaymentOverview(type, filters).toString())
                .post(url);
        then().statusCode(200);
    }

    public void retrievePaymentOverview(String type, int pagination) {
        String url = baseUrlPayReq + "/Payment/1/PaymentRequestOverview";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentOverviewPayload.retrievePaymentOverview(type, pagination).toString())
                .post(url);
        then().statusCode(200);
    }

    public void retrievePaymentOverview(String type, String status) {
        String url = baseUrlPayReq + "/Payment/1/PaymentRequestOverview";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentOverviewPayload.retrievePaymentOverview(type, status).toString())
                .post(url);
        then().statusCode(200);
    }

    public int payIdNumber(){
        return lastResponse().jsonPath().getList("data.paymentRequestId").size();
    }

    public List<String> payIds(int indexStart, int indexEnd) {
        List<String> resp = lastResponse().jsonPath().getList("data.paymentRequestId");
        return resp.subList(indexStart, indexEnd);
    }

    public Object amount(){
        return lastResponse().jsonPath().getList("totalChargeAmount").get(0);
    }

    public String payId(){
        return lastResponse().jsonPath().getString("paymentRequestId");
    }

    public String suppId(){
        return (String) lastResponse().jsonPath().getList("supplier.id").get(0);
    }

    public void retrievePaymentRequest(List<String> payIds) {
        String url = baseUrlPayReq + "/Payment/1/RetrievePaymentRequest";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentOverviewPayload.retrievePaymentRequest(payIds).toString())
                .post(url);
        then().statusCode(200);
    }

    public void verifyNotesAppears(){
        Assert.assertTrue(lastResponse().jsonPath().getString("notes").contains("AWB Number: 909090"));
    }

    public void verifySelectedPaymentAppears(List<String> payIds){
        Assert.assertTrue(lastResponse().jsonPath().getList("data.paymentRequestId").containsAll(payIds));
    }

    public void verifyPaymentIdAppears(String payId){
        Assert.assertTrue(lastResponse().jsonPath().getList("data.paymentRequestId").contains(payId));
    }

    public void createPaymentRequest(String product, int statusCode){
        String url = baseUrlPayReq + "/Payment/1/CreatePaymentRequest";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey(product))
                .contentType("application/json")
                .body(PaymentOverviewPayload.createPaymentRequest(product).toString())
                .post(url);
        then().statusCode(statusCode);
    }

    public void createPaymentRequest(int amount, String chargeDateTime, String deductionDate, String expiredDate, String notes, int statusCode){
        String url = baseUrlPayReq + "/Payment/1/CreatePaymentRequest";
        String product = "svs";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey(product))
                .contentType("application/json")
                .body(PaymentOverviewPayload.createPaymentRequest(product, amount, chargeDateTime, deductionDate, expiredDate, notes).toString())
                .post(url);
        then().statusCode(statusCode);
    }

    public void updatePaymentRequest(String payId, String status, int statusCode){
        String url = baseUrlPayReq + "/Payment/1/UpdatePaymentRequest";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("svs"))
                .contentType("application/json")
                .body(PaymentOverviewPayload.updatePaymentRequest(payId, status).toString())
                .post(url);
        then().statusCode(statusCode);
    }

    public void updatePaymentRequest(String payId, String notes){
        String url = baseUrlPayReq + "/Payment/1/UpdatePaymentRequest";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("svs"))
                .contentType("application/json")
                .body(PaymentOverviewPayload.updatePaymentRequest(payId, "", notes).toString())
                .post(url);
        then().statusCode(200);
    }

    public void verifySuccessAutoDeduct(){
        Assert.assertTrue(lastResponse().jsonPath().getBoolean("data.status[0]"));
    }

    public void verifyPaymentStatus(String status){
        Assert.assertEquals(status, lastResponse().jsonPath().getList("data.status").get(0));
    }

    public void verifyPaymentStatusInPaymentRequest(String status){
        Assert.assertEquals(status.toLowerCase(), String.valueOf(lastResponse().jsonPath().getList("status").get(0)).toLowerCase());
    }

    public void verifyPaymentStatusInPaymentRequest(String status, int index){
        Assert.assertEquals(status.toLowerCase(), String.valueOf(lastResponse().jsonPath().getList("status").get(index)).toLowerCase());
    }

    public void verifyPaymentRequestNull(){
        Assert.assertTrue(lastResponse().jsonPath().getList("status").isEmpty());
    }

    public void verifyPaymentByInPaymentRequest(String paymentBy){
        Assert.assertEquals(paymentBy, lastResponse().jsonPath().getList("paymentBy").get(0));
    }

    public void verifyIsAutoDeductInPaymentRequest(String isAutoDeduct){
        Assert.assertEquals(Boolean.parseBoolean(isAutoDeduct), lastResponse().jsonPath().getList("isAutoDeduct").get(0));
    }

    public void verifyPaymentExpiredDate(String expDate){
        Assert.assertTrue(lastResponse().jsonPath().getString("data.expiredDate[0]").contains(expDate));
    }

    public void verifyPaymentStatusInRetrievePayReq(String status){
        Assert.assertEquals(status, lastResponse().jsonPath().getString("status"));
    }

    public String paymentStatus(){
        return lastResponse().jsonPath().getString("status");
    }

    public void delegatePaymentRequest(String payId, String emailCompany, String companyName){
        String url = baseUrlPayReq + "/Payment/1/delegatePaymentRequest";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentOverviewPayload.delegatePaymentRequest(payId, emailCompany, companyName).toString())
                .post(url);
        then().statusCode(200);
    }

    public void delegatePaymentRequest(List<JSONObject> paymentRequests){
        String url = baseUrlPayReq + "/Payment/1/delegatePaymentRequest";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentOverviewPayload.delegatePaymentRequest(paymentRequests).toString())
                .post(url);
        then().statusCode(200);
    }

    public void verifyDelegateFromCompany(){
        Assert.assertTrue(lastResponse().jsonPath().getString("data.delegateFrom.companyName").contains("Auto QA Company"));
    }

    public void verifyDelegateToCompanyInList(){
        Assert.assertTrue(lastResponse().jsonPath().getString("data.delegateTo.companyName").contains("SG Auto QA"));
    }

    public void verifyDelegateToCompany(){
        Assert.assertEquals(lastResponse().jsonPath().getList("paymentDelegation.delegateTo.companyEmail"),  List.of(ApiProperties.emailCompany3()));
    }

    public void verifyDelegateToCompany(String companyEmail){
        System.out.println("response:" + lastResponse().jsonPath().getString("paymentDelegation.delegateTo.companyEmail"));
        System.out.println("expected: " + List.of(companyEmail));
        if (companyEmail.isEmpty()) {
            Assert.assertNull(lastResponse().jsonPath().getList("paymentDelegation.delegateTo.companyEmail").get(0));
        } else {
            Assert.assertTrue(lastResponse().jsonPath().getString("paymentDelegation.delegateTo.companyEmail").contains(String.valueOf(List.of(companyEmail))));
        }
    }

    public void createCheckoutSession(List<JSONObject> paymentRequests){
        String url = baseUrlPayReq + "/Payment/1/createCheckoutSession";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentOverviewPayload.createCheckoutSession(paymentRequests).toString())
                .post(url);
        then().statusCode(200);
    }

    public void createPaymentRecord(String payId, Object amount, int statusCode){
        String url = baseUrlPayReq + "/Payment/1/createPaymentRequestRecord";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("svs"))
                .contentType("application/json")
                .body(PaymentOverviewPayload.createPaymentRequestRecord(payId, amount).toString())
                .post(url);
        then().statusCode(statusCode);
    }

    public void verifyMessageBody(String message){
        Assert.assertEquals(message, lastResponse().jsonPath().getString("message"));
    }

    public void verifyErrorMessageBody(String message){
        Assert.assertEquals(message, lastResponse().jsonPath().getString("error.message"));
    }

    public void verifyExpiredDate(String date){
        System.out.println(lastResponse().jsonPath().getList("expiredDateTime"));
        Assert.assertTrue(String.valueOf(lastResponse().jsonPath().getList("expiredDateTime").get(0)).contains(date));
    }

    public void verifyErrorMessageContains(String message){
        Assert.assertTrue(lastResponse().jsonPath().getString("error.message").contains(message));
    }

    public void verifyPaymentReqIdInCreatePayRecord(String payId){
        Assert.assertEquals(payId, lastResponse().jsonPath().getString("data.paymentRequestId"));
    }

    public void removePaymentDelegationRequest(List<String> paymentReqIds){
        String url = baseUrlPayReq + "/Payment/1/deleteDelegatePaymentRequest";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentOverviewPayload.removePaymentDelegation(paymentReqIds).toString())
                .post(url);
        then().statusCode(200);
    }
}
