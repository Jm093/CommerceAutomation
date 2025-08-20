package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import utils.ConfigReader;
import utils.WaitUtils;

public class HomePage {
    WebDriver driver;
    String pageURL = ConfigReader.getBaseURL();

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".ico-login") WebElement loginPortal;
    @FindBy(css = ".ico-logout") WebElement logoutBtn;
    @FindBy(css = "img[title='Show products in category Electronics']") WebElement electronicsPortal;
    @FindBy(css = ".ico-cart") WebElement cartPortal;
    @FindBy(css = ".ico-register") WebElement registrationPortal;
    @FindBy(css = "div[class='topic-block-title'] h2") WebElement homePageText;
    String homePageDisplay;
    public void navigateToPage(){
        driver.get(pageURL);
    }
    public void clickLoginPage(){
        WaitUtils.waitForClickable(loginPortal);
        loginPortal.click();
    }
    public void clickLogout(){
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
        return homePageDisplay = homePageText.getText().trim();

    }
}
