package starter.api;

import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class GetLoAPI {
    String response;

    public JSONObject getLORequest(String id) throws IOException {
        String accessToken = FileUtils.readFileToString(new File("src/test/java/starter/utlis/tokenOneRecord.json"), StandardCharsets.UTF_8);

        response = given()
                .headers(
                        "Authorization", "Bearer " + accessToken,
                        "Content-Type", "application/json")
                .get(id)
                .then()
                .extract().response().asString();
        then().statusCode(200);
        return new JSONObject(response);
    }

    public Response getLORequestFullResponse(String id) throws IOException {
        String accessToken = FileUtils.readFileToString(new File("src/test/java/starter/utlis/tokenOneRecord.json"), StandardCharsets.UTF_8);

        Response response = given()
                .headers(
                        "Authorization", "Bearer " + accessToken,
                        "Content-Type", "application/json")
                .get(id);
        then().statusCode(200);
        return response;
    }

    public void verifySuccessGetLO(){
        then().statusCode(200);
    }
    public void verifyIdEqualRequest(String id){
        then().body("@id", equalTo(id));
    }
}
