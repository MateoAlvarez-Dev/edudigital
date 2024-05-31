package com.riwi.edudigital.api.dto.response;

import java.util.List;

import com.riwi.edudigital.domain.entities.Course;
import com.riwi.edudigital.domain.entities.Enrollment;
import com.riwi.edudigital.domain.entities.Submission;
import com.riwi.edudigital.util.enums.RoleType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseFull {
    
    private int id;

    private String username;

    private String email;

    private String full_name;

    private RoleType role;

    private List<Course> courses;

    private List<Enrollment> enrollments;

    private List<Submission> submissions;

}
