package com.udemyqa.pages;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class DemoQAPages {

    public PracticeFormPage practiceFormPage = new PracticeFormPage();
    public WebTablePage webTablePage = new WebTablePage();

}

