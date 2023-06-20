package scripts;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class Commons extends BasePage {
    public Commons (WebDriver driver){
        super(driver);
    }

    public static void navigateTo(String URL){
        driver.get(URL);
    }
}
