@FLEET10-927
Feature: As a user, I should be able to use "Tags" filter under 'Fleet-Vehicles' page

  Background
    Given The user logs in with credential username "user1" and password "UserUser123"
    Then The user navigates to Fleet-Vehicle page

  @FLEET10-984
  Scenario: User can select Tags filter under Fleet-Vehicles page
    When User clicks to filter icon button
    And User able to see "Manage filters"
    Then User able to clicks to Tags

  @FLEET10-986
  Scenario: User should able to see provided tags
    When User click Tags: All
    And User clicks Is Any Of
    Then User should able to see "Is Any Of" and "Is Not Any Of" options

  @FLEET10-1012
  Scenario: User should able to see corresponding value
    When User selects Is Any Of method
    And User entries "Compact" to search box
    Then User able to see "Compact" corresponding value on the table

  @FLEET10-1013
  Scenario: User should not able to see corresponding value
    When User selects Is Not Any Of method
    And User entries "Compact" to search box
    Then User should not able to see "Compact" corresponding value on the table

  @FLEET10-1014
  Scenario: User should not able to see corresponding value
    When User selects Is Not Any Of method
    And User entries "Compact" to search box
    Then User should not able to see "Compact" and "Sedan" corresponding value on the table
