package com.udemyqa.pages;

import lombok.*;
import org.testng.annotations.BeforeClass;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class DemoQAPages {

    public PracticeFormPage practiceFormPage = new PracticeFormPage();
    public WebTablePage webTablePage = new WebTablePage();

//    protected WebTablePage webTablePage;
//
//    @BeforeClass(alwaysRun = true)
//    public void setUp() {
//        webTablePage = new WebTablePage();
//    }





}

