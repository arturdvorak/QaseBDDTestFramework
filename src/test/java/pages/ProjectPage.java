package pages;

import models.Project;
import models.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectPage extends BasePage {
    private static final By TAB_SETTINGS = By.cssSelector("a[title='Settings']");
    private static final By INPUT_PROJECT_NAME = By.id("inputTitle");
    private static final By INPUT_PROJECT_CODE = By.id("inputCode");
    private static final By INPUT_PROJECT_DESCRIPTION = By.id("inputDescription");
    private static final By RADIO_BUTTON_PRIVATE_ACCESS = By.xpath("//label[@for='private-access-type']/../input");
    private static final By BUTTON_CREATE_NEW_SUITE = By.xpath("//a[text()='Create new suite']");
    private static final String TABLE_ROW_SUITE_NAME = "//a[@class='suite-header-title' and text()='%s']";
    private static final String TABLE_ROW_SUITE_DESCRIPTION = "//p[@class='suite-description']/p[text()='%s']";

    public void openSettings() {
        driver.findElement(TAB_SETTINGS).click();
    }

    public void checkProjectDetailsInSettings(Project project) {
        assertEquals(driver.findElement(INPUT_PROJECT_NAME).getAttribute("value"), project.getProjectName(),
                "Project NAME value is saved incorrectly.");
        assertEquals(driver.findElement(INPUT_PROJECT_CODE).getAttribute("value"), "N" + project.getProjectCode(),
                "Project CODE value is saved incorrectly.");
        assertEquals(driver.findElement(INPUT_PROJECT_DESCRIPTION).getText(), project.getProjectDescription(),
                "Project DESCRIPTION value is saved incorrectly.");
        assertTrue(driver.findElement(RADIO_BUTTON_PRIVATE_ACCESS).isSelected(),
                "Project ACCESS value is saved incorrectly.");
    }

    public void openCreateSuite() {
        driver.findElement(BUTTON_CREATE_NEW_SUITE).click();
    }

    public void checkThatSuiteNameIsVisible(Suite suite) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(String.format(TABLE_ROW_SUITE_NAME, suite.getSuiteName()))));
    }

    public void checkThatSuiteDescriptionIsVisible(Suite suite) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(String.format(TABLE_ROW_SUITE_DESCRIPTION, suite.getSuiteDescription()))));
    }

}
