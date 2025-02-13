Feature: Notifying subscribers about Subscription update

  @SN @SN4
  Scenario Outline: Notifying subscribers about new Subscriber
    Given user want to update the subscription
    When trigger add new subscriber with "<userPlanID>" and "<member1>" and "<member2>"
    And check in current queue notification in support app for "<contentType>" "<companyCubeId>" and verify the notification payload data

    Examples:
      | contentType       | documentID               | eventAction        | userPlanID               | member1                        | member2                           | companyCubeId                           |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | RemoveSubscriber   | 67a57e93c9fd8602b87034f3 | test_071123_unreg1@yopmail.com | newsubscribercubetest@yopmail.com | 5b11bba54a43425580405245c92cc40b        |

  @SN @SN2
  Scenario Outline: Notifying subscribers about removed Subscriber
    Given user want to update the subscription
    When trigger remove subscriber with "<userPlanID>" and "<member1>"
    And check in current queue notification in support app for "<contentType>" "<companyCubeId>" and verify the notification payload data

    Examples:
      | contentType       | documentID               | eventAction     | userPlanID               | member1                        | companyCubeId                           |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | NewSubscriber   | 67a57faddb7353d68040014a | test_071123_unreg1@yopmail.com | 5b11bba54a43425580405245c92cc40b        |

  @SN @SN3
  Scenario Outline: Notifying subscribers about Subscriber Info Update on user profile display name
    Given user want to update the subscription
    When trigger subscriber info update on user profile "<displayName>"
    And check in current queue notification in support app for "<contentType>" "<companyCubeId>" and verify the notification payload data

    Examples:
      | contentType       | documentID               | eventAction          | displayName | companyCubeId                           |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | SubscriberInfoUpdate | Kochinq1    | 5b11bba54a43425580405245c92cc40b        |

  @SN @SNSUBS @SN5
  Scenario Outline: Notifying subscribers about canceled Subscriber
    Given user want to update the subscription
    When trigger canceled subscriber with "<userPlanID>"
    And check in current queue notification in support app for "<contentType>" "<companyCubeId>" and verify the notification payload data

    Examples:
      | contentType       | documentID               | eventAction        | userPlanID               | companyCubeId                           |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | SubscriptionCancel | 67ab5a1ff7614bdbf13faeda | 5b11bba54a43425580405245c92cc40b        |

  @SN @SNSUBS @SN1
  Scenario Outline: Notifying subscribers about new Subscription
    Given user want to update the subscription
    When trigger new subscription with "<priceId>"
    And check in current queue notification in support app for "<contentType>" "<companyCubeId>" and verify the notification payload data

    Examples:
      | contentType       | documentID               | eventAction     | priceId                  | companyCubeId                           |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | NewSubscription | 6639b083280974e140d9367f | 5b11bba54a43425580405245c92cc40b        |

  @SN @SN6
  Scenario Outline: Notifying subscribers about company update
    Given user want to update the company
    When trigger company update "<address>"
    And check in current queue notification in support app for "<contentType>" "<companyCubeId>" and verify the notification payload data

    Examples:
      | contentType    | documentID               | eventAction | address | companyCubeId                           |
      | CompanyUpdate  | 6786010a9c40e14b15507d6c | Update      | yondu   | 7bd4b51645ac494e924c142d55b154bb        |
