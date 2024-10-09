Feature: Standing Instruction

  @PD-API-25
  Scenario: User unable to create SI when the service has Active future payment delegation
    Given User login as card admin or card user or user
    And company has Active future payment delegation for service A
    When user create SI for service A
    Then error message can't create SI when has payment delegation appears

  Scenario: User able to create SI when the service doesn't has Active future payment delegation
    Given User login as card admin or card user or user
    And company doesn't has Active future payment delegation for service A
    When user create SI for service A
    Then SI for service A successfully created

  @PD-API-30 @done
  Scenario: User able to create SI of any services from any companies
    Given User login as card admin or card user or user
    When user create SI for service A of company X
    Then able to create SI of service A of company X
    When user create SI for service A of company Y
    Then able to create SI of service A of company Y

  @PD-API-31
  Scenario: User unable to create SI of same services in any companies
    Given User login as card admin or card user or user
    And user has SI of service A for company X
    When user create SI of service A in company X
    Then unable to create SI of same service in company X
