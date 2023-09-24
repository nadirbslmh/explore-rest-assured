package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.CreateUser;

public class CreateUserSteps {
    @Steps
    CreateUser createUser;

    @Given("I set authorization header for the request")
    public void setAuthHeader() {
        createUser.setAuthHeader();
    }

    @Given("I set API endpoint for create an user")
    public void setCreateUserEndpoint() {
        createUser.setCreateUserEndpoint();
    }

    @When("I send create user request with valid inputs")
    public void sendCreateUserRequest() {
        createUser.sendCreateUserRequest();
    }

    @Then("I receive valid HTTP response code 201")
    public void receiveHttp201() {
        createUser.receiveHttp201();
    }

    @And("I receive valid data for created user")
    public void receiveValidCreatedUser() {
        createUser.receiveValidCreatedUser();
    }
}
