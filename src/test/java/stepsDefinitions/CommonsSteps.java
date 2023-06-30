package stepsDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import scripts.Commons;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import scripts.Commons;
import scripts.Configuration;


import java.util.Properties;

public class CommonsSteps  {

    // PROPERTIES PATH
    private final static Properties KEY_PROPERTIES = Configuration.KEY_PROPERTIES_FILE;

    //Driver
    private final static String DRIVER = System.getProperty("webDriver");

    @Given("^The user visit the orange page: '(.*)'")
    public void navigateTo(String URL) {
        Commons.navigateTo(URL);
    }

    @Then("^a '(.*)' is displayed with the text '(.*)'$")
    public void verifyElementHasText(String elementType, String textProperty) {
        String message = KEY_PROPERTIES.getProperty(textProperty);
        Assert.assertTrue("The " + elementType + " has not been found containing :" + message,
                Commons.verifyElementHasText(elementType, message));
    }

    @When("Mark scenario is pending when the driver is {string}")
    public void skipScenarioIfDriver(String driver){
        if(BasePage.WEB_DRIVER.equals(driver)){
            System.out.println("SKIP TEST");
            throw new PendingException("This scenarios is pending in: " + driver);
        }
    }

}








