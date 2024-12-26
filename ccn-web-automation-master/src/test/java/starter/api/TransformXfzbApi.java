package starter.api;

import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.junit.Assert;
import starter.utlis.ApiProperties;
import starter.utlis.onerecord.XFWBResponse;
import starter.utlis.onerecord.XFZBRequest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class TransformXfzbApi {

    private String url, response;
    private RequestSpecification requestSpecification;

    public void setupApi(String typeUrl) throws IOException {
        requestSpecification = given()
                .headers("Content-Type", "application/xml");

        if (typeUrl.equals("internal")){
            url = ApiProperties.internalUrl() +"/service/" + ApiProperties.serviceId() + "/OneRecord/1/transformXFZB3";
            requestSpecification.headers("x-api-key", ApiProperties.apiKey());
        } else if (typeUrl.equals("external")){
            url = ApiProperties.baseUrl() + "/transformXFZB3";
        }
    }

    public String transformXfzb(String payload, String typeUrl) throws IOException {
        setupApi(typeUrl);
        response = requestSpecification
                .body(payload)
                .post(url)
                .then()
                .extract()
                .body()
                .asString();

        FileWriter file = new FileWriter("src/test/java/starter/utlis/onerecord/outputJson.json");
        file.write(response);
        file.close();
        if (typeUrl.equals("internal")) then().statusCode(200);
        else if (typeUrl.equals("external")) then().statusCode(201);
        return response;
    }

    public void verifyWaybillNumber(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.BHD_ID(request), XFWBResponse.waybillNumber(response));
    }

    public void verifyConsignorDeclarationSignature(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.BHD_SCoA_Signatory(request), XFWBResponse.consignorDeclarationSignature(response));
    }

    public void verifyCarrierDeclarationDate(JSONObject request, JSONObject response){
        Assert.assertTrue(XFWBResponse.carrierDeclarationDate(response).contains(XFZBRequest.BHD_SCaA_ActualDateTime(request)));
    }

    public void verifyCarrierDeclarationSignature(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.BHD_SCaA_Signatory(request), XFWBResponse.carrierDeclarationSignature(response));
    }

    public void verifyCarrierDeclarationPlace(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.BHD_SCaA_IAL_Name(request), XFWBResponse.carrierDeclarationPlace(response));
    }

    public void verifyDeclaredValueForCarriage(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_NilCarriageValueIndicator(request), XFWBResponse.declaredValueForCarriage(response));
    }

    public void verifyDeclaredValueForCustoms(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_NilCustomsValueIndicator(request), XFWBResponse.declaredValueForCustoms(response));
    }

    public void verifyInsuredAmount(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_NilInsuranceValueIndicator(request), XFWBResponse.insuredAmount(response));
    }

    public void verifyWeightValuationIndicator(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_TotalChargePrepaidIndicator(request), XFWBResponse.weightValuationIndicator(response));
    }

    public void verifyOtherChargesIndicator(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_TotalDisbursementPrepaidIndicator(request), XFWBResponse.otherChargesIndicator(response));
    }

    public void verifyTotalGrossWeight(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_IncludedTareGrossWeightMeasure(request), XFWBResponse.numericalValueOfGrossWeight(response));
    }

    public void verifySlacForRate(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_PackageQuantity(request), XFWBResponse.slacForRate(response));
    }

    public void verifyGoodsDescriptionForRate(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_SummaryDescription(request), XFWBResponse.WaybillLineItems_GoodsDescriptionForRate(response));
    }

    public void verifyDepartureLocation(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_OriginLocation(request), XFWBResponse.DL_LocationCodes_Code(response));
    }

    public void verifyArrivalLocation(JSONObject request, JSONObject response){
        Assert.assertEquals(XFZBRequest.MC_IHC_FinalDestinationLocation(request), XFWBResponse.AL_LocationCodes_Code(response));
    }
}
