Feature: Crypto Price Conversion

  Scenario: Convert price from GTQ to GBP and GBP to DOGGE
    Given Convert Price From GTQ to GBP "10000000"
    Then Convert Price From GBP to DOGGE
