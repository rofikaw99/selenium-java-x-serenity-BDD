@xfwb
Feature: Create LO

  @create-lo
  Scenario: Success create logistic objects
    Given user transform xfwb
    When Create logistic objects using predefined json
    Then Success create
    And Verify there is id of LO in body response
    And verify the type value is "cargo:Waybill"