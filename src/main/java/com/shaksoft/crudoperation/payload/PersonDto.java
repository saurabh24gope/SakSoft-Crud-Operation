package com.shaksoft.crudoperation.payload;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private Long Id;
    private String firstName;

    private String lastName;

    private String email;

    private Integer age;
}
