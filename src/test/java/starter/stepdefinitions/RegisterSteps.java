package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Register;

public class RegisterSteps {

    @Steps
    Register postRegister;

    @Given("I set api endpoint for register")
    public void setPostApiEndpointRegister() {
        postRegister.setPostApiEndpointRegister();
    }

    @When("I send request for register")
    public void sendPostHttpRequestRegister() {
        postRegister.sendPostHttpRequestRegister();
    }

    @Then("I receive valid data for new user")
    public void validateNewUser() {
        postRegister.validateNewUser();
    }
}
