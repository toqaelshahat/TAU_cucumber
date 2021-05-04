package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(glue={"MyStepdefs"}, features = "src/test/resources", plugin = { "pretty", "html:target/site/cucumber-pretty",
        "json:target/cucumber.json" })
public class RunCucumberTests {

}
