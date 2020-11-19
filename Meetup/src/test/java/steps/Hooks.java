package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities1.Driver;

public class Hooks {
    @Before
    public void setUp(){
        // what we can  put here ?
        // i do not have to setUP driver here
        // Environment set up here only , Before the hook

    }
    @After
    public void TearDown(Scenario scenario){
        try {
            // we can check if scenario has failed and take a screenshot and attached
            if (scenario.isFailed()) {
                //than we take screenshot
                final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                // no we can add screenshot in html report
                scenario.embed(screenshot, "image/png");
            }
        }catch (Exception e){
            System.out.println("the error happened while cleaning up after the test " +
                    e.getMessage());
        }
        // we perform clean up after each test
        //driver.close(); WRONG!!!
        Driver.closeDriver();
    }
}
