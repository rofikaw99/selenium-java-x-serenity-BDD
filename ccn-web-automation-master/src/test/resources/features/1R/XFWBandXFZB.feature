@xfwbxfzb
Feature: XFWB and XFZB

  Background: Login and transform
    Given user login SSO for one record

  @xfwbxfzb @done
  Scenario: Create XFWB without XFZB, the waybillType will be DIRECT
    And user transform xfwb using "internal" url
    When user success create LO with new waybill number and "DIRECT" waybillType
    Then Success create
    And user success get LO
    And the waybill type is "DIRECT"

  @xfwbxfzb-1 @done
  Scenario: Create XFWB with XFZB, the waybillType will be MASTER
    And user transform xfwb using "internal" url
    When user success create LO with new waybill number and "MASTER" waybillType
    And user transform xfzb using "internal" url
    And user success create LO with new house waybill number and same mater
    Then Success create
    And user success get LO for verifying
    And the waybill type is "HOUSE"
    When get logistic objects using "master" LO_ID
    Then the waybill type is "MASTER"
    And the master waybill is same as the master in house waybill

  @xfwbxfzb-2 @done
  Scenario: Verify the piece distribution in Master and House
    And user transform xfzb using "internal" url
    When user success create LO with new master and house waybill number
    Then Success create
    And piece of house will be distributed from master pieces

  @xfwbxfzb-3
  Scenario: Verify able to create same house waybillNumber in different master waybill
    And user transform xfzb using "internal" url
    When user success create LO with new master and house waybill number
    And user create LO again with same house waybill in different master waybill
    Then Success create
    And user able to get the "second" house waybill
    And user able to get the "first" house waybill
    And verify both of LO will have different ID

  @xfwbxfzb-4
  Scenario: Verify able to create many houses in same master waybill
    And user transform xfzb using "internal" url
    When user success create LO with new master and house waybill number
    And user create new house LO in same master waybill
    And user create new house LO in same master waybill
    Then Success create
    And house will be nested in master waybill
    And master will have 2 different house waybill number