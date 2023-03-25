Feature: As a store manager and sales manager, I should be able to add an event
  Background:
    Given The user is on the login page

  Scenario: As a sales manager and sales manager, I should be able to add an event
    When The user logs in as "sales manager"
    And The user navigates to Dashboard Fleet-Vehicle page
    Then The user sees all the vehicle information in a table


  Scenario: As a store manager and sales manager, I should be able to add an event
    When The user logs in as "store manager"
    And The user navigates to Dashboard Fleet-Vehicle page
    Then The user sees all the vehicle information in a table