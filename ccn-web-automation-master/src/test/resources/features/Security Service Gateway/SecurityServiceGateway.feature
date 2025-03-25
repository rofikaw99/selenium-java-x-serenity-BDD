@SSG
Feature: Security Service Gateway

  @SSG_NA_1
  Scenario: Check status with public service gateway with no token and API key
    Given  Check status with "public" service gateway with no token and API key
    Then verify the response is unauthorized

  @SSG_NA_2
  Scenario: Check status with private service gateway with no token and API key
    Given  Check status with "private" service gateway with no token and API key
    Then verify the response is unauthorized

  @SSG_NA_3
  Scenario: Check status with private service gateway with API key but no token
    Given  Check status with "private" service gateway with API key but no token
    Then verify the response is unauthorized

  @SSG_JWTTB_1
  Scenario: Check status with private service gateway with modified host
    Given  Check status with "private" service gateway with modified host
    Then verify the response is succeed

  @ValidatePimaChexs
  Scenario Outline: Validate Pima Chexs
    Given  validate "<pima>" chexs
  Examples:
    | pima                    |
    | CSGAGT9166FF5124/SIN01  |

  @EJWTMSV
  Scenario: modify "aud" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("aud")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "iss" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("iss")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "exp" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("exp")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "nbf" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("nbf")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "sub" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("sub")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "email" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("email")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "name" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("name")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "extension_ContactNo" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("extension_ContactNo")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "extension_CubeUserID" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("extension_CubeUserID")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "city" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("city")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "extension_CountryCode" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("extension_CountryCode")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "uifo" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("uifo")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "tid" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("tid")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "nonce" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("nonce")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "scp" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("scp")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "azp" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("azp")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "ver" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("ver")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)

  @EJWTMSV
  Scenario: modify "iat" value then the request will block
    Given got fresh token from dev.cubeforall.com
    When go to postman : use any API cube.ccnexchange.com ( e.g : CheckStatus or NewSession )
    And go to https://token.dev/ and paste the token
    And modify the token payload ("iat")
    And grab newly generated token from https://token.dev/
    And paste at your postman ( change the cubeId at url use matching with the one you modified )
    Then hit the request
    And not allow for token alteration or misuse. (the expected is unauthorized)