/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.controller;

import com.example.student_reg.events.ListCheckEvent;
import com.example.student_reg.events.ListCleanEvent;
import com.example.student_reg.events.StudentAddEvent;
import com.example.student_reg.events.StudentDeleteEvent;
import com.example.student_reg.model.Student;
import com.example.student_reg.repository.Storage;
import com.example.student_reg.validation.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;


import java.util.Scanner;

@RequiredArgsConstructor
@ShellComponent
public class Controller {

    private final Scanner scanner;

    private final Validation validation;

    private final Storage storage;

    private final ApplicationEventPublisher eventPublisher;

    @ShellMethod(key = "add", value = "adding a student")
    public void addStudent() {
        System.out.println("Введите значение / Пример: Дмитрий; Андронников; 52");
        System.out.println(Thread.currentThread().getName());
        final String str = scanner.nextLine();
        final String newStr = validation.addValidation(str);
        final String[] arr = newStr.split(";");
        final Student student = new Student(arr[0].trim(), arr[1].trim(), Integer.parseInt(arr[2].trim()));
        storage.addStudent(student);
        eventPublisher.publishEvent(new StudentAddEvent(this, student));
    }

    @ShellMethod(key = "delete", value = "deleting a student")
    public void deleteStudent() {
        System.out.println("Введите id студента / Пример: 234");
        final String str = scanner.nextLine();
        final long id = validation.deleteValidation(str);
        storage.deleteStudent(id);
        eventPublisher.publishEvent(new StudentDeleteEvent(this, id));
    }

    @ShellMethod(key = "check", value = "check the contact list")
    public void checkList() {
        storage.checkStudentsList();
        eventPublisher.publishEvent(new ListCheckEvent(this));
    }

    @ShellMethod(key = "clean", value = "clear the contact list")
    public void cleanList() {
        storage.cleanStudentsList();
        eventPublisher.publishEvent(new ListCleanEvent(this));
    }

    public String lineRequest() {
        return scanner.nextLine();
    }
}
