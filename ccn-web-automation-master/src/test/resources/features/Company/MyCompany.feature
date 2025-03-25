@allcompany
Feature: My Company

  Background:
  "User A" was from company "Company Owner"
  "User B" was "requested to join company"
  "User C" was "invited to join company" by "User A"


  @MyCompanysuggestion-1 @regression @companys1 @mycompany1
  Scenario: S1 After login for the first time will be redirected to the suggested company list, which is matching with domain name
    Given go to main web
    Given press sign in button
    When registration with new account and login
    Then will redirected to suggested company list which match with domain name of the users

  @createUserYopmail
  Scenario: S1 After login for the first time will be redirected to the suggested company list, which is matching with domain name
    Given go to main web
    Given press sign in button
    When registration with new account yopmail and login
    Then will redirected to suggested company list which match with domain name of the users

#new aacounts sandbox:
#qa-ccn-xe8hj1hc@yopmail.com
#indoqa-ccn-59113218@yopmail.com
#indoqa-ccn-93446049@yopmail.com



#nd login or more sandbox already on company:
#nz-ccn-63198546@yopmail.com

#have company

#new aacounts dev:
#qa-ccn-66660@mailinator.com
#nd login or more dev:
#

  @MyCompanysuggestion-2 @regression @companys1 @mycompany2 @sort-company
  Scenario Outline: Verify Sorting data for column company name on suggestion company ascending sorting
    Given accept cookie
    When click initial sign in button
    When input email "myqa-ccn-001@yopmail.com" and password "CCNPegasus123" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Company"
    And click Sorting data for column "<column>" on suggestion company "ascending" sorting
    Then the data is sorted by column "<column>" with "ascending" sorting
    When click on the column name again for sorting in "descending"
    Then the data is sorted by column "<column>" with "descending" sorting

    Examples:
      | column |
      | companyName |
      | companyRegistrationNo |
      | type |
      | country |
      | station |

  @MyCompanysuggestion-11 @MyCompany @regression @smoke @companys2 @mycompany12
  Scenario Outline: "User B" as new user request joining the company,then will redirected to application status and can see the status of approval
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    And will redirected to suggested company list which match with domain name of the users
    And search company name "<companyName>"
    When request join to company
    And confirm request joining company
    Then will redirected to the application status
    And status user was still "PENDING APPROVE" and waiting for approval from admin company
    And receive email notification for request joining company
    #qa-ccn-47562@mailinator.com
    Examples:
      |companyName|
    #|PEGASUS TEST|
    #|mailinator CCNPEGASUS_QA|
      |mailinatorCCNPEGASUS_QA|

  @MyCompanysuggestion-11 @MyCompany @regression @smoke @companys2-1 @mycompany13
  Scenario Outline: S2 "User B" as existing user already have company to request joining other company,then will redirected to application status and can see the status of approval
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And input company name "<companyName>"
    When request join to company
    And confirm request joining company
    Then will redirected to the application status
    And status user was still "PENDING APPROVE" and waiting for approval from admin company
    And receive email notification for request joining company

    Examples:
      | email                       | password      | companyName              | companyRegis   | typeOfCompany | country        | city |iconaccountmenu|
      | qa-ccn-03475@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  |My Company     |

  @MyCompanysuggestion-11 @MyCompany @regression @smoke @companys2-2 @mycompany14
  Scenario Outline: S2 "User B" as existing user without any company to request joining the company,then will redirected to application status and can see the status of approval
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And input company name "<companyName>"
    When request join to company
    And confirm request joining company
    Then will redirected to the application status
    And status user was still "PENDING APPROVE" and waiting for approval from admin company
    And receive email notification for request joining company

    Examples:
      | email                       | password      | companyName              | companyRegis   | typeOfCompany | country        | city |iconaccountmenu|
      | qa-ccn-28274@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  |My Company     |


  @CreateMyCompany-1 @MyCompany @regression @companys3 @mycompany15
  Scenario Outline: S3 If theres no company matched, then able to create a new company after registration
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    When system didn't found the suggested company matched
    And input company name "<companyName>"
    And input company registration "<companyRegis>"
    And input company type "<typeOfCompany>"
    And input country "<country>"
    And input city "<city>"
    And theres button to create company with the status was enabled to create company
    Then the user was able to create a new company

    Examples:
      | password      | companyName              | companyRegis   | typeOfCompany | country        | city |iconaccountmenu|
      | CCNPegasus123 | PEGASUSTEST              | CCNPEGASUS_QA1 | GSA           | AE - UNITED ARAB EMIRATES | AUH  |My Company     |

      #| CCNPegasus123 | mailinator CCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | AE - UNITED ARAB EMIRATES | AUH  |My Company     |


      #| qa-ccn-07127@mailinator.com | CCNPegasus123 | mailinator CCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  |My Company     |


      #| qa-ccn-68108@mailinator.com | CCNPegasus123 | mailinator CCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  |My Company     |



  #|qa-ccn-07863@mailinator.com
  #| qa-ccn-04346@mailinator.com | CCNPegasus123 | BB FWD SG 1 | BGSG1        | FWD           | SG      | SIN  |
  #| user_fwd_sg@mailinator.com  | p@55w0rd      | BB FWD SG 1 | BGSG1        | FWD           | SG      | SIN  |
  #| user_fwd_id@mailinator.com  | p@55w0rd      | BB FWD ID 1 | BGID1        | FWD           | ID      | JKT  |
  #| user_fwd_in@mailinator.com  | p@55w0rd      | BB FWD IN 1 | BGIN1        | FWD           | IN      | DEL  |
  #| user_fwd_cn@mailinator.com  | p@55w0rd      | BB FWD CN 1 | BGCN1        | FWD           | CN      | SHA  |

  @CreateMyCompany-1 @MyCompany @regression @companys3-1 @mycompany16
  Scenario Outline: S3 If there's no company matched, then able to create a new company
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    When system didn't found the suggested company matched
    And input company name "<companyName>"
    And input company registration "<companyRegis>"
    And input company type "<typeOfCompany>"
    And input country "<country>"
    And input city "<city>"
    And theres button to create company with the status was enabled to create company
    Then the user was able to create a new company

    Examples:
      | email                       | password      | companyName              | companyRegis   | typeOfCompany | country        | city |iconaccountmenu|
      | qa-ccn-80239@mailinator.com | CCNPegasus123 | mailinator CCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | AE - UNITED ARAB EMIRATES | AUH  |My Company     |
      #| qa-ccn-07127@mailinator.com | CCNPegasus123 | mailinator CCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  |My Company     |


      #| qa-ccn-68108@mailinator.com | CCNPegasus123 | mailinator CCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  |My Company     |



  #|qa-ccn-07863@mailinator.com
  #| qa-ccn-04346@mailinator.com | CCNPegasus123 | BB FWD SG 1 | BGSG1        | FWD           | SG      | SIN  |
  #| user_fwd_sg@mailinator.com  | p@55w0rd      | BB FWD SG 1 | BGSG1        | FWD           | SG      | SIN  |
  #| user_fwd_id@mailinator.com  | p@55w0rd      | BB FWD ID 1 | BGID1        | FWD           | ID      | JKT  |
  #| user_fwd_in@mailinator.com  | p@55w0rd      | BB FWD IN 1 | BGIN1        | FWD           | IN      | DEL  |
  #| user_fwd_cn@mailinator.com  | p@55w0rd      | BB FWD CN 1 | BGCN1        | FWD           | CN      | SHA  |


  @CreateMyCompany-2 @MyCompany @regression @companys4 @mycompany17
  Scenario Outline: After user create a company for country Singapore will get pop up for setup giro payment from registration
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
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

    Examples:
      | companyemail                |iconaccountmenu | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | qa-ccn-46706@mailinator.com |My Company      | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

      #| qa-ccn-42413@mailinator.com |My Company     | qa-ccn-42413@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | AE - UNITED ARAB EMIRATES | AUH  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |
      #| qa-ccn-23429@mailinator.com |My Company     | qa-ccn-23429@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | LK - SRI LANKA | CMB  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |
      #| qa-ccn-93267@mailinator.com |My Company     | qa-ccn-93267@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | US - UNITED STATES | MIA  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |
      #| qa-ccn-33266@mailinator.com |My Company     | qa-ccn-33266@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | ID - INDONESIA | CGK  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |
      #

      #| qa-ccn-46551@mailinator.com |My Company     | qa-ccn-46551@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  #| company_email_testing_qa@mailinator.com | qa-ccn-88106@mailinator.com | CCNPegasus123 | CCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |
  #| company_email_testing_qa@mailinator.com | qa-ccn-75678@mailinator.com | CCNPegasus123 | CCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |
  #| company_email_testing_qa@mailinator.com | qa-ccn-57388@mailinator.com | CCNPegasus123 | CCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |
  #| user_fwd_sg@mailinator.com | p@55w0rd | BB FWD SG 1 | BGSG1        | FWD           | SG      | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road       |   089774 |
  #| user_fwd_id@mailinator.com | p@55w0rd | BB FWD ID 1 | BGID1        | FWD           | ID      | JKT  | gsa id 1 | marketing   | 082234567892 | 00000002 | 21111112 | Jl Surabaya 40, Jkt       |    10310 |
  #| user_fwd_in@mailinator.com | p@55w0rd | BB FWD IN 1 | BGIN1        | FWD           | IN      | DEL  | gsa sg 1 | marketing   | 083234567893 | 00000003 | 31111113 | Behind Mother Dairy Plant |   110092 |
  #| user_fwd_cn@mailinator.com | p@55w0rd | BB FWD CN 1 | BGCN1        | FWD           | CN      | SHA  | gsa sg 1 | marketing   | 084234567894 | 00000004 | 41111114 | 130 Meilong Road          |   200237 |

  @CreateMyCompany-2 @MyCompany @regression @companys4-1 @mycompany18
  Scenario Outline: S4 After user create a company for country Singapore will get pop up for setup giro payment
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
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
    And open email mailinator

    Examples:
      | companyemail                            |iconaccountmenu| email                       | password      | companyName   | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | qa-ccn-46706@mailinator.com |My Company     | qa-ccn-46706@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

      #| qa-ccn-42413@mailinator.com |My Company     | qa-ccn-42413@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | AE - UNITED ARAB EMIRATES | AUH  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |
      #| qa-ccn-23429@mailinator.com |My Company     | qa-ccn-23429@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | LK - SRI LANKA | CMB  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |
      #| qa-ccn-93267@mailinator.com |My Company     | qa-ccn-93267@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | US - UNITED STATES | MIA  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |
      #| qa-ccn-33266@mailinator.com |My Company     | qa-ccn-33266@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | ID - INDONESIA | CGK  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |
      #

      #| qa-ccn-46551@mailinator.com |My Company     | qa-ccn-46551@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  #| company_email_testing_qa@mailinator.com | qa-ccn-88106@mailinator.com | CCNPegasus123 | CCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |
  #| company_email_testing_qa@mailinator.com | qa-ccn-75678@mailinator.com | CCNPegasus123 | CCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |
  #| company_email_testing_qa@mailinator.com | qa-ccn-57388@mailinator.com | CCNPegasus123 | CCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |
  #| user_fwd_sg@mailinator.com | p@55w0rd | BB FWD SG 1 | BGSG1        | FWD           | SG      | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road       |   089774 |
  #| user_fwd_id@mailinator.com | p@55w0rd | BB FWD ID 1 | BGID1        | FWD           | ID      | JKT  | gsa id 1 | marketing   | 082234567892 | 00000002 | 21111112 | Jl Surabaya 40, Jkt       |    10310 |
  #| user_fwd_in@mailinator.com | p@55w0rd | BB FWD IN 1 | BGIN1        | FWD           | IN      | DEL  | gsa sg 1 | marketing   | 083234567893 | 00000003 | 31111113 | Behind Mother Dairy Plant |   110092 |
  #| user_fwd_cn@mailinator.com | p@55w0rd | BB FWD CN 1 | BGCN1        | FWD           | CN      | SHA  | gsa sg 1 | marketing   | 084234567894 | 00000004 | 41111114 | 130 Meilong Road          |   200237 |

  @CreateMyCompany-3 @MyCompany @regression @companys4-1 @mycompany19
  Scenario Outline: Offline payment setup for China company, Subscription and transaction charge as China user
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
    And receive email notification offline setup
    And open email mailinator


    Examples:
      | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country    | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | CN - CHINA | CAN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @CreateMyCompany-4 @MyCompany @regression @companys4-1 @mycompany20
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
    And receive email notification offline setup
    And open email mailinator

    Examples:
      | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country    | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | IN - INDIA | BOM  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @CreateMyCompany-5 @mycompany21
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
    And receive email notification offline setup
    And open email mailinator

    Examples:
      | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | ID - INDONESIA | CGK  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @CreateMyCompany-6 @mycompany22
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
    And receive email notification offline setup
    And open email mailinator

    Examples:
      | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country                   | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | AE - UNITED ARAB EMIRATES | DXB  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @CreateMyCompany-7 @MyCompany @regression @companys4 @mycompany23
  Scenario Outline: Check for duplicate company by creating the same ada as existing company in suggestion company page
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    When system didn't found the suggested company matched
    And input company name "<companyName>"
    And input company registration "<companyRegis>"
    And input company type "<typeOfCompany>"
    And input country "<country>"
    And input city "<city>"
    And theres button to create company with the status was enabled to create company
    Then the user was able to create a new company
    When press create company button
    Then pop up for duplicate company show up

    Examples:
      | companyemail                |iconaccountmenu | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | qa-ccn-46706@mailinator.com |My Company      | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @CreateMyCompany-8 @MyCompany @regression @companys4 @mycompany24
  Scenario Outline: Check for duplicate company by creating the same ada as existing company in suggestion company page except company regis then edit data the same as existing company in the create company page
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
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
    Then pop up for duplicate company show up

    Examples:
      | companyemail                |iconaccountmenu | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | qa-ccn-46706@mailinator.com |My Company      | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @CreateMyCompany-9 @MyCompany @regression @companys4 @mycompany25
  Scenario Outline: Check for duplicate company by creating the same ada as existing company in suggestion company page except company type then edit data the same as existing company in the create company page
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
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
    Then pop up for duplicate company show up

    Examples:
      | companyemail                |iconaccountmenu | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | qa-ccn-46706@mailinator.com |My Company      | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |


  @CreateMyCompany-10 @MyCompany @regression @companys4 @mycompany26
  Scenario Outline: Check for duplicate company by creating the same ada as existing company in suggestion company page except company country then edit data the same as existing company in the create company page
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
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
    Then pop up for duplicate company show up

    Examples:
      | companyemail                |iconaccountmenu | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | qa-ccn-46706@mailinator.com |My Company      | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |

  @CreateMyCompany-11 @MyCompany @regression @companys4 @mycompany27
  Scenario Outline: Check for duplicate company by creating the same ada as existing company in suggestion company page except company country then edit data the same as existing company in the create company page
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
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
    Then pop up for duplicate company show up

    Examples:
      | companyemail                |iconaccountmenu | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | qa-ccn-46706@mailinator.com |My Company      | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |


  @CreateMyCompany-12 @MyCompany @regression @companys4 @mycompany28
  Scenario Outline: Check for duplicate company by creating the same ada as existing company in suggestion company page except company city then edit data the same as existing company in the create company page
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
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
    Then pop up for duplicate company show up

    Examples:
      | companyemail                |iconaccountmenu | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany |
      | qa-ccn-46706@mailinator.com |My Company      | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 |


  @CreateMyCompany-13 @MyCompany @regression  @mycompany29
  Scenario Outline: Admin wont be able to leave the company as the last admin in the company
    Given accept cookie
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And click leave company
    Then pop up that said the last admin cant leave company

    Examples:
      | email                         | password      | iconaccountmenu|
      | chqa-ccn-88742@mailinator.com | CCNPegasus123 | My Company     |

  @CreateMyCompany-14 @MyCompany @regression  @mycompany30
  Scenario Outline: Admin leave company if there are more than one admin in the company
    Given accept cookie
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And click leave company
    Then pop up that said the last admin cant leave company

    Examples:
      | email                         | password      | iconaccountmenu|
      | chqa-ccn-88742@mailinator.com | CCNPegasus123 | My Company     |


  @CreateMyCompany-15 @MyCompany @regression  @mycompany31
  Scenario Outline: current used member account role cant be change because 3 dot button cant be click int the member company list with role user and status active
    Given accept cookie
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    When press dot on the left side user
    And dot cant be click
#qa-ccn-80909@mailinator.com
    #MailinatorCCNPEGASUS_QA
    #user a:

    Examples:
      | email                         | password      | otheruseremail            |iconaccountmenu|
      | chqa-ccn-88742@mailinator.com | CCNPegasus123 | fadlifarham10@yopmail.com |My Company     |
      #| qa-ccn-46551@mailinator.com | CCNPegasus123 | fadlifarham10@yopmail.com |My Company     |
      #| qa-ccn-99227@mailinator.com | CCNPegasus123 | fadlifarham10@yopmail.com |

  @CreateMyCompany-16 @MyCompany @regression  @mycompany32
  Scenario Outline: current used admin account role cant be change because 3 dot button cant be click int the member company list with role admin and status active
    Given accept cookie
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    When press dot on the left side user
    And dot cant be click
#qa-ccn-80909@mailinator.com
    #MailinatorCCNPEGASUS_QA
    #user a:

    Examples:
      | email                         | password      | otheruseremail            |iconaccountmenu|
      | chqa-ccn-88742@mailinator.com | CCNPegasus123 | fadlifarham10@yopmail.com |My Company     |
      #| qa-ccn-46551@mailinator.com | CCNPegasus123 | fadlifarham10@yopmail.com |My Company     |
      #| qa-ccn-99227@mailinator.com | CCNPegasus123 | fadlifarham10@yopmail.com |

  @CreateMyCompany-17 @MyCompany @regression  @mycompany33
  Scenario Outline: Only admin company can change role active admin user to active user
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my company
    And press member tab
    And filter member with status "<statusmember>"
    And press dot on the left side user
    Then press change roles button to change role to "<toroles>"
    And able to change role other user

    Examples:
      | email                              |password      | statusmember|toroles|
      | qa-ccn-68108@mailinator.com        |CCNPegasus123 |Active       |user   |

  @CreateMyCompany-18 @MyCompany @regression  @mycompany34
  Scenario Outline: Only admin company can change role active user to active admin user
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my company
    And press member tab
    And filter member with status "<statusmember>"
    And press dot on the left side user
    Then press change roles button to change role to "<toroles>"
    And able to change role other user

    Examples:
      | email                              |password      | statusmember|toroles|
      | qa-ccn-68108@mailinator.com        |CCNPegasus123 |Active       |admin  |


  @CreateMyCompany-19 @MyCompany @regression  @mycompany35
  Scenario Outline: admin company can have many admin with "active" status
    Given accept cookie
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    When press member tab
    Then admin company can see other admin member with status "Active"

    Examples:
      | email                              |password      | otheruseremail                 |iconaccountmenu|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | qa-ccn-27183@mailinator.com |My Company     |


  @CreateMyCompany-20 @MyCompany @regression  @mycompany36
  Scenario Outline: Admin from company can see the list member company with state "Pending Approve" and "Pending Accept" and "Active" same company
    Given accept cookie
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    When press member tab
    Then admin company can see the pending member with status "Pending Approval" and status "Pending Accept" and status "Active"

    Examples:
      | email                              |password      | otheruseremail                 |iconaccountmenu|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | qa-ccn-27183@mailinator.com |My Company     |

  @CreateMyCompany-21 @MyCompany @regression  @mycompany37
  Scenario Outline: Admin from company can see the list member company with state "Pending Approve" and "Pending Accept"
    Given accept cookie
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    When press member tab
    Then admin company can see the pending member with status "Pending Approval" and status "Pending Accept"

    Examples:
      | email                              |password      | otheruseremail                 |iconaccountmenu|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | qa-ccn-27183@mailinator.com |My Company     |



  @CreateMyCompany-22 @MyCompany @regression  @mycompany38
  Scenario Outline: Admin company invite user "User C" to company
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    When press invite users button
    And input email "<otheruseremail>" on the pop up
    And press invite button on the pop up
    Then success invite user "<otheruseremail>" to the company "<companyusera>"

    #qa-ccn-50128@mailinator.com
    #

    Examples:
      |otheruseremail        | email                              |password      | otheruseremail                 |iconaccountmenu|companyusera|
      |wwwwwww@gmail.com| qa-ccn-46551@mailinator.com        |CCNPegasus123 | qa-ccn-93901@mailinator.com |My Company     |mailinatorCCNPEGASUS_QA|
#		  | qa-ccn-46551@mailinator.com        |CCNPegasus123 | qa-ccn-09538@mailinator.com |My Company     |mailinatorCCNPEGASUS_QA|

#		  | qa-ccn-25470@mailinator.com        |CCNPegasus123 | irsyad.muhamad.andre@gmail.com |
#		  | qa-ccn-25470@mailinator.com        |CCNPegasus123 | ray@yomail.com |



  @CreateMyCompany-23 @MyCompany @regression  @mycompany39
  Scenario Outline: Admin Company was able to remove the request join company with "Pending Accept" member
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    And filter member with status "<statusmember>"
    And search email "<otheruseremail>" to be removed from the company
    And press dot on the left side user
    Then admin company was able to reject or approve the request

    #user b:
    #qa-ccn-11797@mailinator.com

    #user a:
    Examples:
      |otheruseremail        | email                              |password      | statusmember|iconaccountmenu|
      |aaaa@gmail.com| qa-ccn-46551@mailinator.com       |CCNPegasus123 |Pending Accept|   My Company  |

#		  | qa-ccn-99227@mailinator.com        |CCNPegasus123 |Pending Accept|My Company     |


  @CreateMyCompany-24 @MyCompany @regression  @mycompany40
  Scenario Outline: Admin Company was able to reject the request join company with "PENDING APPROVE" member
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my company
    And press member tab
    And filter member with status "<statusmember>"
    And search email "<otheruseremail>" to be removed from the company
    And press dot on the left side user
    And admin company was able to reject or approve the request
    Then press remove to reject the request


    #user b:
    #qa-ccn-11797@mailinator.com
    #qa-ccn-69176@mailinator.com
    #qa-ccn-90241@mailinator.com
    #qa-ccn-71525@mailinator.com
    #qa-ccn-42919@mailinator.com

    #user a:
    #qa-ccn-46551@mailinator.com
    #qa-ccn-99227@mailinator.com
    #qa-ccn-68108@mailinator.com
    Examples:
      |otheruseremail        | email                              |password      | statusmember|iconaccountmenu|
      |aaaaaaaa@gmail.com| qa-ccn-46551@mailinator.com        |CCNPegasus123 |Pending Approve|My Company     |
#		  qa-ccn-46551@mailinator.com


#		  | qa-ccn-99227@mailinator.com        |CCNPegasus123 |Pending Approval|My Company     |


  @CreateMyCompany-25 @MyCompany @regression  @mycompany41
  Scenario Outline: Admin Company was able to approve the request join company with "PENDING APPROVE" member, then become active member for the company
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my company
    And press member tab
    And filter member with status "<statusmember>"
    And search email "<otheruseremail>" to be approved from the company
    And press dot on the left side user
    Then press accept to approve the request



    #user b:
    #qa-ccn-11797@mailinator.com
    #qa-ccn-69176@mailinator.com
    #qa-ccn-90241@mailinator.com
    #qa-ccn-71525@mailinator.com
    #qa-ccn-42919@mailinator.com
    #qa-ccn-72702@mailinator.com
    #qa-ccn-03475@mailinator.com
    #qa-ccn-39739@mailinator.com

    #user a:
    #qa-ccn-46551@mailinator.com
    #qa-ccn-99227@mailinator.com
    #qa-ccn-68108@mailinator.com
    Examples:
      |otheruseremail             | email                              |password      | statusmember|iconaccountmenu|
      |qa-ccn-46551@mailinator.com| qa-ccn-46551@mailinator.com        |CCNPegasus123 |Pending Approve|My Company     |

#		  | qa-ccn-99227@mailinator.com        |CCNPegasus123 |Pending Approval|My Company     |

  @CreateMyCompany-26 @MyCompany @regression  @mycompany42
  Scenario Outline: Admin Company wont be able to change the role with "PENDING APPROVE" member, then pop masssage that said the member need to be approve first as active member
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my company
    And press member tab
    And filter member with status "<statusmember>"
    And search email "<otheruseremail>" member
    And press dot on the left side user
    Then press change roles button to change role to "<toroles>"
    And wont able to change role other user member need to be approve first as active member

    Examples:
      |otheruseremail        | email                              |password      | statusmember|toroles|
      |rrrrr@mailinator.com| qa-ccn-68108@mailinator.com        |CCNPegasus123 |PENDING APPROVE       |admin  |

  @CreateMyCompany-27 @MyCompany @regression  @mycompany43
  Scenario Outline: Admin company was not able to invite user already join other company
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my company
    And press member tab
    When press invite users button
    And input email "<otheruseremail>" on the pop up
    And press invite button on the pop up
    Then wont be able to invite user

    Examples:
      |otheruseremail        | email                              |password      |
      |jjjjj@mailinator.com| qa-ccn-68108@mailinator.com        |CCNPegasus123 |

  @CreateMyCompany-28 @MyCompany @regression  @mycompany44
  Scenario Outline: Admin company was not able to invite user with status already "PENDING ACCEPT"
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my company
    And press member tab
    When press invite users button
    And input email "<otheruseremail>" on the pop up
    And press invite button on the pop up
    Then wont be able to invite user

    Examples:
      |otheruseremail        | email                              |password      |
      |jjjjj@mailinator.com| qa-ccn-68108@mailinator.com        |CCNPegasus123 |

  @CreateMyCompany-29 @MyCompany @regression  @mycompany45
  Scenario Outline: Admin company was not able to invite user with status already "PENDING APPROVE"
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my company
    And press member tab
    When press invite users button
    And input email "<otheruseremail>" on the pop up
    And press invite button on the pop up
    Then wont be able to invite user

    Examples:
      |otheruseremail        | email                              |password      |
      |jjjjj@mailinator.com| qa-ccn-68108@mailinator.com        |CCNPegasus123 |


  @CreateMyCompany-30 @MyCompany @regression  @mycompany46
  Scenario Outline: User from company only see the list of member company with state "Active"
    Given accept cookie
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    When press member tab
    Then user company can see the pending member with status "Active"

    Examples:
      | email                              |password      | otheruseremail                 |iconaccountmenu|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | qa-ccn-27183@mailinator.com |My Company     |

  @CreateMyCompany-31 @MyCompany @regression  @mycompany47
  Scenario Outline: Admin company was not able to invite user "User C" with status pending or already join other company
    Given accept cookie
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    When press invite users button
    And input email "<otheruseremail>" on the pop up
    And press invite button on the pop up
    Then showing error on the pop up modal which contains the user has pending application or is already in company with other email user "<otheruseremail>"
#qa-ccn-80909@mailinator.com
    #MailinatorCCNPEGASUS_QA
    #user a:

    Examples:
      | email                         | password      | otheruseremail            |iconaccountmenu|
      | chqa-ccn-88742@mailinator.com | CCNPegasus123 | fadlifarham10@yopmail.com |My Company     |
      #| qa-ccn-46551@mailinator.com | CCNPegasus123 | fadlifarham10@yopmail.com |My Company     |
      #| qa-ccn-99227@mailinator.com | CCNPegasus123 | fadlifarham10@yopmail.com |





  @CreateMyCompany-32 @MyCompany @regression  @mycompany48
  Scenario Outline:  User able to withdraws application request joining company
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    And will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And search company "<company>"
    And select request join to company
    #When request join to company
    And confirm request joining company
    And will redirected to the application status
    And status user was still "PENDING APPROVE" and waiting for approval from admin company
    When press button withdraw application
    Then confirm withdraw application to company

    Examples:
      | company   |
      |mailinator CCNPEGASUS_QA|
      #| mailinatorCCNPEGASUS_QA |


  @CreateMyCompany-33 @MyCompany @regression  @mycompany49
  Scenario Outline: existing user withdraw application joining company from suggested company table
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my company
    When system didn't found the suggested company matched
    And search company "<company>"
    And select request join to company
    And confirm request joining company
    And will redirected to the application status
    And status user was still "PENDING APPROVE" and waiting for approval from admin company
    When press button withdraw application
    Then confirm withdraw application to company

    Examples:
      | email                              |password      | company|iconaccountmenu|
      | qa-ccn-27453@mailinator.com     |CCNPegasus123 |mailinator CCNPEGASUS_QA|My Company     |

#		  | qa-ccn-39739@mailinator.com        |CCNPegasus123 |mailinator CCNPEGASUS_QA|My Company     |
#		  | qa-ccn-99227@mailinator.com        |CCNPegasus123 |QA CCN Company|My Company     |


  @CreateMyCompany-34 @MyCompany @regression @mycompany49
  Scenario Outline: admin company can change role user "User B" to admin
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my company
    And press member tab
    And filter member with status "<statusmember>"
    And press dot on the left side user
    Then press change roles button to change role to "<toroles>"
    And able to change role other user

    Examples:
      | email                              |password      | statusmember|toroles|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 |Active       |admin  |


  @CreateMyCompany-35 @MyCompany @regression @companys12-3 @mycompany50
  Scenario Outline: S12 Only "User A" admin company cant change role user "User B" with status "PENDING APPROVE"
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my company
    And press member tab
    And filter member with status "<statusmember>"
    And press dot on the left side user
    Then press change roles button to change role to "<toroles>"
    And wont be able to change role other user

    Examples:
      | email                              |password      | statusmember|toroles|
      | qa-ccn-68108@mailinator.com        |CCNPegasus123 |Active       |admin  |


  @CreateMyCompany-36 @MyCompany @regression  @mycompany51
  Scenario Outline: Admin Company was able to remove  "Active" member
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    And filter member with status "<statusmember>"
    And search email "<otheruseremail>" to be removed from the company
    And press dot on the left side user
    Then press remove to reject the request

    #user b:
    #qa-ccn-11797@mailinator.com

    #user a:
    Examples:
      |otheruseremail        | email                              |password      | statusmember|iconaccountmenu|
      |aaaa@gmail.com| qa-ccn-46551@mailinator.com       |CCNPegasus123 |Pending Accept|   My Company  |

#		  | qa-ccn-99227@mailinator.com        |CCNPegasus123 |Pending Accept|My Company     |

  @CreateMyCompany-37 @MyCompany @regression  @mycompany52
  Scenario Outline: Admin Company was able to remove  "Active" member admin
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    And filter member with status "<statusmember>"
    And search email "<otheruseremail>" to be removed from the company
    And press dot on the left side user
    Then press remove to reject the request

	    #user b:
	    #qa-ccn-11797@mailinator.com

	    #user a:
    Examples:
      |otheruseremail        | email                              |password      | statusmember|iconaccountmenu|
      |aaaa@gmail.com| qa-ccn-46551@mailinator.com       |CCNPegasus123 |Pending Accept|   My Company  |

	#		  | qa-ccn-99227@mailinator.com        |CCNPegasus123 |Pending Accept|My Company     |

  @CreateMyCompany-38 @MyCompany @regression  @mycompany53
  Scenario Outline: user accept invitaion company from admin company
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my company
    And will redirected to the application status
    And status user was still "PENDING ACCEPT"
    When press button accept invitation
    Then confirm accept invitation

    Examples:
      | email                              |password      | company|iconaccountmenu|
      | qa-ccn-27453@mailinator.com     |CCNPegasus123 |mailinator CCNPEGASUS_QA|My Company     |

#		  | qa-ccn-39739@mailinator.com        |CCNPegasus123 |mailinator CCNPEGASUS_QA|My Company     |
#		  | qa-ccn-99227@mailinator.com        |CCNPegasus123 |QA CCN Company|My Company     |

  @CreateMyCompany-39 @MyCompany @regression  @mycompany54
  Scenario Outline: user reject invitaion company from admin company
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my company
    And will redirected to the application status
    And status user was still "PENDING ACCEPT"
    When press button reject invitation
    Then confirm reject invitation

    Examples:
      | email                              |password      | company|iconaccountmenu|
      | qa-ccn-27453@mailinator.com     |CCNPegasus123 |mailinator CCNPEGASUS_QA|My Company     |

#		  | qa-ccn-39739@mailinator.com        |CCNPegasus123 |mailinator CCNPEGASUS_QA|My Company     |
#		  | qa-ccn-99227@mailinator.com        |CCNPegasus123 |QA CCN Company|My Company     |

  @CreateMyCompany-40 @MyCompany @regression  @mycompany55
  Scenario Outline: Admin company invite non-cube user to company
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    When press invite users button
    And input email "<otheruseremail>" on the pop up
    And press invite button on the pop up
    Then success invite user "<otheruseremail>" to the company "<companyusera>"

    #qa-ccn-50128@mailinator.com
    #

    Examples:
      |otheruseremail        | email                              |password      | otheruseremail                 |iconaccountmenu|companyusera|
      |wwwwwww@gmail.com| qa-ccn-46551@mailinator.com        |CCNPegasus123 | qa-ccn-93901@mailinator.com |My Company     |mailinatorCCNPEGASUS_QA|
#		  | qa-ccn-46551@mailinator.com        |CCNPegasus123 | qa-ccn-09538@mailinator.com |My Company     |mailinatorCCNPEGASUS_QA|

#		  | qa-ccn-25470@mailinator.com        |CCNPegasus123 | irsyad.muhamad.andre@gmail.com |
#		  | qa-ccn-25470@mailinator.com        |CCNPegasus123 | ray@yomail.com |

  @CreateMyCompany-41 @MyCompany @regression  @mycompany56
  Scenario Outline: non cube user register new account to join invitation company
    And open email mailinator
    And registration with new account and try login
    And will redirected to suggested company list which match with domain name of the users
    And go to my icon account menu "<iconaccountmenu>"

    #qa-ccn-50128@mailinator.com
    #

    Examples:
      | email                              |password      | iconaccountmenu|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 |  My Company     |
#		  | qa-ccn-46551@mailinator.com        |CCNPegasus123 | qa-ccn-09538@mailinator.com |My Company     |mailinatorCCNPEGASUS_QA|

#		  | qa-ccn-25470@mailinator.com        |CCNPegasus123 | irsyad.muhamad.andre@gmail.com |
#		  | qa-ccn-25470@mailinator.com        |CCNPegasus123 | ray@yomail.com |

  @CreateMyCompany-42 @MyCompany @regression  @mycompany57
  Scenario Outline: non cube user after create new account, accept invitaion company from admin company
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my company
    And will redirected to the application status
    And status user was still "PENDING ACCEPT"
    When press button accept invitation
    Then confirm accept invitation

    Examples:
      | email                              |password      | company|iconaccountmenu|
      | qa-ccn-27453@mailinator.com     |CCNPegasus123 |mailinator CCNPEGASUS_QA|My Company     |

#		  | qa-ccn-39739@mailinator.com        |CCNPegasus123 |mailinator CCNPEGASUS_QA|My Company     |
#		  | qa-ccn-99227@mailinator.com        |CCNPegasus123 |QA CCN Company|My Company     |

  @CreateMyCompany-43 @MyCompany @regression  @mycompany58
  Scenario Outline: non cube user after create new account, reject invitaion company from admin company
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my company
    And will redirected to the application status
    And status user was still "PENDING ACCEPT"
    When press button reject invitation
    Then confirm reject invitation

    Examples:
      | email                              |password      | company|iconaccountmenu|
      | qa-ccn-27453@mailinator.com     |CCNPegasus123 |mailinator CCNPEGASUS_QA|My Company     |

#		  | qa-ccn-39739@mailinator.com        |CCNPegasus123 |mailinator CCNPEGASUS_QA|My Company     |
#		  | qa-ccn-99227@mailinator.com        |CCNPegasus123 |QA CCN Company|My Company     |

  @CreateMyCompany-44 @MyCompany @regression  @mycompany59
  Scenario Outline: Verify Sorting data for column user on mycompany member ascending sorting
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab

    Examples:
      | email                              |password      |       iconaccountmenu	|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | My Company     				|

  @CreateMyCompany-45 @MyCompany @regression  @mycompany60
  Scenario Outline: Verify Sorting data for column user on mycompany member descending sorting
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab

    Examples:
      | email                              |password      |       iconaccountmenu	|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | My Company     				|

  @CreateMyCompany-46 @MyCompany @regression  @mycompany61
  Scenario Outline: Verify Sorting data for column role on mycompany member ascending sorting
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab

    Examples:
      | email                              |password      |       iconaccountmenu	|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | My Company     				|

  @CreateMyCompany-47 @MyCompany @regression  @mycompany62
  Scenario Outline: Verify Sorting data for column role on mycompany member descending sorting
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab

    Examples:
      | email                              |password      |       iconaccountmenu	|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | My Company     				|

  @CreateMyCompany-48 @MyCompany @regression  @mycompany63
  Scenario Outline: Verify Sorting data for column status on mycompany member ascending sorting
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab

    Examples:
      | email                              |password      |       iconaccountmenu	|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | My Company     				|


  @CreateMyCompany-49 @MyCompany @regression  @mycompany64
  Scenario Outline: Verify Sorting data for column status on mycompany member descending sorting
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab

    Examples:
      | email                              |password      |       iconaccountmenu	|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | My Company     				|

  @CreateMyCompany-50 @MyCompany @regression  @mycompany65
  Scenario Outline: verifiy filter status member by click "all" then all the checklist including tabel header checklist is check, then click "x mount users selected" blue to unchecklist all data including header table checklist
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    And click all

    Examples:
      | email                              |password      |       iconaccountmenu	|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | My Company     				|


  @CreateMyCompany-51 @MyCompany @regression  @mycompany66
  Scenario Outline: verifiy filter status member by click "pending accept" then all the checklist data, then click "x mount users selected" blue to unchecklist all data including header table checklistm, and see "remove" red button
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    And filter member with status "PENDING ACCEPT"
    And click amount users selected

    Examples:
      | email                              |password      |       iconaccountmenu	|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | My Company     				|


  @CreateMyCompany-52 @MyCompany @regression  @mycompany67
  Scenario Outline: able to remove all "pending accept status" by selecting the filter for that status, and able to see "amount users selected" and "remove", click "remove" for remove all "pending accept" status
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    And filter member with status "PENDING ACCEPT"
    And click remove

    Examples:
      | email                              |password      |       iconaccountmenu	|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | My Company     				|

  @CreateMyCompany-53 @MyCompany @regression  @mycompany68
  Scenario Outline: verifiy filter status member by click "pending approve" then all the checklist data, then click "x mount users selected" blue to unchecklist all data including header table checklistm, and see "remove" red button and "approve" green button
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    And filter member with status "PENDING APPROVE"
    And click x amount users selected

    Examples:
      | email                              |password      |       iconaccountmenu	|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | My Company     				|


  @CreateMyCompany-54 @MyCompany @regression  @mycompany69
  Scenario Outline: able to remove all "pending accept status" by selecting the filter for that status, and able to see "amount users selected","�pprove" and "remove", click "remove" for remove all "pending approve" status
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And press member tab
    And filter member with status "PENDING ACCEPT"


    Examples:
      | email                              |password      |       iconaccountmenu	|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | My Company     				|

  @CreateMyCompany-55 @MyCompany @regression  @mycompany70
  Scenario Outline: able to approve all "pending approve status" by selecting the filter for that status, and able to see "amount users selected","�pprove" and "remove", click "approve" for approve all "pending approve" status
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    And filter member with status "PENDING APPROVE"

    Examples:
      | email                              |password      |       iconaccountmenu	|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | My Company     				|


  @CreateMyCompany-56 @MyCompany @regression  @mycompany71
  Scenario Outline: verifiy filter status member by click "active" then uncheclist current admin account being used, then all the checklist data, then click "x mount users selected" blue to unchecklist all data including header table checklistm, and see "remove" red button and "approve" green button
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    And filter member with status "Active"
    And uncheclist current admin account

    Examples:
      | email                              |password      |       iconaccountmenu	|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | My Company     				|

  @CreateMyCompany-57 @MyCompany @regression  @mycompany72
  Scenario Outline: able to remove all "pending accept status" by selecting the filter for that status, and able to see "amount users selected","�pprove" and "remove", click "remove" for remove all "pending approve" status
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    And filter member with status "PENDING ACCEPT"


    Examples:
      | email                              |password      |       iconaccountmenu	|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | My Company     				|

  @CreateMyCompany-58 @MyCompany @regression  @mycompany73
  Scenario Outline: able to approve all "pending approve status" by selecting the filter for that status, and able to see "amount users selected","�pprove" and "remove", click "approve" for approve all "pending approve" status
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    And filter member with status "PENDING ACCEPT"

    Examples:
      | email                              |password      |       iconaccountmenu	|
      | qa-ccn-46551@mailinator.com        |CCNPegasus123 | My Company     				|

  @ChinaSiteUserFromChina
  Scenario Outline: check subscribtion element on china
    Given go to main web
    Given press sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    When "user from china" click product tab to subscribe to product
    And Select plan "to check subscibtion element" "<product>"
    And wait for response
    And Select plan "to check subscibtion element" "<productB>"
    And wait for response
    And Select plan "to check subscibtion element" "<productC>"
    And wait for response
    And Select plan "to check subscibtion element" "<productD>"
    And wait for response
    And Select plan "to check subscibtion element" "<productE>"
    And wait for response
    And Select plan "to check subscibtion element" "<productF>"
    And wait for response
    And Select plan "to check subscibtion element" "<productH>"
    And wait for response
    And Select plan "to check subscibtion element" "<productI>"
    And wait for response
    And Select plan "to check subscibtion element" "<productJ>"


    Examples:
      | email                         | password      | product       | productB                   | productC                        | productD               | productE                     | productF                      | productG      | productH      | productI   | productJ | productK              |
      | userlevelchina@mailinator.com | CCNPegasus123 | Booking Queue China Site | Cargo Insurance China Site | CargoMart by CargoAi China Site | Lead Freight Solutions | Quotation Request China Site | Quotation Proposal China Site | Bundle BC AWB | AWB Concierge | AWB Editor | DGOffice | Air Line Tariff Query |


  @ChinaSiteCompanyFromChina
  Scenario Outline: check subscribtion element sign in with company from china on china site
    Given go to main web
    Given press sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    When "user from china" click product tab to subscribe to product
    And Select plan "to check subscibtion element" "<product>"
    And wait for response
    And Select plan "to check subscibtion element" "<productB>"
    And wait for response
    And Select plan "to check subscibtion element" "<productC>"
    And wait for response
    And Select plan "to check subscibtion element" "<productD>"
    And wait for response
    And Select plan "to check subscibtion element" "<productE>"
    And wait for response
    And Select plan "to check subscibtion element" "<productF>"
    And wait for response
    And Select plan "to check subscibtion element" "<productH>"
    And wait for response
    And Select plan "to check subscibtion element" "<productI>"
    And wait for response
    And Select plan "to check subscibtion element" "<productJ>"
    And wait for response
    And go to my icon account menu then click subscribe


    Examples:
      | email                       | password      | product       | productB                   | productC                        | productD               | productE                     | productF                      | productG      | productH      | productI   | productJ | productK              |
      | qa-ccn-09538@mailinator.com | CCNPegasus123 | Booking Queue China Site | Cargo Insurance China Site | CargoMart by CargoAi China Site | Lead Freight Solutions | Quotation Request China Site | Quotation Proposal China Site | Bundle BC AWB | AWB Concierge | AWB Editor | DGOffice | Air Line Tariff Query |


  @create_user_company_India
  Scenario Outline: create user company from indonesia
    Given go to main web
    Given press sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    Then will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And input company name "<companyName>" from "<country>" dynamics
    And input company registration "<companyRegis>"
    And input company type "<typeOfCompany>"
    And input country "<countryB>"
    And input city "<cityB>"
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

    Examples:
      | companyemail    | email                | password      | companyName  | companyRegis | typeOfCompany | countryB    | city      | name        | designation  | mobileNo     | iataNo  | cassNo | officeAddress       | postCode | mobileNoCompany | product        | cityB           | country |
      | ind@yopmail.com | indbanga@yopmail.com | CCNPegasus123 | Test         | IND          | GSA           | IN - INDIA  | BANGALORE | India Admin | Plan Manager | 081234567891 | 1234567 | 1234   | 101 Cantonment road |   089774 |      43646363464 | AWB Concierge | BLR - BANGALORE | India   |

  @UpdatePMBeforLeaveFromCompany @UpdatePMBeforeLeaveorRemoveorChangeRole
  Scenario Outline: Update Plan Manager first before leave from a company
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And click leave company
    And click sure want to leave
    Then verify update plan manager pop up available
    And verify the pop up message when leave from the company

    Examples:
      | email                             |password | iconaccountmenu |
      | headquarter_sq@yopmail.com        |P@55w0rd | My Company      |

  @UpdatePMBeforLeaveFromCompany @UpdatePMBeforeLeaveorRemoveorChangeRole
  Scenario Outline: Last admin not as a PM unable to leave from a company
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And click leave company
    And click sure want to leave
    Then verify update plan manager pop up available
    And verify the pop up message when leave from the company

    Examples:
      | email                           |password      | iconaccountmenu |
      | senyorita@mailinator.com        |CCNPegasus123 | My Company      |

  @UpdatePMWhenChangeRole @UpdatePMBeforeLeaveorRemoveorChangeRole
  Scenario Outline: Update Plan Manager first before change role
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    And search email "<otheruseremail>" to be removed from the company
    And press dot on the left side user
    And click change role to user
    Then verify update plan manager pop up available
    And verify the pop up message when change the role for another PM to ordinary user

    Examples:
      | email                         |password | iconaccountmenu | toroles | otheruseremail            |
      | headquarter_sq02@yopmail.com  |P@55w0rd | My Company      | user    | test_300323_a@yopmail.com |

  @UpdatePMRemovePM @UpdatePMBeforeLeaveorRemoveorChangeRole
  Scenario Outline: Update Plan Manager first before remove PM
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "<iconaccountmenu>"
    And press member tab
    And search email "<otheruseremail>" to be removed from the company
    And press dot on the left side user
    And press remove PM or User
    Then verify update plan manager pop up available
    And verify the pop up message when try to remove another PM

    Examples:
      | email                         |password | iconaccountmenu | otheruseremail            |
      | headquarter_sq02@yopmail.com  |P@55w0rd | My Company      | test_300323_a@yopmail.com |

  @ESCLLCLFS
  Scenario Outline: Enhance subscription logic for company level subscription when Plan Manager choose to leave from a company (e.g.LFS)
    Given plan manager as company admin
    When plan manager leave company
    Then verify that Plan manager has been removed from the company.

    Examples:
      | email                         |
      | headquarter_sq02@yopmail.com  |

  @ESCLLCLFS
  Scenario Outline: Enhance subscription logic for company level subscription when remove another company admin (e.g.LFS)
    Given plan manager as company admin
    When remove another company admin
    Then transfer to another plan manager
    And verify that another company admin has been removed from the company.

    Examples:
      | email                         |
      | headquarter_sq02@yopmail.com  |

  @ESCLLCLFS
  Scenario Outline: Enhance subscription logic for company level subscription when change role another company admin (e.g.LFS)
    Given plan manager as company admin
    When change role another company admin
    Then transfer to another plan manager
    And verify that another company admin has been downgrade became member

    Examples:
      | email                         |
      | headquarter_sq02@yopmail.com  |

  @ValidatePimaToSyncWithChexs
  Scenario Outline:  Validate the pima to sync with chexs
    Given validate the pima "<pima>" to sync with chexs

    Examples:
      | pima                    |
      | CSGAGT9166FF5124/SIN01  |

  @companyGroupCheck
  Scenario Outline:  verify company group information
    Given verify company group "<cubeID>" information

    Examples:
      | cubeID                            |
      | 01a93955724546398511f5dd0a271998  |
