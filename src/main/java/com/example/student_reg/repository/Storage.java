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

    public long addStudent(final Student student) {
        final long studentId = id.incrementAndGet();
        studentList.put(studentId, student);
        return studentId;
    }

    public Student deleteStudent(final long id) {
        return studentList.remove(id);
    }

    public void checkStudentsList() {
        for (Student student : studentList.values()) {
            System.out.println(student.getName() + "; " + student.getLastname() + "; " + student.getAge());
        }
    }

    public int size() {
        return studentList.size();
    }

    public void cleanStudentsList() {
        studentList.clear();
    }
}

