package starter.api;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import starter.payload.payment.StandingInstructionPayload;
import starter.utlis.ApiProperties;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.*;

public class StandingInstruction {

    String cubeId, baseUrl, baseUrlCompany, emailCompany, cubeIdCompany;
    Response response;
    Register register = new Register();

    public void setToken(int company) {
        emailCompany = ApiProperties.emailCompany(company);
        cubeIdCompany = register.cubeId(emailCompany);
        cubeId = ApiProperties.cubeId(company);
        baseUrl = ApiProperties.baseUrlPayment() + cubeId + "/service/" + ApiProperties.paymentServiceId();
        baseUrlCompany = ApiProperties.baseUrlExternal() + cubeId + "/service/" + ApiProperties.companyServiceId();
    }

    public void retrieveCardToken(){
        String url = baseUrl + "/Payment/1/retrieveCardDetail";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(StandingInstructionPayload.retrieveCardToken().toString())
                .post(url);
        then().statusCode(200);
    }

    public void retrieveCardToken(boolean isDetail){
        String url = baseUrl + "/Payment/1/retrieveCardDetail";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(StandingInstructionPayload.retrieveCardToken(isDetail).toString())
                .post(url);
        then().statusCode(200);
    }

    public void retrieveLastNumber(){
        String url = baseUrl + "/Payment/1/retrieveCardDetail";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(StandingInstructionPayload.retrieveCardToken().toString())
                .post(url);
        then().statusCode(200);
    }

    public String cardToken(){
        return lastResponse().jsonPath().getString("data.payment_method_id");
    }

    public void thereIsNoDetailCard(){
        JSONObject jsonObject = new JSONObject(lastResponse().asString());
        Assert.assertFalse(jsonObject.getJSONObject("data").getJSONObject("card").has("last4"));
        Assert.assertFalse(jsonObject.getJSONObject("data").getJSONObject("card").has("country"));
        Assert.assertFalse(jsonObject.getJSONObject("data").getJSONObject("card").has("exp_year"));
        Assert.assertFalse(jsonObject.getJSONObject("data").getJSONObject("card").has("exp_month"));
        Assert.assertTrue(jsonObject.getJSONObject("data").getJSONObject("card").has("brand"));
    }

    public void thereIsDetailCard(){
        JSONObject jsonObject = new JSONObject(lastResponse().asString());
        Assert.assertTrue(jsonObject.getJSONObject("data").getJSONObject("card").has("last4"));
        Assert.assertTrue(jsonObject.getJSONObject("data").getJSONObject("card").has("country"));
        Assert.assertTrue(jsonObject.getJSONObject("data").getJSONObject("card").has("exp_year"));
        Assert.assertTrue(jsonObject.getJSONObject("data").getJSONObject("card").has("exp_month"));
        Assert.assertTrue(jsonObject.getJSONObject("data").getJSONObject("card").has("brand"));
    }

    public void retrieveStandingInstruction(String type){
        String url = baseUrl + "/Payment/1/retrieveStandingInstruction";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(StandingInstructionPayload.retrieveSI(type).toString())
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

    public void verifySiCreatedInList(String siId){
        Assert.assertTrue(lastResponse().jsonPath().getList("datas.id").contains(siId));
    }

    public boolean thereIsSI(){
        return !lastResponse().jsonPath().getList("datas.standingInstructionId").isEmpty();
    }

    public boolean thereIsSIForCompany(String companyEmail){
        return lastResponse().jsonPath().getList("datas.paymentOwner.companyEmail").contains(companyEmail);
    }

    public List<String> listOfSiId(){
        return lastResponse().jsonPath().getList("datas.standingInstructionId");
    }

    public List<String> listOfProductIdSi(){
        return lastResponse().jsonPath().getList("datas.productServiceId");
    }

    public void createStandingInstruction(String productId, String productName, String suppId, String suppName, String cardToken,
                                          String type, int company, int statusCode){
        if (company == 2) emailCompany = ApiProperties.emailCompany(company);
        String url = baseUrl + "/Payment/1/createStandingInstruction";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(StandingInstructionPayload.createSI(suppId, suppName, productId, productName,
                        cardToken, type, emailCompany).toString())
                .post(url);
        then().statusCode(statusCode);
    }

    public void createStandingInstruction(String productId, String productName, String suppId, String suppName, String cardToken,
                                          String type, String emailCompany, int statusCode){
        String url = baseUrl + "/Payment/1/createStandingInstruction";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(StandingInstructionPayload.createSI(suppId, suppName, productId, productName,
                        cardToken, type, emailCompany).toString())
                .post(url);
        then().statusCode(statusCode);
    }

    public String siId(){
        return lastResponse().jsonPath().getString("id");
    }

    public void retrieveCompanyIdentities(){
        String url = baseUrlCompany + "/Company/1/RetrieveCompanyIdentities";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body("{}")
                .post(url);
        then().statusCode(200);
    }

    public String companyEmail(int index){
        JSONArray resp = new JSONArray(response.asString());
        return resp.getJSONObject(index).getString("email");
    }

    public String companyEmailFromRetrieveSI(int index){
        JSONObject resp = new JSONObject(response.asString());
        return resp.getJSONArray("datas").getJSONObject(0).getJSONObject("paymentOwner").getString("companyEmail");
    }

    public void verifyMessageAppears(String message){
        Assert.assertEquals(message, lastResponse().jsonPath().getString("message"));
    }

    public void verifyStatusCodeInBody(int statusCode){
        Assert.assertEquals(statusCode, lastResponse().jsonPath().getInt("statusCode"));
    }

    public String supplierIdFromSi(int index){
        JSONObject jsonObject = new JSONObject(lastResponse().asString());
        return jsonObject.getJSONArray("datas").getJSONObject(index).getString("supplierId");
    }

    public String productIdFromSi(int index){
        JSONObject jsonObject = new JSONObject(lastResponse().asString());
        return jsonObject.getJSONArray("datas").getJSONObject(index).getString("productServiceId");
    }

    public String supplierNameFromSi(int index){
        JSONObject jsonObject = new JSONObject(lastResponse().asString());
        return jsonObject.getJSONArray("datas").getJSONObject(index).getString("supplierName");
    }

    public String productNameFromSi(int index){
        JSONObject jsonObject = new JSONObject(lastResponse().asString());
        return jsonObject.getJSONArray("datas").getJSONObject(index).getString("productName");
    }

    public void deleteStandingInstruction(String id, String productId){
        String url = baseUrl + "/Payment/1/deleteStandingInstruction";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(StandingInstructionPayload.deleteSI(id, productId).toString())
                .post(url);
        then().statusCode(200);
    }
}
