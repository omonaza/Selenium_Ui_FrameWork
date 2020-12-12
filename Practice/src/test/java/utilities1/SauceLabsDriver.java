package utilities1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsDriver {
    public static final String USERNAME = ConfigReader.getProperty("sauceLabsUsername");
    public static final String ACCESS_KEY = ConfigReader.getProperty("accessKey");
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

    public static WebDriver loadSauceLabsDriver(){
        //to set up our test browser, os, version we use Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "macOS 10.13");
        caps.setCapability("browserName", "firefox");
        caps.setCapability("browserVersion", "latest");


        WebDriver driver = null;
        try{
            driver = new RemoteWebDriver(new URL(URL), caps);
        }catch(MalformedURLException e){
            e.printStackTrace();
        }
        return driver;
    }
}
