package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class CheckoutPage {
    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#BillingNewAddress_City") WebElement cityField;
    @FindBy(css = "#BillingNewAddress_Address1") WebElement address1Field;
    @FindBy(css = "#BillingNewAddress_ZipPostalCode") WebElement zipField;
    @FindBy(css = "#BillingNewAddress_PhoneNumber") WebElement phoneNoField;
    @FindBy(css = "#BillingNewAddress_FirstName") WebElement firstNameField;
    @FindBy(css = "#BillingNewAddress_LastName") WebElement lastNameField;
    @FindBy(css = "#BillingNewAddress_Email") WebElement emailField;
    @FindBy(css = "#BillingNewAddress_CountryId") WebElement countryDropdown;
    @FindBy(css = "button[onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']") WebElement continueBillingAddBtn;
    @FindBy(css = ".button-1.shipping-method-next-step-button") WebElement continueShippingMtdBtn;
    @FindBy(css = "button[class='button-1 payment-method-next-step-button']") WebElement continuePaymentBtn;
    @FindBy(css = ".button-1.payment-info-next-step-button") WebElement continuePaymentInfoBtn;
    @FindBy(css = ".button-1.confirm-order-next-step-button") WebElement confirmOrderBtn;
    @FindBy(css = ".button-1.order-completed-continue-button") WebElement continueSuccessPage;

    public void fillBillingAddress(String fname, String lname, String email, String country, String city, String address, String zip, String phoneNo){
        Select select = new Select(countryDropdown);
        if (!select.getFirstSelectedOption().getText().equals(country)){
            select.selectByVisibleText(country);
        }
        if (cityField.getAttribute("value").isEmpty()) {
            cityField.clear();
            cityField.sendKeys(city);
        }
        if (address1Field.getAttribute("value").isEmpty()){
            address1Field.clear();
            address1Field.sendKeys(address);
        }
        if (zipField.getAttribute("value").isEmpty()){
            zipField.clear();
            zipField.sendKeys(zip);
        }
        if (phoneNoField.getAttribute("value").isEmpty()){
            phoneNoField.clear();
            phoneNoField.sendKeys(phoneNo);
        }
        if (firstNameField.getAttribute("value").isEmpty()){
            firstNameField.clear();
            firstNameField.sendKeys(fname);
        }
        if (lastNameField.getAttribute("value").isEmpty()){
            lastNameField.clear();
            lastNameField.sendKeys(lname);
        }
        if (emailField.getAttribute("value").isEmpty()){
            emailField.clear();
            emailField.sendKeys(email);
        }

    }

    public void clickContinue(){
        continueBillingAddBtn.click();
    }

    public void selectShippingMethod(String shippingMethod){
        List<WebElement> shippingOptions = driver.findElements(By.name("shippingoption"));

        for (WebElement option : shippingOptions){
            String value = option.getAttribute("value").trim();
            if (value.toLowerCase().contains(shippingMethod.toLowerCase())) {
                option.click();
                break;
            }
        }
        continueShippingMtdBtn.click();
    }

    public void selectPaymentMethod(String paymentMethod){
        List<WebElement> paymentOptions = driver.findElements(By.name("paymentmethod"));
        for (WebElement option: paymentOptions){
            String value = option.getAttribute("value").trim().toLowerCase();
            if (value.contains(paymentMethod.toLowerCase())){
                option.click();
                break;
            }
        continuePaymentBtn.click();
        }
    }

    public void confirmPaymentInformation(){
        continuePaymentInfoBtn.click();
    }
    public void confirmOrder(){
        confirmOrderBtn.click();
    }
    public void continueAtSuccessPage(){
        continueSuccessPage.click();
    }
}
