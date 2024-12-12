Feature: Enhancement notification to support for notifying subscribers about Subscription and Company updates

  Objective

  To enhance notification to support for notifying subscribers about Subscription and Company updates

  Requirements

  1. Define various contentTypes to represent different actions, such as adding a new subscriber,
  removing an existing subscriber, updating user information, or updating company information.

  2. Each contentType has its own set of tags, allowing subscribers to customize the attributes they
  want to receive by configuring their preferences based on the tag list associated with the
  contentType.

  3. To support BC requirement CR70066, BC will only receive 2 specific contentTypes:
  - SubscriptionUpdate - Array with single object (except the NewSubscriber can have
  multiple objects
  1. eventAction: NewSubscription
  2. eventAction: NewSubscriber
  3. eventAction: SubscriberInfoUpdate
  4. eventAction: RemoveSubscriber
  5. eventAction: SubscriptionCancel
  - CompanyUpdate - Array with single object
  1. evenAction: Update
  2. evenAction: Delete


  Scenario : notifying subscribers about new Subscription update
    Given user want to update the subscription
    When  trigger new subscription
    And check the payload is correct
    Then notifying subscribers about Subscription update

  Scenario : notifying subscribers about new Subscriber update
    Given user want to update the subscription
    When  trigger new subscriber
    And check the payload is correct
    Then notifying subscribers about Subscription update

  Scenario : notifying subscribers about Subscriber Info Update
    Given user want to update the subscription
    When  trigger subscriber info update
    And check the payload is correct
    Then notifying subscribers about Subscription update

  Scenario : notifying subscribers about remove subscriber update
    Given user want to update the subscription
    When  trigger Remove Subscriber
    And check the payload is correct
    Then notifying subscribers about Subscription update

  Scenario : notifying about company update
    Given user want to update the company
    When  trigger to update the company
    And check the payload is correct
    Then notifying about company update

  Scenario : notifying about company update (deleted)
    Given user want to deleted the company
    When  trigger to deleted the company
    And check the payload is correct
    Then notifying about company update