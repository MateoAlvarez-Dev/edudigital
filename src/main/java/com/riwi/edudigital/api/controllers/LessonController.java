package com.riwi.edudigital.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.edudigital.api.dto.request.LessonRequest;
import com.riwi.edudigital.api.dto.response.LessonResponse;
import com.riwi.edudigital.infrastructure.abstract_services.ILessonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/lessons")
@AllArgsConstructor
public class LessonController {
    @Autowired
    private final ILessonService lessonService;

    @GetMapping
    public ResponseEntity<Page<LessonResponse>> getAll(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "size", defaultValue = "10") int size) {
        page = page - 1;
        return ResponseEntity.ok(this.lessonService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonResponse> getById(@PathVariable int id) {
        return ResponseEntity.ok(this.lessonService.getById(id));
    }

    @PostMapping
    public ResponseEntity<LessonResponse> create(@Validated @RequestBody LessonRequest request){
        return ResponseEntity.ok(this.lessonService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonResponse> update(@PathVariable int id, @Validated @RequestBody LessonRequest request) {
        return ResponseEntity.ok(this.lessonService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        this.lessonService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
