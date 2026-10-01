package org.example.schoolmanagement.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {

    @NotBlank(message = "Teacher name is required")
    private String name;

    @NotNull(message = "Teacher age is required")
    @Min(value = 1, message = "Teacher age must be greater than 0")
    private Integer age;

    @NotBlank(message = "Teacher email is required")
    @Email(message = "Teacher email must be valid")
    private String email;

    @NotNull(message = "Teacher salary is required")
    @Min(value = 0, message = "Teacher salary must be greater than or equal to 0")
    private Double salary;
}