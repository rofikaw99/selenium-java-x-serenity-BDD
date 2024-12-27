Feature: FHL and FWB

  @fhl-fwb
  Scenario: Creating House After Master is created
    Given user transform xfwb
    When Create logistic objects using predefined json and "internal" url
    Then Success create using "internal" url
    Given user transform xfzb
    When Create logistic objects of fhl using predefined json and "internal" url
    Then Success create using "internal" url

  Scenario: Creating Master After House is created

  Scenario: Creating House Again after Master and House is created

  Scenario: Pieces will distributed if master have 5 pieces and 2 houses that have each 2 and 3 pieces

  Scenario: Pieces will distributed to the first house if master have 5 pieces and have 2 houses with each 5 and 5 pieces