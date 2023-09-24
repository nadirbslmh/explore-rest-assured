package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateUser {
    protected String url = "https://reqres.in/api/";

    @Step("I set authorization header for the request")
    public void setAuthHeader() {
        String token = GenerateToken.generateToken();

        JSONObject requestBody = new JSONObject();

        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token);
    }

    @Step("I set API endpoint for create an user")
    public String setCreateUserEndpoint() {
        return url + "users";
    }

    @Step("I send create user request with valid inputs")
    public void sendCreateUserRequest() {
        String token = GenerateToken.generateToken();

        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "morpheus");
        requestBody.put("job","leader");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setCreateUserEndpoint());
    }

    @Step("I receive valid HTTP response code 201")
    public void receiveHttp201() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("I receive valid data for created user")
    public void receiveValidCreatedUser() {
        JsonSchemaHelper helper = new JsonSchemaHelper();

        restAssuredThat(response -> response.body("'name'", equalTo("morpheus")));
        restAssuredThat(response -> response.body("'job'", equalTo("leader")));
        restAssuredThat(response -> response.body(matchesJsonSchema(helper.getResponseSchema(JsonSchema.CREATE_USER_RESPONSE_SCHEMA))));
    }
}
