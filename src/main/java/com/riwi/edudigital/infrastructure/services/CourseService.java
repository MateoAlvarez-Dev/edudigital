package com.riwi.edudigital.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.edudigital.api.dto.request.CourseRequest;
import com.riwi.edudigital.api.dto.response.CourseResponse;
import com.riwi.edudigital.domain.entities.Course;
import com.riwi.edudigital.domain.entities.User;
import com.riwi.edudigital.domain.repositories.CourseRepository;
import com.riwi.edudigital.infrastructure.abstract_services.ICourseService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CourseService implements ICourseService{

    @Autowired
    private final CourseRepository courseRepository;

    private final UserService userService;

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

    private Course findById(Integer id){
        return this.courseRepository.findById(id).orElseThrow();
    }

    private CourseResponse entityToResponse(Course course){
        CourseResponse response = CourseResponse.builder()
                                  .id(course.getId())
                                  .name(course.getName())
                                  .description(course.getDescription())
                                  .instructor(userService.entityToResponse(course.getInstructor_id()))
                                  .build();
                                  
        return response;
    }
    
    private Course requestToEntity(CourseRequest request){
        User instructor = User.builder().id(request.getInstructor_id()).build();

        Course course = Course.builder()
                      .name(request.getName())
                      .description(request.getDescription())
                      .instructor_id(instructor)
                      .build();

        return course;
    }

}
