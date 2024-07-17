Feature: Booking Concierge Product Plan

  @CargoMartbyCargoAiplan @e2e
  Scenario Outline: Subscribe Booking Concierge plan
    Given User with "<Email>" and password "<Password>" login to the web
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And go to my icon account menu "My Subscriptions"
    And open email mailinator after login

    #And Subscribe plan "<product>"
    #Irsyadm.a@ccn.com.sg
    Examples:
      | Email                         | Password      | product       |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Booking Concierge |