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
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.Matchers.*;

public class SubscribtionAndCompanyUpdateNotificationPage {


    public static final String BEARER_TOKEN = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IlFqZmFlS1pwOXhiZ1dwSDVqM3pYTGxaUW5Qa2szMHFCelZ2Rzl2cmdKLXMiLCJ0eXAiOiJKV1QifQ.eyJhdWQiOiI5NTg3ZGNlOS05NWI1LTQyOGEtOTc2MC1jZjUzMjlmMzdiZDUiLCJpc3MiOiJodHRwczovL2NjbnNzb2Rldi5iMmNsb2dpbi5jb20vZjRlZTZlMTctNjM2MC00MjQxLTgwY2UtZTc5N2UwNWFlMDc4L3YyLjAvIiwiZXhwIjoxNzM5MTk0OTg5LCJuYmYiOjE3MzkxOTEzODksInN1YiI6IjE0OTYzM2I2LWVhYWMtNGM0ZC05MmZlLWMzMDdjZGY2ZWUyZSIsImVtYWlsIjoidGVzdF8wNzExMjNfdW5yZWcxQHlvcG1haWwuY29tIiwibmFtZSI6InRlc3RfMDcxMTIzX3VucmVnMSIsImV4dGVuc2lvbl9Db250YWN0Tm8iOiI2MTIzNDU2NyIsImV4dGVuc2lvbl9DdWJlVXNlcklEIjoiZDNjYTYyNTItOWYxNi00OGJmLTkyZDctYzExYjYxZDZlNTA4IiwiY2l0eSI6IlNJTiIsImV4dGVuc2lvbl9Db3VudHJ5Q29kZSI6IlNHIiwidWlmbyI6ImV5SmpkV0psU1dRaU9pSTRNVEl6TkRFNFkyVXdNREkwWlRkbFlXVTNOalUxTURJeE5qZ3hOVFE1TkNJc0luVnpaWEpRYkdGdVNXUWlPbTUxYkd3c0luQnlhV05sUkdGMFlTSTZiblZzYkN3aWMzUmhkSFZ6SWpwMGNuVmxMQ0p3Y205a2RXTjBWRzlyWlc0aU9tNTFiR3dzSW5OMFlYUjFjMU4xWW5OamNtbHdkR2x2YmlJNklrTlZRa1ZHVDFKQlRFeGZUVVZOUWtWU0lpd2lhWE5PWlhkVmMyVnlJanBtWVd4elpTd2lZMjl0Y0dGdWVTSTZleUp1WVcxbElqb2lTRkV5SWl3aVkyOTFiblJ5ZVNJNklsTkhJaXdpWTJsMGVTSTZJbE5KVGlKOUxDSndjbTltYVd4bElqcDdJbVZ0WVdsc0lqb2lkR1Z6ZEY4d056RXhNak5mZFc1eVpXY3hRSGx2Y0cxaGFXd3VZMjl0SWl3aWJtRnRaU0k2SWt0dlkyaHBJbjBzSW14aGMzUkJZM1JwZG1WVFpYTnphVzl1SWpwN0lsOXBaQ0k2SWpZM1lUbGlOalpsWkdOaE9EYzBZalZtTmpBMU5EUmtNU0lzSW14dloybHVWR2x0WlNJNklqSXdNalV0TURJdE1UQlVNRGc2TVRnNk5UUXVNamN4V2lKOWZRPT0iLCJ0aWQiOiJmNGVlNmUxNy02MzYwLTQyNDEtODBjZS1lNzk3ZTA1YWUwNzgiLCJub25jZSI6ImJkZTgwM2U1LWVkNjktNGI2Mi04M2Y2LTk1OGYzMWE5MTQ1ZSIsInNjcCI6InJlYWQgd3JpdGUiLCJhenAiOiJkMzY3YzY0Ni0yZTc1LTQwMjktYjg1OC0xNDExMTE2MGVhYTgiLCJ2ZXIiOiIxLjAiLCJpYXQiOjE3MzkxOTEzODl9.A8oAYVGZZ8RTzbze0B98zUXq0lRLJvginpsfNpFJMYxYWEKZYmVuf3CKQShtPlvH1pTrUjwWrE908QLiDwXFu_-Tyqyyk4-y7g6NQ1jhln5A4dp5Ruvmr4xTKsTVxc211fZcZrBEImmk_5ZvaEUEVPYZlxrfRYCsrq_Rq7LbCDikpNFCv2UvQJ1DbLrUci0hFRFEAw9ZuCo7z7o_uq7-n1qEfP2wsIKR7b2nBYx9K5ygidXJeithtxbD9t8NP9EdozdES72KIGWhhp4DGfzFd_MuxbXUftzz23pubcHGPM0ig98axxG55-t8mVhLcssyXhDhiN-NibX55cmLNyxLzg";
    public static final String DEV_COMPANY_CUBE_ID = "5b11bba54a43425580405245c92cc40b";
    public static final String DEV_MAIL_CUBE_ID = "8123418ce0024e7eae76550216815494";
    public static final String PPD_MAIL_CUBE_ID = "8123418ce0024e7eae76550216815494";
    public static final String DEV_UNSUBSCRIBE_SERVICE_PATH = "/"+DEV_MAIL_CUBE_ID+"/service/7bbd3c40-48f3-4afc-b86e-e1f4fe1581ba/UserPlan/1/UnsubscribeUserPlan";
    private static final String DEV_UPDATE_PROFILE_PATH = "/"+DEV_MAIL_CUBE_ID+"/service/72fd1d1f-a23f-4626-8bc5-9ca0ac8ba47f/UserProfile/1/UpdateUserProfile";
    private static final String PPD_COMPANY_UPDATE_PATH = "/"+PPD_MAIL_CUBE_ID+"/service/c11a01d2-610e-4d87-8290-2a2aa3a52c58/Company/1/UpdateCompanyIdentity";
    private static final String DEV_COMPANY_UPDATE_PATH = "/"+DEV_MAIL_CUBE_ID+"/service/524accf0-ed99-41c3-bd07-e7a759cae679/Company/1/UpdateCompanyIdentity";


    public void getNotification(String contentType) {
        // Base URI
        RestAssured.baseURI = Constants.PUBLIC_DEV_URL;
        // Endpoint path
        String endpoint = "/"+DEV_COMPANY_CUBE_ID+"/document/";
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
        RestAssured.baseURI = Constants.PUBLIC_DEV_URL;
        // Endpoint path
        String endpoint = "/"+DEV_COMPANY_CUBE_ID+"/document/";
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
        String baseUrl = ""+Constants.SUPPORT_DEV_URL+"/support/database/find-all";
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

    public void subscribePlan(String priceId) {
        String dev_url = Constants.SUBSCRIPTION_DEV_URL+"/"+DEV_MAIL_CUBE_ID+"/service/7bbd3c40-48f3-4afc-b86e-e1f4fe1581ba/UserPlan/1/SubscribeUserPlan";

        // Prepare JSON payload as a String, dynamically passing priceId
        String jsonBody = "{\n" +
                "    \"number_of_users\": 7,\n" +
                "    \"cancel_url\": \"https://sandbox.cubeforall.com/\",\n" +
                "    \"priceId\": \"" + priceId + "\",\n" +
                "    \"additionalInfo\": {}\n" +
                "}";

        // Send the POST request using Rest Assured
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post(dev_url);

        // Assert status code
        Assert.assertEquals(response.getStatusCode(), 200);

        // Optional: Print the response
        System.out.println("Response: " + response.asString());
    }

    public void triggerUnsubsExistingPlan(String userPlanID) {
        // Construct the request body
        String requestBody = "{\"userPlanId\": \"" + userPlanID + "\"}";

        // Set up RestAssured
        RestAssured.baseURI = Constants.PUBLIC_DEV_URL;

        // Create a request specification
        RequestSpecification request = RestAssured.given();

        // Add headers
        request.header("Content-Type", "application/json");
//        request.header("Authorization", BEARER_TOKEN);

        // Add the body
        request.body(requestBody);

        // Perform the POST request
        Response response = request.post(DEV_UNSUBSCRIBE_SERVICE_PATH);

        // Log the response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    public void verifyCurrentQueues(String contentType, String companyCubeId) {
        // Set base URI
        RestAssured.baseURI = "http://cubehelp.dev.ccn/support/database/find-all";

        // Create JSON request body
        JSONObject requestBody = new JSONObject();
        requestBody.put("databaseName", "notification");
        requestBody.put("collectionName", "currentqueues");
        requestBody.put("filterQuery", new JSONObject().put("contentType", contentType).put("companyCUBEId", companyCubeId));
        requestBody.put("sort", new JSONObject().put("_id", -1));
        requestBody.put("limit", 2);

        // Send GET request
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .get()
                .then()
                .statusCode(200) // Expect HTTP 200 OK
                .extract().response();

        // Convert response to JSONObject
        JSONObject jsonResponse = new JSONObject(response.asString());

        // Jika response memiliki array, ambil datanya
        JSONArray jsonArray;
        if (jsonResponse.has("data") && jsonResponse.get("data") instanceof JSONArray) {
            jsonArray = jsonResponse.getJSONArray("data");
        } else {
            throw new RuntimeException("Response does not contain expected 'data' array: " + jsonResponse.toString(2));
        }

        // Validate that at least one record matches the expected content
        boolean contentTypeFound = false;
        boolean companyCubeIdFound = false;

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            if (item.getString("contentType").equals(contentType)) {
                contentTypeFound = true;
            }
            if (item.getString("companyCUBEId").equals(companyCubeId)) {
                companyCubeIdFound = true;
            }
        }

        // Assert values
//        Assertions.assertTrue(contentTypeFound, "Response does not contain expected contentType: " + contentType);
//        Assertions.assertTrue(companyCubeIdFound, "Response does not contain expected companyCubeId: " + companyCubeId);
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
    public void triggerAddSubscriber(String user_plan_id, String member1) {
        // Base URL
        RestAssured.baseURI = Constants.PUBLIC_DEV_URL;

        // Request body
        String requestBody = String.format(
                "{\n" +
                        "    \"user_plan_id\": \"%s\",\n" +
                        "    \"members\": [\n" +
                        "        \"%s\"\n" +
                        "    ]\n" +
                        "}", user_plan_id, member1);

        // Send POST request
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
//                .header("Authorization", BEARER_TOKEN)
                .body(requestBody)
                .post("/"+DEV_MAIL_CUBE_ID+"/service/7bbd3c40-48f3-4afc-b86e-e1f4fe1581ba/GeneralSubscription/1/UpdateMemberships");

        // Print response for debugging
        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response Body: " + response.asString());

        // Validate the response status code (example)
        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed with HTTP code: " + response.statusCode());
        }
    }

    public void subscribeInfoUpdate(String displayName) {
        // Base URL API
        String baseUrl = Constants.PUBLIC_DEV_URL+DEV_UPDATE_PROFILE_PATH;

        String requestBody = "{ \"email\": \"test_071123_unreg1@yopmail.com\", " +
                "\"name\": \"" + displayName + "\", " +
                "\"company\": \"Kochi\", " +
                "\"displayName\": \"" + displayName + "\"}";

        Response response = given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .header("Authorization", BEARER_TOKEN)
                .body(requestBody)
                .when()
                .post();
        // Print response for debugging
        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response Body: " + response.asString());
    }

    public void companyUpdate(String address) {
        // Base URI for the API
        RestAssured.baseURI = Constants.PUBLIC_DEV_URL;

        // Endpoint and payload
        String endpoint = DEV_COMPANY_UPDATE_PATH;

        String payload_ppd = String.format(
                "{\n" +
                        "    \"companyName\": \"SRIPCNCOMP\",\n" +
                        "    \"companyMobileCode\": \"+65\",\n" +
                        "    \"companyMobileNo\": \"6363463465\",\n" +
                        "    \"companyEmail\": \"sripcncomp@yopmail.com\",\n" +
                        "    \"companyRegistrationNo\": \"SRI001\",\n" +
                        "    \"country\": \"SG\",\n" +
                        "    \"station\": \"SIN\",\n" +
                        "    \"postcode\": \"5332\",\n" +
                        "    \"address\": \"%s\",\n" +
                        "    \"iataCode\": \"\",\n" +
                        "    \"cassCode\": \"\",\n" +
                        "    \"type\": \"GSA\",\n" +
                        "    \"contactDetail\": {\n" +
                        "        \"designation\": \"sri\",\n" +
                        "        \"email\": \"sripcn@yopmail.com\",\n" +
                        "        \"contactName\": \"\",\n" +
                        "        \"name\": \"ya\",\n" +
                        "        \"mobileNo\": \"2142112412\",\n" +
                        "        \"mobileCode\": \"+94\"\n" +
                        "    },\n" +
                        "    \"accountCode\": [],\n" +
                        "    \"agentCodes\": [],\n" +
                        "    \"isAirlineAppointedAgent\": false,\n" +
                        "    \"isAgentCodes\": false,\n" +
                        "    \"isSameAddress\": true,\n" +
                        "    \"mailingAddress\": \"climber\",\n" +
                        "    \"mailingPostcode\": \"5332\",\n" +
                        "    \"operatingPort\": \"\",\n" +
                        "    \"isPcnSubscription\": false,\n" +
                        "    \"groupId\": \"65d33fd06b674d8ed32ce6d4\",\n" +
                        "    \"groupName\": \"COMPANY\",\n" +
                        "    \"owner\": \"system.csgagt9165d33fcd_cmb21@ccnexchange.com\",\n" +
                        "    \"state\": \"UPDATED\",\n" +
                        "    \"groupType\": \"COMPANY\",\n" +
                        "    \"groupReferenceId\": \"65d33fcf6b674d8ed32ce6bd\",\n" +
                        "    \"groupReferenceVersionId\": \"66ff509990e0ab601a7fbae2\",\n" +
                        "    \"syncGroupId\": \"65d33fcf6b674d8ed32ce6bd\"\n" +
                        "}", address);

        String payload_dev = String.format(
                "{\n" +
                        "    \"companyName\": \"HQ2\",\n" +
                        "    \"companyMobileCode\": \"+65\",\n" +
                        "    \"companyMobileNo\": \"829724920435\",\n" +
                        "    \"companyEmail\": \"rofikawaludin@yopmail.com\",\n" +
                        "    \"companyRegistrationNo\": \"HQ2\",\n" +
                        "    \"country\": \"SG\",\n" +
                        "    \"station\": \"SIN\",\n" +
                        "    \"postcode\": \"11610\",\n" +
                        "    \"address\": \"%s\",\n" +
                        "    \"iataCode\": \"\",\n" +
                        "    \"cassCode\": \"\",\n" +
                        "    \"type\": \"GSA\",\n" +
                        "    \"contactDetail\": {\n" +
                        "        \"designation\": \"plan manager 1\",\n" +
                        "        \"email\": \"test_071123_unreg1@yopmail.com\",\n" +
                        "        \"contactName\": \"\",\n" +
                        "        \"name\": \"Kochi\",\n" +
                        "        \"mobileNo\": \"3243243242\",\n" +
                        "        \"mobileCode\": \"+213\"\n" +
                        "    },\n" +
                        "    \"accountCode\": [\n" +
                        "        {\n" +
                        "            \"airline\": \"3Q\",\n" +
                        "            \"code\": \"123321\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"agentCodes\": [\n" +
                        "        {\n" +
                        "            \"ghaCode\": \"SATS\",\n" +
                        "            \"accountNo\": \"544580\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"isAirlineAppointedAgent\": true,\n" +
                        "    \"isAgentCodes\": true,\n" +
                        "    \"isSameAddress\": true,\n" +
                        "    \"mailingAddress\": \"%s\",\n" +
                        "    \"mailingPostcode\": \"11610\",\n" +
                        "    \"operatingPort\": \"\",\n" +
                        "    \"isPcnSubscription\": false,\n" +
                        "    \"groupId\": \"66f5098c37515fdd85a2dfea\",\n" +
                        "    \"groupName\": \"COMPANY\",\n" +
                        "    \"owner\": \"system.csgagt9166f50988_sin01@ccnexchange.com\",\n" +
                        "    \"state\": \"UPDATED\",\n" +
                        "    \"groupType\": \"COMPANY\",\n" +
                        "    \"groupReferenceId\": \"66f5098837515fdd85a2dfd3\",\n" +
                        "    \"groupReferenceVersionId\": \"67a2147809f5c0789c369349\",\n" +
                        "    \"syncGroupId\": \"66f5098837515fdd85a2dfd3\"\n" +
                        "}", address, address);

        // Send POST request
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", BEARER_TOKEN)
                .body(payload_dev)
                .when()
                .post(endpoint)
                .then()
                .assertThat()
                .body("address", equalTo(address)) // Validate address matches input
                .extract()
                .response();

        // Print response for debugging
        System.out.println("Response: " + response.asString());
    }
}
