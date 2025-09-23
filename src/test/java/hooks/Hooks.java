package hooks;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
private DriverFactory driverFactory;
public Hooks(DriverFactory driverFactory){
    this.driverFactory=driverFactory;
    }
   @Before
   public void setUp(Scenario scenario){
       System.out.println("Starting:" + scenario.getName());
       DriverFactory.initializeDriver();
   }
   @After
    public void tearDown(Scenario scenario) {
       WebDriver driver = driverFactory.getDriver();
        if (scenario.isFailed()){
           System.out.println("Failed:" + scenario.getName());
           final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
           scenario.attach(screenshot, "image/png", "Failure Screenshot");
       }
       else {
           System.out.println("Passed:" + scenario.getName());
       }
       driverFactory.quitDriver();
    }
}
