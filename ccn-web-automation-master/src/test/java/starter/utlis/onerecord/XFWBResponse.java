package starter.utlis.onerecord;

import net.serenitybdd.core.SkipStepException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XFWBResponse {

    public static String key;

    public static String shippingRefNo(JSONObject jsonObject){
        return jsonObject.getString("cargo:shippingRefNo");
    }
    public static String waybillPrefix(JSONObject jsonObject){
        return jsonObject.getString("cargo:waybillPrefix");
    }
    public static String waybillNumber(JSONObject jsonObject){
        return jsonObject.getString("cargo:waybillNumber");
    }
    public static void changeWaybillNumber(JSONObject jsonObject){
        Long waybillNumber = Long.valueOf(jsonObject.getString("cargo:waybillNumber"));
        waybillNumber = waybillNumber + 1;
        jsonObject.put("cargo:waybillNumber", String.valueOf(waybillNumber));
    }
    public static Map<String, Object> declaredValueForCarriage(JSONObject jsonObject){
        String key = "cargo:declaredValueForCarriage";
        if (jsonObject.has(key)) {
            JSONObject declaredValueForCarriage = jsonObject.getJSONObject(key);
            return Map.of("content", declaredValueForCarriage.getInt("cargo:numericalValue"),
                    "currencyID", declaredValueForCarriage.getString("cargo:currencyUnit"));
        }
        else throw new SkipStepException("there is no " + key + " in body response");
    }
    public static Map<String, Object> declaredValueForCustoms(JSONObject jsonObject){
        String key = "cargo:declaredValueForCustoms";
        if (jsonObject.has(key)) {
            JSONObject declaredValueForCustoms = jsonObject.getJSONObject(key);
            return Map.of("content", declaredValueForCustoms.getInt("cargo:numericalValue"),
                    "currencyID", declaredValueForCustoms.getString("cargo:currencyUnit"));
        }
        else throw new SkipStepException("there is no " + key + " in body response");
    }
    public static String insuredAmount(JSONObject jsonObject){
        String key = "cargo:insuredAmount";
        if (jsonObject.has(key))
            return jsonObject.getString("cargo:insuredAmount");
        else throw new SkipStepException("there is no " + key + " in body response");
    }
    public static String waybillType(JSONObject jsonObject){
        return jsonObject
                .getJSONObject("cargo:waybillType")
                .getString("cargo:code");
    }

    public static String consignorDeclarationSignature(JSONObject jsonObject){
        return jsonObject.getString("cargo:consignorDeclarationSignature");
    }

    public static Integer slacForRate(JSONObject jsonObject){
        String key = "cargo:slacForRate";
        if (jsonObject.has(key)) return jsonObject.getInt(key);
        else throw new SkipStepException("there is no " + key + " in body response");
    }
    public static String productCode(JSONObject jsonObject){
        String key = "cargo:productCode";
        if (jsonObject.has(key)) return jsonObject.getString(key);
        else throw new SkipStepException("there is no " + key + " in body response");
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
    public static void removePieceCountForRate(JSONObject jsonObject){
        waybillLineItems(jsonObject)
                .remove("cargo:pieceCountForRate");
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
                case "FFW":
                    result.put("Associated Party", explrObject);
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
    public static String PD_OtherIdentifiers(JSONObject jsonObject, String partyType){
        String key = "cargo:otherIdentifiers";
        if (involvedParties(jsonObject, partyType).has(key)) return involvedParties(jsonObject, partyType).getJSONObject(key).getString("cargo:textualValue");
        else throw new SkipStepException("there is no response for: " + key);
    }
    public static JSONObject PD_basedAtLocation(JSONObject jsonObject, String partyType){
        return partyDetails(jsonObject, partyType).getJSONObject("cargo:basedAtLocation");
    }
    public static JSONObject PD_BAL_address(JSONObject jsonObject, String partyType){
        return PD_basedAtLocation(jsonObject, partyType).getJSONObject("cargo:address");
    }
    public static String PD_BAL_A_countryCode(JSONObject jsonObject, String partyType){
        String key = "cargo:country";
        if (PD_BAL_address(jsonObject, partyType).has(key))
            return PD_BAL_address(jsonObject, partyType).getJSONObject(key).getString("cargo:code");
        else throw new SkipStepException("there is no response for: " + key);
    }
    public static String PD_BAL_A_cityCode(JSONObject jsonObject, String partyType){
        String key = "cargo:cityCode";
        if (PD_BAL_address(jsonObject, partyType).has(key))
            return PD_BAL_address(jsonObject, partyType).getJSONObject(key).getString("cargo:codeDescription");
        else throw new SkipStepException("there is no response for: " + key);
    }
    public static String PD_BAL_A_cityName(JSONObject jsonObject, String partyType){
        String key = "cargo:cityName";
        if (PD_BAL_address(jsonObject, partyType).has(key))
            return PD_BAL_address(jsonObject, partyType).getJSONObject(key).getString("cargo:codeDescription");
        else throw new SkipStepException("there is no response for: " + key);
    }
    public static String PD_BAL_A_postalCode(JSONObject jsonObject, String partyType){
        return PD_BAL_address(jsonObject, partyType).getJSONObject("cargo:postalCode").getString("cargo:code");
    }
    public static String PD_BAL_streetAddressLines(JSONObject jsonObject, String partyType){
        return PD_BAL_address(jsonObject, partyType).getString("cargo:streetAddressLines");
    }
    public static String PD_BAL_regionName(JSONObject jsonObject, String partyType){
        String key = "cargo:regionCode";
        if (PD_BAL_address(jsonObject, partyType).has(key))
            return PD_BAL_address(jsonObject, partyType).getJSONObject(key).getString("cargo:codeDescription");
        else throw new SkipStepException("there is no response for: " + key);
    }
    public static String PD_BAL_regionCode(JSONObject jsonObject, String partyType){
        String key = "cargo:regionCode";
        if (PD_BAL_address(jsonObject, partyType).has(key))
            return PD_BAL_address(jsonObject, partyType).getJSONObject(key).getString("cargo:code");
        else throw new SkipStepException("there is no response for: " + key);
    }
    public static String PD_BAL_firstName(JSONObject jsonObject, String partyType){
        String key = "cargo:firstName";
        if (PD_BAL_address(jsonObject, partyType).has(key))
            return PD_BAL_address(jsonObject, partyType).getString(key);
        else throw new SkipStepException("there is no response for: " + key);
    }
    public static String PD_BAL_department(JSONObject jsonObject, String partyType){
        String key = "cargo:department";
        if (PD_BAL_address(jsonObject, partyType).has(key))
            return PD_BAL_address(jsonObject, partyType).getString(key);
        else throw new SkipStepException("there is no response for: " + key);
    }
    public static String PD_BAL_textualValue(JSONObject jsonObject, String partyType){
        String key = "cargo:textualValue";
        if (PD_BAL_address(jsonObject, partyType).has(key))
            return PD_BAL_address(jsonObject, partyType).getString(key);
        else throw new SkipStepException("there is no response for: " + key);
    }
    public static String PD_BAL_A_postOfficeBox(JSONObject jsonObject, String partyType){
        String key = "cargo:postOfficeBox";
        if (PD_BAL_address(jsonObject, partyType).has(key))
            return PD_BAL_address(jsonObject, partyType).getString(key);
        else throw new SkipStepException("there is no response for: " + key);
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
    public static String DL_LocationName(JSONObject jsonObject){
        String key = "cargo:locationName";
        if (DepartureLocation(jsonObject).has(key))
            return DepartureLocation(jsonObject).getString(key);
        else throw new SkipStepException("there is no " + key + "in response body");
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
    public static String AL_LocationName(JSONObject jsonObject){
        String key = "cargo:locationName";
        if (DepartureLocation(jsonObject).has(key))
            return DepartureLocation(jsonObject).getString(key);
        else throw new SkipStepException("there is no " + key + "in response body");
    }
    public static JSONObject LOs(JSONObject jsonObject){
        return jsonObject
                .getJSONArray("internal:LOs")
                .getJSONObject(0);
    }
    public static JSONObject ServedActivity(JSONObject jsonObject){
        return LOs(jsonObject).getJSONObject("cargo:servedActivity");
    }
    public static String SA_TransportIdentifier(JSONObject jsonObject){
        return ServedActivity(jsonObject).getString("cargo:transportIdentifier");
    }
    public static String SA_ModeCode(JSONObject jsonObject){
        String key = "cargo:modeCode";
        if (ServedActivity(jsonObject).has(key)) return ServedActivity(jsonObject).getJSONObject(key).getString("cargo:code");
        else throw new SkipStepException("there is no value for " + key + " in response body");
    }
    public static String SA_ModeQualifier(JSONObject jsonObject){
        String key = "cargo:modeQualifier";
        if (ServedActivity(jsonObject).has(key)) return ServedActivity(jsonObject).getJSONObject(key).getString("cargo:code");
        else throw new SkipStepException("there is no value for " + key + " in response body");
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
        String key = "cargo:locationType";
        if (SA_ArrivalLocation(jsonObject).has(key))
            return SA_ArrivalLocation(jsonObject).getString("cargo:locationType");
        else throw new SkipStepException("there is no value of " + key + " in response body");
    }
    public static JSONObject SA_DepartureLocation(JSONObject jsonObject){
        return ServedActivity(jsonObject)
                .getJSONObject("cargo:departureLocation");
    }
    public static String SA_DL_LocationCodes_Code(JSONObject jsonObject){
        return SA_DepartureLocation(jsonObject)
                .getJSONArray("cargo:locationCodes")
                .getJSONObject(0)
                .getString("cargo:code");
    }
    public static String SA_DL_LocationName(JSONObject jsonObject){
        return SA_DepartureLocation(jsonObject)
                .getString("cargo:locationName");
    }
    public static String SA_DL_LocationType(JSONObject jsonObject){
        String key = "cargo:locationType";
        if (SA_DepartureLocation(jsonObject).has(key))
            return SA_DepartureLocation(jsonObject).getString(key);
        else throw new SkipStepException("there is no value of " + key + " in response body");
    }
    public static JSONObject SA_OperatingTransportMeans(JSONObject jsonObject){
        String key = "cargo:operatingTransportMeans";
        if (ServedActivity(jsonObject).has(key))
            return ServedActivity(jsonObject).getJSONObject(key);
        else throw new SkipStepException("there is no value of " + key + " in response body");
    }
    public static String SA_OTM_VehicleRegistration(JSONObject jsonObject){
        String key = "cargo:vehicleRegistration";
        if (SA_OperatingTransportMeans(jsonObject).has(key))
            return SA_OperatingTransportMeans(jsonObject).getString(key);
        else throw new SkipStepException("there is no value of " + key + " in response body");
    }
    public static String SA_OTM_VehicleSize(JSONObject jsonObject){
        String key = "cargo:vehicleSize";
        if (SA_OperatingTransportMeans(jsonObject).has(key))
            return SA_OperatingTransportMeans(jsonObject).getString(key);
        else throw new SkipStepException("there is no value of " + key + " in response body");
    }
    public static String SA_OTM_VehicleType(JSONObject jsonObject){
        String key = "cargo:vehicleType";
        if (SA_OperatingTransportMeans(jsonObject).has(key))
            return SA_OperatingTransportMeans(jsonObject).getJSONObject(key).getString("cargo:code");
        else throw new SkipStepException("there is no value of " + key + " in response body");
    }
    public static String SA_Seal(JSONObject jsonObject){
        String key = "cargo:Seal";
        if (ServedActivity(jsonObject).has(key))
            return ServedActivity(jsonObject).getString(key);
        else throw new SkipStepException("there is no value of " + key + " in response body");
    }
    public static void removeSpecialHandlingCodes(JSONObject jsonObject){
        shipment(jsonObject)
                .remove("cargo:specialHandlingCodes");
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
    public static JSONObject ExternalReferences(JSONObject jsonObject){
        return jsonObject
                .getJSONObject("cargo:externalReferences");
    }
    public static String OriginCurrency(JSONObject jsonObject){
        String key = "cargo:originCurrency";
        if (jsonObject.has(key))
        return jsonObject.getString("cargo:originCurrency");
        else throw new SkipStepException("there is no value for " + key);
    }
    public static String ER_DocumentIdentifier(JSONObject jsonObject){
        return ExternalReferences(jsonObject)
                .getString("cargo:documentIdentifier");
    }
    public static String ER_DocumentName(JSONObject jsonObject){
        return ExternalReferences(jsonObject)
                .getString("cargo:documentName");
    }
    public static String ER_DocumentType(JSONObject jsonObject){
        return ExternalReferences(jsonObject)
                .getString("cargo:documentType");
    }
    public static String ER_ValidFrom(JSONObject jsonObject){
        return ExternalReferences(jsonObject)
                .getString("cargo:validFrom");
    }
    public static String ER_ValidUntil(JSONObject jsonObject){
        return ExternalReferences(jsonObject)
                .getString("cargo:validUntil");
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
    public static void removeOtherChargeCode(JSONObject jsonObject){
        OtherCharges(jsonObject).getJSONObject(0)
                .remove("cargo:otherChargeCode");
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
    public static void removeGrossWeightForRate(JSONObject jsonObject){
        waybillLineItems(jsonObject)
                .remove("cargo:grossWeightForRate");
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
    public static void removeGoodsDescriptionForRate(JSONObject jsonObject){
        waybillLineItems(jsonObject)
                .remove("cargo:goodsDescriptionForRate");
    }
    public static JSONObject WaybillLineItems_HsCodeForRate(JSONObject jsonObject){
        return waybillLineItems(jsonObject).getJSONObject("cargo:hsCodeForRate");
    }
    public static String WaybillLineItems_HsCodeForRate_code(JSONObject jsonObject){
        return WaybillLineItems_HsCodeForRate(jsonObject).getString("cargo:code");
    }
    public static void removeHsCodeForRate(JSONObject jsonObject){
        waybillLineItems(jsonObject)
                .remove("cargo:hsCodeForRate");
    }
    public static JSONObject WaybillLineItems_DimensionsForRate(JSONObject jsonObject){
        return waybillLineItems(jsonObject).getJSONObject("cargo:dimensionsForRate");
    }
    public static Map<String, List<Object>> WLI_DimensionsForRate_Width(JSONObject jsonObject){
        JSONObject dfr = WaybillLineItems_DimensionsForRate(jsonObject).getJSONObject("cargo:width");
        return Map.of("content", List.of(dfr.getInt("cargo:numericalValue")),
                "unitCode", List.of(dfr.getJSONObject("cargo:unit").getString("cargo:code")));
    }
    public static void removeWidth(JSONObject jsonObject){
        WaybillLineItems_DimensionsForRate(jsonObject)
                .remove("cargo:width");
    }
    public static Map<String, List<Object>> WLI_DimensionsForRate_Height(JSONObject jsonObject){
        JSONObject dfr = WaybillLineItems_DimensionsForRate(jsonObject).getJSONObject("cargo:height");
        return Map.of("content", List.of(dfr.getInt("cargo:numericalValue")),
                "unitCode", List.of(dfr.getJSONObject("cargo:unit").getString("cargo:code")));
    }
    public static void removeHeight(JSONObject jsonObject){
        WaybillLineItems_DimensionsForRate(jsonObject)
                .remove("cargo:height");
    }
    public static Map<String, List<Object>> WLI_DimensionsForRate_Length(JSONObject jsonObject){
        JSONObject dfr = WaybillLineItems_DimensionsForRate(jsonObject).getJSONObject("cargo:length");
        return Map.of("content", List.of(dfr.getInt("cargo:numericalValue")),
                "unitCode", List.of(dfr.getJSONObject("cargo:unit").getString("cargo:code")));
    }
    public static void removeLength(JSONObject jsonObject){
        WaybillLineItems_DimensionsForRate(jsonObject)
                .remove("cargo:length");
    }
    public static Map<String, List<Object>> WLI_DimensionsForRate_Volume(JSONObject jsonObject){
        JSONObject dfr = WaybillLineItems_DimensionsForRate(jsonObject).getJSONObject("cargo:volume");
        return Map.of("content", List.of(dfr.getInt("cargo:numericalValue")),
                "unitCode", List.of(dfr.getJSONObject("cargo:unit").getString("cargo:code")));
    }
    public static void removeVolume(JSONObject jsonObject){
        WaybillLineItems_DimensionsForRate(jsonObject)
                .remove("cargo:volume");
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
