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

  Scenario: Create Car with valid data
    Given I am on the "Create Car" page
    When I fill in the following fields with valid data:
      | License Plate        | ABC123          |
      | Tags                 | Junior, Compact |
      | Driver               | John Smith      |
      | Location             | New York        |
      | Chassis Number       | ABC123456       |
      | Model Year           | 2022            |
      | Last Odometer        | 10000           |
      | Immatriculation Date | 03 24, 2023     |
      | First Contract Date  | 03 24, 2023     |
      | Catalog Value ($)    | 20000           |
      | Seat Number          | 5               |
      | Doors Number         | 4               |
      | Colour               | Red             |
      | Transmission         | Automatic       |
      | Fuel Type            | Gasoline        |
      | CO2 Emissions        | 150             |
      | Horsepower           | 200             |
      | Horsepower Taxation  | 1000            |
      | Power (KW)           | 147             |
    And I select a JPEG or PNG file for the Logo field, or leave it blank
    And I click on the "Save and Close" button
    Then I should be redirected to the "General Information" page
    And I should see the "Entity Saved" message

  Scenario: Create Car with invalid data
    Given I am on the "Create Car" page
    When I fill in the following fields with invalid data:
      | License Plate        | $%#     |
      | Tags                 | Invalid |
      | Driver               | 123     |
      | Location             | 123     |
      | Chassis Number       | $%#     |
      | Model Year           | Invalid |
      | Last Odometer        | Invalid |
      | Immatriculation Date | Invalid |
      | First Contract Date  | Invalid |
      | Catalog Value ($)    | Invalid |
      | Seat Number          | Invalid |
      | Doors Number         | Invalid |
      | Colour               | 123     |
      | Transmission         | Invalid |
      | Fuel Type            | Invalid |
      | CO2 Emissions        | Invalid |
      | Horsepower           | Invalid |
      | Horsepower Taxation  | Invalid |
      | Power (KW)           | Invalid |
    And I click on the "Save" button
    Then I should see an error message





