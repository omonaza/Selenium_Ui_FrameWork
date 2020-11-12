package homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Task3 {
    WebDriver driver;
    @Before
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @After
    public void TearDown(){
        driver.close();
    }

    @Test
    public void HoverOverTest() {
        WebDriverWait wait = new WebDriverWait(driver,8);
        driver.navigate().to("https://demoqa.com/menu#");
       wait.until(WebDriver::getCurrentUrl);
        WebElement hoverOverButton = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        WebElement hoverOverButton2 = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverButton).perform();
       wait.until(WebDriver::getPageSource);
        actions.moveToElement(hoverOverButton2).perform();
        wait.until(WebDriver::getPageSource);
        actions.click(driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']")));

    }
}
