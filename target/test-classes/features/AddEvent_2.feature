Feature: As a store manager and sales manager, I should be able to add an event
  Background:
    Given The user is on the login page

  Scenario: As a sales manager
    When The user logs in as "sales manager"
    And The user navigates to Dashboard Fleet-Vehicle page
    And User click the Vehicles modules
    Then User can click on any row in the table

  Scenario: As a store manager and sales manager, I should be able to add an event
    When The user logs in as "store manager"
    And The user navigates to Dashboard Fleet-Vehicle page
    And User click the Vehicles modules
   Then User can click on any row in the table

    Scenario: After clicking on "Add event" button,
      When user clicks add event button and add event page pop up
      And User can mark the event with any color
      And User can click Add event check box
      Then time box will dissappear