Feature: To enhance Action log, company search, Onboarding file upload features in CUBEforall Portal Admin

  @EAL_1
  Scenario Outline: Access Control Tittle Changes
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user click Access Control
    Then verify that the tittle change from “Access Control” to “Portal Access Management.”  on Access Control Sub Menu
    And verify that the tittle change from “Group Access” to “Access Group.”  on Access Control Sub Menu
    And verify that the tittle change from “User” to “User Management.”  on Access Control Sub Menu
    And Add a new feature titled “Admin Change Log.”

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_2
  Scenario Outline: Search Perimeter for admin change log
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user click Access Control
    And user go to a new feature titled “Admin Change Log.”
    When user verify completeness of the perimeter search
    And verify the data range filter is mandatory.
    And verify the functions available are “ User Management” & “ Access Group”

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_3
  Scenario Outline: Search Perimeter for admin change log If no value is selected for “User” or “Function
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user click Access Control
    And user go to a new feature titled “Admin Change Log.”
    When no value is selected for “User” or “Function
    And the search will include all users and all functions.

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_3
  Scenario Outline: Search Perimeter for admin change log If no value is selected for “User” or “Function
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user click Access Control
    And user go to a new feature titled “Admin Change Log.”
    When no value is selected for “User” or “Function
    And the search will include all users and all functions.

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_4
  Scenario Outline: Search Perimeter for admin change log If only select a specific “User” and no value is selected for “Function.
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user click Access Control
    And user go to a new feature titled “Admin Change Log.”
    When only select a specific “User” and no value is selected for “Function
    And the search will include only specific users and all functions.

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_5
  Scenario Outline: Search Perimeter for admin change log If only select a specific “Function (User Management)” and no value is selected for “User,
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user click Access Control
    And user go to a new feature titled “Admin Change Log.”
    When only select a specific “Function (User Management)” and no value is selected for “User,
    And the search will include only specific function (User Management) and all users.
    And the actions tracked should include any changes made by the admin

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_6
  Scenario Outline: Search Perimeter for admin change log If only select a specific “Function (Access Group)” and no value is selected for “User
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user click Access Control
    And user go to a new feature titled “Admin Change Log.”
    When only select a specific “Function (Access Group)” and no value is selected for “User,
    And the search will include only specific function (Access Group) and all users.
    And the actions tracked should include creating a new access group, detailing the functions included in that group or recording changes made to existing access group.

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_7
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


  @EAL_8
  Scenario Outline: Search Perimeter for admin change log If only select a specific “Function (Access Group)” and  “User
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user click Access Control
    And user go to a new feature titled “Admin Change Log.”
    When only select a specific “Function (Access Group)” and  “User
    And the search will include only specific function (Access Group) and specific user.
    And the actions tracked should include creating a new access group, detailing the functions included in that group or recording changes made to existing access group.

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_9
  Scenario Outline: Search Perimeter for admin change log If only select a specific “Function (Access Group)” and  “User
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user click Access Control
    Then verify display information for Support App admin actions

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_10
  Scenario Outline: verify action log report filter functionality & portal admin function availability
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user click Action Log Report
    Then The data range filter is compulsory
    When no value is selected for “User” or “Function,”
    Then the search will include all users and all functions.
    When check function field
    Then all portal admin functions are available except for “Portal Access Management.”

    Examples:
      | userID   | password | condition              |
      | RAwaludin | password | Company System Address |

  @EAL_11
  Scenario Outline: Input Company Name to display more info
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    And user go to company info sub menu
    And Input "<condition>" the display more info

    Examples:
      | userID   | password | condition    |
      | RAwaludin | password | Company Name |

  @EAL_12
  Scenario Outline: Input Company Name to display more info
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    And user go to company info sub menu
    And Input "<condition>" the display more info

    Examples:
      | userID   | password | condition    |
      | RAwaludin | password | Company Name |

  @EAL_13
  Scenario Outline: Input Company Domain to display more info
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    And user go to company info sub menu
    And Input "<condition>" the display more info

    Examples:
      | userID   | password | condition      |
      | RAwaludin | password | Company Domain |

  @EAL_14
  Scenario Outline: Input Company UEN to display more info
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    And user go to company info sub menu
    And Input "<condition>" the display more info

    Examples:
      | userID   | password | condition      |
      | RAwaludin | password | Company UEN |
