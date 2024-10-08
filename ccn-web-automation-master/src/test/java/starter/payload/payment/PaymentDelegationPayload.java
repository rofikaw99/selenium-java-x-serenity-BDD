package starter.payload.payment;

import org.json.JSONObject;

public class PaymentDelegationPayload {
    public static JSONObject payload;

    public static JSONObject retrievePaymentDelegation(){
        JSONObject sortBy = new JSONObject();
        sortBy.put("column", "reference");
        sortBy.put("order", "asc");

        payload = new JSONObject();
        payload.put("delegateTo", true);
        payload.put("delegateFrom", false);
        payload.put("pagination", 10);
        payload.put("page", 1);
        payload.put("search", "");
        payload.put("sortBy", sortBy);
        return payload;
    }

    public static JSONObject createPaymentDelegation(String emailCompany, String productId, String suppId){
        payload = new JSONObject();
        payload.put("delegateTo", emailCompany);
        payload.put("productServiceId", productId);
        payload.put("supplierId", suppId);
        return payload;
    }

    public static JSONObject deletePaymentDelegation(String id){
        payload = new JSONObject();
        payload.put("paymentDelegationSettingId", id);
        return payload;
    }
}
