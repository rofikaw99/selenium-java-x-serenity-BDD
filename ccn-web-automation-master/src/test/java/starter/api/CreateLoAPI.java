package starter.api;

import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.junit.Assert;
import starter.utlis.XFWBResponse;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.*;

public class CreateLoAPI {
    Response response;
    String baseUrlPPD = "https://onerecordppd.cubeforall.com/cd213881a8d848b5803619711fdf660d";
    String baseUrl = "https://onerecorddev.cubeforall.com/a0c7324c2d9644dd8b0986d9791c1e88";

    String internalUrl = "http://cube.dev.ccn/a0c7324c2d9644dd8b0986d9791c1e88";
    String serviceId = "71b83c4d-3cf7-46d5-af72-ce0f4b5666f7";


    public String createLORequest() throws IOException {
        String payload = FileUtils.readFileToString(new File("src/test/java/starter/utlis/outputJson.json"), StandardCharsets.UTF_8);
        String url = internalUrl +"/service/" + serviceId + "/OneRecord/1/CreateLogisticObject";
        String accessToken = FileUtils.readFileToString(new File("src/test/java/starter/utlis/tokenOneRecord.json"), StandardCharsets.UTF_8);

        response = given()
                .headers(
                        "Authorization", "Bearer " + accessToken,
                        "Content-Type", "application/json",
                        "x-api-key", "5dfcf3da-8863-407b-89f1-8f12b08d2b33",
                        "Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .body(payload)
                .post(url);
        then().statusCode(200);
        return response.body().path("@id");
    }

    public String createLORequest(String key) throws IOException {
        String payload = FileUtils.readFileToString(new File("src/test/java/starter/utlis/outputJson.json"), StandardCharsets.UTF_8);
        JSONObject customPayload = new JSONObject(payload);
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
        }

        String url = internalUrl +"/service/" + serviceId + "/OneRecord/1/CreateLogisticObject";
        String accessToken = FileUtils.readFileToString(new File("src/test/java/starter/utlis/tokenOneRecord.json"), StandardCharsets.UTF_8);

        response = given()
                .headers(
                        "Authorization", "Bearer " + accessToken,
                        "Content-Type", "application/json",
                        "x-api-key", "5dfcf3da-8863-407b-89f1-8f12b08d2b33",
                        "Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .body(customPayload.toString())
                .post(url);
        then().statusCode(200);
        return response.body().path("@id");
    }

    public void verifySuccessCreateLO(){
        then().statusCode(200);
    }
    public void verifyThereIsLOId(){
        then().body("$", hasKey("@id"));
    }
    public void verifyTheTypeIsWaybill(){
        then().body("@type", equalTo("cargo:Waybill"));
    }
}
