package com.fleetGru.StepDefinitions;

import com.fleetGru.Pages.*;
import com.fleetGru.Utilities.*;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        //go to login page
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("The user logs in as {string}")
    public void the_user_logged_in_as(String userType) {
        //go to login page
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        //based on input enter that user information
        String username =null;
        String password =null;

        if(userType.equalsIgnoreCase("driver")){
            username = ConfigurationReader.getProperty("driver_username");
            password = ConfigurationReader.getProperty("driver_password");
        }else if(userType.equalsIgnoreCase("sales manager")){
            username = ConfigurationReader.getProperty("sales_manager_username");
            password = ConfigurationReader.getProperty("sales_manager_password");
        }else if(userType.equalsIgnoreCase("store manager")){
            username = ConfigurationReader.getProperty("store_manager_username");
            password = ConfigurationReader.getProperty("store_manager_password");
        }
        //send username and password and login
        loginPage.login(username,password);
    }

    @When("The user enter invalid username and valid password")
    public void theUserEnterInvalidUsernameAndValidPassword() {
        Faker faker = new Faker();
        LoginPage.username.sendKeys(faker.name().fullName());
        LoginPage.password.sendKeys("UserUser123");
        loginPage.loginButton.click();

    }

    @Then("The user see Invalid user name or password error message")
    public void theUserSeeInvalidUserNameOrPasswordErrorMessage() {
        String expectedTitle = "Invalid user name or password.";
        String actualTitle = loginPage.invalidusernameorpassworderrormessage.getText();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
        Driver.closeDriver();
    }

    @When("The user enter valid username and invalid password")
    public void theUserEnterValidUsernameAndInvalidPassword() {
        Faker faker = new Faker();
        LoginPage.username.sendKeys("user1");
        LoginPage.password.sendKeys(faker.bothify("????-########"));
        loginPage.loginButton.click();

    }

    @When("The user enter empty username and random password")
    public void theUserEnterEmptyUsernameAndRandomPassword() {
        LoginPage.username.sendKeys("");
        LoginPage.password.sendKeys("UserUser123");
        loginPage.loginButton.click();
    }

    @Then("The user see Lütfen bu alanı doldurun error message")
    public void theUserSeeLütfenBuAlanıDoldurunErrorMessage() throws InterruptedException {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        BrowserUtils.sleep(5);
        Assert.assertTrue(LoginPage.popUpMessage("Please fill out this field."));
    }


    @When("The user enter random username and empty password")
    public void theUserEnterRandomUsernameAndEmptyPassword() {
        LoginPage.username.sendKeys("user1");
        LoginPage.password.sendKeys("");
        loginPage.loginButton.click();
    }

    @When("The user enter empty username and empty password")
    public void theUserEnterEmptyUsernameAndEmptyPassword() {
        LoginPage.username.sendKeys("");
        LoginPage.password.sendKeys("");
        loginPage.loginButton.click();
    }

    @When("The user click Forgot your password? link")
    public void theUserClickForgotYourPasswordLink() {
        loginPage.forgotyourpasswordlink.click();

    }

    @Then("The user see Forgot Password page")
    public void theUserSeeForgotPasswordPage() throws InterruptedException {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        String expectedTitle = "Forgot Password";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);


    }

    @Then("The user see Forgot Remember me on this computer link")
    public void theUserSeeForgotRememberMeOnThisComputerLink() {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        String expectedTitle = "Remember me on this computer";
        String actualTitle = loginPage.remembermeonthiscomputer.getText();
        Assert.assertEquals(actualTitle, expectedTitle);


    }

    @When("The user see Remember me on this computer link is clickable")
    public void theUserClickRememberMeOnThisComputerLink() {
        loginPage.checkboxbutton.isEnabled();
    }

    @When("User type the password")
    public void userTypeThePassword() {
        Faker faker = new Faker();
        LoginPage.password.sendKeys(faker.bothify("?******?????"));
    }

    @Then("User see the password in bullet signs by default")
    public void userSeeThePasswordInBulletSignsByDefaultLike() {
        LoginPage.password.getAttribute("type").equals("password");

    }


    @When("User press enter key of the keyboard")
    public void userPressEnterKeyOfTheKeyboard() {
        loginPage.loginButton.sendKeys(Keys.ENTER);
    }

    @Then("User see enter key is working")
    public void userSeeEnterKeyIsWorking() {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        Assert.assertTrue(LoginPage.popUpMessage("Please fill out this field."));

    }


    @When("User enter valid username and valid password and click")
    public void userEnterValidUsernameAndValidPasswordAndClick() {
        LoginPage.username.sendKeys("user1");
        LoginPage.password.sendKeys("UserUser123");
        loginPage.loginButton.click();
        BrowserUtils.sleep(5);
    }

    @Then("User see own username in the profile menu")
    public void userSeeOwnUsernameInTheProfileMenu() {
        String actualvalue = loginPage.ownusername.getText();
        String expectedvalue = "user1";
        Assert.assertEquals(actualvalue,expectedvalue);

    }


}
