Feature: Create button functionality test

  Background:
    Given Verify user on the dashboard page


  Scenario: Verify Create Car" button shouldn't be displayed for the driver
    When user log in as a driver
    Then user should not display Create Car button

  Scenario Outline: Verify Create car button displayed for <"user">
    When user logs in as a <"username"> and <"password">
    Then user displays <"verification">

    Examples:
      | user         | username        | password    | verification |
      | salesmanager | salesmanager101 | UserUser123 | Create car   |
      | storemanager | storemanager51  | UserUser123 | Create car   |

    Scenario: Verify user land on the Create car page
      When user logs in create car page after clicking crate car button
      Then Authorised person on the create car page



