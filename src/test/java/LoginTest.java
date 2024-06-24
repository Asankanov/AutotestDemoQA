import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LoginTest {
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            actions = new Actions(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Увеличено время ожидания
            driver.get("https://winter2024-digitalnomads.talentlms.com/");
        }
    }

    @Test(priority = 1)
    void testLogin() {
        WebElement loginField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login']")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));

        // Здесь надо писать свой акаунт и пароль
        loginField.sendKeys("Kutman559.24");
        passwordField.sendKeys("Kutman559.24");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='submit']")));
        submitButton.click();
    }

    @Test(priority = 2)
    void toCloseAlert() {
        WebElement skipBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("skip")));
        skipBtn.click();
    }

    @Test(priority = 3)
    public void moveAndOpenLessonPage() {
        WebElement lessonsBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text()='Winter 2024 Video records']")));

        // Наведение на элемент перед кликом
        actions.moveToElement(lessonsBar).perform();
        actions.click(lessonsBar).perform();

        // Убедимся, что элемент closeHelper существует и доступен перед кликом
        WebElement closeHelper = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='close-btn']")));
        actions.moveToElement(closeHelper).perform();
        actions.click(closeHelper).perform();
    }

    @Test(priority = 4)
    void openLesson() {
        // Ждем, пока все кнопки станут видимыми
        List<WebElement> clickLastLesson = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"app\"]/main/div[2]/aside/div/div/div[3]/dd")));

        // Проверяем, что список содержит достаточно элементов
        if (clickLastLesson.size() >= 99) {
            WebElement button93 = clickLastLesson.get(98); // Индексы начинаются с 0, поэтому 93-й элемент имеет индекс 92
            wait.until(ExpectedConditions.elementToBeClickable(button93)); // Убедимся, что элемент кликабельный
            actions.moveToElement(button93).click().perform(); // Наводим и кликаем на 93-ю кнопку
        } else {
            throw new IllegalStateException("Не найдено 93 кнопки на странице");
        }
    }

//    @Test(priority = 5)
//    void settingsVideo() throws InterruptedException {
//        // Ожидание полной загрузки страницы
////        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
//
//        Thread.sleep(10000);
//
//        WebElement moveToVideo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vp-preview")));
//
//        actions.moveToElement(moveToVideo).perform();
//
//        // Ожидание видимости кнопки Play и её нажатие с помощью JavascriptExecutor, если она не кликабельна
//        WebElement playBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-labelledby='play-button-tooltip']")));
//        //        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", playBtn);
//        actions.click(playBtn).build().perform();
//
//        // Ожидание видимости кнопки Settings и её нажатие с помощью JavascriptExecutor, если она не кликабельна
////        WebElement settingsBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prefs-control-bar-button")));
////        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", settingsBtn);
//    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
