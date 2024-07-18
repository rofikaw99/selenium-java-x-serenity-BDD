package starter.pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.pages.PageObject;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class CheckStatusPage extends PageObject {

    public static String accessToken;

    public static void fetchAccessToken() {
        Response response = RestAssured.given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Cookie", "fpc=AvtAb5bVFpRMgmodPHJEYoWc2pdeAgAAAO0Tzd0OAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd")
                .formParam("grant_type", "client_credentials")
                .formParam("scope", "https://ccnssoppd.onmicrosoft.com/CUBE_CORE_SITE_1/.default")
                .formParam("client_id", "cc4371c5-a9fb-441f-a9e6-de27c073a94c")
                .formParam("client_secret", "QGa8Q~lT3hB8X1UaVAuKMVTe4HeQ7HB~EmRnwaE8")
                .when().post("https://login.microsoftonline.com/ccnssoppd.onmicrosoft.com/oauth2/v2.0/token");

//        accessToken = response.jsonPath().getString("access_token");
        accessToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjVvN2dFX2VseE1kX2xpbUZKeWtpQ0F2dzdTTmVYQ24wbXZxTlRVTWVIbjQiLCJ0eXAiOiJKV1QifQ.eyJhdWQiOiJhYTkyMDA1YS02MzcwLTQ4MWItYWExNy1iYmNmNzhjMDgzYTciLCJpc3MiOiJodHRwczovL2NjbnNzb3BwZC5iMmNsb2dpbi5jb20vZTI0YjI4OWEtMzIzYi00YWRkLTg3NjUtYzcxYmFiOGIxOGEzL3YyLjAvIiwiZXhwIjoxNzIxMjk3MzkxLCJuYmYiOjE3MjEyOTM3OTEsInN1YiI6IjBiNTE0N2I1LWM4YzMtNDhmNi05N2Y0LTQzMjc1NTE1M2VmZiIsImVtYWlsIjoiY28tc2ctMDAxQHlvcG1haWwuY29tIiwibmFtZSI6IkNhcmQgT3duZXIgTGVhdmUiLCJleHRlbnNpb25fQ29udGFjdE5vIjoiMTg0NTU4NTQiLCJleHRlbnNpb25fQ3ViZVVzZXJJRCI6IjlkOTllMzZmLWE4OGUtNDFjYi05NjUyLTY3NWIyMGRkOTExNyIsImNpdHkiOiJTSU4iLCJleHRlbnNpb25fQ291bnRyeUNvZGUiOiJTRyIsInRpZCI6ImUyNGIyODlhLTMyM2ItNGFkZC04NzY1LWM3MWJhYjhiMThhMyIsInRmcCI6IkIyQ18xQV9TaWduVXBfU2lnbkluTmV3VXNlclN5biIsIm5vbmNlIjoiZTZmMjI3MDAtNjk0NC00MDhkLWJhMzUtZmQ1MjJhM2NhYzQ4Iiwic2NwIjoicmVhZCB3cml0ZSIsImF6cCI6IjI2OGU1ODdiLWE5NDctNDIxYi1hNzM3LWI1NTczYzZlYTA3NSIsInZlciI6IjEuMCIsImlhdCI6MTcyMTI5Mzc5MX0.sZAQYjaNMBfuz3SpbW0JMYTWLEJTRTUolP4g6k66ujQzLDxrOsdTSu8KZ0zfvsPa2SF7B_psqUSQ7YNmd_xa55-BDDsSDia_UmcXmGF4OHiJL5HFYLSrEaZjCLaAp5Exvs04CCnGr42gj73Oiw887jckDgAyHNMCWXN2ACjOfJaVD4T3v8Q7blBeqbK69AHTNJbabsGnlD045E_RRoZPRYxlDMT9UdBaKPywzNmdxeOg5EoyWGJvF9qJFGMTjj0GpNgmHz3axIGHd_JR17itbKdpvcg51usLMZWOmMNaSjtraUJyCEHy4k8KXPoH1AzQwuXfTjltv3INuZtK1tajMg";
    }

    public void getCheckStatus(String serviceId){
        String baseUrl = "https://cubesandbox.ccnexchange.com/";
        String cubeID = "dd66606da3fa4d11b5c2424187afa2a7";
        String serviceID = "31bbd797-9265-4ea5-8477-ca783b38bd07";
        String endpoint = "/GeneralSubscription/1/CheckStatus";

        String url = baseUrl + cubeID + "/service/" + serviceID + endpoint;

        Response response = given()
                .headers("source-service-id", serviceId,
                        "Authorization", "Bearer " + accessToken,
                        "Content-Type", ContentType.JSON.toString(),
                        "Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .post(url);
    }

    public void assertSuccessCheckStatus(){
        then().statusCode(200);
    }
}
