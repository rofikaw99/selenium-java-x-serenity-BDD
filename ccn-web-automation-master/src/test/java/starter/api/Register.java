package starter.api;

import io.restassured.response.Response;
import starter.utlis.ApiProperties;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.*;

public class Register {

    String cubeId, emailCompany, baseUrl, baseUrlIp, baseUrlPayReq;

    public void setBase(){
        baseUrl = ApiProperties.baseUrlExternal();
    }

    public String cubeId(String email){
        setBase();
        given()
                .contentType("application/json")
                .body("{ \"email\": \"" + email + "\"}")
                .post(baseUrl + "register");
        String boxUrl = List.of(lastResponse().jsonPath().getString("boxURL").split("/")).get(3);
        return boxUrl;
    }
}
