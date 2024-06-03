package com.riwi.edudigital.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.edudigital.api.dto.request.SubmissionRequest;
import com.riwi.edudigital.api.dto.response.SubmissionResponse;
import com.riwi.edudigital.domain.entities.Assignment;
import com.riwi.edudigital.domain.entities.Submission;
import com.riwi.edudigital.domain.entities.User;
import com.riwi.edudigital.domain.repositories.SubmissionRepository;
import com.riwi.edudigital.infrastructure.abstract_services.ISubmissionService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class SubmissionService implements ISubmissionService{

    @Autowired
    private final SubmissionRepository submissionRepository;

    @Override
    public Page<SubmissionResponse> getAll(int page, int size) {
        if(page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.submissionRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public SubmissionResponse create(SubmissionRequest request) {
        Submission submissionToSave = this.requestToEntity(request);
        Submission submissionSaved = this.submissionRepository.save(submissionToSave);
        SubmissionResponse response = this.entityToResponse(submissionSaved);
        return response;
    }

    @Override
    public SubmissionResponse update(Integer id, SubmissionRequest request) {
        this.findById(id);

        Submission submissionToUpdate = this.requestToEntity(request);

        submissionToUpdate.setId(id);

        this.submissionRepository.save(submissionToUpdate);

        return this.entityToResponse(submissionToUpdate);
    }

    @Override
    public void delete(Integer id) {
        Submission submissionToDelete = this.findById(id);

        this.submissionRepository.delete(submissionToDelete);
    }

    @Override
    public SubmissionResponse getById(Integer id) {
        return this.entityToResponse(this.findById(id));
    }
    
    // Utils

    public Submission findById(Integer id){
        return this.submissionRepository.findById(id).orElseThrow();
    }

    public SubmissionResponse entityToResponse(Submission submission){
        SubmissionResponse response = SubmissionResponse.builder()
                                  .id(submission.getId())
                                  .content(submission.getContent())
                                  .grade(submission.getGrade())
                                  .user(submission.getUser_id())
                                  .assignment(submission.getAssignment_id())
                                  .build();
                                  
        return response;
    }
    
    private Submission requestToEntity(SubmissionRequest submission){
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