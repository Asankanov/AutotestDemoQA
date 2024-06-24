package com.udemyqa.pages;


import com.udemyqa.drivers.DriverManager;
import com.udemyqa.entities.PracticeFormEntity;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PracticeFormPage extends BasePage {

    @FindBy(id = "firstName")
    public WebElement firsNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement userEmailInput;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div")
    public List<WebElement> userGenderChoose;

    @FindBy(id = "userNumber")
    public WebElement userNumber;

    @FindBy(id = "subjectsInput")
    public WebElement userSubjectInput;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div")
    public List<WebElement> userHobbies;

    @FindBy(id = "currentAddress")
    public WebElement userCurrentAddress;

    @FindBy(id = "state")
    public WebElement userStateClick;

    @FindBy(xpath = "//div[contains(@id, 'react-select-3-option')]")
    public List<WebElement> stateInputList;

    @FindBy(id = "city")
    public WebElement clickCityInput;

    @FindBy(xpath = "//*[@id=\"city\"]/div[2]/div/div")
    public List<WebElement> citiesInputList;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPicture;

    @FindBy(className = "react-datepicker__input-container")
    public WebElement dataPickerBtn;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement listOfMonth;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement listOfYear;

    @FindBy(xpath = "//div[contains(@class, 'react-datepicker__day')]")
    public WebElement dayBtn;

    @FindBy(id = "dateOfBirthInput")
    public WebElement birthdayBtn;

    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[6]")
    public WebElement may;


    public PracticeFormPage selectDayMonthYear(String dataMonthYear) {

        String[] dataMonthYearParts = dataMonthYear.split("");

        String date = dataMonthYearParts[0];
        String month = dataMonthYearParts[2];
        String year = dataMonthYearParts[3];

        webElementActions.click(dataPickerBtn);

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        WebElement monthDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month-select")));

        WebElement yearDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__year-select")));

        dropdownHelper.selectByVisibleText(monthDropDown, month)
                .selectByVisibleText(yearDropDown, year);

        WebElement day = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(
                        "//div[contains(@class, 'react-datepicker__day') and not (contains(@class, react-datepicker__day--outside-month)) and text()='" + date + "']"
                )
        ));

        webElementActions.click(day);

        return null;
    }

    public PracticeFormPage fillUpPracticeFormPage(PracticeFormEntity practiceFormEntity) throws InterruptedException {

        webElementActions
                .sendKeys(firsNameInput, practiceFormEntity.getFirstName())
                .sendKeys(lastNameInput, practiceFormEntity.getLastName())
                .sendKeys(userEmailInput, practiceFormEntity.getUserEmail())
                .click(userGenderChoose.get(random.nextInt(userGenderChoose.size())))
                .sendKeys(userNumber, practiceFormEntity.getUserNumber())
                .click(birthdayBtn);

        dropdownHelper
                .selectByVisibleText(listOfMonth, "May")
                .selectByVisibleText(listOfYear, "2001");

        webElementActions
                .click(may)
                .click(userSubjectInput)
                .sendKeys(userSubjectInput, practiceFormEntity.getUserSubjectInput())
                .sendKeys(userSubjectInput, String.valueOf(Keys.ENTER))
                .click(userHobbies.get(random.nextInt(userHobbies.size())))
                .sendKeys(uploadPicture, "C:\\Users\\kutma\\IdeaProjects\\AutotestDemoQA\\src\\main\\resources\\photo.jpg")
                .sendKeys(userCurrentAddress, practiceFormEntity.getUserCurrentAddress())
                .click(userStateClick)
                .click(stateInputList.get(random.nextInt(stateInputList.size())))
                .click(clickCityInput)
                .click(citiesInputList.get(random.nextInt(citiesInputList.size())))
                .click(submitBtn);


        Thread.sleep(5000);

        return this;
    }

}
