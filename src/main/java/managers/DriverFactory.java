package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import utils.ConfigReader;


public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeDriver(){
        String browser = ConfigReader.getBrowser().toLowerCase();
        if (driver.get() == null){
            switch (browser){
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if ("true".equalsIgnoreCase(ConfigReader.get("headless"))) {
                        chromeOptions.addArguments("--headless=new");
                    }
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    chromeOptions.addArguments("--start-maximized");

                    // Anti-bot flags (ONLY needed for the nopCommerce public demo site to bypass bot detection).
                    chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                    chromeOptions.setExperimentalOption("useAutomationExtension", false);
                    chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                    chromeOptions.addArguments("--disable-infobars");
                    chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                            "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");

                    driver.set(new ChromeDriver(chromeOptions));
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();

                    if ("true".equalsIgnoreCase(ConfigReader.get("headless"))) {
                        firefoxOptions.addArguments("--headless");
                    }

                    firefoxOptions.addArguments("--width=1920");
                    firefoxOptions.addArguments("--height=1080");

                    driver.set(new FirefoxDriver(firefoxOptions));
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();

                    if ("true".equalsIgnoreCase(ConfigReader.get("headless"))) {
                        edgeOptions.addArguments("--headless=new");
                    }
                    edgeOptions.addArguments("--disable-gpu");
                    edgeOptions.addArguments("--no-sandbox");
                    edgeOptions.addArguments("--disable-dev-shm-usage");
                    edgeOptions.addArguments("--remote-allow-origins=*");
                    edgeOptions.addArguments("--start-maximized");

                    driver.set(new EdgeDriver(edgeOptions));
                    break;

                case "safari":
                    driver.set(new SafariDriver());
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            driver.get().manage().window().maximize();


        }

    }
    public static WebDriver getDriver(){

        if (driver.get() == null){
            throw new IllegalArgumentException("Driver not initialized. Call initializeDriver() first.");
        }
        else {
            return driver.get();
        }
    }
    public static void quitDriver(){
        if (driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }
}
