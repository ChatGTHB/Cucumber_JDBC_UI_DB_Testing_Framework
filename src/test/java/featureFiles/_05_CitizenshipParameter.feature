Feature: Citizenship Functionality

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully
    And Navigate to citizenship

  Scenario: Create a Citizenship
    When Create a Citizenship that name as "krmsd1001" short name as "ksd1"
    Then Success message should be displayed

    When Create a Citizenship that name as "krmsd1001" short name as "ksd1"
    Then Already exist message should be displayed

