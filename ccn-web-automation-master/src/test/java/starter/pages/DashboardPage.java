package starter.pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import starter.utlis.Common;
import starter.utlis.Constants;

import java.util.List;
import java.util.Random;

import static net.serenitybdd.rest.SerenityRest.*;

public class DashboardPage extends PageObject {
    String boxUrl = "";
    String accessToken = "";
    String awbNo = "";
    String keyword = "";
    int index;

    private By awbTextList = By.xpath("//span[contains(@class, 'sqpp-tracking-quicksearch-clk')]/div[contains(@class, '!font')]");
    private By searchDashboard = By.id("sqpp-tracking-table-searchbar-id");
    private By trackAwbChecklistSvg = By.xpath("//span[contains(@class, \"sqpp-tracking-table-clk-icn\")]//*[local-name() = 'svg']");
    private By trackAwbChecklist = By.xpath("//span[contains(@class, \"sqpp-tracking-table-clk-icn\")]//*[local-name() = 'svg']/*[local-name()='line']");

    private boolean awbTrackChecked(WebElementFacade trackedElement){
        return !trackedElement.getAttribute("fill").equals("none");
    }
    public void fetchAccessToken() {
        Response response = RestAssured.given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Cookie", "fpc=AvtAb5bVFpRMgmodPHJEYoWc2pdeAgAAAO0Tzd0OAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd")
                .formParam("grant_type", "authorization_code")
                .formParam("scope", "https://ccnssoppd.onmicrosoft.com/CUBE_CORE_SITE_1/.default")
                .formParam("client_id", "674567c2-a461-4d3f-bdea-98e5bf0161e9")
                .formParam("client_secret", "9Np8Q~EiTsrOZ6Yg05d9p2Rmt2P4hz1oGrg33dyO")
//                .formParam("client-request-id", "C5K8Q~bS_20wCUbd3YiIS5BAMwrwtmPxMB2vicau")
                .when().post("https://login.microsoftonline.com/ccnssoppd.onmicrosoft.com/oauth2/v2.0/token");

        accessToken = response.jsonPath().getString("access_token");
    }

    public void getRegisterEmail(String email){
        String baseUrl = "https://cubesandbox.ccnexchange.com";
        String endpoint = "/register";

        String url = baseUrl + endpoint;
        String payload = "{\n" +
                "    \"email\": \""+ email +"\"\n" +
                "}";

        given().header("Content-Type", ContentType.JSON.toString())
                .body(payload)
                .post(url);

        then().statusCode(200);
        boxUrl = lastResponse().path("boxURL");
    }

    public void createDocumentShipping(){
        String url = boxUrl + "/document";

        awbNo = Constants.validAwbNo.get(new Random().nextInt(Constants.validAwbNo.size()));
        String payload = "{\n" +
                "    \"contentName\": \"Booking-King\",\n" +
                "    \"tags\": [\n" +
                "                \"status:SENT\",\n" +
                "                \"awbNo:"+ awbNo +"\",\n" +
                "                \"owner:system.csgagt01xsplcsq_sin01@ccnexchange.com\",\n" +
                "                \"forwarderEmail:system.csgagt01xsplcsq_sin01@ccnexchange.com\",\n" +
                "                \"origin:CMB\",\n" +
                "                \"awbPrefix:618\",\n" +
                "                \"destination:LAX\",\n" +
                "                \"jobID:7affc9bb-21c7-46a8-b80d-41d86154d448\",\n" +
                "                \"isAllowSendFFR:False\",\n" +
                "                \"companyName:AIRTROPOLIS EXPRESS S ID\",\n" +
                "                \"isFromBC:False\",\n" +
                "                \"isDGRCommodity:False\",\n" +
                "                \"specialHandlingCodes:GEN\",\n" +
                "                \"flightNo:0469\",\n" +
                "                \"flightDate:"+ Common.createFlightDate(2) +" 00:00:00 AM\",\n" +
                "                \"carrierCode:SQ\"\n" +
                "            ],\n" +
                "    \"contentType\": \"Booking\",\n" +
                "    \"contentMIME\": null,\n" +
                "    \"encodedContent\" :\"lorem ipsum\"\n" +
                "}\n" +
                " ";

        given().header("Content-Type", ContentType.JSON.toString())
                .body(payload)
                .put(url);
    }

    public void successStatusCode(){
        then().statusCode(200);
    }

    public void getListAwb(){
        String serviceId = "0f66e734-3083-43cd-9717-2a4b90ceb927";
        String url = boxUrl + "/service/" + serviceId + "/DashboardModel/1/GetListAWB";

        given().headers("Source-Service-Id", "2ccbe74c-493b-47a4-8dee-80bdb147e895",
                        "Content-Type", "application-json",
                        "Authorization", "Bearer " + accessToken)
                .post(url);

        then().statusCode(200);
        System.out.println(lastResponse().body());
    }

    public void verifyAwbListAppears(){
        ListOfWebElementFacades awbNumbers = $$(awbTextList);
        boolean condition = false;
        for (WebElementFacade e: awbNumbers)  {
            if (e.getText().equals(awbNo)){
                condition = true;
                break;
            }
        }
        Assert.assertTrue(condition);
    }

    public void inputSearchDashboardKeyword(String keyword){
        $(searchDashboard).sendKeys(keyword);
    }

    public void searchValidRegisteredAwbDashboard(){
        keyword = $$(awbTextList).get(0).getText().substring(0, 3);
        $(searchDashboard).sendKeys(keyword);
    }

    public void assertMatchedAwbAppears(){
        ListOfWebElementFacades awbNumbers = $$(awbTextList);
        boolean condition = true;
        for (WebElementFacade e: awbNumbers){
            if (!e.getText().substring(0, 3).equals(keyword)) {
                condition = false;
                break;
            }
        }
        Assert.assertTrue(condition);
    }

    public void checkedAwbTrack(){
        ListOfWebElementFacades checkedAwb = $$(trackAwbChecklistSvg);
        Assert.assertTrue(awbTrackChecked(checkedAwb.get(index)));
    }

    public void clickUntrackedAwb(){
        List<WebElement> checkedAwb = getDriver().findElements(trackAwbChecklist);
        ListOfWebElementFacades checkedAwbSvg = $$(trackAwbChecklistSvg);
        boolean allChecked = true;
        for (WebElementFacade e: checkedAwbSvg){
            if (!awbTrackChecked(e)) {
                index = checkedAwbSvg.indexOf(e);
                Actions builder = new Actions(getDriver());
                builder.moveToElement(checkedAwb.get(index)).click().build().perform();
//                evaluateJavascript("arguments[0].click();", checkedAwbSvg.get(index));
                allChecked = false;
                break;
            }
        }
        if (allChecked) {
            Actions builder = new Actions(getDriver());
            builder.click($(checkedAwbSvg.get(0))).build().perform();
            builder.click($(checkedAwbSvg.get(0))).build().perform();
//            evaluateJavascript("arguments[0].click();", $(checkedAwbSvg.get(0))); //remove watchlist
//            evaluateJavascript("arguments[0].click();", $(checkedAwbSvg.get(0))); //add watchlist
            index = 0;
        }
    }
}
