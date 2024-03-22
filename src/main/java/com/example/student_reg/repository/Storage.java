package com.example.student_reg.repository;

import com.example.student_reg.model.Student;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@NoArgsConstructor(force = true)
public class Storage {

    private Map<Long, Student> studentList;
    private Long id = 0L;

    public Storage(Map<Long, Student> studentList) {
        this.studentList = studentList;
    }


    public void addStudent(Student student) {
        studentList.put(id, student);
        id++;
    }

    public void deleteStudent(long id) {
        studentList.remove(id);
    }

    public void checkStudentsList() {
        for(Student student : studentList.values()) {
            System.out.println(student.getName() + " ;" + student.getLastname() + " ;" + student.getAge());
        }
    }

    public void cleanStudentsList() {
        studentList.clear();
    }

    @PostConstruct
    private void postConstruct(){
        studentList = (Map<Long, Student>) new Storage(new HashMap<>());
    }
}

