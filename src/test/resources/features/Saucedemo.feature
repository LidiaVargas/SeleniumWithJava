@saucedemo @loggin
Feature: saucedemo login
  #Given compartido por todos los escenarios -> acceso a la web
  Background:
    Given The user visit the 'https://www.saucedemo.com/'


#  Scenario: Login successful
#    #Given The user visit the 'https://www.saucedemo.com/'
#    When The user type username: 'standard_user' and password: 'secret_sauce'
#    And The user click on login button
#    And The user click on burguer button
#    Then The user is logged

  @successful
  Scenario Outline: Login with right user and pass
    When The user type username: '<user>' and password: '<pass>'
    And The user click on login button
    And The user click on burguer button
    Then The user is logged
    And The user click a product or products
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |
    And The button color became: '<color>'
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |
    And The button text became: '<text>'
    #And The shopping card show the same number of products have selectec (3)

    Examples:
      | user          | pass         | text   | color   |
      | standard_user | secret_sauce | Remove | #e2231a |


  @unsuccessful
  Scenario Outline: Login with wrong user and pass
    When The user type username: '<user>' and password: '<pass>'
    And The user click on login button
    Then Access displays a message: '<message>'
    And The error div background color is red: '<color>'
    And The error div text color is white: '<colorText>'
    And The color div X is white: '<colorX>'

      #cont+alt+l
    Examples:
      | user          | pass         | message                                                                   | color                | colorText | colorX  |
      | standard_user | wrong        | Epic sadface: Username and password do not match any user in this service | e2231a               | wrong     | wrong   |
      | wrong         | secret_sauce | Epic sadface: Username and password do not match any user in this service | rgba(226, 35, 26, 1) | fff       | fff     |
      | wrong         | wrong        | Epic sadface: Username and password do not match any user in this service | wrong                | #fff      | #fff    |
      |               | secret_sauce | Epic sadface: Username is required                                        | #e2231a              | #fff      | #ffffff |
      | standard_user |              | Epic sadface: Password is required                                        | #e2231a              | #ffffff   | #ffffff |
      |               |              | Epic sadface: Username is required                                        | #e2231a              | #ffffff   | #ffffff |

