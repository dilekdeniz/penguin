package com.cydeo.step_definitions;

import com.cydeo.pages.LogOutPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class LogOut_StepDefinitions {
    LoginPage loginPage=new LoginPage();
    LogOutPage logOutPage=new LogOutPage();
    @Given("user goes to login page")
    public void user_goes_to_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Then("user enters {string} as username")
    public void user_enters_as_username(String username) {
    loginPage.username.sendKeys(username);
    }

    @Then("enters {string} as password")
    public void enters_as_password(String password) {
        loginPage.password.sendKeys(password);


    }

    @Then("user clicks to login button and should be on the homepage")
    public void user_clicks_to_login_button_and_should_be_on_the_homepage() {
        BrowserUtils.sleep(5);
    loginPage.loginButton.click();
    loginPage.dashboardMessage.isDisplayed();
    }

    @Then("user should see logout button the dropdowns by clicking the profile icon")
    public void user_should_see_logout_button_the_dropdowns_by_clicking_the_profile_icon() {
        logOutPage.profileIcon.click();
        logOutPage.logOutButton.isDisplayed();

    }

    @Then("user should be able to click to logout button and land back on the login page")
    public void user_should_be_able_to_click_to_logout_button_and_land_back_on_the_login_page() {
    logOutPage.logOutButton.click();
    logOutPage.loginPageTitle.isDisplayed();
    }




    @When("user navigate back and should see the expired message")
    public void userNavigateBackUserAndShouldSeeTheExpiredMessage() {
        Driver.getDriver().navigate().back();
        logOutPage.expiredMessage.isDisplayed();

    }
}
