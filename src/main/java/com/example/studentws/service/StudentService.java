package com.example.studentws.service;

import com.example.studentws.dto.StudentDto;
import com.example.studentws.dto.request.StudentCreationRequest;

public interface StudentService {
    StudentDto createStudent(StudentCreationRequest request);
    StudentDto updateStudent(long id, StudentCreationRequest request);

    boolean deleteStudent(long id);

    StudentDto getStudentById(long id);
}
