@FLEET10-1069
Feature:As a store manager and sales manager, I should be able to add an event

  Scenario: Log in as a sales manager
    When The user logs in as "sales manager"
    And The user navigates to Dashboard Fleet-Vehicle page
    And User can click on any row in the table
    And user can click add event button
    And user should be able to see add event pop up
    And User enters event title
    And User can mark the event with any color
    And  User can click  All-day event check box
    And Time boxes will disappear
    And user clicks repeat button
    And user sees repeats dropdown menu
    And user can repeat action by selecting Daily,Weekly,Montly and Yearly
      | Daily   |
      | Weekly  |
      | Monthly |
      | Yearly  |

    And user should see ending options as never, after,and by should be clickable
      | Never |
      | After |
      | By    |

    Then All Users can see all events on the General information page






