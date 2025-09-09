package utils;
import managers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static WebDriverWait getWait(){
       return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
    }
    public static void waitForVisibility (WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForClickable (WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitForTextToBePresent (WebElement element, String text){
        getWait().until(ExpectedConditions.textToBePresentInElement(element,text));
    }
    public static void waitForAlert (){
        getWait().until(ExpectedConditions.alertIsPresent());
    }
}
