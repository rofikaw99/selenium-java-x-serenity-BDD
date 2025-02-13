package starter.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import starter.utlis.ApiProperties;
import starter.utlis.onerecord.XFWBResponse;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.*;

public class CreateLoAPI {
    Response response;
    String payload, url, token;
    JSONObject customPayload;
    RequestSpecification requestSpecification;

    public void setupApi(String typeUrl) throws IOException {
        token = FileUtils.readFileToString(new File("src/test/java/starter/utlis/onerecord/tokenOneRecord.json"), StandardCharsets.UTF_8);
        requestSpecification = given().headers(
                "Content-Type", "application/json",
                "Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000");

        if (typeUrl.equals("internal")) {
            url = ApiProperties.internalUrl() +"/service/" + ApiProperties.serviceId() + "/OneRecord/1/CreateLogisticObject";
            requestSpecification.headers("x-api-key", ApiProperties.apiKey());
        }
        else if (typeUrl.equals("external")){
            url = ApiProperties.baseUrl() + "/logistics-objects";
            requestSpecification.header("Authorization", "Bearer " + token);
        }
    }

    public String createLoRequestUrl(String typeUrl) throws IOException {
        setupApi(typeUrl);
        payload();
        response = requestSpecification
                .body(payload)
                .post(url);
        if (typeUrl.equals("internal")) then().statusCode(200);
        else if (typeUrl.equals("external")) then().statusCode(201);
        return response.body().path("@id");
    }

    public JSONObject payload() throws IOException {
        payload = FileUtils.readFileToString(new File("src/test/java/starter/utlis/onerecord/outputJson.json"), StandardCharsets.UTF_8);
        return new JSONObject(payload);
    }

    public JSONObject modifyPayload(JSONObject customPayload, String key, String newValue) throws IOException {
        setupApi("internal");
        switch (key){
            case "masterWaybillNumber":
                if (newValue.isEmpty()) XFWBResponse.changeMasterWaybillNumber(customPayload);
                else XFWBResponse.changeMasterWaybillNumber(customPayload, newValue);
                break;
            case "houseWaybillNumber":
                if (newValue.isEmpty()) XFWBResponse.changeHouseWaybillNumber(customPayload);
                else XFWBResponse.changeWaybillNumber(customPayload, newValue);
                break;
            case "waybillNumber":
                if (newValue.isEmpty()) XFWBResponse.changeWaybillNumber(customPayload);
                else XFWBResponse.changeWaybillNumber(customPayload, newValue);
            case "waybillType":
                XFWBResponse.changeWaybillType(customPayload, newValue);
                break;
        }
        return customPayload;
    }

    public String createLoRequestCustom(JSONObject customPayload) throws IOException {
        response = requestSpecification
                .body(customPayload.toString())
                .post(url);
        then().statusCode(200);
        return response.body().path("@id");
    }

    public String createLORequest(String key) throws IOException {
        setupApi("internal");
        JSONObject customPayload = payload();
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
            case "waybillNumber":
                XFWBResponse.changeWaybillNumber(customPayload);
                break;
            case "masterWaybillNumber":
                XFWBResponse.changeMasterWaybillNumber(customPayload);
                break;
            case "houseWaybillNumber":
                XFWBResponse.changeHouseWaybillNumber(customPayload);
                break;
            case "houseMasterWaybillNumber":
                XFWBResponse.changeMasterWaybillNumber(customPayload);
                XFWBResponse.changeHouseWaybillNumber(customPayload);
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
