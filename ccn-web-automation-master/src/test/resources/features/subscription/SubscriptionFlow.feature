Feature: Subscription feature flow enhancement

  Background:
  "User A" was from company "Company A"
  "User B" was from company "Company B"
  "User C" was from company "Company C"
  "User D" was from company "Company D"
  "User E" was from company "Company E"
  "User F" was from company "Company F"
  "User G" was from company "Pegasus CCN"
  The free trial for plan "Plan A" valid period was 30 days
  "Plan A" was user level plan/no company required
  The plan "Plan A" price was $1 for each user
  "Plan B" was company level plan
  The plan "Plan B" price was $2 for each user
  "unregistered@xyz.co.sg" email was not registered yet to the cube platform
  "Plan C" was company level plan
  "Plan D" was user level plan
  "User X" was not registered yet to the cube platform


  @subscription-2038-s4-1 @e2e @singlesubscriptions
  Scenario: S4 "User A" subscribe "Plan A" was able to unsubscribe plan "Plan A" without joining any company
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    When click product tab to subscribe to product
    And select bundle company level awb concierge lfs product
    And validate product price for tier 1 and tier 2
    And input the complete subscriber payment form
    Then validate for succesfully subscribe selected product

  @subscription-2038-s4-2 @e2e @singlesubscriptions
  Scenario Outline: S4 "User A" subscribe "Plan A" was able to unsubscribe plan "Plan A" already joining some company
    Given go to main web
    Given press sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    When "User A" click product tab to subscribe to product
    And select bundle company level awb concierge lfs product
    And validate product price for tier 1 and tier 2
    And input the complete subscriber payment form
    Then validate for succesfully subscribe selected product

    Examples:
      | email                       | password      |
      | qa-ccn-75754@mailinator.com | CCNPegasus123 |


  #@subscription-2038-s5 already covered in @1874

  @subscription-2038-s6-1 @e2e @singlesubscriptions
  Scenario: S6 "User A" subscribe plan "Plan C" and able to upgrade the tier without joining any company
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    When click product tab to subscribe to product
    And select bundle company level awb concierge lfs product
    And validate product price for tier 1 and tier 2
    And input the complete subscriber payment form
    Then validate for succesfully subscribe selected product

  @subscription-2038-s6-2 @e2e @singlesubscriptions
  Scenario: S6 "User A" subscribe plan "Plan C" and able to upgrade the tier already joining some company
    Given go to main web
    Given press sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    When "User A" click product tab to subscribe to product
    And select bundle company level awb concierge lfs product
    And validate product price for tier 1 and tier 2
    And input the complete subscriber payment form
    Then validate for succesfully subscribe selected product

    Examples:
      | email                       | password      |
      | qa-ccn-75754@mailinator.com | CCNPegasus123 |

  @subscription-2038-s7-1 @e2e @singlesubscriptions
  Scenario: S7 "User A" subscribe plan "Plan C" and able to downgrade the tier without joining any company
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    When click product tab to subscribe to product
    And select bundle company level awb concierge lfs product
    And validate product price for tier 2 and tier 1
    And input the complete subscriber payment form
    Then validate for succesfully subscribe selected product

  @subscription-2038-s7-2 @e2e @singlesubscriptions
  Scenario: S7 "User A" subscribe plan "Plan C" and able to downgrade the tier already joining some company
    Given go to main web
    Given press sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    When "User A" click product tab to subscribe to product
    And select bundle company level awb concierge lfs product
    And validate product price for tier 2 and tier 1
    And input the complete subscriber payment form
    Then validate for succesfully subscribe selected product

    Examples:
      | email                       | password      |
      | qa-ccn-75754@mailinator.com | CCNPegasus123 |

  @subscription-1874-s1-1 @e2e @singlesubscriptions
  Scenario Outline: S1 "User A" subscribe Free trial plan "Plan A" and cannot accommodate multiple users already have company
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Company"
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
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Press Subscribe checkbox for the free trial plan complimentary subscription agreement
    And Press Subscribe button for the free trial plan complimentary subscription
    Then Validate subscription Successful for plan "Plan A" "<product>" pop up massage
    And "User A" click product tab to subscribe to product
    And go to my icon account menu "My Subscriptions"
    Then free trial plan "Plan A" which is no company required cannot accommodate multiple users on table subscription "<product>" with "<usercount>"

    Examples:
      |usercount| product        | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      |1        | LFS Trial 1 day| qa-ccn-08987@mailinator.com | qa-ccn-08987@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @subscription-1874-s1 @e2e @singlesubscriptions
  Scenario Outline: S1 "User A" subscribe Free trial plan "Plan A" and cannot accommodate multiple users already have company from registration
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    And will redirected to suggested company list which match with domain name of the users
    And go to my icon account menu "My Company"
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
    Given "User A" click product tab to subscribe to product
    #And Select plan "Plan A" "<product>"
    #And Press Subscribe checkbox for the free trial plan complimentary subscription agreement
    #And Press Subscribe button for the free trial plan complimentary subscription
    #Then Validate subscription Successful for plan "Plan A" "<product>" pop up massage
    #And go to my icon account menuu "My Subscriptions"
    #Then free trial plan "Plan A" which is no company required cannot accommodate multiple users on table subscription for "<product>" with "<usercount>"

    #And go to my icon account menu "My Company"
    #And Select plan "Plan A" "<product>"

    Examples:
      |usercount| product        | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      |1        | LFS Trial 1 day| qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |


  @subscription-1874-s2 @e2e @singlesubscriptions
  Scenario Outline: S2 Free trial plan "Plan A" have specified valid period
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    And will redirected to suggested company list which match with domain name of the users
    And go to my icon account menu "My Company"
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
    #main test
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Press Subscribe checkbox for the free trial plan complimentary subscription agreement
    And Press Subscribe button for the free trial plan complimentary subscription
    Then Validate subscription Successful for plan "Plan A" "<product>" pop up massage
    And go to my icon account menuu "My Subscriptions"
    Then "User A" was already subscribe the free trial plan "Plan A" "<product>"
    And Validate active periode from "<startdate>" to "<endtdate>" for "<product>"
    And Remove "Plan A" "<product>" subscription
    And the subscription will expired with "CANCELLED" status for "<product>"
    And validate "Plan A" "<product>" has been remove from container application

    Examples:
      |startdate    |endtdate   | product        | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      |  19-Dec-2023|20-Dec-2023| LFS Trial 1 day| qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @subscription-1874-s2-1 @e2e @singlesubscriptions
  Scenario Outline: S2 Free trial plan "Plan A" have specified valid period
    Given go to main web
    Given press sign in button
    And input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Company"
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
    #main test
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Press Subscribe checkbox for the free trial plan complimentary subscription agreement
    And Press Subscribe button for the free trial plan complimentary subscription
    Then Validate subscription Successful for plan "Plan A" "<product>" pop up massage
    And go to my icon account menuu "My Subscriptions"
    Then "User A" was already subscribe the free trial plan "Plan A" "<product>"
    And Validate active periode from "<startdate>" to "<endtdate>"
    And Remove "Plan A" "<product>" subscription
    And the subscription will expired with "CANCELLED" status for "<product>"
    And validate "Plan A" "<product>" has been remove from container application

    Examples:
      |startdate    |endtdate   | product        | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      |  19-Dec-2023|20-Dec-2023| LFS Trial 1 day| qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

    #menunggu condition user free plan nya expired
  @subscription-1874-s3 @e2e @singlesubscriptions
  Scenario Outline: S3 After free trial "Plan A" was expired, the user "User A" wasnt able to subscribe free trial plan "Plan A" again
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    And will redirected to suggested company list which match with domain name of the users
    And go to my icon account menu "My Company"
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
    And Press Subscribe checkbox for the free trial plan complimentary subscription agreement
    And Press Subscribe button for the free trial plan complimentary subscription
    Then Validate subscription Successful for plan "Plan A" "<product>" pop up massage
    And "User A" click product tab to subscribe to product
    And go to my icon account menuu "My Subscriptions"
    #And go to my icon account menu "My Subscriptions"
    Then "User A" was already subscribe the free trial plan "Plan A" "<product>"
    And Validate active periode from "<startdate>" to "<endtdate>"
    And Remove "Plan A" "<product>" subscription
    And the subscription will expired with "CANCELLED" status for "<product>"
    And validate "Plan A" "<product>" has been remove from container application
    #main test 2
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    Then "User A" wont be able to subscribe "Plan A" "<product>" again

    Examples:
      |startdate    |endtdate   | product        | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      |  19-Dec-2023|20-Dec-2023| LFS Trial 1 day| qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |


  #menunggu condition user free plan nya expired
  @subscription-1874-s3-1 @e2e @singlesubscriptions
  Scenario Outline: S3 After free trial "Plan A" was expired, the user "User A" wasnt able to subscribe free trial plan "Plan A" again
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Company"
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
    And Press Subscribe checkbox for the free trial plan complimentary subscription agreement
    And Press Subscribe button for the free trial plan complimentary subscription
    Then Validate subscription Successful for plan "Plan A" "<product>" pop up massage
    And "User A" click product tab to subscribe to product
    And go to my icon account menuu "My Subscriptions"
    #And go to my icon account menu "My Subscriptions"
    Then "User A" was already subscribe the free trial plan "Plan A" "<product>"
    And Validate active periode from "<startdate>" to "<endtdate>"
    And Remove "Plan A" "<product>" subscription
    And the subscription will expired with "CANCELLED" status for "<product>"
    And validate "Plan A" "<product>" has been remove from container application
    #main test 2
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    Then "User A" wont be able to subscribe "Plan A" "<product>" again

    Examples:
      |startdate    |endtdate   | product        | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      |  19-Dec-2023|20-Dec-2023| LFS Trial 1 day| qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |


  @subscription-1874-s4 @e2e @bundlesubscriptions
  Scenario Outline: S4 "User B" subscribe multiple user plan "Plan B" was able to assign users even if its not from same company to plan "Plan B"
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    And will redirected to suggested company list which match with domain name of the users
    And go to my icon account menu "My Company"
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
    Given "User B" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Press Subscribe checkbox for the Bundle (AWB, BC) Non-Company plan complimentary subscription agreement
    And Press Subscribe button for the Bundle (AWB, BC) Non-Company plan complimentary subscription
    Then Validate subscription Successful for plan "Plan B" "<product>" pop up massage
    And input checkout payment cardNumber form
    And input checkout payment cardExpiry form
    And input checkout payment cardCvc form
    And input checkout payment billingName form
    And select checkout payment country
    And click checkbox Securely save my information for 1-click checkout
    Then submit checkout payment
    And Succesfully subscribe the plan "<product>"
    Then "User B" was already subscribe the Bundle (AWB, BC) Non-Company plan "Plan B" "<product>"
    And Validate active periode from "<startdate>" to "<endtdate>" for "<product>"
    And click row product "Plan B" "<product>"
    And Add user by email with same company "<sameemailcompany>"
    And Add user by email with different company "<differentemailcompany>"
    Then Able to add users, even its not from same company if the plan "<product>" was user level

    Examples:
      |sameemailcompany                 |differentemailcompany            |startdate    |endtdate   | product                     | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      |aaaaaaaa@gmail.com bbbb@gmail.com|aaaaaaaa@gmail.com bbbb@gmail.com|  19-Dec-2023|20-Dec-2023| Bundle (AWB, BC) Non-Company| qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @subscription-1874-s4-1 @e2e @bundlesubscriptions
  Scenario Outline: S4 "User B" subscribe multiple user plan "Plan B" was able to assign users even if its not from same company to plan "Plan B"
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Company"
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
    Given "User B" click product tab to subscribe to product
    And Select plan "Plan B" "<product>"
    And Press Subscribe checkbox for the Bundle (AWB, BC) Non-Company plan complimentary subscription agreement
    And Press Subscribe button for the Bundle (AWB, BC) Non-Company plan complimentary subscription
    Then Validate subscription Successful for plan "Plan B" "<product>" pop up massage
    And input checkout payment cardNumber form
    And input checkout payment cardExpiry form
    And input checkout payment cardCvc form
    And input checkout payment billingName form
    And select checkout payment country
    And click checkbox Securely save my information for 1-click checkout
    Then submit checkout payment
    And Succesfully subscribe the plan "<product>"
    Then "User B" was already subscribe the Bundle (AWB, BC) Non-Company plan "Plan B" "<product>"
    And Validate active periode from "<startdate>" to "<endtdate>" for "<product>"
    And click row product "Plan B" "<product>"
    And Add user by email with same company "<sameemailcompany>"
    And Add user by email with different company "<differentemailcompany>"
    Then Able to add users, even its not from same company if the plan "<product>" was user level

    Examples:
      |sameemailcompany                 |differentemailcompany            |startdate    |endtdate   | product                     | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      |aaaaaaaa@gmail.com bbbb@gmail.com|aaaaaaaa@gmail.com bbbb@gmail.com|  19-Dec-2023|20-Dec-2023| Bundle (AWB, BC) Non-Company| qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @subscription-1874-s5 @e2e @bundlesubscriptions
  Scenario Outline: S5 Another user other than "User A" on the company cant subscribe plan when already added into subscription
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    And will redirected to suggested company list which match with domain name of the users
    And go to my icon account menu "My Company"
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
    #main test
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Press Subscribe checkbox for the Bundle (AWB, BC) Non-Company plan complimentary subscription agreement
    And Press Subscribe button for the Bundle (AWB, BC) Non-Company plan complimentary subscription
    Then non "User A" cant subscribe the plan, because user "User A" already subscribed the "Bundle (AWB, BC) Non-Company" plan "Plan A" and added them

    Examples:
      | email                       | password      | product                      | emailtwo      |emailthree      |companytwo |companythree|
      | qa-ccn-75754@mailinator.com | CCNPegasus123 | Bundle (AWB, BC) Non-Company |userb@xyz.co.sg|userg@ccn.com.sg|Company XYZ|Pegasus CCN |

  @subscription-1874-s5-1 @e2e @bundlesubscriptions
  Scenario Outline: S5 Another user other than "User B" on the company cant subscribe plan when already added into subscription "Plan B"
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Company"
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
    #main test
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Press Subscribe checkbox for the Bundle (AWB, BC) Non-Company plan complimentary subscription agreement
    And Press Subscribe button for the Bundle (AWB, BC) Non-Company plan complimentary subscription
    Then non "User A" cant subscribe the plan, because user "User A" already subscribed the "Bundle (AWB, BC) Non-Company" plan "Plan A" and added them

    Examples:
      | email                       | password      | product                      | emailtwo      |emailthree      |companytwo |companythree|
      | qa-ccn-75754@mailinator.com | CCNPegasus123 | Bundle (AWB, BC) Non-Company |userb@xyz.co.sg|userg@ccn.com.sg|Company XYZ|Pegasus CCN |

  @subscription-1874-s6 @e2e @bundlesubscriptions
  Scenario Outline: S6 "User C" subscribe Paid plan "Plan C" which is company required and can accommodate multiple users
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Company"
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
    Given "User C" click product tab to subscribe to product
    And Select plan "Plan C" "<product>"
    And Press Subscribe checkbox for the Bundle (LFS BC) Company Level plan complimentary subscription agreement
    And Press Subscribe button for the Bundle (LFS BC) Company Level plan complimentary subscription
    Then Validate subscription Successful for plan "Plan C" "<product>" pop up massage
    And input checkout payment cardNumber form
    And input checkout payment cardExpiry form
    And input checkout payment cardCvc form
    And input checkout payment billingName form
    And select checkout payment country
    And click checkbox Securely save my information for 1-click checkout
    Then submit checkout payment
    And Succesfully subscribe the plan "<product>"

    Examples:
      |sameemailcompany                 |differentemailcompany            |startdate    |endtdate   | product                     | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      |aaaaaaaa@gmail.com bbbb@gmail.com|aaaaaaaa@gmail.com bbbb@gmail.com|  19-Dec-2023|20-Dec-2023| Bundle (LFS BC) Company Level| qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @subscription-1874-s7 @e2e @bundlesubscriptions
  Scenario Outline: S7 After "User A" subscribe plan "Plan B" was able to assign remaining slot members email from company same company to plan "Plan B"
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Company"
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
    And Press Subscribe checkbox for the Bundle (LFS BC) Company Level plan complimentary subscription agreement
    And Press Subscribe button for the Bundle (LFS BC) Company Level plan complimentary subscription
    Then Validate subscription Successful for plan "Plan A" "<product>" pop up massage
    And input checkout payment cardNumber form
    And input checkout payment cardExpiry form
    And input checkout payment cardCvc form
    And input checkout payment billingName form
    And select checkout payment country
    And click checkbox Securely save my information for 1-click checkout
    Then submit checkout payment
    And Succesfully subscribe the plan "<product>"
    Then "User A" was already subscribe the Bundle (LFS BC) Company Level plan "Plan A" "<product>"
    And Validate active periode from "<startdate>" to "<endtdate>"
    And click row product "Plan A" "<product>"
    And Add user by email with same company "<sameemailcompany>"
    And Add user by email with different company "<differentemailcompany>"
    Then Able to add users for the plan "<product>" was company level with remaining slot members total of "<remainingslotmember>"

    Examples:
      |remainingslotmember|sameemailcompany                 |differentemailcompany            |startdate    |endtdate   | product                     | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      |4                  |aaaaaaaa@gmail.com bbbb@gmail.com|aaaaaaaa@gmail.com bbbb@gmail.com|  19-Dec-2023|20-Dec-2023| Bundle (LFS BC) Company Level| qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @subscription-1874-s8 @e2e @bundlesubscriptions
  Scenario Outline: S8 After "User A" subscribe plan "Plan B" wont be able to add another member because slot member already full
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Company"
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
    And Press Subscribe checkbox for the Bundle (LFS BC) Company Level plan complimentary subscription agreement
    And Press Subscribe button for the Bundle (LFS BC) Company Level plan complimentary subscription
    Then Validate subscription Successful for plan "Plan A" "<product>" pop up massage
    And input checkout payment cardNumber form
    And input checkout payment cardExpiry form
    And input checkout payment cardCvc form
    And input checkout payment billingName form
    And select checkout payment country
    And click checkbox Securely save my information for 1-click checkout
    Then submit checkout payment
    And Succesfully subscribe the plan "<product>"
    Then "User A" was already subscribe the Bundle (LFS BC) Company Level plan "Plan A" "<product>"
    And Validate active periode from "<startdate>" to "<endtdate>"
    And click row product "Plan A" "<product>"
    And Add user by email with same company "<sameemailcompany>"
    And Add user by email with different company "<differentemailcompany>"
    Then not Able to add users for the plan "<product>" because slot member already full

    Examples:
      |remainingslotmember|sameemailcompany                 |differentemailcompany            |startdate    |endtdate   | product                     | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      |4                  |aaaaaaaa@gmail.com bbbb@gmail.com|aaaaaaaa@gmail.com bbbb@gmail.com|  19-Dec-2023|20-Dec-2023| Bundle (LFS BC) Company Level| qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |


  @subscription-1874-s9 @e2e @bundlesubscriptions
  Scenario Outline: S9 Able to add unregistered user email to "Plan A" which is no company required plan
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Company"
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
    And Press Subscribe checkbox for the Bundle (AWB, BC) Non-Company plan complimentary subscription agreement
    And Press Subscribe button for the Bundle (AWB, BC) Non-Company plan complimentary subscription
    Then Validate subscription Successful for plan "Plan A" "<product>" pop up massage
    And input checkout payment cardNumber form
    And input checkout payment cardExpiry form
    And input checkout payment cardCvc form
    And input checkout payment billingName form
    And select checkout payment country
    And click checkbox Securely save my information for 1-click checkout
    Then submit checkout payment
    And Succesfully subscribe the plan "<product>"
    Then "User A" was already subscribe the Bundle (AWB, BC) Non-Company plan "Plan A" "<product>"
    And Validate active periode from "<startdate>" to "<endtdate>"
    And click row product "Plan A" "<product>"
    And Add unregistered user email "unregistered@xyz.co.sg"
    Then The unregistered user with email "unregistered@xyz.co.sg" will get the email to register to cube platform
    And After that the user with email "unregistered@xyz.co.sg" will subscribed the plan "Plan A"

    Examples:
      |sameemailcompany                 |differentemailcompany            |startdate    |endtdate   | product                     | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      |aaaaaaaa@gmail.com bbbb@gmail.com|aaaaaaaa@gmail.com bbbb@gmail.com|  19-Dec-2023|20-Dec-2023| Bundle (AWB, BC) Non-Company| qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |




  @subscriptions-1874-10 @e2e @bundlesubscriptions
  Scenario Outline: S10 Cannot add unregistered/outsiders user email to "Plan B" which is company required plan
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Company"
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
    And Press Subscribe checkbox for the Bundle (AWB, BC) Non-Company plan complimentary subscription agreement
    And Press Subscribe button for the Bundle (AWB, BC) Non-Company plan complimentary subscription
    Then Validate subscription Successful for plan "Plan A" "<product>" pop up massage
    And input checkout payment cardNumber form
    And input checkout payment cardExpiry form
    And input checkout payment cardCvc form
    And input checkout payment billingName form
    And select checkout payment country
    And click checkbox Securely save my information for 1-click checkout
    Then submit checkout payment
    And Succesfully subscribe the plan "<product>"
    Then "User A" was already subscribe the Bundle (AWB, BC) Non-Company plan "Plan A" "<product>"
    And Validate active periode from "<startdate>" to "<endtdate>"
    And click row product "Plan A" "<product>"
    And Add unregistered user email "unregistered@xyz.co.sg"
    Then Will get error on the pop up cannot add unregistered/outsiders user

    Examples:
      |sameemailcompany                 |differentemailcompany            |startdate    |endtdate   | product                     | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      |aaaaaaaa@gmail.com bbbb@gmail.com|aaaaaaaa@gmail.com bbbb@gmail.com|  19-Dec-2023|20-Dec-2023| Bundle (AWB, BC) Non-Company| qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

