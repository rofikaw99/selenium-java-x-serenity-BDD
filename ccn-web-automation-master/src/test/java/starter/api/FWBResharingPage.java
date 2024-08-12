package starter.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
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
}
