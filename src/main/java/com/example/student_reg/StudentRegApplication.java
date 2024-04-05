/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/student-registration
 *
 * Licensed under the Apache License 2.0
 */

package com.example.student_reg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

@SpringBootApplication
public class StudentRegApplication {

	public static void main(final String[] args) {
		SpringApplication.run(StudentRegApplication.class, args);
	}

	@Bean
	Scanner scanner() {
		return new Scanner(System.in, UTF_8);
	}
}
