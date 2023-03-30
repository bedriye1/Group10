
@FLEET10-1155
Feature: Create button functionality test


  Background:
    Given The user is on the login page

    @FLEET10-1147
  Scenario: Verify Create Car" button shouldn't be displayed for the driver
    When When The user logs in as "driver"
    Then user should not display "Create Car" button

    @FLEET10-1148
  Scenario: Verify Create car button displayed for authorised user "salesmanager"
    When user logs in as a "salesmanager101" with"UserUser123"
    Then user displays "Create Car" button page

    @FLEET10-1149
  Scenario: Verify Create car button displayed for authorised user "storemanager"
    When user logs in as a store manager with "storemanager51" with "UserUser123" credentials
    Then user displays "Create Car" button page

    @FLEET10-1150
  Scenario: Verify user land on the Create car page
    When user logs in create car page after clicking crate car button
    Then After clicking Create Car button should land on Create Car page

    @FLEET10-1151
  Scenario: User creates a car with valid data
    When I am on the Create Car page
    And I fill in the License Plate field with "ABC123"
    And Checked  the  all Tags
    And I fill in the Driver field with "Veli KARA"
    And I fill in the Location field with "New York"
    And I fill in the Chassis Number field with "ABC123456"
    And I fill in the Model Year field with "2022"
    And I fill in the Last Odometer field with "10000"
    And I fill in the Immatriculation Date field with "Jun 21, 2021"
    And I fill in the First Contract Date field with "Jun 24, 2023"
    And I fill in the Catalog Value $ field with "20000"
    And I fill in the Seat Number field with "5"
    And I fill in the Doors Number field with "4"
    And I fill in the Colour field with "Red"
    And I select "Automatic" in the Transmission field
    And I select "Electric" in the Fuel Type field
    And I fill in the CO2 Emissions field with "150"
    And I fill in the Horsepower field with "200"
    And I fill in the Horsepower Taxation field with "1000"
    And I fill in the Power (KW) field with "147"
    And  I select the "Save" option
    Then the form data should be saved and the same page should remain the form data should be retained
    Then the message "Entity saved" should be displayed

    @FLEET10-1152
  Scenario: Save and New
    Given I am on the form page
    When I fill in the License Plate field with "ABC123"
    And I fill in the Driver field with "Veli KARA"
    And  I select the "Save And New" option
    Then the message "Entity saved" should be displayed

    @FLEET10-1153
  Scenario: Save and Close
    Given I am on the form page
    When I fill in the License Plate field with "ABC123"
    When I select the "Save And Close" option
    Then the "General Information" page should be displayed
    Then the message "Entity saved" should be displayed

    @FLEET10-1154
  Scenario: Create Car with invalid data
    Given I am on the Create Car page
    When I fill in the License Plate field with "$%#"
    And Checked  the  all Tags
    And I fill in the Driver field with "123"
    And I fill in the Location field with "123"
    And I fill in the Chassis Number field with "$%#"
    And I fill in the Model Year field with "abc"
    And I fill in the Last Odometer field with "abc"
    And I fill in the Immatriculation Date field with "Jun 21, 2021"
    And I fill in the First Contract Date field with "Jun 24, 2023"
    And I fill in the Catalog Value $ field with "abc"
    And I fill in the Seat Number field with "abc"
    And I fill in the Doors Number field with "abc"
    And I fill in the Colour field with "123"
    And I select "Automatic" in the Transmission field
    And I select "Electric" in the Fuel Type field
    And I fill in the CO2 Emissions field with "abc"
    And I fill in the Horsepower field with "123"
    And I fill in the Horsepower Taxation field with "123"
    And I fill in the Power (KW) field with "123"
    When I select the "Save And Close" option


   # And I select a JPEG or PNG file for the Logo field, or leave it blank


