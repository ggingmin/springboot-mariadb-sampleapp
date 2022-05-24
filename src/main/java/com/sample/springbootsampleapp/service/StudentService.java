package com.sample.springbootsampleapp.service;

import com.sample.springbootsampleapp.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student createStudent(Student student);
    public List<Student> findAllStudent(String name);
    public Optional<Student> findById(Long id);
    public Student editStudent(Long id, Student student);
    public void deleteStudent(Long id);
    public List<Student> findByGraduated(boolean graduated);
}
