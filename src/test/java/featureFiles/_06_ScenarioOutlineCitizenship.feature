Feature: Citizenship Functionality

  Background:
    Given Navigate to Campus
    When Enter valid username and password and click login button
    Then User should login successfully
    And Navigate to Citizenship

  Scenario Outline: Create a Citizenship
    When Create a Citizenship that name as "<name>" short name as "<shortname>"
    Then Success message should be displayed

    When Create a Citizenship that name as "<name>" short name as "<shortname>"
    Then Already exist message should be displayed

    Examples:
      | name      | shortname |
      | krm23s001 | sh56is1   |
      | krm23s002 | sh56is2   |
      | krm23s003 | sh56is3   |
      | krm23s004 | sh56is4   |
      | krm23s005 | sh56is5   |
