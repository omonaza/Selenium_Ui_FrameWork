package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities1.Driver;

import java.util.List;

public class SearchResultsPage extends FooterPage {

    public SearchResultsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[starts-with(@data-testid, 'searchResults-')]//p[1]")
    public List<WebElement> searchResultsTitles;

    @FindBy(xpath = "//div[starts-with(@data-element-name, 'searchResults')][1]")
    public WebElement firstSearchResult;

    @FindBy(id = "tracking--searchComponentInput")
    public WebElement searchInputField;

    @FindBy(id = "dateRangeFilter")
    public WebElement DropDownButton;
                                                                                                      //time[1]
    @FindBy(xpath = "//span[text()='Tomorrow']")
    public WebElement tomorrowOption;



    public void setDropDownButton() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(DropDownButton).click().perform();
               actions.moveToElement(tomorrowOption).click().perform();
    }

    @FindBy(tagName = "time[1]")
    public List<WebElement> searchResultsDate;


    @FindBy(xpath = "//div[starts-with(@data-element-name, 'searchResults-eventCard-272846838!chp')][1]      ")
    public WebElement firstSearchResultDate;
}