package com.udemyqa.pages;

import com.udemyqa.drivers.DriverManager;
import com.udemyqa.helper.DropdownHelper;
import com.udemyqa.helper.IframeHelper;
import com.udemyqa.helper.WebElementAction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public WebElementAction webElementActions = new WebElementAction();

    WebDriver driver = DriverManager.getDriver();

    public DropdownHelper dropdownHelper = new DropdownHelper(driver);

    public IframeHelper iframeHelper = new IframeHelper(driver);

    Random random = new Random();

}
