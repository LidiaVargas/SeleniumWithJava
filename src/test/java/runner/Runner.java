package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {
                "stepsDefinitions",
                "hooks"
        },
        //plugin que me ejecuta el reporte
        plugin = {
                "pretty",
                "html:report/cucumber_html/report.html"
        },
        tags = "@login_Again",
        stepNotifications = true

)
public class Runner {
}
