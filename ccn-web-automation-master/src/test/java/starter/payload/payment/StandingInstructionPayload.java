package starter.payload.payment;

import org.json.JSONObject;

public class StandingInstructionPayload {

    public static JSONObject payload;

    public static JSONObject retrieveCardToken(){
        payload = new JSONObject();
        payload.put("cardDetail", true);
        return payload;
    }

    public static JSONObject retrieveCardToken(boolean isDetail){
        payload = new JSONObject();
        payload.put("cardDetail", isDetail);
        payload.put("userList", false);
        return payload;
    }

    public static JSONObject retrieveSI(String type){
        JSONObject sortBy = new JSONObject();
        sortBy.put("column", "createdAt");
        sortBy.put("order", "asc");

        payload = new JSONObject();
        payload.put("type", type);
        payload.put("pagination", 10);
        payload.put("page", 1);
        payload.put("searchSInumber", "");
        payload.put("sortBy", sortBy);
        return payload;
    }

    public static JSONObject createSI(String suppId, String suppName, String productId, String productName,
                                      String cardToken, String type, String emailCompany){
        JSONObject supplier = new JSONObject();
        supplier.put("id", suppId);
        supplier.put("name", suppName);
        supplier.put("productServiceId", productId);
        supplier.put("productName", productName);

        JSONObject limit = new JSONObject();
        limit.put("amount", 400);
        limit.put("currency", "USD");

        payload = new JSONObject();
        payload.put("supplier", supplier);
        payload.put("limit", limit);
        payload.put("limitInterval", "transaction");
        payload.put("validFrom", "2024-09-23");
        payload.put("validTo", "2024-09-30");
        payload.put("paymentMethodId", cardToken);
        payload.put("type", type);
        payload.put("paymentOwner", emailCompany);
        return payload;
    }

    public static JSONObject deleteSI(String id, String productId){
        payload = new JSONObject();

        payload.put("standingInstructionId", id);
        payload.put("supplierProductServiceId", productId);
        return payload;
    }
}
