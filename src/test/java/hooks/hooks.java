package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.BasePage;

import java.sql.Driver;

public class hooks {
    @Before
    public void beforeScenario (){
        BasePage.initDriver();
    }
    @After
    public static void afterScenario(){
        BasePage.closeBrowser();
    }
}
