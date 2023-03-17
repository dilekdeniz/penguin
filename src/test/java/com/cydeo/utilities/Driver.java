package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    creating a private constructor, so we are closing
    access to the object of this class from  outside the class */
    private Driver(){}

    /*
    we made WebDriver private, because we want to close access from outside the class
    we make it static because we will use it in static method */
    //private static WebDriver driver;// value is null by default
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();    /*
    Create a re-usable utility method which will return the same driver instance when we call it */
    public static WebDriver getDriver(){

        if(driverPool.get()==null){

            // we read our browser type from *configuration.properties.*
            // This way we can control which browser is opened from outside of our code, from configuration.properties
            String browserType= ConfigurationReader.getProperty("browser");

            /*
             Depending on the browserType that will return from configuration.properties file
             switch statement will determine the case , and open the matching browser  */
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driverPool.get();
    }


    // driver.quit()  --> nosuchsession
    // driver.quit()


    // try to create a method named closeDriver

    public static void closeDriver() {// close the existing session, and then make it ready for another new session
        if (driverPool.get() != null) {
            driverPool.get().quit();// this line will terminate the existing session. Value will not even be null
            driverPool.set(null);// now its null again and ready to be used again
        }
    }

}