package com.secure.notes.controller;

import com.secure.notes.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students =new ArrayList<>(List.of(
            new Student(1,"saikiran",965),
            new Student(2,"kiran",852)
    ));


    @GetMapping("/students")
    private List<Student> getStudents(){
        return students;
    }
    @PostMapping("/students")
    private Student addStudents(@RequestBody Student student){
        students.add(student);
        return student;
    }
    @GetMapping("/csrf")
    public CsrfToken csrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");

    }

}
