package starter.utlis;

public class XFWBXml {

    public static String xmlPayload =
            "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<rsm:Waybill xmlns:rsm=\"iata:waybill:1\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:ccts=\"urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2\" xmlns:udt=\"urn:un:unece:uncefact:data:standard:UnqualifiedDataType:8\" xmlns:ram=\"iata:datamodel:3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:local=\"urn:local\">\n" +
                    "    <rsm:MessageHeaderDocument>\n" +
                    "        <ram:ID>XFWB</ram:ID>\n" +
                    "        <ram:Name>Air Waybill</ram:Name>\n" +
                    "        <ram:TypeCode>740</ram:TypeCode>\n" +
                    "        <ram:IssueDateTime>2024-07-31T11:01:21</ram:IssueDateTime>\n" +
                    "        <ram:PurposeCode>Creation</ram:PurposeCode>\n" +
                    "        <ram:VersionID>3</ram:VersionID>\n" +
                    "        <ram:ConversationID>XFWB20240731110121227</ram:ConversationID>\n" +
                    "        <ram:SenderParty>\n" +
                    "            <ram:PrimaryID schemeID=\"P\">CSGAGT01XSPKJSQ/SIN01</ram:PrimaryID>\n" +
                    "        </ram:SenderParty>\n" +
                    "        <ram:RecipientParty>\n" +
                    "            <ram:PrimaryID schemeID=\"P\">CSGAIR01SINFMSQ</ram:PrimaryID>\n" +
                    "        </ram:RecipientParty>\n" +
                    "    </rsm:MessageHeaderDocument>\n" +
                    "    <rsm:BusinessHeaderDocument>\n" +
                    "        <ram:ID>618-67009961</ram:ID>\n" +
                    "        <ram:IncludedHeaderNote>\n" +
                    "            <ram:ContentCode>D</ram:ContentCode>\n" +
                    "        </ram:IncludedHeaderNote>\n" +
                    "        <ram:SignatoryConsignorAuthentication>\n" +
                    "            <ram:Signatory>KUEHNE NAGEL PTE LTD</ram:Signatory>\n" +
                    "        </ram:SignatoryConsignorAuthentication>\n" +
                    "        <ram:SignatoryCarrierAuthentication>\n" +
                    "            <ram:ActualDateTime>2024-04-23T00:00:00</ram:ActualDateTime>\n" +
                    "            <ram:Signatory>FOR ATR EASTERN SUPP</ram:Signatory>\n" +
                    "            <ram:IssueAuthenticationLocation>\n" +
                    "                <ram:Name>SINGAPORE</ram:Name>\n" +
                    "            </ram:IssueAuthenticationLocation>\n" +
                    "        </ram:SignatoryCarrierAuthentication>\n" +
                    "    </rsm:BusinessHeaderDocument>\n" +
                    "    <rsm:MasterConsignment>\n" +
                    "        <ram:FreightForwarderAssignedID>1059151163</ram:FreightForwarderAssignedID>\n" +
                    "        <ram:NilCarriageValueIndicator>true</ram:NilCarriageValueIndicator>\n" +
                    "        <ram:NilCustomsValueIndicator>true</ram:NilCustomsValueIndicator>\n" +
                    "        <ram:NilInsuranceValueIndicator>true</ram:NilInsuranceValueIndicator>\n" +
                    "        <ram:TotalChargePrepaidIndicator>true</ram:TotalChargePrepaidIndicator>\n" +
                    "        <ram:TotalDisbursementPrepaidIndicator>true</ram:TotalDisbursementPrepaidIndicator>\n" +
                    "        <ram:IncludedTareGrossWeightMeasure unitCode=\"KGM\">1</ram:IncludedTareGrossWeightMeasure>\n" +
                    "        <ram:GrossVolumeMeasure unitCode=\"MTQ\">0.012</ram:GrossVolumeMeasure>\n" +
                    "        <ram:TotalPieceQuantity>1</ram:TotalPieceQuantity>\n" +
                    "        <ram:ConsignorParty>\n" +
                    "            <ram:Name>ATR EASTERN SUPPORT PTE. LTD.</ram:Name>\n" +
                    "            <ram:PostalStructuredAddress>\n" +
                    "                <ram:PostcodeCode>533865</ram:PostcodeCode>\n" +
                    "                <ram:StreetName>1 GREENWICH DRIVE ARC WAREHOUSE C O</ram:StreetName>\n" +
                    "                <ram:CityName>SINGAPORE</ram:CityName>\n" +
                    "                <ram:CountryID>SG</ram:CountryID>\n" +
                    "            </ram:PostalStructuredAddress>\n" +
                    "        </ram:ConsignorParty>\n" +
                    "        <ram:ConsigneeParty>\n" +
                    "            <ram:Name>ALL NIPPON AIRWAYS TRADING CO. LTD</ram:Name>\n" +
                    "            <ram:PostalStructuredAddress>\n" +
                    "                <ram:PostcodeCode>14400-441</ram:PostcodeCode>\n" +
                    "                <ram:StreetName>3-5-4 HANEDA AIRPORT</ram:StreetName>\n" +
                    "                <ram:CityName>OTA KU</ram:CityName>\n" +
                    "                <ram:CountryID>JP</ram:CountryID>\n" +
                    "            </ram:PostalStructuredAddress>\n" +
                    "        </ram:ConsigneeParty>\n" +
                    "        <ram:FreightForwarderParty>\n" +
                    "            <ram:Name>KUEHNE NAGEL PTE. LTD AIRPORT LOGIS</ram:Name>\n" +
                    "            <ram:CargoAgentID>3231713</ram:CargoAgentID>\n" +
                    "            <ram:FreightForwarderAddress>\n" +
                    "                <ram:CityName>SINGAPORE</ram:CityName>\n" +
                    "            </ram:FreightForwarderAddress>\n" +
                    "            <ram:SpecifiedCargoAgentLocation>\n" +
                    "                <ram:ID>0005</ram:ID>\n" +
                    "            </ram:SpecifiedCargoAgentLocation>\n" +
                    "        </ram:FreightForwarderParty>\n" +
                    "        <ram:OriginLocation>\n" +
                    "            <ram:ID>SIN</ram:ID>\n" +
                    "        </ram:OriginLocation>\n" +
                    "        <ram:FinalDestinationLocation>\n" +
                    "            <ram:ID>HND</ram:ID>\n" +
                    "        </ram:FinalDestinationLocation>\n" +
                    "        <ram:SpecifiedLogisticsTransportMovement>\n" +
                    "            <ram:StageCode />\n" +
                    "            <ram:ID>SQ632</ram:ID>\n" +
                    "            <ram:UsedLogisticsTransportMeans>\n" +
                    "                <ram:Name>SQ</ram:Name>\n" +
                    "            </ram:UsedLogisticsTransportMeans>\n" +
                    "            <ram:ArrivalEvent>\n" +
                    "                <ram:ScheduledOccurrenceDateTime>2024-04-23T00:00:00</ram:ScheduledOccurrenceDateTime>\n" +
                    "                <ram:OccurrenceArrivalLocation>\n" +
                    "                    <ram:ID>HND</ram:ID>\n" +
                    "                    <ram:Name>SQ</ram:Name>\n" +
                    "                </ram:OccurrenceArrivalLocation>\n" +
                    "            </ram:ArrivalEvent>\n" +
                    "            <ram:DepartureEvent>\n" +
                    "                <ram:ScheduledOccurrenceDateTime>2024-04-23T00:00:00</ram:ScheduledOccurrenceDateTime>\n" +
                    "            </ram:DepartureEvent>\n" +
                    "        </ram:SpecifiedLogisticsTransportMovement>\n" +
                    "        <ram:HandlingSPHInstructions>\n" +
                    "            <ram:DescriptionCode>ECC</ram:DescriptionCode>\n" +
                    "        </ram:HandlingSPHInstructions>\n" +
                    "        <ram:HandlingSPHInstructions>\n" +
                    "            <ram:DescriptionCode>NSC</ram:DescriptionCode>\n" +
                    "        </ram:HandlingSPHInstructions>\n" +
                    "        <ram:HandlingSPHInstructions>\n" +
                    "            <ram:DescriptionCode>EAP</ram:DescriptionCode>\n" +
                    "        </ram:HandlingSPHInstructions>\n" +
                    "        <ram:HandlingSSRInstructions>\n" +
                    "            <ram:Description>NSC CUSTOMER REFERENCE 100967680 ORC901246</ram:Description>\n" +
                    "        </ram:HandlingSSRInstructions>\n" +
                    "        <ram:IncludedAccountingNote>\n" +
                    "            <ram:ContentCode>GEN</ram:ContentCode>\n" +
                    "            <ram:Content>AA-TC</ram:Content>\n" +
                    "        </ram:IncludedAccountingNote>\n" +
                    "        <ram:IncludedCustomsNote>\n" +
                    "            <ram:ContentCode>RA</ram:ContentCode>\n" +
                    "            <ram:Content>RCA02012008</ram:Content>\n" +
                    "            <ram:SubjectCode>ISS</ram:SubjectCode>\n" +
                    "            <ram:CountryID>SG</ram:CountryID>\n" +
                    "        </ram:IncludedCustomsNote>\n" +
                    "        <ram:IncludedCustomsNote>\n" +
                    "            <ram:ContentCode>ED</ram:ContentCode>\n" +
                    "            <ram:Content>0624</ram:Content>\n" +
                    "        </ram:IncludedCustomsNote>\n" +
                    "        <ram:IncludedCustomsNote>\n" +
                    "            <ram:ContentCode>SD</ram:ContentCode>\n" +
                    "            <ram:Content>22APR241500</ram:Content>\n" +
                    "        </ram:IncludedCustomsNote>\n" +
                    "        <ram:IncludedCustomsNote>\n" +
                    "            <ram:ContentCode>SN</ram:ContentCode>\n" +
                    "            <ram:Content>THANESH.ARUMUGAM</ram:Content>\n" +
                    "        </ram:IncludedCustomsNote>\n" +
                    "        <ram:ApplicableOriginCurrencyExchange>\n" +
                    "            <ram:SourceCurrencyCode>SGD</ram:SourceCurrencyCode>\n" +
                    "        </ram:ApplicableOriginCurrencyExchange>\n" +
                    "        <ram:ApplicableLogisticsAllowanceCharge>\n" +
                    "            <ram:ID>CH</ram:ID>\n" +
                    "            <ram:PrepaidIndicator>true</ram:PrepaidIndicator>\n" +
                    "            <ram:PartyTypeCode>A</ram:PartyTypeCode>\n" +
                    "            <ram:ActualAmount currencyID=\"SGD\">150</ram:ActualAmount>\n" +
                    "        </ram:ApplicableLogisticsAllowanceCharge>\n" +
                    "        <ram:ApplicableLogisticsAllowanceCharge>\n" +
                    "            <ram:ID>MY</ram:ID>\n" +
                    "            <ram:PrepaidIndicator>true</ram:PrepaidIndicator>\n" +
                    "            <ram:PartyTypeCode>C</ram:PartyTypeCode>\n" +
                    "            <ram:ActualAmount currencyID=\"SGD\">10</ram:ActualAmount>\n" +
                    "        </ram:ApplicableLogisticsAllowanceCharge>\n" +
                    "        <ram:ApplicableRating>\n" +
                    "            <ram:TypeCode>F</ram:TypeCode>\n" +
                    "            <ram:IncludedMasterConsignmentItem>\n" +
                    "                <ram:SequenceNumeric>1</ram:SequenceNumeric>\n" +
                    "                <ram:GrossWeightMeasure unitCode=\"KGM\">1</ram:GrossWeightMeasure>\n" +
                    "                <ram:PieceQuantity>1</ram:PieceQuantity>\n" +
                    "                <ram:NatureIdentificationTransportCargo>\n" +
                    "                    <ram:Identification>CIVIL ARCRAFT PARTS </ram:Identification>\n" +
                    "                </ram:NatureIdentificationTransportCargo>\n" +
                    "                <ram:ApplicableFreightRateServiceCharge>\n" +
                    "                    <ram:CategoryCode>M</ram:CategoryCode>\n" +
                    "                    <ram:ChargeableWeightMeasure unitCode=\"KGM\">2</ram:ChargeableWeightMeasure>\n" +
                    "                    <ram:AppliedRate>87</ram:AppliedRate>\n" +
                    "                    <ram:AppliedAmount currencyID=\"SGD\">87</ram:AppliedAmount>\n" +
                    "                </ram:ApplicableFreightRateServiceCharge>\n" +
                    "            </ram:IncludedMasterConsignmentItem>\n" +
                    "            <ram:IncludedMasterConsignmentItem>\n" +
                    "                <ram:SequenceNumeric>2</ram:SequenceNumeric>\n" +
                    "                <ram:GrossVolumeMeasure unitCode=\"MTQ\">0.012</ram:GrossVolumeMeasure>\n" +
                    "            </ram:IncludedMasterConsignmentItem>\n" +
                    "            <ram:IncludedMasterConsignmentItem>\n" +
                    "                <ram:SequenceNumeric>3</ram:SequenceNumeric>\n" +
                    "                <ram:NatureIdentificationTransportCargo>\n" +
                    "                    <ram:Identification>REF 205670638M</ram:Identification>\n" +
                    "                </ram:NatureIdentificationTransportCargo>\n" +
                    "            </ram:IncludedMasterConsignmentItem>\n" +
                    "            <ram:IncludedMasterConsignmentItem>\n" +
                    "                <ram:SequenceNumeric>4</ram:SequenceNumeric>\n" +
                    "                <ram:TransportLogisticsPackage>\n" +
                    "                    <ram:ItemQuantity>1</ram:ItemQuantity>\n" +
                    "                    <ram:LinearSpatialDimension>\n" +
                    "                        <ram:WidthMeasure unitCode=\"CMT\">22</ram:WidthMeasure>\n" +
                    "                        <ram:LengthMeasure unitCode=\"CMT\">31</ram:LengthMeasure>\n" +
                    "                        <ram:HeightMeasure unitCode=\"CMT\">17</ram:HeightMeasure>\n" +
                    "                    </ram:LinearSpatialDimension>\n" +
                    "                </ram:TransportLogisticsPackage>\n" +
                    "            </ram:IncludedMasterConsignmentItem>\n" +
                    "        </ram:ApplicableRating>\n" +
                    "        <ram:ApplicableTotalRating>\n" +
                    "            <ram:TypeCode>F</ram:TypeCode>\n" +
                    "            <ram:ApplicablePrepaidCollectMonetarySummation>\n" +
                    "                <ram:PrepaidIndicator>true</ram:PrepaidIndicator>\n" +
                    "                <ram:WeightChargeTotalAmount currencyID=\"SGD\">87</ram:WeightChargeTotalAmount>\n" +
                    "                <ram:AgentTotalDuePayableAmount currencyID=\"SGD\">150</ram:AgentTotalDuePayableAmount>\n" +
                    "                <ram:CarrierTotalDuePayableAmount currencyID=\"SGD\">10.00</ram:CarrierTotalDuePayableAmount>\n" +
                    "                <ram:GrandTotalAmount currencyID=\"SGD\">247</ram:GrandTotalAmount>\n" +
                    "            </ram:ApplicablePrepaidCollectMonetarySummation>\n" +
                    "        </ram:ApplicableTotalRating>\n" +
                    "    </rsm:MasterConsignment>\n" +
                    "</rsm:Waybill>";
}
