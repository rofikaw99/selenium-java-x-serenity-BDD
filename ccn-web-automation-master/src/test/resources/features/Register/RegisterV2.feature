@check-status
Feature: Register V2

  Scenario: success register new user
    Given user want to register new mail to cube with mail input
    When  send the request
    Then get response 200
    And get response BOXURL & site

  Scenario: success register new multiple user
    Given user want to register new mail to cube with mail input
    When  send the request
    Then success register new mail
    And get response BOXURL & site

  Scenario: success get register by cube ID
    Given user want to get register by cube ID
    When  send the request
    Then get response 200
    And get response email & status

  Scenario: success get register by mail
    Given user want to register new mail to cube with mail input
    When  send the request
    Then get response 200
    And get response all register mail & cubeid

  Scenario: success get all registered user mail, cube ID and status
    Given user want to get all registered user
    When  send the request
    Then get response 200
    And get response all register mail and cubeID
    And get response body cubeID, email, and status

  Scenario: Put Identity LINC
    Given user want to put Identity LINC with input some required data
    And send the request
    Then get response 200

