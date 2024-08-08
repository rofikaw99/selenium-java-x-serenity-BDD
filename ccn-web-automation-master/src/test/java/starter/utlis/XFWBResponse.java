package starter.utlis;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XFWBResponse {

    public static String waybillPrefix(JSONObject jsonObject){
        return jsonObject.getString("cargo:waybillPrefix");
    }
    public static String waybillNumber(JSONObject jsonObject){
        return jsonObject.getString("cargo:waybillNumber");
    }

    public static String waybillType(JSONObject jsonObject){
        return jsonObject
                .getJSONObject("cargo:waybillType")
                .getString("cargo:code");
    }

    public static String consignorDeclarationSignature(JSONObject jsonObject){
        return jsonObject.getString("cargo:consignorDeclarationSignature");
    }

    public static String carrierDeclarationDate(JSONObject jsonObject){
        return jsonObject.getString("cargo:carrierDeclarationDate");
    }

    public static String carrierDeclarationSignature(JSONObject jsonObject){
        return jsonObject.getString("cargo:carrierDeclarationSignature");
    }
    public static String carrierDeclarationPlace(JSONObject jsonObject){
        return jsonObject
                .getJSONObject("cargo:carrierDeclarationPlace")
                .getJSONArray("cargo:locationCodes")
                .getJSONObject(0)
                .getString("cargo:codeDescription");
    }
    public static String weightValuationIndicator(JSONObject jsonObject){
        return jsonObject
                .getJSONObject("cargo:weightValuationIndicator")
                .getString("cargo:code");
    }

    public static String otherChargesIndicator(JSONObject jsonObject){
        return jsonObject
                .getJSONObject("cargo:otherChargesIndicator")
                .getString("cargo:code");
    }

    public static JSONObject shipment(JSONObject jsonObject){
        return jsonObject
                .getJSONObject("cargo:shipment");
    }
    public static JSONObject totalGrossWeight(JSONObject jsonObject){
        return shipment(jsonObject)
                .getJSONObject("cargo:totalGrossWeight");
    }

    public static Integer numericalValueOfGrossWeight(JSONObject jsonObject){
        return totalGrossWeight(jsonObject)
                .getInt("cargo:numericalValue");
    }

    public static String unitTotalGrossWeight(JSONObject jsonObject){
        return totalGrossWeight(jsonObject)
                .getJSONObject("cargo:unit")
                .getString("cargo:code");
    }

    public static JSONObject waybillLineItems(JSONObject jsonObject){
        return jsonObject.getJSONArray("cargo:waybillLineItems")
                .getJSONObject(0);
    }

    public static JSONObject volumeOfDimensionsForRate(JSONObject jsonObject){
        return waybillLineItems(jsonObject)
                .getJSONObject("cargo:dimensionsForRate")
                .getJSONObject("cargo:volume");
    }
    public static Double numericalValueDimensionsForRate(JSONObject jsonObject){
        return volumeOfDimensionsForRate(jsonObject)
                .getDouble("cargo:numericalValue");
    }

    public static String unitDimensionsForRate (JSONObject jsonObject){
        return volumeOfDimensionsForRate(jsonObject)
                .getJSONObject("cargo:unit")
                .getString("cargo:code");
    }
    public static Integer pieceCountForRate(JSONObject jsonObject){
        return waybillLineItems(jsonObject)
                .getInt("cargo:pieceCountForRate");
    }
    public static JSONObject involvedParties(JSONObject jsonObject, String partyType){
        JSONArray involvedParties =  jsonObject
                .getJSONArray("cargo:involvedParties");
        Map<String, JSONObject> result = new HashMap<>();
        for (int i = 0; i < involvedParties.length(); i++) {

            // store each object in JSONObject
            JSONObject explrObject = involvedParties.getJSONObject(i);

            // get field value from JSONObject using get() method
            String codePartyType = explrObject.getJSONObject("cargo:partyRole").getString("cargo:code");
            switch (codePartyType) {
                case "SHP":
                    result.put("Consignor", explrObject);
                    break;
                case "CNE":
                    result.put("Consignee", explrObject);
                    break;
                case "AGT":
                    result.put("Agent", explrObject);
                    break;
            }
        }
        return result.get(partyType);
    }
    public static JSONObject partyDetails(JSONObject jsonObject, String partyType){
        return involvedParties(jsonObject, partyType).getJSONObject("cargo:partyDetails");
    }
    public static String PD_Name(JSONObject jsonObject, String partyType){
        return partyDetails(jsonObject, partyType).getString("cargo:name");
    }
    public static JSONObject PD_basedAtLocation(JSONObject jsonObject, String partyType){
        return partyDetails(jsonObject, partyType).getJSONObject("cargo:basedAtLocation");
    }
    public static JSONObject PD_BAL_address(JSONObject jsonObject, String partyType){
        return PD_basedAtLocation(jsonObject, partyType).getJSONObject("cargo:address");
    }
    public static String PD_BAL_A_countryCode(JSONObject jsonObject, String partyType){
        return PD_BAL_address(jsonObject, partyType).getJSONObject("cargo:country").getString("cargo:code");
    }
    public static String PD_BAL_A_cityCode(JSONObject jsonObject, String partyType){
        return PD_BAL_address(jsonObject, partyType).getJSONObject("cargo:cityCode").getString("cargo:codeDescription");
    }
    public static Object PD_BAL_A_postalCode(JSONObject jsonObject, String partyType){
        return PD_BAL_address(jsonObject, partyType).getJSONObject("cargo:postalCode").get("cargo:code");
    }
    public static String PD_BAL_streetAddressLines(JSONObject jsonObject, String partyType){
        return PD_BAL_address(jsonObject, partyType).getString("cargo:streetAddressLines");
    }
    public static String PD_IataCargoAgentLocationIdentifier(JSONObject jsonObject, String partyType){
        return partyDetails(jsonObject, partyType).getString("cargo:iataCargoAgentLocationIdentifier");
    }
    public static Integer PD_IataCargoAgentCode(JSONObject jsonObject, String partyType){
        return partyDetails(jsonObject, partyType).getInt("cargo:iataCargoAgentCode");
    }
    public static JSONObject DepartureLocation(JSONObject jsonObject){
        return jsonObject.getJSONObject("cargo:departureLocation");
    }
    public static String DL_LocationCodes_Code(JSONObject jsonObject){
        return DepartureLocation(jsonObject)
                .getJSONArray("cargo:locationCodes")
                .getJSONObject(0)
                .getString("cargo:code");
    }
    public static JSONObject ArrivalLocation(JSONObject jsonObject){
        return jsonObject.getJSONObject("cargo:arrivalLocation");
    }
    public static String AL_LocationCodes_Code(JSONObject jsonObject){
        return ArrivalLocation(jsonObject)
                .getJSONArray("cargo:locationCodes")
                .getJSONObject(0)
                .getString("cargo:code");
    }
    public static JSONObject LOs(JSONObject jsonObject){
        return jsonObject
                .getJSONArray("internal:LOs")
                .getJSONObject(0);
    }
    public static JSONObject ServedActivity(JSONObject jsonObject){
        return LOs(jsonObject).getJSONObject("cargo:servedActivity");
    }
    public static String SA_ModeQualifier_Code(JSONObject jsonObject){
        return ServedActivity(jsonObject).getJSONObject("cargo:modeQualifier").getString("cargo:code");
    }
    public static String SA_ModeCode_Code(JSONObject jsonObject){
        return ServedActivity(jsonObject).getJSONObject("cargo:modeCode").getString("cargo:code");
    }
    public static String SA_TransportIdentifier(JSONObject jsonObject){
        return ServedActivity(jsonObject).getString("cargo:transportIdentifier");
    }
    public static String SA_OperatingTransportMeans_TransportOrganization_AirlineCode(JSONObject jsonObject){
        return ServedActivity(jsonObject)
                .getJSONObject("cargo:operatingTransportMeans")
                .getJSONObject("cargo:transportOrganization")
                .getString("cargo:airlineCode");
    }
    public static String SA_MovementTimes_MovementTimestamp(JSONObject jsonObject){
        return ServedActivity(jsonObject)
                .getJSONArray("cargo:movementTimes")
                .getJSONObject(0)
                .getString("cargo:movementTimestamp");
    }
    public static JSONObject SA_ArrivalLocation(JSONObject jsonObject){
        return ServedActivity(jsonObject)
                .getJSONObject("cargo:arrivalLocation");
    }
    public static String SA_AL_LocationCodes_Code(JSONObject jsonObject){
        return SA_ArrivalLocation(jsonObject)
                .getJSONArray("cargo:locationCodes")
                .getJSONObject(0)
                .getString("cargo:code");
    }
    public static String SA_AL_LocationName(JSONObject jsonObject){
        return SA_ArrivalLocation(jsonObject)
                .getString("cargo:locationName");
    }
    public static String SA_AL_LocationType(JSONObject jsonObject){
        return SA_ArrivalLocation(jsonObject)
                .getString("cargo:locationType");
    }
    public static List<String> SpecialHandlingCodes(JSONObject jsonObject){
        JSONArray arr = shipment(jsonObject)
                .getJSONArray("cargo:specialHandlingCodes");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            JSONObject js = arr.getJSONObject(i);
            result.add(js.getString("cargo:code"));
        }
        return result;
    }
    public static List<String> TextualHandlingInstructions(JSONObject jsonObject){
        JSONArray arr = shipment(jsonObject)
                .getJSONArray("cargo:textualHandlingInstructions");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) result.add(arr.getString(i));
        return result;
    }
    public static String AccountingInformation(JSONObject jsonObject){
        return jsonObject
                .getString("cargo:accountingInformation");
    }
    public static JSONArray CustomsInformation(JSONObject jsonObject){
        return shipment(jsonObject)
                .getJSONArray("cargo:customsInformation");
    }
    public static List<String> CI_ContentCode(JSONObject jsonObject){
        JSONArray arr = CustomsInformation(jsonObject);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            result.add(arr.getJSONObject(i).getJSONObject("cargo:contentCode").getString("cargo:code"));
        }
        return result;
    }
    public static List<String> CI_Note(JSONObject jsonObject){
        JSONArray arr = CustomsInformation(jsonObject);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            result.add(arr.getJSONObject(i).getString("cargo:note"));
        }
        return result;
    }
    public static List<String> CI_Country(JSONObject jsonObject){
        JSONArray arr = CustomsInformation(jsonObject);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            if (arr.getJSONObject(i).has("cargo:country")) result.add(arr.getJSONObject(i).getJSONObject("cargo:country").getString("cargo:code"));
        }
        return result;
    }
    public static List<String> CI_SubjectCode(JSONObject jsonObject){
        JSONArray arr = CustomsInformation(jsonObject);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            if (arr.getJSONObject(i).has("cargo:subjectCode")) result.add(arr.getJSONObject(i).getJSONObject("cargo:subjectCode").getString("cargo:code"));
        }
        return result;
    }
    public static JSONArray OtherCharges(JSONObject jsonObject){
        return jsonObject.getJSONArray("cargo:otherCharges");
    }
    public static List<String> OC_OtherChargeCode(JSONObject jsonObject){
        JSONArray arr = OtherCharges(jsonObject);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            result.add(arr.getJSONObject(i).getJSONObject("cargo:otherChargeCode").getString("cargo:code"));
        }
        return result;
    }
    public static List<String> OC_ChargePaymentType(JSONObject jsonObject){
        JSONArray arr = OtherCharges(jsonObject);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            result.add(arr.getJSONObject(i).getJSONObject("cargo:chargePaymentType").getString("cargo:code"));
        }
        return result;
    }
    public static List<String> OC_Entitlement(JSONObject jsonObject){
        JSONArray arr = OtherCharges(jsonObject);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            result.add(arr.getJSONObject(i).getJSONObject("cargo:entitlement").getString("cargo:code"));
        }
        return result;
    }
    public static Map<String, List<Object>> OC_OtherChargeAmount(JSONObject jsonObject){
        JSONArray arr = OtherCharges(jsonObject);
        List<Object> content = new ArrayList<>();
        List<Object> currencyID = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            JSONObject am = arr.getJSONObject(i).getJSONObject("cargo:otherChargeAmount");
            content.add(am.getInt("cargo:numericalValue"));
            currencyID.add(am.getJSONObject("cargo:currencyUnit").getString("cargo:code"));
        }
        return Map.of("content", content, "currencyID", currencyID);
    }
    public static Map<String, List<Object>> WaybillLineItems_GrossWeightForRate(JSONObject jsonObject){
        JSONObject gwfr = waybillLineItems(jsonObject).getJSONObject("cargo:grossWeightForRate");
        return Map.of("content", List.of(gwfr.getInt("cargo:numericalValue")),
                "unitCode", List.of(gwfr.getJSONObject("cargo:unit").getString("cargo:code")));
    }
    public static List<Object> WaybillLineItems_PieceCountForRate(JSONObject jsonObject){
        return List.of(waybillLineItems(jsonObject).getInt("cargo:pieceCountForRate"));
    }
    public static List<Object> WaybillLineItems_GoodsDescriptionForRate(JSONObject jsonObject){
        return List.of(waybillLineItems(jsonObject).getString("cargo:goodsDescriptionForRate"));
    }
    public static JSONObject WaybillLineItems_DimensionsForRate(JSONObject jsonObject){
        return waybillLineItems(jsonObject).getJSONObject("cargo:dimensionsForRate");
    }
    public static Map<String, List<Object>> WLI_DimensionsForRate_Width(JSONObject jsonObject){
        JSONObject dfr = WaybillLineItems_DimensionsForRate(jsonObject).getJSONObject("cargo:width");
        return Map.of("content", List.of(dfr.getInt("cargo:numericalValue")),
                "unitCode", List.of(dfr.getJSONObject("cargo:unit").getString("cargo:code")));
    }
    public static Map<String, List<Object>> WLI_DimensionsForRate_Height(JSONObject jsonObject){
        JSONObject dfr = WaybillLineItems_DimensionsForRate(jsonObject).getJSONObject("cargo:height");
        return Map.of("content", List.of(dfr.getInt("cargo:numericalValue")),
                "unitCode", List.of(dfr.getJSONObject("cargo:unit").getString("cargo:code")));
    }
    public static Map<String, List<Object>> WLI_DimensionsForRate_Length(JSONObject jsonObject){
        JSONObject dfr = WaybillLineItems_DimensionsForRate(jsonObject).getJSONObject("cargo:length");
        return Map.of("content", List.of(dfr.getInt("cargo:numericalValue")),
                "unitCode", List.of(dfr.getJSONObject("cargo:unit").getString("cargo:code")));
    }
    public static Map<String, List<Object>> WLI_DimensionsForRate_Volume(JSONObject jsonObject){
        JSONObject dfr = WaybillLineItems_DimensionsForRate(jsonObject).getJSONObject("cargo:volume");
        return Map.of("content", List.of(dfr.getInt("cargo:numericalValue")),
                "unitCode", List.of(dfr.getJSONObject("cargo:unit").getString("cargo:code")));
    }
    public static List<Object> WLI_RateClassCode(JSONObject jsonObject){
        return List.of(waybillLineItems(jsonObject).getJSONObject("cargo:rateClassCode").getString("cargo:code"));
    }
    public static Map<String, List<Object>> WLI_ChargeableWeightForRate(JSONObject jsonObject){
        JSONObject dfr = waybillLineItems(jsonObject).getJSONObject("cargo:chargeableWeightForRate");
        return Map.of("content", List.of(dfr.getInt("cargo:numericalValue")),
                "unitCode", List.of(dfr.getJSONObject("cargo:unit").getString("cargo:code")));
    }
    public static Map<String, List<Object>> WLI_RateCharge(JSONObject jsonObject){
        JSONObject dfr = waybillLineItems(jsonObject).getJSONObject("cargo:rateCharge");
        return Map.of("content", List.of(dfr.getInt("cargo:numericalValue")),
                "unitCode", List.of(dfr.getJSONObject("cargo:currencyUnit").getString("cargo:code")));
    }
}
