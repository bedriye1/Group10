package com.fleetGru.Pages;

import com.fleetGru.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddEventPage {
    public AddEventPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//tr[@class='grid-row row-click-action']")
    public WebElement firstRow;

    @FindBy(xpath = "")
    public WebElement driverFirstRow;

    @FindBy(xpath = "//button[.='Save']")
    public WebElement saveButton;

    @FindBy(xpath ="//span[.='This value should not be blank.']" )
    public WebElement message;

    @FindBy(xpath = "//fieldset[@class='form form-horizontal']")
    public List<WebElement> addEventPopUp;

    @FindBy(xpath = "//input[@id='oro_calendar_event_form_organizerDisplayName-uid-641e33e0bb87a']")
    public WebElement organizerDisplayGame;

    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement driverAddButton;
}
