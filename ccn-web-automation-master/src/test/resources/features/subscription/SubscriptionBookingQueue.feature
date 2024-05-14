Feature: Booking Queue Product Plan

  @BookingQueueplan-1 @e2e
  Scenario Outline: Offline payment User level Subscribe "Booking Queue" plan with "active" status, user count "1" billing cycle "-" and get email user side
    Given accept cookie
    When click initial sign in button
    When input email "<Email>" and password "<Password>" and press sign in to continue login
    And back to the main tab browser
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And go to my icon account menu "My Subscriptions"
    And open email mailinator after login

    Examples:
      | Email                         | Password      | product       |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Booking Queue |

  @BookingQueueplan-1 @e2e
  Scenario Outline: Offline payment User level UnSubscribe "Booking Queue" plan with "cancelled" status, user count "1" billing cycle "Expired on date" and get email user side
    When click initial sign in button
    When input email "<Email>" and password "<Password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Subscriptions"
    And UnSubscribe plan "<product>"
    And open email mailinator after login

    Examples:
      | Email                         | Password      | product       |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Booking Queue |


  @BookingQueueplan-1 @e2e
  Scenario Outline: Offline payment  Company member Subscribe "Booking Queue" plan with "active" status, user count "1" billing cycle "-" and get email user side
    Given accept cookie
    When click initial sign in button
    When input email "<Email>" and password "<Password>" and press sign in to continue login
    And back to the main tab browser
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And go to my icon account menu "My Subscriptions"
    And open email mailinator after login

    Examples:
      | Email                         | Password      | product       |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Booking Queue |

  @BookingQueueplan-1 @e2e
  Scenario Outline: Offline payment  Company member UnSubscribe "Booking Queue" plan with "cancelled" status, user count "1" billing cycle "Expired on date" and get email user side
    Given accept cookie
    When click initial sign in button
    When input email "<Email>" and password "<Password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Subscriptions"
    And UnSubscribe plan "<product>"
    And open email mailinator after login

    Examples:
      | Email                         | Password      | product       |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Booking Queue |


  @BookingQueueplan-1 @e2e
  Scenario Outline: Offline payment Company member admin Subscribe "Booking Queue" plan with "active" status, user count "1" billing cycle "-" and get email user side
    Given accept cookie
    When click initial sign in button
    When input email "<Email>" and password "<Password>" and press sign in to continue login
    And back to the main tab browser
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And go to my icon account menu "My Subscriptions"
    And open email mailinator after login


    Examples:
      | Email                         | Password      | product       |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Booking Queue |



  @BookingQueueplan-1 @e2e
  Scenario Outline: Offline payment Company member admin UnSubscribe "Booking Queue" plan with "cancelled" status, user count "1" billing cycle "Expired on date" and get email user side
    Given accept cookie
    When click initial sign in button
    When input email "<Email>" and password "<Password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Subscriptions"
    And UnSubscribe plan "<product>"
    And open email mailinator after login

    Examples:
      | Email                         | Password      | product       |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Booking Queue |

 #online payment

  @BookingQueueplan-1 @e2e
  Scenario Outline: Online payment User level Subscribe "Booking Queue" plan with "active" status, user count "1" billing cycle "-" and get email user side
    Given accept cookie
    When click initial sign in button
    When input email "<Email>" and password "<Password>" and press sign in to continue login
    And back to the main tab browser
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    And open email mailinator after login

    Examples:
      | Email                         | Password      | product       |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Booking Queue |

  @BookingQueueplan-1 @e2e
  Scenario Outline: Online payment User level UnSubscribe "Booking Queue" plan with "cancelled" status, user count "1" billing cycle "Expired on date" and get email user side
    Given accept cookie
    When click initial sign in button
    When input email "<Email>" and password "<Password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Subscriptions"
    And UnSubscribe plan "<product>"
    And open email mailinator after login

    #And Subscribe plan "<product>"
    #Irsyadm.a@ccn.com.sg
    Examples:
      | Email                         | Password      | product       |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Booking Queue |


  @BookingQueueplan-1 @e2e
  Scenario Outline: Online payment Company member Subscribe "Booking Queue" plan with "active" status, user count "1" billing cycle "-" and get email user side
    Given accept cookie
    When click initial sign in button
    When input email "<Email>" and password "<Password>" and press sign in to continue login
    And back to the main tab browser
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    And open email mailinator after login

    #And Subscribe plan "<product>"
    #Irsyadm.a@ccn.com.sg
    Examples:
      | Email                         | Password      | product       |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Booking Queue |

  @BookingQueueplan-1 @e2e
  Scenario Outline: Online payment Company member UnSubscribe "Booking Queue" plan with "cancelled" status, user count "1" billing cycle "Expired on date" and get email user side
    Given accept cookie
    When click initial sign in button
    When input email "<Email>" and password "<Password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Subscriptions"
    And UnSubscribe plan "<product>"
    And open email mailinator after login

    #And Subscribe plan "<product>"
    #Irsyadm.a@ccn.com.sg
    Examples:
      | Email                         | Password      | product       |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Booking Queue |


  @BookingQueueplan-1 @e2e
  Scenario Outline: Online payment Company member admin Subscribe "Booking Queue" plan with "active" status, user count "1" billing cycle "-" and get email user side
    Given accept cookie
    When click initial sign in button
    When input email "<Email>" and password "<Password>" and press sign in to continue login
    And back to the main tab browser
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    And open email mailinator after login

    #And Subscribe plan "<product>"
    #Irsyadm.a@ccn.com.sg
    Examples:
      | Email                         | Password      | product       |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Booking Queue |



  @BookingQueueplan-1 @e2e
  Scenario Outline: Online payment Company member admin UnSubscribe "Booking Queue" plan with "cancelled" status, user count "1" billing cycle "Expired on date" and get email user side
    Given accept cookie
    When click initial sign in button
    When input email "<Email>" and password "<Password>" and press sign in to continue login
    And back to the main tab browser
    And go to my icon account menu "My Subscriptions"
    And UnSubscribe plan "<product>"
    And open email mailinator after login

    #And Subscribe plan "<product>"
    #Irsyadm.a@ccn.com.sg
    Examples:
      | Email                         | Password      | product       |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Booking Queue |
