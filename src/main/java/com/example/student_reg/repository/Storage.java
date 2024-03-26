/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.repository;

import com.example.student_reg.model.Student;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Storage {

    private final Map<Long, Student> studentList = new HashMap<>();
    private Long id = 0L;

    public void addStudent(final Student student) {
        studentList.put(id, student);
        id++;
    }

    public void deleteStudent(final long id) {
        studentList.remove(id);
    }

    public void checkStudentsList() {
        for (Student student : studentList.values()) {
            System.out.println(student.getName() + " ;" + student.getLastname() + " ;" + student.getAge());
        }
    }

    public void cleanStudentsList() {
        studentList.clear();
    }
}

