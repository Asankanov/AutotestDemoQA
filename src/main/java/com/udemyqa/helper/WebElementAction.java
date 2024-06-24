package com.udemyqa.helper;

import com.udemyqa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WebElementAction {
    Actions actions = new Actions(DriverManager.getDriver());

    public WebElementAction click(WebElement element) {
        scrollToElement(element);
        waitElementToBeClickAble(element);
        highlightElement(element);
        element.click();
        return this;
    }

    public WebElementAction sendKeys(WebElement element, String txt) {
        scrollToElement(element);
        waitElementToBeVisible(element);
        highlightElement(element);
        element.sendKeys(txt);
        return this;
    }

    public WebElementAction waitElementToBeClickAble(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public WebElementAction waitElementToBeVisible(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }


    public WebElementAction sendKeysWithEnter(WebElement element, String txt) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        element.sendKeys(txt);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public WebElementAction sendKeysAndEnter(WebElement element, String txt) throws InterruptedException {
        waitElementToBeVisible(element);
        scrollToElement(element);
        element.sendKeys(txt);

        // Добавляем ожидание появления подсказки
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(2)); // Можно настроить время ожидания
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-select-2-option-0\"]"))); // Замените на реальный селектор подсказки

        pressEnter(element);
        return this;
    }

    public WebElementAction pressEnter (WebElement element) throws InterruptedException {
        actions.sendKeys(element, Keys.ENTER).build().perform();
        Thread.sleep(5000);
        return this;
    }


    public WebElementAction scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public WebElementAction jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click();", element);
        return this;
    }

    public WebElementAction highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].style.border='2px solid red'", element);
        return this;
    }

    public WebElementAction jsSendKeys(WebElement element, String txt) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].value = arguments[1];", element, txt);
        return this;
    }


    public WebElementAction doubleClick(WebElement element) {
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        actions.doubleClick(element).perform();
        return this;
    }

    public WebElementAction rightClick(WebElement element) {
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        actions.contextClick(element).perform();
        return this;
    }

    public WebElementAction dynamicClick(WebElement element) {
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        actions.click(element).perform();
        return this;
    }


    public WebElementAction moveToElement(WebElement element) {
        waitElementToBeVisible(element);
        actions.moveToElement(element).build().perform();
        return this;
    }
}
