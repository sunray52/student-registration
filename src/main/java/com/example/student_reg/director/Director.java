/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.director;

import com.example.student_reg.events.ListCheckEvent;
import com.example.student_reg.events.ListCleanEvent;
import com.example.student_reg.events.StudentAddEvent;
import com.example.student_reg.events.StudentDeleteEvent;
import com.example.student_reg.validation.Validation;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class Director {

    private final ApplicationEventPublisher eventPublisher;

    public void request() {
        System.out.println("Что вы хотите сделать ?");
        System.out.println("Добавить студента - 1 / Удалить студента - 2 / Посмотреть список студентов - 3 / Очистить список - 4");
        final Scanner scan = new Scanner(System.in);
        final String comand = scan.nextLine();
        if ("1".equals(comand)) {
            eventPublisher.publishEvent(new StudentAddEvent(this, new Validation()));
            request();
        } else if ("2".equals(comand)) {
            eventPublisher.publishEvent(new StudentDeleteEvent(this, new Validation()));
            request();
        } else if ("3".equals(comand)) {
            eventPublisher.publishEvent(new ListCheckEvent(this));
            request();
        } else if ("4".equals(comand)) {
            eventPublisher.publishEvent(new ListCleanEvent(this));
            request();
        }
    }

    @PostConstruct
    public void postConstruct() {
        request();
    }
}
