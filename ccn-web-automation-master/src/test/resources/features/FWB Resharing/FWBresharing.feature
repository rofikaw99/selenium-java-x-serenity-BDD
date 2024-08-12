@FWB
Feature: FWB Re sharing

  @FWB_R_1
  Scenario Outline: Create BC Document and Check Implicit Sharing
    Given  create "<contentType>" doc with "<contentName>"
    And  Check that notification already share to the member within company

    Examples:
      | contentType      | contentName                |
      | BookingRequest   | test-monday-12-august-2024   |

  @FWB_R_2
  Scenario Outline: Create AWB C Document and Check Implicit Sharing
    Given  create "<contentType>" doc with "<contentName>"
    And  Check that notification already share to the member within company

    Examples:
      | contentType  | contentName                  |
      | MAWBRequest  | test-monday-12-august-2024   |

  @FWB_R_3
  Scenario Outline:  Create BC Document and Do Extended Sharing
    Given create "<contentType>" doc with "<contentName>"
    When do extended sharing "<contact>"
    Then make sure that the notification share to the right user

    Examples:
      | contentType      | contentName                  | contact            |
      | BookingRequest   | test-monday-12-august-2024   | sripcn@yopmail.com |

  @FWB_R_4
  Scenario Outline:  Create AWB C Document and Do Extended Sharing
    Given create "<contentType>" doc with "<contentName>"
    When do extended sharing "<contact>"
    Then make sure that the notification share to the right user

    Examples:
      | contentType  | contentName                  | contact            |
      | MAWBRequest  | test-monday-12-august-2024   | sripcn@yopmail.com |

  @FWB_R_5
  Scenario Outline:  Create BC Document and Do Explicit Sharing
    Given create "<contentType>" doc with "<contentName>" from system
    When do explicit sharing "<contact>"
    Then make sure that the notification share to SATS

    Examples:
      | contentType      | contentName                  | contact                                        |
      | BookingRequest   | test-monday-12-august-2024   | system.csggha01singcxh@ccnexchange.com  |

  @FWB_R_6
  Scenario Outline:  Create AWB C Document and Do Explicit Sharing
    Given create "<contentType>" doc with "<contentName>" from system
    When do explicit sharing "<contact>"
    Then make sure that the notification share to SATS

    Examples:
      | contentType  | contentName                  | contact                                        |
      | MAWBRequest  | test-monday-12-august-2024   | system.csgagt916639d233_cgk01@ccnexchange.com  |

  @FWB_R_7
  Scenario Outline:  Create BC Document then Perform Share Via Coloader
    Given create "<contentType>" doc with "<contentName>" for share via
    When share "<via>" "<contact>" to airline
    Then verify document succeed share to airline

    Examples:
      | contentType      | contentName                  | via                                    | contact                                   |
      | BookingRequest   | test-monday-12-august-2024   | system.pimatest89167@ccnexchange.com   | system.csgagt86cts_sha01@ccnexchange.com  |

  @FWB_R_8
  Scenario Outline:  Create BC Document then Perform Share Via non Coloader
    Given create "<contentType>" doc with "<contentName>" for share via
    When share "<via>" "<contact>" to airline
    Then verify document failed share to airline

    Examples:
      | contentType      | contentName                  | via                                        | contact                            |
      | BookingRequest   | test-monday-12-august-2024   | system.csgagt99rhn_ind99@ccnexchange.com   | system.csgnqhq_dx@ccnexchange.com  |

  @FWB_R_9
  Scenario Outline:  Create AWB C Document then Perform Share Via Coloader
    Given create "<contentType>" doc with "<contentName>" for share via
    When share "<via>" "<contact>" to airline
    Then verify document succeed share to airline

    Examples:
      | contentType  | contentName                  | via                                    | contact                                   |
      | MAWBRequest  | test-monday-12-august-2024   | system.pimatest89167@ccnexchange.com   | system.csgagt86cts_sha01@ccnexchange.com  |

  @FWB_R_10
  Scenario Outline:  Create AWB C Document then Perform Share Via non Coloader
    Given create "<contentType>" doc with "<contentName>" for share via
    When share "<via>" "<contact>" to airline
    Then verify document failed share to airline

    Examples:
      | contentType  | contentName                  | via                                        | contact                            |
      | MAWBRequest  | test-monday-12-august-2024   | system.csgagt99rhn_ind99@ccnexchange.com   | system.csgnqhq_dx@ccnexchange.com  |