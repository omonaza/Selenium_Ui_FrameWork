package javaScript.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities1.ConfigReader;

import java.util.concurrent.TimeUnit;

public class Task1 {
    WebDriver driver;
    @Before
    public void SetUp(){
        if(ConfigReader.getProperty("browser").equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }else if(ConfigReader.getProperty("browser").equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    @After
    public void TearDown(){
        driver.close();
    }

    @Test
    public void LoginTestWithJavaScript()throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(driver,9);
        JavascriptExecutor jvs = (JavascriptExecutor)driver;
        jvs.executeScript("window.location='https://opensource-demo.orangehrmlive.com/'");
        Thread.sleep(3000);
        wait.until(WebDriver::getCurrentUrl);
        WebElement signInInputField = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        jvs.executeScript("arguments[0].setAttribute('style',arguments[1]);",signInInputField, "border: 2px solid red");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='txtUsername']")));
        jvs.executeScript("arguments[0].click();",signInInputField);
        jvs.executeScript("arguments[0].setAttribute('value',arguments[1]);" ,signInInputField,"Admin");
        Thread.sleep(3000);


        WebElement passwordInputField = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='txtPassword']")));
        jvs.executeScript("arguments[0].setAttribute('style',arguments[1]);",passwordInputField, "border: 2px solid red");
        jvs.executeScript("arguments[0].click();",passwordInputField);
        jvs.executeScript("arguments[0].setAttribute('value',arguments[1]);",passwordInputField, "admin123");
        Thread.sleep(3000);

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        jvs.executeScript("arguments[0].setAttribute('style',arguments[1]);",submitButton, "border: 2px solid red");
        jvs.executeScript("arguments[0].click();",submitButton);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_dashboard_index")));
        String textDashBord = driver.findElement(By.xpath("//h1[text()='Dashboard']")).getText();
        Assert.assertTrue(textDashBord.equals("Dashboard"));

        WebElement AssignButton = driver.findElement(By.xpath("//span[@class='quickLinkText' and text()='Assign Leave']"));
        jvs.executeScript("arguments[0].setAttribute('style',arguments[1]);",AssignButton, "border: 2px solid red");
        jvs.executeScript("arguments[0].click();",AssignButton);


        //input[@id='assignleave_txtEmployee_empName']

        WebElement EmployeeNameInputButton = driver.findElement(By.xpath("//input[@id='assignleave_txtEmployee_empName']"));
        EmployeeNameInputButton.click();
        EmployeeNameInputButton.sendKeys("Fiona");
        Thread.sleep(3000);
//        jvs.executeScript("arguments[0].setAttribute('style',arguments[1]);",EmployeeNameInputButton, "border: 2px solid red");
//        jvs.executeScript("arguments[0].click();",EmployeeNameInputButton);
//        Thread.sleep(3000);
//        jvs.executeScript("arguments[0].setAttribute('value',arguments[1]);",EmployeeNameInputButton,"Fiona Grace");
//        Thread.sleep(3000);


         Thread.sleep(3000);
        WebElement autoSuggestedText = driver.findElement(By.xpath("//li[@class='ac_even ac_over']"));
        jvs.executeScript("arguments[0].click();",autoSuggestedText);






    }













}
