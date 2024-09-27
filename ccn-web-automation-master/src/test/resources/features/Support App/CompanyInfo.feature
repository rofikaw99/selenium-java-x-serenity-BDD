Feature: Company Info in Support App

  @SA-1
  Scenario Outline: Input company system address to display more info
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    And user go to company info sub menu
    And Input "<condition>" the display more info

    Examples:
      | userID   | password | condition              |
      | helpdesk | password | Company System Address |

  @SA-2
  Scenario Outline: Input company cube id to display more info
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    And user go to company info sub menu
    And Input "<condition>" the display more info

    Examples:
      | userID   | password | condition       |
      | helpdesk | password | Company Cube ID |

  @SA-3
  Scenario Outline: Input company pima address to display more info
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    And user go to company info sub menu
    And Input "<condition>" the display more info

    Examples:
      | userID   | password | condition            |
      | helpdesk | password | Company Pima Address |

  @SA-4
  Scenario Outline: Input member email to display more info
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    And user go to company info sub menu
    And Input "<condition>" the display more info

    Examples:
      | userID   | password | condition    |
      | helpdesk | password | Member Email |

  @notificationMonitoring
  Scenario Outline: display notification monitoring
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to notification menu
#    And Input "<condition>" the display more info

    Examples:
      | userID   | password | condition    |
      | helpdesk | password | Member Email |