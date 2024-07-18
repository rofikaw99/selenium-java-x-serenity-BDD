@check-status
Feature: Check Status

  Scenario: Success check status with type of service id is Service
    Given user get SSO token for check status
    And user get service id "Service" with reference ID
    Then success get detail of service id

  Scenario: Success check status with type of service id is App
    Given user get SSO token for check status
    And user get service id "App" with reference ID
    Then success get detail of service id