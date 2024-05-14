@loginall
Feature: Login Cubeforall

  @logincube @logins1
  Scenario: Login with happy flow 1
    Given accept cookie
    When click initial sign in button
    And input initial email sign in
    And input initial password sign in
    And click final sign in button
    Then back to the main tab browser

  @logincubeparam @logins2
  Scenario Outline: Login with happy flow 2
    Given accept cookie
    When click initial sign in button
    When input email "<Email>" and password "<Password>" and press sign in to continue login
    And back to the main tab browser
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"

    #Irsyadm.a@ccn.com.sg
    Examples:
      | Email                         | Password      |product|
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |Moaah|
      #| sgqa-ccn-55050@mailinator.com          | CCNPegasus123      |
      #| test_sandbox_01@yopmail.com          | P@55w0rd      |
      #| Irsyadm.a@ccn.com.sg          | qyUk!4VN      |
      #| ray_yao@ccn.com.sg          | P@55w0rd      |
      #| ceva_member_07@yopmail.com | P@55w0rd |
      #| qa-ccn-04346@mailinator.com | CCNPegasus123 |
