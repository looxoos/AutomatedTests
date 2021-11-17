import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class FirstTestTemplate extends BaseTest{

    @Test(description = "First basic test to check if it works")
    public void firstCheck() {
        log.info("Start test");
        driver.get("https://www.google.com/");
    }
}
