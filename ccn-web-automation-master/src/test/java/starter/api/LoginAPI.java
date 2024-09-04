package starter.api;

import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class LoginAPI {

    public void loginRequest() throws IOException {
        String url = "https://login.microsoftonline.com/ccnssoppd.onmicrosoft.com/oauth2/v2.0/token";
        String clientID = "a9366fac-bdeb-4c5f-85dd-d4fcb5989cbc";
        String clientSecret = "HB08Q~qI09SysrjCCaW9JwMgH~YqiWlXXhDaUaDv";
        Response response =
                given()
                        .auth().preemptive().basic(clientID, clientSecret)
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("grant_type", "client_credentials")
                        .formParam("scope", "https://ccnssoppd.onmicrosoft.com/ccn-one-record/.default")
                .when()
                .post(url);

        then().statusCode(200);

        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        String accessToken = jsonObject.get("access_token").toString();

        FileWriter file = new FileWriter("src/test/java/starter/utlis/tokenOneRecord.json");
        file.write(accessToken);
        file.close();
    }
}
