Feature: Registration CUBEforall

  @RegistrationCube @Registration1
  Scenario Outline: Registration with happy flow 1
    Given go to main web
    Given press sign in button
    When press sign up now button
    And input email address on register page
    And press send verification code
    And input password & confirm password on register page
    And input display name "<name>" on register page
    And input contact number "<contact>" on register page
    And select city "<city>" on register page
    And select country "<country>" on register page
    And Open new tab and open mailinator
    And get the email verification and extract the verification code
    And close tab and back to register page
    And input verification code on register page
    And press verification code button on register page
    And press create account on register page
    And back to the main tab browser

    Examples:
      | name|contact|city|country|
      | Pegasus QA CCN|5555555|MALAYSIA|Malaysia|
      #| Pegasus QA CCN|5555555|CHINA|China|
      #| Pegasus QA CCN|5555555|SINGAPORE|Singapore|


  @Registration2
  Scenario: Registration with happy flow 2
    Given go to main web
    Given press sign in button
    When registration with new account and login

  @Registration2withPR
  Scenario: Registration with happy flow PR
    Given go to main web with PlayWright session token
    Given press sign in button
    When registration with new account and login

  @Registration3
  Scenario: Registration with happy flow 3
    Given go to main web
    Given press sign in button
    And registration with new account and try login
    And will redirected to suggested company list which match with domain name of the users

  @Registration4
  Scenario Outline: Registration with happy flow 4
    Given go to main web
    Given press sign in button
    And input email "<email>" and password "<password>" and press sign in to continue login
    And back to the main tab browser
    Examples:
      | email                         | password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |
