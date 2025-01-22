package starter.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import starter.utlis.Constants;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.Matchers.*;

public class SubscribtionAndCompanyUpdateNotificationPage {


    public static final String BEARER_TOKEN = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IlFqZmFl...";


    public void getNotification(String contentType) {
        // Base URI
        RestAssured.baseURI = Constants.PUBLIC_PPD_URL;
        // Endpoint path
        String endpoint = "/5b11bba54a43425580405245c92cc40b/document/";
        // Request body
        String requestBody = "{ \"contentType\": \""+contentType+"\" }";
        // Send POST request
        Response response = given()
                .header("Content-Type", "application/json") // Set Content-Type header
                .body(requestBody) // Attach JSON body
                .when()
                .post(endpoint) // POST request
                .then()
                .extract()
                .response(); // Extract the response
        // Print the response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    public void getEventNotification(String contentType, String eventAction) {
        // Base URI
        RestAssured.baseURI = Constants.PUBLIC_PPD_URL;
        // Endpoint path
        String endpoint = "/5b11bba54a43425580405245c92cc40b/document/";
        // Request body
        String requestBody = "{ \"contentType\": \"" + contentType + "\", \"eventAction\": \"" + eventAction + "\" }";
        // Send POST request
        Response response = given()
                .header("Content-Type", "application/json") // Set Content-Type header
                .body(requestBody) // Attach JSON body
                .when()
                .post(endpoint) // POST request
                .then()
                .extract()
                .response(); // Extract the response

        // Print the response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        // Validate the response
        if (response.getStatusCode() == 200) {
            try {
                List<Map<String, Object>> responseBody = response.jsonPath().getList("$");
                for (Map<String, Object> item : responseBody) {
                    String responseContentType = (String) item.get("contentType");
                    String responseEventAction = (String) item.get("eventAction");

                    if (!contentType.equals(responseContentType) || !eventAction.equals(responseEventAction)) {
                        System.out.println("Validation failed: Mismatched contentType or eventAction");
                    } else {
                        System.out.println("Validation passed: contentType and eventAction are correct");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error parsing response: " + e.getMessage());
            }
        } else {
            System.out.println("Request failed with status code: " + response.getStatusCode());
        }
    }

    public void findTheNotificationByDocumentID(String documentID) {
        // Base URI for the API
        String baseUrl = ""+Constants.PUBLIC_PPD_URL+"/support/database/find-all";
        // Request body
        String requestBody = "{\n" +
                "    \"databaseName\":\"notification\",\n" +
                "    \"collectionName\":\"historyqueues\",\n" +
                "    \"filterQuery\": {\n" +
                "        \"documentID\":\"" + documentID + "\"\n" +
                "    }\n" +
                "}";
        // Send the GET request
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post();
        // Print the response
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        // Add assertions (if needed)
        if (response.getStatusCode() == 200) {
            System.out.println("Request was successful.");
        } else {
            System.out.println("Request failed.");
        }
    }

    public void verifyCurrentQueues(String contentType) {
        // Base URL
        RestAssured.baseURI = Constants.SUPPORT_DEV_URL;

        // Send GET request
        Response response = RestAssured
                .given()
                .header("cookie", "connect.sid=s%3ACX2aRioye5P-Dqzmae8pzgoLFKX_BHg0.IYxwiGuYVBAyu0L6O0tSSF4%2BMS4Ukz8q0R3QlgEvy5k")
                .header("host", "cubehelp.dev.ccn")
                .header("if-none-match", "W/\"178a-TJx18Vidkm1eACuYX+UqUXbBrYg\"")
                .header("referer", ""+Constants.SUPPORT_DEV_URL+"/supportforall/notificationCurrentQ")
                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Safari/537.36 Edg/132.0.0.0")
                .when()
                .get("/support/notification/currentqueue/classification");


        // Extract and print the count for the specified contentType
        int count = response.jsonPath()
                .getInt("datas.find { it.contentType == '" + contentType + "' }.count");

        System.out.println("Count for contentType '" + contentType + "': " + count);

        // Example assertion to validate count (can be customized as needed)
        response.then().body("datas.find { it.contentType == '" + contentType + "' }.count", greaterThanOrEqualTo(0));
    }

    public void triggerRemoveSubscriber(String user_plan_id, String member1, String member2) {
        // Base URL
        RestAssured.baseURI = Constants.PUBLIC_DEV_URL;

        // Request body
        String requestBody = String.format(
                "{\n" +
                        "    \"user_plan_id\": \"%s\",\n" +
                        "    \"members\": [\n" +
                        "        \"%s\",\n" +
                        "        \"%s\"\n" +
                        "    ]\n" +
                        "}", user_plan_id, member1, member2);

        // Send POST request
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("Authorization", BEARER_TOKEN)
                .body(requestBody)
                .post("/8123418ce0024e7eae76550216815494/service/7bbd3c40-48f3-4afc-b86e-e1f4fe1581ba/GeneralSubscription/1/UpdateMemberships");

        // Print response for debugging
        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response Body: " + response.asString());

        // Validate the response status code (example)
        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed with HTTP code: " + response.statusCode());
        }
    }
}
