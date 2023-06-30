package stepsDefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.OrangeLoginPage;
import scripts.Commons;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


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

    @Then("^The orange user is logged$")
    public void ShowLogOut () {
        Assert.assertTrue("es true: "+ OrangeLoginPage.logOut() , OrangeLoginPage.logOut()  );
        //Assert.assertEquals("the message its not correct. \n actual message: " + logOutText + "\n expected message: " + logOutTxt, logOutText, logOutTxt);
    }

    @When("^The user click over hamburger button$")
    public void clickHamburgerButton() {
        if (OrangeLoginPage.lookForHamburger()){
            OrangeLoginPage.clickOnHamburger();
        }
    }

    @When("^Verify if the side panel is visible$")
    public void sidePanelVisible() {
        Assert.assertTrue("the panel is not visible" , OrangeLoginPage.visibleSidePanel());
    }

    @When("^The user click over all panel elements$")
    public void clickSidePanelItem() {
        List<WebElement> elements = OrangeLoginPage.listItems();

        List<String> textElements = new ArrayList<>();

        for(int i = 0; i< elements.size(); i++){
            textElements.add(elements.get(i).getText());
        }

            for(int i = 0; i < textElements.size(); i++){
                if(!textElements.get(i).equals("Maintenance")) {
                    OrangeLoginPage.listItems();
                    OrangeLoginPage.clickListItem(i + 1);
                    if (OrangeLoginPage.lookForHamburger()){
                        OrangeLoginPage.clickOnHamburger();
                    }
                }
            }

    }
    //  if (OrangeLoginPage.lookForHamburger()){
     //         OrangeLoginPage.clickOnHamburger();


}
