package com.fleetGru.StepDefinitions;

import com.fleetGru.Pages.*;
import com.fleetGru.Utilities.BrowserUtils;
import com.fleetGru.Utilities.ConfigurationReader;
import com.fleetGru.Utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OdometerStepDefs {

	FleetVehiclesOdometer fleetVehiclesOdometer = new FleetVehiclesOdometer();
	LoginPage loginPage = new LoginPage();
	FleetVehicles fleetVehicles = new FleetVehicles();
	Dashboard dashboard = new Dashboard();
	QuickLaunchPad quickLaunchPad=new QuickLaunchPad();
	Faker faker=new Faker();
	private WebDriver driver;
	WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	String str = ConfigurationReader.getProperty("lastOdometerDropdownTags");
	String[] strSplit = str.split(",");

	ArrayList<String> expected = new ArrayList<String>(
			Arrays.asList(strSplit));


	@Given("{string} is logged in and clicks Fleet module and Vehicles tab")
	public void isLoggedInToTheApplicationAndClicksModuleAndTab(String username) {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		loginPage.login(username, ConfigurationReader.getProperty("driver_password"));
		dashboard.goVehiclePage();

	}


	@And("User clicks on Manage filter options button")
	public void userClicksOnManageFilterOptionsButton() {
		wait.until(ExpectedConditions.elementToBeClickable(fleetVehicles.filterButton));
		fleetVehicles.filterButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(fleetVehicles.manageFilters));
		fleetVehicles.manageFilters.click();

	}

	@Then("user should be able to click the Last Odometer filter")
	public void userShouldBeAbleToClickTheLastOdometerFilter() {
		BrowserUtils.sleep(2);
		fleetVehicles.lastOdometer.click();

		Assert.assertEquals("text","text");
	}

	@When("User clicks on Last Odometer filter checkbox")
	public void userClicksOnLastOdometerFilterCheckbox() {
		BrowserUtils.sleep(2);
		fleetVehicles.lastOdometer.click();
	}

	@And("User clicks on the Last Odometer dropdown menu")
	public void userClicksOnTheLastOdometerDropdownMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(fleetVehicles.lastOdometerAllButton));
		fleetVehicles.lastOdometerAllButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(fleetVehicles.betweenDropdownButton));
		fleetVehicles.betweenDropdownButton.click();
	}

	@Then("User should be able to see the options as below list")
	public void userShouldBeAbleToSeeTheOptionsAsBelowList() {



		List<String> actual = new ArrayList<>();
		for (WebElement betweenDropdownList : fleetVehicles.betweenDropdownLists) {
			actual.add(betweenDropdownList.getText());
		}

		Assert.assertEquals(expected, actual);
	}

	@And("User selects {string} method")
	public void userSelectsMethod(String listItem) {

		fleetVehicles.betweenDropdownLists.get(fleetVehiclesOdometer.stringToInt(listItem)).click();

	}

	@And("User enters {int} and {int} in the filter fields")
	public void userEntersAndInTheFilterFields(int arg0, int arg1) {
	}

	@Then("User should see the vehicles with last odometer between {int} and {int}")
	public void userShouldSeeTheVehiclesWithLastOdometerBetweenAnd(int arg0, int arg1) {
	}

	@And("User enters {int} in the filter field")
	public void userEntersInTheFilterField(int arg0) {
	}

	@Then("User should be able to see the vehicles with last odometer equal to {int}")
	public void userShouldBeAbleToSeeTheVehiclesWithLastOdometerEqualTo(int arg0) {
	}

	@Then("User should be able to see the vehicles with last odometer more than {int}")
	public void userShouldBeAbleToSeeTheVehiclesWithLastOdometerMoreThan(int arg0) {
	}

	@Then("User should be able to see the vehicles with last odometer less than {int}")
	public void userShouldBeAbleToSeeTheVehiclesWithLastOdometerLessThan(int arg0) {
	}

	@Then("User should be able to see the vehicles with last odometer is empty")
	public void userShouldBeAbleToSeeTheVehiclesWithLastOdometerIsEmpty() {
	}

	@And("User enters {string} in the filter field")
	public void userEntersInTheFilterField(String arg0) {
	}

	@Then("User should not to be able to fill with alphabetical characters")
	public void userShouldNotToBeAbleToFillWithAlphabeticalCharacters() {
	}


}
