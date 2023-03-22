Feature: Create button functionality test

  Background:
    Given The user is on the login page

  Scenario: Verify Create Car" button shouldn't be displayed for the driver
    When When The user logs in as "driver"
    Then user should not display "Create Car" button

  Scenario: Verify Create car button displayed for authorised user "salesmanager"
    When user logs in as a "salesmanager101" with"UserUser123"
    Then user displays "Create Car" button page

  Scenario: Verify Create car button displayed for authorised user "storemanager"
    When user logs in as a store manager with "storemanager51" with "UserUser123" credentials
    Then user displays "Create Car" button page


  Scenario: Verify user land on the Create car page
    When user logs in create car page after clicking crate car button
    Then After clicking Create Car button should land on Create Car page



