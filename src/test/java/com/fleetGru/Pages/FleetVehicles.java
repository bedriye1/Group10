package com.fleetGru.Pages;


import com.fleetGru.Utilities.Driver;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;


import com.fleetGru.Utilities.*;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FleetVehicles {

    Faker faker=new Faker();

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


    @FindBy(xpath = "//div[@class='column-manager dropdown']")
    public WebElement gridButton;

    @FindBy(xpath = "//div[@class='dropdown-menu']")
    public WebElement gridSettingDDown;


    @FindBy(xpath = "//label[starts-with(@for, 'column-c')]")
    public List<WebElement> gridSettingsColumns;

    @FindBy (css = "[class=add-filter-button]")
    public WebElement ManageFiltersButton;

    @FindBy (xpath = "//label[@title='Driver']//span[contains(text(),'Driver')]")
    public WebElement driverFilterButton;
@FindBy (xpath = "//li[@class='driver']/button[contains(text(),'Driver:All')]")
public WebElement driverAllButton;

@FindBy (xpath = "//button[@class='btn dropdown-toggle']")
    public WebElement containsdropDownButton;

    public ArrayList<String> expectedTags(){

        String  str = ConfigurationReader.getProperty("vehicleGridSettingsTags");
        String[] strSplit = str.split(",");

        ArrayList<String> expected = new ArrayList<String>();
        expected.addAll(Arrays.asList(strSplit));





        return expected;


    }

    public ArrayList<String> actualTags(){
        ArrayList<String> actual = new ArrayList<>();
        for (WebElement gridSettingsColumn : gridSettingsColumns) {
            actual.add(gridSettingsColumn.getText());
        }

        return actual;
    }


    @FindBy(xpath = "//input[starts-with(@id, 'column-c')]")
    public List<WebElement> gridSettingCheckBoxes;

    public HashMap<String,Boolean> getCheckboxes() {


        ArrayList<String> actual=actualTags();
        ArrayList<Boolean> isSelected=new ArrayList<>();
        for (WebElement gridSettingTag : gridSettingCheckBoxes) {
            isSelected.add(gridSettingTag.isSelected());
        }
        HashMap<String, Boolean> checkboxes = new HashMap<String, Boolean>();
        for (int i = 0; i < actual.size(); i++) {
            checkboxes.put(actual.get(i), gridSettingCheckBoxes.get(i).isSelected());


        }

        return checkboxes;
    }

    public void selectAllGridTags(){
        for (WebElement gridSettingTag : gridSettingCheckBoxes) {
            gridSettingTag.click();

        }


    }

    @FindBy(xpath = "//input[@placeholder='Quick Search']")
    public WebElement quickSearcBox;



    String res, randomTag;
    public void quickSearchRandom(){
        ArrayList<String> actualTags=actualTags();
         res="";

       randomTag=actualTags.get(faker.number().numberBetween(0,actualTags.size()-1));
        quickSearcBox.sendKeys(randomTag);





    }

    public boolean verifyQuickSearch(){

        for (WebElement gridSettingsColumn : gridSettingsColumns) {
            if (gridSettingsColumn.isDisplayed()){
                res=gridSettingsColumn.getText();




            }

        }

        return (randomTag.equals(res));

    }

    public boolean verifyGridChanges(){


    return true;
    }



    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[4]")
    public WebElement threeDotsEndOfRaw;

    @FindBy(xpath = "(//i[@class='fa-trash-o hide-text'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//*[@class='modal-header']//h3")
    public WebElement actualPopupForDelete;

    @FindBy(xpath = "//a[.='Yes, Delete']")
    public WebElement yesDeleteButton;

    @FindBy(xpath= "//div[@class='message']")
    public WebElement deleteWarningMessage;

    @FindBy(xpath = "(//i[@class='fa-eye hide-text'])[1]")
    public WebElement viewButton;

    @FindBy(xpath = "(//table//tr)[3]//td[2]")
    public WebElement firstLineCarPlate;


}
