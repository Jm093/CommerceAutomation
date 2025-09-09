package stepdefinitions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.datafaker.Faker;
import org.testng.Assert;
import java.util.Map;

import pages.*;
import utils.TestDataReader;
import utils.UserContext;

public class CheckoutSteps {
    private final HomePage homePage;
    private final RegistrationPage registrationPage;
    private final ElectronicsCategory electronicsCategory;
    private final CartPage cartPage;
    private final LoginPage loginPage;
    private final CheckoutPage checkoutPage;
    private final UserContext userContext;
    String productName;
    String cartName;

    public CheckoutSteps(HomePage homePage, RegistrationPage registrationPage, LoginPage loginPage, ElectronicsCategory electronicsCategory, CartPage cartPage, CheckoutPage checkoutPage, UserContext userContext){
        this.homePage = homePage;
        this.registrationPage = registrationPage;
        this.electronicsCategory = electronicsCategory;
        this.cartPage = cartPage;
        this.loginPage = loginPage;
        this.checkoutPage = checkoutPage;
        this.userContext = userContext;
    }
    @Given("the user is registered")
    public void theUserIsRegistered(){
        homePage.navigateToPage();
        homePage.clickRegisterPage();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        userContext.email = faker.internet().emailAddress();
        userContext.password = TestDataReader.get("login.password");
        registrationPage.fillRegistration(firstName, lastName, userContext.email, userContext.password);
        registrationPage.clickRegisterBtn();
        homePage.clickLogout();
    }

    @And("the user is able to log in")
    public void theUserIsAbleToLogIn() {
        homePage.clickLoginPage();
        loginPage.login(userContext.email, userContext.password);
    }

    @When("the user searches for cellphone")
    public void theUserSearchesForCellphone() {
        homePage.clickElectronicsCategory();
        electronicsCategory.selectPhoneCategory();
    }

    @And("adds the item to cart")
    public void addsTheItemToCart() {
        productName = electronicsCategory.getProductName();
        electronicsCategory.addPhoneToCart();
    }

    @Then("the cart should show the added item")
    public void theCartShouldShowTheAddedItem() {
        homePage.cart();
        cartName = cartPage.getProductNameInCart();
        Assert.assertEquals(productName, cartName, "The product was not added in cart");
    }

    @Given("that an item is added to the cart")
    public void thatAnItemIsAddedToTheCart() {
        homePage.clickElectronicsCategory();
        electronicsCategory.selectPhoneCategory();
        electronicsCategory.addPhoneToCart();
        homePage.cart();
    }

    @When("the user has agreed to TOS and clicked the checkout button")
    public void theUserHasAgreedToTOSAndClickedTheCheckoutButton() {
        cartPage.agreeToTermsOfService();
        cartPage.checkoutItems();
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
        checkoutPage.clickContinue();
    }

    @And("the user has selected the Shipping method as {string}")
    public void theUserHasSelectedTheShippingMethod(String method) {
        checkoutPage.selectShippingMethod(method);
    }

    @And("the user has selected the Payment method as {string}")
    public void theUserHasSelectedThePaymentMethod(String method) {
        checkoutPage.selectPaymentMethod(method);
    }

    @And("the user has confirmed the Payment information")
    public void theUserHasConfirmedThePaymentInformation() {
        checkoutPage.confirmPaymentInformation();
    }

    @And("the user has confirmed the order")
    public void theUserHasConfirmedTheOrder() {
        checkoutPage.confirmOrder();
    }

    @Then("the user should be redirected to order confirmed page")
    public void theUserShouldBeRedirectedToOrderConfirmedPage() {
        checkoutPage.continueAtSuccessPage();
    }

}
