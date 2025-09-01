package pages;
import managers.DriverFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;


public class LoginPage {
    private WebDriver driver;

    public LoginPage(DriverFactory driverFactory){
        this.driver=driverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#Email") WebElement emailField;
    @FindBy(css = "#Password") WebElement passwordField;
    @FindBy(css = "button[class='button-1 login-button']") WebElement loginBtn;
    @FindBy(css = ".message-error.validation-summary-errors") WebElement invalidEmailPassword;
    @FindBy(css = "#Email-error") WebElement invalidEmail;
    @FindBy(css = "a[href='/passwordrecovery']") WebElement forgotPasswordBtn;
    @FindBy(css = "div[class='page-title'] h1") WebElement validateForgotPasswordPage;
    @FindBy(css = "#Email") WebElement recoveryEmail;
    @FindBy(css = "button[name='send-email']") WebElement recoverBtn;
    @FindBy(css = ".content") WebElement notification;


    public void login(String email, String password){
        WaitUtils.waitForClickable(emailField);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
    }
    public String getInvalidLoginError() {
        try {
            WaitUtils.waitForVisibility(invalidEmailPassword);
            return invalidEmailPassword.getText().trim();
        }catch (TimeoutException e){
            return "";
    }

    }
    public String getInvalidEmailError(){
        try {
            WaitUtils.waitForVisibility(invalidEmail);
            return invalidEmail.getText().trim();
        } catch (TimeoutException e){
            return "";
        }
    }

    public void clickForgotPassword(){
        WaitUtils.waitForClickable(forgotPasswordBtn);
        forgotPasswordBtn.click();
    }

    public String getForgotPasswordPageTitle(){
        WaitUtils.waitForVisibility(validateForgotPasswordPage);
        return validateForgotPasswordPage.getText().trim();
    }

    public void enterRecoveryEmail(String email){
        WaitUtils.waitForVisibility(recoveryEmail);
        recoveryEmail.sendKeys(email);
    }

    public void clickRecoverBtn(){
        WaitUtils.waitForClickable(recoverBtn);
        recoverBtn.click();
    }

    public String getNotificationMessage(){
        WaitUtils.waitForVisibility(notification);
        return notification.getText().trim();
    }
}
