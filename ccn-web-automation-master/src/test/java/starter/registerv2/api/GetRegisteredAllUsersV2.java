package starter.registerv2.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class GetRegisteredAllUsersV2 {

    private Response response;
    
    public void user_want_to_get_all_registered_user() {
        // Set base URI
        RestAssured.baseURI = "https://cubedev.ccnexchange.com";
    }
    
    public void send_the_request() {
        // Send POST request to get all registered users
        response = given()
                .header("Content-Type", "application/json")
                .when()
                .post("/v2register/all");
    }
    
    
    public void get_response_all_register_mail_and_cubeID() {
        // Extract data from response
        String responseBody = response.getBody().asString();
        System.out.println("Full Response Body: " + responseBody);
    }
    
    public void get_response_body_cubeID_email_and_status() {
        // Extract and log specific fields
        String cubeID = response.jsonPath().getString("data[0].cubeID");
        String email = response.jsonPath().getString("data[0].email");
        String status = response.jsonPath().getString("data[0].status");

        // Log the extracted values
        System.out.println("Cube ID: " + cubeID);
        System.out.println("Email: " + email);
        System.out.println("Status: " + status);
    }
}