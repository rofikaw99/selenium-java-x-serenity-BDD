@payment @payment-overview
Feature: Payment Overview

  @PPM_TC_40 @PaymentOverview @PaymentModule @payment-request
  Scenario Outline: create request payment upcoming
    Given user get SSO token
    And user create upcoming payment request


    Examples:
      | condition            | menu                | keyword |
      | Have Payment Request | My Payment Overview | REF-    |

#  @updateStatusToOutstanding @PaymentOverview @PaymentModule @payment-request
#  Scenario Outline: update payment request to outstanding
#    Given user get SSO token
#    And user create "<status>" payment request with "<paymentRequestId>"
#
#    Examples:
#      | status  | paymentRequestId                     | condition            | menu                | keyword     |
#      | READY   | 35034b8a-b66a-4128-ba42-73fd16f917e7 | Have Payment Request | My Payment Overview | REF-        |

#  @PPM_TC_41 @PaymentOverview @PaymentModule @payment-request
#  Scenario Outline: update payment request to expired
#    Given user get SSO token
#    And user create "<status>" payment request with "<paymentRequestId>"
#
#    Examples:
#      | status    | paymentRequestId                     | condition            | menu                | keyword |
#      | EXPIRED   | 52173ef3-f566-4722-8e17-b02ecb04a3a5 | Have Payment Request | My Payment Overview | REF-    |

  @PPM_TC_42 @PaymentOverview @PaymentModule @payment-request
  Scenario Outline: create request payment credit term with status paid
    Given user get SSO token
    And user create credit term payment request

    Examples:
      | condition            | menu                | condition            | menu                | keyword |
      | Have Payment Request | My Payment Overview | Have Payment Request | My Payment Overview | paid    |
###      | User have company |

  @PPM_TC_49_1 @PaymentOverview @PaymentModule @login @card-admin
  Scenario Outline: Card Admin verify field to be display on my payment
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment

    Examples:
      | condition               | menu                |
      | Have Payment Request    | My Payment Overview |

  @PPM_TC_49_2 @PaymentOverview @PaymentModule @login @card-user
  Scenario Outline: Card User verify field to be display on my payment
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment

    Examples:
      | condition               | menu                |
      | Authorize User Overview | My Payment Overview |


  @PPM_TC_49_3 @PaymentOverview @PaymentModule @user @login
  Scenario Outline: User verify field to be display on my payment
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment

    Examples:
      | condition               | menu                |
      | User Overview           | My Payment Overview |


  @PPM_TC_53_1 @keywordFilter @PaymentOverview @PaymentModule @card-admin @login
  Scenario Outline: Card Admin find certain keyword
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"

    Examples:
      | condition               | menu                | keyword  |
      | Have Payment Request    | My Payment Overview | Deduct   |

  @PPM_TC_53_2 @keywordFilter @PaymentOverview @PaymentModule @login @card-user
  Scenario Outline: Card User verify field to be display on my payment
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"

    Examples:
      | condition               | menu                | keyword |
      | Authorize User Overview | My Payment Overview | Card    |

  @PPM_TC_53_3 @keywordFilter @PaymentOverview @PaymentModule @login @user
  Scenario Outline: User verify field to be display on my payment
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"

    Examples:
      | condition               | menu                | keyword |
      | User Overview           | My Payment Overview | Auto    |

  @PaymentOverviewAnotherCompany @PaymentModule @user
  Scenario Outline: Another company can't see
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    When User go to "<menu>"
    Then verify field to be display that payment request not display

    Examples:
      | email                       | password      | menu                |
      | qa-ccn-49965651@yopmail.com | CCNPegasus123 | My Payment Overview |

  @nonSGCompanyCantAccessPaymentOverview @PaymentModule @user
  Scenario Outline: non SG company can't access payment module
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    Then User go to "<menu>" to verify that the non SG can't access payment module

    Examples:
      | email                | password      | menu                |
      | malaypcn@yopmail.com | CCNPegasus123 | My Payment Overview |

  @AuthorizedUserNotSubscribeService @PaymentModule @card-user
  Scenario Outline: When Card User not subscribe the TDSB service still can view the payment request
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    When User go to "<menu>"
    Then verify field to be display on my payment

    Examples:
      | email                       | password      | menu                |
      | qa-ccn-tp5pkqv2@yopmail.com | CCNPegasus123 | My Payment Overview |

  @UserNotSubscribeService @PaymentModule @user
  Scenario Outline: When user not subscribe the TDSB service can't view the payment request
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    When User go to "<menu>"
    Then verify field to be display that payment request not display

    Examples:
      | email                       | password      | menu                |
      | qa-ccn-cgfqhpqm@yopmail.com | CCNPegasus123 | My Payment Overview |

  @DisappearingPayButton @PaymentModule @card-user
  Scenario Outline: Only can pay with payNow for TDSB product when card-user setup with non SG visa
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    When User go to "<menu>"
    Then verify field to be display on my payment
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    And verify button checkout enable to click
    And user click pay for CC after checkout

    Examples:
      | email                       | password      | menu                | keyword |
      | autoqa-ccn-001@yopmail.com  | CCNPegasus123 | My Payment Overview | TDSB    |

  @SVSCardOnly @PaymentModule @card-user
  Scenario Outline: Pay with card only for SVS product when card-user setup with non SG visa
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    And verify button checkout enable to click
    And user click pay for CC after checkout

    Examples:
      | email                       | password      | menu                | keyword |
      | autoqa-ccn-001@yopmail.com  | CCNPegasus123 | My Payment Overview | Cargo   |

  @paymentIntentFail @PaymentModule @card-user
  Scenario Outline: payment intent fail
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    And verify button checkout enable to click
    And user click pay after checkout
    Then get triggered "<email>" notification
    Examples:
      | email               | password      | menu                | keyword | email              |
      | sripcn@yopmail.com  | CCNPegasus123 | My Payment Overview | Cargo   | sgpcn2@yopmail.com |

#  @PPM_TC_50_1_1 @PaymentOverview @PaymentModule @card-admin @login
#  Scenario Outline: Card Admin verify upcoming payment request status
#    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify upcoming status color code is correct
#    And verify button checkout unable to click
#
#    Examples:
#      | condition               | menu                | keyword  |
#      | Have Payment Request    | My Payment Overview | upcoming |

#  @PPM_TC_50_1_2 @PaymentOverview @PaymentModule @card-user @login
#  Scenario Outline: Card User verify upcoming payment request status
#    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify upcoming status color code is correct
#    And verify button checkout unable to click
#
#    Examples:
#      | condition               | menu                | keyword  |
#      | Authorize User Overview | My Payment Overview | upcoming |

#  @PPM_TC_50_1_3 @PaymentOverview @PaymentModule @user @login
#  Scenario Outline: User verify upcoming payment request status
#    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify upcoming status color code is correct
#    And verify button checkout unable to click
#
#    Examples:
#      | condition               | menu                | keyword  |
#      | User Overview           | My Payment Overview | upcoming |

  @PPM_TC_50_2_1 @PaymentOverview @PaymentModule @card-admin @login
  Scenario Outline: Card Admin verify outstanding payment request status
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    Then verify outstanding status color code is correct
    And verify button checkout enable to click

    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |


  @PPM_TC_50_2_2 @PaymentOverview @PaymentModule @card-user @login
  Scenario Outline: User verify outstanding payment request status
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    Then verify outstanding status color code is correct
    And verify button checkout enable to click

    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | outstanding |

  @PPM_TC_50_2_3 @PaymentOverview @PaymentModule @login @user
  Scenario Outline: User verify outstanding payment request status
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    Then verify outstanding status color code is correct
    And verify button checkout enable to click

    Examples:
      | condition               | menu                | keyword     |
      | User Overview           | My Payment Overview | outstanding |


  @PPM_TC_50_3_1 @PaymentOverview @PaymentModule @card-admin @login
  Scenario Outline: Card Admin verify paid payment request status
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    Then verify paid status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | Have Payment Request    | My Payment Overview | paid    |

  @PPM_TC_50_4_1 @PaymentOverview @PaymentModule @card-admin @login
  Scenario Outline: Card Admin verify expired payment request status
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    Then verify expired status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | Have Payment Request    | My Payment Overview | expired |

  @PPM_TC_50_4_2 @PaymentOverview @PaymentModule @card-user @login
  Scenario Outline: Card User verify expired payment request status
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    Then verify expired status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | Authorize User Overview | My Payment Overview | expired |

  @PPM_TC_50_4_3 @PaymentOverview @PaymentModule @login @user
  Scenario Outline: User verify expired payment request status
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    Then verify expired status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | User Overview           | My Payment Overview | expired |


  @PaymentCancelled @PaymentOverview @PaymentModule @card-admin @login
  Scenario Outline: Card Admin verify cancelled payment request status
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    Then verify cancelled status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | Have Payment Request    | My Payment Overview | canc    |

  @PPM_TC_51_1 @PaymentOverview @PaymentModule @card-admin @login
  Scenario Outline: Card Admin verify payment detail information
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    And go to the payment detail
    And verify payment detail information

    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |



  @PPM_TC_51_2 @PaymentOverview @PaymentModule @card-user @login
  Scenario Outline: Card User verify payment detail information Card User
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    And go to the payment detail
    And verify payment detail information

    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | outstanding |


  @PPM_TC_51_3 @PaymentOverview @PaymentModule @login @user
  Scenario Outline: User verify payment detail information User
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    And go to the payment detail
    And verify payment detail information

    Examples:
      | condition               | menu                | keyword     |
      | User Overview           | My Payment Overview | outstanding |


  @pageFilter20 @PaymentOverview @PaymentModule @login @card-admin
  Scenario Outline: Card Admin try to change page setting
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    And select filter page "<page>"

    Examples:
      | condition            | menu                | page |
      | Have Payment Request | My Payment Overview | 20   |


  @pageFilter @PaymentOverview @PaymentModule @login
  Scenario Outline: Authorize User try to change page setting
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    And select filter page "<page>"

    Examples:
      | condition               | menu                | page |
      | Authorize User Overview | My Payment Overview | 40   |

  @pageFilterUser @PaymentOverview @PaymentModule @login
  Scenario Outline: User try to change page setting
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    And select filter page "<page>"

    Examples:
      | condition               | menu                | page |
      | User Overview           | My Payment Overview | 70   |

  @PPM_TC_27 @PaymentOverview @PaymentModule @card-admin @login
  Scenario Outline: Card Admin do the manual payment with payNow
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    And verify button checkout enable to click
    And user pay with payNow
    And user click pay after checkout

    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |

  @PPM_TC_28 @PaymentOverview @PaymentModule @card-user @login
  Scenario Outline: Card User do manual payment with payNow
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    And verify button checkout enable to click
    And user pay with payNow
    And user click pay after checkout

    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | outstanding |


  @PPM_TC_29 @PaymentOverview @PaymentModule @user @login
  Scenario Outline: User doing manual payment with payNow
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    And verify button checkout enable to click
    And user click pay after checkout

    Examples:
      | condition     | menu                | keyword     |
      | User Overview | My Payment Overview | outstanding |


  @PPM_TC_30 @PaymentOverview @PaymentModule @login @card-admin
  Scenario Outline: Card Admin do the manual payment with CC
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    And verify button checkout enable to click
    And user click pay for CC after checkout

    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |

  @PPM_TC_34 @PaymentOverview @PaymentModule @login @card-user
  Scenario Outline: Card User do the manual payment with CC
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    And verify button checkout enable to click
    And user click pay for CC after checkout

    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | outstanding |


  @PPM_TC_35 @PaymentOverview @PaymentModule @login @card-admin
  Scenario Outline: Card Admin do the bulk payment with CC
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    And user click checkbox bulk outstanding
    And user click checkbox bulk checkout
    Then user click pay for CC after checkout


    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |

  @PPM_TC_36 @PaymentOverview @PaymentModule @login @card-user
  Scenario Outline: Card User do the bulk payment with CC
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    And user click checkbox bulk outstanding
    And user click checkbox bulk checkout
    Then user click pay for CC after checkout


    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | outstanding |

  @PPM_TC_30 @PaymentOverview @PaymentModule @login @card-admin
  Scenario Outline: Card Admin do the bulk payment with PayNow
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    And user click checkbox bulk outstanding
    And user click checkbox bulk checkout
    And user pay with payNow
    And user click pay after checkout


    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |

  @PPM_TC_31 @PaymentOverview @PaymentModule @card-user @login
  Scenario Outline: Card User do the bulk payment with PayNow
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    And user click checkbox bulk outstanding
    And user click checkbox bulk checkout
    And user pay with payNow
    And user click pay after checkout


    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | outstanding |

  @PPM_TC_32 @PaymentOverview @PaymentModule @user @login
  Scenario Outline: User do the bulk payment with PayNow
    Given "<condition>" login to the web
    When User go to "<menu>"
    Then verify field to be display on my payment
    When input filter keyword "<keyword>"
    And user click checkbox bulk outstanding
    And user click checkbox bulk checkout
    And user click pay after checkout


    Examples:
      | condition     | menu                | keyword     |
      | User Overview | My Payment Overview | outstanding |

  @downloadPaymentReport @PaymentOverview @PaymentModule @user
  Scenario Outline: Download agent report on Payment Overview
    Given "<condition>" login to the web
    When User go to "<menu>"
    And verify field to be display on my payment
    Then download the report

    Examples:
      | condition               | menu                |
      | User Overview           | My Payment Overview |


  #PaymentNotification

  @PN1 @PaymentNotification @payment-request
  Scenario Outline: create request payment upcoming to get notification
    Given user get SSO token
    When user create upcoming payment request
    Then get triggered "<email>" notification


    Examples:
      | email              | menu                | keyword |
      | sgpcn2@yopmail.com | My Payment Overview | REF-    |

  @PN2_3 @PaymentNotification @payment-request
  Scenario Outline: create request payment outstanding to get notification
    Given user get SSO token
    When user create upcoming payment request
    Then get triggered "<email>" notification


    Examples:
      | email                | menu                | keyword |
      | sgpcn2@yopmail.com | My Payment Overview   | REF-    |

  @PN2_3 @PaymentNotification @payment-request
  Scenario Outline: create payment but fail then get notification
    Given user get SSO token
    When create payment but fail
    Then get triggered "<email>" notification


    Examples:
      | email                | menu                | keyword |
      | sgpcn2@yopmail.com | My Payment Overview   | REF-    |


  @PN4 @PaymentNotification @payment-request
  Scenario Outline: update payment to expired to get notification
    Given user get SSO token
    When user create upcoming payment request
    And update payment request to "<status>"
    Then get triggered "<email>" notification


    Examples:
      | email                | status    | keyword |
      | sgpcn2@yopmail.com   | EXPIRED   | REF-    |
