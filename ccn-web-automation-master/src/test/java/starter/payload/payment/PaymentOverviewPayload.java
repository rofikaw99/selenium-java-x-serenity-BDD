package starter.payload.payment;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PaymentOverviewPayload {

    public static JSONObject payload;

    public static JSONObject retrievePaymentOverview(String type){
        JSONObject sortBy = new JSONObject();
        sortBy.put("column", "reference");
        sortBy.put("order", "asc");

        List<String> filterSearch = new ArrayList<>();

        payload = new JSONObject();
        payload.put("pagination", 10);
        payload.put("page", 1);
        payload.put("search", "");
        payload.put("sortBy", sortBy);
        payload.put("type", type);
        payload.put("filterSearch", filterSearch);
        return payload;
    }

    public static JSONObject retrievePaymentOverview(String type, String status){
        JSONObject sortBy = new JSONObject();
        sortBy.put("column", "reference");
        sortBy.put("order", "asc");

        List<String> filterSearch = new ArrayList<>();
        filterSearch.add("status");

        payload = new JSONObject();
        payload.put("pagination", 10);
        payload.put("page", 1);
        payload.put("search", status);
        payload.put("sortBy", sortBy);
        payload.put("type", type);
        payload.put("filterSearch", filterSearch);
        return payload;
    }

    public static JSONObject retrievePaymentRequest(List<String> payIds){
        payload = new JSONObject();
        payload.put("paymentRequestIds", payIds);
        return payload;
    }

    public static JSONObject createPaymentRequest(){
        JSONObject meta = new JSONObject();

        List<JSONObject> list = new ArrayList<>();
        JSONObject items = new JSONObject();
        items.put("description", "item 1 description");
        items.put("amount", "1000");
        list.add(items);
        meta.put("items", list);

        payload = new JSONObject();
        payload.put("externalReferenceId", "EXT-123" + new Random().nextInt(100));
        payload.put("reference", "TEST-PAYMENT, REF-1259, 1146, 4567, ABC");
        payload.put("totalChargeAmount", 1000);
        payload.put("currency", "USD");
        payload.put("status", "READY");
        payload.put("chargeDateTime", "2024-09-24");
        payload.put("meta", meta);
        return payload;
    }

    public static JSONObject delegatePaymentRequest(String payId, String emailCompany){
        List<JSONObject> paymentRequest = new ArrayList<>();
        JSONObject paymentRequests = new JSONObject();
        paymentRequests.put("paymentRequestId", payId);

        JSONObject delegateTo = new JSONObject();
        delegateTo.put("companyEmail", emailCompany);
        delegateTo.put("companyName", "SG Auto QA");

        paymentRequests.put("delegateTo", delegateTo);
        paymentRequest.add(paymentRequests);

        payload = new JSONObject();
        payload.put("delegatePaymentRequest", paymentRequest);
        return payload;
    }
}
