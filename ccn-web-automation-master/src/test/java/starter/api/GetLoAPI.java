package starter.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import starter.utlis.ApiProperties;
import starter.utlis.onerecord.XFWBResponse;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class GetLoAPI {
    String response, accessToken;
    JSONObject payload = new JSONObject();
    RequestSpecification requestSpecification;

    public void setupApi() throws IOException {
        accessToken = FileUtils.readFileToString(new File("src/test/java/starter/utlis/onerecord/tokenOneRecord.json"), StandardCharsets.UTF_8);
        requestSpecification = given() .headers(
                "Authorization", "Bearer " + accessToken,
                "Content-Type", "application/json");
    }

    public JSONObject getLORequest(String id) throws IOException {
        setupApi();

        response = requestSpecification
                .get(id)
                .then()
                .extract().response().asString();
        then().statusCode(200);
        return new JSONObject(response);
    }

    public Response getLORequestFullResponse(String id) throws IOException {
        setupApi();

        Response response = requestSpecification
                .get(id);
        then().statusCode(200);
        return response;
    }

    public String getLORequestFullResponseAsString(String id) throws IOException {
        setupApi();

        response = requestSpecification
                .get(id)
                .then()
                .extract().response().asString();
        then().statusCode(200);
        return response;
    }

    public String getLoReq(String payload) throws IOException {
        setupApi();
        String url = ApiProperties.internalUrl() +"/service/" + ApiProperties.serviceId() + "/OneRecord/1/GetLogisticObject";

        response = requestSpecification.headers(
                        "x-api-key", ApiProperties.apiKey())
                .body(payload)
                .post(url)
                .then()
                .extract().response().asString();
        return response;
    }

    public Response getLoReqResponse(String payload) throws IOException {
        setupApi();
        String url = ApiProperties.internalUrl() +"/service/" + ApiProperties.serviceId() + "/OneRecord/1/GetLogisticObject";

        return requestSpecification.headers(
                        "x-api-key", ApiProperties.apiKey())
                .body(payload)
                .post(url);
    }

    public void verifySuccessGetLO(){
        then().statusCode(200);
    }
    public void verifyIdEqualRequest(String id){
        then().body("@id", equalTo(id));
    }

    public void verifyWaybillNumberEqualRequest(String waybillNumber){
        Assert.assertEquals(XFWBResponse.waybillNumber(new JSONObject(response)), waybillNumber);
    }
    public void verifyWaybillNumberEqualRequest(JSONObject response, String waybillNumber){
        Assert.assertEquals(XFWBResponse.waybillNumber(response), waybillNumber);
    }
    public void verifyWaybillNumberContainsRequest(JSONObject response, String waybillNumber){
        Assert.assertTrue(waybillNumber.contains(XFWBResponse.waybillNumber(response)));
    }
    public void verifyWaybillPrefixEqualRequest(String waybillPrefix){
        Assert.assertEquals(XFWBResponse.waybillPrefix(new JSONObject(response)), waybillPrefix);
    }
    public void verifyWaybillType(JSONObject response, String type){
        Assert.assertEquals(XFWBResponse.waybillType_Code(response), type);
    }
    public void verifyPiecesDistributedInHouse(JSONObject response){
        List<String> masterPiecesId = new ArrayList<>();
        for (int i = 0; i < XFWBResponse.Master_Shipment_Pieces(response).length(); i ++){
            masterPiecesId.add(XFWBResponse.Master_S_Pieces_ID(response, i));
        }
        List<String> housePiecesId = new ArrayList<>();
        for (int i = 0; i < XFWBResponse.Shipment_Pieces(response).length(); i ++){
            housePiecesId.add(XFWBResponse.S_Pieces_ID(response, i));
        }
        Assert.assertTrue(masterPiecesId.containsAll(housePiecesId));
    }

    public String getLORequestLoId(String id) throws IOException {
        List<String> ids = List.of(id.split("/"));
        String idBody = ids.get(ids.size() - 1);
        payload.put("LO_ID", idBody);
        payload.put("EMBEDDED", "true");

        return getLoReq(payload.toString());
    }

    public Response getLORequestLoIdResponse(String id) throws IOException {
        List<String> ids = List.of(id.split("/"));
        String idBody = ids.get(ids.size() - 1);
        payload.put("LO_ID", idBody);
        payload.put("EMBEDDED", "true");

        return getLoReqResponse(payload.toString());
    }

    public void getLORequestLoWaybillPrefix(String waybillPrefix, String waybillNumber) throws IOException {
        payload.put("masterWaybillPrefix", waybillPrefix);
        payload.put("masterWaybillNumber", waybillNumber);
        payload.put("EMBEDDED", "true");

        getLoReq(payload.toString());
    }

    public String getLORequestLoMasterHouse(String masterWaybillNumber, String houseWaybillNumber) throws IOException {
        payload.put("masterWaybillPrefix", "123");
        payload.put("masterWaybillNumber", masterWaybillNumber);
        payload.put("houseWaybillNumber", houseWaybillNumber);
        payload.put("EMBEDDED", "true");

        return getLoReq(payload.toString());
    }

    public void getLORequestLoWaybillNumber(String waybillNumber) throws IOException {
        payload.put("masterWaybillPrefix", "123");
        payload.put("masterWaybillNumber", waybillNumber);
        payload.put("EMBEDDED", "true");

        getLoReq(payload.toString());
    }

    public void getLORequestLoAt(String at) throws IOException {
        payload.put("at", at);
        payload.put("EMBEDDED", "true");

        getLoReq(payload.toString());
    }
}
