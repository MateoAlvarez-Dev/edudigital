package com.riwi.edudigital.api.dto.response;

import java.util.Date;
import java.util.List;

import com.riwi.edudigital.domain.entities.Lesson;
import com.riwi.edudigital.domain.entities.Submission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentResponseFull {
    
    private int id;

    private String title;

    private Date due_date;

    private String content;

    private Lesson lesson;

    private List<Submission> submissions;

}
