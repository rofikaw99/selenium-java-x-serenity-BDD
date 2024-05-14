Feature: Loyalty Program App - Enhancement

  Scenario: S1 Users can earn up to 1000 points daily within 24 hours
    Given Registered user with the loyalty program
    When User performs actions to earn points
    Then User points should not exceed earns 1000 within 24 hours

  Scenario: S2 Scheduler triggers point reset at GMT 0
    Given The loyalty program scheduler is configured
    And User on the day 1 has earns 1000 points
    When The clock reaches midnight GMT 0
    Then The earn points should be reset, and user can start earning up to 1000 points again on the day 2

  Scenario: S3 Users cannot earn points beyond 1000 within 24 hours
    Given Registered user with the loyalty program
    When User accumulates points for more than 24 hours
    Then Users points should not exceed 1000
