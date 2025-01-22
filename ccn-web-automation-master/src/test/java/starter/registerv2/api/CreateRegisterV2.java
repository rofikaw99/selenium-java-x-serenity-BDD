package starter.registerv2.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateRegisterV2 {

    @DataProvider(name = "registrationData")
    public Object[][] createTestData() {
        return new Object[][]{
                {"200", "system.csgair01hdqfmaaa@ccnexchange.com"},
        };
    }

    @Test(dataProvider = "registrationData")
    public void givenUserWantsToRegister(String mail) {
        // Given user wants to register a new mail to cube with mail input
        RestAssured.baseURI = "http://cube.dev.ccn/v2register/";
        System.out.println("User wants to register with email: " + mail);
    }

    @Test(dataProvider = "registrationData")
    public void whenSendRequestWithEmail(String mail) {
        // When sending the request with "<mail>" input
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        // Prepare the request body
        String requestBody = String.format("{\"email\": \"%s\"}", mail);
        request.body(requestBody);

        // Send the PUT request
        Response response = request.put();
        response.then().log().all(); // Log the response for debugging purposes

        // Attach response to a thread-safe context for further validations
        TestContext.setResponse(response);
    }
    @Test(dataProvider = "registrationData")
    public void givenUserWantsToRegisterMultipleEmails( String mail1, String mail2) {
        // Given user wants to register multiple mails to cube with mail inputs
        RestAssured.baseURI = "https://cubedev.ccnexchange.com/v2register/";
        System.out.println("User wants to register with emails: " + mail1 + ", " + mail2);
    }
    @Test(dataProvider = "registrationData")
    public void whenSendRequestForMultipleEmails( String mail1, String mail2) {
        // When sending the request with multiple mail inputs "<mail1>" and "<mail2>"
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        // Prepare the request body
        String requestBody = String.format("{\"emails\": [\"%s\", \"%s\"]}", mail1, mail2);
        request.body(requestBody);
        // Send the PUT request
        Response response = request.put();
        response.then().log().all(); // Log the response for debugging purposes
        // Attach response to a thread-safe context for further validations
        TestContext.setResponse(response);
    }

    @Test(dataProvider = "registrationData")
    public void thenValidateResponseCode(String responseCode) {
        // Then get response "<responseCode>"
        Response response = TestContext.getResponse();
        int actualResponseCode = response.getStatusCode();
        Assert.assertEquals(String.valueOf(actualResponseCode), responseCode, "Response code does not match!");
    }

    @Test
    public void andValidateResponseContainsBoxUrlAndSite() {
        // And get response BOXURL & site
        Response response = TestContext.getResponse();
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("BOXURL"), "Response does not contain BOXURL!");
        Assert.assertTrue(responseBody.contains("site"), "Response does not contain site!");

        // Print the response for validation
        System.out.println("Validated Response: " + responseBody);
    }

    @Test
    public void getValidationResponseMessageForAlreadyRegisteredEmail() {
        // Get validation response message that the email is already registered
        Response response = TestContext.getResponse();
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("already registered"), "Response does not indicate that the email is already registered!");

        // Print the validation message for debugging purposes
        System.out.println("Validation Message: " + responseBody);
    }
}
// Utility class to manage thread-safe context for test dependencies
class TestContext {
    private static final ThreadLocal<Response> responseThreadLocal = new ThreadLocal<>();

    public static void setResponse(Response response) {
        responseThreadLocal.set(response);
    }

    public static Response getResponse() {
        return responseThreadLocal.get();
    }
}
