import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BrowserHelperTest extends BaseTest {

    @Test
    void browserHelperTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/browser-windows");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Alerts']")).click();
        Thread.sleep(2000);
        browserHelper.goBack();
        Thread.sleep(2000);
        browserHelper.goForward();
        Thread.sleep(2000);
        browserHelper.refreshThePage();
        browserHelper.goBack();
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(2000);

        browserHelper.switchToParentWindow();

        browserHelper.switchToParentWithChildClose();
        browserHelper.refreshThePage();


    }
}
