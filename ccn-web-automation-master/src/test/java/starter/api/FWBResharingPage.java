package starter.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

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

    public void createDocForShareVia(String contentType, String contentName) {

        // API endpoint
        String endpoint = "https://cubesandbox.ccnexchange.com/fa077c220ff1404f8f71f1c5a05f4c8c/document";
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

    public void awb1000times() {

//        // Base URL and headers setup
//        String baseUrl = "https://cubesandbox.ccnexchange.com/fa077c220ff1404f8f71f1c5a05f4c8c/document";
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
        String baseUrl = "https://cubesandbox.ccnexchange.com/fa077c220ff1404f8f71f1c5a05f4c8c/document";
//        String baseUrl = "https://cube.ccnexchange.com/c8083437160b40bf9349cc782733e548/document";
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addHeader("serviceId", "4e6ae0d1-320a-4565-867e-778f939a58ab")
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .build();

        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200) // Assuming a 200 status code is expected
                .build();

        // Loop to send 1000 requests
        for (int i = 1; i <= 1; i++) {
            String awbNo = "618-" + (62787454 + i); // Generate dynamic AWB number

            String requestBody = String.format(
                    "{\n" +
                            "    \"contentName\": \"%s\",\n" +
                            "    \"contentType\": \"Booking\",\n" +
                            "    \"contentMIME\": null,\n" +
                            "    \"tags\": [\n" +
                            "        \"status:Confirmed\",\n" +
                            "        \"awbNo:%s\",\n" +
                            "        \"owner:batiktrimulyo@gmail.com\",\n" +
                            "        \"forwarderEmail:batiktrimulyo@gmail.com\",\n" +
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
        String endpoint = "https://cubesandbox.ccnexchange.com/fa077c220ff1404f8f71f1c5a05f4c8c/document";
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
                "  \"documentRefID\": \"" + documentRefID + "\",\n" +
                "  \"contacts\": [\n" +
                "    \"" + contact + "\"\n" +
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
        String endpointUrl = "https://cubesandbox.ccnexchange.com/dcfa5ff0a3a94d288cdcaca2e36def94/document/share";
        String serviceId = "7bbd3c40-48f3-4afc-b86e-e1f4fe1581ba";
        String groupId = "6294f9a1ac6979001216e74d";

        // Request payload
        String requestBody = "{\n" +
                "  \"documentRefID\": \"" + documentRefID + "\",\n" +
                "  \"contacts\": [\n" +
                "    \"" + contact + "\"\n" +
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
        // Assertions
         Assert.assertEquals(response.getStatusCode(), 200);
    }

    public void testShareVia(String via, String contact) {
        String endpointUrl = "https://cubesandbox.ccnexchange.com/fa077c220ff1404f8f71f1c5a05f4c8c/document/share";
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
        Assert.assertEquals(response.getStatusCode(), 200);
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

    public void testGetDocumentShareViaColoader() {
        String endpointUrl = "https://cubesandbox.ccnexchange.com/fa077c220ff1404f8f71f1c5a05f4c8c/document/share";
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
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    public void testGetDocumentShareViaNonColoader() {
        String endpointUrl = "https://cubesandbox.ccnexchange.com/dcfa5ff0a3a94d288cdcaca2e36def94/document/share";
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
