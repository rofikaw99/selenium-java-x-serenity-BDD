@po-api
Feature: Payment Overview

  @PO-API-1 @done
  Scenario Outline: User able to view the detail payment of Outstanding, Upcoming, Paid, and Expired status in My Payment
    Given user login as card admin or card user or user
    When user view detail of "MY_PAYMENT" with status: "<status>"
    Then payment detail page with selected id appears
    Examples:
    | status |
    | Upcoming       |
    | Outstanding |
    | Paid       |
    | Expired       |

  @PO-API-2 @done
  Scenario Outline: User able to pay my payment of Outstanding, Upcoming status
    Given user login as card admin or card user or user
    When user pay <number> of Outstanding my payments
    Then payment status changes to "PAID" in My Payment tab menu
    Examples:
    |number|
#    | 1    |
    |   5  |

  @PO-API-3 @done
  Scenario Outline: User able to pay Outstanding payment that has been delegated
    Given user login as card admin or card user or user
    When user pay <number> of Outstanding my payments that has been delegated to other company
    Then payment status changes to "PAID" in My Payment tab menu
    And payment status changes to "PAID" in delegated payment
    Examples:
      |number|
      | 1    |
      | 2    |

  @PO-API-4 @done
  Scenario: My payment successfully auto-deducted when SI for the product has been setup in the company
    Given user login as card admin or card user
    And there is SI for service A in the company
    When there is payment for service A
    Then payment has been Paid
    And the payment by will be "auto_deduct" and autoDeduct is "true"

  @PO-API-5 @done
  Scenario: User able to delegate the specific company payment
    Given user login as card admin or card user
    And there is no Active payment delegation for service A
    And there is Outstanding or Upcoming payment request of service A
    When user delegate the specific payment request to company X
    Then the payment will be delegated to company X (will appears in the Received Payment menu)
    And company X able to pay the payment

    ##USING COMPANY 2
  @PO-API-6 @done
  Scenario: User able to re-assigned Active future payment delegation of specific company payment
    Given user login as card admin or card user from company 2
    And there is Active future payment delegation for service A to company X
    And there is payment Z for service A with Outstanding and Upcoming status
    Then value of Delegated To is company X
    And payment request Z sent to company 1 with Outstanding or Upcoming status
    When user delegate payment Z of service A to company Y
    Then value of Delegated To changes to company Y
    And payment request Z sent to company 3 with Outstanding or Upcoming status
    And payment request Z status in company 1 changes to Withdrawn

#DELEGATED PAYMENT
  @PO-API-7 @done
  Scenario Outline: User able to view the detail payment of Outstanding, Upcoming, Paid, and Expired status in Delegated Payment
    Given user login as card admin or card user or user
    When user view detail of "DELEGATED_PAYMENT" with status: "<status>"
    Then payment detail page with selected id appears
    Examples:
      | status |
      | Upcoming       |
      | Outstanding     |
      | Paid       |
      | Expired       |

  @PO-API-8 @done
  Scenario: User unable to view the detail payment of Withdrawn status
    Given user login as card admin or card user
    When user view detail of delegated payment with status: Withdrawn
    Then payment id disabled

  @PO-API-9 @done
  Scenario Outline: User able to pay the delegated payment of Outstanding, Upcoming status
    Given user login as card admin or card user or user
    When user pay <number> of Outstanding delegated payments
    Then payment status changes to "PAID" in Delegated Payment tab menu
    And payment status changes to "PAID" in My Payment of delegatee company
    Examples:
    | number |
    | 1      |
    | 2      |

  @PO-API-10 @done
  Scenario: User unable to pay the delegated payment of Withdraw status
    Given user login as card admin or card user or user
    When user checkout 1 of "WITHDRAW" delegated payments
    Then there is no checkout button

  @PO-API-11 @failed
  Scenario: Delegated payment successfully auto-deducted when SI has been setup in the company
    Given user login as card admin or card user from company 2
    And payment delegation request for service A from company X to company Y has Active status
    And there is SI for service A in company Y
    When there is payment for service A from company 2
    Then payment for service A of company X will be auto-deducted in company Y
    And payment will automatically changes to "PAID"

  @PO-API-11.1 @failed
  Scenario: Delegated payment successfully auto-deducted in 2 minutes when SI has been setup in the company
    Given user login as card admin or card user from company 2
    And payment delegation request for service A from company X to company Y has Active status
    And there is SI for service A in company Y
    When there is payment for service A from company 2 with deductionTime in 2 minutes
    Then payment will automatically changes to "OUTSTANDING"
    And in 2 minutes later
    And payment for service A of company X will be auto-deducted in company Y
    And payment will automatically changes to "PAID"

  @PO-API-12 @done
  Scenario: User able to remove delegated payment from specific company
    Given user login as card admin or card user from company 2
    And payment delegation request for service A from company X to company Y has Active status
    When there is payment for service A from company 2
    And value of Delegated To is company X
    And company 1 remove payment delegation of that payment
    Then payment will be deleted from company 1
    And value of Delegated To changes to null in company 2

    @PO-API-14
    Scenario Outline: User able to search filter "MY PAYMENT" based on selected criteria
      Given user login as card admin or card user or user
      When search payment with filter "<name>" in "MY_PAYMENT" tab
      Then payment that contains the keyword and matches filter "<name>" will appears
      Examples:
      | name |
      | reference |
      | productName |
      | delegateTo |
#      | chargeDateTime |
#      | dueDate |
      | paymentMethod |
      | total |
      | status |

  @PO-API-15
  Scenario Outline: User able to search filter "MY PAYMENT" based on selected criteria
    Given user login as card admin or card user or user
    When search payment with filter "<name>" in "DELEGATED_PAYMENT" tab
    Then payment that contains the keyword and matches filter "<name>" will appears
    Examples:
      | name |
      | reference |
      | productName |
      | delegateFrom |
#      | chargeDateTime |
#      | dueDate |
      | paymentMethod |
      | total |
      | status |

  @pay-record.1 @done
  Scenario: Success add payment record to specific payment
    Given supplier create payment request to a user
    When payment has been Paid
#    When user pay the payment request
    And supplier add payment record to the payment
    Then success add payment record
    And verify the record appears in report excel merchant

  @pay-record.2 @done
  Scenario: Failed add payment record to specific payment
    Given supplier create payment request to a user
    When payment has been Paid
    And supplier add payment record to the payment with string value
    Then failed add payment record

  @deduct-date.1.1 @done
  Scenario: Success deduct payment based on deductionDate which is 2 minutes later
    Given user has SI for service A
    When supplier create payment request with deductionDate in 2 minutes
    Then payment will automatically changes to "OUTSTANDING"
    And the payment by will be "" and autoDeduct is "false"
    And in 2 minutes later
    Then payment will automatically changes to "PAID"
    And the payment by will be "auto_deduct" and autoDeduct is "true"

  @deduct-date.1 @done
  Scenario: Immediately deduct payment when deductionDate is not set
    Given user has SI for service A
    When supplier create payment request without deductionDate
    Then payment will immediately changes to PAID
    And the payment by will be "auto_deduct" and autoDeduct is "true"

  @deduct-date.1 @done
  Scenario: Deduction does not work when SI not achieved
    Given user has SI for service A
    When supplier create payment request with amount greater than SI
    Then payment will remain in "OUTSTANDING" status
    And the payment by will be "" and autoDeduct is "false"

  @expired-date @exp-date.1 @failed
  Scenario: Success set expired date of payment for 2 minutes later
    When supplier create payment request with expired date in 2 minutes
    Then payment will automatically changes to "OUTSTANDING"
    And in 2 minutes later
    And payment will automatically changes to "EXPIRED"

  @expired-date.4 @exp-date
  Scenario: Success verify the expired date is in 21 days if the field is not set
    When supplier create payment request without expired date
    Then payment will changes to Expired in 21 days

  @update-pay.1 @update-pay @done
  Scenario: Success update payment to ready
    Given supplier create payment request for "Upcoming" status
    When supplier update payment request to "READY" status
    Then payment will automatically changes to "OUTSTANDING"

  @update-pay.2 @update-pay @done
  Scenario: Success update payment to ready with achieved SI
    Given supplier create payment request for "Upcoming" status and achieved amount SI
    When supplier update payment request to "READY" status
    Then payment will automatically changes to "PAID"
    And the payment by will be "auto_deduct" and autoDeduct is "true"

  @update-pay.3 @update-pay @done
  Scenario: Success update payment to canceled from upcoming status
    Given supplier create payment request for "Upcoming" status
    When supplier update payment request to "CANCELED" status
    Then payment will automatically changes to "CANCELED"

  @update-notes.1 @done
  Scenario: Success update OUTSTANDING payment with notes
    Given supplier create payment request for "Upcoming" status
    And supplier update payment request to "READY" status
    And payment will automatically changes to "OUTSTANDING"
    When supplier update payment request with notes
    Then payment will have notes

  @update-notes.2 @done
  Scenario: Success update UPCOMING payment with notes
    Given supplier create payment request for "Upcoming" status
    When supplier update payment request with notes
    Then payment will have notes

  @update-notes.3 @done
  Scenario: Success update PAID payment with notes
    Given supplier create payment request for "Upcoming" status and achieved amount SI
    And supplier update payment request to "READY" status
    And payment will automatically changes to "PAID"
    When supplier update payment request with notes
    Then payment will have notes

  @update-notes.4 @done
  Scenario: Success update CANCELED payment with notes
    Given supplier create payment request for "Upcoming" status
    And supplier update payment request to "CANCELED" status
    And payment will automatically changes to "CANCELED"
    When supplier update payment request with notes
    Then payment will have notes

  @update-notes.5 @done
  Scenario: Success update CANCELED payment with notes that previously has notes
    Given supplier create payment request for "Upcoming" status with notes
    And supplier update payment request to "CANCELED" status
    And payment will automatically changes to "CANCELED"
    When supplier update payment request with notes
    Then payment will have notes

  @update-pay.4 @done
  Scenario: Success update payment to canceled from outstanding status
    Given supplier create payment request for "Outstanding" status
    When supplier update payment request to "CANCELED" status
    Then payment will automatically changes to "CANCELED"

  @update-pay.5 @failed
  Scenario Outline: Error message appears when updating "CANCELED" payment
    Given supplier create payment request for "Outstanding" status
    And supplier update payment request to "CANCELED" status
    When supplier failed update payment request to "<status>" status
    Then error message can't update "CANCELED" payment appears
    Examples:
    |status|
    |READY |
    |CANCELED|

  @update-pay.6
  Scenario Outline: Error message appears when updating "PAID" payment
    Given supplier create payment request for "Upcoming" status and achieved amount SI
    And supplier update payment request to "READY" status
    When supplier failed update payment request to "<status>" status
    Then error message can't update "PAID" payment appears
    Examples:
      |status|
      |READY |
      |CANCELED|

  @void-payment @re-run @bc
  Scenario: BC process the payment from CubeForAll with reattempt true
    Given BC create payment request for processing payment with reattempt "true"
    Then payment will be created
    And payment will automatically changes to "OUTSTANDING"

  @void-payment @re-run @bc
  Scenario: BC process the payment from CubeForAll with reattempt false
    Given BC create payment request for processing payment with reattempt "false"
    Then payment will be created
    And payment will automatically changes to "FAILED"


  @process-payment @re-run @bc
  Scenario: BC process the payment from CubeForAll
#    Given account is a success account
    And BC create payment request for processing payment
    Then payment will be created
    And payment will automatically changes to "PAID"

  @process-payment @re-run @bc
  Scenario: BC process the payment from CubeForAll with failed card account
    Given BC create payment request for processing payment with failed card account
    Then payment will be created
    And payment will automatically changes to "FAILED"

  @refund-payment @re-run @bc.1
  Scenario: BC process refund of payment from CubeForAll with success refund account
    Given BC create payment request for processing payment
    And payment will automatically changes to "PAID"
    When BC process refund of the payment
    Then payment will be refunded
    And payment will automatically changes to "REFUNDED"

  @refund-payment @re-run @bc
  Scenario: BC process refund of payment from CubeForAll with failed refund account
    Given BC create payment request for processing payment with failed refund account
    And payment will automatically changes to "PAID"
    When BC process refund of the payment
    Then payment will be refunded
    And payment will remain in "PAID" status

  @payment-report
  Scenario: Creating payment request with report reference
    Given supplier create payment request with report reference
    #TO DO
    Then report reference will appears in the merchant report

  @exp-date-process @bc
  Scenario: BC process will not have an expiredDate and it will not be changed to Expired
    Given BC create payment request for processing payment
    Then payment will have a null expiredDateTime
    And the payment will not changes to Expired status

  @cant-process @bc
  Scenario: Cannot create payment request with wrong paymentMethodId
    Given BC create payment request for user with different paymentMethodId
    Then error message can't create payment request appears

  @same-ex-id @bc
  Scenario: Cannot create payment request with same external reference id
    Given BC create payment request with "A" external reference id
    When BC create payment request with "A" external reference id again
    Then error message can't create payment request with same external ref id appears

  @popup
  Scenario: Partner create payment with giro method
    Given Partner create payment with "giro" method
    Then payment will be created
    And payment will automatically changes to "NOT_AVAILABLE"

  @popup
  Scenario: Partner create payment with paynow method
    Given Partner create payment with "paynow" method
    Then payment will be created
    And payment will automatically changes to "OUTSTANDING"