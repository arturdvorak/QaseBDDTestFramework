package steps;

import driver.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.Project;
import models.Suite;
import pages.*;

public class SuiteSteps {
    LoginPage loginPage;
    ProjectPage projectPage;
    ProjectsPage projectsPage;
    CreateProject createProject;
    CreateSuite createSuite;
    Project project;
    Suite suite;

    @Before()
    public void setUp() {
        loginPage = new LoginPage();
        projectPage = new ProjectPage();
        projectsPage = new ProjectsPage();
        createProject = new CreateProject();
        createSuite = new CreateSuite();
    }

    @Given("suit with the following parameters: {string}, {string}, {string}")
    public void suitWithTheFollowingParameters(String name, String description, String preconditions) {
        suite = Suite.builder()
                .suiteName(name)
                .suiteDescription(description)
                .suitePreconditions(preconditions)
                .build();
    }

    @And("user creates a suite")
    public void userCreatesASuite() {
        projectPage.openCreateSuite();
        createSuite.createNewSuite(suite);
    }

    @Then("user should see suite on a project page")
    public void userShouldSeeSuiteOnAProjectPage() {
        projectPage.checkThatSuiteNameIsVisible(suite);
        projectPage.checkThatSuiteDescriptionIsVisible(suite);
    }

    @After()
    public void closeDriver() {
        WebDriverSingleton.close();
    }


}
