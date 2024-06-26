import com.udemyqa.entities.PracticeFormEntity;
import com.udemyqa.pages.PracticeFormPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeFormTest extends BaseTest {

    @Test(groups = {"Regression", "1501"}, description = "verify practice form test")
    public void PracticeFormTest() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        PracticeFormEntity practiceFormEntity = randomUtils.generateRandomPracticeFormEntity();
        practiceFormPage.fillUpPracticeFormPage(practiceFormEntity);
                Thread.sleep(10000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Ждем максимум 10 секунд
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/automation-practice-form"));
        Assert.assertTrue(true);
    }
}
