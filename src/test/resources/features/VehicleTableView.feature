  Feature: Vehicle Table View

  Background:
    Given The user is on the login page

  @FLEET10-935
  Scenario: All user types can see vehicle table
    When The user logs in as "driver"
    And The user navigates to QuickLaunchpad Fleet-Vehicle page
    Then The user sees all the vehicle information in a table


   @FLEET10-937

  Scenario: All user types can see vehicle table
    When The user logs in as "sales manager"
    And The user navigates to Dashboard Fleet-Vehicle page
    Then The user sees all the vehicle information in a table

  @FLEET10-939
  Scenario: All user types can see vehicle table
    When The user logs in as "store manager"
    And The user navigates to Dashboard Fleet-Vehicle page
    Then The user sees all the vehicle information in a table

  @FLEET10-940
  Scenario: Verify total page number of the vehicle table is displayed
    When The user logs in as "driver"
    And The user navigates to QuickLaunchpad Fleet-Vehicle page
    Then User can see the total page number

  @FLEET10-941

  Scenario: Verify < and > buttons of the vehicle table work properly
    When The user logs in as "driver"
    And The user navigates to QuickLaunchpad Fleet-Vehicle page
    And The user clicks on the forward ">" button
    Then Verify seeing the next page of the table

  @FLEET10-942
  Scenario: Verify < and > buttons of the vehicle table work properly
    When The user logs in as "driver"
    And The user navigates to QuickLaunchpad Fleet-Vehicle page
    And The user clicks on the forward ">" button
    And The user clicks on the back "<" button
    Then Verify seeing the previous page of the table

  @FLEET10-943
  Scenario: Verify total recordings of vehicles is displayed
    When The user logs in as "driver"
    And The user navigates to QuickLaunchpad Fleet-Vehicle page
    Then Verify user can see total recordings of vehicles

  @FLEET10-944
  Scenario: Verify user can download table data in XLS or CSV format from "Export Grid"
    When The user logs in as "driver"
    And The user navigates to QuickLaunchpad Fleet-Vehicle page
    And The user clicks on the "Export Grid" link
    Then Verify table data is downloaded in XLS or CSV format
