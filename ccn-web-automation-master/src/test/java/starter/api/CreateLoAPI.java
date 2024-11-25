package starter.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.junit.Assert;
import starter.utlis.ApiProperties;
import starter.utlis.XFWBResponse;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.*;

public class CreateLoAPI {
    Response response;
    String payload, url, accessToken;
    RequestSpecification requestSpecification;

    public void setupApi(String typeUrl) throws IOException {
        payload = FileUtils.readFileToString(new File("src/test/java/starter/utlis/outputJson.json"), StandardCharsets.UTF_8);
        accessToken = FileUtils.readFileToString(new File("src/test/java/starter/utlis/tokenOneRecord.json"), StandardCharsets.UTF_8);
        requestSpecification = given().headers(
//                "Authorization", "Bearer " + accessToken,
                "Content-Type", "application/json",
                "Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000");

        if (typeUrl.equals("internal")) {
            url = ApiProperties.internalUrl() +"/service/" + ApiProperties.serviceId() + "/OneRecord/1/CreateLogisticObject";
            requestSpecification.headers("x-api-key", ApiProperties.apiKey());
        }
        else if (typeUrl.equals("external")){
            url = ApiProperties.baseUrl() + "/logistics-objects";
        }
    }

    public String createLoRequestUrl(String typeUrl) throws IOException {
        setupApi(typeUrl);
        response = requestSpecification
                .body(payload)
                .post(url);
        if (typeUrl.equals("internal")) then().statusCode(200);
        else if (typeUrl.equals("external")) then().statusCode(201);
        return response.body().path("@id");
    }

    public String createLORequest(String key) throws IOException {
        setupApi("internal");
        JSONObject customPayload = new JSONObject(payload);
//        XFWBResponse.changeWaybillNumber(customPayload);
        switch (key){
            case "pieceCountForRate" :
                XFWBResponse.removePieceCountForRate(customPayload);
                break;
            case "grossWeightForRate":
                XFWBResponse.removeGrossWeightForRate(customPayload);
                break;
            case "volume":
                XFWBResponse.removeVolume(customPayload);
                break;
            case "dimensions":
                XFWBResponse.removeLength(customPayload);
                XFWBResponse.removeHeight(customPayload);
                XFWBResponse.removeWidth(customPayload);
                break;
            case "goodsDescriptionForRate":
                XFWBResponse.removeGoodsDescriptionForRate(customPayload);
                break;
            case "hsCodeForRate":
                XFWBResponse.removeHsCodeForRate(customPayload);
                break;
            case "specialHandlingCode":
                XFWBResponse.removeSpecialHandlingCodes(customPayload);
                break;
            case "otherChargeCode":
                XFWBResponse.removeOtherChargeCode(customPayload);
                break;
        }

        response = requestSpecification
                .body(customPayload.toString())
                .post(url);
        then().statusCode(200);
        return response.body().path("@id");
    }

    public void verifySuccessCreateLO(){
        then().statusCode(200);
    }
    public void verifySuccessCreateLO(String typeUrl){
        if (typeUrl.equals("internal")) then().statusCode(200);
        else if (typeUrl.equals("external")) then().statusCode(201);
    }
    public void verifyThereIsLOId(){
        then().body("$", hasKey("@id"));
    }
    public void verifyTheTypeIsWaybill(){
        then().body("@type", equalTo("cargo:Waybill"));
    }
    public String getWaybillNumber(){
        JSONObject payloads = new JSONObject(payload);
        return XFWBResponse.waybillNumber(payloads);
    }
    public String getWaybillPrefix(){
        JSONObject payloads = new JSONObject(payload);
        return XFWBResponse.waybillPrefix(payloads);
    }
}
