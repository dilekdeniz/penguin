package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
    public LogOutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
        @FindBy(xpath = "//a[@data-menu='logout']")
        public WebElement logOutButton;

        @FindBy(xpath = "//img[@class='img-circle oe_topbar_avatar']")
        public WebElement profileIcon;

        @FindBy(xpath = "//title[.='Login | Best solution for startups']")
         public WebElement loginPageTitle;

        @FindBy(xpath = "//div[normalize-space(.)='Your Odoo session expired. Please refresh the current web page.']")
          public WebElement expiredMessage;
    }

