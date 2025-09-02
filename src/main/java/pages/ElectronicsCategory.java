package pages;
import managers.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import utils.WaitUtils;

public class ElectronicsCategory {
    private WebDriver driver;
    public ElectronicsCategory(DriverFactory driverFactory){
        this.driver=driverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "img[title='Show products in category Cell phones']") WebElement cellphoneCategory;
    @FindBy (xpath = "//h2[@class='product-title']//a[contains(text(),'Samsung Galaxy S24 256GB')]") WebElement samsungPhone;
    @FindBy (css = "#add-to-cart-button-22") WebElement samsungAddToCart;


    String productName;

    public void selectPhoneCategory(){
        WaitUtils.waitForClickable(cellphoneCategory);
        cellphoneCategory.click();}
    public String getProductName(){
        WaitUtils.waitForVisibility(samsungPhone);
        return productName = samsungPhone.getText().trim();
    }
    public void addPhoneToCart(){
        WaitUtils.waitForClickable(samsungPhone);
        samsungPhone.click();
        samsungAddToCart.click();
    }

}
