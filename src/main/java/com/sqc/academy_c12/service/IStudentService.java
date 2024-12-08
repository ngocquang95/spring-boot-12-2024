package com.sqc.academy_c12.service;

import com.sqc.academy_c12.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll(String name, Double fromScore, Double toScore);

    Student findById(int id);

    Student save(Student student);
}
