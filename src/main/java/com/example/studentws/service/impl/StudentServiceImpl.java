package com.example.studentws.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.studentws.dto.StudentDto;
import com.example.studentws.dto.UniversityDto;
import com.example.studentws.dto.request.StudentCreationRequest;
import com.example.studentws.entity.Student;
import com.example.studentws.gateway.UniversityClient;
import com.example.studentws.repository.StudentRepo;
import com.example.studentws.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepository;
    private final UniversityClient universityClient;

    public StudentServiceImpl(StudentRepo studentRepository, UniversityClient universityClient) {
        this.studentRepository = studentRepository;
        this.universityClient = universityClient;
    }

    @Override
    @Transactional
    public StudentDto createStudent(StudentCreationRequest request) {
        UniversityDto universityDto = universityClient.getUniversityById(request.getUniversityId());
        if (Objects.isNull(universityDto)) {
            return null;
        }

        Student student = new Student();
        StudentDto studentDto = new StudentDto();

        populateStudent(student, request);
        studentRepository.save(student);

        BeanUtils.copyProperties(student, studentDto);
        studentDto.setUniversity(universityDto);
        return studentDto;
    }

    @Override
    public StudentDto updateStudent(long id, StudentCreationRequest request) {
        Student student = findStudentById(id);
        StudentDto studentDto = new StudentDto();
        UniversityDto universityDto = universityClient.getUniversityById(request.getUniversityId());
        if (Objects.isNull(universityDto)) {
            return null;
        }

        populateStudent(student, request);
        studentRepository.save(student);
        BeanUtils.copyProperties(student, studentDto);
        studentDto.setUniversity(universityDto);
        return studentDto;
    }

    @Override
    public boolean deleteStudent(long id) {
        studentRepository.deleteById(id);
        return true;
    }

    @Override
    public StudentDto getStudentById(long id) {
        Student student = findStudentById(id);
        if (Objects.isNull(student)) {
            return null;
        }
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student, studentDto);
        UniversityDto universityDto = universityClient.getUniversityById(student.getUniversityId());
        studentDto.setUniversity(universityDto);
        return studentDto;
    }

    private Student findStudentById(long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    private void populateStudent(Student student, StudentCreationRequest request) {
        student.setAge(request.getAge());
        student.setName(request.getName());
        student.setRole(request.getRole());
        student.setStatus(request.getStatus());
        student.setVerify(request.getVerify());
        student.setUniversityId(request.getUniversityId());
    }
}
