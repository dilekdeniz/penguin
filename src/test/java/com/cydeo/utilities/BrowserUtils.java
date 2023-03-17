package com.cydeo.utilities;

import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
in thus class only general utility methods that are not related to some specific page
 */
public class BrowserUtils {
    /*
    This method will accept int(in second) and execute Thread.sleep
    for given duration

     */

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
        }
    }

    /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowVerify(String expectedInUrl, String expectedTitle) {
        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowsHandles) {

            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());
            if (Driver.getDriver().getCurrentUrl().contains("etsy")) {
                break;
            }
        }

        //  5. Assert: Title contains “Etsy”
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    /*
  This method accepts a String "expectedTitle" and Asserts if it is true
   */
    public static void verifyTitle(  String expectedTitle) {

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }

    /*
    Creating a utility method for ExplicitWait, so we don't have to repeat the lines
     */
    public static void waitForInvisibilityOf(WebElement webElement) {
        //  Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }
}