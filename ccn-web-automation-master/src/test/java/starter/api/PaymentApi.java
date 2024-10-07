package starter.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.equalTo;

public class PaymentApi {
    Response response;
    JSONObject payload;
    RequestSpecification requestSpecification;

//    String paymentCubeId = "89d6540f08a64e3180a4591d9b5ddc25";
    String paymentCubeId = "64194bcfcedc4c4983b9b23684f608e1"; //Auto QA
    String paymentCubeId2 = "404c1b00b82046b38d9f821ac95fc8dd"; //SG Auto QA
    String baseUrl = "https://cubedev.ccnexchange.com/" + paymentCubeId + "/service/251e8baa-c4fc-455a-9d0c-7ad18d627ce9";
    String baseUrlPayReq = "http://172.16.200.158:6969/" + paymentCubeId + "/service/251e8baa-c4fc-455a-9d0c-7ad18d627ce9";
    String sourceServiceId = "0ca57555-4c13-4a06-a2f4-c7ec101fb3bd";
    String emailCompany = "system.csgagt91662f0d74_jkt01@ccnexchange.com";
    String emailCompany2 = "system.csgagt916639bbdb_sin01@ccnexchange.com";

    public void baseUrl(String type){
        String cubeId = "";
        if (type.equals("main")) cubeId = paymentCubeId;
        else if (type.equals("secondary")) cubeId = paymentCubeId2;

        baseUrl = "https://cubedev.ccnexchange.com/" + cubeId + "/service/251e8baa-c4fc-455a-9d0c-7ad18d627ce9";
        baseUrlPayReq = "http://172.16.200.158:6969/" + cubeId + "/service/251e8baa-c4fc-455a-9d0c-7ad18d627ce9";
    }

    public void setHeader() throws IOException {
        String token = FileUtils.readFileToString(new File("src/test/java/starter/utlis/tokenPayment.json"), StandardCharsets.UTF_8);
        requestSpecification = given()
                .headers("Authorization", "Bearer " + token,
                        "source-service-id", sourceServiceId);
    }

    public void setHeader(String type) throws IOException {
        String token = "";
        if (type.equals("main")) token = FileUtils.readFileToString(new File("src/test/java/starter/utlis/tokenPayment.json"), StandardCharsets.UTF_8);
        else if (type.equals("secondary")) token = FileUtils.readFileToString(new File("src/test/java/starter/utlis/tokenPayment2.json"), StandardCharsets.UTF_8);

        requestSpecification = given()
                .headers("Authorization", "Bearer " + token,
                        "source-service-id", sourceServiceId);
    }

    public void setHeaderPayReq() throws IOException {
        String token = FileUtils.readFileToString(new File("src/test/java/starter/utlis/tokenPayment.json"), StandardCharsets.UTF_8);;
        requestSpecification = given()
                .headers("Authorization", "Bearer " + token,
                        "associate-service-id", "6f1943cd-5743-4ee7-bc8c-9c9435e39036");
    }

    public void retrievePaymentDelegation(){
        String url = baseUrl + "/Payment/1/retrievePaymentDelegationSetting";

        JSONObject sortBy = new JSONObject();
        sortBy.put("column", "reference");
        sortBy.put("order", "asc");

        payload = new JSONObject();
        payload.put("delegateTo", true);
        payload.put("delegateFrom", false);
        payload.put("pagination", 10);
        payload.put("page", 1);
        payload.put("search", "");
        payload.put("sortBy", sortBy);

        response = requestSpecification
                .body(payload.toString())
                .post(url);
    }

    public boolean checkThereIsPaymentDelegation(){
        return lastResponse().jsonPath().getString("data").contains("CAR");
    }

    public void getAllSupplier(){
        String url = baseUrl + "/Payment/1/get-all-supplier";

        response = requestSpecification
                .contentType("application/json")
                .body("{}")
                .post(url);
    }

    public void verifySuccessRetrieveDelegation(){
        then().body("message", equalTo("Success retrieve payment delegation settings"));
    }

    public String productId(){
        JSONArray jsonObject = new JSONArray(response.asString());
        return jsonObject.getJSONObject(1).getJSONArray("products").getJSONObject(0).getString("serviceId");
    }

    public String productId(int index){
        JSONArray jsonObject = new JSONArray(response.asString());
        return jsonObject.getJSONObject(index).getJSONArray("products").getJSONObject(0).getString("serviceId");
    }

    public String supplierId(){
        JSONArray jsonObject = new JSONArray(response.asString());
        return jsonObject.getJSONObject(1).getString("_id");
    }

    public String supplierId(int index){
        JSONArray jsonObject = new JSONArray(response.asString());
        return jsonObject.getJSONObject(index).getString("_id");
    }

    public String productName(){
        JSONArray jsonObject = new JSONArray(response.asString());
        return jsonObject.getJSONObject(1).getJSONArray("products").getJSONObject(0).getString("name");
    }

    public String supplierName(){
        JSONArray jsonObject = new JSONArray(response.asString());
        return jsonObject.getJSONObject(1).getString("name");
    }

    public void createPaymentDelegation(String productId, String suppId, String company){
        String url = baseUrl + "/Payment/1/createPaymentDelegationSetting";

        if (company.equals("SG Auto QA")) emailCompany = emailCompany2;

        payload = new JSONObject();
        payload.put("delegateTo", emailCompany);
        payload.put("productServiceId", productId);
        payload.put("supplierId", suppId);

        response = requestSpecification
                .body(payload.toString())
                .post(url);
    }

    public void verifySupplierId(String suppId){
        Assert.assertEquals(lastResponse().jsonPath().getString("data.supplierId"), suppId);
    }

    public void verifyProductId(String productId){
        Assert.assertEquals(lastResponse().jsonPath().getString("data.productServiceId"), productId);
    }

    public void verifyPaymentAuth(){
        Assert.assertEquals(lastResponse().jsonPath().getString("data.paymentAuth"), "FUTURE_PAYMENT");
    }

    public void verifyStatus(){
        Assert.assertEquals(lastResponse().jsonPath().getString("data.status"), "ACTIVE");
    }

    public void verifyDelegateToCompany(){
        Assert.assertEquals(lastResponse().jsonPath().getString("data.delegateTo.email"),  emailCompany2);
    }

    public void deletePaymentDelegation(int index){
        String url = baseUrl + "/Payment/1/deletePaymentDelegationSetting";

        JSONObject resp = new JSONObject(response.asString());

        payload = new JSONObject();
        payload.put("paymentDelegationSettingId", resp.getJSONArray("data").getJSONObject(index).getString("id"));

        response = requestSpecification
                .contentType("application/json")
                .body(payload.toString())
                .post(url);
    }

    public void verifyStatusCode(int statusCode){
        then().statusCode(statusCode);
    }

    public void verifySuccessDeleteDelegation(){
        then().body("message", equalTo("Success delete payment delegation"));
    }

    public void retrieveStandingInstruction(String type){
        String url = baseUrl + "/Payment/1/retrieveStandingInstruction";

        JSONObject sortBy = new JSONObject();
        sortBy.put("column", "createdAt");
        sortBy.put("order", "asc");

        payload = new JSONObject();
        payload.put("type", type);
        payload.put("pagination", 10);
        payload.put("page", 1);
        payload.put("searchSInumber", "");
        payload.put("sortBy", sortBy);

        response = requestSpecification
                .contentType("application/json")
                .body(payload.toString())
                .post(url);
    }

    public boolean checkThereIsSupplier(){
        return lastResponse().jsonPath().getString("datas.productName").contains("Shipment Visibility Service");
    }

    public String siId(){
        JSONObject resp = new JSONObject(response.asString());
        return resp.getString("standingInstructionId");
    }

    public void verifySuccessRetrieveSI(){
        then().body("message", equalTo("Sucess retrieve Standing Instructions"));
    }

    public void retrieveCardToken(){
        String url = baseUrl + "/Payment/1/retrieveCardToken";

        payload = new JSONObject();
        payload.put("email", "autoqa-ccn-001@yopmail.com");

        response = requestSpecification
                .contentType("application/json")
                .body(payload.toString())
                .post(url);
    }

    public String cardToken(){
        JSONObject resp = new JSONObject(response.asString());
        return resp.getJSONObject("data").getString("token");
    }

    public void createStandingInstruction(String productId, String productName, String suppId, String suppName, String cardToken, String type){
        String url = baseUrl + "/Payment/1/createStandingInstruction";

        JSONObject supplier = new JSONObject();
        supplier.put("id", suppId);
        supplier.put("name", suppName);
        supplier.put("productServiceId", productId);
        supplier.put("productName", productName);

        JSONObject limit = new JSONObject();
        limit.put("amount", 400);
        limit.put("currency", "USD");

        payload = new JSONObject();
        payload.put("supplier", supplier);
        payload.put("limit", limit);
        payload.put("limitInterval", "transaction");
        payload.put("validFrom", "2024-09-23");
        payload.put("validTo", "2024-09-30");
        payload.put("card_token", cardToken);
        payload.put("type", type);
        payload.put("paymentOwner", emailCompany2);

        response = requestSpecification
                .contentType("application/json")
                .body(payload.toString())
                .post(url);
    }

    public String siIdFromList(){
        JSONObject resp = new JSONObject(response.asString());
        return resp.getJSONArray("datas").getJSONObject(0).getString("standingInstructionId");
    }

    public String suppIdList(){
        JSONObject resp = new JSONObject(response.asString());
        return resp.getJSONArray("datas").getJSONObject(0).getString("productServiceId");
    }

    public void verifyThereIsSiId(String siId){
        Assert.assertTrue(lastResponse().jsonPath().getString("datas.standingInstructionId").contains(siId));
    }

    public void verifyThereIsNoSiId(String siId){
        Assert.assertFalse(lastResponse().jsonPath().getString("datas.standingInstructionId").contains(siId));
    }

    public void verifyAmountUpdated(Integer amount){
        Assert.assertEquals(lastResponse().jsonPath().getString("limit.amount"), String.valueOf(amount));
    }

    public void verifyValidFromUpdated(String validFrom){
        Assert.assertEquals(validFrom + "T00:00:00.000Z", lastResponse().jsonPath().getString("validFrom"));
    }

    public void updateStandingInstruction(String siId, String productId, String productName,
                                          String suppId, String suppName, String cardToken, String type,
                                          Integer amount, String validFrom){
        String url = baseUrl + "/Payment/1/updateStandingInstruction";

        JSONObject supplier = new JSONObject();
        supplier.put("id", suppId);
        supplier.put("name", suppName);
        supplier.put("productServiceId", productId);
        supplier.put("productName", productName);

        JSONObject limit = new JSONObject();
        limit.put("amount", amount);
        limit.put("currency", "USD");

        payload = new JSONObject();
        payload.put("standingInstructionId", siId);
        payload.put("supplier", supplier);
        payload.put("limit", limit);
        payload.put("limitInterval", "transaction");
        payload.put("validFrom", validFrom);
        payload.put("validTo", "2024-12-30");
        payload.put("card_token", cardToken);
        payload.put("type", type);
        payload.put("paymentOwner", emailCompany2);

        response = requestSpecification
                .contentType("application/json")
                .body(payload.toString())
                .post(url);
    }

    public void deleteStandingInstruction(String siId, String suppId){
        String url = baseUrl + "/Payment/1/deleteStandingInstruction";

        payload = new JSONObject();
        payload.put("standingInstructionId", siId);
        payload.put("supplierProductServiceId", suppId);

        response = requestSpecification
                .contentType("application/json")
                .body(payload.toString())
                .post(url);
    }

    public void retrievePaymentOverview(String type){
        String url = baseUrl + "/Payment/1/PaymentRequestOverview";

        JSONObject sortBy = new JSONObject();
        sortBy.put("column", "reference");
        sortBy.put("order", "asc");

        List<String> filter = new ArrayList<>();

        payload = new JSONObject();
        payload.put("type", type);
        payload.put("pagination", 10);
        payload.put("page", 1);
        payload.put("search", "");
        payload.put("sortBy", sortBy);
        payload.put("filterSearch", filter);

        response = requestSpecification
                .contentType("application/json")
                .body(payload.toString())
                .post(url);
    }

    public void createPaymentRequest(){
        String url = baseUrlPayReq + "/Payment/1/CreatePaymentRequest";

        JSONObject meta = new JSONObject();

        List<JSONObject> list = new ArrayList<>();
        JSONObject items = new JSONObject();
        items.put("description", "item 1 description");
        items.put("amount", "1000");
        list.add(items);
        meta.put("items", list);

        payload = new JSONObject();
        payload.put("externalReferenceId", "EXT-123" + new Random().nextInt(100));
        payload.put("reference", "TEST-PAYMENT, REF-1259, 1146, 4567, ABC");
        payload.put("totalChargeAmount", 1000);
        payload.put("currency", "USD");
        payload.put("status", "READY");
        payload.put("chargeDateTime", "2024-09-24");
        payload.put("meta", meta);


        response = requestSpecification
                .contentType("application/json")
                .body(payload.toString())
                .post(url);
    }

    public void createPaymentRequest(Integer amount){
        String url = baseUrlPayReq + "/Payment/1/CreatePaymentRequest";

        JSONObject meta = new JSONObject();

        List<JSONObject> list = new ArrayList<>();
        JSONObject items = new JSONObject();
        items.put("description", "item 1 description");
        items.put("amount", amount);
        list.add(items);
        meta.put("items", list);

        payload = new JSONObject();
        payload.put("externalReferenceId", "EXT-123");
        payload.put("reference", "TEST-PAYMENT, REF-1259, 1146, 4567, ABC");
        payload.put("totalChargeAmount", amount);
        payload.put("currency", "USD");
        payload.put("status", "READY");
        payload.put("chargeDateTime", "2024-09-24");
        payload.put("meta", meta);


        response = requestSpecification
                .contentType("application/json")
                .body(payload.toString())
                .post(url);
    }

    public String paymentId(){
        JSONObject resp = new JSONObject(response.asString());
        return resp.getString("paymentRequestId");
    }

    public void verifyThereIsPaymentReqId(String payId){
        Assert.assertTrue(lastResponse().jsonPath().getString("data.paymentRequestId").contains(payId));
    }

    public void verifyDelegateFromCompany(){
        Assert.assertTrue(lastResponse().jsonPath().getString("data.delegateFrom.companyName").contains("Auto QA Company"));
    }

    public void verifyDelegateToCompanyInList(){
        Assert.assertTrue(lastResponse().jsonPath().getString("data.delegateTo.companyName").contains("SG Auto QA"));
    }

    public void delegatePaymentRequest(String payId){
        String url = baseUrl + "/Payment/1/delegatePaymentRequest";

        List<JSONObject> paymentRequest = new ArrayList<>();
        JSONObject paymentRequests = new JSONObject();
        paymentRequests.put("paymentRequestId", payId);

        JSONObject delegateTo = new JSONObject();
        delegateTo.put("companyEmail", emailCompany2);
        delegateTo.put("companyName", "SG Auto QA");

        paymentRequests.put("delegateTo", delegateTo);
        paymentRequest.add(paymentRequests);

        payload = new JSONObject();
        payload.put("delegatePaymentRequest", paymentRequest);

        response = requestSpecification
                .contentType("application/json")
                .body(payload.toString())
                .post(url);
    }

    public void verifyPaymentIsAutoDeducted(){
        JSONObject jsonObject = new JSONObject(lastResponse().asString());
        boolean autoDeduct = jsonObject.getJSONArray("data").getJSONObject(0).getJSONObject("paymentRequest").getBoolean("isAutoDeduct");
        Assert.assertTrue(autoDeduct);
    }
}
