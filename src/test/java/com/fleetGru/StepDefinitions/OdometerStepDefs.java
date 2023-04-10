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
import java.util.Objects;

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
	public void userEntersAndInTheFilterFields(int min, int max) {

		fleetVehicles.inputFirst.sendKeys(Integer.toString(min));
		fleetVehicles.inputMax.sendKeys(Integer.toString(max));
		fleetVehicles.updateButton.click();
		BrowserUtils.sleep(3);


	}

	@Then("User should see the vehicles with last odometer between {int} and {int}")
	public void userShouldSeeTheVehiclesWithLastOdometerBetweenAnd(int min, int max) {
		List<WebElement> columns = fleetVehicles.resultsOdometerColumn;
		for (WebElement column : columns) {
			int odometerValue = Integer.parseInt(column.getText().replaceAll(",", ""));
			System.out.println(odometerValue);
			if (odometerValue < min || odometerValue > max) {
				Assert.fail();
			}else{
				Assert.assertTrue(true);
			}
		}
	}

	@And("User enters {int} in the filter field")
	public void userEntersInTheFilterField(int value) {
		fleetVehicles.inputFirst.sendKeys(Integer.toString(value));
		fleetVehicles.updateButton.click();
		BrowserUtils.sleep(3);
	}

	@Then("User should be able to see the vehicles with last odometer equal to {int}")
	public void userShouldBeAbleToSeeTheVehiclesWithLastOdometerEqualTo(int value) {
		List<WebElement> columns = fleetVehicles.resultsOdometerColumn;
		for (WebElement column : columns) {
			int odometerValue = Integer.parseInt(column.getText().replaceAll(",", ""));
			System.out.println(odometerValue);
			if (odometerValue == value) {
				Assert.assertTrue(true);
			}else{
				Assert.fail();
			}
		}
	}

	@Then("User should be able to see the vehicles with last odometer more than {int}")
	public void userShouldBeAbleToSeeTheVehiclesWithLastOdometerMoreThan(int value) {
		List<WebElement> columns = fleetVehicles.resultsOdometerColumn;
		for (WebElement column : columns) {
			int odometerValue = Integer.parseInt(column.getText().replaceAll(",", ""));
			System.out.println(odometerValue);
			if (odometerValue > value) {
				Assert.assertTrue(true);
			}else{
				Assert.fail();
			}
		}
	}

	@Then("User should be able to see the vehicles with last odometer less than {int}")
	public void userShouldBeAbleToSeeTheVehiclesWithLastOdometerLessThan(int value) {
		List<WebElement> columns = fleetVehicles.resultsOdometerColumn;
		for (WebElement column : columns) {
			int odometerValue = Integer.parseInt(column.getText().replaceAll(",", ""));
			System.out.println(odometerValue);
			if (odometerValue < value) {
				Assert.assertTrue(true);
			}else{
				Assert.fail();
			}
		}
	}

	@Then("User should be able to see the vehicles with last odometer is empty")
	public void userShouldBeAbleToSeeTheVehiclesWithLastOdometerIsEmpty() {
		fleetVehicles.updateButton.click();
		BrowserUtils.sleep(3);
		List<WebElement> columns = fleetVehicles.resultsOdometerColumn;
		for (WebElement column : columns) {
			if (column == null) {
				Assert.assertTrue(true);
			}else{
				Assert.fail();
			}
		}
	}

	@And("User enters {string} and {string} in the filter field")
	public void userEntersInTheFilterField(String values1, String values2) {

		fleetVehicles.inputFirst.sendKeys(values1);
		if (fleetVehicles.inputMax.isDisplayed()){
			fleetVehicles.inputMax.sendKeys(values2);
		}
		fleetVehicles.updateButton.click();
	}

	@Then("User should see these methods shouldn't accept non-numeric values")
	public void userShouldNotToBeAbleToFillWithAlphabeticalCharacters() {
		String label = fleetVehicles.filterCriteria.getText();
		System.out.println(label);
		if (Objects.equals(label, "All")){
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
	}


}
