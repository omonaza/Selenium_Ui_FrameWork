//package steps;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import org.junit.Assert;
//import utilities1.ConfigReader;
//import utilities1.Driver;
//
//public class BAsicMeetUpValidationSteps {
//    @Given("^user navigates to Meet up application login page$")
//    public void user_navigates_to_Meet_up_application_login_page() throws Throwable {
//        Driver.getDriver().get(ConfigReader.getProperty("url"));
//    }
//
//    @Then("^verify that web title is \"([^\"]*)\"$")
//    public void verify_that_web_title_is(String ExpectedTitle) throws Throwable {
//        String actualTitle = Driver.getDriver().getTitle();
//        System.out.println( " Actual Title is " + actualTitle);
//        Assert.assertEquals("expected title failure" + ExpectedTitle , actualTitle);
//
//
//    }
//
//    @Then("^verifies the urs is \"([^\"]*)\"$")
//    public void verifies_the_urs_is(String arg1) throws Throwable {
//
//    }
//
//}
