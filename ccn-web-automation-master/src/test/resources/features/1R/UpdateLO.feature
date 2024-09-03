@update-lo
Feature: Update LO

  @1.1 @done
  Scenario: 1.1 Piece count (line item)
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user update piece of count
    Then success update "piece of count"
    And the piece of count value changes in the latest get lo
    And the revision value changes to increment 1

  @1.1.1 @done
  Scenario: 1.1.1 Remove Piece count (line item)
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user remove piece of count
    Then success update "piece of count"
    And the piece of count deleted in the latest get lo
    And the revision value changes to increment 1

  @1.1.2 @done
  Scenario: 1.1.2 Add Piece count (line item)
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO for deleted key "pieceCountForRate"
    And user success get LO
    When user add piece of count
    Then success update "piece of count"
    And the piece of count added in the latest get lo
    And the revision value changes to increment 1

  @2 @done
  Scenario: 2. Gross weight
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user update gross weight for rate
    Then success update "gross weight for rate"
    And the gross weight for rate value changes in the latest get lo
    And the revision value changes to increment 1

  @2.1 @done
  Scenario: 2.1 Delete Gross weight
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user delete gross weight for rate
    Then success update "gross weight for rate"
    And the gross weight for rate deleted in the latest get lo
    And the revision value changes to increment 1

  @2.2
  Scenario: 2.2 Add Gross weight
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO for deleted key "grossWeightForRate"
    And user success get LO
    When user add gross weight for rate
    Then success update "gross weight for rate"
    And the gross weight for rate added in the latest get lo
    And the revision value changes to increment 1

  @3 @done
  Scenario: 3. Chargeable weight
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user update chargeable weight
    Then success update "chargeable weight"
    And the chargeable weight value changes in the latest get lo
    And the revision value changes to increment 1

  @4 @done
  Scenario: 4. Update Volume
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user update volume
    Then success update "volume"
    And the volume value changes in the latest get lo
    And the revision value changes to increment 1

  @4.1 @done
  Scenario: 4.1 Delete Volume
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user delete volume
    Then success update "volume"
    And the volume value deleted in the latest get lo
    And the revision value changes to increment 1

  @4.2
  Scenario: 4.2 Add Volume
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO for deleted key "volume"
    And user success get LO
    When user add volume
    Then success update "volume"
    And the volume value added in the latest get lo
    And the revision value changes to increment 1

  @5
  Scenario: 5. Dims
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user update dimensions
    Then success update "dimensions"
    And the dimensions value changes in the latest get lo
    And the revision value changes to increment 1

  @5.1 @done
  Scenario: 5.1 Delete Dims
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user delete dimensions
    Then success update "dimensions"
    And the dimensions value deleted in the latest get lo
    And the revision value changes to increment 1

  @5.2
  Scenario: 5.2 Add Dims
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO for deleted key "dimensions"
    And user success get LO
    When user add dimensions
    Then success update "dimensions"
    And the dimensions value added in the latest get lo
    And the revision value changes to increment 1

  @6
  Scenario: 6. SLAC count
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user update SLAC count
    Then success update "SLAC count"
    And the SLAC count value changes in the latest get lo
    And the revision value changes to increment 1

  @7 @done
  Scenario: 7. Update Shipment description
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user update Shipment description
    Then success update "Shipment description"
    And the Shipment description value changes in the latest get lo
    And the revision value changes to increment 1

  @7.1 @done
  Scenario: 7.1 Delete Shipment description
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user delete Shipment description
    Then success update "Shipment description"
    And the Shipment description value deleted in the latest get lo
    And the revision value changes to increment 1

  @8
  Scenario: 8. Commodity (price) code
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user update Commodity (price) code
    Then success update "Commodity (price) code"
    And the commodity (price) code value changes in the latest get lo
    And the revision value changes to increment 1

  @9
  Scenario: 9. Special handling code
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user update special handling code
    Then success update "special handling code"
    And the special handling code value changes in the latest get lo
    And the revision value changes to increment 1

  @10
  Scenario: 10. Shipper name, address
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user update shipper name, address
    Then success update "shipper name, address"
    And the shipper name, address value changes in the latest get lo
    And the revision value changes to increment 1

  @11
  Scenario: 11. Consignee name, address
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user update consignee name, address
    Then success update "consignee name, address"
    And the consignee name, address value changes in the latest get lo
    And the revision value changes to increment 1

  @12
  Scenario: 12. OCDC charges, MYC, SCC, RAC, etc
    Given user login SSO for one record
    And user transform xfwb
    And user success create LO
    And user success get LO
    When user update OCDC charges, MYC, SCC, RAC, etc
    Then success update "OCDC charges, MYC, SCC, RAC, etc"
    And the OCDC charges, MYC, SCC, RAC, etc value changes in the latest get lo
    And the revision value changes to increment 1