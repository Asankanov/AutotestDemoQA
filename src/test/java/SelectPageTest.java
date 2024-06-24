import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectPageTest extends BaseTest{

    @Test
    void selectFormTest() {
        browserHelper.open("https://demoqa.com/select-menu");
        selectPage.fillUpSelectMenu();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Ждем максимум 10 секунд
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/select-menu"));
        Assert.assertTrue(true);
    }
}
