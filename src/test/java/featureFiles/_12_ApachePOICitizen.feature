#  Excelden okuduğunuz Citizenship bilgilerinin önce hepsini kaydedin
#  daha sonra da siliniz.

Feature: ApachePOI Citizen Functionality

  Background:
    Given Navigate to Campus
    When Enter valid username and password and click login button
    Then User should login successfully
    And Navigate to Citizenship

  Scenario: Create and Delete CitizenShip From Excel
    When User create citizenship with ApachePOI
    Then User delete citizenship with ApachePOI