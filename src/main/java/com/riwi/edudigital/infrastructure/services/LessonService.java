package com.riwi.edudigital.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.edudigital.api.dto.request.LessonRequest;
import com.riwi.edudigital.api.dto.response.CourseResponse;
import com.riwi.edudigital.api.dto.response.LessonResponse;
import com.riwi.edudigital.domain.entities.Course;
import com.riwi.edudigital.domain.entities.Lesson;
import com.riwi.edudigital.domain.repositories.LessonRepository;
import com.riwi.edudigital.infrastructure.abstract_services.ILessonService;
import com.riwi.edudigital.util.mappers.CourseMapper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class LessonService extends CourseMapper implements ILessonService {
    
    @Autowired
    private final LessonRepository lessonRepository;

    @Autowired
    private final CourseService courseService;

    @Override
    public Page<LessonResponse> getAll(int page, int size) {
        if(page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.lessonRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public LessonResponse create(LessonRequest request) {
        Lesson lessonToSave = this.requestToEntity(request);
        Lesson lessonSaved = this.lessonRepository.save(lessonToSave);
        LessonResponse response = this.entityToResponse(lessonSaved);
        return response;
    }

    @Override
    public LessonResponse update(Integer id, LessonRequest request) {
        this.findById(id);

        Lesson lessonToUpdate = this.requestToEntity(request);

        lessonToUpdate.setId(id);

        this.lessonRepository.save(lessonToUpdate);

        return this.entityToResponse(lessonToUpdate);
    }

    @Override
    public void delete(Integer id) {
        Lesson lessonToDelete = this.findById(id);

        this.lessonRepository.delete(lessonToDelete);
    }

    @Override
    public LessonResponse getById(Integer id) {
        return this.entityToResponse(this.findById(id));
    }



    // Utils

    private Lesson findById(Integer id){
        return this.lessonRepository.findById(id).orElseThrow();
    }

    private LessonResponse entityToResponse(Lesson lesson){
        CourseResponse course = this.entityToResponse(lesson.getCourse_id());
        LessonResponse response = LessonResponse.builder()
                                  .id(lesson.getId())
                                  .title(lesson.getTitle())
                                  .content(lesson.getContent())
                                  .course(course)
                                  .build();
                                  
        return response;
    }
    
    private Lesson requestToEntity(LessonRequest request){
        Course course = courseService.findById(request.getCourse_id());

        Lesson lesson = Lesson.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .course_id(course)
                        .build();

        return lesson;
    }

    

}
