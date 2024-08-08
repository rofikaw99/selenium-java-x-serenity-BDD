Feature: CubeforAll

  Scenario: Success access My Portal
    Given User login to Cubeforall
    When Access My Portal menu
    Then My Portal page appears successfully
    And The related API being called once

  Scenario: Success access Dashboard tab
    Given User login to Cubeforall
    When Access My Portal menu
    And Click Dashboard tab
    Then Dashboard page appears successfully
    And The related API being called once

  Scenario: Success access Schedule tab
    Given User login to Cubeforall
    When Access My Portal menu
    And Click Schedule tab
    Then Schedule page appears successfully
    And The related API being called once

  Scenario: Success access Tracking tab
    Given User login to Cubeforall
    When Access My Portal menu
    And Click Tracking tab
    Then Tracking page appears successfully
    And The related API being called once

  Scenario: Success access Feed tab
    Given User login to Cubeforall
    When Access My Portal menu
    And Click Feed tab
    Then Feed page appears successfully
    And The related API being called once

