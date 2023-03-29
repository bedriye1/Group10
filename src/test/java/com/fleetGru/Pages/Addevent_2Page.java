package com.fleetGru.Pages;

import com.fleetGru.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Addevent_2Page extends BasePage {
    public Addevent_2Page() {
       PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//td[.='Huey Harris']")
    public WebElement anyVehicles;

    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addEventButton;

    @FindBy(xpath = "//span[@id='ui-id-2']")////span[.='Add Event']
    public WebElement AddEventPopUp;
    @FindBy(xpath ="//input[starts-with(@id,'oro_calendar_event_form_title-uid-642')] ")
    public WebElement addEventTitle;

    @FindBy(xpath = "//span[@title='#5484ED']")
    public WebElement colors;

   @FindBy(xpath = "//input [@type='email']")
public WebElement organizerEmail;

@FindBy(xpath = "//input [@data-name='field__organizer-display-name']")
public WebElement organizerName;
    @FindBy(xpath = "//input[@data-name='field__all-day']")
    public WebElement allDayEventCheckBox;
    @FindBy (xpath = "//input[starts-with(@id,'time_selector_oro_calendar_event_form_start-uid-642')]")
    public WebElement timerDisappear;

 @FindBy(xpath = "//input[@data-name='recurrence-repeat']")
    public WebElement repeatButton;



@FindBy(xpath = "//select[starts-with(@id,'recurrence-repeats-view')]")

    public WebElement repeatsDropdown;

@FindBy(xpath = "//div[@class='controls recurrence-subview-control recurrence-subview-control__items']/div/label")
public List<WebElement>endsList;

    @FindBy(xpath = "//button[.='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//h4[.='Activity']")
    public WebElement activity;

    @FindBy(xpath = "//div[@class='details']")
    public WebElement eventAdded;

}

