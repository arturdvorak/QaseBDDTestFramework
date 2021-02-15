package steps;

import driver.BrowserType;
import driver.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.CreateProject;
import pages.LoginPage;
import pages.ProjectPage;
import pages.ProjectsPage;
import utils.PropertyReader;

public class ProjectSteps {
    public static String browserType;
    public static String baseUrl;
    String username;
    String password;
    private WebDriver driver;
    LoginPage loginPage;
    ProjectPage projectPage;
    ProjectsPage projectsPage;
    CreateProject createProject;
    Project project;

    @Before()
    public void setUp() {
        baseUrl = PropertyReader.getFromEnvOrFile("BASE_URL", "base.url");
        username = PropertyReader.getFromEnvOrFile("USERNAME", "username");
        password = PropertyReader.getFromEnvOrFile("PASSWORD", "password");
        browserType = PropertyReader.getFromEnvOrFile("BROWSER_TYPE", "browser.type");
        driver = WebDriverSingleton.getWebDriverInstance(BrowserType.valueOf(browserType));
        loginPage = new LoginPage(driver);
        projectPage = new ProjectPage(driver);
        projectsPage = new ProjectsPage(driver);
        createProject = new CreateProject(driver);
    }

    @Given("project with the following parameters: {string}, {string}, {string}, {string}")
    public void projectWithTheFollowingParameters(String name, String code, String description, String access) {
        project = Project.builder()
                .projectName(name)
                .projectCode(code)
                .projectDescription(description)
                .access(access)
                .build();
    }

    @When("user {string} with password {string} logs in")
    public void userWithPasswordLogsIn(String username, String password) {
        loginPage.openPage();
        loginPage.login(username, password);
    }

    @And("user opens Projects page")
    public void opensProjectsPage() {
        projectsPage.openPage();
    }

    @And("user creates a new project")
    public void createsANewProject() {
        projectsPage.openCreateProjectPage();
        createProject.createNewProject(project);
    }

    @And("user searches by project name")
    public void userSearchesByProjectName() {
        projectsPage.searchByProjectName(project);
    }

    @Then("user should see project in a list")
    public void userShouldSeeProjectInAList() {
        projectsPage.checkThatProjectIsVisible(project);
    }

    @And("user opens project")
    public void userOpensProject() {
        projectsPage.openProjectFromTable(project);
    }

    @Then("user checks project details")
    public void userChecksProjectDetails() {
        projectPage.openSettings();
        projectPage.checkProjectDetailsInSettings(project);
    }

    @After()
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
