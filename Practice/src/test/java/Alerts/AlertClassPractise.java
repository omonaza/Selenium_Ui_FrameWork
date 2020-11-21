package Alerts;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities1.Driver;



public class AlertClassPractise {
    WebDriver driver;

    @Before
    public void SetUp(){
        driver = Driver.getDriver();

    }
    @After
    public void TearDown(){
        Driver.closeDriver();
    }

    @Test
    public void testSimpleAlert(){
        driver.navigate().to("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
        Actions actions = new Actions(Driver.getDriver());
        WebElement doubleClickButton = driver.findElement(By.xpath("//input[@value='Double Click Me']"));
        actions.doubleClick(doubleClickButton).perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("You double clicked me!!!"));
        alert.accept();





    }

    @Test
    public void promtAlertTest(){
        driver.navigate().to("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
        driver.findElement(By.xpath("//input[@value='Prompt']")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("I am prompt"));
        String info = "Abcd";
        alert.sendKeys(info);
        alert.accept();
    }

    @Test
    public void confirmBoxAlertTest(){
        driver.navigate().to("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
        driver.findElement(By.xpath("//input[@value='Confirmation Box']")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("I am confirm"));
        alert.dismiss();
    }


}
