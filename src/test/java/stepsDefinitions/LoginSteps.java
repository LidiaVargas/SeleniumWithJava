package stepsDefinitions;

import io.cucumber.java.en.Given;
import scripts.Commons;

public class LoginSteps {
    @Given("^The user visit the '(.*)'$")
    public void navigateTo (String URL){
        Commons.navigateTo(URL);
    }
}
