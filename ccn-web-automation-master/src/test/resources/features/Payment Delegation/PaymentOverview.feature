Feature: Payment Overview

  Scenario Outline: User able to view the detail payment of Outstanding, Upcoming, Paid, and Expired status
    Given user login as card admin or card user or user
    When user view detail of my payment with status: "<status>"
    Then payment detail page with selected id appears
    Examples:
    | status |
    | Upcoming       |
    | Paid       |
    | Expired       |

  Scenario: My payment successfully auto-deducted when SI for the product has been setup in the company
    Given user login as card admin or card user
    And there is SI for service A in the company
    When there is payment for service A
    Then payment for service A of company will be auto-deducted
    And payment status changes to Paid

  Scenario: User able to delegate the specific company payment
    Given user login as card admin or card user
    And there is no Active payment delegation for service A
    And there is Outstanding or Upcoming payment request of service A
    When user delegate the specific payment request to company X
    Then the payment will be delegated to company X (will appears in the Received Payment menu)
    And company X able to pay the payment

  Scenario: User able to re-assigned Active future payment delegation of specific company payment
    Given user login as card admin or card user
    And there is Active future payment delegation for service A to company X
    And there is payment Z for service A with Outstanding and Upcoming status
    When user delegate payment Z of service A to company Y
    Then payment request Z sent to company Y with Outstanding / Upcoming status
    And payment request Z status in company X changes to Withdrawn
    And value of Delegated To changes to company Y

#DELEGATED PAYMENT
  Scenario Outline: User able to view the detail payment of Outstanding, Upcoming, Paid, and Expired status
    Given user login as card admin or card user or user
    When user view detail of my payment with status: "<status>"
    Then payment detail page with selected id appears
    Examples:
      | status |
      | Upcoming       |
      | Paid       |
      | Expired       |

  Scenario: Delegated payment successfully auto-deducted when SI has been setup in the company
    Given user login as card admin or card user
    And payment delegation request for service A from company X to company Y has Active status
    And there is SI for service A in company Y
    When there is payment for service A
    Then payment for service A of company X will be auto-deducted in company Y
    And payment status changes to Paid