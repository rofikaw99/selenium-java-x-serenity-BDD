@payment @payment-overview
Feature: Payment Overview

  @PPM_TC_40 @PaymentOverview @PaymentModule @payment-request
  Scenario Outline: create request payment upcoming
    Given user get SSO token
    And user create upcoming payment request


    Examples:
      | condition            | menu                | keyword |
      | Have Payment Request | My Payment Overview | REF-    |

  @updateStatusToOutstanding @PaymentOverview @PaymentModule @payment-request
  Scenario Outline: update payment request to outstanding
    Given user get SSO token
    And user create "<status>" payment request with "<paymentRequestId>"

    Examples:
      | status  | paymentRequestId                     | condition            | menu                | keyword     |
      | READY   | 35034b8a-b66a-4128-ba42-73fd16f917e7 | Have Payment Request | My Payment Overview | REF-        |

  @PPM_TC_41 @PaymentOverview @PaymentModule @payment-request
  Scenario Outline: update payment request to expired
    Given user get SSO token
    And user create "<status>" payment request with "<paymentRequestId>"

    Examples:
      | status    | paymentRequestId                     | condition            | menu                | keyword |
      | EXPIRED   | 52173ef3-f566-4722-8e17-b02ecb04a3a5 | Have Payment Request | My Payment Overview | REF-    |

  @PPM_TC_42 @PaymentOverview @PaymentModule @payment-request
  Scenario Outline: create request payment credit term with status paid
    Given user get SSO token
    And user create credit term payment request

    Examples:
      | condition            | menu                | condition            | menu                | keyword |
      | Have Payment Request | My Payment Overview | Have Payment Request | My Payment Overview | paid    |
#      | User have company |

  @PPM_TC_49_1 @PaymentOverview @PaymentModule @login @card-owner
  Scenario Outline: Card Owner verify field to be display on my payment
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment

    Examples:
      | condition               | menu                |
      | Have Payment Request    | My Payment Overview |

  @PPM_TC_49_2 @PaymentOverview @PaymentModule @login @authorized-user
  Scenario Outline: Authorized User verify field to be display on my payment
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment

    Examples:
      | condition               | menu                |
      | Authorize User Overview | My Payment Overview |


  @PPM_TC_49_3 @PaymentOverview @PaymentModule @user @login
  Scenario Outline: User verify field to be display on my payment
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment

    Examples:
      | condition               | menu                |
      | User Overview           | My Payment Overview |


  @PPM_TC_53_1 @keywordFilter @PaymentOverview @PaymentModule @card-owner @login
  Scenario Outline: Card Owner find certain keyword
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"

    Examples:
      | condition               | menu                | keyword  |
      | Have Payment Request    | My Payment Overview | Deduct   |

  @PPM_TC_53_2 @keywordFilter @PaymentOverview @PaymentModule @login @authorized-user
  Scenario Outline: Authorized User verify field to be display on my payment
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"

    Examples:
      | condition               | menu                | keyword |
      | Authorize User Overview | My Payment Overview | Card    |

  @PPM_TC_53_3 @keywordFilter @PaymentOverview @PaymentModule @login @user
  Scenario Outline: User verify field to be display on my payment
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"

    Examples:
      | condition               | menu                | keyword |
      | User Overview           | My Payment Overview | Auto    |

  @PPM_TC_50_1_1 @PaymentOverview @PaymentModule @card-owner @login
  Scenario Outline: Card Owner verify upcoming payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify upcoming status color code is correct
#    And verify button checkout unable to click

    Examples:
      | condition               | menu                | keyword  |
      | Have Payment Request    | My Payment Overview | upcoming |

  @PPM_TC_50_1_2 @PaymentOverview @PaymentModule @authorized-user @login
  Scenario Outline: Authorized User verify upcoming payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify upcoming status color code is correct
#    And verify button checkout unable to click

    Examples:
      | condition               | menu                | keyword  |
      | Authorize User Overview | My Payment Overview | upcoming |

  @PPM_TC_50_1_3 @PaymentOverview @PaymentModule @user @login
  Scenario Outline: User verify upcoming payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify upcoming status color code is correct
#    And verify button checkout unable to click

    Examples:
      | condition               | menu                | keyword  |
      | User Overview           | My Payment Overview | upcoming |

  @PPM_TC_50_2_1 @PaymentOverview @PaymentModule @card-owner @login
  Scenario Outline: Card Owner verify outstanding payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify outstanding status color code is correct
#    And verify button checkout enable to click

    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |


  @PPM_TC_50_2_2 @PaymentOverview @PaymentModule @authorized-user @login
  Scenario Outline: User verify outstanding payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify outstanding status color code is correct
#    And verify button checkout enable to click

    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | outstanding |

  @PPM_TC_50_2_3 @PaymentOverview @PaymentModule @login @user
  Scenario Outline: User verify outstanding payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify outstanding status color code is correct
#    And verify button checkout enable to click

    Examples:
      | condition               | menu                | keyword     |
      | User Overview           | My Payment Overview | outstanding |


  @PPM_TC_50_3_1 @PaymentOverview @PaymentModule @card-owner @login
  Scenario Outline: Card Owner verify paid payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify paid status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | Have Payment Request    | My Payment Overview | paid    |


  @PPM_TC_50_3_2 @PaymentOverview @PaymentModule @authorized-user @login
  Scenario Outline: Authorized User verify paid payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify paid status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | Authorize User Overview | My Payment Overview | paid    |


  @PPM_TC_50_3_3 @PaymentOverview @PaymentModule @user @login
  Scenario Outline: User verify paid payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify paid status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | User Overview           | My Payment Overview | paid    |

  @PPM_TC_50_4_1 @PaymentOverview @PaymentModule @card-owner @login
  Scenario Outline: Card Owner verify expired payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify expired status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | Have Payment Request    | My Payment Overview | expired |

  @PPM_TC_50_4_2 @PaymentOverview @PaymentModule @authorized-user @login
  Scenario Outline: Authorized User verify expired payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify expired status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | Authorize User Overview | My Payment Overview | expired |

  @PPM_TC_50_4_3 @PaymentOverview @PaymentModule @login @user
  Scenario Outline: User verify expired payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify expired status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | User Overview           | My Payment Overview | expired |

  @PPM_TC_51_1 @PaymentOverview @PaymentModule @card-owner @login
  Scenario Outline: Card Owner verify payment detail information
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And go to the payment detail
#    And verify payment detail information

    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |



  @PPM_TC_51_2 @PaymentOverview @PaymentModule @authorized-user @login
  Scenario Outline: Authorized User verify payment detail information Authorized User
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And go to the payment detail
#    And verify payment detail information

    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | upcoming    |


  @PPM_TC_51_3 @PaymentOverview @PaymentModule @login @user
  Scenario Outline: User verify payment detail information Authorized User
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And go to the payment detail
#    And verify payment detail information

    Examples:
      | condition               | menu                | keyword     |
      | User Overview           | My Payment Overview | outstanding |


  @pageFilter @PaymentOverview @PaymentModule @login @card-owner
  Scenario Outline: Card Owner try to change page setting
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    And select filter page "<page>"

    Examples:
      | condition            | menu                | page |
      | Have Payment Request | My Payment Overview | 20   |


  @pageFilter @PaymentOverview @PaymentModule @login
  Scenario Outline: Authorize User try to change page setting
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    And select filter page "<page>"

    Examples:
      | condition               | menu                | page |
      | Authorize User Overview | My Payment Overview | 40   |

  @pageFilterUser @PaymentOverview @PaymentModule @login
  Scenario Outline: User try to change page setting
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    And select filter page "<page>"

    Examples:
      | condition               | menu                | page |
      | User Overview           | My Payment Overview | 70   |

  @PPM_TC_27 @PaymentOverview @PaymentModule @card-owner @login
  Scenario Outline: Card owner do the manual payment with payNow
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And verify button checkout enable to click
#    And user pay with payNow
#    And user click pay after checkout

    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |

  @PPM_TC_28 @PaymentOverview @PaymentModule @authorized-user @login
  Scenario Outline: Authorized user do manual payment with payNow
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And verify button checkout enable to click
#    And user pay with payNow
#    And user click pay after checkout

    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | outstanding |


  @PPM_TC_29 @PaymentOverview @PaymentModule @authorized-user @login
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


  @PPM_TC_30 @PaymentOverview @PaymentModule @login @card-owner
  Scenario Outline: Card Owner do the manual payment with CC
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And verify button checkout enable to click
#    And user click pay for CC after checkout

    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |

  @PPM_TC_34 @PaymentOverview @PaymentModule @login @authorized-user
  Scenario Outline: Authorized user do the manual payment with CC
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And verify button checkout enable to click
#    And user click pay for CC after checkout

    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | outstanding |


  @PPM_TC_35 @PaymentOverview @PaymentModule @login @card-owner
  Scenario Outline: Card Owner do the bulk payment with CC
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And user click checkbox bulk outstanding
#    And user click checkbox bulk checkout
#    Then user click pay for CC after checkout


    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |

  @PPM_TC_36 @PaymentOverview @PaymentModule @login @authorized-user
  Scenario Outline: Authorized user do the bulk payment with CC
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And user click checkbox bulk outstanding
#    And user click checkbox bulk checkout
#    Then user click pay for CC after checkout


    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | outstanding |

  @PPM_TC_30 @PaymentOverview @PaymentModule @login @card-owner
  Scenario Outline: Card Owner do the bulk payment with PayNow
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And user click checkbox bulk outstanding
#    And user click checkbox bulk checkout
#    And user pay with payNow
#    And user click pay after checkout


    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |

  @PPM_TC_31 @PaymentOverview @PaymentModule @authorized-user @login
  Scenario Outline: Authorized user do the bulk payment with PayNow
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And user click checkbox bulk outstanding
#    And user click checkbox bulk checkout
#    And user pay with payNow
#    And user click pay after checkout


    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | outstanding |


  #PaymentNotification

  @PN1 @PaymentNotification
  Scenario Outline: create request payment upcoming to get notification
    Given user get SSO token
    When user create upcoming payment request
    Then get triggered "<email>" notification


    Examples:
      | email              | menu                | keyword |
      | sgpcn2@yopmail.com | My Payment Overview | REF-    |

  @PN2_3 @PaymentNotification
  Scenario Outline: create request payment outstanding to get notification
    Given user get SSO token
    When user create upcoming payment request
    Then get triggered "<email>" notification


    Examples:
      | email                | menu                | keyword |
      | sgpcn2@yopmail.com | My Payment Overview   | REF-    |

  @PN2_3 @PaymentNotification
  Scenario Outline: create payment but fail then get notification
    Given user get SSO token
    When create payment but fail
    Then get triggered "<email>" notification


    Examples:
      | email                | menu                | keyword |
      | sgpcn2@yopmail.com | My Payment Overview   | REF-    |


  @PN4 @PaymentNotification
  Scenario Outline: update payment to expired to get notification
    Given user get SSO token
    When user create upcoming payment request
    And update payment request to "<status>"
    Then get triggered "<email>" notification


    Examples:
      | email                | status    | keyword |
      | sgpcn2@yopmail.com   | EXPIRED   | REF-    |

    ##COPIED SCRIPT

  @PPM_TC_49_1 @PaymentOverview @PaymentModule @login @card-owner
  Scenario Outline: Card Owner verify field to be display on my payment
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment

    Examples:
      | condition               | menu                |
      | Have Payment Request    | My Payment Overview |

  @PPM_TC_49_2 @PaymentOverview @PaymentModule @login @authorized-user
  Scenario Outline: Authorized User verify field to be display on my payment
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment

    Examples:
      | condition               | menu                |
      | Authorize User Overview | My Payment Overview |


  @PPM_TC_49_3 @PaymentOverview @PaymentModule @user @login
  Scenario Outline: User verify field to be display on my payment
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment

    Examples:
      | condition               | menu                |
      | User Overview           | My Payment Overview |


  @PPM_TC_53_1 @keywordFilter @PaymentOverview @PaymentModule @card-owner @login
  Scenario Outline: Card Owner find certain keyword
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"

    Examples:
      | condition               | menu                | keyword  |
      | Have Payment Request    | My Payment Overview | Deduct   |

  @PPM_TC_53_2 @keywordFilter @PaymentOverview @PaymentModule @login @authorized-user
  Scenario Outline: Authorized User verify field to be display on my payment
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"

    Examples:
      | condition               | menu                | keyword |
      | Authorize User Overview | My Payment Overview | Card    |

  @PPM_TC_53_3 @keywordFilter @PaymentOverview @PaymentModule @login @user
  Scenario Outline: User verify field to be display on my payment
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"

    Examples:
      | condition               | menu                | keyword |
      | User Overview           | My Payment Overview | Auto    |

  @PPM_TC_50_1_1 @PaymentOverview @PaymentModule @card-owner @login
  Scenario Outline: Card Owner verify upcoming payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify upcoming status color code is correct
#    And verify button checkout unable to click

    Examples:
      | condition               | menu                | keyword  |
      | Have Payment Request    | My Payment Overview | upcoming |

  @PPM_TC_50_1_2 @PaymentOverview @PaymentModule @authorized-user @login
  Scenario Outline: Authorized User verify upcoming payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify upcoming status color code is correct
#    And verify button checkout unable to click

    Examples:
      | condition               | menu                | keyword  |
      | Authorize User Overview | My Payment Overview | upcoming |

  @PPM_TC_50_1_3 @PaymentOverview @PaymentModule @user @login
  Scenario Outline: User verify upcoming payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify upcoming status color code is correct
#    And verify button checkout unable to click

    Examples:
      | condition               | menu                | keyword  |
      | User Overview           | My Payment Overview | upcoming |

  @PPM_TC_50_2_1 @PaymentOverview @PaymentModule @card-owner @login
  Scenario Outline: Card Owner verify outstanding payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify outstanding status color code is correct
#    And verify button checkout enable to click

    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |


  @PPM_TC_50_2_2 @PaymentOverview @PaymentModule @authorized-user @login
  Scenario Outline: User verify outstanding payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify outstanding status color code is correct
#    And verify button checkout enable to click

    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | outstanding |

  @PPM_TC_50_2_3 @PaymentOverview @PaymentModule @login @user
  Scenario Outline: User verify outstanding payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify outstanding status color code is correct
#    And verify button checkout enable to click

    Examples:
      | condition               | menu                | keyword     |
      | User Overview           | My Payment Overview | outstanding |


  @PPM_TC_50_3_1 @PaymentOverview @PaymentModule @card-owner @login
  Scenario Outline: Card Owner verify paid payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify paid status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | Have Payment Request    | My Payment Overview | paid    |


  @PPM_TC_50_3_2 @PaymentOverview @PaymentModule @authorized-user @login
  Scenario Outline: Authorized User verify paid payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify paid status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | Authorize User Overview | My Payment Overview | paid    |


  @PPM_TC_50_3_3 @PaymentOverview @PaymentModule @user @login
  Scenario Outline: User verify paid payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify paid status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | User Overview           | My Payment Overview | paid    |

  @PPM_TC_50_4_1 @PaymentOverview @PaymentModule @card-owner @login
  Scenario Outline: Card Owner verify expired payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify expired status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | Have Payment Request    | My Payment Overview | expired |

  @PPM_TC_50_4_2 @PaymentOverview @PaymentModule @authorized-user @login
  Scenario Outline: Authorized User verify expired payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify expired status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | Authorize User Overview | My Payment Overview | expired |

  @PPM_TC_50_4_3 @PaymentOverview @PaymentModule @login @user
  Scenario Outline: User verify expired payment request status
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    Then verify expired status color code is correct

    Examples:
      | condition               | menu                | keyword |
      | User Overview           | My Payment Overview | expired |

  @PPM_TC_51_1 @PaymentOverview @PaymentModule @card-owner @login
  Scenario Outline: Card Owner verify payment detail information
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And go to the payment detail
#    And verify payment detail information

    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |



  @PPM_TC_51_2 @PaymentOverview @PaymentModule @authorized-user @login
  Scenario Outline: Authorized User verify payment detail information Authorized User
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And go to the payment detail
#    And verify payment detail information

    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | upcoming    |


  @PPM_TC_51_3 @PaymentOverview @PaymentModule @login @user
  Scenario Outline: User verify payment detail information Authorized User
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And go to the payment detail
#    And verify payment detail information

    Examples:
      | condition               | menu                | keyword     |
      | User Overview           | My Payment Overview | outstanding |

  @pageFilter @PaymentOverview @PaymentModule @login @card-owner
  Scenario Outline: Card try to change page setting
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    And select filter page "<page>"

    Examples:
      | condition            | menu                | page |
      | Have Payment Request | My Payment Overview | 20   |

  @PPM_TC_27 @PaymentOverview @PaymentModule @card-owner @login
  Scenario Outline: Card owner do the manual payment with payNow
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And verify button checkout enable to click
#    And user pay with payNow
#    And user click pay after checkout

    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |

  @PPM_TC_28 @PaymentOverview @PaymentModule @authorized-user @login
  Scenario Outline: Authorized user do manual payment with payNow
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And verify button checkout enable to click
#    And user pay with payNow
#    And user click pay after checkout

    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | outstanding |


  @PPM_TC_30 @PaymentOverview @PaymentModule @login @card-owner
  Scenario Outline: Card Owner do the manual payment with CC
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And verify button checkout enable to click
#    And user click pay for CC after checkout

    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |

  @PPM_TC_34 @PaymentOverview @PaymentModule @login @authorized-user
  Scenario Outline: Authorized user do the manual payment with CC
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And verify button checkout enable to click
#    And user click pay for CC after checkout

    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | outstanding |


  @PPM_TC_35 @PaymentOverview @PaymentModule @login @card-owner
  Scenario Outline: Card Owner do the bulk payment with CC
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And user click checkbox bulk outstanding
#    And user click checkbox bulk checkout
#    Then user click pay for CC after checkout


    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |

  @PPM_TC_36 @PaymentOverview @PaymentModule @login @authorized-user
  Scenario Outline: Authorized user do the bulk payment with CC
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And user click checkbox bulk outstanding
#    And user click checkbox bulk checkout
#    Then user click pay for CC after checkout


    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | outstanding |

  @PPM_TC_30 @PaymentOverview @PaymentModule @login @card-owner
  Scenario Outline: Card Owner do the bulk payment with PayNow
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And user click checkbox bulk outstanding
#    And user click checkbox bulk checkout
#    And user pay with payNow
#    And user click pay after checkout


    Examples:
      | condition               | menu                | keyword     |
      | Have Payment Request    | My Payment Overview | outstanding |

  @PPM_TC_31 @PaymentOverview @PaymentModule @authorized-user @login
  Scenario Outline: Authorized user do the bulk payment with PayNow
    Given "<condition>" login to the web
#    When User go to "<menu>"
#    Then verify field to be display on my payment
#    When input filter keyword "<keyword>"
#    And user click checkbox bulk outstanding
#    And user click checkbox bulk checkout
#    And user pay with payNow
#    And user click pay after checkout


    Examples:
      | condition               | menu                | keyword     |
      | Authorize User Overview | My Payment Overview | outstanding |
