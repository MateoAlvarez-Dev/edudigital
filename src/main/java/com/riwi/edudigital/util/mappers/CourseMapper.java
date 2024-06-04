package com.riwi.edudigital.util.mappers;

import java.util.ArrayList;
import java.util.List;

import com.riwi.edudigital.api.dto.request.CourseRequest;
import com.riwi.edudigital.api.dto.response.CourseResponse;
import com.riwi.edudigital.api.dto.response.LessonResponseNoCourse;
import com.riwi.edudigital.api.dto.response.LessonsInCourse;
import com.riwi.edudigital.domain.entities.Course;
import com.riwi.edudigital.domain.entities.Lesson;
import com.riwi.edudigital.domain.entities.User;

public class CourseMapper {

    public CourseResponse entityToResponse(Course course){
        UserMapper userMapper = new UserMapper();
        CourseResponse response = CourseResponse.builder()
                                  .id(course.getId())
                                  .name(course.getName())
                                  .description(course.getDescription())
                                  .instructor(userMapper.entityToResponse(course.getInstructor_id()))
                                  .build();
                                  
        return response;
    }

    public LessonsInCourse courseToLessons(Course course){
        LessonsInCourse lessons = LessonsInCourse.builder()
                                  .lessons(this.lessonsToLessonResponseNoCourses(course.getLessons()))
                                  .build();
        return lessons;
    }

    public List<LessonResponseNoCourse> lessonsToLessonResponseNoCourses(List<Lesson> lessons){
        List<LessonResponseNoCourse> newLessons = new ArrayList<>();

        for(Lesson lesson : lessons){
            LessonResponseNoCourse lessonResponse = LessonResponseNoCourse.builder()
                                                    .id(lesson.getId())
                                                    .title(lesson.getTitle())
                                                    .content(lesson.getContent())
                                                    .build();
            newLessons.add(lessonResponse);
        }

        return newLessons;
    }
    
    public Course requestToEntity(CourseRequest request){
        User instructor = User.builder().id(request.getInstructor_id()).build();

        Course course = Course.builder()
                      .name(request.getName())
                      .description(request.getDescription())
                      .instructor_id(instructor)
                      .build();

        return course;
    }
    
}
