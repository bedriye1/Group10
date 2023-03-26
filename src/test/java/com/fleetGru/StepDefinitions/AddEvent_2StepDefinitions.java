package com.fleetGru.StepDefinitions;

import com.fleetGru.Pages.BasePage;
import com.fleetGru.Pages.Dashboard;
import com.fleetGru.Pages.FleetVehicles;
import com.fleetGru.Utilities.BrowserUtils;
import com.fleetGru.Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEvent_2StepDefinitions extends BasePage {
    Dashboard dashboard = new Dashboard();
    FleetVehicles fleetVehicles = new FleetVehicles();
    @When("User can go to fleet dropdown")
    public void userCanGoToFleetDropdown() {
        waitUntilLoaderScreenDisappear();
        BrowserUtils.sleep(5);
        dashboard.FleetDropDown.click();

    }

    @And("User click the Vehicles modules")
    public void userClickTheVehiclesModules() {
        dashboard.Vehicles.click();
        BrowserUtils.sleep(5);
    }

    @When("User can click on any row in the table")
    public void user_can_click_on_any_row_in_the_table() {
       BrowserUtils.sleep(5);
       fleetVehicles.firstRow.click();
    }

    @Then("User click the add event button")
    public void user_click_the_add_event_button() {
      BrowserUtils.sleep(5);
      WebElement addEvent = Driver.getDriver().findElement(By.xpath("//a[@title='Add an event to this record']"));
      addEvent.click();
      BrowserUtils.sleep(5);
    }
    @When("user clicks add event button and add event page pop up")
    public void userClicksAddEventButtonAndAddEventPagePopUp() {

    }
    @And("User can mark the event with any color")
    public void userCanMarkTheEventWithAnyColor() {

    }
    @And("User can click Add event check box")
    public void userCanClickAddEventCheckBox() {

    }
    @Then("time box will disappear")
    public void timeBoxWillDissappear() {
    }
}
