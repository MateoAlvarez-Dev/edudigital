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

import com.riwi.edudigital.api.dto.request.CourseRequest;
import com.riwi.edudigital.api.dto.response.CourseResponse;
import com.riwi.edudigital.api.dto.response.LessonsInCourse;
import com.riwi.edudigital.infrastructure.abstract_services.ICourseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/courses")
@AllArgsConstructor
public class CourseController {
    @Autowired
    private final ICourseService courseService;

    @GetMapping
    public ResponseEntity<Page<CourseResponse>> getAll(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "size", defaultValue = "10") int size) {
        page = page - 1;
        return ResponseEntity.ok(this.courseService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getById(@PathVariable int id) {
        return ResponseEntity.ok(this.courseService.getById(id));
    }

    @GetMapping("/{id}/lessons")
    public ResponseEntity<LessonsInCourse> getAllLessons(@PathVariable int id) {
        return ResponseEntity.ok(this.courseService.getLessonsOfCourse(id));
    }

    @PostMapping
    public ResponseEntity<CourseResponse> create(@Validated @RequestBody CourseRequest request){
        return ResponseEntity.ok(this.courseService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponse> update(@PathVariable int id, @Validated @RequestBody CourseRequest request) {
        return ResponseEntity.ok(this.courseService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        this.courseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
