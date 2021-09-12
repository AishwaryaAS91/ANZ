Feature: To add product to the cart

 Scenario Outline: To add Casual Dresses to cart
    Given User is logged into My Store <emailaddress> <password>
    When user clicks on Dresses tab
    Then clicks on More button on product
    And selects the product by providing <quantity> <size>
    And clicks on Add to Cart button
    And clicks on Proceed to Checkout button
    And clicks on Agree to Terms of Service
    Then product is verified in Payment page

    Examples: 
   |emailaddress |password |quantity | size | 
   |nj10@test.com |tosameyre |1 |S |

  