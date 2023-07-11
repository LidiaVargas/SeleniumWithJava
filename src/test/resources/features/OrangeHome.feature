
@login_Again
Feature: orange side panel

  Background: The user navigate in the side panel
    Given The user visit the orange page: 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login'
    When The orange user type username: 'Admin' and password: 'admin123'
    Then The orange user click on login button

  @login_Again @sidePanel
  Scenario Outline: The user click on the side panel elements
    And The user click over hamburger button
    And Verify if the side panel is visible
    Then The user click on menu element: '<pageName>'
    Examples:
      | pageName    |
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My info     |
      | Performance |
