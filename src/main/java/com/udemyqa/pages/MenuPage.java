package com.udemyqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage{

    @FindBy(xpath = "//a[text()='Main Item 1']")
    public WebElement mainItem1;

    @FindBy(xpath = "//a[text()='Main Item 2']")
    public WebElement mainItem2;

    @FindBy(xpath = "//a[text()='Main Item 3']")
    public WebElement mainItem3;

    @FindBy(xpath = "//*[@id=\"nav\"]/li[2]/ul/li[3]")
    public WebElement subList;

}
