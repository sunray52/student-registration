/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.commands;

import com.example.student_reg.scanner.Scan;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@RequiredArgsConstructor
@ShellComponent
public class Commands {

    @Autowired
    private final Scan sc;

    public String[] studentStr;

    @ShellMethod(key = "add", value = "adding a student")
    public void addStudent() {
        System.out.println("Введите значение / Пример: Дмитрий; Андронников; 52");
        final String str = sc.scanner.nextLine();
        studentStr = new String[]{"add", str};
    }

    @ShellMethod(key = "delete", value = "deleting a student")
    public void deleteStudent() {
        System.out.println("Введите id студента / Пример: 234");
        final String str = sc.scanner.nextLine();
        studentStr = new String[]{"delete", str};
    }

    @ShellMethod(key = "check", value = "check the contact list")
    public void checkStudentList() {
        studentStr = new String[]{"checkList", ""};
    }

    @ShellMethod(key = "clean", value = "clear the contact list")
    public void cleanStudentList() {
        studentStr = new String[]{"cleanList", ""};
    }
}
