package com.udemyqa.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class PracticeFormEntity {

    private String firstName;
    private String lastName;
    private String userEmail;
    private int userGender;
    private String userNumber;
    private String userBirthDay;
    private String userSubjectInput;
    private int userHobbies;
    private String userPicture;
    private String userCurrentAddress;
    private String userState;
    private String userCity;

    private String month;
    private String year;
    private String day;
}
