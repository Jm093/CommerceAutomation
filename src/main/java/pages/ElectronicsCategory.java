package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ElectronicsCategory {
    WebDriver driver;
    public ElectronicsCategory(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "img[title='Show products in category Cell phones']") WebElement cellphoneCategory;
    @FindBy (xpath = "//h2[@class='product-title']//a[contains(text(),'Samsung Galaxy S24 256GB')]") WebElement samsungPhone;
    @FindBy (css = "#add-to-cart-button-22") WebElement samsungAddToCart;


    String productName;

    public void selectPhoneCategory(){cellphoneCategory.click();}
    public String getProductName(){
        return productName = samsungPhone.getText().trim();
    }
    public void addPhoneToCart(){
        samsungPhone.click();
        samsungAddToCart.click();
    }

}
