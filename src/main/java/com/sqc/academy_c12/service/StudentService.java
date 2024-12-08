package com.sqc.academy_c12.service;

import com.sqc.academy_c12.entity.Student;
import com.sqc.academy_c12.repository.IStudentRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService implements IStudentService {
    IStudentRepository studentRepository;

    @Override
    public List<Student> findAll(String name, Double fromScore, Double toScore) {
        return studentRepository.findByAttrNativeQuery(name, fromScore, toScore);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
