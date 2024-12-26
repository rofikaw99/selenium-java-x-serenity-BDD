package starter.api;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import starter.payload.payment.PaymentDelegationPayload;
import starter.utlis.ApiProperties;
import starter.utlis.Common;
import starter.utlis.ReadFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static net.serenitybdd.rest.SerenityRest.*;

public class PaymentDelegation {

    String cubeId, baseUrl, emailCompany;
    Response response;

    public void setToken(int company) {
        cubeId = ApiProperties.cubeId(company);
        emailCompany = ApiProperties.emailCompany(company);
        baseUrl = ApiProperties.baseUrlPayment() + cubeId + "/service/" + ApiProperties.paymentServiceId();
    }

    public void retrievePaymentDelegationSetting(int pagination, int page){
        String url = baseUrl + "/Payment/1/retrievePaymentDelegationSetting";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentDelegationPayload.retrievePaymentDelegation(pagination, page).toString())
                .post(url);

        then().statusCode(200);
    }

    public void retrievePaymentDelegationSetting(String column, String order){
        String url = baseUrl + "/Payment/1/retrievePaymentDelegationSetting";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentDelegationPayload.retrievePaymentDelegation(column, order).toString())
                .post(url);

        then().statusCode(200);
    }

    public void retrievePaymentDelegationSetting(){
        String url = baseUrl + "/Payment/1/retrievePaymentDelegationSetting";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentDelegationPayload.retrievePaymentDelegation(10, 1).toString())
                .post(url);

        then().statusCode(200);
    }

    public void verifyThereIsRequiredData(){
        JSONObject resp = new JSONObject(response.asString());
        resp = resp.getJSONArray("data").getJSONObject(0);
        Assert.assertTrue(resp.getJSONObject("delegateTo").has("companyName"));
        Assert.assertTrue(resp.getJSONObject("productData").has("name"));
        Assert.assertTrue(resp.getJSONObject("supplierData").has("name"));
        Assert.assertTrue(resp.has("activeDate"));
        Assert.assertTrue(resp.has("paymentAuth"));
        Assert.assertTrue(resp.has("status"));
    }

    public void verifyPageValueInRetrieve(int page){
        Assert.assertEquals(page, lastResponse().jsonPath().getInt("meta.page"));
    }

    public void verifyPaginationValueInRetrieve(int pagination){
        Assert.assertEquals(pagination, lastResponse().jsonPath().getInt("meta.pagination"));
    }

    public void verifyDataSortedInRetrieve(String column){
        Assert.assertTrue(Common.isSorted(lastResponse().jsonPath().getList("data." + column)));
    }

    public boolean thereIsNoDelegationSetting(){
        return lastResponse().jsonPath().getList("data.id").isEmpty();
    }

    public boolean thereIsNoDelegationId(String id){
        return !lastResponse().jsonPath().getList("data.id").contains(id);
    }

    public void verifyAbleToViewDelegationData(){
        lastResponse().jsonPath().getString("data");
    }

    public void verifyNewPaymentAppears(String id){
        Assert.assertTrue(lastResponse().jsonPath().getList("data.id").contains(id));
    }

    public void verifyPaymentStatus(int index, String status){
        Assert.assertEquals(status, lastResponse().jsonPath().getList("data.status").get(index));
    }

    public void verifyPaymentType(int index, String type){
        Assert.assertEquals(type, lastResponse().jsonPath().getList("data.paymentAuth").get(index));
    }

    public void verifyDelegationActiveDate(int index, String activeDate){
        Assert.assertTrue(String.valueOf(lastResponse().jsonPath().getList("data.requestDate").get(index)).contains(activeDate));
    }

    public void verifyMessageResponse(String message){
        Assert.assertEquals(message, lastResponse().jsonPath().getString("message"));
    }

    public void getAllSupplier(){
        String url = baseUrl + "/Payment/1/get-all-supplier";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body("{}")
                .post(url);
        then().statusCode(200);
    }

    public int indexOfProduct(List<String> productName){
        System.out.println(lastResponse().jsonPath().getList("products.name"));
        return lastResponse().jsonPath().getList("products.name").indexOf(productName);
    }
    public String productId(int index){
        JSONArray jsonObject = new JSONArray(response.asString());
        return jsonObject.getJSONObject(index).getJSONArray("products").getJSONObject(0).getString("serviceId");
    }

    public String supplierId(int index){
        JSONArray jsonObject = new JSONArray(response.asString());
        return jsonObject.getJSONObject(index).getString("_id");
    }

    public String supplierIdFromSi(int index){
        JSONObject jsonObject = new JSONObject(lastResponse().asString());
        return jsonObject.getJSONArray("datas").getJSONObject(index).getString("supplierId");
    }

    public String productIdFromSi(int index){
        JSONObject jsonObject = new JSONObject(lastResponse().asString());
        return jsonObject.getJSONArray("datas").getJSONObject(index).getString("productServiceId");
    }

    public String productIdListDelegation(int index){
        JSONObject jsonObject = new JSONObject(response.asString());
        return jsonObject.getJSONArray("data").getJSONObject(index).getString("productServiceId");
    }

    public String supplierIdListDelegation(int index){
        JSONObject jsonObject = new JSONObject(response.asString());
        return jsonObject.getJSONArray("data").getJSONObject(index).getString("supplierId");
    }

    public String productName(int index){
        JSONArray jsonObject = new JSONArray(response.asString());
        return jsonObject.getJSONObject(index).getJSONArray("products").getJSONObject(0).getString("name");
    }

    public String supplierName(int index){
        JSONArray jsonObject = new JSONArray(response.asString());
        return jsonObject.getJSONObject(index).getString("name");
    }

    public String productNameListDelegation(int index){
        JSONObject jsonObject = new JSONObject(response.asString());
        return jsonObject.getJSONArray("data").getJSONObject(index).getJSONObject("productData").getString("name");
    }

    public String supplierNameListDelegation(int index){
        JSONObject jsonObject = new JSONObject(response.asString());
        return jsonObject.getJSONArray("data").getJSONObject(index).getJSONObject("supplierData").getString("name");
    }

    public void createPaymentDelegation(String productId, String suppId, int statusCode){
        String url = baseUrl + "/Payment/1/createPaymentDelegationSetting";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentDelegationPayload.createPaymentDelegation(emailCompany, productId, suppId).toString())
                .post(url);
        then().statusCode(statusCode);
    }

    public String paymentDelegationId(int index){
        JSONObject resp = new JSONObject(response.asString());
        return resp.getJSONArray("data").getJSONObject(index).getString("id");
    }

    public List<String> paymentDelegationId(){
        return response.jsonPath().getList("data.id");
    }

    public String paymentDelegationIdCreate(){
        JSONObject resp = new JSONObject(response.asString());
        return resp.getJSONObject("data").getString("_id");
    }

    public void deletePaymentDelegation(String id, int statusCode){
        String url = baseUrl + "/Payment/1/deletePaymentDelegationSetting";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(PaymentDelegationPayload.deletePaymentDelegation(id).toString())
                .post(url);
        then().statusCode(statusCode);
    }
}

