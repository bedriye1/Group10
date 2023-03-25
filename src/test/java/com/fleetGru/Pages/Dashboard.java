package com.fleetGru.Pages;

import com.fleetGru.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

    public Dashboard(){
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

    @FindBy(xpath ="//*[@id=\"main-menu\"]/ul/li[2]")
    public WebElement FleetDropDown;

    @FindBy(xpath ="//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span")
    public WebElement Vehicles;

    @FindBy(xpath ="//th[.=*]")
    public WebElement tableHeaders;

    @FindBy (xpath = "//a[@title=\"Edit Car\"]")
    public WebElement editButtonGeneralInformationPage;

    @FindBy (xpath = "//a[@title=\"Delete Car\"]")
    public WebElement deleteButtonGeneralInformationPage;

    @FindBy (xpath = "//a[@title=\"Add an event to this record\"]")
    public WebElement addEventButtonGeneralInformationPage;

    @FindBy (xpath = "//table[@class=\"grid table-hover table table-bordered table-condensed\"]//tr[1]//td//div//div//a[@data-toggle=\"dropdown\"]")
    public WebElement firstThreePoint;

    @FindBy (xpath = "//a[@title=\"View\"]")
    public WebElement threePointView;
}
