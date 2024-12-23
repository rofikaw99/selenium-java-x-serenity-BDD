Feature: notifying subscribers about Subscription update


  Scenario : notifying subscribers about new Subscription update
    Given user want to update the subscription
    When  trigger new subscription
    And check the payload is correct
    Then notifying subscribers about Subscription update
    And check in current queue in support app
    Then a few minutes later check on history queue in support app

  Scenario : notifying subscribers about new Subscriber
    Given user want to update the subscription
    When  trigger add new subscriber
    And check the payload is correct
    Then notifying subscribers about Subscription update
    And check in current queue in support app
    Then a few minutes later check on history queue in support app

  Scenario : notifying subscribers about new Subscriber
    Given user want to update the subscription
    When  trigger add new subscriber
    And check the payload is correct
    Then notifying subscribers about Subscription update
    And check in current queue in support app
    Then a few mintes later check on history queue in support app

  Scenario : notifying subscribers about Subscriber Info Update
    Given user want to update the subscription
    When  trigger subscriber info update
    And check the payload is correct
    Then notifying subscribers about Subscription update
    And check in current queue in support app
    Then a few mintes later check on history queue in support app

  Scenario : notifying subscribers about removed Subscriber
    Given user want to update the subscription
    When  trigger remove subscriber
    And check the payload is correct
    Then notifying subscribers about Subscription update
    And check in current queue in support app
    Then a few minutes later check on history queue in support app

  Scenario : notifying subscribers about canceled Subscriber
    Given user want to update the subscription
    When  trigger canceled subscriber
    And check the payload is correct
    Then notifying subscribers about Subscription update
    And check in current queue in support app
    Then a few minutes later check on history queue in support app

  Scenario : notifying subscribers about company update
    Given user want to update the company
    When  trigger company update
    And check the payload is correct
    Then notifying about company update
    And check in current queue in support app
    Then a few minutes later check on history queue in support app

  Scenario : notifying subscribers about delete the company (for future use)
    Given user want to update the company
    When  trigger to delete the company (for future use)
    And check the payload is correct
    Then notifying about company update
    And check in current queue in support app
    Then a few minutes later check on history queue in support app