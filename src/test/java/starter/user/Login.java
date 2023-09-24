package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Login {
    protected String url = "https://reqres.in/api/";

    @Step("I set API endpoint for login")
    public String setLoginApiEndpoint() {
        return url + "login";
    }

    @Step("I send login request with valid credentials")
    public void sendLoginRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "eve.holt@reqres.in");
        requestBody.put("password","cityslicka");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setLoginApiEndpoint());
    }

    @Step("I receive valid HTTP response code 200")
    public void receiveValidHttp200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid data for login")
    public void receiveValidDataForLogin() {
        JsonSchemaHelper helper = new JsonSchemaHelper();

        restAssuredThat(response -> response.body(matchesJsonSchema(helper.getResponseSchema(JsonSchema.LOGIN_RESPONSE_SCHEMA))));
    }
}
