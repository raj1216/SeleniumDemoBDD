Feature: Login Feature

  
@smoke
  Scenario: Login with valid credentials
    And enter Email "standard_user" and Password "secret_sauce"
    And click login
    Then page tile should be "Swag Labs"
    When user clicks on Logout link
    

@sanity
Scenario: Add product to cart and order it successfully
And enter Email "standard_use" and Password "secret_sauce"
And click login
And add "Sauce Labs Backpack" to cart
And click on cart button
And click on checkout button
When enter required information and click continue
And click finish
Then verify order is successfull
And logout