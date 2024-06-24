package com.udemyqa.utils;

import com.github.javafaker.Faker;
import com.udemyqa.entities.Employee;
import com.udemyqa.entities.PracticeFormEntity;

import java.security.PublicKey;
import java.util.Random;

public class RandomUtils {
    Faker faker = new Faker();
    Random random = new Random();

    public PracticeFormEntity generateRandomPracticeFormEntity() {
        PracticeFormEntity practiceFormEntity = new PracticeFormEntity();
        practiceFormEntity.setFirstName(faker.name().firstName());
        practiceFormEntity.setLastName(faker.name().lastName());
        practiceFormEntity.setUserEmail(faker.internet().emailAddress());
        practiceFormEntity.setUserNumber("077" + faker.phoneNumber().subscriberNumber(7));

        practiceFormEntity.setUserSubjectInput("Math");
        practiceFormEntity.setUserCurrentAddress(faker.address().fullAddress());

//        practiceFormEntity.setYear(String.valueOf(random.nextInt(1945, 2006)));


        return practiceFormEntity;
    }

    public Employee addRandomEmployee() {
        Employee employee = new Employee();

        employee.setFirstName(faker.name().firstName());
        employee.setLastName(faker.name().lastName());
        employee.setEmail(faker.internet().emailAddress());
        employee.setAge(faker.number().numberBetween(18, 80));
        employee.setSalary(faker.number().numberBetween(5000, 50000));
        employee.setDepartment(faker.job().position());
        return employee;
    }




}
