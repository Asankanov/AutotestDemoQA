import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    void alertTest() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(1000);
        webElementAction.click(alertsPage.firstAlertBtn);
        Thread.sleep(1000);
        alertHelper.dismissAlert();
    }

    @Test
    void timerAlertTest() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(1000);
        webElementAction.click(alertsPage.secondAlertBtn);
        Thread.sleep(1000);
        alertHelper.acceptAlertIfPresent();
    }

    @Test
    void confirmAlertTest() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(1000);
        webElementAction.click(alertsPage.thirdAlertBtn);
        Thread.sleep(1000);
        alertHelper.acceptAlert();
        Thread.sleep(1000);
        webElementAction.click(alertsPage.thirdAlertBtn);
        Thread.sleep(1000);
        alertHelper.dismissAlert();
        Thread.sleep(1000);
    }

    @Test
    void promptAlertTest() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(1000);
        webElementAction.click(alertsPage.fourthAlertBtn);
        Thread.sleep(1000);
        alertHelper.acceptPrompt("Test accept");
        Thread.sleep(1000);
        webElementAction.click(alertsPage.fourthAlertBtn);
        Thread.sleep(1000);
        alertHelper.dismissPrompt("Test dismiss");
        Thread.sleep(1000);
    }


}
