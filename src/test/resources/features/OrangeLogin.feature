@orange @loggin
Feature: orange login

  Background: The user navigate to de orange Test and login
    Given The user visit the orange page: 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login'
    When The orange user type username: 'Admin' and password: 'admin123'
    And The orange user click on login button
    And The orange user click on user count button
    Then The orange user is logged 'Cerrar sesión'


  @successful @sidePanel
    Scenario: The user click on the side panel elements
    #And Verify if the side panel is displayed
  And The user go to de side panel
    #And The user click over some element
    #Then The element take the user to the corresponding URL

