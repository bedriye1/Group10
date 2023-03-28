package com.fleetGru.StepDefinitions;

import com.fleetGru.Pages.*;
import com.fleetGru.Utilities.BrowserUtils;
import com.fleetGru.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFilterStepDefinitions extends BasePage {

        FleetVehicles fleetVehicles= new FleetVehicles();
        LoginPage loginPage = new LoginPage();
        Dashboard dashboard = new Dashboard();
        QuickLaunchPad quickLaunchPad = new QuickLaunchPad();

        @When("User clicks {string}")
        public void user_clicks(String string) {
                fleetVehicles.filtersIcon.click();
                BrowserUtils.sleep(5);
                fleetVehicles.manageFiltersButton.click();

        }

        @Then("Verify user able to click to {string} button")
        public void verify_user_able_to_click_to_button(String string) {
                BrowserUtils.sleep(5);
                fleetVehicles.driverFilterButton.click();
                Assert.assertTrue(fleetVehicles.driverFilterButton.isEnabled());

        }

        @When("User able to clicks to {string} button")
        public void user_able_to_clicks_to_button(String string) {

//                if (buttonName.equals("Manage filters")) {
//                        driver.findElement(By.xpath("//span[contains(text(),'Manage filters')]")).click();
//                } else if (buttonName.equals("Driver:All")) {
//                        WebDriverWait wait = new WebDriverWait(driver, 10);
//                        WebElement driverAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='driver']/button[contains(text(),'Driver:All')]")));
//                        driverAllButton.click();
//                }
                BrowserUtils.sleep(10);
                fleetVehicles.filtersIcon.click();
                fleetVehicles.manageFiltersButton.click();
                //fleetVehicles.manageFiltersSearchBar.sendKeys("Driver");
                fleetVehicles.driverFilterButton.click();
                fleetVehicles.driverFilterButton.sendKeys(Keys.ESCAPE);

                fleetVehicles.driverAllButton.click();
                BrowserUtils.sleep(10);
                fleetVehicles.containsdropDownButton.click();
                fleetVehicles.containsdropDownButton.getText();
                System.out.println("fleetVehicles.containsdropDownButton.getText() = " + fleetVehicles.containsdropDownButton.getText());


        }

        @When("The user clicks {string}")
        public void the_user_clicks(String string) {

        }

        @When("The user sees the {string} module and click")
        public void the_user_sees_the_module_and_click(String string) {

        }

        @Then("Verify user should see tags the with the order below")
        public void verify_user_should_see_tags_the_with_the_order_below(io.cucumber.datatable.DataTable dataTable) {

        }

}