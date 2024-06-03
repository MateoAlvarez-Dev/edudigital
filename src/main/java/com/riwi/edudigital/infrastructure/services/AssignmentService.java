package com.riwi.edudigital.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.edudigital.api.dto.request.AssignmentRequest;
import com.riwi.edudigital.api.dto.response.AssignmentResponse;
import com.riwi.edudigital.domain.entities.Assignment;
import com.riwi.edudigital.domain.repositories.AssignmentRepository;
import com.riwi.edudigital.infrastructure.abstract_services.IAssignmentService;
import com.riwi.edudigital.util.mappers.AssignmentMapper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AssignmentService extends AssignmentMapper implements IAssignmentService{

    @Autowired
    private final AssignmentRepository assignmentRepository;

    @Override
    public Page<AssignmentResponse> getAll(int page, int size) {
        if(page < 0){
            page = 0;
        }

        PageRequest pagination = PageRequest.of(page, size);

        return this.assignmentRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public AssignmentResponse create(AssignmentRequest request) {
        Assignment assignment = this.requestToEntity(request);
        Assignment assignmentSaved = this.assignmentRepository.save(assignment);
        AssignmentResponse response = this.entityToResponse(assignmentSaved);
        return response;
    }

    @Override
    public AssignmentResponse update(Integer id, AssignmentRequest request) {
        this.findById(id);

        Assignment assignmentToUpdate = this.requestToEntity(request);

        assignmentToUpdate.setId(id);

        this.assignmentRepository.save(assignmentToUpdate);

        return this.entityToResponse(assignmentToUpdate);
    }

    @Override
    public void delete(Integer id) {
        Assignment assignmentToDelete = this.findById(id);
        this.assignmentRepository.delete(assignmentToDelete);
    }

    @Override
    public AssignmentResponse getById(Integer id) {
        return this.entityToResponse(this.findById(id));
    }

    // Utils

    public Assignment findById(Integer id){
        return this.assignmentRepository.findById(id).orElseThrow();
    }
}
