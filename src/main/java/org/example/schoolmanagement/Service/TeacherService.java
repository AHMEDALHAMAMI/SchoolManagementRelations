package org.example.schoolmanagement.Service;

import lombok.AllArgsConstructor;
import org.example.schoolmanagement.Api.ApiException;
import org.example.schoolmanagement.DTO.TeacherDTO;
import org.example.schoolmanagement.Model.Teacher;
import org.example.schoolmanagement.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {

        return teacherRepository.findAll();
    }

    public void addTeacher(TeacherDTO teacherDTO) {

        if (teacherRepository.existsByEmail(teacherDTO.getEmail())) {
            throw new ApiException("Email already exists");
        }

        Teacher teacher = new Teacher();

        teacher.setName(teacherDTO.getName());
        teacher.setAge(teacherDTO.getAge());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setSalary(teacherDTO.getSalary());

        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, TeacherDTO teacherDTO) {

        Teacher teacher = teacherRepository.findById(id).orElse(null);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        if (!teacher.getEmail().equals(teacherDTO.getEmail())
                && teacherRepository.existsByEmail(teacherDTO.getEmail())) {
            throw new ApiException("Email already exists");
        }

        teacher.setName(teacherDTO.getName());
        teacher.setAge(teacherDTO.getAge());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setSalary(teacherDTO.getSalary());

        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer id) {

        Teacher teacher = teacherRepository.findById(id).orElse(null);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        teacherRepository.delete(teacher);
    }

    public Teacher getTeacherDetails(Integer id) {

        Teacher teacher = teacherRepository.findById(id).orElse(null);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        return teacher;
    }
}