package stepdefinitions;
import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.datafaker.Faker;
import org.testng.Assert;
import java.util.Map;

public class CheckoutSteps {
    TestContext context;
    String email;
    String password;
    String productName;
    String cartName;

    public CheckoutSteps(TestContext context){
        this.context = context;
    }
    @Given("the user is registered")
    public void theUserIsRegistered(){
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

    @And("the user is able to log in")
    public void theUserIsAbleToLogIn() {
        context.homePage().clickLoginPage();
        context.loginPage().login(email, password);
    }

    @When("the user searches for cellphone")
    public void theUserSearchesForCellphone() {
        context.homePage().clickElectronicsCategory();
        context.electronicsCategory().selectPhoneCategory();
    }

    @And("adds the item to cart")
    public void addsTheItemToCart() {
        productName = context.electronicsCategory().getProductName();
        context.electronicsCategory().addPhoneToCart();
    }

    @Then("the cart should show the added item")
    public void theCartShouldShowTheAddedItem() {
        context.homePage().cart();
        cartName = context.cartPage().getProductNameInCart();
        Assert.assertEquals(productName, cartName, "The product was not added in cart");
    }

    @Given("that an item is added to the cart")
    public void thatAnItemIsAddedToTheCart() {
        context.homePage().clickElectronicsCategory();
        context.electronicsCategory().selectPhoneCategory();
        context.electronicsCategory().addPhoneToCart();
        context.homePage().cart();
    }

    @When("the user has agreed to TOS and clicked the checkout button")
    public void theUserHasAgreedToTOSAndClickedTheCheckoutButton() {
        context.cartPage().agreeToTermsOfService();
        context.cartPage().checkoutItems();
    }

    @And("the user has filled up the address details with:")
    public void theUserHasFilledUpTheAddressDetailsWith(DataTable dataTable) {
        Map <String, String> data = dataTable.asMap(String.class, String.class);
        context.checkoutPage().fillBillingAddress(
                data.get("FirstName"),
                data.get("LastName"),
                data.get("Email"),
                data.get("Country"),
                data.get("City"),
                data.get("Address"),
                data.get("ZipCode"),
                data.get("PhoneNo")
        );
        context.checkoutPage().clickContinue();
    }

    @And("the user has selected the Shipping method as {string}")
    public void theUserHasSelectedTheShippingMethod(String method) {
        context.checkoutPage().selectShippingMethod(method);
    }

    @And("the user has selected the Payment method as {string}")
    public void theUserHasSelectedThePaymentMethod(String method) {
        context.checkoutPage().selectPaymentMethod(method);
    }

    @And("the user has confirmed the Payment information")
    public void theUserHasConfirmedThePaymentInformation() {
        context.checkoutPage().confirmPaymentInformation();
    }

    @And("the user has confirmed the order")
    public void theUserHasConfirmedTheOrder() {
        context.checkoutPage().confirmOrder();
    }

    @Then("the user should be redirected to order confirmed page")
    public void theUserShouldBeRedirectedToOrderConfirmedPage() {
        context.checkoutPage().continueAtSuccessPage();
    }

}
