@emailExchange
Feature: Email Exchange

  Objective

  Retrieve the email and compress all attachments into a single ZIP file for the CUBE document that was created in CUBE

  Requirements

  1. Retrieve emails from the mailbox, convert the email body and attachments to JSON format,
  save the document in the sender's company CUBE, and explicit share it with the recipient’s
  company CUBE.

  2. Encode all attachments into a single ZIP file for CUBE document creation.

  3. Differentiate content types for different types of emails based on keywords in the email subject;
  the content types are configurable using a mapping table.

  @REBACDC_1
  Scenario Outline: Send email with keyword "Consignment" along with attachment to another and explicit share it with the recipient’s company CUBE.
#    Given send email from "<senderMail>" with keyword "<keyword>" along with attachment to another company CUBE "<recipientMail>" and cc to "<ccMail>"
    Then retrieve "<recipientMail>" emails from the mailbox
    And convert the email body and attachments to JSON format, save the document in the sender's company CUBE "<senderCompanyCubeID>"
    And explicit share it with the recipient’s "<recipientCompanyCubeID>" company CUBE
    And verify encode all attachments "<recipientCompanyCubeID>" into a single ZIP file for CUBE document creation "<egDocumentID>"

    Examples:
      | keyword     | recipientMail              | senderMail                 | ccMail                       | senderCompanyCubeID              | recipientCompanyCubeID           | egDocumentID             |
      | Consignment | autoqa-ccn-001@yopmail.com | rofikawaludin436@gmail.com | CUBEexchange@ccnexchange.com | 45613b04f70c4935988f9421b4e595a4 | b6cfc71d2f4a4cfdb2b846fbf66c8aa7 | 675bee8e1e73cbef818f4957 |

  @REBACDC_2
  Scenario Outline : Send email with keyword "SHIPMENT ARRIVAL NOTICE" along with attachment to another and explicit share it with the recipient’s company CUBE.
    Given send email from "<senderMail>" with keyword "<keyword>" along with attachment to another company CUBE "<recipientMail>" and cc to "<ccMail>"
    Then retrieve "<recipientMail>" emails from the mailbox
    And convert the email body and attachments to JSON format, save the document in the sender's company CUBE "<senderCompanyCubeID>"
    And explicit share it with the recipient’s "<recipientCompanyCubeID>" company CUBE
    And verify encode all attachments "<recipientCompanyCubeID>" into a single ZIP file for CUBE document creation "<egDocumentID>"

    Examples:
      | keyword                 | recipientMail              | senderMail                 | ccMail                       | senderCompanyCubeID              | recipientCompanyCubeID           | egDocumentID             |
      | SHIPMENT ARRIVAL NOTICE | autoqa-ccn-001@yopmail.com | rofikawaludin436@gmail.com | CUBEexchange@ccnexchange.com | 45613b04f70c4935988f9421b4e595a4 | b6cfc71d2f4a4cfdb2b846fbf66c8aa7 | 675ae84999a71bbad38e2792 |

  @REBACDC_3
  Scenario Outline : Send email with keyword "Notification of Arrival" along with attachment to another and explicit share it with the recipient’s company CUBE.
    Given send email from "<senderMail>" with keyword "<keyword>" along with attachment to another company CUBE "<recipientMail>" and cc to "<ccMail>"
    Then retrieve "<recipientMail>" emails from the mailbox
    And convert the email body and attachments to JSON format, save the document in the sender's company CUBE "<senderCompanyCubeID>"
    And explicit share it with the recipient’s "<recipientCompanyCubeID>" company CUBE
    And verify encode all attachments "<recipientCompanyCubeID>" into a single ZIP file for CUBE document creation "<egDocumentID>"

    Examples:
      | keyword                 | recipientMail              | senderMail                 | ccMail                       | senderCompanyCubeID              | recipientCompanyCubeID           | egDocumentID             |
      | Notification of Arrival | autoqa-ccn-001@yopmail.com | rofikawaludin436@gmail.com | CUBEexchange@ccnexchange.com | 45613b04f70c4935988f9421b4e595a4 | b6cfc71d2f4a4cfdb2b846fbf66c8aa7 | 675ae864f5bbb279ed603b16 |

  Scenario Outline : Send email with keyword not contain "Notification of Arrival" / "Consignment" / "SHIPMENT ARRIVAL NOTICE".
    Given send email from "<senderMail>" with keyword "<keyword>" along with attachment to another company CUBE "<recipientMail>" and cc to "<ccMail>"
    Then retrieve "<recipientMail>" emails from the mailbox
    Then the email body and attachments to JSON format will not coverted, the document in the sender's company CUBE not saved, and not do explicit share it with the recipient’s company CUBE.

    Examples:
      | keyword          | recipientMail              | senderMail                 | ccMail                       |
      | Shipment Request | autoqa-ccn-001@yopmail.com | rofikawaludin436@gmail.com | CUBEexchange@ccnexchange.com |

  Scenario Outline : Send email to recipient emails that do not have a company with keyword contain "Notification of Arrival"
    Given send email from "<senderMail>" with keyword "<keyword>" along with attachment to another company CUBE "<recipientMail>" and cc to "<ccMail>"
    Then retrieve "<recipientMail>" emails from the mailbox
    Then the email body and attachments to JSON format will not coverted, the document in the sender's company CUBE not saved, and not do explicit share it with the recipient’s company CUBE.

    Examples:
      | keyword                 | recipientMail            | senderMail                 | ccMail                       |
      | Notification of Arrival | myqa-ccn-001@yopmail.com | rofikawaludin436@gmail.com | CUBEexchange@ccnexchange.com |

  Scenario Outline : Send email to recipient emails that do not have a company with keyword contain "Consignment".
    Given send email from "<senderMail>" with keyword "<keyword>" along with attachment to another company CUBE "<recipientMail>" and cc to "<ccMail>"
    Then retrieve "<recipientMail>" emails from the mailbox
    Then the email body and attachments to JSON format will not coverted, the document in the sender's company CUBE not saved, and not do explicit share it with the recipient’s company CUBE.

    Examples:
      | keyword     | recipientMail              | senderMail                 | ccMail                       |
      | Consignment | myqa-ccn-001@yopmail.com | rofikawaludin436@gmail.com | CUBEexchange@ccnexchange.com |

  Scenario Outline : Send email to recipient emails that do not have a company with keyword contain "SHIPMENT ARRIVAL NOTICE".
    Given send email from "<senderMail>" with keyword "<keyword>" along with attachment to another company CUBE "<recipientMail>" and cc to "<ccMail>"
    Then retrieve "<recipientMail>" emails from the mailbox
    Then the email body and attachments to JSON format will not coverted, the document in the sender's company CUBE not saved, and not do explicit share it with the recipient’s company CUBE.

    Examples:
      | keyword                 | recipientMail              | senderMail                 | ccMail                       |
      | SHIPMENT ARRIVAL NOTICE | myqa-ccn-001@yopmail.com | rofikawaludin436@gmail.com | CUBEexchange@ccnexchange.com |

  Scenario Outline : Send email to recipient emails that do not have an account in CUBE with keyword contain "Notification of Arrival"
    Given send email from "<senderMail>" with keyword "<keyword>" along with attachment to another company CUBE "<recipientMail>" and cc to "<ccMail>"
    Then retrieve "<recipientMail>" emails from the mailbox
    Then the email body and attachments to JSON format will not coverted, the document in the sender's company CUBE not saved, and not do explicit share it with the recipient’s company CUBE.

    Examples:
      | keyword                 | recipientMail            | senderMail                 | ccMail                       |
      | Notification of Arrival | rofik.awaludin@ccn.com.sg | rofikawaludin436@gmail.com | CUBEexchange@ccnexchange.com |

  Scenario Outline : Send email to recipient emails that do not have an account in CUBE with keyword contain "Consignment".
    Given send email from "<senderMail>" with keyword "<keyword>" along with attachment to another company CUBE "<recipientMail>" and cc to "<ccMail>"
    Then retrieve "<recipientMail>" emails from the mailbox
    Then the email body and attachments to JSON format will not coverted, the document in the sender's company CUBE not saved, and not do explicit share it with the recipient’s company CUBE.

    Examples:
      | keyword     | recipientMail              | senderMail                 | ccMail                       |
      | Consignment | rofik.awaludin@ccn.com.sg | rofikawaludin436@gmail.com | CUBEexchange@ccnexchange.com |

  Scenario Outline : Send email to recipient emails that do not have an account in CUBE with keyword contain "SHIPMENT ARRIVAL NOTICE".
    Given send email from "<senderMail>" with keyword "<keyword>" along with attachment to another company CUBE "<recipientMail>" and cc to "<ccMail>"
    Then retrieve "<recipientMail>" emails from the mailbox
    Then the email body and attachments to JSON format will not coverted, the document in the sender's company CUBE not saved, and not do explicit share it with the recipient’s company CUBE.

    Examples:
      | keyword                 | recipientMail              | senderMail                 | ccMail                       |
      | SHIPMENT ARRIVAL NOTICE | rofik.awaludin@ccn.com.sg | rofikawaludin436@gmail.com | CUBEexchange@ccnexchange.com |