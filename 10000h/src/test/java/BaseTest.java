import configuration.DriverConfiguration;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public abstract class BaseTest {

    @BeforeSuite
    @Step("Initialize driver")
    public void setUp() {
        log.info("Initialize driver");
        DriverConfiguration.setupDriver();
    }

    @AfterSuite
    @Step("Quit driver")
    public void tearDown() {
        log.info("Quit driver");
        DriverConfiguration.quitDriver();
    }

    @AfterMethod
    protected void screenShotIfFail(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            takeScreenShot(result.getMethod());
        }
    }

    private void takeScreenShot(ITestNGMethod testMethod) throws IOException {
        String nameScreenShot = testMethod.getTestClass().getRealClass()
                .getSimpleName()
                + "_" + testMethod.getMethodName();
        takeScreenShot(nameScreenShot);
    }
    private String makeScreenShotFileName(String name) {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
        Date date = new Date();
        return dateFormat.format(date) + "_" + name + ".png";
    }
    private String getRelativePath(String name) throws IOException {
        Path path = Paths.get(".", "target", "surefire-reports", "screenShots",
                makeScreenShotFileName(name));
        File directory = new File(path.toString());
        return directory.getCanonicalPath();
    }

    @Attachment(value = "{name}", type = "image/png")
    private byte[] takeScreenShot(String name) throws IOException {
        return ((TakesScreenshot) DriverConfiguration.driver).getScreenshotAs(OutputType.BYTES);
    }
}
