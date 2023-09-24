Feature: Login functionality

  Scenario: Login with valid username and password

    Given Navigate to Campus
    When  Enter valid username and password and click login button
    Then  User should login successfully