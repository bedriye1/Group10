package com.fleetGru.Pages;

import com.fleetGru.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addevent_2Page extends BasePage {
    public Addevent_2Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addEventButton;

    @FindBy(xpath = "//span[@id='ui-id-2']")
    public WebElement AddEventPopUp;
    @FindBy(xpath = "//input[@id='oro_calendar_event_form_title-uid-642021724c547']")
    public WebElement addEventTitle;

    @FindBy(xpath = "//button[@type='button'][2]")
    public WebElement allTextcolors;

    @FindBy(xpath = "//label[@for='oro_calendar_event_form_backgroundColor-uid-642021724c99f']")
    public WebElement clickableColors;
@FindBy(xpath = "//input [@type='email']")
public WebElement organizerEmail;

@FindBy(xpath = "//input [@data-name='field__organizer-display-name']")
public WebElement organizerName;
    @FindBy(xpath = "//input[@data-name='field__all-day']")
public WebElement allDayEventCheckBox;



    @FindBy (xpath = "//*[@id=\"time_selector_oro_calendar_event_form_end-uid-64202b8f36143\"]")
    public WebElement timerDisappear;

@FindBy(xpath = "//input[@data-name='recurrence-repeat']")
    public WebElement repeatButton;

@FindBy(xpath = "//select[@id='recurrence-repeats-view163']")
    public WebElement repeartsDropdown;


@FindBy(xpath = "//option[.='Daily']")
    public WebElement dailyEvent;


    @FindBy(xpath = "//option[.='Weekly']")
    public WebElement weeklyEvent;


    @FindBy(xpath = "//option[.='Monthly']")
    public WebElement montlyEvent;


    @FindBy(xpath = "//option[.='Yearly']")
    public WebElement yearlyEvent;





    @FindBy(xpath = "//span[.='Never']")
    public WebElement neverButton;
    @FindBy(xpath = "//*[@id=\"oro_calendar_event_form-uid-64202eab5c91e\"]/fieldset/div[2]/div[2]/div[2]/div[6]/div/div[2]/div[1]/label/input")
    public WebElement neverCheckBox;

    @FindBy(xpath = "//span[.='After']")
    public WebElement afterButton;
    @FindBy(xpath = "//*[@id=\"oro_calendar_event_form-uid-64202eab5c91e\"]/fieldset/div[2]/div[2]/div[2]/div[6]/div/div[2]/div[2]/label/input[1]")
    public WebElement afterCheckBox;

    @FindBy(xpath = "//span[.='By']")
    public WebElement byButton;

    @FindBy(xpath = "//*[@id=\"oro_calendar_event_form-uid-64202eab5c91e\"]/fieldset/div[2]/div[2]/div[2]/div[6]/div/div[2]/div[3]/label/input")
    public WebElement byCheckbox;

    @FindBy(xpath = "//button[.='Save']")
    public WebElement saveButton;

}

