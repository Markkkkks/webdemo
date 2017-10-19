import net.sf.json.JSONObject;

public class Utils {
    public static String getJsonString(JSONObject[] jsonObjects) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < jsonObjects.length-1; i++) {
            sb.append(jsonObjects[i]+",");

        }
        sb.append(jsonObjects[jsonObjects.length-1]);
        sb.append("]");
        return sb.toString();
    }
}
