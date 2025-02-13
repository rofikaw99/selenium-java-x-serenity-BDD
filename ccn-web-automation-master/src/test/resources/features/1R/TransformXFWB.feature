@xfwb @transform-xfwb
Feature: Transform XFWB

  Background: Login and transform
    Given user login SSO for one record

  @xfwb-2 @done
  Scenario Outline: Verify BusinessHeaderDocument path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data of "<value>" "<child>" "<child_2>" to data in response of Waybill "<mapping>"
    Examples:
      | value | child | child_2 | mapping |
      | ID    |       |         | waybillPrefix |
      | ID    |       |         | waybillNumber |
      | SenderAssignedID  |  |  |shippingRefNo |
      | IncludedHeaderNote | ContentCode | | waybillType  |
      | IncludedHeaderNote | Content | |   |
      | SignatoryConsignorAuthentication| Signatory | | consignorDeclarationSignature |
      | SignatoryCarrierAuthentication  | ActualDateTime | | carrierDeclarationDate |
      | SignatoryCarrierAuthentication  | Signatory |      | carrierDeclarationSignature |
      | SignatoryCarrierAuthentication  | IssueAuthenticationLocation | Name | carrierDeclarationPlace |

  @xfwb-3 @done
  Scenario Outline: Verify MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data of "<value>" to data in response of Waybill "<mapping>"
    Examples:
      | value | mapping |
      | ID |            |
      | AdditionalID |            |
      | FreightForwarderAssignedID |            |
      | AssociatedReferenceID |            |
      | NilCarriageValueIndicator | declaredValueForCarriage |
      | DeclaredValueForCarriageAmount | declaredValueForCarriage |
      | NilCustomsValueIndicator                          | declaredValueForCustoms  |
      | DeclaredValueForCustomsAmount                     | declaredValueForCustoms  |
      | NilInsuranceValueIndicator                        | insuredAmount            |
      | InsuranceValueAmount                              | insuredAmount            |
      | TotalChargePrepaidIndicator                      | weightValuationIndicator |
      | TotalDisbursementPrepaidIndicator                | otherChargesIndicator    |
      | IncludedTareGrossWeightMeasure                   | totalGrossWeight         |
      | GrossVolumeMeasure                               | dimensionsForRate        |
      | DensityGroupCode                               |         |
      | PackageQuantity                                  | slacForRate              |
      | TotalPieceQuantity                               | pieceCountForRate        |
      | ProductID                                        | productCode |

  @xfwb-4 @done
  Scenario Outline: Verify ConsignorParty of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" "<child>" of ConsignorParty to data in response of Waybill "<mapping>"
    Examples:
      | value | child | mapping |
      | PrimaryID  | |  |
      | AdditionalID  | |  |
      | Name  | | name |
      | AccountID | | otherIdentifiers |
      | PostalStructuredAddress | PostcodeCode | postalCode  |
      | PostalStructuredAddress | StreetName | streetAddressLines  |
      | PostalStructuredAddress | CityName | cityName            |
      | PostalStructuredAddress | CountryID | countryCode            |
      | PostalStructuredAddress | CountryName | country |
      | PostalStructuredAddress | CountrySubDivisionName | regionName    |
      | PostalStructuredAddress | PostOfficeBox | postOfficeBox         |
      | PostalStructuredAddress | CityID | cityCode        |
      | PostalStructuredAddress | CountrySubDivisionID | regionCode              |
      | DefinedTradeContact     | PersonName | firstName        |
      | DefinedTradeContact     | DepartmentName | department |
      | DefinedTradeContact     | DirectTelephoneCommunication | textualValue |
      | DefinedTradeContact     | FaxCommunication | textualValue |
      | DefinedTradeContact     | URIEmailCommunication | textualValue |
      | DefinedTradeContact     | TelexCommunication | textualValue |

  @xfwb-5 @done
  Scenario Outline: Verify ConsigneeParty of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" "<child>" of ConsigneeParty to data in response of Waybill "<mapping>"
    Examples:
      | value | child | mapping |
      | Name  | | name |
      | AccountID | | otherIdentifiers |
      | PostalStructuredAddress | PostcodeCode | postalCode  |
      | PostalStructuredAddress | StreetName | streetAddressLines  |
      | PostalStructuredAddress | CityName | cityName            |
      | PostalStructuredAddress | CountryID | countryCode            |
      | PostalStructuredAddress | CountryName | country |
      | PostalStructuredAddress | CountrySubDivisionName | regionName    |
      | PostalStructuredAddress | PostOfficeBox | postOfficeBox         |
      | PostalStructuredAddress | CityID | cityCode        |
      | PostalStructuredAddress | CountrySubDivisionID | regionCode              |
      | DefinedTradeContact     | PersonName | firstName        |
      | DefinedTradeContact     | DepartmentName | textualValue |
      | DefinedTradeContact     | DirectTelephoneCommunication | textualValue |
      | DefinedTradeContact     | FaxCommunication | textualValue |
      | DefinedTradeContact     | URIEmailCommunication | textualValue |
      | DefinedTradeContact     | TelexCommunication | textualValue |

  @xfwb-6 @done
  Scenario Outline: Verify FreightForwarderParty of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" "<child>" of FreightForwarderParty to data in response of Waybill "<mapping>"
    Examples:
      | value | child | mapping |
      | Name  | | name |
      | AccountID | | otherIdentifiers |
      | CargoAgentID | | iataCargoAgentCode |
      | FreightForwarderAddress | PostcodeCode | postalCode  |
      | FreightForwarderAddress | StreetName | streetAddressLines  |
      | FreightForwarderAddress | CityName | cityName            |
      | FreightForwarderAddress | CountryID | countryCode            |
      | FreightForwarderAddress | CountryName | country |
      | FreightForwarderAddress | CountrySubDivisionName | regionName    |
      | FreightForwarderAddress | PostOfficeBox | postOfficeBox         |
      | FreightForwarderAddress | CityID | cityCode        |
      | FreightForwarderAddress | CountrySubDivisionID | regionCode              |
      | SpecifiedCargoAgentLocation | ID | iataCargoAgentLocationIdentifier              |
      | DefinedTradeContact     | PersonName | firstName        |
      | DefinedTradeContact     | DepartmentName | textualValue |
      | DefinedTradeContact     | DirectTelephoneCommunication | textualValue |
      | DefinedTradeContact     | FaxCommunication | textualValue |
      | DefinedTradeContact     | URIEmailCommunication | textualValue |
      | DefinedTradeContact     | TelexCommunication | textualValue |

  @xfwb-100 @done
  Scenario Outline: Verify AssociatedParty of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" "<child>" of AssociatedParty to data in response of Waybill "<mapping>"
    Examples:
      | value | child | mapping |
      | Name  | | name |
      | RoleCode  | |  |
      | Role  | | partyrole |
      | FreightForwarderAddress | PostcodeCode | postalCode  |
      | FreightForwarderAddress | StreetName | streetAddressLines  |
      | FreightForwarderAddress | CityName | cityName            |
      | FreightForwarderAddress | CountryID | countryCode            |
      | FreightForwarderAddress | CountryName | country |
      | FreightForwarderAddress | CountrySubDivisionName | regionName    |
      | FreightForwarderAddress | PostOfficeBox | postOfficeBox         |
      | FreightForwarderAddress | CityID | cityCode        |
      | FreightForwarderAddress | CountrySubDivisionID | regionCode              |
      | SpecifiedAddressLocation | ID |               |
      | SpecifiedAddressLocation | Name |               |
      | PostalStructuredAddress | TypeCode |               |
      | DefinedTradeContact     | PersonName | firstName        |
      | DefinedTradeContact     | DepartmentName | textualValue |
      | DefinedTradeContact     | DirectTelephoneCommunication | textualValue |
      | DefinedTradeContact     | FaxCommunication | textualValue |
      | DefinedTradeContact     | URIEmailCommunication | textualValue |
      | DefinedTradeContact     | TelexCommunication | textualValue |

  @xfwb-7 @done
  Scenario Outline: Verify OriginLocation of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" of OriginLocation to data in response of Waybill "<mapping>"
    Examples:
      | value | mapping |
      | ID  | code |
      | Name | name |

  @xfwb-8 @done
  Scenario Outline: Verify FinalDestinationLocation of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" of FinalDestinationLocation to data in response of Waybill "<mapping>"
    Examples:
      | value | mapping |
      | ID  | code |
      | Name | name |

  @xfwb-9 @done
  Scenario Outline: Verify SpecifiedLogisticsTransportMovement of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" "<child>" "<child_2>" of SpecifiedLogisticsTransportMovement to data in response of Waybill "<mapping>"
    Examples:
      | value | child | child_2 | mapping |
      | StageCode  |  |         | modeQualifier |
      | ModeCode |    |         | modeCode |
      | Mode |    |         |  |
      | ID |          |         | transportIdentifier |
      | SequenceNumeric |          |         |  |
      | UsedLogisticsTransportMeans | Name | | airlineCode |
      | ArrivalEvent | ScheduledOccurrenceDateTime | | movementTimestamp |
      | ArrivalEvent | OccurrenceArrivalLocation | ID | code |
      | ArrivalEvent | OccurrenceArrivalLocation | Name | locationName |
      | ArrivalEvent | OccurrenceArrivalLocation | TypeCode | locationType |
      | DepartureEvent | ScheduledOccurrenceDateTime |  | movementTimestamp |
      | DepartureEvent | OccurrenceDepartureLocation | ID | code |
      | DepartureEvent | OccurrenceDepartureLocation | Name | locationName |
      | DepartureEvent | OccurrenceDepartureLocation | TypeCode | locationType |

  @xfwb-101 @done
  Scenario Outline: Verify UtilizedLogisticsTransportEquipment of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" of UtilizedLogisticsTransportEquipment to data in response of Waybill "<mapping>"
    Examples:
      | value | mapping |
      | ID | vehicleRegistration |
      | CharacteristicCode | vehicleType |
      | Characteristic | vehicleSize |
      | AffixedLogisticsSeal | seal |

  @xfwb-10 @done
  Scenario Outline: Verify HandlingSPHInstructions of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" of HandlingSPHInstructions to data in response of Waybill "<mapping>"
    Examples:
      | value | mapping |
      | Description |  |
      | DescriptionCode | specialHandlingCodes |

  @xfwb-11 @done
  Scenario Outline: Verify HandlingSSRInstructions of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" of HandlingSSRInstructions to data in response of Waybill "<mapping>"
    Examples:
      | value | mapping |
      | Description | textualHandlingInstructions |
      | DescriptionCode |  |

  @xfwb-102 @done
  Scenario Outline: Verify HandlingOSIInstructions of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" of HandlingOSIInstructions to data in response of Waybill "<mapping>"
    Examples:
      | value | mapping |
      | Description | textualHandlingInstructions |
      | DescriptionCode |  |

  @xfwb-12 @done
  Scenario Outline: Verify IncludedAccountingNote of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" of IncludedAccountingNote to data in response of Waybill "<mapping>"
    Examples:
      | value | mapping |
      | ContentCode | accountingInformation |
      | Code | accountingInformation |

  @xfwb-13 @done
  Scenario Outline: Verify IncludedCustomsNote of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" of IncludedCustomsNote to data in response of Waybill "<mapping>"
    Examples:
      | value | mapping |
      | ContentCode | contentCode |
      | Content | note |
      | SubjectCode | subjectCode |
      | CountryID | country |

  @xfwb-103 @done
  Scenario Outline: Verify AssociatedReferenceDocument of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" of AssociatedReferenceDocument to data in response of Waybill "<mapping>"
    Examples:
      | value | mapping |
      | ID | documentIdentifier |
      | IssueDateTime | validFrom, validUntil |
      | TypeCode | documentType |
      | Name | documentName |

  @xfwb-104 @done
  Scenario Outline: Verify ApplicableOriginCurrencyExchange of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" of ApplicableOriginCurrencyExchange to data in response of Waybill "<mapping>"
    Examples:
      | value | mapping |
      | SourceCurrencyCode | originCurrency |

  @xfwb-14
  Scenario Outline: Verify ApplicableLogisticsAllowanceCharge of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" of ApplicableLogisticsAllowanceCharge to data in response of Waybill "<mapping>"
    Examples:
      | value | mapping |
      | ID | otherChargeCode |
      | PrepaidIndicator | chargePaymentType |
      | PartyTypeCode | entitlement |
      | ActualAmount | otherChargeAmount |

  @xfwb-15 @todo
  Scenario Outline: Verify ApplicableRating of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" of ApplicableRating to data in response of Waybill "<mapping>"
    Examples:
      | value | mapping |
      | TypeCode |  |

  @xfwb-16
  Scenario Outline: Verify IncludedMasterConsignmentItem of ApplicableRating path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" "<child>" "<child_2>" of IncludedMasterConsignmentItem to data in response of Waybill "<mapping>"
    Examples:
      | value | child | child_2 | mapping |
      | SequenceNumeric |  |    | lineItemNumber        |
      | GrossWeightMeasure  |  || grossWeightForRate        |
      | GrossVolumeMeasure  |  || volume        |
      | PieceQuantity  |  |     |  pieceCountForRate |
      | NatureIdentificationTransportCargo  | Identification | | goodsDescriptionForRate |
      | TransportLogisticsPackage  | ItemQuantity |                    | pieceCountForRate |
      | TransportLogisticsPackage  | LinearSpatialDimension | WidthMeasure | width |
      | TransportLogisticsPackage  | LinearSpatialDimension | LengthMeasure | length |
      | TransportLogisticsPackage  | LinearSpatialDimension | HeightMeasure | height |
      | ApplicableFreightRateServiceCharge  | CategoryCode |   | rateClassCode |
      | ApplicableFreightRateServiceCharge  | ChargeableWeightMeasure || chargeableWeightForRate |
      | ApplicableFreightRateServiceCharge  | AppliedRate |            | rateCharge |
      | ApplicableFreightRateServiceCharge  | AppliedAmount |          |  |

  @xfwb-17 @todo
  Scenario Outline: Verify ApplicableTotalRating of MasterConsignment path for every key data
    Given user transform xfwb using "internal" url
    Then verify mapping data "<value>" "<child>" of ApplicableTotalRating to data in response of Waybill "<mapping>"
    Examples:
      | value | child | mapping |
      | TypeCode |  |           |
      | ApplicablePrepaidCollectMonetarySummation | PrepaidIndicator | |
      | ApplicablePrepaidCollectMonetarySummation | WeightChargeTotalAmount | |
      | ApplicablePrepaidCollectMonetarySummation | AgentTotalDuePayableAmount | |
      | ApplicablePrepaidCollectMonetarySummation | CarrierTotalDuePayableAmount | |
      | ApplicablePrepaidCollectMonetarySummation | GrandTotalAmount |             |
