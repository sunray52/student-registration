/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

//getter & setter не должно быть
@RequiredArgsConstructor
@Component
public class Validation {

    public String addValidation(String str) {
        if (mainFilter(str)) {
            return str;
        }
        throw new RuntimeException("Вы ошиблись при вводе данных");
    }

    public long deleteValidation(String str) {
        if (str.trim().matches("^[0-9]+[0-9]+[0-9]+$")) {
            return Long.parseLong(str.trim());
        }
        throw new RuntimeException("Вы ошиблись при вводе id");
    }

    private boolean mainFilter(final String str) { // проверка ФИО / номера телефона / почты / структуры отправки (... ; ... ; ...)
        final String[] arr = str.split(";");
        int count = 0;

        if (arr.length != 3) { // проверка структуры отправки (... ; ... ; ...)
            System.out.println("Вы ошиблись с кол-во полей");
            count++;
        }
        if (arr[0].trim().split(" ").length != 1) { // проверка ФИО
            System.out.println("Вы ошиблись в Имени");
            count++;
        }
        if (arr[1].trim().split(" ").length != 1) { // проверка ФИО
            System.out.println("Вы ошиблись в Фамилии");
            count++;
        }
        if (arr[2].trim().matches("^[0-9]+[0-9]+[0-9]+$")) { // проверка почты
            System.out.println("Вы ошиблись в возрасте");
            count++;
        }
        return count == 0;
    }
}
