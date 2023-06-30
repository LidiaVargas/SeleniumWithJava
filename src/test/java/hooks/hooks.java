package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;
import scripts.BrowserUtils;

import java.sql.Driver;

import static pages.BasePage.driver;

public class hooks {
    //variable que recoge el tamaño de la pantalla o por defecto te lo pone a pantalla completa.
    public static final String WINDOWS_SIZE=System.getProperty("windowsSize", "fullScreen");
    public static final Boolean FULL_STEPS = Boolean.parseBoolean(System.getProperty("fullstep", "true"));
    @Before
    public void beforeScenario (){
        //según el navegador elegido, selecciona el tamaño para la pantalla.
        BasePage.initDriver();
        if(WINDOWS_SIZE != "fullScreen"){
            BrowserUtils.setWindowsSize(driver, WINDOWS_SIZE);
        }else{
            BrowserUtils.maximizeWindow(driver);
        }
    }
    @After
    public static void afterScenario(){
        BasePage.closeBrowser();
    }

    @AfterStep
    public static void screenshot(Scenario scenario){
        if (scenario.isFailed() | FULL_STEPS) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
            System.out.println("screenshot add");
        }
    }
}
