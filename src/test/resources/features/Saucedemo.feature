@saucedemo @checkout
Feature: saucedemo checkout
  #Given compartido por todos los escenarios -> acceso a la web
  Background: the user login and add products
    Given The user visit the 'https://www.saucedemo.com/'
    When The user type username: 'standard_user' and password: 'secret_sauce'
    And The user click on login button
    And The user click a product or products
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |


  @successful
  Scenario Outline: Change de button color
    Then The button color became: '<color>'
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |

    Examples:
      | color   |
      | #e2231a |

  @successful
  Scenario Outline: Change de button text
    And The button text became: '<text>'
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |
    Examples:
      | text   |
      | Remove |

  @successful
  Scenario: Login with right user and pass and change de button color
    And The shopping card show the same number of products user have selected: '3'





