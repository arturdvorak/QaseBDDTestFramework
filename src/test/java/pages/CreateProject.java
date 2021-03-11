package pages;

import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateProject extends BasePage {
    private static final By INPUT_PROJECT_NAME = By.id("inputTitle");
    private static final By INPUT_PROJECT_CODE = By.id("inputCode");
    private static final By INPUT_PROJECT_DESCRIPTION = By.id("inputDescription");
    private static final By RADIO_BUTTON_PRIVATE_ACCESS = By.cssSelector("label[for='private-access-type']");
    private static final By BUTTON_CREATE_PROJECT = By.xpath("//button[text()='Create project']");

    public void createNewProject(Project project) {
        driver.findElement(INPUT_PROJECT_NAME).sendKeys(project.getProjectName());
        driver.findElement(INPUT_PROJECT_CODE).sendKeys(project.getProjectCode());
        driver.findElement(INPUT_PROJECT_DESCRIPTION).sendKeys(project.getProjectDescription());
        driver.findElement(RADIO_BUTTON_PRIVATE_ACCESS).click();
        driver.findElement(BUTTON_CREATE_PROJECT).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(String.format(HEADER_PROJECT_NAME, project.getProjectName()))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(String.format(SUBHEADER_PROJECT_CODE, "N" + project.getProjectCode()))));
    }
}
