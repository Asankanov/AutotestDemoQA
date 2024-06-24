package com.udemyqa.pages;

import com.udemyqa.entities.DigitalNomadsLessonEntity;
import com.udemyqa.helper.WebElementAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DigitalNomadsLessonsPage {

    public WebElementAction webElementAction = new WebElementAction();

    @FindBy(xpath = "//input[@name='login']")
    public WebElement login;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement submitBtn;

    public DigitalNomadsLessonsPage fillUpLoginForm(DigitalNomadsLessonEntity digitalNomadsLessonEntity) {
        webElementAction.sendKeys(login, digitalNomadsLessonEntity.getLogin())
                .sendKeys(password, digitalNomadsLessonEntity.getPassword())
                .click(submitBtn);
        return this;
    }
}
