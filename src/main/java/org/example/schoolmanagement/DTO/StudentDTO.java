package org.example.schoolmanagement.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @NotBlank(message = "Student name is required")
    private String name;

    @NotNull(message = "Student age is required")
    @Min(value = 1, message = "Student age must be greater than 0")
    private Integer age;

    @NotBlank(message = "Student major is required")
    private String major;
}