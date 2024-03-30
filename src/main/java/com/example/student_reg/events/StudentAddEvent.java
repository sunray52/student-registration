/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.events;

import com.example.student_reg.model.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StudentAddEvent extends ApplicationEvent {

    private final Student student;

    public StudentAddEvent(final Object source, final Student student) {
        super(source);
        this.student = student;
    }
}
