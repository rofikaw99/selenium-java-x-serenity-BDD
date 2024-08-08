Feature: Dashboard

  @success-create-document
  Scenario: Success create document shipment
    Given get register of the email
    When create document shipment with valid awb
    Then success create document
    And new document appears in the list of AWB

  @success-search-document
  Scenario: Success search awb with valid AWB Number
    Given "Card User" login to the web
    When search awb with valid and registered awb number
    Then awb that matched with awb keyword appears

  @add-to-watchlist
  Scenario: Add to Watchlist
    Given "Card User" login to the web
    When adding awb number to be tracked
    Then success add awb number to watchlist
