Feature: Payment Settings

  @card-detail
  Scenario Outline: Card admin access card detail with predefined payload
    Given "Card Admin" access card detail with value "<cardDetail>" cardDetail and "<userList>" userList in payload
    Then result will be given based on payload: 200 status code and "<cardDetail>" cardDetail and "<userList>" userList
    Examples:
    |cardDetail | userList |
    |           |          |
    | false |              |
    | true  |              |
    |       | false        |
    |       |  true        |
    | false | false        |
    | false  | true        |
    | true   | false       |
    | true   | true        |

  @card-detail-card-user
  Scenario Outline: Card user access card detail with predefined payload
    Given "Card User" access card detail with value "<cardDetail>" cardDetail and "<userList>" userList in payload
    Then result will be given based on payload: 200 status code and "<cardDetail>" cardDetail and "<userList>" userList
    Examples:
      |cardDetail | userList |
      |           |          |
      | false |              |
      | true  |              |
      |       | false        |
      |       |  true        |
      | false | false        |
      | false  | true        |
      | true   | false       |
      | true   | true        |

  @card-detail-user-card
  Scenario Outline: User card access card detail with predefined payload
    Given "User Card" access card detail with value "<cardDetail>" cardDetail and "<userList>" userList in payload
    Then result will be given based on payload: 401 status code and there's message "Please contact your company card admin"
    Examples:
      |cardDetail | userList |
      |           |          |
      | false |              |
      | true  |              |
      |       | false        |
      |       |  true        |
      | false | false        |
      | false  | true        |
      | true   | false       |
      | true   | true        |

  @card-detail-user
  Scenario Outline: User access card detail with predefined payload
    Given "User" access card detail with value "<cardDetail>" cardDetail and "<userList>" userList in payload
    Then result will be given based on payload: 400 status code and there's message "No card found."
    Examples:
      |cardDetail | userList |
      |           |          |
      | false |              |
      | true  |              |
      |       | false        |
      |       |  true        |
      | false | false        |
      | false  | true        |
      | true   | false       |
      | true   | true        |