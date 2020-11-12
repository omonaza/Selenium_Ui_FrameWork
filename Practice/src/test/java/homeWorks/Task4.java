package homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Watchable;
import java.util.concurrent.TimeUnit;

public class Task4 {
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
    public void dragAndDropTest()throws InterruptedException{
        driver.navigate().to("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
        WebDriverWait wait = new WebDriverWait(driver,7);
        wait.until(WebDriver::getCurrentUrl);
        WebElement sourceTarget = driver.findElement(By.xpath("//span[text()='Draggable 1']"));
        WebElement sourceTarget2 = driver.findElement(By.xpath("//span[text()='Draggable 3']"));
        WebElement destinationTarget = driver.findElement(By.id("mydropzone"));
        WebElement dropListContainer = driver.findElement(By.xpath("//h3[@class='text-center']/."));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(sourceTarget,destinationTarget).perform();
        wait.until(WebDriver::getPageSource);
        actions.dragAndDrop(sourceTarget2,destinationTarget).perform();
        Assert.assertTrue(!dropListContainer.getText().isEmpty());

    }
}
