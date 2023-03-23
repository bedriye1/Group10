package com.fleetGru.StepDefinitions;

import com.fleetGru.Pages.FleetVehicles;
import com.fleetGru.Pages.LoginPage;
import com.fleetGru.Pages.QuickLaunchPad;
import com.fleetGru.Utilities.BrowserUtils;
import com.fleetGru.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TagsFilerStepDefinitions {

    FleetVehicles fleetVehicles = new FleetVehicles();
    QuickLaunchPad quickLaunchPad = new QuickLaunchPad();
    LoginPage loginPage = new LoginPage();


    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);


    @Given("The user logs in with credential username {string} and password {string}")
    public void the_user_logs_in_with_credential_username_and_password(String string, String string2) {
        loginPage.login(string, string2);
    }

    @Then("The user navigates to Fleet-Vehicle page")
    public void the_user_navigates_to_fleet_vehicle_page() {
        wait.until(ExpectedConditions.visibilityOf(quickLaunchPad.FleetsQuichLaunch));
        quickLaunchPad.FleetsQuichLaunch.click();
        BrowserUtils.sleep(1);
        quickLaunchPad.Vehicles.click();
    }

    @When("User clicks to filter icon button")
    public void user_clicks_to_filter_icon_button() {
        fleetVehicles.filterButton.click();
    }

    @When("User able to see {string}")
    public void user_able_to_see(String expectedText) {

        Assert.assertEquals(fleetVehicles.manageFilters.getText(), expectedText);
    }

    @Then("User able to clicks to Tags")
    public void user_able_to_clicks_to() {
        fleetVehicles.tagsButton.click();
    }


}
