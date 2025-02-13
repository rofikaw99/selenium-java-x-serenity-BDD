package starter.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.junit.Assert;
import starter.utlis.ApiProperties;
import starter.utlis.onerecord.UpdateLoPayload;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class GetChangeRequestAPI {
    Response response;
    String url, accessToken;
    RequestSpecification requestSpecification;
    JSONObject payload = new JSONObject();

    public void setupApi() throws IOException {
        accessToken = FileUtils.readFileToString(new File("src/test/java/starter/utlis/onerecord/tokenOneRecord.json"), StandardCharsets.UTF_8);
        requestSpecification = given().headers(
                "Authorization", "Bearer " + accessToken,
                "Content-Type", "application/json",
                "Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000");

        url = ApiProperties.internalUrl() +"/service/" + ApiProperties.serviceId() + "/OneRecord/1/";
        requestSpecification.headers("x-api-key", ApiProperties.apiKey());
    }

    public Response getChangeRequest(String payload) throws IOException {
        setupApi();

        url = url + "getChangeRequest";
        response = requestSpecification
                .body(payload)
                .post(url);

        return response;
    }

    public Response getVerificationRequest(String payload) throws IOException {
        setupApi();
        url = url + "getVerificationRequest";

        response = requestSpecification
                .body(payload)
                .post(url);

        return response;
    }

    public Response getChangeUsingLoId(String id) throws IOException {
        payload.put("loId", id);
        return getChangeRequest(payload.toString());
    }

    public Response getChangeUsingChangeRequestId(String id) throws IOException {
        payload.put("changeRequestId", id);
        return getChangeRequest(payload.toString());
    }

    public Response getVerUsingVerificationReqId(String id) throws IOException {
        payload.put("verificationRequestId", id);
        return getVerificationRequest(payload.toString());
    }

    public void successGetChangeRequest(){
        then().statusCode(200);
    }

    public void verifyRevision(JSONObject lastResp, int revision){
        Assert.assertEquals(lastResp.getJSONObject("changeObject").getJSONObject("api:hasRevision").getString("@value"), String.valueOf(revision));
    }

    public void verifyRevisionInVerification(JSONObject lastResp, int revision){
        Assert.assertEquals(lastResp.getJSONObject("verificationObject").getJSONObject("api:hasRevision").getString("@value"), String.valueOf(revision));
    }

    public void verifyIdObjectTarget(JSONObject lastResp, String id){
        Assert.assertTrue(lastResp.getJSONObject("changeObject").getJSONObject("api:hasLogisticsObject").getString("@id").contains(id));
    }
    public void verifyIdLoOfVerification(JSONObject lastResp, String id){
        Assert.assertTrue(lastResp.getJSONObject("verificationObject").getJSONObject("api:hasLogisticsObject").getString("@id").contains(id));
    }

    public void verifyStatus(JSONObject lastResp, String status){
        Assert.assertEquals(lastResp.getString("requestStatus"), status);
    }

    public void verifyIdHeightUnitCode(JSONObject lastResp, String id){
        Assert.assertTrue(UpdateLoPayload.getOperationIds(lastResp, 0, 1).contains(id));
    }

    public void verifyIdHeightNumericalValue(JSONObject lastResp, String id){
        Assert.assertTrue(UpdateLoPayload.getOperationIds(lastResp, 2, 3).contains(id));
    }

    public void verifyIdLengthUnitCode(JSONObject lastResp, String id){
        Assert.assertTrue(UpdateLoPayload.getOperationIds(lastResp, 4, 5).contains(id));
    }
    public void verifyIdLengthNumericalValue(JSONObject lastResp, String id){
        Assert.assertTrue(UpdateLoPayload.getOperationIds(lastResp, 6, 7).contains(id));
    }
    public void verifyIdWidthUnitCode(JSONObject lastResp, String id){
        Assert.assertTrue(UpdateLoPayload.getOperationIds(lastResp, 8, 9).contains(id));
    }
    public void verifyIdWidthNumericalValue(JSONObject lastResp, String id){
        Assert.assertTrue(UpdateLoPayload.getOperationIds(lastResp, 10, 11).contains(id));
    }
}
