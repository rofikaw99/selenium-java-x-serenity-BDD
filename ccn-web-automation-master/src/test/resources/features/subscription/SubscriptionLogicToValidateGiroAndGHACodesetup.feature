Feature: Enhance Subscription logic to validate Giro & GHA Code setup

  @GHACodeValidationMessage @GHAGiro
  Scenario Outline: Enhance Subscription logic to validate GHA Code setup
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan Test BC-Premium Multicurrency#Sandbox
    And Subscribe plan "<product>"

    Examples:
      | email              | password      | product                              |
      | sripcn@yopmail.com | CCNPegasus123 | test bc premium multicurrencysandbox |

  @GiroValidationMessage @GHAGiro
  Scenario Outline: Enhance Subscription logic to validate Giro setup
    Given go to main web
    When click initial sign in button
    When input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan TDSB
    And Subscribe plan "<product>"

    Examples:
      | email              | password      | product  |
      | sripcn@yopmail.com | CCNPegasus123 | TDSB     |
