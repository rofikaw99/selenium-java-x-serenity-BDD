package starter.utlis.onerecord;

import net.serenitybdd.core.SkipStepException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XFZBRequest {
    public static JSONObject HouseWaybill(JSONObject jsonXml) {
        return jsonXml.getJSONObject("rsm:HouseWaybill");
    }

    public static JSONObject MessageHeaderDocument(JSONObject jsonXml){
        return HouseWaybill(jsonXml).getJSONObject("rsm:MessageHeaderDocument");
    }

    public static String MHD_ID(JSONObject jsonXml){
        return MessageHeaderDocument(jsonXml).getString("ram:ID");
    }

    public static String MHD_Name(JSONObject jsonXml){
        return MessageHeaderDocument(jsonXml).getString("ram:Name");
    }

    public static String MHD_TypeCode(JSONObject jsonXml){
        return MessageHeaderDocument(jsonXml).getString("ram:TypeCode");
    }

    public static String MHD_IssueDateTime(JSONObject jsonXml){
        return MessageHeaderDocument(jsonXml).getString("ram:IssueDateTime");
    }

    public static String MHD_PurposeCode(JSONObject jsonXml){
        return MessageHeaderDocument(jsonXml).getString("ram:PurposeCode");
    }

    public static String MHD_VersionID(JSONObject jsonXml){
        return MessageHeaderDocument(jsonXml).getString("ram:VersionID");
    }

    public static String MHD_ConversationID(JSONObject jsonXml){
        return MessageHeaderDocument(jsonXml).getString("ram:ConversationID");
    }

    public static JSONObject MHD_SenderParty(JSONObject jsonXml){
        return MessageHeaderDocument(jsonXml).getJSONObject("ram:SenderParty");
    }

    public static JSONObject MHD_SenderParty_PrimaryID(JSONObject jsonXml){
        return MHD_SenderParty(jsonXml).getJSONObject("ram:PrimaryID");
    }

    public static JSONObject MHD_RecipientParty(JSONObject jsonXml){
        return MessageHeaderDocument(jsonXml).getJSONObject("ram:RecipientParty");
    }

    public static JSONObject MHD_RecipientParty_PrimaryID(JSONObject jsonXml){
        return MHD_RecipientParty(jsonXml).getJSONObject("ram:PrimaryID");
    }

    public static JSONObject BusinessHeaderDocument(JSONObject jsonXml){
        return HouseWaybill(jsonXml).getJSONObject("rsm:BusinessHeaderDocument");
    }

    public static String BHD_ID(JSONObject jsonXml){
        return BusinessHeaderDocument(jsonXml).getString("ram:ID");
    }

    public static JSONObject BHD_SignatoryConsignorAuthentication(JSONObject jsonXml){
        return BusinessHeaderDocument(jsonXml).getJSONObject("ram:SignatoryConsignorAuthentication");
    }

    public static String BHD_SCoA_Signatory(JSONObject jsonXml){
        return BHD_SignatoryConsignorAuthentication(jsonXml).getString("ram:Signatory");
    }

    public static JSONObject BHD_SignatoryCarrierAuthentication(JSONObject jsonXml){
        return BusinessHeaderDocument(jsonXml).getJSONObject("ram:SignatoryCarrierAuthentication");
    }

    public static String BHD_SCaA_ActualDateTime(JSONObject jsonXml){
        return BHD_SignatoryCarrierAuthentication(jsonXml).getString("ram:ActualDateTime");
    }

    public static String BHD_SCaA_Signatory(JSONObject jsonXml){
        return BHD_SignatoryCarrierAuthentication(jsonXml).getString("ram:Signatory");
    }

    public static JSONObject BHD_SCaA_IssueAuthenticationLocation(JSONObject jsonXml){
        return BHD_SignatoryCarrierAuthentication(jsonXml).getJSONObject("ram:IssueAuthenticationLocation");
    }

    public static String BHD_SCaA_IAL_Name(JSONObject jsonXml){
        return BHD_SCaA_IssueAuthenticationLocation(jsonXml).getString("ram:Name");
    }

    public static JSONObject MasterConsignment(JSONObject jsonXml){
        return HouseWaybill(jsonXml).getJSONObject("rsm:MasterConsignment");
    }

    public static String MC_IncludedTareGrossWeightMeasure(JSONObject jsonXml){
        return MasterConsignment(jsonXml).getString("ram:IncludedTareGrossWeightMeasure");
    }

    public static Integer MC_TotalPieceQuantity(JSONObject jsonXml){
        return MasterConsignment(jsonXml).getInt("ram:TotalPieceQuantity");
    }

    public static JSONObject MC_TransportContractDocument(JSONObject jsonXml){
        return MasterConsignment(jsonXml).getJSONObject("ram:TransportContractDocument");
    }

    public static String MC_TCD_ID(JSONObject jsonXml){
        return MC_TransportContractDocument(jsonXml).getString("ram:ID");
    }

    public static JSONObject MC_OriginLocation(JSONObject jsonXml){
        return MasterConsignment(jsonXml).getJSONObject("ram:OriginLocation");
    }

    public static String MC_OL_ID(JSONObject jsonXml){
        return MC_OriginLocation(jsonXml).getString("ram:ID");
    }

    public static JSONObject MC_FinalDestinationLocation(JSONObject jsonXml){
        return MasterConsignment(jsonXml).getJSONObject("ram:FinalDestinationLocation");
    }

    public static String MC_FDL_ID(JSONObject jsonXml){
        return MC_FinalDestinationLocation(jsonXml).getString("ram:ID");
    }

    public static JSONObject MC_IncludedHouseConsignment(JSONObject jsonXml){
        return MasterConsignment(jsonXml).getJSONObject("ram:IncludedHouseConsignment");
    }

    public static Boolean MC_IHC_NilCarriageValueIndicator(JSONObject jsonXml){
        String key = "ram:NilCarriageValueIndicator";
        if (MC_IncludedHouseConsignment(jsonXml).optBoolean(key)) {
            return MC_IncludedHouseConsignment(jsonXml).getBoolean(key);
        } else return false;
    }

    public static Boolean MC_IHC_NilCustomsValueIndicator(JSONObject jsonXml){
        String key = "ram:NilCustomsValueIndicator";
        if (MC_IncludedHouseConsignment(jsonXml).optBoolean(key)) {
            return MC_IncludedHouseConsignment(jsonXml).getBoolean(key);
        } else return false;
    }

    public static Map<String, Object> MC_IHC_DeclaredValueForCarriageAmount (JSONObject jsonXml){
        String key = "ram:DeclaredValueForCarriageAmount ";
        if (MC_IncludedHouseConsignment(jsonXml).has(key)) {
            JSONObject DeclaredValueForCarriageAmount = MasterConsignment(jsonXml)
                    .getJSONObject(key);
            return Map.of("content", DeclaredValueForCarriageAmount.getFloat("content"),
                    "currencyID", DeclaredValueForCarriageAmount.getString("currencyID"));
        } else throw new SkipStepException("there is no  "+ key +" in request");
    }

    public static Map<String, Object> MC_IHC_DeclaredValueForCustoms (JSONObject jsonXml){
        String key = "ram:declaredValueForCustomsAmount ";
        if (MC_IncludedHouseConsignment(jsonXml).has(key)) {
            JSONObject DeclaredValueForCustomsAmount = MasterConsignment(jsonXml)
                    .getJSONObject(key);
            return Map.of("content", DeclaredValueForCustomsAmount.getFloat("content"),
                    "currencyID", DeclaredValueForCustomsAmount.getString("currencyID"));
        } else throw new SkipStepException("there is no  "+ key +" in request");
    }

    public static Boolean MC_IHC_NilInsuranceValueIndicator(JSONObject jsonXml){
        String key = "ram:NilInsuranceValueIndicator";
        if (MC_IncludedHouseConsignment(jsonXml).optBoolean(key)) {
            return MC_IncludedHouseConsignment(jsonXml).getBoolean(key);
        } else return false;
    }

    public static Map<String, Object> MC_IHC_InsuranceValueAmount (JSONObject jsonXml){
        String key = "ram:insuranceValueAmount ";
        if (MC_IncludedHouseConsignment(jsonXml).has(key)) {
            JSONObject InsuranceValueAmount = MasterConsignment(jsonXml)
                    .getJSONObject(key);
            return Map.of("content", InsuranceValueAmount.getFloat("content"),
                    "currencyID", InsuranceValueAmount.getString("currencyID"));
        } else throw new SkipStepException("there is no  "+ key +" in request");
    }

    public static Boolean MC_IHC_TotalChargePrepaidIndicator(JSONObject jsonXml){
        return MC_IncludedHouseConsignment(jsonXml).getBoolean("ram:TotalChargePrepaidIndicator");
    }

    public static Boolean MC_IHC_TotalDisbursementPrepaidIndicator(JSONObject jsonXml){
        return MC_IncludedHouseConsignment(jsonXml).getBoolean("ram:TotalDisbursementPrepaidIndicator");
    }

    public static Map<String, Object> MC_IHC_IncludedTareGrossWeightMeasure(JSONObject jsonXml){
        String key = "ram:IncludedTareGrossWeightMeasure";
        if (MC_IncludedHouseConsignment(jsonXml).has(key)) {
            JSONObject GrossWeightMeasure = MasterConsignment(jsonXml)
                    .getJSONObject(key);
            return Map.of("content", GrossWeightMeasure.getFloat("content"),
                    "unitCode", GrossWeightMeasure.getString("unitCode"));
        } else throw new SkipStepException("there is no  "+ key +" in request");
    }

    public static Integer MC_IHC_PackageQuantity(JSONObject jsonXml){
        return MC_IncludedHouseConsignment(jsonXml).getInt("ram:PackageQuantity");
    }

    public static Integer MC_IHC_TotalPieceQuantity(JSONObject jsonXml){
        return MC_IncludedHouseConsignment(jsonXml).getInt("ram:TotalPieceQuantity");
    }

    public static List<String> MC_IHC_SummaryDescription(JSONObject jsonXml){
        return List.of(MC_IncludedHouseConsignment(jsonXml).getString("ram:SummaryDescription"));
    }

    public static JSONObject MC_IHC_ConsignorParty(JSONObject jsonXml){
        return MC_IncludedHouseConsignment(jsonXml).getJSONObject("ram:ConsignorParty");
    }

    public static String MC_IHC_CoP_Name(JSONObject jsonXml){
        return MC_IHC_ConsignorParty(jsonXml).getString("ram:Name");
    }

    public static JSONObject MC_IHC_CoP_PostalStructuredAddress(JSONObject jsonXml){
        return MC_IHC_ConsignorParty(jsonXml).getJSONObject("ram:PostalStructuredAddress");
    }

    public static String MC_IHC_CoP_PSA_PostcodeCode(JSONObject jsonXml){
        return String.valueOf(MC_IHC_CoP_PostalStructuredAddress(jsonXml).get("ram:PostcodeCode"));
    }

    public static String MC_IHC_CoP_PSA_StreetName(JSONObject jsonXml){
        return MC_IHC_CoP_PostalStructuredAddress(jsonXml).getString("ram:StreetName");
    }

    public static String MC_IHC_CoP_PSA_CityName(JSONObject jsonXml){
        return MC_IHC_CoP_PostalStructuredAddress(jsonXml).getString("ram:CityName");
    }

    public static String MC_IHC_CoP_PSA_CountryID(JSONObject jsonXml){
        return MC_IHC_CoP_PostalStructuredAddress(jsonXml).getString("ram:CountryID");
    }

    public static String MC_IHC_CoP_PSA_PostOfficeBox(JSONObject jsonXml){
        String key = "ram:PostOfficeBox";
        if (MC_IHC_CoP_PostalStructuredAddress(jsonXml).has(key))
            return MC_IHC_CoP_PostalStructuredAddress(jsonXml).getString("ram:PostOfficeBox");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static String MC_IHC_CoP_PSA_CityID(JSONObject jsonXml){
        String key = "ram:CityID";
        if (MC_IHC_CoP_PostalStructuredAddress(jsonXml).has(key))
            return MC_IHC_CoP_PostalStructuredAddress(jsonXml).getString("ram:CityID");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static String MC_IHC_CoP_PSA_CountrySubDivisionName(JSONObject jsonXml){
        String key = "ram:CountrySubDivisionName";
        if (MC_IHC_CoP_PostalStructuredAddress(jsonXml).has(key))
            return MC_IHC_CoP_PostalStructuredAddress(jsonXml).getString("ram:CountrySubDivisionName");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static String MC_IHC_CoP_PSA_CountrySubDivisionID(JSONObject jsonXml){
        String key = "ram:CountrySubDivisionID";
        if (MC_IHC_CoP_PostalStructuredAddress(jsonXml).has(key))
            return MC_IHC_CoP_PostalStructuredAddress(jsonXml).getString("ram:CountrySubDivisionID");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static JSONObject MC_IHC_ConsigneeParty(JSONObject jsonXml){
        return MC_IncludedHouseConsignment(jsonXml).getJSONObject("ram:ConsigneeParty");
    }

    public static String MC_IHC_CeP_Name(JSONObject jsonXml){
        return MC_IHC_ConsigneeParty(jsonXml).getString("ram:Name");
    }

    public static JSONObject MC_IHC_CeP_PostalStructuredAddress(JSONObject jsonXml){
        return MC_IHC_ConsigneeParty(jsonXml).getJSONObject("ram:PostalStructuredAddress");
    }

    public static String MC_IHC_CeP_PSA_PostcodeCode(JSONObject jsonXml){
        return String.valueOf(MC_IHC_CeP_PostalStructuredAddress(jsonXml).get("ram:PostcodeCode"));
    }

    public static String MC_IHC_CeP_PSA_StreetName(JSONObject jsonXml){
        return MC_IHC_CeP_PostalStructuredAddress(jsonXml).getString("ram:StreetName");
    }

    public static String MC_IHC_CeP_PSA_CityName(JSONObject jsonXml){
        return MC_IHC_CeP_PostalStructuredAddress(jsonXml).getString("ram:CityName");
    }

    public static String MC_IHC_CeP_PSA_CountryID(JSONObject jsonXml){
        return MC_IHC_CeP_PostalStructuredAddress(jsonXml).getString("ram:CountryID");
    }

    public static String MC_IHC_CeP_PSA_PostOfficeBox(JSONObject jsonXml){
        String key = "ram:PostOfficeBox";
        if (MC_IHC_CeP_PostalStructuredAddress(jsonXml).has(key))
            return MC_IHC_CeP_PostalStructuredAddress(jsonXml).getString("ram:PostOfficeBox");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static String MC_IHC_CeP_PSA_CityID(JSONObject jsonXml){
        String key = "ram:CityID";
        if (MC_IHC_CeP_PostalStructuredAddress(jsonXml).has(key))
            return MC_IHC_CeP_PostalStructuredAddress(jsonXml).getString("ram:CityID");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static String MC_IHC_CeP_PSA_CountrySubDivisionName(JSONObject jsonXml){
        String key = "ram:CountrySubDivisionName";
        if (MC_IHC_CeP_PostalStructuredAddress(jsonXml).has(key))
            return MC_IHC_CeP_PostalStructuredAddress(jsonXml).getString("ram:CountrySubDivisionName");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static String MC_IHC_CeP_PSA_CountrySubDivisionID(JSONObject jsonXml){
        String key = "ram:CountrySubDivisionID";
        if (MC_IHC_CeP_PostalStructuredAddress(jsonXml).has(key))
            return MC_IHC_CeP_PostalStructuredAddress(jsonXml).getString("ram:CountrySubDivisionID");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static JSONObject MC_IHC_FreightForwarderParty(JSONObject jsonXml){
        return MC_IncludedHouseConsignment(jsonXml).getJSONObject("ram:FreightForwarderParty");
    }

    public static String MC_IHC_FFP_Name(JSONObject jsonXml){
        return MC_IHC_FreightForwarderParty(jsonXml).getString("ram:Name");
    }

    public static JSONObject MC_IHC_FFP_PostalStructuredAddress(JSONObject jsonXml){
        return MC_IHC_FreightForwarderParty(jsonXml).getJSONObject("ram:PostalStructuredAddress");
    }

    public static String MC_IHC_FFP_PSA_PostcodeCode(JSONObject jsonXml){
        return String.valueOf(MC_IHC_FFP_PostalStructuredAddress(jsonXml).get("ram:PostcodeCode"));
    }

    public static String MC_IHC_FFP_PSA_StreetName(JSONObject jsonXml){
        return MC_IHC_FFP_PostalStructuredAddress(jsonXml).getString("ram:StreetName");
    }

    public static String MC_IHC_FFP_PSA_CityName(JSONObject jsonXml){
        return MC_IHC_FFP_PostalStructuredAddress(jsonXml).getString("ram:CityName");
    }

    public static String MC_IHC_FFP_PSA_CountryID(JSONObject jsonXml){
        return MC_IHC_FFP_PostalStructuredAddress(jsonXml).getString("ram:CountryID");
    }

    public static String MC_IHC_FFP_PSA_PostOfficeBox(JSONObject jsonXml){
        String key = "ram:PostOfficeBox";
        if (MC_IHC_FFP_PostalStructuredAddress(jsonXml).has(key))
            return MC_IHC_FFP_PostalStructuredAddress(jsonXml).getString("ram:PostOfficeBox");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static String MC_IHC_FFP_PSA_CityID(JSONObject jsonXml){
        String key = "ram:CityID";
        if (MC_IHC_FFP_PostalStructuredAddress(jsonXml).has(key))
            return MC_IHC_FFP_PostalStructuredAddress(jsonXml).getString("ram:CityID");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static String MC_IHC_FFP_PSA_CountrySubDivisionName(JSONObject jsonXml){
        String key = "ram:CountrySubDivisionName";
        if (MC_IHC_FFP_PostalStructuredAddress(jsonXml).has(key))
            return MC_IHC_FFP_PostalStructuredAddress(jsonXml).getString("ram:CountrySubDivisionName");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static String MC_IHC_FFP_PSA_CountrySubDivisionID(JSONObject jsonXml){
        String key = "ram:CountrySubDivisionID";
        if (MC_IHC_FFP_PostalStructuredAddress(jsonXml).has(key))
            return MC_IHC_FFP_PostalStructuredAddress(jsonXml).getString("ram:CountrySubDivisionID");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static JSONObject MC_IHC_NotifyParty(JSONObject jsonXml){
        return MC_IncludedHouseConsignment(jsonXml).getJSONObject("ram:NotifyParty");
    }

    public static String MC_IHC_NP_Name(JSONObject jsonXml){
        return MC_IHC_NotifyParty(jsonXml).getString("ram:Name");
    }

    public static JSONObject MC_IHC_NP_PostalStructuredAddress(JSONObject jsonXml){
        return MC_IHC_NotifyParty(jsonXml).getJSONObject("ram:PostalStructuredAddress");
    }

    public static String MC_IHC_NP_PSA_PostcodeCode(JSONObject jsonXml){
        return String.valueOf(MC_IHC_NP_PostalStructuredAddress(jsonXml).get("ram:PostcodeCode"));
    }

    public static String MC_IHC_NP_PSA_StreetName(JSONObject jsonXml){
        return MC_IHC_NP_PostalStructuredAddress(jsonXml).getString("ram:StreetName");
    }

    public static String MC_IHC_NP_PSA_CityName(JSONObject jsonXml){
        return MC_IHC_NP_PostalStructuredAddress(jsonXml).getString("ram:CityName");
    }

    public static String MC_IHC_NP_PSA_CountryID(JSONObject jsonXml){
        return MC_IHC_NP_PostalStructuredAddress(jsonXml).getString("ram:CountryID");
    }

    public static String MC_IHC_NP_PSA_PostOfficeBox(JSONObject jsonXml){
        String key = "ram:PostOfficeBox";
        if (MC_IHC_NP_PostalStructuredAddress(jsonXml).has(key))
            return MC_IHC_NP_PostalStructuredAddress(jsonXml).getString("ram:PostOfficeBox");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static String MC_IHC_NP_PSA_CityID(JSONObject jsonXml){
        String key = "ram:CityID";
        if (MC_IHC_NP_PostalStructuredAddress(jsonXml).has(key))
            return MC_IHC_NP_PostalStructuredAddress(jsonXml).getString("ram:CityID");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static String MC_IHC_NP_PSA_CountrySubDivisionName(JSONObject jsonXml){
        String key = "ram:CountrySubDivisionName";
        if (MC_IHC_NP_PostalStructuredAddress(jsonXml).has(key))
            return MC_IHC_NP_PostalStructuredAddress(jsonXml).getString("ram:CountrySubDivisionName");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static String MC_IHC_NP_PSA_CountrySubDivisionID(JSONObject jsonXml){
        String key = "ram:CountrySubDivisionID";
        if (MC_IHC_NP_PostalStructuredAddress(jsonXml).has(key))
            return MC_IHC_NP_PostalStructuredAddress(jsonXml).getString("ram:CountrySubDivisionID");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static JSONObject MC_IHC_OriginLocation(JSONObject jsonXml){
        return MC_IncludedHouseConsignment(jsonXml).getJSONObject("ram:OriginLocation");
    }

    public static String MC_IHC_OL_ID(JSONObject jsonXml){
        return MC_IHC_OriginLocation(jsonXml).getString("ram:ID");
    }

    public static String MC_IHC_OL_Name(JSONObject jsonXml){
        String key = "ram:Name";
        if (MC_IHC_OriginLocation(jsonXml).has(key)) return MC_IHC_OriginLocation(jsonXml).getString("ram:Name");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static JSONObject MC_IHC_FinalDestinationLocation(JSONObject jsonXml){
        return MC_IncludedHouseConsignment(jsonXml).getJSONObject("ram:FinalDestinationLocation");
    }

    public static String MC_IHC_FDL_ID(JSONObject jsonXml){
        return MC_IHC_FinalDestinationLocation(jsonXml).getString("ram:ID");
    }

    public static String MC_IHC_FDL_Name(JSONObject jsonXml){
        String key = "ram:Name";
        if (MC_IHC_FinalDestinationLocation(jsonXml).has(key)) return MC_IHC_FinalDestinationLocation(jsonXml).getString("ram:Name");
        else throw new SkipStepException("key " + key + " doesn't exist in the XML");
    }

    public static JSONObject MC_IHC_ApplicableOriginCurrencyExchange(JSONObject jsonXml){
        return MC_IncludedHouseConsignment(jsonXml).getJSONObject("ram:ApplicableOriginCurrencyExchange");
    }

    public static String MC_IHC_AOCE_SourceCurrencyCode(JSONObject jsonXml){
        return MC_IHC_ApplicableOriginCurrencyExchange(jsonXml).getString("ram:SourceCurrencyCode");
    }
}
