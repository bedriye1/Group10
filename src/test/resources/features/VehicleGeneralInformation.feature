@FLEET10-919
  Feature: User able to see detailed information of specific vehicle

    User Story :
    As a user, I should be able to see the detailed information of a specific vehicle (General Information Page)

@S1
      Scenario:
        Given User on the Fleet-Vehicle page
        When User clicks any vehicle (row)
        Then User can see the General Information page
@S2
      Scenario:
        Given User on the Fleet-Vehicle page
        When User clicks on the Eye (View) icon at the end of each row
        Then User can see the General Information page
@S3
      Scenario:
        Given Sales manager on the Fleet-Vehicle page
        When Sales manager clicks a row for go to General Information page
        Then Sales manager can see "Edit", "Delete" and "Add Event" buttons on the General Information page
@S4
    Scenario:
      Given Store manager on the Fleet-Vehicle page
      When Store manager clicks a row for go to General Information page
      Then Store manager can see "Edit", "Delete" and "Add Event" buttons on the General Information page
@S5
    Scenario:
      Given Driver on the Fleet-Vehicle page
      When Driver clicks a row for go to General Information page
      Then Driver can't see "Edit", "Delete" and "Add Event" buttons on the General Information page
@S6
      Scenario:
        Given User on the Fleet-Vehicle page
        Then User sees same information about vehicle Fleet-Vehicle page and General Information Page







