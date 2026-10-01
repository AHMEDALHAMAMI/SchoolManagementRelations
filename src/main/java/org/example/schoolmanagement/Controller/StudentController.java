package org.example.schoolmanagement.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.schoolmanagement.Api.ApiResponse;
import org.example.schoolmanagement.DTO.StudentDTO;
import org.example.schoolmanagement.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@Valid @RequestBody StudentDTO studentDTO) {
        studentService.addStudent(studentDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Student added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @Valid @RequestBody StudentDTO studentDTO) {
        studentService.updateStudent(id, studentDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Student updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("Student deleted successfully"));
    }

    @PutMapping("/change-major/{student_id}/{major}")
    public ResponseEntity<?> changeMajor(@PathVariable Integer student_id, @PathVariable String major) {
        studentService.changeMajor(student_id, major);
        return ResponseEntity.status(200).body(new ApiResponse("Student major changed successfully"));
    }

    @PutMapping("/add-course/{student_id}/{course_id}")
    public ResponseEntity<?> addCourseToStudent(@PathVariable Integer student_id, @PathVariable Integer course_id) {
        studentService.addCourseToStudent(student_id, course_id);
        return ResponseEntity.status(200).body(new ApiResponse("Course added to student successfully"));
    }
}