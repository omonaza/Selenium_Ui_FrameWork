package utilities1;
import org.openqa.selenium.WebDriver;

public class Driver {
    //this will be our driver controller
    //the goal of this class is to make sure there is only
    // one instance of driver running
    //how can we prevent the user from creating the object of Driver driver = new Driver();
    private Driver(){} //--> private constructor will not allow anyone to create a driver object directly from a different class
    // Singleton pattern  - only one instance of the class can be created at a time
    private static WebDriver driver;
    public static WebDriver getDriver() {
        //before we create a new driver instance we have to check if there
        //is no driver running already
        if (driver == null) {
            switch(ConfigReader.getProperty("browser").toLowerCase()){
                default:
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "firefox":
                    driver = FireFoxWebDriver.loadFireFoxDriver();
                    break;

            }
        }
        return driver;
    }
    //we need to provide another method that will handle the disposal of the driver depending if it is running or not
    public static void closeDriver(){
        try{
            if(driver != null){
                driver.close(); //--> closing a current tab only. If you have only 1 tab open - it will close the browser and the tab
                driver.quit(); //--> doesn't care how many windows\tabs are open - it closes all of them!
                driver = null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
