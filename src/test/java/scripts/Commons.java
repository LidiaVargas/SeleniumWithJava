package scripts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;


public class Commons extends BasePage {
    public Commons (WebDriver driver){
        super(driver);
    }

    public static void navigateTo(String URL){
        driver.get(URL);
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    // WEB ELEMENT METHODS
    ///////////////////////////////////////////////////////////////////////////////////////

    // FIND ELEMENT
    public static WebElement findElementByXpath (String xpath){
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
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



}
