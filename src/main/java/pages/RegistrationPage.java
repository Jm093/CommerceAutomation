package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#FirstName") WebElement fnRegistration;
    @FindBy(css = "#LastName") WebElement lnRegistration;
    @FindBy(css = "#Email ") WebElement emailRegistration;
    @FindBy(css = "#Password") WebElement passwordRegistration;
    @FindBy(css = "#ConfirmPassword") WebElement confirmPasswordRegistration;
    @FindBy(xpath = "//button[@id='register-button']") WebElement registerBtn;
    @FindBy(xpath = "//div[@class='result']") WebElement registrationResult;

    String actualMessage;

    public void fillRegistration(String firstName, String lastName, String email, String password){
        fnRegistration.sendKeys(firstName);
        lnRegistration.sendKeys(lastName);
        emailRegistration.sendKeys(email);
        passwordRegistration.sendKeys(password);
        confirmPasswordRegistration.sendKeys(password);
    }
    public void clickRegisterBtn(){
        registerBtn.click();
    }
    public String getSuccessfulRegistrationMessage(){
       return actualMessage = registrationResult.getText().trim();
    }
}
