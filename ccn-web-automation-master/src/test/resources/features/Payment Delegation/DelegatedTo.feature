Feature: Delegated To

  @PD-1 @done
  Scenario: Card Admin able to view all payment delegation request in Delegated To tab
    Given "Card Admin" login to the web
    When go to Payment Delegation menu tab "Delegated To"
    Then "card admin" can view all payment delegation request

  @PD-2 @done
  Scenario: Card User able to view all payment delegation request in Delegated To tab
    Given "Card User" login to the web
    When go to Payment Delegation menu tab "Delegated To"
    Then "card user" can view all payment delegation request

  @PD-49
  Scenario: User able to view subscribed product payment delegation request in Delegated To tab
    Given "User" login to the web
    When go to Payment Delegation menu tab "Delegated To"
    And user that subscribe into the product or service can view their own payment delegation request of the product or service

  @PD-3 @done
  Scenario: User able to view all the required payment delegation request data
    Given "Card Admin" login to the web
    When go to Payment Delegation menu tab "Delegated To"
    Then user view all the required data: delegated to, product, supplier, request date, active date, payment authorization, status

  @PD-51
  Scenario: User able to sort payment delegation request data in all column
    Given "Card User" login to the web
    And go to Payment Delegation menu tab "Delegated To"
    When sort payment delegation data based on "Delegated To" column in "Delegated To" tab
    Then the data will be sorted asc or desc based on the "Delegated To"
    When sort payment delegation data based on "Product / Service" column in "Delegated To" tab
    Then the data will be sorted asc or desc based on the "Product / Service"
    When sort payment delegation data based on "Supplier" column in "Delegated To" tab
    Then the data will be sorted asc or desc based on the "Supplier"
    When sort payment delegation data based on "Request Date" column in "Delegated To" tab
    Then the data will be sorted asc or desc based on the "Request Date"
    When sort payment delegation data based on "Active Date" column in "Delegated To" tab
    Then the data will be sorted asc or desc based on the "Active Date"
    When sort payment delegation data based on "Payment Authorization" column in "Delegated To" tab
    Then the data will be sorted asc or desc based on the "Payment Authorization"
    When sort payment delegation data based on "Status" column in "Delegated To" tab
    Then the data will be sorted asc or desc based on the "Status"

  @PD-52
  Scenario: User able to change the pagination of payment delegation request data
    Given "Card Admin" login to the web
    And go to Payment Delegation menu tab "Delegated To"
    When change the page to page 2
    Then page will change to page 2
    When change the results per page value
    Then number of data appears based on the selected value
    When go to previous page
    Then page will change to page 1
    When go to next page
    Then page will change to page 2

  @PD-9
  Scenario: User able to delete payment delegation request with Pending status
    Given "Card User" login to the web
    And go to Payment Delegation menu tab "Delegated To"
    When user delete Pending payment delegation request for future payment type
    Then the selected payment delegation request status will be Deleted
    And the payment delegation request will disappear in the delegated company data

  @PD-11
  Scenario: User unable to delete payment delegation request with Active, Rejected, and Cancelled status
    Given "Card Admin" login to the web
    And go to Payment Delegation menu tab "Delegated To"
    When user delete Active, Rejected or Cancelled payment delegation request with future payment type
    Then there is no delete button for these statuses

  @PD-10
  Scenario: User able cancel payment delegation request with Active status and future payment type
    Given "Card Admin" login to the web
    And go to Payment Delegation menu tab "Delegated To"
    When user cancel Active payment delegation request with future payment type (note: user only can delete the product that they subscribe)
    Then payment delegation request status changes to "CANCELLED"
    And the payment will not being delegated to the delegated company in the future

  @PD-6 @done
  Scenario: User able to create new payment delegation request with valid data
    Given "Card Admin" login to the web
    And go to Payment Delegation menu tab "Delegated To"
    When create new payment delegation request with valid data
    Then new payment request appears in list of data
    And the value of status is "PENDING"
    And the value of Payment Authorization is "Future Payments"
    And the value of Request Date is today
    And the value of Active Date is null

  @PD-7 @done
  Scenario: User unable to create new payment delegation request with invalid data
    Given "Card Admin" login to the web
    And go to Payment Delegation menu tab "Delegated To"
    When input fill blank in all of fields in add payment delegation form
    Then the Request button will be disabled

  @PD-13
  Scenario: User unable to create new payment delegation request with same product/service that has Active / Pending status
    Given "Card Admin" login to the web
    And go to Payment Delegation menu tab "Delegated To"
    And there is payment delegation request of product or service A with Active or Pending status
    When create new payment delegation request with product or service A
    Then product or service A disappear from the field of create form

  @PD-14
  Scenario: User unable to create new payment delegation when there is SI of the product / service
    Given "Card Admin" login to the web
    And go to Payment Delegation menu tab "Delegated To"
    And there is standing instruction with product or service A
    When create new payment delegation request with product or service A for error message
    Then error message can't create payment delegation appears