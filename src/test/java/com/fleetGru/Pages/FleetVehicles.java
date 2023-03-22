package com.fleetGru.Pages;

import com.fleetGru.Utilities.BrowserUtils;
import com.fleetGru.Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class FleetVehicles extends BasePage {

    public FleetVehicles () {PageFactory.initElements(Driver.getDriver(), this);}




    @FindBy(xpath = "//ul[@class='nav-multilevel main-menu']/li[1]")
    public WebElement element_Fleet_Menu;

    public void moveToFleetMenu(){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element_Fleet_Menu).build().perform();
    }
    @FindBy(xpath = "//a[@href='entity/Extend_Entity_Carreservation']/span")
    public WebElement click_vehicle;

    public void click_vehicle_menu(){
        click_vehicle.click();

    }

    @FindBy(xpath = "//*[@id='main-menu']/ul/li[2]")
    public WebElement Fleet_Menu_Store_Manager;

    public void hoverOverFleetMenu(){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Fleet_Menu_Store_Manager).build().perform();

    }
    @FindBy(xpath = "//a[@title='Create Car']")
    public WebElement createCarBtn;

    public String  createCarBtnText(){
        return  createCarBtn.getText();

    }

    @FindBy(className = "user-name")
    public WebElement createCarPAge;







}

