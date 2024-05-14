Feature: Moaah Product Plan

  @moaahstarterplan @e2e
  Scenario Outline: Subscribe moaah starter plan
    Given accept cookie
    When click initial sign in button
    When input email "<Email>" and password "<Password>" and press sign in to continue login
    And back to the main tab browser
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"

    #Irsyadm.a@ccn.com.sg
    Examples:
      | Email                         | Password      | product       |
      | sgqa-ccn-56518@mailinator.com | CCNPegasus123 | Moaah Starter |

  @moaahpremiumplan @e2e
  Scenario Outline: Subscribe moaah starter plan
    Given accept cookie
    When click initial sign in button
    When input email "<Email>" and password "<Password>" and press sign in to continue login
    And back to the main tab browser
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"

    #Irsyadm.a@ccn.com.sg
    Examples:
      | Email                         | Password      | product       |
      | sgqa-ccn-56518@mailinator.com | CCNPegasus123 | Moaah Premium |
