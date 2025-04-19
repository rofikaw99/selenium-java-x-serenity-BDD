@PAB
Feature: Popup Advertisement Banner

  @PAB1
  Scenario: Upload and configure schedule period for advertisement content
    Given already on the advertisement configuration page
    When upload an advertisement image
    Then the image should be displayed in a preview section
    When set a start and end date for the advertisement
    And click the save button
    Then the configuration should be saved and applied to user logins
    And the advertisement should only be active between those dates

  @PAB2
  Scenario: Upload and configure target specific countries for advertisement content
    Given already on the advertisement configuration page
    When upload an advertisement image
    Then the image should be displayed in a preview section
    When select specific countries for the advertisement
    And click the save button
    Then the configuration should be saved and applied to user logins
    And only users whose company is registered in those countries should see the popup

  @PAB3
  Scenario: Upload and configure advertisement frequency (e.g., every login) for advertisement content
    Given already on the advertisement configuration page
    When upload an advertisement image
    Then the image should be displayed in a preview section
    When set the frequency to "every login"
    And click the save button
    Then the configuration should be saved and applied to user logins
    And users should only see the popup every login

  @PAB4
  Scenario: Upload and configure advertisement frequency (e.g., once a week) for advertisement content
    Given already on the advertisement configuration page
    When upload an advertisement image
    Then the image should be displayed in a preview section
    When set the frequency to "once a week"
    And click the save button
    Then the configuration should be saved and applied to user logins
    And users should only see the popup once a week

  @PAB5
  Scenario: Upload and configure advertisement frequency (e.g., once a month) for advertisement content
    Given already on the advertisement configuration page
    When upload an advertisement image
    Then the image should be displayed in a preview section
    When set the frequency to "once a month"
    And click the save button
    Then the configuration should be saved and applied to user logins
    And users should only see the popup once a month

  @PAB6
  Scenario: Upload and configure combination between schedule period and specific countries for advertisement content
    Given already on the advertisement configuration page
    When upload an advertisement image
    Then the image should be displayed in a preview section
    When set a start and end date for the advertisement
    And select specific countries for the advertisement
    And click the save button
    Then the configuration should be saved and applied to user logins
    And the advertisement should only be active between those dates and only applied for specific country

  @PAB7
  Scenario: Upload and configure combination between target specific countries and frequency for advertisement content
    Given already on the advertisement configuration page
    When upload an advertisement image
    Then the image should be displayed in a preview section
    When select specific countries for the advertisement
    And set the frequency to "every login" / "once a week" / "once a month"
    And click the save button
    Then the configuration should be saved and applied to user logins
    And only users whose company is registered in those countries and certain frequency condition should see the popup

  @PAB8
  Scenario: Upload and configure combination between schedule period and specific frequency for advertisement content
    Given already on the advertisement configuration page
    When upload an advertisement image
    Then the image should be displayed in a preview section
    When set a start and end date for the advertisement
    And set the frequency to "every login" / "once a week" / "once a month"
    And click the save button
    Then the configuration should be saved and applied to user logins
    And the advertisement should only be active between those dates and frequency

  @PAB9
  Scenario: Upload and configure combination between schedule period, target specific countries, and frequency for advertisement content
    Given already on the advertisement configuration page
    When upload an advertisement image
    Then the image should be displayed in a preview section
    When set a start and end date for the advertisement
    And select specific countries for the advertisement
    And set the frequency to "every login" / "once a week" / "once a month"
    And click the save button
    Then the configuration should be saved and applied to user logins
    And only users whose company is registered in those countries, certain frequency condition, and certain date should see the popup

  @PAB10
  Scenario: Advertisement pop-up should not show outside scheduled period
    Given login with account with condition the current date is outside the advertisement schedule
    Then the pop-up should not appear

  @PAB11
  Scenario: Popup should not show for unlisted countries
    Given login with account with condition the user's company country is not in the targeted list
    Then the popup should not appear

  @PAB12
  Scenario: Popup should not show if frequency condition (once a week / once a month) is not met
    Given the user saw the popup less than a week ago / a month ago depend on frequency condition
    And the frequency is set to "once a week" / "once a month"
    When the user logs in
    Then the popup should not appear

  @PAB13
  Scenario: Popup should not show if frequency condition (once a week / once a month), or schedule, or specific country is not met
    Given login with account if frequency condition (once a week / once a month), or schedule, or specific country is not met
    Then the popup should not appear

  @PAB14
  Scenario: Display banner upon user login should be responsive on all devices
    Given a user has logged into the system
    And the current date is within the configured advertisement period
    And the user's company country is targeted
    And the frequency condition allows display
    When the user logs in
    Then the advertisement popup banner should appear
    And the banner should be responsive on all devices (desktop, tablet, mobile)
    And the banner should display the configured advertisement image

  @PAB15
  Scenario: Close banner by clicking close button
    Given the advertisement popup banner is visible
    When the user clicks the close button
    Then the banner should disappear

  @PAB16
  Scenario: Close banner by clicking outside the popup
    Given the advertisement popup banner is visible
    When the user clicks outside of the popup area
    Then the banner should disappear

  @PAB17
  Scenario: User opts out of future popups
    Given the advertisement popup banner is visible
    When the user checks the "Do not show this again" checkbox
    And the user closes the banner
    Then the popup should not appear in future logins

