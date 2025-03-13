Feature: Company Info in Support App

  @SA @SA-1
  Scenario Outline: Input company system address to display more info
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    And user go to company info sub menu
    And Input "<condition>" the display more info

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @SA @SA-2
  Scenario Outline: Input company cube id to display more info
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    And user go to company info sub menu
    And Input "<condition>" the display more info

    Examples:
      | userID   | password | condition       |
      | RAwaludin | password | Company Cube ID |

  @SA @SA-3
  Scenario Outline: Input company pima address to display more info
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    And user go to company info sub menu
    And Input "<condition>" the display more info

    Examples:
      | userID   | password | condition            |
      | RAwaludin | password | Company Pima Address |

  @SA @SA-4
  Scenario Outline: Input member email to display more info
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    And user go to company info sub menu
    And Input "<condition>" the display more info

    Examples:
      | userID   | password | condition    |
      | RAwaludin | password | Member Email |

  @notificationMonitoring
  Scenario Outline: display notification monitoring
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to notification menu
    Then verify notification monitoring information

    Examples:
      | userID   | password |
      | RAwaludin | password |

  @updatePlanManagerSupportApp
  Scenario Outline: update plan manager
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to update plan manager menu
    And input "<planManagerMail>" to display update plan manager function
    Then update new plan manager in support app

    Examples:
      | userID   | password | planManagerMail |
      | RAwaludin | password | HQ              |

  @actionLog
  Scenario Outline: action log
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to action log
    And user click action log dropDown
    And select user to export action log
    And input start date "<startDate>" and end date "<endDate>" to export action log

    Examples:
      | userID    | password     | startDate  | endDate    |
      | RAwaludin | spdoRed230C$ | 11/01/2024 | 11/20/2024 |