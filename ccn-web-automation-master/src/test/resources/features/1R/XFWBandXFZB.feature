Feature: XFWB and XFZB

  Background: Login and transform
    Given user login SSO for one record
    And user transform xfwb using "internal" url


  @xfwbxfzb
  Scenario: Create XFWB without XFZB, the waybillType will be DIRECT
    When user success create LO with new waybill number
    Then Success create
    And user success get LO
    And the waybill type is "DIRECT"

  @xfwbxfzb-1
  Scenario: Create XFWB with XFZB, the waybillType will be MASTER
    When user success create LO with new waybill number
    And user transform xfzb using "internal" url
    And user success create LO with new master and house waybill number
    Then Success create
    And user success get LO for verifying
    And the waybill type is "HOUSE"
    When get logistic objects using "master" LO_ID