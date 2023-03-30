package com.fleetGru.StepDefinitions;

import com.fleetGru.Pages.*;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.html.FormSubmitEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class CreateBtnStepDefinitions extends BasePage {

    LoginPage loginPage = new LoginPage();
    Dashboard dashboard = new Dashboard();
    QuickLaunchPad quickLaunchPad = new QuickLaunchPad();
    FleetVehicles fleetVehicles = new FleetVehicles();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("Verify {string} on the dashboard page")
    public void verify_on_the_dashboard_page(String userType) {

        //go to login page
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        //based on input enter that user information

    }

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
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
        BrowserUtils.waitForPageToLoad(5);
        fleetVehicles.login(username, password);
        BrowserUtils.waitForPageToLoad(10);

    }

    @Then("user should not display {string} button")
    public void user_should_not_display_button(String string) throws InterruptedException {

        Thread.sleep(5000);
        fleetVehicles.moveToFleetMenu();
        BrowserUtils.waitForClickablility(fleetVehicles.element_Fleet_Menu,5);
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
        //waitUntilLoaderScreenDisappear();
        fleetVehicles.username.sendKeys(arg0);
        fleetVehicles.password.sendKeys(arg1);
        fleetVehicles.loginButton.click();
        BrowserUtils.waitForPageToLoad(10);
        fleetVehicles.hoverOverFleetMenu();
        fleetVehicles.click_vehicle_menu();
        BrowserUtils.waitForPageToLoad(10);
        //waitUntilLoaderScreenDisappear();
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
        fleetVehicles.username.sendKeys(arg0);
        fleetVehicles.password.sendKeys(arg1);
        BrowserUtils.waitForClickablility(fleetVehicles.loginButton,5);
        fleetVehicles.loginButton.click();
        fleetVehicles.hoverOverFleetMenu();
        fleetVehicles.click_vehicle_menu();
        Thread.sleep(8000);

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
        waitUntilLoaderScreenDisappear();
    }

    @Then("After clicking Create Car button should land on Create Car page")
    public void afterClickingCreateCarButtonShouldLandOnCreateCarPage() {
        String actual = fleetVehicles.createCarPAge.getText();
        String expected = "Create Car";
        Assert.assertEquals(expected, actual);
    }

    @Given("I am on the Create Car page")
    public void iAmOnTheCreateCarPage() throws InterruptedException {
        BrowserUtils.waitForPageToLoad(5);
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
        BrowserUtils.waitForPageToLoad(1);
        fleetVehicles.driver.sendKeys(driver);

    }

    @And("I fill in the Location field with {string}")
    public void iFillInTheLocationFieldWith(String location) {
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
/*
    @And("I fill in the Immatriculation Date field with {string} {string} {string}")
    public void iFillInTheImmatriculationDateFieldWith(String month, String day, String year) {
        fleetVehicles.ımmactriculation.click();
        List<WebElement> month1 = Driver.getDriver().findElements(By.xpath("//select[@class='ui-datepicker-month']/option"));
        for (WebElement each1 : month1) {
            if (each1.getText().equals(month)) {
                each1.click();
            }
        }
        List<WebElement>year1 = Driver.getDriver().findElements(By.xpath("//select[@class='ui-datepicker-year']/option"));
        for (WebElement each : year1) {
            if (each.getText().equals(year)){
                each.click();
            }
        }
    }
*/


    @And("I fill in the Immatriculation Date field with {string}")
    public void iFillInTheImmatriculationDateFieldWith(String date) {
        fleetVehicles.ımmactriculation.click();
        fleetVehicles.date1Btn.click();

    }

    @And("I fill in the First Contract Date field with {string}")
    public void iFillInTheFirstContractDateFieldWith(String arg0) {
        fleetVehicles.firstContactDate.click();
        fleetVehicles.date2Btn.click();

    }

    @And("I fill in the Catalog Value $ field with {string}")
    public void iFillInTheCatalogValue$FieldWith(String value) {
        fleetVehicles.catalogValue.sendKeys(value);
    }

    @And("I fill in the Seat Number field with {string}")
    public void iFillInTheSeatNumberFieldWith(String seatNumber) {
        fleetVehicles.seatNumber.sendKeys(seatNumber);
    }

    @And("I fill in the Doors Number field with {string}")
    public void iFillInTheDoorsNumberFieldWith(String doorNum) {
        fleetVehicles.doorNumber.sendKeys(doorNum);
    }

    @And("I fill in the Colour field with {string}")
    public void iFillInTheColourFieldWith(String colour) {
        fleetVehicles.colour.sendKeys(colour);
    }

    @And("I select {string} in the Transmission field")
    public void iSelectInTheTransmissionField(String automatic) {
        BrowserUtils.waitFor(2);
        fleetVehicles.transmission.click();
        /*
         Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        List<WebElement> months = select.getOptions();
        for (WebElement each : months) {
            if (each.getText().equals(month)) {
                each.click();
            }
         */
        BrowserUtils.waitFor(2);
        // Select select = new Select( Driver.getDriver().findElements(By.xpath("//select[@id='custom_entity_type_Transmission-uid-64232c9200dbb']")));
        List<WebElement> transmission1 = Driver.getDriver().findElements(By.xpath("//select[@name='custom_entity_type[Transmission]']/option"));
        for (WebElement each1 : transmission1) {
            if (each1.getText().equals(automatic)) {
                each1.click();
            }
        }

    }

    @And("I select {string} in the Fuel Type field")
    public void iSelectInTheFuelTypeField(String fuelType) {
        fleetVehicles.gasoline.click();

        List<WebElement> fuel = Driver.getDriver().findElements(By.xpath("//select[@name='custom_entity_type[FuelType]']/option"));
        for (WebElement each : fuel) {
            if (each.getText().equals(fuelType)) {
                each.click();
            }
        }
    }

    @And("I fill in the CO{int} Emissions field with {string}")
    public void iFillInTheCOEmissionsFieldWith(int arg0, String coEmission) {
        fleetVehicles.cOemission.sendKeys(coEmission);
    }

    @And("I fill in the Horsepower field with {string}")
    public void iFillInTheHorsepowerFieldWith(String horsePower) {
        actions.moveToElement(fleetVehicles.horsePower).perform();
        fleetVehicles.horsePower.sendKeys(horsePower);
    }

    @And("I fill in the Horsepower Taxation field with {string}")
    public void iFillInTheHorsepowerTaxationFieldWith(String horsepowerTaxation) {
        fleetVehicles.horsePowerTaxation.sendKeys(horsepowerTaxation);
    }

    @And("I fill in the Power \\(KW) field with {string}")
    public void iFillInThePowerKWFieldWith(String power) {
        fleetVehicles.power.sendKeys(power);
        BrowserUtils.waitFor(2);
    }


    @And("I select the {string} option")
    public void iSelectTheOption(String saveType) {


        actions.moveToElement(fleetVehicles.saveDropdown).perform();
        fleetVehicles.saveDropdown.click();
        BrowserUtils.waitFor(2);
        List<WebElement> d = Driver.getDriver().findElements(By.xpath("//button[@type='submit']"));
        for (WebElement each : d) {
            if (each.getText().equals(saveType)) {
                each.click();
            }
        }
        BrowserUtils.waitFor(2);
    }

    @Then("the form data should be saved and the same page should remain the form data should be retained")
    public void theFormDataShouldBeSavedAndTheSamePageShouldRemainTheFormDataShouldBeRetained() {
        Assert.assertEquals(fleetVehicles.beforeSave.getText(), fleetVehicles.afterSave.getText());
    }

    @And("I select a JPEG or PNG file for the Logo field, or leave it blank")
    public void iSelectAJPEGOrPNGFileForTheLogoFieldOrLeaveItBlank() throws FileNotFoundException {

        String upload = ConfigurationReader.getProperty("uploadFile");
        // fleetVehicles.uploadFile.click();

        fleetVehicles.uploadFile.sendKeys(upload + Keys.ENTER);
    }

    @Given("I am on the form page")
    public void iAmOnTheFormPage() throws InterruptedException {
        BrowserUtils.waitForPageToLoad(5);
        fleetVehicles.ToReachCreateCarBtnPage();
        BrowserUtils.waitForPageToLoad(5);


    }

    @Then("the message {string} should be displayed")
    public void the_message_should_be_displayed(String string) {
        Assert.assertEquals(string, fleetVehicles.flashMessage.getText());
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String string) {

        Assert.assertEquals(fleetVehicles.generalInfoPage.getText(), string);
    }


}




        /*
    @And("I fill in the Immatriculation Date field with {string} {string} {string}")
    public void iFillInTheImmatriculationDateFieldWith(String month, String date, String year) {



        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        List<WebElement> months = select.getOptions();
        for (WebElement each : months) {
            if (each.getText().equals(month)) {
                each.click();
            }
        }

        Select select1 = new Select(Driver.getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        List<WebElement> years = select1.getOptions();
        for (WebElement each1 : years) {
            if (each1.getText().equals(year)) {
                each1.click();
            }

        }


        List<WebElement> month1 = Driver.getDriver().findElements(By.xpath("//select[@class='ui-datepicker-month']/option"));
        for (WebElement each1 : month1) {
            if (each1.getText().equals(month)) {
                each1.click();
            }
        }
        //BrowserUtils.waitFor(5);
        //Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']/option")));
        List<WebElement> year1 = Driver.getDriver().findElements(By.xpath("//select[@class='ui-datepicker-year']/option"));
        // select.selectByValue(year);
        for (WebElement each : year1) {
            //  System.out.println(each.getText());

            if (each.getText().equals(year)) {
                System.out.println(each.getText());
                // each.click();

            }

        }

*/

         /*
    @And("I select a JPEG or PNG file for the Logo field, or leave it blank")
    public void iSelectAJPEGOrPNGFileForTheLogoFieldOrLeaveItBlank() throws FileNotFoundException {

       String upload=ConfigurationReader.getProperty("uploadFile");
       // fleetVehicles.uploadFile.click();
        BrowserUtils.waitFor(2);
        fleetVehicles.uploadFile.sendKeys(upload+Keys.ENTER);

*/




















