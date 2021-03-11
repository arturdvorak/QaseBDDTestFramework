Feature: CRUD for suite in qase.io

  Scenario: Creation of suite
    Given project with the following parameters: "Name26", "26", "Description", "Private"
    When user "arimelka@yandex.by" with password "Q033008061zxcv" logs in
    And user creates a new project
    Given suit with the following parameters: "SuiteName1", "Description", "Preconditions"
    And user creates a suite
    Then user should see suite on a project page