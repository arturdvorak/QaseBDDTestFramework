package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.PropertyReader;

public class LoginPage extends BasePage {
    private static final By INPUT_LOGIN = By.id("inputEmail");
    private static final By INPUT_PASSWORD = By.id("inputPassword");
    private static final By BUTTON_LOGIN = By.id("btnLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(BASE_URL +"login");
    }

    public void login(String userName, String passwordKeys) {
        driver.findElement(INPUT_LOGIN).sendKeys(userName);
        driver.findElement(INPUT_PASSWORD).sendKeys(passwordKeys);
        driver.findElement(BUTTON_LOGIN).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_PROJECTS));
    }
}
