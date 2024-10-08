package starter.api;

import io.restassured.response.Response;
import org.json.JSONObject;
import starter.payload.payment.PaymentDelegationPayload;
import starter.payload.payment.StandingInstructionPayload;
import starter.utlis.ApiProperties;
import starter.utlis.ReadFile;

import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.*;

public class StandingInstruction {

    String token, cubeId, baseUrl, emailCompany, emailCompany2;
    Response response;

    public void setToken(int company) throws IOException {
        if (company == 1) {
            token = ReadFile.tokenCompany1();
            cubeId = ApiProperties.cubeId1();
        }
        else if (company == 2) {
            token = ReadFile.tokenCompany2();
            cubeId = ApiProperties.cubeId2();
        }
        emailCompany = ApiProperties.emailCompany1();
        emailCompany2 = ApiProperties.emailCompany2();
        baseUrl = ApiProperties.baseUrlExternal() + cubeId + "/service/" + ApiProperties.paymentServiceId();
    }

    public void retrieveCardToken(){
        String url = baseUrl + "/Payment/1/retrieveCardToken";

        response = given()
                .header("Authorization", "Bearer " + token)
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(StandingInstructionPayload.retrieveCardToken().toString())
                .post(url);
        then().statusCode(200);
    }

    public String cardToken(){
        return lastResponse().jsonPath().getString("payment_token");
    }

    public void retrieveStandingInstruction(String type){
        String url = baseUrl + "/Payment/1/retrieveStandingInstruction";

        response = given()
                .header("Authorization", "Bearer " + token)
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(StandingInstructionPayload.retrieveSI(type).toString())
                .post(url);

        then().statusCode(200);
    }

    public boolean thereIsSI(){
        return !lastResponse().jsonPath().getList("datas.id").isEmpty();
    }

    public void createStandingInstruction(String productId, String productName, String suppId, String suppName, String cardToken,
                                          String type, int company){
        if (company == 2) emailCompany = emailCompany2;
        String url = baseUrl + "/Payment/1/createStandingInstruction";

        response = given()
                .header("Authorization", "Bearer " + token)
                .header("source-service-id", ApiProperties.sourceServiceId())
                .contentType("application/json")
                .body(StandingInstructionPayload.createSI(suppId, suppName, productId, productName,
                        cardToken, type, emailCompany).toString())
                .post(url);
    }

}
