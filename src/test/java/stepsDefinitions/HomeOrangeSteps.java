package stepsDefinitions;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.OrangeHomePage;


public class HomeOrangeSteps {
    @When("^Verify if the side panel is visible$")
    public void sidePanelVisible() {
        Assert.assertTrue("the panel is not visible", OrangeHomePage.visibleSidePanel());
    }

    @When("^The user click on menu element: '(.*)'$")
    public void clickSidePanelItem(String pageName) {
        OrangeHomePage.goToPage(pageName);
        Assert.assertEquals(pageName, OrangeHomePage.getTextTitle(pageName));
    }

    @When("^The user write some text in the side panel: '(.*)'$")
    public static void lookAndWrite(String css) {
        OrangeHomePage.getElementByCssClassName(css);
    }

    @When("^Check by id=app$")
    public static void checkById (){
        OrangeHomePage.getElementById();
    }

    @When("^Check by tagName div who has img first child$")
    public static void checkByTagName (){
        OrangeHomePage.getElementByTagName();
    }
}
