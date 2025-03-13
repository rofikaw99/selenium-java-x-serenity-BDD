Feature: To Onboarding file upload features in CUBEforall Portal Admin

  @EAL_O_1
  Scenario Outline: Onboard using Support App select future effective month
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And select the country
    And select future effective date
    And input OCR number
    And click populate
    Then the onboard data display in support app with correct information
    And click submit
    Then success submit onboard data

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_O_2
  Scenario Outline:  Onboard using Support App if not select future effective month
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And select the country
    And select != future effective date
    Then error validation cannot pick the date will display

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_0_3
  Scenario Outline: Onboard using Support App without input compulsory field
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And not select the country
    And not select effective date
    Then error validation display

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_O_4
  Scenario Outline: User Bundle Termination using Support App with select future effective month
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to Subscription > User Bundle Termination
    And upload onboard file
    And select the country
    And select future effective date
    And verify The billing effective date always falls on the first day of the month
    And input OCR number
    And click populate
    Then the onboard data display in support app with correct information
    And click submit
    Then success terminate user bundle

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_O_5
  Scenario Outline: User Bundle Termination using Support App without input select future effective month
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to Subscription > User Bundle Termination
    And upload onboard file
    And select the country
    And select not future effective date
    Then error validation cannot pick the date will display

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_O_6
  Scenario Outline: User Bundle Termination using Support App without input compulsory field
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to Subscription > User Bundle Termination
    And upload onboard file
    And not select the country
    And not select effective date
    Then error validation display

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_O_7
  Scenario Outline: Cubeforall User Bundle Amendment with select future effective month
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to Subscription > User Bundle Termination
    And not input pima
    And select the country
    Then verify The billing effective date always falls on the first day of the month
    And input OCR number
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
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_O_8
  Scenario Outline: Search Perimeter for admin change log If only select a specific “Function (User Management)” and  “User
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user click Access Control
    And user go to a new feature titled “Admin Change Log.”
    When only select a specific “Function (User Management)” and  “User
    And the search will include only specific function (User Management) and specific user.
    And the actions tracked should include any changes made by the admin

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |


  @EAL_O_8
  Scenario Outline: Cubeforall User Bundle Amendment without input compulsory field
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to Subscription > User Bundle Termination
    And not input pima
    And not select the country
    Then verify The billing effective date always falls on the first day of the month
    Then error validation display

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_O_9
  Scenario Outline: Report Onboard Input Start Date and End Date
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to Subscription > Report Onboard
    And input start date and end date
    And click search
    Then get the correct report onboard information

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_O_10
  Scenario Outline: Report Onboard input end date earlier than end date
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to Subscription > Report Onboard
    And input end date earlier than end date
    And click search
    Then get validation error invalid date range

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_O_11
  Scenario Outline: Report Onboard Only input either start date or end date
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to Subscription > Report Onboard
    And Only input either start date or end date
    And click search
    Then get validation error please select both start and end dates

    Examples:
      | userID   | password | condition    |
      | RAwaludin | password | Company Name |

  @EAL_O_12
  Scenario Outline: Report Onboard Input Start Date and End Date & Input specific user
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to Subscription > Report Onboard
    And Input Start Date and End Date & Input specific user
    And click search
    Then get the correct report onboard information for specific user

    Examples:
      | userID   | password | condition    |
      | RAwaludin | password | Company Name |
