package com.fleetGru.Pages;

import com.fleetGru.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralInformationPage {
    public GeneralInformationPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@href='javascript:void(0);'])[2]")
    public WebElement delete_Button;

    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    public WebElement deletedCarPlate;

}
