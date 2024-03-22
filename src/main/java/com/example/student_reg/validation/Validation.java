package com.example.student_reg.validation;


import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Validation {

    private String studentStr;

    public String addValidation() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите значение / Пример: Дмитрий; Андронников; 52");
        final String str = scan.nextLine();
        if (mainFilter(str)) {
            studentStr = str;
        }
        return studentStr;
    }

    public long deleteValidation() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите id студента / Пример: 234");
        final String str = scan.nextLine();
        if (str.trim().matches("^[0-9]+[0-9]+[0-9]+$")) {
            studentStr = str;
        }
        return Long.parseLong(studentStr);
    }

    private boolean mainFilter(final String str) { // проверка ФИО / номера телефона / почты / структуры отправки (... ; ... ; ...)
        final String[] arr = str.split(";");
        int count = 0;

        if (arr.length != 3) { // проверка структуры отправки (... ; ... ; ...)
            System.out.println("Вы ошиблись с кол-во полей");
            count++;
        }
        if (arr[0].split(" ").length != 1) { // проверка ФИО
            System.out.println("Вы ошиблись в Имени");
            count++;
        }
        if (arr[1].split(" ").length != 1) { // проверка ФИО
            System.out.println("Вы ошиблись в Фамилии");
            count++;
        }
        if (arr[2].trim().matches("^[0-9]+[0-9]+[0-9]+$")) { // проверка почты
            System.out.println("Вы ошиблись в возрасте");
            count++;
        }
        return count == 0;
    }
}
