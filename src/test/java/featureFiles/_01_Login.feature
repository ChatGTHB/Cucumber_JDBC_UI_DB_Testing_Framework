Feature: Login functionality

  @SmokeTest
  Scenario: Login with valid username and password
    Given Navigate to campus
    When  Enter valid username and password and click login button
    Then  User should login successfully