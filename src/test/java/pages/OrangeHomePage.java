package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import scripts.Commons;

import java.util.List;


public class OrangeHomePage {
    private static final String HAMBURGER = "//i[@class='oxd-icon bi-list oxd-topbar-header-hamburger']";
    private static final String SIDE_PANEL = "//div[@class='oxd-layout']";
    private static final String LI_ELEMENTS_SIDE_PANEL = "//ul[@class='oxd-main-menu']/li[./a/span/text()='%s']";
    private static final String ELEMENT_CLASS_CSS = "oxd-input";
    private static final String ELEMENT_ID = "app";
    private static final String ELEMENT_TAGNAME = "body";
    private static final String ELEMENT_CSS_SELECTOR = ".orangehrm-login-container";



    public static void clickOnHamburger() {
        WebElement hamburgerClicked = Commons.findElementVisibleByXpath(HAMBURGER);
        Commons.click(hamburgerClicked);
    }

    public static void getElementByCssClassName(String css) {
        WebElement elementCSS = Commons.findElementVisibleByClassName(ELEMENT_CLASS_CSS);
        Commons.setText(elementCSS, css);
    }

        public static WebElement getElementById () {
            WebElement elementId = Commons.findElementVisibleById(ELEMENT_ID);
           return elementId;
    }

    public static List<WebElement> getElementByTagName () {
        List<WebElement> elementagTagName = Commons.findElementVisibleByTagName(ELEMENT_TAGNAME).findElements(By.tagName("div"));
        return elementagTagName;
    }

    public static WebElement getElementByCssSelector () {
        WebElement cssSelector = Commons.findElementVisibleByCssSelector(ELEMENT_CSS_SELECTOR);
        return cssSelector;
    }

    public static boolean lookForHamburger() {
        WebElement logoDisplay = Commons.findElementByXpath(HAMBURGER);
        return Commons.elementIsDisplayed(logoDisplay);
    }

    public static Boolean visibleSidePanel() {
        WebElement sidePanel = Commons.findElementVisibleByXpath(SIDE_PANEL);
        return Commons.elementIsDisplayed(sidePanel);
    }


    public static void  goToPage(String page) {
        if (lookForHamburger()){
            clickOnHamburger();
        }
        WebElement item = Commons.findElementVisibleByXpath(LI_ELEMENTS_SIDE_PANEL.formatted(page));
        Commons.click(item);
    }

    public static String getTextTitle (String pageName){
        WebElement text =Commons.findElementByText("h6", pageName);
        return Commons.getText(text);

    }
}
