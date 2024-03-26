/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg.scanner;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Scan {
    public Scanner scanner = new Scanner(System.in);
}
