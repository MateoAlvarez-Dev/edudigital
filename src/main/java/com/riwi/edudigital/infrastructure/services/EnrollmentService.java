package com.riwi.edudigital.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.edudigital.api.dto.request.EnrollmentRequest;
import com.riwi.edudigital.api.dto.response.EnrollmentResponse;

import com.riwi.edudigital.domain.entities.Enrollment;

import com.riwi.edudigital.domain.repositories.EnrollmentRepository;
import com.riwi.edudigital.infrastructure.abstract_services.IEnrollmentService;
import com.riwi.edudigital.util.mappers.EnrollmentMapper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class EnrollmentService extends EnrollmentMapper implements IEnrollmentService{

    @Autowired
    private final EnrollmentRepository enrollmentRepository;

    @Override
    public Page<EnrollmentResponse> getAll(int page, int size) {
        if(page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.enrollmentRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public EnrollmentResponse create(EnrollmentRequest request) {
        Enrollment enrollmentToSave = this.requestToEntity(request);
        Enrollment enrollmentSaved = this.enrollmentRepository.save(enrollmentToSave);
        EnrollmentResponse response = this.entityToResponse(enrollmentSaved);
        return response;
    }

    @Override
    public EnrollmentResponse update(Integer id, EnrollmentRequest request) {
        this.findById(id);

        Enrollment enrollmentToUpdate = this.requestToEntity(request);

        enrollmentToUpdate.setId(id);

        this.enrollmentRepository.save(enrollmentToUpdate);

        return this.entityToResponse(enrollmentToUpdate);
    }

    @Override
    public void delete(Integer id) {
        Enrollment enrollmentToDelete = this.findById(id);

        this.enrollmentRepository.delete(enrollmentToDelete);
    }

    @Override
    public EnrollmentResponse getById(Integer id) {
        return this.entityToResponse(this.findById(id));
    }
    
    // Utils

    public Enrollment findById(Integer id){
        return this.enrollmentRepository.findById(id).orElseThrow();
    }

}