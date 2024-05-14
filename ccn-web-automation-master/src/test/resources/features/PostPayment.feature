Feature: 2255 Post payment for subscription and transaction charge

  @postpayment_sg
  Scenario Outline: Giro payment setup for Singapore company, Subscription and transaction charge as Singapore user
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

    #And Select plan "Plan A" "<product>"
    #And Press Subscribe checkbox for the Bundle LFS BC Company Level plan complimentary subscription agreement
    #And input number of member for product Bundle AWB, BC Non Company
    #And Press Subscribe button for the Bundle LFS BC Company Level plan complimentary subscription
    #Then Validate subscription Successful for plan "Plan A" "<product>" pop up massage

    Examples:
      | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @postpayment_sg_1
  Scenario Outline: Post payment setup for China company, Subscription and transaction charge as Singapore user
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
    Then finally successfully to the setup post payment
    #main test 1
    Given "User A" click product tab to subscribe to product
    #Then verify giro payment by api
    And Select plan "Plan A" "<product>"
    And Press Subscribe checkbox for the Bundle LFS BC Company Level plan complimentary subscription agreement
    And input number of member for product Bundle AWB, BC Non Company
    And Press Subscribe button for the Bundle LFS BC Company Level plan complimentary subscription
    Then Validate subscription Successful for plan "Plan A" "<product>" pop up massage
    And Validate country "<country>" csm geolocation
    And go to my icon account menu "My Subscriptions"
    And open email mailinator

    #And Succesfully subscribe the plan "<product>"
    Examples:
      | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country    | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | CN - CHINA | CAN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @postpayment_ch
  Scenario Outline: Post payment setup for China company, Subscription and transaction charge as China user
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
    #Then verify giro payment by api
    And Select plan "Plan A" "<product>"
    #And Press Subscribe checkbox for the Bundle LFS BC Company Level plan complimentary subscription agreement
    #And input number of member for product Bundle AWB, BC Non Company
    #And Press Subscribe button for the Bundle LFS BC Company Level plan complimentary subscription
    #Then Validate subscription Successful for plan "Plan A" "<product>" pop up massage
    #And Validate country "<country>" csm geolocation
    #And go to my icon account menuu "My Subscriptions"
    #And open email mailinator

    Examples:
      | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country    | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | CN - CHINA | CAN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @postpayment_in
  Scenario Outline: Post payment setup for India company, Subscription and transaction charge as China user
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
    #Then verify giro payment by api
    And Select plan "Plan A" "<product>"
    And Press Subscribe checkbox for the Bundle LFS BC Company Level plan complimentary subscription agreement
    And input number of member for product Bundle AWB, BC Non Company
    And Press Subscribe button for the Bundle LFS BC Company Level plan complimentary subscription
    Then Validate subscription Successful for plan "Plan A" "<product>" pop up massage
    And Validate country "<country>" csm geolocation
    And go to my icon account menu "My Subscriptions"
    And open email mailinator

    Examples:
      | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country    | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | IN - INDIA | BOM  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @postpayment_id
  Scenario Outline: Post payment setup for Indonesia company, Subscription and transaction charge as China user
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
    #Then verify giro payment by api
    And Select plan "Plan A" "<product>"
    And Press Subscribe checkbox for the Bundle LFS BC Company Level plan complimentary subscription agreement
    And input number of member for product Bundle AWB, BC Non Company
    And Press Subscribe button for the Bundle LFS BC Company Level plan complimentary subscription
    Then Validate subscription Successful for plan "Plan A" "<product>" pop up massage
    And Validate country "<country>" csm geolocation
    And go to my icon account menu "My Subscriptions"
    And open email mailinator

    Examples:
      | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | ID - INDONESIA | CGK  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @postpayment_uae
  Scenario Outline: Post payment setup for United Emirate Arab company, Subscription and transaction charge as China user
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
    #Then verify giro payment by api
    And Select plan "Plan A" "<product>"
    And Press Subscribe checkbox for the Bundle LFS BC Company Level plan complimentary subscription agreement
    And input number of member for product Bundle AWB, BC Non Company
    And Press Subscribe button for the Bundle LFS BC Company Level plan complimentary subscription
    Then Validate subscription Successful for plan "Plan A" "<product>" pop up massage
    And Validate country "<country>" csm geolocation
    And go to my icon account menu "My Subscriptions"
    And open email mailinator

    Examples:
      | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country                   | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | AE - UNITED ARAB EMIRATES | DXB  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @nonpostpayment
  Scenario Outline: Giro payment setup for Singapore company, Subscription and transaction charge as Singapore user
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
      | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |
