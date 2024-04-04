# Login function check
# First go to the website (driver.get)
# Then enter your Login information (username password sendkeys)
# Then check (verify) that you are logged in

Feature: Login functionality

  @SmokeTest @Regression
  Scenario: Login with valid username and password
    Given Navigate to campus
    When  Enter valid username and password and click login button
    Then  User should login successfully