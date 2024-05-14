Feature: 2104 CMS Geolocation feature � Allow pricing info by countries

  @subscriptionscsmgeos_publicuser_sg @e2e @bundlesubscriptions
  Scenario Outline: View public users from varies countries Singapore, product/bundle price showing in SGD
    Given go to main web
    Given "User A" click product tab to subscribe to product
    Then Select plan "Plan A" "<product>"
    And verify the currency as "<currency>"

    Examples:
      | product                      | currency |
      | Bundle (AWB, BC) Non Company | SGD      |

  @subscriptionscsmgeos_publicuser_ch @e2e @bundlesubscriptions
  Scenario Outline: View public users from varies countries China, product/bundle price showing in CNY
    Given go to main web
    Given "User A" click product tab to subscribe to product
    Then Select plan "Plan A" "<product>"
    And verify the currency as "<currency>"

    Examples:
      | product                      | currency |
      | Bundle (AWB, BC) Non Company | CNY      |

  @subscriptionscsmgeos_publicuser_in @e2e @bundlesubscriptions
  Scenario Outline: View public users from varies countries India, product/bundle price showing in INR
    Given go to main web
    Given "User A" click product tab to subscribe to product
    Then Select plan "Plan A" "<product>"
    And verify the currency as "<currency>"

    Examples:
      | product                      | currency |
      | Bundle (AWB, BC) Non Company | INR      |

  @subscriptionscsmgeos_publicuser_my @e2e @bundlesubscriptions
  Scenario Outline: View public users from varies countries Malaysia, product/bundle price showing in RM
    Given go to main web
    Given "User A" click product tab to subscribe to product
    Then Select plan "Plan A" "<product>"
    And verify the currency as "<currency>"

    Examples:
      | product                      | currency |
      | Bundle (AWB, BC) Non Company | RM       |

  @subscriptionscsmgeos_publicuser_lk @e2e @bundlesubscriptions
  Scenario Outline: View public users from varies countries Sri Lanka, product/bundle price showing in LKR
    Given go to main web
    Given "User A" click product tab to subscribe to product
    Then Select plan "Plan A" "<product>"
    And verify the currency as "<currency>"

    Examples:
      | product                      | currency |
      | Bundle (AWB, BC) Non Company | LKR      |

  @subscriptionscsmgeos_publicuser_uae @e2e @bundlesubscriptions
  Scenario Outline: View public users from varies countries United Emirate Arab, product/bundle price showing in AED
    Given go to main web
    Given "User A" click product tab to subscribe to product
    Then Select plan "Plan A" "<product>"
    And verify the currency as "<currency>"

    Examples:
      | product                      | currency |
      | Bundle (AWB, BC) Non Company | AED      |

  @subscriptionscsmgeos_nonpublicuser_sg @e2e @bundlesubscriptions
  Scenario Outline: View Giro payment setup for Singapore company Subscription and transaction charge product page for product price as Singapore user in SGD
    Given go to main web
    Given press sign in button
    And registration with new account and login
    And will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And input company name "<companyName>"
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
    #main test 1
    Given "User A" click product tab to subscribe to product
    #Then verify giro payment by api
    And Select plan "Plan A" "<product>"
    And verify the currency as "<currency>"

    Examples:
      | currency | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | SGD      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @subscriptionscsmgeos_nonpublicuser_ch
  Scenario Outline: View Post payment setup for China company Subscription and transaction charge product page for product price as China user in CNY
    Given go to main web
    Given press sign in button
    And registration with new account and try login china
    And will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And input company name "<companyName>"
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
    Then finally successfully to the setup post payment
    And receive email notification giro setup
    #main test 1
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And verify the currency as "<currency>"

    Examples:
      | currency | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country    | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | CNY      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | CN - CHINA | CAN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @subscriptionscsmgeos_nonpublicuser_in
  Scenario Outline: View Post payment setup for India company Subscription and transaction charge product page for product price as China user in INR
    Given go to main web
    Given press sign in button
    And registration with new account and try login china
    And will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And input company name "<companyName>"
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
    Then finally successfully to the setup post payment
    And receive email notification giro setup
    #main test 1
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And verify the currency as "<currency>"

    Examples:
      | currency | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country    | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | INR      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | IN - INDIA | BOM  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @subscriptionscsmgeos_nonpublicuser_id
  Scenario Outline: View Post payment setup for Indonesia company Subscription and transaction charge product page for product price as China user in USD (NON MAIN CSM GEO COUNTRY NOW)
    Given go to main web
    Given press sign in button
    And registration with new account and try login china
    And will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And input company name "<companyName>"
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
    Then finally successfully to the setup post payment
    And receive email notification giro setup
    #main test 1
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And verify the currency as "<currency>"

    Examples:
      | currency | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | USD      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | ID - INDONESIA | CGK  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @subscriptionscsmgeos_nonpublicuser_ae
  Scenario Outline: View Post payment setup for United Emirate Arab company Subscription and transaction charge product page for product price as China user in AED
    Given go to main web
    Given press sign in button
    And registration with new account and try login china
    And will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And input company name "<companyName>"
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
    Then finally successfully to the setup post payment
    And receive email notification giro setup
    #main test 1
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And verify the currency as "<currency>"

    Examples:
      | currency | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country                   | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | AED      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | AE - UNITED ARAB EMIRATES | DXB  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @subscriptionscsmgeos_nonpublicuser_my
  Scenario Outline: View Non Giro/Post payment setup for Malaysia company, Subscription and transaction charge product page for product price as China user in RM
    Given go to main web
    Given press sign in button
    And registration with new account and login
    And will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And input company name "<companyName>"
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
    #main test 1
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Press Subscribe checkbox for the Bundle LFS BC Company Level plan complimentary subscription agreement
    And input number of member for product Bundle AWB, BC Non Company
    And Press Subscribe button for the Bundle LFS BC Company Level plan complimentary subscription
    And input checkout payment cardNumber form
    And input checkout payment cardExpiry form
    And input checkout payment cardCvc form
    And input checkout payment billingName form
#    And select checkout payment country
#    And click checkbox Securely save my information for 1-click checkout
    Then submit checkout payment
    And Succesfully subscribe the plan "<product>"

    Examples:
      | currency | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country       | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | RM       | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | MY - MALAYSIA | KUL  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @subscriptionscsmgeos_nonpublicuser_lk
  Scenario Outline: View Non Giro/Post payment setup for Malaysia company, Subscription and transaction charge product page for product price as China user in LKR
    Given go to main web
    Given press sign in button
    And registration with new account and login
    And will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And input company name "<companyName>"
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
    #main test 1
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Press Subscribe checkbox for the Bundle LFS BC Company Level plan complimentary subscription agreement
    And input number of member for product Bundle AWB, BC Non Company
    And Press Subscribe button for the Bundle LFS BC Company Level plan complimentary subscription
    And input checkout payment cardNumber form
    And input checkout payment cardExpiry form
    And input checkout payment cardCvc form
    And input checkout payment billingName form
    #And select checkout payment country
    #And click checkbox Securely save my information for 1-click checkout
    Then submit checkout payment
    And Succesfully subscribe the plan "<product>"

    Examples:
      | currency | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | LKR      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | LK - SRI LANKA | CMB  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |
