package starter.api;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import starter.payload.payment.StandingInstructionPayload;
import starter.utlis.ApiProperties;

import static net.serenitybdd.rest.SerenityRest.*;

public class PaymentSettings {

    public String email, emailCompany, cubeIdCompany, cubeId, baseUrl, baseUrlPayReq;
    public Register register = new Register();
    public Response response;

    public void setToken(String role) {
        email = ApiProperties.emailUser(role);
        cubeId = register.cubeId(email);
        baseUrl = ApiProperties.baseUrlExternal() + cubeId + "/service/" + ApiProperties.paymentServiceId();
        baseUrlPayReq = ApiProperties.baseUrlPayment() + cubeId + "/service/" + ApiProperties.paymentServiceId();
    }

    public void retrieveCardDetail(String isDetail, String userList){
        String url = baseUrlPayReq + "/Payment/1/retrieveCardDetail";

        response = given()
                .header("x-api-key", ApiProperties.xApiKey("token"))
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(StandingInstructionPayload.retrieveCardToken(isDetail, userList).toString())
                .post(url);
    }

    public void verifyStatusCode(int statusCode){
        then().statusCode(statusCode);
    }

    public void verifyCardDetail(String cardDetail){
        JSONObject jsonObject = new JSONObject(lastResponse().asString());
        if (cardDetail.equals("true")) {
            Assert.assertTrue(jsonObject.getJSONObject("data").getJSONObject("card").has("last4"));
            Assert.assertTrue(jsonObject.getJSONObject("data").getJSONObject("card").has("country"));
            Assert.assertTrue(jsonObject.getJSONObject("data").getJSONObject("card").has("expYear"));
            Assert.assertTrue(jsonObject.getJSONObject("data").getJSONObject("card").has("expMonth"));
            Assert.assertTrue(jsonObject.getJSONObject("data").getJSONObject("card").has("brand"));
            Assert.assertTrue(jsonObject.getJSONObject("data").getJSONObject("card").has("status"));
        } else {
            Assert.assertFalse(jsonObject.getJSONObject("data").getJSONObject("card").has("last4"));
            Assert.assertFalse(jsonObject.getJSONObject("data").getJSONObject("card").has("country"));
            Assert.assertFalse(jsonObject.getJSONObject("data").getJSONObject("card").has("expYear"));
            Assert.assertFalse(jsonObject.getJSONObject("data").getJSONObject("card").has("expMonth"));
            Assert.assertTrue(jsonObject.getJSONObject("data").getJSONObject("card").has("brand"));
            Assert.assertFalse(jsonObject.getJSONObject("data").getJSONObject("card").has("status"));
        }
    }

    public void verifyUserList(String userList){
        JSONObject jsonObject = new JSONObject(lastResponse().asString());
        if (userList.equals("true")) {
            Assert.assertTrue(jsonObject.getJSONObject("data").has("isOwner"));
            Assert.assertTrue(jsonObject.getJSONObject("data").has("isAuthorized"));
            Assert.assertTrue(jsonObject.getJSONObject("data").has("authorizedUser"));
            Assert.assertTrue(jsonObject.getJSONObject("data").has("unauthorizedUser"));
            Assert.assertTrue(jsonObject.getJSONObject("data").has("ownerEmail"));
        } else {
            Assert.assertFalse(jsonObject.getJSONObject("data").has("isOwner"));
            Assert.assertFalse(jsonObject.getJSONObject("data").has("isAuthorized"));
            Assert.assertFalse(jsonObject.getJSONObject("data").has("authorizedUser"));
            Assert.assertFalse(jsonObject.getJSONObject("data").has("unauthorizedUser"));
            Assert.assertFalse(jsonObject.getJSONObject("data").has("ownerEmail"));
        }
    }

    public void verifyMessage(String message){
        Assert.assertTrue(lastResponse().jsonPath().getString("message").contains(message));
    }

    public void verifyStatusCodeInBody(int statusCode){
        Assert.assertEquals(lastResponse().statusCode(), statusCode);
    }

}
