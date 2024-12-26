@api-si
Feature: Standing Instruction

  ##USING CUBE ID 2
  @SI-API-1 @done
  Scenario: User unable to create SI when the service has Active future payment delegation
    Given User login as card admin or card user or user from company 2
    And company has Active future payment delegation for service A
    When user create SI for service A with status code 400
    Then error message can't create SI when has payment delegation appears

  @SI-API-3 @done
  Scenario: User able to create SI of any services from any companies
    Given User login as card admin or card user or user
    When user create SI for service A of company X
    Then able to create SI of service A of company X
    When user create SI for service A of company Y
    Then able to create SI of service A of company Y

  @SI-API-4 @done
  Scenario: User unable to create SI of same services in any companies
    Given User login as card admin or card user or user
    And user has SI of service A for company X
    When user create SI of service A in company X
    Then unable to create SI of same service in company X

  @SI-01 @done
  Scenario Outline: User able to retrieve SI
    Given User login as card admin or card user or user
    When user retrieve "<type>" of standing instruction
    Then success retrieve standing instruction
    Examples:
    | type |
    | RECEIVED_PAYMENT |
    | MY_PAYMENT |

  @card-number @done
  Scenario: Success retrieve card of payment
    Given User login as card admin or card user or user
    When user retrieve card detail with isDetail "false"
    Then there is no 4 last card number
    When user retrieve card detail with isDetail "true"
    Then card number success retrieve
    When user retrieve card detail with isDetail ""
    Then there is no 4 last card number

  @card-details @failed
  Scenario: Retrieve card detail with user card
    Given User login as user with a card in the company
    When user retrieve card detail with isDetail "false"
    Then there is message that the user should contact the card admin

  ##USING CUBE ID 1
  @SI-API-2 @done
  Scenario: User able to create SI when the service doesn't has Active future payment delegation
    Given User login as card admin or card user or user
    And company doesn't has Active future payment delegation for service A
    When user create SI for service A with status code 200
    Then SI for service A successfully created