/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.repository;

import com.example.student_reg.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StorageTest {

    @Test
    void shouldAddStudent() {
        final Storage storage = new Storage();

        Assertions.assertEquals(0, storage.size());

        long result = storage.addStudent(new Student("Дмитрий", "Андронников", 52));

        Assertions.assertEquals(1, storage.size());

        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldDeleteStudent() {
        final Storage storage = new Storage();

        storage.addStudent(new Student("Дмитрий", "Андронников", 52));
        long resultId = storage.addStudent(new Student("Андрей", "Маликов", 21));
        storage.addStudent(new Student("Максим", "Галкин", 23));

        Student student = storage.deleteStudent(resultId);

        Assertions.assertEquals(2, storage.size());

        assertThat(student)
                .isNotNull()
                .isEqualTo(new Student("Андрей", "Маликов", 21));

        assertThat(storage.deleteStudent(resultId))
                .isNull();
    }
}
