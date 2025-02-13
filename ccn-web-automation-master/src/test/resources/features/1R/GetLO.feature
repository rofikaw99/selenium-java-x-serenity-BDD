@lo @xfwb @get-lo
Feature: Get Logistics Objects

  @get-lo-0
  Scenario: Success get logistics objects using external url
    Given user login SSO for one record
    And user transform xfwb
    And Create logistic objects using predefined json and "external" url
    When get logistic objects using ID of response
    Then success get detail of logistic object
    And verify the id of body is equals with the request data

  @get-lo-1
  Scenario Outline: Success get logistics objects with predefined key and using internal url
    Given user login SSO for one record
    And user transform xfwb
    And Create logistic objects using predefined json and "internal" url
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

  @get-lo-1.1 @run
  Scenario Outline: Success get logistics objects with predefined key and using external url
    Given user login SSO for one record
    And user transform xfwb
    And Create logistic objects using predefined json and "external" url
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

  @get-lo-2
  Scenario: Success get logistics objects using LO_ID and internal url
    Given user login SSO for one record
    And user transform xfwb
    And Create logistic objects using predefined json and "internal" url
    When get logistic objects using LO_ID
    Then success get detail of logistic object
    And verify the id of body is equals with the request data

  @get-lo-3
  Scenario: Success get logistics objects using waybillNumber and internal url
    Given user login SSO for one record
    And user transform xfwb
    And Create logistic objects using predefined json and "internal" url
    When get logistic objects using waybillNumber
    Then success get detail of logistic object
    And verify the waybillNumber is equals with the request data

  @get-lo-4
  Scenario: Success get logistics objects using waybillPrefix and internal url
    Given user login SSO for one record
    And user transform xfwb
    And Create logistic objects using predefined json and "internal" url
    When get logistic objects using waybillPrefix
    Then success get detail of logistic object
    And verify the waybillPrefix is equals with the request data