package stepsDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CardShoppingPage;
import pages.LoginPage;
import scripts.Commons;
import scripts.Utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CardShoppingSteps {

    @Then("^The user click a product or products$")
    public void productClick (DataTable data){
        List<String> productList = data.asList();

        for (int i = 0; i < productList.size(); i++) {
            CardShoppingPage.clickOnProduct(productList.get(i));
        }
    }

    @Then("^The button color became: '(.*)'$")
    public void buttonChangeColor (String color, DataTable data){
        List<String> productList = data.asList();

        for (int i = 0; i < productList.size(); i++) {
            String textColor = CardShoppingPage.buttonTextColor(productList.get(i));
            Assert.assertEquals("the color is wrong: ", color, Utils.convertColorToHex(textColor));
        }
    }

    @Then("^The button text became: '(.*)'$" )
    public void buttonChangeText (String text) {
        String actualMessage = CardShoppingPage.buttonText(text);
        Assert.assertEquals( text, actualMessage);
    }

}
