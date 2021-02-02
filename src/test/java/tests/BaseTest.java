package tests;

import driver.BrowserType;
import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import steps.ProjectSteps;
import utils.PropertyReader;

public class BaseTest {
    public static String browserType;
    public static String baseUrl;
    String username;
    String password;
    private WebDriver driver;
    ProjectSteps projectSteps;

    @BeforeClass(description = "Initializing properties and browser")
    public void setUp(ITestContext context) {
        baseUrl = PropertyReader.getFromEnvOrFile("BASE_URL", "base.url");
        username = PropertyReader.getFromEnvOrFile("USERNAME", "username");
        password = PropertyReader.getFromEnvOrFile("PASSWORD", "password");
        browserType = PropertyReader.getFromEnvOrFile("BROWSER_TYPE", "browser.type");
        driver = WebDriverSingleton.getWebDriverInstance(BrowserType.valueOf(browserType));
        //projectSteps = new ProjectSteps(driver);
    }

    @AfterClass(description = "Closing browser")
    public void closeDriver() {
        driver.close();
    }
}
