/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.events;

import com.example.student_reg.validation.Validation;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Getter
@Component
public class StudentDeleteEvent extends ApplicationEvent {

    @Autowired
    private final Validation studentInfo;

    public StudentDeleteEvent(final Object source, final Validation studentInfo) {
        super(source);
        this.studentInfo = studentInfo;
    }
}
