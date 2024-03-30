///*
// * Copyright (c) 2019-2024. Luka Pavlov and others.
// * https://github.com/sunRay52/student-registration
// *
// * Licensed under the Apache License 2.0
// */
//
//package com.example.student_reg.director;
//
//import com.example.student_reg.events.ListCheckEvent;
//import com.example.student_reg.events.ListCleanEvent;
//import com.example.student_reg.events.StudentAddEvent;
//import com.example.student_reg.events.StudentDeleteEvent;
//import com.example.student_reg.model.Student;
//import com.example.student_reg.repository.Storage;
//import com.example.student_reg.validation.Validation;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.stereotype.Component;
//
//@RequiredArgsConstructor
//@Component
//public class Director {
//
//    private final ApplicationEventPublisher eventPublisher;
//
//    private final  Storage storage;
//
//    private void addSt() {
//        final String[] arr = comandWithStr.getStudentStrWithComand()[0].split(";");
//        storage.addStudent(new Student(arr[0].trim(), arr[1].trim(), Integer.parseInt(arr[2].trim())));
//    }
//
//    private void deleteSt() {
//        storage.deleteStudent(Long.parseLong(comandWithStr.getStudentStrWithComand()[0].trim()));
//    }
//
//    private void checkList() {
//        storage.checkStudentsList();
//    }
//
//    private void cleanList() {
//        storage.cleanStudentsList();
//    }
//
//
//
//    @PostConstruct
//    public void postConstruct() {
//        move();
//    }
//}
