package cucumberrunner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/tests.feature",
        glue = "StepDefinitions"
)

public class RunCucumberTest {

}
