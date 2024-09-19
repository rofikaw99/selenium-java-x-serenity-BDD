Feature: Discount in Support App

  @Support_Discount1
  Scenario Outline: Create Discount
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to create discount menu
    And input create discount support web app with "<couponNameFill>" and "<amount>" and "<promoCodeFill>" and "<companyPromoFill>" and "<customer>" and "<priceID>" and "<country>" and "<city>"

    Examples:
      | userID   | password | couponNameFill | amount | promoCodeFill | companyPromoFill            | customer | priceID | country | city |
      | helpdesk | password | CouponTest     | 10     | Promo         | system.company@exchange.com | customer | pid1234 | AD      | AAE  |

  @Support_Plan1
  Scenario Outline: Create Plan
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When user go to create plan support web app menu
    And input create plan in support web app with "<name>" and "<productPlanName>" and "<description>"

    Examples:
      | userID   | password | name    | productPlanName | description |
      | helpdesk | password | PlanTest| ProductTest     | qc ccn test |


  @Support_Price1
  Scenario Outline: add new price on new plan
    Given go to support app web
    When input user ID "<userID>" and password "<password>" and submit button to continue login
    When add new price on new plan
    And add new price in support web app with "<nickName>" and "<unitAmount>" and "<memberLimit>"

    Examples:
      | userID   | password | nickName    | unitAmount  | memberLimit |
      | helpdesk | password | qa ccn test | 10          | 3           |

