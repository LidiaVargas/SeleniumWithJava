package pages;
import org.openqa.selenium.WebElement;
import scripts.Commons;

public class OrangeLoginPage {

    private static final String USERNAME_INPUT="//input[@name='username']";
    private static final String PASSWORD_INPUT="//input[@name='password']";
    private static final String LOGIN_BUTTON="//button[@type='submit']";
    private static final String USER_ACCOUNT_BUTTON="//span[@class='oxd-userdropdown-tab']";
    private static final String LOGOUT_TEXT="//a[@href='/web/index.php/auth/logout']";




    public static void enterUser (String user){
        WebElement username = Commons.findElementByXpath(USERNAME_INPUT);
        Commons.setText(username, user);
    }
    public static void enterPass (String pass){
        WebElement password = Commons.findElementByXpath(PASSWORD_INPUT);
        Commons.setText(password, pass);
    }
    public static void clickLoginButton (){
        WebElement loginButton = Commons.findElementByXpath(LOGIN_BUTTON);
        Commons.click(loginButton);
    }

    public static void clickUserAccountButton (){
        WebElement userAccountButton = Commons.findElementByXpath(USER_ACCOUNT_BUTTON);
        Commons.click(userAccountButton);
    }

    public static String logOut () {
        WebElement logOutText = Commons.findElementByXpath(LOGOUT_TEXT);
        return Commons.getText(logOutText);
    }
}
