package starter.api;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class Example {
    private String url;

    public void setUrlApiListUser(){
        url = "https://reqres.in/api/users?page=2";
    }

    public void requestListUser(){
        given().when().get(url);
    }

    public void verifyStatusCode200(){
        // then() -> method untuk melakukan verifikasi atau pengecekan terhadap
        // response yang dihasilkan
        // method then digunakan untuk memverifikasi response yg dikembalikan
        then().statusCode(200);
    }
}
