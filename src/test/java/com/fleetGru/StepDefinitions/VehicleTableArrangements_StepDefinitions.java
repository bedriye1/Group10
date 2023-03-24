package com.fleetGru.StepDefinitions;

import com.fleetGru.Pages.BasePage;
import com.fleetGru.Pages.FleetVehicles;
import com.fleetGru.Utilities.BrowserUtils;
import com.fleetGru.Utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static afu.org.checkerframework.checker.units.UnitsTools.min;

public class VehicleTableArrangements_StepDefinitions extends BasePage {

    FleetVehicles fleetVehicles=new FleetVehicles();

    @When("User click the View Per Page button")
    public void user_click_the_view_per_page_button() {
        waitUntilLoaderScreenDisappear();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(fleetVehicles.viewPerPageBtn));
        fleetVehicles.viewPerPageBtn.click();
        BrowserUtils.sleep(3);
    }

    @Then("View Per Page button is Enable to select options")
    public void view_per_page_button_has_vehicle_numbers_options() {
        Assert.assertTrue(fleetVehicles.viewPerPageBtn.isEnabled());
    }

    @Then("User should see vehicle numbers {int} as default")
    public void user_should_see_vehicle_numbers_as_default(Integer number) {
        BrowserUtils.sleep(3);
        System.out.println(fleetVehicles.viewPerPageBtn.getText());
    }

    @Then("User should see vehicle numbers")
    public void user_should_see_vehicle(List<String> numbers) {
        int i=0;
        for (WebElement number : fleetVehicles.vehicleNumbers) {
           Assert.assertTrue(numbers.get(i++).equals(number.getText()));
        }

    }

    @When("User click the {string}")
    public void user_click_the(String string) {

        BrowserUtils.sleep(5);
        for (WebElement header : fleetVehicles.tableHeaders) {

            if (header.getText().equals(string)){
                header.click();
                break;
            }

        }
    }
    @Then("User should see {string} sorted {string} order")
    public void user_should_see_column_sorted(String headerName,String sortOrder) {
        BrowserUtils.sleep(2);
        for (WebElement header : fleetVehicles.tableHeaders) {
            if (header.getText().equals(headerName)){
                Assert.assertTrue(header.getAttribute("class").contains(sortOrder));
            }
        }

    }

    @When("User click the any columnName")
    public void user_click_the_any() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(fleetVehicles.driverColumn));
        fleetVehicles.driverColumn.click();
    }
    @When("user select any number from View Per Page button")
    public void user_select_any_number_from_view_per_page_button() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(fleetVehicles.viewPerPageBtn));
        fleetVehicles.viewPerPageBtn.click();
        BrowserUtils.sleep(2);
        //System.out.println(fleetVehicles.vehicleNumber100.getText());
        fleetVehicles.vehicleNumber100.click();


    }
    @When("User click Reset button")
    public void user_click_button() {

        fleetVehicles.resetBtn.click();
    }
    @Then("User should see all columnName sortings reset and vehicle numbers {string} as default")
    public void user_should_see_all_column_sorted_and_vehicle_numbers_as_default(String string) {
        BrowserUtils.sleep(3);
        for (WebElement header : fleetVehicles.tableHeaders) {

            Assert.assertFalse(header.getAttribute("class").contains("ascending")||
                    header.getAttribute("class").contains("descending"));
        }

        Assert.assertTrue(string.equals(fleetVehicles.viewPerPageBtn.getText()));

    }

}
