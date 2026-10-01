package org.example.schoolmanagement.Service;

import lombok.AllArgsConstructor;
import org.example.schoolmanagement.Api.ApiException;
import org.example.schoolmanagement.DTO.AddressDTO;
import org.example.schoolmanagement.Model.Address;
import org.example.schoolmanagement.Model.Teacher;
import org.example.schoolmanagement.Repository.AddressRepository;
import org.example.schoolmanagement.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public void addTeacherAddress(Integer teacher_id, AddressDTO addressDTO) {

        Teacher teacher = teacherRepository.findById(teacher_id).orElse(null);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        if (teacher.getAddress() != null) {
            throw new ApiException("Teacher already has an address");
        }

        Address address = new Address();

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        address.setTeacher(teacher);

        addressRepository.save(address);
    }

    public void updateTeacherAddress(Integer teacher_id, AddressDTO addressDTO) {

        Teacher teacher = teacherRepository.findById(teacher_id).orElse(null);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        Address address = teacher.getAddress();

        if (address == null) {
            throw new ApiException("Teacher address not found");
        }

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());

        addressRepository.save(address);
    }

    public void deleteTeacherAddress(Integer teacher_id) {

        Teacher teacher = teacherRepository.findById(teacher_id).orElse(null);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        Address address = teacher.getAddress();

        if (address == null) {
            throw new ApiException("Teacher address not found");
        }

        addressRepository.delete(address);
    }
}