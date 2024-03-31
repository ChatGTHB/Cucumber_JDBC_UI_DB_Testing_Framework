Feature: Citizenship Functionality

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully
    And Navigate to citizenship

  Scenario Outline: Create a Citizenship
    When Create a citizenship that name as "<name>" short name as "<shortname>"
    Then Success message should be displayed

    When Create a citizenship that name as "<name>" short name as "<shortname>"
    Then Already exist message should be displayed

    When User delete the citizenship that name as "<name>"
    Then Success message should be displayed

    Examples:
      | name      | shortname |
      | krm23s001 | sh561     |
      | krm23s002 | sh562     |
      | krm23s003 | sh563     |
      | krm23s004 | sh564     |
      | krm23s005 | sh565     |
