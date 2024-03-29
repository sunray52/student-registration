/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.validation;

import com.example.student_reg.commands.Commands;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Getter

@Component
public class Validation {

    @Autowired
    private Commands command;

    private final String[] studentStrWithComand = new String[2];

    public Validation(Commands command) {
        this.command = command;
        controller(this.command);
    }

    public void addValidation() {
        final Scanner scan = new Scanner(System.in);
        System.out.println("Введите значение / Пример: Дмитрий; Андронников; 52");
        final String str = scan.nextLine();
        if (mainFilter(str)) {
            final StringBuilder newStr = new StringBuilder();
            final String[] arr = str.split(";");
            for (String el : arr) {
                newStr.append(el.trim());
            }
            studentStrWithComand[0] = String.valueOf(newStr);
        }
    }

    public void deleteValidation() {
        final Scanner scan = new Scanner(System.in);
        System.out.println("Введите id студента / Пример: 234");
        final String str = scan.nextLine();
        if (str.trim().matches("^[0-9]+[0-9]+[0-9]+$")) {
            studentStrWithComand[0] = str.trim();
        }
    }
    public void controller(Commands command) {
        if ("add".equals(command.studentStr[0])) {
            addValidation();
        } else if ("delete".equals(command.studentStr[0])) {
            deleteValidation();
        } else if ("checkList".equals(command.studentStr[0])) {
            studentStrWithComand[1] = "checkList";
        } else if ("cleanList".equals(command.studentStr[0])) {
            studentStrWithComand[1] = "cleanList";
        }
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
