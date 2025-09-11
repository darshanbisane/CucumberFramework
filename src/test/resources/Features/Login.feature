Feature: Login Functionally

  Scenario: valid_Login_TC2
    Given user should be on the login page.
    When user Enters valid Credential and click on login page.
    Then user should be navigate to home page.
    And user can see logout link on home page.

  Scenario Outline: Invalid_Login_TC1
    Given user should be on the login page.
    When user Enters Invalid Credential userid as "<username>" and password as "<password>" and click on login page.
    Then user should be on login page.
    And user can see the error message.

    Examples:
    |username | password |
    |admin1 | pwd1     |
   # |admin2 | pwd2     |
    #|admin3 | pwd3     |