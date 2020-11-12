package basicLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class BasicLocatorsTest {

    @Test
    public void testLocator() throws InterruptedException {
        // to set up the driver instead of System.Property we will use methods from bonigarcia management
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://www.amazon.ae/");
        WebElement hamburgerMenuLink = webDriver.findElement(By.id("nav-hamburger-menu"));
        hamburgerMenuLink.click();
        Thread.sleep(2000);
        WebElement helloTextOnSideMenu = webDriver.findElement(By.id("hmenu-customer-name"));
        Assert.assertTrue(helloTextOnSideMenu.isDisplayed());
        webDriver.close();
    }

    @Test
    public void testNameLocator() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");

        WebElement searchInputField = driver.findElement(By.name("q"));
        String searchCriteria = "apple";
        searchInputField.sendKeys(searchCriteria);
        driver.findElement(By.name("btnK")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().contains(searchCriteria));
        driver.close();

    }

    @Test
    public void testLinkAndPartialLinkLocators() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");

        driver.findElement(By.linkText("English")).click();

        driver.findElement(By.linkText("Gmail")).click();


        driver.findElement(By.linkText("Create an account"));
        // driver.findElement(By.partialLinkText("Create")).click();


    }

    @Test
    public void testNameLocator1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com/");

        // driver.findElement(By.linkText("English")).click();
        WebElement textOnMainPage = driver.findElement(By.id("SIvCob"));
        textOnMainPage.click();
        Thread.sleep(2000);
        Assert.assertTrue(textOnMainPage.isDisplayed());
        driver.close();

//        WebElement electionLink = driver.findElement(By.className("NKcBbd"));
//        //getText() - return a strings - the visible text of the webelement
//        String textOfLink = electionLink.getText(); //Find out how to vote this election
//        Assert.assertNotEquals("Find out how to vote this election", textOfLink);


    }


    @Test
    public void testTagNameLocator() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.practiceselenium.com/");
        WebElement element = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(element.getText().contains("tea"));
        driver.close();
    }

    @Test
    public void testingWorkingWithMultipleElements() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("devxschool" + Keys.ENTER);
        Thread.sleep(3000);
        //first we will find a first link and print its text
        WebElement firstLink = driver.findElement(By.tagName("a"));
        System.out.println("This is the first link on the page: " + firstLink.getText());
        System.out.println("__________________________________________");
        List<WebElement> allLinksOnThePage = driver.findElements(By.tagName("a"));
        for (WebElement link : allLinksOnThePage) {
            System.out.println(link.getText());
        }
        driver.close();

    }

}