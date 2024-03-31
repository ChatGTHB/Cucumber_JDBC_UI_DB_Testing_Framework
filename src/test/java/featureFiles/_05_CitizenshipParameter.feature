# Scenario
# Go to the Citizenship page.
# Verify the create operation with the parameter method.
# Then verify that it is not possible to Create again with the same information. (Negative test)
# Verify the deletion of the information entered in a separate scenario


Feature: Citizenship Functionality

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully
    And Navigate to citizenship

  Scenario: Create a Citizenship
    When Create a citizenship that name as "krmsd1013" short name as "ksd13"
    Then Success message should be displayed

    When Create a citizenship that name as "krmsd1013" short name as "ksd13"
    Then Already exist message should be displayed

  Scenario: Delete the citizenship
    When User delete the citizenship that name as "krmsd1013"
    Then Success message should be displayed

