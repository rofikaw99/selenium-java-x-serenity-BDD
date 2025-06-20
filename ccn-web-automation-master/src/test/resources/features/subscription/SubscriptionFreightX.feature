Feature: Freight-X Plan

  Scenario Outline: User subscribes to "<Plan>" with optional add-on
    Given the user selects "<Plan>" as the subscription plan
    And the user <AddonSelected> selects the MyInvois via PEPPOL add-on
    And the user adds <UserCount> members
    And the user agrees to both "CCN T&C" and "Partner’s T&C"
    When the user submits the subscription
    Then the system should generate a subscription with base price <BasePrice> * <UserCount>
    And <AddonCharge> be added once for the add-on
    And the system should generate a unique priceID for this combination

    Examples:
      | Plan                                            | AddonSelected | UserCount | BasePrice | AddonCharge |
      |-------------------------------------------------|---------------|-----------|-----------|-------------|
      | Air Freight + Finance                           | does not      | 3         | 65        | no charge   |
      | Air Freight + Finance                           | does          | 3         | 65        | 50 SGD      |
      | Sea Freight + Finance                           | does not      | 2         | 65        | no charge   |
      | Sea Freight + Finance                           | does          | 2         | 65        | 50 SGD      |
      | Air Freight + Sea Freight                       | does not      | 4         | 70        | no charge   |
      | Air Freight + Sea Freight                       | does          | 4         | 70        | 50 SGD      |
      | Air Freight + Sea Freight + Finance             | does not      | 5         | 100       | no charge   |
      | Air Freight + Sea Freight + Finance             | does          | 5         | 100       | 50 SGD      |

  Scenario: User tries to subscribe without selecting a plan
    Given the user is on the subscription form
    When the user does not select any plan
    And clicks subscribe
    Then the system should show an error "Please select a subscription plan"

  Scenario: User tries to subscribe without checking one or both T&C
    Given the user selected a plan
    But did not check "CCN T&C" or "Partner’s T&C"
    When the user clicks subscribe
    Then the system should show error "You must accept all mandatory terms"

  Scenario: User tries to subscribe with invalid member count (0)
    Given the user selected a plan
    And added 0 members
    When the user clicks subscribe
    Then the system should show error "At least 1 user is required"

  Scenario: User subscribes to Plan D with multiple members and add-on
    Given the user selects "Air Freight + Sea Freight + Finance" as the subscription plan
    And the user adds 5 members to the plan
    And the user selects the MyInvois via PEPPOL add-on
    And the user agrees to both "CCN T&C" and "Partner’s T&C"
    When the user submits the subscription
    Then the system should charge 100 SGD * 5 for the users
    And add only 50 SGD once for the add-on (per company)

  Scenario Outline: Verify My Subscription page reflects subscribed plan correctly
    Given the user has successfully subscribed to "<Plan>"
    When the user navigates to "My Subscription" page
    Then the subscription entry should show:
      | Product     | Plan                                   | Description                                                                                      |
      | FreightX    | <Plan>                                 | An integrated logistics solution with AI capabilities offers significant benefits...             |
    And the subscription should include:
      | USER COUNT     | <UserCount>      |
      | BILLING CYCLE  | Monthly          |
      | STATUS         | Active           |

    Examples:
      | Plan                                              | UserCount |
      |---------------------------------------------------|-----------|
      | Air Freight + Finance                             | 3         |
      | Air Freight + Finance + MyInvois via PEPPOL       | 2         |
      | Sea Freight + Finance                             | 4         |
      | Sea Freight + Finance + MyInvois via PEPPOL       | 5         |
      | Air Freight + Sea Freight                         | 1         |
      | Air Freight + Sea Freight + MyInvois via PEPPOL   | 2         |
      | Air Freight + Sea Freight + Finance               | 3         |
      | Air Freight + Sea Freight + Finance + MyInvois    | 6         |

  Scenario: Subscribed plan is disabled on subscription list
    Given the user has subscribed to "Air Freight + Finance"
    When the user visits the subscription plan selection page
    Then the "Air Freight + Finance" plan should be shown as disabled
    And other plans should be enabled

  Scenario: Prevent user from subscribing to another plan after already subscribed
    Given the user has already subscribed to "Sea Freight + Finance"
    And the user is on the plan selection page
    When the user clicks on "Air Freight + Sea Freight + Finance"
    Then the system should show a message:
    """
    You have already subscribed to plan 'Sea Freight + Finance'. You cannot subscribe to multiple plans.
    """
    And the subscription should not proceed




