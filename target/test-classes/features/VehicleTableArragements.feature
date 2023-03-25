@FLEET10-981
Feature: Vehicle Table Arragements

  Background:
    Given The user logs in as "sales manager"

  @FLEET10-969
  Scenario: Arrange vehicle numbers from 'View Per Page' button
    When The user navigates to Dashboard Fleet-Vehicle page
    And User click the View Per Page button
    Then View Per Page button is Enable to select options

  @FLEET10-972
    Scenario: 'View Per Page' button default value is '25'
      When The user navigates to Dashboard Fleet-Vehicle page
      Then User should see vehicle numbers 25 as default

  @FLEET10-973
     Scenario: 'View Per Page' includes values
       When The user navigates to Dashboard Fleet-Vehicle page
       And User click the View Per Page button
       Then User should see vehicle numbers
         | 10  |
         | 25  |
         | 50  |
         | 100 |

  @FLEET10-974
  Scenario Outline: Sort columns by clicking column name
         When The user navigates to Dashboard Fleet-Vehicle page
         And User click the "<columnName>"
         And User should see "<columnName>" sorted "ascending" order
         And User click the "<columnName>"
         Then User should see "<columnName>" sorted "descending" order
      Examples:
        | columnName |
        | LICENSE PLATE        |
        | DRIVER               |
        | LOCATION             |
        | CHASSIS NUMBER       |
        | MODEL YEAR           |
        | LAST ODOMETER        |
        | IMMATRICULATION DATE |
        | FIRST CONTRACT DATE  |
        | CVVI                 |
        | SEATS NUMBER         |
        | DOORS NUMBER         |
        | COLOR                |
        | TRANSMISSION         |
        | FUEL TYPE            |
        | CO2 EMISSIONS        |
        | HORSEPOWER           |
        | HORSEPOWER TAXATION  |
        | POWER (KW)           |


  @FLEET10-977
  Scenario: Remove all sortings and filterings after clicking reset button
      When The user navigates to Dashboard Fleet-Vehicle page
      And user select any number from View Per Page button
      And User click the any columnName
      And User click Reset button
      Then User should see all columnName sortings reset and vehicle numbers "25" as default
#    Examples:
#      | columnName |
#      | LICENSE PLATE        |
#      | DRIVER               |
#      | LOCATION             |
#      | CHASSIS NUMBER       |
#      | MODEL YEAR           |
#      | LAST ODOMETER        |
#      | IMMATRICULATION DATE |
#      | FIRST CONTRACT DATE  |
#      | CVVI                 |
#      | SEATS NUMBER         |
#      | DOORS NUMBER         |
#      | COLOR                |
#      | TRANSMISSION         |
#      | FUEL TYPE            |
#      | CO2 EMISSIONS        |
#      | HORSEPOWER           |
#      | HORSEPOWER TAXATION  |
#      | POWER (KW)           |
