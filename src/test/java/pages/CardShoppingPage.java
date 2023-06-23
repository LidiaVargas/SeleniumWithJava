package pages;


import org.openqa.selenium.WebElement;
import scripts.Commons;

public class CardShoppingPage {
    private static final String PRODUCT_BUTTON="//div[@class='inventory_item_label'][contains(.,'%s')]/following-sibling::div/button";
    private static final String SHOPING_CART_NUMBER="//div[@id='shopping_cart_container']/a/span";
    public static void clickOnProduct (String productName) {
        WebElement product = Commons.findElementByXpath(PRODUCT_BUTTON.formatted(productName));
        Commons.click(product);
    }

    public static String buttonTextColor (String productName){
        WebElement buttonTextColorChange = Commons.findElementByXpath(PRODUCT_BUTTON.formatted(productName));
        return Commons.getCssAttribute(buttonTextColorChange, "color");
    }

    public static String buttonText (String productName){
        WebElement buttonTextChange = Commons.findElementByXpath(PRODUCT_BUTTON.formatted(productName));
        return Commons.getText(buttonTextChange);
    }

    public static String shoppingCartText (){
        WebElement shoppingCartNumb = Commons.findElementByXpath(SHOPING_CART_NUMBER);
        return Commons.getText(shoppingCartNumb);
    }
}