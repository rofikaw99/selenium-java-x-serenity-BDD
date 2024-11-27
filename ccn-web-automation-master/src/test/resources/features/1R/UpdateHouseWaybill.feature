@lo @update-house-lo
Feature: Update House LO

  Background: Login and transform
    Given user login SSO for one record
    And user transform xfzb using "internal" url

  @house-1.1
  Scenario: 1.1 Piece count (line item)
    And user success create LO
    And user success get LO
    When user update piece of count
    Then success update "piece of count"
    And the piece of count value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request
    And verify change request same as update dimensions

  @house-2
  Scenario: 2. Gross weight
    And user success create LO
    And user success get LO
    When user update gross weight for rate in house LO
    Then success update "gross weight for rate"
    And the gross weight for rate value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request