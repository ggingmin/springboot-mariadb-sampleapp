package com.sample.springbootsampleapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_STUDENTS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "student_num")
    private String student_num;

    @Column(name = "name")
    private String name;

    @Column(name = "college")
    private String college;

    @Column(name = "major")
    private String major;

    @Column(name = "student_type")
    private String student_type;

    @Column(name = "grduated")
    private boolean graduated;

    @Column(name = "entrance_date")
    private Date entrance_date;

    public Student(
            String student_num,
            String name,
            String college,
            String major,
            String student_type,
            boolean graduated,
            Date entrance_date
    ) {
        this.student_num = student_num;
        this.name = name;
        this.college = college;
        this.major = major;
        this.student_type = student_type;
        this.graduated = graduated;
    }
}
