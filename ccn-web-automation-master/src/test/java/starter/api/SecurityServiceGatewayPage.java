package starter.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class SecurityServiceGatewayPage {

    private static String documentID;
    private static String documentRefID;

    public void Check_status_with_public_service_gateway_with_no_token_and_API_key() {
        // Define the base URL for RestAssured
        RestAssured.baseURI = "https://cubedev.ccnexchange.com";
        // Perform the POST request and get the response
        Response response = given()
                .contentType("application/json")
                .when()
                .post("/5c15c737a0544c08b29d7a9e77898c5e/service/7bbd3c40-48f3-4afc-b86e-e1f4fe1581ba/GeneralSubscription/1/CheckStatus")
                .then()
                .extract().response();

        // Get the response status code
        int statusCode = response.getStatusCode();
        // Get the response body
        String responseBody = response.getBody().asString();
        // Print response for debugging
        System.out.println("Response Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);
        // Validate the response status code
    }

    public void Check_status_with_private_service_gateway_with_no_token_and_API_key(String serviceGatewayType) {
        // Define the base URL for RestAssured
        RestAssured.baseURI = serviceGatewayType;
        // Perform the POST request and get the response
        Response response = given()
                .contentType("application/json")
                .when()
                .post("/5c15c737a0544c08b29d7a9e77898c5e/service/7bbd3c40-48f3-4afc-b86e-e1f4fe1581ba/GeneralSubscription/1/CheckStatus")
                .then()
                .extract().response();

        // Get the response status code
        int statusCode = response.getStatusCode();
        // Get the response body
        String responseBody = response.getBody().asString();
        // Print response for debugging
        System.out.println("Response Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);
    }

    public void Check_status_with_private_service_gateway_with_no_token(String serviceGatewayType) {
        // Define the base URL for RestAssured
        RestAssured.baseURI = serviceGatewayType;
        // Perform the POST request and get the response
        Response response = given()
                .contentType("application/json")
                .header("x-api-key", "d367c646-2e75-4029-b858-14111160eaa8")
                .when()
                .post("/5c15c737a0544c08b29d7a9e77898c5e/service/7bbd3c40-48f3-4afc-b86e-e1f4fe1581ba/GeneralSubscription/1/CheckStatus")
                .then()
                .extract().response();

        // Get the response status code
        int statusCode = response.getStatusCode();
        // Get the response body
        String responseBody = response.getBody().asString();
        // Print response for debugging
        System.out.println("Response Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);
    }

    public void assertFailed401(){
        then().statusCode(401);
    }
}
