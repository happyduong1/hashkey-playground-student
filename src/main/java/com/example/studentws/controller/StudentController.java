package com.example.studentws.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.example.studentws.entity.Student;
import com.example.studentws.repository.StudentRepo;
import org.springframework.web.bind.annotation.*;

import com.example.studentws.dto.StudentDto;
import com.example.studentws.dto.request.StudentCreationRequest;
import com.example.studentws.service.StudentService;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;
    private final StudentRepo studentRepo;

    public StudentController(StudentService studentService, StudentRepo studentRepo) {
        this.studentService = studentService;
        this.studentRepo = studentRepo;
    }

    @PostMapping
    public StudentDto createStudent(@Valid @RequestBody StudentCreationRequest request) {
        return studentService.createStudent(request);
    }

    @PutMapping("/{id}")
    public StudentDto updateStudent(@NotBlank @PathVariable long id,
                                    @Valid @RequestBody StudentCreationRequest request) {
        return studentService.updateStudent(id, request);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id);
    }
    @GetMapping("/all")
    public Iterable<Student> getAllStudent() {
        return studentRepo.findAll();
    }

}
