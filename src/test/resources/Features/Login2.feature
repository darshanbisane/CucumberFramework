Feature: Login functionality

  Scenario: Valid login with correct username and password
    Given user is on the login page
    When user enters a valid username and valid password
    And clicks on the login button
    Then user should be navigated to the home page
    And user should see the logout link

  Scenario: Login with valid credentials and remember me checked
    Given user is on the login page
    When user enters a valid username and valid password
    And selects the remember me checkbox
    And clicks on the login button
    Then user should stay logged in even after closing and reopening the browser

  Scenario: Login with case-insensitive username (if system supports)
    Given user is on the login page
    When user enters a valid username in uppercase and valid password
    And clicks on the login button
    Then user should be navigated to the home page
#nigative
  Scenario: Invalid login with wrong password
    Given user is on the login page
    When user enters a valid username and invalid password
    And clicks on the login button
    Then user should see an error message "Invalid username or password"

  Scenario: Invalid login with non-existing username
    Given user is on the login page
    When user enters an invalid username and any password
    And clicks on the login button
    Then user should see an error message "User does not exist"

  Scenario: Login attempt with empty username and password
    Given user is on the login page
    When user leaves the username and password fields blank
    And clicks on the login button
    Then user should see an error message "Username and Password are required"

  Scenario: Login attempt with SQL injection
    Given user is on the login page
    When user enters "' OR '1'='1" as username and password
    And clicks on the login button
    Then user should see an error message "Invalid username or password"
#edge
  Scenario: Login with maximum allowed characters in username and password
    Given user is on the login page
    When user enters a username of 50 characters and password of 50 characters
    And clicks on the login button
    Then user should see an appropriate error or success depending on validity

  Scenario: Login with special characters in username and password
    Given user is on the login page
    When user enters "user.name+123@example.com" as username and "!@#Test123" as password
    And clicks on the login button
    Then user should be navigated to the home page

  Scenario: Multiple failed login attempts leading to account lock
    Given user is on the login page
    When user enters invalid credentials 5 times
    Then the account should be locked
    And user should see an error message "Account locked. Please reset your password."

  Scenario: Login session timeout after inactivity
    Given user is logged in successfully
    When user is idle for 15 minutes
    Then user should be automatically logged out
    And redirected to the login page
