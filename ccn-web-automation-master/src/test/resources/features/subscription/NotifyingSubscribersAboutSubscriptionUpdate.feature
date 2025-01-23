@SN
Feature: notifying subscribers about Subscription update

  @SN5
  Scenario Outline : notifying subscribers about canceled Subscriber
    Given user want to update the subscription
    When  trigger canceled subscriber with "<userPlanID>"
    And check in current queue in support app for "<contentType>"
    Then notifying subscribers about Subscription update with input content type "<contentType>" param
    And check the response payload is correct with input "<contentType>" and "<eventAction>"
    And a few moment later check on history queue in support app with "<documentID>" input param

    Examples:
      | contentType       | documentID               | eventAction        | userPlanID               |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | SubscriptionCancel | 679064e47d3a9798e63379cf |

  @SN1
  Scenario Outline : notifying subscribers about new Subscription update
    Given user want to update the subscription
    When  trigger new subscription with "<priceId>"
    And check in current queue in support app for "<contentType>"
    Then notifying subscribers about Subscription update with input content type "<contentType>" param
    And check the response payload is correct with input "<contentType>" and "<eventAction>"
    And a few moment later check on history queue in support app with "<documentID>" input param

    Examples:
      | contentType       | documentID               | eventAction     | priceId                  |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | NewSubscription | 6639b083280974e140d9367f |

  @SN2
  Scenario Outline: notifying subscribers about new Subscriber
    Given user want to update the subscription
    When  trigger add new subscriber with "<userPlanID>" and "<member1>"
    And check in current queue in support app for "<contentType>"
    Then notifying subscribers about Subscription update with input content type "<contentType>" param
    And check the response payload is correct with input "<contentType>" and "<eventAction>"
    And a few moment later check on history queue in support app with "<documentID>" input param

    Examples:
      | contentType       | documentID               | eventAction     | userPlanID               | member1                        |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | NewSubscriber   | 679064e47d3a9798e63379cf | test_071123_unreg1@yopmail.com |

  @SN3
  Scenario Outline : notifying subscribers about Subscriber Info Update on user profile display name
    Given user want to update the subscription
    When  trigger subscriber info update on user profile "<displayName>"
    And check in current queue in support app for "<contentType>"
    Then notifying subscribers about Subscription update with input content type "<contentType>" param
    And check the response payload is correct with input "<contentType>" and "<eventAction>"
    And a few moment later check on history queue in support app with "<documentID>" input param

    Examples:
      | contentType       | documentID               | eventAction            | displayName |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | SubscriberInfoUpdate   | Kochinq1    |

  @SN4
  Scenario Outline : notifying subscribers about removed Subscriber
    Given user want to update the subscription
    When trigger remove subscriber with "<userPlanID>" and "<member1>" and "<member2>"
    And check in current queue in support app for "<contentType>"
    Then notifying subscribers about Subscription update with input content type "<contentType>" param
    And check the response payload is correct with input "<contentType>" and "<eventAction>"
    And a few moment later check on history queue in support app with "<documentID>" input param

    Examples:
      | contentType       | documentID               | eventAction        | userPlanID               | member1                        | member2                           |
      | SubscriptionUpdate| 6786010a9c40e14b15507d6c | RemoveSubscriber   | 679064e47d3a9798e63379cf | test_071123_unreg1@yopmail.com | newsubscribercubetest@yopmail.com |

  @SN6
  Scenario Outline : notifying subscribers about company update
    Given user want to update the company
    When  trigger company update
    And check in current queue in support app for "<contentType>"
    Then notifying subscribers about Subscription update with input content type "<contentType>" param
    And check the response payload is correct with input "<contentType>" and "<eventAction>"
    And a few moment later check on history queue in support app with "<documentID>" input param

    Examples:
      | contentType    | documentID               | eventAction |
      | CompanyUpdate  | 6786010a9c40e14b15507d6c | Update      |
#
#  Scenario : notifying subscribers about delete the company (for future use)
#    Given user want to update the company
#    When  trigger to delete the company (for future use)
#    And check the payload is correct
#    Then notifying about company update
#    And check in current queue in support app
#    Then a few moment later check on history queue in support app