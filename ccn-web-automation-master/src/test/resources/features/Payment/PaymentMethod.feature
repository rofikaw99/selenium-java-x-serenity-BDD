@payment @payment-method
Feature: Payment Method
  User's type:
  Card Owner: Cube Platform User that has setup a commercial card
  Authorized User: Cube Platform User is authorize to use a commercial card by card owner
  User: Cube Platform User is not authorize to use a commercial card by a card owner or has not setup a commercial card

  Only users who are not authorized to use a commercial card or have not previously set up a commercial card Can eligible to setup a commercial card.

  @PPM_TC_12 @PPM_TC_13 @view-commercial-card @PaymentModule @authorized-user
  Scenario Outline: Card Owner and Authorized User can view the last 4 digit visa card
    Given "<user type>" login to the web
    When "<user type>" click view icon
    Then "<user type>" can view the last 4 digit visa card
    Examples:
      | user type |
      | Authorized User |

  @PPM_TC_12 @PPM_TC_13 @view-commercial-card @PaymentModule @card-owner
  Scenario Outline: Card Owner and Authorized User can view the last 4 digit visa card
    Given "<user type>" login to the web
    When "<user type>" click view icon
    Then "<user type>" can view the last 4 digit visa card
    Examples:
      | user type |
      | Card Owner |

  @PPM_TC_14 @view-commercial-card @PaymentModule @user
  Scenario: User have no option to view the visa card
    Given "User" login to the web
    Then no view icon

  @PPM_TC_73 @commercial-card-access @PaymentModule @user
  Scenario: User able setup commercial card
    Given "User have company" login to the web
    When "User" setup commercial card
    Then user able to setup commercial card

  @PPM_TC_1 @commercial-card-access @PaymentModule @user
  Scenario: User able setup commercial card
    Given "User doesn't have company" login to the web
    When "User" setup commercial card
    Then button setup company appears since "User" have to create company first

  @PPM_TC_6 @PPM_TC_7 @commercial-card-access @PaymentModule @card-owner
  Scenario Outline: User who has been authorized to use a commercial card can't setup commercial card
    Given "<user type>" login to the web
    When "<user type>" setup commercial card
    Then can't setup commercial card
    Examples:
      | user type |
      | Card Owner |

  @PPM_TC_6 @PPM_TC_7 @commercial-card-access @PaymentModule @authorized-user
  Scenario Outline: User who has been authorized to use a commercial card can't setup commercial card
    Given "<user type>" login to the web
    When "<user type>" setup commercial card
    Then can't setup commercial card
    Examples:
      | user type |
      | Authorized User |

  @PPM_TC_2 @add-commercial-card @PaymentModule @user
  Scenario Outline: User can't input non visa singapore issued when setup commercial card
    Given "User have company" login to the web
    When "User" setup commercial card
    And user input "<condition>" commercial card
    And press save commercial card
    Then validation note "<note>" appears
    Examples:
    | condition | note |
#    | non visa singapore issued | Error: Should be a Visa card issued in Singapore |
    | duplicate | This card has already been set up. Please try using a different card. |

  @PPM_TC_4 @add-commercial-card @PaymentModule @user
  Scenario Outline: Input several invalid data in commercial card form
    Given "User have company" login to the web
    When "User" setup commercial card
    When input data: "<card info>" card information, "<expired date>" expired date, "<cvc>" cvc, "<email>" email
    Then validation "<message>" appears
    Examples:
      | card info | expired date          | cvc         | email         | message           |
      |           |                       |             |               | button disabled   |
      | invalid   |                       |             |               | Your card number is incomplete. |
      |           |  invalid              |             |               | Your card's expiration year is in the past.|
      |           |                       | invalid     |               | Your card's security code is incomplete. |

  @PPM_TC_3 @add-commercial-card
  Scenario: User able to save commercial card when input valid VISA number
    Given "User have company" login to the web
    When "user" setup commercial card
    And user input "valid VISA number" commercial card
    And press save commercial card
    Then commercial card will be saved (tokenization)

  @PPM_TC_10 @PPM_TC_11 @add-authorized-user @PaymentModule @authorized-user
  Scenario Outline: Authorized User and User doesn't have function to add authorized user
    Given "<user type>" login to the web
    When "<user type>" want add authorized user
    Then the manage authored user function not available for "<user type>"
    Examples:
    | user type |
    | Authorized User |

  @PPM_TC_10 @PPM_TC_11 @add-authorized-user @PaymentModule @user
  Scenario Outline: Authorized User and User doesn't have function to add authorized user
    Given "<user type>" login to the web
    When "<user type>" want add authorized user
    Then the manage authored user function not available for "<user type>"
    Examples:
      | user type |
      | User |

  @PPM_TC_8 @add-authorized-user @PaymentModule @card-owner
  Scenario: Card Owner success add authorized user
    Given "Card Owner" login to the web
    When "Card Owner" want add authorized user
    And Card Owner can only authorise user within their same company
    Then succeed add authorized user

  @PPM_TC_58 @add-authorized-user @done @PaymentModule @user
  Scenario: User who doesn't have company can't add authorized user
    Given "User doesn't have company" login to the web
    When "User" want add authorized user
    Then button setup company appears since "User" have to create company first
    When click button setup company
    Then Card Owner will be redirected to My Company page

  @PPM_TC_18 @setup-si @done @PaymentModule @user
  Scenario: Non company user not able to setup standing instruction
    Given "User doesn't have company" login to the web
    When "User doesn't have company" want to setup standing instruction
    Then not able to setup standing instruction

  @PPM_TC_20 @setup-si @done @PaymentModule @card-owner
  Scenario: Setup standing instruction with card owner
    Given "Card Owner" login to the web
    When "Card Owner" want to setup standing instruction
    Then can select supplier to setup standing instruction
    Then able to setup standing instruction
    Then "Card Owner" can view all standing instruction including authorize user

  @PPM_TC_19 @setup-si @done @PaymentModule @authorized-user
  Scenario: Setup standing instruction with authorized user
    Given "Authorized User" login to the web
    When "Authorized User" want to setup standing instruction
    Then can select supplier to setup standing instruction
    Then able to setup standing instruction
    Then "Authorized User" can see all the standing instruction created within the company. but they only able to manage their own standing instruction

  @PPM_TC_21 @update-si @done @PaymentModule @card-owner
  Scenario: Update standing instruction with card owner
    Given "Card Owner" login to the web
    When "Card Owner" want to update standing instruction
    And "Card Owner" choose one of the standing instruction
    Then only threshold limit, end date can be updated
    And success update standing instruction

  @PPM_TC_22 @update-si @done @PaymentModule @authorized-user
  Scenario: Update standing instruction with authorize user
    Given "Authorized User" login to the web
    When "Authorized User" want to update standing instruction
    And "Authorized User" choose one of the standing instruction
    Then only threshold limit, end date can be updated
    And success update standing instruction

  @PPM_TC_23 @update-si @done @PaymentModule @user
  Scenario: Update standing instruction with user
    Given "User" login to the web
    When "User" want to update standing instruction
    Then can't update standing instruction

  @PPM_TC_24 @transfer-si @PaymentModule @card-owner
  Scenario: Only card owner can transfer standing instruction ownership
    Given "Card Owner" login to the web
    When "Card Owner" want to transfer standing instruction ownership
    And "Card Owner" choose one of the standing instruction
    Then Card Owner able to transfer instruction ownership

  @PPM_TC_25 @transfer-si @PaymentModule @authorized-user
  Scenario: Authorized User can't transfer standing instruction ownership
    Given "Authorized User" login to the web
    When "Authorized User" want to transfer standing instruction ownership
    And "Authorized User" choose one of the standing instruction
    Then Authorized User can't transfer standing instruction ownership

  @PPM_TC_26 @transfer-si @done @PaymentModule @user
  Scenario: The function to transfer standing instruction not available for user
    Given "User" login to the web
    When "User" want to transfer standing instruction ownership
    Then the function not available

  @PPM_TC_68 @remove-authorized-user @done @PaymentModule @card-owner
  Scenario: Card Owner remove user who doesn't have standing instruction
    Given "Card Owner" login to the web
    When remove authorized user that doesn't has standing instruction
    Then there's no option to transfer the SI
    And success delete user without standing instruction

  @PPM_TC_65 @remove-authorized-user @done @PaymentModule @card-owner
  Scenario: Card Owner remove user without transferring the standing instruction
    Given "Authorized User" has standing instruction
    Given "Card Owner" login to the web
    When "Card Owner" go the payment methods page
    When remove authorized user that has standing instruction
    And confirm remove "without" transferring the standing instruction
    Then succeed remove authorized user who has standing instruction
    And standing instruction will be removed from the list of standing instruction

  @PPM_TC_64 @remove-authorized-user @done @PaymentModule @card-owner
  Scenario: Card Owner remove user with transferring the standing instruction
    Given "Authorized User" has standing instruction
    Given "Card Owner" login to the web
    When "Card Owner" go the payment methods page
    When remove authorized user that has standing instruction
    And confirm remove "with" transferring the standing instruction
    Then succeed remove authorized user who has standing instruction
    And standing instruction will be managed by the selected user

  @PPM_TC_90 @remove-authorized-user @done @PaymentModule @authorized-user
  Scenario Outline: Authorized User and User can't remove the list of authorized user
    Given "<user type>" login to the web
    When "<user type>" want remove authorized user
    Then the manage authored user function not available for "<user type>"
    Examples:
      | user type |
      | Authorized User |

  @PPM_TC_90 @remove-authorized-user @done @PaymentModule @user
  Scenario Outline: Authorized User and User can't remove the list of authorized user
    Given "<user type>" login to the web
    When "<user type>" want remove authorized user
    Then the manage authored user function not available for "<user type>"
    Examples:
      | user type |
      | User            |

  @PPM_TC_69 @remove-si @done @PaymentModule @card-owner
  Scenario: Card owner able to remove all standing instruction within the card
    Given "Card Owner" login to the web
    When "Card Owner" want to remove standing instruction
    Then card owner able to remove all the standing instruction within their card

  @PPM_TC_70 @remove-si @done @PaymentModule @authorized-user
  Scenario: Authorized user only able to remove their standing instruction
    Given "Authorized User" login to the web
    When "Authorized User" want to remove standing instruction
    Then authorized user only able to remove their standing instruction

  @PPM_TC_71 @remove-si @done @PaymentModule @user
  Scenario: User has no option to remove standing instruction
    Given "User" login to the web
    When "User" want to remove standing instruction
    Then user has no option to remove standing instruction

  @PPM_TC_72 @remove-si @done @PaymentModule @card-owner
  Scenario: Success remove standing instruction
    Given "Card Owner" login to the web
    When "Card Owner" want to remove standing instruction
    When confirm remove one of the standing instruction
    Then selected standing instruction disappear from the list

  @PPM_TC_16 @remove-commercial-card @done @PaymentModule @authorized-user
  Scenario Outline: Authorized user not able and User have no option to remove commercial card
    Given "<user type>" login to the web
    When "<user type>" want to remove commercial card
    Then "<user type>" "<result>" to remove commercial card
    Examples:
      | user type | result |
      | Authorized User | no option |

  @PPM_TC_16 @remove-commercial-card @done @PaymentModule @user
  Scenario Outline: Authorized user not able and User have no option to remove commercial card
    Given "<user type>" login to the web
    When "<user type>" want to remove commercial card
    Then "<user type>" "<result>" to remove commercial card
    Examples:
      | user type | result |
      | User | no option |

  @PPM_TC_15 @remove-commercial-card @done @PaymentModule @card-owner
  Scenario: Card owner can remove their commercial card
    Given "Card Owner that want to remove their card" login to the web
    When "Card Owner" want to remove commercial card
    Then "Card Owner" "able" to remove commercial card
    Then all standing instruction and authorized user will be removed

  @PPM_TC_67 @leave-company @PaymentModule @authorized-user
  Scenario: Authorized user leave the company
    Given "Authorized User that Leave Company" login to the web
    When "Authorized User" leave the company
    Then all standing instruction will be transferred to card owner

  @PPM_TC_66 @leave-company @done @PaymentModule @card-owner
  Scenario: Card owner leave the company
    Given "Card Owner that Leave Company" login to the web
    When "Card Owner" leave the company
    Then all card, authorized user & standing instruction will be removed

#   THE FEATURE IS HIDDEN
#    @PPM_TC_57 @PPM_TC_59 @add-authorized-user @done @PaymentModule
#    Scenario Outline: Card Owner add email account outside the company
#      Given "Card Owner" login to the web
#      When "Card Owner" want add authorized user
#      And add user "<condition>"
#      Then information to invite the user to company appears
#      Examples:
#      |condition|
#      | from another company |
#      | that has not yet joined the company |

#    @PPM_TC_60 @PPM_TC_61 @add-authorized-user @done @PaymentModule
#    Scenario Outline: Card Owner invite several authorized user that has not yet join company
#      Given "Card Owner" login to the web
#      And "Card Owner" go the payment methods page
#      And card owner added "<amount>" authorized user that has not yet join company
#      When invite "<amount>" of the user
#      Then create account email sent to "<condition>" the email user
#      Examples:
#      | amount | condition |
#      | 1      |           |
#      | 2      | all of    |
#
#    @PPM_TC_62 @remove-authorized-user @done @PaymentModule
#    Scenario: Card Owner want to remove added user without a company that has not invited yet
#      Given "Card Owner" login to the web
#      When "Card Owner" go the payment methods page
#      And card owner has not yet invite the authorized user
#      When remove that invited authorized user
#      Then succeed remove authorized user without company

#    @PPM_TC_63 @remove-authorized-user @done @PaymentModule
#    Scenario: Card Owner want to remove added user without a company that has been invited
#      Given "Card Owner" login to the web
#      When "Card Owner" go the payment methods page
#      And card owner invite the authorized user without company
#      When remove that invited authorized user
#      Then succeed remove authorized user without company
      #verify that he can't see standing instruction after join
