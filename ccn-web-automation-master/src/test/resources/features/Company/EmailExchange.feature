Feature: Email Exchange

  Objective

  Retrieve the email and compress all attachments into a single ZIP file for the CUBE document that was
  created in CUBE

  Requirements

  1. Retrieve emails from the mailbox, convert the email body and attachments to JSON format,
  save the document in the sender's company CUBE, and explicit share it with the recipient’s
  company CUBE.

  2. Encode all attachments into a single ZIP file for CUBE document creation.

  3. Differentiate content types for different types of emails based on keywords in the email subject;
  the content types are configurable using a mapping table.

  Scenario: Send email with keyword "CONSIGMENT" along with attachment to another and explicit share it with the recipient’s company CUBE.
    Given Send email with keyword "CONSIGMENT" along with attachment to another company CUBE.
    And cc to CUBEexchange@ccnexchange.com
    Then Retrieve emails from the mailbox, convert the email body and attachments to JSON format, save the document in the sender's company CUBE, and explicit share it with the recipient’s company CUBE.
    Then verify JSON format is correct

  Scenario: Send email with keyword "SHIPMENT ARRIVAL NOTICE" along with attachment to another and explicit share it with the recipient’s company CUBE.
    Given Send email with keyword "SHIPMENT ARRIVAL NOTICE" along with attachment to another company CUBE.
    And cc to CUBEexchange@ccnexchange.com
    Then Retrieve emails from the mailbox, convert the email body and attachments to JSON format, save the document in the sender's company CUBE, and explicit share it with the recipient’s company CUBE.
    Then verify JSON format is correct

  Scenario: Send email with keyword "Notification of Arrival" along with attachment to another and explicit share it with the recipient’s company CUBE.
    Given Send email with keyword "Notification of Arrival" along with attachment to another company CUBE.
    And cc to CUBEexchange@ccnexchange.com
    Then Retrieve emails from the mailbox, convert the email body and attachments to JSON format, save the document in the sender's company CUBE, and explicit share it with the recipient’s company CUBE.
    Then verify JSON format is correct

  Scenario: Send email with keyword not contain "Notification of Arrival" / "CONSIGMENT" / "SHIPMENT ARRIVAL NOTICE" along with attachment to another and explicit share it with the recipient’s company CUBE.
    Given Send email with keyword not contain "Notification of Arrival" / "CONSIGMENT" / "SHIPMENT ARRIVAL NOTICE" along with attachment to another company CUBE.
    And cc to CUBEexchange@ccnexchange.com
    Then Retrieve emails from the mailbox, convert the email body and attachments to JSON format, save the document in the sender's company CUBE, and explicit share it with the recipient’s company CUBE.
    Then verify JSON format is correct