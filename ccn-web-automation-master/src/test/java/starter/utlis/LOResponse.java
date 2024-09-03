package starter.utlis;

import io.cucumber.messages.JSON;
import org.json.JSONArray;
import org.json.JSONObject;

public class LOResponse {

    public static int defaultInt = 0;

    public static String id(JSONObject jsonObject){
        return jsonObject.getString("@id");
    }
    public static JSONObject arrivalLocation(JSONObject jsonObject){
        return jsonObject.getJSONObject("cargo:arrivalLocation");
    }
    public static String arrivalLocation_id(JSONObject jsonObject){
        return arrivalLocation(jsonObject).getString("@id");
    }
    public static JSONObject AL_locationCodes(JSONObject jsonObject){
        return arrivalLocation(jsonObject).getJSONObject("cargo:locationCodes");
    }
    public static String AL_locationCodes_id(JSONObject jsonObject){
        return AL_locationCodes(jsonObject).getString("@id");
    }
    public static String AL_LocationCodes_code(JSONObject jsonObject){
        return AL_locationCodes(jsonObject).getString("cargo:code");
    }

    public static JSONObject departureLocation(JSONObject jsonObject){
        return jsonObject.getJSONObject("cargo:departureLocation");
    }
    public static String departureLocation_id(JSONObject jsonObject){
        return departureLocation(jsonObject).getString("@id");
    }
    public static JSONObject DL_locationCodes(JSONObject jsonObject){
        return departureLocation(jsonObject).getJSONObject("cargo:locationCodes");
    }
    public static String DL_locationCodes_ID(JSONObject jsonObject){
        return DL_locationCodes(jsonObject).getString("@id");
    }
    public static String DL_locationCodes_Code(JSONObject jsonObject){
        return DL_locationCodes(jsonObject).getString("cargo:code");
    }

    public static JSONObject carrierDeclarationPlace(JSONObject jsonObject){
        return jsonObject.getJSONObject("cargo:carrierDeclarationPlace");
    }
    public static String carrierDeclarationPlace_ID(JSONObject jsonObject){
        return carrierDeclarationPlace(jsonObject).getString("@id");
    }
    public static JSONObject CDP_locationCodes(JSONObject jsonObject){
        return carrierDeclarationPlace(jsonObject).getJSONObject("cargo:locationCodes");
    }
    public static String CDP_locationCodes_id(JSONObject jsonObject){
        return CDP_locationCodes(jsonObject).getString("@id");
    }
    public static String CDP_locationCodes_code(JSONObject jsonObject){
        return CDP_locationCodes(jsonObject).getString("cargo:code");
    }

    public static JSONObject declaredValueForCustoms(JSONObject jsonObject){
        return jsonObject.getJSONObject("cargo:declaredValueForCustoms");
    }
    public static String declaredValueForCustoms_id(JSONObject jsonObject){
        return declaredValueForCustoms(jsonObject).getString("@id");
    }
    public static Integer declaredValueForCustoms_numericalValue(JSONObject jsonObject){
        return declaredValueForCustoms(jsonObject).getInt("cargo:numericalValue");
    }
    public static String declaredValueForCustoms_currencyUnit(JSONObject jsonObject){
        return declaredValueForCustoms(jsonObject).getString("cargo:currencyUnit");
    }

    public static JSONObject declaredValueForCarriage(JSONObject jsonObject){
        return jsonObject.getJSONObject("cargo:declaredValueForCarriage");
    }
    public static String declaredValueForCarriage_id(JSONObject jsonObject){
        return declaredValueForCustoms(jsonObject).getString("@id");
    }
    public static Integer declaredValueForCarriage_numericalValue(JSONObject jsonObject){
        return declaredValueForCustoms(jsonObject).getInt("cargo:numericalValue");
    }
    public static String declaredValueForCarriage_currencyUnit(JSONObject jsonObject){
        return declaredValueForCustoms(jsonObject).getString("cargo:currencyUnit");
    }

    public static JSONObject involvedParties(JSONObject jsonObject, String party){
        JSONArray involvedParties = jsonObject.getJSONArray("cargo:involvedParties");
        JSONObject result = new JSONObject();
        for (int i = 0; i < involvedParties.length(); i++){
            if (involvedParties.getJSONObject(i).getJSONObject("cargo:partyRole").getString("cargo:code").equals(party)){
                result = involvedParties.getJSONObject(i);
            }
        }
        return result;
    }
    public static String involvedParties_id(JSONObject jsonObject, String party){
        return involvedParties(jsonObject, party).getString("@id");
    }
    public static JSONObject involvedParties_partyRole(JSONObject jsonObject, String party){
        return involvedParties(jsonObject, party).getJSONObject("cargo:partyRole");
    }
    public static String IP_partyRole_id(JSONObject jsonObject, String party){
        return involvedParties_partyRole(jsonObject, party).getString("@id");
    }
    public static String IP_partyRole_code(JSONObject jsonObject, String party){
        return involvedParties_partyRole(jsonObject, party).getString("cargo:code");
    }
    public static JSONObject involvedParties_otherIdentifiers(JSONObject jsonObject, String party){
        return involvedParties(jsonObject, party).getJSONObject("cargo:otherIdentifiers");
    }
    public static String IP_otherIdentifiers_id(JSONObject jsonObject, String party){
        return involvedParties_otherIdentifiers(jsonObject, party).getString("@id");
    }
    public static String IP_otherIdentifiers_otherIdentifierType(JSONObject jsonObject, String party){
        return involvedParties_otherIdentifiers(jsonObject, party).getString("cargo:otherIdentifierType");
    }
    public static String IP_otherIdentifiers_textualValue(JSONObject jsonObject, String party){
        return involvedParties_otherIdentifiers(jsonObject, party).getString("cargo:textualValue");
    }
    public static JSONObject involvedParties_partyDetails(JSONObject jsonObject, String party){
        return involvedParties(jsonObject, party).getJSONObject("cargo:partyDetails");
    }
    public static String IP_partyDetails_id(JSONObject jsonObject, String party){
        return involvedParties_partyDetails(jsonObject, party).getString("@id");
    }
    public static String IP_partyDetails_name(JSONObject jsonObject, String party){
        return involvedParties_partyDetails(jsonObject, party).getString("cargo:name");
    }
    public static JSONObject IP_PD_basedAtLocation(JSONObject jsonObject, String party){
        return involvedParties_partyDetails(jsonObject, party).getJSONObject("cargo:basedAtLocation");
    }
    public static String IP_PD_basedAtLocation_id(JSONObject jsonObject, String party){
        return IP_PD_basedAtLocation(jsonObject, party).getString("@id");
    }
    public static JSONObject IP_PD_basedAtLocation_address(JSONObject jsonObject, String party){
        return IP_PD_basedAtLocation(jsonObject, party).getJSONObject("cargo:address");
    }
    public static String IP_PD_BAT_address_id(JSONObject jsonObject, String party){
        return IP_PD_basedAtLocation_address(jsonObject, party).getString("@id");
    }
    public static JSONObject IP_PD_BAT_address_country(JSONObject jsonObject, String party){
        return IP_PD_basedAtLocation_address(jsonObject, party).getJSONObject("cargo:country");
    }
    public static String IP_PD_BAT_address_country_id(JSONObject jsonObject, String party){
        return IP_PD_BAT_address_country(jsonObject, party).getString("@id");
    }
    public static String IP_PD_BAT_address_country_code(JSONObject jsonObject, String party){
        return IP_PD_BAT_address_country(jsonObject, party).getString("cargo:code");
    }
    public static JSONObject IP_PD_BAT_address_cityCode(JSONObject jsonObject, String party){
        return IP_PD_basedAtLocation_address(jsonObject, party).getJSONObject("cargo:cityCode");
    }
    public static String IP_PD_BAT_address_cityCode_id(JSONObject jsonObject, String party){
        return IP_PD_BAT_address_cityCode(jsonObject, party).getString("@id");
    }
    public static String IP_PD_BAT_address_cityCode_codeDescription(JSONObject jsonObject, String party){
        return IP_PD_BAT_address_cityCode(jsonObject, party).getString("cargo:codeDescription");
    }
    public static JSONObject IP_PD_BAT_address_postalCode(JSONObject jsonObject, String party){
        return IP_PD_basedAtLocation_address(jsonObject, party).getJSONObject("cargo:postalCode");
    }
    public static String IP_PD_BAT_address_postalCode_id(JSONObject jsonObject, String party){
        return IP_PD_BAT_address_postalCode(jsonObject, party).getString("@id");
    }
    public static String IP_PD_BAT_address_postalCode_code(JSONObject jsonObject, String party){
        return IP_PD_BAT_address_postalCode(jsonObject, party).getString("cargo:code");
    }
    public static JSONObject IP_PD_BAT_address_regionCode(JSONObject jsonObject, String party){
        return IP_PD_basedAtLocation_address(jsonObject, party).getJSONObject("cargo:regionCode");
    }
    public static String IP_PD_BAT_address_regionCode_id(JSONObject jsonObject, String party){
        return IP_PD_BAT_address_regionCode(jsonObject, party).getString("@id");
    }
    public static String IP_PD_BAT_address_regionCode_code(JSONObject jsonObject, String party){
        return IP_PD_BAT_address_regionCode(jsonObject, party).getString("cargo:code");
    }
    public static String IP_PD_BAT_address_regionCode_codeDescription(JSONObject jsonObject, String party){
        return IP_PD_BAT_address_regionCode(jsonObject, party).getString("cargo:codeDescription");
    }
    public static String IP_PD_BAT_address_postOfficeBox(JSONObject jsonObject, String party){
        return IP_PD_basedAtLocation_address(jsonObject, party).getString("cargo:postOfficeBox");
    }
    public static String IP_PD_BAT_address_streetAddressLines(JSONObject jsonObject, String party){
        return IP_PD_basedAtLocation_address(jsonObject, party).getString("cargo:streetAddressLines");
    }

    public static JSONObject waybillLineItems(JSONObject jsonObject){
        return jsonObject.getJSONArray("cargo:waybillLineItems")
                .getJSONObject(0);
    }
    public static String waybillLineItems_id(JSONObject jsonObject){
        return waybillLineItems(jsonObject).getString("@id");
    }
    public static JSONObject waybillLineItems_chargeableWeightForRate(JSONObject jsonObject){
        return waybillLineItems(jsonObject).getJSONObject("cargo:chargeableWeightForRate");
    }
    public static String WLI_chargeableWeightForRate_id(JSONObject jsonObject){
        return waybillLineItems_chargeableWeightForRate(jsonObject).getString("@id");
    }
    public static float WLI_chargeableWeightForRate_numericalValue(JSONObject jsonObject){
        return waybillLineItems_chargeableWeightForRate(jsonObject).getFloat("cargo:numericalValue");
    }
    public static JSONObject WLI_chargeableWeightForRate_unit(JSONObject jsonObject){
        return waybillLineItems_chargeableWeightForRate(jsonObject).getJSONObject("cargo:unit");
    }
    public static String WLI_CWFR_unit_id(JSONObject jsonObject){
        return WLI_chargeableWeightForRate_unit(jsonObject).getString("@id");
    }
    public static String WLI_CWFR_unit_code(JSONObject jsonObject){
        return WLI_chargeableWeightForRate_unit(jsonObject).getString("cargo:code");
    }
    public static JSONObject waybillLineItems_grossWeightForRate(JSONObject jsonObject){
        JSONObject result = null;
        if (waybillLineItems(jsonObject).has("cargo:grossWeightForRate")) result = waybillLineItems(jsonObject).getJSONObject("cargo:grossWeightForRate");
        return result;
    }
    public static String WLI_grossWeightForRate_id(JSONObject jsonObject){
        return waybillLineItems_grossWeightForRate(jsonObject).getString("@id");
    }
    public static float WLI_grossWeightForRate_numericalValue(JSONObject jsonObject){
        return waybillLineItems_grossWeightForRate(jsonObject).getFloat("cargo:numericalValue");
    }
    public static JSONObject WLI_grossWeightForRate_unit(JSONObject jsonObject){
        return waybillLineItems_grossWeightForRate(jsonObject).getJSONObject("cargo:unit");
    }
    public static String WLI_GWFR_unit_id(JSONObject jsonObject){
        return WLI_grossWeightForRate_unit(jsonObject).getString("@id");
    }
    public static String WLI_GWFR_unit_code(JSONObject jsonObject){
        return WLI_grossWeightForRate_unit(jsonObject).getString("cargo:code");
    }
    public static JSONObject waybillLineItems_dimensionsForRate(JSONObject jsonObject){
        return waybillLineItems(jsonObject).getJSONObject("cargo:dimensionsForRate");
    }
    public static String WLI_dimensionsForRate_id(JSONObject jsonObject){
        return waybillLineItems_dimensionsForRate(jsonObject).getString("@id");
    }
    public static JSONObject WLI_dimensionsForRate_height(JSONObject jsonObject){
        JSONObject result = null;
        if (waybillLineItems_dimensionsForRate(jsonObject).has("cargo:height")) result = waybillLineItems_dimensionsForRate(jsonObject).getJSONObject("cargo:height");
        return result;
    }
    public static String WLI_DFR_height_id(JSONObject jsonObject){
        return WLI_dimensionsForRate_height(jsonObject).getString("@id");
    }
    public static float WLI_DFR_height_numericalValue(JSONObject jsonObject){
        return WLI_dimensionsForRate_height(jsonObject).getFloat("cargo:numericalValue");
    }
    public static JSONObject WLI_DFR_height_unit(JSONObject jsonObject){
        return WLI_dimensionsForRate_height(jsonObject).getJSONObject("cargo:unit");
    }
    public static String WLI_DFR_height_unit_id(JSONObject jsonObject){
        return WLI_DFR_height_unit(jsonObject).getString("@id");
    }
    public static String WLI_DFR_height_unit_code(JSONObject jsonObject){
        return WLI_DFR_height_unit(jsonObject).getString("cargo:code");
    }
    public static JSONObject WLI_dimensionsForRate_length(JSONObject jsonObject){
        JSONObject result = null;
        if (waybillLineItems_dimensionsForRate(jsonObject).has("cargo:length")) result = waybillLineItems_dimensionsForRate(jsonObject).getJSONObject("cargo:length");
        return result;
    }
    public static String WLI_DFR_length_id(JSONObject jsonObject){
        return WLI_dimensionsForRate_length(jsonObject).getString("@id");
    }
    public static float WLI_DFR_length_numericalValue(JSONObject jsonObject){
        return WLI_dimensionsForRate_length(jsonObject).getFloat("cargo:numericalValue");
    }
    public static JSONObject WLI_DFR_length_unit(JSONObject jsonObject){
        return WLI_dimensionsForRate_length(jsonObject).getJSONObject("cargo:unit");
    }
    public static String WLI_DFR_length_unit_id(JSONObject jsonObject){
        return WLI_DFR_length_unit(jsonObject).getString("@id");
    }
    public static String WLI_DFR_length_unit_code(JSONObject jsonObject){
        return WLI_DFR_length_unit(jsonObject).getString("cargo:code");
    }
    public static JSONObject WLI_dimensionsForRate_width(JSONObject jsonObject){
        JSONObject result = null;
        if (waybillLineItems_dimensionsForRate(jsonObject).has("cargo:width")) result = waybillLineItems_dimensionsForRate(jsonObject).getJSONObject("cargo:width");
        return result;
    }
    public static String WLI_DFR_width_id(JSONObject jsonObject){
        return WLI_dimensionsForRate_width(jsonObject).getString("@id");
    }
    public static float WLI_DFR_width_numericalValue(JSONObject jsonObject){
        return WLI_dimensionsForRate_width(jsonObject).getFloat("cargo:numericalValue");
    }
    public static JSONObject WLI_DFR_width_unit(JSONObject jsonObject){
        return WLI_dimensionsForRate_width(jsonObject).getJSONObject("cargo:unit");
    }
    public static String WLI_DFR_width_unit_id(JSONObject jsonObject){
        return WLI_DFR_width_unit(jsonObject).getString("@id");
    }
    public static String WLI_DFR_width_unit_code(JSONObject jsonObject){
        return WLI_DFR_width_unit(jsonObject).getString("cargo:code");
    }
    public static JSONObject WLI_dimensionsForRate_volume(JSONObject jsonObject){
        JSONObject result = null;
        if (waybillLineItems_dimensionsForRate(jsonObject).has("cargo:volume")) result = waybillLineItems_dimensionsForRate(jsonObject).getJSONObject("cargo:volume");
        return result;
    }
    public static String WLI_DFR_volume_id(JSONObject jsonObject){
        return WLI_dimensionsForRate_volume(jsonObject).getString("@id");
    }
    public static float WLI_DFR_volume_numericalValue(JSONObject jsonObject){
        return WLI_dimensionsForRate_volume(jsonObject).getFloat("cargo:numericalValue");
    }
    public static JSONObject WLI_DFR_volume_unit(JSONObject jsonObject){
        return WLI_dimensionsForRate_volume(jsonObject).getJSONObject("cargo:unit");
    }
    public static String WLI_DFR_volume_unit_id(JSONObject jsonObject){
        return WLI_DFR_volume_unit(jsonObject).getString("@id");
    }
    public static String WLI_DFR_volume_unit_code(JSONObject jsonObject){
        return WLI_DFR_volume_unit(jsonObject).getString("cargo:code");
    }
    public static JSONObject waybillLineItems_rateCharge(JSONObject jsonObject){
        return waybillLineItems(jsonObject).getJSONObject("cargo:rateCharge");
    }
    public static String waybillLineItems_rateCharge_id(JSONObject jsonObject){
        return waybillLineItems_rateCharge(jsonObject).getString("@id");
    }
    public static String WLI_rateCharge_numericalValue(JSONObject jsonObject){
        return waybillLineItems_rateCharge(jsonObject).getString("cargo:numericalValue");
    }
    public static JSONObject WLI_rateCharge_currencyUnit(JSONObject jsonObject){
        return waybillLineItems_rateCharge(jsonObject).getJSONObject("cargo:currencyUnit");
    }
    public static String WLI_RC_currencyUnit_id(JSONObject jsonObject){
        return WLI_rateCharge_currencyUnit(jsonObject).getString("@id");
    }
    public static String WLI_RC_currencyUnit_code(JSONObject jsonObject){
        return WLI_rateCharge_currencyUnit(jsonObject).getString("cargo:code");
    }
    public static JSONObject waybillLineItems_rateClassCode(JSONObject jsonObject){
        return waybillLineItems(jsonObject).getJSONObject("cargo:rateClassCode");
    }
    public static String waybillLineItems_rateClassCode_id(JSONObject jsonObject){
        return waybillLineItems_rateClassCode(jsonObject).getString("@id");
    }
    public static String waybillLineItems_rateClassCode_code(JSONObject jsonObject){
        return waybillLineItems_rateClassCode(jsonObject).getString("cargo:code");
    }
    public static String waybillLineItems_goodsDescriptionForRate(JSONObject jsonObject){
        String result = null;
        if (waybillLineItems(jsonObject).has("cargo:goodsDescriptionForRate")) result = waybillLineItems(jsonObject).getString("cargo:goodsDescriptionForRate");
        return result;
    }
    public static Integer waybillLineItems_pieceCountForRate(JSONObject jsonObject){
        int result = defaultInt;
        if (waybillLineItems(jsonObject).has("cargo:pieceCountForRate")) result = waybillLineItems(jsonObject).getInt("cargo:pieceCountForRate");
        return result;
    }
    public static JSONObject waybillLineItems_hsCodeForRate(JSONObject jsonObject){
        JSONObject result = null;
        if (waybillLineItems(jsonObject).has("cargo:hsCodeForRate")) result = waybillLineItems(jsonObject).getJSONObject("cargo:hsCodeForRate");
        return result;
    }
    public static String waybillLineItems_hsCodeForRate_id(JSONObject jsonObject){
        return waybillLineItems_hsCodeForRate(jsonObject).getString("@id");
    }
    public static String waybillLineItems_hsCodeForRate_code(JSONObject jsonObject){
        return waybillLineItems_hsCodeForRate(jsonObject).getString("cargo:code");
    }

    public static JSONObject otherCharges(JSONObject jsonObject){
        return jsonObject.getJSONArray("cargo:otherCharges").getJSONObject(0);
    }
    public static String otherCharges_id(JSONObject jsonObject){
        return otherCharges(jsonObject).getString("@id");
    }
    public static JSONObject otherCharges_otherChargeCode(JSONObject jsonObject){
        JSONObject result = null;
        if (otherCharges(jsonObject).has("cargo:otherChargeCode")) result = otherCharges(jsonObject).getJSONObject("cargo:otherChargeCode");
        return result;
    }
    public static String otherCharges_otherChargeCode_id(JSONObject jsonObject){
        return otherCharges_otherChargeCode(jsonObject).getString("@id");
    }
    public static String otherCharges_otherChargeCode_code(JSONObject jsonObject){
        return otherCharges_otherChargeCode(jsonObject).getString("cargo:code");
    }
    public static JSONObject otherCharges_chargePaymentType(JSONObject jsonObject){
        return otherCharges(jsonObject).getJSONObject("cargo:chargePaymentType");
    }
    public static String otherCharges_chargePaymentType_id(JSONObject jsonObject){
        return otherCharges_chargePaymentType(jsonObject).getString("@id");
    }
    public static String otherCharges_chargePaymentType_code(JSONObject jsonObject){
        return otherCharges_chargePaymentType(jsonObject).getString("cargo:code");
    }
    public static JSONObject otherCharges_entitlement(JSONObject jsonObject){
        return otherCharges(jsonObject).getJSONObject("cargo:entitlement");
    }
    public static String otherCharges_entitlement_id(JSONObject jsonObject){
        return otherCharges_entitlement(jsonObject).getString("@id");
    }
    public static String otherCharges_entitlement_code(JSONObject jsonObject){
        return otherCharges_entitlement(jsonObject).getString("cargo:code");
    }
    public static JSONObject otherCharges_otherChargeAmount(JSONObject jsonObject){
        return otherCharges(jsonObject).getJSONObject("cargo:otherChargeAmount");
    }
    public static String otherCharges_otherChargeAmount_id(JSONObject jsonObject){
        return otherCharges_otherChargeAmount(jsonObject).getString("@id");
    }
    public static String otherCharges_otherChargeAmount_numericalValue(JSONObject jsonObject){
        return otherCharges_otherChargeAmount(jsonObject).getString("cargo:numericalValue");
    }
    public static JSONObject otherCharges_otherChargeAmount_currencyUnit(JSONObject jsonObject){
        return otherCharges_otherChargeAmount(jsonObject).getJSONObject("cargo:currencyUnit");
    }
    public static String OC_otherChargeAmount_currencyUnit_id(JSONObject jsonObject){
        return otherCharges_otherChargeAmount(jsonObject).getString("@id");
    }
    public static String OC_otherChargeAmount_currencyUnit_code(JSONObject jsonObject){
        return otherCharges_otherChargeAmount(jsonObject).getString("cargo:code");
    }

    public static JSONObject shipment(JSONObject jsonObject){
        return jsonObject.getJSONObject("cargo:shipment");
    }
    public static String shipment_id(JSONObject jsonObject){
        return shipment(jsonObject).getString("@id");
    }
    public static JSONObject shipment_customsInformation(JSONObject jsonObject, int index){
        return shipment(jsonObject).getJSONArray("cargo:customsInformation").getJSONObject(index);
    }
    public static String shipment_customsInformation_id(JSONObject jsonObject, int index){
        return shipment_customsInformation(jsonObject, index).getString("@id");
    }
    public static String shipment_customsInformation_note(JSONObject jsonObject, int index){
        return shipment_customsInformation(jsonObject, index).getString("cargo:note");
    }
    public static JSONObject shipment_customsInformation_contentCode(JSONObject jsonObject, int index){
        return shipment_customsInformation(jsonObject, index).getJSONObject("cargo:contentCode");
    }
    public static String S_customsInformation_contentCode_id(JSONObject jsonObject, int index){
        return shipment_customsInformation_contentCode(jsonObject, index).getString("@id");
    }
    public static String S_customsInformation_contentCode_code(JSONObject jsonObject, int index){
        return shipment_customsInformation_contentCode(jsonObject, index).getString("cargo:code");
    }
    public static JSONObject shipment_customsInformation_country(JSONObject jsonObject, int index){
        return shipment_customsInformation(jsonObject, index).getJSONObject("cargo:country");
    }
    public static String S_customsInformation_country_id(JSONObject jsonObject, int index){
        return shipment_customsInformation_country(jsonObject, index).getString("@id");
    }
    public static String S_customsInformation_country_code(JSONObject jsonObject, int index){
        return shipment_customsInformation_country(jsonObject, index).getString("cargo:code");
    }
    public static JSONObject shipment_customsInformation_subjectCode(JSONObject jsonObject, int index){
        return shipment_customsInformation(jsonObject, index).getJSONObject("cargo:subjectCode");
    }
    public static String S_customsInformation_subjectCode_id(JSONObject jsonObject, int index){
        return shipment_customsInformation_subjectCode(jsonObject, index).getString("@id");
    }
    public static String S_customsInformation_subjectCode_code(JSONObject jsonObject, int index){
        return shipment_customsInformation_subjectCode(jsonObject, index).getString("cargo:code");
    }
    public static JSONObject shipment_insurance(JSONObject jsonObject){
        return shipment(jsonObject).getJSONObject("cargo:insurance");
    }
    public static String shipment_insurance_id(JSONObject jsonObject){
        return shipment_insurance(jsonObject).getString("@id");
    }
    public static String shipment_insurance_numericalValue(JSONObject jsonObject){
        return shipment_insurance(jsonObject).getString("cargo:numericalValue");
    }
    public static String shipment_insurance_currencyUnit(JSONObject jsonObject){
        return shipment_insurance(jsonObject).getString("cargo:currencyUnit");
    }
    public static JSONObject shipment_pieces(JSONObject jsonObject){
        return shipment(jsonObject).getJSONArray("cargo:pieces").getJSONObject(0);
    }
    public static String shipment_pieces_id(JSONObject jsonObject){
        return shipment_pieces(jsonObject).getString("@id");
    }
    public static JSONObject shipment_pieces_involvedInActions(JSONObject jsonObject){
        return shipment_pieces(jsonObject).getJSONObject("cargo:involvedInActions");
    }
    public static String S_pieces_involvedInActions_id(JSONObject jsonObject){
        return shipment_pieces_involvedInActions(jsonObject).getString("@id");
    }
    public static JSONObject S_pieces_involvedInActions_servedActivity(JSONObject jsonObject){
        return shipment_pieces_involvedInActions(jsonObject).getJSONObject("cargo:servedActivity");
    }
    public static String S_P_involvedInActions_servedActivity_id(JSONObject jsonObject){
        return S_pieces_involvedInActions_servedActivity(jsonObject).getString("@id");
    }
    public static JSONObject S_P_IIA_servedActivity_arrivalLocation(JSONObject jsonObject){
        return S_pieces_involvedInActions_servedActivity(jsonObject).getJSONObject("cargo:arrivalLocation");
    }
    public static String S_P_IIA_SA_arrivalLocation_id(JSONObject jsonObject){
        return S_P_IIA_servedActivity_arrivalLocation(jsonObject).getString("@id");
    }
    public static JSONObject S_P_IIA_SA_arrivalLocation_locationCodes(JSONObject jsonObject){
        return S_P_IIA_servedActivity_arrivalLocation(jsonObject).getJSONArray("cargo:locationCodes").getJSONObject(0);
    }
    public static String S_P_IIA_SA_AL_locationCodes_id(JSONObject jsonObject){
        return S_P_IIA_SA_arrivalLocation_locationCodes(jsonObject).getString("@id");
    }
    public static String S_P_IIA_SA_AL_locationCodes_code(JSONObject jsonObject){
        return S_P_IIA_SA_arrivalLocation_locationCodes(jsonObject).getString("cargo:code");
    }
    public static String S_P_IIA_SA_arrivalLocation_locationName(JSONObject jsonObject){
        return S_P_IIA_servedActivity_arrivalLocation(jsonObject).getString("cargo:locationName");
    }
    public static String S_P_IIA_SA_arrivalLocation_locationType(JSONObject jsonObject){
        return S_P_IIA_servedActivity_arrivalLocation(jsonObject).getString("cargo:locationType");
    }
    public static JSONObject S_P_IIA_servedActivity_departureLocation(JSONObject jsonObject){
        return S_pieces_involvedInActions_servedActivity(jsonObject).getJSONObject("cargo:departureLocation");
    }
    public static String S_P_IIA_SA_departureLocation_id(JSONObject jsonObject){
        return S_P_IIA_servedActivity_departureLocation(jsonObject).getString("@id");
    }
    public static JSONObject S_P_IIA_SA_departureLocation_locationCodes(JSONObject jsonObject){
        return S_P_IIA_servedActivity_departureLocation(jsonObject).getJSONArray("cargo:locationCodes").getJSONObject(0);
    }
    public static String S_P_IIA_SA_DL_locationCodes_id(JSONObject jsonObject){
        return S_P_IIA_SA_departureLocation_locationCodes(jsonObject).getString("@id");
    }
    public static String S_P_IIA_SA_DL_locationCodes_code(JSONObject jsonObject){
        return S_P_IIA_SA_departureLocation_locationCodes(jsonObject).getString("cargo:code");
    }
    public static String S_P_IIA_SA_departureLocation_locationName(JSONObject jsonObject){
        return S_P_IIA_servedActivity_departureLocation(jsonObject).getString("cargo:locationName");
    }
    public static String S_P_IIA_SA_departureLocation_locationType(JSONObject jsonObject){
        return S_P_IIA_servedActivity_departureLocation(jsonObject).getString("cargo:locationType");
    }
    public static JSONObject S_P_involvedInActions_servedActivity_modeCode(JSONObject jsonObject){
        return S_pieces_involvedInActions_servedActivity(jsonObject).getJSONObject("cargo:modeCode");
    }
    public static String S_P_IIA_servedActivity_modeCode_id(JSONObject jsonObject){
        return S_P_involvedInActions_servedActivity_modeCode(jsonObject).getString("@id");
    }
    public static String S_P_IIA_servedActivity_modeCode_code(JSONObject jsonObject){
        return S_P_involvedInActions_servedActivity_modeCode(jsonObject).getString("cargo:code");
    }
    public static JSONObject S_P_involvedInActions_servedActivity_modeQualifier(JSONObject jsonObject){
        return S_pieces_involvedInActions_servedActivity(jsonObject).getJSONObject("cargo:modeQualifier");
    }
    public static String S_P_IIA_servedActivity_modeQualifier_id(JSONObject jsonObject){
        return S_P_involvedInActions_servedActivity_modeQualifier(jsonObject).getString("@id");
    }
    public static String S_P_IIA_servedActivity_modeQualifier_code(JSONObject jsonObject){
        return S_P_involvedInActions_servedActivity_modeQualifier(jsonObject).getString("cargo:code");
    }
    public static JSONObject S_P_involvedInActions_servedActivity_movementTimes(JSONObject jsonObject){
        return S_pieces_involvedInActions_servedActivity(jsonObject).getJSONArray("cargo:movementTimes").getJSONObject(0);
    }
    public static String S_P_IIA_servedActivity_movementTimes_id(JSONObject jsonObject){
        return S_P_involvedInActions_servedActivity_movementTimes(jsonObject).getString("@id");
    }
    public static String S_P_IIA_servedActivity_movementTimes_movementTimestamp(JSONObject jsonObject){
        return S_P_involvedInActions_servedActivity_movementTimes(jsonObject).getString("cargo:movementTimestamp");
    }
    public static JSONObject S_P_IIA_servedActivity_movementTimes_movementTimeType(JSONObject jsonObject){
        return S_P_involvedInActions_servedActivity_movementTimes(jsonObject).getJSONObject("cargo:movementTimeType");
    }
    public static String S_P_IIA_SA_movementTimes_movementTimeType_id(JSONObject jsonObject){
        return S_P_IIA_servedActivity_movementTimes_movementTimeType(jsonObject).getString("@id");
    }
    public static String S_P_IIA_SA_movementTimes_movementTimeType_code(JSONObject jsonObject){
        return S_P_IIA_servedActivity_movementTimes_movementTimeType(jsonObject).getString("cargo:code");
    }
    public static JSONObject S_P_involvedInActions_servedActivity_operatingTransportMeans(JSONObject jsonObject){
        return S_pieces_involvedInActions_servedActivity(jsonObject).getJSONObject("cargo:operatingTransportMeans");
    }
    public static String S_P_IIA_servedActivity_operatingTransportMeans_id(JSONObject jsonObject){
        return S_P_involvedInActions_servedActivity_operatingTransportMeans(jsonObject).getString("@id");
    }
    public static String S_P_IIA_servedActivity_operatingTransportMeans_vehicleRegistration(JSONObject jsonObject){
        return S_P_involvedInActions_servedActivity_operatingTransportMeans(jsonObject).getString("cargo:vehicleRegistration");
    }
    public static String S_P_IIA_servedActivity_operatingTransportMeans_vehicleSize(JSONObject jsonObject){
        return S_P_involvedInActions_servedActivity_operatingTransportMeans(jsonObject).getString("cargo:vehicleSize");
    }
    public static JSONObject S_P_IIA_servedActivity_operatingTransportMeans_transportOrganization(JSONObject jsonObject){
        return S_P_involvedInActions_servedActivity_operatingTransportMeans(jsonObject).getJSONObject("cargo:transportOrganization");
    }
    public static String S_P_IIA_SA_operatingTransportMeans_transportOrganization_id(JSONObject jsonObject){
        return S_P_IIA_servedActivity_operatingTransportMeans_transportOrganization(jsonObject).getString("@id");
    }
    public static String S_P_IIA_SA_operatingTransportMeans_transportOrganization_airlineCode(JSONObject jsonObject){
        return S_P_IIA_servedActivity_operatingTransportMeans_transportOrganization(jsonObject).getString("cargo:airlineCode");
    }
    public static JSONObject S_P_IIA_servedActivity_operatingTransportMeans_vehicleType(JSONObject jsonObject){
        return S_P_involvedInActions_servedActivity_operatingTransportMeans(jsonObject).getJSONObject("cargo:vehicleType");
    }
    public static String S_P_IIA_SA_operatingTransportMeans_vehicleType_id(JSONObject jsonObject){
        return S_P_IIA_servedActivity_operatingTransportMeans_vehicleType(jsonObject).getString("@id");
    }
    public static String S_P_IIA_SA_operatingTransportMeans_vehicleType_code(JSONObject jsonObject){
        return S_P_IIA_servedActivity_operatingTransportMeans_vehicleType(jsonObject).getString("cargo:code");
    }
    public static String S_P_IIA_servedActivity_transportIdentifier(JSONObject jsonObject){
        return S_pieces_involvedInActions_servedActivity(jsonObject).getString("cargo:transportIdentifier");
    }
    public static JSONObject S_pieces_involvedInActions_loadingType(JSONObject jsonObject){
        return shipment_pieces_involvedInActions(jsonObject).getJSONObject("cargo:loadingType");
    }
    public static String S_P_involvedInActions_loadingType_id(JSONObject jsonObject){
        return S_pieces_involvedInActions_loadingType(jsonObject).getString("@id");
    }
    public static String S_P_involvedInActions_loadingType_code(JSONObject jsonObject){
        return S_pieces_involvedInActions_loadingType(jsonObject).getString("cargo:code");
    }
    public static JSONArray shipment_specialHandlingCodes(JSONObject jsonObject){
        return shipment(jsonObject).getJSONArray("cargo:specialHandlingCodes");
    }
    public static JSONObject shipment_specialHandlingCodes(JSONObject jsonObject, int index){
        return shipment(jsonObject).getJSONArray("cargo:specialHandlingCodes").getJSONObject(index);
    }
    public static String shipment_specialHandlingCodes_id(JSONObject jsonObject, int index){
        return shipment_specialHandlingCodes(jsonObject, index).getString("@id");
    }
    public static String shipment_specialHandlingCodes_code(JSONObject jsonObject, int index){
        return shipment_specialHandlingCodes(jsonObject, index).getString("cargo:code");
    }
    public static JSONObject shipment_totalGrossWeight(JSONObject jsonObject){
        return shipment(jsonObject).getJSONObject("cargo:totalGrossWeight");
    }
    public static String shipment_totalGrossWeight_id(JSONObject jsonObject){
        return shipment_totalGrossWeight(jsonObject).getString("@id");
    }
    public static JSONObject shipment_totalGrossWeight_unit(JSONObject jsonObject){
        return shipment_totalGrossWeight(jsonObject).getJSONObject("cargo:unit");
    }
    public static String S_totalGrossWeight_unit_id(JSONObject jsonObject){
        return shipment_totalGrossWeight_unit(jsonObject).getString("@id");
    }
    public static String S_totalGrossWeight_unit_code(JSONObject jsonObject){
        return shipment_totalGrossWeight_unit(jsonObject).getString("cargo:code");
    }
    public static String shipment_totalGrossWeight_numericalValue(JSONObject jsonObject){
        return shipment_totalGrossWeight(jsonObject).getString("cargo:numericalValue");
    }
    public static JSONArray shipment_textualHandlingInstructions(JSONObject jsonObject){
        return shipment(jsonObject).getJSONArray("cargo:textualHandlingInstructions");
    }
    public static JSONObject waybillType(JSONObject jsonObject){
        return jsonObject.getJSONObject("cargo:waybillType");
    }
    public static String waybillType_id(JSONObject jsonObject){
        return waybillType(jsonObject).getString("@id");
    }
    public static String waybillType_code(JSONObject jsonObject){
        return waybillType(jsonObject).getString("cargo:code");
    }
    public static JSONObject otherChargesIndicator(JSONObject jsonObject){
        return jsonObject.getJSONObject("cargo:otherChargesIndicator");
    }
    public static String otherChargesIndicator_id(JSONObject jsonObject){
        return otherChargesIndicator(jsonObject).getString("@id");
    }
    public static String otherChargesIndicator_code(JSONObject jsonObject){
        return otherChargesIndicator(jsonObject).getString("cargo:code");
    }
    public static JSONObject weightValuationIndicator(JSONObject jsonObject){
        return jsonObject.getJSONObject("cargo:weightValuationIndicator");
    }
    public static String weightValuationIndicator_id(JSONObject jsonObject){
        return weightValuationIndicator(jsonObject).getString("@id");
    }
    public static String weightValuationIndicator_code(JSONObject jsonObject){
        return weightValuationIndicator(jsonObject).getString("cargo:code");
    }
    public static String accountingInformation(JSONObject jsonObject){
        return jsonObject.getString("cargo:accountingInformation");
    }
    public static String carrierDeclarationDate(JSONObject jsonObject){
        return jsonObject.getString("cargo:carrierDeclarationDate");
    }
    public static String carrierDeclarationSignature(JSONObject jsonObject){
        return jsonObject.getString("cargo:carrierDeclarationSignature");
    }
    public static String consignorDeclarationSignature(JSONObject jsonObject){
        return jsonObject.getString("cargo:consignorDeclarationSignature");
    }
    public static String shippingRefNo(JSONObject jsonObject){
        return jsonObject.getString("cargo:shippingRefNo");
    }
    public static String waybillPrefix(JSONObject jsonObject){
        return jsonObject.getString("cargo:waybillPrefix");
    }
    public static String waybillNumber(JSONObject jsonObject){
        return jsonObject.getString("cargo:waybillNumber");
    }
}
