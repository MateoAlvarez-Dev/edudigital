package com.riwi.edudigital.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.edudigital.api.dto.request.AssignmentRequest;
import com.riwi.edudigital.api.dto.response.AssignmentResponse;
import com.riwi.edudigital.infrastructure.abstract_services.IAssignmentService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping(path = "/assignments")
@AllArgsConstructor
public class AssignmentController {
    
    @Autowired
    private final IAssignmentService assignmentService;

    @GetMapping("/{id}")
    public ResponseEntity<AssignmentResponse> getMethodName(@PathVariable int id) {
        return ResponseEntity.ok(this.assignmentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<AssignmentResponse> postMethodName(@Validated @RequestBody AssignmentRequest assignment) {
        return ResponseEntity.ok(this.assignmentService.create(assignment));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AssignmentResponse> putMethodName(@PathVariable int id, @Validated @RequestBody AssignmentRequest assignment) {
        return ResponseEntity.ok(this.assignmentService.update(id, assignment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable int id){
        this.assignmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    
}
