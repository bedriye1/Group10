@FLEET10-1142 #test-exec
Feature:Last Odometer Tests

  User Story :

  As a user, I should be able to use "Last Odometer" filter under 'Fleet-Vehicles' page

  Acceptance Criteria:

  1- User can select "Last Odometer" filter under 'Fleet-Vehicles' page

  2- "Last Odometer" filter should provide the methods shown as below:
  -> Between
  -> Not Between
  -> Equals
  -> Not Equals
  -> More Than
  -> Less Than
  -> Equals or More Than
  -> Equals or Less Than
  -> Is Empty
  -> Is Not Empty

  3- When user selects "Between" method with numeric values, the results should be between the specified values

  4- When user selects "Equals" method with numeric values, the results should match the specified value exactly

  5- When user selects "More than" method with numeric values, the results should be more than the specified value

  6- When user selects "Less than" method with numeric values, the results should be less than the specified value

  7- When user selects "Is Empty" method, only empty values should be displayed.

  8- Methods ("Between","Equals","More Than","Less Than") shouldn't accept non-numeric values


  Background: Pre-Condition
    Given "user1" is logged in and clicks Fleet module and Vehicles tab
    And User clicks on Manage filter options button


  @FLEET10-1134 #TC-01
  Scenario: User can select "Last Odometer" filter under 'Fleet-Vehicles' page
    Then user should be able to click the Last Odometer filter

  @FLEET10-1135 #TC-02
  Scenario: Last Odometer filter provide the methods
    When User clicks on Last Odometer filter checkbox
    And User clicks on the Last Odometer dropdown menu
    Then User should be able to see the options as below list

  @FLEET10-1136 #TC-03
  Scenario: User selects Between method with numeric values and see correct values
    When User clicks on Last Odometer filter checkbox
    And User clicks on the Last Odometer dropdown menu
    And User selects "Between" method
    And User enters 10000 and 20000 in the filter fields
    Then User should see the vehicles with last odometer between 10000 and 20000

  @FLEET10-1137 #TC-04
  Scenario: User selects Equals method with numeric values and see correct values
    When User clicks on Last Odometer filter checkbox
    And User clicks on the Last Odometer dropdown menu
    And User selects "Equals" method
    And User enters 10000 in the filter field
    Then User should be able to see the vehicles with last odometer equal to 10000

  @FLEET10-1138 #TC-05
  Scenario: User selects More than method with numeric values and see correct values
    When User clicks on Last Odometer filter checkbox
    And User clicks on the Last Odometer dropdown menu
    And User selects "More Than" method
    And User enters 25000 in the filter field
    Then User should be able to see the vehicles with last odometer more than 25000

  @FLEET10-1139 #TC-06
  Scenario: User selects Less than method with numeric values and see correct values
    When User clicks on Last Odometer filter checkbox
    And User clicks on the Last Odometer dropdown menu
    And User selects "Less Than" method
    And User enters 25000 in the filter field
    Then User should be able to see the vehicles with last odometer less than 25000

  @FLEET10-1140 #TC-07-(FAIL)
  Scenario: User selects Is Empty method with numeric values and see correct values
    When User clicks on Last Odometer filter checkbox
    And User clicks on the Last Odometer dropdown menu
    And User selects "Is Empty" method
    Then User should be able to see the vehicles with last odometer is empty


  @FLEET10-1141 #TC-08-(FAIL)
  Scenario Outline: Methods ("Between","Equals","More Than","Less Than") shouldn't accept non-numeric values
    When User clicks on Last Odometer filter checkbox
    And User clicks on the Last Odometer dropdown menu
    And User selects "<MethodName>" method
    And User enters "<Values1>" and "<Values2>" in the filter field
    Then User should see these methods shouldn't accept non-numeric values

    Examples:
      | MethodName          | Values1     | Values2     |
      | Between             | onethousand | twothousand |
      | Not Between         | onethousand | twothousand |
      | Equals              | 123.asd     |             |
      | Not Equals          | 123.asd     |             |
      | More Than           | DoesItWork? |             |
      | Less Than           | 15000#      |             |
      | Equals Or More Than | 10000o      |             |
      | Equals Or Less Than | 10o00       |             |

