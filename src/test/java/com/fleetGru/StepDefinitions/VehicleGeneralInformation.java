package com.fleetGru.StepDefinitions;

import com.fleetGru.Pages.Dashboard;
import com.fleetGru.Pages.FleetVehicles;
import com.fleetGru.Pages.LoginPage;
import com.fleetGru.Pages.QuickLaunchPad;
import com.fleetGru.Utilities.BrowserUtils;
import com.fleetGru.Utilities.ConfigurationReader;
import com.fleetGru.Utilities.Driver;
import com.github.javafaker.Bool;
import com.google.common.base.Predicates;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class VehicleGeneralInformation {

    Dashboard dashboard = new Dashboard();
    FleetVehicles fleetVehicles = new FleetVehicles();
    LoginPage loginPage = new LoginPage();
    QuickLaunchPad quickLaunchPad = new QuickLaunchPad();

    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


    @Given("User on the Fleet-Vehicle page")
    public void user_on_the_fleet_vehicle_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.username.sendKeys(ConfigurationReader.getProperty("driver_username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("driver_password"));
        loginPage.loginButton.click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(quickLaunchPad.FleetsQuichLaunch));
        quickLaunchPad.FleetsQuichLaunch.click();
        BrowserUtils.sleep(1);
        quickLaunchPad.Vehicles.click();
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitFor(3);


    }
    @When("User clicks any vehicle \\(row)")
    public void user_clicks_any_vehicle_row() {
    quickLaunchPad.firstCell.click();


    }

    @When("User clicks on the Eye \\(View) icon at the end of each row")
    public void user_clicks_on_the_eye_view_icon_at_the_end_of_each_row() {

        actions.moveToElement(dashboard.firstThreePoint).perform();
        dashboard.threePointView.click();



    }
    @Then("User can see the General Information page")
    public void user_can_see_the_general_information_page() {

        Assert.assertTrue(quickLaunchPad.generalInformationPage.getText().equals("General Information"));

    }

    @Given("Sales manager on the Fleet-Vehicle page")
    public void sales_manager_on_the_fleet_vehicle_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.username.sendKeys(ConfigurationReader.getProperty("sales_manager_username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("sales_manager_password"));
        loginPage.loginButton.click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(dashboard.DashboardText));
        dashboard.FleetDropDown.click();
        BrowserUtils.sleep(1);
        dashboard.Vehicles.click();
        BrowserUtils.waitForPageToLoad(10);

    }
    @When("Sales manager clicks a row for go to General Information page")
    public void sales_manager_clicks_a_row_for_go_to_general_information_page() {
        quickLaunchPad.firstCell.click();
    }
    @Then("Sales manager can see {string}, {string} and {string} buttons on the General Information page")
    public void sales_manager_can_see_and_buttons_on_the_general_information_page(String string, String string2, String string3) {
        dashboard.editButtonGeneralInformationPage.isDisplayed();
        dashboard.addEventButtonGeneralInformationPage.isDisplayed();
        dashboard.deleteButtonGeneralInformationPage.isDisplayed();

    }

    @Given("Store manager on the Fleet-Vehicle page")
    public void store_manager_on_the_fleet_vehicle_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.username.sendKeys(ConfigurationReader.getProperty("store_manager_username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("store_manager_password"));
        loginPage.loginButton.click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(dashboard.DashboardText));
        dashboard.FleetDropDown.click();
        BrowserUtils.sleep(1);
        dashboard.Vehicles.click();
        BrowserUtils.waitForPageToLoad(10);
    }
    @When("Store manager clicks a row for go to General Information page")
    public void store_manager_clicks_a_row_for_go_to_general_information_page() {
        quickLaunchPad.firstCell.click();
    }

    @Then("Store manager can see {string}, {string} and {string} buttons on the General Information page")
    public void store_manager_can_see_and_buttons_on_the_general_information_page(String string, String string2, String string3) {
        dashboard.editButtonGeneralInformationPage.isDisplayed();
        dashboard.addEventButtonGeneralInformationPage.isDisplayed();
        dashboard.deleteButtonGeneralInformationPage.isDisplayed();

    }



    @Given("Driver on the Fleet-Vehicle page")
    public void driver_on_the_fleet_vehicle_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.username.sendKeys(ConfigurationReader.getProperty("driver_username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("driver_password"));
        loginPage.loginButton.click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(quickLaunchPad.FleetsQuichLaunch));
        quickLaunchPad.FleetsQuichLaunch.click();
        BrowserUtils.waitForPageToLoad(10);
        quickLaunchPad.Vehicles.click();
        BrowserUtils.waitForPageToLoad(10);
    }
    @When("Driver clicks a row for go to General Information page")
    public void driver_clicks_a_row_for_go_to_general_information_page() {
        quickLaunchPad.firstCell.click();
    }


    @Then("Driver can't see {string}, {string} and {string} buttons on the General Information page")
    public void driver_can_t_see_and_buttons_on_the_general_information_page(String string, String string2, String string3) {
        dashboard.editButtonGeneralInformationPage.isDisplayed();
        quickLaunchPad.addEventGeneralInformationPage.isDisplayed();
        dashboard.deleteButtonGeneralInformationPage.isDisplayed();

    }


    @Then("User sees same information about vehicle Fleet-Vehicle page and General Information Page")
    public void userSeesSameInformationAboutVehicleFleetVehiclePageAndGeneralInformationPage() {

        ArrayList <String> fleetVehiclePage = new ArrayList<String>();
        ArrayList <String> generalInformationPage = new ArrayList<String>();


        for (int i = 1; i < 26; i++) {
            for (int j = 1; j < 21; j++) {
                String cell = "//div/table/tbody/tr["+i+"]/td["+j+"]";
                fleetVehiclePage.add(Driver.getDriver().findElement(By.xpath(cell)).getText());

            }
            Driver.getDriver().findElement(By.xpath("//div/table/tbody/tr["+i+"]/td[2]")).click();
            BrowserUtils.waitForPageToLoad(100);
            for (int n = 1; n <23 ; n++) {
                String pathGeneral = "//div[@id=\"container\"]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div["+n+"]/div/div";
                generalInformationPage.add(Driver.getDriver().findElement(By.xpath(pathGeneral)).getText());

            }
            System.out.println(fleetVehiclePage);
            System.out.println(generalInformationPage);

            Boolean compare = generalInformationPage.equals(fleetVehiclePage);
            System.out.println(compare);
            Assert.assertTrue(compare);

            fleetVehiclePage.clear();
            generalInformationPage.clear();

            Driver.getDriver().navigate().back();
            BrowserUtils.waitForPageToLoad(300);

        }
    }
}
