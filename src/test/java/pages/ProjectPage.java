package pages;

import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectPage extends BasePage {
    private static final By TAB_SETTINGS = By.cssSelector("a[title='Settings']");
    private static final By INPUT_PROJECT_NAME = By.id("inputTitle");
    private static final By INPUT_PROJECT_CODE = By.id("inputCode");
    private static final By INPUT_PROJECT_DESCRIPTION = By.id("inputDescription");
    private static final By RADIO_BUTTON_PRIVATE_ACCESS = By.xpath("//label[@for='private-access-type']/../input");

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

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

}
