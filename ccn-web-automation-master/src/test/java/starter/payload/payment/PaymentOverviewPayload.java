package starter.payload.payment;

import org.json.JSONObject;
import starter.utlis.ApiProperties;
import starter.utlis.Common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PaymentOverviewPayload {

    public static JSONObject payload;

    public static JSONObject retrievePaymentOverview(String type, int pagination){
        JSONObject sortBy = new JSONObject();
        sortBy.put("column", "reference");
        sortBy.put("order", "asc");

        List<String> filterSearch = new ArrayList<>();

        payload = new JSONObject();
        payload.put("pagination", pagination);
        payload.put("page", 1);
        payload.put("search", "");
        payload.put("sortBy", sortBy);
        payload.put("type", type);
        payload.put("filterSearch", filterSearch);
        return payload;
    }

    public static JSONObject retrievePaymentOverview(String type, JSONObject filters){
        JSONObject sortBy = new JSONObject();
        sortBy.put("column", "reference");
        sortBy.put("order", "asc");

        List<String> filterSearch = new ArrayList<>();
        filterSearch.add((String) filters.get("filter"));

        payload = new JSONObject();
        payload.put("pagination", 10);
        payload.put("page", 1);
        payload.put("search", filters.get("keyword"));
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

    public static JSONObject retrievePaymentOverview(String type, String column, String order){
        JSONObject sortBy = new JSONObject();
        sortBy.put("column", column);
        sortBy.put("order", order);

        List<String> filterSearch = new ArrayList<>();

        payload = new JSONObject();
        payload.put("pagination", 50);
        payload.put("page", 1);
        payload.put("search", "");
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

    public static JSONObject createPaymentRequest(String product){
        JSONObject meta = new JSONObject();

        List<JSONObject> list = new ArrayList<>();
        JSONObject items = new JSONObject();
        items.put("description", "item 1 description");
        items.put("amount", 1000);
        list.add(items);
        meta.put("items", list);

        payload = new JSONObject();
        payload.put("externalReferenceId", "EXT-123" + new Random().nextInt(10000));
//        payload.put("reference", product.toUpperCase() + Common.idForPayment() +",TDSB01, 0001");
        payload.put("reference", product.toUpperCase() + Common.idForPayment());
        payload.put("totalChargeAmount", 1000);
        payload.put("currency", "USD");
        payload.put("status", "UPCOMING");
        payload.put("chargeDateTime", Common.chargeDateTimePayment("MINUTES", 0));
        payload.put("meta", meta);
        return payload;
    }

    public static JSONObject createPaymentRequest(String product, int amount, JSONObject reportReference){
        JSONObject meta = new JSONObject();

        List<JSONObject> list = new ArrayList<>();
        JSONObject items = new JSONObject();
        items.put("description", "item 1 description");
        items.put("amount", amount);
        list.add(items);
        meta.put("items", list);

        payload = new JSONObject();
        payload.put("externalReferenceId", "EXT-123" + new Random().nextInt(10000));
        payload.put("reference", product.toUpperCase() + Common.idForPayment());
        payload.put("totalChargeAmount", amount);
        payload.put("currency", "USD");
        payload.put("status", "UPCOMING");
        payload.put("chargeDateTime", Common.chargeDateTimePayment("MINUTES", 0));
        payload.put("meta", meta);
        payload.put("reportReference", reportReference);
        return payload;
    }

    public static JSONObject createPaymentRequest(String product, int amount, String chargeDateTime, String deductionDate, String expiredDate, String notes){
        JSONObject meta = new JSONObject();
        String currency = null;

        List<JSONObject> list = new ArrayList<>();
        JSONObject items = new JSONObject();
        items.put("description", "item 1 description");
        items.put("amount", amount);
        list.add(items);
        meta.put("items", list);

        if (product.equals("tdsb")) currency = "SGD";
        else if (product.equals("svs")) currency = "USD";
        payload = new JSONObject();
        payload.put("externalReferenceId", "EXT-123" + new Random().nextInt(100000));
        payload.put("reference", product.toUpperCase() + Common.idForPayment());
        payload.put("totalChargeAmount", amount);
        payload.put("currency", currency);
        payload.put("status", "UPCOMING");
        payload.put("chargeDateTime", chargeDateTime);
        payload.put("deductionDateTime", deductionDate);
        payload.put("expiredDateTime", expiredDate);
        payload.put("dueDate", expiredDate);
        payload.put("meta", meta);

        if (chargeDateTime.isEmpty()) {
            payload.put("status", "READY");
            payload.put("chargeDateTime", Common.chargeDateTimePayment("MINUTES", 0));
        }
        if (expiredDate.isEmpty()) payload.remove("expiredDateTime");
        if (deductionDate.isEmpty()) payload.remove("deductionDateTime");
        if (!notes.isEmpty()){
            List<String> notesList = List.of(notes);
            payload.put("notes", notesList);
        }
        return payload;
    }

    public static JSONObject updatePaymentRequest(String payId, String status){
        payload = new JSONObject();
        payload.put("paymentRequestId", payId);
        payload.put("status", status);
        return payload;
    }

    public static JSONObject updatePaymentRequest(String payId, String status, String notes){
        payload = new JSONObject();
        payload.put("paymentRequestId", payId);
        payload.put("status", status);
        payload.put("notes", List.of(notes, notes));
        if (status.isEmpty()) payload.remove("status");
        return payload;
    }

    public static JSONObject delegatePaymentRequest(String payId, String emailCompany, String companyName){
        List<JSONObject> paymentRequest = new ArrayList<>();
        JSONObject paymentRequests = new JSONObject();
        paymentRequests.put("paymentRequestId", payId);

        JSONObject delegateTo = new JSONObject();
        delegateTo.put("companyEmail", emailCompany);
        delegateTo.put("companyName", companyName);

        paymentRequests.put("delegateTo", delegateTo);
        paymentRequest.add(paymentRequests);

        payload = new JSONObject();
        payload.put("delegatePaymentRequest", paymentRequest);
        return payload;
    }

    public static JSONObject delegatePaymentRequest(List<JSONObject> paymentRequests){
        payload = new JSONObject();
        payload.put("delegatePaymentRequest", paymentRequests);
        return payload;
    }

    public static JSONObject createCheckoutSession(List<JSONObject> paymentReq){
        payload = new JSONObject();
        payload.put("email", ApiProperties.emailCompany(1));
        payload.put("payment_type", "card");
        payload.put("payment_requests", paymentReq);
        return payload;
    }

    public static JSONObject createPaymentRequestRecord(String payId, Object amount){
        payload = new JSONObject();

        payload.put("paymentRequestId", payId);
        payload.put("amount", amount);
        return payload;
    }

    public static JSONObject removePaymentDelegation(List<String> paymentRequestIds){
        payload = new JSONObject();

        payload.put("paymentRequestIds", paymentRequestIds);
        return payload;
    }

    public static JSONObject createPaymentProcess(String paymentMethodId, String product, Object amount, Boolean reattempt){
        JSONObject meta = new JSONObject();

        List<JSONObject> list = new ArrayList<>();
        JSONObject items = new JSONObject();
        items.put("description", "item 1 description");
        items.put("amount", amount);
        list.add(items);
        meta.put("items", list);

        payload = new JSONObject();
        payload.put("externalReferenceId", "EXT-123" + new Random().nextInt(10000));
        payload.put("reference", product.toUpperCase() + Common.idForPayment());
        payload.put("totalChargeAmount", amount);
        payload.put("currency", "USD");
        payload.put("isPaymentProcess", true);
        payload.put("paymentReattempt", reattempt);
        payload.put("paymentMethodId", paymentMethodId);
        payload.put("meta", meta);
        return payload;
    }

    public static JSONObject createPaymentProcess(String paymentMethodId, String externalRefId, String product){
        JSONObject meta = new JSONObject();

        List<JSONObject> list = new ArrayList<>();
        JSONObject items = new JSONObject();
        items.put("description", "item 1 description");
        items.put("amount", 100);
        list.add(items);
        meta.put("items", list);

        payload = new JSONObject();
        payload.put("externalReferenceId", externalRefId);
        payload.put("reference", product.toUpperCase() + Common.idForPayment());
        payload.put("totalChargeAmount", 100);
        payload.put("currency", "USD");
        payload.put("isPaymentProcess", true);
        payload.put("paymentMethodId", paymentMethodId);
        payload.put("meta", meta);
        return payload;
    }

    public static JSONObject refundPaymentRequest(String paymentRequestId){
        payload = new JSONObject();

        payload.put("paymentRequestId", paymentRequestId);
        return payload;
    }

    public static JSONObject createPaymentPopup(String paymentMethod, String product){
        JSONObject meta = new JSONObject();

        List<JSONObject> list = new ArrayList<>();
        JSONObject items = new JSONObject();
        items.put("description", "item 1 description");
        items.put("amount", 100);
        list.add(items);
        meta.put("items", list);

        payload = new JSONObject();
        payload.put("externalReferenceId",  "EXT-123" + new Random().nextInt(10000));
        payload.put("reference", product.toUpperCase() + Common.idForPayment());
        payload.put("totalChargeAmount", 100);
        payload.put("currency", "USD");
        payload.put("isPaymentProcess", true);
        payload.put("paymentReattempt", true);
        payload.put("paymentMethod", paymentMethod);
        payload.put("meta", meta);
        if (product.equals("tdsb")) payload.put("currency", "SGD");
        else payload.put("currency", "USD");
        return payload;
    }
}
