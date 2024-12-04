package com.sqc.academy_c12.controller;

import com.sqc.academy_c12.Student;
import com.sqc.academy_c12.dto.ApiResponse;
import com.sqc.academy_c12.exception.ApiException;
import com.sqc.academy_c12.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Lê Đức Minh", 9.8),
                    new Student(2, "Khoa Nguyễn", 9.7)
            )
    );

    @GetMapping
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.ok(ApiResponse.builder()
                .data(students)
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return ResponseEntity.ok(ApiResponse.<Student>builder()
                        .data(student)
                        .build());
            }
        }

        throw new ApiException(ErrorCode.STUDENT_NOT_EXIST);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> addStudent(@RequestBody Student student) {
        student.setId((int) (Math.random() * 10000000));
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<Student>builder()
                        .data(student)
                        .build());
    }
}
