@registerApiV2
Feature: Register V2

  Scenario Outline: success register new individual user
    Given user want to register new mail to cube with "<mail>" input
    When  send the request with "<mail>" input
    Then get response "<responseCode>"
    And get response email and status

    Examples:
      | responseCode | mail                                    |
      | 200          | system.csgair01hdqfmaaa@ccnexchange.com |

  Scenario Outline: registered the individual mail that already registered before
    Given user want to register existing mail to cube with "<mail>" input
    When  send the request with "<mail>" input
    Then get response "<responseCode>"
    And get validation response that the email that email already registered

    Examples:
      | responseCode | mail                                   |
      | 201          | system.csgair01hdqfmaa@ccnexchange.com |

  Scenario Outline: success register new multiple user
    Given user want to register multiple mail to cube with multiple mail "<mail1>" "<mail2>" input
    When  send the request for register multiple mail to cube with multiple mail input "<mail1>" "<mail2>"
    Then get response "<responseCode>"
    And get response email and status

    Examples:
      | responseCode | mail1                                  | mail2                                  |
      | 200          | system.csgair01hdqfmaaa@ccnexchange.com | system.csgair01hdqfmaaa@ccnexchange.com |

  Scenario Outline: registered the multiple mail that already registered before
    Given user want to register multiple mail to cube with multiple mail "<mail1>" "<mail2>" input
    When  send the request for register multiple mail to cube with multiple mail input "<mail1>" "<mail2>"
    Then get response "<responseCode>"
    And get validation response that the email that email already registered

    Examples:
      | responseCode | mail1                                  | mail2                                  |
      | 201          | system.csgair01hdqfmaa@ccnexchange.com | system.csgair01hdqfmaa@ccnexchange.com |

  Scenario Outline: success get register by cube ID
    Given user want to get register by "<param>"
    When  send the request to get register by cube ID
    Then get response "<responseCode>"
    And get response email and status

    Examples:
      | responseCode | param                            |
      | 200          | e222543c5aed4437b93652156bc27fec |

  Scenario Outline: success get register by mail
    Given user want to get register by "<param>"
    When  send the request to get register by mail
    Then get response "<responseCode>"
    And get box url and site response

    Examples:
      | responseCode | param                    |
      | 200          | myqa-ccn-001@yopmail.com |

  Scenario Outline: success get all registered user mail, cube ID and status
    Given user want to get all registered user V2
    When  send the get all registered user V2 request
    Then get response "<responseCode>"
    And get response all register mail and cubeID
    And get response body cubeID, email, and status

    Examples:
      | responseCode |
      | 200          |

  Scenario Outline: success to Put Identity LINC
    Given user want to put Identity LINC with input some required data
    Then get response "<responseCode>"
    And get response body value message and log id

    Examples:
      | responseCode |
      | 200          |

