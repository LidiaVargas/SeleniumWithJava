@orange @loggin
Feature: orange login

  Background: The user navigate to de orange Test
    Given The user visit the orange page: 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login'

  @successful
  Scenario: The user is logged and successful
    When The orange user type username: 'Admin' and password: 'admin123'
    And The orange user click on login button
    And The orange user click on user count button
    Then The orange user is logged 'Logout'

