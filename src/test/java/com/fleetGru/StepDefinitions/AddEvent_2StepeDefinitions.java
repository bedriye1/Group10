package com.fleetGru.StepDefinitions;

import com.fleetGru.Pages.*;
import com.fleetGru.Utilities.BrowserUtils;
import com.fleetGru.Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEvent_2StepeDefinitions extends AddEventStepDefinition{
    AddEventPage addEventPage=new AddEventPage();
   FleetVehicles fleetVehicles=new FleetVehicles();
   Dashboard dashboard=new Dashboard();
   QuickLaunchPad quickLaunchPad=new QuickLaunchPad();
    Addevent_2Page addevent_2Page=new Addevent_2Page();

    @When("User can go to fleet dropdown")
    public void userCanGoToFleetDropdown() {
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
        addEventPage.firstRow.click();
    }

    @Then("User click the add event button")
    public void user_click_the_add_event_button() {
        BrowserUtils.sleep(5);
        WebElement addEvent = Driver.getDriver().findElement(By.xpath("//a[@title='Add an event to this record']"));
        addEvent.click();
        BrowserUtils.sleep(5);
        Assert.assertTrue(addEvent.isEnabled());


    }
        @When("user clicks add event button and sees add event page pop up")
    public void userClicksAddEventButtonAndSeesAddEventPagePopUp() {
        addevent_2Page.addEventButton.click();
        BrowserUtils.sleep(3);

       addevent_2Page.AddEventPopUp.isDisplayed();

    }
    @And("User enters event title")
    public void userEntersEventTitle() {
        addevent_2Page.addEventTitle.sendKeys("Event Title");
    }
    @And("User can mark the event with any color")
    public void userCanMarkTheEventWithAnyColor() {
        addevent_2Page.allTextcolors.click();
        addevent_2Page.clickableColors.isEnabled();
addevent_2Page.organizerEmail.sendKeys("mustafabaz861@gmail.com");
addevent_2Page.organizerName.sendKeys("Mustafa BAZ");


    }
    @And("User can click Add event check box")
    public void userCanClickAddEventCheckBox() {
        addevent_2Page.allDayEventCheckBox.click();
    }


    @Then("time box will disappear")
    public void timeBoxWillDisappear() {
     addevent_2Page.timerDisappear.click();

    }
    @When("user clicks repeat button")
    public void user_clicks_repeat_button() {
addevent_2Page.repeatButton.click();
    }
    @Then("user sees repeats dropdown menu")
    public void user_sees_repearts_dropdown_menu() {
        addevent_2Page.repeartsDropdown.click();
    }
    @Then("user can repeat action by selecting daily,weekly,montlyand yearly")
    public void user_can_repeat_action_by_selecting_daily_weekly_montlyand_yearly() {
      addevent_2Page.dailyEvent.click();
      addevent_2Page.weeklyEvent.click();
      addevent_2Page.montlyEvent.click();
      addevent_2Page.yearlyEvent.click();
    }
    @Then("user sholud see ending options as never, after,and should be clickable")
    public void user_sholud_see_ending_options_as_never_after_and_should_be_clickable() {
addevent_2Page.neverButton.isDisplayed();
addevent_2Page.neverCheckBox.click();

addevent_2Page .afterButton.isDisplayed();
addevent_2Page.afterCheckBox.click();
addevent_2Page.byButton.isDisplayed();
addevent_2Page.byCheckbox.click();
addevent_2Page.saveButton.click();
    }


}
