/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.controller;

import com.example.student_reg.model.Student;
import com.example.student_reg.repository.Storage;
import com.example.student_reg.validation.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @Mock
    private Storage storage;

    @Mock
    private Validation validation;

    @Mock
    private Scanner scanner;

    @InjectMocks
    private Controller controller;

    @Test
    public void shouldAddStudentsCorrectly() {
        final String testStr1 = "Дмитрий; Андронников; 52";
        Mockito.when(scanner.nextLine()).thenReturn(testStr1);

        verify(controller).addStudent();

        final int checkSize = verify(storage).size();

        Assertions.assertEquals(1, checkSize);
    }

    @Test
    public void shouldDeleteStudentCorrectly() {
        verify(storage).addStudent(
                new Student("Дмитрий", "Андронников", 52)
        );

        final String id = "1 ";
        Mockito.when(scanner.nextLine()).thenReturn(id);

        verify(controller).deleteStudent();

        final int checkSize = verify(storage).size();

        Assertions.assertEquals(0, checkSize);
    }
}
