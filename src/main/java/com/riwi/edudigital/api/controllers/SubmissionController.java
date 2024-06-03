package com.riwi.edudigital.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.riwi.edudigital.api.dto.request.SubmissionRequest;
import com.riwi.edudigital.api.dto.response.SubmissionResponse;
import com.riwi.edudigital.infrastructure.abstract_services.ISubmissionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/submissions")
@AllArgsConstructor
public class SubmissionController {

    @Autowired
    private final ISubmissionService submissionService;

    @GetMapping
    public ResponseEntity<Page<SubmissionResponse>> getAll(@RequestParam(defaultValue = "0") int page, 
                                                           @RequestParam(defaultValue = "10") int size) {
        page = page - 1;
        return ResponseEntity.ok(submissionService.getAll(page, size));
    }

    @PostMapping
    public ResponseEntity<SubmissionResponse> create(@RequestBody SubmissionRequest request) {
        return ResponseEntity.ok(submissionService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubmissionResponse> update(@PathVariable Integer id, 
                                                     @RequestBody SubmissionRequest request) {
        return ResponseEntity.ok(submissionService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        submissionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubmissionResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(submissionService.getById(id));
    }
}