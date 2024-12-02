@lo @xfzb @create-fhl-lo
Feature: Create LO

  Background: Login
    Given user login SSO for one record

  @create-fhl-lo
  Scenario: Success create logistic objects using internal url
    Given user transform xfzb
    When Create logistic objects of fhl using predefined json and "internal" url
    Then Success create using "internal" url
    And Verify there is id of LO in body response
    And verify the type value is "cargo:Waybill"
    Then get logistic objects using ID of response

  @get-xfzb-1
  Scenario Outline: Verify mapping of BusinessHeaderDocument after creating LO
    Given user transform xfzb
    When Create logistic objects of fhl using predefined json and "internal" url
    Then get logistic objects of FHL using ID of response
    And verify mapping data "<key>" "<subkey>" "<subkey_2> "of BusinessHeaderDocument to data in response of HouseWaybill "<key_response>"
    Examples:
      |key | subkey | subkey_2 | key_response |
      | ID | | | waybillNumber |
      | SignatoryConsignorAuthentication | Signatory | | consignorDeclarationSignature |
      | SignatoryCarrierAuthentication | ActualDateTime | | carrierDeclarationDate |
      | SignatoryCarrierAuthentication | Signatory | | carrierDeclarationSignature |
      | SignatoryCarrierAuthentication | IssueAuthenticationLocation | Name | carrierDeclarationPlace |

  @get-xfzb-1
  Scenario Outline: Verify mapping of MasterConsignment
    Given user transform xfzb
    Then verify mapping data "<key>" "<subkey>" "<subkey_2> "of MasterConsignment to data in response of HouseWaybill "<key_response>"
    Examples:
      |key | subkey | subkey_2 | key_response |
      | IncludedTareGrossWeightMeasure | |  | |
      | TotalPieceQuantity |  | | |
      | TransportContractDocument | ID | | |
      | OriginLocation | ID | | departureLocation |
      | FinalDestinationLocation | ID | | arrivalLocation |
      | IncludedHouseConsignment | NilCarriageValueIndicator | |declaredValueForCarriage |
      | IncludedHouseConsignment | NilCustomsValueIndicator | | declaredValueForCustoms |
      | IncludedHouseConsignment | NilInsuranceValueIndicator | | insuredAmount |
      | IncludedHouseConsignment | TotalChargePrepaidIndicator | | weightValuationIndicator |
      | IncludedHouseConsignment | TotalDisbursementPrepaidIndicator | | otherChargesIndicator |
      | IncludedHouseConsignment | IncludedTareGrossWeightMeasure |  | totalGrossWeight |
      | IncludedHouseConsignment | PackageQuantity | | slacForRate |
      | IncludedHouseConsignment | TotalPieceQuantity | | |
      | IncludedHouseConsignment | SummaryDescription | | Goodsdescriptionforrate |
      | ApplicableOriginCurrencyExchange | SourceCurrencyCode | | originCurrency |