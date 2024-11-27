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

  @house-2 @done
  Scenario: 2. Gross weight
    And user success create LO
    And user success get LO
    When user update gross weight for rate in house LO
    Then success update "gross weight for rate"
    And the gross weight for rate value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @house-6 @done
  Scenario: 6. Update SLAC count
    And user success create LO
    And user success get LO
    When user update SLAC count
    Then success update "SLAC count"
    And the SLAC count value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @house-6.1 @done
  Scenario: 6. Delete SLAC count
    And user success create LO
    And user success get LO
    When user delete SLAC count
    Then success update "SLAC count"
    And the SLAC count value deleted in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @house-6.2 @done
  Scenario: 6. Add SLAC count
    And user success create LO
    And user success get LO
    When user add SLAC count
    Then success update "SLAC count"
    And the SLAC count value added in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @house-7 @done
  Scenario: 7. Update Shipment description
    And user success create LO
    And user success get LO
    When user update Shipment description
    Then success update "Shipment description"
    And the Shipment description value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @house-9 @done
  Scenario: 9. Special handling code
    And user success create LO
    And user success get LO
    When user update special handling code
    Then success update "special handling code"
    And the special handling code value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @house-9.1 @done
  Scenario: 9.1 Delete Special handling code
    And user success create LO
    And user success get LO
    When user delete special handling code
    Then success update "special handling code"
    And the special handling code value deleted in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @house-9.2 @done
  Scenario: 9.2 Add Special handling code
    And user success create LO
    And user success get LO
    When user add special handling code
    Then success update "special handling code"
    And the special handling code value added in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @house-10 @done
  Scenario: 10. Update Shipper name, address
    And user success create LO
    And user success get LO
    When user update shipper name, address
    Then success update "shipper name, address"
    And the shipper name, address value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @house-10.1 @done
  Scenario: 10. Delete Shipper name, address
    And user success create LO
    And user success get LO
    When user delete shipper name, address
    Then success update "shipper name, address"
    And the shipper name, address value deleted in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @house-10.2 @done
  Scenario: 10. Add Shipper name, address
    And user success create LO
    And user success get LO
    When user add shipper name, address
    Then success update "shipper name, address"
    And the shipper name, address value added in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @house-11 @done
  Scenario: 11. Update Consignee name, address
    And user success create LO
    And user success get LO
    When user update consignee name, address
    Then success update "consignee name, address"
    And the consignee name, address value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @house-11.1 @done
  Scenario: 11. Delete Consignee name, address
    And user success create LO
    And user success get LO
    When user delete consignee name, address
    Then success update "consignee name, address"
    And the consignee name, address value deleted in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @house-11.2 @done
  Scenario: 11. Add Consignee name, address
    And user success create LO
    And user success get LO
    When user add consignee name, address
    Then success update "consignee name, address"
    And the consignee name, address value added in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @house-13 @cust-info @done
  Scenario: 13. Other Customs Information
    And user success create LO
    And user success get LO
    When user update Other Customs Information
    Then success update "Other Customs Information"
    And the Other Customs Information value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @house-13.1 @cust-info @done
  Scenario: 13.1 Delete Other Customs Information
    And user success create LO
    And user success get LO
    When user delete Other Customs Information
    Then success update "Other Customs Information"
    And the Other Customs Information value deleted in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @house-13.2 @cust-info @done
  Scenario: 13.2 Add Other Customs Information
    And user success create LO
    And user success get LO
    When user add Other Customs Information
    Then success update "Other Customs Information"
    And the Other Customs Information value added in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request
