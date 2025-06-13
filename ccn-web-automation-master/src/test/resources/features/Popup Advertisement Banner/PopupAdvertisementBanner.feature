@CRP0068
Feature: Implementing Pop-Up Advertisement Banner with Configuration Page and Country Targeting

  @CRP0068_1 @CRP0068_P2
  Scenario Outline: Upload and configure schedule period for advertisement content every login
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    And user go to manage banner support app
    And upload an advertisement image
    And input the advertisement URL "<adsUrl>" to learn more
    And set a "<startDate>" and "<endDate>" for the advertisement
    And input targeted advertisement "<country>"
    And select frequency on "<frequencyValue>" value
    And click the manage banner save button
    Then the image should be displayed in a preview section

    Examples:
      | userID    | password     | startDate  | endDate    | adsUrl                   | country | frequencyValue |
      | RAwaludin | spdoRed230C$ | 2025-06-12 | 2025-06-28 | https://www.siacargo.com | jordan  | every_login    |

  @CRP0068_2 @CRP0068_P2
  Scenario Outline: Upload and configure schedule period for advertisement content weekly
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    And user go to manage banner support app
    And upload an advertisement image
    And input the advertisement URL "<adsUrl>" to learn more
    And set a "<startDate>" and "<endDate>" for the advertisement
    And input targeted advertisement "<country>"
    And select frequency on "<frequencyValue>" value
    And click the manage banner save button
    Then the image should be displayed in a preview section

    Examples:
      | userID    | password     | startDate  | endDate    | adsUrl           | country | frequencyValue |
      | RAwaludin | spdoRed230C$ | 2025-06-12 | 2025-06-28 | https://www.siacargo.com | jordan  | weekly         |

  @CRP0068_3 @CRP0068_P2
  Scenario Outline: Upload and configure schedule period for advertisement content monthly
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    And user go to manage banner support app
    And upload an advertisement image
    And input the advertisement URL "<adsUrl>" to learn more
    And set a "<startDate>" and "<endDate>" for the advertisement
    And input targeted advertisement "<country>"
    And select frequency on "<frequencyValue>" value
    And click the manage banner save button
    Then the image should be displayed in a preview section

    Examples:
      | userID    | password     | startDate  | endDate    | adsUrl           | country | frequencyValue |
      | RAwaludin | spdoRed230C$ | 2025-06-12 | 2025-06-28 | https://www.siacargo.com | jordan  | monthly         |

  @CRP0068_4 @CRP0068_P2
  Scenario Outline: Upload and configure schedule period for advertisement content multiple country
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    And user go to manage banner support app
    And upload an advertisement image
    And input the advertisement URL "<adsUrl>" to learn more
    And set a "<startDate>" and "<endDate>" for the advertisement
    And input targeted advertisement with multiple country "<country>" "<country2>"
    And select frequency on "<frequencyValue>" value
    And click the manage banner save button
    Then the image should be displayed in a preview section

    Examples:
      | userID    | password     | startDate  | endDate    | adsUrl                   | country | frequencyValue  | country2 |
      | RAwaludin | spdoRed230C$ | 2025-06-12 | 2025-06-28 | https://www.siacargo.com | jordan  | monthly         | belize   |

  @CRP0068_5 @CRP0068_P2
  Scenario Outline: Upload and configure combination between country, schedule period and specific frequency for advertisement content
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    And user go to manage banner support app
    And upload an advertisement image
    And input the advertisement URL "<adsUrl>" to learn more
    And set a "<startDate>" and "<endDate>" for the advertisement
    And input targeted advertisement "<country>"
    And select frequency on "<frequencyValue>" value
    And click the manage banner save button
    Then the image should be displayed in a preview section

    Examples:
      | userID    | password     | startDate  | endDate    | adsUrl                   | country | frequencyValue |
      | RAwaludin | spdoRed230C$ | 2025-06-12 | 2025-06-28 | https://www.siacargo.com | jordan  | monthly         |

  @CRP0068_6 @CRP0068_P2
  Scenario Outline: Upload and configure combination between country, schedule period and specific frequency for advertisement content
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    And user go to manage banner support app
    And upload an advertisement image
    And input the advertisement URL "<adsUrl>" to learn more
    And set a "<startDate>" and "<endDate>" for the advertisement
    And input targeted advertisement "<country>"
    And select frequency on "<frequencyValue>" value
    And click the manage banner save button
    Then the image should be displayed in a preview section

    Examples:
      | userID    | password     | startDate  | endDate    | adsUrl                   | country | frequencyValue |
      | RAwaludin | spdoRed230C$ | 2025-06-12 | 2025-06-28 | https://www.siacargo.com | jordan  | monthly         |

  @CRP0068_7 @CRP0068_P2
  Scenario Outline: Upload and configure with overlapping between schedule period, target specific countries, and frequency for advertisement content will return
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    And user go to manage banner support app
    And upload an advertisement image
    And input the advertisement URL "<adsUrl>" to learn more
    And set a "<startDate>" and "<endDate>" for the advertisement
    And input targeted advertisement "<country>"
    And select frequency on "<frequencyValue>" value
    And click the manage banner save button then return error because any overlapping data


    Examples:
      | userID    | password     | startDate  | endDate    | adsUrl                   | country    | frequencyValue  |
      | RAwaludin | spdoRed230C$ | 2025-06-12 | 2025-06-28 | https://www.siacargo.com | singapore  | monthly         |

  @CRP0068_10 @CRP0068_P1
  Scenario Outline: Advertisement pop-up should not show outside scheduled period
    Given login with account with condition the current date is outside the advertisement schedule
    When "<condition>" login to the web
    Then the pop-up should not appear

    Examples:
      | condition          |
      | Non Visible Banner |

  @CRP0068_11 @CRP0068_P1
  Scenario Outline: Popup should not show for unlisted countries
    Given login with account with condition the user's company country is not in the targeted list
    When "<condition>" login to the web
    Then the pop-up should not appear

    Examples:
      | condition          |
      | Non Visible Banner |

  @CRP0068_12 @CRP0068_P1
  Scenario Outline: Popup should not show if frequency condition (once a week / once a month) is not met or already show before
    Given the user saw the popup less than a week ago or a month ago depend on frequency condition
    And the frequency is set to once a week or once a month depend on frequency condition
    When "<condition>" login to the web
    Then the pop-up should not appear

    Examples:
      | condition          |
      | Non Visible Banner |

  @CRP0068_13 @CRP0068_P1
  Scenario Outline: Popup should not show if frequency condition (once a week / once a month), or schedule, or specific country is not met
    Given login with account if frequency condition once a week or once a month or schedule or specific country is not met
    When "<condition>" login to the web
    Then the pop-up should not appear

    Examples:
      | condition          |
      | Non Visible Banner |

  @CRP0068_14 @CRP0068_P1
  Scenario Outline: Display banner upon user login should be responsive on all devices (the current date is within the configured advertisement period, the user's company country is targeted, the frequency condition allows display)
    Given "<condition>" login to the web
    Then the advertisement popup banner should appear and should be responsive

    Examples:
      | condition           |
      | Able to View Banner |

  @CRP0068_15 @CRP0068_P1
  Scenario Outline: Close banner by clicking close button
    Given "<condition>" login to the web
    When the advertisement popup banner is visible
    And the user clicks the close button
    Then the banner should disappear

    Examples:
      | condition           |
      | Able to View Banner |

  @CRP0068_16 @CRP0068_P1
  Scenario Outline: Close banner by clicking outside the popup
    Given "<condition>" login to the web
    When the advertisement popup banner is visible
    When the user clicks outside of the popup area
    Then the banner should disappear

    Examples:
      | condition           |
      | Able to View Banner |

  @CRP0068_17 @CRP0068_P1
  Scenario Outline: User opts out of future popups
    Given "<condition>" login to the web
    When the advertisement popup banner is visible
    And the user checks the Do not show this again checkbox
    And the user closes the banner
    Then the pop-up should not appear in future logins

    Examples:
      | condition           |
      | Able to View Banner |

  @CRP0068_19 @CRP0068_P1
  Scenario Outline: User click Hyperlink for more detail
    Given "<condition>" login to the web
    When the advertisement popup banner is visible
    And the user checks the Click here to find out more checkbox
    Then the user will be direct to new link to see more detail

    Examples:
      | condition           |
      | Able to View Banner |

  @CRP0068_20 @CRP0068_P2
  Scenario Outline: view image in job list advertisement configuration log
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    And user go to manage banner support app
    Then view image in job list advertisement configuration log

    Examples:
      | userID    | password     | startDate  | endDate    | adsUrl                   | country | frequencyValue |
      | RAwaludin | spdoRed230C$ | 2025-06-12 | 2025-06-28 | https://www.siacargo.com | jordan  | every_login    |

  @CRP0068_21 @CRP0068_P2
  Scenario Outline: edit job list advertisement configuration log
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    And user go to manage banner support app
    Then edit job list advertisement configuration log
    And upload an advertisement image
    And click the manage banner save button
    Then the image should be displayed in a preview section

    Examples:
      | userID    | password     | startDate  | endDate    | adsUrl                   | country | frequencyValue |
      | RAwaludin | spdoRed230C$ | 2025-06-12 | 2025-06-28 | https://www.siacargo.com | jordan  | every_login    |

  @CRP0068_22 @CRP0068_P2
  Scenario Outline: remove job list advertisement configuration log
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    And user go to manage banner support app
    Then delete job list advertisement configuration log

    Examples:
      | userID    | password     |
      | RAwaludin | spdoRed230C$ |

