package scripts;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import java.awt.*;

public class BrowserUtils {
    public static WebDriver setWindowsSize (WebDriver driver, String size){
        String [] dimensions = size.split("x");
        int width = Integer.parseInt(dimensions[0]);
        int height = Integer.parseInt(dimensions[1]);
        driver.manage().window().setSize(new Dimension(width, height));
        return driver;
    }

    public static WebDriver maximizeWindow (WebDriver driver){
        driver.manage().window().maximize();
        return driver;
    }
    public static void screenSize(){
        Toolkit t = Toolkit.getDefaultToolkit();
        int width = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        System.out.println("width: " + width  + "  height: " +  height);
    }
}
