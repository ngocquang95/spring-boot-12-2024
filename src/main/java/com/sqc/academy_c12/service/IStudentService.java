package com.sqc.academy_c12.service;

import com.sqc.academy_c12.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    Student findById(int id);

    Student save(Student student);
}
