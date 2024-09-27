@lo @xfwb @create-lo
Feature: Create LO

  Background: Login
    Given user login SSO for one record

  @create-lo
  Scenario: Success create logistic objects using internal url
    Given user transform xfwb
    When Create logistic objects using predefined json and "internal" url
    Then Success create using "internal" url
    And Verify there is id of LO in body response
    And verify the type value is "cargo:Waybill"

  @create-lo-2
  Scenario: Success create logistic objects using external url
    Given user transform xfwb
    When Create logistic objects using predefined json and "external" url
    Then Success create using "external" url
    And Verify there is id of LO in body response
    And verify the type value is "cargo:Waybill"