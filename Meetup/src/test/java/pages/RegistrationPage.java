package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities1.Driver;

import java.util.ArrayList;
import java.util.List;

public class RegistrationPage {

    //this is where I will store all the elements from Meetup Registration page

    //we create scenarios first and based on the scenario we add elements to the pages classes
    //POM - Page Object Model - design concept(pattern) where each page of application is represented by a separate class in the framework

    //@FindBy annotation is used to find an element or a list of WebelEments that match provided locator

    //before we can use these elements we need to initialize them -->
    // we use page factory class  - method initElements();

    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[@id='register-trigger--withEmail'][1]")
    public WebElement signUpWithEmail;

     @FindAll({@FindBy( xpath = "//span[text()='Continue with Facebook'][1]"),@FindBy(xpath = "//span[text()='Continue with Google'][1]"),
     @FindBy(xpath = "//span[text()='Continue with Apple'][1]"),@FindBy(xpath = "//a[@id='register-trigger--withEmail'][1]")})
     public List<WebElement> optionsField;

     @FindBy(xpath = "//button[@type='submit']")
      public WebElement continueButton;

     @FindBy(xpath = "//strong[text()='click the link in that email']")
     public WebElement messageConformation;


//===========================================================================================================================================
//    @FindBy(id = "register-field--name")
//    public WebElement inputNameFiled;
//
//
//    @FindBy(id = "register-field--password")
//    public WebElement inputPasswordField;
//
//
//    @FindBy(id = "register-field--email")
//    public WebElement inputEmailField;



    @FindAll({@FindBy(id = "register-field--name"), @FindBy(id = "register-field--email"),@FindBy(id = "register-field--password")})
    public List<WebElement> inputField;



}





