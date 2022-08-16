@smoke
Feature: : F04-search |user could search using product name or product sku

  Scenario Outline: user could search using product name
    Given user enters <product_name> in search box
    When user clicks search buttons
    Then search page is opened
    And search result is shown
    Examples:
      | product_name |
      | book         |
      | laptop       |
      | nike         |

  Scenario Outline: user could search using sku
    Given user enters <sku> in search box
    When user clicks search buttons
    Then search page is opened
    And user clicks the result product
    Then product page is opened
    Examples:
      | sku       |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |
