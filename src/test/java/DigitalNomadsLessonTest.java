import com.udemyqa.drivers.DriverManager;
import com.udemyqa.entities.DigitalNomadsLessonEntity;
import com.udemyqa.helper.BrowserHelper;
import com.udemyqa.helper.WebElementAction;
import com.udemyqa.pages.DigitalNomadsLessonsPage;
import com.udemyqa.utils.DataBaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DigitalNomadsLessonTest extends BaseTest{

//    public WebDriver driver = DriverManager.getDriver();
//    public WebElementAction webElementAction = new WebElementAction();
//    public BrowserHelper browserHelper = new BrowserHelper(driver);
//    public DataBaseUtils dataBaseUtils = new DataBaseUtils();
//    public DigitalNomadsLessonsPage digitalNomadsLessonsPage = new DigitalNomadsLessonsPage();


    @Test(description = "Open lesson and go studiing")
    void goStudy(){
        browserHelper.open("https://winter2024-digitalnomads.talentlms.com/");

        webElementAction.click(digitalNomadsLessonsPage.login)
        .sendKeys(digitalNomadsLessonsPage.login, "Kutman559.24");

//        DigitalNomadsLessonEntity digitalNomadsLessonEntity = dataBaseUtils.toLogin();
//        digitalNomadsLessonsPage.fillUpLoginForm(digitalNomadsLessonEntity);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlToBe("https://winter2024-digitalnomads.talentlms.com/"));
//        Assert.assertTrue(true);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login']")));
        webElementAction.scrollToElement(element);

    }
}
