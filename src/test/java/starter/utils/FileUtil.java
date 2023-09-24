package starter.utils;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
    public static JSONObject getUser() {
        try {
            // Define the file path
            String filePath = "src/test/resources/test/user.json";

            // Read the file content
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Convert the content to a JSON object
            return new JSONObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
