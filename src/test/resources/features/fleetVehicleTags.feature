@FLEET10-927

Feature: As a user, I should be able to use "Tags" filter under 'Fleet-Vehicles' page

  Background:
    Given The user logs in with credential username "user1" and password "UserUser123"
    Then The user navigates to Fleet-Vehicle page

    @FLEET10-984
    Scenario: User can select Tags filter under Fleet-Vehicles page
      When User clicks to filter icon button
      And User able to see "Manage filters"
      Then User able to clicks to Tags
