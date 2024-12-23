package starter.utlis;

import io.cucumber.java.pt.Mas;
import io.cucumber.java.sl.In;
//import io.cucumber.messages.JSON;
import net.serenitybdd.core.SkipStepException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XFWBRequest {
    public static String key = "";

    public static JSONObject Waybill(JSONObject jsonXml) {
        return jsonXml.getJSONObject("rsm:Waybill");
    }
    public static JSONObject BusinessHeaderDocument(JSONObject jsonXml) {
        return Waybill(jsonXml).getJSONObject("rsm:BusinessHeaderDocument");
    }
    public static String BHD_ID(JSONObject jsonXML) {
        String key = "ram:ID";
        if (BusinessHeaderDocument(jsonXML).has(key)) return BusinessHeaderDocument(jsonXML).getString(key);
        else throw new SkipStepException("there is no "+ key +" in request");
    }
    public static String BHD_SenderAssignedID(JSONObject jsonXML) {
        String key = "ram:SenderAssignedID";
        if (BusinessHeaderDocument(jsonXML).has(key)) return BusinessHeaderDocument(jsonXML).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject BHD_IncludedHeaderNote(JSONObject jsonXML){
        String key = "ram:IncludedHeaderNote";
        if (BusinessHeaderDocument(jsonXML).has(key)) return BusinessHeaderDocument(jsonXML).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String IHN_ContentCode(JSONObject jsonObject){
        String key = "ram:ContentCode";
        if (BHD_IncludedHeaderNote(jsonObject).has(key)) return BHD_IncludedHeaderNote(jsonObject).getString("ram:ContentCode");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String SCoA_Signatory(JSONObject jsonObject){
        String key = "ram:Signatory";
        if (BusinessHeaderDocument(jsonObject).getJSONObject("ram:SignatoryConsignorAuthentication").has(key)) return BusinessHeaderDocument(jsonObject).getJSONObject("ram:SignatoryConsignorAuthentication").getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject BHD_SCaA(JSONObject jsonObject){
        String key = "ram:SignatoryCarrierAuthentication";
        if (BusinessHeaderDocument(jsonObject).has(key)) return BusinessHeaderDocument(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String BHD_SCaA_ActualDateTime(JSONObject jsonObject){
        String key = "ram:ActualDateTime";
        if (BHD_SCaA(jsonObject).has(key)) return BHD_SCaA(jsonObject).getString(key) + ".000Z";
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String BHD_SCaA_Signatory(JSONObject jsonObject){
        String key = "ram:Signatory";
        if (BHD_SCaA(jsonObject).has(key)) return BHD_SCaA(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String IAL_Name(JSONObject jsonObject){
        String key = "ram:Name";
        if (BHD_SCaA(jsonObject).getJSONObject("ram:IssueAuthenticationLocation").has(key)) return BHD_SCaA(jsonObject).getJSONObject("ram:IssueAuthenticationLocation").getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject MasterConsignment(JSONObject jsonObject){
        String key = "rsm:MasterConsignment";
        return Waybill(jsonObject).getJSONObject(key);
    }
    public static Boolean NilCarriageValueIndicator(JSONObject jsonObject){
        String key = "ram:NilCarriageValueIndicator";
        if (MasterConsignment(jsonObject).has(key)) return MasterConsignment(jsonObject).getBoolean(key);
        else throw new SkipStepException("there is no "+ key +" in request");
    }
    public static Map<String, Object> DeclaredValueForCarriageAmount (JSONObject jsonObject){
        String key = "ram:DeclaredValueForCarriageAmount";
        if (MasterConsignment(jsonObject).has(key)) {
            JSONObject DeclaredValueForCarriageAmount = MasterConsignment(jsonObject).getJSONObject(key);
            return Map.of("content", DeclaredValueForCarriageAmount.getInt("content"),
                    "currencyID", DeclaredValueForCarriageAmount.getString("currencyID"));
        }
        else throw new SkipStepException("there is no "+ key +" in request");
    }
    public static Boolean NilCustomsValueIndicator(JSONObject jsonObject){
        String key = "ram:NilCustomsValueIndicator";
        if (MasterConsignment(jsonObject).has(key)) return MasterConsignment(jsonObject).getBoolean(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Map<String, Object> DeclaredValueForCustomsAmount(JSONObject jsonObject){
        String key = "ram:DeclaredValueForCustomsAmount";
        if (MasterConsignment(jsonObject).has(key)) {
                JSONObject DeclaredValueForCarriageAmount = MasterConsignment(jsonObject).getJSONObject(key);
                return Map.of("content", DeclaredValueForCarriageAmount.getInt("content"),
                        "currencyID", DeclaredValueForCarriageAmount.getString("currencyID"));

        }
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Boolean NilInsuranceValueIndicator(JSONObject jsonObject){
        String key = "ram:NilInsuranceValueIndicator";
        if (MasterConsignment(jsonObject).has(key)) return MasterConsignment(jsonObject).getBoolean(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Map<String, Object> InsuranceValueAmount(JSONObject jsonObject){
        String key = "ram:InsuranceValueAmount";
        if (MasterConsignment(jsonObject).has(key)) {
            JSONObject InsuranceValueAmount = MasterConsignment(jsonObject).getJSONObject(key);
            return Map.of("content", InsuranceValueAmount.getInt("content"),
                    "currencyID", InsuranceValueAmount.getString("currencyID"));

        }
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Boolean TotalChargePrepaidIndicator(JSONObject jsonObject){
        String key = "ram:TotalChargePrepaidIndicator";
        if (MasterConsignment(jsonObject).has(key)) return MasterConsignment(jsonObject).getBoolean(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Boolean TotalDisbursementPrepaidIndicator(JSONObject jsonObject){
        String key = "ram:TotalDisbursementPrepaidIndicator";
        if (MasterConsignment(jsonObject).has(key)) return MasterConsignment(jsonObject).getBoolean(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Map<String, Object> IncludedTareGrossWeightMeasure(JSONObject jsonObject){
        String key = "ram:IncludedTareGrossWeightMeasure";
        if (MasterConsignment(jsonObject).has(key)) {
            JSONObject IncludedTareGrossWeightMeasure = MasterConsignment(jsonObject)
                    .getJSONObject(key);
            return Map.of("content", IncludedTareGrossWeightMeasure.getInt("content"),
                    "unitCode", IncludedTareGrossWeightMeasure.getString("unitCode"));
        }
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Map<String, Object> GrossVolumeMeasure(JSONObject jsonObject){
        String key = "ram:GrossVolumeMeasure";
        if (MasterConsignment(jsonObject).has(key)) {
            JSONObject GrossVolumeMeasure = MasterConsignment(jsonObject)
                    .getJSONObject(key);
            return Map.of("content", GrossVolumeMeasure.getDouble("content"),
                    "unitCode", GrossVolumeMeasure.getString("unitCode"));
        } else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Integer TotalPieceQuantity(JSONObject jsonObject){
        String key = "ram:TotalPieceQuantity";
        if (MasterConsignment(jsonObject).has(key)) return MasterConsignment(jsonObject).getInt(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Integer PackageQuantity(JSONObject jsonObject){
        String key = "ram:PackageQuantity";
        if (MasterConsignment(jsonObject).has(key)) return MasterConsignment(jsonObject).getInt(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String ProductID(JSONObject jsonObject){
        String key = "ram:ProductID";
        if (MasterConsignment(jsonObject).has(key)) return MasterConsignment(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject ConsignorParty(JSONObject jsonObject){
        String key = "ram:ConsignorParty";
        if (MasterConsignment(jsonObject).has(key)) return MasterConsignment(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CoP_Name(JSONObject jsonObject){
        String key = "ram:Name";
        if (ConsignorParty(jsonObject).has(key)) return ConsignorParty(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Integer CoP_AccountID(JSONObject jsonObject){
        String key = "ram:AccountID";
        if (ConsignorParty(jsonObject).has(key)) return ConsignorParty(jsonObject).getInt(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject CoP_PostalStructuredAddress(JSONObject jsonObject){
        String key = "ram:PostalStructuredAddress";
        if (ConsignorParty(jsonObject).has(key)) return ConsignorParty(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject CoP_DefinedTradeContact(JSONObject jsonObject){
        String key = "ram:DefinedTradeContact";
        if (ConsignorParty(jsonObject).has(key)) return ConsignorParty(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject CeP_DefinedTradeContact(JSONObject jsonObject){
        String key = "ram:DefinedTradeContact";
        if (ConsigneeParty(jsonObject).has(key)) return ConsigneeParty(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject AP_DefinedTradeContact(JSONObject jsonObject){
        String key = "ram:DefinedTradeContact";
        if (AssociatedParty(jsonObject).has(key)) return AssociatedParty(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static BigInteger CoP_PSA_PostcodeCode(JSONObject jsonObject){
        String key = "ram:PostcodeCode";
        if (CoP_PostalStructuredAddress(jsonObject).has(key)) return CoP_PostalStructuredAddress(jsonObject).getBigInteger(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CoP_PSA_StreetName(JSONObject jsonObject){
        String key = "ram:StreetName";
        if (CoP_PostalStructuredAddress(jsonObject).has(key)) return CoP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CoP_PSA_CityName(JSONObject jsonObject){
        String key = "ram:CityName";
        if (CoP_PostalStructuredAddress(jsonObject).has(key)) return CoP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CoP_PSA_CountryID(JSONObject jsonObject){
        String key = "ram:CountryID";
        if (CoP_PostalStructuredAddress(jsonObject).has(key)) return CoP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CoP_PSA_CountryName(JSONObject jsonObject){
        String key = "ram:CountryName";
        if (CoP_PostalStructuredAddress(jsonObject).has(key)) return CoP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CoP_PSA_CountrySubDivisionName(JSONObject jsonObject){
        String key = "ram:CountrySubDivisionName";
        if (CoP_PostalStructuredAddress(jsonObject).has(key)) return CoP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Integer CoP_PSA_PostOfficeBox(JSONObject jsonObject){
        String key = "ram:PostOfficeBox";
        if (CoP_PostalStructuredAddress(jsonObject).has(key)) return CoP_PostalStructuredAddress(jsonObject).getInt(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CoP_PSA_CityID(JSONObject jsonObject){
        String key = "ram:CityID";
        if (CoP_PostalStructuredAddress(jsonObject).has(key)) return CoP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object CoP_PSA_CountrySubDivisionID(JSONObject jsonObject){
        String key = "ram:CountrySubDivisionID";
        if (CoP_PostalStructuredAddress(jsonObject).has(key)) return CoP_PostalStructuredAddress(jsonObject).get(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CoP_DTC_PersonName(JSONObject jsonObject){
        String key = "ram:PersonName";
        if (CoP_DefinedTradeContact(jsonObject).has(key)) return CoP_DefinedTradeContact(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CeP_DTC_PersonName(JSONObject jsonObject){
        String key = "ram:PersonName";
        if (CeP_DefinedTradeContact(jsonObject).has(key)) return CeP_DefinedTradeContact(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String FFP_DTC_PersonName(JSONObject jsonObject){
        String key = "ram:PersonName";
        if (FFP_DefinedTradeContact(jsonObject).has(key)) return FFP_DefinedTradeContact(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String AP_DTC_PersonName(JSONObject jsonObject){
        String key = "ram:PersonName";
        if (AP_DefinedTradeContact(jsonObject).has(key)) return AP_DefinedTradeContact(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CoP_DTC_DepartmentName(JSONObject jsonObject){
        String key = "ram:DepartmentName";
        if (CoP_DefinedTradeContact(jsonObject).has(key)) return CoP_DefinedTradeContact(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CeP_DTC_DepartmentName(JSONObject jsonObject){
        String key = "ram:DepartmentName";
        if (CeP_DefinedTradeContact(jsonObject).has(key)) return CeP_DefinedTradeContact(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String FFP_DTC_DepartmentName(JSONObject jsonObject){
        String key = "ram:DepartmentName";
        if (FFP_DefinedTradeContact(jsonObject).has(key)) return FFP_DefinedTradeContact(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String AP_DTC_DepartmentName(JSONObject jsonObject){
        String key = "ram:DepartmentName";
        if (AP_DefinedTradeContact(jsonObject).has(key)) return AP_DefinedTradeContact(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object CoP_DTC_DirectTelephoneCommunication(JSONObject jsonObject){
        String key = "ram:DirectTelephoneCommunication";
        if (CoP_DefinedTradeContact(jsonObject).has(key)) return CoP_DefinedTradeContact(jsonObject).getJSONObject(key).get("ram:CompleteNumber");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object CeP_DTC_DirectTelephoneCommunication(JSONObject jsonObject){
        String key = "ram:DirectTelephoneCommunication";
        if (CeP_DefinedTradeContact(jsonObject).has(key)) return CeP_DefinedTradeContact(jsonObject).getJSONObject(key).get("ram:CompleteNumber");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object CoP_DTC_FaxCommunication(JSONObject jsonObject){
        String key = "ram:FaxCommunication";
        if (CoP_DefinedTradeContact(jsonObject).has(key)) return CoP_DefinedTradeContact(jsonObject).getJSONObject(key).get("ram:CompleteNumber");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object CeP_DTC_FaxCommunication(JSONObject jsonObject){
        String key = "ram:FaxCommunication";
        if (CeP_DefinedTradeContact(jsonObject).has(key)) return CeP_DefinedTradeContact(jsonObject).getJSONObject(key).get("ram:CompleteNumber");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object CoP_DTC_URIEmailCommunication(JSONObject jsonObject){
        String key = "ram:URIEmailCommunication";
        if (CoP_DefinedTradeContact(jsonObject).has(key)) return CoP_DefinedTradeContact(jsonObject).getJSONObject(key).get("ram:URIID");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object CeP_DTC_URIEmailCommunication(JSONObject jsonObject){
        String key = "ram:URIEmailCommunication";
        if (CeP_DefinedTradeContact(jsonObject).has(key)) return CeP_DefinedTradeContact(jsonObject).getJSONObject(key).get("ram:URIID");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object CoP_DTC_TelexCommunication(JSONObject jsonObject){
        String key = "ram:TelexCommunication";
        if (CoP_DefinedTradeContact(jsonObject).has(key)) return CoP_DefinedTradeContact(jsonObject).getJSONObject(key).get("ram:CompleteNumber");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object CeP_DTC_TelexCommunication(JSONObject jsonObject){
        String key = "ram:TelexCommunication";
        if (CeP_DefinedTradeContact(jsonObject).has(key)) return CeP_DefinedTradeContact(jsonObject).getJSONObject(key).get("ram:CompleteNumber");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject ConsigneeParty(JSONObject jsonObject){
        String key = "ram:ConsigneeParty";
        if (MasterConsignment(jsonObject).has(key)) return MasterConsignment(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CeP_Name(JSONObject jsonObject){
        String key = "ram:Name";
        if (ConsigneeParty(jsonObject).has(key)) return ConsigneeParty(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject CeP_PostalStructuredAddress(JSONObject jsonObject){
        String key = "ram:PostalStructuredAddress";
        if (ConsigneeParty(jsonObject).has(key)) return ConsigneeParty(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static BigInteger CeP_PSA_PostcodeCode(JSONObject jsonObject){
        String key = "ram:PostcodeCode";
        if (CeP_PostalStructuredAddress(jsonObject).has(key)) return CeP_PostalStructuredAddress(jsonObject).getBigInteger(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CeP_PSA_StreetName(JSONObject jsonObject){
        String key = "ram:StreetName";
        if (CeP_PostalStructuredAddress(jsonObject).has(key)) return CeP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CeP_PSA_CityName(JSONObject jsonObject){
        String key = "ram:CityName";
        if (CeP_PostalStructuredAddress(jsonObject).has(key)) return CeP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Integer CeP_AccountID(JSONObject jsonObject){
        String key = "ram:AccountID";
        if (ConsigneeParty(jsonObject).has(key)) return ConsigneeParty(jsonObject).getInt(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CeP_PSA_CountryID(JSONObject jsonObject){
        String key = "ram:CountryID";
        if (CeP_PostalStructuredAddress(jsonObject).has(key)) return CeP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CeP_PSA_CountryName(JSONObject jsonObject){
        String key = "ram:CountryName";
        if (CeP_PostalStructuredAddress(jsonObject).has(key)) return CeP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CeP_PSA_CountrySubDivisionName(JSONObject jsonObject){
        String key = "ram:CountrySubDivisionName";
        if (CeP_PostalStructuredAddress(jsonObject).has(key)) return CeP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static BigInteger CeP_PSA_PostOfficeBox(JSONObject jsonObject){
        String key = "ram:PostOfficeBox";
        if (CeP_PostalStructuredAddress(jsonObject).has(key)) return CeP_PostalStructuredAddress(jsonObject).getBigInteger(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CeP_PSA_CityID(JSONObject jsonObject){
        String key = "ram:CityID";
        if (CeP_PostalStructuredAddress(jsonObject).has(key)) return CeP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String CeP_PSA_CountrySubDivisionID(JSONObject jsonObject){
        String key = "ram:CountrySubDivisionID";
        if (CeP_PostalStructuredAddress(jsonObject).has(key)) return CeP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject FreightForwarderParty(JSONObject jsonObject){
        String key = "ram:FreightForwarderParty";
        if (MasterConsignment(jsonObject).has(key)) return MasterConsignment(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String FFP_Name(JSONObject jsonObject){
        String key = "ram:Name";
        if (FreightForwarderParty(jsonObject).has(key)) return FreightForwarderParty(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Integer FFP_AccountID(JSONObject jsonObject){
        String key = "ram:AccountID";
        if (FreightForwarderParty(jsonObject).has(key)) return FreightForwarderParty(jsonObject).getInt(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Integer FFP_CargoAgentID(JSONObject jsonObject){
        String key = "ram:CargoAgentID";
        if (FreightForwarderParty(jsonObject).has(key)) return FreightForwarderParty(jsonObject).getInt(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject FFP_FreightForwarderAddress(JSONObject jsonObject){
        String key = "ram:FreightForwarderAddress";
        if (FreightForwarderParty(jsonObject).has(key)) return FreightForwarderParty(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String FFP_FFA_CityName(JSONObject jsonObject){
        String key = "ram:CityName";
        if (FFP_FreightForwarderAddress(jsonObject).has(key)) return FFP_FreightForwarderAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static BigInteger FFP_FFA_PostcodeCode(JSONObject jsonObject){
        String key = "ram:PostcodeCode";
        if (FFP_FreightForwarderAddress(jsonObject).has(key)) return FFP_FreightForwarderAddress(jsonObject).getBigInteger(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String FFP_FFA_StreetName(JSONObject jsonObject){
        String key = "ram:StreetName";
        if (FFP_FreightForwarderAddress(jsonObject).has(key)) return FFP_FreightForwarderAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String FFP_FFA_CountryID(JSONObject jsonObject){
        String key = "ram:CountryID";
        if (FFP_FreightForwarderAddress(jsonObject).has(key)) return FFP_FreightForwarderAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String FFP_FFA_CountryName(JSONObject jsonObject){
        String key = "ram:CountryName";
        if (FFP_FreightForwarderAddress(jsonObject).has(key)) return FFP_FreightForwarderAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String FFP_FFA_CountrySubDivisionName(JSONObject jsonObject){
        String key = "ram:CountrySubDivisionName";
        if (FFP_FreightForwarderAddress(jsonObject).has(key)) return FFP_FreightForwarderAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static BigInteger FFP_FFA_PostOfficeBox(JSONObject jsonObject){
        String key = "ram:PostOfficeBox";
        if (FFP_FreightForwarderAddress(jsonObject).has(key)) return FFP_FreightForwarderAddress(jsonObject).getBigInteger(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String FFP_FFA_CityID(JSONObject jsonObject){
        String key = "ram:CityID";
        if (FFP_FreightForwarderAddress(jsonObject).has(key)) return FFP_FreightForwarderAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String FFP_FFA_CountrySubDivisionID(JSONObject jsonObject){
        String key = "ram:CountrySubDivisionID";
        if (FFP_FreightForwarderAddress(jsonObject).has(key)) return FFP_FreightForwarderAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String FFP_SpecifiedCargoAgentLocation_ID(JSONObject jsonObject){
        String key = "ram:ID";
        if (FreightForwarderParty(jsonObject).getJSONObject("ram:SpecifiedCargoAgentLocation").has(key)) return FreightForwarderParty(jsonObject).getJSONObject("ram:SpecifiedCargoAgentLocation").getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject FFP_DefinedTradeContact(JSONObject jsonObject){
        String key = "ram:DefinedTradeContact";
        if (FreightForwarderParty(jsonObject).has(key)) return FreightForwarderParty(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object FFP_DTC_DirectTelephoneCommunication(JSONObject jsonObject){
        String key = "ram:DirectTelephoneCommunication";
        if (FFP_DefinedTradeContact(jsonObject).has(key)) return FFP_DefinedTradeContact(jsonObject).getJSONObject(key).get("ram:CompleteNumber");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object FFP_DTC_FaxCommunication(JSONObject jsonObject){
        String key = "ram:FaxCommunication";
        if (FFP_DefinedTradeContact(jsonObject).has(key)) return FFP_DefinedTradeContact(jsonObject).getJSONObject(key).get("ram:CompleteNumber");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object FFP_DTC_URIEmailCommunication(JSONObject jsonObject){
        String key = "ram:URIEmailCommunication";
        if (FFP_DefinedTradeContact(jsonObject).has(key)) return FFP_DefinedTradeContact(jsonObject).getJSONObject(key).get("ram:URIID");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object FFP_DTC_TelexCommunication(JSONObject jsonObject){
        String key = "ram:TelexCommunication";
        if (FFP_DefinedTradeContact(jsonObject).has(key)) return FFP_DefinedTradeContact(jsonObject).getJSONObject(key).get("ram:CompleteNumber");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject AssociatedParty(JSONObject jsonObject){
        String key = "ram:AssociatedParty";
        if (MasterConsignment(jsonObject).has(key)) return MasterConsignment(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String AP_Name(JSONObject jsonObject){
        String key = "ram:Name";
        if (AssociatedParty(jsonObject).has(key)) return AssociatedParty(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject AP_PostalStructuredAddress(JSONObject jsonObject){
        String key = "ram:PostalStructuredAddress";
        if (AssociatedParty(jsonObject).has(key)) return AssociatedParty(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static BigInteger AP_PSA_PostcodeCode(JSONObject jsonObject){
        String key = "ram:PostcodeCode";
        if (AP_PostalStructuredAddress(jsonObject).has(key)) return AP_PostalStructuredAddress(jsonObject).getBigInteger(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String AP_PSA_StreetName(JSONObject jsonObject){
        String key = "ram:StreetName";
        if (AP_PostalStructuredAddress(jsonObject).has(key)) return AP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String AP_PSA_CityName(JSONObject jsonObject){
        String key = "ram:CityName";
        if (AP_PostalStructuredAddress(jsonObject).has(key)) return AP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Integer AP_AccountID(JSONObject jsonObject){
        String key = "ram:AccountID";
        if (AssociatedParty(jsonObject).has(key)) return AssociatedParty(jsonObject).getInt(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String AP_PSA_CountryID(JSONObject jsonObject){
        String key = "ram:CountryID";
        if (AP_PostalStructuredAddress(jsonObject).has(key)) return AP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String AP_PSA_CountryName(JSONObject jsonObject){
        String key = "ram:CountryName";
        if (AP_PostalStructuredAddress(jsonObject).has(key)) return AP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String AP_PSA_CountrySubDivisionName(JSONObject jsonObject){
        String key = "ram:CountrySubDivisionName";
        if (AP_PostalStructuredAddress(jsonObject).has(key)) return AP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static BigInteger AP_PSA_PostOfficeBox(JSONObject jsonObject){
        String key = "ram:PostOfficeBox";
        if (AP_PostalStructuredAddress(jsonObject).has(key)) return AP_PostalStructuredAddress(jsonObject).getBigInteger(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String AP_PSA_CityID(JSONObject jsonObject){
        String key = "ram:CityID";
        if (AP_PostalStructuredAddress(jsonObject).has(key)) return AP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String AP_PSA_CountrySubDivisionID(JSONObject jsonObject){
        String key = "ram:CountrySubDivisionID";
        if (AP_PostalStructuredAddress(jsonObject).has(key)) return AP_PostalStructuredAddress(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object AP_DTC_DirectTelephoneCommunication(JSONObject jsonObject){
        String key = "ram:DirectTelephoneCommunication";
        if (AP_DefinedTradeContact(jsonObject).has(key)) return AP_DefinedTradeContact(jsonObject).getJSONObject(key).get("ram:CompleteNumber");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object AP_DTC_FaxCommunication(JSONObject jsonObject){
        String key = "ram:FaxCommunication";
        if (AP_DefinedTradeContact(jsonObject).has(key)) return AP_DefinedTradeContact(jsonObject).getJSONObject(key).get("ram:CompleteNumber");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object AP_DTC_URIEmailCommunication(JSONObject jsonObject){
        String key = "ram:URIEmailCommunication";
        if (AP_DefinedTradeContact(jsonObject).has(key)) return AP_DefinedTradeContact(jsonObject).getJSONObject(key).get("ram:URIID");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object AP_DTC_TelexCommunication(JSONObject jsonObject){
        String key = "ram:TelexCommunication";
        if (AP_DefinedTradeContact(jsonObject).has(key)) return AP_DefinedTradeContact(jsonObject).getJSONObject(key).get("ram:CompleteNumber");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject OriginLocation(JSONObject jsonObject){
        String key = "ram:OriginLocation";
        if (MasterConsignment(jsonObject).has(key)) return MasterConsignment(jsonObject).getJSONObject("ram:OriginLocation");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String OL_ID(JSONObject jsonObject){
        String key = "ram:ID";
        if (OriginLocation(jsonObject).has(key)) return OriginLocation(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String OL_Name(JSONObject jsonObject){
        String key = "ram:Name";
        if (OriginLocation(jsonObject).has(key)) return OriginLocation(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject FinalDestinationLocation(JSONObject jsonObject){
        String key = "ram:FinalDestinationLocation";
        if (MasterConsignment(jsonObject).has(key)) return MasterConsignment(jsonObject).getJSONObject("ram:FinalDestinationLocation");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String FDL_ID(JSONObject jsonObject){
        String key = "ram:ID";
        if (FinalDestinationLocation(jsonObject).has(key)) return FinalDestinationLocation(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String FDL_Name(JSONObject jsonObject){
        String key = "ram:Name";
        if (FinalDestinationLocation(jsonObject).has(key)) return FinalDestinationLocation(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject SpecifiedLogisticsTransportMovement(JSONObject jsonObject){
        String key = "ram:SpecifiedLogisticsTransportMovement";
        if (MasterConsignment(jsonObject).has(key)) return MasterConsignment(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String SLTM_ID(JSONObject jsonObject){
        String key = "ram:ID";
        if (SpecifiedLogisticsTransportMovement(jsonObject).has(key)) return SpecifiedLogisticsTransportMovement(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String SLTM_StageCode(JSONObject jsonObject){
        String key = "ram:StageCode";
        if (SpecifiedLogisticsTransportMovement(jsonObject).has(key)) {
            if (SpecifiedLogisticsTransportMovement(jsonObject).getString(key).isEmpty())
                return "MAIN_CARRIAGE";
            else return SpecifiedLogisticsTransportMovement(jsonObject).getString(key);
        }
        else return "MAIN_CARRIAGE";
    }
    public static String SLTM_ModeCode(JSONObject jsonObject){
        String key = "ram:ModeCode";
        if (SpecifiedLogisticsTransportMovement(jsonObject).has(key)) return SpecifiedLogisticsTransportMovement(jsonObject).getString(key);
        else return "AIR_TRANSPORT";
    }
    public static String SLTM_UsedLogisticsTransportMeans_Name(JSONObject jsonObject){
        String key = "ram:Name";
        if (SpecifiedLogisticsTransportMovement(jsonObject)
                .getJSONObject("ram:UsedLogisticsTransportMeans").has(key)) {
            return SpecifiedLogisticsTransportMovement(jsonObject)
                    .getJSONObject("ram:UsedLogisticsTransportMeans")
                    .getString(key);
        } else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject SLTM_ArrivalEvent(JSONObject jsonObject){
        String key = "ram:ArrivalEvent";
        if (SpecifiedLogisticsTransportMovement(jsonObject).has(key))
            return SpecifiedLogisticsTransportMovement(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String SLTM_AE_ScheduledOccurrenceDateTime(JSONObject jsonObject){
        String key = "ram:ScheduledOccurrenceDateTime";
        if (SLTM_ArrivalEvent(jsonObject).has(key))
            return SLTM_ArrivalEvent(jsonObject).getString(key) + ".000Z";
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject SLTM_AE_OccurrenceArrivalLocation(JSONObject jsonObject){
        String key = "ram:OccurrenceArrivalLocation";
        if (SLTM_ArrivalEvent(jsonObject).has(key))
            return SLTM_ArrivalEvent(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String SLTM_AE_OAL_ID(JSONObject jsonObject){
        String key = "ram:ID";
        if (SLTM_AE_OccurrenceArrivalLocation(jsonObject).has(key))
            return SLTM_AE_OccurrenceArrivalLocation(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String SLTM_AE_OAL_Name(JSONObject jsonObject){
        String key = "ram:Name";
        if (SLTM_AE_OccurrenceArrivalLocation(jsonObject).has(key))
            return SLTM_AE_OccurrenceArrivalLocation(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String SLTM_AE_OAL_TypeCode(JSONObject jsonObject){
        String key = "ram:TypeCode";
        if (SLTM_AE_OccurrenceArrivalLocation(jsonObject).has(key))
            return SLTM_AE_OccurrenceArrivalLocation(jsonObject).getString(key);
        else return "Airport";
    }
    public static JSONObject SLTM_DepartureEvent(JSONObject jsonObject){
        String key = "ram:DepartureEvent";
        if (SpecifiedLogisticsTransportMovement(jsonObject).has(key))
            return SpecifiedLogisticsTransportMovement(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String SLTM_DE_ScheduledOccurrenceDateTime(JSONObject jsonObject){
        String key = "ram:ScheduledOccurrenceDateTime";
        if (SLTM_DepartureEvent(jsonObject).has(key))
            return SLTM_DepartureEvent(jsonObject).getString(key) + ".000Z";
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject SLTM_DE_OccurrenceDepartureLocation(JSONObject jsonObject){
        String key = "ram:OccurrenceDepartureLocation";
        if (SLTM_DepartureEvent(jsonObject).has(key))
            return SLTM_DepartureEvent(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String SLTM_DE_ODL_ID(JSONObject jsonObject){
        String key = "ram:ID";
        if (SLTM_DE_OccurrenceDepartureLocation(jsonObject).has(key))
            return SLTM_DE_OccurrenceDepartureLocation(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String SLTM_DE_ODL_Name(JSONObject jsonObject){
        String key = "ram:Name";
        if (SLTM_DE_OccurrenceDepartureLocation(jsonObject).has(key))
            return SLTM_DE_OccurrenceDepartureLocation(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String SLTM_DE_ODL_TypeCode(JSONObject jsonObject){
        String key = "ram:TypeCode";
        if (SLTM_DE_OccurrenceDepartureLocation(jsonObject).has(key))
            return SLTM_DE_OccurrenceDepartureLocation(jsonObject).getString(key);
        else return "Airport";
    }
    public static JSONObject UtilizedLogisticsTransportEquipment(JSONObject jsonObject){
        String key = "ram:UtilizedLogisticsTransportEquipment";
        if (MasterConsignment(jsonObject).has(key)) return MasterConsignment(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Integer ULTE_ID(JSONObject jsonObject){
        String key = "ram:ID";
        if (UtilizedLogisticsTransportEquipment(jsonObject).has(key)) return UtilizedLogisticsTransportEquipment(jsonObject).getInt(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String ULTE_CharacteristicCode(JSONObject jsonObject){
        String key = "ram:CharacteristicCode";
        if (UtilizedLogisticsTransportEquipment(jsonObject).has(key)) return UtilizedLogisticsTransportEquipment(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Integer ULTE_Characteristic(JSONObject jsonObject){
        String key = "ram:Characteristic";
        if (UtilizedLogisticsTransportEquipment(jsonObject).has(key)) return UtilizedLogisticsTransportEquipment(jsonObject).getInt(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String ULTE_AffixedLogisticsSeal_ID(JSONObject jsonObject){
        String key = "ram:AffixedLogisticsSeal";
        if (UtilizedLogisticsTransportEquipment(jsonObject).has(key)) return UtilizedLogisticsTransportEquipment(jsonObject).getJSONObject(key).getString("ram:ID");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static List<String> HandlingSPHInstructions(JSONObject jsonObject){
        String key = "ram:HandlingSPHInstructions";
        if (MasterConsignment(jsonObject).has(key)){
            JSONArray arr = MasterConsignment(jsonObject)
                    .getJSONArray(key);
            List<String> result = new ArrayList<>();
            for (int i = 0; i < arr.length(); i++){
                JSONObject js = arr.getJSONObject(i);
                result.add(js.getString("ram:DescriptionCode"));
            }
            return result;
        } else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static List<JSONObject> HandlingSSRInstructions(JSONObject jsonObject){
        String key = "ram:HandlingSSRInstructions";
        if (MasterConsignment(jsonObject).has(key)){
            Object ssri = MasterConsignment(jsonObject).get(key);
            List<JSONObject> result = new ArrayList<>();
            if (ssri instanceof JSONObject){
                result = List.of(MasterConsignment(jsonObject).getJSONObject(key));
            } else if (ssri instanceof JSONArray){
                for (int i = 0; i < ((JSONArray) ssri).length(); i++){
                    result.add(MasterConsignment(jsonObject).getJSONArray(key).getJSONObject(i));
                }
            }
            return result;
        } else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static List<String> HSSRI_Description(String type, JSONObject jsonObject){
        String key = "ram:Description";
        List<JSONObject> ssri = HandlingSSRInstructions(jsonObject);
        List<String> result = new ArrayList<>();
        for (JSONObject object : ssri) {
            result.add(type + "-" + object.getString(key));
        }
        return result;
    }
    public static List<JSONObject> HandlingOSIInstructions(JSONObject jsonObject){
        String key = "ram:HandlingOSIInstructions";
        if (MasterConsignment(jsonObject).has(key)){
            Object ssri = MasterConsignment(jsonObject).get(key);
            List<JSONObject> result = new ArrayList<>();
            if (ssri instanceof JSONObject){
                result = List.of(MasterConsignment(jsonObject).getJSONObject(key));
            } else if (ssri instanceof JSONArray){
                for (int i = 0; i < ((JSONArray) ssri).length(); i++){
                    result.add(MasterConsignment(jsonObject).getJSONArray(key).getJSONObject(i));
                }
            }
            return result;
        } else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static List<String> OSI_Description(String type, JSONObject jsonObject){
        String key = "ram:Description";
        List<JSONObject> ssri = HandlingOSIInstructions(jsonObject);
        List<String> result = new ArrayList<>();
        for (JSONObject object : ssri) {
            result.add(type + "-" + object.getString(key));
        }
        return result;
    }
    public static String IncludedAccountingNote(JSONObject jsonObject){
        String key = "ram:IncludedAccountingNote";
        if (MasterConsignment(jsonObject).has(key)) {
            JSONObject includedAccountingNote = MasterConsignment(jsonObject).getJSONArray(key).getJSONObject(0);
            return includedAccountingNote.getString("ram:ContentCode") + "-" + includedAccountingNote.getString("ram:Content");
        } else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONArray IncludedCustomsNote(JSONObject jsonObject){
        String key = "ram:IncludedCustomsNote";
        if (MasterConsignment(jsonObject).has(key))
            return MasterConsignment(jsonObject).getJSONArray(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
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
        String key = "ram:ApplicableOriginCurrencyExchange";
        if (MasterConsignment(jsonObject).has(key))
            return MasterConsignment(jsonObject).getJSONObject(key).getString("ram:SourceCurrencyCode");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONObject AssociatedReferenceDocument(JSONObject jsonObject){
        String key = "ram:AssociatedReferenceDocument";
        if (MasterConsignment(jsonObject).has(key))
            return MasterConsignment(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Integer ARD_ID(JSONObject jsonObject){
        String key = "ram:ID";
        if (AssociatedReferenceDocument(jsonObject).has(key))
            return AssociatedReferenceDocument(jsonObject).getInt(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String ARD_IssueDateTime(JSONObject jsonObject){
        String key = "ram:IssueDateTime";
        if (AssociatedReferenceDocument(jsonObject).has(key))
            return AssociatedReferenceDocument(jsonObject).getString(key) + ".000Z";
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static Object ARD_TypeCode(JSONObject jsonObject){
        String key = "ram:TypeCode";
        if (AssociatedReferenceDocument(jsonObject).has(key))
            return AssociatedReferenceDocument(jsonObject).get(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String ARD_Name(JSONObject jsonObject){
        String key = "ram:Name";
        if (AssociatedReferenceDocument(jsonObject).has(key))
            return AssociatedReferenceDocument(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONArray ApplicableLogisticsAllowanceCharge(JSONObject jsonObject){
        JSONArray result = new JSONArray();
        if (MasterConsignment(jsonObject).get("ram:ApplicableLogisticsAllowanceCharge") instanceof JSONObject){
            result.put(MasterConsignment(jsonObject).getJSONObject("ram:ApplicableLogisticsAllowanceCharge"));
        } else {
            result = MasterConsignment(jsonObject).getJSONArray("ram:ApplicableLogisticsAllowanceCharge");
        }
        return result;
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
        String key = "ram:ApplicableRating";
        if (MasterConsignment(jsonObject).has(key))
            return MasterConsignment(jsonObject).getJSONObject("ram:ApplicableRating");
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static String AR_TypeCode(JSONObject jsonObject){
        String key = "ram:TypeCode";
        if (MasterConsignment(jsonObject).has(key))
            return ApplicableRating(jsonObject).getString(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
    }
    public static JSONArray AR_IncludedMasterConsignmentItem(JSONObject jsonObject){
        String key = "ram:IncludedMasterConsignmentItem";
        if (ApplicableRating(jsonObject).has(key))
            return ApplicableRating(jsonObject).getJSONArray(key);
        else throw new SkipStepException("there is no  "+ key +" in request");
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
                else parse = parse + " " + arr.getJSONObject(i).getJSONObject("ram:NatureIdentificationTransportCargo")
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