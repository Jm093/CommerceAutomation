package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.RegistrationPage;
import pages.HomePage;
import net.datafaker.Faker;

public class Registration {
    TestContext context;
    RegistrationPage registrationPage;
    HomePage homePage;

    public Registration(TestContext context){
        this.context = context;
        registrationPage = context.registrationPage();
        homePage = context.homePage();
    }

    @Given("the user is in the registration page")
    public void theUserIsInTheRegistrationPage(){
        homePage.navigateToPage();
        homePage.clickRegisterPage();
    }

    @When("the user fills up the registration form")
    public void theUserFillsUpTheRegistrationForm(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = "P@ssword01";
        registrationPage.fillRegistration(firstName, lastName, email, password);
    }

    @And("clicks on the register button")
    public void clicksOnTheRegisterButton(){
        registrationPage.clickRegisterBtn();
    }

    @Then("user should be successfully registered")
    public void userShouldBeSuccessfullyRegistered(){
        String actualMessage = registrationPage.getSuccessfulRegistrationMessage();
        String expectedMessage = "Your registration completed";
        Assert.assertEquals(actualMessage, expectedMessage, "Registration Message Mismatch");
    }

}
