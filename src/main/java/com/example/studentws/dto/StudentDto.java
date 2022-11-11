package com.example.studentws.dto;

import lombok.Data;

@Data
public class StudentDto {
    private long id;
    private String name;
    private String role;
    private boolean status;
    private String verify;
    private int age;
    private UniversityDto university;
}
