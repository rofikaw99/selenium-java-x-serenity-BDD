Feature: Transform XFZB

  Scenario Outline: Verify mapping of MessageHeaderDocument
    Given user transform xfzb
    Then verify mapping data "<key>" "<subkey>" of MessageHeaderDocument to data in response of HouseWaybill "<key_response>"
    Examples:
    |key | subkey | key_response |
    | ID | | |
    | Name | | |
    | TypeCode | | |
    | IssueDateTime | | |
    | PurposeCode | | |
    | VersionID | | |
    | ConversationID | | |
    | SenderParty | PrimaryID | |
    | RecipientParty | PrimaryID | |

  @xfzb-1
  Scenario Outline: Verify mapping of BusinessHeaderDocument
    Given user transform xfzb
    Then verify mapping data "<key>" "<subkey>" "<subkey_2> "of BusinessHeaderDocument to data in response of HouseWaybill "<key_response>"
    Examples:
      |key | subkey | subkey_2 | key_response |
      | ID | | | waybillNumber |
      | SignatoryConsignorAuthentication | Signatory | | consignorDeclarationSignature |
      | SignatoryCarrierAuthentication | ActualDateTime | | carrierDeclarationDate |
      | SignatoryCarrierAuthentication | Signatory | | carrierDeclarationSignature |
      | SignatoryCarrierAuthentication | IssueAuthenticationLocation | Name | carrierDeclarationPlace |

  @xfzb-2
  Scenario Outline: Verify mapping of MasterConsignment
    Given user transform xfzb
    Then verify mapping data "<key>" "<subkey>" "<subkey_2> "of MasterConsignment to data in response of HouseWaybill "<key_response>"
    Examples:
      |key | subkey | subkey_2 | key_response |
      | IncludedTareGrossWeightMeasure | |  | |
      | TotalPieceQuantity |  | | |
      | TransportContractDocument | ID | | |
      | OriginLocation | ID | | |
      | FinalDestinationLocation | ID | | |
      | IncludedHouseConsignment | NilCarriageValueIndicator | |declaredValueForCarriage |
      | IncludedHouseConsignment | NilCustomsValueIndicator | | declaredValueForCustoms |
      | IncludedHouseConsignment | NilInsuranceValueIndicator | | insuredAmount |
      | IncludedHouseConsignment | TotalChargePrepaidIndicator | | weightValuationIndicator |
      | IncludedHouseConsignment | TotalDisbursementPrepaidIndicator | | otherChargesIndicator |
      | IncludedHouseConsignment | IncludedTareGrossWeightMeasure |  | totalGrossWeight |
      | IncludedHouseConsignment | PackageQuantity | | slacForRate |
      | IncludedHouseConsignment | TotalPieceQuantity | | |
      | IncludedHouseConsignment | SummaryDescription | | Goodsdescriptionforrate |
      | ApplicableOriginCurrencyExchange | SourceCurrencyCode | | |

  Scenario Outline: Verify mapping of ConsignorParty in MasterConsignment
    Given user transform xfzb
    Then verify mapping data "<key>" "<subkey>" "<subkey_2>" of ConsignorParty in MasterConsignment to data in response of HouseWaybill "<key_response>"
    Examples:
      |key | subkey | subkey_2 | key_response |
      | Name | | |                              |
      | PostalStructuredAddress | PostcodeCode | | |
      | PostalStructuredAddress | StreetName | | |
      | PostalStructuredAddress | CityName | | |
      | PostalStructuredAddress | CountryID | | |

  Scenario Outline: Verify mapping of ConsigneeParty in MasterConsignment
    Given user transform xfzb
    Then verify mapping data "<key>" "<subkey>" "<subkey_2>" of ConsigneeParty in MasterConsignment to data in response of HouseWaybill "<key_response>"
    Examples:
      |key | subkey | subkey_2 | key_response |
      | Name | | |                              |
      | PostalStructuredAddress | PostcodeCode | | |
      | PostalStructuredAddress | StreetName | | |
      | PostalStructuredAddress | CityName | | |
      | PostalStructuredAddress | CountryID | | |