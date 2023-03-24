package com.fleetGru.StepDefinitions;

import com.fleetGru.Pages.*;
import com.fleetGru.Utilities.BrowserUtils;
import com.fleetGru.Utilities.ConfigurationReader;
import com.fleetGru.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateBtnStepDefinitions extends BasePage {

    LoginPage loginPage = new LoginPage();
    Dashboard dashboard = new Dashboard();
    QuickLaunchPad quickLaunchPad = new QuickLaunchPad();
    FleetVehicles fleetVehicles = new FleetVehicles();
    Actions action = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("Verify {string} on the dashboard page")
    public void verify_on_the_dashboard_page(String userType) {

        //go to login page
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        //based on input enter that user information

    }

    @When("When The user logs in as {string}")
    public void whenTheUserLogsInAs(String userType) throws InterruptedException {
        String username = null;
        String password = null;

        if (userType.equalsIgnoreCase("driver")) {
            username = ConfigurationReader.getProperty("driver_username");
            password = ConfigurationReader.getProperty("driver_password");
        } else if (userType.equalsIgnoreCase("sales manager")) {
            username = ConfigurationReader.getProperty("sales_manager_username");
            password = ConfigurationReader.getProperty("sales_manager_password");
        } else if (userType.equalsIgnoreCase("store manager")) {
            username = ConfigurationReader.getProperty("store_manager_username");
            password = ConfigurationReader.getProperty("store_manager_password");
        }
        //send username and password and login
        loginPage.login(username, password);
        Thread.sleep(5000);
    }

    @Then("user should not display {string} button")
    public void user_should_not_display_button(String string) throws InterruptedException {

        Thread.sleep(5000);
        fleetVehicles.moveToFleetMenu();
        Thread.sleep(3000);
        fleetVehicles.click_vehicle_menu();

        String createCar = "Create Car";

        List<WebElement> create = Driver.getDriver().findElements(By.xpath("//*[contains(text(),'Create Car')]"));

        int size = create.size();
        System.out.println(size);
        Assert.assertFalse(size >= 1);

    }

    @When("user logs in as a {string} with{string}")
    public void userLogsInAsAWith(String arg0, String arg1) throws InterruptedException {
        loginPage.username.sendKeys(arg0);
        loginPage.password.sendKeys(arg1);
        loginPage.loginButton.click();
        fleetVehicles.hoverOverFleetMenu();
        fleetVehicles.click_vehicle_menu();
        Thread.sleep(5000);

    }

    @Then("user displays {string} button page")
    public void userDisplaysButtonPage(String arg0) throws InterruptedException {
        Thread.sleep(5000);
        String expected = "Create Car";
        String actual = fleetVehicles.createCarBtnText();
        Assert.assertEquals(expected, fleetVehicles.createCarBtnText());
        Thread.sleep(5000);
    }

    @When("user logs in as a store manager with {string} with {string} credentials")
    public void userLogsInAsAStoreManagerWithWithCredentials(String arg0, String arg1) throws InterruptedException {
        loginPage.username.sendKeys(arg0);
        loginPage.password.sendKeys(arg1);
        loginPage.loginButton.click();
        fleetVehicles.hoverOverFleetMenu();
        fleetVehicles.click_vehicle_menu();
        Thread.sleep(5000);

    }

    @When("user logs in create car page after clicking crate car button")
    public void userLogsInCreateCarPageAfterClickingCrateCarButton() throws InterruptedException {
        loginPage.login("storemanager51", "UserUser123");
        fleetVehicles.hoverOverFleetMenu();
        fleetVehicles.click_vehicle.click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(fleetVehicles.createCarBtn));
        fleetVehicles.createCarBtn.click();

    }

    @Then("After clicking Create Car button should land on Create Car page")
    public void afterClickingCreateCarButtonShouldLandOnCreateCarPage() {
        String actual = fleetVehicles.createCarPAge.getText();
        String expected = "Create Car";
        Assert.assertEquals(expected, actual);
    }
}

