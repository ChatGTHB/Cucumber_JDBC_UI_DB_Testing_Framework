Feature: Citizenship Functionality

  Scenario: Create a Citizenship
    Given Navigate to Campus
    When  Enter valid username and password and click login button
    Then  User should login successfully
    And   Navigate to Citizenship
    When  Create a Citizenship
    Then  Success message should be displayed
