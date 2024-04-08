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

        assertThat(storage.size())
                .isEqualTo(0);

        final long result = storage.addStudent(new Student("Дмитрий", "Андронников", 52));

        assertThat(storage.size())
                .isEqualTo(1);

        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    void shouldDeleteStudent() {
        final Storage storage = new Storage();

        storage.addStudent(new Student("Дмитрий", "Андронников", 52));
        final long resultId = storage.addStudent(new Student("Андрей", "Маликов", 21));
        storage.addStudent(new Student("Максим", "Галкин", 23));

        final Student student = storage.deleteStudent(resultId);

        assertThat(storage.size())
                .isEqualTo(2);

        assertThat(student)
                .isNotNull()
                .isEqualTo(new Student("Андрей", "Маликов", 21));

        assertThat(storage.deleteStudent(resultId))
                .isNull();
    }
}
