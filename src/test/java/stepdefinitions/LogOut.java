package stepdefinitions;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import managers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;

public class LogOut {
    private final HomePage homePage;
    private final WebDriver driver;
    public LogOut(DriverFactory driverFactory, HomePage homePage){
        this.driver = driverFactory.getDriver();
        this.homePage = homePage;
    }

    @When("the user clicks logout")
    public void theUserClicksLogout(){
        homePage.clickLogout();
    }

    @And("the user should no longer have access to their account info")
    public void theUserShouldNoLongerHaveAccessToTheirAccountInfo() {
        Assert.assertFalse(homePage.isAccountInfoIconVisible(),"Account info icon is still present");
    }

    @And("the user clicks the back button")
    public void theUserClicksTheBackButton() {
        driver.navigate().back();
    }

    @Then("the system should not show logged-in pages")
    public void theSystemShouldNotShowLoggedInPages() {
     Assert.assertFalse(homePage.isAccountInfoIconVisible(),"Account info icon is still present");
     Assert.assertFalse(homePage.isLogoutButtonVisible(), "Logout button is still present");
    }
}
