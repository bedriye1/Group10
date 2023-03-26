package com.fleetGru.StepDefinitions;

import com.fleetGru.Pages.AddEventPage;
import com.fleetGru.Pages.Dashboard;
import com.fleetGru.Pages.FleetVehicles;
import com.fleetGru.Pages.QuickLaunchPad;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class AddEvent_2StepeDefinitions extends AddEventStepDefinition{
    AddEventPage addEventPage=new AddEventPage();
   FleetVehicles fleetVehicles=new FleetVehicles();
   Dashboard dashboard=new Dashboard();
   QuickLaunchPad quickLaunchPad=new QuickLaunchPad();

    @When("user clicks add event button and sees add event page pop up")
    public void userClicksAddEventButtonAndSeesAddEventPagePopUp() {
    }
    @And("User can mark the event with any color")
    public void userCanMarkTheEventWithAnyColor() {
    }
    @And("User can click Add event check box")
    public void userCanClickAddEventCheckBox() {
    }

    

}
