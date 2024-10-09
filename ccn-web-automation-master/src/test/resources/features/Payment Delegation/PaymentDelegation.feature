Feature: Payment Delegation

Feature: Delegated To

  @PD-API-1 @done
  Scenario: Card Admin able to view all payment delegation request in Delegated To tab
    Given "Card Admin" login to the api
    When go to Payment Delegation menu tab "Delegated To"
    Then "card admin" can view all payment delegation request

  @PD-API-2 @done
  Scenario: Card User able to view all payment delegation request in Delegated To tab
    Given "Card User" login to the api
    When go to Payment Delegation menu tab "Delegated To"
    Then "card user" can view all payment delegation request

  @PD-API-49 @done
  Scenario: User able to view subscribed product payment delegation request in Delegated To tab
    Given "User" login to the api
    When go to Payment Delegation menu tab "Delegated To"
    And user that subscribe into the product or service can view their own payment delegation request of the product or service

  @PD-API-3 @done
  Scenario: User able to view all the required payment delegation request data
    Given "Card Admin" login to the api
    When go to Payment Delegation menu tab "Delegated To"
    Then user view all the required data: delegated to, product, supplier, active date, payment authorization, status

  @PD-API-51 @done
  Scenario: User able to sort payment delegation request data in all column
    Given "Card User" login to the api
    And go to Payment Delegation menu tab "Delegated To"
    When sort payment delegation data based on "Delegated To" column in "Delegated To" tab
    Then the data will be sorted asc or desc based on the "Delegated To"
    When sort payment delegation data based on "Product / Service" column in "Delegated To" tab
    Then the data will be sorted asc or desc based on the "Product / Service"
    When sort payment delegation data based on "Supplier" column in "Delegated To" tab
    Then the data will be sorted asc or desc based on the "Supplier"
#    When sort payment delegation data based on "Active Date" column in "Delegated To" tab
#    Then the data will be sorted asc or desc based on the "Active Date"
    When sort payment delegation data based on "Payment Authorization" column in "Delegated To" tab
    Then the data will be sorted asc or desc based on the "Payment Authorization"
    When sort payment delegation data based on "Status" column in "Delegated To" tab
    Then the data will be sorted asc or desc based on the "Status"

  @PD-52-API @done
  Scenario: User able to change the pagination of payment delegation request data
    Given "Card Admin" login to the api
    And go to Payment Delegation menu tab "Delegated To"
    When change the page to page 2
    Then page will change to page 2
    When change the results per page value to 30
    Then number of data appears to 30 on the selected value
    When go to previous page
    Then page will change to page 1

  @PD-API-10 @done
  Scenario: User able delete payment delegation request with Active status and future payment type
    Given "Card Admin" login to the api
    And go to Payment Delegation menu tab "Delegated To"
    When user delete Active payment delegation request with future payment type (note: user only can delete the product that they subscribe)
    Then the selected payment delegation request status will be deleted from the row data
#    And the payment will not being delegated to the delegated company in the future
#    And the previous payment that has been delegated to company X still can be accessed in company X

  @PD-API-6 @done
  Scenario: User able to create new payment delegation request with valid data
    Given "Card Admin" login to the api
    And go to Payment Delegation menu tab "Delegated To"
    When create new payment delegation request with valid data
    Then new payment request appears in list of data
    And the value of status is "ACTIVE"
    And the value of Payment Authorization is "FUTURE_PAYMENT"
    And the value of Active Date is today

  @PD-API-7 @done
  Scenario: User unable to create new payment delegation request with invalid data
    Given "Card Admin" login to the api
    And go to Payment Delegation menu tab "Delegated To"
    When input fill blank in all of fields in add payment delegation form
    Then the Request button will be disabled

  @PD-API-13 @failed
  Scenario: User unable to create new payment delegation request with same product/service that has Active / Pending status
    Given "Card Admin" login to the api
    And go to Payment Delegation menu tab "Delegated To"
    And there is payment delegation request of product or service A with Active status
    When create new payment delegation request with product or service A
    Then unable create same product or service in payment delegation request

  @PD-API-14
  Scenario: User unable to create new payment delegation when there is SI of the product / service
    Given "Card Admin" login to the api
    And go to Payment Delegation menu tab "Delegated To"
    And there is standing instruction with product or service A
    When create new payment delegation request with product or service A for error message
    Then error message can't create payment delegation appears