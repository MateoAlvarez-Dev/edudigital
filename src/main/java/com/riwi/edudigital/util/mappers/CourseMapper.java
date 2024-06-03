package com.riwi.edudigital.util.mappers;

import com.riwi.edudigital.api.dto.request.CourseRequest;
import com.riwi.edudigital.api.dto.response.CourseResponse;
import com.riwi.edudigital.domain.entities.Course;
import com.riwi.edudigital.domain.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseMapper {

    private UserMapper userMapper;

    public CourseResponse entityToResponse(Course course){

        CourseResponse response = CourseResponse.builder()
                                  .id(course.getId())
                                  .name(course.getName())
                                  .description(course.getDescription())
                                  .instructor(this.userMapper.entityToResponse(course.getInstructor_id()))
                                  .build();
                                  
        return response;
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
