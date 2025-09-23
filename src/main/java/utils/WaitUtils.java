package utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class WaitUtils {
    private WebDriver driver;   
    public WaitUtils(WebDriver driver){
        this.driver = driver;
    }
    private WebDriverWait getWait(){
       return new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getExplicitWait()));
    }
    public void waitForVisibility (WebElement element){
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }
    public void waitForClickable (WebElement element){
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }
    public void waitForTextToBePresent (WebElement element, String text){
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.textToBePresentInElement(element,text)));
    }
    public void waitForAlert (){
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.alertIsPresent()));
    }
}
