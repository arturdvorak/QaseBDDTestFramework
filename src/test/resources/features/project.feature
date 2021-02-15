Feature: CRUD for projects in qase.io
    Scenario: Creation of project
      Given project with the following parameters: "Name17", "17", "Description17", "Private"
      When user "arimelka@yandex.by" with password "Q033008061zxcv" logs in
      And user creates a new project
      And user opens Projects page
      And user searches by project name
      Then user should see project in a list
      And user opens project
      Then user checks project details