package com.sqc.academy_c12.repository;

import com.sqc.academy_c12.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    Student findById(int id);

    Student save(Student student);
}
