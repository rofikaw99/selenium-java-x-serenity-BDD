package starter.api;

import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.junit.Assert;
import starter.utlis.LOResponse;
import starter.utlis.UpdateLoPayload;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static net.serenitybdd.rest.SerenityRest.*;

public class UpdateLoAPI {
    GetLoAPI getLoAPI = new GetLoAPI();

    Response response;
    JSONObject payload;

    public void updateLOReq(JSONObject payload, String id) throws IOException {
        String accessToken = FileUtils.readFileToString(new File("src/test/java/starter/utlis/tokenOneRecord.json"), StandardCharsets.UTF_8);

        response = given()
                .headers(
                        "Authorization", "Bearer " + accessToken,
                        "Content-Type", "application/json",
                        "x-api-key", "5dfcf3da-8863-407b-89f1-8f12b08d2b33",
                        "Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .body(payload.toString())
                .patch(id);
    }

    public Integer getRevision(Response response) {
        return Integer.valueOf(response.getHeader("revision"));
    }

    public void updatePieceCountForRate(Integer revision, String idObjectTarget, Map<String, String> actualData, Integer pieceCountValue) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/pieceCountForRate/update.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idPieceCountForRate"));
        UpdateLoPayload.updateActualData(payload, pieceCountValue, 0);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void removePieceCountForRate(Integer revision, String idObjectTarget, Map<String, String> actualData, Integer piece) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/pieceCountForRate/delete.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idPieceCountForRate"));
        UpdateLoPayload.updateActualData(payload, piece, 0);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void addPieceCountForRate(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/pieceCountForRate/add.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idPieceCountForRate"));
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void verifySuccessUpdateLO(){
        then().statusCode(201);
    }

    public void verifyPieceOfCountUpdated(JSONObject response, int index) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, index);
        int actual = LOResponse.waybillLineItems_pieceCountForRate(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyRevisionIncreased(Response response, Integer expected){
        Integer actual = getRevision(response);
        Assert.assertEquals(Optional.of(expected + 1), Optional.of(actual));
    }

    public void updateGrossWeightForRate(Integer revision, String idObjectTarget, Map<String, String> actualData, float numericalValue) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/grossWeightForRate/update.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idUnitCode"), 0, 2);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idNumericalValue"), 2, 4);
        UpdateLoPayload.updateActualData(payload, actualData.get("unitCode"), 0);
        UpdateLoPayload.updateActualData(payload, numericalValue, 2);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void removeGrossWeightForRate(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/grossWeightForRate/delete.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idWaybillLine"), 0, 1);
        UpdateLoPayload.updateActualData(payload, actualData.get("idGrossWeightForRate"), 0);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void addGrossWeightForRate(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/grossWeightForRate/add.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idWaybillLine"), 0, 1);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void verifyGrossWeightForRateUnitCodeUpdated(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);
        String actual = LOResponse.WLI_GWFR_unit_code(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyChargeableWeightForRateUnitCodeUpdated(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);
        String actual = LOResponse.WLI_CWFR_unit_code(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyVolumeUnitCodeUpdated(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);
        String actual = LOResponse.WLI_DFR_volume_unit_code(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyVolumeNumericalValueUpdated(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 3);
        float actual = LOResponse.WLI_DFR_volume_numericalValue(response);
        Assert.assertEquals(expected, String.valueOf(actual));
    }

    public void verifyGrossWeightForRateNumericalValueUpdated(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 3);
        float actual = LOResponse.WLI_grossWeightForRate_numericalValue(response);
        Assert.assertEquals(expected, (int) actual);
    }

    public void verifyChargeableWeightForRateNumericalValueUpdated(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);
        float actual = LOResponse.WLI_chargeableWeightForRate_numericalValue(response);
        Assert.assertEquals(expected, (int) actual);
    }

    public void updateChargeableWeightForRate(Integer revision, String idObjectTarget, Map<String, String> actualData, float numericalValue) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/chargeableWeightForRate.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
//        UpdateLoPayload.updateOperationIds(payload, actualData.get("idUnitCode"), 0, 2);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idNumericalValue"), 0, 2);
//        UpdateLoPayload.updateActualData(payload, actualData.get("unitCode"), 0);
        UpdateLoPayload.updateActualData(payload, numericalValue, 0);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void updateVolume(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/volume/update.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idUnitCode"), 0, 2);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idNumericalValue"), 2, 4);
        UpdateLoPayload.updateActualData(payload, actualData.get("unitCode"), 0);
        UpdateLoPayload.updateActualData(payload, actualData.get("numericalValue"), 2);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void deleteVolume(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/volume/delete.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idDimensionsForRate"), 0, 1);
        UpdateLoPayload.updateActualData(payload, actualData.get("idVolume"), 0);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void addVolume(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/volume/add.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idDimensionsForRate"), 0, 1);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void updateDimensions(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/dimensions/update.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idHeightUnitCode"), 0, 2);
        UpdateLoPayload.updateActualData(payload, actualData.get("heightUnitCode"), 0);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idHeightNumericalValue"), 2, 4);
        UpdateLoPayload.updateActualData(payload, actualData.get("heightNumericalValue"), 2);

        UpdateLoPayload.updateOperationIds(payload, actualData.get("idLengthUnitCode"), 4, 6);
        UpdateLoPayload.updateActualData(payload, actualData.get("lengthUnitCode"), 4);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idLengthNumericalValue"), 6, 8);
        UpdateLoPayload.updateActualData(payload, actualData.get("lengthNumericalValue"), 6);

        UpdateLoPayload.updateOperationIds(payload, actualData.get("idWidthUnitCode"), 8, 10);
        UpdateLoPayload.updateActualData(payload, actualData.get("widthUnitCode"), 8);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idWidthNumericalValue"), 10, 12);
        UpdateLoPayload.updateActualData(payload, actualData.get("widthNumericalValue"), 10);

        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public String getChangeRequestId(){
        return response.getHeader("Location");
    }

    public void verifyHeightUnitCodeUpdated(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);
        String actual = LOResponse.WLI_DFR_height_unit_code(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyHeightNumericalValueUpdated(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 3);
        float actual = LOResponse.WLI_DFR_height_numericalValue(response);
        Assert.assertEquals(expected, String.valueOf((int) actual));
    }

    public void verifyLengthUnitCodeUpdated(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 5);
        String actual = LOResponse.WLI_DFR_length_unit_code(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyLengthNumericalValueUpdated(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 7);
        float actual = LOResponse.WLI_DFR_length_numericalValue(response);
        Assert.assertEquals(expected, String.valueOf((int) actual));
    }

    public void verifyWidthUnitCodeUpdated(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 9);
        String actual = LOResponse.WLI_DFR_width_unit_code(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyWidthNumericalValueUpdated(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 11);
        float actual = LOResponse.WLI_DFR_width_numericalValue(response);
        Assert.assertEquals(expected, String.valueOf((int) actual));
    }

    public void addDimensions(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/dimensions/add.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idDimensionsForRate"), 0, 1);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idDimensionsForRate"), 4, 5);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idDimensionsForRate"), 8, 9);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void updateShipmentDescription(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/goodsDescriptionForRate/update.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idWaybillLine"));
        UpdateLoPayload.updateActualData(payload, actualData.get("shipmentDescription"), 0);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void deleteShipmentDescription(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/goodsDescriptionForRate/delete.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idWaybillLine"));
        UpdateLoPayload.updateActualData(payload, actualData.get("shipmentDescription"), 0);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void addShipmentDescription(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/goodsDescriptionForRate/add.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idWaybillLine"));
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void verifyShipmentDescriptionUpdated(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);
        String actual = LOResponse.waybillLineItems_goodsDescriptionForRate(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyShipmentDescriptionDeleted(JSONObject response) {
        String actual = LOResponse.waybillLineItems_goodsDescriptionForRate(response);
        Assert.assertNull(actual);
    }

    public void verifyShipmentDescriptionAdded(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 0);
        String actual = LOResponse.waybillLineItems_goodsDescriptionForRate(response);
        Assert.assertEquals(expected, actual);
    }

    public void deleteDimensions(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/dimensions/delete.json"),
                StandardCharsets.UTF_8)
        );


        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idDimensions"), 0, 3);
        UpdateLoPayload.updateActualData(payload, actualData.get("idLength"), 0);
        UpdateLoPayload.updateActualData(payload, actualData.get("idWidth"), 1);
        UpdateLoPayload.updateActualData(payload, actualData.get("idHeight"), 2);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void verifyHeightDeleted(JSONObject response) {
        JSONObject actual = LOResponse.WLI_dimensionsForRate_height(response);
        Assert.assertNull(actual);
    }

    public void verifyPieceOfCountDeleted(JSONObject response) {
        int expected = 0;
        int actual = LOResponse.waybillLineItems_pieceCountForRate(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyLengthDeleted(JSONObject response) {
        JSONObject actual = LOResponse.WLI_dimensionsForRate_length(response);
        Assert.assertNull(actual);
    }

    public void verifyWidthDeleted(JSONObject response) {
        JSONObject actual = LOResponse.WLI_dimensionsForRate_width(response);
        Assert.assertNull(actual);
    }

    public void updateHsCodeForRate(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/hsCodeForRate.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idHeightUnitCode"), 0, 1);
        UpdateLoPayload.updateActualData(payload, actualData.get("heightUnitCode"), 0);

        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void updateCommodityCode(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/hsCodeForRate/update.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idHsCodeForRate"));
        UpdateLoPayload.updateActualData(payload, actualData.get("hsCodeForRate"), 0);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void deleteCommodityCode(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/hsCodeForRate/delete.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, idObjectTarget);
        UpdateLoPayload.updateActualData(payload, actualData.get("idHsCodeForRate"), 0);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void addCommodityCode(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/hsCodeForRate/add.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idWaybillLine"), 0, 1);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void verifyHsCodeForRateUpdated(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);;
        String actual = LOResponse.waybillLineItems_hsCodeForRate_code(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyHsCodeForRateDeleted(JSONObject response) {
        JSONObject actual = LOResponse.waybillLineItems_hsCodeForRate(response);
        Assert.assertNull(actual);
    }

    public void verifyHsCodeForRateAdded(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);
        String actual = LOResponse.waybillLineItems_hsCodeForRate_code(response);
        Assert.assertEquals(expected, actual);
    }

    public void updateSpecialHandlingCode(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/specialHandlingCode/update.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idSpecialHandlingCode"));
        UpdateLoPayload.updateActualData(payload, actualData.get("codeSpecialHandlingCode"), 0);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void deleteSpecialHandlingCode(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/specialHandlingCode/delete.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, idObjectTarget);
        UpdateLoPayload.updateActualData(payload, actualData.get("idSpecialHandlingCode"), 0);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void addSpecialHandlingCode(Integer revision, String idObjectTarget) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/specialHandlingCode/add.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, idObjectTarget, 0, 1);
//        UpdateLoPayload.updateOperationIds(payload, idObjectTarget, 2, 3);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void verifySpecialHandlingCodeUpdated(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);
        String actual = LOResponse.shipment_specialHandlingCodes_code(response, 0);
        Assert.assertEquals(expected, actual);
    }

    public void verifySpecialHandlingCodeDeleted(JSONObject response) {
        Assert.assertNull(LOResponse.shipment_specialHandlingCodes(response));
    }

    public void verifySpecialHandlingCodeAdded(JSONObject response) {
        List<Object> expected = new ArrayList<>();
        expected.add(UpdateLoPayload.getHasValueOfHasOperation(payload, 1));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < LOResponse.shipment_specialHandlingCodes(response).length(); i++){
            result.add(LOResponse.shipment_specialHandlingCodes_code(response, i));
        }
        Assert.assertTrue(result.containsAll(expected));
    }

    public void updateShipperNameAddress(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/shipperNameAddress.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idPartyDetails"), 0, 2);
        UpdateLoPayload.updateActualData(payload, actualData.get("partyDetailsName"), 0);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idStreetAddressLine"), 2, 4);
        UpdateLoPayload.updateActualData(payload, actualData.get("streetAddressLine"), 2);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void verifyPartyName(JSONObject response, String party) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);;
        String actual = LOResponse.IP_partyDetails_name(response, party);
        Assert.assertEquals(expected, actual);
    }

    public void verifyPartyStressAddress(JSONObject response, String party) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 3);;
        String actual = LOResponse.IP_PD_BAT_address_streetAddressLines(response, party);
        Assert.assertEquals(expected, actual);
    }

    public void updateConsigneeNameAddress(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/consigneeNameAddress.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idPartyDetails"), 0, 2);
        UpdateLoPayload.updateActualData(payload, actualData.get("partyDetailsName"), 0);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idStreetAddressLine"), 2, 4);
        UpdateLoPayload.updateActualData(payload, actualData.get("streetAddressLine"), 2);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void updateOtherChargeCode(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/otherChargeCode/update.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idOtherChargeCode"));
        UpdateLoPayload.updateActualData(payload, actualData.get("otherChargeCode"), 0);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void deleteOtherChargeCode(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/otherChargeCode/delete.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, idObjectTarget);
        UpdateLoPayload.updateActualData(payload, actualData.get("idOtherChargeCode"), 0);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void addOtherChargeCode(Integer revision, String idObjectTarget) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/otherChargeCode/add.json"),
                StandardCharsets.UTF_8)
        );

        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, idObjectTarget, 0, 1);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void verifyOtherChargesCode(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);;
        String actual = LOResponse.otherCharges_otherChargeCode_code(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyOtherChargesDeleted(JSONObject response) {
        JSONObject actual = LOResponse.otherCharges_otherChargeCode(response);
        Assert.assertNull(actual);
    }

    public void verifyOtherChargesAdded(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);
        String actual = LOResponse.otherCharges_otherChargeCode_code(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyGrossWeightForRateDeleted(JSONObject response) {
        JSONObject actual = LOResponse.waybillLineItems_grossWeightForRate(response);
        Assert.assertNull(actual);
    }

    public void verifyVolumeDeleted(JSONObject response) {
        JSONObject actual = LOResponse.WLI_dimensionsForRate_volume(response);
        Assert.assertNull(actual);
    }

    public void verifyGrossWeightForRateUnitAdded(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 3);
        String actual = LOResponse.WLI_GWFR_unit_code(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyGrossWeightForRateValueAdded(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);
        int actual = (int) LOResponse.WLI_grossWeightForRate_numericalValue(response);
        Assert.assertEquals(expected, String.valueOf(actual));
    }

    public void verifyVolumeUnitAdded(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 3);
        String actual = LOResponse.WLI_DFR_volume_unit_code(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyVolumeValueAdded(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);
        float actual = LOResponse.WLI_DFR_volume_numericalValue(response);
        Assert.assertEquals(expected, String.valueOf(actual));
    }

    public void verifyWidthUnitAdded(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 11);
        String actual = LOResponse.WLI_DFR_width_unit_code(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyWidthValueAdded(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 9);
        float actual = LOResponse.WLI_DFR_width_numericalValue(response);
        Assert.assertEquals(expected, String.valueOf(actual));
    }

    public void verifyLengthUnitAdded(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 7);
        String actual = LOResponse.WLI_DFR_length_unit_code(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyLengthValueAdded(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 5);
        float actual = LOResponse.WLI_DFR_length_numericalValue(response);
        Assert.assertEquals(expected, String.valueOf(actual));
    }

    public void verifyHeightUnitAdded(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 3);
        String actual = LOResponse.WLI_DFR_height_unit_code(response);
        Assert.assertEquals(expected, actual);
    }

    public void verifyHeightValueAdded(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);
        float actual = LOResponse.WLI_DFR_height_numericalValue(response);
        Assert.assertEquals(expected, String.valueOf(actual));
    }

    public void updateOtherCustomInformation(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/customsInformation/update.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, idObjectTarget);
        UpdateLoPayload.updateActualData(payload, actualData.get("note"), 0);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void verifyOtherCustomsInformation(JSONObject response, int index) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);
        String actual = LOResponse.shipment_customsInformation_note(response, index);
        Assert.assertEquals(expected, actual);
    }

    public void deleteOtherCustomInformation(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/customsInformation/delete.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, idObjectTarget);
        UpdateLoPayload.updateActualData(payload, actualData.get("note"), 0);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void verifyOtherCustomsInformationDeleted(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 0);
        boolean result = true;
        for (int i = 0; i < LOResponse.shipment_customsInformation(response).length(); i++){
            if (Objects.equals(LOResponse.shipment_customsInformation_note(response, i), expected)) {
                result = false;
                break;
            }
        }
        Assert.assertTrue(result);
    }

    public void addOtherCustomInformation(Integer revision, String idObjectTarget) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/customsInformation/add.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, idObjectTarget);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void verifyOtherCustomsInformationAdded(JSONObject response) {
        List<Object> expected = new ArrayList<>();
        expected.add(UpdateLoPayload.getHasValueOfHasOperation(payload, 0));
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < LOResponse.shipment_customsInformation(response).length(); i++){
            result.add(LOResponse.shipment_customsInformation_note(response, i));
        }
        Assert.assertTrue(result.containsAll(expected));
    }

    public void updateSlacForRate(Integer revision, String idObjectTarget, Map<String, String> actualData) throws IOException {
        // Load the JSON payload from the file
        payload = new JSONObject(FileUtils.readFileToString(
                new File("src/test/java/starter/payload/slacForRate.json"),
                StandardCharsets.UTF_8)
        );

        // Update the payload with the extracted details
        UpdateLoPayload.updateLogisticsObjectId(payload, idObjectTarget);
        UpdateLoPayload.updateOperationIds(payload, actualData.get("idSlacForRate"), 0, 2);
        UpdateLoPayload.updateActualData(payload, actualData.get("slacForRate"), 0);
        UpdateLoPayload.updateRevision(payload, revision);

        // Send the update request
        updateLOReq(payload, idObjectTarget);
    }

    public void verifySlacForRateUpdated(JSONObject response) {
        Object expected = UpdateLoPayload.getHasValueOfHasOperation(payload, 1);
        String actual = LOResponse.waybillLineItems_slacForRate(response);
        Assert.assertEquals(expected, actual);
    }
}
