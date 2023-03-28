package com.fleetGru.Pages;


import com.fleetGru.Utilities.Driver;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;


import com.fleetGru.Utilities.*;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FleetVehicles {

    public FleetVehicles() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    Faker faker=new Faker();
    Actions actions=new Actions(Driver.getDriver());

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

    @FindBy(xpath = "//button[@class='btn dropdown-toggle' and @data-toggle='dropdown']")
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


    public void selectAllGridTags(){
        for (WebElement gridSettingTag : gridSettingCheckBoxes) {
            if (!gridSettingTag.isSelected()){
                gridSettingTag.click();
            }

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





    @FindBy(xpath = "//i[@class='fa-arrows-v handle ui-sortable-handle']")
    public List<WebElement> dragAndDropsList;
    public void dragAndDropRandomTag(){

        WebElement random=dragAndDropsList.get(faker.number().numberBetween(0,dragAndDropsList.size()-1));
        WebElement random2=dragAndDropsList.get(faker.number().numberBetween(0,dragAndDropsList.size()-1));
        actions.clickAndHold(random).moveToElement(random2).release().perform();



    }


    @FindBy(xpath = "//tr[@class='renderable']/td[1]")
    public List<WebElement> selectedTagTexts;


    @FindBy(xpath = "//thead[1]//span[@class='grid-header-cell__label']")
    public List<WebElement> gridHeaders;

    public ArrayList<String> getSelectedTagTexts(){

        ArrayList<String> res=new ArrayList<>();
        for (WebElement selectedTagText : selectedTagTexts) {
            res.add(selectedTagText.getText());
        }

        return res;
    }




    public void confirmsAllTheGridTagsSelectedAreApplied() {
        ArrayList<String> selectedTags=getSelectedTagTexts();
        ArrayList<String> gridHeads=new ArrayList<>();

        ArrayList<String> selectedTags1=new ArrayList<>();
        ArrayList<String> gridHeads1=new ArrayList<>();

        for (WebElement gridHeader : gridHeaders) {
            gridHeads.add(gridHeader.getText());}


        for (String selectedTag : selectedTags) {

            if (selectedTag.equals("Catalog Value (VAT Incl.)")){
                selectedTags1.add("CVVI");
            }
            else{
                if (selectedTag.contains("i")){
                    selectedTags1.add(selectedTag.replace('i','I').toUpperCase());}
                else selectedTags1.add(selectedTag.toUpperCase());
            }

        }
        for (String gridHead : gridHeads) {


            if (gridHead.equals("Catalog Value (VAT Incl.)")){
                gridHeads1.add(("CVVI"));
            }
            else { if (gridHead.contains("i")){gridHeads1.add(gridHead.replace('i','I').toUpperCase());}
            else gridHeads1.add(gridHead.toUpperCase());}

        }

        Assert.assertEquals(selectedTags1, gridHeads1);

    }








}
