@FLEET10-1069
Feature:As a store manager and sales manager, I should be able to add an event

  Background:
    Given The user is on the login page

 Scenario Outline: Log in as a sales manager
    When The user logs in as "<username>"
    And The user navigates to Dashboard Fleet-Vehicle page
    And User click the Vehicles modules
    Then User can click on any row in the table
    Examples:
      | username      |
      | sales manager |
      | store manager |


  Scenario Outline: After clicking on "Add event" button user can see "Add Event" pop up
    When The user logs in as "<username>"
    And The user navigates to Dashboard Fleet-Vehicle page
    And User click the Vehicles modules
    And User can click on any row in the table
    And user can click add event button
    Then user should be able to see add event pop up
    Examples:
      | username      |
      | sales manager |
      | store manager |

  
  Scenario: Repatin action "Daily", "Weekly", "Monthly", "Yearly"
    When user clicks repeat button
    Then user sees repeats dropdown menu
    And user can repeat action by selecting daily,weekly,montlyand yearly
    And user sholud see ending options as never, after,and should be clickable




