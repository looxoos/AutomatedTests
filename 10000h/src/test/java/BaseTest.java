import Configuration.DriverConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@Slf4j
public abstract class BaseTest {

    public WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = DriverConfiguration.setupDriver();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
