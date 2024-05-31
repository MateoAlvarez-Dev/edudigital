package com.riwi.edudigital.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonResponse {
    
    private int id;

    private String title;

    private String content;

    private CourseResponse course;

}