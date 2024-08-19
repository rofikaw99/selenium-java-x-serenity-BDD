@SSG
Feature: Security Service Gateway

  @SSG_NA_1
  Scenario: Check status with public service gateway with no token and API key
    Given  Check status with "public" service gateway with no token and API key
    Then verify the response is unauthorized

  @SSG_NA_2
  Scenario: Check status with private service gateway with no token and API key
    Given  Check status with "private" service gateway with no token and API key
    Then verify the response is unauthorized

  @SSG_NA_3
  Scenario: Check status with private service gateway with API key but no token
    Given  Check status with "private" service gateway with API key but no token
    Then verify the response is unauthorized