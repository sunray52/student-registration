/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.controller;

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
                .isEqualTo(1);

    }
}

//    @Test
//    public void shouldDeleteStudentCorrectly() {
//        verify(storage).addStudent(
//                new Student("Дмитрий", "Андронников", 52)
//        );
//
//        final String id = "1 ";
//        Mockito.when(scanner.nextLine()).thenReturn(id);
//
//        verify(controller).deleteStudent();
//
//        final int checkSize = verify(storage).size();
//
//        Assertions.assertEquals(0, checkSize);
//    }
//}
