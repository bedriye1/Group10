Feature: Delete a car

  Background:
    Given The user is on the login page

  Scenario Outline: All users can see the delete button by hovering over the three dots at the end of each row
    When The user enters with valid "<username>" and password and clicks login button
    And The user navigates to Fleet-Vehicles page-for all users
    Then The user hover over the three dots and able to see delete button

    Examples:
      | username        |
      | user1           |
      | storemanager51  |
      | salesmanager101 |

  Scenario Outline: "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
    When The user enters with valid "<username>" and password and clicks login button
    And The user navigates to Fleet-Vehicles page-for all users
    And The user clicks the delete button
    Then The user able to see "Delete Confirmation" pop up

    Examples:
      | username        |
      | user1           |
      | storemanager51  |
      | salesmanager101 |

  Scenario: İf the driver clicks on the "Yes, Delete" button, "You do not have permission to perform this action." message should be displayed
    When The user enters with valid "user1" and password and clicks login button
    And The user navigates to Fleet-Vehicles page-for all users
    And The user clicks the delete button
    And The user clicks the Yes, Delete button
    Then The user should see "You do not have permission to perform this action." message

  Scenario Outline: 'Sales Manager' and 'Store Manager' can delete any car by clicking on the delete button at the end of each row and the "Item deleted" message should be displayed.
    When The user enters with valid "<username>" and password and clicks login button
    And The user navigates to Fleet-Vehicles page-for all users
    And The user clicks the delete button
    And The user clicks the Yes, Delete button
    Then The user should see "Item deleted" message

    Examples:
      | username        |
      | storemanager51  |
      | salesmanager101 |

  Scenario Outline: When 'Sales Manager' and 'Store Manager' go to the 'General Information' page by clicking on any vehicle/row, they can delete any vehicle by clicking on the 'Delete' button and the "Car deleted" message should be displayed.
    When The user enters with valid "<username>" and password and clicks login button
    And The user navigates to Fleet-Vehicles page-for all users
    And The user clicks the View button
    And The user click the Delete Button on General Information Page
    And The user clicks the Yes, Delete button
    Then The user should see "Car deleted" message

    Examples:
      | username        |
      | storemanager51  |
      | salesmanager101 |

  Scenario Outline: When 'Sales Manager' and 'Store Manager' delete a car, the corresponding car should also be removed from the Fleet-Vehicle page.
    When The user enters with valid "<username>" and password and clicks login button
    And The user navigates to Fleet-Vehicles page-for all users
    And The user clicks the View button
    And The user click the Delete Button on General Information Page
    Then The user clicks the Yes, Delete button and can not see deleted car on Fleet-Vehicles page anymore

    Examples:
      | username        |
      | storemanager51  |
      | salesmanager101 |


