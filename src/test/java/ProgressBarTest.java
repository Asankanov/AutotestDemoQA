import com.udemyqa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProgressBarTest extends BaseTest {

    @Test
    void progressBarTest() throws InterruptedException {

        // Открытие целевого URL
        browserHelper.open("https://demoqa.com/progress-bar");

        // Нажатие на кнопку запуска
        webElementAction.click(progressBarPage.startStopButton);

        // Создание экземпляра WebDriverWait
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        // Ожидание, пока индикатор прогресса достигнет 52%
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                WebElement progressBar = driver.findElement(By.cssSelector(".progress-bar"));
                int value = Integer.parseInt(progressBar.getAttribute("aria-valuenow"));
                if (value >= 48) {
                    webElementAction.click(progressBarPage.startStopButton);
                    return true;
                }
                return false;
            }
        });

        // Печать текущего значения индикатора прогресса
        System.out.println(progressBarPage.valueNow.getAttribute("aria-valuenow"));
    }
}
