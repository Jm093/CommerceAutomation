package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.datafaker.Faker;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;


public class LoginSteps {
    private final HomePage homePage;
    private final RegistrationPage registrationPage;
    private final LoginPage loginPage;
    String email;
    String password;
    public LoginSteps(HomePage homePage, RegistrationPage registrationPage, LoginPage loginPage){
        this.homePage = homePage;
        this.registrationPage = registrationPage;
        this.loginPage = loginPage;
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


    @When("the user logs in with invalid {string} & {string} credentials")
    public void theUserLogsInWithInvalidCredentials(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("the email error {string} should be shown")
    public void theEmailErrorShouldBeShown(String expectedError) {
        String actualError = loginPage.getInvalidEmailError();
        if (expectedError.isEmpty()){
            Assert.assertTrue(actualError == null || actualError.isEmpty(), "No expected email field error");
        } else {
            Assert.assertEquals(actualError,expectedError.trim(), "Error mismatch");
        }
    }

    @Then("the user should encounter an {string} message and not proceed to home page")
    public void theUserShouldEncounterAnMessageAndNotProceedToHomePage(String expectedError) {
        String actualError = loginPage.getInvalidLoginError();
        if (expectedError.isEmpty()){
            Assert.assertTrue(actualError == null || actualError.isEmpty(), "No expected overall error");
        } else {
            Assert.assertTrue(actualError.contains(expectedError), "Error mismatch");
        }
    }

    @Given("the user is on the forgot password page")
    public void theUserIsOnTheForgotPasswordPage() {
        homePage.clickLoginPage();
        loginPage.clickForgotPassword();
        String actualPageTitle = loginPage.getForgotPasswordPageTitle();
        String expectedPageTitle = "Password recovery";
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Redirected to wrong page");
    }

    @When("the user enters a valid email")
    public void theUserEntersAValidEmail() {
        loginPage.enterRecoveryEmail(email);
    }

    @And("submits the request")
    public void submitsTheRequest() {
        loginPage.clickRecoverBtn();
    }

    @Then("the user should see a success notification")
    public void theUserShouldSeeASuccessNotification() {
        String actualNotificationMessage = loginPage.getNotificationMessage();
        String expectedNotificationMessage = "Email with instructions has been sent to you.";
        Assert.assertEquals(actualNotificationMessage, expectedNotificationMessage, "Incorrect notification message received");
    }

    @When("the user enters an invalid email")
    public void theUserEntersAnInvalidEmail() {
        loginPage.enterRecoveryEmail("invalidemail@gmail.com");
    }

    @Then("the user should see an error notification")
    public void theUserShouldSeeAnErrorNotification() {
        String actualNotificationMessage = loginPage.getNotificationMessage();
        String expectedNotificationMessage= "Email not found.";
        Assert.assertEquals(actualNotificationMessage, expectedNotificationMessage, "Incorrect notification message received");
    }
}


