package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.SkipStepException;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;
import org.json.XML;
import starter.api.TransformXfwbAPI;
import starter.utlis.XFWBXml;

import java.io.IOException;

public class TransformXfwb {

    @Steps
    TransformXfwbAPI transformXfwbPage;
    String response;
    JSONObject jsonXml;

    @Given("user transform xfwb")
    public void userTransformXfwb() throws IOException {
        response = transformXfwbPage.transformXfwb();
        jsonXml = XML.toJSONObject(XFWBXml.xmlPayload);
    }

    @Then("verify mapping data of {string} {string} {string} to data in response of Waybill {string}")
    public void verifyMappingDataOfToDataInResponseOfWaybill(String value, String child, String child2, String mapping) {
        JSONObject jsonObject = new JSONObject(response);
        switch (mapping) {
            case "waybillPrefix":
                transformXfwbPage.verifyWaybillPrefix(jsonXml, jsonObject);
                break;
            case "waybillNumber":
                transformXfwbPage.verifyWaybillNumber(jsonXml, jsonObject);
                break;
            case "waybillType":
                transformXfwbPage.verifyWaybillType(jsonXml, jsonObject);
                break;
            case "consignorDeclarationSignature":
                transformXfwbPage.verifyConsignorDeclarationSignature(jsonXml, jsonObject);
                break;
            case "carrierDeclarationDate":
                transformXfwbPage.verifyCarrierDeclarationDate(jsonXml, jsonObject);
                break;
            case "carrierDeclarationSignature":
                transformXfwbPage.verifyCarrierDeclarationSignature(jsonXml, jsonObject);
                break;
            case "carrierDeclarationPlace":
                transformXfwbPage.verifyCarrierDeclarationPlace(jsonXml, jsonObject);
                break;
        }
    }

    @Then("verify mapping data of {string} to data in response of Waybill {string}")
    public void verifyMappingDataOfToDataInResponseOfWaybill(String value, String mapping) {
            JSONObject jsonObject = new JSONObject(response);
            switch (mapping) {
                case "weightValuationIndicator":
                    transformXfwbPage.verifyWeightValuationIndicator(jsonXml, jsonObject);
                    break;
                case "otherChargesIndicator":
                    transformXfwbPage.verifyOtherChargesIndicator(jsonXml, jsonObject);
                    break;
                case "totalGrossWeight":
                    // verify numericalValue
                    transformXfwbPage.verifyTotalGrossWeight(jsonXml, jsonObject);
                    // verify unit
                    transformXfwbPage.verifyUnitTotalGrossWeight(jsonXml, jsonObject);
                    break;
                case "dimensionsForRate":
                    // verify numericalValue
                    transformXfwbPage.verifyDimensionsForRate(jsonXml, jsonObject);
                    // verify unit
                    transformXfwbPage.verifyUnitDimensionsForRate(jsonXml, jsonObject);
                    break;
                case "pieceCountForRate":
                    transformXfwbPage.verifyPieceCountForRate(jsonXml, jsonObject);
                    break;
            }
    }

    @Then("verify mapping data {string} {string} of ConsignorParty to data in response of Waybill {string}")
    public void verifyMappingDataOfConsignorPartyToDataInResponseOfWaybill(String value, String child, String mapping) {
        JSONObject jsonObject = new JSONObject(response);
        String party = "Consignor";
        switch (mapping) {
            case "name":
                transformXfwbPage.verifyNameConsignorParty(jsonXml, jsonObject, party);
                break;
            case "postalCode":
                transformXfwbPage.verifyConsignorPostalCode(jsonXml, jsonObject, party);
                break;
            case "streetAddressLines":
                transformXfwbPage.verifyConsignorStreetAddressLines(jsonXml, jsonObject, party);
                break;
            case "country":
                transformXfwbPage.verifyConsignorCountryCode(jsonXml, jsonObject, party);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} {string} of ConsigneeParty to data in response of Waybill {string}")
    public void verifyMappingDataOfConsigneePartyToDataInResponseOfWaybill(String value, String child, String mapping) {
        JSONObject jsonObject = new JSONObject(response);
        String party = "Consignee";
        switch (mapping) {
            case "name":
                transformXfwbPage.verifyNameConsigneeParty(jsonXml, jsonObject, party);
                break;
            case "postalCode":
                transformXfwbPage.verifyConsigneePostalCode(jsonXml, jsonObject, party);
                break;
            case "streetAddressLines":
                transformXfwbPage.verifyConsigneeStreetAddressLines(jsonXml, jsonObject, party);
                break;
            case "country":
                transformXfwbPage.verifyConsigneeCountryCode(jsonXml, jsonObject, party);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} {string} of FreightForwarderParty to data in response of Waybill {string}")
    public void verifyMappingDataOfFreightForwarderPartyToDataInResponseOfWaybill(String arg0, String arg1, String mapping) {
        JSONObject jsonObject = new JSONObject(response);
        String party = "Agent";
        switch (mapping) {
            case "name":
                transformXfwbPage.verifyNameFreightForwarderParty(jsonXml, jsonObject, party);
                break;
            case "iataCargoAgentLocationIdentifier":
                transformXfwbPage.verifyFreightForwarderSpecifiedCargoAgentLocationId(jsonXml, jsonObject, party);
                break;
            case "iataCargoAgentCode":
                transformXfwbPage.verifyFreightForwarderCargoAgentId(jsonXml, jsonObject, party);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} of OriginLocation to data in response of Waybill {string}")
    public void verifyMappingDataOfOriginLocationToDataInResponseOfWaybill(String arg0, String mapping) {
        JSONObject jsonObject = new JSONObject(response);
        switch (mapping) {
            case "code":
                transformXfwbPage.verifyOriginLocationId(jsonXml, jsonObject);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} of FinalDestinationLocation to data in response of Waybill {string}")
    public void verifyMappingDataOfFinalDestinationLocationToDataInResponseOfWaybill(String arg0, String mapping) {
        JSONObject jsonObject = new JSONObject(response);
        switch (mapping) {
            case "code":
                transformXfwbPage.verifyFinalDestinationLocationId(jsonXml, jsonObject);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }
    @Then("verify mapping data {string} {string} {string} of SpecifiedLogisticsTransportMovement to data in response of Waybill {string}")
    public void verifyMappingDataOfSpecifiedLogisticsTransportMovementToDataInResponseOfWaybill(String keyRequest, String arg1, String arg2, String keyResponse) {
        JSONObject jsonObject = new JSONObject(response);
        if (keyRequest.equals("ArrivalEvent")){
            switch (keyResponse) {
                case "movementTimestamp":
                    transformXfwbPage.verifyScheduledOccurrenceDateTime(jsonXml, jsonObject);
                    break;
                case "code":
                    transformXfwbPage.verifyOccurrenceArrivalLocationID(jsonXml,jsonObject);
                    break;
                case "locationName":
                    transformXfwbPage.verifyOccurrenceArrivalLocationName(jsonXml,jsonObject);
                    break;
                default:
                    throw new SkipStepException("there is no key");
            }
        } else if (keyRequest.equals("DepartureEvent")){
            throw new SkipStepException("there is no key");
        } else {
            switch (keyResponse) {
                case "transportIdentifier":
                    transformXfwbPage.verifySpecifiedLogisticsTransportMovementID(jsonXml,jsonObject);
                    break;
                case "airlineCode":
                    transformXfwbPage.verifyUsedLogisticsTransportMeans(jsonXml,jsonObject);
                    break;
                default:
                    throw new SkipStepException("there is no key");
            }
        }
    }
    @Then("verify mapping data {string} of HandlingSPHInstructions to data in response of Waybill {string}")
    public void verifyMappingDataOfHandlingSPHInstructionsToDataInResponseOfWaybill(String arg0, String mapping) {
        JSONObject jsonObject = new JSONObject(response);
        switch (mapping) {
            case "specialHandlingCodes":
                transformXfwbPage.verifySpecialHandlingCodes(jsonXml, jsonObject);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }
    @Then("verify mapping data {string} of HandlingSSRInstructions to data in response of Waybill {string}")
    public void verifyMappingDataOfHandlingSSRInstructionsToDataInResponseOfWaybill(String arg0, String mapping) {
        JSONObject jsonObject = new JSONObject(response);
        switch (mapping) {
            case "textualHandlingInstructions":
                transformXfwbPage.verifyTextualHandlingInstructionsDescription(jsonXml, "SSR", jsonObject);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }
    @Then("verify mapping data {string} of IncludedAccountingNote to data in response of Waybill {string}")
    public void verifyMappingDataOfIncludedAccountingNoteToDataInResponseOfWaybill(String arg0, String mapping) {
        transformXfwbPage.verifyAccountingInformationMapping(mapping);
    }

    @Then("verify mapping data {string} of IncludedCustomsNote to data in response of Waybill {string}")
    public void verifyMappingDataOfIncludedCustomsNoteToDataInResponseOfWaybill(String arg0, String mapping) {
        JSONObject jsonObject = new JSONObject(response);
        switch (mapping) {
            case "contentCode":
                transformXfwbPage.verifyCustomsInformationContentCode(jsonXml, jsonObject);
                break;
            case "note":
                transformXfwbPage.verifyCustomsInformationContent(jsonXml, jsonObject);
                break;
            case "subjectCode":
                transformXfwbPage.verifyCustomsInformationSubjectCode(jsonXml, jsonObject);
                break;
            case "country":
                transformXfwbPage.verifyCustomsInformationCountryID(jsonXml, jsonObject);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} of ApplicableLogisticsAllowanceCharge to data in response of Waybill {string}")
    public void verifyMappingDataOfApplicableLogisticsAllowanceChargeToDataInResponseOfWaybill(String arg0, String mapping) {
        JSONObject jsonObject = new JSONObject(response);
        switch (mapping) {
            case "otherChargeCode":
                transformXfwbPage.verifyOtherChargesOtherChargeCode(jsonXml, jsonObject);
                break;
            case "chargePaymentType":
                transformXfwbPage.verifyOtherChargesChargePaymentType(jsonXml, jsonObject);
                break;
            case "entitlement":
                transformXfwbPage.verifyOtherChargesEntitlement(jsonXml, jsonObject);
                break;
            case "otherChargeAmount":
                transformXfwbPage.verifyOtherChargesOtherChargeAmount(jsonXml, jsonObject);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} {string} {string} of IncludedMasterConsignmentItem to data in response of Waybill {string}")
    public void verifyMappingDataOfIncludedMasterConsignmentItemToDataInResponseOfWaybill(String keyRequest, String childReq, String arg2, String keyResponse) {
        JSONObject jsonObject = new JSONObject(response);
        switch (keyResponse) {
            case "grossWeightForRate":
                transformXfwbPage.verifyIncludedMasterConsignmentItemGrossWeightForRate(jsonXml, jsonObject);
                break;
            case "volume":
                transformXfwbPage.verifyIncludedMasterConsignmentItemGrossVolumeMeasure(jsonXml, jsonObject);
                break;
            case "pieceCountForRate":
                if (keyRequest.equals("PieceQuantity")) transformXfwbPage.verifyIncludedMasterConsignmentItemPieceQuantity(jsonXml, jsonObject);
                else if (keyRequest.equals("TransportLogisticsPackage")) transformXfwbPage.verifyTransportLogisticsPackageItemQuantity(jsonXml, jsonObject);
                break;
            case "goodsDescriptionForRate":
                transformXfwbPage.verifyNatureIdentificationTransportCargoIdentification(jsonXml, jsonObject);
                break;
            case "width":
                transformXfwbPage.verifyLinearSpatialDimensionWidthMeasure(jsonXml, jsonObject);
                break;
            case "length":
                transformXfwbPage.verifyLinearSpatialDimensionLengthMeasure(jsonXml, jsonObject);
                break;
            case "height":
                transformXfwbPage.verifyLinearSpatialDimensionHeightMeasure(jsonXml, jsonObject);
                break;
            case "rateClassCode":
                transformXfwbPage.verifyApplicableFreightRateServiceChargeCategoryCode(jsonXml, jsonObject);
                break;
            case "chargeableWeightForRate":
                transformXfwbPage.verifyApplicableFreightRateServiceChargeChargeableWeightMeasure(jsonXml, jsonObject);
                break;
            case "rateCharge":
                if (childReq.equals("AppliedRate")) transformXfwbPage.verifyApplicableFreightRateServiceChargeAppliedRate(jsonXml, jsonObject);
                else if (childReq.equals("AppliedAmount")) transformXfwbPage.verifyApplicableFreightRateServiceChargeAppliedAmount(jsonXml, jsonObject);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }
}
