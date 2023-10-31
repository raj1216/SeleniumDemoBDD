Feature: Login Feature

  Background: 
    Given launch chrome
    When enter url "https://admin-demo.nopcommerce.com/login"

@smoke
  Scenario: Login with valid credentials
    And enter Email "admin@yourstore.com" and Password "admin"
    And click login
    Then page tile should be "Dashboard / nopCommerce administration"
    When user clicks on Logout link
    Then page title should be "Your store. Login"
    And close browser
    
@regression
  Scenario Outline: Login with Credentials BDD
    And enter Email "<email>" and Password "<password>"
    And click login
    Then page tile should be "Dashboard / nopCommerce administration"
    When user clicks on Logout link
    Then page title should be "Your store. Login"
    And close browser

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.com | admin    |
