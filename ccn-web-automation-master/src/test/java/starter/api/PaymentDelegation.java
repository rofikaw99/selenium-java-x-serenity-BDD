package starter.api;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import starter.payload.payment.PaymentDelegationPayload;
import starter.utlis.ApiProperties;
import starter.utlis.ReadFile;

import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.*;

public class PaymentDelegation {

    String token, cubeId, baseUrl, emailCompany;
    Response response;

    public void setToken(int company) throws IOException {
        if (company == 1) {
            token = ReadFile.tokenCompany1();
            cubeId = ApiProperties.cubeId1();
            emailCompany = ApiProperties.emailCompany2();
        }
        else if (company == 2) {
            token = ReadFile.tokenCompany2();
            cubeId = ApiProperties.cubeId2();
            emailCompany = ApiProperties.emailCompany1();
        }
//        baseUrl = ApiProperties.baseUrlExternal() + cubeId + "/service/" + ApiProperties.paymentServiceId();
        baseUrl = ApiProperties.baseUrlPayment() + cubeId + "/service/" + ApiProperties.paymentServiceId();
    }

    public void retrievePaymentDelegationSetting(){
        String url = baseUrl + "/Payment/1/retrievePaymentDelegationSetting";

        response = given()
                .header("Authorization", "Bearer " + token)
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentDelegationPayload.retrievePaymentDelegation().toString())
                .post(url);

        then().statusCode(200);
    }

    public boolean thereIsNoDelegationSetting(){
        return lastResponse().jsonPath().getList("datas.id").isEmpty();
    }

    public boolean thereIsNoDelegationId(String id){
        return !lastResponse().jsonPath().getList("datas.id").contains(id);
    }

    public void verifyAbleToViewDelegationData(){
        lastResponse().jsonPath().getString("datas");
    }

    public void verifyNewPaymentAppears(String id){
        Assert.assertTrue(lastResponse().jsonPath().getList("datas.paymentRequestId").contains(id));
    }

    public void verifyPaymentStatus(int index, String status){
        Assert.assertEquals(status, lastResponse().jsonPath().getList("datas.status").get(index));
    }

    public void verifyPaymentType(int index, String type){
        Assert.assertEquals(type, lastResponse().jsonPath().getList("datas.type").get(index));
    }

    public void verifyDelegationActiveDate(int index, String activeDate){
        Assert.assertEquals(activeDate, lastResponse().jsonPath().getList("datas.activeDate").get(index));
    }

    public void verifyMessageResponse(String message){
        Assert.assertEquals(message, lastResponse().jsonPath().getString("message"));
    }

    public void getAllSupplier(){
        String url = baseUrl + "/Payment/1/get-all-supplier";

        response = given()
                .header("Authorization", "Bearer " + token)
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body("{}")
                .post(url);
        then().statusCode(200);
    }

    public String productId(int index){
        JSONArray jsonObject = new JSONArray(response.asString());
        return jsonObject.getJSONObject(index).getJSONArray("products").getJSONObject(0).getString("serviceId");
    }

    public String supplierId(int index){
        JSONArray jsonObject = new JSONArray(response.asString());
        return jsonObject.getJSONObject(index).getString("_id");
    }

    public String productName(int index){
        JSONArray jsonObject = new JSONArray(response.asString());
        return jsonObject.getJSONObject(index).getJSONArray("products").getJSONObject(0).getString("serviceProductName");
    }

    public String supplierName(int index){
        JSONArray jsonObject = new JSONArray(response.asString());
        return jsonObject.getJSONObject(index).getString("name");
    }

    public void createPaymentDelegation(String productId, String suppId, int statusCode){
        String url = baseUrl + "/Payment/1/createPaymentDelegationSetting";

        response = given()
                .header("Authorization", "Bearer " + token)
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentDelegationPayload.createPaymentDelegation(emailCompany, productId, suppId))
                .post(url);
        then().statusCode(statusCode);
    }

    public String paymentDelegationId(int index){
        JSONObject resp = new JSONObject(response.asString());
        return resp.getJSONArray("data").getJSONObject(index).getString("id");
    }

    public void deletePaymentDelegation(String id, int statusCode){
        String url = baseUrl + "/Payment/1/deletePaymentDelegationSetting";

        response = given()
                .header("Authorization", "Bearer " + token)
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentDelegationPayload.deletePaymentDelegation(id).toString())
                .post(url);
        then().statusCode(statusCode);
    }
}

