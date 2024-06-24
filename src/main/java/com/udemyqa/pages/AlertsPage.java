package com.udemyqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage{

    @FindBy(id = "alertButton")
    public WebElement firstAlertBtn;

    @FindBy(id = "timerAlertButton")
    public WebElement secondAlertBtn;

    @FindBy (id = "confirmButton")
    public WebElement thirdAlertBtn;

    @FindBy (id = "promptButton")
    public WebElement fourthAlertBtn;


}
