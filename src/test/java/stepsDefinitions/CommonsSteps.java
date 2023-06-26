package stepsDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import scripts.Commons;

public class CommonsSteps  {
    @Given("^The user visit the orange page: '(.*)'")
    public void navigateTo(String URL) {
        Commons.navigateTo(URL);
    }

}
