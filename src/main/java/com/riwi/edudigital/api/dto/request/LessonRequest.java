package com.riwi.edudigital.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequest {
    
    private int id;

    @Size(min = 3, max = 50, message = "Please insert a title with at least 4 characters, max is 50")
    @NotBlank(message = "The title is required")
    private String title;

    @Size(min = 1, message = "Please insert a content")
    @NotBlank(message = "The content is required")
    private String content;

    @NotNull(message = "The course id is required")
    private int course_id;

}
