Feature: [CUBEforall - Company] Support to get Airline as company Identity
  - Airline Company identity should cover 5 attributes: Airline Name / Carrier Code / AWB prefix / Airline address / system cube email address
  - Support to get airline company identity information based on Carrier Code & AWB Prefix

  @EACI_1 @EACI
  Scenario Outline: Input valid AWB Prefix
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    When user go to airlines submenu
    And user input "<AWB Prefix>" and click search
    Then verify that Airlines Company Identity already cover Airlines Name, Carrier Code, Awb Prefix, Airlines Address, and System Cube Mail Address

    Examples:
      | userID    | password     | AWB Prefix |
      | RAwaludin | spdoRed230C$ | 014        |

  @EACI_2 @EACI
  Scenario Outline: Input valid Carrier Code
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    When user go to airlines submenu
    And user select airline company identity by carrier code
    And user input "<Airline Search By>" and click search
    Then verify that Airlines Company Identity already cover Airlines Name, Carrier Code, Awb Prefix, Airlines Address, and System Cube Mail Address

    Examples:
      | userID    | password     | Airline Search By |
      | RAwaludin | spdoRed230C$ | AC                |

  @EACI_3 @EACI
  Scenario Outline: input Carrier Code != exactly 2 alphanumeric characters
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    When user go to airlines submenu
    And user select airline company identity by carrier code
    And user input "<Airline Search By>" and click search
    Then verify airline search validation text display

    Examples:
      | userID    | password     | Airline Search By |
      | RAwaludin | spdoRed230C$ | AC547             |

  @EACI_4 @EACI
  Scenario Outline: AWB Prefix != exactly 3 numeric characters.
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    When user go to airlines submenu
    And user input "<Airline Search By>" and click search
    Then verify airline search validation text display

    Examples:
      | userID    | password     | Airline Search By |
      | RAwaludin | spdoRed230C$ | AC                |

  @EACI_5 @EACI
  Scenario Outline: All change log successfully recorded
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    When user go to airlines submenu
    And user input "<AWB Prefix>" and click search
    Then verify that Airlines Company Identity already cover Airlines Name, Carrier Code, Awb Prefix, Airlines Address, and System Cube Mail Address
    When user want to view change log by input filter date "<startDate>" and "<endDate>"

    Examples:
      | userID    | password     | AWB Prefix | startDate | endDate  |
      | RAwaludin | spdoRed230C$ | 014        | 2024-11-01|2024-11-28|
