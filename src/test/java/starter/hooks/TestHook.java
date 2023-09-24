package starter.hooks;

import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class TestHook {
    @Before(value = "@Register")
    public static void beforeTest() {
//        Faker faker = new Faker();
//
//        String email = faker.internet().safeEmailAddress();
//        String password = faker.internet().password(8,12);

        String email = "eve.holt@reqres.in";
        String password = "pistol";

        JSONObject requestBody = new JSONObject();

        requestBody.put("email", email);
        requestBody.put("password", password);

        String filePath = "src/test/resources/test/user.json";

        try {
            String jsonString = requestBody.toString();

            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(jsonString);
            fileWriter.close();

            System.out.println("Successfully wrote JSON object to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}