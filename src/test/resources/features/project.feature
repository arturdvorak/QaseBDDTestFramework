Feature: CRUD for projects in qase.io
    Scenario: Creation of project
      Given project with the following parameters: "Name", "Code", "Description", "Private"
      When user "arimelka@yandex.by" with password "Q033008061zxcv" logs in
      And opens Projects page
      And creates a new project
      Then user should see project in a list
      And user opens project
      Then project details should be the following: "Name", "Code", "Description", "Private"