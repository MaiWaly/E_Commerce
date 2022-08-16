@smoke
  Feature:F08_Wishlist feature | User could add products to Wishlist

    Scenario: add product to wishlist
      Given user clicks wishlist icon
     Then successful message is displayed


      Scenario: check wishlist quantity value
        Given  user clicks wishlist icon
        And  successful message is displayed
        When  wishlist tab is clickable
        Then qty value got increased more then 0


