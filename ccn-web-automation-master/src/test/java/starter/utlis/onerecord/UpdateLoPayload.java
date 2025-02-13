package starter.utlis.onerecord;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UpdateLoPayload {

    public static void updateActualData(JSONObject payload, Object actualData, int index) {
        JSONArray operations = payload.optJSONArray("api:hasOperation");
        if (operations != null && operations.length() > 0) {
            JSONObject firstOperation = operations.getJSONObject(index);
            JSONArray operationObjects = firstOperation.optJSONArray("api:o");
            if (operationObjects != null && operationObjects.length() > 0) {
                JSONObject operationObject = operationObjects.getJSONObject(0);
                operationObject.put("api:hasValue", actualData);
            }
        }
    }

    public static void deleteTheSpecificOperation(JSONObject payload, int index) {
        JSONArray operations = payload.optJSONArray("api:hasOperation");
        if (operations != null && operations.length() > 0) {
            operations.remove(index);
        }
    }

    public static void changesTheSpecificOperation(JSONObject payload, int index, String operation) {
        JSONArray operations = payload.optJSONArray("api:hasOperation");
        if (operations != null && operations.length() > 0) {
            operations.remove(index);
        }
    }

    public static void updateOperationIds(JSONObject payload, String id, int startIndex, int endIndex) {
        JSONArray operations = payload.optJSONArray("api:hasOperation");
        if (operations != null) {
            for (int i = startIndex; i < endIndex; i++) {
                JSONObject operation = operations.getJSONObject(i);
                operation.put("api:s", id);
            }
        }
    }

    public static void updateOperationIds(JSONObject payload, String id) {
        JSONArray operations = payload.optJSONArray("api:hasOperation");
        if (operations != null) {
            for (int i = 0; i < operations.length(); i++) {
                JSONObject operation = operations.getJSONObject(i);
                operation.put("api:s", id);
            }
        }
    }

    public static Object getOperationIds(JSONObject payload, int index){
        Object result = "";
        JSONArray operations = payload.optJSONArray("api:hasOperation");
        if (operations != null) {
            result = operations.getJSONObject(index).get("api:s");
        }
        return result;
    }

    public static List<Object> getOperationIds(JSONObject payload, int startIndex, int endIndex){
        List<Object> result = new ArrayList<>();
        JSONArray operations = payload.getJSONObject("changeObject").optJSONArray("api:hasOperation");
        if (operations != null) {
            for (int i = startIndex; i < endIndex; i++){
                result.add(operations.getJSONObject(i).get("api:s"));
            }
        }
        return result;
    }

    public static Object getHasValueOfHasOperation(JSONObject payload, int index){
        Object result = "";
        JSONArray operations = payload.optJSONArray("api:hasOperation");
        if (operations != null && operations.length() > 0) {
            JSONObject firstOperation = operations.getJSONObject(index);
            JSONArray operationObjects = firstOperation.optJSONArray("api:o");
            if (operationObjects != null && operationObjects.length() > 0) {
                JSONObject operationObject = operationObjects.getJSONObject(0);
                result = operationObject.get("api:hasValue");
            }
        }
        return result;
    }

    public static String getDescription(JSONObject payload){
        return payload.getString("api:hasDescription");
    }

    public static void updateLogisticsObjectId(JSONObject payload, String id) {
        JSONObject logisticsObject = payload.optJSONObject("api:hasLogisticsObject");
        if (logisticsObject != null) {
            logisticsObject.put("@id", id);
        }
    }

    public static void updateRevision(JSONObject payload, Integer revision) {
        JSONObject hasRevision = payload.optJSONObject("api:hasRevision");
        if (hasRevision != null) {
            hasRevision.put("@value", String.valueOf(revision));
        }
    }

    public static void updateVerificationRequest(JSONObject payload, String id) {
        List<JSONObject> verificationId = new ArrayList<>();
        JSONObject ids = new JSONObject();
        ids.put("@id", id);
        verificationId.add(ids);
        payload.put("api:hasVerificationRequest", verificationId);
    }
}
