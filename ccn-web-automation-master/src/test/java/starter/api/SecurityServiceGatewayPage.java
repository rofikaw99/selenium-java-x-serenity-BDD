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
                .post("9af033381cea4417af7b0821c82101e5/service/31bbd797-9265-4ea5-8477-ca783b38bd07/GeneralSubscription/1/CheckStatus")
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
                .post("9af033381cea4417af7b0821c82101e5/service/31bbd797-9265-4ea5-8477-ca783b38bd07/GeneralSubscription/1/CheckStatus")
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

    public void Check_status_with_private_service_gateway_with_modified_host(String serviceGatewayType) {
        // Define the base URL for RestAssured
        RestAssured.baseURI = serviceGatewayType;
        // Perform the POST request and get the response
        Response response = given()
                .contentType("application/json")
                .header("x-api-key", "d367c646-2e75-4029-b858-14111160eaa8")
                .header("Host", "172.16.200.161:8585")
                .when()
                .post("9af033381cea4417af7b0821c82101e5/service/31bbd797-9265-4ea5-8477-ca783b38bd07/GeneralSubscription/1/CheckStatus")
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
                .post("9af033381cea4417af7b0821c82101e5/service/31bbd797-9265-4ea5-8477-ca783b38bd07/GeneralSubscription/1/CheckStatus")
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
