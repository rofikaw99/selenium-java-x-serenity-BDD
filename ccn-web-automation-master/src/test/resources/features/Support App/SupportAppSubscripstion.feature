Feature: Subscription in Support App

  @Upload_Onboard_File
  Scenario Outline: Upload Onboard File
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to subscription menu
    When user go to upload file onboard submenu
    And user select an excel file to upload file onboard in the support app then populate and submit

    Examples:
      | userID    | password     |
      | RAwaludin | spdoRed230C$ |
