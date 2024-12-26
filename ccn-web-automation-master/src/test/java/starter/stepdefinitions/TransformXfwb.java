package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.SkipStepException;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;
import org.json.XML;
import starter.api.TransformXfwbAPI;
import starter.utlis.onerecord.XFWBXml;

import java.io.IOException;

public class TransformXfwb {

    @Steps
    TransformXfwbAPI transformXfwbPage;
    String response;
    JSONObject jsonRequest, jsonResponse;

    @Given("user transform xfwb")
    public void userTransformXfwb() throws IOException {
        String xmlPayload = XFWBXml.xmlPayload;
        jsonRequest = XML.toJSONObject(xmlPayload);
        response = transformXfwbPage.transformXfwb(xmlPayload, "internal");
        jsonResponse = new JSONObject(response);
    }

    @Then("verify mapping data of {string} {string} {string} to data in response of Waybill {string}")
    public void verifyMappingDataOfToDataInResponseOfWaybill(String value, String child, String child2, String mapping) {
        switch (mapping) {
            case "waybillPrefix":
                transformXfwbPage.verifyWaybillPrefix(jsonRequest, jsonResponse);
                break;
            case "waybillNumber":
                transformXfwbPage.verifyWaybillNumber(jsonRequest, jsonResponse);
                break;
            case "shippingRefNo":
                transformXfwbPage.verifyShippingRefNo(jsonRequest, jsonResponse);
                break;
            case "waybillType":
                transformXfwbPage.verifyWaybillType(jsonRequest, jsonResponse);
                break;
            case "consignorDeclarationSignature":
                transformXfwbPage.verifyConsignorDeclarationSignature(jsonRequest, jsonResponse);
                break;
            case "carrierDeclarationDate":
                transformXfwbPage.verifyCarrierDeclarationDate(jsonRequest, jsonResponse);
                break;
            case "carrierDeclarationSignature":
                transformXfwbPage.verifyCarrierDeclarationSignature(jsonRequest, jsonResponse);
                break;
            case "carrierDeclarationPlace":
                transformXfwbPage.verifyCarrierDeclarationPlace(jsonRequest, jsonResponse);
                break;
            default:
                throw new SkipStepException(value + " is skipped because there is no mapping");
        }
    }

    @Then("verify mapping data of {string} to data in response of Waybill {string}")
    public void verifyMappingDataOfToDataInResponseOfWaybill(String value, String mapping) {
            switch (mapping) {
                case "weightValuationIndicator":
                    transformXfwbPage.verifyWeightValuationIndicator(jsonRequest, jsonResponse);
                    break;
                case "otherChargesIndicator":
                    transformXfwbPage.verifyOtherChargesIndicator(jsonRequest, jsonResponse);
                    break;
                case "totalGrossWeight":
                    // verify numericalValue
                    transformXfwbPage.verifyTotalGrossWeight(jsonRequest, jsonResponse);
                    // verify unit
                    transformXfwbPage.verifyUnitTotalGrossWeight(jsonRequest, jsonResponse);
                    break;
                case "dimensionsForRate":
                    // verify numericalValue
                    transformXfwbPage.verifyDimensionsForRate(jsonRequest, jsonResponse);
                    // verify unit
                    transformXfwbPage.verifyUnitDimensionsForRate(jsonRequest, jsonResponse);
                    break;
                case "pieceCountForRate":
                    transformXfwbPage.verifyPieceCountForRate(jsonRequest, jsonResponse);
                    break;
                case "declaredValueForCarriage":
                    if (value.equals("NilCarriageValueIndicator")) transformXfwbPage.verifyNilCarriageValueIndicator(jsonRequest, jsonResponse);
                    else if (value.equals("DeclaredValueForCarriageAmount")) transformXfwbPage.verifyDeclaredValueForCarriageAmount(jsonRequest, jsonResponse);
                    break;
                case "declaredValueForCustoms":
                    if (value.equals("NilCustomsValueIndicator")) transformXfwbPage.verifyNilCustomsValueIndicator(jsonRequest, jsonResponse);
                    else if (value.equals("DeclaredValueForCustomsAmount")) transformXfwbPage.verifyDeclaredValueForCustomsAmount(jsonRequest, jsonResponse);
                    break;
                case "insuredAmount":
                    if (value.equals("NilInsuranceValueIndicator")) transformXfwbPage.verifyNilInsuranceValueIndicator(jsonRequest, jsonResponse);
                    else if (value.equals("InsuranceValueAmount")) transformXfwbPage.verifyInsuranceValueAmount(jsonRequest, jsonResponse);
                    break;
                case "slacForRate":
                    transformXfwbPage.verifyPackageQuantity(jsonRequest, jsonResponse);
                    break;
                case "productCode":
                    transformXfwbPage.verifyProductID(jsonRequest, jsonResponse);
                    break;
                default:
                    throw new SkipStepException(value + " is skipped because there is no mapping in IR LO");
            }
    }

    @Then("verify mapping data {string} {string} of ConsignorParty to data in response of Waybill {string}")
    public void verifyMappingDataOfConsignorPartyToDataInResponseOfWaybill(String value, String child, String mapping) {
        String party = "Consignor";
        switch (mapping) {
            case "name":
                transformXfwbPage.verifyNameConsignorParty(jsonRequest, jsonResponse, party);
                break;
            case "otherIdentifiers":
                transformXfwbPage.verifyConsignorPartyAccID(jsonRequest, jsonResponse, party);
                break;
            case "postalCode":
                transformXfwbPage.verifyConsignorPostalCode(jsonRequest, jsonResponse, party);
                break;
            case "streetAddressLines":
                transformXfwbPage.verifyConsignorStreetAddressLines(jsonRequest, jsonResponse, party);
                break;
            case "country":
                transformXfwbPage.verifyConsignorCountry(jsonRequest, jsonResponse, party);
                break;
            case "cityName":
                transformXfwbPage.verifyConsignorCityName(jsonRequest, jsonResponse, party);
                break;
            case "countryCode":
                transformXfwbPage.verifyConsignorCountryCode(jsonRequest, jsonResponse, party);
                break;
            case "regionName":
                transformXfwbPage.verifyConsignorRegionName(jsonRequest, jsonResponse, party);
                break;
            case "postOfficeBox":
                transformXfwbPage.verifyConsignorPostOfficeBox(jsonRequest, jsonResponse, party);
                break;
            case "cityCode":
                transformXfwbPage.verifyConsignorCityID(jsonRequest, jsonResponse, party);
                break;
            case "regionCode":
                transformXfwbPage.verifyConsignorCountrySubDivisionID(jsonRequest, jsonResponse, party);
                break;
            case "firstName":
                transformXfwbPage.verifyConsignorPersonName(jsonRequest, jsonResponse, party);
                break;
            case "department":
                transformXfwbPage.verifyConsignorDepartmentName(jsonRequest, jsonResponse, party);
                break;
            case "textualValue":
                switch (child) {
                    case "DirectTelephoneCommunication":
                        transformXfwbPage.verifyConsignorDirectTelephoneCommunication(jsonRequest, jsonResponse, party);
                        break;
                    case "FaxCommunication":
                        transformXfwbPage.verifyConsignorFaxCommunication(jsonRequest, jsonResponse, party);
                        break;
                    case "URIEmailCommunication":
                        transformXfwbPage.verifyConsignorURIEmailCommunication(jsonRequest, jsonResponse, party);
                        break;
                    case "TelexCommunication":
                        transformXfwbPage.verifyConsignorTelexCommunication(jsonRequest, jsonResponse, party);
                        break;
                }
                break;
            default:
                throw new SkipStepException("there is no mapping for: " + mapping);
        }
    }

    @Then("verify mapping data {string} {string} of ConsigneeParty to data in response of Waybill {string}")
    public void verifyMappingDataOfConsigneePartyToDataInResponseOfWaybill(String value, String child, String mapping) {
        String party = "Consignee";
        switch (mapping) {
            case "name":
                transformXfwbPage.verifyNameConsigneeParty(jsonRequest, jsonResponse, party);
                break;
            case "postalCode":
                transformXfwbPage.verifyConsigneePostalCode(jsonRequest, jsonResponse, party);
                break;
            case "streetAddressLines":
                transformXfwbPage.verifyConsigneeStreetAddressLines(jsonRequest, jsonResponse, party);
                break;
            case "country":
                transformXfwbPage.verifyConsigneeCountryName(jsonRequest, jsonResponse, party);
                break;
            case "otherIdentifiers":
                transformXfwbPage.verifyConsigneeAccountID(jsonRequest, jsonResponse, party);
                break;
            case "cityName":
                transformXfwbPage.verifyConsigneeCityName(jsonRequest, jsonResponse, party);
                break;
            case "countryCode":
                transformXfwbPage.verifyConsigneeCountryID(jsonRequest, jsonResponse, party);
                break;
            case "regionName":
                transformXfwbPage.verifyConsigneeCountrySubDivisionName(jsonRequest, jsonResponse, party);
                break;
            case "postOfficeBox":
                transformXfwbPage.verifyConsigneePostOfficeBox(jsonRequest, jsonResponse, party);
                break;
            case "cityCode":
                transformXfwbPage.verifyConsigneeCityID(jsonRequest, jsonResponse, party);
                break;
            case "regionCode":
                transformXfwbPage.verifyConsigneeCountrySubDivisionID(jsonRequest, jsonResponse, party);
                break;
            case "firstName":
                transformXfwbPage.verifyConsigneePersonName(jsonRequest, jsonResponse, party);
                break;
            case "textualValue":
                switch (child) {
                    case "DirectTelephoneCommunication":
                        transformXfwbPage.verifyConsigneeDirectTelephoneCommunication(jsonRequest, jsonResponse, party);
                        break;
                    case "FaxCommunication":
                        transformXfwbPage.verifyConsigneeFaxCommunication(jsonRequest, jsonResponse, party);
                        break;
                    case "URIEmailCommunication":
                        transformXfwbPage.verifyConsigneeURIEmailCommunication(jsonRequest, jsonResponse, party);
                        break;
                    case "TelexCommunication":
                        transformXfwbPage.verifyConsigneeTelexCommunication(jsonRequest, jsonResponse, party);
                        break;
                    case "DepartmentName":
                        transformXfwbPage.verifyConsigneeDepartmentName(jsonRequest, jsonResponse, party);
                        break;
                }
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} {string} of FreightForwarderParty to data in response of Waybill {string}")
    public void verifyMappingDataOfFreightForwarderPartyToDataInResponseOfWaybill(String value, String child, String mapping) {
        String party = "Agent";
        switch (mapping) {
            case "name":
                transformXfwbPage.verifyNameFreightForwarderParty(jsonRequest, jsonResponse, party);
                break;
            case "iataCargoAgentLocationIdentifier":
                transformXfwbPage.verifyFreightForwarderSpecifiedCargoAgentLocationId(jsonRequest, jsonResponse, party);
                break;
            case "iataCargoAgentCode":
                transformXfwbPage.verifyFreightForwarderCargoAgentId(jsonRequest, jsonResponse, party);
                break;
            case "otherIdentifiers":
                transformXfwbPage.verifyFreightForwarderAccountID(jsonRequest, jsonResponse, party);
                break;
            case "postalCode":
                transformXfwbPage.verifyFreightForwarderPostcodeCode(jsonRequest, jsonResponse, party);
                break;
            case "streetAddressLines":
                transformXfwbPage.verifyFreightForwarderStreetName(jsonRequest, jsonResponse, party);
                break;
            case "cityName":
                transformXfwbPage.verifyFreightForwarderCityName(jsonRequest, jsonResponse, party);
                break;
            case "countryCode":
                transformXfwbPage.verifyFreightForwarderCountryID(jsonRequest, jsonResponse, party);
                break;
            case "country":
                transformXfwbPage.verifyFreightForwarderCountryName(jsonRequest, jsonResponse, party);
                break;
            case "regionName":
                transformXfwbPage.verifyFreightForwarderCountrySubDivisionName(jsonRequest, jsonResponse, party);
                break;
            case "postOfficeBox":
                transformXfwbPage.verifyFreightForwarderPostOfficeBox(jsonRequest, jsonResponse, party);
                break;
            case "cityCode":
                transformXfwbPage.verifyFreightForwarderCityID(jsonRequest, jsonResponse, party);
                break;
            case "firstName":
                transformXfwbPage.verifyFFPPersonName(jsonRequest, jsonResponse, party);
                break;
            case "regionCode":
                transformXfwbPage.verifyFreightForwarderCountrySubDivisionID(jsonRequest, jsonResponse, party);
                break;
            case "textualValue":
                switch (child) {
                    case "DirectTelephoneCommunication":
                        transformXfwbPage.verifyFFPDirectTelephoneCommunication(jsonRequest, jsonResponse, party);
                        break;
                    case "FaxCommunication":
                        transformXfwbPage.verifyFFPFaxCommunication(jsonRequest, jsonResponse, party);
                        break;
                    case "URIEmailCommunication":
                        transformXfwbPage.verifyFFPURIEmailCommunication(jsonRequest, jsonResponse, party);
                        break;
                    case "TelexCommunication":
                        transformXfwbPage.verifyFFPTelexCommunication(jsonRequest, jsonResponse, party);
                        break;
                    case "DepartmentName":
                        transformXfwbPage.verifyFFPDepartmentName(jsonRequest, jsonResponse, party);
                        break;
                }
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} of OriginLocation to data in response of Waybill {string}")
    public void verifyMappingDataOfOriginLocationToDataInResponseOfWaybill(String arg0, String mapping) {
        switch (mapping) {
            case "code":
                transformXfwbPage.verifyOriginLocationId(jsonRequest, jsonResponse);
                break;
            case "name":
                transformXfwbPage.verifyOriginLocationName(jsonRequest, jsonResponse);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} of FinalDestinationLocation to data in response of Waybill {string}")
    public void verifyMappingDataOfFinalDestinationLocationToDataInResponseOfWaybill(String arg0, String mapping) {
        switch (mapping) {
            case "code":
                transformXfwbPage.verifyFinalDestinationLocationId(jsonRequest, jsonResponse);
                break;
            case "name":
                transformXfwbPage.verifyFinalDestinationLocationName(jsonRequest, jsonResponse);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }
    @Then("verify mapping data {string} {string} {string} of SpecifiedLogisticsTransportMovement to data in response of Waybill {string}")
    public void verifyMappingDataOfSpecifiedLogisticsTransportMovementToDataInResponseOfWaybill(String keyRequest, String arg1, String arg2, String keyResponse) {
        if (keyRequest.equals("ArrivalEvent")){
            switch (keyResponse) {
                case "movementTimestamp":
                    transformXfwbPage.verifyScheduledOccurrenceDateTime(jsonRequest, jsonResponse);
                    break;
                case "code":
                    transformXfwbPage.verifyOccurrenceArrivalLocationID(jsonRequest, jsonResponse);
                    break;
                case "locationName":
                    transformXfwbPage.verifyOccurrenceArrivalLocationName(jsonRequest, jsonResponse);
                    break;
                case "locationType":
                    transformXfwbPage.verifyOccurrenceArrivalTypeCode(jsonRequest, jsonResponse);
                    break;
                default:
                    throw new SkipStepException("there is no key");
            }
        } else if (keyRequest.equals("DepartureEvent")){
            switch (keyResponse) {
                case "movementTimestamp":
                    transformXfwbPage.verifyDepartureScheduledOccurrenceDateTime(jsonRequest, jsonResponse);
                    break;
                case "code":
                    transformXfwbPage.verifyOccurrenceDepartureLocationID(jsonRequest, jsonResponse);
                    break;
                case "locationName":
                    transformXfwbPage.verifyOccurrenceDepartureLocationName(jsonRequest, jsonResponse);
                    break;
                case "locationType":
                    transformXfwbPage.verifyOccurrenceDepartureTypeCode(jsonRequest, jsonResponse);
                    break;
                default:
                    throw new SkipStepException("there is no key");
            }
        } else {
            switch (keyResponse) {
                case "transportIdentifier":
                    transformXfwbPage.verifySpecifiedLogisticsTransportMovementID(jsonRequest, jsonResponse);
                    break;
                case "airlineCode":
                    transformXfwbPage.verifyUsedLogisticsTransportMeans(jsonRequest, jsonResponse);
                    break;
                case "modeQualifier":
                    transformXfwbPage.verifySpecifiedLogisticsTransportMovementStageCode(jsonRequest, jsonResponse);
                    break;
                case "modeCode":
                    transformXfwbPage.verifySpecifiedLogisticsTransportMovementModeCode(jsonRequest, jsonResponse);
                    break;
                default:
                    throw new SkipStepException("there is no key");
            }
        }
    }
    @Then("verify mapping data {string} of HandlingSPHInstructions to data in response of Waybill {string}")
    public void verifyMappingDataOfHandlingSPHInstructionsToDataInResponseOfWaybill(String arg0, String mapping) {
        switch (mapping) {
            case "specialHandlingCodes":
                transformXfwbPage.verifySpecialHandlingCodes(jsonRequest, jsonResponse);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }
    @Then("verify mapping data {string} of HandlingSSRInstructions to data in response of Waybill {string}")
    public void verifyMappingDataOfHandlingSSRInstructionsToDataInResponseOfWaybill(String arg0, String mapping) {
        switch (mapping) {
            case "textualHandlingInstructions":
                transformXfwbPage.verifyTextualHandlingInstructionsDescription(jsonRequest, "SSR", jsonResponse);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }
    @Then("verify mapping data {string} of IncludedAccountingNote to data in response of Waybill {string}")
    public void verifyMappingDataOfIncludedAccountingNoteToDataInResponseOfWaybill(String arg0, String mapping) throws IOException {
        switch (mapping) {
            case "accountingInformation":
                transformXfwbPage.verifyAccountingInformation(jsonRequest, jsonResponse);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} of IncludedCustomsNote to data in response of Waybill {string}")
    public void verifyMappingDataOfIncludedCustomsNoteToDataInResponseOfWaybill(String arg0, String mapping) {
        switch (mapping) {
            case "contentCode":
                transformXfwbPage.verifyCustomsInformationContentCode(jsonRequest, jsonResponse);
                break;
            case "note":
                transformXfwbPage.verifyCustomsInformationContent(jsonRequest, jsonResponse);
                break;
            case "subjectCode":
                transformXfwbPage.verifyCustomsInformationSubjectCode(jsonRequest, jsonResponse);
                break;
            case "country":
                transformXfwbPage.verifyCustomsInformationCountryID(jsonRequest, jsonResponse);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} of ApplicableLogisticsAllowanceCharge to data in response of Waybill {string}")
    public void verifyMappingDataOfApplicableLogisticsAllowanceChargeToDataInResponseOfWaybill(String arg0, String mapping) {
        switch (mapping) {
            case "otherChargeCode":
                transformXfwbPage.verifyOtherChargesOtherChargeCode(jsonRequest, jsonResponse);
                break;
            case "chargePaymentType":
                transformXfwbPage.verifyOtherChargesChargePaymentType(jsonRequest, jsonResponse);
                break;
            case "entitlement":
                transformXfwbPage.verifyOtherChargesEntitlement(jsonRequest, jsonResponse);
                break;
            case "otherChargeAmount":
                transformXfwbPage.verifyOtherChargesOtherChargeAmount(jsonRequest, jsonResponse);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} {string} {string} of IncludedMasterConsignmentItem to data in response of Waybill {string}")
    public void verifyMappingDataOfIncludedMasterConsignmentItemToDataInResponseOfWaybill(String keyRequest, String childReq, String arg2, String keyResponse) {
        switch (keyResponse) {
            case "grossWeightForRate":
                transformXfwbPage.verifyIncludedMasterConsignmentItemGrossWeightForRate(jsonRequest, jsonResponse);
                break;
            case "volume":
                transformXfwbPage.verifyIncludedMasterConsignmentItemGrossVolumeMeasure(jsonRequest, jsonResponse);
                break;
            case "pieceCountForRate":
                if (keyRequest.equals("PieceQuantity")) transformXfwbPage.verifyIncludedMasterConsignmentItemPieceQuantity(jsonRequest, jsonResponse);
                else if (keyRequest.equals("TransportLogisticsPackage")) transformXfwbPage.verifyTransportLogisticsPackageItemQuantity(jsonRequest, jsonResponse);
                break;
            case "goodsDescriptionForRate":
                transformXfwbPage.verifyNatureIdentificationTransportCargoIdentification(jsonRequest, jsonResponse);
                break;
            case "width":
                transformXfwbPage.verifyLinearSpatialDimensionWidthMeasure(jsonRequest, jsonResponse);
                break;
            case "length":
                transformXfwbPage.verifyLinearSpatialDimensionLengthMeasure(jsonRequest, jsonResponse);
                break;
            case "height":
                transformXfwbPage.verifyLinearSpatialDimensionHeightMeasure(jsonRequest, jsonResponse);
                break;
            case "rateClassCode":
                transformXfwbPage.verifyApplicableFreightRateServiceChargeCategoryCode(jsonRequest, jsonResponse);
                break;
            case "chargeableWeightForRate":
                transformXfwbPage.verifyApplicableFreightRateServiceChargeChargeableWeightMeasure(jsonRequest, jsonResponse);
                break;
            case "rateCharge":
                if (childReq.equals("AppliedRate")) transformXfwbPage.verifyApplicableFreightRateServiceChargeAppliedRate(jsonRequest, jsonResponse);
                else if (childReq.equals("AppliedAmount")) transformXfwbPage.verifyApplicableFreightRateServiceChargeAppliedAmount(jsonRequest, jsonResponse);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} {string} of AssociatedParty to data in response of Waybill {string}")
    public void verifyMappingDataOfAssociatedPartyToDataInResponseOfWaybill(String value, String child, String mapping) {
        String party = "Associated Party";
        switch (mapping) {
            case "name":
                transformXfwbPage.verifyAssociatedPartyName(jsonRequest, jsonResponse, party);
                break;
            case "postalCode":
                transformXfwbPage.verifyAssociatedPartyPostcodeCode(jsonRequest, jsonResponse, party);
                break;
            case "streetAddressLines":
                transformXfwbPage.verifyAssociatedPartyStreetName(jsonRequest, jsonResponse, party);
                break;
            case "cityName":
                transformXfwbPage.verifyAssociatedPartyCityName(jsonRequest, jsonResponse, party);
                break;
            case "countryCode":
                transformXfwbPage.verifyAssociatedPartyCountryID(jsonRequest, jsonResponse, party);
                break;
            case "country":
                transformXfwbPage.verifyAssociatedPartyCountryName(jsonRequest, jsonResponse, party);
                break;
            case "regionName":
                transformXfwbPage.verifyAssociatedPartyCountrySubDivisionName(jsonRequest, jsonResponse, party);
                break;
            case "postOfficeBox":
                transformXfwbPage.verifyAssociatedPartyPostOfficeBox(jsonRequest, jsonResponse, party);
                break;
            case "cityCode":
                transformXfwbPage.verifyAssociatedPartyCityID(jsonRequest, jsonResponse, party);
                break;
            case "firstName":
                transformXfwbPage.verifyAssociatedPartyPersonName(jsonRequest, jsonResponse, party);
                break;
            case "regionCode":
                transformXfwbPage.verifyAssociatedPartyCountrySubDivisionID(jsonRequest, jsonResponse, party);
                break;
            case "textualValue":
                switch (child) {
                    case "DirectTelephoneCommunication":
                        transformXfwbPage.verifyAssociatedPartyDirectTelephoneCommunication(jsonRequest, jsonResponse, party);
                        break;
                    case "FaxCommunication":
                        transformXfwbPage.verifyAssociatedPartyFaxCommunication(jsonRequest, jsonResponse, party);
                        break;
                    case "URIEmailCommunication":
                        transformXfwbPage.verifyAssociatedPartyURIEmailCommunication(jsonRequest, jsonResponse, party);
                        break;
                    case "TelexCommunication":
                        transformXfwbPage.verifyAssociatedPartyTelexCommunication(jsonRequest, jsonResponse, party);
                        break;
                    case "DepartmentName":
                        transformXfwbPage.verifyAssociatedPartyDepartmentName(jsonRequest, jsonResponse, party);
                        break;
                }
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} of UtilizedLogisticsTransportEquipment to data in response of Waybill {string}")
    public void verifyMappingDataOfUtilizedLogisticsTransportEquipmentToDataInResponseOfWaybill(String value, String mapping) {
        switch (mapping) {
            case "vehicleRegistration":
                transformXfwbPage.verifyUtilizedLogisticsTransportEquipmentID(jsonRequest, jsonResponse);
                break;
            case "vehicleType":
                transformXfwbPage.verifyUtilizedLogisticsTransportEquipmentCharacteristicCode(jsonRequest, jsonResponse);
                break;
            case "vehicleSize":
                transformXfwbPage.verifyUtilizedLogisticsTransportEquipmentCharacteristic(jsonRequest, jsonResponse);
                break;
            case "seal":
                transformXfwbPage.verifyUtilizedLogisticsTransportEquipmentAffixedLogisticsSeal(jsonRequest, jsonResponse);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} of HandlingOSIInstructions to data in response of Waybill {string}")
    public void verifyMappingDataOfHandlingOSIInstructionsToDataInResponseOfWaybill(String value, String mapping) {
        switch (mapping) {
            case "textualHandlingInstructions":
                transformXfwbPage.verifyOSITextualHandlingInstructionsDescription(jsonRequest, "SSR", jsonResponse);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} of AssociatedReferenceDocument to data in response of Waybill {string}")
    public void verifyMappingDataOfAssociatedReferenceDocumentToDataInResponseOfWaybill(String value, String mapping) {
        switch (mapping) {
            case "documentIdentifier":
                transformXfwbPage.verifyAssociatedReferenceDocumentID(jsonRequest, jsonResponse);
                break;
            case "validFrom, validUntil":
                transformXfwbPage.verifyAssociatedReferenceDocumentIssueDateTime(jsonRequest, jsonResponse);
                break;
            case "documentType":
                transformXfwbPage.verifyAssociatedReferenceDocumentTypeCode(jsonRequest, jsonResponse);
                break;
            case "documentName":
                transformXfwbPage.verifyAssociatedReferenceDocumentName(jsonRequest, jsonResponse);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    @Then("verify mapping data {string} of ApplicableOriginCurrencyExchange to data in response of Waybill {string}")
    public void verifyMappingDataOfApplicableOriginCurrencyExchangeToDataInResponseOfWaybill(String value, String mapping) {
        if (mapping.equals("originCurrency")) {
            transformXfwbPage.verifyApplicableOriginCurrencyExchangeSourceCurrencyCode(jsonRequest, jsonResponse);
        } else {
            throw new SkipStepException("there is no searched key");
        }
    }

    @Given("user transform xfwb using {string} url")
    public void userTransformXfwbUsingUrl(String url) throws IOException {
        String xmlPayload = XFWBXml.xmlPayload;
        jsonRequest = XML.toJSONObject(xmlPayload);
        response = transformXfwbPage.transformXfwb(xmlPayload, url);
        jsonResponse = new JSONObject(response);
    }
}
