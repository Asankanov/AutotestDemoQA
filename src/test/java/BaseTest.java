import com.udemyqa.drivers.DriverManager;
import com.udemyqa.helper.AlertHelper;
import com.udemyqa.helper.BrowserHelper;
import com.udemyqa.helper.DropdownHelper;
import com.udemyqa.helper.WebElementAction;
import com.udemyqa.pages.*;
import com.udemyqa.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    protected WebElementAction webElementAction;

    protected PracticeFormPage practiceFormPage;

    protected RandomUtils randomUtils;

//    protected AlertsPage alertsPage;

//    protected AlertHelper alertHelper;

//    protected BrowserHelper browserHelper;

//    protected ButtonsPage buttonsPage;

    protected MenuPage menuPage;

    protected ProgressBarPage progressBarPage;

//    protected SelectPage selectPage;

//    protected DropdownHelper dropdownHelper;

//    protected WebTablePage webTablePage;

    protected DemoQAPages demoQAPages;

    //digitalNomads
//    protected DigitalNomadsLessonsPage digitalNomadsLessonsPage;


    @BeforeClass(alwaysRun = true)
    public void setUp() {

        driver = DriverManager.getDriver();

        webElementAction = new WebElementAction();

        practiceFormPage = new PracticeFormPage();

        randomUtils = new RandomUtils();

//        alertsPage = new AlertsPage();
//
//        alertHelper = new AlertHelper(driver);
//
//        browserHelper = new BrowserHelper(driver);
//
//        buttonsPage = new ButtonsPage();

        menuPage = new MenuPage();

        progressBarPage = new ProgressBarPage();

//        selectPage = new SelectPage(driver);
//
//        dropdownHelper = new DropdownHelper(driver);
//
//        webTablePage = new WebTablePage();


        demoQAPages = new DemoQAPages();

        demoQAPages.setUp();


        //digitalNomads
//        digitalNomadsLessonsPage = new DigitalNomadsLessonsPage();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.closeDriver();
    }
}
