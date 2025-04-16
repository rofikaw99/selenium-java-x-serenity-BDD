Feature: To Onboarding file upload features in CUBEforall Portal Admin

  @EAL @EAL_O_1
  Scenario Outline: Onboard using Support App select future effective month
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And select the country
    And select future effective date "<effectiveDate>" in this case just select the month option
    And input OCR number "<ocr>"
    And click populate
    Then the onboard data display in support app with correct information
    And click submit to onboard
    Then success submit onboard data

    Examples:
      | userID   | password | effectiveDate | ocr |
      | RAwaludin | password | 2025-07       | 1126 |

  @EAL @EAL_O_2
  Scenario Outline:  Onboard using Support App if not select future effective month
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And select the country
    And select past future effective date "<effectiveDate>"
    And click populate
    Then error validation cannot pick the date will display

    Examples:
      | userID    | password | effectiveDate |
      | RAwaludin | password | 2025-04       |

  @EAL @EAL_0_3
  Scenario Outline: Onboard using Support App without input compulsory field
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And not select the country
    And not select effective date
    And click populate
    Then error validation display

    Examples:
      | userID    | password |
      | RAwaludin | password |

  @EAL @EAL_O_4
  Scenario Outline: User Bundle Termination using Support App with select future effective month
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to User Bundle Termination submenu
    And user select an excel file to upload file onboard in the support app
    And select the country
    And select future effective date "<effectiveDate>" in this case just select the month option
    And input OCR number "<ocr>"
    And click populate
    Then the onboard data display in support app with correct information
    And click submit to onboard
    Then success terminate user bundle

    Examples:
      | userID    | password | effectiveDate | ocr |
      | RAwaludin | password | 2025-08       |1126 |

  @EAL @EAL_O_5
  Scenario Outline: User Bundle Termination using Support App without input select future effective month
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to User Bundle Termination submenu
    And select the country
    And select past future effective date "<effectiveDate>"
    Then error validation cannot pick the date will display

    Examples:
      | userID    | password | effectiveDate |
      | RAwaludin | password | 2025-04       |

  @EAL @EAL_O_6
  Scenario Outline: User Bundle Termination using Support App without input compulsory field
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to User Bundle Termination submenu
    And not select the country
    And not select effective date
    Then error validation display

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL @EAL_O_7
  Scenario Outline: Cubeforall User Bundle Amendment with select future effective month
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to User Bundle Amendment submenu
    And not input pima
    And select the country
    And select future effective date "<effectiveDate>" in this case just select the month option
    And input OCR number "<ocr>"
    And click populate
    Then the onboard data display in support app with correct information
    When user want to edit total number of account
    Then user able to edit, add, and remove the account quantity
    When user want to edit total number of account chargeable
    Then user able to edit, add, and remove the account quantity
    When user want to edit number of free account
    Then user able to edit, add, and remove the account quantity
    When user want to edit discount amount
    Then user able to edit, add, and remove the account quantity
    When user want to edit total charge account
    Then user able to edit, add, and remove the account quantity
    When user want to edit PCN Charge
    Then user able to edit, add, and remove the account quantity
    When user want to edit Plan Manager
    Then user unable to edit Plan Manager
    When user want to edit members
    Then user able to add, and remove members
    And click submit
    Then success terminate user bundle

    Examples:
      | userID   | password | ocr  | effectiveDate |
      | RAwaludin | password | 7263 | 2025-08       |


  @EAL @EAL_O_8
  Scenario Outline: Cubeforall User Bundle Amendment without input compulsory field
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to User Bundle Amendment
    And not input pima
    And not select the country
    And select future effective date "<effectiveDate>" in this case just select the month option
    Then error validation display

    Examples:
      | userID    | password | effectiveDate |
      | RAwaludin | password | 2025-08       |

  @EAL @EAL_O_9
  Scenario Outline: Report Onboard Input Start Date and End Date
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to Subscription > Report Onboard
    And input start date and end date
    And click search
    Then get the correct report onboard information

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL @EAL_O_10
  Scenario Outline: Report Onboard input end date earlier than end date
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to Subscription > Report Onboard
    And input end date earlier than end date
    And click search
    Then get validation error invalid date range

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL @EAL_O_11
  Scenario Outline: Report Onboard Only input either start date or end date
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to Subscription > Report Onboard
    And Only input either start date or end date
    And click search
    Then get validation error please select both start and end dates

    Examples:
      | userID   | password | condition    |
      | RAwaludin | password | Company Name |

  @EAL @EAL_O_12
  Scenario Outline: Report Onboard Input Start Date and End Date & Input specific user
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to Subscription > Report Onboard
    And Input Start Date and End Date & Input specific user
    And click search
    Then get the correct report onboard information for specific user

    Examples:
      | userID   | password | condition    |
      | RAwaludin | password | Company Name |

  @EAPDCBI
  Scenario Outline: Display the user count info for company level subscription on support app
    Given user have company level subscribtion
    When user want to see the CUBEforall Bundle information in the support app
    Then display: Plan Name, Product name(s), user counts, chargeable counts, Plan Mangers, Plan members
    And Display the user count info for company level subscription

    Examples:
      | userID   | password | condition    |
      | RAwaludin | password | Company Name |

  @EAPDCBI
  Scenario Outline: not Display the user count info in Support App for non company level subscription
    Given user doesn't have company level subscription
    When user want to see the CUBEforall Bundle information in the support app
    Then not display

    Examples:
      | userID   | password | condition    |
      | RAwaludin | password | Company Name |
