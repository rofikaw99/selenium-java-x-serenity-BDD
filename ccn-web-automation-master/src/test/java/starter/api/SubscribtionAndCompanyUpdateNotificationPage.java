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


    public static final String BEARER_TOKEN = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjVvN2dFX2VseE1kX2xpbUZKeWtpQ0F2dzdTTmVYQ24wbXZxTlRVTWVIbjQiLCJ0eXAiOiJKV1QifQ.eyJhdWQiOiJhYTkyMDA1YS02MzcwLTQ4MWItYWExNy1iYmNmNzhjMDgzYTciLCJpc3MiOiJodHRwczovL2NjbnNzb3BwZC5iMmNsb2dpbi5jb20vZTI0YjI4OWEtMzIzYi00YWRkLTg3NjUtYzcxYmFiOGIxOGEzL3YyLjAvIiwiZXhwIjoxNzM5OTc2OTM3LCJuYmYiOjE3Mzk5NzMzMzcsInN1YiI6ImJkMjg0ZTk3LTA2NTUtNGY2ZC05NmRiLTg5ZjRkYWQyN2JiYiIsImVtYWlsIjoic2dwY25AeW9wbWFpbC5jb20iLCJuYW1lIjoiUUEgQ0NOIDU1Nzc3NTk3IiwiZXh0ZW5zaW9uX0NvbnRhY3RObyI6IjEyMzQ1Njc4IiwiZXh0ZW5zaW9uX0N1YmVVc2VySUQiOiIzMDA3ODU4ZC1kY2NkLTQyNDQtOGNiMS1lM2Q1ZTFmMjBhYjUiLCJjaXR5IjoiU0lOIiwiZXh0ZW5zaW9uX0NvdW50cnlDb2RlIjoiU0ciLCJ1aWZvIjoiZXlKamRXSmxTV1FpT2lKaFlUQXlaV001TXpnME5qRTBPVEUwT1RJeU16a3dOMlV5WWpCa1pXTTBaaUlzSW5WelpYSlFiR0Z1U1dRaU9tNTFiR3dzSW5CeWFXTmxSR0YwWVNJNmJuVnNiQ3dpYzNSaGRIVnpJanAwY25WbExDSndjbTlrZFdOMFZHOXJaVzRpT201MWJHd3NJbk4wWVhSMWMxTjFZbk5qY21sd2RHbHZiaUk2SWtOVlFrVkdUMUpCVEV4ZlRVVk5Ra1ZTSWl3aWFYTk9aWGRWYzJWeUlqcG1ZV3h6WlN3aVkyOXRjR0Z1ZVNJNmV5SnVZVzFsSWpvaUlpd2lZMjkxYm5SeWVTSTZJaUlzSW1OcGRIa2lPaUlpZlN3aWNISnZabWxzWlNJNmV5SmxiV0ZwYkNJNkluTm5jR051UUhsdmNHMWhhV3d1WTI5dElpd2libUZ0WlNJNklsbHZhR0Z1SW4wc0lteGhjM1JCWTNScGRtVlRaWE56YVc5dUlqcDdJbDlwWkNJNklqWTNZalZrTjJFd05HUTVOMlpoTURrM1ltUmpaVGc1TVNJc0lteHZaMmx1VkdsdFpTSTZJakl3TWpVdE1ESXRNVGxVTVRNNk1EYzZORFF1TURReVdpSjlmUT09IiwidGlkIjoiZTI0YjI4OWEtMzIzYi00YWRkLTg3NjUtYzcxYmFiOGIxOGEzIiwidGZwIjoiQjJDXzFBXzRTSUdOVVBfU0lHTklOTkVXVVNFUlNZTiIsIm5vbmNlIjoiMTIzN2U2NjQtMTYxOC00NjQzLWI3ZjQtMjEwYzczMTdjZGY3Iiwic2NwIjoicmVhZCB3cml0ZSIsImF6cCI6IjI2OGU1ODdiLWE5NDctNDIxYi1hNzM3LWI1NTczYzZlYTA3NSIsInZlciI6IjEuMCIsImlhdCI6MTczOTk3MzMzN30.aSY5fBZz9XJ1Ft-YvVgCWVFEVeeK8zydFqkp-Z6zrMi2QTzh65bc5TXAYaic4mT56wvwOtbqkdZ7QvljrIxezlS8qRXSw3AuxZgWO8eH3bG1a0n6xxnQ_fVWW71TYp1qSm1Z1pBB4H-vxVnbBX3Fg6ReDWXnoVGm64HtgoLWFZztFuhNXVi6kb702bBfmGpuTzoQEhwT4eLn_n9ZBI6V26x8Ny_Z4nSKeuJxmtkfA0fNABIIi3EjFh7TCvtq2ivBf7d_-Keh98OsAlIEuJz_hSRiD7ByZY0CffqPjR4Ko0rVpDAOK8TrhxJ0NeZemjoBrRgEJFwsMPkym9Y2zUC1Wg";
    public static final String DEV_COMPANY_CUBE_ID = "5b11bba54a43425580405245c92cc40b";
    public static final String DEV_MAIL_CUBE_ID = "8123418ce0024e7eae76550216815494";
    public static final String PPD_MAIL_CUBE_ID = "93dbecceee9c427faa8fd39347d56b35";
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

    public void companyUpdate(String address) {
        // Base URI for the API
        RestAssured.baseURI = Constants.PUBLIC_PPD_URL;

        // Endpoint and payload
        String endpoint = PPD_COMPANY_UPDATE_PATH;

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
                        "    \"accountCode\": [\n" +
                        "        {\n" +
                        "            \"airline\": \"3Q\",\n" +
                        "            \"code\": \"86779\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"agentCodes\": [\n" +
                        "        {\n" +
                        "            \"ghaCode\": \"SATS\",\n" +
                        "            \"accountNo\": \"5464564\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"isAirlineAppointedAgent\": true,\n" +
                        "    \"isAgentCodes\": true,\n" +
                        "    \"isSameAddress\": true,\n" +
                        "    \"mailingAddress\": \"%s\",\n" +
                        "    \"mailingPostcode\": \"5332\",\n" +
                        "    \"operatingPort\": \"\",\n" +
                        "    \"isPcnSubscription\": false,\n" +
                        "    \"groupId\": \"67b48ce7d81f3e5883cd82aa\",\n" +
                        "    \"groupName\": \"COMPANY\",\n" +
                        "    \"owner\": \"system.csgagt9165d33fcd_cmb21@ccnexchange.com\",\n" +
                        "    \"state\": \"UPDATED\",\n" +
                        "    \"groupType\": \"COMPANY\",\n" +
                        "    \"groupReferenceId\": \"65d33fcf6b674d8ed32ce6bd\",\n" +
                        "    \"groupReferenceVersionId\": \"67b48d89207ceab23ab2660b\",\n" +
                        "    \"syncGroupId\": \"65d33fcf6b674d8ed32ce6bd\"\n" +
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
                .body("address", equalTo(address)) // Validate address matches input
                .extract()
                .response();

        // Print response for debugging
        System.out.println("Response: " + response.asString());
    }
}
