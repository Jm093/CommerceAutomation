package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;
public class LoginPage {
    WebDriver driver;


    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#Email") WebElement emailField;
    @FindBy(css = "#Password") WebElement passwordField;
    @FindBy(css = "button[class='button-1 login-button']") WebElement loginBtn;


    public void login(String email, String password){
        WaitUtils.waitForClickable(emailField);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
    }
}
