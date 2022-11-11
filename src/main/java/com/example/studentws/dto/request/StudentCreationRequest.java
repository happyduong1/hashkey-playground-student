package com.example.studentws.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class StudentCreationRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String role;

    @NotNull(message = "Status is mandatory")
    private Boolean status;

    @NotBlank(message = "Verify is mandatory")
    private String verify;

    @Min(value = 0, message = "Age invalid")
    private int age;

    private long universityId;
}
