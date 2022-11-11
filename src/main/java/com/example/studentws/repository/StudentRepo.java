package com.example.studentws.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.studentws.entity.Student;

public interface StudentRepo extends CrudRepository<Student, Long> {
}
