package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;
import org.junit.Assert;
import starter.api.CreateLoAPI;
import starter.api.GetChangeRequestAPI;
import starter.api.GetLoAPI;
import starter.api.UpdateLoAPI;
import starter.utlis.onerecord.LOResponse;
import starter.utlis.onerecord.XFWBResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateLOStep {

    @Steps
    CreateLoAPI createLoAPI;

    @Steps
    UpdateLoAPI updateLoAPI;

    @Steps
    GetLoAPI getLoAPI;

    @Steps
    GetChangeRequestAPI getChangeRequestAPI;

    String id, idTarget, houseId, idChangeRequest, masterWaybill, houseWaybill = "";
    JSONObject responseJson;
    Response response;
    Integer revision, index;
    Map<String, String> actualData = new HashMap<>();
    List<String> loId = new ArrayList<>();

    @Given("user success create LO")
    public void userSuccessCreateLO() throws IOException {
        id = createLoAPI.createLoRequestUrl("internal");
    }

    @And("user success get LO")
    public void userSuccessGetLO() throws IOException {
//        response = getLoAPI.getLORequestFullResponse(id);
        List<String> loIds = List.of(id.split("/"));
        id = loIds.get(loIds.size() - 1);
        response = getLoAPI.getLORequestLoIdResponse(id);
        responseJson = new JSONObject(response.asString());
    }

    @When("user update piece of count")
    public void userUpdatePieceOfCount() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        Integer pieceCountValue = LOResponse.waybillLineItems_pieceCountForRate(responseJson);

        actualData.put("idPieceCountForRate", LOResponse.waybillLineItems_id(responseJson));
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updatePieceCountForRate(revision, idTarget, actualData, pieceCountValue);
    }

    @When("user remove piece of count")
    public void userRemovePieceOfCount() throws IOException, InterruptedException {
        Thread.sleep(2000);
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        Integer pieceCount = LOResponse.waybillLineItems_pieceCountForRate(responseJson);

        actualData.put("idPieceCountForRate",LOResponse.waybillLineItems_id(responseJson));
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.removePieceCountForRate(revision, idTarget, actualData, pieceCount);
    }

    @When("user add piece of count")
    public void userAddPieceOfCount() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        actualData.put("idPieceCountForRate", LOResponse.waybillLineItems_id(responseJson));

        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.addPieceCountForRate(revision, idTarget, actualData);
    }

    @And("the piece of count deleted in the latest get lo")
    public void thePieceOfCountDeletedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyPieceOfCountDeleted(jsonResponse);
    }

    @And("the piece of count added in the latest get lo")
    public void thePieceOfCountAddedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        updateLoAPI.verifyPieceOfCountUpdated(new JSONObject(response.asString()), 0);
    }

    @And("the piece of count value changes in the latest get lo")
    public void thePieceOfCountValueChangesInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(5000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        updateLoAPI.verifyPieceOfCountUpdated(new JSONObject(response.asString()), 1);
    }

    @And("the revision value changes to increment {int}")
    public void theRevisionValueChangesToIncrement(int arg0) throws IOException {
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        updateLoAPI.verifyRevisionIncreased(response, revision);
    }

    @When("user update gross weight for rate")
    public void userUpdateGrossWeightForRate() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        float numericalValue = LOResponse.WLI_grossWeightForRate_numericalValue(responseJson);
        String idNumericalValue = LOResponse.WLI_grossWeightForRate_id(responseJson);
        String unitCode = LOResponse.WLI_GWFR_unit_code(responseJson);
        String idUnitCode = LOResponse.WLI_GWFR_unit_id(responseJson);

        actualData.put("idNumericalValue", idNumericalValue);
        actualData.put("idUnitCode", idUnitCode);
        actualData.put("unitCode", unitCode);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateGrossWeightForRate(revision, idTarget, actualData, numericalValue);
    }

    @And("the gross weight for rate value changes in the latest get lo")
    public void theGrossWeightForRateValueChangesInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyGrossWeightForRateUnitCodeUpdated(jsonResponse);
        updateLoAPI.verifyGrossWeightForRateNumericalValueUpdated(jsonResponse);
    }

    @When("user update chargeable weight")
    public void userUpdateChargeableWeight() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        float numericalValue = LOResponse.WLI_chargeableWeightForRate_numericalValue(responseJson);
        String idNumericalValue = LOResponse.WLI_chargeableWeightForRate_id(responseJson);
        String unitCode = LOResponse.WLI_CWFR_unit_code(responseJson);
        String idUnitCode = LOResponse.WLI_CWFR_unit_id(responseJson);

        actualData.put("idNumericalValue", idNumericalValue);
        actualData.put("idUnitCode", idUnitCode);
        actualData.put("unitCode", unitCode);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateChargeableWeightForRate(revision, idTarget, actualData, numericalValue);
    }

    @Then("success update {string}")
    public void successUpdate(String arg0) throws InterruptedException {
        updateLoAPI.verifySuccessUpdateLO();
        Thread.sleep(2000);
    }

    @And("the chargeable weight value changes in the latest get lo")
    public void theChargeableWeightValueChangesInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
//        updateLoAPI.verifyChargeableWeightForRateUnitCodeUpdated(jsonResponse);
        updateLoAPI.verifyChargeableWeightForRateNumericalValueUpdated(jsonResponse);
    }

    @When("user update volume")
    public void userUpdateVolume() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        float numericalValue = LOResponse.WLI_DFR_volume_numericalValue(responseJson);
        String idNumericalValue = LOResponse.WLI_DFR_volume_id(responseJson);
        String unitCode = LOResponse.WLI_DFR_volume_unit_code(responseJson);
        String idUnitCode = LOResponse.WLI_DFR_volume_unit_id(responseJson);

        actualData.put("idNumericalValue", idNumericalValue);
        actualData.put("numericalValue", String.valueOf(numericalValue));
        actualData.put("idUnitCode", idUnitCode);
        actualData.put("unitCode", unitCode);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateVolume(revision, idTarget, actualData);
    }

    @And("the volume value changes in the latest get lo")
    public void theVolumeValueChangesInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyVolumeUnitCodeUpdated(jsonResponse);
        updateLoAPI.verifyVolumeNumericalValueUpdated(jsonResponse);
    }

    @When("user update dimensions")
    public void userUpdateDimensions() throws IOException {
JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        float heightNumericalValue = LOResponse.WLI_DFR_height_numericalValue(responseJson);
        String idHeightNumericalValue = LOResponse.WLI_DFR_height_id(responseJson);
        String heightUnitCode = LOResponse.WLI_DFR_height_unit_code(responseJson);
        String idHeightUnitCode = LOResponse.WLI_DFR_height_unit_id(responseJson);

        float lengthNumericalValue = LOResponse.WLI_DFR_length_numericalValue(responseJson);
        String idLengthNumericalValue = LOResponse.WLI_DFR_length_id(responseJson);
        String lengthUnitCode = LOResponse.WLI_DFR_length_unit_code(responseJson);
        String idLengthUnitCode = LOResponse.WLI_DFR_length_unit_id(responseJson);

        float widthNumericalValue = LOResponse.WLI_DFR_width_numericalValue(responseJson);
        String idWidthNumericalValue = LOResponse.WLI_DFR_width_id(responseJson);
        String widthUnitCode = LOResponse.WLI_DFR_width_unit_code(responseJson);
        String idWidthUnitCode = LOResponse.WLI_DFR_width_unit_id(responseJson);

        actualData.put("idHeightUnitCode", idHeightUnitCode);
        actualData.put("heightUnitCode", heightUnitCode);
        actualData.put("idHeightNumericalValue", idHeightNumericalValue);
        actualData.put("heightNumericalValue", String.valueOf(heightNumericalValue));

        actualData.put("idLengthUnitCode", idLengthUnitCode);
        actualData.put("lengthUnitCode", lengthUnitCode);
        actualData.put("idLengthNumericalValue", idLengthNumericalValue);
        actualData.put("lengthNumericalValue", String.valueOf(lengthNumericalValue));

        actualData.put("idWidthUnitCode", idWidthUnitCode);
        actualData.put("widthUnitCode", widthUnitCode);
        actualData.put("idWidthNumericalValue", idWidthNumericalValue);
        actualData.put("widthNumericalValue", String.valueOf(widthNumericalValue));
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateDimensions(revision, idTarget, actualData);
    }

    @And("the dimensions value changes in the latest get lo")
    public void theDimensionsValueChangesInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyHeightUnitCodeUpdated(jsonResponse);
        updateLoAPI.verifyHeightNumericalValueUpdated(jsonResponse);
        updateLoAPI.verifyLengthUnitCodeUpdated(jsonResponse);
        updateLoAPI.verifyLengthNumericalValueUpdated(jsonResponse);
        updateLoAPI.verifyWidthUnitCodeUpdated(jsonResponse);
        updateLoAPI.verifyWidthNumericalValueUpdated(jsonResponse);
    }

    @When("user update Shipment description")
    public void userUpdateShipmentDescription() throws IOException {
JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        String shipmentDescription = LOResponse.waybillLineItems_goodsDescriptionForRate(responseJson);

        actualData.put("idWaybillLine", LOResponse.waybillLineItems_id(responseJson));
        actualData.put("shipmentDescription", shipmentDescription);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateShipmentDescription(revision, idTarget, actualData);
    }

    @And("the Shipment description value changes in the latest get lo")
    public void theShipmentDescriptionValueChangesInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        updateLoAPI.verifyShipmentDescriptionUpdated(new JSONObject(response.asString()));
    }

    @When("user delete dimensions")
    public void userDeleteDimensions() throws IOException {
JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        String idDimensions = LOResponse.WLI_dimensionsForRate_id(responseJson);
        String idHeight = LOResponse.WLI_DFR_height_id(responseJson);
        String idLength = LOResponse.WLI_DFR_length_id(responseJson);
        String idWidth = LOResponse.WLI_DFR_width_id(responseJson);

        actualData.put("idDimensions", idDimensions);
        actualData.put("idHeight", idHeight);
        actualData.put("idLength", idLength);
        actualData.put("idWidth", idWidth);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.deleteDimensions(revision, idTarget, actualData);
    }

    @And("the dimensions value deleted in the latest get lo")
    public void theDimensionsValueDeletedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(3000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyHeightDeleted(jsonResponse);
        updateLoAPI.verifyLengthDeleted(jsonResponse);
        updateLoAPI.verifyWidthDeleted(jsonResponse);
    }

    @When("user update Commodity \\(price) code")
    public void userUpdateCommodityPriceCode() throws IOException {
JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        String hsCodeForRate = LOResponse.waybillLineItems_hsCodeForRate_code(responseJson);
        String hsCodeForRateId = LOResponse.waybillLineItems_hsCodeForRate_id(responseJson);

        actualData.put("idHsCodeForRate", hsCodeForRateId);
        actualData.put("hsCodeForRate", hsCodeForRate);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateCommodityCode(revision, idTarget, actualData);
    }

    @And("the commodity \\(price) code value changes in the latest get lo")
    public void theCommodityPriceCodeValueChangesInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyHsCodeForRateUpdated(jsonResponse);
    }

    @When("user update special handling code")
    public void userUpdateSpecialHandlingCode() throws IOException {
JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.shipment_id(responseJson);
        String idSpecialHandlingCode = LOResponse.shipment_specialHandlingCodes_id(responseJson, 0);
        String codeSpecialHandlingCode = LOResponse.shipment_specialHandlingCodes_code(responseJson, 0);

        actualData.put("idSpecialHandlingCode", idSpecialHandlingCode);
        actualData.put("codeSpecialHandlingCode", codeSpecialHandlingCode);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateSpecialHandlingCode(revision, idTarget, actualData);
    }

    @And("the special handling code value changes in the latest get lo")
    public void theSpecialHandlingCodeValueChangesInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifySpecialHandlingCodeUpdated(jsonResponse);
    }

    @When("user update shipper name, address")
    public void userUpdateShipperNameAddress() throws IOException {
JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.shipment_id(responseJson);
        String idPartyDetails = LOResponse.s_IP_partyDetails_id(responseJson, "SHP");
        String partyDetailsName = LOResponse.s_IP_partyDetails_name(responseJson, "SHP");
        String idStreetAddressLine = LOResponse.s_IP_PD_BAT_address_id(responseJson, "SHP");
        String streetAddressLine = LOResponse.s_IP_PD_BAT_address_streetAddressLines(responseJson, "SHP");

        actualData.put("idPartyDetails", idPartyDetails);
        actualData.put("partyDetailsName", partyDetailsName);
        actualData.put("idStreetAddressLine", idStreetAddressLine);
        actualData.put("streetAddressLine", streetAddressLine);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateShipperNameAddress(revision, idTarget, actualData);
    }

    @And("the shipper name, address value changes in the latest get lo")
    public void theShipperNameAddressValueChangesInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyPartyName(jsonResponse, "SHP");
        updateLoAPI.verifyPartyStressAddress(jsonResponse, "SHP");
    }

    @When("user update consignee name, address")
    public void userUpdateConsigneeNameAddress() throws IOException {
JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.shipment_id(responseJson);
        String idPartyDetails = LOResponse.s_IP_partyDetails_id(responseJson, "CNE");
        String partyDetailsName = LOResponse.s_IP_partyDetails_name(responseJson, "CNE");
        String idStreetAddressLine = LOResponse.s_IP_PD_BAT_address_id(responseJson, "CNE");
        String streetAddressLine = LOResponse.s_IP_PD_BAT_address_streetAddressLines(responseJson, "CNE");

        actualData.put("idPartyDetails", idPartyDetails);
        actualData.put("partyDetailsName", partyDetailsName);
        actualData.put("idStreetAddressLine", idStreetAddressLine);
        actualData.put("streetAddressLine", streetAddressLine);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateConsigneeNameAddress(revision, idTarget, actualData);
    }

    @And("the consignee name, address value changes in the latest get lo")
    public void theConsigneeNameAddressValueChangesInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyPartyName(jsonResponse, "CNE");
        updateLoAPI.verifyPartyStressAddress(jsonResponse, "CNE");
    }

    @When("user update OCDC charges, MYC, SCC, RAC, etc")
    public void userUpdateOCDCChargesMYCSCCRACEtc() throws IOException {
JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        String idOtherChargeCode = LOResponse.otherCharges_otherChargeCode_id(responseJson);
        String otherChargeCode = LOResponse.otherCharges_otherChargeCode_code(responseJson);

        actualData.put("idOtherChargeCode", idOtherChargeCode);
        actualData.put("otherChargeCode", otherChargeCode);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateOtherChargeCode(revision, idTarget, actualData);
    }

    @And("the OCDC charges, MYC, SCC, RAC, etc value changes in the latest get lo")
    public void theOCDCChargesMYCSCCRACEtcValueChangesInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyOtherChargesCode(jsonResponse);
    }

    @And("user success create LO for deleted key {string}")
    public void userSuccessCreateLOForDeletedKey(String key) throws IOException {
        id = createLoAPI.createLORequest(key);
    }

    @When("user delete gross weight for rate")
    public void userDeleteGrossWeightForRate() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        String idWaybillLine = LOResponse.waybillLineItems_id(responseJson);
        String idGrossWeightForRate = LOResponse.WLI_grossWeightForRate_id(responseJson);

        actualData.put("idWaybillLine", idWaybillLine);
        actualData.put("idGrossWeightForRate", idGrossWeightForRate);

        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.removeGrossWeightForRate(revision, idTarget, actualData);
    }

    @And("the gross weight for rate deleted in the latest get lo")
    public void theGrossWeightForRateDeletedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(1000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyGrossWeightForRateDeleted(jsonResponse);
    }

    @When("user add gross weight for rate")
    public void userAddGrossWeightForRate() throws IOException {
JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        String idWaybillLine = LOResponse.waybillLineItems_id(responseJson);

        actualData.put("idWaybillLine", idWaybillLine);

        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.addGrossWeightForRate(revision, idTarget, actualData);
    }

    @And("the gross weight for rate added in the latest get lo")
    public void theGrossWeightForRateAddedInTheLatestGetLo() throws InterruptedException, IOException {
        Thread.sleep(1000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyGrossWeightForRateUnitAdded(jsonResponse);
        updateLoAPI.verifyGrossWeightForRateValueAdded(jsonResponse);
    }

    @When("user delete volume")
    public void userDeleteVolume() throws IOException {
JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        String idDimensionsForRate = LOResponse.WLI_dimensionsForRate_id(responseJson);
        String idVolume = LOResponse.WLI_DFR_volume_id(responseJson);

        actualData.put("idDimensionsForRate", idDimensionsForRate);
        actualData.put("idVolume", idVolume);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.deleteVolume(revision, idTarget, actualData);
    }

    @And("the volume value deleted in the latest get lo")
    public void theVolumeValueDeletedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyVolumeDeleted(jsonResponse);
    }

    @When("user add volume")
    public void userAddVolume() throws IOException {
JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        String idDimensionsForRate = LOResponse.WLI_dimensionsForRate_id(responseJson);

        actualData.put("idDimensionsForRate", idDimensionsForRate);

        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.addVolume(revision, idTarget, actualData);
    }

    @And("the volume value added in the latest get lo")
    public void theVolumeValueAddedInTheLatestGetLo() throws InterruptedException, IOException {
        Thread.sleep(1000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyVolumeValueAdded(jsonResponse);
        updateLoAPI.verifyVolumeUnitAdded(jsonResponse);
    }

    @When("user add dimensions")
    public void userAddDimensions() throws IOException {
JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        String idDimensionsForRate = LOResponse.WLI_dimensionsForRate_id(responseJson);

        actualData.put("idDimensionsForRate", idDimensionsForRate);

        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.addDimensions(revision, idTarget, actualData);
    }

    @And("the dimensions value added in the latest get lo")
    public void theDimensionsValueAddedInTheLatestGetLo() throws InterruptedException, IOException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyHeightValueAdded(jsonResponse);
        updateLoAPI.verifyHeightUnitAdded(jsonResponse);
        updateLoAPI.verifyLengthValueAdded(jsonResponse);
        updateLoAPI.verifyLengthUnitAdded(jsonResponse);
        updateLoAPI.verifyWidthValueAdded(jsonResponse);
        updateLoAPI.verifyWidthUnitAdded(jsonResponse);
    }

    @When("user delete Shipment description")
    public void userDeleteShipmentDescription() throws IOException {
JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        String shipmentDescription = LOResponse.waybillLineItems_goodsDescriptionForRate(responseJson);

        actualData.put("idWaybillLine", LOResponse.waybillLineItems_id(responseJson));
        actualData.put("shipmentDescription", shipmentDescription);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.deleteShipmentDescription(revision, idTarget, actualData);
    }

    @And("the Shipment description value deleted in the latest get lo")
    public void theShipmentDescriptionValueDeletedInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyShipmentDescriptionDeleted(jsonResponse);
    }

    @When("user add Shipment description")
    public void userAddShipmentDescription() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);

        actualData.put("idWaybillLine", LOResponse.waybillLineItems_id(responseJson));

        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.addShipmentDescription(revision, idTarget, actualData);
    }

    @And("the Shipment description value added in the latest get lo")
    public void theShipmentDescriptionValueAddedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyShipmentDescriptionAdded(jsonResponse);
    }

    @When("user delete Commodity \\(price) code")
    public void userDeleteCommodityPriceCode() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        String hsCodeForRateId = LOResponse.waybillLineItems_hsCodeForRate_id(responseJson);

        actualData.put("idHsCodeForRate", hsCodeForRateId);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.deleteCommodityCode(revision, idTarget, actualData);
    }

    @And("the commodity \\(price) code value deleted in the latest get lo")
    public void theCommodityPriceCodeValueDeletedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyHsCodeForRateDeleted(jsonResponse);
    }

    @When("user add Commodity \\(price) code")
    public void userAddCommodityPriceCode() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);

        actualData.put("idWaybillLine", LOResponse.waybillLineItems_id(responseJson));

        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.addCommodityCode(revision, idTarget, actualData);
    }

    @And("the commodity \\(price) code value added in the latest get lo")
    public void theCommodityPriceCodeValueAddedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyHsCodeForRateAdded(jsonResponse);
    }

    @When("user delete special handling code")
    public void userDeleteSpecialHandlingCode() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.shipment_id(responseJson);
        String idSpecialHandlingCode = LOResponse.shipment_specialHandlingCodes_id(responseJson, 0);

        actualData.put("idSpecialHandlingCode", idSpecialHandlingCode);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.deleteSpecialHandlingCode(revision, idTarget, actualData);
    }

    @And("the special handling code value deleted in the latest get lo")
    public void theSpecialHandlingCodeValueDeletedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifySpecialHandlingCodeDeleted(jsonResponse);
    }

    @When("user add special handling code")
    public void userAddSpecialHandlingCode() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.shipment_id(responseJson);

        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.addSpecialHandlingCode(revision, idTarget);
    }

    @And("the special handling code value added in the latest get lo")
    public void theSpecialHandlingCodeValueAddedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifySpecialHandlingCodeAdded(jsonResponse);
    }

    @When("user delete OCDC charges, MYC, SCC, RAC, etc")
    public void userDeleteOCDCChargesMYCSCCRACEtc() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        String idOtherCharge = LOResponse.otherCharges_id(responseJson);
        String idOtherChargeCode = LOResponse.otherCharges_otherChargeCode_id(responseJson);

        actualData.put("idOtherChargeCode", idOtherChargeCode);
        actualData.put("idOtherCharge", idOtherCharge);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.deleteOtherChargeCode(revision, idTarget, actualData);
    }

    @And("the OCDC charges, MYC, SCC, RAC, etc value deleted in the latest get lo")
    public void theOCDCChargesMYCSCCRACEtcValueDeletedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyOtherChargesDeleted(jsonResponse);
    }

    @When("user add OCDC charges, MYC, SCC, RAC, etc")
    public void userAddOCDCChargesMYCSCCRACEtc() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);

        actualData.put("idOtherCharge", LOResponse.otherCharges_id(responseJson));

        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.addOtherChargeCode(revision, idTarget, actualData);
    }

    @And("the OCDC charges, MYC, SCC, RAC, etc value added in the latest get lo")
    public void theOCDCChargesMYCSCCRACEtcValueAddedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyOtherChargesAdded(jsonResponse);
    }

    @And("user success create LO with new waybill number")
    public void userSuccessCreateLOWithNewWaybillNumber() throws IOException {
        JSONObject customPaylod = createLoAPI.payload();
        customPaylod = createLoAPI.modifyPayload(customPaylod, "waybillNumber", "");
        masterWaybill = XFWBResponse.waybillNumber(customPaylod);
        id = createLoAPI.createLoRequestCustom(customPaylod);
    }

    @When("user update Other Customs Information")
    public void userUpdateOtherCustomsInformation() throws IOException {
        index = 0;
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.shipment_customsInformation_id(responseJson, index);
        String note = LOResponse.shipment_customsInformation_note(responseJson, index);

        actualData.put("note", note);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateOtherCustomInformation(revision, idTarget, actualData);
    }

    @And("the Other Customs Information value changes in the latest get lo")
    public void theOtherCustomsInformationValueChangesInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(1000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyOtherCustomsInformation(jsonResponse, index);
    }

    @When("user delete Other Customs Information")
    public void userDeleteOtherCustomsInformation() throws IOException {
        index = 0;
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.shipment_customsInformation_id(responseJson, index);
        String note = LOResponse.shipment_customsInformation_note(responseJson, index);

        actualData.put("note", note);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.deleteOtherCustomInformation(revision, idTarget, actualData);
    }

    @And("the Other Customs Information value deleted in the latest get lo")
    public void theOtherCustomsInformationValueDeletedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(1000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyOtherCustomsInformationDeleted(jsonResponse);
    }

    @When("user add Other Customs Information")
    public void userAddOtherCustomsInformation() throws IOException {
        index = 0;
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.shipment_customsInformation_id(responseJson, index);

        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.addOtherCustomInformation(revision, idTarget);
    }

    @And("the Other Customs Information value added in the latest get lo")
    public void theOtherCustomsInformationValueAddedInTheLatestGetLo() throws InterruptedException, IOException {
        Thread.sleep(1000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyOtherCustomsInformationAdded(jsonResponse);
    }

    @Then("success get change request")
    public void successGetChangeRequest() {
        getChangeRequestAPI.successGetChangeRequest();
    }

    @When("user get change request using LO_ID")
    public void userGetChangeRequestUsingLO_ID() throws IOException {
        List<String> ids = List.of(idTarget.split("/"));
        String loId = ids.get(ids.size() - 1);
        response = getChangeRequestAPI.getChangeUsingLoId(loId);
    }

    @And("verify change request same as update dimensions")
    public void verifyChangeRequestSameAsUpdateDimensions() {
        JSONObject jsonObject = new JSONObject(response.asString());
        jsonObject = jsonObject.getJSONArray("data").getJSONObject(jsonObject.getJSONArray("data").length() - 1);
        getChangeRequestAPI.verifyRevision(jsonObject, revision);
        getChangeRequestAPI.verifyIdObjectTarget(jsonObject, idTarget);
        getChangeRequestAPI.verifyIdHeightUnitCode(jsonObject, actualData.get("idHeightUnitCode"));
        getChangeRequestAPI.verifyIdHeightNumericalValue(jsonObject, actualData.get("idHeightNumericalValue"));
        getChangeRequestAPI.verifyIdLengthUnitCode(jsonObject, actualData.get("idLengthUnitCode"));
        getChangeRequestAPI.verifyIdLengthNumericalValue(jsonObject, actualData.get("idLengthNumericalValue"));
        getChangeRequestAPI.verifyIdWidthUnitCode(jsonObject, actualData.get("idWidthUnitCode"));
        getChangeRequestAPI.verifyIdWidthNumericalValue(jsonObject, actualData.get("idWidthNumericalValue"));
    }

    @When("user get change request using change request ID")
    public void userGetChangeRequestUsingChangeRequestID() throws IOException {
        List<String> changeRequests = List.of(updateLoAPI.getChangeRequestId().split("/"));
        idChangeRequest = changeRequests.get(changeRequests.size() - 1);
        response = getChangeRequestAPI.getChangeUsingChangeRequestId(idChangeRequest);
    }

    @And("verify change request using change request ID same as update dimensions")
    public void verifyChangeRequestUsingChangeRequestIDSameAsUpdateDimensions() {
        JSONObject jsonObject = new JSONObject(response.asString());
        jsonObject = jsonObject.getJSONArray("data").getJSONObject(0);
        getChangeRequestAPI.verifyRevision(jsonObject, revision);
        getChangeRequestAPI.verifyIdObjectTarget(jsonObject, idTarget);
        getChangeRequestAPI.verifyIdHeightUnitCode(jsonObject, actualData.get("idHeightUnitCode"));
        getChangeRequestAPI.verifyIdHeightNumericalValue(jsonObject, actualData.get("idHeightNumericalValue"));
        getChangeRequestAPI.verifyIdLengthUnitCode(jsonObject, actualData.get("idLengthUnitCode"));
        getChangeRequestAPI.verifyIdLengthNumericalValue(jsonObject, actualData.get("idLengthNumericalValue"));
        getChangeRequestAPI.verifyIdWidthUnitCode(jsonObject, actualData.get("idWidthUnitCode"));
        getChangeRequestAPI.verifyIdWidthNumericalValue(jsonObject, actualData.get("idWidthNumericalValue"));
    }

    @When("user update SLAC count")
    public void userUpdateSLACCount() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        Object slacForRate = LOResponse.waybillLineItems_slacForRate(responseJson);

        actualData.put("idSlacForRate", LOResponse.waybillLineItems_id(responseJson));
        actualData.put("slacForRate", String.valueOf(slacForRate));
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateSlacForRate(revision, idTarget, actualData);
    }

    @And("the SLAC count value changes in the latest get lo")
    public void theSLACCountValueChangesInTheLatestGetLo() throws InterruptedException, IOException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifySlacForRateUpdated(jsonResponse);
    }

    @When("user update gross weight for rate in house LO")
    public void userUpdateGrossWeightForRateInHouseLO() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.shipment_id(responseJson);
        float numericalValue = LOResponse.WLI_grossWeightForRate_numericalValue(responseJson);
        String idNumericalValue = LOResponse.WLI_grossWeightForRate_id(responseJson);
        String unitCode = LOResponse.WLI_GWFR_unit_code(responseJson);
        String idUnitCode = LOResponse.WLI_GWFR_unit_id(responseJson);

        actualData.put("idNumericalValue", idNumericalValue);
        actualData.put("idUnitCode", idUnitCode);
        actualData.put("unitCode", unitCode);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateGrossWeightForRate(revision, idTarget, actualData, numericalValue);
    }

    @When("user delete SLAC count")
    public void userDeleteSLACCount() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        Object slacForRate = LOResponse.waybillLineItems_slacForRate(responseJson);

        actualData.put("idSlacForRate", LOResponse.waybillLineItems_id(responseJson));
        actualData.put("slacForRate", String.valueOf(slacForRate));
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.deleteSlacForRate(revision, idTarget, actualData);
    }

    @And("the SLAC count value deleted in the latest get lo")
    public void theSLACCountValueDeletedInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifySlacForRateDeleted(jsonResponse);
    }

    @When("user add SLAC count")
    public void userAddSLACCount() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);

        actualData.put("idWaybillLine", LOResponse.waybillLineItems_id(responseJson));

        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.addSlacForRate(revision, idTarget, actualData);
    }

    @And("the SLAC count value added in the latest get lo")
    public void theSLACCountValueAddedInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifySlacForRateAdded(jsonResponse);
    }

    @When("user delete shipper name, address")
    public void userDeleteShipperNameAddress() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.shipment_id(responseJson);
        String idPartyDetails = LOResponse.s_IP_partyDetails_id(responseJson, "SHP");
        String partyDetailsName = LOResponse.s_IP_partyDetails_name(responseJson, "SHP");
        String idStreetAddressLine = LOResponse.s_IP_PD_BAT_address_id(responseJson, "SHP");
        String streetAddressLine = LOResponse.s_IP_PD_BAT_address_streetAddressLines(responseJson, "SHP");

        actualData.put("idPartyDetails", idPartyDetails);
        actualData.put("partyDetailsName", partyDetailsName);
        actualData.put("idStreetAddressLine", idStreetAddressLine);
        actualData.put("streetAddressLine", streetAddressLine);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.deleteShipperNameAddress(revision, idTarget, actualData);
    }

    @And("the shipper name, address value deleted in the latest get lo")
    public void theShipperNameAddressValueDeletedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyPartyNameDeleted(jsonResponse, "SHP");
        updateLoAPI.verifyPartyStreetDeleted(jsonResponse, "SHP");
    }

    @When("user add shipper name, address")
    public void userAddShipperNameAddress() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.shipment_id(responseJson);
        String idPartyDetails = LOResponse.s_IP_partyDetails_id(responseJson, "SHP");
        String idStreetAddressLine = LOResponse.s_IP_PD_BAT_address_id(responseJson, "SHP");

        actualData.put("idPartyDetails", idPartyDetails);
        actualData.put("idStreetAddressLine", idStreetAddressLine);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.addShipperNameAddress(revision, idTarget, actualData);
    }

    @And("the shipper name, address value added in the latest get lo")
    public void theShipperNameAddressValueAddedInTheLatestGetLo() throws InterruptedException, IOException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyPartyNameAdded(jsonResponse, "SHP");
        updateLoAPI.verifyPartyAddressAdded(jsonResponse, "SHP");
    }

    @When("user delete consignee name, address")
    public void userDeleteConsigneeNameAddress() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.shipment_id(responseJson);
        String idPartyDetails = LOResponse.s_IP_partyDetails_id(responseJson, "CNE");
        String partyDetailsName = LOResponse.s_IP_partyDetails_name(responseJson, "CNE");
        String idStreetAddressLine = LOResponse.s_IP_PD_BAT_address_id(responseJson, "CNE");
        String streetAddressLine = LOResponse.s_IP_PD_BAT_address_streetAddressLines(responseJson, "CNE");

        actualData.put("idPartyDetails", idPartyDetails);
        actualData.put("partyDetailsName", partyDetailsName);
        actualData.put("idStreetAddressLine", idStreetAddressLine);
        actualData.put("streetAddressLine", streetAddressLine);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.deleteConsigneeNameAddress(revision, idTarget, actualData);
    }

    @And("the consignee name, address value deleted in the latest get lo")
    public void theConsigneeNameAddressValueDeletedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyPartyNameDeleted(jsonResponse, "CNE");
        updateLoAPI.verifyPartyStreetDeleted(jsonResponse, "CNE");
    }

    @When("user add consignee name, address")
    public void userAddConsigneeNameAddress() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.shipment_id(responseJson);
        String idPartyDetails = LOResponse.s_IP_partyDetails_id(responseJson, "CNE");
        String idStreetAddressLine = LOResponse.s_IP_PD_BAT_address_id(responseJson, "CNE");

        actualData.put("idPartyDetails", idPartyDetails);
        actualData.put("idStreetAddressLine", idStreetAddressLine);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.addConsigneeNameAddress(revision, idTarget, actualData);
    }

    @And("the consignee name, address value added in the latest get lo")
    public void theConsigneeNameAddressValueAddedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestLoIdResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyPartyNameAdded(jsonResponse, "CNE");
        updateLoAPI.verifyPartyAddressAdded(jsonResponse, "CNE");
    }

    @And("user success create LO with new master and house waybill number")
    public void userSuccessCreateLOWithNewMasterAndHouseWaybillNumber() throws IOException {
        JSONObject customPayload = createLoAPI.payload();
        //change house waybill number to random
        customPayload = createLoAPI.modifyPayload(customPayload, "houseWaybillNumber", "");
        //change house waybill number to random
        customPayload = createLoAPI.modifyPayload(customPayload, "masterWaybillNumber", "");
        masterWaybill = XFWBResponse.Master_WaybillNumber(customPayload);
        houseWaybill = XFWBResponse.waybillNumber(customPayload);
        houseId = createLoAPI.createLoRequestCustom(customPayload);
    }

    @And("the waybill type is {string}")
    public void theWaybillTypeIs(String waybillType) {
        getLoAPI.verifyWaybillType(responseJson, waybillType);
    }

    @When("get logistic objects using masterWaybillNumber")
    public void getLogisticObjectsUsingMasterWaybillNumber() throws IOException {
        JSONObject resp = new JSONObject(response);
        String masterPrefix = updateLoAPI.getMasterPrefix(resp);
        String masterNumber = updateLoAPI.getMasterWaybillNumber(resp);
        getLoAPI.getLORequestLoWaybillPrefix(masterPrefix, masterNumber);
    }

    @And("user success get LO for verifying")
    public void userSuccessGetLOForVerifying() throws IOException {
        responseJson = getLoAPI.getLORequest(houseId);
    }

    @When("get logistic objects using {string} LO_ID")
    public void getLogisticObjectsUsingLO_ID(String type) throws IOException {
        if (!type.equals("master")) id = houseId;
        responseJson = new JSONObject(getLoAPI.getLORequestLoId(id));
    }

    @When("user success create LO with new waybill number and {string} waybillType")
    public void userSuccessCreateLOWithNewWaybillNumberAndWaybillType(String waybillType) throws IOException {
        JSONObject customPayload = createLoAPI.payload();
        customPayload = createLoAPI.modifyPayload(customPayload, "waybillNumber", "");
        createLoAPI.modifyPayload(customPayload, "waybillType", waybillType);
        masterWaybill = XFWBResponse.waybillNumber(customPayload);
        id = createLoAPI.createLoRequestCustom(customPayload);
    }

    @And("the master waybill is same as the master in house waybill")
    public void theMasterWaybillIsSameAsTheMasterInHouseWaybill() {
        getLoAPI.verifyWaybillNumberContainsRequest(responseJson, masterWaybill);
    }

    @And("piece of house will be distributed from master pieces")
    public void pieceOfHouseWillBeDistributedFromMasterPieces() throws IOException {
        responseJson = getLoAPI.getLORequest(houseId);
        getLoAPI.verifyPiecesDistributedInHouse(responseJson);
    }

    @And("user create LO again with same house waybill in different master waybill")
    public void userCreateLOAgainWithSameHouseWaybillInDifferentMasterWaybill() throws IOException {
        JSONObject customPayload = createLoAPI.payload();
        customPayload = createLoAPI.modifyPayload(customPayload, "houseWaybillNumber", houseWaybill);
        customPayload = createLoAPI.modifyPayload(customPayload, "masterWaybillNumber", "");
        houseWaybill = XFWBResponse.waybillNumber(customPayload);
        houseId = createLoAPI.createLoRequestCustom(customPayload);
    }

    @And("user able to get the {string} house waybill")
    public void userAbleToGetTheHouseWaybill(String number) throws IOException {
        if (number.equals("second")){
            responseJson = getLoAPI.getLORequest(houseId);
            getLoAPI.verifySuccessGetLO();
            loId.add(XFWBResponse.id(responseJson));
        } else if (number.equals("first")){
            responseJson = new JSONObject(getLoAPI.getLORequestLoMasterHouse(masterWaybill, houseWaybill));
            getLoAPI.verifySuccessGetLO();
            loId.add(XFWBResponse.id(responseJson));
        }
    }

    @And("verify both of LO will have different ID")
    public void verifyBothOfLOWillHaveDifferentID() {
        Assert.assertNotSame(loId.get(0), loId.get(1));
    }

    @And("user create new house LO in same master waybill")
    public void userCreateNewHouseLOInSameMasterWaybill() throws IOException, InterruptedException {
        Thread.sleep(5000);
        JSONObject customPayload = createLoAPI.payload();
        customPayload = createLoAPI.modifyPayload(customPayload, "houseWaybillNumber", "");
        customPayload = createLoAPI.modifyPayload(customPayload, "masterWaybillNumber", masterWaybill);
        houseWaybill = XFWBResponse.waybillNumber(customPayload);
        houseId = createLoAPI.createLoRequestCustom(customPayload);
    }

    @And("user success get LO with string response")
    public void userSuccessGetLOWithStringResponse() throws IOException {
        response = getLoAPI.getLORequestLoIdResponse(id);
    }

    @And("user success create LO with new house waybill number and same mater")
    public void userSuccessCreateLOWithNewHouseWaybillNumberAndSameMater() throws IOException {
        JSONObject customPayload = createLoAPI.payload();
        //change house waybill number to random
        customPayload = createLoAPI.modifyPayload(customPayload, "houseWaybillNumber", "");
        //change house waybill number to random
        customPayload = createLoAPI.modifyPayload(customPayload, "masterWaybillNumber", masterWaybill);
        masterWaybill = XFWBResponse.Master_WaybillNumber(customPayload);
        houseWaybill = XFWBResponse.waybillNumber(customPayload);
        houseId = createLoAPI.createLoRequestCustom(customPayload);
    }

    @And("user create verification request for that LO")
    public void userCreateVerificationRequestForThatLO() throws IOException {
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(id);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.createVerificationRequest(revision, id);
        idChangeRequest = updateLoAPI.getChangeRequestId();
    }

    @Then("success create verification request")
    public void successCreateVerificationRequest() {
        updateLoAPI.verifySuccessCreateVerReq();
    }

    @And("user able to get action request details")
    public void userAbleToGetActionRequestDetails() throws IOException {
        List<String> changeRequests = List.of(updateLoAPI.getChangeRequestId().split("/"));
        idChangeRequest = changeRequests.get(changeRequests.size() - 1);
        response = getChangeRequestAPI.getVerUsingVerificationReqId(idChangeRequest);
    }

    @And("verification request will have {string} status")
    public void verificationRequestWillHaveStatus(String status) {
        JSONObject jsonObject = new JSONObject(response.asString());
        jsonObject = jsonObject.getJSONArray("data").getJSONObject(0);
        getChangeRequestAPI.verifyRevisionInVerification(jsonObject, revision);
        getChangeRequestAPI.verifyIdLoOfVerification(jsonObject, id);
        getChangeRequestAPI.verifyStatus(jsonObject, status);
    }

    @When("user update gross weight for rate with verification request id")
    public void userUpdateGrossWeightForRateWithVerificationRequestId() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.id(responseJson);
        float numericalValue = LOResponse.WLI_grossWeightForRate_numericalValue(responseJson);
        String idNumericalValue = LOResponse.WLI_grossWeightForRate_id(responseJson);
        String unitCode = LOResponse.WLI_GWFR_unit_code(responseJson);
        String idUnitCode = LOResponse.WLI_GWFR_unit_id(responseJson);

        actualData.put("idNumericalValue", idNumericalValue);
        actualData.put("idUnitCode", idUnitCode);
        actualData.put("unitCode", unitCode);
        actualData.put("verificationId", idChangeRequest);
        //get the id
        response = getLoAPI.getLORequestLoIdResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateGrossWeightForRate(revision, idTarget, actualData, numericalValue);
        idChangeRequest = updateLoAPI.getChangeRequestId();
    }

    @And("verification request data will appears when user get change request")
    public void verificationRequestDataWillAppearsWhenUserGetChangeRequest() throws IOException {
        List<String> changeRequests = List.of(idChangeRequest.split("/"));
        idChangeRequest = changeRequests.get(changeRequests.size() - 1);
        response = getChangeRequestAPI.getChangeUsingChangeRequestId(idChangeRequest);
        // TODO
//        getChangeRequestAPI.verifyStatus(response);
    }
}
