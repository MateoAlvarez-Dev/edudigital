package com.riwi.edudigital.api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequest {

    @NotNull(message = "The student id is required")
    private int student_id;

    @NotNull(message = "The course id is required")
    private int course_id;

}
