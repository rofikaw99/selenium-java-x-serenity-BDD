package starter.pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.pages.PageObject;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class CheckStatusPage extends PageObject {

    public static String accessToken;

    public static void fetchAccessToken() {
        Response response = RestAssured.given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Cookie", "fpc=AvtAb5bVFpRMgmodPHJEYoWc2pdeAgAAAO0Tzd0OAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd")
                .formParam("grant_type", "client_credentials")
                .formParam("scope", "https://ccnssoppd.onmicrosoft.com/CUBE_CORE_SITE_1/.default")
                .formParam("client_id", "cc4371c5-a9fb-441f-a9e6-de27c073a94c")
                .formParam("client_secret", "QGa8Q~lT3hB8X1UaVAuKMVTe4HeQ7HB~EmRnwaE8")
                .when().post("https://login.microsoftonline.com/ccnssoppd.onmicrosoft.com/oauth2/v2.0/token");

        accessToken = response.jsonPath().getString("access_token");
    }

    public void getCheckStatus(String serviceId){
        String baseUrl = "https://cubesandbox.ccnexchange.com/";
        String cubeID = "dd66606da3fa4d11b5c2424187afa2a7";
        String serviceID = "31bbd797-9265-4ea5-8477-ca783b38bd07";
        String endpoint = "/GeneralSubscription/1/CheckStatus";

        String url = baseUrl + cubeID + "/service/" + serviceID + endpoint;

        Response response = given()
                .headers("source-service-id", serviceId,
                        "Authorization", "Bearer " + accessToken,
                        "Content-Type", ContentType.JSON.toString(),
                        "Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .post(url);
    }

    public void assertSuccessCheckStatus(){
        then().statusCode(200);
    }

<<<<<<< HEAD
    public void assertFailedCheckStatus(){
        then().statusCode(401);
=======
    public void assertFailedCheckStatus(int statusCode){
        then().statusCode(statusCode);
>>>>>>> 3e42ba6dfe57e8f1ccfefa12d0d8d74898361080
    }
}
