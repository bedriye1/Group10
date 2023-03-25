package com.fleetGru.Pages;


import com.fleetGru.Utilities.Driver;

import org.openqa.selenium.By;


import com.fleetGru.Utilities.*;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FleetVehicles {

    public FleetVehicles() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//th[.=*]")
    public List<WebElement> tableHeaders;

    @FindBy(xpath ="//tr/td")
    public List<WebElement> tableCells;

    @FindBy(xpath ="//div[4]/label[2]")
    public WebElement totalPageNumber;

    @FindBy(xpath ="//div[2]/div[1]/div/div[4]/ul/li[3]/a")
    public WebElement forwardButton;

    @FindBy(xpath ="//input[@type='number']")
    public WebElement pageNumber;

    @FindBy(xpath ="//*[@id=\"flash-messages\"]/div/div/div/div")
    public WebElement ExportGridConfirmationMessage;

    @FindBy(xpath ="//label[@class='dib'][3]")
    public WebElement totalVehiclesText;

    @FindBy(xpath ="//a[@title='With this button you will export the content of the grid as it appears to you, with filters and sorting applied. All pages will be exported.']\n")
    public WebElement ExportGridButton;

    @FindBy(xpath ="//div[2]/div[1]/div/div[4]/ul/li[1]/a")
    public WebElement backButton;

    @FindBy(xpath ="//a[@data-index='1']")
    public WebElement xlsxButton;


    @FindBy(xpath = "//a[@title='Filters']")
    public WebElement filterButton;

    @FindBy(xpath = "//button[@type='button']//a[@class='add-filter-button']")
    public WebElement manageFilters;

    @FindBy(xpath = "//ul[@class='ui-multiselect-checkboxes ui-helper-reset fixed-li']//li//label//input[@title='Tags']")
    public WebElement tagsButton;

    @FindBy(xpath = "//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']")
    public WebElement tagsAll;

    @FindBy(xpath = "//button[@class='btn dropdown-toggle']")
    public WebElement dropDownToggleButton;

    @FindBy(xpath = "//label[@class='control-label']/../div/button")
    public WebElement viewPerPageBtn;

    @FindBy(xpath = "(//ul[@class='dropdown-menu pull-right'])[2]/li")
    public List<WebElement> vehicleNumbers;

    @FindBy(xpath ="//th[.=*]/a")
    public List<WebElement> columnNames;

    @FindBy(xpath ="(//th[.=*]/a)[2]")
    public WebElement driverColumn;

    @FindBy (xpath = "//a[@data-size='100']")
    public WebElement vehicleNumber100;

    @FindBy(xpath = "(//*[@class='fa-refresh'])[2]")
    public WebElement resetBtn;


    @FindBy (xpath = "//a[@title='Filters']")
    public WebElement filtersIcon;

    @FindBy (css = "a.add-filter-button")
    public WebElement manageFiltersButton;


    @FindBy (xpath = "//label[@title='Tags']")
    public WebElement tagsFilter;

    @FindBy (xpath = "//input[@type='search']")
    public WebElement manageFiltersSearchBar;

    @FindBy (xpath = "//label[@title='Driver']")
    public WebElement driverFilter;

    @FindBy (xpath = "(//i[@class='fa-refresh'])[2]")
    public WebElement resetIcon;

    @FindBy (xpath = "//div[@class='filter-container']")
    public WebElement filterContainer;

    @FindBy(id = "s2id_autogen2")
    public WebElement chooseValuesInputBox;

    @FindBy(xpath = "//a[@class='dropdown-item choice-value' and .='is any of']")
    public WebElement isAnyOfButton;

    @FindBy(xpath = "//a[@class='dropdown-item choice-value' and .='is not any of']")
    public WebElement isNotAnyOfButton;

    @FindBy(xpath = "//ul[@class='unstyled options']")
    public WebElement listOfTags;

    @FindBy(xpath = "//button[.='Update']")
    public WebElement updateButton;

    @FindBy(xpath = "//span[.='Compact']")
    public WebElement compactOption;

    @FindBy(xpath = "//td[.='Samuel Christiansen']")
    public WebElement SamuelChrist;


    @FindBy(xpath = "//div[@class='column-manager dropdown']")
    public WebElement gridButton;

    @FindBy(xpath = "//div[@class='dropdown-menu']")
    public WebElement gridSettingDDown;


    @FindBy(xpath = "//label[starts-with(@for, 'column-c')]")
    public List<WebElement> gridSettingsColumns;


}
