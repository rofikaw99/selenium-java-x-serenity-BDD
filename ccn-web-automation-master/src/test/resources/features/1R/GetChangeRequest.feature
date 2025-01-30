@lo @change-req
Feature: Get Change Request

  Background: Login and transform
    Given user login SSO for one record
    And user transform xfwb using "internal" url
    And user success create LO with new waybill number
    And user success get LO
    When user update dimensions

  @change-req
  Scenario: Get Change Request using LO_ID
    When user get change request using LO_ID
    Then success get change request
    And verify change request same as update dimensions

  @change-req-2
  Scenario: Get Change Request using Change Request ID
    When user get change request using change request ID
    Then success get change request
    And verify change request using change request ID same as update dimensions
