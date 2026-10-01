package org.example.schoolmanagement.Service;

import org.example.schoolmanagement.Api.ApiException;
import org.example.schoolmanagement.DTO.AddressDTO;
import org.example.schoolmanagement.Model.Address;
import org.example.schoolmanagement.Model.Teacher;
import org.example.schoolmanagement.Repository.AddressRepository;
import org.example.schoolmanagement.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public void addTeacherAddress(Integer teacherId, AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ApiException("Teacher not found"));

        if (addressRepository.existsByTeacherId(teacherId)) {
            throw new ApiException("Teacher already has an address");
        }

        Address address = new Address();
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        address.setTeacher(teacher);

        addressRepository.save(address);
    }

    public void updateTeacherAddress(Integer teacherId, AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ApiException("Teacher not found"));

        if (teacher.getAddress() == null) {
            throw new ApiException("Teacher does not have an address");
        }

        Address address = teacher.getAddress();
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());

        addressRepository.save(address);
    }

    public void deleteTeacherAddress(Integer teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ApiException("Teacher not found"));

        if (teacher.getAddress() == null) {
            throw new ApiException("Teacher does not have an address");
        }

        Address address = teacher.getAddress();
        teacher.setAddress(null);
        teacherRepository.save(teacher);
        addressRepository.delete(address);
    }
}
