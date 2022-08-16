@smoke
Feature:F06_Home slider |user could navigate by Home sliders

  Scenario: first slider is clickable on home page
    Given user clicks the first slider
    Then user directs to "https://demo.nopcommerce.com/nokia-lumia-1020"


Scenario: second slider is clickable on home page
  Given user clicks the second slider
  Then user directs to "https://demo.nopcommerce.com/iphone-6"