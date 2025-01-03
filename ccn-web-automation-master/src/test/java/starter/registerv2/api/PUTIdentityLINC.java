package starter.registerv2.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.junit.Assert;
import starter.utlis.ApiProperties;
import starter.utlis.onerecord.XFWBResponse;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class PUTIdentityLINC extends PageObject {
    private static Response response;

    public void user_wants_to_put_identity_linc_with_input_some_required_data() {
        // Set base URI
        RestAssured.baseURI = "https://cubedev.ccnexchange.com";

        // Request body
        String requestBody = """
                {
                    "companyCode": "GF",
                    "companyName": "mailinatorCCNPEGASUS_QA",
                    "companyType": "FWD",
                    "station": "SIN",
                    "accountNo": "01",
                    "iataCode": "",
                    "cassCode": "",
                    "globalCompanyID": "8a93764e-7728-4b5a-a7d6-52a9ed52ccc0",
                    "pimaAddress": "CSGAGT86SGCCN54/SIN81",
                    "user": {
                        "email": "qa-ccn-960602@mailinator.com",
                        "contactNumber": "+621234567890",
                        "linc_id": "07649647-1f85-46f9-b6e0-3d72dbb404b6",
                        "name": "andrian linc x001",
                        "password": "secret",
                        "userType": "U"
                    }
                }
                """;

        // Kirim PUT request dan simpan response ke variabel instance
        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/v2register/group_identity_linc");
    }

    public void get_response(String responseCode) {
        // Assert the response status code
        Assert.assertEquals(String.valueOf(response.getStatusCode()), Integer.parseInt(responseCode), "Unexpected status code");
    }

    public static void get_response_body_value_message_and_log_id() {

        // Extract dan assert fields dari response body
        String message = response.jsonPath().getString("message");
        String logId = response.jsonPath().getString("log_id");

        // Log values untuk debugging
        System.out.println("Message: " + message);
        System.out.println("Log ID: " + logId);
    }
}
