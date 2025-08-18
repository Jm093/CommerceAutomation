package stepdefinitions;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.datafaker.Faker;
import org.testng.Assert;


public class LoginSteps {
    TestContext context;
    String email;
    String password;
    public LoginSteps(TestContext context){
        this.context = context;
    }

    @Given("user is in the registration page")
    public void UserIsInTheRegistrationPage(){
        context.homePage().navigateToPage();
        context.homePage().clickRegisterPage();
    }

    @And("user is registered")
    public void userIsRegistered() {
        context.homePage().navigateToPage();
        context.homePage().clickRegisterPage();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        password = "P@ssword01";
        context.registrationPage().fillRegistration(firstName, lastName, email, password);
        context.registrationPage().clickRegisterBtn();
        context.homePage().clickLogout();
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage(){
        context.homePage().clickLoginPage();
    }

    @When("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials() {
        context.loginPage().login(email,password);
    }

    @Then("the user should be redirected to home page")
    public void theUserShouldBeRedirectedToHomePage() {
        String actual = context.homePage().getHomePageTextDisplay();
        String expected = "Welcome to our store";
        Assert.assertEquals(actual, expected, "Text mismatch you have not accessed the home page.");
    }


}
