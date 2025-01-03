package starter.registerv2.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class GetRegisteredByMailV2 {

    private Response response;
    private String parameter;

    public void user_want_to_get_register_by(String param) {
        RestAssured.baseURI = "https://cubesandbox.ccnexchange.com";
        this.parameter = param;
    }

    public void send_the_request_by_email() {
        response = given()
                .header("Content-Type", "application/json")
                .body("{\"email\": \"" + parameter + "\"}")
                .when()
                .post("/v2register/email/");
    }

    public void send_the_request_by_cubeID() {
        response = given()
                .header("Content-Type", "application/json")
                .body("{\"cubeID\": \"" + parameter + "\"}")
                .when()
                .post("/v2register/email/");
    }

    public void get_box_url_and_site_response() {
        // Extract and log fields from response
        String boxUrl = response.jsonPath().getString("boxURL");
        String site = response.jsonPath().getString("site");

        // Log the extracted values
        System.out.println("Box URL: " + boxUrl);
        System.out.println("Site: " + site);
    }

    public void get_email_and_status_response() {
        // Extract and log fields from response
        String email = response.jsonPath().getString("email");
        String status = response.jsonPath().getString("status");

        // Log the extracted values
        System.out.println("Box URL: " + email);
        System.out.println("Site: " + status);
    }
}