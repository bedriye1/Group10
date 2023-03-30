package com.fleetGru.Pages;

import com.fleetGru.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public static boolean  popUpMessage(String message) {
        boolean flag = false;
        if (username.getText().equals("")){
            if(username.getAttribute("validationMessage").equals(message)){
                flag = true;
            }
        }
        if(password.getText().equals("")){
            if(password.getAttribute("validationMessage").equals(message)){
                flag = true;
            }
        }
        return flag;
    }


    @FindBy(xpath = "//h3")
    public WebElement loading;

    @FindBy(id ="prependedInput")
    public static WebElement username;

    @FindBy(id ="prependedInput2")
    public static WebElement password;

    @FindBy(id ="_submit")
    public WebElement loginButton;

    public void login(String usernameStr, String passwordStr) {
        username.sendKeys(usernameStr);
        password.sendKeys(passwordStr);
        loginButton.click();
    }
    @FindBy(xpath = "//div [@class='form-signin__footer control-group form-row']/a")
    public  WebElement forgotyourpasswordlink;


    @FindBy(xpath = "//span [@class='custom-checkbox__text']")
    public  WebElement remembermeonthiscomputer;




    @FindBy(xpath = "//div [@class = 'alert alert-error']/div")
    public WebElement invalidusernameorpassworderrormessage;




    @FindBy(xpath = "//input [@type = 'checkbox']")
    public WebElement checkboxbutton;


    @FindBy(xpath = "(//a [@class='dropdown-toggle'])[1]")
    public WebElement ownusername ;


}
