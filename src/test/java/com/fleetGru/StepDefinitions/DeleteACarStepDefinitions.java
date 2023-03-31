package com.fleetGru.StepDefinitions;





import com.fleetGru.Pages.*;
import com.fleetGru.Utilities.BrowserUtils;
import com.fleetGru.Utilities.ConfigurationReader;
import com.fleetGru.Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.module.Configuration;
import java.util.List;

public class DeleteACarStepDefinitions {
    LoginPage loginPage = new LoginPage();
    FleetVehicles fleetVehicles = new FleetVehicles();
    Dashboard dashboard = new Dashboard();
    GeneralInformationPage generalInformationPage = new GeneralInformationPage();

    @When("The user enters with valid {string} and password and clicks login button")
    public void theUserEntersValidUsernameAndPasswordAndClicksLoginButton(String username) {

        loginPage.login(username, ConfigurationReader.getProperty("driver_password"));
    }

    @And("The user navigates to Fleet-Vehicles page-for all users")
    public void theUserNavigatesToFleetVehiclePageForAllUsers() {

        dashboard.goVehiclePage();
    }


    @Then("The user hover over the three dots and able to see delete button")
    public void theUserHoverOverTheThreeDotsAndAbleToSeeDeleteButton() {

        BrowserUtils.scrollToElement(fleetVehicles.threeDotsEndOfRaw);
        BrowserUtils.sleep(3);
        BrowserUtils.hover(fleetVehicles.threeDotsEndOfRaw);
        BrowserUtils.waitForVisibility(fleetVehicles.deleteButton, 10);
        Assert.assertTrue(fleetVehicles.deleteButton.isDisplayed());

    }

    @And("The user clicks the delete button")
    public void theUserClicksTheDeleteButton() {

        BrowserUtils.scrollToElement(fleetVehicles.threeDotsEndOfRaw);
        BrowserUtils.sleep(3);
        BrowserUtils.hover(fleetVehicles.threeDotsEndOfRaw);
        BrowserUtils.waitForClickablility(fleetVehicles.deleteButton, 10);
        fleetVehicles.deleteButton.click();
    }

    @Then("The user able to see {string} pop up")
    public void theUserAbleToSeePopUp(String expectedPopupForDelete) {

        Assert.assertEquals(expectedPopupForDelete, fleetVehicles.actualPopupForDelete.getText());
    }

    @And("The user clicks the Yes, Delete button")
    public void theUserClicksTheYesDeleteButton() {

        fleetVehicles.yesDeleteButton.click();
    }

    @Then("The user should see {string} message")
    public void theUserShouldSeeMessage(String notificationMessage) {

        Assert.assertEquals(notificationMessage, fleetVehicles.deleteWarningMessage.getText());
    }


    @And("The user clicks the View button")
    public void theUserClicksTheButton() {

        BrowserUtils.scrollToElement(fleetVehicles.threeDotsEndOfRaw);
        BrowserUtils.sleep(3);
        BrowserUtils.hover(fleetVehicles.threeDotsEndOfRaw);
        fleetVehicles.viewButton.click();
    }

    @And("The user clicks the Delete Button on General Information Page")
    public void theUserClickTheDeleteButtonOnGeneralInformationPage() {

        BrowserUtils.sleep(3);
        generalInformationPage.delete_Button.click();
    }

    @Then("The user clicks the Yes, Delete button and can not see deleted car on Fleet-Vehicles page anymore")
    public void theUserClicksTheYesDeleteButtonAndCanNotSeeDeletedCarOnFleetVehiclesPageAnymore() {
        String deletedCarPlateText = generalInformationPage.deletedCarPlate.getText();
        fleetVehicles.yesDeleteButton.click();
        dashboard.goVehiclePage();
        Assert.assertNotEquals(deletedCarPlateText, fleetVehicles.firstLineCarPlate.getText());
    }
}
