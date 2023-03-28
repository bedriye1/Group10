package com.fleetGru.StepDefinitions;

import com.fleetGru.Pages.*;
import com.fleetGru.Utilities.BrowserUtils;
import com.fleetGru.Utilities.ConfigurationReader;
import com.fleetGru.Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
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
        BrowserUtils.waitFor(5);
        fleetVehicles.hoverOverFleetMenu();
        BrowserUtils.waitFor(5);
        fleetVehicles.click_vehicle.click();
        Thread.sleep(5000);
        BrowserUtils.waitFor(5);
        fleetVehicles.createCarBtn.click();

    }

    @Then("After clicking Create Car button should land on Create Car page")
    public void afterClickingCreateCarButtonShouldLandOnCreateCarPage() {
        String actual = fleetVehicles.createCarPAge.getText();
        String expected = "Create Car";
        Assert.assertEquals(expected, actual);
    }

    @Given("I am on the Create Car page")
    public void iAmOnTheCreateCarPage() throws InterruptedException {
        fleetVehicles.ToReachCreateCarBtnPage();
        BrowserUtils.waitForPageToLoad(5);

    }

    @When("I fill in the License Plate field with {string}")
    public void i_fill_in_the_license_plate_field_with(String licencePlate) throws InterruptedException {
        BrowserUtils.waitForPageToLoad(5);
        fleetVehicles.licencePlate.sendKeys(licencePlate);
    }


    @And("Checked  the  all Tags")
    public void checkedTheAllTags() throws InterruptedException {
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.clickWithJS(fleetVehicles.junior);
        BrowserUtils.clickWithJS(fleetVehicles.senior);
        BrowserUtils.clickWithJS(fleetVehicles.employeeCar);
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.clickWithJS(fleetVehicles.purchased);
        BrowserUtils.clickWithJS(fleetVehicles.compact);
        BrowserUtils.clickWithJS(fleetVehicles.sedan);
        BrowserUtils.clickWithJS(fleetVehicles.convertible);

    }

    @And("I fill in the Driver field with {string}")
    public void iFillInTheDriverFieldWith(String driver) {
        BrowserUtils.waitForPageToLoad(5);
        fleetVehicles.driver.sendKeys(driver);

    }

    @And("I fill in the Location field with {string}")
    public void iFillInTheLocationFieldWith(String location) {
        BrowserUtils.waitFor(5);
        fleetVehicles.location.sendKeys(location);
    }

    @And("I fill in the Chassis Number field with {string}")
    public void iFillInTheChassisNumberFieldWith(String chasis) {
        fleetVehicles.chasisNumber.sendKeys(chasis);
    }

    @And("I fill in the Model Year field with {string}")
    public void iFillInTheModelYearFieldWith(String year) {
        fleetVehicles.modelYear.sendKeys(year);
    }

    @And("I fill in the Last Odometer field with {string}")
    public void iFillInTheLastOdometerFieldWith(String odoMeter) {
        fleetVehicles.lastOdometre.sendKeys(odoMeter);
    }

    @And("I fill in the Immatriculation Date field with {int} {int}, {int}")
    public void iFillInTheImmatriculationDateFieldWith(int month, int date, int year) {


        Select month1 = new Select(fleetVehicles.month);
        List<WebElement> monthselect = new ArrayList<>();
        //Select(Driver.getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']");
        Select date1 = (Select) Driver.getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select year1 = (Select) Driver.getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']"));

        month1.selectByVisibleText(String.valueOf(month));
        for (WebElement selectMonth : monthselect) {
            if (selectMonth.getText().equals(month)){
                selectMonth.click();
            }
        }

        List<WebElement> dateSelector = Driver.getDriver().findElements(By.xpath("//table[@class='ui-datepicker-calendar']"));
        //List<WebElement>monthSelector = Driver.getDriver().findElements(By.xpath("//select[@class='ui-datepicker-month']"));
        //List<WebElement>yearSelector = Driver.getDriver().findElements(By.xpath("//select[@class='ui-datepicker-year']"));

        if (dateSelector.equals(date)) {
            dateSelector.get(date).click();
            BrowserUtils.waitFor(5);
        }


        //monthSelector.get(month);
        //yearSelector.get(year);


        //date1.selectByValue(String.valueOf(date));
        year1.selectByValue(String.valueOf(year));


    }

    @And("I fill in the Immatriculation Date field with {string}")
    public void iFillInTheImmatriculationDateFieldWith(String d) {
       // fleetVehicles.ımmactriculationDate.sendKeys(d+Keys.ESCAPE);
    }

    @And("I fill in the First Contract Date field with {string}")
    public void iFillInTheFirstContractDateFieldWith(String f) {
      //  fleetVehicles.firstContactdate.sendKeys(f+Keys.ESCAPE);
    }






    @And("I fill in the Catalog Value $ field with {string}")
    public void iFillInTheCatalogValue$FieldWith(String arg0) {
        fleetVehicles.catalogValue.sendKeys(arg0);
    }
}

