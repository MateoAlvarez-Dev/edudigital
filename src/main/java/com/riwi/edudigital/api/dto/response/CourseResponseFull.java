package com.riwi.edudigital.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseFull {

    private int id;

    private String name;

    private String description;

    private UserResponse instructor_id;

    private List<EnrollmentResponse> enrollments;

    private List<LessonResponse> lessons;

    private List<MessagesResponse> messages;
    
}
