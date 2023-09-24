package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Login;

public class LoginSteps {
    @Steps
    Login loginSteps;

    @Given("I set API endpoint for login")
    public void setLoginApiEndpoint() {
        loginSteps.setLoginApiEndpoint();
    }

    @When("I send login request with valid credentials")
    public void sendLoginRequest() {
        loginSteps.sendLoginRequest();
    }

    @Then("I receive valid HTTP response code 200")
    public void receiveValidHttp200() {
        loginSteps.receiveValidHttp200();
    }

    @And("I receive valid data for login")
    public void receiveValidDataForLogin() {
        loginSteps.receiveValidDataForLogin();
    }
}
