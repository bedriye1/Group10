package com.fleetGru.StepDefinitions;

import com.fleetGru.Pages.FleetVehicles;
import com.fleetGru.Pages.LoginPage;
import com.fleetGru.Pages.QuickLaunchPad;
import com.fleetGru.Utilities.BrowserUtils;
import com.fleetGru.Utilities.ConfigurationReader;
import com.fleetGru.Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TagsFilerStepDefinitions {

    FleetVehicles fleetVehicles = new FleetVehicles();
    QuickLaunchPad quickLaunchPad = new QuickLaunchPad();
    LoginPage loginPage = new LoginPage();


    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    Actions actions = new Actions(Driver.getDriver());

    @Given("The user logs in with credential username {string} and password {string}")
    public void the_user_logs_in_with_credential_username_and_password(String string, String string2) {
        //Go to login page

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        //Call the method in order to log in with credentials
        loginPage.login(string, string2);
    }

    @Then("The user navigates to Fleet-Vehicle page")
    public void the_user_navigates_to_fleet_vehicle_page() {
        wait.until(ExpectedConditions.visibilityOf(quickLaunchPad.FleetsQuichLaunch));
        quickLaunchPad.FleetsQuichLaunch.click();
        BrowserUtils.sleep(1);
        quickLaunchPad.Vehicles.click();
    }

    // < ------------------------------------------------------- > //

    @When("User clicks to filter icon button")
    public void user_clicks_to_filter_icon_button() {
        //Click the filterButton
        fleetVehicles.filterButton.click();
    }

    @When("User able to see {string}")
    public void user_able_to_see(String expectedText) {

        //Check the text
        Assert.assertEquals(fleetVehicles.manageFilters.getText(), expectedText);
        fleetVehicles.manageFilters.click();
    }

    @Then("User able to clicks to Tags")
    public void user_able_to_clicks_to() {
        //Click the Tags button
        fleetVehicles.tagsButton.click();
    }

    // < ------------------------------------------------------- > //

    @When("User click Tags: All")
    public void user_click_tags_all() {
        steps(); //Call the steps method in order to not recode the back-steps

        //Click the tagsAll button
        wait.until(ExpectedConditions.visibilityOf(fleetVehicles.tagsAll)).click();
    }

    @When("User clicks Is Any Of")
    public void user_click() {
        //Click the dropDownToggleButton
        fleetVehicles.dropDownToggleButton.click();
        BrowserUtils.sleep(2);
    }

    @Then("User should able to see {string} and {string} options")
    public void user_should_able_to_see_and_options(String string, String string2) {

        //Create a list in order to collect the options of the list
        List<WebElement> opt = Driver.getDriver().findElements(By.xpath("//div[@class='btn-group btn-block open']//ul"));

        //Create a list in order to collect the strings
        List<String> stringList = new ArrayList<>(Arrays.asList(string, string2));

        //Compare the text each other in a loop
        for (int i = 0; i < opt.size(); i++) {
            Assert.assertEquals(opt.get(i).getText(), stringList.get(i));
        }
    }

    // < ------------------------------------------------------- > //

    @When("User selects Is Any Of method")
    public void user_selects_is_any_of_method() {
        steps(); // Call the method
        BrowserUtils.sleep(2);
        fleetVehicles.isAnyOfButton.click();

    }

    @And("User entries {string} to search box")
    public void user_entries_compact_to_search_box(String compact) {
        fleetVehicles.chooseValuesInputBox.sendKeys(compact);
        actions.moveToElement(fleetVehicles.compactOption).click().perform();
        actions.moveToElement(fleetVehicles.updateButton).click().perform();
    }

    @Then("User able to see {string} corresponding value on the table")
    public void user_able_to_see_corresponding_value_on_the_table(String compact) {
        BrowserUtils.sleep(3);
        List<WebElement> eachTagsValue = Driver.getDriver().findElements(By.xpath("//ul[@class='unstyled options']"));
        System.out.println(eachTagsValue.size()); //See the size of the list

        for (WebElement webElement : eachTagsValue) {
            Assert.assertEquals(compact.toLowerCase(), webElement.getText().toLowerCase());
        }
    }

    // < ----------------------------- < METHODS > ----------------------------- > //
    public void steps() {
        wait = new WebDriverWait(Driver.getDriver(), 10);
        List<WebElement> eachClickOpt = new ArrayList<>(Arrays.asList(fleetVehicles.filterButton
                , fleetVehicles.manageFilters
                , fleetVehicles.tagsButton
                , fleetVehicles.tagsAll
                , fleetVehicles.dropDownToggleButton));

        for (WebElement webElement : eachClickOpt) {
            webElement.click();
            BrowserUtils.sleep(2);
        }
    }

}
