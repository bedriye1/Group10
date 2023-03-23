package com.fleetGru.Pages;

import com.fleetGru.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//tr[@class='grid-row row-click-action']")
    public WebElement firstRow;

}
