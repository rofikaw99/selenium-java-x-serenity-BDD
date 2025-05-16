Feature: CRP0071 - Enhance CUBEforall Bundle Billing file

  @CRP0071
  Scenario Outline: verify the output new onboard file when using country (SG)
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And select future effective date "<effectiveDate>" in this case just select the month option
    And input OCR number "<ocr>"
    And click populate
    Then the onboard data display in support app with correct information
    And click submit to onboard
    Then success submit onboard data
    And verify output onboard file
    And verify the transaction record on the log

    Examples:
      | userID    | password | effectiveDate | ocr  | country   |
      | RAwaludin | password | 2025-07       | 1126 | Singapore |

  @CRP0071
  Scenario Outline: verify the output new onboard file when using country (PH)
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And select future effective date "<effectiveDate>" in this case just select the month option
    And input OCR number "<ocr>"
    And click populate
    Then the onboard data display in support app with correct information
    And click submit to onboard
    Then success submit onboard data
    And verify output onboard file
    And verify the transaction record on the log

    Examples:
      | userID    | password | effectiveDate | ocr  | country |
      | RAwaludin | password | 2025-07       | 1126 | PH      |

  @CRP0071
  Scenario Outline: verify the output new onboard file when using country (VN)
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And select future effective date "<effectiveDate>" in this case just select the month option
    And input OCR number "<ocr>"
    And click populate
    Then the onboard data display in support app with correct information
    And click submit to onboard
    Then success submit onboard data
    And verify output onboard file
    And verify the transaction record on the log

    Examples:
      | userID    | password | effectiveDate | ocr  | country |
      | RAwaludin | password | 2025-07       | 1126 | VN      |

  @CRP0071
  Scenario Outline: verify the output new onboard file when using country (ID)
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And select future effective date "<effectiveDate>" in this case just select the month option
    And input OCR number "<ocr>"
    And click populate
    Then the onboard data display in support app with correct information
    And click submit to onboard
    Then success submit onboard data
    And verify output onboard file
    And verify the transaction record on the log

    Examples:
      | userID    | password | effectiveDate | ocr  | country |
      | RAwaludin | password | 2025-07       | 1126 | ID      |

  @CRP0071
  Scenario Outline: verify the output new onboard file when using country (UAE) non Onboard Country
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And select future effective date "<effectiveDate>" in this case just select the month option
    And input OCR number "<ocr>"
    And click populate
    Then the onboard data display in support app with correct information
    And click submit to onboard
    Then success submit onboard data
    And verify output onboard file
    And verify the transaction record on the log

    Examples:
      | userID    | password | effectiveDate | ocr  | country |
      | RAwaludin | password | 2025-07       | 1126 | UAE     |

  @CRP0071
  Scenario Outline: Cubeforall User Bundle Amendment with select future effective month
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    And user go to User Bundle Amendment submenu
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
    Then success amendment user bundle
    And verify output onboard file
    And verify the transaction record on the log

    Examples:
      | userID    | password | ocr  | effectiveDate |
      | RAwaludin | password | 7263 | 2025-08       |

  @CRP0071
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
    Then success upload terminate user bundle
    And verify output onboard file
    And verify the transaction record on the log

    Examples:
      | userID    | password | effectiveDate | ocr  |
      | RAwaludin | password | 2025-08       | 1126 |
