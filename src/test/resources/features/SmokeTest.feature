@smoke
Feature: Smoke test sample

  @FLEET10-941 @smoke
  Scenario: Verify < and > buttons of the vehicle table work properly
    When The user logs in as "driver"
    And The user navigates to QuickLaunchpad Fleet-Vehicle page
    And The user clicks on the forward ">" button
    Then Verify seeing the next page of the table

  @FLEET10-942 @smoke
  Scenario: Verify < and > buttons of the vehicle table work properly
    When The user logs in as "driver"
    And The user navigates to QuickLaunchpad Fleet-Vehicle page
    And The user clicks on the forward ">" button
    And The user clicks on the back "<" button
    Then Verify seeing the previous page of the table