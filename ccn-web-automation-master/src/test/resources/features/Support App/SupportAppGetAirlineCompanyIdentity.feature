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

  @EACI_6 @EACI
  Scenario Outline: update airline company identity
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    When user go to airlines submenu
    And user input "<AWB Prefix>" and click search
    Then verify that Airlines Company Identity already cover Airlines Name, Carrier Code, Awb Prefix, Airlines Address, and System Cube Mail Address
    When user go to edit airlines company identity function
    When try to edit "<address3>" in airline company identity

    Examples:
      | userID    | password     | AWB Prefix | address3     |
      | RAwaludin | spdoRed230C$ | 014        | PO Box 14000 |

  @EACI_7 @EACI
  Scenario Outline: verify airline company identity data information
    Given  retrieve airline company identity information with input "<awbPrefix>" and or "<carrierCode>" and verify the data is correct
    Examples:
      | awbPrefix | carrierCode |
      | 001       | AA          |

  @EACI_8 @EACINOT
  Scenario Outline: update airline company identity
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to group menu
    When user go to airlines submenu
    And user go to create new airlines function
#    When user input all data required to create company like "<airlinesName>" and "<email>" and "<compRegNo>" and "<pimaAddress>" and "<country>" and "<city>" and "<address>" and "<address2>" and "<address3>" and "<carrierCode>" and "<awbPrefix>"
#    And user press submit to create new airlines
#    Then verify that new Airlines Company created successfully

    Examples:
      | userID    | password     | awbPrefix  | airlinesName | email                                    | compRegNo| pimaAddress     | country | city | address | address2 | address3 | carrierCode |
      | RAwaludin | spdoRed230C$ | 014        | Air Canada   | system.csgair01hdqfmac@ccnexchange.com   | AC01     | csgair01hdqfmac | CA      | YVR  | Laurent | Quebec   | Montreal | AC          |

