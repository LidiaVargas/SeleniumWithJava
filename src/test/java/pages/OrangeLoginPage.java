package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import scripts.Commons;

import java.util.List;

public class OrangeLoginPage {

    private static final String USERNAME_INPUT = "//input[@name='username']";
    private static final String PASSWORD_INPUT = "//input[@name='password']";
    private static final String LOGIN_BUTTON = "//button[@type='submit']";
    private static final String USER_ACCOUNT_BUTTON = "//span[@class='oxd-userdropdown-tab']";
    private static final String LOGOUT_TEXT = "//a[@href='/web/index.php/auth/logout']";
    ////a[contains(.,'Cerrar sesión')]
    ////a[contains(.,'Logout')]
    ////a[@href='/web/index.php/auth/logout']
    ////a[contains(.,'Cerrar sesión')] | //a[contains(.,'Logout')]
    private static final String HAMBURGER = "//i[@class='oxd-icon bi-list oxd-topbar-header-hamburger']";
    private static final String SIDE_PANEL = "//div[@class='oxd-layout']";
    private static final String LI_ELEMENTS_SIDE_PANEL = "//ul[@class='oxd-main-menu']";
    private static final String LI_ELEMENTS_SIDE_PANEL_BY_POSITION = "//ul[@class='oxd-main-menu']/li[%s]";


    public static void enterUser(String user) {
        WebElement username = Commons.findElementVisibleByXpath(USERNAME_INPUT);
        Commons.setText(username, user);
    }

    public static void enterPass(String pass) {
        WebElement password = Commons.findElementVisibleByXpath(PASSWORD_INPUT);
        Commons.setText(password, pass);
    }

    public static void clickLoginButton() {
        WebElement loginButton = Commons.findElementVisibleByXpath(LOGIN_BUTTON);
        Commons.click(loginButton);
    }

    public static void clickUserAccountButton() {
        WebElement userAccountButton = Commons.findElementVisibleByXpath(USER_ACCOUNT_BUTTON);
        Commons.click(userAccountButton);
    }

    public static Boolean logOut() {
        WebElement logOutText = Commons.findElementVisibleByXpath(LOGOUT_TEXT);
        return logOutText.isDisplayed();
    }

    public static boolean lookForHamburger() {
        WebElement logoDisplay = Commons.findElementByXpath(HAMBURGER);
        return Commons.elementIsDisplayed(logoDisplay);
    }

    public static void clickOnHamburger() {
        WebElement hamburgerClicked = Commons.findElementVisibleByXpath(HAMBURGER);
        Commons.click(hamburgerClicked);
    }

    public static Boolean visibleSidePanel() {
        WebElement sidePanel = Commons.findElementVisibleByXpath(SIDE_PANEL);
        return Commons.elementIsDisplayed(sidePanel);
    }

    public static List<WebElement> listItems() {
        WebElement list = Commons.findElementVisibleByXpath(LI_ELEMENTS_SIDE_PANEL);
        return list.findElements(new By.ByTagName("li"));
    }

    public static void clickListItem(int number){
        Commons.click( Commons.findElementVisibleByXpath(LI_ELEMENTS_SIDE_PANEL_BY_POSITION.formatted(number)));
    }


}




