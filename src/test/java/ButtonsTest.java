import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    @Test(groups = {"Smoke", "UI", "1411"}, description = "Verify double click button is working property")
    public void doubleClickBtnTest() throws InterruptedException {

        browserHelper.open("https://demoqa.com/buttons");

        webElementAction.doubleClick(buttonsPage.doubleClickBtn);
        Thread.sleep(2000);
        Assert.assertEquals(buttonsPage.doubleClickMassage.getText(),
                "You have done a double click");
    }

    @Test(groups = {"Smoke", "UI", "1412"}, description = "Verify right click button is working property")
    public void rightClickBtnTest() {

        browserHelper.open("https://demoqa.com/buttons");

        webElementAction.rightClick(buttonsPage.rightClickBtn);
        Assert.assertEquals(buttonsPage.rightClickMassage.getText(), "You have done a right click");
    }

    @Test(groups = {"Smoke", "UI", "1413"}, description = "Verify dynamic click button is working property")
    public void dynamicClickTest() throws InterruptedException {

        browserHelper.open("https://demoqa.com/buttons");

        webElementAction.click(buttonsPage.dynamicClickBtn);
        Thread.sleep(3000);
        Assert.assertEquals(buttonsPage.dynamicClickMassage.getText(), "You have done a dynamic click");
    }
}
