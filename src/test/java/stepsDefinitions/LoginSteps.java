package stepsDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import scripts.Commons;
import scripts.Utils;

import java.awt.*;
import java.util.ArrayList;


public class LoginSteps {
    //@Given("^The user visit the '(.*)'$")
   // public void navigateTo (String URL){
     //   Commons.navigateTo(URL);
   // }

    //alt+enter
    @When("^The user type username: '(.*)' and password: '(.*)'$")
    public void enterUserAndPass (String user, String pass){
        LoginPage.enterUser(user);
        LoginPage.enterPass(pass);
    }

    @When("^The user click on login button$")
    public void clickLoginButton (){
        LoginPage.clickLoginButton();
    }

    @Then("^Access displays a message: '(.*)'$")
    public void showErrorMessage (String expectedMessage) {
        String actualMessage = LoginPage.showErrorMessage();
        Assert.assertEquals("the message its not correct. \n actual message: " + actualMessage + " \n expected message: " + expectedMessage, expectedMessage, actualMessage);
    }

    @Then("^The error div background color is red: '(.*)'$")
    public void compareBackgroundColor (String color){
        String backgroundColor = LoginPage.backgroundColor();
        Assert.assertEquals("the color is wrong: ", color, Utils.convertColorToHex(backgroundColor));
    }

    @Then("^The error div text color is white: '(.*)'$")
    public void compareTextColor (String color){
        String textColor = LoginPage.textColor();
        Assert.assertEquals("the color is wrong: ", color, Utils.convertColorToHex(textColor));
    }

    @Then("^The color div X is white: '(.*)'$")
    public void compareXColor (String color) {
        String XColor = LoginPage.textColor();
        Assert.assertEquals("the color is wrong: ", color, Utils.convertColorToHex(XColor));
    }



}
