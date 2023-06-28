package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.BasePage;
import scripts.BrowserUtils;

import java.sql.Driver;

import static pages.BasePage.driver;

public class hooks {
    public static final String WINDOWS_SIZE=System.getProperty("windowsSize", "fullScreen");
    @Before
    public void beforeScenario (){
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
}
