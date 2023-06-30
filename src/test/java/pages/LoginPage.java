package pages;


import org.openqa.selenium.WebElement;
import scripts.Commons;

import java.util.ArrayList;


public class LoginPage  {
   //Xpath
    private static final String USERNAME_INPUT="//input[@id='user-name']";
    private static final String PASSWORD_INPUT="//input[@id='password']";
    private static final String LOGIN_BUTTON="//input[@id='login-button']";
    private static final String ERROR_MESSAGE_H3="//div[contains(@class, 'error-message-container')]/h3";
    private static final String ERROR_MESSAGE_COLOR_CONTAINER ="//div[contains(@class, 'error-message-container')]";
    private static final String ERROR_MESSAGE_X="//div[contains(@class, 'error-message-container')]/h3/button";





    public static void enterUser (String user){
        WebElement username = Commons.findElementVisibleByXpath(USERNAME_INPUT);
        Commons.setText(username, user);
    }
    public static void enterPass (String pass){
        WebElement password = Commons.findElementVisibleByXpath(PASSWORD_INPUT);
        Commons.setText(password, pass);
    }
    public static void clickLoginButton (){
        WebElement loginButton = Commons.findElementVisibleByXpath(LOGIN_BUTTON);
        Commons.click(loginButton);
    }

    public static String showErrorMessage () {
        WebElement errorMessage = Commons.findElementVisibleByXpath(ERROR_MESSAGE_H3);
        return Commons.getText(errorMessage);
    }

    public static String backgroundColor (){
        WebElement errorContainerColor = Commons.findElementVisibleByXpath(ERROR_MESSAGE_COLOR_CONTAINER);
        return Commons.getCssAttribute(errorContainerColor, "background-color");
    }

    public static String textColor (){
        WebElement errorTextColor = Commons.findElementVisibleByXpath(ERROR_MESSAGE_X);
        return Commons.getCssAttribute(errorTextColor, "color");
    }


}
