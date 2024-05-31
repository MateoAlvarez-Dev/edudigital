package com.riwi.edudigital.api.dto.response;

import java.util.List;

import com.riwi.edudigital.domain.entities.Enrollment;
import com.riwi.edudigital.domain.entities.Lesson;
import com.riwi.edudigital.domain.entities.Message;
import com.riwi.edudigital.domain.entities.User;

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

    private User instructor_id;

    private List<Enrollment> enrollments;

    private List<Lesson> lessons;

    private List<Message> messages;
    
}
