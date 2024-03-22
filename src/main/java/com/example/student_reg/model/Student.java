package com.example.student_reg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private final String name;
    private final String lastname;
    private final int age;
}
