package stepdefinitions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.datafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import managers.DriverFactory;
import pages.LoginPage;
import pages.HomePage;
import pages.ElectronicsCategory;
import pages.CheckoutPage;
import pages.CartPage;
import pages.RegistrationPage;
import pages.LoginPage;
import java.sql.Driver;
import java.util.Map;

public class CheckoutSteps {
    WebDriver driver;
    HomePage homepage;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    ElectronicsCategory electronicscategory;
    CheckoutPage checkoutPage;
    CartPage cartpage;
    String email;
    String password;
    String productName;
    String cartName;
    public CheckoutSteps() {
        this.driver = DriverFactory.getDriver();
        homepage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        electronicscategory = new ElectronicsCategory(driver);
        checkoutPage = new CheckoutPage(driver);
        cartpage = new CartPage(driver);
    }
    @Given("the user is registered")
    public void theUserIsRegistered(){
        homepage.navigateToPage();
        homepage.clickRegisterPage();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        password = "P@ssword01";
        registrationPage.fillRegistration(firstName, lastName, email, password);
        registrationPage.clickRegisterBtn();
        homepage.clickLogout();
    }

    @And("the user is able to log in")
    public void theUserIsAbleToLogIn() {
        homepage.clickLoginPage();
        loginPage.login(email, password);
    }

    @When("the user searches for cellphone")
    public void theUserSearchesForCellphone() {
        homepage.clickElectronicsCategory();
        electronicscategory.selectPhoneCategory();
    }

    @And("adds the item to cart")
    public void addsTheItemToCart() {
        productName = electronicscategory.getProductName();
        electronicscategory.addPhoneToCart();
    }

    @Then("the cart should show the added item")
    public void theCartShouldShowTheAddedItem() {
        homepage.cart();
        cartName = cartpage.getProductNameInCart();
        Assert.assertEquals(productName, cartName, "The product was not added in cart");
    }

    @Given("that an item is added to the cart")
    public void thatAnItemIsAddedToTheCart() {
        homepage.clickElectronicsCategory();
        electronicscategory.selectPhoneCategory();
        electronicscategory.addPhoneToCart();
        homepage.cart();
    }

    @When("the user has agreed to TOS and clicked the checkout button")
    public void theUserHasAgreedToTOSAndClickedTheCheckoutButton() {
        cartpage.agreeToTermsOfService();
        cartpage.checkoutItems();
    }

    @And("the user has filled up the address details with:")
    public void theUserHasFilledUpTheAddressDetailsWith(DataTable dataTable) {
        Map <String, String> data = dataTable.asMap(String.class, String.class);
        checkoutPage.fillBillingAddress(
                data.get("FirstName"),
                data.get("LastName"),
                data.get("Email"),
                data.get("Country"),
                data.get("City"),
                data.get("Address"),
                data.get("ZipCode"),
                data.get("PhoneNo")
        );
    }

    @And("the user has selected the Shipping method")
    public void theUserHasSelectedTheShippingMethod() {
        checkoutPage.selectShippingMethod("Next Day Air");
    }

    @And("the user has selected the Payment method")
    public void theUserHasSelectedThePaymentMethod() {
    }

    @And("the user has selected the Payment information")
    public void theUserHasSelectedThePaymentInformation() {
    }

    @And("the user has confirmed the order")
    public void theUserHasConfirmedTheOrder() {
    }

    @Then("the user should be redirected to order confirmed page")
    public void theUserShouldBeRedirectedToOrderConfirmedPage() {
    }
}
