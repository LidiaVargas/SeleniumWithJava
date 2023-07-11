package stepsDefinitions;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.OrangeHomePage;


public class HomeOrangeSteps {
    @When("^Verify if the side panel is visible$")
    public void sidePanelVisible() {
        Assert.assertTrue("the panel is not visible" , OrangeHomePage.visibleSidePanel());
    }

    @When("^The user click on menu element: '(.*)'$")
    public void clickSidePanelItem(String pageName) {
        OrangeHomePage.goToPage(pageName);
        Assert.assertEquals(pageName,OrangeHomePage.getTextTitle(pageName));
    }
}
