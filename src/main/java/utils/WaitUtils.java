package utils;
import managers.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static final WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
    public static void waitForVisibility (WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForClickable (WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitForTextToBePresent (WebElement element, String text){
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }
    public static void waitForAlert (){
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
