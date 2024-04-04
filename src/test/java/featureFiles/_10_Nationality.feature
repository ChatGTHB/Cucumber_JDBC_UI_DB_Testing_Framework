# Nationality menusunun kayıt ve silme özelliğini
# (DataTable ile) 5 farklı değer seti ile çalıştırınız.

Feature: Nationality functionality

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully

  @Regression
  Scenario Outline: Create Nationality and Delete
    And Click on the element in LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | <name> |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the element from Dialog
      | <name> |

    Then Success message should be displayed
    Examples:
      | name        |
      | Turkish01   |
      | Kurdish01   |
      | Italian01   |
      | Spanish01   |
      | Norwegian01 |