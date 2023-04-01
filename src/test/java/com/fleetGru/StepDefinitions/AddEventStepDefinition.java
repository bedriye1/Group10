package com.fleetGru.StepDefinitions;

import com.fleetGru.Pages.*;
import com.fleetGru.Utilities.BrowserUtils;

import com.fleetGru.Utilities.Driver;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AddEventStepDefinition {



    public class AddEventStepDefinitions extends BasePage {
Addevent_2Page addevent_2Page=new Addevent_2Page();
        AddEventPage addEventPage=new AddEventPage();
        Dashboard dashboard = new Dashboard();
        QuickLaunchPad quickLaunchPad=new QuickLaunchPad();


        @When("User can go to fleet dropdown")
        public void userCanGoToFleetDropdown() {
            waitUntilLoaderScreenDisappear();
            BrowserUtils.sleep(5);
            dashboard.FleetDropDown.click();

        }

        @And("User click the Vehicles modules")
        public void userClickTheVehiclesModules() {
            dashboard.Vehicles.click();
            BrowserUtils.sleep(5);
        }



        @Then("User click the add event button")
        public void user_click_the_add_event_button() {
            BrowserUtils.sleep(5);
            WebElement addEvent = Driver.getDriver().findElement(By.xpath("//a[@title='Add an event to this record']"));
            addEvent.click();
            BrowserUtils.sleep(5);
        }

        @When("User can go to Fleet module")
        public void userCanGoToFleetModule() {
            quickLaunchPad.FleetDropDown.click();
        }

        @And("User click the Vehicles module")
        public void userClickTheVehiclesModule() {
            quickLaunchPad.Vehicles.click();
        }



        @Then("User can not see the add event button")
        public void userCanNotSeeTheAddEventButton() {
            WebElement driverAddEventButton=addEventPage.driverAddButton;
            Assert.assertTrue(driverAddEventButton.isEnabled());
          //  Assert.assertTrue(driverAddEventButton.isDisplayed());
        }


        @Then("User can access the Add Event page")
        public void userCanAccessTheAddEventPage() {
            BrowserUtils.sleep(5);
            WebElement addEvent = Driver.getDriver().findElement(By.xpath("//a[@title='Add an event to this record']"));
            addEvent.click();
            BrowserUtils.sleep(5);
           // Assert.assertTrue(addEvent.isEnabled());
        }

        @Then("User can see {string} pop up")
        public void userCanSeePopUp(String arg0) {
            WebElement popUp=Driver.getDriver().findElement(By.xpath("//fieldset[@class='form form-horizontal']"));
            Assert.assertTrue(popUp.isDisplayed());
            Assert.assertEquals(arg0,popUp.getText());
        }

        @Then("Compulsory fields are shown as below")
        public void compulsoryFieldsAreShownAsBelow(List<String> expected) {

            List<WebElement> fields=addEventPage.addEventPopUp;
            List<String> actual=new ArrayList<>();
            for (WebElement field : fields) {
                actual.add(field.getText());
            }
            Assert.assertEquals(expected,actual);

        }

        @And("User click save button without filling {string} field")
        public void userClickSaveButtonWithoutFillingField(String arg0) {
            addEventPage.saveButton.click();
        }

        @Then("User should see {string} message")
        public void userShouldSeeMessage(String expected) {
            String actual=addEventPage.message.getText();
            Assert.assertEquals(actual,expected);
        }

        @Then("User should see {string} message after clicking save button")
        public void userShouldSeeMessageAfterClickingSaveButton(String expected) {
            WebElement actual=addEventPage.message;
            Assert.assertTrue(actual.isDisplayed());
            Assert.assertEquals(expected,actual);
        }

        @And("User click save button without filling compulsory fields \\(without Title field)")
        public void userClickSaveButtonWithoutFillingCompulsoryFieldsWithoutTitleField() {
            addEventPage.organizerDisplayGame.sendKeys("John D");
            addEventPage.saveButton.click();
        }


    }



}
