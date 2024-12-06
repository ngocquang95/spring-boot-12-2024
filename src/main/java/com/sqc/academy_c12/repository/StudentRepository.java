package com.sqc.academy_c12.repository;

import com.sqc.academy_c12.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private final List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Lê Đức Minh", 9.8),
                    new Student(2, "Khoa Nguyễn", 9.7)
            )
    );

    public List<Student> findAll() {
        return students;
    }

    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student save(Student student) {
        student.setId((int) (Math.random() * 10000000));
        students.add(student);
        return student;
    }
}
