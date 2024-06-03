package com.riwi.edudigital.util.mappers;

import com.riwi.edudigital.api.dto.request.AssignmentRequest;
import com.riwi.edudigital.api.dto.response.AssignmentResponse;
import com.riwi.edudigital.domain.entities.Assignment;
import com.riwi.edudigital.domain.entities.Lesson;

public class AssignmentMapper {
    public AssignmentResponse entityToResponse(Assignment assignment){
        AssignmentResponse response = AssignmentResponse.builder()
                                      .id(assignment.getId())
                                      .title(assignment.getTitle())
                                      .due_date(assignment.getDue_date())
                                      .content(assignment.getContent())
                                      .build();
                                  
        return response;
    }
    
    public Assignment requestToEntity(AssignmentRequest request){
        Lesson lesson = Lesson.builder()
                                .id(request.getLession_id())
                                .build();

        Assignment assignment = Assignment.builder()
                      .title(request.getTitle())
                      .due_date(request.getDue_date())
                      .content(request.getContent())
                      .lesson_id(lesson)
                      .build();

        return assignment;
    }
}
