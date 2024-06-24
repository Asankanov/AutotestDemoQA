package com.udemyqa.pages;

import com.udemyqa.drivers.DriverManager;
import com.udemyqa.entities.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WebTablePage extends BasePage {

    @FindBy(id = "addNewRecordButton")
    public WebElement addBtn;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "age")
    public WebElement age;

    @FindBy(id = "salary")
    public WebElement salary;

    @FindBy(id = "department")
    public WebElement department;

    @FindBy(id = "submit")
    public WebElement submit;


    public WebTablePage fillUpNewEmployee(Employee employee) {
        webElementActions.click(addBtn)
                .sendKeys(firstName, employee.getFirstName())
                .sendKeys(lastName, employee.getLastName())
                .sendKeys(userEmail, employee.getEmail())
                .sendKeys(age, String.valueOf(employee.getAge()))
                .sendKeys(salary, String.valueOf(employee.getSalary()))
                .sendKeys(department, employee.getDepartment())
                .click(submit);
        return this;
    }

    public List<Employee> getEmployeeFromTable() {
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        ArrayList<Employee> employees = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".tr-td"));

            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]", "");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty() || salaryText.isEmpty() || department.isEmpty()) {
                continue;
            }

            int age = Integer.parseInt(ageText.trim());
            int salary = Integer.parseInt(salaryText.trim());

            employees.add(new Employee(firstName, lastName, age, email, salary, department));
        }

        return employees;
    }

}
