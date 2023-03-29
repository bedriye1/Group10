@FLEET10-1069
Feature:As a store manager and sales manager, I should be able to add an event

  Background:
    Given The user is on the login page

  Scenario Outline: Log in as a sales manager
    When The user logs in as "<username>"
    And The user navigates to Dashboard Fleet-Vehicle page
    And User click the Vehicles modules
    And User can click on any row in the table
    And user can click add event button
    Examples:
      | username      |
      | sales manager |
      | store manager |

  Scenario:Users should able to click add event
    And User can click on any row in the table
    And user can click add event button
    And user should be able to see add event pop up
    And User can mark the event with any color
    And  User can click  All-day event check box
    And Time boxes will disappear
    And  user clicks repeat button
    And user sees repeats dropdown menu
    And user can repeat action by selecting Daily,Weekly,Montly and Yearly
    And user sholud see ending options as never, after,and should be clickable
    Then All Users can see all events on the General information page







