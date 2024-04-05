/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StudentDeleteEvent extends ApplicationEvent {

    private final long id;

    public StudentDeleteEvent(final Object source, final long id) {
        super(source);
        this.id = id;
    }
}
