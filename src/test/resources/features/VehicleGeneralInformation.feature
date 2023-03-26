@FLEET10-919
  Feature: User able to see detailed information of specific vehicle

    User Story :
    As a user, I should be able to see the detailed information of a specific vehicle (General Information Page)

@FLEET10-1033
      Scenario: User can see the "General Information" page by clicking on any vehicle (row), under 'Fleet-Vehicle' module
        Given User on the Fleet-Vehicle page
        When User clicks any vehicle (row)
        Then User can see the General Information page
@FLEET10-1034
      Scenario: User can see the "General Information" page clicking on the "Eye (View)" icon at the end of each row, under 'Fleet-Vehicle' module
        Given User on the Fleet-Vehicle page
        When User clicks on the Eye (View) icon at the end of each row
        Then User can see the General Information page
@FLEET10-1035
      Scenario:Sales manager  should see "Edit", "Delete" and "Add Event" buttons on the "General Information" page
        Given Sales manager on the Fleet-Vehicle page
        When Sales manager clicks a row for go to General Information page
        Then Sales manager can see "Edit", "Delete" and "Add Event" buttons on the General Information page
@FLEET10-1036
    Scenario:Store manager should see "Edit", "Delete" and "Add Event" buttons on the "General Information" page
      Given Store manager on the Fleet-Vehicle page
      When Store manager clicks a row for go to General Information page
      Then Store manager can see "Edit", "Delete" and "Add Event" buttons on the General Information page
@FLEET10-1037
    Scenario:Driver shouldn't see "Add Event", "Edit" and "Delete" buttons
      Given Driver on the Fleet-Vehicle page
      When Driver clicks a row for go to General Information page
      Then Driver can't see "Edit", "Delete" and "Add Event" buttons on the General Information page
@FLEET10-1038
      Scenario: Vehicle information displayed on the "General Information" page and "Fleet-Vehicle" page should be the same
        Given User on the Fleet-Vehicle page
        Then User sees same information about vehicle Fleet-Vehicle page and General Information Page







