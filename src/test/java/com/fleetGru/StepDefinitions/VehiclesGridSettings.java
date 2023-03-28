package com.fleetGru.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.fleetGru.Pages.*;
import com.fleetGru.Utilities.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VehiclesGridSettings extends BasePage {
    FleetVehicles fleetVehicles = new FleetVehicles();


    @When("User clicks on the gear icon")
    public void user_clicks_on_the_gear_icon() {

        BrowserUtils.sleep(2);


        fleetVehicles.gridButton.click();


    }

    @Then("user can see grid settings")
    public void user_can_see_grid_settings() {

        waitUntilLoaderScreenDisappear();
        Assert.assertTrue(fleetVehicles.gridSettingDDown.isDisplayed());
        waitUntilLoaderScreenDisappear();
    }

    @Then("User checks all the visible tags by name")
    public void user_checks_all_the_visible_tags_by_name() {

        String str = ConfigurationReader.getProperty("vehicleGridSettingsTags");
        String[] strSplit = str.split(",");

        ArrayList<String> expected = new ArrayList<String>(
                Arrays.asList(strSplit));


        List<String> actual = new ArrayList<>();
        for (WebElement gridSettingsColumn : fleetVehicles.gridSettingsColumns) {
            actual.add(gridSettingsColumn.getText());
        }

        Assert.assertEquals(expected, actual);

    }

    @Then("User confirms all the tags can be selected")
    public void user_confirms_all_the_tags_can_be_selected() {
        for (WebElement gridSettingTag : fleetVehicles.gridSettingCheckBoxes) {
            if (!gridSettingTag.isSelected()){
                gridSettingTag.click();
            }

        }



        ArrayList<String> tags=fleetVehicles.actualTags();
        boolean a=true;
        for (WebElement gridSettingCheckBox : fleetVehicles.gridSettingCheckBoxes) {
            if (!gridSettingCheckBox.isSelected()){
                a=false;
            }
        }



    }

    @When("user searches for a random tag")
    public void user_searches_for_a_random_tag() {
fleetVehicles.quickSearchRandom();
    }

    @Then("the random tag user searched for will be displayed")
    public void the_random_tag_user_searched_for_will_be_displayed() {
      Assert.assertTrue(fleetVehicles.verifyQuickSearch());
    }

    @When("User selects all grid tags")
    public void user_selects_all_grid_tags() {
       fleetVehicles.selectAllGridTags();
    }

    @Then("User confirms all the grid changes are applied")
    public void user_confirms_all_the_grid_changes_are_applied() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




}


