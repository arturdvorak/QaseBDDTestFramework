package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

public class BasePage {
    protected static final By TITLE_PROJECTS = By.xpath("//h1[text()='Projects']");
    protected static final String BASE_URL = PropertyReader.getFromEnvOrFile("BASE_URL", "base.url");
    protected static final String HEADER_PROJECT_NAME = "//p[@class='header'and text()='%s']";
    protected static final String SUBHEADER_PROJECT_CODE = "//span[@class='subheader' and text()='%s']";
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
}
