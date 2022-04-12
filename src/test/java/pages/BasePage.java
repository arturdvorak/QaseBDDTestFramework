package pages;

import driver.BrowserType;
import driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.time.Duration;

public class BasePage {
    protected static final By TITLE_PROJECTS = By.xpath("//h1[text()='Projects']");
    protected static final String BASE_URL = PropertyReader.getFromEnvOrFile("BASE_URL", "base.url");
    protected static final String HEADER_PROJECT_NAME = "//p[@class='header'and text()='%s']";
    protected static final String SUBHEADER_PROJECT_CODE = "//span[@class='subheader' and text()='%s']";
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl;

    public BasePage() {
        this.driver = WebDriverSingleton.getWebDriverInstance(BrowserType.valueOf(PropertyReader.getFromEnvOrFile("BROWSER_TYPE", "browser.type")));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        baseUrl = PropertyReader.getFromEnvOrFile("BASE_URL", "base.url");
    }
}
