package scripts;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;


public class JsonReaderWithGson {
    private static String JSON_FILE_PATH = "src/test/resources/propierties/Keys_EN.json";

    //este método recoge los datos del archivo json guardado en resources / propierties
    public static JsonObject readJsonFile(String filePath) {
        try {
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(new FileReader(filePath));
            return jsonElement.getAsJsonObject();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JsonElement getSelectedValue(String... keys) {
        JsonObject json = readJsonFile(JSON_FILE_PATH);
        for (String key : keys) {
            try {
                if (json.has(key)) {
                    JsonElement element = json.get(key);
                    if (element.isJsonObject()) {
                        json = element.getAsJsonObject();
                    } else if (element.isJsonPrimitive()) {
                        return element;
                    }
                }

            } catch (IllegalStateException e) {
                throw new IllegalStateException("key not found in Json: " + key);
            }
        }
        return null;
    }
    public static String getString(String... keys){
        return getSelectedValue(keys).getAsString();
    }
}
