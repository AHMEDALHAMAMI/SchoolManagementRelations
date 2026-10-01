package org.example.schoolmanagement.Controller;

import org.example.schoolmanagement.Api.ApiResponse;
import org.example.schoolmanagement.DTO.TeacherDTO;
import org.example.schoolmanagement.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllTeachers() {

        return ResponseEntity.status(200).body(
                teacherService.getAllTeachers()
        );
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(
            @Valid @RequestBody TeacherDTO teacherDTO) {

        teacherService.addTeacher(teacherDTO);

        return ResponseEntity.status(200).body(
                new ApiResponse("Teacher added successfully")
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(
            @PathVariable Integer id,
            @Valid @RequestBody TeacherDTO teacherDTO) {

        teacherService.updateTeacher(id, teacherDTO);

        return ResponseEntity.status(200).body(
                new ApiResponse("Teacher updated successfully")
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id) {

        teacherService.deleteTeacher(id);

        return ResponseEntity.status(200).body(
                new ApiResponse("Teacher deleted successfully")
        );
    }

    @GetMapping("/get/{id}/details")
    public ResponseEntity<?> getTeacherDetails(@PathVariable Integer id) {

        return ResponseEntity.status(200).body(
                teacherService.getTeacherDetails(id)
        );
    }
}