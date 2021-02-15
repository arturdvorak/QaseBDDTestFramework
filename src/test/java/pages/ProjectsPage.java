package pages;

import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectsPage extends BasePage {
    private static final By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    private static final By INPUT_SEARCH = By.name("title");
    private static final By TITLE_NEW_PROJECT = By.xpath("//h1[text()='New Project']");
    private static final String TABLE_ROW_PROJECT_NAME = "//a[@class='defect-title' and text()='%s']";


    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(BASE_URL +"projects");
    }

    public void openCreateProjectPage() {
        driver.findElement(CREATE_NEW_PROJECT_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_NEW_PROJECT));
    }

    public void searchByProjectName(Project project) {
        driver.findElement(INPUT_SEARCH).sendKeys(project.getProjectName());
    }

    public void checkThatProjectIsVisible(Project project) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(String.format(TABLE_ROW_PROJECT_NAME, project.getProjectName()))));
    }

    public void openProjectFromTable(Project project) {
        driver.findElement(By.xpath(String.format(TABLE_ROW_PROJECT_NAME, project.getProjectName()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(String.format(HEADER_PROJECT_NAME, project.getProjectName()))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(String.format(SUBHEADER_PROJECT_CODE, "N" + project.getProjectCode()))));
    }
}
