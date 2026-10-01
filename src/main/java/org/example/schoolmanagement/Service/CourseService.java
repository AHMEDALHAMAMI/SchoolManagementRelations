package org.example.schoolmanagement.Service;

import lombok.AllArgsConstructor;
import org.example.schoolmanagement.Api.ApiException;
import org.example.schoolmanagement.DTO.CourseDTO;
import org.example.schoolmanagement.Model.Course;
import org.example.schoolmanagement.Repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {

        return courseRepository.findAll();
    }

    public void addCourse(CourseDTO courseDTO) {

        Course course = new Course();

        course.setName(courseDTO.getName());

        courseRepository.save(course);
    }

    public void updateCourse(Integer id, CourseDTO courseDTO) {

        Course course = courseRepository.findById(id).orElse(null);

        if (course == null) {
            throw new ApiException("Course not found");
        }

        course.setName(courseDTO.getName());

        courseRepository.save(course);
    }

    public void deleteCourse(Integer id) {

        Course course = courseRepository.findById(id).orElse(null);

        if (course == null) {
            throw new ApiException("Course not found");
        }

        courseRepository.delete(course);
    }

    public String getTeacherNameByCourseId(Integer course_id) {

        Course course = courseRepository.findById(course_id).orElse(null);

        if (course == null) {
            throw new ApiException("Course not found");
        }

        if (course.getTeacher() == null) {
            throw new ApiException("Teacher not assigned to this course");
        }

        return course.getTeacher().getName();
    }
}