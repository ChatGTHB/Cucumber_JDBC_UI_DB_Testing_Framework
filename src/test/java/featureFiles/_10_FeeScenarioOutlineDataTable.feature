Feature: Fees Multiple Values Functionality

  Background:
    Given Navigate to Campus
    When Enter valid username and password and click login button
    Then User should login successfully

  Scenario Outline: Fee Functionality
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priorityCode    | <priority> |

    And Click on the element in Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be displayed

    And User delete the element from Dialog
      | <name> |

    Then Success message should be displayed

    Examples:
      | name    | code | intCode  | priority |
      | KrmFee1 | 2224 | PayPal   | 1234     |
      | KrmFee2 | 2225 | Cash     | 1235     |
      | KrmFee3 | 2226 | Cheque   | 1236     |
      | KrmFee4 | 2227 | ApplePay | 1237     |
      | KrmFee5 | 2229 | Crypto   | 1238     |