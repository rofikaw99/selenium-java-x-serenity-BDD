package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;
import starter.api.CreateLoAPI;
import starter.api.GetLoAPI;
import starter.api.UpdateLoAPI;
import starter.utlis.LOResponse;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class UpdateLOStep {

    @Steps
    CreateLoAPI createLoAPI;

    @Steps
    UpdateLoAPI updateLoAPI;

    @Steps
    GetLoAPI getLoAPI;

    String id, idTarget = "";
    Response response;
    Integer revision;

    @Given("user success create LO")
    public void userSuccessCreateLO() throws IOException {
        id = createLoAPI.createLORequest();
    }

    @And("user success get LO")
    public void userSuccessGetLO() throws IOException {
        response = getLoAPI.getLORequestFullResponse(id);
    }

    @When("user update piece of count")
    public void userUpdatePieceOfCount() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.waybillLineItems_id(responseJson);
        Integer pieceCountValue = LOResponse.waybillLineItems_pieceCountForRate(responseJson);

        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updatePieceCountForRate(revision, idTarget, String.valueOf(pieceCountValue));
    }

    @When("user remove piece of count")
    public void userRemovePieceOfCount() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.waybillLineItems_id(responseJson);
        Integer pieceCount = LOResponse.waybillLineItems_pieceCountForRate(responseJson);

        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.removePieceCountForRate(revision, idTarget, String.valueOf(pieceCount));
    }

    @When("user add piece of count")
    public void userAddPieceOfCount() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.waybillLineItems_id(responseJson);

        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.addPieceCountForRate(revision, idTarget);
    }

    @And("the piece of count deleted in the latest get lo")
    public void thePieceOfCountDeletedInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestFullResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyPieceOfCountDeleted(jsonResponse);
    }

    @And("the piece of count added in the latest get lo")
    public void thePieceOfCountAddedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(2000);
        response = getLoAPI.getLORequestFullResponse(id);
        updateLoAPI.verifyPieceOfCountUpdated(new JSONObject(response.asString()), 0);
    }

    @And("the piece of count value changes in the latest get lo")
    public void thePieceOfCountValueChangesInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestFullResponse(id);
        updateLoAPI.verifyPieceOfCountUpdated(new JSONObject(response.asString()), 1);
    }

    @And("the revision value changes to increment {int}")
    public void theRevisionValueChangesToIncrement(int arg0) throws IOException {
        response = getLoAPI.getLORequestFullResponse(idTarget);
        updateLoAPI.verifyRevisionIncreased(response, revision);
    }

    @When("user update gross weight for rate")
    public void userUpdateGrossWeightForRate() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.waybillLineItems_id(responseJson);
        float numericalValue = LOResponse.WLI_grossWeightForRate_numericalValue(responseJson);
        String idNumericalValue = LOResponse.WLI_grossWeightForRate_id(responseJson);
        String unitCode = LOResponse.WLI_GWFR_unit_code(responseJson);
        String idUnitCode = LOResponse.WLI_GWFR_unit_id(responseJson);

        Map<String, String> actualData = new HashMap<>();
        actualData.put("idNumericalValue", idNumericalValue);
        actualData.put("numericalValue", String.valueOf(numericalValue));
        actualData.put("idUnitCode", idUnitCode);
        actualData.put("unitCode", unitCode);
        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateGrossWeightForRate(revision, idTarget, actualData);
    }

    @And("the gross weight for rate value changes in the latest get lo")
    public void theGrossWeightForRateValueChangesInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestFullResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyGrossWeightForRateUnitCodeUpdated(jsonResponse);
        updateLoAPI.verifyGrossWeightForRateNumericalValueUpdated(jsonResponse);
    }

    @When("user update chargeable weight")
    public void userUpdateChargeableWeight() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.waybillLineItems_id(responseJson);
        float numericalValue = LOResponse.WLI_chargeableWeightForRate_numericalValue(responseJson);
        String idNumericalValue = LOResponse.WLI_chargeableWeightForRate_id(responseJson);
        String unitCode = LOResponse.WLI_CWFR_unit_code(responseJson);
        String idUnitCode = LOResponse.WLI_CWFR_unit_id(responseJson);

        Map<String, String> actualData = new HashMap<>();
        actualData.put("idNumericalValue", idNumericalValue);
        actualData.put("numericalValue", String.valueOf(numericalValue));
        actualData.put("idUnitCode", idUnitCode);
        actualData.put("unitCode", unitCode);
        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateChargeableWeightForRate(revision, idTarget, actualData);
    }

    @Then("success update {string}")
    public void successUpdate(String arg0) {
        updateLoAPI.verifySuccessUpdateLO();
    }

    @And("the chargeable weight value changes in the latest get lo")
    public void theChargeableWeightValueChangesInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestFullResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyChargeableWeightForRateUnitCodeUpdated(jsonResponse);
        updateLoAPI.verifyChargeableWeightForRateNumericalValueUpdated(jsonResponse);
    }

    @When("user update volume")
    public void userUpdateVolume() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.waybillLineItems_id(responseJson);
        float numericalValue = LOResponse.WLI_DFR_volume_numericalValue(responseJson);
        String idNumericalValue = LOResponse.WLI_DFR_volume_id(responseJson);
        String unitCode = LOResponse.WLI_DFR_volume_unit_code(responseJson);
        String idUnitCode = LOResponse.WLI_DFR_volume_unit_id(responseJson);

        Map<String, String> actualData = new HashMap<>();
        actualData.put("idNumericalValue", idNumericalValue);
        actualData.put("numericalValue", String.valueOf(numericalValue));
        actualData.put("idUnitCode", idUnitCode);
        actualData.put("unitCode", unitCode);
        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateVolume(revision, idTarget, actualData);
    }

    @And("the volume value changes in the latest get lo")
    public void theVolumeValueChangesInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestFullResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyVolumeUnitCodeUpdated(jsonResponse);
        updateLoAPI.verifyVolumeNumericalValueUpdated(jsonResponse);
    }

    @When("user update dimensions")
    public void userUpdateDimensions() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.waybillLineItems_id(responseJson);
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

        Map<String, String> actualData = new HashMap<>();
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
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateDimensions(revision, idTarget, actualData);
    }

    @And("the dimensions value changes in the latest get lo")
    public void theDimensionsValueChangesInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestFullResponse(id);
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
        idTarget = LOResponse.waybillLineItems_id(responseJson);
        String shipmentDescription = LOResponse.waybillLineItems_goodsDescriptionForRate(responseJson);

        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateShipmentDescription(revision, idTarget, shipmentDescription);
    }

    @And("the Shipment description value changes in the latest get lo")
    public void theShipmentDescriptionValueChangesInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestFullResponse(id);
        updateLoAPI.verifyShipmentDescriptionUpdated(new JSONObject(response.asString()));
    }

    @When("user delete dimensions")
    public void userDeleteDimensions() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.waybillLineItems_id(responseJson);
        String idDimensions = LOResponse.WLI_dimensionsForRate_id(responseJson);
        String idHeight = LOResponse.WLI_DFR_height_id(responseJson);
        String idLength = LOResponse.WLI_DFR_length_id(responseJson);
        String idWidth = LOResponse.WLI_DFR_width_id(responseJson);

        Map<String, String> actualData = new HashMap<>();
        actualData.put("idDimensions", idDimensions);
        actualData.put("idHeight", idHeight);
        actualData.put("idLength", idLength);
        actualData.put("idWidth", idWidth);
        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.deleteDimensions(revision, idTarget, actualData);
    }

    @And("the dimensions value deleted in the latest get lo")
    public void theDimensionsValueDeletedInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestFullResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyHeightDeleted(jsonResponse);
        updateLoAPI.verifyLengthDeleted(jsonResponse);
        updateLoAPI.verifyWidthDeleted(jsonResponse);
    }

    @When("user update Commodity \\(price) code")
    public void userUpdateCommodityPriceCode() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.waybillLineItems_id(responseJson);
        String hsCodeForRate = LOResponse.waybillLineItems_hsCodeForRate_code(responseJson);
        String hsCodeForRateId = LOResponse.waybillLineItems_hsCodeForRate_id(responseJson);

        Map<String, String> actualData = new HashMap<>();
        actualData.put("idHsCodeForRate", hsCodeForRateId);
        actualData.put("hsCodeForRate", hsCodeForRate);
        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateCommodityCode(revision, idTarget, actualData);
    }

    @And("the commodity \\(price) code value changes in the latest get lo")
    public void theCommodityPriceCodeValueChangesInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestFullResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyHsCodeForRateUpdated(jsonResponse);
    }

    @When("user update special handling code")
    public void userUpdateSpecialHandlingCode() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.shipment_id(responseJson);
        String idSpecialHandlingCode = LOResponse.shipment_specialHandlingCodes_id(responseJson, 0);
        String codeSpecialHandlingCode = LOResponse.shipment_specialHandlingCodes_code(responseJson, 0);

        Map<String, String> actualData = new HashMap<>();
        actualData.put("idSpecialHandlingCode", idSpecialHandlingCode);
        actualData.put("codeSpecialHandlingCode", codeSpecialHandlingCode);
        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateSpecialHandlingCode(revision, idTarget, actualData);
    }

    @And("the special handling code value changes in the latest get lo")
    public void theSpecialHandlingCodeValueChangesInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestFullResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifySpecialHandlingCodeUpdated(jsonResponse);
    }

    @When("user update shipper name, address")
    public void userUpdateShipperNameAddress() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.shipment_id(responseJson);
        String idPartyDetails = LOResponse.IP_partyDetails_id(responseJson, "SHP");
        String partyDetailsName = LOResponse.IP_partyDetails_name(responseJson, "SHP");
        String idStreetAddressLine = LOResponse.IP_PD_BAT_address_id(responseJson, "SHP");
        String streetAddressLine = LOResponse.IP_PD_BAT_address_streetAddressLines(responseJson, "SHP");

        Map<String, String> actualData = new HashMap<>();
        actualData.put("idPartyDetails", idPartyDetails);
        actualData.put("partyDetailsName", partyDetailsName);
        actualData.put("idStreetAddressLine", idStreetAddressLine);
        actualData.put("streetAddressLine", streetAddressLine);
        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateShipperNameAddress(revision, idTarget, actualData);
    }

    @And("the shipper name, address value changes in the latest get lo")
    public void theShipperNameAddressValueChangesInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestFullResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyPartyName(jsonResponse, "SHP");
        updateLoAPI.verifyPartyStressAddress(jsonResponse, "SHP");
    }

    @When("user update consignee name, address")
    public void userUpdateConsigneeNameAddress() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.shipment_id(responseJson);
        String idPartyDetails = LOResponse.IP_partyDetails_id(responseJson, "CNE");
        String partyDetailsName = LOResponse.IP_partyDetails_name(responseJson, "CNE");
        String idStreetAddressLine = LOResponse.IP_PD_BAT_address_id(responseJson, "CNE");
        String streetAddressLine = LOResponse.IP_PD_BAT_address_streetAddressLines(responseJson, "CNE");

        Map<String, String> actualData = new HashMap<>();
        actualData.put("idPartyDetails", idPartyDetails);
        actualData.put("partyDetailsName", partyDetailsName);
        actualData.put("idStreetAddressLine", idStreetAddressLine);
        actualData.put("streetAddressLine", streetAddressLine);
        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateConsigneeNameAddress(revision, idTarget, actualData);
    }

    @And("the consignee name, address value changes in the latest get lo")
    public void theConsigneeNameAddressValueChangesInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestFullResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyPartyName(jsonResponse, "CNE");
        updateLoAPI.verifyPartyStressAddress(jsonResponse, "CNE");
    }

    @When("user update OCDC charges, MYC, SCC, RAC, etc")
    public void userUpdateOCDCChargesMYCSCCRACEtc() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.otherCharges_id(responseJson);
        String idOtherChargeCode = LOResponse.otherCharges_otherChargeCode_id(responseJson);
        String otherChargeCode = LOResponse.otherCharges_otherChargeCode_code(responseJson);

        Map<String, String> actualData = new HashMap<>();
        actualData.put("idOtherChargeCode", idOtherChargeCode);
        actualData.put("otherChargeCode", otherChargeCode);
        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.updateOtherChargeCode(revision, idTarget, actualData);
    }

    @And("the OCDC charges, MYC, SCC, RAC, etc value changes in the latest get lo")
    public void theOCDCChargesMYCSCCRACEtcValueChangesInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestFullResponse(id);
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
        idTarget = LOResponse.waybillLineItems_id(responseJson);
        String idWaybillLine = LOResponse.waybillLineItems_id(responseJson);
        String idGrossWeightForRate = LOResponse.WLI_grossWeightForRate_id(responseJson);

        Map<String, String> actualData = new HashMap<>();
        actualData.put("idWaybillLine", idWaybillLine);
        actualData.put("idGrossWeightForRate", idGrossWeightForRate);

        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.removeGrossWeightForRate(revision, idTarget, actualData);
    }

    @And("the gross weight for rate deleted in the latest get lo")
    public void theGrossWeightForRateDeletedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(1000);
        response = getLoAPI.getLORequestFullResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyGrossWeightForRateDeleted(jsonResponse);
    }

    @When("user add gross weight for rate")
    public void userAddGrossWeightForRate() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.waybillLineItems_id(responseJson);
        String idWaybillLine = LOResponse.waybillLineItems_id(responseJson);

        Map<String, String> actualData = new HashMap<>();
        actualData.put("idWaybillLine", idWaybillLine);

        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.addGrossWeightForRate(revision, idTarget, actualData);
    }

    @And("the gross weight for rate added in the latest get lo")
    public void theGrossWeightForRateAddedInTheLatestGetLo() throws InterruptedException, IOException {
        Thread.sleep(1000);
        response = getLoAPI.getLORequestFullResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyGrossWeightForRateUnitAdded(jsonResponse);
        updateLoAPI.verifyGrossWeightForRateValueAdded(jsonResponse);
    }

    @When("user delete volume")
    public void userDeleteVolume() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.waybillLineItems_id(responseJson);
        String idDimensionsForRate = LOResponse.WLI_dimensionsForRate_id(responseJson);
        String idVolume = LOResponse.WLI_DFR_volume_id(responseJson);

        Map<String, String> actualData = new HashMap<>();
        actualData.put("idDimensionsForRate", idDimensionsForRate);
        actualData.put("idVolume", idVolume);
        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.deleteVolume(revision, idTarget, actualData);
    }

    @And("the volume value deleted in the latest get lo")
    public void theVolumeValueDeletedInTheLatestGetLo() throws IOException, InterruptedException {
        Thread.sleep(1000);
        response = getLoAPI.getLORequestFullResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyVolumeDeleted(jsonResponse);
    }

    @When("user add volume")
    public void userAddVolume() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.waybillLineItems_id(responseJson);
        String idDimensionsForRate = LOResponse.WLI_dimensionsForRate_id(responseJson);

        Map<String, String> actualData = new HashMap<>();
        actualData.put("idDimensionsForRate", idDimensionsForRate);

        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.addVolume(revision, idTarget, actualData);
    }

    @And("the volume value added in the latest get lo")
    public void theVolumeValueAddedInTheLatestGetLo() throws InterruptedException, IOException {
        Thread.sleep(1000);
        response = getLoAPI.getLORequestFullResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyVolumeValueAdded(jsonResponse);
        updateLoAPI.verifyVolumeUnitAdded(jsonResponse);
    }

    @When("user add dimensions")
    public void userAddDimensions() throws IOException {
        JSONObject responseJson = new JSONObject(response.asString());
        idTarget = LOResponse.waybillLineItems_id(responseJson);
        String idDimensionsForRate = LOResponse.WLI_dimensionsForRate_id(responseJson);

        Map<String, String> actualData = new HashMap<>();
        actualData.put("idDimensionsForRate", idDimensionsForRate);

        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.addDimensions(revision, idTarget, actualData);
    }

    @And("the dimensions value added in the latest get lo")
    public void theDimensionsValueAddedInTheLatestGetLo() throws InterruptedException, IOException {
        Thread.sleep(1000);
        response = getLoAPI.getLORequestFullResponse(id);
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
        idTarget = LOResponse.waybillLineItems_id(responseJson);
        String shipmentDescription = LOResponse.waybillLineItems_goodsDescriptionForRate(responseJson);

        //get the id
        response = getLoAPI.getLORequestFullResponse(idTarget);
        revision = updateLoAPI.getRevision(response);
        updateLoAPI.deleteShipmentDescription(revision, idTarget, shipmentDescription);
    }

    @And("the Shipment description value deleted in the latest get lo")
    public void theShipmentDescriptionValueDeletedInTheLatestGetLo() throws IOException {
        response = getLoAPI.getLORequestFullResponse(id);
        JSONObject jsonResponse = new JSONObject(response.asString());
        updateLoAPI.verifyShipmentDescriptionDeleted(jsonResponse);
    }
}
