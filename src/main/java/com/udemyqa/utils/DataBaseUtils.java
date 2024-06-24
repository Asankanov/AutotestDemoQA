package com.udemyqa.utils;

import com.udemyqa.entities.DigitalNomadsLessonEntity;

public class DataBaseUtils {

    public DigitalNomadsLessonEntity toLogin() {
        DigitalNomadsLessonEntity digitalNomadsLessonEntity = new DigitalNomadsLessonEntity();
        digitalNomadsLessonEntity.setLogin("Kutman559.24");
        digitalNomadsLessonEntity.setPassword("Kutman559.24");
        return digitalNomadsLessonEntity;
    }
}
