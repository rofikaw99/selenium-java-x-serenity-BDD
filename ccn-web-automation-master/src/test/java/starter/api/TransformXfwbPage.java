package starter.api;

import io.cucumber.messages.JSON;
import net.serenitybdd.core.SkipStepException;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Assert;
import starter.utlis.XFWBRequest;
import starter.utlis.XFWBResponse;
import starter.utlis.XFWBXml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.*;

public class TransformXfwbPage {
    String response;
    JSONObject jsonXml;

    public void transformXfwb() throws IOException {
        String url = "https://onerecordppd.cubeforall.com/6b0b831ee6b546f4b4ac0eab642874c6/transformXFWB3";
        String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IkwxS2ZLRklfam5YYndXYzIyeFp4dzFzVUhIMCJ9.eyJhdWQiOiJhYTkyMDA1YS02MzcwLTQ4MWItYWExNy1iYmNmNzhjMDgzYTciLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vZmFmMDVlYmUtYzNkYy00NDM3LWJjMmQtMmE4MTU2NTNmNzVjL3YyLjAiLCJpYXQiOjE3MTU4MTgxNTIsIm5iZiI6MTcxNTgxODE1MiwiZXhwIjoxNzE1ODIyMDUyLCJhaW8iOiJBU1FBMi84V0FBQUFuUXhVSG9WQVBwUzErMjdjcGxMbnRKS1RONm0vQWFCNWdObU9VekpIazd3PSIsImF6cCI6ImNiZmM2ODkzLTNjMTMtNDJjMi1hMzFlLTg3NGMxNWQ2ZmVhYyIsImF6cGFjciI6IjEiLCJyaCI6IjAuQVQ4QXZsN3ctdHpETjBTOExTcUJWbFAzWEZvQWtxcHdZeHRJcWhlN3ozakFnNmRBQUFBLiIsInRpZCI6ImZhZjA1ZWJlLWMzZGMtNDQzNy1iYzJkLTJhODE1NjUzZjc1YyIsInV0aSI6Im5mWVN1dDRadmtHSzd4NWVPMlFhQUEiLCJ2ZXIiOiIyLjAifQ.Fycbt6eI8nQgoR3nE5X259kOuEO6SpZi1DxAKv19P_VMfqhoCFo_0azOGb7s5Lq9qcAQ1eBqJlv4jscYG-DUbdVGfzN8BRlc6-H1fs1yNJUYZvRnyW1ZR8jF82ghwkhgb8A3stQ3SV0XOWRRyXw1iXuLSJgZf7VKbcQQrFjixDfkTJkUg14B7Dl3fKQwJVdt5CYnJDRGpnwQv7635JQDRmFNv1RNmhk7VpqWYrL2lndCltec_acpbkCq-shW23Al-UwWGafpXsBc_CO7l65juHuXXRHh2xb3GKO2iqAijb5VV0oGz25Iun7EHGVa1E7Zw9Mxr_rz-haun5iTe98mow";
        jsonXml = XML.toJSONObject(XFWBXml.xmlPayload);

        response = given()
                .headers(
                        "Authorization", "Bearer " + accessToken,
                        "Content-Type", "application/xml",
                        "Cookie", "BIGipServerPPD_Cube_80=4006088876.20480.0000")
                .body(XFWBXml.xmlPayload)
                .post(url)
                .then()
                .extract()
                .body()
                .asString();

        FileWriter file = new FileWriter("src/test/java/starter/utlis/outputJson.json");
        file.write(response);
        file.close();
        then().statusCode(200);
    }

    public void verifyWaybillPrefix(JSONObject jsonObject){
        Assert.assertEquals(List.of(XFWBRequest.BHD_ID(jsonXml).split("-")).get(0), XFWBResponse.waybillPrefix(jsonObject));
    }
    public void verifyWaybillNumber(JSONObject jsonObject){
        Assert.assertEquals(List.of(XFWBRequest.BHD_ID(jsonXml).split("-")).get(1), XFWBResponse.waybillNumber(jsonObject));
    }
    public void verifyWaybillType(JSONObject jsonObject){
        String expected = XFWBRequest.IHN_ContentCode(jsonXml);
        if (expected.equals("D")) expected = "DIRECT";
        else expected = "MASTER";
        Assert.assertEquals(expected, XFWBResponse.waybillType(jsonObject));
    }
    public void verifyConsignorDeclarationSignature(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SCoA_Signatory(jsonXml), XFWBResponse.consignorDeclarationSignature(jsonObject));
    }
    public void carrierDeclarationDate(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.BHD_SCaA_ActualDateTime(jsonXml), XFWBResponse.carrierDeclarationDate(jsonObject));
    }
    public void verifyCarrierDeclarationSignature(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.BHD_SCaA_Signatory(jsonXml), XFWBResponse.carrierDeclarationSignature(jsonObject));
    }
    public void verifyCarrierDeclarationPlace(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.IAL_Name(jsonXml), XFWBResponse.carrierDeclarationPlace(jsonObject));
    }
    public void verifyWeightValuationIndicator(JSONObject jsonObject){
        Boolean expected = XFWBRequest.TotalChargePrepaidIndicator(jsonXml);
        String convertExpected;
        if (expected) convertExpected = "P";
        else convertExpected = "C";
        Assert.assertEquals(convertExpected, XFWBResponse.weightValuationIndicator(jsonObject));
    }
    public void verifyOtherChargesIndicator(JSONObject jsonObject){
        Boolean expected = XFWBRequest.TotalDisbursementPrepaidIndicator(jsonXml);
        String convertExpected;
        if (expected) convertExpected = "P";
        else convertExpected = "C";
        Assert.assertEquals(convertExpected, XFWBResponse.otherChargesIndicator(jsonObject));
    }
    public void verifyTotalGrossWeight(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.IncludedTareGrossWeightMeasure(jsonXml).get("content"), XFWBResponse.numericalValueOfGrossWeight(jsonObject));
    }
    public void verifyUnitTotalGrossWeight(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.IncludedTareGrossWeightMeasure(jsonXml).get("unitCode"), XFWBResponse.unitTotalGrossWeight(jsonObject));
    }
    public void verifyDimensionsForRate(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.GrossVolumeMeasure(jsonXml).get("content"), XFWBResponse.numericalValueDimensionsForRate(jsonObject));
    }
    public void verifyUnitDimensionsForRate(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.GrossVolumeMeasure(jsonXml).get("unitCode"), XFWBResponse.unitDimensionsForRate(jsonObject));
    }
    public void verifyPieceCountForRate(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.TotalPieceQuantity(jsonXml), XFWBResponse.pieceCountForRate(jsonObject));
    }
    public void verifyNameConsignorParty(JSONObject jsonObject, String party){
        Assert.assertEquals(XFWBRequest.CoP_Name(jsonXml), XFWBResponse.PD_Name(jsonObject, party));
    }
    public void verifyConsignorPostalCode(JSONObject jsonObject, String party){
        Assert.assertEquals(XFWBRequest.CoP_PSA_PostcodeCode(jsonXml), XFWBResponse.PD_BAL_A_postalCode(jsonObject, party));
    }
    public void verifyConsignorStreetAddressLines(JSONObject jsonObject, String party){
        Assert.assertEquals(XFWBRequest.CoP_PSA_StreetName(jsonXml), XFWBResponse.PD_BAL_streetAddressLines(jsonObject, party));
    }
    public void verifyConsignorCountryCode(JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CoP_PSA_CountryID(jsonXml), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyNameConsigneeParty(JSONObject jsonObject, String party){
        Assert.assertEquals(XFWBRequest.CeP_Name(jsonXml), XFWBResponse.PD_Name(jsonObject, party));
    }
    public void verifyConsigneePostalCode(JSONObject jsonObject, String party){
        Assert.assertEquals(XFWBRequest.CeP_PSA_PostcodeCode(jsonXml), XFWBResponse.PD_BAL_A_postalCode(jsonObject, party));
    }
    public void verifyConsigneeStreetAddressLines(JSONObject jsonObject, String party){
        Assert.assertEquals(XFWBRequest.CeP_PSA_StreetName(jsonXml), XFWBResponse.PD_BAL_streetAddressLines(jsonObject, party));
    }
    public void verifyConsigneeCountryCode(JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.CeP_PSA_CountryID(jsonXml), XFWBResponse.PD_BAL_A_countryCode(jsonObject, party));
    }
    public void verifyNameFreightForwarderParty(JSONObject jsonObject, String party){
        Assert.assertEquals(XFWBRequest.FFP_Name(jsonXml), XFWBResponse.PD_Name(jsonObject, party));
    }
    public void verifyFreightForwarderCargoAgentId(JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_CargoAgentID(jsonXml), XFWBResponse.PD_IataCargoAgentCode(jsonObject, party));
    }
    public void verifyFreightForwarderSpecifiedCargoAgentLocationId(JSONObject jsonObject, String party) {
        Assert.assertEquals(XFWBRequest.FFP_SpecifiedCargoAgentLocation_ID(jsonXml), XFWBResponse.PD_IataCargoAgentLocationIdentifier(jsonObject, party));
    }
    public void verifyOriginLocationId(JSONObject jsonObject) {
        Assert.assertEquals(XFWBRequest.OL_ID(jsonXml), XFWBResponse.DL_LocationCodes_Code(jsonObject));
    }
    public void verifyFinalDestinationLocationId(JSONObject jsonObject) {
        Assert.assertEquals(XFWBRequest.FDL_ID(jsonXml), XFWBResponse.AL_LocationCodes_Code(jsonObject));
    }
    public void verifySpecifiedLogisticsTransportMovementID(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_ID(jsonXml), XFWBResponse.SA_TransportIdentifier(jsonObject));
    }
    public void verifyUsedLogisticsTransportMeans(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_UsedLogisticsTransportMeans_Name(jsonXml), XFWBResponse.SA_OperatingTransportMeans_TransportOrganization_AirlineCode(jsonObject));
    }
    public void verifyScheduledOccurrenceDateTime(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_AE_ScheduledOccurrenceDateTime(jsonXml), XFWBResponse.SA_MovementTimes_MovementTimestamp(jsonObject));
    }
    public void verifyOccurrenceArrivalLocationID(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_AE_OAL_ID(jsonXml), XFWBResponse.SA_AL_LocationCodes_Code(jsonObject));
    }
    public void verifyOccurrenceArrivalLocationName(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.SLTM_AE_OAL_Name(jsonXml), XFWBResponse.SA_AL_LocationName(jsonObject));
    }
    public void verifySpecialHandlingCodes(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.HandlingSPHInstructions(jsonXml), XFWBResponse.SpecialHandlingCodes(jsonObject));
    }
    public void verifyTextualHandlingInstructionsDescription(String type, JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.HSSRI_Description(type, jsonXml), XFWBResponse.TextualHandlingInstructions(jsonObject));
    }
    public void verifyAccountingInformation(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.IncludedAccountingNote(jsonXml), XFWBResponse.AccountingInformation(jsonObject));
    }
    public void verifyCustomsInformationContentCode(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ICN_ContentCode(jsonXml), XFWBResponse.CI_ContentCode(jsonObject));
    }
    public void verifyCustomsInformationContent(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ICN_Content(jsonXml), XFWBResponse.CI_Note(jsonObject));
    }
    public void verifyCustomsInformationSubjectCode(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ICN_SubjectCode(jsonXml), XFWBResponse.CI_SubjectCode(jsonObject));
    }
    public void verifyCustomsInformationCountryID(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ICN_CountryID(jsonXml), XFWBResponse.CI_Country(jsonObject));
    }
    public void verifyOtherChargesOtherChargeAmount(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ALLC_ActualAmount(jsonXml), XFWBResponse.OC_OtherChargeAmount(jsonObject));
    }
    public void verifyOtherChargesOtherChargeCode(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ALLC_ID(jsonXml), XFWBResponse.OC_OtherChargeCode(jsonObject));
    }
    public void verifyOtherChargesChargePaymentType(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ALLC_PrepaidIndicator(jsonXml), XFWBResponse.OC_ChargePaymentType(jsonObject));
    }
    public void verifyOtherChargesEntitlement(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.ALLC_PartyTypeCode(jsonXml), XFWBResponse.OC_Entitlement(jsonObject));
    }
    public void verifyIncludedMasterConsignmentItemGrossWeightForRate(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_GrossWeightMeasure(jsonXml), XFWBResponse.WaybillLineItems_GrossWeightForRate(jsonObject));
    }
    public void verifyIncludedMasterConsignmentItemGrossVolumeMeasure(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_GrossVolumeMeasure(jsonXml), XFWBResponse.WLI_DimensionsForRate_Volume(jsonObject));
    }
    public void verifyIncludedMasterConsignmentItemPieceQuantity(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_PieceQuantity(jsonXml), XFWBResponse.WaybillLineItems_PieceCountForRate(jsonObject));
    }
    public void verifyNatureIdentificationTransportCargoIdentification(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_NatureIdentificationTransportCargo_Identification(jsonXml), XFWBResponse.WaybillLineItems_GoodsDescriptionForRate(jsonObject));
    }
    public void verifyTransportLogisticsPackageItemQuantity(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_TLP_ItemQuantity(jsonXml), XFWBResponse.WaybillLineItems_PieceCountForRate(jsonObject));
    }
    public void verifyLinearSpatialDimensionWidthMeasure(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_TLP_LSD_WidthMeasure(jsonXml), XFWBResponse.WLI_DimensionsForRate_Width(jsonObject));
    }
    public void verifyLinearSpatialDimensionLengthMeasure(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_TLP_LSD_LengthMeasure(jsonXml), XFWBResponse.WLI_DimensionsForRate_Length(jsonObject));
    }
    public void verifyLinearSpatialDimensionHeightMeasure(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_TLP_LSD_HeightMeasure(jsonXml), XFWBResponse.WLI_DimensionsForRate_Height(jsonObject));
    }
    public void verifyApplicableFreightRateServiceChargeCategoryCode(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_AFRSC_CategoryCode(jsonXml), XFWBResponse.WLI_RateClassCode(jsonObject));
    }
    public void verifyApplicableFreightRateServiceChargeChargeableWeightMeasure(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_AFRSC_ChargeableWeightMeasure(jsonXml), XFWBResponse.WLI_ChargeableWeightForRate(jsonObject));
    }
    public void verifyApplicableFreightRateServiceChargeAppliedRate(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_AFRSC_AppliedRate(jsonXml), XFWBResponse.WLI_RateCharge(jsonObject));
    }
    public void verifyApplicableFreightRateServiceChargeAppliedAmount(JSONObject jsonObject){
        Assert.assertEquals(XFWBRequest.AR_IMCI_AFRSC_AppliedAmount(jsonXml), XFWBResponse.WLI_RateCharge(jsonObject));
    }
    public void verifyMappingMasterConsignment(String key){
        JSONObject jsonObject = new JSONObject(response);
        switch (key) {
            case "weightValuationIndicator":
                verifyWeightValuationIndicator(jsonObject);
                break;
            case "otherChargesIndicator":
                verifyOtherChargesIndicator(jsonObject);
                break;
            case "totalGrossWeight":
                // verify numericalValue
                verifyTotalGrossWeight(jsonObject);
                // verify unit
                verifyUnitTotalGrossWeight(jsonObject);
                break;
            case "dimensionsForRate":
                // verify numericalValue
                verifyDimensionsForRate(jsonObject);
                // verify unit
                verifyUnitDimensionsForRate(jsonObject);
                break;
            case "pieceCountForRate":
                verifyPieceCountForRate(jsonObject);
                break;
        }
    }
    public void verifyMappingBusinessHeader(String key){
        JSONObject jsonObject = new JSONObject(response);
        switch (key) {
            case "waybillPrefix":
                verifyWaybillPrefix(jsonObject);
                break;
            case "waybillNumber":
                verifyWaybillNumber(jsonObject);
                break;
            case "waybillType":
                verifyWaybillType(jsonObject);
                break;
            case "consignorDeclarationSignature":
                verifyConsignorDeclarationSignature(jsonObject);
                break;
            case "carrierDeclarationDate":
                carrierDeclarationDate(jsonObject);
                break;
            case "carrierDeclarationSignature":
                verifyCarrierDeclarationSignature(jsonObject);
                break;
            case "carrierDeclarationPlace":
                verifyCarrierDeclarationPlace(jsonObject);
                break;
        }
    }

    public void verifyConsignorMappingParty(String key){
        JSONObject jsonObject = new JSONObject(response);
        String party = "Consignor";
        switch (key) {
            case "name":
                verifyNameConsignorParty(jsonObject, party);
                break;
            case "postalCode":
                verifyConsignorPostalCode(jsonObject, party);
                break;
            case "streetAddressLines":
                verifyConsignorStreetAddressLines(jsonObject, party);
                break;
            case "country":
                verifyConsignorCountryCode(jsonObject, party);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }
    public void verifyConsigneeMappingParty(String key) {
        JSONObject jsonObject = new JSONObject(response);
        String party = "Consignee";
        switch (key) {
            case "name":
                verifyNameConsigneeParty(jsonObject, party);
                break;
            case "postalCode":
                verifyConsigneePostalCode(jsonObject, party);
                break;
            case "streetAddressLines":
                verifyConsigneeStreetAddressLines(jsonObject, party);
                break;
            case "country":
                verifyConsigneeCountryCode(jsonObject, party);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }
    public void verifyFreightForwarderMappingParty(String key) {
        JSONObject jsonObject = new JSONObject(response);
        String party = "Agent";
        switch (key) {
            case "name":
                verifyNameFreightForwarderParty(jsonObject, party);
                break;
            case "iataCargoAgentLocationIdentifier":
                verifyFreightForwarderSpecifiedCargoAgentLocationId(jsonObject, party);
                break;
            case "iataCargoAgentCode":
                verifyFreightForwarderCargoAgentId(jsonObject, party);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }
    public void verifyOriginLocationMapping(String key) {
        JSONObject jsonObject = new JSONObject(response);
        switch (key) {
            case "code":
                verifyOriginLocationId(jsonObject);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }
    public void verifyFinalDestinationLocationMapping(String key) {
        JSONObject jsonObject = new JSONObject(response);
        switch (key) {
            case "code":
                verifyFinalDestinationLocationId(jsonObject);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

    public void verifySpecifiedLogisticsTransportMovementMapping(String keyRequest, String keyResponse) {
        JSONObject jsonObject = new JSONObject(response);
        if (keyRequest.equals("ArrivalEvent")){
            switch (keyResponse) {
                case "movementTimestamp":
                    verifyScheduledOccurrenceDateTime(jsonObject);
                    break;
                case "code":
                    verifyOccurrenceArrivalLocationID(jsonObject);
                    break;
                case "locationName":
                    verifyOccurrenceArrivalLocationName(jsonObject);
                    break;
                default:
                    throw new SkipStepException("there is no key");
            }
        } else if (keyRequest.equals("DepartureEvent")){
            throw new SkipStepException("there is no key");
        } else {
            switch (keyResponse) {
                case "transportIdentifier":
                    verifySpecifiedLogisticsTransportMovementID(jsonObject);
                    break;
                case "airlineCode":
                    verifyUsedLogisticsTransportMeans(jsonObject);
                    break;
                default:
                    throw new SkipStepException("there is no key");
            }
        }
    }
    public void verifyHandlingSPHInstructions(String key) {
        JSONObject jsonObject = new JSONObject(response);
        switch (key) {
            case "specialHandlingCodes":
                verifySpecialHandlingCodes(jsonObject);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }
    public void verifyTextualHandlingInstructions(String type, String key) {
        JSONObject jsonObject = new JSONObject(response);
        switch (key) {
            case "textualHandlingInstructions":
                verifyTextualHandlingInstructionsDescription(type, jsonObject);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }
    public void verifyAccountingInformationMapping(String key) {
        JSONObject jsonObject = new JSONObject(response);
        switch (key) {
            case "accountingInformation":
                verifyAccountingInformation(jsonObject);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }
    public void verifyCustomsInformationMapping(String key) {
        JSONObject jsonObject = new JSONObject(response);
        switch (key) {
            case "contentCode":
                verifyCustomsInformationContentCode(jsonObject);
                break;
            case "note":
                verifyCustomsInformationContent(jsonObject);
                break;
            case "subjectCode":
                verifyCustomsInformationSubjectCode(jsonObject);
                break;
            case "country":
                verifyCustomsInformationCountryID(jsonObject);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }
    public void verifyApplicableLogisticsAllowanceChargeMapping(String key) {
        JSONObject jsonObject = new JSONObject(response);
        switch (key) {
            case "otherChargeCode":
                verifyOtherChargesOtherChargeCode(jsonObject);
                break;
            case "chargePaymentType":
                verifyOtherChargesChargePaymentType(jsonObject);
                break;
            case "entitlement":
                verifyOtherChargesEntitlement(jsonObject);
                break;
            case "otherChargeAmount":
                verifyOtherChargesOtherChargeAmount(jsonObject);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }
    public void verifyIncludedMasterConsignmentItemMapping(String keyRequest, String childReq, String keyResponse) {
        JSONObject jsonObject = new JSONObject(response);
        switch (keyResponse) {
            case "grossWeightForRate":
                verifyIncludedMasterConsignmentItemGrossWeightForRate(jsonObject);
                break;
            case "volume":
                verifyIncludedMasterConsignmentItemGrossVolumeMeasure(jsonObject);
                break;
            case "pieceCountForRate":
                if (keyRequest.equals("PieceQuantity")) verifyIncludedMasterConsignmentItemPieceQuantity(jsonObject);
                else if (keyRequest.equals("TransportLogisticsPackage")) verifyTransportLogisticsPackageItemQuantity(jsonObject);
                break;
            case "goodsDescriptionForRate":
                verifyNatureIdentificationTransportCargoIdentification(jsonObject);
                break;
            case "width":
                verifyLinearSpatialDimensionWidthMeasure(jsonObject);
                break;
            case "length":
                verifyLinearSpatialDimensionLengthMeasure(jsonObject);
                break;
            case "height":
                verifyLinearSpatialDimensionHeightMeasure(jsonObject);
                break;
            case "rateClassCode":
                verifyApplicableFreightRateServiceChargeCategoryCode(jsonObject);
                break;
            case "chargeableWeightForRate":
                verifyApplicableFreightRateServiceChargeChargeableWeightMeasure(jsonObject);
                break;
            case "rateCharge":
                if (childReq.equals("AppliedRate")) verifyApplicableFreightRateServiceChargeAppliedRate(jsonObject);
                else if (childReq.equals("AppliedAmount")) verifyApplicableFreightRateServiceChargeAppliedAmount(jsonObject);
                break;
            default:
                throw new SkipStepException("there is no searched key");
        }
    }

}
