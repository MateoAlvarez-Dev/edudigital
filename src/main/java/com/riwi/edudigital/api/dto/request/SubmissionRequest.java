package com.riwi.edudigital.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionRequest {
    
    @NotBlank(message = "You need to provide a content")
    private String content;

    @NotNull(message = "You need to provide a grade")
    private Double grade;

    @NotNull(message = "You need to provide a user id")
    private int user_id;

    @NotNull(message = "You need to provide a assignment id")
    private int assignment_id;

}
