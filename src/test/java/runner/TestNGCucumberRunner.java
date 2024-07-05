package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    features = "src/test/resources/Features/Register.feature", // path to your feature files
    glue = "stepdefin", // package containing step definitions
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

    
}
