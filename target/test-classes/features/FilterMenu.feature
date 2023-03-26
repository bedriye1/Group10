@FLEET10-921 @FLEET10-1008
Feature: Filter Menu

  Background: Given The user is on the login page
    Given The user logs in as "sales manager"

  @FLEET10-1001
  Scenario:When a user clicks on the filter icon, the "Manage Filter" button should be visible
    When The user navigates to Dashboard Fleet-Vehicle page
    And The user clicks filters icon
    Then The user should see "Manage Filter" button

  @FLEET10-1002
  Scenario: User can apply filters by clicking on the filter name
    When The user navigates to Dashboard Fleet-Vehicle page
    And The user clicks filters icon
    And The user should see "Manage Filter" button
    And The user clicks "Manage Filter" button
    Then The user can apply filters by clicking

  @FLEET10-1004
  Scenario: User can apply filters by typing the filter name
    When The user navigates to Dashboard Fleet-Vehicle page
    And The user clicks filters icon
    And The user should see "Manage Filter" button
    And The user clicks "Manage Filter" button
    Then The user can apply filters by typing

  @FLEET10-1005
  Scenario: User can apply multiple filters at the same time
    When The user navigates to Dashboard Fleet-Vehicle page
    And The user clicks filters icon
    And The user should see "Manage Filter" button
    And The user clicks "Manage Filter" button
    And The user clicks "Tags" and "Driver" tags
    Then The user can apply multiple filters at a time

  @FLEET10-1006
  Scenario: User can remove all filters by clicking on the reset icon
    When The user navigates to Dashboard Fleet-Vehicle page
    And The user clicks filters icon
    And The user should see "Manage Filter" button
    And The user clicks "Manage Filter" button
    And The user clicks "Tags" and "Driver" tags
    And The user clicks reset icon
    Then The user should be able to reset all filters







