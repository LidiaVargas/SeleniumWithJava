package stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;

public class HomeSteps {
    @When("The user click on burguer button")
    public static void clickBurguerButton (){
        HomePage.clickBurguer();
    }

    @Then("The user is logged")
    public static void checkUserIsLogged (){
        Assert.assertTrue("the user its not logged", HomePage.checkUserIsLogged());
    }
}
