package com.udemyqa.pages;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class DemoQAPages {

    public PracticeFormPage practiceFormPage;
    public WebTablePage webTablePage;

    public void setUp() {
        practiceFormPage = new PracticeFormPage();
        webTablePage = new WebTablePage();
    }
}

