/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.director;

import com.example.student_reg.events.ListCheckEvent;
import com.example.student_reg.events.ListCleanEvent;
import com.example.student_reg.events.StudentAddEvent;
import com.example.student_reg.events.StudentDeleteEvent;
import com.example.student_reg.model.Student;
import com.example.student_reg.repository.Storage;
import com.example.student_reg.validation.Validation;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Director {

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    private Storage storage;

    @Autowired
    private final Validation comandWithStr;

    private void addSt() {
        final String[] arr = comandWithStr.getStudentStrWithComand()[0].split(";");
        storage.addStudent(new Student(arr[0].trim(), arr[1].trim(), Integer.parseInt(arr[2].trim())));
    }

    private void deleteSt() {
        storage.deleteStudent(Long.parseLong(comandWithStr.getStudentStrWithComand()[0].trim()));
    }

    private void checkList() {
        storage.checkStudentsList();
    }

    private void cleanList() {
        storage.cleanStudentsList();
    }

    public void move() {
        final String comand = comandWithStr.getStudentStrWithComand()[1];
        if ("add".equals(comand)) {
            addSt();
            eventPublisher.publishEvent(new StudentAddEvent(this));
        } else if ("delete".equals(comand)) {
            deleteSt();
            eventPublisher.publishEvent(new StudentDeleteEvent(this));
        } else if ("checkList".equals(comand)) {
            checkList();
            eventPublisher.publishEvent(new ListCheckEvent(this));
        } else if ("cleanList".equals(comand)) {
            cleanList();
            eventPublisher.publishEvent(new ListCleanEvent(this));
        }
    }

    @PostConstruct
    public void postConstruct() {
        move();
    }
}
