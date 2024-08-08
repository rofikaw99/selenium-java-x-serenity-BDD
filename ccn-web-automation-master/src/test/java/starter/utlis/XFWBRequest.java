package starter.utlis;

import io.cucumber.java.pt.Mas;
import io.cucumber.messages.JSON;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XFWBRequest {

    public static JSONObject Waybill(JSONObject jsonXml) {
        return jsonXml.getJSONObject("rsm:Waybill");
    }
    public static JSONObject BusinessHeaderDocument(JSONObject jsonXml) {
        return Waybill(jsonXml).getJSONObject("rsm:BusinessHeaderDocument");
    }
    public static String BHD_ID(JSONObject jsonXML) {
        return BusinessHeaderDocument(jsonXML).getString("ram:ID");
    }
    public static JSONObject BHD_IncludedHeaderNote(JSONObject jsonXML){
        return BusinessHeaderDocument(jsonXML).getJSONObject("ram:IncludedHeaderNote");
    }
    public static String IHN_ContentCode(JSONObject jsonObject){
        return BHD_IncludedHeaderNote(jsonObject).getString("ram:ContentCode");
    }
    public static String SCoA_Signatory(JSONObject jsonObject){
        return BusinessHeaderDocument(jsonObject).getJSONObject("ram:SignatoryConsignorAuthentication").getString("ram:Signatory");
    }
    public static JSONObject BHD_SCaA(JSONObject jsonObject){
        return BusinessHeaderDocument(jsonObject).getJSONObject("ram:SignatoryCarrierAuthentication");
    }
    public static String BHD_SCaA_ActualDateTime(JSONObject jsonObject){
        return BHD_SCaA(jsonObject).getString("ram:ActualDateTime") + ".000Z";
    }
    public static String BHD_SCaA_Signatory(JSONObject jsonObject){
        return BHD_SCaA(jsonObject).getString("ram:Signatory");
    }
    public static String IAL_Name(JSONObject jsonObject){
        return BHD_SCaA(jsonObject).getJSONObject("ram:IssueAuthenticationLocation").getString("ram:Name");
    }
    public static JSONObject MasterConsignment(JSONObject jsonObject){
        return Waybill(jsonObject).getJSONObject("rsm:MasterConsignment");
    }
    public static String NilCarriageValueIndicator(JSONObject jsonObject){
        return MasterConsignment(jsonObject).getString("ram:NilCarriageValueIndicator");
    }

    public static String NilCustomsValueIndicator(JSONObject jsonObject){
        return MasterConsignment(jsonObject).getString("ram:NilCustomsValueIndicator");
    }

    public static String NilInsuranceValueIndicator(JSONObject jsonObject){
        return MasterConsignment(jsonObject).getString("ram:NilInsuranceValueIndicator");
    }
    public static Boolean TotalChargePrepaidIndicator(JSONObject jsonObject){
        return MasterConsignment(jsonObject).getBoolean("ram:TotalChargePrepaidIndicator");
    }
    public static Boolean TotalDisbursementPrepaidIndicator(JSONObject jsonObject){
        return MasterConsignment(jsonObject).getBoolean("ram:TotalDisbursementPrepaidIndicator");
    }
    public static Map<String, Object> IncludedTareGrossWeightMeasure(JSONObject jsonObject){
        JSONObject IncludedTareGrossWeightMeasure = MasterConsignment(jsonObject)
                .getJSONObject("ram:IncludedTareGrossWeightMeasure");
        return Map.of("content", IncludedTareGrossWeightMeasure.getInt("content"),
                        "unitCode", IncludedTareGrossWeightMeasure.getString("unitCode"));
    }
    public static Map<String, Object> GrossVolumeMeasure(JSONObject jsonObject){
        JSONObject GrossVolumeMeasure = MasterConsignment(jsonObject)
                .getJSONObject("ram:GrossVolumeMeasure");
        return Map.of("content", GrossVolumeMeasure.getDouble("content"),
                        "unitCode", GrossVolumeMeasure.getString("unitCode"));
    }
    public static Integer TotalPieceQuantity(JSONObject jsonObject){
        return MasterConsignment(jsonObject).getInt("ram:TotalPieceQuantity");
    }
    public static JSONObject ConsignorParty(JSONObject jsonObject){
        return MasterConsignment(jsonObject).getJSONObject("ram:ConsignorParty");
    }
    public static String CoP_Name(JSONObject jsonObject){
        return ConsignorParty(jsonObject).getString("ram:Name");
    }
    public static JSONObject CoP_PostalStructuredAddress(JSONObject jsonObject){
        return ConsignorParty(jsonObject).getJSONObject("ram:PostalStructuredAddress");
    }
    public static Integer CoP_PSA_PostcodeCode(JSONObject jsonObject){
        return CoP_PostalStructuredAddress(jsonObject).getInt("ram:PostcodeCode");
    }
    public static String CoP_PSA_StreetName(JSONObject jsonObject){
        return CoP_PostalStructuredAddress(jsonObject).getString("ram:StreetName");
    }
    public static String CoP_PSA_CityName(JSONObject jsonObject){
        return CoP_PostalStructuredAddress(jsonObject).getString("ram:CityName");
    }
    public static String CoP_PSA_CountryID(JSONObject jsonObject){
        return CoP_PostalStructuredAddress(jsonObject).getString("ram:CountryID");
    }
    public static JSONObject ConsigneeParty(JSONObject jsonObject){
        return MasterConsignment(jsonObject).getJSONObject("ram:ConsigneeParty");
    }
    public static String CeP_Name(JSONObject jsonObject){
        return ConsigneeParty(jsonObject).getString("ram:Name");
    }
    public static JSONObject CeP_PostalStructuredAddress(JSONObject jsonObject){
        return ConsigneeParty(jsonObject).getJSONObject("ram:PostalStructuredAddress");
    }
    public static String CeP_PSA_PostcodeCode(JSONObject jsonObject){
        return CeP_PostalStructuredAddress(jsonObject).getString("ram:PostcodeCode");
    }
    public static String CeP_PSA_StreetName(JSONObject jsonObject){
        return CeP_PostalStructuredAddress(jsonObject).getString("ram:StreetName");
    }
    public static String CeP_PSA_CityName(JSONObject jsonObject){
        return CeP_PostalStructuredAddress(jsonObject).getString("ram:CityName");
    }
    public static String CeP_PSA_CountryID(JSONObject jsonObject){
        return CeP_PostalStructuredAddress(jsonObject).getString("ram:CountryID");
    }
    public static JSONObject FreightForwarderParty(JSONObject jsonObject){
        return MasterConsignment(jsonObject).getJSONObject("ram:FreightForwarderParty");
    }
    public static String FFP_Name(JSONObject jsonObject){
        return FreightForwarderParty(jsonObject).getString("ram:Name");
    }
    public static Integer FFP_CargoAgentID(JSONObject jsonObject){
        return FreightForwarderParty(jsonObject).getInt("ram:CargoAgentID");
    }
    public static JSONObject FFP_FreightForwarderAddress(JSONObject jsonObject){
        return FreightForwarderParty(jsonObject).getJSONObject("ram:FreightForwarderAddress");
    }
    public static String FFP_FFA_CityName(JSONObject jsonObject){
        return FFP_FreightForwarderAddress(jsonObject).getString("ram:CityName");
    }
    public static String FFP_SpecifiedCargoAgentLocation_ID(JSONObject jsonObject){
        return FreightForwarderParty(jsonObject).getJSONObject("ram:SpecifiedCargoAgentLocation").getString("ram:ID");
    }
    public static JSONObject OriginLocation(JSONObject jsonObject){
        return MasterConsignment(jsonObject).getJSONObject("ram:OriginLocation");
    }
    public static String OL_ID(JSONObject jsonObject){
        return OriginLocation(jsonObject).getString("ram:ID");
    }
    public static JSONObject FinalDestinationLocation(JSONObject jsonObject){
        return MasterConsignment(jsonObject).getJSONObject("ram:FinalDestinationLocation");
    }
    public static String FDL_ID(JSONObject jsonObject){
        return FinalDestinationLocation(jsonObject).getString("ram:ID");
    }
    public static JSONObject SpecifiedLogisticsTransportMovement(JSONObject jsonObject){
        return MasterConsignment(jsonObject).getJSONObject("ram:SpecifiedLogisticsTransportMovement");
    }
    public static String SLTM_ID(JSONObject jsonObject){
        return SpecifiedLogisticsTransportMovement(jsonObject).getString("ram:ID");
    }
    public static String SLTM_UsedLogisticsTransportMeans_Name(JSONObject jsonObject){
        return SpecifiedLogisticsTransportMovement(jsonObject)
                .getJSONObject("ram:UsedLogisticsTransportMeans")
                .getString("ram:Name");
    }
    public static JSONObject SLTM_ArrivalEvent(JSONObject jsonObject){
        return SpecifiedLogisticsTransportMovement(jsonObject)
                .getJSONObject("ram:ArrivalEvent");
    }
    public static String SLTM_AE_ScheduledOccurrenceDateTime(JSONObject jsonObject){
        return SLTM_ArrivalEvent(jsonObject).getString("ram:ScheduledOccurrenceDateTime") + ".000Z";
    }
    public static JSONObject SLTM_AE_OccurrenceArrivalLocation(JSONObject jsonObject){
        return SLTM_ArrivalEvent(jsonObject).getJSONObject("ram:OccurrenceArrivalLocation");
    }
    public static String SLTM_AE_OAL_ID(JSONObject jsonObject){
        return SLTM_AE_OccurrenceArrivalLocation(jsonObject).getString("ram:ID");
    }
    public static String SLTM_AE_OAL_Name(JSONObject jsonObject){
        return SLTM_AE_OccurrenceArrivalLocation(jsonObject).getString("ram:Name");
    }
    public static JSONObject SLTM_DepartureEvent(JSONObject jsonObject){
        return SpecifiedLogisticsTransportMovement(jsonObject)
                .getJSONObject("ram:DepartureEvent");
    }
    public static String SLTM_DE_ScheduledOccurrenceDateTime(JSONObject jsonObject){
        return SpecifiedLogisticsTransportMovement(jsonObject)
                .getString("ram:ScheduledOccurrenceDateTime");
    }
    public static List<String> HandlingSPHInstructions(JSONObject jsonObject){
        JSONArray arr = MasterConsignment(jsonObject)
                .getJSONArray("ram:HandlingSPHInstructions");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            JSONObject js = arr.getJSONObject(i);
            result.add(js.getString("ram:DescriptionCode"));
        }
        return result;
    }
    public static JSONObject HandlingSSRInstructions(JSONObject jsonObject){
        return MasterConsignment(jsonObject)
                .getJSONObject("ram:HandlingSSRInstructions");
    }
    public static List<String> HSSRI_Description(String type, JSONObject jsonObject){
        return List.of(type + "-" + HandlingSSRInstructions(jsonObject).getString("ram:Description"));
    }
    public static String IncludedAccountingNote(JSONObject jsonObject){
        JSONObject includedAccountingNote = MasterConsignment(jsonObject).getJSONObject("ram:IncludedAccountingNote");
        return includedAccountingNote.getString("ram:ContentCode") + "-" + includedAccountingNote.getString("ram:Content");
    }
    public static JSONArray IncludedCustomsNote(JSONObject jsonObject){
        return MasterConsignment(jsonObject).getJSONArray("ram:IncludedCustomsNote");
    }
    public static List<String> ICN_ContentCode(JSONObject jsonObject){
        List<String> result = new ArrayList<>();
        JSONArray arr = IncludedCustomsNote(jsonObject);
        for (int i = 0; i < arr.length(); i++){
            result.add(arr.getJSONObject(i).getString("ram:ContentCode"));
        }
        return result;
    }
    public static List<String> ICN_Content(JSONObject jsonObject){
        List<String> result = new ArrayList<>();
        JSONArray arr = IncludedCustomsNote(jsonObject);
        for (int i = 0; i < arr.length(); i++){
            result.add(arr.getJSONObject(i).getString("ram:Content"));
        }
        return result;
    }
    public static List<String> ICN_SubjectCode(JSONObject jsonObject){
        List<String> result = new ArrayList<>();
        JSONArray arr = IncludedCustomsNote(jsonObject);
        for (int i = 0; i < arr.length(); i++){
            if (arr.getJSONObject(i).has("ram:SubjectCode")) result.add(arr.getJSONObject(i).getString("ram:SubjectCode"));
        }
        return result;
    }
    public static List<String> ICN_CountryID(JSONObject jsonObject){
        List<String> result = new ArrayList<>();
        JSONArray arr = IncludedCustomsNote(jsonObject);
        for (int i = 0; i < arr.length(); i++){
            if (arr.getJSONObject(i).has("ram:CountryID")) result.add(arr.getJSONObject(i).getString("ram:CountryID"));
        }
        return result;
    }
    public static String ApplicableOriginCurrencyExchange_SourceCurrencyCode(JSONObject jsonObject){
        return MasterConsignment(jsonObject)
                .getJSONObject("ram:ApplicableOriginCurrencyExchange")
                .getString("ram:SourceCurrencyCode");
    }
    public static JSONArray ApplicableLogisticsAllowanceCharge(JSONObject jsonObject){
        return MasterConsignment(jsonObject).getJSONArray("ram:ApplicableLogisticsAllowanceCharge");
    }
    public static List<String> ALLC_ID(JSONObject jsonObject){
        JSONArray arr = ApplicableLogisticsAllowanceCharge(jsonObject);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            result.add(arr.getJSONObject(i).getString("ram:ID"));
        }
        return result;
    }
    public static List<String> ALLC_PrepaidIndicator(JSONObject jsonObject){
        JSONArray arr = ApplicableLogisticsAllowanceCharge(jsonObject);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            if(arr.getJSONObject(i).getBoolean("ram:PrepaidIndicator"))
                result.add("P");
        }
        return result;
    }
    public static List<String> ALLC_PartyTypeCode(JSONObject jsonObject){
        JSONArray arr = ApplicableLogisticsAllowanceCharge(jsonObject);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            result.add(arr.getJSONObject(i).getString("ram:PartyTypeCode"));
        }
        return result;
    }
    public static Map<String, List<Object>> ALLC_ActualAmount(JSONObject jsonObject){
        JSONArray arr = ApplicableLogisticsAllowanceCharge(jsonObject);
        List<Object> content = new ArrayList<>();
        List<Object> currencyID = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            JSONObject am = arr.getJSONObject(i).getJSONObject("ram:ActualAmount");
            content.add(am.getInt("content"));
            currencyID.add(am.getString("currencyID"));
        }
        return Map.of("content", content, "currencyID", currencyID);
    }
    public static JSONObject ApplicableRating(JSONObject jsonObject){
        return MasterConsignment(jsonObject).getJSONObject("ram:ApplicableRating");
    }
    public static String AR_TypeCode(JSONObject jsonObject){
        return ApplicableRating(jsonObject).getString("ram:TypeCode");
    }
    public static JSONArray AR_IncludedMasterConsignmentItem(JSONObject jsonObject){
        return ApplicableRating(jsonObject).getJSONArray("ram:IncludedMasterConsignmentItem");
    }
    public static List<Object> AR_IMCI_SequenceNumeric(JSONObject jsonObject){
        JSONArray arr = AR_IncludedMasterConsignmentItem(jsonObject);
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            result.add(arr.getJSONObject(i).getString("ram:SequenceNumeric"));
        }
        return result;
    }
    public static Map<String, List<Object>> AR_IMCI_GrossWeightMeasure(JSONObject jsonObject){
        JSONArray arr = AR_IncludedMasterConsignmentItem(jsonObject);
        List<Object> content = new ArrayList<>();
        List<Object> unitCode = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            if (arr.getJSONObject(i).has("ram:GrossWeightMeasure")) {
                JSONObject am = arr.getJSONObject(i).getJSONObject("ram:GrossWeightMeasure");
                content.add(am.getInt("content"));
                unitCode.add(am.getString("unitCode"));
            }
        }
        return Map.of("content", content, "unitCode", unitCode);
    }
    public static Map<String, List<Object>> AR_IMCI_GrossVolumeMeasure(JSONObject jsonObject){
        JSONArray arr = AR_IncludedMasterConsignmentItem(jsonObject);
        List<Object> content = new ArrayList<>();
        List<Object> unitCode = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            if (arr.getJSONObject(i).has("ram:GrossVolumeMeasure")) {
                JSONObject am = arr.getJSONObject(i).getJSONObject("ram:GrossVolumeMeasure");
                content.add(am.getInt("content"));
                unitCode.add(am.getString("unitCode"));
            }
        }
        return Map.of("content", content, "unitCode", unitCode);
    }
    public static List<Object> AR_IMCI_PieceQuantity(JSONObject jsonObject){
        JSONArray arr = AR_IncludedMasterConsignmentItem(jsonObject);
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            if (arr.getJSONObject(i).has("ram:PieceQuantity")) result.add(arr.getJSONObject(i).getInt("ram:PieceQuantity"));
        }
        return result;
    }
    public static List<Object> AR_IMCI_NatureIdentificationTransportCargo_Identification(JSONObject jsonObject){
        JSONArray arr = AR_IncludedMasterConsignmentItem(jsonObject);
        List<Object> result = new ArrayList<>();
        String parse = "";
        for (int i = 0; i < arr.length(); i++){
            if (arr.getJSONObject(i).has("ram:NatureIdentificationTransportCargo")) {
                if (i == 0) parse = arr.getJSONObject(i).getJSONObject("ram:NatureIdentificationTransportCargo")
                        .getString("ram:Identification");
                else parse = parse + "  " + arr.getJSONObject(i).getJSONObject("ram:NatureIdentificationTransportCargo")
                            .getString("ram:Identification");
            }
        }
        result.add(parse);
        return result;
    }
    public static List<JSONObject> AR_IMCI_TransportLogisticsPackage(JSONObject jsonObject){
        JSONArray arr = AR_IncludedMasterConsignmentItem(jsonObject);
        List<JSONObject> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            if (arr.getJSONObject(i).has("ram:TransportLogisticsPackage")) result.add(arr.getJSONObject(i).getJSONObject("ram:TransportLogisticsPackage"));
        }
        return result;
    }
    public static List<Object> AR_IMCI_TLP_ItemQuantity(JSONObject jsonObject){
        List<JSONObject> arr = AR_IMCI_TransportLogisticsPackage(jsonObject);
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++){
            result.add(arr.get(i).getInt("ram:ItemQuantity"));
        }
        return result;
    }
    public static List<JSONObject> AR_IMCI_TLP_LinearSpatialDimension(JSONObject jsonObject){
        List<JSONObject> arr = AR_IMCI_TransportLogisticsPackage(jsonObject);
        List<JSONObject> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++){
            result.add(arr.get(i).getJSONObject("ram:LinearSpatialDimension"));
        }
        return result;
    }
    public static Map<String, List<Object>> AR_IMCI_TLP_LSD_WidthMeasure(JSONObject jsonObject){
        List<JSONObject> arr = AR_IMCI_TLP_LinearSpatialDimension(jsonObject);
        List<Object> content = new ArrayList<>();
        List<Object> unitCode = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++){
            JSONObject am = arr.get(i).getJSONObject("ram:WidthMeasure");
            content.add(am.getInt("content"));
            unitCode.add(am.getString("unitCode"));
        }
        return Map.of("content", content, "unitCode", unitCode);
    }
    public static Map<String, List<Object>> AR_IMCI_TLP_LSD_LengthMeasure(JSONObject jsonObject){
        List<JSONObject> arr = AR_IMCI_TLP_LinearSpatialDimension(jsonObject);
        List<Object> content = new ArrayList<>();
        List<Object> unitCode = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++){
            JSONObject am = arr.get(i).getJSONObject("ram:LengthMeasure");
            content.add(am.getInt("content"));
            unitCode.add(am.getString("unitCode"));
        }
        return Map.of("content", content, "unitCode", unitCode);
    }
    public static Map<String, List<Object>> AR_IMCI_TLP_LSD_HeightMeasure(JSONObject jsonObject){
        List<JSONObject> arr = AR_IMCI_TLP_LinearSpatialDimension(jsonObject);
        List<Object> content = new ArrayList<>();
        List<Object> unitCode = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++){
            JSONObject am = arr.get(i).getJSONObject("ram:HeightMeasure");
            content.add(am.getInt("content"));
            unitCode.add(am.getString("unitCode"));
        }
        return Map.of("content", content, "unitCode", unitCode);
    }
    public static List<JSONObject> AR_IMCI_ApplicableFreightRateServiceCharge(JSONObject jsonObject){
        JSONArray arr = AR_IncludedMasterConsignmentItem(jsonObject);
        List<JSONObject> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            if (arr.getJSONObject(i).has("ram:ApplicableFreightRateServiceCharge")) result.add(arr.getJSONObject(i).getJSONObject("ram:ApplicableFreightRateServiceCharge"));
        }
        return result;
    }
    public static List<Object> AR_IMCI_AFRSC_CategoryCode(JSONObject jsonObject){
        List<JSONObject> arr = AR_IMCI_ApplicableFreightRateServiceCharge(jsonObject);
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++){
            result.add(arr.get(i).getString("ram:CategoryCode"));
        }
        return result;
    }
    public static Map<String, List<Object>> AR_IMCI_AFRSC_ChargeableWeightMeasure(JSONObject jsonObject){
        List<JSONObject> arr = AR_IMCI_ApplicableFreightRateServiceCharge(jsonObject);
        List<Object> content = new ArrayList<>();
        List<Object> unitCode = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++){
            JSONObject am = arr.get(i).getJSONObject("ram:ChargeableWeightMeasure");
            content.add(am.getInt("content"));
            unitCode.add(am.getString("unitCode"));
        }
        return Map.of("content", content, "unitCode", unitCode);
    }
    public static List<Object> AR_IMCI_AFRSC_AppliedRate(JSONObject jsonObject){
        List<JSONObject> arr = AR_IMCI_ApplicableFreightRateServiceCharge(jsonObject);
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++){
            result.add(arr.get(i).getInt("ram:AppliedRate"));
        }
        return result;
    }
    public static Map<String, List<Object>> AR_IMCI_AFRSC_AppliedAmount(JSONObject jsonObject){
        List<JSONObject> arr = AR_IMCI_ApplicableFreightRateServiceCharge(jsonObject);
        List<Object> content = new ArrayList<>();
        List<Object> currencyID = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++){
            if (arr.get(i).has("ram:AppliedAmount"))
            {
                JSONObject am = arr.get(i).getJSONObject("ram:AppliedAmount");
                content.add(am.getInt("content"));
                currencyID.add(am.getString("currencyID"));
            }
        }
        return Map.of("content", content, "unitCode", currencyID);
    }
}