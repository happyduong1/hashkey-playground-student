package com.example.studentws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Setter;

@Entity
@Table(name = "STUDENT")
@Setter
public class Student {
    private long id;
    private String name;
    private int age;
    private String role;
    private String verify;
    private Boolean status;
    private long universityId;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "AGE")
    public int getAge() {
        return age;
    }

    @Column(name = "UNI_ID")
    public long getUniversityId() {
        return universityId;
    }

    @Column(name = "ROLE")
    public String getRole() {
        return role;
    }

    @Column(name = "VERIFY")
    public String getVerify() {
        return verify;
    }

    @Column(name = "STATUS")
    public Boolean getStatus() {
        return status;
    }
}
