Feature: SQPP

  @Sqpp-1 @e2e
  Scenario Outline: Sign in user sqpp as station admin
    Given go to sqpp website
    Given click member login sqpp
    Given input login sqpp email "<email>" and password "<password>"
    Given go to yopmail
    When enter yopmail email to login "<email>"
    When open yopmail email "CUBEforall by CCN account email verification code"
    When get verification code sqpp
    When back to login page after get verification code sqpp
    Then continue sign in sqpp
    When click agent managament sqpp

    Examples:
      | email                             | password |
      | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-2 @e2e
  Scenario Outline: Sign in user sqpp as headquarter
    Given go to sqpp website
    Given click member login sqpp
    Given input login sqpp email "<email>" and password "<password>"
    Given go to yopmail
    When enter yopmail email to login "<email>"
    When open yopmail email "CUBEforall by CCN account email verification code"
    When get verification code sqpp
    When back to login page after get verification code sqpp
    Then continue sign in sqpp
    When click agent managament sqpp

    Examples:
      | email                      | password |
      | headquarter_sq@yopmail.com | P@55w0rd |

  @Sqpp-3 @e2e
  Scenario Outline: Sign in user sqpp as sqpp user
    Given go to sqpp website
    Given click member login sqpp
    Given input login sqpp email "<email>" and password "<password>"
    Given go to yopmail
    When enter yopmail email to login "<email>"
    When open yopmail email "CUBEforall by CCN account email verification code"
    When get verification code sqpp
    When back to login page after get verification code sqpp
    Then continue sign in sqpp
    When click agent managament sqpp

    Examples:
      | email                        | password      |
      | sqppqa-ccn-58404@yopmail.com | CCNPegasus123 |

  @Sqpp-4 @e2e
  Scenario Outline: signs up via the SSO page without an invitation email with valid agent code
    Given go to sqpp website
    Given click member login sqpp
    Given click sign up sqpp
    Given go to yopmail
    When enter yopmail email to register
    When open yopmail email "CUBEforall by CCN account email verification code"
    When get verification code sqpp
    When back to login page after get verification code sqpp registration "<agentcode>" "<country>" "<city>"
    Then continue sign up sqpp with agent code "<agentcode>" and country from "<country>" and city from "<city>"

    Examples:
      | agentcode       | country   | city      |
      | 013014012345678 | SINGAPORE | Singapore |

  @Sqpp-4 @e2e
  Scenario Outline: signs up via the SSO page without an invitation email with invalid agent code
    Given go to sqpp website
    Given click member login sqpp
    Given click sign up sqpp
    Given go to yopmail
    When enter yopmail email to register
    When open yopmail email "CUBEforall by CCN account email verification code"
    When get verification code sqpp
    When back to login page after get verification code sqpp registration "<agentcode>" "<country>" "<city>"
    Then continue sign up sqpp with agent code "<agentcode>" and country from "<country>" and city from "<city>"

    Examples:
      | agentcode   | country   | city      |
      | 11111111111 | SINGAPORE | Singapore |

  #g
  @Sqpp-5 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin approve, hq approve)
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-6 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin not taking any action for approval/reject)
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "pending" request via the SSO page without an invitation

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-7 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin approve become pendigg hdq approve, hq not taking any action approval/reject)
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "pending" request via the SSO page without an invitation

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-8 @e2e
  Scenario Outline: Reject For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email(station admin reject)
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "reject" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "New account request to access SIA Cargo Partners Portal"

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-9 @e2e
  Scenario Outline: Reject For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email(admin approve become pending hdq approve then hq reject)
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "New account request to access SIA Cargo Partners Portal"

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-10 @e2e
  Scenario Outline: Reject For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email(admin approve become pending hdq approve then hq reject can be re-request again to hdq)
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "New account request to access SIA Cargo Partners Portal"

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-11 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin approve become pending hdq approve, hq approve become active,then terminate by hdq) then cant acces the sqpp that has been terminate
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"
    Then headquarter "terminate" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Your SIA Cargo Partners Portal Account status has been updated"

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-12 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin approve become pending hdq approve, hdq approve become active,then suspend by hdq)
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"
    Then headquarter "suspend" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Your SIA Cargo Partners Portal Account status has been updated"

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-13 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin approve become pending hdq approve, hdq approve become active,then suspend by hdq) can be activate again suspend to active by hdq
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"
    Then headquarter "suspend" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Your SIA Cargo Partners Portal Account status has been updated"
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"
    Then headquarter "active" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-14 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email.(station admin invite member pending hdq approve thru station admin and approved by hdq pending become active)
    Given go to sqpp website
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When go to agent management
    Then select agent code "<agentcode>"
    Then add member email "<email>" to the agent company "<agentcode>" as "local key"
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    Then select agent code "<agentcode>"
    Then headquarter "approved" added by station admin with an invitation email
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "You have been invited to join"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-15 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email.(station admin invite member pending hdq approve, hdq reject)
    Given go to sqpp website
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When go to agent management
    Then select agent code "<agentcode>"
    Then add member email "<email>" to the agent company "<agentcode>" as "local key"
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    Then select agent code "<agentcode>"
    Then headquarter "approved" added by station admin with an invitation email
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "You have been invited to join"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-16 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email (admin invite with pending hdq approval,then hdq reject then status is rejected in station admin can re-request approval to hq)
    Given go to sqpp website
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When go to agent management
    Then select agent code "<agentcode>"
    Then add member email "<email>" to the agent company "<agentcode>" as "local key"
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    Then select agent code "<agentcode>"
    Then headquarter "approved" added by station admin with an invitation email
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "You have been invited to join"
    When check yopmail email "Subscription to SIA Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "reject" request
    Then station admin "approved" request
    Then headquarter "approved" added by station admin with an invitation email
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "You have been invited to join"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-17 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email (admin invite with pending hdq approval,then hdq suspend then status is suspend)
    Given go to sqpp website
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When go to agent management
    Then select agent code "<agentcode>"
    Then add member email "<email>" to the agent company "<agentcode>" as "local key"
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    Then select agent code "<agentcode>"
    Then headquarter "approved" added by station admin with an invitation email
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "You have been invited to join"
    When check yopmail email "Subscription to SIA Partners Portal"
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    Then headquarter "suspend" added by station admin with an invitation email
    When check yopmail email "Your SIA Cargo Partners Portal Account status has been updated"

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-18 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email (admin invite with pending hdq approval,then hdq suspend then status is suspend can be activate again by hdq)
    Given go to sqpp website
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When go to agent management
    Then select agent code "<agentcode>"
    Then add member email "<email>" to the agent company "<agentcode>" as "local key"
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    Then select agent code "<agentcode>"
    Then headquarter "approved" added by station admin with an invitation email
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "You have been invited to join"
    When check yopmail email "Subscription to SIA Partners Portal"
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    Then headquarter "suspend" added by station admin with an invitation email
    When check yopmail email "Your SIA Cargo Partners Portal Account status has been updated"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "suspend" request
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    Then headquarter "active" added by station admin with an invitation email
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-19 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email.(admin invite member become pending hdq approve thru station admin and hdq not taking any action)
    Given go to sqpp website
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When go to agent management
    Then select agent code "<agentcode>"
    Then add member email "<email>" to the agent company "<agentcode>" as "local key"
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    Then select agent code "<agentcode>"
    Then headquarter "pending" added by station admin with an invitation email

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-20 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email (admin invite with pending hdq approval,then hdq suspend then status is suspend can be activate again by hdq)
    Given go to sqpp website
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When go to agent management
    Then select agent code "<agentcode>"
    Then add member email "<email>" to the agent company "<agentcode>" as "local key"
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    Then select agent code "<agentcode>"
    Then headquarter "approved" added by station admin with an invitation email
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "You have been invited to join"
    When check yopmail email "Subscription to SIA Partners Portal"
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    Then headquarter "suspend" added by station admin with an invitation email
    When check yopmail email "Your SIA Cargo Partners Portal Account status has been updated"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "suspend" request
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    Then headquarter "active" added by station admin with an invitation email
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-21 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email.(hdq invite member pending hdq approve then approve become active by hdq then terminate by hdq cant added again and ban accces sqpp)
    Given go to sqpp website
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When go to agent management
    Then select agent code "<agentcode>"
    Then add member email "<email>" to the agent company "<agentcode>" as "local key"
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    Then select agent code "<agentcode>"
    Then headquarter "approved" added by station admin with an invitation email
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "You have been invited to join"
    When check yopmail email "Subscription to SIA Partners Portal"
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    Then headquarter "terminate" added by station admin with an invitation email
    When check yopmail email "Your SIA Cargo Partners Portal Account status has been updated"

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-22 @e2e
  Scenario Outline: agent company  in station admin can have multiple member
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-23 @e2e
  Scenario Outline: agent company  in hdq can have multiple member
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"

    Examples:
      | agentcode   | email                             | password |
      | 11111111111 | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-24 @e2e
  Scenario Outline: agent company that already have some active local key, station admin added to the agent company status already active no need other hq permission, but still need approval from one of the active local key
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-25 @e2e
  Scenario Outline: agent company that already have some active local key, station admin approve request join to the agent company status already active no need other hq permission,still need approval from other active local key
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  #non first local key ==========================================
  @Sqpp-26 @e2e
  Scenario Outline: remove 1st local key then add another member become first local key in hq with normal approval as first local key flow
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-27 @e2e
  Scenario Outline: remove 1st local key then approve request join another member become first local key in hdq  with normal approval as first local key flow
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-28 @e2e
  Scenario Outline: suspend 1st local key then add another member become first local key in hdq with normal approval as first local key flow
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-29 @e2e
  Scenario Outline: terminate 1st local key then add another member become first local key in hq with normal approval as first local key flow
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-30 @e2e
  Scenario Outline: agent company that have multiple active local key, then terminate one of the key, no need approval from station admin to hq when added member to hq as active local key
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-31 @e2e
  Scenario Outline: agent company that have multiple active local key, then terminate one of the key, no need approval from station admin to hq when added member to hq as active local key
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-32 @e2e
  Scenario Outline: agent company that have multiple active local key, then terminate one of the key, no need approval from station admin to hq when register through sso page for request joinin agent company member to hq as active local key
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-33 @e2e
  Scenario Outline: agent company that have multiple active local key, then suspend one of the key, no need approval from station admin to hq when register through sso page for request joinin agent company member to hq as active local key
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-34 @e2e
  Scenario Outline: agent company that have multiple active local key, then terminate all of the key, need approval from station admin to hq when added member to hq as active first local key
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-35 @e2e
  Scenario Outline: agent company that have multiple active local key, then suspend all of the key, need need approval from station admin to hq when added member to hq as active first local key
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-36 @e2e
  Scenario Outline: add 1st add 2nd, remove all, then add new member
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-37 @e2e
  Scenario Outline: approve 1st approve 2nd, remove all, then approve new member local key
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-38 @e2e
  Scenario Outline: rejected member in hq can be reapprove by station admin and reaprrove by hq
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-39 @e2e
  Scenario Outline: if there are no active local key,any request join with single request act as first lcal key flow
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-40 @e2e
  Scenario Outline: if there are no active local key,any request join with multiple request act as first lcal key flow
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-41 @e2e
  Scenario Outline: all of the email notification going to one specific hdq which is headquarter_sq@yopmail.com
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |

  @Sqpp-42 @e2e
  Scenario Outline: all of the email notification going to one specific station admin base on each station name
    Given go to sqpp website
    Given Register new user via the SSO page without an invitation email
    When check yopmail email "New account request to access SIA Cargo Partners Portal"
    Given Sign in user sqpp as station admin "testbrancha_member_12@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then station admin "approved" request via the SSO page without an invitation
    Given Sign in user sqpp as headquarter "headquarter_sq@yopmail.com"
    When check yopmail email "New local key is pending approval to join"
    When go to agent management
    Then select agent code "<agentcode>"
    Then headquarter "approved" request via the SSO page without an invitation
    Then Sign in user sqpp as sqpp user "<email>"
    When check yopmail email "Subscription to SIA Partners Portal"

    Examples:
      | agentcode   | email            | password |
      | 11111111111 | aaa2@yopmail.com | P@55w0rd |
