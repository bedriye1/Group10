package com.fleetGru.StepDefinitions;


import com.fleetGru.Pages.Dashboard;
import com.fleetGru.Pages.FleetVehicles;
import com.fleetGru.Pages.LoginPage;
import com.fleetGru.Pages.QuickLaunchPad;
import com.fleetGru.Utilities.BrowserUtils;
import com.fleetGru.Utilities.ConfigurationReader;
import com.fleetGru.Utilities.Driver;

import com.fleetGru.Pages.*;
import com.fleetGru.Utilities.*;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;

public class VehicleTableView_StepDefs {

    LoginPage loginPage = new LoginPage();
    Dashboard dashboard = new Dashboard();
    QuickLaunchPad quickLaunchPad = new QuickLaunchPad();
    FleetVehicles fleetVehicles = new FleetVehicles();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("The user enters {string} and  {string} and clicks login button")
    public void the_user_enters_and_and_clicks_login_button(String string, String string2) {
        loginPage.username.sendKeys(string);
        loginPage.password.sendKeys(string2);
        loginPage.loginButton.click();
    }

    @When("The user navigates to QuickLaunchpad Fleet-Vehicle page")
    public void the_user_navigates_to_quicklaunchpad_fleet_vehicle_page() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(quickLaunchPad.FleetsQuichLaunch));
        quickLaunchPad.FleetsQuichLaunch.click();
        BrowserUtils.sleep(1);
        quickLaunchPad.Vehicles.click();
    }

    @When("The user navigates to Dashboard Fleet-Vehicle page")
    public void the_user_navigates_to_dashboard_fleet_vehicle_page() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(dashboard.FleetDropDown));
        dashboard.FleetDropDown.click();
        BrowserUtils.sleep(1);
        dashboard.Vehicles.click();
    }

    @Then("The user sees all the vehicle information in a table")
    public void the_user_sees_all_the_vehicle_information_in_a_table() {
        BrowserUtils.sleep(3);
        int numberOfTableHeadersQuickLaunch = 19;
        int numberOfTableHeadersDashBoard = 21;
        boolean resultQuickLaunch = fleetVehicles.tableHeaders.size() == numberOfTableHeadersQuickLaunch;
        boolean resultDashboard = fleetVehicles.tableHeaders.size() == numberOfTableHeadersDashBoard;
        boolean emptyCell = true;

        for (WebElement eachCell : fleetVehicles.tableCells) {
            //System.out.println(eachCell.getText().length());
            if(eachCell.getText().length() == 0 ){
                emptyCell = false;
                break;
            }else{
                emptyCell = true;
            }
        }
        Assert.assertTrue(emptyCell);
    }

    @Then("User can see the total page number")
    public void user_can_see_the_total_page_number() {

        BrowserUtils.sleep(10);
        String totalPageNumberText = fleetVehicles.totalPageNumber.getText();
        char number = (char) totalPageNumberText.charAt(3);
        System.out.println(number); ///////
        List<Character> numbers = new ArrayList<>();
        numbers.add('1');
        numbers.add('2');
        numbers.add('3');
        numbers.add('4');
        numbers.add('5');
        numbers.add('6');
        numbers.add('7');
        numbers.add('8');
        numbers.add('9');
        numbers.add('0');

        boolean totalPageNumberExists = false;
        for (Character each : numbers) {
            if(each == number){
                totalPageNumberExists = true;
            }
        }
        System.out.println(totalPageNumberText);
        Assert.assertTrue(totalPageNumberExists);
    }

    @When("The user clicks on the forward {string} button")
    public void the_user_clicks_on_the_button(String string) {
        BrowserUtils.sleep(5);
        fleetVehicles.forwardButton.click();
        BrowserUtils.sleep(5);
    }

    @Then("Verify seeing the next page of the table")
    public void verify_seeing_the_next_page_of_the_table() {
        String pageNumb = fleetVehicles.pageNumber.getAttribute("value");
        Assert.assertEquals(pageNumb, "2");
    }


    @When("The user clicks on the back {string} button")
    public void the_user_clicks_on_the_back_button(String string) {
        BrowserUtils.sleep(5);
        fleetVehicles.backButton.click();
        BrowserUtils.sleep(5);

    }

    @Then("Verify seeing the previous page of the table")
    public void verify_seeing_the_previous_page_of_the_table() {
        String pageNumb = fleetVehicles.pageNumber.getAttribute("value");
        Assert.assertEquals(pageNumb, "1");
    }

    @Then("Verify user can see total recordings of vehicles")
    public void user_can_see_total_recordings_of_vehicles() {
        String totalVehicleText = fleetVehicles.totalVehiclesText.getText();
        Assert.assertEquals(totalVehicleText, "Total Of 108 Records");
    }

    @When("The user clicks on the {string} link")
    public void the_user_clicks_on_the_link(String string) {
        WebElement exportGridButton = fleetVehicles.ExportGridButton;
        exportGridButton.click();
        WebElement xlsxButton = fleetVehicles.xlsxButton;
        xlsxButton.click();
    }

    @Then("Verify table data is downloaded in XLS or CSV format")
    public void verify_table_data_is_downloaded_in_xls_or_csv_format() {
        String messageExpected = "Export started successfully. You will receive email notification upon completion.";
        String actual = fleetVehicles.ExportGridConfirmationMessage.getText();
        System.out.println("actual = " + actual);
        Assert.assertEquals(messageExpected, actual);
    }
}
