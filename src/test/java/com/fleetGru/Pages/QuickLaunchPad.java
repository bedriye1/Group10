package com.fleetGru.Pages;

import com.fleetGru.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickLaunchPad {

    public QuickLaunchPad(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//*[@id=\"user-menu\"]/a")
    public WebElement profileName;

    @FindBy(xpath ="//*[@id=\"user-menu\"]/ul/li[4]/a")
    public WebElement logoutButton;

    @FindBy(xpath ="//div[2]/div[1]/div/div/div[1]/div/h1")
    public WebElement QuickLaunchpadText;

    @FindBy(xpath ="//div[2]/div[1]/div/div/div[1]/div/h1")
    public WebElement DashboardText;

    @FindBy(xpath ="//span[@class='title title-level-1']")
    public WebElement FleetDropDown;

    @FindBy(xpath ="//div[@id='main-menu']/ul/li[1]/a[@href='#']/span[@class='title title-level-1']")
    public WebElement FleetsQuichLaunch;

    @FindBy(xpath ="//div[@id='main-menu']/ul/li[1]/div[@class='dropdown-menu-wrapper dropdown-menu-wrapper__placeholder']/div[@class='dropdown-menu-wrapper dropdown-menu-wrapper__scrollable']/ul[@class='dropdown-menu dropdown-menu-level-1 menu menu-level-1']//a[@href='entity/Extend_Entity_Carreservation']/span[@class='title title-level-2']")
    public WebElement VehiclesDropDown;

    @FindBy(xpath ="/html//div[@id='container']/div[@class='container-fluid page-title']//h1[@class='oro-subtitle']")
    public WebElement Cars;

    @FindBy(xpath ="//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[3]/a/span")
    public WebElement Vehicles;

    @FindBy(xpath ="//th[.=*]")
    public WebElement tableHeaders;

}
