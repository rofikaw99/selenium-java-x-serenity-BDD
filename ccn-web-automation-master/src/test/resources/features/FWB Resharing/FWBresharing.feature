@FWB
Feature: FWB Re sharing

  @FWB_R_1
  Scenario Outline: Create BC Document and Check Implicit Sharing
    Given  create "<contentType>" doc with "<contentName>"
    And  Check that notification already share to the member within company

    Examples:
      | contentType      | contentName                |
      | BookingRequest   | test-monday-16-august-2024   |

  @FWB_R_2
  Scenario Outline: Create AWB C Document and Check Implicit Sharing
    Given  create "<contentType>" doc with "<contentName>"
    And  Check that notification already share to the member within company

    Examples:
      | contentType  | contentName                  |
      | MAWBRequest  | test-monday-16-august-2024   |

  @FWB_R_3
  Scenario Outline:  Create BC Document and Do Extended Sharing
    Given create "<contentType>" doc with "<contentName>"
    When do extended sharing "<contact>"
    Then make sure that the notification share to the right user

    Examples:
      | contentType      | contentName                  | contact            |
      | BookingRequest   | test-monday-16-august-2024   | sripcn@yopmail.com |

  @FWB_R_4
  Scenario Outline:  Create AWB C Document and Do Extended Sharing
    Given create "<contentType>" doc with "<contentName>"
    When do extended sharing "<contact>"
    Then make sure that the notification share to the right user

    Examples:
      | contentType  | contentName                  | contact            |
      | MAWBRequest  | test-monday-16-august-2024   | sripcn@yopmail.com |

  @FWB_R_5
  Scenario Outline:  Create BC Document and Do Explicit Sharing
    Given create "<contentType>" doc with "<contentName>" from system
    When do explicit sharing "<contact>"
    Then make sure that the notification share to SATS

    Examples:
      | contentType      | contentName                  | contact                                        |
      | BookingRequest   | test-monday-16-august-2024   | system.csggha01singcxh@ccnexchange.com  |

  @FWB_R_6
  Scenario Outline:  Create AWB C Document and Do Explicit Sharing
    Given create "<contentType>" doc with "<contentName>" from system
    When do explicit sharing "<contact>"
    Then make sure that the notification share to SATS

    Examples:
      | contentType  | contentName                  | contact                                        |
#      | MAWBRequest  | test-monday-19-august-2024   | system.csgagt916639d233_cgk01@ccnexchange.com  |
      | MAWBRequest  | test-monday-19-august-2024   | system.csgair01sinfmsq@ccnexchange.com  |

  @FWB_R_11
  Scenario Outline:  Create DockShipment Document and Do Explicit Sharing
    Given create "<contentType>" doc with "<contentName>" from system
    When do explicit sharing "<contact>"
    Then make sure that the notification share to SATS

    Examples:
      | contentType  | contentName                  | contact                                        |
      | DockShipment  | test-monday-19-august-2024   | system.csgagt916639d233_cgk01@ccnexchange.com  |

  @FWB_R_12
  Scenario Outline:  Create DockShipment Document and Do Explicit Sharing
    Given create "<contentType>" doc with "<contentName>" from system
    When do explicit sharing "<contact>"
    Then make sure that the notification share to SATS

    Examples:
      | contentType  | contentName                  | contact                                        |
      | DockBookingUpdate  | test-monday-19-august-2024   | system.csgagt916639d233_cgk01@ccnexchange.com  |

  @FWB_R_7 @notificationV2
  Scenario Outline:  Create BC Document then Perform Share Via Coloader
    Given create "<contentType>" doc with "<contentName>" for share via
    When share "<via>" "<contact>" to airline
    Then verify document succeed share to airline
#    Then verify no encoded content missing

    Examples:
      | contentType      | contentName                  | via                                    | contact                                   |
      | BookingRequest   | test-monday-16-august-2024   | system.pimatest89167@ccnexchange.com   | system.csgair01sinfmsq@ccnexchange.com  |

  @FWB_R_8
  Scenario Outline:  Create BC Document then Perform Share Via non Coloader
    Given create "<contentType>" doc with "<contentName>" for share via
    When share "<via>" "<contact>" to airline
    Then verify document failed share to airline

    Examples:
      | contentType      | contentName                  | via                                        | contact                            |
      | BookingRequest   | test-monday-30-august-2024   | system.csgagt99rhn_ind99@ccnexchange.com   | system.csgair01sinfmsq@ccnexchange.com  |

  @FWB_R_7_2 @notificationV2
  Scenario Outline:  Create BC Document then Perform Share Via Coloader
    Given create "<contentType>" doc with "<contentName>" for share via
    When share "<via>" "<contact>" to airline
    Then verify document failed share to airline
    #    Then verify no encoded content missing

    Examples:
      | contentType      | contentName         | via                                        | contact                            |
      | BookingReply     | test-04-Sept-2024   | system.pimatest89167@ccnexchange.com   | system.csgair01sinfmsq@ccnexchange.com  |

  @FWB_R_9 @notificationV2
  Scenario Outline:  Create AWB C Document then Perform Share Via Coloader
    Given create "<contentType>" doc with "<contentName>" for share via
    When share "<via>" "<contact>" to airline
    Then verify document succeed share to airline
    #    Then verify no encoded content missing

    Examples:
      | contentType  | contentName                  | via                                    | contact                                   |
      | MAWBRequest  | test-monday-04-sept-2024   | system.pimatest89167@ccnexchange.com   | system.csgair01sinfmsq@ccnexchange.com  |

  @FWB_R_9_2 @notificationV2
  Scenario Outline:  Create MAWBReply Document then Perform Share Via Co loader
    Given create "<contentType>" doc with "<contentName>" for share via
    When share "<via>" "<contact>" to airline
    Then verify document succeed share to airline
    #    Then verify no encoded content missing

    Examples:
      | contentType  | contentName              | via                                    | contact                                   |
      | MAWBReply  | test-monday-04-sept-2024   | system.pimatest89167@ccnexchange.com   | system.csgair01sinfmsq@ccnexchange.com  |

  @FWB_R_13 @notificationV2
  Scenario Outline:  Create DockShipment Document then Perform Share Via Coloader
    Given create "<contentType>" doc with "<contentName>" for share via
    When share "<via>" "<contact>" to airline
    Then verify document succeed share to airline
    #    Then verify no encoded content missing

    Examples:
      | contentType  | contentName                  | via                                    | contact                                   |
      | DockShipment  | test-04-Sept-2024   | system.pimatest89167@ccnexchange.com   | system.csgair01sinfmsq@ccnexchange.com  |

  @FWB_R_15
  Scenario Outline:  Create DockShipment Document then Perform Share Via Coloader Ordinary User
    Given create "<contentType>" doc with "<contentName>"
    When share "<via>" "<contact>" to airline
    Then verify document succeed share to airline
    #    Then verify no encoded content missing

    Examples:
      | contentType  | contentName                  | via                                    | contact                                   |
      | DockShipment  | test-monday-27-august-2024   | system.pimatest89167@ccnexchange.com   | system.csgair01sinfmsq@ccnexchange.com  |

  @FWB_R_14 @notificationV2
  Scenario Outline:  Create DockBookingUpdate Document then Perform Share Via Coloader
    Given create "<contentType>" doc with "<contentName>" for share via
    When share "<via>" "<contact>" to airline
    Then verify document succeed share to airline
    #    Then verify no encoded content missing

    Examples:
      | contentType        | contentName                  | via                                    | contact                                 |
      | DockBookingUpdate  | test-monday-27-august-2024   | system.pimatest89167@ccnexchange.com   | system.csgair01sinfmsq@ccnexchange.com  |

  @FWB_R_14_2 @notificationV2
  Scenario Outline:  Create ShipmentStatus Document then Perform Share Via Coloader
    Given create "<contentType>" SS doc with "<contentName>" for share via
    When share "<via>" "<contact>" to airline
    Then verify document succeed share to airline
    Then verify no encoded content missing

    Examples:
      | contentType     | contentName       | via                                    | contact                                 |
      | ShipmentStatus  | test-05-09-2024   | system.pimatest89167@ccnexchange.com   | system.csgair01sinfmsq@ccnexchange.com  |

  @FWB_R_10
  Scenario Outline:  Create AWB C Document then Perform Share Via non Coloader
    Given create "<contentType>" doc with "<contentName>" for share via
    When share "<via>" "<contact>" to airline
    Then verify document failed share to airline

    Examples:
      | contentType  | contentName                  | via                                        | contact                            |
      | BookingReply  | test-monday-16-august-2024   | system.csgagt99rhn_ind99@ccnexchange.com   | system.csgnqhq_dx@ccnexchange.com  |

  @SR6168 @SR6168DEV @SR61681
  Scenario Outline:  Create "<contentType>" Document to verify awbNo filter tag and implicit share working properly
    Given create "<contentType>" doc with "<contentName>" and "<awbNo>"
    Then verify no encoded content missing
    And verify that "<contentType>" and "<awbNo>" document filtering is running well
    And verify that "<contentType>" and "<awbNo>" the document should appear in the company system
    And verify that "<contentType>" and "<awbNo>" another user in the same company should also be able to view the document created
    And do explicit sharing "<contact>"
    And update the data after retrieve

    Examples:
      | contentType| contentName     | awbNo                | contact                                       |
      | Booking    | test-20052025   | awbNo:618-64461986   | system.csgagt9166a0a6b8_sin01@ccnexchange.com |

  @SR6168 @SR6168DEV
  Scenario Outline:  Create "<contentType>" Document to verify awbNo filter tag and implicit share working properly
    Given create "<contentType>" doc with "<contentName>" and "<awbNo>"
    Then verify no encoded content missing
    And verify that "<contentType>" and "<awbNo>" document filtering is running well
    And verify that "<contentType>" and "<awbNo>" the document should appear in the company system
    And verify that "<contentType>" and "<awbNo>" another user in the same company should also be able to view the document created
    And do explicit sharing "<contact>"
    And update the data after retrieve

    Examples:
      | contentType     | contentName     | awbNo                | contact                                       |
      | BookingRequest  | test-20052025   | awbNo:618-64461984   | system.csgagt9166a0a6b8_sin01@ccnexchange.com |

  @SR6168 @SR6168DEV
  Scenario Outline:  Create "<contentType>" Document to verify awbNo filter tag and implicit share working properly
    Given create "<contentType>" doc with "<contentName>" and "<awbNo>"
    Then verify no encoded content missing
    And verify that "<contentType>" and "<awbNo>" document filtering is running well
    And verify that "<contentType>" and "<awbNo>" the document should appear in the company system
    And verify that "<contentType>" and "<awbNo>" another user in the same company should also be able to view the document created
    And do explicit sharing "<contact>"
    And update the data after retrieve

    Examples:
      | contentType  | contentName     | awbNo                | contact                                       |
      | BookingReply | test-26032025   | awbNo:618-64461985   | system.csgagt9166a0a6b8_sin01@ccnexchange.com |

  @SR6168 @SR6168DEV
  Scenario Outline:  Create "<contentType>" Document to verify awbNo filter tag and implicit share working properly
    Given create "<contentType>" doc with "<contentName>" and "<awbNo>"
    Then verify no encoded content missing
    And verify that "<contentType>" and "<awbNo>" document filtering is running well
    And verify that "<contentType>" and "<awbNo>" the document should appear in the company system
    And verify that "<contentType>" and "<awbNo>" another user in the same company should also be able to view the document created
    And do explicit sharing "<contact>"
    And update the data after retrieve

    Examples:
      | contentType  | contentName     | awbNo                | contact                                       |
      | MAWBRequest  | test-26032025   | awbNo:618-64461986   | system.csgagt9166a0a6b8_sin01@ccnexchange.com |

  @SR6168 @SR6168DEV
  Scenario Outline:  Create "<contentType>" Document to verify awbNo filter tag and implicit share working properly
    Given create "<contentType>" doc with "<contentName>" and "<awbNo>"
    Then verify no encoded content missing
    And verify that "<contentType>" and "<awbNo>" document filtering is running well
    And verify that "<contentType>" and "<awbNo>" the document should appear in the company system
    And verify that "<contentType>" and "<awbNo>" another user in the same company should also be able to view the document created
    And do explicit sharing "<contact>"
    And update the data after retrieve

    Examples:
      | contentType | contentName     | awbNo                | contact                                       |
      | MAWBReply   | test-26032025   | awbNo:618-64461987   | system.csgagt9166a0a6b8_sin01@ccnexchange.com |

  @SR6168
  Scenario Outline:  Create "<contentType>" Document to verify awbNo filter tag and implicit share working properly
    Given create "<contentType>" doc with "<contentName>" and "<awbNo>"
    Then verify no encoded content missing
    And verify that "<contentType>" and "<awbNo>" document filtering is running well
    And verify that "<contentType>" and "<awbNo>" the document should appear in the company system
    And verify that "<contentType>" and "<awbNo>" another user in the same company should also be able to view the document created
    And do explicit sharing "<contact>"
    And update the data after retrieve

    Examples:
      | contentType   | contentName     | awbNo                | contact                                       |
      | DockShipment  | test-26032025   | awbNo:618-64461983   | system.csgagt9166a0a6b8_sin01@ccnexchange.com |

  @SR6168
  Scenario Outline:  Create "<contentType>" Document to verify awbNo filter tag and implicit share working properly
    Given create "<contentType>" doc with "<contentName>" and "<awbNo>"
    Then verify no encoded content missing
    And verify that "<contentType>" and "<awbNo>" document filtering is running well
    And verify that "<contentType>" and "<awbNo>" the document should appear in the company system
    And verify that "<contentType>" and "<awbNo>" another user in the same company should also be able to view the document created
    And do explicit sharing "<contact>"
    And update the data after retrieve

    Examples:
      | contentType        | contentName     | awbNo                | contact                                       |
      | DockBookingUpdate  | test-26032025   | awbNo:618-64461983   | system.csgagt9166a0a6b8_sin01@ccnexchange.com |

  @RAUI
  Scenario Outline:  Register user PPD after UI
    Given register "<email>" sandbox after register in UI
    Examples:
      | email                             |
      | partner.trucker.ccn@proton.me  |
#      | sgqa-ccn-94960871@mailinator.com  |

  @awb1000times
  Scenario Outline:  awb 1000 times
    Given create awbNo 1000 times
    Examples:
      | contentType        | contentName                  | via                                    | contact                                 |
      | DockBookingUpdate  | test-monday-27-august-2024   | system.pimatest89167@ccnexchange.com   | system.csgair01sinfmsq@ccnexchange.com  |