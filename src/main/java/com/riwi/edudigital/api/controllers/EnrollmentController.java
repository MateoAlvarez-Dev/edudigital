package com.riwi.edudigital.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.riwi.edudigital.api.dto.request.EnrollmentRequest;
import com.riwi.edudigital.api.dto.response.EnrollmentResponse;
import com.riwi.edudigital.infrastructure.abstract_services.IEnrollmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/enrollments")
@AllArgsConstructor
public class EnrollmentController {

    @Autowired
    private final IEnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<Page<EnrollmentResponse>> getAll(@RequestParam(defaultValue = "1") int page, 
                                                           @RequestParam(defaultValue = "10") int size) {
        page = page - 1;
        return ResponseEntity.ok(enrollmentService.getAll(page, size));
    }

    @PostMapping
    public ResponseEntity<EnrollmentResponse> create(@RequestBody EnrollmentRequest request) {
        return ResponseEntity.ok(enrollmentService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentResponse> update(@PathVariable Integer id, 
                                                     @RequestBody EnrollmentRequest request) {
        return ResponseEntity.ok(enrollmentService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        enrollmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(enrollmentService.getById(id));
    }
}