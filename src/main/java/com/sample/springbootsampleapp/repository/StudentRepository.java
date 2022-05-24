package com.sample.springbootsampleapp.repository;

import com.sample.springbootsampleapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByGraduated(boolean graduated);
    List<Student> findByNameContaining(String name);
}
