Feature: Exam functionality

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully

  Scenario: Exam Create and Delete
    And Click on the element in LeftNav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | Krm941Exam1 |

    And Click on the element in Dialog
      | academicPeriod  |
      | academicPeriod1 |
      | gradeLevel      |
      | gradeLevel2     |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

#    Navigate again to reach the delete screen
    And Click on the element in LeftNav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in Dialog
      | searchAcademicPeriod |
      | academicPeriod1      |

    And User delete the element from Dialog
      | Krm941Exam1 |

    Then Success message should be displayed