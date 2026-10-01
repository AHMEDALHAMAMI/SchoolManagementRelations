package org.example.schoolmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String area;

    private String street;

    private Integer buildingNumber;

    @OneToOne
    @JoinColumn(name = "teacher_id", unique = true)
    @JsonIgnore
    private Teacher teacher;
}