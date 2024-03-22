package com.example.student_reg.event_listener;

import com.example.student_reg.events.ListCheckEvent;
import com.example.student_reg.events.ListCleanEvent;
import com.example.student_reg.events.StudentAddEvent;
import com.example.student_reg.events.StudentDeleteEvent;
import com.example.student_reg.model.Student;
import com.example.student_reg.repository.Storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EvListener {

    @Autowired
    private Storage storage;

    @EventListener(StudentAddEvent.class)
    public void onAddStudent(StudentAddEvent event) {
        String studentStr = event.getStudentInfo().addValidation();
        String[] arr = studentStr.split(";");
        storage.addStudent(new Student(arr[0], arr[1], Integer.parseInt(arr[2]) ));
    }

    @EventListener(StudentDeleteEvent.class)
    public void onDeleteStudent(StudentDeleteEvent event) {
        long studentId = event.getStudentInfo().deleteValidation();
        storage.deleteStudent(studentId);
    }

    @EventListener(ListCheckEvent.class)
    public void onCheckList() {
        storage.checkStudentsList();
    }

    @EventListener(ListCleanEvent.class)
    public void onCleanList(){
        storage.cleanStudentsList();
    }
}
