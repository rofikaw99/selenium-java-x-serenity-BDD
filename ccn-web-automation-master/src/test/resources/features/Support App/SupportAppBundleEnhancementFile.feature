Feature: CRP0071 - Enhance CUBEforall Bundle Billing file

  @CRP0071 @CRP0071_1
  Scenario Outline: verify the output new onboard file when using country (SG)
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And input OCR number "<ocr>"
    And select future effective date "<effectiveDate>" in this case just select the month option
    Then the onboard data display in support app with correct information
    And click submit to onboard
    Then success submit onboard data
    And verify the onboard transaction record on the log on certain "<startDate>" "<endDate>"
    And verify output onboard file


    Examples:
      | userID    | password     | effectiveDate | ocr  | country   | startDate  | endDate    |
      | RAwaludin | spdoRed230C$ | 2025-07       | 1    | Singapore | 06/01/2025 | 06/28/2025 |

  @CRP0071
  Scenario Outline: verify the output new onboard file when using country (PH)
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And input OCR number "<ocr>"
    And select future effective date "<effectiveDate>" in this case just select the month option
    Then the onboard data display in support app with correct information
    And click submit to onboard
    Then success submit onboard data
    And verify the onboard transaction record on the log on certain "<startDate>" "<endDate>"
    And verify output onboard file

    Examples:
      | userID    | password | effectiveDate  | ocr  | country | startDate  | endDate    |
      | RAwaludin | spdoRed230C$ | 2025-07        | 1126 | PH      | 06/01/2025 | 06/28/2025 |

  @CRP0071
  Scenario Outline: verify the output new onboard file when using country (VN)
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And input OCR number "<ocr>"
    And select future effective date "<effectiveDate>" in this case just select the month option
    Then the onboard data display in support app with correct information
    And click submit to onboard
    Then success submit onboard data
    And verify the onboard transaction record on the log on certain "<startDate>" "<endDate>"
    And verify output onboard file

    Examples:
      | userID    | password | effectiveDate | ocr  | country | startDate  | endDate    |
      | RAwaludin | spdoRed230C$ | 2025-07       | 1126 | VN      | 06/01/2025 | 06/28/2025 |

  @CRP0071
  Scenario Outline: verify the output new onboard file when using country (ID)
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And input OCR number "<ocr>"
    And select future effective date "<effectiveDate>" in this case just select the month option
    Then the onboard data display in support app with correct information
    And click submit to onboard
    Then success submit onboard data
    And verify the onboard transaction record on the log on certain "<startDate>" "<endDate>"
    And verify output onboard file

    Examples:
      | userID    | password | effectiveDate | ocr  | country | startDate  | endDate    |
      | RAwaludin | spdoRed230C$ | 2025-07       | 1126 | ID      | 06/01/2025 | 06/28/2025 |

  @CRP0071
  Scenario Outline: verify the output new onboard file when using country (UAE/non Onboard Registered country) non Onboard Country
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And input OCR number "<ocr>"
    And select future effective date "<effectiveDate>" in this case just select the month option
    Then the onboard data display in support app with correct information
    And click submit to onboard
    Then success submit onboard data
    And verify the onboard transaction record on the log on certain "<startDate>" "<endDate>"
    And verify output onboard file

    Examples:
      | userID    | password | effectiveDate | ocr  | country | startDate  | endDate    |
      | RAwaludin | spdoRed230C$ | 2025-07       | 1126 | UAE     | 06/01/2025 | 06/28/2025 |

  @CRP0071 @CRP0071_2
  Scenario Outline: verify when onboard new file not using future effective date
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app
    And input OCR number "<ocr>"
    And select future effective date "<effectiveDate>" in this case just select the month option
    Then validation please select future date when onboard appear


    Examples:
      | userID    | password     | effectiveDate | ocr  | country | startDate  | endDate    |
      | RAwaludin | spdoRed230C$ | 2025-05       | 1126 | UAE     | 06/01/2025 | 06/28/2025 |

  @CRP0071
  Scenario Outline: Cubeforall User Bundle Amendment with select future effective month
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    And user go to User Bundle Amendment submenu
    And input pima "<pima>"
    And input OCR number "<ocr>"
    And select future effective date "<effectiveDate>" in this case just select the month option
    And wait for response
    Then the onboard data display in support app with correct information
    And press edit amendment
    When user want to edit total number of account to "<totalNumberAccount>"
    And save the amendment change
    And click submit to amendment
    Then success amendment user bundle
    And verify output onboard file
    And verify the amendment record on the log on the certain "<startDate>" "<endDate>"
    And verify output amendment file

    Examples:
      | userID    | password     | ocr  | effectiveDate | pima              | totalNumberAccount | startDate  | endDate    |
      | RAwaludin | spdoRed230C$ | 7263 | 2025-08       | csgagt99rhn_ind99 | 7                  | 06/01/2025 | 06/28/2025 |

    #    Then user able to edit, add, and remove the account quantity
#    When user want to edit total number of account chargeable
#    Then user able to edit, add, and remove the account quantity
#    When user want to edit number of free account
#    Then user able to edit, add, and remove the account quantity
#    When user want to edit discount amount
#    Then user able to edit, add, and remove the account quantity
#    When user want to edit total charge account
#    Then user able to edit, add, and remove the account quantity
#    When user want to edit PCN Charge
#    Then user able to edit, add, and remove the account quantity
#    When user want to edit Plan Manager
#    Then user unable to edit Plan Manager
#    When user want to edit members
#    Then user able to add, and remove members

  @CRP0071 @CRP0071T
  Scenario Outline: User Bundle Termination using Support App with select future effective month
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription support app
    When user go to User Bundle Termination submenu
    And input pima "<pima>"
    And input OCR number "<ocr>"
    And select future effective date "<effectiveDate>" in this case just select the month option
    And wait for response
    Then the onboard data display in support app with correct information
    And click submit to termination
    Then success upload terminate user bundle
    And verify the termination record on the log on the certain "<startDate>" "<endDate>"
    And verify output termination file

    Examples:
      | userID    | password     | effectiveDate | ocr  | startDate  | endDate    | pima              |
      | RAwaludin | spdoRed230C$ | 2025-08       | 1126 | 06/01/2025 | 06/28/2025 | csgagt99rhn_ind99 |
