package starter.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.common.mapper.TypeRef;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import starter.utlis.Constants;
import java.util.HashMap;
import java.util.Map;

import java.util.*;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class FWBResharingPage {
    private String url;

    public void setUrlApiListUser(){
        url = "https://reqres.in/api/users?page=2";
    }

    public void requestListUser(){
        given().when().get(url);
    }
    private static String documentID;
    private static String documentRefID;
    private static String awbNoTag;
    private static String documentIDshareForm;
    private static String documentIDshareExplicitForm;
    private static String documentIDshareVia;
    public void createDoc(String contentType, String contentName) {

        // API endpoint
        String endpoint = "https://cubesandbox.ccnexchange.com/3ec7938287c5464ca769a30b37ab3ee6/document";
        String serviceId = "4e6ae0d1-320a-4565-867e-778f939a58ab";

        // Request body
        String requestBody = "{\n" +
                "  \"contentName\": \""+contentName+"\",\n" +
                "  \"contentType\": \""+contentType+"\",\n" +
                "  \"contentMIME\": \""+contentName+"\",\n" +
                "  \"tags\": [\n" +
                "    \"awbNo:681-11112222\"\n" +
                "  ],\n" +
                "  \"encodedContent\": \"eyJhaXJXYXliaWxsTnVtYmVyIjoiNTU1NDIzMjEyMjYiLCJyb3V0aW5nIjp7ImJvb2tpbmdSZXF1ZXN0TnVtYmVyIjoiIiwiYm9va2luZ0RhdGUiOiIyMi81LzIwMjMgMzo1MTo0NyBQTSIsImJvb2tpbmdTdGF0dXMiOiJDb25maXJtZWQiLCJzZWdtZW50RGV0YWlsIjp7InRyYW5zcG9ydC1zZWdtZW50IjpbeyJ0cmFuc3BvcnRDb21wYW55IjoiU1EiLCJ0cmFuc3BvcnRJZGVudGlmaWVyIjoiU1EwMjMzIiwidHJhbnNwb3J0RGF0ZSI6IjIwMjMtMDUtMjMiLCJkZXBhcnR1cmVMb2NhdGlvbiI6IlNJTiIsImFycml2YWxMb2NhdGlvbiI6IkRYQiIsImJvb2tpbmdUeXBlIjoiIiwiYm9va2luZ1N0YXR1cyI6IktLIn1dfX0sInJlbWFya3MiOlt7ImlkIjoiOWRlZjAxMDQtM2E0Yy00Y2U3LTk1OWUtMzkxYTBlM2I1ZmE0IiwidGV4dCI6InRlc3QiLCJkYXRlX0NyZWF0ZWQiOiIyMDIzLTA1LTIyVDA3OjUxOjQ3LjUwOTU2MDNaIiwiaXNfU2VudCI6dHJ1ZSwiYXV0aG9yIjp7Im5hbWUiOiJUVC1TSU4iLCJlbWFpbCI6Im5lbWVzaW9fZ0BjY24uY29tLnNnIn19XSwiYm9va2luZ0ZpbGVzIjpbXX0=\"\n" +
                "}";

        // Sending PUT request
        Response response = RestAssured.given()
                .header("serviceId", serviceId)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put(endpoint);

        // Extracting documentID from response
        documentID = response.jsonPath().getString("documentID");
        documentRefID = response.jsonPath().getString("documentRefID");

        // Printing response
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        System.out.println("documentID: " + documentID);
        System.out.println("documentRefID: " + documentRefID);
    }

    public void createDocFromSystem(String contentType, String contentName) {

        // API endpoint
        String endpoint = "https://cubesandbox.ccnexchange.com/dcfa5ff0a3a94d288cdcaca2e36def94/document";
        String serviceId = "4e6ae0d1-320a-4565-867e-778f939a58ab";

        // Request body
        String requestBody = "{\n" +
                "  \"contentName\": \""+contentName+"\",\n" +
                "  \"contentType\": \""+contentType+"\",\n" +
                "  \"contentMIME\": \""+contentName+"\",\n" +
                "  \"tags\": [\n" +
                "    \"awbNo:681-11112222\"\n" +
                "  ],\n" +
                "  \"encodedContent\": \"eyJhaXJXYXliaWxsTnVtYmVyIjoiNTU1NDIzMjEyMjYiLCJyb3V0aW5nIjp7ImJvb2tpbmdSZXF1ZXN0TnVtYmVyIjoiIiwiYm9va2luZ0RhdGUiOiIyMi81LzIwMjMgMzo1MTo0NyBQTSIsImJvb2tpbmdTdGF0dXMiOiJDb25maXJtZWQiLCJzZWdtZW50RGV0YWlsIjp7InRyYW5zcG9ydC1zZWdtZW50IjpbeyJ0cmFuc3BvcnRDb21wYW55IjoiU1EiLCJ0cmFuc3BvcnRJZGVudGlmaWVyIjoiU1EwMjMzIiwidHJhbnNwb3J0RGF0ZSI6IjIwMjMtMDUtMjMiLCJkZXBhcnR1cmVMb2NhdGlvbiI6IlNJTiIsImFycml2YWxMb2NhdGlvbiI6IkRYQiIsImJvb2tpbmdUeXBlIjoiIiwiYm9va2luZ1N0YXR1cyI6IktLIn1dfX0sInJlbWFya3MiOlt7ImlkIjoiOWRlZjAxMDQtM2E0Yy00Y2U3LTk1OWUtMzkxYTBlM2I1ZmE0IiwidGV4dCI6InRlc3QiLCJkYXRlX0NyZWF0ZWQiOiIyMDIzLTA1LTIyVDA3OjUxOjQ3LjUwOTU2MDNaIiwiaXNfU2VudCI6dHJ1ZSwiYXV0aG9yIjp7Im5hbWUiOiJUVC1TSU4iLCJlbWFpbCI6Im5lbWVzaW9fZ0BjY24uY29tLnNnIn19XSwiYm9va2luZ0ZpbGVzIjpbXX0=\"\n" +
                "}";

        // Sending PUT request
        Response response = RestAssured.given()
                .header("serviceId", serviceId)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put(endpoint);

        // Extracting documentID from response
        documentID = response.jsonPath().getString("documentID");
        documentRefID = response.jsonPath().getString("documentRefID");

        // Printing response
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        System.out.println("documentID: " + documentID);
        System.out.println("documentRefID: " + documentRefID);
    }

    public void validatePima(String pima) {

        // API endpoint
        String endpoint = "http://chexsconfigurationapi.ppd.ccn/CHEXS/ValidatePima";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6IkNVQkVGT1JBTEwiLCJuYW1laWQiOiJDVUJFRk9SQUxMIiwibmJmIjoxNzI3NzYzOTM3LCJleHAiOjE3Mjc3ODU1MzcsImlhdCI6MTcyNzc2MzkzNywiaXNzIjoiQ0NOIn0.N1MbmsmCdSqMXMlhfEAAQSijMc9jcCzs5vhwIdY8qPk";

        // Sending GET request
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .queryParam("pimaAddress", pima)
                .when()
                .get(endpoint);

        // Printing response
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());

        // Asserting response
        response.then()
                .statusCode(200)
                .body("pima", equalTo(pima))
                .body("isSucceed", equalTo(true));

    }

    public void companyGroupInformation(String cubeID) {

        // API endpoint
        String endpoint = "https://cubeppd.ccnexchange.com/"+cubeID+"/group";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6IkNVQkVGT1JBTEwiLCJuYW1laWQiOiJDVUJFRk9SQUxMIiwibmJmIjoxNzI3NzYzOTM3LCJleHAiOjE3Mjc3ODU1MzcsImlhdCI6MTcyNzc2MzkzNywiaXNzIjoiQ0NOIn0.N1MbmsmCdSqMXMlhfEAAQSijMc9jcCzs5vhwIdY8qPk";

        // Sending GET request
        Response response = RestAssured.given()
                .header("Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .contentType(ContentType.JSON)
                .when()
                .post(endpoint);

        // Printing response
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());

        // Asserting response
        response.then()
                .statusCode(200)
                .body("groupName", not(equalTo("COMPANY")));

    }
    public void verifyEncodedContent(String companyCubeID, String egDocumentID) {
        // Base URI
        RestAssured.baseURI = "http://cube.sandbox.ccn";
        // Endpoint
        String endpoint = "/"+companyCubeID+"/document/content";
        // JSON request body
        String requestBody = "{\n" +
                "  \"documentID\": \""+egDocumentID+"\"\n" +
                "}";
        // Perform POST request
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)  // Set Content-Type to application/json
                .body(requestBody)  // Add JSON body
                .when()
                .post(endpoint);
        // Print response details
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }
    public void emailExchangeDocumentChecking(String companyCubeID) {
        RestAssured.baseURI = "https://cubesandbox.ccnexchange.com";
        // Endpoint
        String endpoint = "/"+companyCubeID+"/document";
        // Cookie value
        String cookie = "BIGipServerPPD_Cube_80=4006088876.20480.0000";
        // Perform POST request
        Response response = RestAssured
                .given()
                .header("Cookie", cookie) // Add the Cookie header
                .contentType(ContentType.JSON)
                .when()
                .post(endpoint);
        // Print response details
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    public void emailExchangeDocumentChecking2(String recipientCompanyCubeID) {
        RestAssured.baseURI = "https://cubesandbox.ccnexchange.com";
        // Endpoint
        String endpoint = "/"+recipientCompanyCubeID+"/document";
        // Cookie value
        String cookie = "BIGipServerPPD_Cube_80=4006088876.20480.0000";
        // Perform POST request
        Response response = RestAssured
                .given()
                .header("Cookie", cookie) // Add the Cookie header
                .contentType(ContentType.JSON)
                .when()
                .post(endpoint);
        // Print response details
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    public void createDocForShareVia(String contentType, String contentName) {

        // API endpoint
        String endpoint = "https://cubesandbox.ccnexchange.com/b0dcda17075048e2a3c5f996cd704c60/document";
        String serviceId = "4e6ae0d1-320a-4565-867e-778f939a58ab";

        // Request body
        String requestBody = "{\n" +
                "  \"contentName\": \""+contentName+"\",\n" +
                "  \"contentType\": \""+contentType+"\",\n" +
                "  \"contentMIME\": \""+contentName+"\",\n" +
                "  \"tags\": [\n" +
                "    \"awbNo:681-11112222\"\n" +
                "  ],\n" +
                "  \"encodedContent\": \"eyJhaXJXYXliaWxsTnVtYmVyIjoiNTU1NDIzMjEyMjYiLCJyb3V0aW5nIjp7ImJvb2tpbmdSZXF1ZXN0TnVtYmVyIjoiIiwiYm9va2luZ0RhdGUiOiIyMi81LzIwMjMgMzo1MTo0NyBQTSIsImJvb2tpbmdTdGF0dXMiOiJDb25maXJtZWQiLCJzZWdtZW50RGV0YWlsIjp7InRyYW5zcG9ydC1zZWdtZW50IjpbeyJ0cmFuc3BvcnRDb21wYW55IjoiU1EiLCJ0cmFuc3BvcnRJZGVudGlmaWVyIjoiU1EwMjMzIiwidHJhbnNwb3J0RGF0ZSI6IjIwMjMtMDUtMjMiLCJkZXBhcnR1cmVMb2NhdGlvbiI6IlNJTiIsImFycml2YWxMb2NhdGlvbiI6IkRYQiIsImJvb2tpbmdUeXBlIjoiIiwiYm9va2luZ1N0YXR1cyI6IktLIn1dfX0sInJlbWFya3MiOlt7ImlkIjoiOWRlZjAxMDQtM2E0Yy00Y2U3LTk1OWUtMzkxYTBlM2I1ZmE0IiwidGV4dCI6InRlc3QiLCJkYXRlX0NyZWF0ZWQiOiIyMDIzLTA1LTIyVDA3OjUxOjQ3LjUwOTU2MDNaIiwiaXNfU2VudCI6dHJ1ZSwiYXV0aG9yIjp7Im5hbWUiOiJUVC1TSU4iLCJlbWFpbCI6Im5lbWVzaW9fZ0BjY24uY29tLnNnIn19XSwiYm9va2luZ0ZpbGVzIjpbXX0=\"\n" +
                "}";

        // Sending PUT request
        Response response = RestAssured.given()
                .header("serviceId", serviceId)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put(endpoint);

        // Extracting documentID from response
        documentID = response.jsonPath().getString("documentID");
        documentRefID = response.jsonPath().getString("documentRefID");

        // Printing response
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        System.out.println("documentID: " + documentID);
        System.out.println("documentRefID: " + documentRefID);
    }

    public void createDocForVerifyAWBNo(String contentType, String contentName, String awbNo) {

        // API endpoint
        String endpoint = ""+Constants.PUBLIC_PPD_URL+"/93386a266bf64d1183e9384e201e6eae/document";
        //local
//        String endpoint = "https://db27-182-1-114-1.ngrok-free.app/93386a266bf64d1183e9384e201e6eae/document";
        String serviceId = "4e6ae0d1-320a-4565-867e-778f939a58ab";

        // Request body
        String requestBody = "{\n" +
                "  \"contentName\": \""+contentName+"\",\n" +
                "  \"contentType\": \""+contentType+"\",\n" +
                "  \"contentMIME\": \""+contentName+"\",\n" +
                "  \"tags\": [\n" +
                "    \""+awbNo+"\"\n" +
                "  ],\n" +
                "  \"encodedContent\": \"eyJhaXJXYXliaWxsTnVtYmVyIjoiNTU1NDIzMjEyMjYiLCJyb3V0aW5nIjp7ImJvb2tpbmdSZXF1ZXN0TnVtYmVyIjoiIiwiYm9va2luZ0RhdGUiOiIyMi81LzIwMjMgMzo1MTo0NyBQTSIsImJvb2tpbmdTdGF0dXMiOiJDb25maXJtZWQiLCJzZWdtZW50RGV0YWlsIjp7InRyYW5zcG9ydC1zZWdtZW50IjpbeyJ0cmFuc3BvcnRDb21wYW55IjoiU1EiLCJ0cmFuc3BvcnRJZGVudGlmaWVyIjoiU1EwMjMzIiwidHJhbnNwb3J0RGF0ZSI6IjIwMjMtMDUtMjMiLCJkZXBhcnR1cmVMb2NhdGlvbiI6IlNJTiIsImFycml2YWxMb2NhdGlvbiI6IkRYQiIsImJvb2tpbmdUeXBlIjoiIiwiYm9va2luZ1N0YXR1cyI6IktLIn1dfX0sInJlbWFya3MiOlt7ImlkIjoiOWRlZjAxMDQtM2E0Yy00Y2U3LTk1OWUtMzkxYTBlM2I1ZmE0IiwidGV4dCI6InRlc3QiLCJkYXRlX0NyZWF0ZWQiOiIyMDIzLTA1LTIyVDA3OjUxOjQ3LjUwOTU2MDNaIiwiaXNfU2VudCI6dHJ1ZSwiYXV0aG9yIjp7Im5hbWUiOiJUVC1TSU4iLCJlbWFpbCI6Im5lbWVzaW9fZ0BjY24uY29tLnNnIn19XSwiYm9va2luZ0ZpbGVzIjpbXX0=\"\n" +
                "}";

        // Sending PUT request
        Response response = RestAssured.given()
                .header("serviceId", serviceId)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put(endpoint);

        // Extracting documentID from response
        documentID = response.jsonPath().getString("documentID");
        documentRefID = response.jsonPath().getString("documentRefID");

        // Printing response
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        System.out.println("documentID: " + documentID);
        System.out.println("documentRefID: " + documentRefID);
    }

    public void verifyAWBNumber(String contentType, String awbNo) {
        // API endpoint and request body
        String url = ""+Constants.PUBLIC_PPD_URL+"/93386a266bf64d1183e9384e201e6eae/document";
        //local
//        String url = "https://db27-182-1-114-1.ngrok-free.app/93386a266bf64d1183e9384e201e6eae/document";
        String requestBody = "{\n" +
                "    \"contentTypes\": [\"" + contentType + "\"],\n" +
                "    \"tags\": [\n" +
                "        \"" + awbNo + "\"\n" +
                "    ]\n" +
                "}";

        // Sending the request using RestAssured
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post(url);


        String documentAWBNumber = response.jsonPath().getString("tags");

        // Printing response
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        // Print the AWB number
        System.out.println("Extracted AWB Number: " + documentAWBNumber);
        // Verify that the extracted AWB number matches the expected value
//        Assert.assertEquals(documentAWBNumber, awbNo, "AWB No does not match");
    }
    public void verify_the_document_should_appear_in_the_company_system(String contentType, String awbNo) {
        // API endpoint and request body
        String url = ""+Constants.PUBLIC_PPD_URL+"/b5631389e2244eb1ac5243195c250d68/document";
        //local
//        String url = "https://db27-182-1-114-1.ngrok-free.app/b5631389e2244eb1ac5243195c250d68/document";
        String requestBody = "{\n" +
                "    \"contentTypes\": [\"" + contentType + "\"],\n" +
                "    \"tags\": [\n" +
                "        \"" + awbNo + "\"\n" +
                "    ]\n" +
                "}";

        // Sending the request using RestAssured
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post(url);

        String documentAWBNumber = response.jsonPath().getString("tags");

        // Printing response
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        // Print the AWB number
        System.out.println("Extracted AWB Number: " + documentAWBNumber);
    }
    public void verify_another_user_in_the_same_company_should_also_be_able_to_view_the_document_created(String contentType, String awbNo) {
        // API endpoint and request body
        String url = ""+Constants.PUBLIC_PPD_URL+"/6cb86189a54b462491065d6f94eb680e/document";
        //local
//        String url = "https://db27-182-1-114-1.ngrok-free.app/6cb86189a54b462491065d6f94eb680e/document";
        String requestBody = "{\n" +
                "    \"contentTypes\": [\"" + contentType + "\"],\n" +
                "    \"tags\": [\n" +
                "        \"" + awbNo + "\"\n" +
                "    ]\n" +
                "}";

        // Sending the request using RestAssured
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post(url);

        String documentAWBNumber = response.jsonPath().getString("tags");

        // Printing response
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        // Print the AWB number
        System.out.println("Extracted AWB Number: " + documentAWBNumber);

    }
    public void testGetDocumentContent() {
        // Base URI
        RestAssured.baseURI = Constants.PUBLIC_PPD_URL;

        // Request payload
        String requestBody = "{\n" +
                "  \"documentID\": \"" + documentID + "\"\n" +
                "}";

        // Perform POST request and extract response
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Cookie", "1b1003=pgyFsHEcyjtjlQgpOcVZ2rS2H9dcTI2d0B9hs/JDeGrBKyAEaVSlFbBvaXHASuJtXI2xyD6h9N7wMVn7POG/P+0RiE8r1Qe/BidtxSvVQiWaPTMM2xZOkyFEnnT1erSB+vvEnYbUebl6sdTgaz9e5sJOT7J+L4jJcHBPlNjT8PMhWcqY")
                .body(requestBody)
                .when()
                .post("/93386a266bf64d1183e9384e201e6eae/document/content")
                .then()
                .statusCode(200)
                .body("documentID", notNullValue())
                .body("encodedContent", notNullValue())
                .extract().response();

        // Extract values
        String documentID = response.jsonPath().getString("documentID");
        String encodedContent = response.jsonPath().getString("encodedContent");

        // Print values
        System.out.println("Document ID: " + documentID);
        System.out.println("Encoded Content: " + encodedContent);
    }
    public void patchDocumentWithLatestData() {
        String cookieHeader = "1b1003=3elDKU5MMi6xAMbtKnQhJQc65QjwIy8nQVDFR3CwbZipZxC3SqvUhH5R/ugt6zkOmE6oJDZ4d/4hYkk7vH9XNlQmFuiAE78lu891aOKxfUqQAhqeuCbxZowzNyiSotSE5ARVac6ol2VDy1Ja6sLfXazf9tirEM+L7QVJqnKVidVBw2ey";

        // 1. Get latest documents
        Response getResponse = RestAssured.given()
                .baseUri(Constants.PUBLIC_PPD_URL)
                .header("Cookie", cookieHeader)
                .contentType(ContentType.JSON)
                .post("/93386a266bf64d1183e9384e201e6eae/document/");

        // Parse JSON response
        JsonPath jsonPath = getResponse.jsonPath();
        List<Map<String, Object>> documentList = jsonPath.getList("$");

        if (documentList == null || documentList.isEmpty()) {
            System.out.println("No documents returned from the GET call.");
            return;
        }

        // 2. Get top document and prepare PATCH data
        Map<String, Object> topDocument = documentList.get(0);

        Map<String, Object> patchBody = new LinkedHashMap<>();
        patchBody.put("documentID", topDocument.get("documentID"));
        patchBody.put("documentReferenceVersionID", topDocument.get("documentReferenceVersionID"));
        patchBody.put("documentVersionID", topDocument.get("documentVersionID"));
        patchBody.put("contentName", topDocument.get("contentName"));
        patchBody.put("contentType", topDocument.get("contentType"));
        patchBody.put("contentMIME", topDocument.get("documentVersionID")); // dynamic
        patchBody.put("tags", topDocument.get("tags"));
        patchBody.put("owner", topDocument.get("owner"));
        patchBody.put("createdByServiceID", topDocument.get("createdByServiceID"));
        patchBody.put("state", topDocument.get("state"));
        patchBody.put("readTimeStamp", topDocument.get("readTimeStamp"));
        patchBody.put("from", topDocument.get("from"));
        patchBody.put("to", topDocument.get("to"));
        patchBody.put("lastUpdateBy", topDocument.get("lastUpdateBy"));
        patchBody.put("lastReceivedTimeStamp", topDocument.get("lastReceivedTimeStamp"));
        patchBody.put("timeStamp", topDocument.get("timeStamp"));
        patchBody.put("lastSharedTimeStamp", topDocument.get("lastSharedTimeStamp"));
        patchBody.put("from", topDocument.get("owner"));
        patchBody.put("to", topDocument.get("to"));

        // Tambahan field yang tidak ada di POST response
        patchBody.put("state", "UPDATED");

        // 3. Send PATCH request
        Response patchResponse = RestAssured.given()
                .baseUri(Constants.PUBLIC_PPD_URL)
                .header("Cookie", cookieHeader)
                .contentType(ContentType.JSON)
                .body(patchBody)
                .patch("/93386a266bf64d1183e9384e201e6eae/document");

        System.out.println("PATCH status: " + patchResponse.statusCode());
        System.out.println("PATCH response: " + patchResponse.getBody().asString());
    }
    public void retrieveDBPlatform(String email) {
        String apiKeyDBPlatform = "7f4b3d9c-2a1e-41c5-b8f7-a9d6e3f9c1a2";
        String apiKeyDB = "b0dcda17075048e2a3c5f996cd704c60";

        // 1. GET from /databasePlatform/find-all
        Response findAllResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("x-api-key", apiKeyDBPlatform)
                .body(Map.of(
                        "databaseName", "cubePlatform",
                        "collectionName", "cubes",
                        "filterQuery", Map.of("email", email)
                ))
                .when()
                .get("http://cubehelp.sandbox.ccn/support/databasePlatform/find-all");

        System.out.println("Response 1 - find-all:\n" + findAllResponse.getBody().asPrettyString());

        @SuppressWarnings("unchecked")
        Map<Object, Object> rawData = findAllResponse.jsonPath().getMap("data[0]");
        Map<String, Object> retrievedData = convertToStringKeyMap(rawData);

        // 2. POST to /database/create-one
        Response insertCubesResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("x-api-key", apiKeyDB)
                .header("email", "headquarter_sq@yopmail.com")
                .header("Cookie", "connect.sid=abc123")
                .body(Map.of(
                        "databaseName", "cubePlatform",
                        "collectionName", "cubes",
                        "insertedData", retrievedData
                ))
                .when()
                .post("http://cubehelp.sandbox.ccn/support/database/create-one");

        System.out.println("Response 2 - insert cubes:\n" + insertCubesResponse.getBody().asPrettyString());

        // 3. GET profile
        Response profileResponse = RestAssured
                .given()
                .get("http://cube.sandbox.ccn/profile/get-profile/" + email);

        System.out.println("Response 3 - get profile:\n" + profileResponse.getBody().asPrettyString());

        @SuppressWarnings("unchecked")
        Map<Object, Object> rawProfileData = profileResponse.as(Map.class);
        Map<String, Object> profileData = convertToStringKeyMap(rawProfileData);
        profileData.put("displayName", profileData.get("name"));

        // 4. POST to /databasePlatform/create-one
        Response insertUserProfileDBPlatform = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("x-api-key", apiKeyDBPlatform)
                .header("email", "headquarter_sq@yopmail.com")
                .header("Cookie", "connect.sid=abc123")
                .body(Map.of(
                        "databaseName", "cubePlatform",
                        "collectionName", "userprofiles",
                        "insertedData", profileData
                ))
                .when()
                .post("http://cubehelp.sandbox.ccn/support/databasePlatform/create-one");

        System.out.println("Response 4 - insert userprofiles (Platform):\n" + insertUserProfileDBPlatform.getBody().asPrettyString());

        // 5. POST to /database/create-one
        Response insertUserProfileStandard = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("x-api-key", apiKeyDB)
                .header("email", "headquarter_sq@yopmail.com")
                .header("Cookie", "connect.sid=abc123")
                .body(Map.of(
                        "databaseName", "cubePlatform",
                        "collectionName", "userprofiles",
                        "insertedData", profileData
                ))
                .when()
                .post("http://cubehelp.sandbox.ccn/support/database/create-one");

        System.out.println("Response 5 - insert userprofiles (Standard):\n" + insertUserProfileStandard.getBody().asPrettyString());
    }

    // Helper: Convert Map<Object, Object> to Map<String, Object>
    private Map<String, Object> convertToStringKeyMap(Map<?, ?> input) {
        Map<String, Object> result = new HashMap<>();
        for (Map.Entry<?, ?> entry : input.entrySet()) {
            if (entry.getKey() instanceof String) {
                result.put((String) entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
    private String baseUrl = "https://cubedev.ccnexchange.com/93386a266bf64d1183e9384e201e6eae";
    private String patchUrl = "http://cube.sandbox.ccn/93386a266bf64d1183e9384e201e6eae/document";

    public void automateDocumentUpdate(String contentType, String awbNo, String newDepartureDate) throws Exception {
                String cookieValue = "1b1003=G4aRLbIkDmUjtxiVb524fF1HXvKALhE0ByXqQ6Ec5EdLmn9jIv6gQ03JEkbvobFHwEW13ILmhn++YonZJyI6T06I1U7Q+kCtLiEG9Xjr5c4z4oANA4j5w1kbbs4hP6NEYU+V7Ht9Ycv02FX9rNn9o0duZmXR2+Ho/ozSL8bIC+SFZNuH";
                // Request body as string
                String requestBody = "{\n" +
                        "    \"contentTypes\": [\"" + contentType + "\"],\n" +
                        "    \"tags\": [\n" +
                        "        \"" + awbNo + "\"\n" +
                        "    ]\n" +
                        "}";

                // POST request
                Response response = RestAssured
                        .given()
                        .header("Content-Type", "application/json")
                        .header("Cookie", cookieValue)
                        .body(requestBody)
                        .when()
                        .post(baseUrl + "/document")
                        .then()
                        .statusCode(200)
                        .extract().response();

                // Type-safe list mapping
                List<Map<String, Object>> documents = response.jsonPath().getObject("", new TypeRef<List<Map<String, Object>>>() {});
                if (documents.isEmpty()) {
                    throw new RuntimeException("No document found for AWB: " + awbNo);
                }

                Map<String, Object> document = documents.get(0);

                // Update departureDate in tags
                Object tagObj = document.get("tags");
                if (tagObj instanceof List<?>) {
                    List<String> tags = new ArrayList<>();
                    for (Object tag : (List<?>) tagObj) {
                        String tagStr = String.valueOf(tag);
                        if (tagStr.startsWith("departureDate:")) {
                            tags.add("departureDate:" + newDepartureDate);
                        } else {
                            tags.add(tagStr);
                        }
                    }
                    document.put("tags", tags);
                }

                // PATCH request
                ObjectMapper mapper = new ObjectMapper();
                String patchBody = mapper.writeValueAsString(document);

                Response patchResponse = RestAssured
                        .given()
                        .header("Content-Type", "application/json")
                        .body(patchBody)
                        .when()
                        .patch(patchUrl)
                        .then()
                        .statusCode(200)
                        .extract().response();

                System.out.println("PATCH success: " + patchResponse.asString());
    }
    public void awb1000times() {

//        // Base URL and headers setup
//        String baseUrl = "https://cubesandbox.ccnexchange.com/b0dcda17075048e2a3c5f996cd704c60/document";
//        RequestSpecification requestSpec = new RequestSpecBuilder()
//                .setBaseUri(baseUrl)
//                .addHeader("serviceId", "4e6ae0d1-320a-4565-867e-778f939a58ab")
//                .addHeader("Content-Type", "application/json")
//                .addHeader("Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
//                .build();
//
//        ResponseSpecification responseSpec = new ResponseSpecBuilder()
//                .expectStatusCode(200) // Assuming a 200 status code is expected
//                .build();
//
//        // Loop to send 1000 requests
//        for (int i = 1; i <= 1; i++) {
//            String awbNo = "618-" + (32789454 + i); // Generate dynamic AWB number
//
//            String requestBody = String.format(
//                    "{\n" +
//                            "    \"contentName\": \"%s\",\n" +
//                            "    \"contentType\": \"Booking\",\n" +
//                            "    \"contentMIME\": null,\n" +
//                            "    \"tags\": [\n" +
//                            "        \"status:Confirmed\",\n" +
//                            "        \"awbNo:%s\",\n" +
//                            "        \"owner:batiktrimulyo@gmail.com\",\n" +
//                            "        \"forwarderEmail:batiktrimulyo@gmail.com\",\n" +
//                            "        \"origin:CMB\",\n" +
//                            "        \"awbPrefix:618\",\n" +
//                            "        \"destination:BNE\",\n" +
//                            "        \"jobID:4fd4cb8a-5fea-4e4f-b1f3-74011b389917\",\n" +
//                            "        \"isAllowSendFFR:False\",\n" +
//                            "        \"companyName:CEF LOGISTICS (PVT) LTD\",\n" +
//                            "        \"isFromBC:True\",\n" +
//                            "        \"isDGRCommodity:False\",\n" +
//                            "        \"specialHandlingCodes:EAW\",\n" +
//                            "        \"flightNo:0469\",\n" +
//                            "        \"flightDate:25/09/2024 00:00:00 AM\",\n" +
//                            "        \"carrierCode:SQ\"\n" +
//                            "    ],\n" +
//                            "    \"encodedContent\": \"ewogICJEb\"\n" +
//                            "}", awbNo, awbNo);
//
//            // Make the PUT request
//            Response response = RestAssured
//                    .given()
//                    .spec(requestSpec)
//                    .body(requestBody)
//                    .when()
//                    .put()
//                    .then()
//                    .spec(responseSpec)
//                    .extract()
//                    .response();
//
//            // Print response status and details
//            System.out.println("Iteration " + i + ": Status Code " + response.getStatusCode() +
//                    ", Response: " + response.getBody().asString());
//        }

        // Base URL and headers setup
        String baseUrl = "https://cubesandbox.ccnexchange.com/363b527ca33941d7acfafec6012ce4ca/document";
//        String baseUrl = "https://cube.ccnexchange.com/c8083437160b40bf9349cc782733e548/document";
//        String baseUrl = "https://cubedev.ccnexchange.com/7d102148f14c41b891f38d85744aa429//document";
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addHeader("serviceId", "4e6ae0d1-320a-4565-867e-778f939a58ab")
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .build();

        ResponseSpecification responseSpec = new ResponseSpecBuilder()
//                .expectStatusCode(200) // Assuming a 200 status code is expected
                .build();

        // Loop to send 1000 requests
        for (int i = 1; i <= 1000; i++) {
            String awbNo = "618-" + (62787454 + i); // Generate dynamic AWB number

            String requestBody = String.format(
                    "{\n" +
                            "    \"contentName\": \"%s\",\n" +
                            "    \"contentType\": \"BookingRequest\",\n" +
                            "    \"contentMIME\": null,\n" +
                            "    \"tags\": [\n" +
                            "        \"status:Confirmed\",\n" +
                            "        \"awbNo:%s\",\n" +
                            "        \"owner:au-auto-001@yopmail.com\",\n" +
                            "        \"forwarderEmail:au-auto-001@yopmail.com\",\n" +
                            "        \"origin:CMB\",\n" +
                            "        \"awbPrefix:618\",\n" +
                            "        \"destination:BNE\",\n" +
                            "        \"jobID:4fd4cb8a-5fea-4e4f-b1f3-74011b389917\",\n" +
                            "        \"isAllowSendFFR:False\",\n" +
                            "        \"companyName:CEF LOGISTICS (PVT) LTD\",\n" +
                            "        \"isFromBC:True\",\n" +
                            "        \"isDGRCommodity:False\",\n" +
                            "        \"specialHandlingCodes:EAW\",\n" +
                            "        \"flightNo:0469\",\n" +
                            "        \"flightDate:25/09/2024 00:00:00 AM\",\n" +
                            "        \"carrierCode:SQ\"\n" +
                            "    ],\n" +
                            "    \"encodedContent\": \"ewogICJEb\"\n" +
                            "}", awbNo, awbNo);

            // Make the PUT request
            Response response = RestAssured
                    .given()
                    .spec(requestSpec)
                    .body(requestBody)
                    .when()
                    .put()
                    .then()
                    .spec(responseSpec)
                    .extract()
                    .response();

            // Print response status and details
            System.out.println("Iteration " + i + ": Status Code " + response.getStatusCode() +
                    ", Response: " + response.getBody().asString());
        }
    }

    public void createDocShipmentStatusForShareVia(String contentType, String contentName) {

        // API endpoint
        String endpoint = ""+Constants.PUBLIC_PPD_URL+"/b0dcda17075048e2a3c5f996cd704c60/document";
        String serviceId = "4e6ae0d1-320a-4565-867e-778f939a58ab";

        // Request body
        String requestBody = "{\n" +
                "  \"contentName\": \""+contentName+"\",\n" +
                "  \"contentType\": \""+contentType+"\",\n" +
                "  \"contentMIME\": \""+contentName+"\",\n" +
                "  \"tags\": [\n" +
                "    \"awbNo:681-11112222\",\n" +
                "    \"origin:SIN\",\n" +
                "    \"destination:CAN\",\n" +
                "    \"statusCode:FOH\"\n" +
                "  ],\n" +
                "  \"encodedContent\": \"eyJhaXJXYXliaWxsTnVtYmVyIjoiNTU1NDIzMjEyMjYiLCJyb3V0aW5nIjp7ImJvb2tpbmdSZXF1ZXN0TnVtYmVyIjoiIiwiYm9va2luZ0RhdGUiOiIyMi81LzIwMjMgMzo1MTo0NyBQTSIsImJvb2tpbmdTdGF0dXMiOiJDb25maXJtZWQiLCJzZWdtZW50RGV0YWlsIjp7InRyYW5zcG9ydC1zZWdtZW50IjpbeyJ0cmFuc3BvcnRDb21wYW55IjoiU1EiLCJ0cmFuc3BvcnRJZGVudGlmaWVyIjoiU1EwMjMzIiwidHJhbnNwb3J0RGF0ZSI6IjIwMjMtMDUtMjMiLCJkZXBhcnR1cmVMb2NhdGlvbiI6IlNJTiIsImFycml2YWxMb2NhdGlvbiI6IkRYQiIsImJvb2tpbmdUeXBlIjoiIiwiYm9va2luZ1N0YXR1cyI6IktLIn1dfX0sInJlbWFya3MiOlt7ImlkIjoiOWRlZjAxMDQtM2E0Yy00Y2U3LTk1OWUtMzkxYTBlM2I1ZmE0IiwidGV4dCI6InRlc3QiLCJkYXRlX0NyZWF0ZWQiOiIyMDIzLTA1LTIyVDA3OjUxOjQ3LjUwOTU2MDNaIiwiaXNfU2VudCI6dHJ1ZSwiYXV0aG9yIjp7Im5hbWUiOiJUVC1TSU4iLCJlbWFpbCI6Im5lbWVzaW9fZ0BjY24uY29tLnNnIn19XSwiYm9va2luZ0ZpbGVzIjpbXX0=\"\n" +
                "}";

        // Sending PUT request
        Response response = RestAssured.given()
                .header("serviceId", serviceId)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put(endpoint);

        // Extracting documentID from response
        documentID = response.jsonPath().getString("documentID");
        documentRefID = response.jsonPath().getString("documentRefID");

        // Printing response
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        System.out.println("documentID: " + documentID);
        System.out.println("documentRefID: " + documentRefID);
    }

    public void testGetDocument() {
        String getEndpointUrl = "https://cubesandbox.ccnexchange.com/3ec7938287c5464ca769a30b37ab3ee6/document";

        // Use documentID obtained from previous request
        String requestBody = "{\n" +
                "  \"documentIDs\": [\n" +
                "    \"" + documentID + "\"\n" +
                "  ]\n" +
                "}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .body(requestBody)
                .when()
                .post(getEndpointUrl);

        // Handle response as needed
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
    }

    public void testShareDocument(String contact) {
        String endpointUrl = "https://cubesandbox.ccnexchange.com/3ec7938287c5464ca769a30b37ab3ee6/document/share";
        String serviceId = "7bbd3c40-48f3-4afc-b86e-e1f4fe1581ba";
        String groupId = "6294f9a1ac6979001216e74d";

        // Request payload
        String requestBody = "{\n" +
                "  \"documentID\": \"6833348a936b10e1a471c5b4\",\n" +
                "  \"contacts\": [\n" +
                "    \"" + contact + "\",\n" +
                "    \"system.csgair01sinfmsq@ccnexchange.com\"\n" +
                "  ]\n" +
                "}";

        // Sending PUT request
        Response response = RestAssured.given()
                .header("serviceid", serviceId)
                .header("groupid", groupId)
                .header("Content-Type", ContentType.JSON)
                .header("Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .body(requestBody)
                .when()
                .put(endpointUrl);

        documentIDshareForm = response.jsonPath().getString("documentID");
        // Printing response for verification
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
    }

    public void testShareExplicitDocument(String contact) {
        String endpointUrl = ""+Constants.PUBLIC_PPD_URL+"/93386a266bf64d1183e9384e201e6eae/document/share";
        String serviceId = "7bbd3c40-48f3-4afc-b86e-e1f4fe1581ba";
        String groupId = "6294f9a1ac6979001216e74d";

        // Request payload
        String requestBody = "{\n" +
                "  \"documentID\": \"" + documentID + "\",\n" +
                "  \"contacts\": [\n" +
                "    \"" + contact + "\",\n" +
                "    \"system.csgair01sinfmsq@ccnexchange.com\"\n" +
                "  ]\n" +
                "}";

        // Sending PUT request
        Response response = RestAssured.given()
                .header("serviceid", serviceId)
                .header("groupid", groupId)
                .header("Content-Type", ContentType.JSON)
                .header("Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .body(requestBody)
                .when()
                .put(endpointUrl);
        documentIDshareExplicitForm = response.jsonPath().getString("documentID");

        // Printing response for verification
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        int statusCode = response.getStatusCode();
        Assert.assertTrue("status code: " + statusCode, statusCode == 200 || statusCode == 201);
    }

    public void testShareVia(String via, String contact) {
        String endpointUrl = "https://cubesandbox.ccnexchange.com/b0dcda17075048e2a3c5f996cd704c60/document/share/v2";
        String serviceId = "7bbd3c40-48f3-4afc-b86e-e1f4fe1581ba";
        String groupId = "6294f9a1ac6979001216e74d";

        // Request payload
        String requestBody = "{\n" +
                "  \"documentID\": \"" + documentID + "\",\n" +
                "  \"contacts\": [\n" +
                "    \"" + contact + "\",\n" +
                "    \"system.csggha01singsxh@ccnexchange.com\",\n" +
                "    \"system.csgagt86abc_han01@ccnexchange.com\",\n" +
                "    \"system.csgagt86eas_szx81@ccnexchange.com\",\n" +
                "    \"system.csgagt86cts_sha01@ccnexchange.com\",\n" +
                "    \"system.csgagt01xsplcsq_sin01@ccnexchange.com\",\n" +
                "    \"system.csgagt01xspbcsq_sin81@ccnexchange.com\",\n" +
                "    \"system.csgagt99kiex637nu459et1po_aae@ccnexchange.com\",\n" +
                "    \"system.csgagt86cts_sha01@ccnexchange.com\"\n" +
                "  ],\n" +
                "  \"via\": \"" + via + "\"\n" +
                "}";

        // Sending PUT request
        Response response = RestAssured.given()
                .header("serviceid", serviceId)
                .header("groupid", groupId)
                .header("Content-Type", ContentType.JSON)
                .header("Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .body(requestBody)
                .when()
                .put(endpointUrl);
        documentIDshareVia = response.jsonPath().getString("documentID");

        // Printing response for verification
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        // Assertions
        assertThat(response.getStatusCode(), isOneOf(200, 201));
    }

    public void testGetDocumentShareForm() {
        String endpointUrl = "https://cubesandbox.ccnexchange.com/3ec7938287c5464ca769a30b37ab3ee6/document";
        String serviceId = "7bbd3c40-48f3-4afc-b86e-e1f4fe1581ba";
        String groupId = "6294f9a1ac6979001216e74d";

        // Request payload
        String requestBody = "{\n" +
                "  \"documentIDs\": [\"" + documentIDshareForm + "\"]\n" +
                "}";

        // Sending POST request
        Response response = RestAssured.given()
                .header("serviceid", serviceId)
                .header("groupid", groupId)
                .header("Content-Type", ContentType.JSON)
                .header("Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .body(requestBody)
                .when()
                .post(endpointUrl);

        // Printing response for verification
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        // Assertions
         Assert.assertEquals(response.getStatusCode(), 200);
    }

    public void testGetExplicitDocument() {
        String endpointUrl = "https://cubesandbox.ccnexchange.com/dcfa5ff0a3a94d288cdcaca2e36def94/document";
        String serviceId = "7bbd3c40-48f3-4afc-b86e-e1f4fe1581ba";
        String groupId = "6294f9a1ac6979001216e74d";

        // Request payload
        String requestBody = "{\n" +
                "  \"documentIDs\": [\"" + documentIDshareExplicitForm + "\"]\n" +
                "}";

        // Sending PUT request
        Response response = RestAssured.given()
                .header("serviceid", serviceId)
                .header("groupid", groupId)
                .header("Content-Type", ContentType.JSON)
                .header("Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .body(requestBody)
                .when()
                .post(endpointUrl);

        // Printing response for verification
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    public void testGetDocumentShareViaColoader(String via, String contentType, String contentName) {
        String endpointUrl = "https://cubesandbox.ccnexchange.com/cd213881a8d848b5803619711fdf660d/document";
        String serviceId = "7bbd3c40-48f3-4afc-b86e-e1f4fe1581ba";
        String groupId = "6294f9a1ac6979001216e74d";

        // Request payload
        String requestBody = "{\n" +
//                "  \"contentNames\": [\"" + contentName + "\"],\n" +
//                "  \"contentTypes\": [\"" + contentType + "\"],\n" +
                "  \"pageSize\": 5\n" +
                "}";

        // Sending PUT request
        Response response = RestAssured.given()
                .header("serviceid", serviceId)
                .header("groupid", groupId)
                .header("Content-Type", ContentType.JSON)
                .header("Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .body(requestBody)
                .when()
                .post(endpointUrl);

        // Printing response for verification
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());

        // Status code check (boleh 200/201)
//        int statusCode = response.getStatusCode();
//        assert (statusCode == 200 || statusCode == 201) : "Unexpected status code: " + statusCode;

        // Parse JSON response
        JsonPath jsonPath = response.jsonPath();

        // Ambil nilai 'from' dari elemen pertama
        String actualFrom = jsonPath.getString("[0].from");

        // Assertion
        assertEquals(actualFrom, via, "Field 'from' tidak sesuai");
    }

    public void testGetDocumentShareViaNonColoader() {
        String endpointUrl = "https://cubesandbox.ccnexchange.com/dcfa5ff0a3a94d288cdcaca2e36def94/document/content";
        String serviceId = "7bbd3c40-48f3-4afc-b86e-e1f4fe1581ba";
        String groupId = "6294f9a1ac6979001216e74d";

        // Request payload
        String requestBody = "{\n" +
                "  \"documentID\": \"" + documentIDshareVia + "\"\n" + // No array brackets
                "}";

        // Sending PUT request
        Response response = RestAssured.given()
                .header("serviceid", serviceId)
                .header("groupid", groupId)
                .header("Content-Type", ContentType.JSON)
                .header("Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .body(requestBody)
                .when()
                .post(endpointUrl);

        // Printing response for verification
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 400);
    }
}
