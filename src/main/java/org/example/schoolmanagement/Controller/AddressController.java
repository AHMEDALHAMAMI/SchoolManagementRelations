package org.example.schoolmanagement.Controller;

import org.example.schoolmanagement.Api.ApiResponse;
import org.example.schoolmanagement.DTO.AddressDTO;
import org.example.schoolmanagement.Service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/add/{teacher_id}")
    public ResponseEntity<?> addTeacherAddress(
            @PathVariable Integer teacher_id,
            @Valid @RequestBody AddressDTO addressDTO) {

        addressService.addTeacherAddress(teacher_id, addressDTO);

        return ResponseEntity.status(200).body(
                new ApiResponse("Teacher address added successfully")
        );
    }

    @PutMapping("/update/{teacher_id}")
    public ResponseEntity<?> updateTeacherAddress(
            @PathVariable Integer teacher_id,
            @Valid @RequestBody AddressDTO addressDTO) {

        addressService.updateTeacherAddress(teacher_id, addressDTO);

        return ResponseEntity.status(200).body(
                new ApiResponse("Teacher address updated successfully")
        );
    }

    @DeleteMapping("/delete/{teacher_id}")
    public ResponseEntity<?> deleteTeacherAddress(
            @PathVariable Integer teacher_id) {

        addressService.deleteTeacherAddress(teacher_id);

        return ResponseEntity.status(200).body(
                new ApiResponse("Teacher address deleted successfully")
        );
    }
}