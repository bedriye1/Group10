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

public class VehiclesGridSettings extends BasePage{
    FleetVehicles fleetVehicles=new FleetVehicles();



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


                List<String> actual=new ArrayList<>();
               for (WebElement gridSettingsColumn : fleetVehicles.gridSettingsColumns) {
                    actual.add(gridSettingsColumn.getText());
               }

               Assert.assertEquals(expected,actual);

           }

}


