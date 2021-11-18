import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;

@Slf4j
public class FirstTemplateTest extends BaseTest {

    @Test(description = "First basic test to check if it works")
    public void firstCheck() {
        log.info("Start test");
        HomePage.getHomePage();
        Assert.assertEquals(2, 4);
    }

    @Test(groups = {"Debug"})
    public void exampleTwo() {
        Assert.assertEquals(3, 3);
    }

    @Test(groups = {"Debug"})
    public void exampleThree() {
        Assert.assertEquals(3, 3);
    }

    @Test
    public void exampleFour() {
        Assert.assertEquals(3, 3);
    }
}
