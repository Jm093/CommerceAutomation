package pages;
import managers.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import utils.WaitUtils;

import java.sql.Driver;

public class CartPage {
    private WebDriver driver;
    public CartPage(DriverFactory driverFactory){
        this.driver = driverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "#termsofservice") WebElement toscheckbox;
    @FindBy (css = "#checkout") WebElement checkoutBtn;
    @FindBy (css = ".product-name") WebElement cartProductName;

    String cartName;

    public String getProductNameInCart(){
        WaitUtils.waitForVisibility(cartProductName);
        return cartName = cartProductName.getText().trim();
    }
    public void agreeToTermsOfService(){
        toscheckbox.click();}
    public void checkoutItems(){checkoutBtn.click();}
}
