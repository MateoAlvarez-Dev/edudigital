package com.riwi.edudigital.api.dto.response;

import java.util.Date;

import com.riwi.edudigital.domain.entities.Course;
import com.riwi.edudigital.domain.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResponse {

    private int id;

    private Date date;

    private User student;

    private Course course;

}