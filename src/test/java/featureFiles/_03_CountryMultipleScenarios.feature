Feature: Country Multi Scenario

  Background:
    Given Navigate to Campus
    When  Enter valid username and password and click login button
    Then  User should login successfully
    And   Navigate to country

  Scenario: Create a country
    When  Create a country
    Then  Success message should be displayed

  Scenario: Create a country 2
    When  Create a country that name as "Krm1001" code as "U1001"
    Then  Success message should be displayed
 

