Feature: PCN
  PCN subscription

  PCN applies to company level and individual
  PCN charge different by countries, (e.g. Price, or Bundle including)
  PCN only applies to CCN products and CCN bundle for now.
  PCN applies to different products subscription (e.g. x% of each subscription. % can be different by different country)
  PCN applies to plan level
  PCN applies after discounted subscription amount
  Discount applicable to PCN
  Minimum charge applicable
  PCN charge monthly (1st day of each month based on Subscription of previous month)
  PCN charge flat fee across in city or company in CN market
  PCN Discount

  Discount can be % or absolute amount
  Discount has validity period
  Discount apply as discount code by PM via subscription
  Discount can be applied across to the whole region/country/cities (configurable at the backend)
  Discount can be applied to the product plan by default

  @PCNS1 @PCN
  Scenario Outline: [ONLINE] Subscription of the first month. PCN Configuration:  set to 20% of each subscription, PCN applies to all products, countries, cities, companies.
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>"
#    Given go to main web
#    And select plan test awbconcierge premium multicurrencysandbox
#    And Subscribe plan "<productB>"
#    And open subscriber payment form
#    When press second sign in button with email "<email2>" and password "<password>" plan C for AWB BC with "<inputSubs>"

    Examples:
      | email                       | password      | product                               | email2                       | productB                                       | productC      | inputSubs |
      | qa-ccn-47562@mailinator.com | CCNPegasus123 | Test BC-Premium Multicurrency#Sandbox | qa-ccn-75754@mailinator.com  | test awbconcierge premium multicurrencysandbox | Bundle BC AWB | 5         |


  @PCNS2_1 @PCNS2 @PCN
  Scenario Outline: [ONLINE] Subscription of the first month with different PM. PCN Configuration:  set to 20% of each subscription, PCN applies to all products, countries, cities, companies.
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>"

    Examples:
      | email                         | password      | product                              | email2                         | productB                                       | inputSubs |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | test bc premium multicurrencysandbox | sgqa-ccn-72921@mailinator.com  | test awbconcierge premium multicurrencysandbox | 5         |

  @PCNS2_1 @PCNS2 @PCN
  Scenario Outline: [ONLINE] Subscription of the first month with different PM. PCN Configuration:  set to 20% of each subscription, PCN applies to all products, countries, cities, companies.
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>"

    Examples:
      | email                | password      | product                              | email2                         | productB                                       | inputSubs |
      | malaypcn@yopmail.com | CCNPegasus123 | test bc premium multicurrencysandbox | sgqa-ccn-72921@mailinator.com  | test awbconcierge premium multicurrencysandbox | 5         |

  @PCNS3 @PCN
  Scenario Outline: [ONLINE] Subscription of the subsequent month (with new subscription). PCN Configuration:  set to 20% of each subscription; PCN applies to all products, countries, cities, companies. or for specify flat rate product.
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 2 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>"



    Examples:
      | email                 | password      | product                              |
      | malaypcn2@yopmail.com | CCNPegasus123 | test bc premium multicurrencysandbox |

  @PCNS4 @PCN
  Scenario Outline: [ONLINE] Subscription of the subsequent month (with new PM Join). PCN Configuration:  set to 10% of each subscription; PCN applies to all products, countries, cities, companies.
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>"


    Examples:
      | email             | password      | product                              |
      | sgpcn@yopmail.com | CCNPegasus123 | test bc premium multicurrencysandbox |

  @PCNS5 @PCN
  Scenario Outline: [ONLINE] Subscription Does not meet minimum PCN Charge. PCN Configuration:  set to 20% of each subscription, PCN applies to all products, countries, cities, companies. (include partner product)
    Given go to main web
    When click initial sign in button
#    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>"

    Examples:
      | email                         | password      | product                              |
      | sgpcn@yopmail.com             | CCNPegasus123 | test bc premium multicurrencysandbox |

  @PCNS6 @PCN
  Scenario Outline: [ONLINE] Subscription meet minimum PCN Charge. PCN Configuration:  set to 20% of each subscription, PCN applies to all products, countries, cities, companies.
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And select plan bundle BC AWB
#    And Subscribe plan "<product>"
#    Given go to main web
#    When "PM 1 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<productB>"
#    Given go to main web
#    When "PM 1 Company A" click product tab to subscribe to product
#    And select plan test awbconcierge premium multicurrencysandbox
#    And Subscribe plan "<productC>"

    Examples:
      | email               | password      | product       | productB                             | productC                                       |
      | sripcn2@yopmail.com | CCNPegasus123 | Bundle BC AWB | test bc premium multicurrencysandbox | test awbconcierge premium multicurrencysandbox |

  @PCNS7 @PCN
  Scenario Outline: [ONLINE] Subscription Partner Product then no PCN charge. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies. A 10% discount is set for PCN.
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And select plan Lead Freight Solutions
#    And Subscribe plan "<product>"

    Examples:
      | email              | password      | product                                       |
      | sripcn@yopmail.com | CCNPegasus123 | Freight Management System - LFS Multi Upgrade |


  @PCNS9 @PCN
  Scenario Outline: [ONLINE] subscribe specify product flat rate
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And select plan Test IATA TACT RATE-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>"

    Examples:
      | email              | password      | product                                           |
      | sripcn@yopmail.com | CCNPegasus123 | Test IATA TACT RATE-Premium Multicurrency#Sandbox |

  @PCNS10 @PCN
  Scenario Outline: [ONLINE] Apply discount when meet with the coupon criteria
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And select plan test awbconcierge premium multicurrencysandbox
#    And Subscribe plan "<product>" and input coupon "<coupon>"

    Examples:
      | email              | password      | product                                        | coupon             |
      | sripcn@yopmail.com | CCNPegasus123 | test awbconcierge premium multicurrencysandbox | UATSUBSPCNOFFLINE1 |

  @PCNS13 @PCN
  Scenario Outline: [ONLINE] Apply discount to specify company
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And select plan test awbconcierge premium multicurrencysandbox
#    And Subscribe plan "<product>" and input coupon "<coupon>"

    Examples:
      | email               | password      | product                                        | coupon             |
      | thaipcn@yopmail.com | CCNPegasus123 | test awbconcierge premium multicurrencysandbox | UATSUBSPCN13       |

  @PCNS14 @PCN
  Scenario Outline: [ONLINE] Apply discount to specify pm
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And select plan test awbconcierge premium multicurrencysandbox
#    And Subscribe plan "<product>" and input coupon "<coupon>"

    Examples:
      | email                | password      | product                                        | coupon      |
      | thaipcn2@yopmail.com | CCNPegasus123 | test awbconcierge premium multicurrencysandbox | UATSUBSPCN4 |

  @PCNS15 @PCN
  Scenario Outline: [ONLINE] Apply discount to specify plan
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>" and input coupon "<coupon>"

    Examples:
      | email                | password      | product                              | coupon       |
      | thaipcn2@yopmail.com | CCNPegasus123 | test bc premium multicurrencysandbox | UATSUBSPCN14 |

  @PCNS15 @PCN
  Scenario Outline: [ONLINE] Apply discount to specify plan type I/C
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>" and input coupon "<coupon>"

    Examples:
      | email                | password      | product                              | coupon       |
      | thaipcn2@yopmail.com | CCNPegasus123 | test bc premium multicurrencysandbox | UATSUBSPCN17 |

  @PCNS11 @PCN
  Scenario Outline: [ONLINE] Apply discount when doesn't meet with the coupon criteria
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And select plan test awbconcierge premium multicurrencysandbox
#    And Subscribe plan "<product>" and input coupon "<coupon>"

    Examples:
      | email              | password      | product                                        | coupon             |
      | sripcn@yopmail.com | CCNPegasus123 | test awbconcierge premium multicurrencysandbox | UATSUBSPCNOFFLINE2 |

  @PCN12 @PCN
  Scenario Outline: [ONLINE] PCN charges can be set a specify % of subscription charge, applied to a specify product/plan
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>"

    Examples:
      | email                         | password      | product                              |
      | qa-ccn-23395@mailinator.com   | CCNPegasus123 | test bc premium multicurrencysandbox |

  @PCNS8 @PCN
  Scenario Outline: [OFFLINE] subscribe flat rate for CN market
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    And select plan BC CN Market
#    And contact us on plan BC CN Market

    Examples:
      | email                       | password      |
      | qa-ccn-09538@mailinator.com | CCNPegasus123 |

  @PCNS1 @PCN
  Scenario Outline: [OFFLINE] Subscription of the first month. PCN Configuration:  set to 20% of each subscription, PCN applies to all products, countries, cities, companies.
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>"
#    Given go to main web
#    And select plan test awbconcierge premium multicurrencysandbox
#    And Subscribe plan "<productB>"
#    And open subscriber payment form
#    When press second sign in button with email "<email2>" and password "<password>" plan C for AWB BC with "<inputSubs>"

    Examples:
      | email                           | password      | product                               | email2                       | productB                                       | productC      | inputSubs |
      | indoqa-ccn-47591568@yopmail.com | CCNPegasus123 | Test BC-Premium Multicurrency#Sandbox | qa-ccn-75754@mailinator.com  | test awbconcierge premium multicurrencysandbox | Bundle BC AWB | 5         |


  @PCNS2_1 @PCNS2 @PCN
  Scenario Outline: [OFFLINE] Subscription of the first month with different PM. PCN Configuration:  set to 20% of each subscription, PCN applies to all products, countries, cities, companies.
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>"

    Examples:
      | email                          | password      | product                              | email2                         | productB                                       | inputSubs |
      | uaeqa-ccn-74616801@yopmail.com | CCNPegasus123 | test bc premium multicurrencysandbox | sgqa-ccn-72921@mailinator.com  | test awbconcierge premium multicurrencysandbox | 5         |

  @PCNS2_1 @PCNS2 @PCN
  Scenario Outline: [OFFLINE] Subscription of the first month with different PM. PCN Configuration:  set to 20% of each subscription, PCN applies to all products, countries, cities, companies.
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>"

    Examples:
      | email                           | password      | product                              | email2                         | productB                                       | inputSubs |
      | indoqa-ccn-40425212@yopmail.com | CCNPegasus123 | test bc premium multicurrencysandbox | sgqa-ccn-72921@mailinator.com  | test awbconcierge premium multicurrencysandbox | 5         |

  @PCNS3 @PCN
  Scenario Outline: [OFFLINE] Subscription of the subsequent month (with new subscription). PCN Configuration:  set to 20% of each subscription; PCN applies to all products, countries, cities, companies. or for specify flat rate product.
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 2 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>"



    Examples:
      | email                          | password      | product                              |
      | uaeqa-ccn-19407167@yopmail.com | CCNPegasus123 | test bc premium multicurrencysandbox |

  @PCNS4 @PCN
  Scenario Outline: [OFFLINE] Subscription of the subsequent month (with new PM Join). PCN Configuration:  set to 10% of each subscription; PCN applies to all products, countries, cities, companies.
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>"


    Examples:
      | email                           | password      | product                              |
      | indoqa-ccn-14890676@yopmail.com | CCNPegasus123 | test bc premium multicurrencysandbox |

  @PCNS5 @PCN
  Scenario Outline: [OFFLINE] Subscription Does not meet minimum PCN Charge. PCN Configuration:  set to 20% of each subscription, PCN applies to all products, countries, cities, companies. (include partner product)
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>"

    Examples:
      | email                            | password      | product                              |
      | indoqa-ccn-11875860@yopmail.com  | CCNPegasus123 | test bc premium multicurrencysandbox |

  @PCNS6 @PCN
  Scenario Outline: [OFFLINE] Subscription meet minimum PCN Charge. PCN Configuration:  set to 20% of each subscription, PCN applies to all products, countries, cities, companies.
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And select plan bundle BC AWB
#    And Subscribe plan "<product>"
#    Given go to main web
#    When "PM 1 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<productB>"
#    Given go to main web
#    When "PM 1 Company A" click product tab to subscribe to product
#    And select plan test awbconcierge premium multicurrencysandbox
#    And Subscribe plan "<productC>"

    Examples:
      | email                           | password      | product       | productB                             | productC                                       |
      | indoqa-ccn-96297200@yopmail.com | CCNPegasus123 | Bundle BC AWB | test bc premium multicurrencysandbox | test awbconcierge premium multicurrencysandbox |

  @PCNS7 @PCN
  Scenario Outline: [OFFLINE] Subscription Partner Product then no PCN charge. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies. A 10% discount is set for PCN.
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And select plan Lead Freight Solutions
#    And Subscribe plan "<product>"

    Examples:
      | email                           | password      | product                                       |
      | indoqa-ccn-47591568@yopmail.com | CCNPegasus123 | Freight Management System - LFS Multi Upgrade |


  @PCNS9 @PCN
  Scenario Outline: [OFFLINE] subscribe specify product flat rate
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And select plan Test IATA TACT RATE-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>"

    Examples:
      | email                           | password      | product                                           |
      | indoqa-ccn-47591568@yopmail.com | CCNPegasus123 | Test IATA TACT RATE-Premium Multicurrency#Sandbox |

  @PCNS10 @PCN
  Scenario Outline: [OFFLINE] Apply discount when meet with the coupon criteria
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And select plan test awbconcierge premium multicurrencysandbox
#    And Subscribe plan "<product>" and input coupon "<coupon>"

    Examples:
      | email                           | password      | product                                        | coupon             |
      | indoqa-ccn-06843969@yopmail.com | CCNPegasus123 | test awbconcierge premium multicurrencysandbox | UATSUBSPCNOFFLINE1 |


  @PCNS11 @PCN
  Scenario Outline: [OFFLINE] Apply discount when doesn't meet with the coupon criteria
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And select plan test awbconcierge premium multicurrencysandbox
#    And Subscribe plan "<product>" and input coupon "<coupon>"

    Examples:
      | email                          | password      | product                                        | coupon             |
      | uaeqa-ccn-34314855@yopmail.com | CCNPegasus123 | test awbconcierge premium multicurrencysandbox | UATSUBSPCNOFFLINE2 |

  @PCN12 @PCN
  Scenario Outline: [OFFLINE] PCN charges can be set a specify % of subscription charge, applied to a specify product/plan
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
#    And back to the main tab browser
#    When "PM 1 Company A" click product tab to subscribe to product
#    And Select plan Test BC-Premium Multicurrency#Sandbox
#    And Subscribe plan "<product>"

    Examples:
      | email                            | password      | product                              |
      | uaeqa-ccn-70545671@yopmail.com   | CCNPegasus123 | test bc premium multicurrencysandbox |

#  @createUserMalay
#  Scenario Outline: create user from malaysia
#    Given go to main web
#    Given press sign in button
#    When registration with new account from malaysia "<city>" and "<country>" login
#    Then will redirected to suggested company list which match with domain name of the users
#
#    Examples:
#      | city         | country  |
#      | KUALA LUMPUR | Malaysia |
#
#
#  @create_user_INDO
#  Scenario Outline: create user from indonesia
#    Given go to main web
#    Given press sign in button
#    When registration with new account from INDO "<city>" and "<country>" login
#    Then will redirected to suggested company list which match with domain name of the users
#
#    Examples:
#      | city         | country   |
#      | YOGYAKARTA    | Indonesia |
#
#  @createUserUAE
#  Scenario Outline: create user from united arab emirates
#    Given go to main web
#    Given press sign in button
#    When registration with new account from UAE "<city>" and "<country>" login
#    Then will redirected to suggested company list which match with domain name of the users
#
#    Examples:
#      | city      | country              |
#      | ABU DHABI | United Arab Emirates |
#
#
#  @create_user_company_my
#  Scenario Outline: create user company malaysia
#    Given go to main web
#    Given press sign in button
#    When registration with new account from malaysia "<city>" and "<country>" login
#    Then will redirected to suggested company list which match with domain name of the users
#    When system didn't found the suggested company matched
#    And input company name "<companyName>" from "<country>" dynamics
#    And input company registration "<companyRegis>"
#    And input company type "<typeOfCompany>"
#    And input country "<countryB>"
#    And input city "<cityB>"
#    And theres button to create company with the status was enabled to create company
#    Then the user was able to create a new company
#    When press create company button
#    And input contact details IATA membership number "<iataNo>"
#    And input contact details CASS number "<cassNo>"
#    And input registered office address "<officeAddress>" for company detail
#    And input post code "<postCode>" for company detail
#    And input company email "<companyemail>" for company detail
#    And input mobile number detail company "<mobileNoCompany>" for company detail
#    And input mailing address complete from same as registered company address
#    And input contact details name "<name>"
#    And input contact details designation "<designation>"
#    And input contact details mobile no "<mobileNo>"
#    And input contact details email "<email>"
#    And press submit create company
#
#    Examples:
#      | companyemail   | email             | password      | companyName  | companyRegis | typeOfCompany | countryB       | city          | name    | designation | mobileNo     | iataNo  | cassNo | officeAddress       | postCode | mobileNoCompany | product       | cityB         | country  |
#      | my@yopmail.com | myper@yopmail.com | CCNPegasus123 | Test         | MY           | GSA           | MY - MALAYSIA  | KUALA LUMPUR  | my test | marketing   | 081234567891 | 1234567 | 1234   | 101 Cantonment road |   089774 |      1111111111 | AWB Concierge | KUL  | Malaysia |
#
##    //63774212
#  @create_user_company_UAE
#  Scenario Outline: create user company united arab emirates
#    Given go to main web
#    Given press sign in button
#    When registration with new account from UAE "<city>" and "<country>" login
#    Then will redirected to suggested company list which match with domain name of the users
#    When system didn't found the suggested company matched
#    And input company name "<companyName>" from "<companyRegis>" dynamics
#    And input company registration "<companyRegis>"
#    And input company type "<typeOfCompany>"
#    And input country "<countryB>"
#    And input city "<cityB>"
#    And theres button to create company with the status was enabled to create company
#    Then the user was able to create a new company
#    When press create company button
#    And input contact details IATA membership number "<iataNo>"
#    And input contact details CASS number "<cassNo>"
#    And input registered office address "<officeAddress>" for company detail
#    And input post code "<postCode>" for company detail
#    And input company email "<companyemail>" for company detail
#    And input mobile number detail company "<mobileNoCompany>" for company detail
#    And input mailing address complete from same as registered company address
#    And input contact details name "<name>"
#    And input contact details designation "<designation>"
#    And input contact details mobile no "<mobileNo>"
#    And input contact details email "<email>"
#    And press submit create company
#
#    Examples:
#      | companyemail    | email              | password      | companyName  | companyRegis | typeOfCompany | countryB                   | city       | name     | designation    | mobileNo     | iataNo  | cassNo | officeAddress       | postCode | mobileNoCompany | product       | cityB           | country              |
#      | uae@yopmail.com | uaeper@yopmail.com | CCNPegasus123 | Test         | UAE          | GSA           | AE - UNITED ARAB EMIRATES  | ABU DHABI  | uae comp | plan manager   | 081234567891 | 1234567 | 1234   | 101 Cantonment road |   089774 |      1111111111 | AWB Concierge | AUH - ABU DHABI | United Arab Emirates |
#
#  @create_user_company_INA
#  Scenario Outline: create user company from indonesia
#    Given go to main web
#    Given press sign in button
#    When registration with new account from INDO "<city>" and "<country>" login
#    Then will redirected to suggested company list which match with domain name of the users
#    When system didn't found the suggested company matched
#    And input company name "<companyName>" from "<country>" dynamics
#    And input company registration "<companyRegis>"
#    And input company type "<typeOfCompany>"
#    And input country "<countryB>"
#    And input city "<cityB>"
#    And theres button to create company with the status was enabled to create company
#    Then the user was able to create a new company
#    When press create company button
#    And input contact details IATA membership number "<iataNo>"
#    And input contact details CASS number "<cassNo>"
#    And input registered office address "<officeAddress>" for company detail
#    And input post code "<postCode>" for company detail
#    And input company email "<companyemail>" for company detail
#    And input mobile number detail company "<mobileNoCompany>" for company detail
#    And input mailing address complete from same as registered company address
#    And input contact details name "<name>"
#    And input contact details designation "<designation>"
#    And input contact details mobile no "<mobileNo>"
#    And input contact details email "<email>"
#    And press submit create company
#
#    Examples:
#      | companyemail    | email              | password      | companyName  | companyRegis | typeOfCompany | countryB        | city     | name                 | designation | mobileNo     | iataNo  | cassNo | officeAddress       | postCode | mobileNoCompany | product       | cityB            | country   |
#      | ina@yopmail.com | inawon@yopmail.com | CCNPegasus123 | Test         | INA          | GSA           | ID - INDONESIA  | JAKARTA  | perusahaan indonesia | marketing   | 081234567891 | 1234567 | 1234   | 101 Cantonment road |   089774 |      1111111111 | AWB Concierge | JOG - YOGYAKARTA | Indonesia |
#


  @create_user_company_SG
  Scenario Outline: create user company from singapore
    Given go to main web
    Given press sign in button
    When registration with new account yopmail and login
    Then will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And input company name "<companyName>" from "<country>" dynamics
    And input company registration "<companyRegis>"
    And input company type "<typeOfCompany>"
    And input country "<country>"
    And input city "<city>"
    And theres button to create company with the status was enabled to create company
    Then the user was able to create a new company
    When press create company button
    And input contact details IATA membership number "<iataNo>"
    And input contact details CASS number "<cassNo>"
    And input registered office address "<officeAddress>" for company detail
    And input post code "<postCode>" for company detail
    And input company email "<companyemail>" for company detail
    And input mobile number detail company "<mobileNoCompany>" for company detail
    And input mailing address complete from same as registered company address
    And input contact details name "<name>"
    And input contact details designation "<designation>"
    And input contact details mobile no "<mobileNo>"
    And input contact details email "<email>"
    And press submit create company
    Then will displayed pop up for post payment setup
    And click proceed pop up button for creating company to the post payment
    And click ok button from pop up confirmation that tells GIRO setup instructions has been sent to email
    Then finally successfully to the setup post payment
    And receive email notification giro setup

    Examples:
      | companyemail   | email             | password      | companyName | companyRegis | typeOfCompany | country        | city             | name              | designation | mobileNo     | iataNo  | cassNo | officeAddress       | postCode | mobileNoCompany |
      | sg@yopmail.com | sgsin@yopmail.com | CCNPegasus123 | Test        | SGCOM        | GSA           | SG - SINGAPORE | SIN - SINGAPORE  | singapore admin   | admin       | 081234567891 | 1234567 | 1234   | 101 Cantonment road |   089774 |      1111111111 |
#
#
#
#  @create_user_company_NZ
#  Scenario Outline: create user company from new zealand
#    Given go to main web
#    Given press sign in button
#    When registration with new account from NZ "<city>" and "<country>" login
#    Then will redirected to suggested company list which match with domain name of the users
#    When system didn't found the suggested company matched
#    And input company name "<companyName>" from "<country>" dynamics
#    And input company registration "<companyRegis>"
#    And input company type "<typeOfCompany>"
#    And input country "<countryB>"
#    And input city "<cityB>"
#    And theres button to create company with the status was enabled to create company
#    Then the user was able to create a new company
#    When press create company button
#    And input contact details IATA membership number "<iataNo>"
#    And input contact details CASS number "<cassNo>"
#    And input registered office address "<officeAddress>" for company detail
#    And input post code "<postCode>" for company detail
#    And input company email "<companyemail>" for company detail
#    And input mobile number detail company "<mobileNoCompany>" for company detail
#    And input mailing address complete from same as registered company address
#    And input contact details name "<name>"
#    And input contact details designation "<designation>"
#    And input contact details mobile no "<mobileNo>"
#    And input contact details email "<email>"
#    And press submit create company
#
#    Examples:
#      | companyemail   | email              | password      | companyName  | companyRegis| typeOfCompany | countryB          | city     | name       | designation  | mobileNo     | iataNo  | cassNo | officeAddress       | postCode | mobileNoCompany | product       | cityB          | country     |
#      | nz@yopmail.com | nzauck@yopmail.com | CCNPegasus123 | Test         | NZ          | GSA           | NZ - NEW ZEALAND  | AUCKLAND | NZ Company | Plan Manager | 481234567891 | 1234567 | 1234   | 101 Cantonment road |   089774 |      9348293493 | AWB Concierge | AKL - AUCKLAND | New Zealand |
