package pages;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import scripts.Commons;

public class OrangeLoginPage {

    private static final String USERNAME_INPUT = "//input[@name='username']";
    private static final String PASSWORD_INPUT = "//input[@name='password']";
    private static final String LOGIN_BUTTON = "//button[@type='submit']";
    private static final String USER_ACCOUNT_BUTTON = "//span[@class='oxd-userdropdown-tab']";
    private static final String LOGOUT_TEXT = "//a[contains(.,'Cerrar sesión')] | //a[contains(.,'Logout')]";
    ////a[contains(.,'Cerrar sesión')]
    ////a[contains(.,'Logout')]
    ////a[@href='/web/index.php/auth/logout']
    private static final String HAMBURGER = "//i[@class='oxd-icon bi-list oxd-topbar-header-hamburger']";
    //i contains
    private static final String LI_ELEMENTS_SIDE_PANEL = "//li[@class='oxd-main-menu-item-wrapper']";


    public static void enterUser(String user) {
        WebElement username = Commons.findElementByXpath(USERNAME_INPUT);
        Commons.setText(username, user);
    }

    public static void enterPass(String pass) {
        WebElement password = Commons.findElementByXpath(PASSWORD_INPUT);
        Commons.setText(password, pass);
    }

    public static void clickLoginButton() {
        WebElement loginButton = Commons.findElementByXpath(LOGIN_BUTTON);
        Commons.click(loginButton);
    }

    public static void clickUserAccountButton() {
        WebElement userAccountButton = Commons.findElementByXpath(USER_ACCOUNT_BUTTON);
        Commons.click(userAccountButton);
    }

    public static String logOut() {
        WebElement logOutText = Commons.findElementByXpath(LOGOUT_TEXT);
        return Commons.getText(logOutText);
    }

    public static boolean lookForHamburger() {
        WebElement logoDisplay = Commons.findElementByXpath(HAMBURGER);
        return Commons.elementIsDisplayed(logoDisplay);
    }

    public static String findSideBarItems(String itemName) {
        WebElement item = Commons.findElementByXpath(LI_ELEMENTS_SIDE_PANEL.formatted(itemName));
        return Commons.getText(item);
    }

}
