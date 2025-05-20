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


    public static final String BEARER_TOKEN = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjVvN2dFX2VseE1kX2xpbUZKeWtpQ0F2dzdTTmVYQ24wbXZxTlRVTWVIbjQiLCJ0eXAiOiJKV1QifQ.eyJhdWQiOiJhYTkyMDA1YS02MzcwLTQ4MWItYWExNy1iYmNmNzhjMDgzYTciLCJpc3MiOiJodHRwczovL2NjbnNzb3BwZC5iMmNsb2dpbi5jb20vZTI0YjI4OWEtMzIzYi00YWRkLTg3NjUtYzcxYmFiOGIxOGEzL3YyLjAvIiwiZXhwIjoxNzQ3Mzg4Mjc5LCJuYmYiOjE3NDczODQ2NzksInN1YiI6IjYxMTEyYTVkLWU1MGMtNDRmZS1iMjYzLTg3MWNjMzU5MTg1ZSIsImVtYWlsIjoiYXV0b3FhLWNjbi0wMDFAeW9wbWFpbC5jb20iLCJuYW1lIjoiQXV0byBRQSBDQ04gMDAxIiwiZXh0ZW5zaW9uX0NvbnRhY3RObyI6Ijk4NzQzNjQzIiwiZXh0ZW5zaW9uX0N1YmVVc2VySUQiOiI4NzhmNDY1NS01YzQyLTQ3MmQtYWZlNS1lNmU3NTAxYWMxMTEiLCJjaXR5IjoiSktUIiwiZXh0ZW5zaW9uX0NvdW50cnlDb2RlIjoiU0ciLCJ1aWZvIjoiZXlKamRXSmxTV1FpT2lJNU16TTRObUV5TmpaaVpqWTBaREV4T0RObE9UTTROR1V5TURGbE5tVmhaU0lzSW5WelpYSlFiR0Z1U1dRaU9tNTFiR3dzSW5CeWFXTmxSR0YwWVNJNmJuVnNiQ3dpYzNSaGRIVnpJanAwY25WbExDSndjbTlrZFdOMFZHOXJaVzRpT201MWJHd3NJbk4wWVhSMWMxTjFZbk5qY21sd2RHbHZiaUk2SWtOVlFrVkdUMUpCVEV4ZlRVVk5Ra1ZTSWl3aWFYTk9aWGRWYzJWeUlqcG1ZV3h6WlN3aVkyOXRjR0Z1ZVNJNmV5SnVZVzFsSWpvaVFYVjBieUJSUVNCRGIyMXdZVzU1SWl3aVkyOTFiblJ5ZVNJNklsTkhJaXdpWTJsMGVTSTZJbE5KVGlKOUxDSndjbTltYVd4bElqcDdJbVZ0WVdsc0lqb2lZWFYwYjNGaExXTmpiaTB3TURGQWVXOXdiV0ZwYkM1amIyMGlMQ0p1WVcxbElqb2llWFFpZlN3aWJHRnpkRUZqZEdsMlpWTmxjM05wYjI0aU9uc2lYMmxrSWpvaU5qZ3lObVZpTlRBME5qSTFORGczTlRFNU5HWm1OVEZtSWl3aWJHOW5hVzVVYVcxbElqb2lNakF5TlMwd05TMHhObFF3Tnpvek56bzFNaTR4TlRkYUluMTkiLCJ0aWQiOiJlMjRiMjg5YS0zMjNiLTRhZGQtODc2NS1jNzFiYWI4YjE4YTMiLCJ0ZnAiOiJCMkNfMUFfNFNJR05VUF9TSUdOSU5ORVdVU0VSU1lOIiwibm9uY2UiOiI3NzhhMmU4OC1mZjRjLTQ4OTEtODI3My00OGUyNGU4ZmVlNTgiLCJzY3AiOiJyZWFkIHdyaXRlIiwiYXpwIjoiMjY4ZTU4N2ItYTk0Ny00MjFiLWE3MzctYjU1NzNjNmVhMDc1IiwidmVyIjoiMS4wIiwiaWF0IjoxNzQ3Mzg0Njc5fQ.q5seP0ME0RW4gFLknDVfHQ7T1baqCyHed-K5dD2UhXr-M1RKk-niM5wLuZ2KhzhDbAMRvsupRZ0Klh9U7HPq5LLXow2uEHp06-y96NX6vov2lxTTXmhYXOcsOe0m3oGLJoS-Mh7YUN_BbQl2FhZ34paqEZdX4-pQV3_l9t6RhYH4gTk0NqK7uZVNZe99CA_9riUjITvBey2pJgAGPCq6_swI9azD9QLdf359vtFaqqYEHjTfju3LITn6PAAqJtny7_5i4XE7JJNvBPlE2GyNAgyw9pgoHD6jQEXRk5b1mVaIm0-3fMx560zopARkVcYzNJ3t4S2ktFOjK9G2G7Gg5g";
    public static final String DEV_COMPANY_CUBE_ID = "5b11bba54a43425580405245c92cc40b";
    public static final String DEV_MAIL_CUBE_ID = "8123418ce0024e7eae76550216815494";
    public static final String PPD_MAIL_CUBE_ID = "a68703f70b8d4988a0cfae82b02e1f71";
    public static final String SUBSCRIBE_USERPLAN_PPD_SERVICE = "31bbd797-9265-4ea5-8477-ca783b38bd07";
    public static final String SERVICE_UPDATE_MEMBERSHIP = "31bbd797-9265-4ea5-8477-ca783b38bd07";
    public static final String DEV_UNSUBSCRIBE_SERVICE_PATH = "/"+DEV_MAIL_CUBE_ID+"/service/7bbd3c40-48f3-4afc-b86e-e1f4fe1581ba/UserPlan/1/UnsubscribeUserPlan";
    public static final String PPD_UNSUBSCRIBE_SERVICE_PATH = "/"+PPD_MAIL_CUBE_ID+"/service/31bbd797-9265-4ea5-8477-ca783b38bd07/UserPlan/1/UnsubscribeUserPlan";
    private static final String DEV_UPDATE_PROFILE_PATH = "/"+DEV_MAIL_CUBE_ID+"/service/72fd1d1f-a23f-4626-8bc5-9ca0ac8ba47f/UserProfile/1/UpdateUserProfile";
    private static final String PPD_UPDATE_PROFILE_PATH = "/"+PPD_MAIL_CUBE_ID+"/service/8ee57fd5-3173-442c-a99b-2fc25702b108/UserProfile/1/UpdateUserProfile";
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
        String dev_url = Constants.SUBSCRIPTION_PPD_URL+"/"+PPD_MAIL_CUBE_ID+"/service/"+SUBSCRIBE_USERPLAN_PPD_SERVICE+"/UserPlan/1/SubscribeUserPlan";

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

//        // Assert status code
//        Assert.assertEquals(response.getStatusCode(), 200);

        // Optional: Print the response
        System.out.println("Response: " + response.asString());
    }

    public void triggerUnsubsExistingPlan(String userPlanID) {
        // Construct the request body
        String requestBody = "{\"userPlanId\": \"" + userPlanID + "\"}";

        // Set up RestAssured
        RestAssured.baseURI = Constants.PUBLIC_PPD_URL;

        // Create a request specification
        RequestSpecification request = RestAssured.given();

        // Add headers
        request.header("Content-Type", "application/json");
        request.header("Authorization", BEARER_TOKEN);

        // Add the body
        request.body(requestBody);

        // Perform the POST request
        Response response = request.post(PPD_UNSUBSCRIBE_SERVICE_PATH);

        // Log the response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    public void verifyCurrentQueues(String contentType, String companyCubeId) {
        // Set base URI
        RestAssured.baseURI = Constants.SUPPORT_PPD_URL;

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

        // If response have array, retrieve the data
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
        RestAssured.baseURI = Constants.PUBLIC_PPD_URL;

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
                .post(""+PPD_MAIL_CUBE_ID+"/service/"+SERVICE_UPDATE_MEMBERSHIP+"/GeneralSubscription/1/UpdateMemberships");

        // Print response for debugging
        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response Body: " + response.asString());

        // Validate the response status code (example)
//        if (response.statusCode() != 200) {
//            throw new RuntimeException("Failed with HTTP code: " + response.statusCode());
//        }
    }
    public void triggerAddSubscriber(String user_plan_id, String member1) {
        // Base URL
        RestAssured.baseURI = Constants.PUBLIC_PPD_URL;

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
                .post(""+PPD_MAIL_CUBE_ID+"/service/"+SERVICE_UPDATE_MEMBERSHIP+"/GeneralSubscription/1/UpdateMemberships");

        // Print response for debugging
        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response Body: " + response.asString());

        // Validate the response status code (example)
//        if (response.statusCode() != 200) {
//            throw new RuntimeException("Failed with HTTP code: " + response.statusCode());
//        }
    }

    public void subscribeInfoUpdate(String displayName) {
        // Base URL API
        String baseUrl = Constants.PUBLIC_PPD_URL+PPD_UPDATE_PROFILE_PATH;

        String requestBody = "{ \"email\": \"sgpcn@yopmail.com\", " +
                "\"name\": \"" + displayName + "\", " +
                "\"company\": \"SGPCNCOMP\", " +
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
    public void updateCompanyMultipleTimes(String address) {
        for (int i = 1; i <= 7; i++) {
            String addressu = address + i; // Generate different address for each iteration
            System.out.println("Updating company with address: " + addressu);
            companyUpdate(address);
        }}

    public void companyUpdate(String address) {
        // Base URI for the API
        RestAssured.baseURI = Constants.PUBLIC_PPD_URL;

        // Endpoint and payload
        String endpoint = PPD_COMPANY_UPDATE_PATH;

        String payload_ppd = String.format(
                "{\n" +
                        "    \"companyName\": \"Auto QA Company\",\n" +
                        "    \"companyMobileCode\": \"+65\",\n" +
                        "    \"companyMobileNo\": \"8365456232\",\n" +
                        "    \"companyEmail\": \"auto@qa.com\",\n" +
                        "    \"companyRegistrationNo\": \"AUTO\",\n" +
                        "    \"country\": \"SG\",\n" +
                        "    \"station\": \"SIN\",\n" +
                        "    \"postcode\": \"90909\",\n" +
                        "    \"address\": \"%s\",\n" +
                        "    \"iataCode\": \"\",\n" +
                        "    \"cassCode\": \"\",\n" +
                        "    \"type\": \"GSA\",\n" +
                        "    \"contactDetail\": {\n" +
                        "        \"designation\": \"Mr\",\n" +
                        "        \"email\": \"autoqa-ccn-001@yopmail.com\",\n" +
                        "        \"contactName\": \"\",\n" +
                        "        \"name\": \"Automation User\",\n" +
                        "        \"mobileNo\": \"8346374565\",\n" +
                        "        \"mobileCode\": \"+62\"\n" +
                        "    },\n" +
                        "    \"accountCode\": [],\n" +
                        "    \"agentCodes\": [\n" +
                        "        {\n" +
                        "            \"ghaCode\": \"SATS\",\n" +
                        "            \"accountNo\": \"56757\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"isAirlineAppointedAgent\": false,\n" +
                        "    \"isAgentCodes\": true,\n" +
                        "    \"isSameAddress\": true,\n" +
                        "    \"mailingAddress\": \"%s\",\n" +
                        "    \"mailingPostcode\": \"90909\",\n" +
                        "    \"operatingPort\": \"\",\n" +
                        "    \"isPcnSubscription\": false,\n" +
                        "    \"groupId\": \"6639d233d1f60d20411b6440\",\n" +
                        "    \"groupName\": \"COMPANY\",\n" +
                        "    \"owner\": \"system.csgagt916639d233_cgk01@ccnexchange.com\",\n" +
                        "    \"state\": \"UPDATED\",\n" +
                        "    \"groupType\": \"COMPANY\",\n" +
                        "    \"groupReferenceId\": \"6639d233d1f60d20411b6424\",\n" +
                        "    \"groupReferenceVersionId\": \"68147e9bc0ac8181bd09616e\",\n" +
                        "    \"syncGroupId\": \"6639d233d1f60d20411b6424\"\n" +
                        "}", address, address);

        System.out.println(payload_ppd);


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
                .body(payload_ppd)
                .when()
                .post(endpoint)
                .then()
                .assertThat()
//                .body("address", equalTo(address)) // Validate address matches input
                .extract()
                .response();

        // Print response for debugging
        System.out.println("Response: " + response.asString());
    }
}
