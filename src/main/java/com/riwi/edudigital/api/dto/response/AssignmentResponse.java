package com.riwi.edudigital.api.dto.response;

import java.util.Date;

import com.riwi.edudigital.domain.entities.Lesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentResponse {
    
    private int id;

    private String title;

    private Date due_date;

    private String content;

    private Lesson lesson;

}
