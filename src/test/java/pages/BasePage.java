package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private static final String WEB_DRIVER=System.getProperty("webDriver", "chrome");
    private static final Boolean HEADLESS_MODE=Boolean.parseBoolean(System.getProperty( "headlessMode", "false"));

    public static WebDriver driver;
    protected static WebDriverWait wait;

    public static void initDriver() {
        switch (WEB_DRIVER){
            case "chrome":
                System.out.println("chrome driver selected");
                chromeDriver();
                break;
            case "firefox":
                System.out.println("firefox driver selected");
                fireFoxDriver();
                break;
        }
    }

    public static void chromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        if (HEADLESS_MODE){
            options.addArguments("--headless");
            System.out.println("headless mode selected");
        }
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static void fireFoxDriver(){
        FirefoxOptions options = new FirefoxOptions() ;
        if (HEADLESS_MODE){
            options.addArguments("--headless");
            System.out.println("headless mode selected");
        }
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public static void closeBrowser(){
        if (driver!= null){
            driver.manage().deleteAllCookies();
           // driver.quit();
        }
    }
}
