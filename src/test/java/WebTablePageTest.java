import com.udemyqa.entities.Employee;
import com.udemyqa.pages.DemoQAPages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablePageTest extends BaseTest {

    protected DemoQAPages demoQAPages;

    @BeforeMethod
    public void setupTest() {
        demoQAPages = new DemoQAPages();
        webTablePage = demoQAPages.getWebTablePage();
    }

    @Test
    void addEmployeeTest() throws InterruptedException {




        browserHelper.open("https://demoqa.com/webtables");

//        webElementAction.click(webTablePage.addBtn);

//        Employee employee = randomUtils.addRandomEmployee();
//        Thread.sleep(5000);
//        webTablePage.fillUpNewEmployee(employee);
//        Thread.sleep(1000);

        List<Employee> employees = demoQAPages.getWebTablePage().getEmployeeFromTable();

        for (Employee employee1 : employees) {
            System.out.println(employee1);
        }

//        webTablePage.getEmployeeFromTable();
//        System.out.println(webTablePage.getEmployeeFromTable());
//        webElementAction.click(webTablePage.addBtn);
//        Thread.sleep(2000);
//        webTablePage.fillUpNewEmployee(employee);
    }
}
