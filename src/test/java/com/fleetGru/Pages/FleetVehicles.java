package com.fleetGru.Pages;

import com.fleetGru.Utilities.BrowserUtils;
import com.fleetGru.Utilities.ConfigurationReader;
import com.fleetGru.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.lang.module.Configuration;
import java.security.interfaces.XECPrivateKey;
import java.util.List;


public class FleetVehicles extends BasePage {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    public FleetVehicles() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//ul[@class='nav-multilevel main-menu']/li[1]")
    public WebElement element_Fleet_Menu;

    public void moveToFleetMenu() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element_Fleet_Menu).build().perform();
    }

    @FindBy(xpath = "//a[@href='entity/Extend_Entity_Carreservation']/span")
    public WebElement click_vehicle;

    public void click_vehicle_menu() {
        click_vehicle.click();

    }

    @FindBy(xpath = "//*[@id='main-menu']/ul/li[2]")
    public WebElement Fleet_Menu_Store_Manager;

    public void hoverOverFleetMenu() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Fleet_Menu_Store_Manager).build().perform();
        BrowserUtils.waitForPageToLoad(2);

    }

    @FindBy(xpath = "//a[@title='Create Car']")
    public WebElement createCarBtn;

    public String createCarBtnText() {
        return createCarBtn.getText();

    }

    @FindBy(className = "user-name")
    public WebElement createCarPAge;

    @FindBy(id = "prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    public void login(String usernameStr, String passwordStr) {

        BrowserUtils.waitForPageToLoad(5);
        username.sendKeys(usernameStr);
        password.sendKeys(passwordStr);
        loginButton.click();
    }

    public void ToReachCreateCarBtnPage() throws InterruptedException {

        login("storemanager51", "UserUser123");
        wait.until(ExpectedConditions.visibilityOf(Fleet_Menu_Store_Manager));
        hoverOverFleetMenu();
        click_vehicle.click();

        waitUntilLoaderScreenDisappear();

        createCarBtn.click();

    }

    @FindBy(xpath = "//input[@name='custom_entity_type[LicensePlate]']")
    public WebElement licencePlate;

    @FindBy(xpath = "//div[@class='controls']/div[1]/div[1]")
    //input[@id='custom_entity_type_Tags_0-uid-642035123a63b']

    public WebElement junior;

    @FindBy(xpath = "//div[@class='controls']/div[1]/div[2]")
    public WebElement senior;

    @FindBy(xpath = "//div[@class='controls']/div[1]/div[3]")
    public WebElement employeeCar;

    @FindBy(xpath = "//div[@class='controls']/div[1]/div[4]")
    public WebElement purchased;

    @FindBy(xpath = "//div[@class='controls']/div[1]/div[5]")
    public WebElement compact;

    @FindBy(xpath = "//div[@class='controls']/div[1]/div[6]")
    public WebElement sedan;

    @FindBy(xpath = "//div[@class='controls']/div[1]/div[7]")
    public WebElement convertible;

    @FindBy(xpath = "//input[@name='custom_entity_type[Driver]']")
    public WebElement driver;

    @FindBy(xpath = "//input[@name='custom_entity_type[Location]']")
    public WebElement location;

    @FindBy(xpath = "//input[@name='custom_entity_type[ChassisNumber]']")
    public WebElement chasisNumber;

    @FindBy(xpath = "//input[@name='custom_entity_type[ModelYear]']")
    public WebElement modelYear;

    @FindBy(xpath = "//input[@name='custom_entity_type[LastOdometer]']")
    public WebElement lastOdometre;

    @FindBy(xpath = "//input[@class='datepicker-input hasDatepicker']")
    public WebElement ımmactriculation;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']/option")
    public WebElement month;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']/option")
    public WebElement year;

    @FindBy(xpath = "//input[@name='date_selector_custom_entity_type_FirstContractDate-uid-6421db52923de']")
    public WebElement firstContactdate;

    @FindBy(xpath = "//input[@name='custom_entity_type[CatalogValue]']")
    public WebElement catalogValue;

    @FindBy(xpath = "//input[@name='custom_entity_type[SeatsNumber]']")
    public WebElement seatNumber;

    @FindBy(xpath = "//input[@name='custom_entity_type[DoorsNumber]']")
    public WebElement doorNumber;

    @FindBy(xpath = "//input[@name='custom_entity_type[Color]']")
    public WebElement colour;

    @FindBy(xpath = "(//span[@class='select2-chosen'])[1]")
    public WebElement transmission;

    @FindBy(xpath = "(//span[@class='select2-chosen'])[2]")
    public WebElement gasoline;

    @FindBy(xpath = "//input[@name='custom_entity_type[CO2Emissions]']")
    public WebElement cOemission;

    @FindBy(xpath = "//input[@name='custom_entity_type[Horsepower]']")
    public WebElement horsePower;

    @FindBy(xpath = "//input[@name='custom_entity_type[HorsepowerTaxation]']")
    public WebElement horsePowerTaxation;

    @FindBy(xpath = "//input[@name='custom_entity_type[Power]']")
    public WebElement power;

    @FindBy(xpath = "//div[20]/div[2]/div/div/input")
    public WebElement uploadFile;

    public void submit() {
        uploadFile.sendKeys(ConfigurationReader.getProperty("uploadFile" + Keys.ENTER));
    }

    @FindBy(xpath = "//input[starts-with(@id,'date_selector_custom_entity_type_FirstContractDate')]")
    public WebElement firstContactDate;

    @FindBy(xpath = "//button[@class='ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all']")
    public WebElement date1Btn;

    @FindBy(xpath = "//button[@class='ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all']")
    public WebElement date2Btn;

    @FindBy(xpath = "//a[@class='btn-success btn dropdown-toggle']")
    public WebElement saveDropdown;

    @FindBy(xpath = "//h1[@class='user-name']")
    public WebElement beforeSave;

    @FindBy(xpath = "//h1[@class='user-name']")
    public WebElement afterSave;

    @FindBy(xpath = "//*[@id=\"flash-messages\"]/div/div/div/div")
    public WebElement flashMessage;

    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/h5/span")
    public WebElement generalInfoPage;

    public void clickSave(String string){
        Actions actions = new Actions(Driver.getDriver());

        saveDropdown.click();
        BrowserUtils.waitFor(2);
        List<WebElement> d = Driver.getDriver().findElements(By.xpath("//button[@type='submit']"));
        for (WebElement each : d) {
            if (each.getText().contains(string)) {
                each.click();
            }
        }
        BrowserUtils.waitFor(2);
    }
}

