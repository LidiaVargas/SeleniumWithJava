package scripts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Commons extends BasePage {
    public Commons (WebDriver driver){
        super(driver);
    }

    public static void navigateTo(String URL){
        driver.get(URL);
    }

    ////////////////////////////////////////////////////////////////////////
    // PROPERTIES METHODS
    ////////////////////////////////////////////////////////////////////////
    public static Properties getProperties(String propertiesFileName) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertiesFileName));
        } catch (FileNotFoundException exception) {
            Assert.fail("File not found: " + propertiesFileName + ".\n" + exception.getMessage());
        } catch (IOException exception) {
            Assert.fail("Exception while reading: " + propertiesFileName + ".\n" + exception.getMessage());
        }
        return properties;
    }


    ///////////////////////////////////////////////////////////////////////////////////////
    // WEB ELEMENT METHODS
    ///////////////////////////////////////////////////////////////////////////////////////

    // FIND ELEMENT
    public static WebElement findElementVisibleByXpath(String xpath){
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e){
            Assert.fail("fail to find element: "+ xpath);
            return null;
        }
    }

    public static WebElement findElementByXpath(String xpath){
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        } catch (Exception e){
            Assert.fail("fail to find element: "+ xpath);
            return null;
        }
    }
    //SET TEXT
    public static void setText (WebElement element, String text){
        try{
            element.clear();
            element.sendKeys(text);
        }catch (Exception e){
            Assert.fail("fail to send text element: "+ element);
        }
    }

    //GET TEXT
    public static String getText(WebElement element){
        try{
           return element.getText();
        }catch (Exception e){
            Assert.fail("fail to get text: " + element);
            return null;
        }
    }


    //CLICK
    public static void click (WebElement element){
        try{
            element.click();
        }catch (Exception e){
            Assert.fail("fail to click on element: "+ element);
        }

    }

    //GET ATTRIBUTE HTML
    public static String getCssAttribute(WebElement element, String attributeColor){
        try{
            return element.getCssValue(attributeColor);
        }catch (Exception e){
            Assert.fail("fail to get the attribute: " + element);
            return null;
        }
    }

    //VERIFICATIONS
    public static boolean elementIsDisplayed (WebElement element){
        return element.isDisplayed();
    }


    //NUEVOS APORTES
    public static WebElement findElementByText(String elementType, String text) {
        WebElement element;
        switch (elementType) {
            case "header3":
                elementType = "h3";
                break;
        }
        try {
            return element = findElementByXpath("//" + elementType + "[contains(.,'" + text + "')]");
        } catch (Exception e) {
            Assert.fail("Fail to find elements with text: " + text);
            return null;
        }
    }

    public static boolean verifyElementHasText(String elementType, String text) {
        if (Commons.findElementByText(elementType, text) == null) {
            return false;
        } else {
            return true;
        }
    }

}
