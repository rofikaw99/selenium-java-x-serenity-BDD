package starter.api;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import starter.payload.payment.PaymentOverviewPayload;
import starter.payload.payment.StandingInstructionPayload;
import starter.utlis.ApiProperties;
import starter.utlis.ReadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.serenitybdd.rest.SerenityRest.*;

public class PaymentOverview {

    String token, cubeId, baseUrl, baseUrlPayReq, emailCompany, emailCompany2;
    Response response;

    public void setToken(int company) throws IOException {
        if (company == 1) {
            token = ReadFile.tokenCompany1();
            cubeId = ApiProperties.cubeId1();
        } else if (company == 2) {
            token = ReadFile.tokenCompany2();
            cubeId = ApiProperties.cubeId2();
        }
        emailCompany = ApiProperties.emailCompany1();
        emailCompany2 = ApiProperties.emailCompany2();
        baseUrl = ApiProperties.baseUrlExternal() + cubeId + "/service/" + ApiProperties.paymentServiceId();
        baseUrlPayReq = ApiProperties.baseUrlPayment() + cubeId + "/service/" + ApiProperties.paymentServiceId();
    }

    public void retrievePaymentOverview(String type) {
        String url = baseUrl + "/Payment/1/PaymentRequestOverview";

        response = given()
                .header("Authorization", "Bearer " + token)
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentOverviewPayload.retrievePaymentOverview(type).toString())
                .post(url);
        then().statusCode(200);
    }

    public void retrievePaymentOverview(String type, String status) {
        String url = baseUrl + "/Payment/1/PaymentRequestOverview";

        response = given()
                .header("Authorization", "Bearer " + token)
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentOverviewPayload.retrievePaymentOverview(type, status).toString())
                .post(url);
        then().statusCode(200);
    }

    public List<String> payIds(int indexStart, int indexEnd) {
        List<String> resp = lastResponse().jsonPath().getList("");
        return resp.subList(indexStart, indexEnd);
    }

    public void retrievePaymentRequest(List<String> payIds) {
        String url = baseUrl + "/Payment/1/RetrievePaymentRequest";

        response = given()
                .header("Authorization", "Bearer " + token)
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentOverviewPayload.retrievePaymentRequest(payIds).toString())
                .post(url);
        then().statusCode(200);
    }

    public void verifySelectedPaymentAppears(List<String> payIds){
        Assert.assertTrue(lastResponse().jsonPath().getList("data.paymentRequestId").containsAll(payIds));
    }

    public void verifyPaymentIdAppears(String payId){
        Assert.assertTrue(lastResponse().jsonPath().getList("data.paymentRequestId").contains(payId));
    }

    public void createPaymentRequest(int statusCode){
        String url = baseUrlPayReq + "/Payment/1/CreatePaymentRequest";

        response = given()
                .header("Authorization", "Bearer " + token)
                .header("associate-service-id", ApiProperties.associateServiceId())
                .contentType("application/json")
                .body(PaymentOverviewPayload.createPaymentRequest().toString())
                .post(url);
        then().statusCode(statusCode);
    }

    public void verifySuccessAutoDeduct(){
        Assert.assertTrue(lastResponse().jsonPath().getBoolean("data.status[0]"));
    }

    public void verifyPaymentStatus(String status){
        Assert.assertEquals(status, lastResponse().jsonPath().getString("data.status[0]"));
    }

    public void delegatePaymentRequest(String payId, String emailCompany){
        String url = baseUrl + "/Payment/1/delegatePaymentRequest";

        response = given()
                .header("Authorization", "Bearer " + token)
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentOverviewPayload.delegatePaymentRequest(payId, emailCompany).toString())
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
        Assert.assertEquals(lastResponse().jsonPath().getString("data.delegateTo.email"),  emailCompany2);
    }
}
