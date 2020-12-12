package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"json:target/cucumber.json", "pretty",
                "html:target/cucumber-reports"},

        features = {"classpath:feature"},
        glue = {"steps"},
      //  tags = {"@search"},
        dryRun =true


)

public class runner {


}
