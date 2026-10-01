package org.example.schoolmanagement.Service;

import lombok.AllArgsConstructor;
import org.example.schoolmanagement.Api.ApiException;
import org.example.schoolmanagement.DTO.StudentDTO;
import org.example.schoolmanagement.Model.Course;
import org.example.schoolmanagement.Model.Student;
import org.example.schoolmanagement.Repository.CourseRepository;
import org.example.schoolmanagement.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    public void addStudent(StudentDTO studentDTO) {

        Student student = new Student();

        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setMajor(studentDTO.getMajor());

        studentRepository.save(student);
    }

    public void updateStudent(Integer id, StudentDTO studentDTO) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            throw new ApiException("Student not found");
        }

        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setMajor(studentDTO.getMajor());

        studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            throw new ApiException("Student not found");
        }

        studentRepository.delete(student);
    }

    public void changeMajor(Integer id, String major) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            throw new ApiException("Student not found");
        }

        student.setMajor(major);

        if (student.getCourses() != null) {
            student.getCourses().clear();
        }

        studentRepository.save(student);
    }

    public void addCourseToStudent(Integer student_id, Integer course_id) {

        Student student = studentRepository.findById(student_id).orElse(null);

        if (student == null) {
            throw new ApiException("Student not found");
        }

        Course course = courseRepository.findById(course_id).orElse(null);

        if (course == null) {
            throw new ApiException("Course not found");
        }

        student.getCourses().add(course);

        studentRepository.save(student);
    }
}