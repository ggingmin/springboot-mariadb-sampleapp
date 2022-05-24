package com.sample.springbootsampleapp.controller;

import com.sample.springbootsampleapp.model.Student;
import com.sample.springbootsampleapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAll(@RequestParam(required = false) String name) {
        try {
            return ResponseEntity.ok(studentService.findAllStudent(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("/students/{id}")
    public ResponseEntity<Optional<Student>> getOneById(@PathVariable("id") long id) {
        try {
            return ResponseEntity.ok(studentService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("/students/graduated")
    public ResponseEntity<List<Student>> findByGraduated() {
        try {
            return ResponseEntity.ok(studentService.findByGraduated(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @PostMapping("/students")
    public ResponseEntity<Student> createOne(@RequestBody Student student) {
        try {
            ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(student));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateOne(@PathVariable("id") long id, @RequestBody Student student) {
        try {
            ResponseEntity.status(HttpStatus.CREATED).body(studentService.editStudent(id, student));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<HttpStatus> deleteOne(@PathVariable("id") long id) {
        try {
            studentService.deleteStudent(id);
            ResponseEntity.noContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
