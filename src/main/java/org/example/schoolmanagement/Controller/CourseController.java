package org.example.schoolmanagement.Controller;

import org.example.schoolmanagement.Api.ApiResponse;
import org.example.schoolmanagement.DTO.CourseDTO;
import org.example.schoolmanagement.Service.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllCourses() {

        return ResponseEntity.status(200).body(
                courseService.getAllCourses()
        );
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(
            @Valid @RequestBody CourseDTO courseDTO) {

        courseService.addCourse(courseDTO);

        return ResponseEntity.status(200).body(
                new ApiResponse("Course added successfully")
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(
            @PathVariable Integer id,
            @Valid @RequestBody CourseDTO courseDTO) {

        courseService.updateCourse(id, courseDTO);

        return ResponseEntity.status(200).body(
                new ApiResponse("Course updated successfully")
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {

        courseService.deleteCourse(id);

        return ResponseEntity.status(200).body(
                new ApiResponse("Course deleted successfully")
        );
    }

    @GetMapping("/get/{course_id}/teacher-name")
    public ResponseEntity<?> getTeacherName(
            @PathVariable Integer course_id) {

        return ResponseEntity.status(200).body(
                courseService.getTeacherNameByCourseId(course_id)
        );
    }
}