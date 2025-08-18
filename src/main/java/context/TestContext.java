package context;

import io.cucumber.java.en.*;
import managers.DriverFactory;
import net.datafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ElectronicsCategory;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.ConfigReader;
import utils.WaitUtils;

public class TestContext {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private ElectronicsCategory electronicsCategory;

    public TestContext(){
        this.driver = DriverFactory.getDriver();
    }

    public HomePage homePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
    public RegistrationPage registrationPage(){
        return (registrationPage == null) ? registrationPage = new RegistrationPage(driver) : registrationPage;
    }
    public LoginPage loginPage(){
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }
    public CartPage cartPage(){
        return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;
    }
    public CheckoutPage checkoutPage(){
        return (checkoutPage == null) ? checkoutPage = new CheckoutPage(driver) : checkoutPage;
    }
    public ElectronicsCategory electronicsCategory(){
        return (electronicsCategory == null) ? electronicsCategory = new ElectronicsCategory(driver) : electronicsCategory;
    }
}
