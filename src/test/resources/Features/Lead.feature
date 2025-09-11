Feature: Lead functionality

  Background:
    Given user should be on the login page.
    When user Enters valid Credential and click on login page.
    Then user should be navigated to home page.

  @CreateLead
  Scenario: Create_Lead_with_Mandatory_Fields_TC03
    When user click on new lead.
    And fill all mandatory fields and click on save.
    Then lead should be created successfully.