/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.repository;

import com.example.student_reg.model.Student;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class Storage {

    private final ConcurrentMap<Long, Student> studentList = new ConcurrentHashMap<>();
    private final AtomicLong id = new AtomicLong();

    public void addStudent(final Student student) {
        studentList.put(id.incrementAndGet(), student);
    }

    public void deleteStudent(final long id) {
        studentList.remove(id);
    }

    public void checkStudentsList() {
        for (Student student : studentList.values()) {
            System.out.println(student.getName() + " ;" + student.getLastname() + " ;" + student.getAge());
        }
    }

    public int size() {
        return studentList.size();
    }

    public void cleanStudentsList() {
        studentList.clear();
    }
}

