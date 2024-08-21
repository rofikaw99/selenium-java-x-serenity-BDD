@xfwb @get-logistic-object
Feature: Get Logistics Objects

  @get-lo
  Scenario: Success get logistics objects
    Given Create logistic objects using predefined json
    When get logistic objects using ID of response
    Then success get detail of logistic object
    And verify the id of body is equals with the request data

  @get-lo-1
  Scenario Outline: Success get logistics objects with predefined key
    Given Create logistic objects using predefined json
    When get logistic objects using ID of response
    Then success get detail of logistic object
    Then verify mapping data of "<mapping>" to API response
    Examples:
      | mapping |
      | accountingInformation |
      | carrierDeclarationDate |
      | carrierDeclarationSignature |
      | consignorDeclarationSignature  |
      | waybillPrefix |
      | waybillNumber |