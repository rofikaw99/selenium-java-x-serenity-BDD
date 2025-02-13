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

  @xfzb-1 @done
  Scenario Outline: Verify mapping of BusinessHeaderDocument
    Given user transform xfzb
    Then verify mapping data "<key>" "<subkey>" "<subkey_2> "of BusinessHeaderDocument to data in response of HouseWaybill "<key_response>"
    Examples:
      |key | subkey | subkey_2 | key_response |
      | ID | | | waybillNumber |
      | IncludedHeaderNote | ContentCode | | waybillType |
      | IncludedHeaderNote | Content | |  |
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
      | IncludedTareGrossWeightMeasure | |  | totalGrossWeight |
      | TotalPieceQuantity |  | | pieceCountForRate |
      | TransportContractDocument | ID | | waybillNumber |
      | OriginLocation | ID | | departureLocation |
      | OriginLocation | Name | |  |
      | FinalDestinationLocation | ID | | arrivalLocation |
      | FinalDestinationLocation | Name | | |
#      | IncludedHouseConsignment | ID | | |
#      | IncludedHouseConsignment | AdditionalID | | |
#      | IncludedHouseConsignment | AssociatedReferenceID | | |
#      | IncludedHouseConsignment | NilCarriageValueIndicator | |declaredValueForCarriage |
#      | IncludedHouseConsignment | DeclaredValueForCarriageAmount | |declaredValueForCarriage |
#      | IncludedHouseConsignment | NilCustomsValueIndicator | | declaredValueForCustoms |
#      | IncludedHouseConsignment | DeclaredValueForCustomsAmount | | declaredValueForCustoms |
#      | IncludedHouseConsignment | NilInsuranceValueIndicator | | insuredAmount |
#      | IncludedHouseConsignment | InsuranceValueAmount  | | insuredAmount |
#      | IncludedHouseConsignment | TotalChargePrepaidIndicator | | weightValuationIndicator |
#      | IncludedHouseConsignment | WeightTotalChargeAmount | | weightCharge |
#      | IncludedHouseConsignment | ValuationTotalChargeAmount | | valuationCharge |
#      | IncludedHouseConsignment | TaxTotalChargeAmount | | otherChargeAmount |
#      | IncludedHouseConsignment | TotalDisbursementPrepaidIndicator | | otherChargesIndicator |
#      | IncludedHouseConsignment | AgentTotalDisbursementAmount | |  |
#      | IncludedHouseConsignment | CarrierTotalDisbursementAmount | |  |
#      | IncludedHouseConsignment | TotalPrepaidChargeAmount | |  |
#      | IncludedHouseConsignment | TotalCollectChargeAmount | |  |
#      | IncludedHouseConsignment | IncludedTareGrossWeightMeasure |  | totalGrossWeight |
#      | IncludedHouseConsignment | GrossVolumeMeasure |  | dimensions |
#      | IncludedHouseConsignment | ConsignmentItemQuantity |  |  |
#      | IncludedHouseConsignment | PackageQuantity | | slacForRate |
#      | IncludedHouseConsignment | TotalPieceQuantity | | |
#      | IncludedHouseConsignment | SummaryDescription | | Goodsdescriptionforrate |
#      | IncludedHouseConsignment | FreightRateTypeCode | | |

  @xfzb-3
  Scenario Outline: Verify mapping of ConsignorParty in MasterConsignment
    Given user transform xfzb
    Then verify mapping data "<key>" "<subkey>" "<subkey_2>" of ConsignorParty in MasterConsignment to data in response of HouseWaybill "<key_response>"
    Examples:
      |key | subkey | subkey_2 | key_response |
      | PrimaryID | | |                              |
      | AdditionalID | | |                              |
      | Name | | | name |
      | AccountID | | |                              |
      | PostalStructuredAddress | PostcodeCode | | postalCode |
      | PostalStructuredAddress | StreetName | | streetAddressLines  |
      | PostalStructuredAddress | CityName | | cityName |
      | PostalStructuredAddress | CountryID | | countryCode |
      | PostalStructuredAddress | CountryName | countryDescription | |
      | PostalStructuredAddress | CountrySubDivisionName | | regionName |
      | PostalStructuredAddress | PostOfficeBox | | postOfficeBox |
      | PostalStructuredAddress | CityID | | cityCode |
      | PostalStructuredAddress | CountrySubDivisionID | | regionCode |

  @xfzb-4
  Scenario Outline: Verify mapping of ConsigneeParty in MasterConsignment
    Given user transform xfzb
    Then verify mapping data "<key>" "<subkey>" "<subkey_2>" of ConsigneeParty in MasterConsignment to data in response of HouseWaybill "<key_response>"
    Examples:
      |key | subkey | subkey_2 | key_response |
      | PrimaryID | | |                              |
      | AdditionalID | | |                              |
      | Name | | | name |
      | AccountID | | |                              |
      | PostalStructuredAddress | PostcodeCode | | postalCode |
      | PostalStructuredAddress | StreetName | | streetAddressLines  |
      | PostalStructuredAddress | CityName | | cityName |
      | PostalStructuredAddress | CountryID | | countryCode |
      | PostalStructuredAddress | CountryName | countryDescription | |
      | PostalStructuredAddress | CountrySubDivisionName | | regionName |
      | PostalStructuredAddress | PostOfficeBox | | postOfficeBox |
      | PostalStructuredAddress | CityID | | cityCode |
      | PostalStructuredAddress | CountrySubDivisionID | | regionCode |

  @xfzb-5
  Scenario Outline: Verify mapping of FreightForwarderParty in MasterConsignment
    Given user transform xfzb
    Then verify mapping data "<key>" "<subkey>" "<subkey_2>" of FreightForwarderParty in MasterConsignment to data in response of HouseWaybill "<key_response>"
    Examples:
      |key | subkey | subkey_2 | key_response |
      | PrimaryID | | |                              |
      | AdditionalID | | |                              |
      | Name | | | name |
      | AccountID | | |                              |
      | PostalStructuredAddress | PostcodeCode | | postalCode |
      | PostalStructuredAddress | StreetName | | streetAddressLines  |
      | PostalStructuredAddress | CityName | | cityName |
      | PostalStructuredAddress | CountryID | | countryCode |
      | PostalStructuredAddress | CountryName | countryDescription | |
      | PostalStructuredAddress | CountrySubDivisionName | | regionName |
      | PostalStructuredAddress | PostOfficeBox | | postOfficeBox |
      | PostalStructuredAddress | CityID | | cityCode |
      | PostalStructuredAddress | CountrySubDivisionID | | regionCode |

  @xfzb-6
  Scenario Outline: Verify mapping of AssociatedParty in MasterConsignment
    Given user transform xfzb
    Then verify mapping data "<key>" "<subkey>" "<subkey_2>" of AssociatedParty in MasterConsignment to data in response of HouseWaybill "<key_response>"
    Examples:
      |key | subkey | subkey_2 | key_response |
      | PrimaryID | | |                              |
      | AdditionalID | | |                              |
      | Name | | | name |
      | AccountID | | |                              |
      | PostalStructuredAddress | PostcodeCode | | postalCode |
      | PostalStructuredAddress | StreetName | | streetAddressLines  |
      | PostalStructuredAddress | CityName | | cityName |
      | PostalStructuredAddress | CountryID | | countryCode |
      | PostalStructuredAddress | CountryName | countryDescription | |
      | PostalStructuredAddress | CountrySubDivisionName | | regionName |
      | PostalStructuredAddress | PostOfficeBox | | postOfficeBox |
      | PostalStructuredAddress | CityID | | cityCode |
      | PostalStructuredAddress | CountrySubDivisionID | | regionCode |

  @xfzb-7
  Scenario Outline: Verify mapping of OriginLocation in MasterConsignment
    Given user transform xfzb
    Then verify mapping data "<key>" "<subkey>" "<subkey_2>" of OriginLocation in MasterConsignment to data in response of HouseWaybill "<key_response>"
    Examples:
      |key | subkey | subkey_2 | key_response |
      | ID | | |      locationCode                        |
      | Name | | | locationName |

  @xfzb-8
  Scenario Outline: Verify mapping of FinalDestinationLocation in MasterConsignment
    Given user transform xfzb
    Then verify mapping data "<key>" "<subkey>" "<subkey_2>" of FinalDestinationLocation in MasterConsignment to data in response of HouseWaybill "<key_response>"
    Examples:
      |key | subkey | subkey_2 | key_response |
      | ID | | |      locationCode                        |
      | Name | | | locationName |