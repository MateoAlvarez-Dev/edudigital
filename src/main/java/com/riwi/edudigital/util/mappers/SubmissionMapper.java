package com.riwi.edudigital.util.mappers;

import com.riwi.edudigital.api.dto.request.SubmissionRequest;
import com.riwi.edudigital.api.dto.response.SubmissionResponse;
import com.riwi.edudigital.domain.entities.Assignment;
import com.riwi.edudigital.domain.entities.Submission;
import com.riwi.edudigital.domain.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionMapper {

    private UserMapper userMapper;
    private AssignmentMapper assignmentMapper;

    public SubmissionResponse entityToResponse(Submission submission){
        SubmissionResponse response = SubmissionResponse.builder()
                                  .id(submission.getId())
                                  .content(submission.getContent())
                                  .grade(submission.getGrade())
                                  .user(this.userMapper.entityToResponse(submission.getUser_id()))
                                  .assignment(this.assignmentMapper.entityToResponse(submission.getAssignment_id()))
                                  .build();
                                  
        return response;
    }
    
    public Submission requestToEntity(SubmissionRequest submission){
        User student = User.builder().id(submission.getUser_id()).build();
        Assignment assignment = Assignment.builder().id(submission.getAssignment_id()).build();

        Submission submissionEntity = Submission.builder()
                        .content(submission.getContent())
                        .grade(submission.getGrade())
                        .user_id(student)
                        .assignment_id(assignment)
                        .build();

        return submissionEntity;
    }
}
