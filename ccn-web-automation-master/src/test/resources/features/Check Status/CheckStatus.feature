@check-status
Feature: Check Status

  Scenario: Success check status with type of service id is Service
    Given user get SSO token for check status
    And user get service id "Service" with reference ID
    Then success get detail of service id

#  @failed-check-status
#  Scenario: Failed check status source service id come from pair service type service with service
#    Given user get SSO token for check status
#    And user get service id "Pairing with Service" with reference ID
#    Then failed with 401 get detail of service id