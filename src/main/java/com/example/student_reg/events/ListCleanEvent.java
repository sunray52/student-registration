/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.events;

import org.springframework.context.ApplicationEvent;

public class ListCleanEvent extends ApplicationEvent {

    public ListCleanEvent(final Object source) {
        super(source);
    }
}
