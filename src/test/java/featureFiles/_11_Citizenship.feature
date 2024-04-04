# CitizenShip menusunun kayıt ve silme özelliğini
# (DataTable ile) 5 farklı değer seti ile çalıştırınız.

Feature: CitizenShip functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Create CitizenShip and Delete
    And Click on the Element in LeftNav
      | setup       |
      | parameters  |
      | citizenship |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | <name>  |
      | shortName | <short> |

    And Click on the Element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | <name> |

    Then Success message should be displayed
    Examples:
      | name   | short   |
      | isCS31 | isCSk31 |
      | isCS32 | isCSk32 |
      | isCS33 | isCSk33 |
      | isCS34 | isCSk34 |
      | isCS35 | isCSk35 |