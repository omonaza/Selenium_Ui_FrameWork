package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.SearchResultsPage;
import utilities1.Driver;

public class SearchFunctionalitySteps {
    HomePage homePage = new HomePage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();


    @When("^the user types \"([^\"]*)\" in the search field$")
    public void the_user_types_in_the_search_field(String searchCriteria) throws Throwable {
        homePage.searchInputField.sendKeys(searchCriteria);
      //  homePage.search(searchCriteria);
    }

    @When("^the user hits Search button$")
    public void the_user_hits_Search_button() throws Throwable {
        homePage.searchButton.click();

    }

    @Then("^verify all search results contain \"([^\"]*)\" in the title$")
    public void verify_all_search_results_contain_in_the_title(String  searchCriteria) throws Throwable {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 7);
        wait.until(ExpectedConditions.visibilityOf(searchResultsPage.firstSearchResult));

        for(WebElement resultTile: searchResultsPage.searchResultsTitles){
            Assert.assertTrue(resultTile.getText().toUpperCase().contains(searchCriteria));
            System.out.println(resultTile.getText());
        }


    }

    @And("^the user selects tomorrow from a dates dropdown$")
    public void theUserSelectsTomorrowFromADatesDropdown() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 7);

        wait.until(ExpectedConditions.visibilityOf(searchResultsPage.DropDownButton));
        searchResultsPage.setDropDownButton();


    }

    @Then("^verify all search results contain tomorrows date in the date fields$")
    public void verifyAllSearchResultsContainTomorrowsDateInTheDateFields() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 7);
        wait.until(ExpectedConditions.visibilityOf(searchResultsPage.firstSearchResultDate));


        for(WebElement resultTile: searchResultsPage.searchResultsDate){
            Assert.assertTrue(resultTile.getText().startsWith("FRI,NOV 20"));
            System.out.println("this are dates -----> " +resultTile.getText());
        }
    }
}
