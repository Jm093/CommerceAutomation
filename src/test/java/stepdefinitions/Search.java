package stepdefinitions;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.HomePage;
import utils.TestDataReader;

public class Search {
    private final HomePage homePage;
    public Search(HomePage homePage){
        this.homePage = homePage;
    }

    @When("the user searches for an item")
    public void theUserSearchesForAnItem(){
    homePage.searchItem(TestDataReader.get("search.product"));
    homePage.clickSearchBtn();
    }
    @Then("the correct item should be displayed")
    public void theCorrectItemShouldBeDisplayed(){
    String expectedResult = TestDataReader.get("searched.result");
    String actualResult = homePage.getSearchResult();
        Assert.assertEquals(actualResult,expectedResult, "Wrong item appeared on search");
    }

    @When("the user searches for a non existing item")
    public void theUserSearchesForANonExistingItem() {
        homePage.searchItem(TestDataReader.get("invalidSearch.product"));
        homePage.clickSearchBtn();
    }

    @Then("there should be no items in display and a message indicating no items found should be displayed")
    public void thereShouldBeNoItemsInDisplayAndAMessageIndicatingNoItemsFoundShouldBeDisplayed() {
        String expectedMsg = TestDataReader.get("invalidSearched.result");
        String actualMsg = homePage.getNoResultMessage();
        Assert.assertEquals(expectedMsg,actualMsg,"Incorrect Message an item might be present");
    }
}
