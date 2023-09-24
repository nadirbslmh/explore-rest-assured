package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.FileUtil;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class Register {
    protected String url = "https://reqres.in/api/";

    @Step("I set api endpoint for register")
    public String setPostApiEndpointRegister() {
        return url + "register";
    }

    @Step("I send request for register")
    public void sendPostHttpRequestRegister() {
        JSONObject requestBody = FileUtil.getUser();

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setPostApiEndpointRegister());
    }

    @Step("I receive valid data for new user")
    public void validateNewUser() {
        restAssuredThat(response -> response.body("'token'", notNullValue()));

    }
}
