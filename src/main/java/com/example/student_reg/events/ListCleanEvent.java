package com.example.student_reg.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class ListCleanEvent extends ApplicationEvent {

    public ListCleanEvent(Object source) {
        super(source);
    }
}
