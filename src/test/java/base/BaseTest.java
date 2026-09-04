package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        String browser = ConfigReader.getProperty("browser");
        String appUrl = ConfigReader.getProperty("url");

        System.out.println("Starting test execution on browser: " + browser);
        System.out.println("Navigating to URL: " + appUrl);

        driver = DriverFactory.initDriver();

        if (appUrl != null && !appUrl.isEmpty()) {
            driver.get(appUrl);
        } else {
            throw new RuntimeException("Application URL is not specified in config.properties!");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            System.out.println("Closing browser session...");
            driver.quit();
        }
    }
}
