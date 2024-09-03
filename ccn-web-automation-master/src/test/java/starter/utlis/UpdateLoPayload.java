package starter.utlis;

import org.json.JSONArray;
import org.json.JSONObject;

public class UpdateLoPayload {

    public static void updateActualData(JSONObject payload, String actualData, int index) {
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

    public static String getHasValueOfHasOperation(JSONObject payload, int index){
        String result = "";
        JSONArray operations = payload.optJSONArray("api:hasOperation");
        if (operations != null && operations.length() > 0) {
            JSONObject firstOperation = operations.getJSONObject(index);
            JSONArray operationObjects = firstOperation.optJSONArray("api:o");
            if (operationObjects != null && operationObjects.length() > 0) {
                JSONObject operationObject = operationObjects.getJSONObject(0);
                result = operationObject.getString("api:hasValue");
            }
        }
        return result;
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
}
