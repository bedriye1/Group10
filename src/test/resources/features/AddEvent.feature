Feature: Add event features

  Background:
    Given The user is on the login page

  Scenario: User can access the "Add Event" page from the "General Information" page
    When The user logs in as "sales manager"
    And User can go to fleet dropdown
    And User click the Vehicles modules
    And  User can click on any row in the table
    Then User can access the Add Event page

  Scenario: As a Sales Manager ; user can click "Add Event" button
    When The user logs in as "sales manager"
    And User can go to fleet dropdown
    And User click the Vehicles modules
    And  User can click on any row in the table
    Then User click the add event button

  Scenario: As a Store Manager ;user can click "Add Event" button
    When The user logs in as "store manager"
    And User can go to fleet dropdown
    And User click the Vehicles modules
    And  User can click on any row in the table
    Then User click the add event button

  Scenario: As a Driver ;user can not see "Add Event" button
    When The user logs in as "driver"
    And User can go to Fleet module
    And User click the Vehicles module
    And  User can click  any row in the table
    Then User can not see the add event button

  Scenario: After clicking on "Add event" button, "Add Event" page should pop up.
    When The user logs in as "store manager"
    And User can go to fleet dropdown
    And User click the Vehicles modules
    And  User can click on any row in the table
    And User click the add event button
    Then User can see "Add Event" pop up

  Scenario: Compulsory fields are shown as wanted

    When The user logs in as "store manager"
    And User can go to fleet dropdown
    And User click the Vehicles modules
    And  User can click on any row in the table
    And User click the add event button
    Then Compulsory fields are shown as below
  |Title|
  |Owner|
  |Organizer display name|
  |Organizer email       |
  |Start Date            |
  |End Date              |

  Scenario: If "Title" field is not filled, the "This value should not be blank."
  message should be displayed after clicking on the save button.
    When The user logs in as "store manager"
   And User can go to fleet dropdown
    And User click the Vehicles modules
    And  User can click on any row in the table
    And User click the add event button
    And User click save button without filling "Title" field
    Then User should see "This value should not be blank." message

  Scenario:  If any compulsory field is not filled (without "Title"), the "This value should not be blank."
  message should be displayed after clicking on the save button.
    When The user logs in as "store manager"
    And User can go to fleet dropdown
    And User click the Vehicles modules
    And  User can click on any row in the table
    And User click the add event button
    And User click save button without filling compulsory fields (without Title field)
    Then User should see "This value should not be blank." message after clicking save button