package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverConfiguration {

    private static ChromeOptions options;
    public static ChromeDriver driver;

    public static void setupDriver() {
        chromeOptionConfiguration();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    public static void quitDriver() {
        driver.quit();
    }

    private static void chromeOptionConfiguration() {
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        options.addArguments("--headless");
    }
}
