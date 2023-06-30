@orange @loggin
Feature: orange login

  Background: The user navigate to de orange Test and login
    Given The user visit the orange page: 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login'
    When The orange user type username: 'Admin' and password: 'admin123'
    And The orange user click on login button
    And The orange user click on user count button
    Then The orange user is logged


  @successful @sidePanel
    Scenario: The user click on the side panel elements
    And The user click over hamburger button
    And Verify if the side panel is visible
    And The user click over all panel elements
