package pages;
import managers.DriverFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.WaitUtils;

public class HomePage {
    private WebDriver driver;
    String pageURL = ConfigReader.getBaseURL();

    public HomePage(DriverFactory driverFactory){
        this.driver = driverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".ico-login") WebElement loginPortal;
    @FindBy(css = ".ico-logout") WebElement logoutBtn;
    @FindBy(css = "img[title='Show products in category Electronics']") WebElement electronicsPortal;
    @FindBy(css = ".ico-cart") WebElement cartPortal;
    @FindBy(css = ".ico-register") WebElement registrationPortal;
    @FindBy(css = "div[class='topic-block-title'] h2") WebElement homePageText;
    @FindBy(css = ".ico-account") WebElement accountInfo;
    @FindBy(css = "#small-searchterms") WebElement searchField;
    @FindBy(css = "button[type='submit']") WebElement searchBtn;
    @FindBy(css = "h2[class='product-title'] a") WebElement searchedItem;
    @FindBy(css = ".no-result") WebElement noResultFoundMsg;

    public void navigateToPage(){
        driver.get(pageURL);
    }
    public void clickLoginPage(){
        WaitUtils.waitForClickable(loginPortal);
        loginPortal.click();
    }
    public void clickLogout(){
        WaitUtils.waitForClickable(logoutBtn);
        logoutBtn.click();
    }
    public void clickElectronicsCategory(){
        WaitUtils.waitForClickable(electronicsPortal);
        electronicsPortal.click();
    }
    public void cart(){
        WaitUtils.waitForVisibility(cartPortal);
        cartPortal.click();
    }
    public void clickRegisterPage(){
        WaitUtils.waitForClickable(registrationPortal);
        registrationPortal.click();
    }

    public String getHomePageTextDisplay(){
        WaitUtils.waitForVisibility(homePageText);
        return homePageText.getText().trim();
    }

    public boolean isAccountInfoIconVisible(){
        try{
            return accountInfo.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
    public boolean isLogoutButtonVisible(){
        try{
            return logoutBtn.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
    public void searchItem(String item){
        WaitUtils.waitForVisibility(searchField);
        searchField.sendKeys(item);
    }
    public void clickSearchBtn(){
        WaitUtils.waitForClickable(searchBtn);
        searchBtn.click();
    }
    public String getSearchResult(){
        WaitUtils.waitForVisibility(searchedItem);
        return searchedItem.getText().trim();
    }
    public String getNoResultMessage(){
        WaitUtils.waitForVisibility(noResultFoundMsg);
        return noResultFoundMsg.getText().trim();
    }
}
