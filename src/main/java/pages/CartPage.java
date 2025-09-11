package pages;
import managers.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class CartPage {
    private WebDriver driver;
    public CartPage(DriverFactory driverFactory){
        this.driver = driverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "#termsofservice") WebElement tosCheckbox;
    @FindBy (css = "#checkout") WebElement checkoutBtn;
    @FindBy (css = ".product-name") WebElement cartProductName;

    String cartName;

    public String getProductNameInCart(){
        WaitUtils.waitForVisibility(cartProductName);
        return cartName = cartProductName.getText().trim();
    }
    public void agreeToTermsOfService(){
        WaitUtils.waitForClickable(tosCheckbox);
        tosCheckbox.click();}
    public void checkoutItems(){
        WaitUtils.waitForClickable(checkoutBtn);
        checkoutBtn.click();}
}
