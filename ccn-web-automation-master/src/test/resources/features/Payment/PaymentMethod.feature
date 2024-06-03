@payment @payment-method
Feature: Payment Method
  User's type:
  Card Admin: Cube Platform User that has setup a commercial card
  Card User: Cube Platform User is authorize to use a commercial card by Card Admin
  User: Cube Platform User is not authorize to use a commercial card by a Card Admin or has not setup a commercial card

  Only users who are not authorized to use a commercial card or have not previously set up a commercial card Can eligible to setup a commercial card.

  @PPM_TC_12 @view-commercial-card @PaymentModule @card-user @login
  Scenario Outline: Card Admin and Card User can view the last 4 digit visa card
    Given "<user type>" login to the web
    When "<user type>" click view icon
    Then "<user type>" can view the last 4 digit visa card
    Examples:
      | user type |
      | Card User |

  @PPM_TC_13 @view-commercial-card @PaymentModule @card-admin @login
  Scenario Outline: Card Admin and Card User can view the last 4 digit visa card
    Given "<user type>" login to the web
    When "<user type>" click view icon
    Then "<user type>" can view the last 4 digit visa card
    Examples:
      | user type |
      | Card Admin |

  @PPM_TC_14 @view-commercial-card @PaymentModule @user @login
  Scenario: User have no option to view the visa card
    Given "User who company has card" login to the web
    Then no view icon

  @PPM_TC_73 @commercial-card-access @PaymentModule @user @login
  Scenario: User able setup commercial card
    Given "User who company doesn't has card" login to the web
    When "User" setup commercial card
    Then user able to setup commercial card

  @PPM_TC_1 @commercial-card-access @PaymentModule @user @login
  Scenario: User who doesn't have company unable to setup commercial card
    Given "User doesn't have company" login to the web
    When "User" setup commercial card
    Then button setup company appears since "User" have to create company first

  @PPM_TC_6 @commercial-card-access @PaymentModule @card-admin @login
  Scenario Outline: Card Admin can't setup commercial card
    Given "<user type>" login to the web
    When "<user type>" setup commercial card
    Then can't setup commercial card
    Examples:
      | user type |
      | Card Admin |

  @PPM_TC_7 @commercial-card-access @PaymentModule @card-user @login
  Scenario Outline: Card User can't setup commercial card
    Given "<user type>" login to the web
    When "<user type>" setup commercial card
    Then can't setup commercial card
    Examples:
      | user type |
      | Card User |

  @PPM_TC_2 @add-commercial-card @PaymentModule @user @login
  Scenario Outline: User can't input non visa singapore issued when setup commercial card
    Given "User who company doesn't has card" login to the web
    When "User" setup commercial card
    And user input "<condition>" commercial card
    And press save commercial card
    Then validation note "<note>" appears
    Examples:
    | condition | note |
#    | non visa singapore issued | Error: Should be a Visa card issued in Singapore |
    | duplicate | This card has already been set up. Please try using a different card. |

  @PPM_TC_4 @add-commercial-card @PaymentModule @user @login
  Scenario Outline: Input several invalid data in commercial card form
    Given "User who company doesn't has card" login to the web
    When "User" setup commercial card
    When input data: "<card info>" card information, "<expired date>" expired date, "<cvc>" cvc, "<email>" email
    Then validation "<message>" appears
    Examples:
      | card info | expired date          | cvc         | email         | message           |
      |           |                       |             |               | button disabled   |
      | invalid   |                       |             |               | Your card number is incomplete. |
      |           |  invalid              |             |               | Your card's expiration year is in the past.|
      |           |                       | invalid     |               | Your card's security code is incomplete. |

#  @PPM_TC_3 @add-commercial-card @login
#  Scenario: User able to save commercial card when input valid VISA number
#    Given "User who company doesn't has card" login to the web
#    When "user" setup commercial card
#    And user input "valid VISA number" commercial card
#    And press save commercial card
#    Then commercial card will be saved (tokenization)

  @PPM_TC_10 @add-card-user @PaymentModule @card-user @login
  Scenario Outline: Card User doesn't have function to add Card User
    Given "<user type>" login to the web
    When "<user type>" want add Card User
    Then the manage authored user function not available for "<user type>"
    Examples:
    | user type |
    | Card User |

  @PPM_TC_11 @add-card-user @PaymentModule @user @login
  Scenario Outline: User doesn't have function to add Card User
    Given "<user type>" login to the web
    When "<user type>" want add Card User
    Then the manage authored user function not available for "<user type>"
    Examples:
      | user type |
      | User who company doesn't has card |
      | User who company has card |

  @PPM_TC_8 @add-card-user @PaymentModule  @card-admin @login
  Scenario: Card Admin success add Card User
    Given "Card Admin" login to the web
    When "Card Admin" want add Card User
    And Card Admin can only authorise user within their same company
    Then succeed add Card User

  @PPM_TC_58 @add-card-user @done @PaymentModule @user @login
  Scenario: User who doesn't have company can't add Card User
    Given "User doesn't have company" login to the web
    When "User" want add Card User
    Then button setup company appears since "User" have to create company first
    When click button setup company
    Then Card Admin will be redirected to My Company page

  @PPM_TC_18 @setup-si @done @PaymentModule @user @login
  Scenario: Non company user not able to setup standing instruction
    Given "User doesn't have company" login to the web
    When "User doesn't have company" want to setup standing instruction
    Then not able to setup standing instruction

  @PPM_TC_90 @setup-si @done @PaymentModule @user @login
  Scenario: User who company has card not able to setup standing instruction
    Given "User who company has card" login to the web
    When "User who company has card" want to setup standing instruction
    Then not able to setup standing instruction

  @PPM_TC_20 @setup-si @done @PaymentModule @card-admin @login
  Scenario: Setup standing instruction with Card Admin
    Given "Card Admin" login to the web
    When "Card Admin" want to setup standing instruction
    Then can select supplier to setup standing instruction
    Then able to setup standing instruction
    Then "Card Admin" can view all standing instruction including authorize user

  @PPM_TC_19 @setup-si @done @PaymentModule @card-user @login
  Scenario: Setup standing instruction with Card User
    Given "Card User" login to the web
    When "Card User" want to setup standing instruction
    Then can select supplier to setup standing instruction
    Then able to setup standing instruction
    Then "Card User" can see all the standing instruction created within the company. but they only able to manage their own standing instruction

  @PPM_TC_21 @update-si @done @PaymentModule @card-admin @login
  Scenario: Update standing instruction with Card Admin
    Given "Card Admin" login to the web
    When "Card Admin" want to update standing instruction
    And "Card Admin" choose one of the standing instruction
    Then only threshold limit, end date can be updated
    And success update standing instruction

  @PPM_TC_22 @update-si @done @PaymentModule @card-user @login
  Scenario: Update standing instruction with authorize user
    Given "Card User" login to the web
    When "Card User" want to update standing instruction
    And "Card User" choose one of the standing instruction
    Then only threshold limit, end date can be updated
    And success update standing instruction

  @PPM_TC_23 @update-si @done @PaymentModule @user @login
  Scenario: Update standing instruction with user
    Given "User" login to the web
    When "User" want to update standing instruction
    Then can't update standing instruction

  @PPM_TC_24 @transfer-si @PaymentModule @card-admin @login
  Scenario: Only Card Admin can transfer standing instruction ownership
    Given "Card Admin" login to the web
    When "Card Admin" want to transfer standing instruction ownership
    And "Card Admin" choose one of the standing instruction
    Then Card Admin able to transfer instruction ownership

  @PPM_TC_25 @transfer-si @PaymentModule @card-user @login
  Scenario: Card User can't transfer standing instruction ownership
    Given "Card User" login to the web
    When "Card User" want to transfer standing instruction ownership
    And "Card User" choose one of the standing instruction
    Then Card User can't transfer standing instruction ownership

  @PPM_TC_26 @transfer-si @done @PaymentModule @user @login
  Scenario: The function to transfer standing instruction not available for user
    Given "User" login to the web
    When "User" want to transfer standing instruction ownership
    Then the function not available

  @PPM_TC_68 @remove-card-user @done @PaymentModule @card-admin @login
  Scenario: Card Admin remove user who doesn't have standing instruction
    Given "Card Admin" login to the web
    When remove Card User that doesn't has standing instruction
    Then there's no option to transfer the SI
    And success delete user without standing instruction

  @PPM_TC_65 @remove-card-user @done @PaymentModule @card-admin @login
  Scenario: Card Admin remove user without transferring the standing instruction
    Given "Card User" has standing instruction

  @PPM_TC_65 @remove-card-user @done @PaymentModule @card-admin
  Scenario: Card Admin remove user without transferring the standing instruction
    Given "Card Admin" login to the web
    When "Card Admin" go the payment methods page
    When remove Card User that has standing instruction
    And confirm remove "without" transferring the standing instruction
    Then succeed remove Card User who has standing instruction
    And standing instruction will be removed from the list of standing instruction

  @PPM_TC_64 @remove-card-user @done @PaymentModule @card-admin @login
  Scenario: Card Admin remove user with transferring the standing instruction
    Given "Card User" has standing instruction

  @PPM_TC_64 @remove-card-user @done @PaymentModule @card-admin
  Scenario: Card Admin remove user with transferring the standing instruction
    Given "Card Admin" login to the web
    When "Card Admin" go the payment methods page
    When remove Card User that has standing instruction
    And confirm remove "with" transferring the standing instruction
    Then succeed remove Card User who has standing instruction
    And standing instruction will be managed by the selected user

  @PPM_TC_90 @remove-card-user @done @PaymentModule @card-user @login
  Scenario Outline: Card User can't remove the list of Card User
    Given "<user type>" login to the web
    When "<user type>" want remove Card User
    Then the manage authored user function not available for "<user type>"
    Examples:
      | user type |
      | Card User |

  @PPM_TC_90 @remove-card-user @done @PaymentModule @user @login
  Scenario Outline: User can't remove the list of Card User
    Given "<user type>" login to the web
    When "<user type>" want remove Card User
    Then the manage authored user function not available for "<user type>"
    Examples:
      | user type |
      | User            |

  @PPM_TC_69 @remove-si @done @PaymentModule @card-admin @login
  Scenario: Card Admin able to remove all standing instruction within the card
    Given "Card Admin" login to the web
    When "Card Admin" want to remove standing instruction
    Then Card Admin able to remove all the standing instruction within their card

  @PPM_TC_70 @remove-si @done @PaymentModule @card-user @login
  Scenario: Card User only able to remove their standing instruction
    Given "Card User" login to the web
    When "Card User" want to remove standing instruction
    Then Card User only able to remove their standing instruction

  @PPM_TC_71 @remove-si @done @PaymentModule @user @login
  Scenario: User has no option to remove standing instruction
    Given "User" login to the web
    When "User" want to remove standing instruction
    Then user has no option to remove standing instruction

  @PPM_TC_72 @remove-si @done @PaymentModule @card-admin @login
  Scenario: Success remove standing instruction
    Given "Card Admin" login to the web
    When "Card Admin" want to remove standing instruction
    When confirm remove one of the standing instruction
    Then selected standing instruction disappear from the list

  @PPM_TC_16 @remove-commercial-card @done @PaymentModule @card-user @login
  Scenario Outline: Card User not able to remove commercial card
    Given "<user type>" login to the web
    When "<user type>" want to remove commercial card
    Then "<user type>" "<result>" to remove commercial card
    Examples:
      | user type | result |
      | Card User | no option |

  @PPM_TC_16 @remove-commercial-card @done @PaymentModule @user @login
  Scenario Outline: User have no option to remove commercial card
    Given "<user type>" login to the web
    When "<user type>" want to remove commercial card
    Then "<user type>" "<result>" to remove commercial card
    Examples:
      | user type | result |
      | User | no option |

  @PPM_TC_15 @remove-commercial-card @done @PaymentModule @user-leave @login @card-admin
  Scenario: Card Admin can remove their commercial card
    Given "Card Admin that want to remove their card" login to the web
    When "Card Admin" want to remove commercial card
    Then "Card Admin" "able" to remove commercial card
    Then all standing instruction and Card User will be removed

  @PPM_TC_67 @leave-company @PaymentModule @user-leave @login @card-user
  Scenario: Card User leave the company
    Given "Card User that Leave Company" login to the web
    When "Card User" leave the company
    Then all standing instruction will be transferred to Card Admin

  @PPM_TC_66 @leave-company @done @PaymentModule @card-admin @login
  Scenario: Card Admin leave the company
    Given "Card Admin that Leave Company" login to the web
    When "Card Admin" leave the company
    Then all card, Card User & standing instruction will be removed

#   THE FEATURE IS HIDDEN
#    @PPM_TC_57 @PPM_TC_59 @add-card-user @done @PaymentModule
#    Scenario Outline: Card Admin add email account outside the company
#      Given "Card Admin" login to the web
#      When "Card Admin" want add Card User
#      And add user "<condition>"
#      Then information to invite the user to company appears
#      Examples:
#      |condition|
#      | from another company |
#      | that has not yet joined the company |

#    @PPM_TC_60 @PPM_TC_61 @add-card-user @done @PaymentModule
#    Scenario Outline: Card Admin invite several Card User that has not yet join company
#      Given "Card Admin" login to the web
#      And "Card Admin" go the payment methods page
#      And Card Admin added "<amount>" Card User that has not yet join company
#      When invite "<amount>" of the user
#      Then create account email sent to "<condition>" the email user
#      Examples:
#      | amount | condition |
#      | 1      |           |
#      | 2      | all of    |
#
#    @PPM_TC_62 @remove-card-user @done @PaymentModule
#    Scenario: Card Admin want to remove added user without a company that has not invited yet
#      Given "Card Admin" login to the web
#      When "Card Admin" go the payment methods page
#      And Card Admin has not yet invite the Card User
#      When remove that invited Card User
#      Then succeed remove Card User without company

#    @PPM_TC_63 @remove-card-user @done @PaymentModule
#    Scenario: Card Admin want to remove added user without a company that has been invited
#      Given "Card Admin" login to the web
#      When "Card Admin" go the payment methods page
#      And Card Admin invite the Card User without company
#      When remove that invited Card User
#      Then succeed remove Card User without company
      #verify that he can't see standing instruction after join
