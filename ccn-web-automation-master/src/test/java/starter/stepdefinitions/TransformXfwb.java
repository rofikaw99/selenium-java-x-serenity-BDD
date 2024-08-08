package starter.stepdefinitions;

import com.ibm.icu.impl.StringRange;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.api.TransformXfwbPage;
import starter.utlis.XFWBRequest;

import java.io.IOException;
import java.util.Map;

public class TransformXfwb {

    @Steps
    TransformXfwbPage transformXfwbPage;

    @Given("user transform xfwb")
    public void userTransformXfwb() throws IOException {
        transformXfwbPage.transformXfwb();
    }

    @Then("verify mapping data of {string} {string} {string} to data in response of Waybill {string}")
    public void verifyMappingDataOfToDataInResponseOfWaybill(String value, String child, String child2, String mapping) {
        transformXfwbPage.verifyMappingBusinessHeader(mapping);
    }

    @Then("verify mapping data of {string} to data in response of Waybill {string}")
    public void verifyMappingDataOfToDataInResponseOfWaybill(String value, String mapping) {
        transformXfwbPage.verifyMappingMasterConsignment(mapping);
    }

    @Then("verify mapping data {string} {string} of ConsignorParty to data in response of Waybill {string}")
    public void verifyMappingDataOfConsignorPartyToDataInResponseOfWaybill(String value, String child, String mapping) {
        transformXfwbPage.verifyConsignorMappingParty(mapping);
    }

    @Then("verify mapping data {string} {string} of ConsigneeParty to data in response of Waybill {string}")
    public void verifyMappingDataOfConsigneePartyToDataInResponseOfWaybill(String value, String child, String mapping) {
        transformXfwbPage.verifyConsigneeMappingParty(mapping);
    }

    @Then("verify mapping data {string} {string} of FreightForwarderParty to data in response of Waybill {string}")
    public void verifyMappingDataOfFreightForwarderPartyToDataInResponseOfWaybill(String arg0, String arg1, String mapping) {
        transformXfwbPage.verifyFreightForwarderMappingParty(mapping);
    }

    @Then("verify mapping data {string} of OriginLocation to data in response of Waybill {string}")
    public void verifyMappingDataOfOriginLocationToDataInResponseOfWaybill(String arg0, String mapping) {
        transformXfwbPage.verifyOriginLocationMapping(mapping);
    }

    @Then("verify mapping data {string} of FinalDestinationLocation to data in response of Waybill {string}")
    public void verifyMappingDataOfFinalDestinationLocationToDataInResponseOfWaybill(String arg0, String mapping) {
        transformXfwbPage.verifyFinalDestinationLocationMapping(mapping);
    }
    @Then("verify mapping data {string} {string} {string} of SpecifiedLogisticsTransportMovement to data in response of Waybill {string}")
    public void verifyMappingDataOfSpecifiedLogisticsTransportMovementToDataInResponseOfWaybill(String keyRequest, String arg1, String arg2, String keyResponse) {
        transformXfwbPage.verifySpecifiedLogisticsTransportMovementMapping(keyRequest, keyResponse);
    }
    @Then("verify mapping data {string} of HandlingSPHInstructions to data in response of Waybill {string}")
    public void verifyMappingDataOfHandlingSPHInstructionsToDataInResponseOfWaybill(String arg0, String mapping) {
        transformXfwbPage.verifyHandlingSPHInstructions(mapping);
    }
    @Then("verify mapping data {string} of HandlingSSRInstructions to data in response of Waybill {string}")
    public void verifyMappingDataOfHandlingSSRInstructionsToDataInResponseOfWaybill(String arg0, String mapping) {
        transformXfwbPage.verifyTextualHandlingInstructions("SSR", mapping);
    }
    @Then("verify mapping data {string} of IncludedAccountingNote to data in response of Waybill {string}")
    public void verifyMappingDataOfIncludedAccountingNoteToDataInResponseOfWaybill(String arg0, String mapping) {
        transformXfwbPage.verifyAccountingInformationMapping(mapping);
    }

    @Then("verify mapping data {string} of IncludedCustomsNote to data in response of Waybill {string}")
    public void verifyMappingDataOfIncludedCustomsNoteToDataInResponseOfWaybill(String arg0, String mapping) {
        transformXfwbPage.verifyCustomsInformationMapping(mapping);
    }

    @Then("verify mapping data {string} of ApplicableLogisticsAllowanceCharge to data in response of Waybill {string}")
    public void verifyMappingDataOfApplicableLogisticsAllowanceChargeToDataInResponseOfWaybill(String arg0, String mapping) {
        transformXfwbPage.verifyApplicableLogisticsAllowanceChargeMapping(mapping);
    }

    @Then("verify mapping data {string} {string} {string} of IncludedMasterConsignmentItem to data in response of Waybill {string}")
    public void verifyMappingDataOfIncludedMasterConsignmentItemToDataInResponseOfWaybill(String keyRequest, String childReq, String arg2, String keyResponse) {
        transformXfwbPage.verifyIncludedMasterConsignmentItemMapping(keyRequest, childReq, keyResponse);
    }
}
