
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

    public StudentDeleteEvent(Object source, Validation studentInfo) {
        super(source);
        this.studentInfo = studentInfo;
    }
}
