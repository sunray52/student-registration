/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.comands;

import com.example.student_reg.scanner.Scan;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@RequiredArgsConstructor
@ShellComponent
public class Comands {

    @Autowired
    private final Scan sc;

    public String[] studentStr;

    public String moveChoice() {
        return "Что вы хотите сделать " + '\n' + "Добавить студента - 1 / Удалить студента - 2 / Посмотреть список студентов - 3 / Очистить список - 4";
    }

    @ShellMethod(key = "1")
    public void addStudent() {
        System.out.println("Введите значение / Пример: Дмитрий; Андронников; 52");
        final String str = sc.scanner.nextLine();
        studentStr = new String[]{"add", str};
    }

    @ShellMethod(key = "2")
    public void deleteStudent() {
        System.out.println("Введите id студента / Пример: 234");
        final String str = sc.scanner.nextLine();
        studentStr = new String[]{"delete", str};
    }

    @ShellMethod(key = "3")
    public void checkStudentList() {
        studentStr = new String[]{"checkList", ""};
    }

    @ShellMethod(key = "4")
    public void cleanStudentList() {
        studentStr = new String[]{"cleanList", ""};
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Вы вошли в приложение для контроля студентов !");
        moveChoice();
    }
}
