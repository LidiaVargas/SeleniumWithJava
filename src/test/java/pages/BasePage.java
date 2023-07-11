package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    //selecciona eñ driver que le pasas por el swich o coge por defecto el que haya escrito (chrome).
    public static final String WEB_DRIVER=System.getProperty("webDriver", "chrome");


    //headless mode permite que la ventana de ejecución sea visible o no. Se indica con true o false.ojo! revisar run test específico por si está true o false tb.
    private static final Boolean HEADLESS_MODE=Boolean.parseBoolean(System.getProperty( "headlessMode", "false"));


    public static WebDriver driver;
    protected static WebDriverWait wait;

    //SELECTOR DE DRIVER (SE LE PASA POR RUN TEST, EDIT CONFIGURATION EL PARa 6METRO)
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
            case "edge":
                System.out.println("edge driver selected");
                edgeDriver();
                break;
        }
    }
    ////////////////////////////////////////////////////////////////////
    //MÉTODOS PARA SELECCIONAR EL DRIVER DEL NAVEGADOR.
    //se puede generar uno por cada navegador
    ////////////////////////////////////////////////////////////////////
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

    public static void edgeDriver(){
        EdgeOptions options = new EdgeOptions() ;
        if (HEADLESS_MODE){
            options.addArguments("--headless");
            System.out.println("headless mode selected");
        }
        driver = new EdgeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public static void closeBrowser(){
        if (driver!= null){
            driver.manage().deleteAllCookies();
            //cierra automáticamente el navegador después de cada test
           // driver.quit();
        }
    }
}
