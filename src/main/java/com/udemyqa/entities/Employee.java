package com.udemyqa.entities;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Employee {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private int salary;
    private String department;

}
