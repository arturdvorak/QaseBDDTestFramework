package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    protected final static String ACTIVE_TAB_LOCATOR = "//div[contains(@class,'active')]";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
