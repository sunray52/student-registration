/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.event_listener;

import com.example.student_reg.events.ListCheckEvent;
import com.example.student_reg.events.ListCleanEvent;
import com.example.student_reg.events.StudentAddEvent;
import com.example.student_reg.events.StudentDeleteEvent;
import com.example.student_reg.repository.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EvListener {

    @Autowired
    private Storage storage;

    @EventListener(StudentAddEvent.class)
    public void onAddStudent(final StudentAddEvent event) {
        System.out.println("Пользователь добавлен !");
    }

    @EventListener(StudentDeleteEvent.class)
    public void onDeleteStudent(final StudentDeleteEvent event) {
        System.out.println("Пользователь удален.");
    }

    @EventListener(ListCheckEvent.class)
    public void onCheckList() {
        System.out.println("Только что вы проверили свой список контактов :)");
    }

    @EventListener(ListCleanEvent.class)
    public void onCleanList() {
        System.out.println("Теперь список числ :(");
    }
}
