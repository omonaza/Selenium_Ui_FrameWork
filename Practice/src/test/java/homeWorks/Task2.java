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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Task2 {
    WebDriver driver;

    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @After
    public void TearDown() {
        driver.close();
    }

    @Test
    public void resetTest() {
        driver.navigate().to("\thttps://demoqa.com/progress-bar");
        WebElement rightClickButton = driver.findElement(By.id("startStopButton"));

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 9);
        actions.click(rightClickButton).perform();
        WebElement resetButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resetButton")));
        Assert.assertTrue(resetButton.isDisplayed());
        actions.contextClick(resetButton).perform();


    }


}
