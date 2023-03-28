Feature: User Story :

  As a user, I should be able to use the "Driver" filter under the Fleet-Vehicles page



  Acceptance Criteria:

  1- User can select "Driver" filter under 'Fleet-Vehicles' module

  2- "Driver" filter should provide the methods shown as below:
  -> Contains
  -> Does Not Contain
  -> Is Equal To
  -> Starts With
  -> Ends With
  -> Is Any Of
  -> Is Not Any Of
  -> Is Empty
  -> Is Not Empty

  3- When user selects "Contains" method with a keyword, the results should contain the specified keyword

  4- When user selects "Does Not Contain" method with a keyword, the results should not contain the specified keyword

  5- When user selects "Starts-with" method with a keyword, the results should start with the specified keyword

  6- When user selects "Ends With" method with a keyword, the results should end with the specified keyword

  7- When user selects "Is Equal to" method with a keyword, the results should match the specified keyword exactly

  8- Methods  ("Contains", "Does Not Contains", "Starts With", "Ends With", "Is Equal to") shouldn't accept non-alphabetical characters

  Background:
    Given The user logs in as "sales manager"


    Scenario: User can select "Driver" filter under 'Fleet-Vehicles' module
     When The user navigates to Dashboard Fleet-Vehicle page
     And User clicks "Manage filters"
     Then Verify user able to click to "Driver" button

      Scenario: User should able to see provided tags
        When The user navigates to Dashboard Fleet-Vehicle page
        And User clicks "Manage filters"
        And Verify user able to click to "Driver" button
        And  The user clicks "Driver:All"
      And The user sees the "Contains" module and click
      Then Verify user should see tags the with the order below
      | Contains |
      | Does Not Contain |
      | Is Equal To |
      | Starts With |
      | Ends With |
      | Is Any Of |
      | Is Not Any Of |
      | Is Empty|
      | Is Not Empty |

  Scenario: User should able to see corresponding value
    Given The user sees the "Contains" module and click
    When User selects "Contains" from dropdown and enters "String"
    And User click the add update button
    Then  the user can see the result contains "String"

  Scenario: User should able to see corresponding value
    Given The user sees the "Contains" module and click
    When User selects "Does Not Contain"" from dropdown and enters "String"
    And User click the add update button
    Then  the user can see results should not contain the "String"

  Scenario: User should able to see corresponding value
    Given The user sees the "Contains" module and click
    When User selects "Starts-with" from dropdown and clicks "String"
    And User click the add update button
    Then  the user can see the results should start with the "String"

  Scenario: User should able to see corresponding value
    Given The user sees the "Contains" module and click
    When User selects "Ends With" from dropdown and enters "String"
    And User click the add update button
    Then  the user can see the results should end with the "String"

  Scenario: User should able to see corresponding value
    Given The user sees the "Contains" module and click
    When User selects "Is Equal to" from dropdown and enters "String"
    And User click the add update button
    Then  the user can see the results should match the "String" exactly


   Scenario Outline: Non-Alphabetical Characters in String Methods
    Given a "<method>" method is used with a non-alphabetical character
    When the method parameter contains "<non_alpha>" character
    Then the system should not accept non-alphabetical characters with the "<method>" method and display an error message

    Examples:
      | method        | non_alpha |
      | Contains      | Hello1    |
      | Does Not Contain | 12345     |
      | Starts With   | !Hello    |
      | Ends With     | world!    |
      | Is Equal To   | Bye@      |










