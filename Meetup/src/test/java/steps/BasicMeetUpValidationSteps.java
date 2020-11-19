package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.HomePage;
import utilities1.ConfigReader;
import utilities1.Driver;


public class BasicMeetUpValidationSteps {
    HomePage homePage = new HomePage();

    @Given("^user navigates to Meet up application login page$")
    public void user_navigates_to_Meet_up_application_login_page() throws Throwable {
        Driver.getDriver().get(ConfigReader.getProperty("url"));


    }

    @Then("^verify that web title is \"([^\"]*)\"$")
    public void verify_that_web_title_is(String ExpectedTitle) throws Throwable {
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals("title verification is failed",ExpectedTitle,actualTitle);




    }

    @Then("^verifies the urs is \"([^\"]*)\"$")
    public void verifies_the_urs_is(String url) throws Throwable {
        Assert.assertTrue("url failure--->",ConfigReader.getProperty("url").endsWith(url));


    }


    @Then("^verifies the Join Meetup button is displayed$")
    public void verifiesTheJoinMeetupButtonIsDisplayed() {
       // Assert.assertTrue(  "meet Up Button Failure",Driver.getDriver().findElement(By.xpath("//a[text()='Join Meetup']")).isDisplayed());
        Assert.assertTrue(homePage.joinMeetupButton.isDisplayed());
    }

    @Then("^verifies the \"([^\"]*)\" button is displayed$")
    public void verifiesTheButtonIsDisplayed(String LogInButton) throws Throwable {
       String LoginButtonText = Driver.getDriver().findElement(By.xpath("//a[@class='css-14e76nj' and text()='Log in']")).getText();
       Assert.assertTrue("login Button Failure-->",LoginButtonText.equalsIgnoreCase(LogInButton));


    }

    @Then("^verifies the sign up button is displayed$")
    public void verifiesTheSignUpButtonIsDisplayed() {
        Assert.assertTrue("sign up button failure-->",Driver.getDriver().findElement(By.xpath("//a[@class='css-14e76nj' and text()='Sign up']")).isDisplayed());

    }
}
