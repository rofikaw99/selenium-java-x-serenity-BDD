@DLG-API
Feature: Payment Delegation API

  @create-delegation @delegation
  Scenario: Create Payment Delegation
    Given get all suppliers
    When request create payment delegation
    Then success request api
    And verify success create

  @retrieve-delegation @delegation
  Scenario: Retrieve Payment Delegation
    When request retrieve payment delegation
    Then success request api
    And verify the data

  @delete-delegation @delegation
  Scenario: Delete Payment Delegation
    Given request retrieve payment delegation
    When delete payment delegation
    Then success request api
    And verify success delete

  @retrieve-si
  Scenario: Retrieve My Payment Standing Instruction
    When request retrieve "MY_PAYMENT" standing instruction
    Then success request api
    And verify success retrieve si

  @retrieve-si
  Scenario: Retrieve Received Payment Standing Instruction
    When request retrieve "RECEIVED_PAYMENT" standing instruction
    Then success request api
    And verify success retrieve si

  @create-si
  Scenario: Create My Payment Standing Instruction
    Given get all suppliers
    And retrieve card token
    When create "MY_PAYMENT" standing instruction
    Then success request api
    And verify success create "MY_PAYMENT" SI

  @create-si
  Scenario: Create Received Payment Standing Instruction
    Given get all suppliers
    And retrieve card token
    When create "RECEIVED_PAYMENT" standing instruction
    Then success request api
    And verify success create "RECEIVED_PAYMENT" SI

  @update-si-api
  Scenario: Update My Payment Standing Instruction
    Given request retrieve "MY_PAYMENT" standing instruction
    And get all suppliers
    And retrieve card token
    When update "MY_PAYMENT" standing instruction
    Then success request api
    And verify success update si

  @update-si-api
  Scenario: Update Received Payment Standing Instruction
    Given request retrieve "RECEIVED_PAYMENT" standing instruction
    And get all suppliers
    And retrieve card token
    When update "RECEIVED_PAYMENT" standing instruction
    Then success request api
    And verify success update si

  @delete-si-api.1
  Scenario: Delete My Payment Standing Instruction
    Given request retrieve "MY_PAYMENT" standing instruction
    When delete "MY_PAYMENT" standing instruction
    Then success request api
    And verify success delete "MY_PAYMENT" si

  @delete-si-api
  Scenario: Delete Received Payment Standing Instruction
    Given request retrieve "RECEIVED_PAYMENT" standing instruction
    When delete "RECEIVED_PAYMENT" standing instruction
    Then success request api
    And verify success delete "RECEIVED_PAYMENT" si

  @create-payment-req.1
  Scenario: Success Create Payment Request 1
    When create payment request
    Then success request api
    And verify success create payment request

  @create-payment-req
  Scenario: Success Create Payment Request
    When create payment request
    Then success request api
    And verify success create payment request

  @create-payment-req-tdsb
  Scenario: Success Create Payment Request TDSB
    When create payment request tdsb
    Then success request api
    And verify success create payment request

  @retrieve-overview
  Scenario: Retrieve My Payment Overview
    When request retrieve "MY_PAYMENT" payment overview
    Then success request api
    And verify success retrieve payment overview

  @retrieve-overview.2
  Scenario: Retrieve Delegated Payment Overview from Delegated Company
    When request retrieve "DELEGATED_PAYMENT" payment overview
    Then success request api
    And verify success retrieve payment overview with delegated payment

  @delegate-payment
  Scenario: Delegate Payment Request
    Given create payment request
    When delegate specific payment request to other company
    Then success request api
    And verify success retrieve payment overview in company owner
    And verify success delegated payment to other company

  @delegate-payment.2
  Scenario: Auto Delegate Payment Request to Another Company
    Given there is payment delegation request of product X to company "A"
    When create payment request of product X in company "B"
    Then success request api
    And verify success delegated payment to company "A"

  @integrate-si
  Scenario: Success auto-deduct payment in my payment
    Given there is active SI for supplier
    When create payment request for auto-deduct
    And verify success create payment request
    Then payment success being auto-deduct

  @integrate-si.2
  Scenario: Success auto-deduct payment in delegated payment
    Given there is active SI for supplier X in RECEIVED_PAYMENT of company A
    And there is delegated payment setting of supplier X in company B to company A
    When create payment request of supplier X in company B
    And verify success create payment request in company B
    Then payment success being auto-deduct