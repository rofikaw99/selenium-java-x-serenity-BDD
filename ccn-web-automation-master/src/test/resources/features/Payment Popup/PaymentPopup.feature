Feature: Payment Popup

  Scenario: User want to pay with popup payment component
    Given user login as card admin or card user or user
    When user pay from the popup
    Then detail of payment items will appears
    And saved card with enabled icon will appears if card admin or card user login
    And saved card with disabled icon will appears if user with saved card company login
    And option to input new card will appears for all of users
    And paynow option will appears for all users type
    And giro option will appears for user with giro saved in company
    And there is Pay button

  Scenario: Card admin and card user able to pay with saved card
    Given user login as card admin and card user
    And go to payment popup
    And saved company card will auto-selected and appears
    When pay payment with saved card selected
    Then processing payment successfully
    And payment will appears in the list of payment
    And payment will have ""PAID"" status


  Scenario: Card admin and card user able to pay with new card
    Given user login as card admin and card user
    And go to payment popup
    And select non-saved card option
    And setup card form appears without save payment method checkbox
    When pay payment with the setup card
    Then processing payment successfully
    And payment will appears in the list of payment
    And payment will have ""PAID"" status
    And card will not saved to the company

  Scenario: Card admin, card user, user able to pay with paynow
    Given user login as card admin or card user
    And go to payment popup
    When pay payment with paynow
    Then processing payment successfully
    And payment will appears in the list of payment
    And payment will have ""PAID"" status

  Scenario: User who company have card able to pay with new card
    Given user login as user who company have card
    And go to payment popup
    And non-saved card option is auto-selected
    And setup card form appears without save payment method checkbox
    When pay payment with the valid setup card
    Then processing payment successfully
    And payment will appears in the list of payment
    And payment will have ""PAID"" status
    And card will not saved to the company

  Scenario: User who company doesn't have card able to pay with new card and choose to not save the payment method
    Given user login as user who company doesn't have card
    And go to payment popup
    And non-saved card option is auto-selected
    And setup card form appears with save payment method checkbox
    When pay payment with the valid setup card
    Then processing payment successfully
    And payment will appears in the list of payment
    And payment will have ""PAID"" status
    And card will not saved to the company

  Scenario: User who company doesn't have card able to pay with new card and choose to save the payment method
    Given user login as user who company doesn't have card
    And go to payment popup
    And non-saved card option is auto-selected
    And setup card form appears with save payment method checkbox
    When pay payment with the valid setup card
    And check save payment method checkbox
    Then processing payment successfully
    And payment will appears in the list of payment
    And payment will have ""PAID"" status
    And card will saved to the company
    And user will become a card admin

  Scenario: Card admin, card user, user able to pay with giro
    Given user login as card admin or card user
    And go to payment popup
    When pay payment with giro
    Then processing payment successfully
    And payment will appears in the list of payment
    And payment will have ""N/A"" status
    And email notification sent to admin

  Scenario: User able to pay payment with payment method based on each supplier
    Given user login as card admin or card user
    When there is payment with product TDSB
    Then available payment method are Paynow and Visa card from Singapore only
    When there is payment with product SVS
    Then availabe payment method only card (all card type)

  Scenario: User not able to pay with new setup card with non-visa card
    Given user login as card admin, card user, and user
    And go to payment popup
    And non-saved card option is selected
    And setup card form appears
    When pay payment with non-visa card
    Then processing payment failed
    And error message appears

  Scenario: User not able to pay with new setup card with non-singapore card for tdsb supplier
    Given user login as card admin, card user, and user
    And go to payment popup
    And non-saved card option is selected
    And setup card form appears
    When pay payment with non-singapore card
    Then processing payment failed
    And error message appears

  Scenario: Card admin and card user not able to pay with expired card
    Given user login as card admin
    And company has expired card
    When go to payment popup
    Then pay button disabled when saved card selected
    And there is Expired message appears
    And there is Update button
    When click Update button
    Then user will be redirected to Payment Settings