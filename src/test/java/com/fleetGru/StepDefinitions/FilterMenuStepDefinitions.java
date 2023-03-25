package com.fleetGru.StepDefinitions;

import com.fleetGru.Pages.*;
import com.fleetGru.Utilities.BrowserUtils;
import com.fleetGru.Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import java.util.*;


public class FilterMenuStepDefinitions extends BasePage {

    FleetVehicles fleetVehicles = new FleetVehicles();


    @And("The user clicks filters icon")
    public void the_user_clicks_filters_icon() {
        fleetVehicles.filtersIcon.click();
    }

    @Then("The user should see {string} button")
    public void the_user_should_see_button(String string) {
        BrowserUtils.sleep(5);
        BrowserUtils.verifyElementDisplayed(fleetVehicles.manageFiltersButton);
    }

    @And("The user clicks {string} button")
    public void the_user_clicks_button(String string) {
        BrowserUtils.sleep(3);
        fleetVehicles.manageFiltersButton.click();


    }


    @Then("The user can apply filters by clicking")
    public void the_user_can_apply_filters_by_clicking() {

        BrowserUtils.sleep(3);
        fleetVehicles.tagsFilter.click();
        BrowserUtils.sleep(5);
        Assert.assertTrue(fleetVehicles.tagsFilter.isEnabled());


    }

    @Then("The user can apply filters by typing")
    public void the_user_can_apply_filters_by_typing() {
        fleetVehicles.manageFiltersSearchBar.sendKeys("Driver");
        fleetVehicles.driverFilter.click();
        Assert.assertTrue(fleetVehicles.driverFilter.isEnabled());
    }

    @And("The user clicks {string} and {string} tags")
    public void the_user_clicks_and_tags(String string, String string2) {

        BrowserUtils.sleep(5);
        fleetVehicles.tagsFilter.click();
        BrowserUtils.sleep(5);
        fleetVehicles.driverFilter.click();

    }

    @Then("The user can apply multiple filters at a time")
    public void the_user_can_apply_multiple_filters_at_a_time() {
        System.out.println(fleetVehicles.filterContainer.getText());
        BrowserUtils.sleep(3);
        String tagsFilterText = fleetVehicles.filterContainer.getText();
        Assert.assertTrue(tagsFilterText.contains("Tags: All"));
        BrowserUtils.sleep(3);
        String driverFilterText = fleetVehicles.filterContainer.getText();
        Assert.assertTrue(driverFilterText.contains("Driver: All"));


    }

    @And("The user clicks reset icon")
    public void the_user_clicks_reset_icon() {
        BrowserUtils.sleep(5);
        fleetVehicles.resetIcon.click();
    }

    @Then("The user should be able to reset all filters")
    public void the_user_should_be_able_reset_all_filters() {
        BrowserUtils.sleep(8);
        Assert.assertTrue(fleetVehicles.filterContainer.getText().equals("Manage filters"));

    }


}
