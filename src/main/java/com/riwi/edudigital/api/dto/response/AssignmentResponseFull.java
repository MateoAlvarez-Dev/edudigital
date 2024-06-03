package com.riwi.edudigital.api.dto.response;

import java.util.Date;
import java.util.List;

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

    private LessonResponse lesson;

    private List<SubmissionResponse> submissions;

}
