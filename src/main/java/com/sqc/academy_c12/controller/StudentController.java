package com.sqc.academy_c12.controller;

import com.sqc.academy_c12.dto.ApiResponse;
import com.sqc.academy_c12.exception.ApiException;
import com.sqc.academy_c12.exception.ErrorCode;
import com.sqc.academy_c12.model.Student;
import com.sqc.academy_c12.service.IStudentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {
    IStudentService studentService;

    @GetMapping
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.ok(ApiResponse.builder()
                .data(studentService.findAll())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable int id) {
        Student student = studentService.findById(id);
        if (student != null) {
            return ResponseEntity.ok(ApiResponse.<Student>builder()
                    .data(student)
                    .build());
        }

        throw new ApiException(ErrorCode.STUDENT_NOT_EXIST);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> addStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<Student>builder()
                        .data(studentService.save(student))
                        .build());
    }
}
