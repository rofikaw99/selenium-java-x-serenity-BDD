@lo @update-lo
Feature: Update LO

  Background: Login and transform
    Given user login SSO for one record
    And user transform xfwb using "internal" url

  @1.1 @done @pieceCountForRate @passed
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

  @1.1.1 @done @pieceCountForRate
  Scenario: 1.1.1 Remove Piece count (line item)
    And user success create LO
    And user success get LO
    When user remove piece of count
    Then success update "piece of count"
    And the piece of count deleted in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request
    And verify change request same as update dimensions

  @1.1.2 @done @pieceCountForRate
  Scenario: 1.1.2 Add Piece count (line item)
    And user success create LO for deleted key "pieceCountForRate"
    And user success get LO
    When user add piece of count
    Then success update "piece of count"
    And the piece of count added in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request
    And verify change request same as update dimensions

  @2 @done @grossWeight
  Scenario: 2. Gross weight
    And user success create LO
    And user success get LO
    When user update gross weight for rate
    Then success update "gross weight for rate"
    And the gross weight for rate value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request
    And verify change request same as update dimensions

  @2.1 @done @grossWeight
  Scenario: 2.1 Delete Gross weight
    And user success create LO
    And user success get LO
    When user delete gross weight for rate
    Then success update "gross weight for rate"
    And the gross weight for rate deleted in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request
    And verify change request same as update dimensions

  @2.2 @grossWeight
  Scenario: 2.2 Add Gross weight
    And user success create LO for deleted key "grossWeightForRate"
    And user success get LO
    When user add gross weight for rate
    Then success update "gross weight for rate"
    And the gross weight for rate added in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request
    And verify change request same as update dimensions

  @3 @done
  Scenario: 3. Chargeable weight
    And user success create LO
    And user success get LO
    When user update chargeable weight
    Then success update "chargeable weight"
    And the chargeable weight value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request
    And verify change request same as update dimensions

  @4 @done @volume
  Scenario: 4. Update Volume
    And user success create LO with new waybill number
    And user success get LO
    When user update volume
    Then success update "volume"
    And the volume value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request
    And verify change request same as update dimensions

  @4.1 @done @volume
  Scenario: 4.1 Delete Volume
    And user success create LO with new waybill number
    And user success get LO
    When user delete volume
    Then success update "volume"
    And the volume value deleted in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @4.2 @volume
  Scenario: 4.2 Add Volume
    And user success create LO for deleted key "volume"
    And user success get LO
    When user add volume
    Then success update "volume"
    And the volume value added in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @5 @dims
  Scenario: 5. Dims
    And user success create LO with new waybill number
    And user success get LO
    When user update dimensions
    Then success update "dimensions"
    And the dimensions value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @5.1 @done @dims
  Scenario: 5.1 Delete Dims
    And user success create LO with new waybill number
    And user success get LO
    When user delete dimensions
    Then success update "dimensions"
    And the dimensions value deleted in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @5.2 @dims
  Scenario: 5.2 Add Dims
    And user success create LO for deleted key "dimensions"
    And user success get LO
    When user add dimensions
    Then success update "dimensions"
    And the dimensions value added in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @6
  Scenario: 6. SLAC count
    And user success create LO with new waybill number
    And user success get LO
    When user update SLAC count
    Then success update "SLAC count"
    And the SLAC count value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @7 @done @shipmentDesc
  Scenario: 7. Update Shipment description
    And user success create LO
    And user success get LO
    When user update Shipment description
    Then success update "Shipment description"
    And the Shipment description value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @7.1 @done @shipmentDesc
  Scenario: 7.1 Delete Shipment description
    And user success create LO with new waybill number
    And user success get LO
    When user delete Shipment description
    Then success update "Shipment description"
    And the Shipment description value deleted in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @7.2 @done @shipmentDesc
  Scenario: 7.2 Add Shipment description
    And user success create LO for deleted key "goodsDescriptionForRate"
    And user success get LO
    When user add Shipment description
    Then success update "Shipment description"
    And the Shipment description value added in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @8 @hsCodeForRate
  Scenario: 8. Update Commodity (price) code
    And user success create LO
    And user success get LO
    When user update Commodity (price) code
    Then success update "Commodity (price) code"
    And the commodity (price) code value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @8.1 @done @hsCodeForRate
  Scenario: 8.1 Delete Commodity (price) code
    And user success create LO
    And user success get LO
    When user delete Commodity (price) code
    Then success update "Commodity (price) code"
    And the commodity (price) code value deleted in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @8.2 @done @hsCodeForRate
  Scenario: 8.2 Add Commodity (price) code
    And user success create LO for deleted key "hsCodeForRate"
    And user success get LO
    When user add Commodity (price) code
    Then success update "Commodity (price) code"
    And the commodity (price) code value added in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @9 @done @handlingCode
  Scenario: 9. Special handling code
    And user success create LO
    And user success get LO
    When user update special handling code
    Then success update "special handling code"
    And the special handling code value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @9.1 @done @handlingCode
  Scenario: 9.1 Delete Special handling code
    And user success create LO
    And user success get LO
    When user delete special handling code
    Then success update "special handling code"
    And the special handling code value deleted in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @9.2 @handlingCode
  Scenario: 9.2 Add Special handling code
    And user success create LO
    And user success get LO
    When user add special handling code
    Then success update "special handling code"
    And the special handling code value added in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @10
  Scenario: 10. Shipper name, address
    And user success create LO with new waybill number
    And user success get LO
    When user update shipper name, address
    Then success update "shipper name, address"
    And the shipper name, address value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @11
  Scenario: 11. Consignee name, address
    And user success create LO with new waybill number
    And user success get LO
    When user update consignee name, address
    Then success update "consignee name, address"
    And the consignee name, address value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @12. @done
  Scenario: 12. OCDC charges, MYC, SCC, RAC, etc
    And user success create LO with new waybill number
    And user success get LO
    When user update OCDC charges, MYC, SCC, RAC, etc
    Then success update "OCDC charges, MYC, SCC, RAC, etc"
    And the OCDC charges, MYC, SCC, RAC, etc value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @12.1 @done @12
  Scenario: 12.1 Delete OCDC charges, MYC, SCC, RAC, etc
    And user success create LO
    And user success get LO
    When user delete OCDC charges, MYC, SCC, RAC, etc
    Then success update "OCDC charges, MYC, SCC, RAC, etc"
    And the OCDC charges, MYC, SCC, RAC, etc value deleted in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @12.2 @done @12
  Scenario: 12.2 Add OCDC charges, MYC, SCC, RAC, etc
    And user success create LO for deleted key "otherChargeCode"
    And user success get LO
    When user add OCDC charges, MYC, SCC, RAC, etc
    Then success update "OCDC charges, MYC, SCC, RAC, etc"
    And the OCDC charges, MYC, SCC, RAC, etc value added in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @13 @done
  Scenario: 13. Other Customs Information
    And user success create LO
    And user success get LO
    When user update Other Customs Information
    Then success update "Other Customs Information"
    And the Other Customs Information value changes in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @13.1
  Scenario: 13.1 Delete Other Customs Information
    And user success create LO
    And user success get LO
    When user delete Other Customs Information
    Then success update "Other Customs Information"
    And the Other Customs Information value deleted in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

  @13.2 @done
  Scenario: 13.2 Add Other Customs Information
    And user success create LO
    And user success get LO
    When user add Other Customs Information
    Then success update "Other Customs Information"
    And the Other Customs Information value added in the latest get lo
    And the revision value changes to increment 1
    When user get change request using LO_ID
    Then success get change request

