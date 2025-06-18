@SN
Feature: Notifying subscribers about Subscription update

  Scenario: Retrieve notification when user has BC 3.0 subscription
    Given the user has an active BC 3.0 subscription
    When the system checks for subscription and company notification
    Then the system should retrieve the Subscription and Company Notification

  Scenario: Do not retrieve notification when user no longer has BC 3.0 subscription
    Given the user does not have an active BC 3.0 subscription
    When the system checks for subscription and company notification
    Then the system should not retrieve any Subscription and Company Notification

  Scenario: Do not retrieve BC 3.0 beta notification when user only has stock app subscription
    Given the user has an active Stock App subscription
    And the user has BC 3.0 beta subscription
    When the system checks for subscription and company notification
    Then the system should not retrieve BC 3.0 beta Subscription and Company Notification

  Scenario: Do not retrieve any notification for subscriptions other than stock app or BC 3.0 beta
    Given the user has a subscription other than stock app or BC 3.0 beta
    When the system checks for subscription and company notification
    Then the system should not retrieve any Subscription and Company Notification

  @SN @SN1 @SNR
  Scenario Outline: Notifying subscribers about new Subscriber
    Given user want to update the subscription
    When trigger add new subscriber with "<userPlanID>" and "<member1>" and "<member2>"
    And check in current queue notification in support app for "<contentType>" "<companyCubeId>" and verify the notification payload data

    Examples:
      | contentType       | documentID               | eventAction        | userPlanID               | member1                        | member2                           | companyCubeId                           |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | RemoveSubscriber   | 67ac56b25eca292caaf03c34 | au-autoqa-ccn-001@yopmail.com | au2-autoqa-ccn-001@yopmail.com | 5b11bba54a43425580405245c92cc40b        |

  @SN @SN2 @SNR
  Scenario Outline: Notifying subscribers about removed Subscriber
    Given user want to update the subscription
    When trigger remove subscriber with "<userPlanID>" and "<member1>"
    And check in current queue notification in support app for "<contentType>" "<companyCubeId>" and verify the notification payload data

    Examples:
      | contentType       | documentID               | eventAction     | userPlanID               | member1                        | companyCubeId                           |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | NewSubscriber   | 67ac56b25eca292caaf03c34 | au-autoqa-ccn-001@yopmail.com | 5b11bba54a43425580405245c92cc40b        |

  @SN @SN3 @SNR
  Scenario Outline: Notifying subscribers about Subscriber Info Update on user profile display name
    Given user want to update the subscription
    When trigger subscriber info update on user profile "<displayName>"
    And check in current queue notification in support app for "<contentType>" "<companyCubeId>" and verify the notification payload data

    Examples:
      | contentType       | documentID               | eventAction          | displayName | companyCubeId                           |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | SubscriberInfoUpdate | Kochinq2    | 5b11bba54a43425580405245c92cc40b        |

  @SN @SNSUBS @SN4
  Scenario Outline: Notifying subscribers about canceled Subscription
    Given user want to update the subscription
    When trigger canceled subscriber with "<userPlanID>"
    And check in current queue notification in support app for "<contentType>" "<companyCubeId>" and verify the notification payload data

    Examples:
      | contentType       | documentID               | eventAction        | userPlanID               | companyCubeId                           |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | SubscriptionCancel | 67ac56b25eca292caaf03c34 | 5b11bba54a43425580405245c92cc40b        |

  @SN @SNSUBS @SN5
  Scenario Outline: Notifying subscribers about new free Subscription
    Given user want to update the subscription
    When trigger new subscription with "<priceId>"
    And check in current queue notification in support app for "<contentType>" "<companyCubeId>" and verify the notification payload data

    Examples:
      | contentType       | documentID               | eventAction     | priceId                  | companyCubeId                           |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | NewSubscription | 6639b083280974e140d9367f | 5b11bba54a43425580405245c92cc40b        |

  @SN @SNSUBS @SN6
  Scenario Outline: Notifying subscribers about new licence Subscription
    Given user want to update the subscription
    When trigger new subscription with "<priceId>"
    And check in current queue notification in support app for "<contentType>" "<companyCubeId>" and verify the notification payload data

    Examples:
      | contentType       | documentID               | eventAction     | priceId                  | companyCubeId                           |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | NewSubscription | 65080d09702c39fae35ceca0 | 5b11bba54a43425580405245c92cc40b        |

  @SN @SNSUBS @SN7
  Scenario Outline: Notifying subscribers about new bundle Subscription
    Given user want to update the subscription
    When trigger new subscription with "<priceId>"
    And check in current queue notification in support app for "<contentType>" "<companyCubeId>" and verify the notification payload data

    Examples:
      | contentType       | documentID               | eventAction     | priceId                  | companyCubeId                           |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | NewSubscription | 6542b80735e603a44d404aa3 | 5b11bba54a43425580405245c92cc40b        |

  @SN @SN8 @SNR
  Scenario Outline: Notifying subscribers about company update
    Given user want to update the company
    When trigger company update "<address>"
    And check in current queue notification in support app for "<contentType>" "<companyCubeId>" and verify the notification payload data

    Examples:
      | contentType    | documentID               | eventAction | address | companyCubeId                           |
      | CompanyUpdate  | 6786010a9c40e14b15507d6c | Update      | yonduy   | 7bd4b51645ac494e924c142d55b154bb        |

  @MULTIPLESN8
  Scenario Outline: Notifying subscribers about company update
    Given user want to update the company
    When trigger company update multiple "<address>"
    And check in current queue notification in support app for "<contentType>" "<companyCubeId>" and verify the notification payload data

    Examples:
      | contentType    | documentID               | eventAction | address | companyCubeId                           |
      | CompanyUpdate  | 6786010a9c40e14b15507d6c | Update      | yonduy   | 7bd4b51645ac494e924c142d55b154bb        |


