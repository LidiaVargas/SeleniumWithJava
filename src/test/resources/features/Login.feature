@saucedemo @loggin
Feature: saucedemo login
  #Given compartido por todos los escenarios -> acceso a la web
  Background: The user navigate to de saucemo Test
    Given The user visit the 'https://www.saucedemo.com/'

  @successful
  Scenario: The user is logged and successful
    When The user type username: 'standard_user' and password: 'secret_sauce'
    And The user click on login button
    And The user click on burguer button
    Then The user is logged

  @unsuccessful
  Scenario Outline: Login with wrong user and pass
    When The user type username: '<user>' and password: '<pass>'
    And The user click on login button
    And Access displays a message: '<message>'
      #cont+alt+l
    Examples:
      | user          | pass         | message                                                                   |
      | standard_user | wrong        | Epic sadface: Username and password do not match any user in this service |
      | wrong         | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | wrong         | wrong        | Epic sadface: Username and password do not match any user in this service |
      |               | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user |              | Epic sadface: Password is required                                        |
      |               |              | Epic sadface: Username is required |



  @newCases
  Scenario Outline: Login with wrong user and pass: <errorMessage>
    When Mark scenario is pending when the driver is 'chrome'
    And The user type username: '<user>' and password: '<pass>'
    And The user click on login button
    Then a 'header3' is displayed with the text '<errorMessage>'
    #header3 hace referencia al método de Commons de "nuevos aportes"

    Examples:
      | user        | pass         | errorMessage                                              |
      | locked_out_user | secret_sauce | @PROPERTY_SAUCE_DEMO_LOGIN_WITH_LOCKED_USER_ERROR_MESSAGE |
      |                 |              | @PROPERTY_SAUCE_DEMO_LOGIN_WITH_EMPTY_USERNAME_FIELD      |
      | standard_user   |              | @PROPERTY_SAUCE_DEMO_LOGIN_WITH_EMPTY_PASSWORD_FIELD      |




  @unsuccessful2
  Scenario Outline: Change the background de color
    When The user type username: '<user>' and password: '<pass>'
    And The user click on login button
    Then Access displays a message: '<message>'
    And The error div background color is red: '<color>'
      #cont+alt+l
    Examples:
      | user          | pass         | message                                                                   | color                |
      | standard_user | wrong        | Epic sadface: Username and password do not match any user in this service | e2231a               |
      | wrong         | secret_sauce | Epic sadface: Username and password do not match any user in this service | rgba(226, 35, 26, 1) |
      | wrong         | wrong        | Epic sadface: Username and password do not match any user in this service | wrong                |
      |               | secret_sauce | Epic sadface: Username is required                                        | #e2231a              |
      | standard_user |              | Epic sadface: Password is required                                        | #e2231a              |
      |               |              | Epic sadface: Username is required                                        | #e2231a              |

  @unsuccessful3
  Scenario Outline: Change de text color
    When The user type username: '<user>' and password: '<pass>'
    And The user click on login button
    Then Access displays a message: '<message>'
    And The error div text color is white: '<colorText>'
      #cont+alt+l
    Examples:
      | user          | pass         | message                                                                   | colorText |
      | standard_user | wrong        | Epic sadface: Username and password do not match any user in this service | wrong     |
      | wrong         | secret_sauce | Epic sadface: Username and password do not match any user in this service | fff       |
      | wrong         | wrong        | Epic sadface: Username and password do not match any user in this service | #fff      |
      |               | secret_sauce | Epic sadface: Username is required                                        | #fff      |
      | standard_user |              | Epic sadface: Password is required                                        | #ffffff   |
      |               |              | Epic sadface: Username is required                                        | #ffffff   |

  @unsuccessful4
  Scenario Outline: Change de X color
    When The user type username: '<user>' and password: '<pass>'
    And The user click on login button
    Then Access displays a message: '<message>'
    And The color div X is white: '<colorX>'
      #cont+alt+l
    Examples:
      | user          | pass         | message                                                                   | colorX  |
      | standard_user | wrong        | Epic sadface: Username and password do not match any user in this service | wrong   |
      | wrong         | secret_sauce | Epic sadface: Username and password do not match any user in this service | fff     |
      | wrong         | wrong        | Epic sadface: Username and password do not match any user in this service | #fff    |
      |               | secret_sauce | Epic sadface: Username is required                                        | #ffffff |
      | standard_user |              | Epic sadface: Password is required                                        | #ffffff |
      |               |              | Epic sadface: Username is required                                        | #ffffff |