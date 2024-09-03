Feature: Delegated To

  @PD-15-1
  Scenario: Card Admin able to view all payment delegation request in Delegated From tab
    Given "Card Admin" login to the web
    When go to Payment Delegation menu tab "Delegated From"
    Then "card admin" can view all payment delegation request

  @PD-15-2
  Scenario: Card User able to view all payment delegation request in Delegated From tab
    Given "Card User" login to the web
    When go to Payment Delegation menu tab "Delegated From"
    Then "card user" can view all payment delegation request

  @PD-15-3
  Scenario: User able to view subscribed product payment delegation request in Delegated From tab
    Given "User" login to the web
    When go to Payment Delegation menu tab "Delegated From"
    And user that subscribe into the product or service can view their own payment delegation request of the product or service

  @PD-16
  Scenario: User able to view all the required payment delegation request data
    Given "Card Admin" login to the web
    When go to Payment Delegation menu tab "Delegated From"
    Then user view all the required data: delegated from, product, supplier, request date, active date, payment authorization, status

  @PD-58
  Scenario: User able to change the pagination of payment delegation request data
    Given "Card Admin" login to the web
    And go to Payment Delegation menu tab "Delegated From"
    When change the page to page 2
    Then page will change to page 2
    When change the results per page value
    Then number of data appears based on the selected value
    When go to previous page
    Then page will change to page 1
    When go to next page
    Then page will change to page 2

  @PD-57
  Scenario: User able to sort payment delegation request data in all column
    Given "Card Admin" login to the web
    And go to Payment Delegation menu tab "Delegated From"
    When sort payment delegation data based on "Delegated From" column in "Delegated From" tab
    Then the data will be sorted asc or desc based on the "Delegated From"
    When sort payment delegation data based on "Product / Service" column in "Delegated From" tab
    Then the data will be sorted asc or desc based on the "Product / Service"
    When sort payment delegation data based on "Supplier" column in "Delegated From" tab
    Then the data will be sorted asc or desc based on the "Supplier"
    When sort payment delegation data based on "Request Date" column in "Delegated From" tab
    Then the data will be sorted asc or desc based on the "Request Date"
    When sort payment delegation data based on "Active Date" column in "Delegated From" tab
    Then the data will be sorted asc or desc based on the "Active Date"
    When sort payment delegation data based on "Payment Authorization" column in "Delegated From" tab
    Then the data will be sorted asc or desc based on the "Payment Authorization"
    When sort payment delegation data based on "Status" column in "Delegated From" tab
    Then the data will be sorted asc or desc based on the "Status"

  @PD-21
  Scenario: User able to approve Pending payment delegation request for future payment
    Given "Card Admin" login to the web
    And go to Payment Delegation menu tab "Delegated From"
    When approve payment delegation request which have Pending status and "future" payments
    Then payment delegation request status changes to "Active"
    And value of Active Date is today
    And all future payment of the payment owner will appears in Delegated Payment tab
    And the previous Active date payment will not being sent to delegated company

  @PD-22
  Scenario: User able to reject Pending payment delegation request for future payment
    Given "Card Admin" login to the web
    And go to Payment Delegation menu tab "Delegated From"
    When reject payment delegation request which have Pending status and "future" payments
    Then payment delegation request status changes to "Rejected"

  @PD-23
  Scenario: User able cancel payment delegation request with Active status and future payment type
    Given "Card Admin" login to the web
    And go to Payment Delegation menu tab "Delegated From"
    When user cancel Active payment delegation request with future payment type
    Then payment delegation request status changes to "Cancelled"
    And the future payment of delegatee payment doesnt appear in the company
    And the previous payment of delegatee payment still appear and the payment detail can be accessed in the company

  @PD-59
  Scenario: User cancel Active future payment delegation request that SI has been setup in company
    Given "Card Admin" login to the web
    And user has Active future payment delegation of service A from other company
    And user has setup SI for service A
    When user cancel the payment delegation of service A
    Then payment delegation request status changes to Cancelled
    And SI will be deleted from the company
    And other company able to setup SI for service A