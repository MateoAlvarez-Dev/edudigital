package com.riwi.edudigital.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    private int id;

    @NotBlank(message = "The name is required")
    private String name;

    @NotBlank(message = "The description is required")
    private String description;

    @NotBlank(message = "The intructor id is required")
    private int instructor_id;
    
}
