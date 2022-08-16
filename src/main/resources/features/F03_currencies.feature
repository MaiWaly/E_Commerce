@smoke
Feature: F03_currencies | users could switch currency correctly

  Scenario: user could switch currency to Euro
    Given user switches currency list to Euro
    Then 4 products switch to Euro