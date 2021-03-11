package pages;

import models.Suite;
import org.openqa.selenium.By;

public class CreateSuite extends BasePage {
    private static final By INPUT_SUITE_NAME = By.id("name");
    private static final By INPUT_SUITE_DESCRIPTION = By.xpath("//label[text()='Description']/..//div[@contenteditable='true']");
    private static final By INPUT_SUITE_PRECONDITIONS = By.xpath("//label[text()='Preconditions']/..//div[@contenteditable='true']");
    private static final By BUTTON_CREATE = By.id("save-suite-button");

    public void createNewSuite(Suite suite) {
        driver.findElement(INPUT_SUITE_NAME).sendKeys(suite.getSuiteName());
        driver.findElement(INPUT_SUITE_DESCRIPTION).sendKeys(suite.getSuiteDescription());
        driver.findElement(INPUT_SUITE_PRECONDITIONS).sendKeys(suite.getSuitePreconditions());
        driver.findElement(BUTTON_CREATE).click();
    }
}
