package browserSincronization;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class testWaits {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void etsyExplicitWaitTest() {
        driver.get("https://www.etsy.com/");
        driver.findElement(By.cssSelector(".select-signin")).click();
        //this is our explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 4);
        WebElement registerButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".select-register")));
        Assert.assertTrue(registerButton.isDisplayed());
    }

    @Test
    public void waitTask() {
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='enableAfter']")));
        Assert.assertTrue(Button.isEnabled());


    }

    @Test
    public void fileUploadTest() {
        driver.get("https://demoqa.com/upload-download");
        WebElement uploadButton = driver.findElement(By.xpath("//input[@id='uploadFile']"));
        String fileLocation = "C:\\Users\\azaos\\OneDrive\\Desktop\\maxresdefault.jpg";
        uploadButton.sendKeys(fileLocation);


    }

    @Test
    public void fileUploadTestWithGoogle() {
        driver.get("https://images.google.com/?gws_rd=ssl");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement imageButton = driver.findElement(By.xpath("//span[@class='BwoPOe']"));
        imageButton.click();
        WebElement searchButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href['iOGqzf H4qWMc aXIg1b'] and @href='javascript:void(0)' and @onclick='google.qb.ti(true);return false']")));
        // WebElement searchButton = driver.findElement(By.xpath("//a[@href['iOGqzf H4qWMc aXIg1b'] and @href='javascript:void(0)' and @onclick='google.qb.ti(true);return false'] "));
        searchButton.click();
        WebElement fileUploadButton = driver.findElement(By.xpath("//input[@id='awyMjb']"));

        String pathToTheFile = "C:\\Users\\azaos\\OneDrive\\Desktop\\maxresdefault.jpg";
        fileUploadButton.sendKeys(pathToTheFile);
    }

    public static void main(String[] args) {
        Faker f = new Faker();

        System.out.println(f.name().firstName());
    }
}
