Feature:User Story :

  As a user, I should be able to arrange vehicle table columns via "grid settings" functionality under the Fleet-Vehicles page



  Acceptance Criteria:

  1- "Grid Settings" should be visible when user clicks on the gear icon
  2- Column names in grid settings should be shown as below:
  -Id
  -License Plate
  -Tags
  -Driver
  -Location
  -Chassis Number
  -Model Year
  -Last Odometer
  -Immatriculation Date
  -First Contract Date
  -Catalog Value (VAT Incl.)
  -Seats Number
  -Doors Number
  -Color
  -Transmission
  -Fuel Type
  -CO2 Emissions
  -Horsepower
  -Horsepower Taxation
  -Power (KW)
  3- User can find any column by typing the name on "Quick Search" input box
  4- User can select any column by clicking the column name
  5- User can arrange the order of the columns (by dragging and dropping)
  6- User can see all corresponding changes under 'Fleet-Vehicles' pages


  Background:
    Given The user is on the login page


    @surhay @AC1
    Scenario: Grid Settings toolbar
      When The user logs in as "sales manager"
      And The user navigates to Dashboard Fleet-Vehicle page
      When User clicks on the gear icon
      Then user can see grid settings
@surhay @AC2
  Scenario: Testing default column names
    When The user logs in as "sales manager"
    And The user navigates to Dashboard Fleet-Vehicle page
    When User clicks on the gear icon
    Then User checks all the visible tags by name

  Scenario: Testing checkboxes
    When The user logs in as "sales manager"
    And The user navigates to Dashboard Fleet-Vehicle page
    When User clicks on the gear icon
    Then User checks all the visible tags by name


