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

  Scenario: User creates a car with valid data
    Given I am on the Create Car page
    When I fill in the License Plate field with "ABC123"
    And Checked  the  all Tags
    And I fill in the Driver field with "Veli KARA"
    And I fill in the Location field with "New York"
    And I fill in the Chassis Number field with "ABC123456"
    And I fill in the Model Year field with "2022"
    And I fill in the Last Odometer field with "10000"
    And I fill in the Immatriculation Date field with "Mar 21,2020"
    And I fill in the First Contract Date field with "03 24, 2023"
    And I fill in the Catalog Value $ field with "20000"


  Scenario: aaaaaa
    And I fill in the Seat Number field with "5"
    And I fill in the Doors Number field with "4"
    And I fill in the Colour field with "Red"
    And I select "Automatic" in the Transmission field
    And I select "Gasoline" in the Fuel Type field
    And I fill in the CO2 Emissions field with "150"
    And I fill in the Horsepower field with "200"
    And I fill in the Horsepower Taxation field with "1000"
    And I fill in the Power (KW) field with "147"
    And I click the "Create Car" button
    Then the car with the valid data should be created successfully
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





