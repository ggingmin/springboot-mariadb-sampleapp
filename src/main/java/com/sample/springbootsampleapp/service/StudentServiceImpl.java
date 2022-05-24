package com.sample.springbootsampleapp.service;

import com.sample.springbootsampleapp.model.Student;
import com.sample.springbootsampleapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        try {
            return studentRepository.save(new Student(
                    student.getStudent_num(),
                    student.getName(),
                    student.getCollege(),
                    student.getMajor(),
                    student.getStudent_type(),
                    student.isGraduated(),
                    student.getEntrance_date()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> findAllStudent(String name) {
        try {
            List<Student> students = new ArrayList<>();
            if (name == null) {
                studentRepository.findAll().forEach(students::add);
            } else {
                studentRepository.findByNameContaining(name).forEach(students::add);
            }
            if (students.isEmpty()) {
                return null;
            }
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Optional<Student> findById(Long id) {
        try {
            Optional<Student> studentData = studentRepository.findById(id);
            if (studentData.isPresent()) {
                return studentData;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Student> findByGraduated(boolean graduated) {
        try {
            List<Student> students = studentRepository.findByGraduated(graduated);
            if (!students.isEmpty()) {
                return students;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student editStudent(Long id, Student student) {
        try {
            Optional<Student> studentData = studentRepository.findById(id);
            if (studentData.isPresent()) {
                Student _student = studentData.get();
                _student.setStudent_num(student.getStudent_num());
                _student.setName(student.getName());
                _student.setCollege(student.getCollege());
                _student.setMajor(student.getMajor());
                _student.setStudent_type(student.getStudent_type());
                _student.setGraduated(student.isGraduated());
                return _student;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void deleteStudent(Long id) {
        try {
            studentRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
