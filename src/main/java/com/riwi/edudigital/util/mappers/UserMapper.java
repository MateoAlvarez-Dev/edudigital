package com.riwi.edudigital.util.mappers;

import java.util.ArrayList;
import java.util.List;

import com.riwi.edudigital.api.dto.request.UserRequest;
import com.riwi.edudigital.api.dto.response.CourseResponse;
import com.riwi.edudigital.api.dto.response.EnrollmentResponse;
import com.riwi.edudigital.api.dto.response.SubmissionResponse;
import com.riwi.edudigital.api.dto.response.UserResponse;
import com.riwi.edudigital.api.dto.response.UserResponseFull;
import com.riwi.edudigital.domain.entities.Course;
import com.riwi.edudigital.domain.entities.Enrollment;
import com.riwi.edudigital.domain.entities.Submission;
import com.riwi.edudigital.domain.entities.User;


public class UserMapper {

    public UserResponse entityToResponse(User user){
        UserResponse response = UserResponse.builder()
                                .id(user.getId())
                                .username(user.getUsername())
                                .email(user.getEmail())
                                .full_name(user.getFull_name())
                                .role(user.getRole())
                                .build();
        return response;
    }

    public UserResponseFull entityToResponseFull(User user){
        UserResponseFull response = UserResponseFull.builder()
                                .id(user.getId())
                                .username(user.getUsername())
                                .email(user.getEmail())
                                .full_name(user.getFull_name())
                                .role(user.getRole())
                                .courses(this.coursesToCourseResponses(user.getCourses()))
                                .enrollments(this.enrollmentsToEnrollmentResponses(user.getEnrollments()))
                                .submissions(this.submissionsToSubmissionResponses(user.getSubmissions()))
                                .build();
        return response;
    }

    public List<CourseResponse> coursesToCourseResponses(List<Course> courses){
        CourseMapper courseMapper = new CourseMapper();
        List<CourseResponse> courseResponses = new ArrayList<>();
        for(Course course : courses){
            courseResponses.add(courseMapper.entityToResponse(course));
        }
        return courseResponses;
    }
    
    public List<EnrollmentResponse> enrollmentsToEnrollmentResponses(List<Enrollment> enrollments){
        EnrollmentMapper enrollmentMapper = new EnrollmentMapper();
        List<EnrollmentResponse> enrollmentResponses = new ArrayList<>();
        for(Enrollment enrollment : enrollments){
            enrollmentResponses.add(enrollmentMapper.entityToResponse(enrollment));
        }
        return enrollmentResponses;
    }

    public List<SubmissionResponse> submissionsToSubmissionResponses(List<Submission> submissions){
        SubmissionMapper submissionMapper = new SubmissionMapper();
        List<SubmissionResponse> submissionResponses = new ArrayList<>();
        for(Submission submission : submissions){
            submissionResponses.add(submissionMapper.entityToResponse(submission));
        }
        return submissionResponses;
    }
    
    public User requestToEntity(UserRequest request){
        User user = User.builder()
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .email(request.getEmail())
                    .full_name(request.getFull_name())
                    .role(request.getRole())
                    .build();
        return user;
    }
}
