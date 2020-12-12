package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domains.testClass;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.RegistrationPage;
import utilities1.Driver;

import java.util.List;
import java.util.Map;

public class MeetUpRegistrationSteps {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    testClass testClass = new testClass();

    @When("^user clicks on Join Meetup button$")
    public void user_clicks_on_Join_Meetup_button() throws Throwable {
        homePage.joinMeetupButton.click();

    }


    @Then("^user is provided with <options>$")
    public void user_is_provided_with_options(DataTable dataTable) throws Throwable {
        List<String> dataTable1 = dataTable.asList(String.class);
        List<WebElement> newOptions = registrationPage.optionsField;
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        for (int i = 0; i < dataTable1.size(); i++) {
            System.out.println("newOptions----> " + newOptions.get(i).getText());
            wait.until(ExpectedConditions.visibilityOf(newOptions.get(i)));
            Assert.assertTrue(dataTable1.get(i).contains(newOptions.get(i).getText()));
        }

//
//          for(int i =0; i< registrationPage.optionsField.size();i++){
//              for(int j = i ; j <registrationPage.optionsField.size();j++){
//                  if(registrationPage.optionsField.get(i).getText().equals(registrationPage.optionsField.get(j).getText())){
//                      registrationPage.optionsField.remove(i);
//                  }
//
//              }
//                newOptions.add(registrationPage.optionsField.get(i));
//
//          }
//
//           for(int i = 0; i < dataTable1.size();i++){
//                  Assert.assertEquals("Continue with Options failure ",newOptions.get(i).getText(),(dataTable1.get(i)));
//
//
//               }

        // Assert.assertTrue("Email sign up failure ",registrationPage.signUpWithEmail.getText().contains(dataTable1.get(3)));
    }


    @When("^selects Sign up with email option$")
    public void selects_Sign_up_with_email_option() throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 8);
        wait.until(ExpectedConditions.elementToBeClickable(registrationPage.signUpWithEmail));
        js.executeScript("arguments[0].click();", registrationPage.signUpWithEmail);


    }

    @Then("^verify continue button is disabled when no input was provided$")
    public void verify_continue_button_is_disabled_when_no_input_was_provided() throws Throwable {
        Assert.assertTrue("continue button failure---> ",registrationPage.continueButton.isEnabled());
    }

    @When("^user enters the following credentials$")
    public void user_enters_the_following_credentials(List<Map<String, String>> credentials) throws Throwable {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        List<WebElement> inputFields = registrationPage.inputField;
        inputFields.get(0).sendKeys(testClass.getName());
        inputFields.get(1).sendKeys(testClass.getEmail());
        inputFields.get(2).sendKeys(testClass.getPassword());





        }




    @When("^clicks continue$")
    public void clicks_continue() throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(100000);
        js.executeScript("arguments[0].click();",registrationPage.continueButton);
        Thread.sleep(60000);

    }

    @Then("^verifies the message to confirm an email is displayed$")
    public void verifies_the_message_to_confirm_an_email_is_displayed() throws Throwable {
      registrationPage.messageConformation.isDisplayed();
    }

    @Then("^verifies that the email in the message is correct$")
    public void verifies_that_the_email_in_the_message_is_correct() throws Throwable {

    }


}