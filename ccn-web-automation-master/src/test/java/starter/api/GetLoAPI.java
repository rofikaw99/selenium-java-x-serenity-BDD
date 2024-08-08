package starter.api;

import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.hasKey;

public class GetLoAPI {
    String response;

    public JSONObject getLORequest(String id){
        String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IkwxS2ZLRklfam5YYndXYzIyeFp4dzFzVUhIMCJ9.eyJhdWQiOiJhYTkyMDA1YS02MzcwLTQ4MWItYWExNy1iYmNmNzhjMDgzYTciLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vZmFmMDVlYmUtYzNkYy00NDM3LWJjMmQtMmE4MTU2NTNmNzVjL3YyLjAiLCJpYXQiOjE3MTU4MTgxNTIsIm5iZiI6MTcxNTgxODE1MiwiZXhwIjoxNzE1ODIyMDUyLCJhaW8iOiJBU1FBMi84V0FBQUFuUXhVSG9WQVBwUzErMjdjcGxMbnRKS1RONm0vQWFCNWdObU9VekpIazd3PSIsImF6cCI6ImNiZmM2ODkzLTNjMTMtNDJjMi1hMzFlLTg3NGMxNWQ2ZmVhYyIsImF6cGFjciI6IjEiLCJyaCI6IjAuQVQ4QXZsN3ctdHpETjBTOExTcUJWbFAzWEZvQWtxcHdZeHRJcWhlN3ozakFnNmRBQUFBLiIsInRpZCI6ImZhZjA1ZWJlLWMzZGMtNDQzNy1iYzJkLTJhODE1NjUzZjc1YyIsInV0aSI6Im5mWVN1dDRadmtHSzd4NWVPMlFhQUEiLCJ2ZXIiOiIyLjAifQ.Fycbt6eI8nQgoR3nE5X259kOuEO6SpZi1DxAKv19P_VMfqhoCFo_0azOGb7s5Lq9qcAQ1eBqJlv4jscYG-DUbdVGfzN8BRlc6-H1fs1yNJUYZvRnyW1ZR8jF82ghwkhgb8A3stQ3SV0XOWRRyXw1iXuLSJgZf7VKbcQQrFjixDfkTJkUg14B7Dl3fKQwJVdt5CYnJDRGpnwQv7635JQDRmFNv1RNmhk7VpqWYrL2lndCltec_acpbkCq-shW23Al-UwWGafpXsBc_CO7l65juHuXXRHh2xb3GKO2iqAijb5VV0oGz25Iun7EHGVa1E7Zw9Mxr_rz-haun5iTe98mow";

        response = given()
                .headers(
                        "Authorization", "Bearer " + accessToken,
                        "Content-Type", "application/json",
                        "Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .get(id)
                .then()
                .extract().response().asString();
        return new JSONObject(response);
    }
    public void verifySuccessGetLO(){
        then().statusCode(200);
    }
}
