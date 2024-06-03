package com.riwi.edudigital.util.mappers;

import com.riwi.edudigital.api.dto.request.EnrollmentRequest;
import com.riwi.edudigital.api.dto.response.EnrollmentResponse;
import com.riwi.edudigital.domain.entities.Course;
import com.riwi.edudigital.domain.entities.Enrollment;
import com.riwi.edudigital.domain.entities.User;

public class EnrollmentMapper {

    private UserMapper userMapper;
    private CourseMapper courseMapper;

    public EnrollmentResponse entityToResponse(Enrollment enrollment){
        EnrollmentResponse response = EnrollmentResponse.builder()
                                  .id(enrollment.getId())  
                                  .student(this.userMapper.entityToResponse(enrollment.getStudent_id()))
                                  .course(this.courseMapper.entityToResponse(enrollment.getCourse_id()))
                                  .build();
                                  
        return response;
    }
    
    public Enrollment requestToEntity(EnrollmentRequest request){
        User student = User.builder().id(request.getStudent_id()).build();
        Course course = Course.builder().id(request.getCourse_id()).build();

        Enrollment enrollment = Enrollment.builder()
                      .student_id(student)
                      .course_id(course)
                      .build();

        return enrollment;
    }
}
