Feature: As a store manager and sales manager, I should be able to add an event
  Background:
    Given The user is on the login page

  Scenario: Log in as a sales manager
    When The user logs in as "sales manager"
    And The user navigates to Dashboard Fleet-Vehicle page
    And User click the Vehicles modules
    Then User can click on any row in the table

  Scenario: Log in as a store manager
    When The user logs in as "store manager"
    And The user navigates to Dashboard Fleet-Vehicle page
    And User click the Vehicles modules
   Then User can click on any row in the table

    Scenario: After clicking on "Add event" button user can see "Add Event" pop up
      When user clicks add event button and sees add event page pop up
      And User enters event title
      And User can mark the event with any color
      And User can click Add event check box
      Then time box will disappear

     Scenario: Repatin action "Daily", "Weekly", "Monthly", "Yearly"
       When user clicks repeat button
       Then user sees repeats dropdown menu
       And user can repeat action by selecting daily,weekly,montlyand yearly
       And user sholud see ending options as never, after,and should be clickable




