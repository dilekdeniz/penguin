package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class Login_StepDefinition {
    LoginPage loginPage = new LoginPage();

    @When("user is on fidexio login page")
    public void user_is_on_fidexio_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @When("user\\(salesManager)enters {string} as username and {string} as password.")
    public void user_sales_manager_enters_as_username_and_as_password(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);


    }

    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        loginPage.loginButton.click();

    }

    @Then("user\\(SalesManager) is on the homepage")
    public void user_sales_manager_is_on_the_homepage() {
        BrowserUtils.sleep(15);
        Assert.assertEquals("#Inbox - Odoo", Driver.getDriver().getTitle());
        boolean checkProfile = loginPage.salesProfileName.getText().contains("SalesManager");
        Assert.assertTrue(checkProfile);


    }


    @When("user\\(posManager)enters {string} as username and {string} as password.")
    public void user_pos_manager_enters_as_username_and_as_password(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);


    }

    @Then("user\\(posManager) is on the homepage")
    public void user_pos_manager_is_on_the_homepage() {
        BrowserUtils.sleep(15);
        Assert.assertEquals("#Inbox - Odoo", Driver.getDriver().getTitle());
        boolean checkProfile = loginPage.posProfilName.getText().contains("POSManager");
        Assert.assertTrue(checkProfile);


    }

    @Then("user should see the {string} message on the login page after providing invalid credentials")
    public void user_should_see_the_message_on_the_login_page_after_providing_invalid_credentials(String string) {
        Assert.assertEquals(string, loginPage.wrongInputText.getText());


    }

    @When("user enters {string} as invalid username and {string} as invalid password")
    public void user_enters_as_invalid_username_and_as_invalid_password(String invalidUsername, String invalidPassword) {
        loginPage.username.sendKeys(invalidUsername);
        loginPage.password.sendKeys(invalidPassword);

    }


    @When("user clicks on the {string} link to  reset password")
    public void user_clicks_on_the_link_to_reset_password(String string) {

    }

    @Then("user will be redirected to the reset password page")
    public void user_will_be_redirected_to_the_reset_password_page() {


    }

    @When("user enters {string} as password")
    public void user_enters_as_password(String string) {
        loginPage.password.sendKeys(string);
    }

    @Then("the user should see the password in bullet signs by default")
    public void the_user_should_see_the_password_in_bullet_signs_by_default() {
        String type = loginPage.password.getAttribute("type");
        Assert.assertEquals("password", type);

    }

    @When("user enters {string} as username and {string} as password.")
    public void user_enters_as_username_and_as_password(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
    }

    @When("user should  press the Enter key on the keyboard")
    public void user_should_press_the_enter_key_on_the_keyboard() {
        loginPage.loginButton.sendKeys(Keys.ENTER);

    }

    @Then("user should be logged in to the system")
    public void user_should_be_logged_in_to_the_system() {
        Assert.assertEquals("Congratulations, your inbox is empty", loginPage.dashboardMessage.getText());





    }



    @When("user enters only an {string} or {string}")
    public void userEntersOnlyAnOr(String email, String password) {
        loginPage.username.sendKeys(email);
        loginPage.password.sendKeys(password);

    }

    @Then("user should see warning message to fill empty fields when trying to log in")
    public void userShouldSeeWarningMessageToFillEmptyFieldsWhenTryingToLogIn() {

       loginPage.loginButton.click();

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if (loginPage.password.getAttribute("value").isEmpty()) {
        System.out.println("hello1");
        Assert.assertEquals("Please fill in this field.", loginPage.password.getAttribute("validationMessage"));
    }
        if (loginPage.username.getAttribute("value").isEmpty()) {
        System.out.println("hello2");
        Assert.assertEquals("Please fill in this field.", loginPage.username.getAttribute("validationMessage"));
    }

}

}
