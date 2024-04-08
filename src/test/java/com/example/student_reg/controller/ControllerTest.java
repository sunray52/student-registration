/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.controller;

import com.example.student_reg.model.Student;
import com.example.student_reg.repository.Storage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @MockBean
    private Scanner scanner;

    @Autowired
    private Controller controller;

    @Autowired
    private Storage storage;

    @Test
    public void shouldAddStudentsCorrectly() {
        final String testStr1 = "Дмитрий; Андронников; 52";
        Mockito.when(scanner.nextLine()).thenReturn(testStr1);

        controller.addStudent();

        assertThat(storage.size())
                .as("size after additions")
                .isEqualTo(1);
    }

    @Test
    public void shouldDeleteStudentCorrectly() {
        final Student testStudent = new Student("Дмитрий","Андронников",52);
        final long lastStudentId = storage.addStudent(testStudent);

        assertThat(storage.size())
                .isEqualTo(1);

        Mockito.when(scanner.nextLine()).thenReturn(String.valueOf(lastStudentId));

        final Student lastDeletedStudent = controller.deleteStudent();

        assertThat(storage.size())
                .as("size after deletion")
                .isEqualTo(0);

        assertThat(lastDeletedStudent)
                .isNotNull()
                .isEqualTo(testStudent);
    }
}
