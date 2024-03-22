package com.example.student_reg.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class ListCheckEvent extends ApplicationEvent {

    public ListCheckEvent(Object source) {
        super(source);
    }
}
