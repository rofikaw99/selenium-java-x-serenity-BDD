@ver-req
Feature: Verification Request

  Background: Login and transform
    Given user login SSO for one record

  @ver-req
  Scenario: Success Create Verification Request for Master Waybill
    And user transform xfwb using "internal" url
    When user success create LO with new waybill number and "DIRECT" waybillType
    And user create verification request for that LO
    Then success create verification request
    And user able to get action request details
    And verification request will have "ACKNOWLEDGE" status

  @ver-req2
  Scenario: Success Update LO with verification request ID
    When user success create LO
    And user create verification request for that LO
    When user update gross weight for rate with verification request id
    Then success update "grossWeightForRate"
    And the gross weight for rate value changes in the latest get lo
    And verification request data will appears when user get change request

