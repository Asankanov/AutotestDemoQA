import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MenuPageTest extends BaseTest{

    @Test (groups = {"Smoke",  "1410"}, description = "MenuPageTest")
    public void menuPageTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/menu");

        webElementAction.moveToElement(menuPage.mainItem2);

        Thread.sleep(3000);

        webElementAction.waitElementToBeVisible(menuPage.subList).moveToElement(menuPage.subList);
        Thread.sleep(3000);



    }
}
