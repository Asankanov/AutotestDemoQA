package com.udemyqa.drivers;

import com.udemyqa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null){
            switch (ConfigReader.getValue("browser").toLowerCase()){
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "firefox":
                    // TODO add drivers for firefox
                    break;

                default:
                    throw new IllegalArgumentException("You provided wrong driver name");
            }
        }
        return driver;
    }

    public static void closeDriver(){
        try {
            if (driver != null){
                driver.close();
                driver.quit();
                driver=null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
