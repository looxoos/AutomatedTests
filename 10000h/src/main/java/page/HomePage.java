package page;

import configuration.DriverConfiguration;
import io.qameta.allure.Step;

public class HomePage extends DriverConfiguration {

    @Step("Open home page")
    public static void getHomePage() {
        driver.get("https://www.google.com/");
    }
}
