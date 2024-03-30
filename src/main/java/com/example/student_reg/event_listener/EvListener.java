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

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class EvListener {

    @EventListener(StudentAddEvent.class)
    public void onAddStudent(final StudentAddEvent event) {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Пользователь добавлен !" + event.getStudent());
    }

    @EventListener(StudentDeleteEvent.class)
    public void onDeleteStudent(final StudentDeleteEvent event) {
        System.out.println("Пользователь c id " + event.getId() + "удален");
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
