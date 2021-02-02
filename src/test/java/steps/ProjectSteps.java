package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class ProjectSteps {
    LoginPage loginPage;

    @Given("project with the following parameters: {string}, {string}, {string}, {string}")
    public void projectWithTheFollowingParameters(String name, String code, String description, String access) {
        Project.builder()
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

    @And("opens Projects page")
    public void opensProjectsPage() {
    }

    @And("creates a new project")
    public void createsANewProject() {
    }

    @Then("user should see project in a list")
    public void userShouldSeeProjectInAList() {
    }

    @And("user opens project")
    public void userOpensProject() {
    }

    @Then("project details should be the following: {string}, {string}, {string}, {string}")
    public void projectDetailsShouldBeTheFollowing(String arg0, String arg1, String arg2, String arg3) {
    }
}
