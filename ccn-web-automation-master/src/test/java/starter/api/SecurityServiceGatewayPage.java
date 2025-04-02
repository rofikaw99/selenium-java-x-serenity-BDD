package starter.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import starter.pages.GoToUrl;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

import starter.pages.SecurityServiceGatewayPageOrdinary;
import starter.pages.SupportAppPage;
import starter.utlis.Constants;

public class SecurityServiceGatewayPage {
    @Steps
    GoToUrl goToUrl;

    @Steps
    SecurityServiceGatewayPageOrdinary securityServiceGatewayPageOrdinary;

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
    public void goToJWTDebugger() throws InterruptedException {
        goToUrl.goToAbsUrl("https://token.dev/");
        Thread.sleep(1500);
        securityServiceGatewayPageOrdinary.inputTokenPayload();

    }

    public void validatePimaChexs(String pima) {

        // API endpoint
        String baseUrl = "http://chexsconfigurationapi.ppd.ccn/CHEXS/ValidatePima";
        String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6IkNVQkVGT1JBTEwiLCJuYW1laWQiOiJDVUJFRk9SQUxMIiwibmJmIjoxNzI3NzYzOTM3LCJleHAiOjE3Mjc3ODU1MzcsImlhdCI6MTcyNzc2MzkzNywiaXNzIjoiQ0NOIn0.N1MbmsmCdSqMXMlhfEAAQSijMc9jcCzs5vhwIdY8qPk";

        // Sending PUT request
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .queryParam("pimaAddress", pima)
                .header("Authorization", "Bearer " + bearerToken)
                .when()
                .get()
                .then()
                .statusCode(200) // Check for a successful response
                .extract().response();
        // Print response for debugging purposes
        System.out.println("Response: " + response.asString());
    }
    public void retrieveAirlineCompanyIdentity(String awbPrefix, String carrierCode) {
        /// Base URI
        RestAssured.baseURI = "http://cubecompany.sandbox.ccn";
        // Request payload
        String requestBody = "{\n" +
                "    \"awbPrefix\": \""+awbPrefix+"\",\n" +
                "    \"carrierCode\": \""+carrierCode+"\"\n" +
                "}";
        // Send POST request
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/Airline/1/retrieveAirline")
                .then()
                .statusCode(200) // Verifies status code
                .body("message", equalTo("Successfully get company identity")) // Verifies message
                .extract()
                .response();
        // Print full response
        System.out.println("Response: " + response.asPrettyString());
        // Extract and print specific fields from the response
        String email = response.jsonPath().getString("data[0].email");
        String companyName = response.jsonPath().getString("data[0].companyName");
        String pimaAddress = response.jsonPath().getString("data[0].pimaAddress");
        String companyType = response.jsonPath().getString("data[0].companyType");
        String station = response.jsonPath().getString("data[0].station");
        String address = response.jsonPath().getString("data[0].address");
        String awbPrefixR = response.jsonPath().getString("data[0].awbPrefix");
        String carrierCodeR = response.jsonPath().getString("data[0].carrierCode");
        String companyRegistrationNo = response.jsonPath().getString("data[0].companyRegistrationNo");
        // Print extracted fields
        System.out.println("Email: " + email);
        System.out.println("Company Name: " + companyName);
        System.out.println("PIMA Address: " + pimaAddress);
        System.out.println("Company Type: " + companyType);
        System.out.println("Station: " + station);
        System.out.println("Address: " + address);
        System.out.println("AWB Prefix: " + awbPrefixR);
        System.out.println("Carrier Code: " + carrierCodeR);
        System.out.println("Company Registration No: " + companyRegistrationNo);
    }

    public void assertFailed401(){
        then().statusCode(401);
    }
}
