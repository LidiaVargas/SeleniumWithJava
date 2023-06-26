package stepsDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.OrangeLoginPage;
import scripts.Commons;
import scripts.Utils;

public class OrangeLoginSteps {

    @When("^The orange user type username: '(.*)' and password: '(.*)'")
    public void enterUserAndPass(String user, String pass) {
        OrangeLoginPage.enterUser(user);
        OrangeLoginPage.enterPass(pass);
    }

    @When("^The orange user click on login button$")
    public void clickLoginButton() {
        OrangeLoginPage.clickLoginButton();
    }

    @When("^The orange user click on user count button$")
    public void clickUserAccountButton() {
        OrangeLoginPage.clickUserAccountButton();
    }

    @Then("The orange user is logged '(.*)'$")
    public void ShowLogOut (String logOutTxt) {
        String logOutText = OrangeLoginPage.logOut();
        Assert.assertEquals("the message its not correct. \n actual message: " + logOutText + "\n expected message: " + logOutTxt, logOutText, logOutTxt);
    }
}