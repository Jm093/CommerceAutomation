package hooks;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private final DriverFactory driverFactory;

    public Hooks(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }

    @Before
    public void setUp(Scenario scenario) {
        long threadId = Thread.currentThread().getId();
        System.out.println("Starting scenario: " + scenario.getName() + " on thread: " + threadId);
        driverFactory.initializeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        long threadId = Thread.currentThread().getId();
        WebDriver driver = null;
        try {
            try {
                driver = driverFactory.getDriver();
            } catch (IllegalArgumentException e) {
                driver = null;
            }

            if (scenario.isFailed()) {
                System.out.println("Scenario FAILED: " + scenario.getName() + " on thread: " + threadId);
                if (driver != null) {
                    try {
                        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                        scenario.attach(screenshot, "image/png", "Failure Screenshot");
                    } catch (Exception ex) {
                        System.out.println("Warning: unable to capture screenshot: " + ex.getMessage());
                    }
                } else {
                    System.out.println("No WebDriver available to capture screenshot for failed scenario.");
                }
            } else {
                System.out.println("Scenario PASSED: " + scenario.getName() + " on thread: " + threadId);
            }
        } finally {

            try {
                driverFactory.quitDriver();
            } catch (Exception e) {
                System.out.println("Warning: exception while quitting driver in @After: " + e.getMessage());
            }
        }
    }
}
