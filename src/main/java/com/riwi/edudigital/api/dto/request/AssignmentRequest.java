package com.riwi.edudigital.api.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentRequest {

    private int id;

    @NotBlank(message = "The title is required")
    private String title;

    @NotBlank(message = "The due date is required")
    private Date due_date;

    @NotBlank(message = "The content is required")
    private String content;

    @NotBlank(message = "The lession id is required")
    private int lession_id;

}
