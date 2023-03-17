package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy (id="login")
    public WebElement username;

    @FindBy (id="password")
    public WebElement password;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.='POSManager15']")
    public WebElement posProfilName;

    @FindBy(xpath = "//span[.='SalesManager15']")
    public WebElement salesProfileName;

    @FindBy(xpath = "//p[normalize-space(.)='Wrong login/password']")
    public WebElement wrongInputText;

   // @FindBy(xpath = "//div[.='Congratulations, your inbox is empty']")
   // public WebElement dashboardMessage;

    @FindBy(xpath ="//div[@class='o_thread_title']" )
    public WebElement dashboardMessage;




}
