package com.udemyqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SelectPage extends BasePage {
    Random random = new Random();
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "withOptGroup")
    public WebElement selectValue;

    @FindBy(id = "selectOne")
    public WebElement selectOne;

    @FindBy(id = "oldSelectMenu")
    public WebElement oldSelectMenu;

    @FindBy(id = "selectMenuContainer")
    public WebElement selectMenuContainer;

    @FindBy(xpath = "//*[@id=\"withOptGroup\"]/div[2]/div/div")
    public List<WebElement> listSelectValue;

    @FindBy(xpath = "//*[@id=\"selectMenuContainer\"]/div[7]/div/div/div[2]/div/div")
    public List<WebElement> listOfMultiSelect;

    public SelectPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public SelectPage fillUpSelectMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(selectValue));
//        dropdownHelper.selectByVisibleText(selectOne, "Mrs.");
        dropdownHelper.selectByVisibleText(oldSelectMenu, "Green");
        return this;
    }
}