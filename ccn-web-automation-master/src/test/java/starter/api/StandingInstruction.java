package starter.api;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import starter.payload.payment.PaymentDelegationPayload;
import starter.payload.payment.StandingInstructionPayload;
import starter.utlis.ApiProperties;
import starter.utlis.ReadFile;

import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.*;

public class StandingInstruction {

    String token, cubeId, baseUrl, baseUrlCompany, emailCompany, emailCompany2;
    Response response;

    public void setToken(int company) throws IOException {
        if (company == 1) {
            token = ReadFile.tokenCompany1();
            cubeId = ApiProperties.cubeId1();
        }
        else if (company == 2) {
            token = ReadFile.tokenCompany2();
            cubeId = ApiProperties.cubeId2();
        }
        emailCompany = ApiProperties.emailCompany1();
        emailCompany2 = ApiProperties.emailCompany2();
        baseUrl = ApiProperties.baseUrlExternal() + cubeId + "/service/" + ApiProperties.paymentServiceId();
        baseUrlCompany = ApiProperties.baseUrlExternal() + cubeId + "/service/" + ApiProperties.companyServiceId();
    }

    public void retrieveCardToken(){
        String url = baseUrl + "/Payment/1/retrieveCardToken";

        response = given()
                .header("Authorization", "Bearer " + token)
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(StandingInstructionPayload.retrieveCardToken().toString())
                .post(url);
        then().statusCode(200);
    }

    public String cardToken(){
        return lastResponse().jsonPath().getString("data.token");
    }

    public void retrieveStandingInstruction(String type){
        String url = baseUrl + "/Payment/1/retrieveStandingInstruction";

        response = given()
                .header("Authorization", "Bearer " + token)
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
        return !lastResponse().jsonPath().getList("datas.id").isEmpty();
    }

    public void createStandingInstruction(String productId, String productName, String suppId, String suppName, String cardToken,
                                          String type, int company, int statusCode){
        if (company == 2) emailCompany = emailCompany2;
        String url = baseUrl + "/Payment/1/createStandingInstruction";

        response = given()
                .header("Authorization", "Bearer " + token)
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
                .header("Authorization", "Bearer " + token)
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
                .header("Authorization", "Bearer " + token)
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
}
