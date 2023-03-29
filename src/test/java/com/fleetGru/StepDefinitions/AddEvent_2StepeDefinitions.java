package com.fleetGru.StepDefinitions;

import com.fleetGru.Pages.*;
import com.fleetGru.Utilities.BrowserUtils;
import com.fleetGru.Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
        BrowserUtils.sleep(5);
        dashboard.Vehicles.click();

    }
    @When("User can click on any row in the table")
    public void user_can_click_on_any_row_in_the_table() {
        BrowserUtils.sleep(8);
        addevent_2Page.anyVehicles.click();
    }
    @And("user can click add event button")
    public void userCanClickAddEventButton() {
        BrowserUtils.sleep(5);
        addevent_2Page.addEventButton.click();
        BrowserUtils.sleep(5);

    }
    @Then("user should be able to see add event pop up")
    public void userShouldBeAbleToSeeAddEventPopUp() {
          String expectedTitle="Add Event";
        String actualTitle= addevent_2Page.AddEventPopUp.getText();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);
        BrowserUtils.sleep(3);
    }
    @And("User enters event title")
    public void userEntersEventTitle() {
        addevent_2Page.addEventTitle.sendKeys("Event Title");
    }
    @And("User can mark the event with any color")
    public void userCanMarkTheEventWithAnyColor() {
     addevent_2Page.colors.click();
addevent_2Page.organizerEmail.sendKeys("mustafabaz861@gmail.com");
addevent_2Page.organizerName.sendKeys("Mustafa BAZ");


    }
    @And("User can click  All-day event check box")
    public void userCanClickAddEventCheckBox() {
        addevent_2Page.allDayEventCheckBox.click();
    }
    @And("Time boxes will disappear")
    public void timeBoxesWillDisappear() {
        BrowserUtils.sleep(2);
        //Assert.assertFalse();//saati locate et ve is visible

    // addevent_2Page.timerDisappear.isDisplayed();
//Assert.assertEquals("display: none;",addevent_2Page.timerDisappear.getAttribute("style"));

    }
    @When("user clicks repeat button")
    public void user_clicks_repeat_button() {
addevent_2Page.repeatButton.click();
    }
    @Then("user sees repeats dropdown menu")
    public void user_sees_repearts_dropdown_menu() {
     addevent_2Page.repeatsDropdown.click();
    }
    @And("user can repeat action by selecting Daily,Weekly,Montly and Yearly")
    public void userCanRepeatActionBySelectingDailyWeeklyMontlyAndYearly(List<String>eventRepeats) {
        Select select=new Select(addevent_2Page.repeatsDropdown);
    List<WebElement>repeatDropdown=select.getOptions();
    int i=0;
        for (WebElement each : repeatDropdown) {
           Assert.assertEquals(eventRepeats.get(i++),each.getText());
                  }

    }

    @Then("user should see ending options as never, after,and by should be clickable")
    public void user_sholud_see_ending_options_as_never_after_and_should_be_clickable(List<String>itemslist) {
        int i=0;
        for (String each : itemslist) {
           Assert.assertTrue(addevent_2Page.endsList.get(i++).getText().contains(each));

        }
       BrowserUtils.sleep(2);
        addevent_2Page.saveButton.click();
        }

    @Then("All Users can see all events on the General information page")
    public void allUsersCanSeeAllEventsOnTheGeneralInformationPage() {
        JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",addevent_2Page.activity);
        Assert.assertTrue(addevent_2Page.eventAdded.isDisplayed());
    }
}
