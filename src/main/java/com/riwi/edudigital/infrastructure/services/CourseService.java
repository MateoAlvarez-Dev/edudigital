package com.riwi.edudigital.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.edudigital.api.dto.request.CourseRequest;
import com.riwi.edudigital.api.dto.response.CourseResponse;
import com.riwi.edudigital.domain.entities.Course;
import com.riwi.edudigital.domain.repositories.CourseRepository;
import com.riwi.edudigital.infrastructure.abstract_services.ICourseService;
import com.riwi.edudigital.util.mappers.CourseMapper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CourseService extends CourseMapper implements ICourseService{

    @Autowired
    private final CourseRepository courseRepository;

    @Override
    public Page<CourseResponse> getAll(int page, int size) {
        if(page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.courseRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public CourseResponse create(CourseRequest request) {
        Course courseToSave = this.requestToEntity(request);
        Course courseSaved = this.courseRepository.save(courseToSave);
        CourseResponse response = this.entityToResponse(courseSaved);
        return response;
    }

    @Override
    public CourseResponse update(Integer id, CourseRequest request) {
        this.findById(id);

        Course courseToUpdate = this.requestToEntity(request);

        courseToUpdate.setId(id);

        this.courseRepository.save(courseToUpdate);

        return this.entityToResponse(courseToUpdate);
    }

    @Override
    public void delete(Integer id) {
        Course courseToDelete = this.findById(id);

        this.courseRepository.delete(courseToDelete);
    }

    @Override
    public CourseResponse getById(Integer id) {
        return this.entityToResponse(this.findById(id));
    }
    
    // Utils

    public Course findById(Integer id){
        return this.courseRepository.findById(id).orElseThrow();
    }

}
