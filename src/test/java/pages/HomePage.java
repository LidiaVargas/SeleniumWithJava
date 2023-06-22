package pages;

import org.openqa.selenium.WebElement;
import scripts.Commons;

public class HomePage {
    private static final String BURGER_BUTTON = "//button[@id='react-burger-menu-btn']";
    private static final String LOGOUT_BUTTON = "//a[@id='logout_sidebar_link']";
    public static Boolean checkUserIsLogged(){
    WebElement logOutButton = Commons.findElementByXpath(LOGOUT_BUTTON);
    return Commons.elementIsDisplayed(logOutButton);
    }

    public static void clickBurguer (){
        WebElement burguerButton = Commons.findElementByXpath(BURGER_BUTTON);
        Commons.click(burguerButton);
    }

}
