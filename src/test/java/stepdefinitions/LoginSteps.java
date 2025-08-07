package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import managers.DriverFactory;
import net.datafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.HomePage;
import pages.RegistrationPage;

import java.sql.Driver;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    RegistrationPage registrationPage;
    String email;
    String password;
    public LoginSteps(){
        this.driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);

    }

    @Given("user is in the registration page")
    public void UserIsInTheRegistrationPage(){
        homePage.navigateToPage();
        homePage.clickRegisterPage();
    }

    @And("user is registered")
    public void userIsRegistered() {
        homePage.navigateToPage();
        homePage.clickRegisterPage();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        password = "P@ssword01";
        registrationPage.fillRegistration(firstName, lastName, email, password);
        registrationPage.clickRegisterBtn();
        homePage.clickLogout();
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage(){
        homePage.clickLoginPage();
    }

    @When("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials() {
        loginPage.login(email,password);
    }

    @Then("the user should be redirected to home page")
    public void theUserShouldBeRedirectedToHomePage() {
        String actual = homePage.getHomePageTextDisplay();
        String expected = "Welcome to our store";
        Assert.assertEquals(actual, expected, "Text mismatch you have not accessed the home page.");
    }


}
